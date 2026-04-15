## Comandes Linux - Eines bàsiques

### [](#user-content-find)find

La comanda _find_ pot ser molt útil al principi d’una "pipe" per buscar fitxers.

|   |   |
|---|---|
||És interessant posar `2>/dev/null` al final de la comanda per evitar la sortida dels misatges d’error.|

Trobar tots els fitxers a _/etc_ i posar el resultat a etc.txt

```
josep@hades:~$ find /etc > etc.txt
```

```
josep@hades:~$ find /etc > etc.txt 2> /dev/null
```

Trobar tots els fitxers que acaben en .conf de tot el disc

```
josep@hades:~$ find / -name "*.conf"
```

Trobar tots els fitxers, només fitxers, que acaben en .conf al directori actual

```
josep@hades:~$ find . -type f -name "*.conf"
```

Trobar els directoris del sistema que es diguin _tmp_.

```
josep@hades:~$ find / -type d -name "tmp" 2> /dev/null
```

Busca fitxers més recents que fitxer.txt

```
josep@hades:~$ find / -newer fitxer.txt
```

La comanda _find_ pot executar una altra comanda per a cada fitxer que troba. El següent exemple còpia tots els fitxers *.tmp de /var a /backup:

```
josep@odin:~$ find /var -name "*.tmp" -exec cp {} /backup \;
```

### [](#user-content-locate)locate

L’eina _locate_ utilitza un index per localitzar fitxers, és molt més ràpida que la comanda _find_ però possiblement l’index no estarà actualitzat.

Per actualitzar l’index cal cridar la comanda _updatedb_.

```
josep@odin:~$ locate samba
/usr/lib/x86_64-linux-gnu/libsamba-credentials.so.0
/usr/lib/x86_64-linux-gnu/libsamba-credentials.so.0.0.1
/usr/lib/x86_64-linux-gnu/libsamba-errors.so.1
/usr/lib/x86_64-linux-gnu/libsamba-hostconfig.so.0
...
```

### [](#user-content-time)time

La comanda _time_ pot mostrar el tems que triga en executar-se una comanda.

Indica el temps d’execució, el tems gastat en mode ususari i el temps gastat en mode kernel.

```
josep@odin:~$ time sleep 5

real	0m5,212s
user	0m0,000s
sys	0m0,000s
```