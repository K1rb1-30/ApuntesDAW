## Comandes Linux - Alies

### [](#user-content-crear-un-alias)Crear un alias

La shell en permet crear alias que poden facilitar el recordar o escriure determinades comandes.

### [](#user-content-abreviar-comandes)Abreviar comandes

Un alies pot ser útil per abreviar una comanda existent.

```
josep@hades:~$ alias ll='ls -lh --color=auto'
josep@hades:~$ alias c='clear'
```

### [](#user-content-paràmetres-per-defecte)Paràmetres per defecte

També els podem utilitzar per generar comandes amb paràmetres per defecte.

```
josep@odin:~$ alias ls='ls -l'
```

### [](#user-content-alias-amb-paràmetres)Alias amb paràmetres

Fins i tot podem crear un alies que admeti paràmetres.

```
josep@odin:~$ alias mes='cal -A 1 -B 1 -m'
```

```
josep@odin:~$ mes 5
                            2018
       Abril                  Mayo                 Junio
do lu ma mi ju vi sá  do lu ma mi ju vi sá  do lu ma mi ju vi sá
 1  2  3  4  5  6  7         1  2  3  4  5                  1  2
 8  9 10 11 12 13 14   6  7  8  9 10 11 12   3  4  5  6  7  8  9
15 16 17 18 19 20 21  13 14 15 16 17 18 19  10 11 12 13 14 15 16
22 23 24 25 26 27 28  20 21 22 23 24 25 26  17 18 19 20 21 22 23
29 30                 27 28 29 30 31        24 25 26 27 28 29 30
```

### [](#user-content-mostrar-els-alies-existents)Mostrar els alies existents

La comanda _alias_ sense paràmetres mostra tots els alies existents.

```
josep@odin:~$ alias
alias ls='ls -l'
alias mes='cal -A 1 -B 1 -m'
```

### [](#user-content-unalias)unalias

Es pot eliminar un alias amb la comanda _unalias_.

```
josep@odin:~$ alias
alias ls='ls -l'
alias mes='cal -A 1 -B 1 -m'
josep@odin:~$ unalias ls
josep@odin:~$ alias
alias mes='cal -A 1 -B 1 -m'
```

### [](#user-content-fer-alies-permanents)Fer alies permanents

La manera més senzilla de fer alies que es mantinguin entre sessions és afegir-los al fitxer **_~/.bash_aliases_**.