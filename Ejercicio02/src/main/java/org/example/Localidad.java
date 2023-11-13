package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;


/**
 * Clase que representa la localidad en la que trabajan los jardineros y hacen las reclamaciones los ciudadanos
 *
 * @see Jardin
 *
 * @version 2.0
 * @since 2023-11-09
 * @author Charles Arruda Santos
 */
@Data
public class Localidad {

    List<Jardin> jardin;

    public Localidad(int numJardin) {
        this.jardin = new ArrayList<>(); // inicializa el jardin

        for (int i = 0; i < numJardin; i++) { // añade las posiciones del jardin como libres (false)
            jardin.add(new Jardin(i));
        }
    }

    /**
     * Comienza a trabajar en una posicion aleatoria del jardin
     * @return posicion del jardin en el que comienza a trabajar
     */
    public synchronized int trabajando() {
        int posicion; // posicion del jardin en el que comienza a trabajar


        do {
            posicion = getRandonJardin(); // obtiene una posicion aleatoria del jardin

        } while (jardin.get(posicion).isOcupado());    // si la posicion esta ocupada busca otra

        jardin.get(posicion).trabajar(); // ocupa la posicion en la que va a trabajar

        System.out.println("El: " + Thread.currentThread().getName()
                + " esta trabajando en la posicion: " + posicion); // mensaje de que esta trabajando

        return posicion; // devuelve la posicion en la que esta trabajando
    }

    /**
     * Termina de trabajar en la posicion indicada
     * @param posicion posicion del jardin en el que termina de trabajar
     */
    public synchronized void terminar(int posicion){
        jardin.get(posicion).terminar(); // libera la posicion en la que estaba trabajando

        System.out.println("El: " + Thread.currentThread().getName()
                + " ha terminado de trabajar en la posicion: " + posicion); // mensaje de que ha terminado
    }

    /**
     * Devuelve una posicion aleatoria del jardin
     * @return posicion aleatoria del jardin
     */
    public int getRandonJardin(){
        return (int) (Math.random() * jardin.size()); // devuelve una posicion aleatoria del jardin
    }

    /**
     * Devuelve si la posicion indicada esta limpia
     * @param posicion posicion del jardin que se quiere mirar
     * @return true si la posicion esta limpia, false en caso contrario
     */
    public boolean isJardinLimpio(int posicion){
        return jardin.get(posicion).mirarSiEstaLimpio(); // devuelve si la posicion indicada esta limpia
    }

    /**
     * Clase que representa un jardin de la localidad
     * @Data: genera los getters, setters, toString, equals y hashCode
     *
     */
    @Data
    static class Jardin{

        private int id; // identificador del jardin
        private boolean ocupado; // indica si el jardin esta ocupado
        private long ultimaVezLimpio; // ultima vez que se limpio el jardin

        public Jardin(int id) {
            this.id = id; // inicializa el identificador
            this.ocupado = false; // inicializa el jardin como libre
            this.ultimaVezLimpio = 0L; // inicializa la ultima vez que se limpio el jardin
        }

        /**
         * Comienza a trabajar en el jardin
         */
        public synchronized void trabajar(){
            this.ocupado = true; // indica que el jardin esta ocupado
        }

        /**
         * Termina de trabajar en el jardin
         */
        public synchronized void terminar(){
            this.ocupado = false; // indica que el jardin esta libre
            this.ultimaVezLimpio = currentTimeMillis(); // actualiza la ultima vez que se limpio el jardin
        }

        /**
         * Devuelve si el jardin esta limpio
         * @return true si el jardin esta limpio, false en caso contrario
         */
        public synchronized boolean mirarSiEstaLimpio(){
            return (currentTimeMillis() - this.ultimaVezLimpio) <= 2000L; // devuelve si el jardin esta limpio
        }
    }
}
