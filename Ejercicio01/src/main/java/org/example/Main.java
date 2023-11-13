package org.example;

/**
 * Clase Main
 *
 * @author Charles Arruda Santos
 * @version 1.0
 * @since 2023-11-09
 * @see Jardinero
 * @see Localidad
 */
public class Main {
    public static final long TIEMPO = 30000L; // tiempo limite de ejecucion de 30 segundos
    public static final int NUM_JARDINEROS = 3; // numero de jardineros
    public static final int NUM_JARDINES = 10; // numero de posiciones del jardin

    public static void main(String[] args) {

        Localidad localidad = new Localidad(NUM_JARDINES); // crea la localidad con el numero de posiciones indicadas

        Jardinero[] jardineros = new Jardinero[NUM_JARDINEROS]; // crea el array de jardineros con el numero indicado

        System.out.println("Comienza la ejecucion\n"); // mensaje de inicio

        for (int i = 0; i < NUM_JARDINEROS; i++) { // crea los jardineros y los inicia

            jardineros[i] = new Jardinero(localidad); // crea el jardinero

            jardineros[i].setName("Jardinero " + (i+1)); // le pone un nombre

            jardineros[i].start(); // lo inicia
        }

        for(int i = 0; i < NUM_JARDINEROS; i++){ // espera a que terminen todos los jardineros
            try{
                jardineros[i].join(); // espera a que termine el jardinero "i"
            }catch (InterruptedException e){
                System.out.println("Error en el hilo principal :\n"+ e.getMessage());
            }
        }

        System.out.println("\n\nTermina la ejecucion"); // mensaje de fin

        for (int i = 0; i < NUM_JARDINEROS; i++) { // muestra el numero de veces que ha trabajado cada jardinero

            System.out.println("El" + jardineros[i].getName()
                    + " ha trabajado " + jardineros[i].getCount() + " veces"); // mensaje de fin
        }
    }
}