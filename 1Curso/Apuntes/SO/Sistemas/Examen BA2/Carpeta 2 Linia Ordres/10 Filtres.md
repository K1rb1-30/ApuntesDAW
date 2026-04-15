## Comandes Linux - Filtres

Les comandes creades per a ser utilitzades junt amb una "pipe" s’anomenen filtres.
### [](#user-content-cat)cat

Quan _cat_ es troba entre dues pipes, la comanda _cat_ no fa res, simplement posa _stdin_ a _stdout_.

```
josep@odin:~/tmp$ cat file
un
dos
tres
quatre

josep@odin:~/tmp$ tac file | cat | cat | cat > file2
josep@odin:~/tmp$ cat file2
quatre
tres
dos
un
```

### [](#user-content-tee)tee

És útil si s’escriuen pipes llargues. La comanda _tee_ posat _stdin_ a _stdout_ i a un fitxers.

_tee_ és molt similar a cat però genera dues sortides idèntiques.

```
josep@odin:~/tmp$ ls -l /etc | tee etc.txt | grep .conf > etcconf.txt
```

### [](#user-content-grep)grep

La comanda _grep_ permet filtrar línies de text que contenen (o no) una determinada cadena o patró.

```
josep@odin:~/tmp$ cat vegetals
poma, fruita
patata, tubercle
pera, fruita
bleda, verdura
col, verdura
raim, fruita
nap, tubercle
```

D’entrada grep retorna línies senceres que contenen la cadena buscada.

```
josep@odin:~/tmp$ grep verdura vegetals
bleda, verdura
col, verdura
```

Podem utilitzar grep en una pipe.

```
josep@odin:~/tmp$ cat vegetals | grep verdura
bleda, verdura
col, verdura
```

#### [](#user-content-grep-i)grep -i

_grep_ té en compte les majúscules i minúscules, per evitar-ho es pot utilitzar la opció _-i_.

```
josep@odin:~/tmp$ cat vegetals | grep Verdura
```

```
josep@odin:~/tmp$ cat vegetals | grep -i Verdura
bleda, verdura
col, verdura
```

#### [](#user-content-grep-v)grep -v

La opció _-v_ retorna les línies que **no** contenen la cadena buscada.

```
josep@odin:~/tmp$ cat vegetals | grep -v verdura
poma, fruita
patata, tubercle
pera, fruita
raim, fruita
nap, tubercle
```

#### [](#user-content-grep-a-grep-b-grep-c)grep -A, grep -B, grep -C

Les opcions _-A_ i _-B_ mostren línies abans i després dels resultats,, la opció _-C_ mostra n línies abans i n després.

```
josep@odin:~/tmp$ cat vegetals | grep -A 1 -B 1 tubercle
poma, fruita
patata, tubercle
pera, fruita
--
raim, fruita
nap, tubercle
```

### [](#user-content-cut)cut

La comanda _cut_ permet seleccionar columnes de fitxers, depenen d’un delimitador o d’un recompte de bytes.

```
josep@odin:~$ cut -d: -f1,3 /etc/passwd | tail -4
testuser:1007
bob:1002
patricio:1008
alice:1009
```

Si volem utilitzar un espai com a delimitador, l’hem de posar entre cometes.

```
josep@odin:~$ ls -l /etc | cut -d' ' -f1 | tail -4
drwxr-xr-x
drwxr-xr-x
drwxr-xr-x
drwxr-xr-x
```

Podem tallar els camps contant bytes enlloc de per un separador.

```
josep@odin:~$ ls -l /etc | cut -c1-4 | tail -4
drwx
drwx
drwx
drwx
```

### [](#user-content-tr)tr

Permet canviar un conjunt de caràcters per un altre conjunt de caràcters.

```
josep@odin:~/tmp$ cat vegetals | tr 'a' 'A'
pomA, fruitA
pAtAtA, tubercle
perA, fruitA
bledA, verdurA
col, verdurA
rAim, fruitA
nAp, tubercle
```

```
josep@odin:~/tmp$ cat vegetals | tr 'aeiou' 'AEIOU'
pOmA, frUItA
pAtAtA, tUbErclE
pErA, frUItA
blEdA, vErdUrA
cOl, vErdUrA
rAIm, frUItA
nAp, tUbErclE
```

Podem especificar rangs sempre i quant siguin de la mateixa longitud.

```
josep@odin:~/tmp$ cat vegetals | tr 'a-z' 'A-Z'
POMA, FRUITA
PATATA, TUBERCLE
PERA, FRUITA
BLEDA, VERDURA
COL, VERDURA
RAIM, FRUITA
NAP, TUBERCLE
```

Recordeu que en Linux un final de línia és un caràcter.

```
josep@odin:~/tmp$ cat vegetals | tr '\n' ' '
poma, fruita patata, tubercle pera, fruita bleda, verdura col, verdura raim, fruita nap, tubercle
```

#### [](#user-content-tr-s)tr -s

La opció _-s_ permet compactar múltiples ocurrències d’un caràcter a un de sol.

```
josep@odin:~/tmp$ cat file
un    dos  tres        quatre     cinc
josep@odin:~/tmp$ cat file | tr -s ' '
un dos tres quatre cinc
```

#### [](#user-content-xifrat-del-cèsar)Xifrat del cèsar

LA comanda permet fer un xifrat del cèsar de forma fàcil.

```
josep@odin:~/tmp$ cat hola
bon dia
josep@odin:~/tmp$ cat hola | tr 'a-z' 'd-za-c' > hola2
josep@odin:~/tmp$ cat hola2
erq gld
josep@odin:~/tmp$ cat hola2 | tr 'd-za-c' 'a-z'
bon dia
```

#### [](#user-content-tr-d)tr -d

La opció _-d_ permet eliminar caràcters.

```
josep@odin:~/tmp$ cat vegetals | tr -d 'aeiou'
pm, frt
ptt, tbrcl
pr, frt
bld, vrdr
cl, vrdr
rm, frt
np, tbrcl
```

### [](#user-content-wc)wc

La comanda _wc_ permet contar paraules, caràcters o línies.

```
josep@odin:~/tmp$ wc -l vegetals
7 vegetals
josep@odin:~/tmp$ wc -w vegetals
14 vegetals
josep@odin:~/tmp$ wc -c vegetals
98 vegetals
```

### [](#user-content-nl)nl

La comanda _nl_ permet numerar les línies del que rep per lentrada estàndard.

```
josep@odin:~$ cat | nl > file
un
dos
tres
josep@odin:~$ cat file
     1	un
     2	dos
     3	tres
```

### [](#user-content-sort)sort

Per defecte ordena segons l’ordenació alfabètica tradicional.

```
josep@odin:~/tmp$ cat vegetals | sort
bleda, verdura
col, verdura
nap, tubercle
patata, tubercle
pera, fruita
poma, fruita
raim, fruita
```

#### [](#user-content-sort-k)sort -k

Permet ordenar per columnes.

```
josep@odin:~/tmp$ cat vegetals | sort -k2
pera, fruita
poma, fruita
raim, fruita
nap, tubercle
patata, tubercle
bleda, verdura
col, verdura
```

#### [](#user-content-sort-n)sort -n

Podem forçar una ordenació numèrica enlloc d’una ordenació alfabètica.

```
josep@odin:~/tmp$ cat nums | tr '\n' '\t'
10	1	100	110	1	11	10
josep@odin:~/tmp$ sort nums | tr '\n' '\t'
1	1	10	10	100	11	110
josep@odin:~/tmp$ sort -n nums | tr '\n' '\t'
1	1	10	10	11	100	110
```

### [](#user-content-uniq)uniq

El filtre _uniq_ permet eliminar duplicats d’una llista ordenada.

```
josep@odin:~/tmp$ sort -n nums | uniq
1
10
11
100
110
```

#### [](#user-content-uniq-c)uniq -c

La opció _-c_ permet contar ocurrències.

```
josep@odin:~/tmp$ sort -n nums | uniq -c
      2 1
      2 10
      1 11
      1 100
      1 110
```

### [](#user-content-comm)comm

El filtre _comm_ permet comparar streams **ordenats**. Per defecte _comm_ mostra tres columnes.

```
josep@hades:~/tmp1$ cat llista1
patates
cigrons
peres
pomes

josep@hades:~/tmp1$ cat llista2
peres
cebes
cigrons
```

La primera columna mostra els que hi ha a la primera llista i no a la segona, la segona columna, els que hi ha a la segona i no a la primera i a tercera columna els que hi ha a les dues.

```
josep@hades:~/tmp1$ comm <(sort llista2) <(sort llista1)
cebes
		        cigrons
    	patates
	        	peres
    	pomes
```

Podem eliminar les comunes que ens interessa, per exemple, només ens quedem amb la tercera.

```
josep@hades:~/tmp1$ comm -12 <(sort llista2) <(sort llista1)
cigrons
peres
```

### [](#user-content-od)od

Permet veure el contingut d’un fitxer en hexadecimal.

```
josep@odin:~/tmp$ od -x hola
0000000 6f62 206e 6964 0a61
0000010
```

En octal.

```
josep@odin:~/tmp$ od -b hola
0000000 142 157 156 040 144 151 141 012
0000010
```

En ascii.

```
josep@odin:~/tmp$ od -c hola
0000000   b   o   n       d   i   a  \n
0000010
```

### [](#user-content-sed)sed

Permet editar un flux de dades utilitzant expressions regulars, és una eina molt potent i molt complexa que queda fora de l’abast d’aquest mòdul.

```
josep@odin:~/tmp$ echo tinc 3 psicines | sed 's/3/4/'
tinc 4 psicines
```

```
josep@odin:~/tmp$ echo tinc 33 psicines | sed 's/3/4/'
tinc 43 psicines
josep@odin:~/tmp$ echo tinc 33 psicines | sed 's/3/4/g'
tinc 44 psicines
```

### [](#user-content-exemples)Exemples

#### [](#user-content-who-wc)who | wc

Quants usuaris hi ha "logats" en el sistema?

```
josep@odin:~$ who
josep    tty7         2018-10-07 16:41 (:0)
alice    tty2         2018-10-07 17:48
bob      tty3         2018-10-07 17:48
josep@odin:~$ who | wc -l
3
```

#### [](#user-content-who-cut-sort)who | cut | sort

Donar una llista d’usuaris "logats" en el sistema.

```
josep@odin:~$ who | cut -d' ' -f1 | sort
alice
bob
josep
```

### [](#user-content-xargs)xargs

La comanda _xargs_ converteix dades de la entrada estàndard _stdin_ a arguments d’una comanda.

Per exemple, la comanda echo no és capaç de prendre el seus arguments des de l’entrada estàndard:

```
josep@odin:~/tmp$ ls -l | echo
```

Podem convertir l’entrada estàndard en un argument per a la comanda echo:

```
josep@odin:~/tmp$ ls -l | xargs echo
total 4 -rw-r--r-- 1 josep josep 24 oct 13 08:53 file
```