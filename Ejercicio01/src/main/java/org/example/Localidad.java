package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase que representa la localidad en la que trabajan los jardineros
 */
@Data
public class Localidad {

    List<Boolean> jardin;

    public Localidad(int numJardin) {
        this.jardin = new ArrayList<>(); // inicializa el jardin

        for (int i = 0; i < numJardin; i++) { // añade las posiciones del jardin como libres (false)
            jardin.add(false);
        }
    }

    /**
     * Comienza a trabajar en una posicion aleatoria del jardin
     * @return posicion del jardin en el que comienza a trabajar
     */
    public synchronized int trabajando(){
        int posicion; // posicion del jardin en el que comienza a trabajar

        do{
            posicion = (int) (Math.random() * jardin.size()); // posicion aleatoria

            if (!jardin.get(posicion)){ // si la posicion esta libre la ocupa
                jardin.set(posicion, true); // ocupa la posicion

            }
        }while (!jardin.get(posicion));    // si la posicion esta ocupada busca otra

        System.out.println("El: " + Thread.currentThread().getName()
                + " esta trabajando en la posicion: " + posicion); // mensaje de que esta trabajando

        return posicion; // devuelve la posicion en la que esta trabajando
    }

    /**
     * Termina de trabajar en la posicion indicada
     * @param posicion posicion del jardin en el que termina de trabajar
     */
    public synchronized void terminar(int posicion){
        jardin.set(posicion, false); // libera la posicion en la que estaba trabajando

        System.out.println("El: " + Thread.currentThread().getName()
                + " ha terminado de trabajar en la posicion: " + posicion); // mensaje de que ha terminado
    }

}
