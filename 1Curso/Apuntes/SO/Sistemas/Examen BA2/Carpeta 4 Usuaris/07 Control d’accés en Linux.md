## Control d’accés en Linux

Quan en un mateix sistema convergeixen més d’un usuari hi ha d’haver algun mecanisme que gestioni l’accés als processos, fitxers i carpetes del sistema.

La tradició Unix estableix que a cada fitxer i a cada directori se li assignara **exactament** un usuari, anomenat propietari, i un grup.

Cada fitxer suporta privilegis separats pel seu **propietari**, pel seu **grup** i per tots els **demés usuaris**.

El propietari estableix els privilegis d’accés del fitxer i el grup i els altres només podran accedir-hi si el propietari els hi ha assignat suficients privilegis.

La suma de total dels permisos d’accés d’un fitxer s’anomena **el mode d’accés**.

### [](#user-content-control-daccés-per-fitxers-i-directoris)Control d’accés per fitxers i directoris

Per a cada fitxer i cada directori del sistema Linux permet drets d’accés separadament per cadascuna de les següents tres classes d’usuaris.

- Propietari (owner) representat per la lletra **u**ser.
    
- Membres del grup del fitxer representat per la lletra **g**roup.
    
- Altres ussaris representats per la lletra **o**thers.
    

Els permisos que s’assignen per a cadascuna de les classes anteriors són:

En el cas dels fitxers

- Permís de lectura, **r**ead
    
- Permís d’escriptura, **w**rite
    
- Permís d’execució, e**x**ecute
    
    - Necessari per llençar el fitxer com un procés
        
    

|   |   |
|---|---|
||Executar un fitxer binari només necessita permisos d’execució, executar un script necessita a més permisos de lectura.|

En els cas dels directoris

- Permís de lectura
    
    - Permet veure el contingut del directori.
        
    
- Permís d’escriptura
    
    - Permet crear, eliminar o renombrar fitxers dins al directori.
        
    
- Permís d’execució
    
    - Permet l’accés al directori, am _cd_ per exemple.
        
    

|   |   |
|---|---|
||Per poder realitzar operacions sobre qualsevol directori (llegir o escriure) serà necessari sempre, tenir atorgat a més el permís d’execució.<br><br>Per accedir a un recurs de qualsevol forma (execució, lectura o escriptura) s’han de tenir permisos d’execució per a tots els directoris que contenen al recurs directa i indirectament.|

### [](#user-content-representació-dels-permisos-en-linux)Representació dels permisos en Linux

Els tres tipus de permisos esmentats posseeixen una representació numèrica basada en el sistema octal que parteix de representar com **1** els bits dels permisos atorgats i **0** per als negats. Després es transforma la representació binària així obtinguda en octal. Els permisos sempre van formant trios, de la forma **rwx**.

D’aquesta forma s’obtenen per a cada tipus de permís els següents valors:

|Permís|r|w|x|
|---|---|---|---|
|Valor|4|2|1|

r = 100 (4 en octal) (r--) w = 010 (2 en octal) (-w-) x = 001 (1 en octal) (--x)

La combinació dels tres tipus de permisos per a un tipus d’usuari oscil·la des de zero (cap permís) fins a set (tots els permisos).

Per exemple:

|r|w|x|Binari|Decimal|Permisos|
|---|---|---|---|---|---|
|r|w|-|110|6|Lectura i escriptura, no execució.|
|r|-|x|101|5|Lectura i execució.|
|r|-|-|100|4|Solament lectura.|
|-|-|-|000|0|Cap permís.|

Els permisos "totals" d’un recurs consten de nou indicadors, on els tres primers indiquen els permisos associats a l’usuari propietari, els altres tres al grup i els últims 3 als altres.

|u|g|o|Valor octal|Valor octal|Valor octal|
|---|---|---|---|---|---|
|rw-|rw-|rw-|6|6|6|
|rwx|rwx|---|7|7|0|
|rw-|r--|r--|6|4|4|
|rwx|r-x|---|7|5|0|
|r--|---|---|4|0|0|

### [](#user-content-veure-els-permisos-dun-fitxer)Veure els permisos d’un fitxer

Per veure els permisos d’un fitxer es pot utlitzar la comanda _ls -l_, els permisos es mostren a través d’una cadena de 10 caràcters:

```
josep@odin:~/tmp$ ls -l
total 4
-rw-r--r-- 1 josep josep    0 sep 24 12:55 file2
drwxr-xr-x 2 josep josep 4096 oct  2 13:14 tmp1
```

El primer caràcter indica el tipus de recurs, i pot ser:

- d : directori
    
- l : enllaç
    
- b : dispositiu de bloc
    
- c : dispositiu de caràcters
    
- s : socket
    
- p : pipe
    
- - : fitxer regular
    

Els caràcters 2,3 i 4 indiquen els permisos pel propietari del recurs.

Els caràcters 5,6 i 7 indiquen els permisos pel grup del recurs.

Els caràcters 8,9 i 10 indiquen els permisos per a la resta d’usuaris.

### [](#user-content-canviar-els-permisos-dun-recurs)Canviar els permisos d’un recurs

Per canviar els permisos d’un recurs s’utilitza la comanda **chmod**.

Sintaxi:

chmod [opcions] <permisos> <fitxers>

Les formes d’expressar els nous permisos són diverses, es poden usar nombres o caràcters per indicar els permisos. Podrem comprendre millor com funciona l’ordre mirant directament alguns exemples:

1. Afegeix el permís d’execució (+x) a l’usuari propietari (u) del fitxer classe.txt.
    
    chmod u+x file.txt
    
2. Assigna exactament els permisos de lectura i execució (rx) al grup (g) sobre el fitxer program.sh.
    
    chmod g=rx program.sh
    
3. Elimina el permís d’escriptura (-w) en el grup i en altres (go) del fitxer o directori profile.
    
    chmod go-w profile
    
4. Afegeix el permís de lectura (+r) para tots els usuaris (a) i elimina el d’execució (-x) para uns altres (o) en tots els fitxers acabats en .ts.
    
    chmod a+r,o-x *.ts
    
5. Afegeix el permís especial t al directori tmp.
    
    chmod +t tmp/
    
6. Assigna els permisos amb representació octal 755 (rwx r-x r-x) al fitxer /home/bob/doc.
    
    chmod 755 /home/bob/doc/
    
7. Afegeix el permís de lectura a altres en el directori _apps_ i a més ho fa de forma recursiva, afegint aquest permís també en tots els fitxers i directoris continguts en apps.
    
    chmod -R o+r apps/
    
8. Assigna els permisos amb representació octal 4511 (r-s—​x—​x)
    
    chmod 4511 /usr/bin/passwd
    
9. Lectura i escriptura per a l’usuari, lectura per al grup i lectura per a altres.
    
    chmod 644
    

### [](#user-content-permisos-per-defecte)Permisos per defecte

Quan es crea un fitxer o un directori s’estableixen per defecte una sèrie de permisos. Aquests permisos per defecte estan determinats per una màscara anomenada _umask_.

La mascara especifica els permisos que **no** es volen establir per defecte.

Per ajustar la màscara es pot emprar la comanda -umask_.

Sintaxi:

umask [-S] [màscara]

Exemples:

1. Sense arguments mostra la màscara actual en format numèric.
    
    ```
    josep@odin:~$ umask
    0022
    ```
    
2. Mostrar el complement de la màscara en format caràcters
    
    ```
    josep@hades:~$ umask -S
    u=rwx,g=rx,o=rx
    ```
    
3. Assigna la màscara 37
    
    ```
    josep@hades:~$ umask 37
    ```
    
4. Assignem el complement de la màscara (umask 002)
    

josep@hades:~$ umask o=rwx,g=rwx,o=rx

La màscara per defecte és 0022 però atenció:

|   |   |
|---|---|
||Els **fitxers** nous creats en Linux **mai** són executables per defecte independentment del valor de _umask_.<br><br>Per tant un umask 0022, **per un fitxer**, és equivalent a un umask 0033 per un fitxer, per un directori no.|

### [](#user-content-especificar-propietaris-i-grups-dun-recurs)Especificar propietaris i grups d’un recurs

La comanda _chown_ permet establir el propietari i el grup d’un fitxer o d’un directori.

Sintaxi:

chown ⟨user name⟩[:][⟨group name⟩] ⟨file⟩ …

o bé

chown :⟨group name⟩ ⟨file⟩ …

Per assignar fitxers a usuaris o grups cal tenir permissos de root, la comanda _chgrp_ permet canviar el grup d’un fitxer com un usuari normal sempre i quan **qui fa el canvi és el propietari i és membre del nou grup**.

Sintaxi:

chgrp ⟨group name⟩ ⟨file⟩ …

### [](#user-content-permisos-especials)Permisos especials

#### [](#user-content-permisos-s-i-s)Permisos S i s

Per a la seva representació a través de caràcters **s’utilitza el lloc del permís d’execució del propietari o del grup** i d’aquí la diferència entre s i S:

- Si és **s** (minúscula) significa que inclou a més el permís d’execució (x i s)
    
- Si és **S** inclou solament el permís (s) i no el x.
    

Es pot associar a un fitxer o a un directori:

- Si s’associa a un **fitxer** significa que quan aquest s’executi per un usuari que tingui permisos d’execució, el fitxer adquirirà els permisos del seu propietari. Aquest bit s’anomena **setuid**.
    
    Es pot habilitar amb:
    
    ```
    josep@odin:~$ sudo chmod u+s file1
    ```
    
    O bé:
    
    ```
    josep@odin:~$ sudo chmod 4777 file1
    ```
    
    Un exemple de fitxer amb aquest permís és la comanda _passwd_, que adquireix els permisos de _root_ en ser executada pels usuaris (sense arguments) per poder modificar el fitxer _/etc/shadow_ que és on es guarden les contrasenyes dels usuaris.
    
    ```
    josep@odin:~$ ls -l /usr/bin/passwd
    -rwsr-xr-x 1 root root 59680 may 17  2017 /usr/bin/passwd
    ```
    
- Per al cas d’un **directori** aquest bit garanteix que tots els fitxers que es troben dintre d’un directori pertanyen al grup propietari del directori.
    
    Aquest bit es mostra a la mateixa posició que el bit **x** del **propietari del grup** amb una **s** si **x** està habilitat i amb una **S** si **x** no està habilitat.
    
    Un exemple de directori amb aquest permís és aquell on es guarden els documents d’un lloc FTP anònim. Aquest permís es coneix com **setgid** bit o *setgid bit, per a l’usuari i el grup respectivament.
    
    Es pot habilitar amb:
    
    ```
    josep@odin:~$ sudo chmod g+s dir1
    ```
    
    O bé:
    
    ```
    josep@odin:~$ sudo chmod 2775 dir1
    ```
    

|   |   |
|---|---|
||És un permís que de no administrar-se correctament pot provocar problemes de seguretat.|

#### [](#user-content-permisos-t-i-t)Permisos T i t

Per a la seva representació a través de caràcters **s’utilitza el lloc del permís d’execució d' altres** i d’aquí la diferència entre s i S:

- Si és **t** (minúscula) significa que inclou a més el permís d’execució (x i t)
    
- Si és **T** inclou solament el permís (t) i no el x.
    

Quan està associat a un **directori** al costat del permís d’escriptura per a un grup d’usuaris, indica que aquests usuaris poden escriure nous fitxers en el directori però aquests només podran ser esborrats pel propietari o per root.

Exemple d’un directori amb aquest permís és /tmp on tots els usuaris poden escriure però només el propietari i root pot esborrar els seus fitxers. Aquest permís es coneix també com **sticky bit**.

```
josep@hades:~$ ls -ld /tmp
drwxrwxrwt 9 root root 4096 oct 17 15:03 /tmp
```

|   |   |
|---|---|
||Si està associat a un fitxer, el permís expressa que el sue contingut s’emmagatzema en memòria swap per ser accedit amb major rapidesa.<br><br>Aquest bit associat a fitxers està obsolet i actualment no s’utilitza.|

Es pot habilitar amb:

```
bob@odin:~$ chmod +t dir1
```

O bé:

```
josep@odin:~$ chmod 1775 dir1
```

|   |   |
|---|---|
||Aquests permisos s i t són una causa freqüent de problemes, i són insegurs de per si, per la qual cosa és molt recomanable no usar-los tret que sigui estrictament necessari.|

#### [](#user-content-resum-dels-permisos-especials)Resum dels permisos especials

Table 1. Permisos especials
||setuid|setgid|sticky bit|
|---|---|---|---|
|notació|s - S|s - S|t -T|
|assignació|u+s|g+s|+t|
|recurs|fitxer|directori|directori|