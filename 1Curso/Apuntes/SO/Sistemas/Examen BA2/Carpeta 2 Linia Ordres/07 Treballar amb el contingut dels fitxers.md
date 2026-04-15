## Comandes Linux - Treballar amb el contingut dels fitxers

### [](#user-content-head)head

Mostra les 10 primeres línies d’un fitxer.

```
usuari@Azathoth~$ head /etc/passwd
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/bin/sh
bin:x:2:2:bin:/bin:/bin/sh
sys:x:3:3:sys:/dev:/bin/sh
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/bin/sh
man:x:6:12:man:/var/cache/man:/bin/sh
lp:x:7:7:lp:/var/spool/lpd:/bin/sh
mail:x:8:8:mail:/var/mail:/bin/sh
news:x:9:9:news:/var/spool/news:/bin/sh
```

#### [](#user-content-head-n)head -n

Mostra les n primeres línies d’un fitxer.

```
usuari@Azathoth~$ head -4 /etc/passwd
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/bin/sh
bin:x:2:2:bin:/bin:/bin/sh
sys:x:3:3:sys:/dev:/bin/sh
```

També podem mostrar els 4 primers bytes.

```
josep@odin:~$ head -c 4 /etc/passwd
rootjosep@odin:~$
```

### [](#user-content-tail)tail

Mostra les 10 últimes línies d’un fitxer.

```
usuari@Azathoth~$ tail /etc/services
vboxd 20012/udp
binkp 24554/tcp # binkp fidonet protocol
asp 27374/tcp # Address Search Protocol
asp 27374/udp
csync2 30865/tcp # cluster synchronization tool
dircproxy 57000/tcp # Detachable IRC Proxy
tfido 60177/tcp # fidonet EMSI over telnet
fido 60179/tcp # fidonet EMSI over TCP
# Local services
usuari@Azathoth~$
```

#### [](#user-content-tail-n)tail -n

Mostra les n últimes línies d’un fitxer.

```
usuari@Azathoth~$ tail -3 /etc/services
fido 60179/tcp # fidonet EMSI over TCP
# Local services
usuari@Azathoth~$
```

### [](#user-content-tail-f)tail -f

Mostra les últimes línies d’un fitxer mentre aquest va creixent.

```
josep@odin:~$ cat > file
un
dos
tres

josep@odin:~$ tail -f file
un
dos
tres
quatre
```

```
josep@odin:~$ echo quatre >> file
```

### [](#user-content-cat)cat

La comanda cat és una de les més universals tot i que l’únic que fa és copiar l’entrada estàndard a la sortida estàndard.

Alguns exemples permetran veure les seves possibilitats.

El primer exemple és simple, cat permet mostrar un fitxer per pantalla.

```
usuari@debian8:~$ cat /etc/resolv.conf
domain test.local
search test.local
nameserver 192.168.1.254
```

#### [](#user-content-concatenar-fitxers)Concatenar fitxers

cat permet concatenar fitxers en un de més gran.

```
josep@odin:~$ echo un > part1
josep@odin:~$ echo dos > part2
josep@odin:~$ echo tres > part3
josep@odin:~$ cat part1 part2 part3
un
dos
tres
josep@odin:~$ cat part1 part2 part3 > parts
josep@odin:~$ cat parts
un
dos
tres
```

#### [](#user-content-crear-fitxers)Crear fitxers

Es pot utilitzar la comanda cat per crear fitxers de text pla.

N’hi ha prou en escriure **cat > fitxer.txt**, a partir d’aquest moment tot el que es va escrivint pel terminal es va afegint a fitxer.txt.

[CTRL]+d per sortir.

```
josep@odin:~$ cat > file
bla
bla
bla
josep@odin:~$ cat file
bla
bla
bla
```

|   |   |
|---|---|
||La combinació [CTRL]+d envia un EOF (End Of File) al procés acabant la comanda cat.|

#### [](#user-content-final-de-fitxer-personalitzat)Final de fitxer personalitzat

Es pot triar un marcador de final de fitxer personalitzat, cal utilitzar **<<** com es mostra al següent exemple.

Aquesta construcció s’anomena una directiva "here" i finalitza la comanda cat.

```
josep@odin:~$ cat > file << stop
> bla
> bla
> bla
> stop
josep@odin:~$ cat file
bla
bla
bla
```

#### [](#user-content-copiar-fitxers)Copiar fitxers

Es pot utilitzar cat per copiar fitxers com es mostra a l’exemple.

```
josep@odin:~$ cat file > file2
josep@odin:~$ cat file2
bla
bla
bla
```

### [](#user-content-tac)tac

Funciona com cat però al revés com es veu a l’exemple.

```
josep@odin:~$ cat > comptar
un
dos
tres
josep@odin:~$ tac comptar
tres
dos
un
```

### [](#user-content-more-less)more / less

La comanda **more** és útil per mostrar fitxers que ocupen més d’una pantalla. Aquesta comanda permet veure’n els continguts pàgina a pàgina prement la barra espaiadora.

La comanda **less** és similar a more però més moderna i amb més funcionalitats.

Cal prèmer **q** per sortir.

### [](#user-content-strings)strings

Permet mostrar cadenes ascii que es troben dins de fitxers binaris.

```
josep@odin:~$ which ls
/usr/local/bin/ls

josep@odin:~$ strings /usr/local/bin/ls
.data
.bss
.comment
.debug_aranges
.debug_info
.debug_abbrev
.debug_line
.debug_str
.debug_loc
.debug_ranges
...
```