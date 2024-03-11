/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> de almacenaje de tipo
 * <strong>Armario</strong> para la gestión de productos en una tienda de
 * muebles.
 * <p>
 * Un {@code Armario} es un mueble de almacenaje que puede aceptar módulos de
 * cualquier tipo y que contiene una cantidad de puertas.
 * </p>
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * información relativa a un mueble de almacenaje de tipo Armario en una tienda.
 * Además de los atributos propios de un mueble de almacenaje, deberá contener
 * los específicos de un armario, que son:
 * </p>
 * <ul>
 * <li><strong>Número de puertas</strong> del armario (valor entero en el rango
 * {@link #MIN_PUERTAS 1}-{@link #MAX_PUERTAS 6}).</li>
 * </ul>
 *
 *
 * @author Alba 
 * @version 1.0
 */
public final class Armario extends Almacenaje {

    // Atributos de objeto 
    private int numPuertas;

    // Atributos estáticos constantes públicos
    /**
     * Número mínimo de puertas permitido: {@value MIN_PUERTAS}.
     */
    public static final int MIN_PUERTAS = 1;
    /**
     * Número máximo de puertas permitido: {@value MAX_PUERTAS}.
     */
    public static final int MAX_PUERTAS = 6;

    // ---------------------- GETTERS -----------------------------
    /**
     * Devueve el número de puertas del armario.
     *
     * @return número de puertas del armario
     */
    public int getNumPuertas() {
        return this.numPuertas;
    }

    // CONSTRUCTOR 
    /**
     * Crea un objeto Armario con su precio, descripción, anchura, altura,
     * número máximo de módulos que admitirá y número de puertas.
     *
     * @param precio Precio del armario (euros)
     * @param descripcion Descripción del armario
     * @param anchura Anchura del armario
     * @param altura Altura del armario
     * @param numModulos Número máximo de módulos que se podrán añadir al
     * armario
     * @param numPuertas Número de puertas del armario
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Armario(double precio, String descripcion, double anchura, double altura, int numModulos, int numPuertas) throws IllegalArgumentException {
        super(precio, descripcion, anchura, altura, numModulos);
        if (numPuertas < MIN_PUERTAS || numPuertas > MAX_PUERTAS) {
            throw new IllegalArgumentException(String.format("No se puede crear el Armario. El número de puertas no está en el rango permitido: %s", numPuertas));
        }
        this.numPuertas = numPuertas;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las características del Armario de
     * forma textual.
     *
     * @return cadena que representa las característias del Armario de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("%s  Número de puertas:%d", super.toString(), this.getNumPuertas());
    }

}
