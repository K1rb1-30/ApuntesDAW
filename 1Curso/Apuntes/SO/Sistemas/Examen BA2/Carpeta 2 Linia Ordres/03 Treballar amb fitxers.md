## Comandes Linux - Treballar amb fitxers

### [](#user-content-el-nom-dels-fitxers-es-case-sensitive)El nom dels fitxers es "case sensitive"

|   |   |
|---|---|
||Tots els fitxers en Linux són sensibles a les majúscules i a les minúscules, això vol dir que FITXER1 és diferent que fitxer1.|

### [](#user-content-tot-és-un-fitxer)Tot és un fitxer

- En Linux un directori és un tipus especial de fitxer.
    
- Una partició és un fitxer, per exemple, **/dev/sdb1**.
    
- Cada finestra de terminal, per exemple **/dev/pts/4**, és un fitxer.
    
- Tots els processos es representen en algun lloc del sistema de fitxers.
    

### [](#user-content-file)file

file

indica el tipus de fitxer segons el seu contingut.

|   |   |
|---|---|
||Linux **no** utilitza extensions per a determinar el tipus de fitxer.|

```
josep@odin:~$ file pic33.png
pic33.png: PNG image data, 3840 x 1200, 8-bit/color RGBA, non-interlaced
josep@odin:~$ file /etc/passwd
/etc/passwd: ASCII text
josep@odin:~$ file HelloWorld.c
HelloWorld.c: ASCII C program text
```

|   |   |
|---|---|
||La comanda **file** utilitza un fitxer màgic que conté els patrons per a reconèixer els diferents tipus de fitxers. Aquest fitxer es troba a **/usr/share/file/magic/**.|

#### [](#user-content-file-s)file -s

Mostra les propietats dels fitxers especials, per exemple, els que resideixen a **/dev** i a **/proc**.

```
root@odin:~# file -s /dev/sda
/dev/sda: DOS/MBR boot sector
root@odin:~# file -s /dev/sda1
/dev/sda1: Linux rev 1.0 ext4 filesystem data, UUID=72a76dcc-489d-464e-9015-be2e8f96fd8c (needs journal recovery) (extents) (64bit) (large files) (huge files)
root@odin:~# file -s /proc/cpuinfo
/proc/cpuinfo: ASCII text, with very long lines
```

### [](#user-content-touch)touch

Crea un fitxer buit.

```
root@odin:~/tmp# ls -l
total 0
root@odin:~/tmp# touch file1
root@odin:~/tmp# ls -l
total 0
-rw-r--r-- 1 root root 0 sep 15 11:21 file1
```

### [](#user-content-touch-t)touch -t

Permet assignar algunes propietats al crear els fitxers.

```
root@odin:~/tmp# touch -t 7012230000 ancient.txt
root@odin:~/tmp# ls -l
total 0
-rw-r--r-- 1 root root 0 dic 23  1970 ancient.txt
```

### [](#user-content-rm)rm

Elimina permanentment un fitxer del sistema de fitxers.

|   |   |
|---|---|
||Linux no disposa de paperera de reciclatge!!!|

```
root@odin:~/tmp# ls
ancient.txt
root@odin:~/tmp# rm ancient.txt
root@odin:~/tmp# ls
```

#### [](#user-content-rm-i)rm -i

Pregunta abans d’eliminar un fitxer.

```
root@odin:~/tmp# ls
ancient.txt
root@odin:~/tmp# rm -i ancient.txt
rm: ¿borrar el fichero regular vacío 'ancient.txt'? (s/n) s
root@odin:~/tmp# ls
```

#### [](#user-content-rm-rf)rm -rf

Per defecte **rm** no elimina els directoris plens, **-f** permet eliminar els directoris amb contingut, **-r** ho ha de manera recursiva.

|   |   |
|---|---|
||Cal anar amb molt de compte al utilitzar **rm -rf** és una comanda perillosa.|

```
usuari@debian7:~$ mkdir test
usuari@debian7:~$ rm test
rm: cannot remove 'test': Is a directory
usuari@debian7:~$ rm -rf test
usuari@debian7:~$ ls test
ls: cannot access test: No such file or directory
usuari@debian7:~$
```

### [](#user-content-cp)cp

Realitza la còpia d’un fitxer.

```
josep@odin:~/tmp$ ls
file1
josep@odin:~/tmp$ cp file1 file2
josep@odin:~/tmp$ ls
file1  file2
```

#### [](#user-content-copiar-a-un-altre-directori)Copiar a un altre directori

Si el destí és un directori, els fitxers origen es copien a aquest directori.

```
josep@odin:~/tmp$ ls
file1  file2
josep@odin:~/tmp$ ls
file1  file2
josep@odin:~/tmp$ mkdir dir1
josep@odin:~/tmp$ cp file1 file2 dir1
josep@odin:~/tmp$ cd dir1
josep@odin:~/tmp/dir1$ ls
file1  file2
```

#### [](#user-content-cp-r)cp -r

Còpia directoris sencers, incloent-hi tots els seus subdirectoris.

```
josep@odin:~/tmp$ ls
dir1  file1  file2
josep@odin:~/tmp$ mkdir dir2
josep@odin:~/tmp$ cp dir1 file1 file2 dir2
cp: -r not specified; omitting directory 'dir1'
josep@odin:~/tmp$ cp -r dir1 file1 file2 dir2
josep@odin:~/tmp$ cd dir2
josep@odin:~/tmp/dir2$ ls
dir1  file1  file2
```

Copiar més d’un fitxer a un directori

Cal que l’últim argument sigui un directori.

#### [](#user-content-cp-i)cp -i

Per evitar que **cp** sobreescrigui els fitxers existent es pot utilitzar **-i** (interactiu).

```
josep@odin:~/tmp$ cp file1 file2
josep@odin:~/tmp$ cp -i file1 file2
cp: ¿sobreescribir 'file2'? (s/n) s
```

### [](#user-content-mv)mv

Permet moure o canviar el nom d’un fitxer.

```
josep@odin:~/tmp$ ls
file1
josep@odin:~/tmp$ mkdir dir1
josep@odin:~/tmp$ mv file1 dir1
josep@odin:~/tmp$ ls
dir1
josep@odin:~/tmp$ cd dir1
josep@odin:~/tmp/dir1$ ls
file1
```

#### [](#user-content-canviar-el-nom-dun-fitxer)Canviar el nom d’un fitxer

La comanda **mv** és la comanda recomanada per renombrar un fitxer, n’hi ha prou en moure el fitxer a la mateixa carpeta on està donant-li un nom diferent.

```
josep@odin:~/tmp$ ls -l
total 8
drwxr-xr-x 2 josep josep 4096 sep 24 10:50 dir1
-rw-r--r-- 1 josep josep    5 sep 24 10:51 file1
josep@odin:~/tmp$ mv file1 file2
josep@odin:~/tmp$ ls -l
total 8
drwxr-xr-x 2 josep josep 4096 sep 24 10:50 dir1
-rw-r--r-- 1 josep josep    5 sep 24 10:51 file2
```

#### [](#user-content-mv-i)mv -i

Demana permís per sobreescriure un fitxer.

```
josep@odin:~/tmp$ ls
file1  file2
josep@odin:~/tmp$ mv -i file1 file2
mv: ¿sobreescribir 'file2'? (s/n) s
josep@odin:~/tmp$ ls
file2
```