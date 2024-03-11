package mobiliario;

/**
 * Clase que representa un <strong>Mueble</strong> de asiento de tipo
 * <strong>Sillón</strong> para la gestión de productos en una tienda.
 * <p>
 * Un {@code Sillon} es un mueble de tipo asiento que sólo puede contener una
 * plaza.
 * </p>
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un asiento de tipo Sillon en una tienda. Además de los
 * atributos propios de un mueble de tipo asiento, deberá contener los
 * específicos de un sillón, que son:
 * </p>
 * <ul>
 * <li>Posición de los pies del sillón (valor entero:
 * {@link #POS_BAJADO 0}(bajado)-{@link #POS_SUBIDO 1}(subido)).</li>
 * </ul>
 * <p>
 * Dado que implementa la interfaz Ajustable, contiene la información necesaria
 * para poder cumplir los requisitos de esta interfaz.
 * </p>
 *
 * @author Alba
 * @version 1.0
 */
public final class Sillon extends Asiento implements Ajustable {

    // Atributos de objeto
    private int posicionPies;

    // Atributos publicos estaticos constantes
    /**
     * Posición de pies bajada: {@value POS_BAJADO}.
     */
    public final static int POS_BAJADO = 0;
    /**
     * Posición de pies subida: {@value POS_SUBIDO}.
     */
    public final static int POS_SUBIDO = 1;

    // CONSTRUCTOR
    /**
     * Crea un objeto Sillon con su precio, descripción, tipo de tapicería y
     * color.
     *
     * @param precio Precio del sillón (euros)
     * @param descripcion Descripción del sillón
     * @param tapiceria Tipo de tapicería del sillón (piel, polipiel, poliéster,
     * etc.)
     * @param color Color del sillón
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Sillon(double precio, String descripcion, String tapiceria, String color) throws IllegalArgumentException {
        super(precio, descripcion, Asiento.MIN_PLAZAS, tapiceria, color);
        this.posicionPies = POS_BAJADO;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las características del sillón de
     * forma textual.
     *
     * @return cadena que representa las característias del sillón de forma
     * textual
     */
    @Override
    public String toString() {
        String posicionPiesStr = (this.posicionPies == POS_BAJADO) ? "bajada" : "subida";
        return String.format("%s Posición actual de los pies: %s",
                super.toString(), posicionPiesStr);
    }

    // ------------- Métodos sobreescritos de Ajustable -------------
    /**
     * Devuelve la <strong>posición de los pies</strong> del sillón.
     *
     * @return posición de los pies del sillón (valor
     * entero:{@link #POS_BAJADO 0}(bajado)-{@link #POS_SUBIDO 1}(subido))
     */
    @Override
    public int obtenerPosicion() {
        return this.posicionPies;
    }

    /**
     * Sube una posición de los pies del sillón y la devuelve.
     *
     * @return posición de los pies del sillón
     * @throws IllegalStateException si la posición de los pies ya está subida
     */
    @Override
    public int subirPosicion() throws IllegalStateException {
        if (this.posicionPies == POS_SUBIDO) {
            throw new IllegalStateException("Error: no se pueden subir los pies del sillón. Ya están subidos");
        }
        return this.posicionPies = POS_SUBIDO;
    }

    /**
     * Baja una posición de los pies del sillón y la devuelve.
     *
     * @return posición de los pies del sillón
     * @throws IllegalStateException si la posición de los pies ya está bajada
     */
    @Override
    public int bajarPosicion() throws IllegalStateException {
        if (this.posicionPies == POS_BAJADO) {
            throw new IllegalStateException("Error: no se pueden bajar los pies del sillón. Ya están bajados");
        }
        return this.posicionPies = POS_BAJADO;
    }

}
