/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

import java.util.Arrays;

/**
 * Clase abstracta que representa un <strong>Mueble</strong> de tipo
 * <strong>Almacenaje</strong> para la gestión de productos en una tienda de
 * muebles.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar la
 * información relativa a un producto de tipo Almacenaje en una tienda. Además
 * de los atributos propios de un mueble, deberá contener los específicos de un
 * mueble que sirve para almacenar, que son:
 * </p>
 * <ul>
 * <li><strong>Anchura</strong> del mueble (en cm).</li>
 * <li><strong>Altura</strong> del mueble (en cm). </li>
 * <li><strong>Número máximo de módulos que se pueden añadir</strong> al mueble
 * (valor entero en el rango 1-20).</li>
 * <li><strong>Número de módulos que se han añadido</strong> al mueble. </li>
 * </ul>
 * <p>
 * Se trata de una clase abstracta que contiene la información mínima sobre el
 * mueble de tipo almacenaje pero no contiene información que depende del
 * almacenaje concreto (si se trata de una estantería o un armario). Para eso
 * existen otras clases especializadas que heredarán de ésta.
 * </p>
 * <p>
 * Dado que implementa la interfaz {@code Personalizable}, contiene la
 * información necesaria para poder cumplir los requisitos de esta interfaz.
 * </p>
 *
 * @author Alba 
 * @version 1.0
 */
public abstract class Almacenaje extends Mueble implements Personalizable {

    // Atributos de objeto variables
    private double anchura;         // en cm
    private double altura;          // en cm
    private Modulo[] modulos;
    /**
     * Contador del número de módulos añadidos al mueble de almacenaje.
     */
    protected int modulosAnyadidos;       // servirá de contador

    // Atributos constantes
    private final int numModulos;       // Num. máximo de módulos

    // Atributos estáticos constantes  públicos
    /**
     * Mínimo número de módulos de un mueble de almacenaje: {@value MIN_MODULOS}
     */
    public static final int MIN_MODULOS = 1;
    /**
     * Máximo número de módulos de un mueble de almacenaje: {@value MAX_MODULOS}
     */
    public static final int MAX_MODULOS = 20;

    // CONSTRUCTOR
    /**
     * Crea un objeto Almacenaje con su precio, descripción, anchura, altura y
     * número máximo de módulos que se le pueden añadir.
     *
     * @param precio Precio del mueble de almacenaje (euros)
     * @param descripcion Descripción del mueble de almacenaje
     * @param anchura Anchura del mueble de almacenaje
     * @param altura Altura del mueble de almacenaje
     * @param numModulos Número máximo de módulos que se le pueden añadir
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Almacenaje(double precio, String descripcion, double anchura, double altura, int numModulos) throws IllegalArgumentException {
        super(precio, descripcion);
        if (numModulos < MIN_MODULOS || numModulos > MAX_MODULOS) {
            throw new IllegalArgumentException(String.format("ERROR: No se puede crear el mueble de Almacenaje. "
                    + "El número de módulos no está en el rango permitido: %d", numModulos));
        }
        this.anchura = anchura;
        this.altura = altura;
        this.numModulos = numModulos;
        modulos = new Modulo[numModulos];
        modulos[0] = Modulo.BALDA;
        modulosAnyadidos++;

    }

    // ---------------------- GETTERS -----------------------------
    /**
     * Devuelve la <strong>anchura</strong> del mueble de Almacenaje.
     *
     * @return anchura del mueble de Almacenaje
     */
    public double getAnchura() {
        return this.anchura;
    }

    /**
     * Devuelve la <strong>altura</strong> del mueble de Almacenaje.
     *
     * @return altura del mueble de Almacenaje
     */
    public double getAltura() {
        return this.altura;
    }

    /**
     * Devuelve el <strong>número de módulos</strong> que se han añadido al
     * mueble de Almacenaje.
     *
     * @return número de módulos
     */
    public int getModulosAnyadidos() {
        return this.modulosAnyadidos;
    }

    /**
     * Devuelve el <strong>número máximo</strong> de módulos que admite el
     * mueble de Almacenaje.
     *
     * @return número máximo de módulos
     */
    public int getNumModulos() {
        return this.numModulos;
    }

    // ---------------------- toString() ----------------------
    /**
     * Devuelve una cadena que representa las características del mueble de
     * Almacenaje de forma textual.
     *
     * @return cadena que representa las característias del mueble de Almacenaje
     * de forma textual
     */
    @Override
    public String toString() {
        return String.format("%s   Anchura:%.2f    Altura:%.2f    Módulos máximos:%d    Módulos añadidos:%s ",
                super.toString(), this.getAnchura(), this.getAltura(), this.getNumModulos(), this.obtenerModulos());
    }

    // ------------- Métodos sobreescritos de Personalizable -------------
    /**
     * Devuelve una cadena con todos los módulos del mueble de Almacenaje.
     *
     * @return la cadena con los módulos del mueble de almacenaje
     */
    @Override
    public String obtenerModulos() {
        return Arrays.toString(this.modulos);
    }

    /**
     * Añade un módulo al mueble de Almacenaje.
     *
     * @param modulo el módulo a añadir al mueble de almacenaje
     * @throws NullPointerException si el parámetro es nulo
     * @throws IllegalStateException si el número de módulos supera el máximo
     * permitido
     */
    @Override
    public void anyadirModulo(Modulo modulo) throws NullPointerException, IllegalStateException {
        if (modulo == null) {
            throw new NullPointerException("Error: el módulo a añadir no puede ser nulo");
        } else if (this.getModulosAnyadidos() >= numModulos) {
            throw new IllegalStateException(String.format("Error: no se puede añadir el módulo %s. "
                    + "El número de módulos no puede superar el máximo permitido: %d",
                    modulo, numModulos));
        }
        modulos[modulosAnyadidos] = modulo; // añadimos el módulo
        modulosAnyadidos++; // incrementamos el contador de módulos añadidos

    }

    /**
     * Extrae un módulo del mueble de Almacenaje. El módulo extraído será el
     * útimo añadido.
     *
     * @return el módulo extraído
     * @throws IllegalStateException si no es posible extraer el módulo
     */
    @Override
    public Modulo extraerModulo() throws IllegalStateException {
        if (modulosAnyadidos <= MIN_MODULOS) {
            throw new IllegalStateException(String.format("Error: no se puede quitar el módulo. El número de módulos no puede ser inferior a %d", MIN_MODULOS));
        }
        Modulo moduloExtraido = modulos[modulosAnyadidos - 1]; // Obtiene el módulo de la última posición del array
        modulos[modulosAnyadidos - 1] = null; // vaciamos la última posición del array
        modulosAnyadidos--; // Decrementa el contador de módulos
        return moduloExtraido; // Devuelve el módulo extraído

    }

}
