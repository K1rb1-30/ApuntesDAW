## Comandes Linux - Introducció

### Alguns shortcuts

- Obrir terminal [CTRL]+[ALT]+t

- Tancar terminal [CTRL]+d

- Netejar terminal [CTRL]+l

### Definicions importants

comanda

Una comanda és una instrucció teclejada en un terminal.

shell

És un programa que interpreta les comandes.

terminal o emulador de terminal

És una finestra gràfica on s’hi poden teclejar comandes que seran enviades a un shell.

### La shell bash

Bash és un intèrpret d’ordres, usat sovint pel sistema GNU/Linux. És qui s’encarrega de comunicar l’usuari amb el sistema. No és l’únic intèrpret existent per a Linux, però si un dels més emprats.

Aquest programa, desenvolupat per GNU, és una adaptació lliure de l’intèrpret d’ordres propi d’Unix, de codi font tancat, anomenat **Bourne shell** o sh. Bash (Bourne again shell) millora la shell de Bourne en diversos aspectes, podent-lo considerar una extensió del mateix sh.

Existeixen més intèrprets d’ordres com per exemple:

- csh (C shell)
    
- ksh (Korn shell)
    

### [](#user-content-el-prompt)El prompt

S’anomena _prompt_ al conjunt de caràcters que es mostren en una línia de comandes per indicar que s’està a l’espera d’ordres. El _prompt_ és diferent en funció de la _shell_ i a més sol ser configurable.

A la shell de Bourne i els seus derivats el _prompt_ generalment conté el caràcter **$** pels usuaris sense privilegis i el caràcter **#** per l’administrador. a més sol proporcionar més informació, com ara el nom de l’usuari actiu i el nom de la màquina.

```
josep@odin:~$
```

```
root@odin:~#
```

### [](#user-content-comanda-echo)Comanda echo

La comada _echo_ s’utilitza per mostrar text per la sortida estàndard del sistema.

Essencialment s’utilitza de dues maneres:

```
josep@hades:~$ echo Hola
Hola
```

```
josep@odin:~$ MISSATGE='Hola'
josep@odin:~$ echo $MISSATGE
Hola
```

### [](#user-content-arguments)Arguments

Una de les principals ocupacions de la shell és realitzar un anàlisi de la línia de comandes.

Quan s’entra una comanda al prompt de la shell i es prem [ENTER]:

1. La shell comença a analitzar la línia entrada i la talla en arguments.
    
2. Mentre està analitzant la línia la shell pot modificar alguns dels arguments entrats, aquest procés s’anomena **shell expansion**.
    
3. Finalment s’executa a línia entrada.
    

### [](#user-content-eliminació-dels-espais-en-blanc)Eliminació dels espais en blanc

Les parts separades per un o més espais o tabulacions es consideren arguments separats.

el primer argument és la pròpia comanda a executar, els altres arguments es proporcionaran a la comanda

### [](#user-content-cometes-simples)Cometes simples

Es pot evitar l’eliminació dels espais en blanc posant cometes simples. El contingut entre les cometes es considera un sol argument.

Per exemple:

Comanda amb tres arguments

```
josep@hades:~$ echo bon dia
bon dia
```

Comanda amb dos arguments

```
josep@hades:~$ echo 'bon dia'
bon dia
```

|                                                                                                                   |     |
| ----------------------------------------------------------------------------------------------------------------- | --- |
| En aquesta situació també es podrien utilitzar cometes dobles tot i que en general no tenen el mateix significat. |     |

### Variables de la shell - set

La comanda _set_ és una comanda de la shell que s’utilitza per determinar els valors de les variables d ela shell.

En general, a la shell bash, per habilitar un valor s’utilitzarà la sintaxi:

set -_opcio_

i per deshabilitar-lo,

set +_opcio_

#### Mostrar el tractament de les comandes per la shell

Habilitar la opció **-x** de la shell permet veure quines substitucions o expansions realitza la shell prèviament a l’execució de la comanda.

Per exemple:

```
josep@odin:~/tmp$ ls
a  a.html  b.html  file  fitxer  persones  text  users.txt  user.txt
josep@odin:~/tmp$ ls f*
file  fitxer
josep@odin:~/tmp$ set -x
josep@odin:~/tmp$ ls f*
+ ls --color=auto file fitxer
file  fitxer
josep@odin:~/tmp$ set +x
+ set +x
```

```
josep@odin:~/tmp$ echo $USER
josep
josep@odin:~/tmp$ set -x
josep@odin:~/tmp$ echo $USER
+ echo josep
josep
josep@odin:~/tmp$ set +x
+ set +x
```

### [](#user-content-comandes)Comandes

#### [](#user-content-comandes-externes-o-comandes-de-la-shell)Comandes externes o comandes de la shell

No totes les comandes són externes a la shell, algunes estan integrades dins seu.

Les comandes de la shell són necessàries per implementar funcionalitats impossibles o inconvenients d’obtenir amb programes externs.

|   |   |
|---|---|
||Cal tenir en compte que si canviem la shell, les comandes de la shell poden canviar.|

#### [](#user-content-type)type

Per saber si una comanda és de la shell o no es pot utilitzar la comada _type_.

```
josep@hades:~$ type cd
cd es una orden interna del shell
josep@hades:~$ type cat
cat is /bin/cat
```

_type_ també indica si una comanda és en realitat un alias.

```
josep@hades:~$ type ls
ls es un alias de 'ls --color=auto'
```

#### [](#user-content-executar-comandes-externes)Executar comandes externes

Algunes comandes tenen versions internes i externes. QUan una d’aquestes comandes és invocada sempre pren preferència la versió interna, per executar la versió externa s’ha de fer indicant la ruta completa a la comanda.

```
josep@hades:~$ type -a echo
echo es una orden interna del shell
echo is /bin/echo
```

#### [](#user-content-which)which

La comanda _which_ buscarà els binaris a les rutes indicades per la variable d’entorn $PATH i indicarà on es troben.

```
josep@hades:~$ which cp ls cd mkdir pwd
/bin/cp
/bin/ls
/bin/mkdir
/bin/pwd
```

### [](#user-content-opcions)Opcions

Una opció és un tipus d’argument que modifica el comportament d’una comanda.

Aquestes opcions poden ser en versió llarga o en versió curta.

|   |   |
|---|---|
||Cada comanda es comporta de manera diferent, caldrà mirar la corresponent pàgina del manual per veure’n el comportament especific.|

#### [](#user-content-opcions-en-versió-curta)Opcions en versió curta

Estan definides per una sola lletra i es precedeixen del símbol **-**.

```
cal -y
cal -y 2000
date -u
```

#### [](#user-content-opcions-en-versió-llarga)Opcions en versió llarga

Es defineixen per una paraula sencera i es precedeixen dels símbols **--**.

```
date --help
date --universal
```

Si una comanda necessita més d’una opció es poden ajuntar totes en una, per exemple:

```
ls -l -a
```

és equivalent a

```
ls -la
```

### [](#user-content-paràmetres)Paràmetres

Un paràmetre és un argument que proporciona informació o bé a la comanda o bé a una d eles seves opcions.

La següent comanda té dos paràmetres:

```
cal 12 2018
```

La següent comanda té un paràmetre:

```
cat /etc/hosts
```

La següent comanda té dos opcions i un paràmetre

```
ls -la /tmp
```

La següent comanda té dos opcions i un paràmetre associat a cadascuna de les opcions.

```
cal -A 1 -B 1
```