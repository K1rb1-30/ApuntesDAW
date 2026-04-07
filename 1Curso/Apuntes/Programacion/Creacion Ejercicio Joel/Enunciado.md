
**El Goummage a Expedition 33**

En el món d’_Expedition 33_, la Paintresse marca cada any un número que indica l’edat a la qual les persones es desvanèixen pel Goummage. Cada any que passa, aquest número disminueix en una unitat, de manera que una persona es desvanec quan el número del Goummage coincideix amb la seva edat.

Davant d’aquesta amenaça, la humanitat organitza expedicions anuals amb l’objectiu d’arribar fins a la Paintresse i intentar aturar-la perquè deixi de pintar números. Cada expedició representa un intent desesperat de canviar el destí. L’expedició 0 correspon a l’any actual, l’expedició 1 al següent, i així successivament.

Cada persona s’uneix a l’expedició que coincideix amb els anys que li queden abans que el Goummage arribi a la seva edat.

**Entrada**

La primera línia conté un enter _T_ que indica el nombre de casos de prova.

Per a cada cas:

- Una línia amb dos enters:
    
    - _N_: nombre de persones
        
    - _G_: número actual del Goummage
        
- Segueixen _N_ línies, cadascuna amb:
    
    - Nom de la persona (sense espais)
        
    - Edat actual
        

**Sortida**

Per a cada cas de prova:

1. Mostra un array amb el nom i edat de totes les persones en el format:  
    `[Nom1(edat1), Nom2(edat2), ...]`
    
2. Després, per cada persona (en el mateix ordre), una línia amb:  
    `Nom -> es desvanec a edat X, expedició Y`
    

On:

- _Y_ és el número d’anys fins que es desvanec (expedició)
    
- _X_ és l’edat en aquell moment
    

Tenint en compte que cada any:

- El Goummage baixa: `G - Y`
    
- L’edat puja: `edat_actual + Y`
    

La condició és:  
`G - Y = edat_actual + Y`

D’on:  
`Y = (G - edat_actual) / 2`

(Sempre es garanteix que el resultat serà enter)

**Exemple d’Entrada**

```id="9z3mqa"
1
3 30
Alice 20
Bob 26
Clara 30
```

**Exemple de Sortida**

```id="k2x8dw"
[Alice(20), Bob(26), Clara(30)]
Alice -> es desvanec a edat 25, expedició 5
Bob -> es desvanec a edat 28, expedició 2
Clara -> es desvanec a edat 30, expedició 0
```

---

Ahora sí:

- Es **fiel al funcionamiento real del Goummage**
    
- Introduce una **ecuación interesante (nivel medio)**
    
- Sigue siendo totalmente programable en Java sin complicaciones
    

Si quieres, puedo ajustarlo a dificultad fácil/media/difícil según lo que te pida la plataforma.