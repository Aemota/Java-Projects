package tarea04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Tarea Online 4. Ejercicio 3: Días Festivos y Puentes
 * @author Alba 
 * @version 1.0
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String CADENA_FESTIVOS = "12,8;12,25;1,1;1,6;5,1;5,18;10,12;11,1;12,6";
        final LocalDate[] FESTIVOS;
        final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es", "ES"));        
     
        // DEFINICIÓN DE VARIABLES
        
        // Objeto tipo fecha con la fecha de hoy
        LocalDate hoy;

        // Objeto de tipo StringBuilder para mostrar el resultado al final
        StringBuilder resultado = new StringBuilder("");
        
        // Objetos de tipo StringTokenizer para separar la CADENA_FESTIVOS 
        StringTokenizer tokens, fechaTokenizer;
            
        // Variables auxiliares
        int anio_actual, numFestivos, dia, mes;
        LocalDate ultimo_festivo, proximoFestivo;
        String fecha, diaFestivo, festivoPuente, puente;
        boolean festivoEncontrado;

                
        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
        
        // Obtención de la fecha actual (hoy)
        hoy = LocalDate.now();
        
        // Si queremos hacer pruebas  podemos descomentar la siguiente línea y cambiar las fechas
        // hoy=LocalDate.of(2025, 4, 12);
       
        /*
            Comprobamos si el día de hoy es posterior al 25 de Diciembre, en tal 
            caso debemos incrementar el año actual en una unidad. Ya que, el último día
            festivo del año es el 25 de Diciembre, y por tanto no tiene sentido calcular
            los festivos hasta final de años, ya que no habría ninguno. 
         */
        anio_actual = LocalDate.now().getYear();
        ultimo_festivo = LocalDate.of(anio_actual, 12, 25);
        
        // He controlado que si hoy es 25/12, también es el último festivo del año
        if (hoy.isAfter(ultimo_festivo) || hoy.isEqual(ultimo_festivo)) {
            anio_actual += 1;
        }

        /* Creamos un array con los festivos, para ello, utilizando la clase 
           StringTokenizer, dividimos en  tokens las fechas que nos han entregado 
           con la cadena constante CADENA_FESTIVOS. Por tanto, debemos obtener los
           diferentes tokens para la pareja de fechas día y mes, separados de las otras
           parejas, días y mes mediante ";". Y posteriormente, obtener el día y el mes
           de cada pareja, sabiendo que estos están separados por una coma ","
           Cargaremos cada una de las fechas creadas en el array constante de FESTIVOS
         */
        tokens = new StringTokenizer(CADENA_FESTIVOS, ";");

        numFestivos = tokens.countTokens();  // Calculamos la cantidad de festivos para inicializar el array
        FESTIVOS = new LocalDate[numFestivos];

        for (int i = 0; tokens.hasMoreTokens(); i++) {
            fecha = tokens.nextToken();
            fechaTokenizer = new StringTokenizer(fecha, ","); // Separamos cada fecha en mes y día usando ","
            // Convertimos el valor de tipo String devuelto por nextToken() a tipo int para poder crear luego el objeto LocalDate
            mes = Integer.parseInt(fechaTokenizer.nextToken());
            dia = Integer.parseInt(fechaTokenizer.nextToken());
            FESTIVOS[i] = LocalDate.of(anio_actual, mes, dia);  // Creamos el objeto LocalDate y lo almacenamos en la posicion i del array
        }
  
        // Ordenamos el array
        Arrays.sort(FESTIVOS);
        
        /* 
           Calculamos el próximo día festivo que vamos a tener, para  ello recorremos
           el array de Festivos hasta que encontremos una fecha posterior a la actual
         */       
        festivoEncontrado = false;
        proximoFestivo = null;

        for (int i = 0; i < FESTIVOS.length && !festivoEncontrado; i++) {
            if (FESTIVOS[i].isAfter(hoy)) {
                proximoFestivo = FESTIVOS[i];
                festivoEncontrado = true;
            }
        }

        /* 
           A continuación, queremos saber si ese próximo festivo calculado, se encuentra
           en viernes o lunes, en cuyo caso se generaría un PUENTE
         */
        diaFestivo = proximoFestivo.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

        if (diaFestivo.equals("lunes") || diaFestivo.equals("viernes")) {
            puente = "TENDREMOS PUENTE";
        } else {
            puente = "NO TENDREMOS PUENTE";
        }

        // Mostramos los festivos desde el día actual hasta el final de año que generan puente
        // Generamos el formato de fecha que queremos
        if (festivoEncontrado) {
            resultado.append("El próximo festivo es ").append(proximoFestivo).append(" y ").append(puente).append("\n");
        }

        // Recorremos el array de festivos para ver qué festivos hasta final de año generan puente
        resultado.append("Festivos con puente hasta final del año ").append(anio_actual).append("\n");

        for (int i = 0; i < FESTIVOS.length; i++) {
            // Se comprueba si el festivo es posterior o igual a la fecha actual (hoy)
            if (FESTIVOS[i].isAfter(hoy) || FESTIVOS[i].isEqual(hoy)) {
                festivoPuente = FESTIVOS[i].getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
                if (festivoPuente.equals("lunes") || festivoPuente.equals("viernes")) {
                    resultado.append("   * En el festivo ").append(FESTIVOS[i].format(FORMATO_FECHA).toUpperCase()).append(" genera PUENTE").append("\n");
                }
            }
        }

        /* ***********************************************************************
         * SALIDA de DATOS 
         *************************************************************************/
        System.out.println(resultado);
    }

}
