## Comandes Linux - Permisos - Bàsics

### [](#user-content-propietat-dun-fitxer)Propietat d’un fitxer

#### [](#user-content-usuari-propietari-i-grup-propietari)Usuari propietari i grup propietari

Els usuaris i grups d’un sistema poden ser locals i gestionats als fitxers _/etc/passwd_ o _/etc/group_ o poden residir en un directori NIS (Network Information System), en un domini LDAP o en un domini Samba.

Aquests usuaris i grups podent ser propietaris de fitxers. En Linux cada fitxer té un usuari propietari i un grup propietari.

```
josep@odin:~/tmp$ ls -l
total 0
-rw-r--r-- 1 josep    josep        0 oct  4 09:41 file1
-rw-r--r-- 1 bob      fondobiquini 0 oct  4 09:41 file2
-rw-r--r-- 1 patricio fondobiquini 0 oct  4 09:41 file3
```

#### [](#user-content-llistat-dels-comptes-dusuari)Llistat dels comptes d’usuari

Podem mostrar tots els comptes d’usuari amb:

```
josep@hades:~$ cut -d: --fields=1 /etc/passwd | column

root			gnats			saned
daemon			nobody			hplip
bin			systemd-timesync	josep
sys			systemd-network		vboxadd
sync			systemd-resolve		user1
games			systemd-bus-proxy	user2
man			_apt			bob
lp			rtkit			patricio
mail			dnsmasq			arenita
news			messagebus		testuser
uucp			usbmux			alice
proxy			speech-dispatcher	carol
www-data		lightdm			dan
backup			pulse			juanjo
list			avahi			gloria
irc			colord
```

#### [](#user-content-chgrp)chgrp

Es pot canviar el grup propietari d’un fitxer amb la comanda _chgrp_.

```
josep@odin:~/tmp$ ls -l
total 0
-rw-r--r-- 1 josep    josep        0 oct  4 09:41 file1
-rw-r--r-- 1 bob      fondobiquini 0 oct  4 09:41 file2
-rw-r--r-- 1 patricio fondobiquini 0 oct  4 09:41 file3

josep@odin:~/tmp$ sudo chgrp josep file2
josep@odin:~/tmp$ ls -l
total 0
-rw-r--r-- 1 josep    josep        0 oct  4 09:41 file1
-rw-r--r-- 1 bob      josep        0 oct  4 09:41 file2
-rw-r--r-- 1 patricio fondobiquini 0 oct  4 09:41 file3
```

|   |   |
|---|---|
||La comanda chgrp permet canviar el grup d’un fitxer com un usuari normal sempre i quan qui fa el canvi és el propietari i és membre del nou grup.|

#### [](#user-content-chown)chown

L’usuari propietari d’un fitxer es pot canviar amb la comanda _chown_.

Sintaxi:

chown ⟨user name⟩[:][⟨group name⟩] ⟨file⟩ …

o bé

chown :⟨group name⟩ ⟨file⟩ …

```
josep@odin:~/tmp$ ls -l
total 0
-rw-r--r-- 1 josep    josep        0 oct  4 09:41 file1
-rw-r--r-- 1 bob      josep        0 oct  4 09:41 file2
-rw-r--r-- 1 patricio fondobiquini 0 oct  4 09:41 file3

josep@odin:~/tmp$ sudo chown patricio file1
josep@odin:~/tmp$ ls -l
total 0
-rw-r--r-- 1 patricio josep        0 oct  4 09:41 file1
-rw-r--r-- 1 bob      josep        0 oct  4 09:41 file2
-rw-r--r-- 1 patricio fondobiquini 0 oct  4 09:41 file3
```

#### [](#user-content-llistat-dels-fitxers-especials)Llistat dels fitxers especials

Quan mostrem el llistat d’un directori amb _ls -l_ apareixen deu caràcters al principi de cada fitxer.

|   |   |
|---|---|
Table 1. El primer caràcter indica el tipus de fitxer
|-|fitxer|
|d|directori|
|l|enllaç simbòlic|
|p|canonada (pipe)|
|c|dispositiu de caràcter|
|b|dispositiu de bloc|
|s|socket|

```
josep@odin:~/tmp$ ls -l /dev/console
crw------- 1 root root 5, 1 oct  4 09:33 /dev/console
josep@odin:~/tmp$ ls -l /dev/sda
brw-rw---- 1 root disk 8, 0 oct  4 09:33 /dev/sda
josep@odin:~/tmp$ ls -l /etc
total 956
-rw-r--r--  1 root root    2981 jul 19 09:06 adduser.conf
-rw-r--r--  1 root root      44 jul 19 10:15 adjtime
drwxr-xr-x  2 root root    4096 jul 27 10:03 alternatives
-rw-r--r--  1 root root     401 may 29  2017 anacrontab
drwxr-xr-x  3 root root    4096 jul 19 10:07 apache2
lrwxrwxrwx  1 root root      19 jul 19 10:15 mtab -> ../proc/self/mounts
```

### [](#user-content-permisos)Permisos

#### [](#user-content-rwx)rwx

ELs nou caràcters que segueixen el tipus de fitxer denoten els permisos en tre tríades.

|   |   |
|---|---|
Table 2. Un permís pot ser
|r|lectura|
|w|escriptura|
|x|execució|

- Fa falta el permís **r** per llistar el contingut d’un directori.
    
- Fa falta el permís **x** per entrar dins d’un directori.
    
- Fa falta el permís **w** per crear i eliminar fitxers dins d’un directori.
    

#### [](#user-content-permisos-aplicats-a-fitxers-o-a-directoris)Permisos aplicats a fitxers o a directoris

Table 3. Permisos aplicats a directoris o fitxers
|Permís|directori o fitxer|Descripció|
|---|---|---|
|r|fitxer|Permis de visualització (**cat**, etc…​)|
|directori|Permís de visualització del contingut del directori (**ls**)|
|w|fitxer|Permís de modificació del contingut.<br><br>Permís de modificació de propietari i grup (**chmod**)|
|directori|Permís de modificació del contingut de la carpeta, creació i eliminació de fitxers (**touch**, **rm**)|
|x|fitxer|Permís d’execució.|
|directori|Permís d’entrada a la carpeta (**cd**)|

#### [](#user-content-rwxrwxrwx)rwxrwxrwx

- El primer conjunt **rwx** representen el permisos atorgats al usuari propietari.
    
- El segon conjunt **rwx** representen el permisos atorgats al grup propietari.
    
- El tercer conjunt **rwx** representen el permisos atorgats als altres usuaris.
    

#### [](#user-content-chmod)chmod

Els permisos es poden modificar amb la comanda _chmod_.

Donem permisos d’execució al usuari propietari

```
josep@odin:~/tmp$ ls -l
total 0
-rw-r--r-- 1 josep josep 0 oct  4 10:21 file1
josep@odin:~/tmp$ chmod u+x file1
josep@odin:~/tmp$ ls -l
total 0
-rwxr--r-- 1 josep josep 0 oct  4 10:21 file1
```

Retirem el permís d’execució al grup propietari

```
josep@odin:~/tmp$ chmod g-r file1
josep@odin:~/tmp$ ls -l
total 0
-rwx---r-- 1 josep josep 0 oct  4 10:21 file1
```

Retirem als demés el permís de lectura

```
josep@odin:~/tmp$ chmod o-r file1
josep@odin:~/tmp$ ls -l
total 0
-rwx------ 1 josep josep 0 oct  4 10:21 file1
```

Donem el permís d’escriptura a tothom

```
josep@odin:~/tmp$ chmod a+w file1
josep@odin:~/tmp$ ls -l
total 0
-rwx-w--w- 1 josep josep 0 oct  4 10:21 file1
```

No cal escriure la a

```
josep@odin:~/tmp$ chmod +x file1
josep@odin:~/tmp$ ls -l
total 0
-rwx-wx-wx 1 josep josep 0 oct  4 10:21 file1
```

Podem donar permisos explícitament

```
josep@odin:~/tmp$ chmod u=rw file1
josep@odin:~/tmp$ ls -l
total 0
-rw--wx-wx 1 josep josep 0 oct  4 10:21 file1
```

Podem combinar les diferents maneres de donar permisos

```
josep@odin:~/tmp$ chmod u=rw,g=rw,o=r file1
josep@odin:~/tmp$ ls -l
total 0
-rw-rw-r-- 1 josep josep 0 oct  4 10:21 file1
```

Podem combinar les diferents maneres de donar permisos

```
josep@odin:~/tmp$ chmod u=rwx,ug+rw,o=r file1
josep@odin:~/tmp$ ls -l
total 0
-rwxrw-r-- 1 josep josep 0 oct  4 10:21 file1
```

#### [](#user-content-permisos-en-octal)Permisos en octal

Una altra manera d’assignar permisos és amb la notació octal.

Considerem que cada permís és un bit i per tant cada tríada són tres bits, un dígit octal es pot expressar exactament en tres bits. Per tant les tres tríades dels permisos es poden expressar en tres dígits octals.

|binari|octal|permís|
|---|---|---|
|000|0|---|
|001|1|--x|
|010|2|-w-|
|011|3|-wx|
|100|4|r--|
|101|5|r-x|
|110|6|rw-|
|111|7|rwx|

```
josep@odin:~/tmp$ chmod 777 file1
josep@odin:~/tmp$ ls -l
total 0
-rwxrwxrwx 1 josep josep 0 oct  4 10:21 file1
josep@odin:~/tmp$ chmod 664 file1
josep@odin:~/tmp$ ls -l
total 0
-rw-rw-r-- 1 josep josep 0 oct  4 10:21 file1
josep@odin:~/tmp$ chmod 750 file1
josep@odin:~/tmp$ ls -l
total 0
-rwxr-x--- 1 josep josep 0 oct  4 10:21 file1
```

#### [](#user-content-umask)umask

Quan es crea un fitxer o un directori s’estableixen per defecte una sèrie de permisos. Aquests permisos per defecte estan determinats per una màscara anomenada _umask_.

La mascara especifica els permisos que **no** es volen establir per defecte.

Podem veure els permisos per defecte amb la comanda _umask_

Permisos per defecte en un directori

```
josep@odin:~/tmp$ umask
0022
josep@odin:~/tmp$ mkdir tmp
josep@odin:~/tmp$ ls -ld tmp
drwxr-xr-x 2 josep josep 4096 oct  4 10:43 tmp
```

Permisos per defecte en un fitxer

```
josep@odin:~/tmp$ umask
0022
josep@odin:~/tmp$ touch file2
josep@odin:~/tmp$ ls -l file2
-rw-r--r-- 1 josep josep 0 oct  4 10:39 file2
```

|   |   |
|---|---|
||Fixeu-vos que el fitxer **no** és executable per defecte.<br><br>Els **fitxers** nous creats en Linux **mai** són executables per defecte independentment del valor de _umask_.<br><br>Per tant un umask 0022, **per un fitxer**, és equivalent a un umask 0033.|

Si hem de crear molts fitxers a la vegada pot ser útil modificar el valor de umask.

```
josep@odin:~$ umask
0022
josep@odin:~$ umask 0
josep@odin:~$ touch file3
josep@odin:~$ ls -l file3
-rw-r--r-- 1 josep josep 0 oct  4 10:50 file3
josep@odin:~$ mkdir tmp3
josep@odin:~$ ls -ld tmp3
drwxrwxrwx 2 josep josep 4096 oct  4 10:50 tmp3
```

|   |   |
|---|---|
||Podem modificar permanentment el valor de umask modificant el contingut del fitxer _.bashrc_|

#### [](#user-content-mkdir-m)mkdir -m

Al crear directoris es poden assignar directament els seus permisos.

```
josep@odin:~$ mkdir -m 700 tmp4
josep@odin:~$ mkdir -m 777 tmp5
josep@odin:~$ ls -ld tmp4 tmp5
drwx------ 2 josep josep 4096 oct  4 10:54 tmp4
drwxrwxrwx 2 josep josep 4096 oct  4 10:54 tmp5
```

#### [](#user-content-cp-p)cp -p

El paràmetre _-p_ de la comanda cp permet mantenir els permisos, la propietat i les marques de temps del fitxer original.

```
josep@odin:~/tmp$ ls -l
total 8
drwxrwxrwx 2 josep josep 4096 oct  4 10:58 A
drwxrwxrwx 2 josep josep 4096 oct  4 10:58 B
-rwxrwxrwx 1 josep josep    0 oct  4 10:58 file
josep@odin:~/tmp$ cp file A
josep@odin:~/tmp$ cp -p file B
josep@odin:~/tmp$ ls -l A
total 0
-rwxrwxrwx 1 josep josep 0 oct  4 11:00 file
josep@odin:~/tmp$ ls -l B
çtotal 0
-rwxrwxrwx 1 josep josep 0 oct  4 10:58 file
```