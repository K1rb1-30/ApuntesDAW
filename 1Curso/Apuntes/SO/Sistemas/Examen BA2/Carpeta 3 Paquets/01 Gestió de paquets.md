## Comandes Linux - Gestió de paquets

La majoria de distribucions tenen un sistema de gestió de paquets online amb "repositories" que contenen milers de paquets.

Això fa molt senzilla la instal·lació i la eliminació d’aplicacions, components, documentació i molt més al sistema.

### [](#user-content-terminologia)Terminologia

repositoris

Molt del software i de la documentació per les distribucions de Linux està disponible mitjançant **paquets** o **packages** en un o més **repositoris** centralitzats. Aquests paquets dins dels repositoris estan provats i són fàcils d’instal·lar (o eliminar) des d’un entorn gràfic o des de la consola.

Paquets .deb

Debian, Ubuntu, Mint i totes les distribucions derivades utilitzen paquets **.deb**. Per gestionar aquest tipus de paquets es pot utilitzar **aptitude** o **apt-get**, ambdues eines són "front ends" de l’eina **dpkg**.

Paquets .rpm

Red Hat, Fedora, CentOS, OpenSUSE, Mandriva, Red Flag i d’altres utilitzen paquets **.rpm**. Les eines per a gestionar paquets **.rpm** són **yum** i **rpm**.

Dependències

Alguns paquets necessiten d’altres paquets per funcionar correctament. Eines com **apt-get**, **aptitude** o **yum** instal·len automàticament les dependències quan es necessiten. Les eines de més baix nivell **dpkg** o **rpm** o quan es compila directament un codi font no instal·len les dependències necessàries.

Codi obert

Els repositoris contenen una molt software obert. Sovint el codi font està personalitzat per que s’integri millor amb una distribució en particular. La majoria de distribucions proporcionen aquest codi personalitzat a través d’un package dins d’un repositori.

Normalment els llocs web dels projectes individuals (samba.org, apache.org, …​) proporcionen versions no modificades del codi font.

Eines de gestió de software de tipus GUI

Existeixen eines gràfiques per a gestionar els repositoris i la instal·lació dels paquets

### [](#user-content-deb-package-management)deb package management

#### [](#user-content-fitxers-deb)fitxers deb

En general s’utilitzen les eines **aptitude**, **apt-get** o **apt** per gestionar els paquets de les distribucions derivades de Debian.

Ambdues són "front ends" de l’eina **dpkg** i són alhora "backends" d’eines gràfiques com ara **synaptic**.

[![synaptic](/joanq/m1sistemesinformatics/-/blob/main/UF2/3Paquets/images/synaptic.png)](/joanq/m1sistemesinformatics/-/blob/main/UF2/3Paquets/images/synaptic.png)

Figure 1. Eina synaptic

#### [](#user-content-dpkg-l)dpkg -l

Mostra una llista de tots els paquets instal·lats.

```
josep@odin:~$ dpkg -l | wc -l
1441
```

Exemple de com mostrar informació d’un únic paquet.

```
josep@odin:~$ dpkg -l ipcalc | tail -1  | tr -s ' '
ii ipcalc 0.41-5 all parameter calculator for IPv4 addresses
```

#### [](#user-content-dpkg-s)dpkg -S

Permet veure quin paquet ha instal·lat determinat fitxer.

```
josep@odin:~$ dpkg -S /etc/ssh/ssh_config
openssh-client: /etc/ssh/ssh_config
```

#### [](#user-content-dpkg-l-2)dpkg -L

Mostra una llista de tots els fitxers instal·lats per un determinat paquet.

```
josep@odin:~$ dpkg -L ipcalc
/.
/usr
/usr/bin
/usr/bin/ipcalc
/usr/share
/usr/share/doc
/usr/share/doc/ipcalc
/usr/share/doc/ipcalc/examples
/usr/share/doc/ipcalc/examples/ipcalc_cgi.1
/usr/share/doc/ipcalc/examples/ipcalc.gif
/usr/share/doc/ipcalc/examples/ipcalculator.png
/usr/share/doc/ipcalc/examples/ipcalc.cgi.gz
/usr/share/doc/ipcalc/README
/usr/share/doc/ipcalc/changelog.Debian.gz
/usr/share/doc/ipcalc/contributors
/usr/share/doc/ipcalc/copyright
/usr/share/doc/ipcalc/changelog.gz
/usr/share/man
/usr/share/man/man1
/usr/share/man/man1/ipcalc.1.gz
```

#### [](#user-content-dpkg-i)dpkg -i

Instal·la un paquet **sense tenir en compte les dependències**

#### [](#user-content-dpkg-r)dpkg -r

Elimina un paquet sense tenir en compte les dependències.

#### [](#user-content-dpkg-reconfigure)dpkg-reconfigure

Reconfigura un paquest que ja està instal·lat.

```
josep@odin:~$ dpkg-reconfigure keyboard-configuration
```

### [](#user-content-apt-get-aptitude-i-apt)apt-get, aptitude i apt

Debian utilitza l’eina **apt-get** per gestionar els paquets des de 1998.

Una alternativa és l’ús de l’eina **aptitude** que gestiona millor l’us de les dependències, es pot utilitzar tant en mode _ncurses_ com en mode comanda.

[![aptitude](/joanq/m1sistemesinformatics/-/blob/main/UF2/3Paquets/images/aptitude.png)](/joanq/m1sistemesinformatics/-/blob/main/UF2/3Paquets/images/aptitude.png)

Figure 2. Aplicació aptitude

Una opció més moderna és utilitzar la comanda **apt**, és una interfície més moderna de la comanda **_apt-get_**.

Les tres comandes utilitzen els mateixos fitxers de configuració i es poden utilitzar alternativament.

#### [](#user-content-apt-get-update)apt-get update

Baixa els noms, versions i una petita descripció de tots els paquets disponibles a tots els repositoris configurats al sistema.

```
josep@odin:~$ sudo apt-get update
Obj:1 http://security.debian.org/debian-security stretch/updates InRelease
Ign:2 http://ftp.es.debian.org/debian stretch InRelease
Obj:3 http://packages.microsoft.com/repos/vscode stable InRelease
Obj:4 http://ftp.es.debian.org/debian stretch-updates InRelease
Obj:5 https://download.docker.com/linux/debian stretch InRelease
Obj:6 http://ftp.es.debian.org/debian stretch Release
Leyendo lista de paquetes... Hecho
```

|   |   |
|---|---|
||És important executar **apt-get update** abans de realitzar altres operacions amb paquets.|

#### [](#user-content-apt-get-upgrade)apt-get upgrade

Permet instal·lar les actualitzacions de tot el software instal·lat actualment a la màquina de forma segura.

```
josep@odin:~$ sudo apt-get upgrade
Leyendo lista de paquetes... Hecho
Creando árbol de dependencias
Leyendo la información de estado... Hecho
Calculando la actualización... Hecho
El paquete indicado a continuación se instaló de forma automática y ya no es necesario.
  linux-image-4.9.0-6-amd64
Utilice «sudo apt autoremove» para eliminarlo.
Se actualizarán los siguientes paquetes:
  code tzdata
2 actualizados, 0 nuevos se instalarán, 0 para eliminar y 0 no actualizados.
Se necesita descargar 44,2 MB de archivos.
Se utilizarán 14,3 kB de espacio de disco adicional después de esta operación.
¿Desea continuar? [S/n]
```

#### [](#user-content-apt-get-distr-upgrade)apt-get distr-upgrade

La comanda _apt-get upgrade_ només actualitza paquets ja instal·lats, _apt-get dist-upgrade_ actualitza els paquets ja instal·lats i si cal instal·lar nous paquets per actualitzar algunes dependències ho fa.

```
josep@odin:~$ sudo apt-get dist-upgrade
Leyendo lista de paquetes... Hecho
Creando árbol de dependencias
Leyendo la información de estado... Hecho
Calculando la actualización... Hecho
El paquete indicado a continuación se instaló de forma automática y ya no es necesario.
  linux-image-4.9.0-6-amd64
Utilice «sudo apt autoremove» para eliminarlo.
0 actualizados, 0 nuevos se instalarán, 0 para eliminar y 0 no actualizados.
```

#### [](#user-content-apt-get-clean)apt-get clean

apt-get manté una còpia de tots els paquets baixats a **/var/cache/apt/archives**, apt-get clean permet eliminar aquests fitxers.

```
root@ubu1204~# ls /var/cache/apt/archives/ | head
accountsservice_0.6.15-2ubuntu9.4_i386.deb
apport_2.0.1-0ubuntu14_all.deb
apport-gtk_2.0.1-0ubuntu14_all.deb
apt_0.8.16~exp12ubuntu10.3_i386.deb
apt-transport-https_0.8.16~exp12ubuntu10.3_i386.deb
apt-utils_0.8.16~exp12ubuntu10.3_i386.deb
bind9-host_1%3a9.8.1.dfsg.P1-4ubuntu0.4_i386.deb
chromium-browser_20.0.1132.47~r144678-0ubuntu0.12.04.1_i386.deb
chromium-browser-l10n_20.0.1132.47~r144678-0ubuntu0.12.04.1_all.deb
chromium-codecs-ffmpeg_20.0.1132.47~r144678-0ubuntu0.12.04.1_i386.deb
Running apt-get clean removes all .deb files from that directory.
root@ubu1204~# apt-get clean
root@ubu1204~# ls /var/cache/apt/archives/*.deb
ls: cannot access /var/cache/apt/archives/*.deb: No such file or directory
```

#### [](#user-content-apt-get-install)apt-get install

Permet instal·lar un o més paquets a la màquina.

```
josep@odin:~$ sudo apt-get install rsync
[sudo] password for josep:
Leyendo lista de paquetes... Hecho
Creando árbol de dependencias
Leyendo la información de estado... Hecho
rsync ya está en su versión más reciente (3.1.2-1+deb9u1).
fijado rsync como instalado manualmente.
El paquete indicado a continuación se instaló de forma automática y ya no es necesario.
  linux-image-4.9.0-6-amd64
Utilice «sudo apt autoremove» para eliminarlo.
0 actualizados, 0 nuevos se instalarán, 0 para eliminar y 0 no actualizados.
```

#### [](#user-content-apt-get-remove)apt-get remove

Permet eliminar aplicacions prèviament instal·lades de l’ordinador.

```
josep@odin:~$ sudo apt-get remove rsync
Leyendo lista de paquetes... Hecho
Creando árbol de dependencias
Leyendo la información de estado... Hecho
El paquete indicado a continuación se instaló de forma automática y ya no es necesario.
  linux-image-4.9.0-6-amd64
Utilice «sudo apt autoremove» para eliminarlo.
Los siguientes paquetes se ELIMINARÁN:
  rsync
0 actualizados, 0 nuevos se instalarán, 1 para eliminar y 0 no actualizados.
Se liberarán 703 kB después de esta operación.
¿Desea continuar? [S/n]
```

|   |   |
|---|---|
||Al desinstal·lar un paquet amb **apt-get remove** no s’eliminen els fitxers de configuració.|

```
josep@odin:~$ dpkg -l rsync | tail -1 | tr -s ' '
rc rsync 3.1.2-1+deb9u1 amd64 fast, versatile, remote (and local) file-copying tool
```

#### [](#user-content-apt-get-purge)apt-get purge

Permet eliminar aplicacions prèviament instal·lades de l’ordinador junt amb els fitxers de configuració associats.

```
josep@odin:~$ sudo apt-get purge rsync
Leyendo lista de paquetes... Hecho
Creando árbol de dependencias
Leyendo la información de estado... Hecho
El paquete indicado a continuación se instaló de forma automática y ya no es necesario.
  linux-image-4.9.0-6-amd64
Utilice «sudo apt autoremove» para eliminarlo.
Los siguientes paquetes se ELIMINARÁN:
  rsync*
0 actualizados, 0 nuevos se instalarán, 1 para eliminar y 0 no actualizados.
Se utilizarán 0 B de espacio de disco adicional después de esta operación.
¿Desea continuar? [S/n]
(Leyendo la base de datos ... 142524 ficheros o directorios instalados actualmente.)
Purgando ficheros de configuración de rsync (3.1.2-1+deb9u1) ...
Procesando disparadores para systemd (232-25+deb9u4) ...
```

### [](#user-content-apt-cache)apt-cache

Permet buscar paquets a l’índex de baquets local.

#### [](#user-content-apt-cache-search)apt-cache search

No cal donar el nom exacte del paquet, busta entre els noms dels paquets i les seves descripcions curtes.

```
josep@odin:~$ apt-cache search apache2
libapache2-mod-auth-ntlm-winbind - apache2 module for NTLM authentication against Winbind
libapache2-mod-upload-progress - upload progress support for the Apache web server
apache2 - Apache HTTP Server
apache2-bin - Apache HTTP Server (modules and other binary files)
apache2-data - Apache HTTP Server (common files)
apache2-dbg - Apache debugging symbols
apache2-dev - Apache HTTP Server (development headers)
apache2-doc - Apache HTTP Server (on-site documentation)
apache2-ssl-dev - Apache HTTP Server (mod_ssl development headers)
apache2-suexec-custom - Apache HTTP Server configurable suexec program for mod_suexec
...
```

#### [](#user-content-apt-cache-pkgnames)apt-cache pkgnames

Podem buscar específicament en el nom dels paquets:

```
josep@odin:~$ apt-cache pkgnames apache2
apache2-ssl-dev
apache2-suexec-pristine
apache2-data
apache2-bin
apache2-dbg
apache2-dev
apache2-doc
apache2-suexec-custom
apache2
apache2-utils
```

#### [](#user-content-apt-cache-showpkg)apt-cache showpkg

Un cop sabem el nom exacte del paquet podem veure’n la informació i les dependències.

```
josep@odin:~$ apt-cache showpkg apache2
Package: apache2
Versions:
2.4.25-3+deb9u6 (/var/lib/apt/lists/ftp.es.debian.org_debian_dists_stretch_main_binary-amd64_Packages)
 Description Language:
                 File: /var/lib/apt/lists/ftp.es.debian.org_debian_dists_stretch_main_binary-amd64_Packages
                  MD5: d02426bc360345e5acd45367716dc35c
 Description Language: en
                 File: /var/lib/apt/lists/ftp.es.debian.org_debian_dists_stretch_main_i18n_Translation-en
                  MD5: d02426bc360345e5acd45367716dc35c

...
```

### [](#user-content-aptitude)aptitude

Alternativament a **apt-get** es pot utilitzar **aptitude**.

Sincronitzar amb els repositoris

aptitude update

Instal·lar les actualitzacions

aptitude upgrade (Debian)  
aptitude safe-upgrade (Ubuntu / Mint)

Instal·lar un paquet i totes les seves dependències

aptitude install $package

Buscar els repositoris que contenen certa cadena al seu nom o descripció

aptitude search $string

Eliminar un paquet

aptitude remove $package

eliminar un paquet i els fitxers de configuració associats

aptitude purge $package

### [](#user-content-apt)apt

_apt_ proporciona una interfície d’alt nivell, pensada per l’ús interactiu, per a la gestió dels paquets.

update

Sincronitza l’índex de paquets des de les seves fonts.

upgrade

Instal·la la versió més nova de tots els paquets instal·lats en el sistema provinents d’alguna de les fonts llistades en _/etc/apt/sources.list_. Els paquets instal·lats amb una nova versió disponible es descarreguen i actualitzen, i sota cap circumstància es desinstal·laran paquets, o s’instal·laran paquets nous. Les noves versions de programes instal·lats que no es puguin actualitzar sense canviar l’estat d’instal·lació d’altres paquets no s’instal·laran, mantenint-se la versió actual. Ha de realitzar un update abans perquè apt−get sàpiga que hi ha noves versions disponibles.

dist−upgrade

dist−upgrade, a més de realitzar les accions de upgrade, tracta intel·ligentment els canvis de dependències deguts a les noves versions de paquets. apt−get té un sistema «intel·ligent» de resolució de conflictes, i si és necessari tractarà d’actualitzar els paquets més importants a costa dels menys importants.

install

Instal·la o actualitza els paquets que segueixen a la paraula «install». Pot seleccionar una versió especifica d’un paquet posant a continuació del nom del paquet un símbol igual _=_ seguit de la versió desitjada.

remove

Es comporta de la mateixa manera que install amb la diferència que elimina els paquets en comptes d’instal·lar-los.

purge

És idèntic a remove, amb la diferència que els paquets s’eliminaran i purgaran (s’eliminarà també qualsevol fitxer de configuració).

source

Fa que apt−get descarregui els paquets font. APT examinarà els paquets disponibles per decidir què paquet font descarregarà.

check

És una eina de diagnòstic, actualitza la caché de paquets i revisa l’existència de dependències trencades.

autoremove

Desinstal·la paquets que es van instal·lar automàticament per satisfer les dependències d’algun paquet, però que ja no són necessaris.

### [](#user-content-etcapt)/etc/apt

Tant **apt-get** com **aptitude** com **apt** utilitzen els mateixos fitxers de confguració situats a **/etc/apt/**.

#### [](#user-content-apt-a-través-dun-proxy)apt a través d’un proxy

És possible configurar certs aspectes de APT agregant directives en un arxiu del directori **_/etc/apt/apt.conf.d/_**.

Si només pot accedir a la web a través d’un proxy, cal afegir una línia de l’estil:

/etc/apt/apt.conf

```
Acquire::http::proxy "http://proxy:3128";
Acquire::https::proxy "https://proxy:3128";
Acquire::ftp::proxy "ftp://proxy";
```

Si la configuració es vol fer només de manera temporal és pot executar una comanda de l’estil:

```
export http_proxy=http://proxy:3128

export https_proxy=http://proxy:3128
```

|   |   |
|---|---|
||Directoris acabats en .d<br><br>Cada vegada més s’utilitzen directoris amb el sufix .d. Cada directori representa un arxiu de configuració repartit en múltiples arxius. En aquest sentit, tots els arxius en **_/etc/apt/apt.conf.d/_** són instruccions per a la configuració de APT.<br><br>APT **els inclou en ordre alfabètic** perquè els últims puguin modificar un element de configuració definit en els primers.|

#### [](#user-content-etcaptsources-list)/etc/apt/sources.list

La llista de recursos utilitzats per apt-get i aptitude es troba al fitxer /etc/apt/sources.list.

Aquest fitxer conté una llista d’orígens http o ftp a on es poden trobar els diferents paquets per a la distribució.

```
josep@odin:~$ cat /etc/apt/sources.list

deb http://ftp.es.debian.org/debian/ stretch main
deb-src http://ftp.es.debian.org/debian/ stretch main

deb http://security.debian.org/debian-security stretch/updates main contrib
deb-src http://security.debian.org/debian-security stretch/updates main contrib

# stretch-updates, previously known as 'volatile'
deb http://ftp.es.debian.org/debian/ stretch-updates main contrib
deb [arch=amd64] https://download.docker.com/linux/debian stretch stable
# deb-src [arch=amd64] https://download.docker.com/linux/debian stretch stable
deb-src http://ftp.es.debian.org/debian/ stretch-updates main contrib
```

#### [](#user-content-treballar-amb-repositoris-de-diferents-distribucions)Treballar amb repositoris de diferents distribucions

És possible treballar amb repositoris d’altres distribucions. Per exemple, després d’instal·lar un sistema _Stable_ es podria desitjar provar paquets de programari disponible a _Testing_ o _Unstable_.

En primer lloc cladrà definir la distribució de referència amb el paràmetre **APT::Default-Release**, (**En general no cladrà fer-ho ja que per defecte serà la distribució "esperada"**).

I a continuació caldrà cridar la comanda **_apt-get_** amb la opció **_-t_** seguit del nom de la distribució des de la que volem instal·lar.

```
josep@odin:~$ sudo apt-get install -t testing apache2
```

|   |   |
|---|---|
||Evidentment caldrà afegir els nous reopositoris al fitxer **_/etc/apt/sources.list_**|

### [](#user-content-rpm)rpm

#### [](#user-content-sobre-rpm)Sobre rpm

L’aplicació rpm (Red Hat Packet Manager) es pot utilitzar des de la línia de comandes amb **rpm** o gràficament, Applications → System Settings → Add/Remove Applications.

El software distribuït en el format rpm té la nomenclatura _nom-versio.plataforma.rmp_.

#### [](#user-content-rpm-qa)rpm -qa

Mostrar una llista de tot el software instal·lat.

```
[root@RHEL52 ~]# rpm -qa | grep samba
system-config-samba-1.2.39-1.el5
samba-3.0.28-1.el5_2.1
samba-client-3.0.28-1.el5_2.1
samba-common-3.0.28-1.el5_2.1
```

#### [](#user-content-rpm-q)rpm -q

Verificar si un paquet està instal·lat.

```
root@RHELv4u4:~# rpm -q gcc
gcc-3.4.6-3
root@RHELv4u4:~# rpm -q laika
package laika is not installed
```

#### [](#user-content-rpm-uvh)rpm -Uvh

Per instal·lar o actualitzar un paquet s’utilitzen els paràmetres **-Uvh**.

El paràmetre **-U** fa el mateix que **-i** per instal·lar però elimina les versions antigues.

Els paràmetres **-vh** milloren la informació de sortida.

```
root@RHELv4u4:~# rpm -Uvh gcc-3.4.6-3
```

#### [](#user-content-rpm-e)rpm -e

Elimina un paquets instal·lat prèviament.

```
root@RHELv4u4:~# rpm -e gcc-3.4.6-3
```

|   |   |
|---|---|
||**rpm -e** verifica les dependències i per tant evita desinstal·lar accidentalment paquets utilitzats per altres paquets.|

```
[root@RHEL52 ~]# rpm -e gcc-4.1.2-42.el5
error: Failed dependencies:
gcc = 4.1.2-42.el5 is needed by (installed) gcc-c++-4.1.2-42.el5.i386
gcc = 4.1.2-42.el5 is needed by (installed) gcc-gfortran-4.1.2-42.el5.i386
gcc is needed by (installed) systemtap-0.6.2-1.el5_2.2.i386
```

#### [](#user-content-varlibrpm)/var/lib/rpm

TODO

#### [](#user-content-rpm2cpio)rpm2cpio

TODO

### [](#user-content-yum)yum

#### [](#user-content-sobre-yum)Sobre yum

La comanda yum (Yellowdog Updater) és una comanda per treballar amb paquets rpm més senzilla que no pas rpm. S’instal·la per defecte a les últimes versions de Fedora, Red Hat i CentOS.

#### [](#user-content-yum-list)yum list

TODO

#### [](#user-content-yum-search)yum search

TODO

#### [](#user-content-yum-provides)yum provides

TODO

#### [](#user-content-yum-install)yum install

TODO

#### [](#user-content-yum-update)yum update

TODO

#### [](#user-content-yum-software-groups)yum software groups

TODO

#### [](#user-content-repositoris-i-etcyum-conf)Repositoris i /etc/yum.conf

TODO

### [](#user-content-alien)alien

TODO

### [](#user-content-baixar-software-fora-dels-repositoris)Baixar software fora dels repositoris

|   |   |
|---|---|
||El primer que cal fer al baixar software és llegir el fitxer anomenat README!!.<br><br>Normalment aquest fitxer explica què fer després de baixar el programa.|

Probablement el programa baixat serà un fitxer de tipus **.tar.gz** o **.tgz**.

Un cop llegida la documentació cal posar el fitxer comprimit en un directori.

Per saber els fitxer continguts al comprimit:

```
tar -tvzpf _fitxer_.tgz
```

Per descomprimir el fitxer:

```
tar -xzf fitxer.tgz
```

descomrpimirà el fitxer en una carpeta de nom _nomaplicacio-1.2.3_

Si el fitxer acaba en **.tar.bz2** caldrà substituir la z per una j.

En cas de escarregar un fitxer **.deb** caldrà instal·lar-lo directament amb **dpkg**

Si el fitxer és un .rpm l’aplicació **rpm** és l’adequada per instal·lar-lo.

### [](#user-content-compilació-de-software)Compilació de software

En primer lloc, quan es baixa un codi font per compilar és important llegir amb calma el fitxer README.

En general els passos són els segúents:

1. Executar `./configure` per preparar la compilació en el sistema actual.
    
2. Executar `make` que executa la compilació del codi font.
    
3. Executar `make install` que instal·la el software al sistema.