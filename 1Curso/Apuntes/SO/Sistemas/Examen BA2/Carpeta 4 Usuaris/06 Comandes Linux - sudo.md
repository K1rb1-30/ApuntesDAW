## Comandes Linux - sudo

En ambients on diversos usuaris usen un o més sistemes GNU/Linux, és necessari atorgar diferents permisos o privilegis perquè aquests puguin fer ús de comandes propies de l’usuari root.

La comanda sudo permet implementar un control d’accés altament granulat indicant quins usuaris executen quines comandes. Si un usuari normal desitja executar una comanda de de qualsevol altre usuari, sudo verifica a la seva llista de permisos i si està permesa l’execució d’aquesta comanda per a aquest usuari, i en aquest cas l’executa.

És a dir, sudo és un programa que basat en una llista de control (_/etc/sudoers_) permet o no l’execució a l’usuari que l’ha invocat sobre un determinat programa propietat d’un altre usuari, generalment root.

### [](#user-content-executar-un-programa-com-un-altre-usuari)Executar un programa com un altre usuari

El programa _sudo_ permet a un usuari executar un programa amb les credencials d’un altre usuari.

Per què això funcioni, l’administrador del sistema ha d’haver configurat el fitxer **_/etc/sudoers_**. Això pot ser útil si es volen delegar tasques administratives a un altre usuari sense la necessitat de donar-li el password de root.

L’exemple següent mostra l’usuari **josep** que no té permisos per donar d’alta un nou usuari. Amb l’ajuda de la comanda _sudo_ rep el permís per executar la comanda **useradd** sense necessitat de saber el password de **root**.

```
josep@odin:~$ useradd -m maria
-su: useradd: no se encontró la orden
josep@odin:~$ sudo useradd -m maria
[sudo] password for josep:
```

### [](#user-content-comanda-sudo)Comanda sudo

La comanda sudo és executada per un usuari normal, al que se suposa té permisos per executar certa comanda. A continuació, sudo requereix que els usuaris s’autentiquin a si mateixos a través de la seva contrasenya per permetre’ls l’execució de la comanda demanada.

```
josep@hades:~$ sudo apt-get install ipcalc
[sudo] password for josep:
```

#### [](#user-content-sudo-k)sudo -k

La opció _-k_ elimina de la cache sudo les credencials de l’usuari. A la següent execució e sudo es tornarà a demanar la contrasenya.

#### [](#user-content-sudo-l)sudo -l

La opció _-l_ mostra les comandes que pot utilitzar l’usuari amb sudo.

```
josep@hades:~$ sudo -l
Matching Defaults entries for josep on hades:
    env_reset, mail_badpass,
    secure_path=/usr/local/sbin\:/usr/local/bin\:/usr/sbin\:/usr/bin\:/sbin\:/bin

User josep may run the following commands on hades:
    (ALL : ALL) ALL
```

```
bob@hades:~$ sudo -l
[sudo] password for bob:
Sorry, user bob may not run sudo on hades.
```

#### [](#user-content-sudo-u)sudo -u

Permet executar comandes d’altres usuaris.

$ sudo -u alice comanda_de_alice

#### [](#user-content-sudo-e)sudo -e

Permet editar fitxers de text com a root.

```
josep@hades:~$ sudo -e /etc/hosts
```

Podem canviar l’editor per defecte:

```
josep@hades:~$ sudo update-alternatives --config editor
Existen 2 opciones para la alternativa editor (que provee /usr/bin/editor).

  Selección   Ruta               Prioridad  Estado
------------------------------------------------------------
* 0            /bin/nano           40        modo automático
  1            /bin/nano           40        modo manual
  2            /usr/bin/vim.tiny   15        modo manual

Pulse <Intro> para mantener el valor por omisión [*] o pulse un número de selección:
```

#### [](#user-content-sudo-v)sudo -V

Mostra les opcions establertes per defecte per sudo per tots els ususaris. Cal llançar la comanda com a root.

```
root@hades:/home/josep# sudo -V
```

### [](#user-content-auditoria-de-la-comanda-sudo)Auditoria de la comanda sudo

En Debian, tots els accessos a programes i comandes mitjançant la comanda _sudo_ queden registrats al fitxer **_var/log/auth.log_**.

```
josep@odin:~$ sudo tail /var/log/auth.log
[sudo] password for josep:
Oct  3 10:38:11 odin su[6050]: + /dev/pts/0 josep:joan
Oct  3 10:38:11 odin su[6050]: pam_unix(su:session): session opened for user joan by (uid=1000)
Oct  3 10:38:11 odin su[6050]: pam_systemd(su:session): Cannot create session: Already running in a session
Oct  3 10:41:50 odin sudo:     joan : user NOT in sudoers ; TTY=pts/0 ; PWD=/home/joan ; USER=root ; COMMAND=/usr/local/bin/tail /var/log/auth.log
Oct  3 10:41:57 odin su[6073]: Successful su for josep by joan
Oct  3 10:41:57 odin su[6073]: + /dev/pts/0 joan:josep
Oct  3 10:41:57 odin su[6073]: pam_unix(su:session): session opened for user josep by (uid=1005)
Oct  3 10:41:57 odin su[6073]: pam_systemd(su:session): Cannot create session: Already running in a session
Oct  3 10:42:12 odin sudo:    josep : TTY=pts/0 ; PWD=/home/josep ; USER=root ; COMMAND=/usr/local/bin/tail /var/log/auth.log
Oct  3 10:42:12 odin sudo: pam_unix(sudo:session): session opened for user root by (uid=0)
```

### [](#user-content-visudo)visudo

El fitxer _/etc/sudoers_ determina quins usuaris i quines comandes es poden utilitzar amb la comanda _sudo_.

Una entrada incorrecta en aquest fitxer pot impedir l’entrada al sistema per a tots els usuaris.

El programa _visudo_ permet manipular el fitxer _/etc/sudoers/_ de forma segura, garantint que no es produeixen errors de sintaxi.

- Bloqueja l’arxiu /etc/sudoers de tal manera que ningú més el pot utilitzar, això evita que dos o més usuaris administradors modifiquin accidentalment els canvis que l’altre va realitzar.
    
- En tancar l’arxiu detectarà si hi ha errors de principalment de sintaxis evitant la gravació d’una versió corrupta de l’arxiu.
    

### [](#user-content-etcsudoers)/etc/sudoers

/etc/sudoers és l’arxiu de configuració, per defecte, de sudo. En aquest arxiu s’estableix quins usuaris poden executar quines comandes i de quina manera, generant efectivament una llista de control d’accés que pot ser tan detallada com es desitgi.

Existeixen tres elements importants per entendre com s’articula aquest fitxer:

- Àlies
    
- Opcions (Defaults)
    
- Regles d’accés
    

La única secció obligatòria és la darrera, les regles d’accés.

### [](#user-content-àlies)Àlies

Un àlies es refereix a un conjunt d’usuaris, un conjunt de comandes o un conjunt d’equips.

Les regles d’accés podran ser aplicades sobre els alies enlloc de sobre usuaris, grups o equips individuals.

Sinatxi:

tipus_àlies NOM_ÀLIES = element1, element2, element3, ... elementN

o bé

tipus_àlies NOM1 = element1, element2 : NOM2 = element1, element2

En el segon cas, separat per ":" és possible indicar més d’un àlies en una mateixa definició.

Els tipus d’àlies són quatre i són els següents:

Cmnd_Alias

Defineix àlies de comandes.

User_Alias

Defineix àlies d’usuaris normals.

Runas_Alias

Defineix àlies d’usuaris administradors o amb privilegis.

Host_Alias

Defineix àlies de hosts o equips.

El NOM_DE EL_ÀLIES pot portar lletres, nombres o guió baix ( _ ) i ha de començar amb una **lletra majúscula**, s’acostuma a usar-los sempre en majúscules.

Els elements de l’àlies varien depenent del tipus d’àlies:

#### [](#user-content-cmnd_alias)Cmnd_Alias

Defineixen una o més comandes i altres àlies de comandes que podran ser utilitzats després en àlies d’usuaris. Exemples:

Exemple 1

Cmnd_Alias WEB = /usr/sbin/apachectl, /usr/sbin/httpd, sudoedit /etc/httpd/

Indica que a qui se li apliqui l’àlies WEB podrà executar els comandos apachectl, httpd i editar tot el que estigui sota el directori /etc/httpd/.

|   |   |
|---|---|
||Per fer referència a una carpeta cal acabar la ruta amb /<br><br>Les rutes de les comandes han de ser senceres.|

Exemple 2

Cmnd_Alias APAGAR = /usr/bin/shutdown -h 23\:00

A l’usuari que se li assigni l’àlies APAGAR podrà fer ús de la comanda 'shutdown' exactament amb els paràmetres com estan indicats, és a dir apagar -h l’equip a les 23:00 hores.

|   |   |
|---|---|
||És necessari escapar el signe ':', així com els símbols ' : , = \|

Exemple 3

Cmnd_Alias NET_ADMIN = /sbin/ifconfig, /sbin/iptables, WEB

NET_ADMIN és un àlies amb les comandes de configuració d’interfícies de xarxa ifconfig i de firewall iptables, però a més li agreguem un àlies prèviament definit que és WEB, per tant a qui se li assigni aquest àlies podrà fer ús de les comandes de l’àlies WEB.

Exemple 4

Cmnd_Alias TOT_BIN = /usr/bin/, !/usr/bin/rpm

A qui se li assigni aquest àlies podrà executar totes les comandes que estiguin dins del directori /usr/bin/ menys la comanda 'rpm' situada al mateix directori.

#### [](#user-content-user_alias)User_Alias

Defineixen a un o més usuaris, grups del sistema (indicats amb %), grups de xarxa (netgroups indicats amb +) o altres àlies d’usuaris. Exemples:

Exemple 1

User_Alias MYSQL_USERS = andy, marce, juan, %mysql

Indica que a l’àlies MYSQL_USERS pertanyen els usuaris indicats individualment més els usuaris que formin part del grup 'mysql'.

Exemple 2

User_Alias ADMIN = bob, patricio

Exemple 3

User_Alias TOTS = ALL, !samuel, !david

Exemple 4

User_Alias OPERADORS = ADMIN, alejandra

#### [](#user-content-runas_alias)Runas_Alias

Funciona exactament igual que **User_Alias**, l’única diferència és que és possible usar UID amb el caràcter '#'.

Exemple 1

Runas_Alias OPERADORS = #501, alice

##### [](#user-content-host_alias)Host_Alias

Defineixen un o més equips o altres àlies de host. Els equips poden indicar-se pel seu nom (si es troba en /etc/hosts) per nom de domini, si existeix un resolver de dominis, per adreça IP, per adreça IP amb màscara de xarxa. Exemples:

Exemple 1

Host_Alias LANS = 192.168.0.0/24, 192.168.0.1/255.255.255.0

L’àlies LANS defineix tots els equips de les xarxes locals.

Exemple 2

Host_Alias WEBSERVERS = 172.16.0.21, web1 : DBSERVERS = 192.168.100.10, dataserver

Es defineixen dos àlies en la mateixa línia: WEBSERVERS i DBSERVERS amb les seves respectives llistes d’elements, el separador ':' és vàlid en qualsevol definició de tipus d’àlies.

### [](#user-content-regles-daccés)Regles d’accés

Les regles d’accés defineixen quins usuaris executen quines comandes sota quin usuari i en quins equips.

Sintaxi:

usuari host = comanda1, comanda2, ... comandaN

usuari

pot ser un usuari, un àlies d’usuari o un grup (indicat per %)

host

pot ser ALL qualsevol equip, un sol equip, un àlies d’equip, una adreça IP o una definició de xarxa IP/màscara

comandax

És qualsevol comanda indicant amb la seva ruta completa. Si s’acaba en '/' com en /etc/http/ llavors indica tots els arxius dins d’aquest directori.

Exemple 1

bob ALL = /sbin/fdisk

Usuari _bob_ en qualsevol host o equip pot utiliar iptables.

Exemple 2

ADMIN ALL = ALL

Els usuaris definits en l’àlies _ADMIN_ des de qualsevol host poden executar qualsevol comanda.

Exemple 3

%gerents dbserver = (director) /usr/facturacio, (root) /comandes/

Els usuaris que pertanyin al grup del sistema anomenat _gerents_ poden en l’equip anomenat _dbserver_ executar com si fossin l’usuari _director_ l’aplicació anomenada _facturacio_, a més com a usuaris _root_ poden executar totes les comandes de la carpeta _/comandes_.

Notem que és possible indicar sota quin usuari s’ha d’executar el permís. Per defecte és l’usuari _root_, però no sempre ha de ser així. A més la llista 'hereta' la primera definició d’usuari que s’indica entre parèntesi ( ), per això si n’hi ha més d’un cal canviar d’usuari a la seguent comanda.

El següent exemple és equivalent a l’anterior:

%gerents dbserver = /var/log/, (director) /usr/facturacion

Exemple 4

josep ALL = (ALL) ALL

S’estableix permís per a l’usuari _josep_ en qualsevol host per executar qualsevol comanda de qualsevol usuari.

Exemple 5

SUPERVISORS PRODUCCIO = OPERACIO

Una regla formada solament per àlies. Els usuaris indicats en l’àlies _SUPERVISORS_, tindran permís en els equips definits en l’àlies de host _PRODUCCIO_, d’executar les comandes definides en l’àlies de comandes _OPERACIO_.

Veiem que una vegada definida la regla, solament hem d’agregar o eliminar elements de les llistes d’àlies definits prèviament.

Exemple 6

daniel ALL = /usr/bin/passwd *, !/usr/bin/passwd root

L’usuari _daniel_ des de qualsevol equip, té permís de canviar la contrasenya de qualsevol usuari (usant la comanda _passwd_), excepte '!' la contrasenya de l’usuari _root_.

|   |   |
|---|---|
||Quan s’indica la comanda sense arguments: _/sbin/iptables_ sudo ho interpreta com 'pot usar iptables amb qualsevol dels seus arguments'.|

Exemple 7

carla ALL = "/sbin/lsmod"

Si una comanda està entre cometes dobles sudo ho interpreta com 'pot fer ús de la comanda _lsmod_ però sense arguments'. En aquest cas l’usuari _carla_ podrà veure la llista de mòduls del kernel, però solament això.