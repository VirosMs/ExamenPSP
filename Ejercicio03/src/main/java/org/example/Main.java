package org.example;

import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Primero comando:");
        String cmd1 = scanner.nextLine();
        System.out.println("Segundo comando:");
        String cmd2 = scanner.nextLine();


        ProcessBuilder pb1;
        ProcessBuilder pb2 = new ProcessBuilder(cmd2.split(" "));
        try {
            pb1 = new ProcessBuilder(cmd1.split(" "));


            Process primeroProceso = pb1.start();
            BufferedReader leer = new BufferedReader(new InputStreamReader(primeroProceso.getInputStream()));


            String salidaProceso = getSalidaProceso(leer);

            Process p2 = pb2.start();


            escribir(p2, salidaProceso);


            leer(p2);

        } catch (Exception e) {
            System.err.println("Exception:" + e.getMessage());
        }
    }

    /**
     * Obtiene la salida del proceso
     * @param leer proceso
     * @return salida del proceso
     * @throws IOException excepcion
     */
    private static String getSalidaProceso(BufferedReader leer) throws IOException {
        String linea; // Variable para leer el proceso
        String salidaProceso = ""; // Variable para leer el proceso
        while ((linea = leer.readLine()) != null) { //Leemos el proceso
            salidaProceso+=linea+"\r\n"; //Leemos el proceso
        }
        return salidaProceso;  //Leemos el proceso
    }

    /**
     * Lee el proceso
     * @param p2 proceso
     * @throws IOException excepcion
     */
    private static void leer(Process p2) throws IOException {
        String linea; // Variable para leer el proceso
        BufferedReader leer = new BufferedReader(new InputStreamReader(p2.getInputStream())); //Leemos el proceso
        while ((linea = leer.readLine()) != null) { //Leemos el proceso
            System.out.println(linea); //Leemos el proceso
        }
    }

    /**
     * Escribe en el proceso
     * @param p2 proceso
     * @param salidaProceso salida del proceso
     * @throws IOException excepcion
     */
    private static void escribir(Process p2, String salidaProceso) throws IOException {
        BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream())); //Escribimos en el proceso
        escribir.write(salidaProceso); //Escribimos en el proceso
        escribir.close(); //Cerramos el proceso
    }
}
