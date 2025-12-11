## Modelo relacional



PERSONA\_F(**fitxaDirectiva**, nom, cognom1, cognom2)

PK: fitxaDirectiva



GIMNASTA(**fitxaDirectiva,** dta\_naixament, nom\_club, entrenadora, suplent)

PK: fitxaDirectiva

FK: fitxaDirectiva -> PERSONA\_F

FK: nom\_club -> CLUB

FK: entrenadora -> ENTRENADORA

FK: suplent -> GIMNASTA



ENTRENADORA(**fitxaDirectiva,** DNI, titulació, adreça)

PK: fitxaDirectiva

FK: fitxaDirectiva -> PERSONA\_F



JUTGE (**fitxaDirectiva,** DNI, titulació, adreça)

PK: fitxaDirectiva

FK: fitxaDirectiva -> PERSONA\_F



CLUB(**nom,** adreça, provincia, president, fitxa\_)

PK: nom



TREBALLAR(**fitxa\_entrenadora, nom\_club, data\_inici**, data\_fi)

PK: (fitxa\_entrenadora, nom\_club, data\_inici)

FK: fitxa\_entrenadora -> ENTRENADORA

FK: nom\_club -> CLUB



IDIOMA(idioma)

PK: idioma



PARLA(**tipus\_idioma, jutgessa**)

PK: **(tipus\_idioma, jutgessa)**

**FK:** tipus\_idioma -> IDIOMA

FK: jutgessa -> JUTGE



EXERCICI(tipus\_exercici)

PK: tipus\_exercici



QUALIFICACIO(tipus\_exercici, jutge, gimnasta, nota)

PK: (tipus\_exercici, jutge, gimnasta)

FK: tipus\_exercici -> EXERCICI

FK: jutge -> JUTGE

FK: gimnasta -> GIMNASTA









