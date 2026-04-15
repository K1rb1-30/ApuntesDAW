## Comandes Linux - Gestió d’usuaris - Introducció

### [](#user-content-whoami)whoami

La comanda _whoami_ indica el teu nom d’usuari.

```
josep@odin:~$ whoami
josep
```

### [](#user-content-who)who

La comanda _who_ dona informació sobre qui està "logat" en el sistema en aquell moment.

```
josep@odin:~$ who
josep    tty7         2018-10-03 09:36 (:0)
joan     tty2         2018-10-03 10:01
```

### [](#user-content-w)w

La comada _w_ mostra qui està "logat" i què està fent.

```
josep@odin:~$ w
 10:05:44 up 30 min,  2 users,  load average: 0,00, 0,01, 0,00
USER     TTY      FROM             LOGIN@   IDLE   JCPU   PCPU WHAT
josep    tty7     :0               09:36   30:01   9.11s  0.01s /bin/sh /etc/xd
joan     tty2     -                10:01    8.00s  0.11s  0.04s nano fitxer.txt
```

### [](#user-content-id)id

La comanda _id_ indica el UID, el GID primàri i la llista de grups dels que s’és membre.

```
josep@odin:~$ id
uid=1000(josep) gid=1000(josep) grupos=1000(josep),24(cdrom),25(floppy),27(sudo),29(audio),30(dip),44(video),46(plugdev),108(netdev),112(lpadmin),116(scanner),998(docker),999(vboxsf)
```

```
josep@odin:~$ id joan
uid=1005(joan) gid=1005(joan) grupos=1005(joan)
```

### [](#user-content-su-a-un-altre-usuari)su a un altre usuari

La comada _su_ permet a un usuari executar una shell com un altre usuari.

```
josep@odin:~$ su joan
Contraseña:
joan@odin:/home/josep$
```

### [](#user-content-su-a-root)su a root

Podem ser root executant su sense paràmetres.

|   |   |
|---|---|
||No tots els sistemes ho permeten d’entrada.|

```
josep@odin:~$ su
Contraseña:
root@odin:/home/josep#
```

### [](#user-content-su-com-a-root)su com a root

Cal conèixer el password de l’usuari que es vol substituir a no ser que siguem root, en aquest cas podem fer su per qualsevol usuari sense conèixer la seva contrasenya.

```
root@odin:/home/josep# id
uid=0(root) gid=0(root) grupos=0(root)
root@odin:/home/josep# su - joan
```

### [](#user-content-su-nomusuari)su - $nomusuari

Per defecte, la comada _su_ manté la configuració de la shell de que l’executa. Si volem ser un altre usuari junt amb tot el seu entorn cal posar un guió abans del nom d’usuari.

```
ot@odin:~# su josep
josep@odin:/root$ exit
exit
root@odin:~# su - josep
josep@odin:~$ pwd
/home/josep
josep@odin:~$
```