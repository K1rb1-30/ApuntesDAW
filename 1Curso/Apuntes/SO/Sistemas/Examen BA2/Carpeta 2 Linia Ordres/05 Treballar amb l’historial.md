## Comandes Linux - Treballar amb l’historial

### [](#user-content-repetir-la-última-comanda)Repetir la última comanda

Per repetir la última comanda a bash, teclejar **!!**

|   |   |
|---|---|
||En anglès **!** s’anomena **bang**.|

```
josep@odin:~$ echo patata > file.txt
josep@odin:~$ !!
echo patata > file.txt
```

### [](#user-content-repetir-altres-comandes)Repetir altres comandes

Per repetir la última comanda entrada que comenci per un o més caràcters **!_caracters_**

```
josep@odin:~$ touch file
josep@odin:~$ cat file
josep@odin:~$ !to
touch file
```

### [](#user-content-history)history

Permet veure les comandes entrades anteriorment.

**history n** mostra les n últimes comandes.

```
josep@odin:~$ history 10
  373  help | head -15
  374  echo patata > file.txt
  375  touch file
  376  cat file
  377  |to
  378  touch file
  379  history
  380  ping
  381  history
  382  history 10
```

### [](#user-content-n)!n

Escriure **!** seguit d’un número repeteix la comanda emmagatzemada a l’historial amb aquest número.

```
josep@odin:~$ !378
touch file
```

### [](#user-content-ctrl-r)Ctrl-r

[CTRL]+r seguit d’alguns caràcters, busca l’última comanda que comenci per aquests caràcters a l’historial.

```
(reverse-i-search)`apt': sudo apt install whois
```

### [](#user-content-histsize)$HISTSIZE

La variable **$HISTSIZE** determina el nombre de comandes que es poden emmagatzemar a l’historial, **durant una sessió bash**.

La majoria de distribucions tenen aquest paràmetre a 500 - 1000 per defecte.

```
josep@odin:~$ echo $HISTSIZE
1000
```

```
josep@odin:~$ HISTSIZE=0
josep@odin:~$ echo $HISTSIZE
0
josep@odin:~$ history
```

### [](#user-content-histfile)$HISTFILE

La variable **$HISTFILE** apunta al fitxer on s’emmagatzema l’historial. Per defecte **~/.bash_history**.

```
josep@odin:~$ echo $HISTFILE
/home/josep/.bash_history
```

|   |   |
|---|---|
||L’historial de la sessió s’emmagatzema en aquest fitxer en el moment de tancar la sessió.<br><br>Tancar un terminal de gnome amb el ratolí o llançar la comanda **reboot** NO guardarà l’historial al fitxer.|

### [](#user-content-histfilesize)$HISTFILESIZE

El nombre de comandes que es poden emmagatzemar a l’historial es pot establir modificant la variable **$HISTFILESIZE**, **es manté l’historial entre sessions bash**.

```
josep@odin:~$ echo $HISTFILESIZE
2000
```

### [](#user-content-evitar-emmagatzemar-una-comanda-a-lhistorial)Evitar emmagatzemar una comanda a l’historial

Començar una comanda amb un **espai** evita que aquesta quedi guardada a l’historial.

### [](#user-content-expressions-regulars)Expressions regulars

TODO

### [](#user-content-historial-a-la-shell-korn)Historial a la shell Korn

TODO