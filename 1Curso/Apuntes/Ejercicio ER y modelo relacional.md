

- [x] En una localitat propera a la nostra han començat a aparèixer importants restes arqueològiques i l’ajuntament ha decidit fer una excavació a veure què hi troben. Com que sembla que tot el territori és ple de jaciments els ajuntaments dels voltants també s’han afegit a la iniciativa. Ens han demanat que nosaltres els fem el disseny de la base de dades que necessiten per poder gestionar la seva organització a tot el territori.

  

- [x] De cada ajuntament guardarem el CIF, el nom complet, el nombre d’habitants, el nom de l’alcalde, el nom de la persona de contacte, el seu mail i el partit en el poder actualment.

  

- [x] De cada jaciment hem de guardar un codi que l’identifica, el nom complet, la seva extensió en metres quadrats i les coordenades GPS del seu punt central. Necessitem saber en quin terme municipal (ajuntament) està ubicat. Tots els ajuntaments de la nostre base de dades tenen un o més jaciments en el seu terme municipal.

  

- [x] Cada jaciment a excavar es divideix en unes quadrícules que identifiquen com les cel·les del joc dels vaixells (A2, C3, etc). De cadascuna d’elles han de guardar també l’extensió em metres quadrats i les coordenades GPS del seu punt central.

  

- [x] Les excavacions es porten a terme en campanyes anuals. Cada campanya hi ha una sèrie de patrocinadors (empreses que posen diners i subvencions d’entitats públiques com poden ser diputacions, ajuntaments , CCAA etc). Unes de les entitats públiques que més diners hi posen son els propis ajuntaments. Cal enregistrar quants diners ha posat cada patrocinador en cada campanya (any) per excavar cada jaciment. 

  

- [x] Dels patrocinadors particulars (empreses) guardem el nom, el CIF, el domicili fiscal, la persona de contacte , el seu mail i el sector productiu al quual es dediquen. De les entitats públiques guardem el CIF, el nom de l’entitat, la persona de contacte, el seu mail i el departament que concedeix la subvenció. Hi ha patrocinadors tan generosos que posen diners diversos anys i per a diversos jaciments. Cada excavació normalment té més d’un patrocinador.

  

- [x] En cada jaciment, en cada campanya, treballen uns quants arqueòlegs qualificats, una sèrie d’estudiants d’arqueologia que hi fan les pràctiques i una sèrie de persones voluntàries dels pobles. Cal saber quines persones treballen cada any a cada lloc.

  

- [x] Dels arqueòlegs hem de guardar el seu DNI o passaport, el número del compte corrent, el NSS, les dades personals habituals i la titulació que aporten. S’ha de dir que alguns estan tan qualificats que aporten més d’una titulació. Tots en tenen almenys una. 

  

- [x] Dels estudiants guardem el seu DNI o passaport, les dades personals habituals, la titulació que estan estudiant (de la que fan les pràctiques), la universitat on l’estan fent, el nom del seu tutor en la universitat i el nombre d’hores que han de fer de pràctiques en el seu grau. Malauradament a ells no els paguen.

  

- [x] No guardarem a la nostra base de dades titulacions que no tingui ningú o que ningú estigui estudiant.

  

- [x] Dels voluntaris guardem el DNI o passaport i les seves dades personals habituals. També necessitem saber si són majors o menors d’edat perquè als menors no els podem deixar sols (pot ser perillós) i els assignem sempre un altre voluntari major d’edat per supervisar-lo en cada campanya. Hem de poder conèixer aquestes assignacions per si hi ha cap problema. Tots els menors tindran un únic supervisor cada campanya però no tots els majors supervisaran a algú. Un major d’edat podria supervisar a més d’un menor alhora. Encara que siguin menors s’han de fer el DNI si volen col·laborar.

  

- [x] Els arqueòlegs titulats son els que dirigeixen les excavacions de cada jaciment. Podrien dirigir més d’una excavació alhora però cada jaciment només té un director. Cal tenir un històric que qui ha dirigit cada excavació cada campanya i cal guardar quant ha cobrat per fer-ho.

  

- [x] Als voluntaris se’ls assignen una o més quadrícules per excavar-les que podrien variar en les diverses campanyes. A tots els voluntaris se’ls assignen una o més quadrícules en cada campanya. En cada quadrícula poden treballar simultàniament diversos voluntaris. Per poder valorar el seu grau d’eficàcia guardem també el nombre de troballes (peces) que ha extret cada voluntari de cada quadrícula en cada campanya que ha excavat.

- [x] Dels estudiants cal saber en quins jaciments han treballat cada campanya (a ells no se’ls assignen quadrícules) i el nombre d’hores que han fet en cadascun cada any. Només treballen en un jaciment cada campanya i podrien treballar en el mateix jaciment en diverses campanyes.

**