package mobiliario;

/**
 * Interfaz que ofrece a un objeto la capacidad de ajustar su posición.
 *
 * @author Alba 
 * @version 1.0
 */
public interface Ajustable {

    /**
     * Devuelve un entero con la <strong>posición actual</strong> del objeto
     * ajustable.
     *
     * @return posición del objeto ajustable
     */
    int obtenerPosicion();

    /**
     * <strong>Sube una posición</strong> del objeto ajustable y la devuelve.
     *
     * @return posición del objeto ajustable
     * @throws IllegalStateException si la posición del objeto supera la
     * posición máxima
     */
    int subirPosicion() throws IllegalStateException;

    /**
     * <strong>Baja una posición</strong> del objeto ajustable y la devuelve.
     *
     * @return posición del objeto ajustable
     * @throws IllegalStateException si la posición del objeto es inferior a la
     * posición mínima
     */
    int bajarPosicion() throws IllegalStateException;
}
