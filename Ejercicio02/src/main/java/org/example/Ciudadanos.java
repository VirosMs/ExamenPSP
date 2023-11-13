package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;

/**
 * Clase que representa la localidad en la que trabajan los jardineros
 *
 * @see Localidad
 *
 * @version 1.0
 * @since 2023-11-09
 * @author Charles Arruda Santos
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Ciudadanos extends Thread{
    private Localidad localidad; // localidad en la que hacen las reclamaciones a los jardineros (compartida)
    private List<String> reclamaciones; // lista de reclamaciones

    public Ciudadanos(Localidad localidad) {
        this.localidad = localidad; // inicializa la localidad
        this.reclamaciones = new ArrayList<>(); // inicializa la lista de reclamaciones
    }

    @Override
    public void run() {
        long empieza = currentTimeMillis(); // tiempo en el que comienza a ejecutarse el hilo

        while ((currentTimeMillis() - empieza) < Main.TIEMPO && Thread.currentThread().isAlive()){ // mientras no haya pasado el tiempo limite NO termina
            try{
                sleep(2000L); // duerme 2 segundos

                int posicion = localidad.getRandonJardin(); // obtiene una posicion aleatoria del jardin

                if(!localidad.isJardinLimpio(posicion)){ // si la posicion no esta limpia la reclama


                    reclamaciones.add("El Jardin " + localidad.getJardin().get(posicion).getId()
                            + " está en mal estado reclamado por el " + Thread.currentThread().getName()
                            + " -> Dia: " + (currentTimeMillis()- empieza)/1000%Main.TIEMPO); // añade la reclamacion a la lista
                }

                sleep(500L); // duerme 0.5 segundos

            }catch (InterruptedException e){
                System.out.println("Error en el hilo ciudadano :\n"+ e.getMessage());
            }
        }
    }
}
