/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un Mueble de asiento de tipo Silla para la gestión de
 * productos en una tienda.
 *
 * <p>
 * Una {@code Silla} es un mueble de tipo asiento que sólo puede contener una
 * plaza.
 * </p>
 *
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un asiento de tipo Silla en una tienda. Además de los
 * atributos propios de un mueble de tipo asiento, deberá contener los
 * específicos de una silla, que son:
 * </p>
 * <ul>
 * <li>Posición del respaldo de la silla (valor entero en el rango
 * {@link #MIN_POSICION 0}-{@link #MAX_POSICION 4}).</li>
 * </ul>
 *
 * <p>
 * Dado que implementa la interfaz {@code Ajustable}, contiene la información
 * necesaria para poder cumplir los requisitos de esta interfaz.
 * </p>
 *
 * @author Alba 
 * @version 1.0
 */
public final class Silla extends Asiento implements Ajustable {

    // Atributos de objeto variables
    private int posicion;

    // Atributos estáticos constantes y públicos
    /**
     * Posición mínima permitida: {@value MIN_POSICION}.
     */
    public static final int MIN_POSICION = 1;
    /**
     * Posición máxima permitida: {@value MAX_POSICION}.
     */
    public static final int MAX_POSICION = 4;

    // CONSTRUCTOR
    /**
     * Crea un objeto Silla con su precio, descripción, tipo de tapicería y
     * color.
     *
     * @param precio Precio de la silla (euros)
     * @param descripcion Descripción de la silla
     * @param tapiceria Tipo de tapicería de la silla (piel, polipiel,
     * poliéster, etc.)
     * @param color Color de la silla
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Silla(double precio, String descripcion, String tapiceria, String color) throws IllegalArgumentException {
        super(precio, descripcion, Asiento.MIN_PLAZAS, tapiceria, color);
        this.posicion = MIN_POSICION;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las características de la silla de
     * forma textual.
     *
     * @return cadena que representa las característias de la silla de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("%s Posición actual del respaldo:%d",
                super.toString(), this.obtenerPosicion());
    }

    // ------------- Métodos sobreescritos de Ajustable -------------
    /**
     * Devuelve la <strong>posición del respaldo</strong> de la silla.
     *
     * @return número de posición del respaldo (valor entero en el rango
     * {@link #MIN_POSICION 0}-{@link #MAX_POSICION 4})
     */
    @Override
    public int obtenerPosicion() {
        return this.posicion;
    }

    /**
     * Sube una posición el respaldo de la silla y la devuelve.
     *
     * @return posición del respaldo de la silla
     *
     * @throws IllegalStateException si la posición del respaldo supera la
     * posición máxima
     */
    @Override
    public int subirPosicion() throws IllegalStateException {
        if (this.posicion >= MAX_POSICION) {
            throw new IllegalStateException(String.format("Error: no se puede subir a la posición %d, ya que la posición máxima es %d", this.posicion + 1, Silla.MAX_POSICION));
        }
        return ++this.posicion;

    }

    /**
     * Baja una posición el respaldo de la silla y la devuelve.
     *
     * @return posición del respaldo de la silla
     *
     * @throws IllegalStateException si la posición del respaldo baja de la
     * posición mínima
     */
    @Override
    public int bajarPosicion() throws IllegalStateException {
        if (this.posicion <= MIN_POSICION) {
            throw new IllegalStateException(String.format("Error: no se puede bajar a la posición %d, ya que la posición mínima es %d", this.posicion - 1, Silla.MIN_POSICION));
        } else {
            return --this.posicion;
        }
    }

}
