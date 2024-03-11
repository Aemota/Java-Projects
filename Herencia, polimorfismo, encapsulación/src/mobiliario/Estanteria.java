/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> de almacenaje de tipo
 * <strong>Estanteria</strong> para la gestión de productos en una tienda de
 * muebles. Una {@code Estanteria} es un mueble de almacenaje que sólo puede
 * contener módulos de tipo BALDA.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * información relativa a un mueble de almacenaje de tipo Estanteria en una
 * tienda. Además de los atributos propios de un mueble de almacenaje, deberá
 * contener los específicos de una estantería, que son:
 * </p>
 * <ul>
 * <li><strong>Tipo</strong> de estantería (de pared, de suelo, de encastre,
 * ...).</li>
 * </ul>
 *
 * @author Alba 
 * @version 1.0
 */
public final class Estanteria extends Almacenaje {

    // Atributos de objeto
    private String tipo;     // tipo de estantería (de pared, suelo, etc.)

    // CONSTRUCTOR
    /**
     * Crea un objeto Estanteria con su precio, descripción, anchura y altura.
     *
     * @param precio Precio de la estantería (euros)
     * @param descripcion Descripción de la estantería
     * @param anchura Anchura de la estantería
     * @param altura Altura de la estantería
     * @param numModulos Número máximo de módulos que se podrán añadir a la
     * estantería
     * @param tipo Tipo de estantería: de pared, de suelo, de encastre...
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Estanteria(double precio, String descripcion, double anchura, double altura, int numModulos, String tipo) throws IllegalArgumentException {
        super(precio, descripcion, anchura, altura, numModulos);
        this.tipo = tipo;
    }

    // ---------------------- GETTERS -------------------------
    /**
     * Devueve el <strong>tipo</strong> de estantería.
     *
     * @return tipo de estantería
     */
    public String getTipo() {
        return this.tipo;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las características de la estantería
     * de forma textual.
     *
     * @return cadena que representa las característias de la estantería de
     * forma textual
     */
    @Override
    public String toString() {
        return String.format("%s  Tipo:%s", super.toString(), this.getTipo());
    }

    // ------------- Métodos sobreescritos de Personalizable -------------
    /**
     * Añade un módulo a la estantería.
     *
     * @param modulo el módulo a añadir a la estantería
     * @throws NullPointerException si el parámetro es nulo
     * @throws IllegalStateException si el número de módulos supera el máximo
     * permitido
     * @throws IllegalArgumentException si el módulo a añadir no es una BALDA
     */
    @Override
    public void anyadirModulo(Modulo modulo) throws NullPointerException, IllegalStateException, IllegalArgumentException {
        if (modulo == null) {
            throw new NullPointerException("Error: el módulo a añadir no puede ser nulo");
        }
        if (modulo != Modulo.BALDA) {
            throw new IllegalArgumentException(String.format("Error: no se puede añadir el módulo %s, "
                    + "ya que solo se permiten módulos de tipo BALDA", modulo));
        }
        // Llamada al método de la clase padre
        super.anyadirModulo(modulo);

    }

}
