/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> de asiento de tipo
 * <strong>Sofá</strong> para la gestión de productos en una tienda.
 * <p>
 * Un {@code Sofa} es un mueble de tipo asiento que puede contener más de una
 * plaza.
 * </p>
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un asiento de tipo Sofa en una tienda. Además de los
 * atributos propios de un mueble de tipo asiento, deberá contener los
 * específicos de un sofá, que son:
 * </p>
 * <ul>
 * <li><strong>composición</strong> del sofá ("3+2", "2+CHAISELONGUE",
 * "3+2+CHAISELONGUE",...).</li>
 * </ul>
 *
 * @author Alba 
 * @version 1.0
 */
public final class Sofa extends Asiento {

    // atributos de objeto
    private String composicion;

    // CONSTRUCTOR
    /**
     * Crea un objeto Sofa con su precio, descripción, número de plazas,
     * tapicería, color y composición.
     *
     * @param precio Precio del sofá (Euros)
     * @param descripcion Descripción del sofá
     * @param numPlazas Número de plazas del sofá
     * @param tapiceria Tapicería del sofá
     * @param color Color del sofá
     * @param composicion Composición del sofá
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Sofa(double precio, String descripcion, int numPlazas, String tapiceria, String color, String composicion) throws IllegalArgumentException {
        super(precio, descripcion, numPlazas, tapiceria, color);
        this.composicion = composicion;
    }

    // ------------- GETTERS -------------
    /**
     * Devuelve la <strong>composición</strong> del sofá.
     *
     * @return cadena que representa la composición del sofá
     */
    public String getComposicion() {
        return this.composicion;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las características del sofá de forma
     * textual.
     *
     * @return cadena que representa las característias del sofá de forma
     * textual
     */
    @Override
    public String toString() {
        return String.format("%s Composición: %s", super.toString(), this.getComposicion());
    }

}
