## Comandes Linux - Globbing

La shell és responsable de la generació dinàmica de noms de fitxers, aquest proces s’anomena **globbing**

### [](#user-content-asterisc)* asterisc

L’asterisc és interpretat per la shell com una manera de generar noms de fitxers coincidint amb qualsevol combinació de caràcters (fins i tot cap).

Si no es proporciona un path, la shell, utilitzarà els noms de fitxer al directori actual.

|   |   |
|---|---|
||Veure la pàgina de manual glob(7) per a més informació.|

```
josep@odin:~/tmp$ ls
file1  file2  file3  file4  filea  fileab  fileabc
josep@odin:~/tmp$ ls file*
file1  file2  file3  file4  filea  fileab  fileabc
josep@odin:~/tmp$ ls *ile
ls: no se puede acceder a '*ile': No existe el fichero o el directorio
josep@odin:~/tmp$ ls *ile3
file3
josep@odin:~/tmp$ ls f*2
file2
```

### [](#user-content-interrogant)? interrogant

De forma similar a l’asterisc, l’interrogant és interpretat per la shell com una manera de generar noms de fitxers coincidint l’interrogant amb un sol caràcter.

```
josep@odin:~/tmp$ ls
file1  file2  file3  file4  filea  fileab  fileabc
josep@odin:~/tmp$ ls file?
file1  file2  file3  file4  filea
josep@odin:~/tmp$ ls fil?3
file3
josep@odin:~/tmp$ ls fil??
file1  file2  file3  file4  filea
```

### [](#user-content-claudators)[] claudators

Els claudators indiquen a la shell que generi noms de fitxers fent coincidir qualsevol dels caràcters entre claudators, independentment de l’ordre.

Cada parell de claudàtors es reemplaça exactment per un caràcter.

```
josep@odin:~/tmp$ ls
file1  file2  file3  file4  filea  fileab  fileabc
josep@odin:~/tmp$ ls file[a3]
file3  filea
josep@odin:~/tmp$ ls file[3a]
file3  filea
josep@odin:~/tmp$ ls file[3a][3b]
fileab
josep@odin:~/tmp$ ls file[abcdefghijklmn]
filea
josep@odin:~/tmp$ ls file[3a][abcdefghijklmn]
fileab
```

### [](#user-content-exclamació)! exclamació

L’exclamació exclou els caràcters de la llista, a més els claudators es poden combinar amb els comodins, * i ?.

```
josep@odin:~/tmp$ ls
file1  file2  file3  file4  filea  fileab  fileabc
josep@odin:~/tmp$ ls file[3a][!z]
fileab
josep@odin:~/tmp$ ls file[!34a]
file1  file2
josep@odin:~/tmp$ ls file[!3]*
file1  file2  file4  filea  fileab  fileabc
josep@odin:~/tmp$ ls file[!3]?
fileab
```

### [](#user-content-rangs-a-z-i-0-9)Rangs a-z i 0-9

Bash també és capaç d’entendre rangs de caràcters entre claudàtors.

```
josep@odin:~/tmp$ ls
file1  file2  file3  file4  filea  fileab  fileabc
josep@odin:~/tmp$ ls file[a-z]*
filea  fileab  fileabc
josep@odin:~/tmp$ ls file[0-9]
file1  file2  file3  file4
josep@odin:~/tmp$ ls file[a-z][a-z]
fileab
```

### [](#user-content-evitar-el-globbing)Evitar el globbing

Per evitar el globbing n’hi ha prou en utilitzar comilles o escapar els caràcters especials.

```
josep@odin:~/tmp$ echo *
file1 file2 file3 file4 filea fileab fileabc
josep@odin:~/tmp$ echo "*"
*
josep@odin:~/tmp$ echo \*
*
josep@odin:~/tmp$ echo '*'
*
```