
package tarea04;

import java.util.Random;
import java.util.Scanner;

/**
 * Tarea Online 4. Ejercicio 2: Campo de regalos
 * @author Alba Esperanza Jiménez Mota
 * @version 1.0
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        
        // DEFINICIÓN DE VARIABLES
        // Variable que contiene un objeto tipo Random para generar valores aleatorios
        Random aleatorio = new Random();
        
        // Matriz de enteros para gestionar la partida de juego
        int[][] matriz ;
        
        // Variables auxiliares 
        int posicionCeros, miFila, miColumna;
        boolean avanceValido;
        
        // Variables de entrada
        String avance;
        
        // Variables de salida
        int bolsaPremios;
        
        // Variable que contiene un objeto tipo Scanner para gestionar la entrada de datos
        Scanner teclado = new Scanner(System.in);

     

        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
        
        
        /* 
         1. Creación de la Matriz
         Creamos una matriz bidimensional de 6x6 que será nuestro mapa, donde
         iremos recorriendo entre los premios
        */
        matriz = new int[6][6];

         /* 
           2. Generación de Premios 
           Se generan números aleatorios entre 100 y 200, que se asignarán a cada una
           una de las casillas, un premio aleatorio para cada casilla. Debemos recorrer
           la matriz y asignar los premios.
         */       
        for (int i = 0; i < matriz.length; i++) { // Este bucle recorre las filas
            for (int j = 0; j < matriz[i].length; j++) { // Este bucle recorre las columnas
                matriz[i][j] = aleatorio.nextInt(101)+100;
            }           
        }
        
         /* 
           3. Asignación de CEROS
           A partir de la segunda fila, elegimos aleatoriamente una posición entre 0 y 
            el número de columnas de cada fila. En esa posición para cada fila, 
           sobreescribimos el valor existente y asignamos un cero
         */
        for (int i = 1; i < matriz.length; i++) { // Este bucle recorre las filas
            posicionCeros = aleatorio.nextInt(matriz[i].length);
            matriz[i][posicionCeros] = 0;
        }

        /*
         4.1 Elección de columna de partida en la primera fila.
         Al igual que antes elegimos una posición aleatoria entre 0 y 
         el número de columnas de esa primera fila.
        */        
        miFila = 0;
        miColumna = aleatorio.nextInt(matriz[0].length);

        /*
         4.2 Sumar el premio existente en la casilla elegida a la bolsa de premios
        */
        bolsaPremios = matriz[miFila][miColumna];
        
        /*
         4.3 Cambiamos el valor de la casilla elegida "3", para posteriormente 
        poder mostrar una "A" en dicha casilla
        */
        matriz[miFila][miColumna] = 3;
        
        /* 5. Para realizar la  jugada mostraremos el mapa, así como la posición en la que se encuentra (fila y columna). 
           Posteriormente, se muestra al usuario los posibles movimientos que puede realizar
                - Si se está en la primera columna (0), evidemente sólo se podrá ir de frente o a la derecha
                - Si se está en la úlitma columna (longitud-1), evidemente sólo se podrá ir de frente o a la izquierda
                - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres posiciones (frente, derecha o izquierda)
           Se pregunta al usuario la dirección de su avance en función de sus posibilidades.
           Si el desplazamiento introducido no es correcto se volverá a repetir la solicitud de dirección           
        */           
            /*
             5.1 Mostrar el mapa actualmente
             Para recorrer el mapa por filas, se irá descubiendo cada una de las casillas
             El valor mostrado dependerá de si la casilla está descubierta o no, 
             presentando dos posibles casos, 
             - si la fila de la casilla es menor o igual a la que estamos mostraremos 
               la información según los cógigos establecidos en el enunciado.
             - Si la fila de la casilla es mayor a la que estamos actualmente, mostraremos una "X"            
            */   
        avanceValido = true;
        while(miFila < matriz.length - 1 && avanceValido){
            System.out.println("Mapa ACTUAL");
            mostrarMapa(matriz, miFila);
            System.out.println();
            
            /* 5.2 Se muestra el premio actual */
            System.out.printf("Tu premio actual es de: %d%n", bolsaPremios);
            
            /* 5.3 Se muestra la fila y columnas actuales*/
            System.out.printf("Te encuentras en la fila %d y en la posición %d%n", miFila + 1, miColumna);
            
            /* 5.4 Se genera un bucle para validar la entrada y elegir un valor 
               correcto, entre IZQUIERDA, DERECHA  o FRENTE. Sólo se mostrarán los 
               posibles movimientos en función de las posibilidades*/
            System.out.println("Elige posición a la que avanzar");
                          
           /* 5.4.1 Mostramos las posibilidades según la posición horizontal
                 *  - Si se está en la primera columna (0), evidentemente sólo se podrá ir de frente o a la derecha
                 *  - Si se está en la última columna (longitud-1), evidentemente sólo se podrá ir de frente o a la izquierda
                 *  - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres direcciones (frente, derecha o izquierda)
            */         
            do {
                if (miColumna == 0) {
                    System.out.println("Sólo puedes avanzar hacia la derecha o de frente (DERECHA o FRENTE)");
                } else if (miColumna == matriz[0].length - 1) {
                    System.out.println("Puedes avanzar hacia la izquierda o de frente (IZQUIERDA o FRENTE)");
                } else {
                    System.out.println("Puedes avanzar hacia la izquierda, derecha o de frente (IZQUIERDA, DERECHA o FRENTE)");
                }

                /* 5.4.2 Leemos los valores de teclado. Para simplificar errores, 
               hacemos que la entrada NO sea case sensitive 
                 */
                avance = teclado.nextLine().toLowerCase();                
                /* 5.4.3 El bucle sólo debe salir si la opción elegida es correcta 
               en función de la posición
                 */
            } while ((miColumna == 0 && avance.equals("izquierda")) || (miColumna == matriz[0].length - 1 && avance.equals("derecha")));
        
            /* 5.5 Según la elección de desplazamiento, nos posicionamos en 
               casilla correspondiente */
            System.out.println();           
                /*  5.5.1 Si se ha elegido la dirección izquierda, las fila del 
                   mapa se avanza, pero la columna se decrementa en una unidad para
                   desplazarnos hacia nuestra izquierda. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                */           
            switch (avance) {  // Lo haremos comprobando antes lo que hay en la posición elegida 
                case "izquierda": 
                    if (miColumna - 1 >= 0 && miFila + 1 < matriz.length) {  // Controlamos los límites de la matriz 
                        if (matriz[miFila + 1][miColumna - 1] == 0) {
                            bolsaPremios = 0;
                            matriz[miFila][miColumna] = 2;
                            matriz[miFila + 1][miColumna - 1] = 1;
                        } else {
                            bolsaPremios += matriz[miFila + 1][miColumna - 1];
                            matriz[miFila][miColumna] = 2;
                            matriz[miFila + 1][miColumna - 1] = 3;
                        }
                        miColumna--;
                    }
                    break;                                        
                /* 5.5.2 Si se ha elegido la dirección derecha, las fila del mapa se avanza,
                   pero la columna se incrementa en una unidad para desplazarnos hacia 
                   nuestra derecha. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                 */
                case "derecha":
                    if (miColumna + 1 < matriz[miFila].length && miFila + 1 < matriz.length) {
                        if (matriz[miFila + 1][miColumna + 1] == 0) {
                            bolsaPremios = 0;
                            matriz[miFila][miColumna] = 2;
                            matriz[miFila + 1][miColumna + 1] = 1;
                        } else {
                            bolsaPremios += matriz[miFila + 1][miColumna + 1];
                            matriz[miFila][miColumna] = 2;
                            matriz[miFila + 1][miColumna + 1] = 3;
                        }
                        miColumna++;
                    }
                    break;
                /*  5.5.3 En cualquier otro caso se avanza de frente, con lo que la
                    fila se incrementa en una unidad, pero la columna se mantiene igual. 
                    Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                 */
                default:
                    if (miFila + 1 < matriz.length) {
                        if (matriz[miFila + 1][miColumna] == 0) {
                            bolsaPremios = 0;
                            matriz[miFila][miColumna] = 2;
                            matriz[miFila + 1][miColumna] = 1;
                        } else {
                            bolsaPremios += matriz[miFila + 1][miColumna];
                            matriz[miFila][miColumna] = 2;
                            matriz[miFila + 1][miColumna] = 3;
                        }
                    }
                    break;
                }                
            /* 5.5.4 Incrementamos la fila"*/ 
                miFila++;      
            /*
                Se comprueba si la nueva posición obtenida permite seguir jugado o no,
                así como si hemos llegado a la fila final del trayecto.
                Si permite seguir se repetirá el bucle. Sino, saldremos del bucle.
            */
            /* 6. Si se ha llegado a la fila final sin problemas, habremos ganado, 
                en caso contrario se habrá perdido     
                 */
            /* 6.1 Imprimir mensaje correspondiente de haber perdido */
                if (bolsaPremios == 0) {
                    System.out.println("Has PERDIDO");
                    avanceValido = false;                    
                } /* 6.2 Imprimir mensaje correspondiente de haber ganado */ 
                if (miFila == matriz.length - 1) {
                    System.out.printf("Has GANADO: %d€ %n", bolsaPremios);
                    avanceValido = false;
                }        
        }
        /* 7. Mostrar el mapa FINAL de la PARTIDA */
        System.out.println();
        System.out.println("Mapa al FINAL de la PARTIDA");
        mostrarMapa(matriz, miFila);
        
    }


    /* 7. BIS. Para mostrar el mapa se puede realizar un método estático para ver 
       el mapa de situación. Para mostrar el mapa vamos generando por filas cada  
       uno de los valores de las columnas. A este método estático se le debería pasar
       el número actual de fila, y el array bidimensional, devolviendo un String
            
     */
    public static void mostrarMapa(int[][] m, int fila) {
        for (int i = 0; i < m.length; i++) { // Recorre las filas 
            for (int j = 0; j < m[i].length; j++) { // Recorre las columnas
                if (i > fila) {
                    System.out.print("  X\t");
                } else { // Definimos aquí las variables al tratarse de un método estático definido fuera del main
                    int casillaActual = m[i][j];
                    char codigo = ' ';

                    switch (casillaActual) {
                        case 0:
                            codigo = 'C';
                            break;
                        case 1:
                            codigo = 'B';
                            break;
                        case 2:
                            codigo = 'I';
                            break;
                        case 3:
                            codigo = 'A';
                            break;
                        default:
                            System.out.print(" " + m[i][j]);
                            break;
                    }
                    System.out.print("  " + codigo + "\t");
                }
            }
            System.out.println();
        }
    }   
}
