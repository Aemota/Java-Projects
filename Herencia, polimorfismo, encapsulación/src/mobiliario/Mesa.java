/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> de tipo <strong>Mesa</strong>
 * para la gestión de productos en una tienda de muebles.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un mueble de tipo Mesa en una tienda. Además de los
 * atributos propios de un mueble, deberá contener los específicos de una Mesa,
 * que son:
 * </p>
 * <ul>
 * <li><strong>Forma</strong> de la mesa (Cuadrada, Redonda, Ovalada,
 * etc.).</li>
 * <li>Número de <strong>comensales</strong> de la mesa (valor entero en el
 * rango {@link #MIN_COMENSALES 4}-{@link #MAX_COMENSALES 16}).</li>
 * </ul>
 *
 * @author Alba
 * @version 1.0
 */
public final class Mesa extends Mueble {

    // Atributos de objeto
    private String forma;
    private int comensales;

    // Atributos estáticos constantes públicos
    /**
     * Mínimo número de comensales permitido: {@value MIN_COMENSALES}.
     */
    public static final int MIN_COMENSALES = 4;
    /**
     * Máximo número de comensales permitido: {@value MAX_COMENSALES}.
     */
    public static final int MAX_COMENSALES = 16;

    // ---------------------- GETTERS -----------------------------
    /**
     * Devuelve la <strong>forma</strong> de la mesa
     *
     * @return forma de la mesa
     */
    public String getForma() {
        return this.forma;
    }

    /**
     * Devuelve el número de <strong>comensales</strong> de la mesa
     *
     * @return número de comensales de la mesa
     */
    public int getComensales() {
        return this.comensales;
    }

    // CONSTRUCTOR
    /**
     * Crea un objeto Mesa con su precio, descripción, forma y número de
     * comensales.
     *
     * @param precio Precio de la mesa (euros)
     * @param descripcion Descripción de la mesa
     * @param forma forma de la mesa (Cuadrada, Redonda, Ovalada, etc.)
     * @param comensales número de comensales máximos de la mesa
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Mesa(double precio, String descripcion, String forma, int comensales) throws IllegalArgumentException {
        super(precio, descripcion);
        if (comensales < MIN_COMENSALES || comensales > MAX_COMENSALES) {
            throw new IllegalArgumentException(String.format("Error: el número de comensales no está dentro del rango permitido: %d", comensales));
        }
        this.forma = forma;
        this.comensales = comensales;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las característias de la mesa de forma
     * textual.
     *
     * @return cadena que representa las características de la mesa de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("%s    Forma:%s   N.Comensales:%d", super.toString(), this.getForma(), this.getComensales());
    }

}
