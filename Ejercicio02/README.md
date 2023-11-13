# Simulador de jardineros
_Autor: **Charles Arruda Santos**_

Este programa simula cómo 3 jardineros y 5 ciudadanos hacen trabajos en 10 jardines de una localidad. 
Los jardineros escogen un jardín, lo trabajan y pasan a trabajar en otro jardín. 
En cualquier momento dado sólo habrá un jardinero por jardín. 
Los ciudadanos iran en jardines aleatorios para comprobar si esta limpio, si no esta limpio hacen una reclamacion. 
Los ciudadanos visitan a cada 2 dias un jardin y se quedan medio dia en el mismo.
Trabajar en un jardín cuesta un día y la simulación dura 30 días. Cada día de la simulación equivale a 1 segundo real.
- -------------------
## Funcionamiento



El programa funciona de la siguiente manera:

* Hay 10 jardines y 3 jardineros.
* Los jardineros empiezan a trabajar:
    * Buscan un jardín libre de manera aleatoria. No debe estar siendo trabajado en este momento por otro jardinero.
    * Empiezan a trabajarlo (durante un día / segundo)
    * Terminan liberando el jardín.
* Los ciudadanos visitan los jardines cada 2 días.
    * Eligen un jardín al azar.
    * Si el jardín está en mal estado, hacen una queja.
    * Pasan medio día en el jardín.
3. El programa principal espera a que hayan terminado todos los hilos.

- -------------------
## Salida

El programa muestra la siguiente información:

* Cada hilo mostrará el siguiente mensaje cuando se empiece a trabajar en un jardín: “El jardinero 3 ha empezado a trabajar en el jardín 9”. Siendo 3 el identificador único del hilo y 9 el identificador numérico que asignamos a mano a cada jardín.
* Cada hilo mostrará el fin de los trabajos de cada jardinero. Por ejemplo: “El jardinero 3 ha terminado de trabajar en el jardín 9”. Siendo 3 el identificador único del hilo y 9 el identificador numérico que asignamos a mano a cada jardín.
* El programa principal esperará que finalice la simulación, mostrará cuántos jardines ha trabajado cada jardinero y cuántas quejas han hecho los ciudadanos. Por ejemplo: “El jardinero 3 ha trabajado 30 jardines” y “El jardín 12 está en mal estado”.
- -------------------

## Modificaciones

Este programa se puede modificar de varias maneras, por ejemplo:

* Se puede cambiar el número de jardineros, número de ciudadanos o el número de jardines.
* Se puede cambiar el tiempo de duración de la simulación.
* Se puede cambiar el comportamiento de los jardineros, por ejemplo, haciendo que elijan los jardines de manera diferente.
* Se puede cambiar el comportamiento de los ciudadanos, por ejemplo, haciendo que reclamen de los jardines de manera diferente.

- --------------------
## Ejemplo de salida

- El jardinero 1 ha empezado a trabajar en el jardín 1
- El jardinero 2 ha empezado a trabajar en el jardín 2
- El jardinero 3 ha empezado a trabajar en el jardín 3
* ...
- El jardinero 1 ha terminado de trabajar en el jardín 1
- El jardinero 2 ha terminado de trabajar en el jardín 2
- El jardinero 3 ha terminado de trabajar en el jardín 3
* ...

* **Respecto a los Trabajadores:**
  - El jardinero 1 ha trabajado 30 jardines.
  - El jardinero 2 ha trabajado 30 jardines.
  - El jardinero 3 ha trabajado 30 jardines.
* **Respecto a las Quejas recibidas:**
  - El jardín 3 está en mal estado.
  - El jardín 12 está en mal estado.

- -------------------
## Ejecución del programa

_Consejo :
  Ejecunta desde una IDE que es mas sencillo._
* ### Por consola
   + Compilación del programa, 
   + hay que estar en la carpeta donde se encuentra el archivo `Ciudadanos.java`, y ejecutar el siguiente comando:
      ```javac Ciudadanos.java```
     + hay que estar en la carpeta donde se encuentra el archivo `Jardinero.java`, y ejecutar el siguiente comando:
      ```javac Jardinero.java```
     + hay que estar en la carpeta donde se encuentra el archivo `Localidad.java`, y ejecutar el siguiente comando:
      ```javac Localidad.java```
     + hay que estar en la carpeta donde se encuentra el archivo `Main.java`, y ejecutar el siguiente comando:
      ```javac Main.java```
     
    + Ejecución del programa, hay que estar en la carpeta donde se encuentra el archivo `Main.class`, y ejecutar el siguiente comando:
      ```java Main```
* ### Por IDE
  * Abrir el proyecto en un IDE y ejecutar el archivo `Main.java`
