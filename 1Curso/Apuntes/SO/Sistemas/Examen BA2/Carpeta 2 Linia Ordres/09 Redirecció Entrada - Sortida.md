## Comandes Linux - Redirecció Entrada / Sortida

Una característica important dels sistemes Unix és la capacitat de redireccionar les entrades i les sortides de dades i encadenar mitjançant "pipes" l’entrada i la sortida de més d’una aplicació.

### [](#user-content-stdin-stdout-and-stderr)stdin, stdout, and stderr

La shell de bash disposa de tres fluxes de dades (streams).

Pren la entrada de la entrada estàndard (**stdin**) la sortida l’envia cap a la sortida estàndard (**stout**) i els missatges d’error els envia cap a un flux especific per aquesta funció, (**sterr**).

Internament numera els tres fluxos de la següent manera:

- stdin (0) bash
    
- stdout (1)
    
- stderr (2)
    

Normalment el teclat actua com a **stdin** mentre que la pantalla actua com a **stdout** i com a **stderr**.

|   |   |
|---|---|
||A vegades serà molt útil separar **stdout** de **stderr**.|

### [](#user-content-redirecció-de-output)Redirecció de "output"

#### [](#user-content-stdout)> stdout

Per a redireccionar **stdout** s’utilitza el símbol **>**, de fet > és una abreviatura de **1>**.

```
josep@odin:~$ echo hola
hola
josep@odin:~$ echo hola > saluda.txt
josep@odin:~$ cat saluda.txt
hola
```

|   |   |
|---|---|
||Cal notar que la shell (bash) retira l’operador de redirecció, >, abans de l’execució del primer argument.|

#### [](#user-content-el-fitxer-de-sortida-es-borra)El fitxer de sortida es borra

Quan es processa la línia i la shell nota l’operador > elimina el contingut del fitxer de sortida. Això passa encara que la comanda falli degut a un error.

```
josep@odin:~$ cat saluda.txt
hola
josep@odin:~$ echo adeu > saluda.txt
josep@odin:~$ cat saluda.txt
adeu
```

#### [](#user-content-noclobber)noclobber

Es pot evitar que l’operador > elimini el fitxer de sortida establint la opció **noclobber**.

```
josep@odin:~$ cat saluda.txt
adeu
josep@odin:~$ set -o noclobber
josep@odin:~$ echo Hi > saluda.txt
bash: saluda.txt: no se puede sobreescribir un fichero existente
josep@odin:~$ set +o noclobber
josep@odin:~$ echo Hi > saluda.txt
josep@odin:~$ cat saluda.txt
Hi
```

#### [](#user-content-ignorar-la-opció-noclobber)Ignorar la opció noclobber

L’operador **>|** ignora la opció **noclobber**.

```
josep@odin:~$ set -o noclobber
josep@odin:~$ echo Hola > saluda.txt
bash: saluda.txt: no se puede sobreescribir un fichero existente
josep@odin:~$ echo Hola >| saluda.txt
josep@odin:~$ cat saluda.txt
Hola
```

#### [](#user-content-operador)Operador >>

Es pot utilitzar l’operador **>>** per afegir la sortida al fitxer.

```
josep@odin:~$ echo pastanaga > llista.txt
josep@odin:~$ cat llista.txt
pastanaga
josep@odin:~$ echo patates >> llista.txt
josep@odin:~$ cat llista.txt
pastanaga
patates
```

### [](#user-content-redirecció-de-stderr)Redirecció de "stderr"

#### [](#user-content-2-stderr)2> stderr

Per redireccionar **stderr** s’utilitza l’operador **2>**.

És útil per evitar que els missatges d’error emmascarin el resultat de la comanda.

```
josep@odin:~$ find / > totselsfitxers.txt 2> /dev/null
```

#### [](#user-content-21)2>&1

Es pot redireccionar **stdout** i **stderr** al mateix fitxer utilitzant 2>&1.

```
josep@odin:~$ find / > totselsfitxersierrors.txt 2>&1
```

|   |   |
|---|---|
||L’ordre de les redireccions és important.|

```
ls > dirlist 2>&1 # Dirigeix stdin i stdout al fitxer dirlist
ls 2>&1 > dirlist # Dirigeix només stdout a dirlist ja que s'ha redireccionat stderr abans de redireccionar stdin.
```

### [](#user-content-redirecció-de-stdout-i-pipes)Redirecció de stdout i pipes

Per defecte no es pot fer **grep** dins de stderr utilitzant "pipes" a la línia de comandes per què només es redirecciona stdout.

```
josep@odin:~$ rm file1 file2 file3
rm: no se puede borrar 'file1': No existe el fichero o el directorio
rm: no se puede borrar 'file2': No existe el fichero o el directorio
rm: no se puede borrar 'file3': No existe el fichero o el directorio
josep@odin:~$ rm file1 file2 file3 | grep file1
rm: no se puede borrar 'file1': No existe el fichero o el directorio
rm: no se puede borrar 'file2': No existe el fichero o el directorio
rm: no se puede borrar 'file3': No existe el fichero o el directorio
```

Amb 2>&1 es pot forçar que stderr vagi cap a stdout. Això permet que a la següent comanda, la "pipe" pugui actuar als dos fluxos.

```
josep@odin:~$ rm file1 file2 file3 2>&1 | grep file1
rm: no se puede borrar 'file1': No existe el fichero o el directorio
```

No es pot utilitzar 1>&2 i 2>&1 per intercanviar stdout i stderr.

```
josep@odin:~$ rm file1 file2 file3 2>&1 1>&2 | grep file1
rm: no se puede borrar 'file1': No existe el fichero o el directorio
```

Cal un tercer stream per intercanviar stdout i stderr després d’un pipe.

grep actua sobre stderr

```
josep@odin:~$ rm file1 file2 file3 3>&1 1>&2 2>&3 | grep file1
rm: no se puede borrar 'file1': No existe el fichero o el directorio
```

grep no actua sobre stdout

```
josep@odin:~$ echo file1 file2 file3 3>&1 1>&2 2>&3 | grep file1
file1 file2 file3
```

### [](#user-content-ajuntar-stdout-i-stderr)Ajuntar stdout i stderr

La construcció &> ajunta stdout i stderr en un mateix flux.

```
josep@odin:~$ rm file1 &> outierr
josep@odin:~$ cat outierr
rm: no se puede borrar 'file1': No existe el fichero o el directorio
josep@odin:~$ echo file1 &> outierr
josep@odin:~$ cat outierr
file1
```

### [](#user-content-redirecció-de-stdin)Redirecció de "stdin"

#### [](#user-content-stdin)< stdin

La redirecció de **stdin** es fa amb l’operador **<** (o bé, **0<**)

```
josep@odin:~$ cat < test.txt
patata
pastanaga
pebrot
```

#### [](#user-content-here-document)<< here document

**Here document** és una manera d’afegir input fins a una certa seqüència (normalment EOF). EL marcador EOF es pot escriure literalment o amb [CTRL]-D

A l’exemple EOF é sla condició de sortida del cat.

```
josep@odin:~$ cat <<EOF > llista.txt
> un
> dos
> tres
> EOF
josep@odin:~$ cat llista.txt
un
dos
tres
```

### [](#user-content-redirecció-ofuscada)Redirecció ofuscada?

Les dues redireccions següents són equivalents.

cat file.txt > errors.txt

> errors.txt cat file.txt

Les tres redireccions següents són equivalents.

cat file.txt > file2.txt 2> errors.txt

2> errors.txt cat file.txt > file2.txt

< file.txt > file2.txt 2> errors.txt cat

### [](#user-content-la-manera-més-ràpida-deliminar-el-contingut-dun-fitxer)La manera més ràpida d’eliminar el contingut d’un fitxer

`>foo`

i si la opció **noclobber** està habilitada:

`>|bar`