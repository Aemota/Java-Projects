/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase abstracta que representa un Mueble genérico para una tienda de muebles
 * online.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * mínima información necesaria de un mueble para ser comercializado en la
 * tienda:
 * </p>
 * <ul>
 * <li><strong>Id</strong> único del mueble.</li>
 * <li><strong>Precio</strong> del mueble (valor real en el rango
 * {@link #MIN_PRECIO 0.01}-{@link #MAX_PRECIO 10000.00} euros).</li>
 * <li><strong>Descripción</strong> del mueble.</li>
 * </ul>
 * <p>
 * El precio de un mueble puede cambiar a lo largo del tiempo.
 * </p>
 * <p>
 * Se trata de una clase abstracta que contiene la información mínima sobre un
 * mueble pero no contiene información que depende del mueble concreto (si se
 * trata de una silla, un armario, una estantería, etc). Para eso existen otras
 * clases especializadas que heredarán de ésta.
 * </p>
 *
 * @author Alba
 * @version 1.0
 */
public abstract class Mueble {

    // Atributos estáticos constantes públicos
    /**
     * Mínimo precio permitido: {@value MIN_PRECIO}.
     */
    public static final double MIN_PRECIO = 0.01;
    /**
     *
     * Máximo precio permitido: {@value MAX_PRECIO}.
     */
    public static final double MAX_PRECIO = 10000.00;

    // Atributos de objeto constantes
    private final int id;
    private final String descripcion;

    // Atributos de objeto variables
    /**
     *
     * Precio actual del mueble
     */
    protected double precio;

    // Atributos estáticos variables
    private static int nextId = 1; // contador de identificadores

    // CONSTRUCTOR 
    /**
     * Crea un objeto {@code  Mueble} con un <strong>precio</strong> y un
     * <strong>texto de descripción</strong>. Tambén contendrá un id que se
     * genera automáticamente y que lo identificará de manera unívoca.
     *
     * @param precio Precio del mueble. El rango válido es
     * {@link #MIN_PRECIO 0.01}-{@link #MAX_PRECIO 10000.00} euros
     * @param descripcion Descripción del mueble
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Mueble(double precio, String descripcion) throws IllegalArgumentException {
        if (precio < MIN_PRECIO || precio > MAX_PRECIO) {
            throw new IllegalArgumentException(String.format("El precio no está en el rango permitido: %.2f", precio));
        } else {
            this.id = Mueble.nextId++;
            this.precio = precio;
            this.descripcion = descripcion;
        }
    }

    // ---------------------- GETTERS -----------------------------
    /**
     * Devuelve el <strong>identificador</strong> del mueble. Se trata de un id
     * que lo identifica unívocamente.
     *
     * @return Identificador del mueble
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve el <strong>precio</strong> actual del mueble.
     *
     * @return precio del mueble
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Devuelve la <strong>descripción</strong> del mueble.
     *
     * @return Descripción del mueble
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las característias del mueble de forma
     * textual.
     *
     * @return cadena que representa las características del mueble de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format(" Tipo:%-11s Id:%2d Precio: %.2f   Descripción: %-20s",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getPrecio(),
                this.getDescripcion());
    }

}
