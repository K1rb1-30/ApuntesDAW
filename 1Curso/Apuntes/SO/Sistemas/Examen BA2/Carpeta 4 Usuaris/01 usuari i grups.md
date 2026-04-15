## Gestió de comptes d’usuari i grups en Linux

### [](#user-content-comptes-dusuari)Comptes d’usuari

Linux distingeix entre usuaris diferents mitjançant **comptes d’usuari** diferents.

Les distribucions comunes típicament creen dos comptes d’usuari durant la instal·lació, un compte anomenat **root** per tasques administratives i un altre compte per un **usuari** "normal".

En Linux s’assigna un nombre únic, anomenat **UID** o _user ID_, a cada compte d’usuari a més del nom textual, no obstant el Kernel de Linux només treballa amb aquest UID.

|   |   |
|---|---|
||Les dades d’un procés i la propietat de dades en un sistema de fitxers es gestiona únicament a partir dels UID dels usuaris. Això pot portar problemes si per exemple s’elimina un usuari que encara és propietari de fitxers del sistema i el seu UID es reassigna a un usuari diferent. El nou usuari heretaria la propietat dels fitxers de l’usuari eliminat.|

|   |   |
|---|---|
||Tècnicament no hi ha problema en què dos usuaris comparteixin el mateix UID, ambdós usuaris tindrien el mateix accés als fitxers propietat del UID i cada usuari tindria el seu propi password.<br><br>No obstant, no és una bona recomanació fer-ho.|

#### [](#user-content-usuaris-i-grups)Usuaris i grups

Per treballar amb un ordinador amb Linux cal haver accedit al sistema prèviament. Això permet al sistema reconèixer-te i assignar-te els drets d’accés correctes.

Tot el que passa durant una sessió passa sota el compte d’usuari loginat. A més cada usuari té un directori **home** on només ell, llevat de root, pot emmagatzemar i gestionar els fitxers propis.

Varis usuaris **que volen compartir l’accés a determinats recursos del sistema** poden formar un **grup**. Linux identifica els membres d’un grup per un **nom** i internament per un **GID** o _group ID_. A diferència dels usuaris, els grups no tenen un directori home.

#### [](#user-content-grups-primaris)Grups primaris

Tot usuari pertany a un **_grup primari_** i possiblement a varis **_grups secondaris_**.

Des del punt de vista del control d’accés, **tots els grups tenen el mateix pes**, cada usuari gaudeix dels drets derivats de tots els grups als quals pertany. La única diferència entre el grup primari i els secundaris és que **els nous fitxers creats per l’usuari se’ls assigna automàticament el grup primari**.

|   |   |
|---|---|
||Fins a la versió 2.4 del Kernel de Linux un usuari podia pertànyer a fins a 32 grups a la vegada, a partir de la versió 2.6 del Kernel, el nombre de grups als que pot pertànyer un usuari és il·limitat.|

#### [](#user-content-comanda-id)Comanda id

Per saber el UID d’un usuari, el grup primari i els grups secundaris amb els seus GID es pot utilitzar la comanda _id_.

```
josep@odin:~$ id
uid=1000(josep) gid=1000(josep) grupos=1000(josep),24(cdrom),25(floppy),27(sudo),29(audio),30(dip),44(video),46(plugdev),108(netdev),112(lpadmin),116(scanner),998(docker),999(vboxsf)
```

#### [](#user-content-pseudo-usuaris)Pseudo-usuaris

A part dels usuaris "persona", el concepte de grup i usuari també s’utilitza per gestionar els drets d’accés a determinades parts del sistema. Això vol dir que a part dels comptes d’usuari per usuaris "reals" existeixen comptes que no corresponen a persones sinó que estan assignades a funcions administratives internes.

Un cop instal·lat Linux, es poden trobar varis pseudo-usuaris i grups als fitxers **/etc/passwd** i **/etc/group**.

En particular l’usuari **root** sempre té UID 0 i GID 0.

#### [](#user-content-fitxer-etcpasswd)Fitxer /etc/passwd

El fitxer **/etc/passwd** és la base de dades d’usuaris del sistema, conté una entrada per a cada usuari del sistema amb la següent estructura:

```
josep@odin:~$ cat /etc/passwd
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
bin:x:2:2:bin:/bin:/usr/sbin/nologin
sys:x:3:3:sys:/dev:/usr/sbin/nologin
sync:x:4:65534:sync:/bin:/bin/sync
...
```

<nom_usuari>:<password>:<UID>:<GID>:<GECOS>:<directori_home>:<shell>

<nom_usuari>

Nom consistent en lletres minúscules i dígits. El primer caràcter ha de ser una lletra.

Els sistemes Unix limiten la longitud del nom a 8 caràcters, Linux no té aquesta limitació però es una cosa a tenir en compte en xarxes heterogènies.

<password>

Tradicionalment aquest camp contenia el password encriptat. Actualment la majoria de distribucions de Linux utilitzen "shadow passwords", enlloc d’emmagatzemar el password en aquest fitxer s’emmagatzema en el fitxer extern **/etc/shadow** amb accés restringit a l’administrador. Una x en aquest camp vol dir precisament això.

<UID>

Número entre 0 i 232-1 que identifica l’usuari.

Per conveni els UID entre 0 i 99 estan reservats pel sistema, els UID del 100 al 499 estan reservats per diferents paquets de software en cas que necessitin comptes de pseudo-usuari.

A la majoria de distribucions populars els UID d’usuaris persona comencen al 500 o al 1000

<GID>

Grup primari de l’usuari.

|   |   |
|---|---|
||Les distribucions Novel/SUSE i d’altres assignen, per defecte, un grup de l’estil _users_ com a grup primari de tots els usuaris creats al sistema.<br><br>Les distribucions derivades de Debian i Red Hat assignen un grup primari nou a cada usuari creat, aquest grup primari té el mateix nom que l’usuari.|

|   |   |
|---|---|
||Tot usuari ha de ser membre d’almenys un grup.|

<GECOS>

Aquest camp conté informació diversa de l’usuari, nom real, telèfon, etc…​

|   |   |
|---|---|
||GECOS significa General Electric Comprehensive Operating System i no té res a veure amb Linux.|

<directori_home>

És el directori personal de l’usuari, on pot guardar-hi els seus fitxers.

Un directori home acabat de crear no és un directori buit, el nou usuari acostuma a rebre una serie de fitxers basats en el seu perfil.

quan un usuari fa login, la seva shell utilitza el directori home de l’usuari com el seu directori de treball.

<shell>

El nom del programa arrancat pel login després d’una autenticació am èxit, en general es tracta d’una _shell_

|   |   |
|---|---|
||L’usuari pot canviar la seva shell per defecte amb el programa **_chsh_**, la llista de shells disponibles es pot veure a **_/etc/shells_**.<br><br>Si l’usuari no ha de tenir una shell interactiva es pot posar un programa arbitrari en aquest camp, normalment **_/bin/true_**.<br><br>Si aquest camp és buit la shell que s’utilitzarà serà la shell standard **_/bin/sh_**.|

#### [](#user-content-el-fitxer-etcshadow)El fitxer /etc/shadow

Per seguretat la majoria de distribucions de Linux actuals emmagatzemen els passwords encriptats dels usuaris al fitxer **_/etc/shadow_**.

Aquest fitxer no és accessible pels usuaris normals, nomes*root* el pot modificar i només els usuaris del grup **_shadow_** el poden llegir.

```
josep@odin:~$ sudo cat /etc/shadow
[sudo] password for josep:
root:$6$X61vJ0ay$QkmMnwFEMMvHUnLNjAfO2uxr6WgxuXCfLNw29xNvcwOp2nzn5n7u4ahg82rOcbIDvWGfO1nU.ecxsQayBWYtK1:17731:0:99999:7:::
daemon:*:17731:0:99999:7:::
bin:*:17731:0:99999:7:::
sys:*:17731:0:99999:7:::
sync:*:17731:0:99999:7:::
games:*:17731:0:99999:7:::
...
```

El format del fitxer és el següent:

<nom_usuari>:<password>:<canvi>:<min>:<max>:<avís>:<gràcia>:<bloqueig>:<reservat>

<nom_usuari>: Correspon a una entrada del fitxer **_/etc/passwd_**. És el camp que vincula els dos fitxers.

<password>

conté el password encriptat de l’usuari.

Si està buit generalment indica que l’usuari pot entrar al sistema sense password.

Un * o un ! evita que l’usuari pugui fer login.

|   |   |
|---|---|
||És habitual bloquejar el compte d’un usuari sense esborrar-lo completament afegint un * o ! al principi del password corresponent.|

<canvi>

Data de l’últim canvi de password, en dies des de l'1 de gener de 1970.

<min>

El mínim nombre de dies des de l’últim canvi de password abans que es pugui tornar a canviar de nou.

<max>

Nombre de dies en que el password és vàlid.

<avís>

nombre de dies abans de l’expiració del password en que l’usuari serà avisat que ha de canviar-lo.

<gràcia>

Període de gràcia després de l’expiració del password en que l’usuari pot entrar al sistema.

<bloqueig>

Data en que el compte d’usuari serà definitivament bloquejat, en dies des del 1 de gener de 1970.

#### [](#user-content-fitxer-etcgroup)Fitxer /etc/group

Per defecte, Linux emmagatzema la informació dels grups al fitxer **_/etc/group_**, aquest fitxer conté una línia per a cada grup del sistema amb la següent estructura:

```
josep@odin:~$ cat /etc/group
root:x:0:
daemon:x:1:
bin:x:2:
...
pulse-access:x:115:
scanner:x:116:saned,josep
avahi:x:117:
saned:x:118:
josep:x:1000:
vboxsf:x:999:josep
docker:x:998:josep
```

<nom_grup>:<password>:<GID>:<membres>

<nom_grup>

Nom del grup.

<password>

Un password opcional pel grup. Això permet que usuaris que no són membres del grup via /etc/shadow o /etc/group assumeixin la membresia del grup utilitzant newgrp. (És una opció que no se sol utilitzar!!)

Un * impedeix als usuaris normals canviar el grup.

Una x fa referència a un fitxer de passwords separat, **_/etc/gshadow_**.

<GID>

Identificador numèric del grup.

<membres>

Llista separada per comes de tots els noms d’usuari pertanyents al grup. Aquesta llista conté els usuaris que tenen el grup com a grup secundari, si el tenen com a grup primari poden no aparèixer.

#### [](#user-content-fitxer-etcgshadow)Fitxer /etc/gshadow

És un fitxer definció equivalen al fitxer /etc/shadow però pels passwords de grup.

```
josep@hades:~$ sudo cat /etc/gshadow | tail -10
juanjo:!::
gloria:!::
eva:!::
direccio:!::juanjo,gloria
tecnic:!:gloria:juanjo
finances:!:gloria:juanjo,eva
pepe:!::
usuari:!::
amparo:!::
bbb:!::
```

<nom_grup>:<password_encriptat>:<administradors>:<membres>

<nom_grup>

Nom del grup.

<password>

password encriptat, una **!** significa que el password està bloquejat.

<administradors>

Llista de noms separats per comes.

Els administradors d’un grup poden modificar els passwords dels membres del grup.

Els administradors tenen els mateixos permissos que els membres del grup.

<membres>

Llista separada per comes de tots els noms d’usuari pertanyents al grup. Aquesta llista conté els usuaris que tenen el grup com a grup secundari, si el tenen com a grup primari poden no aparèixer.

### [](#user-content-comanda-getent)Comanda getent

Tot i que es pot llegir i processar el contingut dels fitxers -/etc/passwd_, _/etc/shadow- i _/etc/group_ com si fossin fitxers de text hi ha un parell de problemes:

- Part de la base de dades d’usuaris pot estar emmagatzemada en una base de dades relacional o en un servidor LDAP i per tant els fitxers anterior no contindran tota la informació.
    
- Utilitzar grep per consultar els fitxers anterior és poc pràctic.
    

La comanda _getent_ permet obtenir les entrades de determinats fitxers de text, anomenats bases de dades. La comanda mostra tota la informació, incloent-hi la que s’ha adquirit des de origens de xarxa com ara informació LDAP.

Les bases de dades que es poden consultar són: **_ahosts_**, **_ahostsv4_**, **_ahostsv6_**, **_aliases_**, **_ethers_** (Adreces ethernet), **_group_**, **_gshadow_**, **_hosts_**, **_netgroup_**, **_networks_**, **_passwd_**, **_protocols_**, **_rpc_**, **_services_**, i **_shadow_**.

#### [](#user-content-getent-passwd)getent passwd

Mostrarà una cosa similar a /etc/passwd independentment d’on estigui emmagatzemada la informació.

```
josep@odin:~$ getent passwd
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
bin:x:2:2:bin:/bin:/usr/sbin/nologin
sys:x:3:3:sys:/dev:/usr/sbin/nologin
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/usr/sbin/nologin
man:x:6:12:man:/var/cache/man:/usr/sbin/nologin
lp:x:7:7:lp:/var/spool/lpd:/usr/sbin/nologin
```

```
josep@odin:~$ getent passwd josep
josep:x:1000:1000:josep,,,:/home/josep:/bin/bash
```

```
josep@odin:~$ getent group docker
docker:x:998:josep
```

### [](#user-content-crear-comptes-dusuari)Crear comptes d’usuari

El procediment per crear comptes d’usuari és gairebé sempre el mateix i consisteix en els següents passos:

1. Cal crear entrades al fitxer _/etc/passwd_ i possiblement al fitxer _/etc/shadow_.
    
2. Si és necessari caldrà crear entrades a _/etc/group_.
    
3. Caldrà crear el directori _home_, copiar un conjunt de fitxer predefinit i transferir la propietat de tot plegat al nou usuari.
    
4. Si és necessari, caldrà entrar l’usuari a altres base de dades, quotes de disc, aplicacions especials, …​
    

tots els passos anteriors es poden fer manualment amb un editor de text o amb l’ajuda del programa **_useradd_**

#### [](#user-content-comanda-useradd)Comanda useradd

El cas més simple és utilitzar _useradd_ seguit del nom d’usuari que volem crear, veurem que no és exactament el que esperàvem:

```
josep@odin:~$ sudo useradd testuser
```

Anem a veure que hem creat:

```
josep@odin:~$ getent passwd testuser
testuser:x:1002:1002::/home/testuser:
```

En principi ha creat un usuari amb una home a _/home/testuser_.

```
josep@odin:~$ cd /home/
josep@odin:/home$ ls
josep
```

Veiem que la carpeta home de l’usuari no s’ha creat i no se li ha assignat un grup primari.

A més tampoc se li ha assignat una shell, de fet tampoc ens ha demanat password, vegem el contingut de _/etc/shadow_:

```
josep@odin:/home$ sudo cat /etc/shadow | grep testuser
testuser:!:17806:0:99999:7:::
```

Veiem que efectivament tenim bloquejat el login.

La sintaxi de la comanda és la següent:

useradd [<options>] <nom_usuari>

I les opcions:

-c comment

Informació GECOS

-d home directory

Estableix el directori home, si no s’especifica s’entén /home/nom_usuari.

-g group

Grup primari de l’usuari. El grup ha d’existir.

-G group[,group]…

Grups suplementaris de l’usuari.

-s shell

La nova shell de l’usuari

-u UID

El UID de l’usuari. No pot estar en ús.

-m

Crea el directori home de l’usuari i còpia els fitxers de la plantilla que es troba a **_/etc/skel_**

Per tant, per crear un usuari bàsic:

```
josep@odin:/home$ sudo useradd -c "Joe Smith" -m -s /bin/bash joe
```

|   |   |
|---|---|
||_useradd_ es comporta lleugerament diferent en funció de la distribució de Linux.<br><br>En particular, en Debian, es recomana el programa _adduser_ en lloc de _useradd_|

#### [](#user-content-etcdefaultuseradd)/etc/default/useradd

Tant RHEL com Debian tenen un fitxer anomenat _/etc/default/useradd_ que conté algunes opcions per defecte alhora de crear usuaris.

Podem veure el seu contingut o fer **_useradd -D_**.

```
josep@odin:~$ sudo useradd -D
GROUP=100
HOME=/home
INACTIVE=-1
EXPIRE=
SHELL=/bin/sh
SKEL=/etc/skel
CREATE_MAIL_SPOOL=no
```

|   |   |
|---|---|
||Podem modificar els valors per defecte de la creació d’usuaris amb la mateixa comanda **_useradd -D_**.|

#### [](#user-content-etcskel)/etc/skel/

Quan es crea un usuari amb la opció **_-m_**, el contingut del directori _/etc/skel_ es còpia al nou directori home creat.

_/etc/skel_ conté normalment alguns fitxers ocults amb algunes configuracions del perfil.

```
josep@odin:~$ ls -al /etc/skel
total 20
drwxr-xr-x   2 root root 4096 jul 19 09:06 .
drwxr-xr-x 112 root root 4096 oct  3 12:01 ..
-rw-r--r--   1 root root  220 may 15  2017 .bash_logout
-rw-r--r--   1 root root 3526 may 15  2017 .bashrc
-rw-r--r--   1 root root  675 may 15  2017 .profile
josep@odin:~$ sudo touch /etc/skel/readme.txt
josep@odin:~$ sudo useradd -m -s /bin/bash testuser
josep@odin:~$ ls /home/testuser
readme.txt
```

### [](#user-content-contrassenyes)Contrassenyes

#### [](#user-content-comanda-passwd)Comanda passwd

La comanda _passwd_ permet assignar un password a un usuari.

josep@odin:/home$ sudo passwd joe
Introduzca la nueva contraseña de UNIX:
Vuelva a escribir la nueva contraseña de UNIX:
passwd: contraseña actualizada correctamente

Utilitzar la comanda sense paràmetres permet canviar el password de l’usuari actual.

|   |   |
|---|---|
||Executar la comanda sota root no demana la contrasenya antiga ni té les restriccions de seguretat de contrasenyes.<br><br>Executar la comanda des del propi usuari demana la contrasenya antiga i aplica totes les restriccions de seguretat de contrasenyes.|

A més, amb aquesta comanda es poden gestionar algunes propietats del fitxer _/etc/shadow_:

#### [](#user-content-passwd-s)passwd -S

La opció **_-S_** permet veure l’estat del password:

josep@odin:~$ sudo passwd -S joe
joe P 10/02/2018 0 99999 7 -1

El format de la resposta és:

usuari seguit de l’estat del password **P** o **PS** si el password està establert, **LK** o **L** si està bloquejat i **NP** si no hi ha password.

Els demés camps fan referència a les dates d’expiració, intervals i dates de canvi de password.

A més la comanda passwd permet:

#### [](#user-content-passwd-l)passwd -l

Bloquegem el compte

josep@odin:~$ sudo passwd -l joe

#### [](#user-content-passwd-u)passwd -u

Desbloquejem el compte

josep@odin:~$ sudo passwd -u joe

#### [](#user-content-passwd-n)passwd -n

Canvi de password com a molt cada 7 dies

josep@odin:~$ sudo passwd -n 7 joe

#### [](#user-content-chage)chage

La comanda _chage_ es pot utilitzar per establir una data d’expiració d’un compte d’usuari **_-E_**, establir un mímin **_-m_** i un màxim **_-M_** de temps de vida de la contrasenya, una data d’expiració del password, etc…​

Molta de la seva funcionalitat coincideix amb la de la comanda _passwd_.

Per mostrar la configuració per un usuari fem _chage -l_.

```
josep@hades:~$ sudo chage -l bob
Último cambio de contraseña					:oct 03, 2018
La contraseña caduca					: nunca
Contraseña inactiva					: nunca
La cuenta caduca						: nunca
Número de días mínimo entre cambio de contraseña		: 0
Número de días máximo entre cambio de contraseña		: 99999
Número de días de aviso antes de que caduque la contraseña	: 7
```

#### [](#user-content-etclogin-defs)/etc/login.defs

El fitxer _/etc/login.defs_ conté alguns dels valors per defecte pels passwords dels ususaris, la longitud, la caducitat, etc…​

```
josep@hades:~$ cat /etc/login.defs | grep PASS
#	PASS_MAX_DAYS	Maximum number of days a password may be used.
#	PASS_MIN_DAYS	Minimum number of days allowed between password changes.
#	PASS_WARN_AGE	Number of days warning given before a password expires.
PASS_MAX_DAYS	99999
PASS_MIN_DAYS	0
PASS_WARN_AGE	7
#PASS_CHANGE_TRIES
#PASS_ALWAYS_WARN
#PASS_MIN_LEN
#PASS_MAX_LEN
# NO_PASSWORD_CONSOLE
```

### [](#user-content-accions-amb-els-comptes-dusuari)Accions amb els comptes d’usuari

#### [](#user-content-comanda-userdel)Comanda userdel

Eliminar un compte d’usuari consisteix en eliminar les entrades dels fitxers _/etc/passwd_ i _/etc/shadow_, eliminar totes les referències a l’usuari de _/etc/group_ i eliminar la carpeta _home_ de l’usuari amb el seu contingut i possiblement algunes carpetes o fitxers de l’usuari, per exemple la carpeta _var/mail_

|   |   |
|---|---|
||Cal tenir en compte que els fitxers propietat de l’usuari, en general no s’eliminen i quedaran orfes un cop eliminat l’usuari.|

La comada **_userdel_** permet eliminar usuaris del sistema, la sintaxi és la següent:

userdel [-r] <nom_usuari>

|   |   |
|---|---|
||El paràmetre **_-r_** garanteix l’eliminació de la carpeta home de l’usuari eliminat.|

A vegades ens interessarà veure si queden més fitxers propietat de l’usuari, per fer-ho podem:

find / -uid <UID> -delete

#### [](#user-content-comanda-usermod)Comanda usermod

Les comandes _usermod_ permet modificar els comptes d’usuari existents.

La comanda _usermod_ suporta gairebé les mateixes opcions que la comanda _useradd_ però s’executa sobre un usuari existent.

El següent exemple **assigna una nova carpeta home** a l’usuari joe **_-d_** i hi **mou el contingut de l’antiga home** **_-m_**.

```
josep@odin:~$ ls /home
joan  joe  josep  maria  testuser2
josep@odin:~$ cat /etc/passwd | grep joe
joe:x:1004:1004:Joe Smith:/home/joe:/etc/bash
josep@odin:~$ sudo usermod -m -d /home/muntanyes joe
josep@odin:~$ ls /home
joan  josep  maria  muntanyes  testuser2
josep@odin:~$ cat /etc/passwd | grep joe
joe:x:1004:1004:Joe Smith:/home/muntanyes:/etc/bash
josep@odin:~$
```

#### [](#user-content-groupadd)groupadd

Els grups es poden crear amb la comanda _groupadd_.

El següent exemple crea quatre grups buits:

```
josep@hades:~$ sudo groupadd asix
josep@hades:~$ sudo groupadd dam
josep@hades:~$ sudo groupadd daw
josep@hades:~$ sudo groupadd smix
```

#### [](#user-content-etcgroup)/etc/group

Els usuaris poden ser membres de més d’un grup. La membresia dels grups està definida al fitxer _/etc/group_.

```
josep@hades:~$ tail -4 /etc/group
asix:x:1007:
dam:x:1008:
daw:x:1009:
smix:x:1010:
```

La descripció de cada camp es pot trobar a :

```
josep@hades:~$ man 5 group
```

#### [](#user-content-groups)groups

Un usuari pot veure els grups als que pertany amb la comanda _groups_.

```
josep@hades:~$ groups
josep cdrom floppy sudo audio dip video plugdev netdev lpadmin scanner vboxsf
josep@hades:~$
```

#### [](#user-content-modificar-la-membresia-dun-grup-usermod)Modificar la membresia d’un grup usermod

Per modificar la membresia d’un grup es pot utilitzar la comanda _usermod_

```
josep@hades:~$ sudo usermod -a -G smix alice
josep@hades:~$ sudo usermod -a -G dam bob
josep@hades:~$ sudo usermod -a -G asix carol
josep@hades:~$ sudo usermod -a -G daw dan
```

|   |   |
|---|---|
||Per defecte la comanda _usermod_ treurà l’usuari de tots els grups que no estiguin llistats a la comanda.<br><br>Per prevenir-ho cal utilitzar el paràmetre **_-a_**.|

##### [](#user-content-usermod-g)usermod -g

Podem canviar el grup primàri d’un usuari amb la opció **_-g_**.

josep@odin:~$ id bob
uid=1002(bob) gid=1002(bob) grupos=1002(bob)
josep@odin:~$ sudo usermod -g fondobiquini bob
josep@odin:~$ id bob
uid=1002(bob) gid=1009(fondobiquini) grupos=1009(fondobiquini)

|   |   |
|---|---|
||Tots els fitxers del directori home que tinguin al grup antic com a propietari se’ls hi canviarà el grup propietari al nou grup.|

#### [](#user-content-groupmod)groupmod

Es pot canviar el nom del grup amb _groupmod_.

```
josep@hades:~$ sudo groupmod -n smx smix
josep@hades:~$ tail -4 /etc/group
alice:x:1011:
carol:x:1012:
dan:x:1013:
smx:x:1010:alice
```

#### [](#user-content-groupdel)groupdel

Per eliminar permanentment un grup utilitzem _groupdel_

```
josep@hades:~$ sudo groupdel smx
```

### [](#user-content-administradors-de-grups)Administradors de grups

#### [](#user-content-gpasswd)gpasswd

Es pot delegar el control de membresia d’un grup a un usuari amb la comanda _gpasswd_.

Per exemple, deleguem el permisos per afegir i eliminar membres del grup daw a bob.

```
josep@hades:~$ sudo gpasswd -A bob daw
josep@hades:~$ su - bob
bob@hades:~$ id alice
bob@hades:~$ id carol
uid=1008(carol) gid=1012(carol) grupos=1012(carol),1007(asix)
bob@hades:~$ gpasswd -a carol daw
Añadiendo al usuario carol al grupo daw
bob@hades:~$ id carol
uid=1008(carol) gid=1012(carol) grupos=1012(carol),1007(asix),1009(daw)
```

Com es pot veure els administradors d’un grup no tenen perquè pertànyer al grup.

```
bob@hades:~$ gpasswd -d bob daw
Eliminando al usuario bob del grupo daw
```

La informació sobre els grup d’administradors s’emmagatzema al fitxer _/etc/gshadow_.

```
josep@hades:~$ sudo tail -4 /etc/gshadow
daw:!:bob:dan,carol
alice:!::
carol:!::
dan:!::
```

Per eliminar tots els administradors d’un grup:

```
josep@hades:~$ sudo gpasswd -A "" daw
josep@hades:~$ sudo tail -4 /etc/gshadow
daw:!::dan,carol
alice:!::
carol:!::
dan:!::
```