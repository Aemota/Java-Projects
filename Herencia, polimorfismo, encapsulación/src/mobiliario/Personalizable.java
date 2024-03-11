package mobiliario;

/**
 * Interfaz que incorpora la capacidad de un objeto de ser personalizado.
 *
 * @author Alba 
 * @version 1.0
 */
public interface Personalizable {

    /**
     * Devuelve una cadena con <strong>todos los módulos</strong> del objeto
     * personalizable.
     *
     * @return la cadena con los módulos del objeto personalizable
     */
    String obtenerModulos();

    /**
     * <strong>Añade un módulo</strong> al objeto personalizable.
     *
     * @param modulo el módulo a añadir al objeto personalizable
     * @throws IllegalStateException si el número de módulos supera el máximo
     * permitido
     * @throws NullPointerException si el parámetro es nulo
     */
    void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException;

    /**
     * <strong>Extrae un módulo</strong> del objeto personalizable.
     *
     * @return el modulo extraído del objeto personalizable
     * @throws IllegalStateException si el número de módulos es inferior al
     * mínimo permitido
     */
    Modulo extraerModulo() throws IllegalStateException;
}
