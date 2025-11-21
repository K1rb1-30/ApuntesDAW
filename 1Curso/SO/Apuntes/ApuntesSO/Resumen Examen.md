
### 1. **Puertas Lógicas**:

Las puertas lógicas son componentes fundamentales en la electrónica digital y la computación. Se utilizan para realizar operaciones lógicas con valores binarios (0s y 1s). Las puertas más comunes son:

- **AND**: Solo da "1" si ambas entradas son "1".

- **OR**: Da "1" si al menos una entrada es "1".

- **NOT**: Invierte el valor de la entrada (de "0" a "1" o de "1" a "0").

- **XOR**: Da "1" si las entradas son diferentes (una es "1" y la otra "0").

- **NAND**: Es la inversa de AND.

- **NOR**: Es la inversa de OR.

Estas puertas son los bloques básicos para construir circuitos más complejos en sistemas electrónicos y computadoras.

### 2. **Binario/Decimal/Otros Tipos – Cambio de Bases**:

El sistema binario (base 2) utiliza solo dos dígitos: 0 y 1, mientras que el sistema decimal (base 10) utiliza diez dígitos: 0 a 9. Los sistemas operativos y las computadoras generalmente manejan datos en binario, pero es común necesitar convertir entre diferentes bases.

- **Conversión de binario a decimal**: Se realiza multiplicando cada dígito binario por una potencia de 2, dependiendo de su posición.  
    Ejemplo:
    
    - 110 (base 2) = 1×22+1×21+0×201 \times 2^2 + 1 \times 2^1 + 0 \times 2^01×22+1×21+0×20 = 4 + 2 + 0 = 6 (base 10).
        
- **Conversión de decimal a binario**: Se divide el número decimal por 2 y se anotan los restos en orden inverso.  
    Ejemplo:
    
    - 6 (base 10) = 110 (base 2).
        

Además de binario y decimal, existen otros sistemas como el octal (base 8) y hexadecimal (base 16), que se usan en programación y computación para representar números de manera más compacta.

### 3. **Shift** (Desplazamiento de bits):

El _shift_ es una operación de desplazamiento de bits en un número binario. En la práctica, se usa para multiplicar o dividir un número por potencias de 2 de manera eficiente.

- **Shift a la izquierda (<<)**: Desplaza los bits hacia la izquierda, lo que es equivalente a multiplicar el número por 2 por cada posición que se desplace.  
    Ejemplo:
    
    - 3 (base 10) → 11 (base 2)
        
    - Si aplicamos un "shift" a la izquierda, tenemos 110 (base 2), que es 6 (base 10). **Multiplicamos por 2**.
        
- **Shift a la derecha (>>)**: Desplaza los bits hacia la derecha, lo que es equivalente a dividir el número por 2 por cada posición que se desplace.  
    Ejemplo:
    
    - 12 (base 10) → 1100 (base 2)
        
    - Si aplicamos un "shift" a la derecha, obtenemos 110 (base 2), que es 6 (base 10). **Dividimos por 2**.
        

### 4. **Arquitectura Von Neumann**:

Es un modelo de arquitectura de computadoras en el que el procesamiento de datos y las instrucciones se almacenan en la misma memoria. Esto significa que el CPU (procesador) obtiene tanto los datos como las instrucciones del mismo espacio de memoria, lo que simplifica el diseño de los sistemas. La arquitectura Von Neumann está basada en estos componentes principales:

- **Unidad de Control**: Dirige las operaciones.
    
- **Unidad Aritmético Lógica (ALU)**: Realiza cálculos y operaciones lógicas.
    
- **Memoria**: Almacena instrucciones y datos.
    
- **Dispositivos de Entrada/Salida (E/S)**: Interactúan con el usuario o con otros dispositivos.
    

### 5. **DNA** (Direct Memory Access):

El acceso directo a memoria (DMA) es una técnica que permite a los dispositivos de entrada/salida (como discos duros o tarjetas de red) acceder directamente a la memoria del sistema sin pasar por el procesador. Esto mejora la eficiencia, ya que el procesador no necesita intervenir en cada transferencia de datos, lo que libera recursos para otras tareas.

### 6. **Memorias**:

Las memorias son componentes esenciales en los sistemas operativos y en las computadoras. Se dividen principalmente en dos tipos:

- **Memoria RAM** (Memoria de acceso aleatorio): Es volátil, lo que significa que pierde su contenido cuando se apaga el dispositivo. Se usa para almacenar datos temporales y programas en ejecución.
    
- **Memoria ROM** (Memoria de solo lectura): Es no volátil y contiene instrucciones críticas para el arranque y funcionamiento básico del sistema.
    

Además de estas, existen otros tipos de memoria como la memoria caché (más rápida que la RAM) y los discos duros o SSD (para almacenamiento a largo plazo).

### 7. **DMA (Direct Memory Access)**:

DMA es una técnica que permite a los periféricos del sistema, como dispositivos de entrada/salida (teclados, discos, tarjetas de red, etc.), acceder directamente a la memoria RAM sin la intervención del procesador. Esto optimiza el rendimiento porque reduce la carga en el CPU y acelera la transferencia de datos entre dispositivos y memoria.

### Videos sobre **DMA**:

Los videos sobre DMA generalmente explican cómo este proceso permite a los dispositivos transferir datos de manera más eficiente, liberando al procesador de tareas repetitivas. Esto es clave en sistemas donde la transferencia de grandes volúmenes de datos es común (como en redes o almacenamiento).



