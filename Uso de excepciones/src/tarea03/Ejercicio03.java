package tarea03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Ejercicio 3: Día de cumpleaños
 *
 * @author Alba 
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int MIN_ANIO = 1900;
        final int ANIO_ACTUAL = LocalDate.now().getYear();
        final int MIN_MES = 1;
        final int MAX_MES = 12;
        final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Variables de entrada
        int anio, mes, dia;

        // Variables de salida
        String nombreDia;
        int coincidencias;
        LocalDate fechaCumple;

        // Variables auxiliares
        boolean entradaValida, esBisiesto, coincideEsBisiesto;
        int diasEnElMes;
        LocalDate fecha;
        String diaSemanaCumple;

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("DÍA DE CUMPLEAÑOS");
        System.out.println("-----------------");

        // 1. Entrada de datos: lectura de año de nacimiento
        // 1.1.- Leer y comprobar el año de nacimiento (entre 1900 y año actual)
        anio = 0;
        do {
            entradaValida = true;
            System.out.printf("Ingrese un año entre %d y %d: %n", MIN_ANIO, ANIO_ACTUAL);
            try {
                anio = teclado.nextInt();
                if (anio < MIN_ANIO || anio > ANIO_ACTUAL) {
                    System.out.println("Error de lectura: año incorrecto.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de lectura: año incorrecto.");
                entradaValida = false;
                teclado.next(); // Limpiar el buffer del scanner
            }
        } while (!entradaValida);

        // 1.2.- Leer y comprobar el mes de nacimiento 
        mes = 0;
        do {
            entradaValida = true;
            System.out.printf("Introduzca el mes de nacimiento (%d-%d): %n", MIN_MES, MAX_MES);
            try {
                mes = teclado.nextInt();
                if (mes < MIN_MES || mes > MAX_MES) {
                    System.out.println("Error de lectura: mes incorrecto.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e2) {
                System.out.println("Error de lectura: mes incorrecto.");
                entradaValida = false;
                teclado.next();
            }
        } while (!entradaValida);

        // 1.3.- Averiguamos cuántos días tiene el mes de nacimiento
        if (mes == 2) { // Si es febrero
            // Verificar si el año es bisiesto
            esBisiesto = LocalDate.of(anio, 1, 1).isLeapYear();
            diasEnElMes = esBisiesto ? 29 : 28;
        } else {
            // Para otros meses, simplemente obtenemos la longitud del mes con el método de la clase LocalDate
            diasEnElMes = LocalDate.of(anio, mes, 1).lengthOfMonth();
        }

        // 1.4.- Leer y comprobar el día de nacimiento 
        dia = 0;
        do {
            entradaValida = true;
            System.out.println("Introduzca día de nacimiento: ");
            try {
                dia = teclado.nextInt();
                if (dia > diasEnElMes) {
                    System.out.println("Error de lectura: día incorrecto.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e3) {
                System.out.println("Error de lectura: día incorrecto.");
                entradaValida = false;
                teclado.next();
            }
        } while (!entradaValida);

        //----------------------------------------------
        //    Procesamiento + Salida de resultados  
        //----------------------------------------------
        //2.- Cálculo del día de la semana en que cayó el nacimiento 
        
        // Instanciamos el objeto fecha con los datos obtenidos 
        fecha = LocalDate.of(anio, mes, dia);
        // Obtenemos el nombre del día de la semana en español
        nombreDia = fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        // Lo mostramos por pantalla
        System.out.println("El día que naciste fue " + nombreDia);
        System.out.println();

        // 3.- Recorremos desde el año posterior al año de nacimiento hasta el año actual (bucle)
        System.out.println("¿Cúantas veces tu cumpleaños ha caído en " + nombreDia + "?");
        System.out.println("-----------------------------------------------------");

        coincidencias = 0; 
        for (int i = anio + 1; i <= ANIO_ACTUAL; i++) {
            // Comprobamos si es bisiesto el año siguiente al introducido 
            coincideEsBisiesto = LocalDate.of(i, 1, 1).isLeapYear();
            // Comprobamos que no es un 29 de febrero de un año no bisiesto:
            if (!(dia == 29 && mes == 2 && !coincideEsBisiesto)) {
                fechaCumple = LocalDate.of(i, mes, dia);
                diaSemanaCumple = fechaCumple.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

                if (diaSemanaCumple.equals(nombreDia)) {
                    coincidencias++;
                    System.out.printf("%d. %s%n", coincidencias, fechaCumple.format(FORMATO_FECHA));
                }
            }
        }

        // 4.- Mostramos por pantalla el número de coincidencias
        System.out.println("\nNúmero total de coincidencias: " + coincidencias);
    }
}
