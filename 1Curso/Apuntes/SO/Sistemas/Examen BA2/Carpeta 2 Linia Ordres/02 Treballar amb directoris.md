## Comandes Linux - Treballar amb directoris

### [](#user-content-pwd)pwd

**pwd** mostra el directori de treball actual. (Print Working Directory)

```
usuari@Azathoth:~$ pwd
/home/usuari
```

### [](#user-content-cd)cd

**cd** permet canviar el directori actual. (Change Directory)

```
usuari@Azathoth:~$ cd /etc
usuari@Azathoth:/etc$
usuari@Azathoth:/etc$ pwd
/etc
```

#### [](#user-content-cd-2)cd ~

És una drecera per tornar al directori home de l’usuari actual.

**cd** sense paràmetres fa el mateix efecte.

```
usuari@Azathoth:/etc$ cd
usuari@Azathoth:~$
```

#### [](#user-content-cd-3)cd ..

Retorna al directori pare.

```
usuari@Azathoth:/home$ cd ..
usuari@Azathoth:/$
```

#### [](#user-content-cd-4)cd -

Torna al directori previ.

```
usuari@Azathoth:~$ pwd
/home/usuari
usuari@Azathoth:~$ cd /etc
usuari@Azathoth:/etc$ cd -
/home/usuari
usuari@Azathoth:~$ cd -
/etc
usuari@Azathoth:/etc$
```

### [](#user-content-rutes-absolutes-i-rutes-relatives)Rutes absolutes i rutes relatives

Quan una ruta comença amb **/** la ruta es considera absoluta.

```
usuari@Azathoth:/etc$ pwd
/etc
usuari@Azathoth:/etc$ cd home
bash: cd: home: No existe el fichero o el directorio
usuari@Azathoth:/etc$ cd /home
usuari@Azathoth:/home$ pwd
/home
usuari@Azathoth:/home$
```

### [](#user-content-autocompletant-amb-la-tecla-tab)Autocompletant amb la tecla [TAB]

La tecla [TAB] permet autocompletar automàticament les comandes.

### [](#user-content-ls)ls

Mostra el contingut d’un directori.

```
usuari@Azathoth:/$ ls
bin   dev  home        lib    lost+found  mnt  proc  run   srv  tmp  var
boot  etc  initrd.img  lib64  media       opt  root  sbin  sys  usr  vmlinuz
```

#### [](#user-content-ls-a)ls -a

Mostra tots els fitxers incloent-hi els fitxers ocults

```
usuari@Azathoth:~$ ls -a
.  ..  .bash_logout  .bashrc  .profile
```

### [](#user-content-ls-l)ls -l

Mostra el contingut d’un directori en format llarg.

```
usuari@Azathoth:~$ ls -l
total 4868
-rwxrw-rw- 1 root   root    834686 sep 28 19:02 bins
-rw-r--r-- 1 usuari usuari      84 feb 15 20:55 commandes.txt
drwxr-xr-x 2 usuari usuari    4096 feb 15 20:52 coses
-rw-r--r-- 1 usuari usuari      35 feb 15 20:53 dades
-rwxrw-rw- 1 root   root   4134597 sep 27 20:20 photos
```

#### [](#user-content-ls-lh)ls -lh

Mostra la mida dels fitxers en unitats més llegibles.

```
usuari@Azathoth:~$ ls -lh
total 4,8M
-rwxrw-rw- 1 root   root   816K sep 28 19:02 bins
-rw-r--r-- 1 usuari usuari   84 feb 15 20:55 commandes.txt
drwxr-xr-x 2 usuari usuari 4,0K feb 15 20:52 coses
-rw-r--r-- 1 usuari usuari   35 feb 15 20:53 dades
-rwxrw-rw- 1 root   root   4,0M sep 27 20:20 photos
```

### [](#user-content-mkdir)mkdir

Permet crear nous directoris sempre que es tinguin permisos.

```
usuari@Azathoth:/home$ mkdir testdir
mkdir: no se puede crear el directorio «testdir»: Permiso denegado
usuari@Azathoth:/home$ cd ~
usuari@Azathoth:~$ mkdir testdir
```

### [](#user-content-rmdir)rmdir

Permet eliminar directoris buits.

```
usuari@Azathoth:~$ ls
bins  commandes.txt  coses  dades  photos  testdir
usuari@Azathoth:~$ rmdir testdir
usuari@Azathoth:~$ ls
bins  commandes.txt  coses  dades  photos
usuari@Azathoth:~$
```

#### [](#user-content-rmdir-p)rmdir -p

Elimina directoris recursivament.

```
josep@odin:~$ mkdir dir1/dir2/dir3
mkdir: no se puede crear el directorio «dir1/dir2/dir3»: No existe el fichero o el directorio
josep@odin:~$ mkdir -p dir1/dir2/dir3
josep@odin:~$ rmdir -p dir1/dir2/dir3
```