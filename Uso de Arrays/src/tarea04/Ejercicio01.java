
package tarea04;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * Tarea Online 4. Ejercicio 1: Nivel de Seguridad de Contraseñas
 * @author Alba 
 * @version 1.0
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String[] PATRONES = { "\\d"/*Patrón si contiene números */,"[a-z]" /*Patrón si contiene letras minúsculas */, "[A-Z]" /*Patrón si contiene letras mayúsculas */, "[\\\\\\!\\|#\\$%&\\(\\)=\\?\\*\\+\\-_\\{\\}\\[\\]:;,\\.<>@]"/*Patrón si contiene caracteres especiales */, "([^aeiouAEIOU\\d]{4})+" /* Si contiene al menos cuatro consonantes juntas */, "([a-z][A-Z][a-z])|([A-Z][a-z][A-Z])"/* Que tenga al menos dos alternancias entre mayúsculas y minúsculas*/}; 
        final String CONTRASENYAS_USADAS = "password;123456;123456789;guest;qwerty;12345678;111111;12345;col123456;123123;1234567;1234;1234567890;tequiero;555555;666666;123321;654321;7777777;123;D1lakiss;777777;110110jp;1111;987654321;121212;Gizli;abc123;112233;azerty;159753;1q2w3e4r;54321;pass@123;222222;qwertyuiop;qwerty123;qazwsx;vip;asdasd;123qwe;123654;iloveyou;a1b2c3;999999;Groupd2013;1q2w3e;usr;Liman1000;1111111;333333;123123123;9136668099;11111111;1qaz2wsx;password1;mar20lt;987654321;gfhjkm;159357;abcd1234;131313;789456;luzit2000;aaaaaa;zxcvbnm;asdfghjkl;1234qwer;88888888;dragon;987654;888888;qwe123;football;3601;asdfgh;master;samsung;12345678910;killer;1237895;1234561;12344321;daniel;00000;444444;101010;f--;you;qazwsxedc;789456123;super123;qwer1234;123456789a;823477aA;147258369;unknown;98765;q1w2e3r4;232323";
        final String[] DICCIONARIO_CONTRASENYAS;
        
        // DEFINICIÓN DE VARIABLES
        // Variable para almacenar la password introducida
        String password;
        
        // Varaible para el nivel de seguridad
        double nivelSeguridad;
        
        // Variable para almacenar el objeto Scanner para la entrada de datos
        Scanner teclado = new Scanner(System.in);
        
        // Variables de salida
        int numPartesMasUsadas;
        
        // Variables auxiliares
        boolean passwordCorrecta, encontrado;
        String passCoincide;
        Pattern pattern;
        Matcher matcher;
       
        /* ************************************************************************
         * ENTRADA DE DATOS
         * ***********************************************************************/
        
        /* 1. Comprobamos que la contraseña tenga al menos 8 caracteres, no se debe 
         * seguir si la contraseña no presenta al menos 8 caracteres 
         */
        do {
            passwordCorrecta = true;
            System.out.println("Introduce la contraseña (NIVEL 0: La contraseña debe tener al menos 8 caracteres)");
            password = teclado.nextLine();
            if(password.length() < 8)
                passwordCorrecta = false;         
        } while (!passwordCorrecta);
        
       
        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
        
        /* 2. Realizamos la comprobación de cada uno de los patrones, aumentando el nivel 
           de complejidad de la variable si va superando los patrones
         */
        nivelSeguridad = 0.0;
        int patronesEncontrados = 0;

        for (int i = 0; i < PATRONES.length; i++) {
            pattern = Pattern.compile(PATRONES[i]);
            matcher = pattern.matcher(password);
            encontrado = matcher.find();

            System.out.println("Comprobando patrón: " + (i + 1)); // Sumamos 1 a la i para considerar como primer patrón la posición 0

            if (encontrado) {
                if (i < 4) {
                    nivelSeguridad += 0.5;
                    patronesEncontrados++; // contador para saber cuándo llegamos a comprobar los 4 primeros patrones
                } else {
                    nivelSeguridad += 1;
                }
            }
            System.out.println("Nivel Actual: " + nivelSeguridad);
            
            /* 2.1 En el caso de que hayamos completado los cuatro primeros patrones 
            y su validación haya sido positiva en todos ellos, se suma un punto
            al nivel de seguridad
             */
            if (i == 3 && patronesEncontrados == 4) {
                nivelSeguridad += 1;
                System.out.println("Al completarse los cuatro primeros patrones como positivos, añadimos un punto al nivel de seguridad");
                System.out.println("Nivel Actual: " + nivelSeguridad);
            }
        }

        /* 2.2 Si es uno de los cuatro primeros patrones suman 0.5
         * si el patron analizado es de los siguientes (a partir del cuarto) 
         * suman un punto  ---> ESTO SE HA COMPROBADO EN EL IF-ELSE ANIDADO DEL PRIMER IF. 
         */
         
        // 3. Comprobación de que la palabra se encuentra en el diccionario.
        
        /* 3.1 A partir de la cadena de contraseñas separadas por ";" que tenemos 
         * en la constante CONTRASENYAS_USADAS, obtenemos un array de palabras que
         * guardamos en DICCIONARIO_CONTRASENYAS
         */
        DICCIONARIO_CONTRASENYAS = CONTRASENYAS_USADAS.split(";");
         
        /* En este bucle comprobamos si nuestra contraseña es igual que alguna 
           palabra del diccionario, y si nuestra contraseña contiene partes de 
           de contraseñas del diccionario. Una vez encuentra una, no es necesario 
           comprobar si es igual al resto,aunque sí pueden aparecer varias 
           contraseñas del diccionario como partes de la nuestra, por lo que debemos
           incrementar el contador y recorrer el bucle hasta el final
        */
        numPartesMasUsadas = 0;
        for (int i = 0; i < DICCIONARIO_CONTRASENYAS.length; i++) {
            passCoincide = DICCIONARIO_CONTRASENYAS[i];
            if (password.equals(passCoincide)) {
                nivelSeguridad--;
            } else if (password.contains(passCoincide)) {
                numPartesMasUsadas++;
            }
        }

        /* ************************************************************************
         * SALIDA DE DATOS
         * ***********************************************************************/
        
        // Se muestra el nivel final de seguridad de nuestra contraseña
        System.out.printf("El nivel de seguridad de la contraseña %s es: %.2f\n", password, nivelSeguridad);
        
        // Se muestra la cantidad de contraseñas más utilizadas que forman parte de nuestro password
        System.out.printf("Tu contraseña tiene partes de contraseñas más utilizadas %d veces\n", numPartesMasUsadas);
        
    }

}
