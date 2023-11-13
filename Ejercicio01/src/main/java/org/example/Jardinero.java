package org.example;


import lombok.Data;
import lombok.EqualsAndHashCode;

import static java.lang.System.currentTimeMillis;


/**
 * Clase que representa a los jardineros
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class Jardinero extends Thread{

    private Localidad localidad;
    private int count = 0;

    public Jardinero(Localidad localidad) {
        this.localidad = localidad; // inicializa la localidad
    }

    @Override
    public void run() {
        long empieza = currentTimeMillis();
        while ((currentTimeMillis() - empieza) < Main.TIEMPO) { // mientras no haya pasado el tiempo limite NO termina
            try{
                int posicion = localidad.trabajando(); // comienza a trabajar en una posicion aleatoria

                count++; // incrementa el numero de veces que ha trabajado

                sleep(1000L); // duerme 1 segundo

                localidad.terminar(posicion); // termina de trabajar en la posicion indicada

            }catch (InterruptedException e){
                System.out.println("Error en el hilo jardinero :\n"+ e.getMessage());
            }
        }
    }
}


