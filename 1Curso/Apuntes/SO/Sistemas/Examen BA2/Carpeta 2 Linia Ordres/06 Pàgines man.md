## Comandes Linux - Pàgines man

Aquest capítol explica l’ús de les pàgines man, les pàgines de manual en sistemes Linux.

La majoria de comandes en Linux disposen de pàgines man on expliquen el seu ús. Són útils sobretot per recordar els diferents paràmetres i per moure’s entre diferents versions de Linux on els paràmetres de les comandes poden variar.

### [](#user-content-man-command)man $command

man seguit d’una comanda mostra la pàgina man referent a la comanda entrada.

Cal prèmer q per sortir de la pàgina man.

```
josep@odin:~$ man whois
```

### [](#user-content-man-configfile)man $configfile

També es pot utilitzar la comanda man per obtenir informació sobre els fitxers de configuració, la majoria d’ells disposen de la seva pròpia pàgina de manual.

```
josep@odin:~$ man systemd-system.conf
```

### [](#user-content-man-daemon)man $daemon

La majoria de "daemons" també tenen pàgina man.

```
josep@odin:~$ man systemd
```

### [](#user-content-man-k-apropos)man -k (apropos)

Mostra una llista de pàgines man que contenen la cadena demanada a l’apartat **NAME** de la pàgina del manual.

```
osep@odin:~$ man -k systemd
deb-systemd-helper (1p) - subset of systemctl for machines not running systemd
deb-systemd-invoke (1p) - wrapper around systemctl, respecting policy-rc.d
init (1)             - systemd system and service manager
journalctl (1)       - Query the systemd journal
loginctl (1)         - Control the systemd login manager
pam_systemd (8)      - Register user sessions in the systemd login manager
systemctl (1)        - Control the systemd system and service manager
systemd (1)          - systemd system and service manager
systemd-analyze (1)  - Analyze system boot-up performance
...
```

### [](#user-content-whatis)whatis

Mostra només la descripció (apartat NAME) de la pàgina man.

```
josep@odin:~$ whatis ip
ip (7)               - Implementación Linux del protocolo IPv4
ip (8)               - show / manipulate routing, devices, policy routing and...
```

### [](#user-content-whereis)whereis

Mostra la localització de la pàgina man demanada i la localització del fitxer.

```
josep@odin:~$ whereis ip
ip: /bin/ip /sbin/ip /usr/share/man/man7/ip.7.gz /usr/share/man/man8/ip.8.gz
```

### [](#user-content-seccions-del-manual)Seccions del manual

En les pàgines man apareixen uns números entre parèntesis, fan referència a les diferents seccions de les pàgines del manual. Que poden ser:

|Secció|Conté||
|---|---|---|
|**1**|User Commands|Programes executables o comandes del shell. (normalment no necessiten privilegis administratius).|
|2|System Calls|Crides a system (funcions del kernel de Linux)|
|3|C Library Functions|Funcions de programació que proporcionen interfícies a biblioteques de programació específiques.|
|4|Devices and Special Files|Nodes del sistema de fitxers que representen dispositius hardware o software. Normalment dins el directori _/dev_|
|**5**|File Formats and Conventions|Estructures i formats e fitxers amb configuracions especifiques. Per exemple _/etc/passwd_|
|6|Games|Jocs disponibles al sistema|
|7|Miscellaneous|Temes generals sobre protocols, sistemes d efitxers, etc…​|
|**8**|System administration tools and Daemons|Rutines del kernel. Necessiten privilegis de root.|

|   |   |
|---|---|
||Si no recordem les seccions del manual sempre podem fer:<br><br>```<br>josep@odin:~$ man passwd<br>josep@odin:~$ man 5 passwd<br>```|

### [](#user-content-man-section-file)man $section $file

Permet fer referència a una de les seccions del manual.

```
josep@odin:~$ man passwd
josep@odin:~$ man 5 passwd
```

### [](#user-content-man-man)man man

Mostra ajuda sobre les pàgines man.

#### [](#user-content-mandb)mandb

Refresca els índexs de la base de dades man.

|   |   |
|---|---|
||Útil en el cas que una pàgina man que hauria d’existir no es mostra.|

```
josep@odin:~$ mandb
0 man subdirectories contained newer manual pages.
0 manual pages were added.
0 stray cats were added.
0 old database entries were purged.
```

### [](#user-content-help-shellcommand)help $shellcommand

Algunes comandes pertanyen al shell i no tenen entrada de manual. Per veure l’ajuda d’aquestes comandes cal utilitzar la comanda _help_

```
josep@odin:~$ man cd
No manual entry for cd
josep@odin:~$ help cd
```

### [](#user-content-help)help

Mostra la llista de comandes del shell

```
josep@odin:~$ help | head -15
GNU bash, versión 4.4.12(1)-release (x86_64-pc-linux-gnu)
Estas órdenes del shell están definidas internamente.  Teclee `help' para
ver esta lista.
Teclee `help nombre' para saber más sobre la función `nombre'.
Use `info bash' para saber más sobre el shell en general.
Use `man -k' o `info' para saber más sobre las órdenes que no están en
esta lista.

Un asterisco (*) junto a un nombre significa que el comando está desactivado.

 id_trabajo [&]                          history [-c] [-d despl] [n] ó histor>
 (( expresión ))                         if ÓRDENES; then ÓRDENES; [ elif ÓRD>
 . fichero [argumentos]                  jobs [-lnprs] [idtrabajo ...] ó jobs>
 :                                       kill [-s id_señal | -n num_señal | ->
 [ arg... ]
 ....
```

### [](#user-content-com-interpretar-la-sinopsis-duna-entrada-de-manual)Com interpretar la sinopsis d’una entrada de manual

L’apartat SINOPSIS d’una pàgina man mostra el resum d’utilització de la comanda. Per interpretar-la correctament cal tenir em compte un sèrie de coses:

Nombre de línies de la sinopsis

La quantitat de línies que té la sinopsis determina de quantes maneres diferents es pot utilitzar la comanda.

[arg1][arg2][arg3]

Els arguments entre claudàtors són optatius, la comanda funcionarà sense ells.

{arg1, arg2} o [arg1 | arg2]

Els arguments entre claus o bé separats per una 'pipe' són excloents un de l’altre, és a dir, si en posem un no podem posar l’altre i al revés.

<arg1> <arg2> o arg1 arg2

Els arguments entre els símbols menor i major o sense delimitar són obligatoris, si no es posen la comanda no funcionarà.

```
josep@odin:~$ man man
```

SINOPSIS
       man  [-c|-w|-tZT  dispositivo] [-adhu7V] [-m sistema[,...]] [-L locale]
       [-p cadena] [-M  ruta]  [-P  paginador]  [-r  prompt]  [-S  lista]  [-e
       extension] [[sección] pagina ...] ...
       man  -l  [-7] [-tZT dispositivo] [-p cadena] [-P paginador] [-r prompt]
       fichero ...
       man -k [-M ruta] palabra_clave ...
       man -f [-M ruta] pagina ...