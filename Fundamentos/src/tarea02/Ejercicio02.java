
package tarea02;

/**
 * Ejercicio 2: Máquina Expendedora
 * @author Alba 
 */
import java.util.Scanner;

public class Ejercicio02 {

    public enum Bebidas {
        COCACOLA, PEPSI, AGUA, ZUMO, OTRO
    };
    
    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //-----------------------------------------------
        
        // Variables de entrada 
        int opcion;
        double importe;
        
        // Constantes de precios  
        final double  PRECIO_COLA = 1.50;
        final double  PRECIO_PEPSI = 1.50;
        final double  PRECIO_AGUA = 1.00;
        final double  PRECIO_ZUMO = 2.00;
        
        // Variable de tipo enum 
        Bebidas miBebida;
        
        // Variables de salida 
        String opcionElegida;
       
        // Variable auxiliar
        boolean eleccionValida=false;
        
        // Variables de cambio devuelto
        double cambioCola;
        double cambioPepsi;
        double cambioAgua;
        double cambioZumo;
        
        // Clase Scanner para petición de datos al usuario a través del teclado      
        Scanner scanner = new Scanner(System.in);
        
 
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println();
        System.out.println("Ejercicio 2: Máquina expendedora de Bebidas");
        System.out.println("-------------------------------------------");                                       
                
        // Bloque 1: Sacamos por pantalla el menú de opciones y pedimos que introduzca una.       
        do{
            System.out.println("¡Bienvenido/a a la Máquina Expendedora de Bebidas!\n");
            System.out.println("Seleccione una bebida:");
            System.out.printf("1. COCACOLA - %.2f€%n", PRECIO_COLA);
            System.out.printf("2. PEPSI - %.2f€%n", PRECIO_PEPSI);                
            System.out.printf("3. AGUA - %.2f€%n",  PRECIO_AGUA);                       
            System.out.printf("4. ZUMO de naranja - %.2f€%n",  PRECIO_ZUMO);     
            System.out.println("0. Salir");     
            System.out.println();  
            
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            
        // En caso de introducir una opción inválida, debemos indicarlo y volver a pedirla:           
            if (opcion >= 0 && opcion <= 4){ 
                eleccionValida = true;
            } else {
                System.out.println("Opción no válida. Seleccione una bebida válida.\n");
            }
        } while (!eleccionValida);
        
           
        //------------------------------------------------------------------
        //                 Procesamiento y  Salida de resultados 
        //------------------------------------------------------------------
        
        /* Cuando se haya introducido una opción válida, llevamos a cabo las siguientes acciones:
             
         *      PARTE I: TIPO DE OPCIÓN ELEGIDA
        
                -Si nos indica 'Salir', nos despedimos y terminamos 
                -Si nos indica un producto:
                   1. Decimos el producto seleccionado y su precio 
                   2. Pedimos que introduzca el importe 
                --------------------------------------------------------
         *      PARTE II: EL IMPORTE
        
                -Si el importe es suficiente:
                        1. Imprimimos el producto obtenido (Equivale a la orden de suministrar el producto)
                        2. Decimos el importe que ha sobrado
                -Si no, indicamos que el importe es insuficiente 
        */

        switch (opcion){         
            case 1:
                miBebida = Bebidas.COCACOLA;
                opcionElegida="Ha seleccionado una " + miBebida + ". El precio es 1,50€";
                System.out.println(opcionElegida);
                System.out.print("Ingrese la cantidad de dinero en euros: ");
                
                importe = scanner.nextDouble();
                cambioCola = importe - PRECIO_COLA; // definimos la variable "cambio" para calcular el cambio de cada bebida
                
                if (importe >= PRECIO_COLA && opcion == 1){
                    System.out.printf("Compra exitosa. Su cambio es: %.2f€%n", cambioCola);
                    System.out.println("¡Disfrute su COCACOLA!");
                }else
                    System.out.println("Dinero insuficiente. Su dinero será devuelto.");
                break;
            
            case 2:
                miBebida = Bebidas.PEPSI;
                opcionElegida="Ha seleccionado una " + miBebida + ". El precio es 1,50€";
                System.out.println(opcionElegida);
                System.out.print("Ingrese la cantidad de dinero en euros: ");
                
                importe = scanner.nextDouble();
                cambioPepsi = importe - PRECIO_PEPSI;
                
                if (importe >= PRECIO_PEPSI && opcion == 2){
                    System.out.printf("Compra exitosa. Su cambio es: %.2f€%n", cambioPepsi);
                    System.out.println("¡Disfrute su PEPSI!");
                }else
                    System.out.println("Dinero insuficiente. Su dinero será devuelto.");
                break;
            
            case 3:
                miBebida = Bebidas.AGUA;               
                opcionElegida="Ha seleccionado un " + miBebida + ". El precio es 1,00€";
                System.out.println(opcionElegida);
                System.out.print("Ingrese la cantidad de dinero en euros: ");
                
                importe = scanner.nextDouble();
                cambioAgua = importe - PRECIO_AGUA;
                
                if (importe >= PRECIO_AGUA && opcion == 3){
                    System.out.printf("Compra exitosa. Su cambio es: %.2f€%n", cambioAgua);
                    System.out.println("¡Disfrute su AGUA!");
                }else
                    System.out.println("Dinero insuficiente. Su dinero será devuelto.");
                break;
            
            case 4:
                miBebida = Bebidas.ZUMO;             
                opcionElegida="Ha seleccionado un " + miBebida + " de naranja. El precio es 2,00€";
                System.out.println(opcionElegida);
                System.out.print("Ingrese la cantidad de dinero en euros: ");
                
                importe = scanner.nextDouble();
                cambioZumo = importe - PRECIO_ZUMO;
                
                if (importe >= PRECIO_ZUMO && opcion == 4){
                    System.out.printf("Compra exitosa. Su cambio es: %.2f€%n", cambioZumo);
                    System.out.println("¡Disfrute su ZUMO de naranja!");
                }else
                    System.out.println("Dinero insuficiente. Su dinero será devuelto.");
                break;
            
            case 0:
                System.out.println("Gracias por usar la Máquina Expendedora. ¡Hasta luego!");
                break;
        }
       
        //----------------------------------------------
        //             Salida de resultados 
        //----------------------------------------------
        //  Se produce durante el proceso
    }
}

