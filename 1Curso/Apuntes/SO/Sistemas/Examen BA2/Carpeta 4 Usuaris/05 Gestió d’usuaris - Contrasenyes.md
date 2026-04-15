## Comandes Linux - Gestió d’usuaris - Contrasenyes

### [](#user-content-passwd)passwd

La comanda _passwd_ permet establir la contrasenya d’un usuari.

```
josep@hades:~$ passwd
Cambiando la contraseña de josep.
(actual) contraseña de UNIX:
Introduzca la nueva contraseña de UNIX:
Vuelva a escribir la nueva contraseña de UNIX:
Debe elegir una contraseña más larga
Introduzca la nueva contraseña de UNIX:
Vuelva a escribir la nueva contraseña de UNIX:
Bad: new password cannot be a palindrome
Introduzca la nueva contraseña de UNIX:
Vuelva a escribir la nueva contraseña de UNIX:
Bad: new password is just a wrapped version of the old one
passwd: Error de manipulación del testigo de autenticación
passwd: no se ha cambiado la contraseña
```

Executar la comanda sota root no demana la contrasenya antiga ni té les restriccions de seguretat de contrasenyes.

```
josep@hades:~$ sudo passwd bob
Introduzca la nueva contraseña de UNIX:
Vuelva a escribir la nueva contraseña de UNIX:
passwd: contraseña actualizada correctamente
```

### [](#user-content-fitxers-shadow)Fitxers shadow

Les contrasenyes dels usuaris s’encripten i s’emmagatzemen al fitxer _/etc/shadow_. Aquest fitxer és de només lectura i només és accessible per l’ususari root.

```
josep@hades:~$ sudo tail -4 /etc/shadow
user2:$6$77UM1uQj$lE1CJF/0kRT9D3UcbLOa7zBspgWZivQiwNJcMZrlBDDWcPQeSoekP.P.W2Esou0mF6IQ/.FUzEM/PW6gxTneL0:17802:0:99999:7:::
bob:$6$ALjDbUjU$ocd6PGz7suNHok1c/dZdBG1hXCewGESaGmfxhhbsp8lduPJMdN4CDMmqNjsbS0scR3CPQzM5oMG9hYNeYWTKX/:17807:0:99999:7:::
patricio:!:17807:0:99999:7:::
arenita:$6$yH4Dw9Bs$kYCa69KSaKpJMqUOlnMpgoCAxHKjGjVqvYXqwAUwSnkaLLIsk46B0QHdZdflVserIqOcxdHZxmFJZH7QStsA5.:17807:0:99999:7:::
```

Per interpretar el contingut del fitxer:

josep@hades:~$ man 5 shadow

### [](#user-content-etclogin-defs)/etc/login.defs

El fitxer _/etc/login.defs_ conté alguns dels valors per defecte pels passwords dels ususaris, la longitud, la caducitat, etc…​

```
josep@hades:~$ cat /etc/login.defs | grep PASS
#	PASS_MAX_DAYS	Maximum number of days a password may be used.
#	PASS_MIN_DAYS	Minimum number of days allowed between password changes.
#	PASS_WARN_AGE	Number of days warning given before a password expires.
PASS_MAX_DAYS	99999
PASS_MIN_DAYS	0
PASS_WARN_AGE	7
#PASS_CHANGE_TRIES
#PASS_ALWAYS_WARN
#PASS_MIN_LEN
#PASS_MAX_LEN
# NO_PASSWORD_CONSOLE
```

### [](#user-content-chage)chage

La comanda _chage_ es pot utilitzar per establir una data d’expiració d’un compte d’usuari **_-E_**, establir un mímin **_-m_** i un màxim **_-M_** de temps de vida de la contrasenya, una data d’expiració del password, etc…​

Molta de la seva funcionalitat coincideix amb la de la comanda _passwd_.

Per mostrar la configuració per un usuari fem _chage -l_.

```
josep@hades:~$ sudo chage -l bob
Último cambio de contraseña					:oct 03, 2018
La contraseña caduca					: nunca
Contraseña inactiva					: nunca
La cuenta caduca						: nunca
Número de días mínimo entre cambio de contraseña		: 0
Número de días máximo entre cambio de contraseña		: 99999
Número de días de aviso antes de que caduque la contraseña	: 7
```

### [](#user-content-deshabilitar-un-password)Deshabilitar un password

Les contrasenyes que es troben a _/etc/shadow_ no poden començar amb una exclamació.

Quan el segon camp comença amb un signe d’exclamació el password no es pot utilitzar, diem que el compte d’usuari està bloquejat, deshabilitat o suspès.

La manera més fàcil de deshabilitar un compte d’ususari és amb la comanda **_usermod -L_**.

```
josep@hades:~$ sudo grep bob /etc/shadow
bob:$6$ALjDbUjU$ocd6PGz7suNHok1c/dZdBG1hXCewGESaGmfxhhbsp8lduPJMdN4CDMmqNjsbS0scR3CPQzM5oMG9hYNeYWTKX/:17807:0:99999:7:::
josep@hades:~$ sudo usermod -L bob
josep@hades:~$ sudo grep bob /etc/shadow
bob:!$6$ALjDbUjU$ocd6PGz7suNHok1c/dZdBG1hXCewGESaGmfxhhbsp8lduPJMdN4CDMmqNjsbS0scR3CPQzM5oMG9hYNeYWTKX/:17807:0:99999:7:::

josep@hades:~$ su bob
Contraseña:
su: Fallo de autenticación
```

|   |   |
|---|---|
||L’usuari root podrà entrar al compte d’susuari de bob ja que no li cal el password.<br><br>```<br>josep@hades:~$ sudo su bob<br>bob@hades:/home/josep$<br>```|

|   |   |
|---|---|
||Si bob tingues un accés ssh sense password podria seguir entrant remotament al sistema encara que tingués el compte bloquejat.|