/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

import java.util.Random;

/**
 * Ejercicio 4: Simulador de Máquina Tragaperras.
 *
 * @author Alba Esperanza Jiménez Mota
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //               Declaración de variables
        //----------------------------------------------
        // Variables de entrada 
        int numAleatorio;
        char fruta;

        // Variables de salida 
        int numIntentos, premio;
        String secuencia;

        /*  La clase Random es una clase de Java que nos sirve para generar elementos aleatorios.
            En este caso, el objeto "r", consigue a través de su método nextInt(número), generar
            un número aleatorio entero entre 0 y número-1; por ejemplo: r.nextInt(5) generará 
            un número entero entre 0 y 4, es decir, podrá devolver 0,1,2,3 o 4 cada vez que se 
            utilice.
         */
        Random r = new Random();

        //----------------------------------------------
        //              Entrada de datos
        //----------------------------------------------
        // En este caso, no hay entrada de datos. 
        System.out.println("Ejercicio 4. Simulador de Máquina Tragaperras.");
        System.out.println("----------------------------------------------");
        System.out.println("Voy a generar secuencias de 3 frutas entre Plátano(P), Fresa(F), Manzana(M), Naranja(N) y Cereza(C) hasta conseguir 3 iguales y te diré qué premio has obtenido de los cinco:");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /* 
           Hemos de generar una secuencia de 3 frutas.
           - Las frutas son: Plátano, Fresa, Manzana, Naranja, Cerezas 
           - Representamos cada fruta con un caracter: P,F,M,N,C
           - Para elegir una de las cinco frutas podemos asociar cada una con un número
           - Para ello podemos generar un número aleatorio 
           - El proceso debe hacerse hasta que se obtengan 3 iguales, cosa que suponemos que se producirá en x intentos. 
             Hemos de llevar la cuenta de los intentos.
         */
        numIntentos = 0;
        premio = 0;

        do {
            secuencia = ""; // Se reinicia la secuencia en cada intento

            for (int i = 0; i < 3; i++) {
                numAleatorio = r.nextInt(5);
                fruta = ' ';

                switch (numAleatorio) {
                    case 0:
                        fruta = 'P';
                        break;
                    case 1:
                        fruta = 'F';
                        break;
                    case 2:
                        fruta = 'M';
                        break;
                    case 3:
                        fruta = 'N';
                        break;
                    case 4:
                        fruta = 'C';
                        break;
                }
                secuencia += fruta;
            }
            switch (secuencia) {
                case "PPP":
                    premio = 1;
                    break;
                case "FFF":
                    premio = 2;
                    break;
                case "MMM":
                    premio = 3;
                    break;
                case "NNN":
                    premio = 4;
                    break;
                case "CCC":
                    premio = 5;
                    break;
                default:
                    break;
            }
            numIntentos++;
            System.out.println(numIntentos + " - " + secuencia);

        } while (premio == 0);

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        //Además de los intentos en los que se ha obtenido el premio, hay que decir qué premio hemos tenido de entre los posibles.
        System.out.println("Has conseguido el premio " + premio + " en el intento " + numIntentos + " con la secuencia: " + secuencia);

    }
}
