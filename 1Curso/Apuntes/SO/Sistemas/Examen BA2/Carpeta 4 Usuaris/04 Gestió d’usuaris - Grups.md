## Comandes Linux - Gestió d’usuaris - Grups

### [](#user-content-groupadd)groupadd

Els grups es poden crear amb la comanda _groupadd_.

El següent exemple crea quatre grups buits:

```
josep@hades:~$ sudo groupadd asix
josep@hades:~$ sudo groupadd dam
josep@hades:~$ sudo groupadd daw
josep@hades:~$ sudo groupadd smix
```

### [](#user-content-etcgroup)/etc/group

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

### [](#user-content-groups)groups

Un usuari pot veure els grups als que pertany amb la comanda _groups_.

```
josep@hades:~$ groups
josep cdrom floppy sudo audio dip video plugdev netdev lpadmin scanner vboxsf
josep@hades:~$
```

### [](#user-content-usermod)usermod

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

#### [](#user-content-usermod-g)usermod -g

Podem canviar el grup primàri d’un usuari amb la opció **_-g_**.

josep@odin:~$ id bob
uid=1002(bob) gid=1002(bob) grupos=1002(bob)
josep@odin:~$ sudo usermod -g fondobiquini bob
josep@odin:~$ id bob
uid=1002(bob) gid=1009(fondobiquini) grupos=1009(fondobiquini)

|   |   |
|---|---|
||Tots els fitxers del directori home que tinguin al grup antic com a propietari se’ls hi canviarà el grup propietari al nou grup.|

### [](#user-content-groupmod)groupmod

Es pot canviar el nom del grup amb _groupmod_.

```
josep@hades:~$ sudo groupmod -n smx smix
josep@hades:~$ tail -4 /etc/group
alice:x:1011:
carol:x:1012:
dan:x:1013:
smx:x:1010:alice
```

### [](#user-content-groupdel)groupdel

Per eliminar permanentment un grup utilitzem _groupdel_

```
josep@hades:~$ sudo groupdel smx
```

### [](#user-content-gpasswd)gpasswd

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

### [](#user-content-newgrp)newgrp

Podem llençar una shell filla amb un grup primarti temporal amb la comanda _newgrp_.

```
josep@hades:~$ groups josep
josep : josep cdrom floppy sudo audio dip video plugdev netdev lpadmin scanner vboxsf daw
josep@hades:~$ mkdir info
josep@hades:~$ cd info
josep@hades:~/info$ touch info.txt
josep@hades:~/info$ ls -l
total 0
-rw-r--r-- 1 josep josep 0 oct  3 16:31 info.txt
josep@hades:~/info$ echo $SHLVL
1
josep@hades:~/info$ newgrp daw
josep@hades:~/info$ echo $SHLVL
2
josep@hades:~/info$ touch infodaw.txt
josep@hades:~/info$ ls -l
total 0
-rw-r--r-- 1 josep daw   0 oct  3 16:31 infodaw.txt
-rw-r--r-- 1 josep josep 0 oct  3 16:31 info.txt
josep@hades:~/info$ exit
exit
josep@hades:~/info$
```