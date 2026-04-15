## Comandes Linux - Permisos - Avançats

Table 1. Permisos especials
||setuid|setgid|sticky bit|
|---|---|---|---|
|aplicat a|fitxer|directori|directori|
|notació|s - S|s - S|t -T|
|assignació|u+s|g+s|+t|
|Exemple|_/usr/bin/sudo_<br><br>_/usr/bin/passwd_||_/tmp_|

|   |   |
|---|---|
|**setuid**|El fitxer s’executa amb els permisos del propietari del fitxer enlloc dels permisos de qui ha llançat l’executable.|
|**setgid**|Tots els fitxers que es troben dintre d’un directori pertanyen al grup propietari del directori.|
|**sticky bit**|Elements del directori només poden ser renombrats o eliminats pel propietari de l’element, el propietari del directori o l’usuari root|

### [](#user-content-els-bits-setuid-en-un-fitxer)Els bits setuid en un fitxer

Aquest permis fa que un fitxer executable s’executi amb els permisos del propietari del fitxer enlloc dels permisos de qui ha llaçat l’executable.

Això implica que si un usuari llença un programa propietat de root, el programa correrà amb permisos de root.

Evidentment això pot suposar un problema de seguretat però a vegades és necessari.

Per exemple, les contrasenyes s’emmagatzemen en un fitxer que només pot llegir root, _etc/shadow_.

```
josep@odin:~$ ls -l /etc/shadow
-rw-r----- 1 root shadow 1892 oct  4 11:24 /etc/shadow
```

Canviar la pròpia contrasenya necessita modificar aquest fitxer, la solució és permetre que un usuari normal pugui llençar el programa _/usr/bin/passwd_ com a root.

```
josep@odin:~$ ls -l /usr/bin/passwd
-rwsr-xr-x 1 root root 59680 may 17  2017 /usr/bin/passwd
```

Es pot habilitar amb:

```
josep@odin:~$ sudo chmod u+s file1
```

O bé:

```
josep@odin:~$ sudo chmod 4777 file1
```

Podem veure tots els fitxers que tenen aquest bit habilitat:

```
josep@odin:~/tmp$ find /usr/bin -type f -perm -04000
/usr/bin/gpasswd
/usr/bin/newgrp
/usr/bin/sudo
/usr/bin/passwd
/usr/bin/chfn
/usr/bin/pkexec
/usr/bin/chsh
```

#### [](#user-content-setuid-a-sudo)setuid a sudo

Mireu els permisos de la comanda sudo:

```
josep@odin:~$ which sudo
/usr/bin/sudo
josep@odin:~$ ls -l /usr/bin/sudo
-rwsr-xr-x 1 root root 140944 jun  5  2017 /usr/bin/sudo
```

### [](#user-content-setgid-bit-en-un-directori)setgid bit en un directori

Aquest bit garanteix que tots els fitxers que es troben dintre d’un directori pertanyen al grup propietari del directori.

Aquest bit es mostra a la mateixa posició que el bit **x** del **propietari del grup** amb una **s** si **x** està habilitat i amb una **S** si **x** no està habilitat.

```
josep@odin:~$ mkdir tmp
josep@odin:~$ sudo groupadd tmpgroup
josep@odin:~$ sudo chown josep:tmpgroup tmp
josep@odin:~$ sudo chmod 2775 tmp
josep@odin:~$ ls -ld tmp
drwxrwsr-x 2 josep tmpgroup 4096 oct  4 11:51 tmp
josep@odin:~$ cd tmp
josep@odin:~/tmp$ touch file1
josep@odin:~/tmp$ ls -l
total 0
-rw-r--r-- 1 josep tmpgroup 0 oct  4 11:54 file1
```

Alternativament:

```
josep@odin:~$ sudo chmod g+s tmp
```

Podem veure tots els directoris del sistema que tenen aquest bit habilitat:

```
josep@odin:~/tmp$ find / -type d -perm -2000 2> /dev/null
```

### [](#user-content-sticky-bit-en-un-directori)sticky bit en un directori

Habilitar aquest bit en un directori fa que els elements del directori només puguin ser renombrats o eliminats pel propietari de l’element, el propietari del directori o l’usuari root **encara que la resta d’usuaris tinguin permisos d’escriptura al directori**.

Aquest bit es mostra a la mateixa posició que el bit **x** per **altres**, representat per **t** indicant que **x** està habilitat i per **T** indicant que **x** no està habilitat.

```
bob@odin:~$ umask 0
bob@odin:~$ mkdir tmp
bob@odin:~$ ls -ld tmp
drwxrwxrwx 2 bob bob 4096 oct  4 11:28 tmp
bob@odin:~$ cd tmp
bob@odin:~/tmp$ touch file1
bob@odin:~/tmp$ ls -l
total 0
-rw-rw-rw- 1 bob bob 0 oct  4 11:29 file1
bob@odin:~/tmp$ su - alice
Contraseña:
alice@odin:~$ cd /home/bob/tmp
alice@odin:/home/bob/tmp$ cp file1 file2
alice@odin:/home/bob/tmp$ rm file2

bob@odin:~$ umask
0000
bob@odin:~$ mkdir tmp
bob@odin:~$ ls -l
total 4
drwxrwxrwx 2 bob bob 4096 oct  4 11:32 tmp
bob@odin:~$ chmod +t tmp
bob@odin:~$ ls -l
total 4
drwxrwxrwt 2 bob bob 4096 oct  4 11:32 tmp
bob@odin:~/tmp$ touch file1
bob@odin:~/tmp$ ls -l
total 0
-rw-rw-rw- 1 bob bob 0 oct  4 11:34 file1
bob@odin:~/tmp$ su - alice
Contraseña:
alice@odin:~$ cd /home/bob/tmp
alice@odin:/home/bob/tmp$ mv file1 file2
mv: no se puede mover 'file1' a 'file2': Operación no permitida
alice@odin:/home/bob/tmp$ rm file1
rm: no se puede borrar 'file1': Operación no permitida
alice@odin:/home/bob/tmp$ echo hola > file1
alice@odin:/home/bob/tmp$ cat file1
hola
alice@odin:/home/bob/tmp$
```

Aquest bit també es pot assignar en forma octal:

```
josep@odin:~$ mkdir tmp
josep@odin:~$ chmod 1775 tmp
josep@odin:~$ ls -ld tmp
drwxr-xr-x 2 josep josep 4096 oct  4 11:43 tmp
josep@odin:~$
```

Típicament es troba aquests bit a la capeta /tmp

```
josep@odin:~$ ls -ld /tmp
drwxrwxrwt 10 root root 4096 oct  4 11:17 /tmp
```