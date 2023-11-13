# Simulador de jardineros

Este programa simula cómo 3 jardineros hacen trabajos en 10 jardines de una localidad. Los jardineros escogen un jardín, lo trabajan y pasan a trabajar en otro jardín. En cualquier momento dado sólo habrá un jardinero por jardín. Trabajar en un jardín cuesta un día y la simulación dura 30 días. Cada día de la simulación equivale a 1 segundo real.
- -------------------
## Funcionamiento

El programa funciona de la siguiente manera:

1. Hay 10 jardines y 3 jardineros.
2. Los jardineros empiezan a trabajar:
    * Buscan un jardín libre de manera aleatoria. No debe estar siendo trabajado en este momento por otro jardinero.
    * Empiezan a trabajarlo (durante un día / segundo)
    * Terminan liberando el jardín.
3. El programa principal espera a que hayan terminado todos los hilos.

- -------------------
## Salida

El programa muestra la siguiente información:

* Cada hilo mostrará el siguiente mensaje cuando se empiece a trabajar en un jardín: “El jardinero 3 ha empezado a trabajar en el jardín 9”. Siendo 3 el identificador único del hilo y 9 el identificador numérico que asignamos a mano a cada jardín.
* Cada hilo mostrará el fin de los trabajos de cada jardinero. Por ejemplo: “El jardinero 3 ha terminado de trabajar en el jardín 9”. Siendo 3 el identificador único del hilo y 9 el identificador numérico que asignamos a mano a cada jardín.
* El programa principal esperará que finalice la simulación y mostrará cuántos jardines ha trabajado cada jardinero.
- -------------------

## Modificaciones

Este programa se puede modificar de varias maneras, por ejemplo:

* Se puede cambiar el número de jardineros o el número de jardines.
* Se puede cambiar el tiempo de duración de la simulación.
* Se puede cambiar el comportamiento de los jardineros, por ejemplo, haciendo que elijan los jardines de manera diferente.

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
- El jardinero 1 ha trabajado 30 jardines.
- El jardinero 2 ha trabajado 30 jardines.
- El jardinero 3 ha trabajado 30 jardines.

- -------------------
## Ejecución del programa

* ### Por consola
   + Compilación del programa, 
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
