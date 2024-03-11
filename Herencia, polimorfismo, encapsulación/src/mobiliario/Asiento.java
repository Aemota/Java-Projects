/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase abstracta que representa un <strong>Mueble</strong> de tipo
 * <strong>Asiento</strong> para la gestión de productos en una tienda de
 * muebles.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * información relativa a un producto de tipo Asiento en una tienda. Además de
 * los atributos propios de un mueble, deberá contener los específicos de un
 * mueble que sirve para sentarse, que son:
 * </p>
 * <ul>
 * <li><strong>Plazas</strong> del asiento (valor entero en el rango
 * {@link #MIN_PLAZAS 1}-{@link #MAX_PLAZAS 9}).</li>
 * <li><strong>Tapicería</strong> del asiento.</li>
 * <li><strong>Color</strong> del asiento.</li>
 * </ul>
 *
 * <p>
 * Se trata de una clase abstracta que contiene la información mínima sobre el
 * mueble de tipo asiento pero no contiene información que depende del asiento
 * concreto (si se trata de una silla, un sillón o un sofá). Para eso existen
 * otras clases especializadas que heredarán de ésta.
 * </p>
 *
 * @author Alba 
 * @version 1.0
 */
public abstract class Asiento extends Mueble {

    // Atributos constantes estáticos públicos 
    /**
     * Mínimo número de plazas permitido: {@value MIN_PLAZAS}.
     */
    public final static int MIN_PLAZAS = 1;
    /**
     * Máximo número de plazas permitido: {@value MAX_PLAZAS}.
     */
    public final static int MAX_PLAZAS = 9;

    // Atributos constantes privados de objeto
    private final int numPlazas;
    private final String tapiceria;
    private final String color;

    // CONSTRUCTOR
    /**
     * Crea un objeto Asiento con su precio, descripción, número de plazas,
     * tapicería y color.
     *
     * @param precio Precio del asiento
     * @param descripcion Descripción del asiento
     * @param numPlazas Número de plazas del asiento
     * @param tapiceria Tapicería del asiento
     * @param color Color del asiento
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Asiento(double precio, String descripcion, int numPlazas, String tapiceria, String color) throws IllegalArgumentException {
        super(precio, descripcion);
        if (numPlazas < MIN_PLAZAS || numPlazas > MAX_PLAZAS) {
            throw new IllegalArgumentException(String.format("El número de plazas no está en el rango permitido: %d", numPlazas));
        }
        this.numPlazas = numPlazas;
        this.tapiceria = tapiceria;
        this.color = color;

    }

    // ------------- GETTERS -------------
    /**
     * Devuelve el <strong>número de plazas</strong> del asiento.
     *
     * @return tapicería del asiento
     */
    public int getNumPlazas() {
        return this.numPlazas;
    }

    /**
     * Devuelve la <strong>tapicería</strong> del asiento.
     *
     * @return tapicería del asiento
     */
    public String getTapiceria() {
        return this.tapiceria;
    }

    /**
     * Devuelve el <strong>color</strong> del asiento.
     *
     * @return color del asiento
     */
    public String getColor() {
        return this.color;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las características del asiento de
     * forma textual.
     *
     * @return cadena que representa las característias del asiento de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("%-14s    \tTapicería: %-14s Color:%-10s Número de plazas:%-2d",
                super.toString(),
                this.getTapiceria(),
                this.getColor(),
                this.getNumPlazas());
    }

}
