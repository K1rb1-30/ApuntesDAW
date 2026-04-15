## Comandes Linux - Gestió d’usuaris

Si pensem en línia de comandes tenim dos maneres de treballar:

- Mitjançant els programes useradd, userdel, usermode, etc…​
    
- Modificant directament els fitxers locals on s’emmagatzemen els usuaris, passwords i grups. (No recomanat)
    

|   |   |
|---|---|
||Cal tenir en compte que en molts entorns existiran usuaris i grups no locals que no es podran gestionar amb les eines aquí presentades. Per exemple en el cas d’usuaris LDAP o de sistemes amb gran quantitat d’usuaris on s’ha optat per emmagatzemar-los en una base de dades relacional enlloc de en un fitxer de text.|

### [](#user-content-etcpasswd)/etc/passwd

La base de dades local d’usuaris a Linux (i en molts Unix) és _/etc/passwd_.

```
josep@odin:~$ tail /etc/passwd
avahi:x:112:117:Avahi mDNS daemon,,,:/var/run/avahi-daemon:/bin/false
saned:x:113:118::/var/lib/saned:/bin/false
josep:x:1000:1000:josep,,,:/home/josep:/bin/bash
vboxadd:x:999:1::/var/run/vboxadd:/bin/false
pepe:x:1001:1001::/home/pepe:
testuser:x:1002:1002::/home/testuser:
testuser2:x:1003:1003::/home/testuser2:
joe:x:1004:1004:Joe Smith:/home/joe:/etc/bash
joan:x:1005:1005:Joan,,,:/home/joan:/bin/bash
maria:x:1006:1006::/home/maria:
```

Per entendre l’estructura del fitxer anterior:

```
josep@odin:~$ man 5 passwd
```

### [](#user-content-getent)getent

Tot i que es pot llegir i processar el contingut dels fitxers _/etc/passwd_, _/etc/shadow_ i _/etc/group_ com si fossin fitxers de text hi ha un parell de problemes:

- Part de la base de dades d’usuaris pot estar emmagatzemada en una base de dades relacional o en un servidor LDAP i per tant els fitxers anterior no contindran tota la informació.
    
- Utilitzar grep per consultar els fitxers anterior és poc pràctic.
    

La comanda _getent_ permet obtenir les entrades de determinats fitxers de text, anomenats bases de dades. La comanda mostra tota la informació, incloent-hi la que s’ha adquirit des de origens de xarxa com ara informació LDAP.

Les bases de dades que es poden consultar són: **_ahosts_**, **_ahostsv4_**, **_ahostsv6_**, **_aliases_**, **_ethers_** (Adreces ethernet), **_group_**, **_gshadow_**, **_hosts_**, **_netgroup_**, **_networks_**, **_passwd_**, **_protocols_**, **_rpc_**, **_services_**, i **_shadow_**.

#### [](#user-content-getent-passwd)getent passwd

Mostrarà una cosa similar a _/etc/passwd_ independentment d’on estigui emmagatzemada la informació.

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

### [](#user-content-root)root

L’usuari _root_ o superusuari és el compte d’usuari amb més permisos del sistema. Sempre té un id d’usuari de 0.

[source, bash]

josep@odin:~$ head -1 /etc/passwd
root:x:0:0:root:/root:/bin/bash

### [](#user-content-useradd)useradd

Es poden afegir usuaris amb la comanda _useradd_.

Per exemple, creem un usuari _zeus_ amb el seu directori home **_-m_**, posant explícitament el nom del seu directori home **_-d_**, donant una descripció a l’usuari **_-c_** i establint que la seva shell serà _/bin/bash_ **_-s_**.

```
josep@odin:~$ sudo useradd -m -d /home/olimp -c "Zeus déu de l'olimp" -s /bin/bash zeus
```

comprovem el que hem fet:

```
josep@odin:~$ tail -1 /etc/passwd
zeus:x:1007:1007:Zeus deu de l'olimp:/home/olimp:/bin/bash
```

### [](#user-content-etcdefaultuseradd)/etc/default/useradd

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

### [](#user-content-userdel)userdel

Podem eliminar un usuari amb _userdel_. La opció **_-r_** de userdel elimina també el directori home.

```
josep@odin:~$ ls /home
joan  joe  josep  maria  olimp  testuser2
josep@odin:~$ sudo userdel -r zeus
userdel: zeus mail spool (/var/mail/zeus) not found
josep@odin:~$ ls /home
joan  joe  josep  maria  testuser2
```

|   |   |
|---|---|
||A vegades ens interessar veure si queden més fitxers propietat de l’usuari, per fer-ho podem:<br><br>find / -uid <UID> -delete|

### [](#user-content-usermod)usermod

Podem modificar les propietats d’un usuari amb _usermod_.

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

### [](#user-content-etcskel)/etc/skel/

Quan es crea un usuari amb la opció _-m_, el contingut del directori _/etc/skel_ es còpia al nou directori home creat.

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

### [](#user-content-login-shell)login shell

El fitxer _/etc/passwd_ especifica la shell de login per l’usuari.

```
josep@odin:~$ tail /etc/passwd
josep:x:1000:1000:josep,,,:/home/josep:/bin/bash
vboxadd:x:999:1::/var/run/vboxadd:/bin/false
pepe:x:1001:1001::/home/pepe:
joe:x:1004:1004:Joe Smith:/home/muntanyes:/etc/bash
joan:x:1005:1005:Joan,,,:/home/joan:/bin/sh
maria:x:1006:1006::/home/maria:/bin/rbash
```