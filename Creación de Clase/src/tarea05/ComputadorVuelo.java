package tarea05;

/**
 *
 *
 * Clase que representa el <strong>computador de vuelo</strong> que se
 * interconecta con los sistemas de vuelo de ultraligeros con motor para
 * gestionar las diferentes operaciones de escuelas de vuelo.
 * <p>
 * Los objetos de esta clase permiten almacenar y gestionar la informaci�n
 * relativa al estado de la aeronave y la informaci�n de vuelo con los
 * siguientes atributos:
 * </p>
 * <ul>
 * <li><strong>En vuelo.</strong> Indica si la aeronave est� volando o no.</li>
 * <li><strong>Piloto.</strong> Indica el nombre del piloto de la aeronave.</li>
 * <li><strong>Tipo de vuelo.</strong> Indica si el vuelo es de tipo "escuela" o
 * "privado".</li>
 * <li><strong>Tiempo total de vuelo.</strong> Indica los minutos de vuelo que
 * lleva la aeronave.</li>
 * <li><strong>Velocidad.</strong> Indica la velocidad en km/h que lleva la
 * aeronave.</li>
 * <li><strong>Rumbo.</strong> Indica el rumbo en � que lleva la aeronave.</li>
 * <li><strong>Altitud.</strong> Indica la altitud en metros que lleva la
 * aeronave.</li>
 * </ul>
 * <p>
 * Adem�s, cuenta con los siguientes atributos que son constantes. Se
 * establecer�n a la hora de crear la aeronave y no cambiar�n:
 * </p>
 * <ul>
 * <li><strong>Matr�cula.</strong> Indica la matr�cula de la aeronave.</li>
 * <li><strong>Modelo.</strong> Indica el modelo de la aeronave.</li>
 * </ul>
 * <p>
 * La clase tambi�n posee informaci�n general (est�tica), relativa a las
 * diferentes aeronaves que existen en la escuela, como:
 * </p>
 * <ul>
 * <li><strong>Cantidad total de aeronaves</strong> que existen en la
 * escuela.</li>
 * <li><strong>Cantidad de aeronaves volando</strong> en el momento actual.</li>
 * <li><strong>Cantidad total de horas de vuelo</strong> de todas las
 * aeronaves.</li>
 * </ul>
 *
 * @author Alba 
 * @version 1.0
 */
public class ComputadorVuelo {

    // ATRIBUTOS DE CLASE (est�ticos)
    // ------------------------------
    // Atributos est�ticos constantes
    /**
     * Piloto por defecto: {@value PILOTO_DEFECTO}
     */
    public final static String PILOTO_DEFECTO = "Juan P�rez";
    /**
     * Matr�cula por defecto: {@value MATRICULA_DEFECTO}
     */
    public final static String MATRICULA_DEFECTO = "EC-ABC";
    /**
     * Modelo de la aeronave por defecto: {@value MODELO_DEFECTO}
     */
    public final static String MODELO_DEFECTO = "Cessna 152";
    /**
     * Altitud m�nima permitida: {@value MIN_ALTITUD}
     */
    public final static int MIN_ALTITUD = 1000;
    /**
     * Altitud m�xima permitida: {@value MAX_ALTITUD}
     */
    public final static int MAX_ALTITUD = 3000;
    /**
     * Identificador para el tipo de vuelo "escuela": {@value VUELO_ESCUELA}
     */
    public final static int VUELO_ESCUELA = 0;
    /**
     * Identificador para el tipo de vuelo "privado": {@value VUELO_PRIVADO}
     */
    public final static int VUELO_PRIVADO = 1;

    // Atributos est�ticos
    private static int totalAeronavesCreadas;
    private static int totalAeronavesVolando;
    private static float totalHorasVueloTodasAeronaves;

    // ATRIBUTOS DE OBJETO:  cada aeronave tendr� su propio valor para representar estas caracter�sticas
    // --------------------------------------------------------------------------------------------------
    // Atributos de objeto constantes (representan caracter�sticas "inmutables" de la aeronave)
    private final String matricula;     // estar� formada por un c�digo alfanum�rico de la forma EC-ABC (pa�s y registro). "EC" para Espa�a.
    private final String modelo;

    // Atributos de objeto variables: de Estado y de Informaci�n de vuelo   
    // Atributos de Estado de la Aeronave: estado b�sico de la aeronave en un momento dado 
    private boolean enVuelo;            // true - si est� volando; false - si ha aterrizado o est� en tierra.
    private String piloto;
    private int tipoVuelo;              // ser� de "escuela" o "privado". Por defecto ser� de "escuela". 
    private int tiempoTotalVuelo;       // en minutos
    private String mensajeDeEstado;     // mensaje informativo sobre el estado actual de la aeronave

    // Atributos de Informaci�n de vuelo: gestionan informaci�n sobre los par�metros de vuelo en un momento dado
    private int velocidad;              // en km/h  
    private int rumbo;                  // en grados
    private int altitud;                // en metros

    // CONSTRUCTORES
    // --------------------------------------------
    // Constructor de 3 par�metros
    /**
     * Constructor de tres pr�metros.
     *
     * @param matricula Matr�cula de la aeronave.
     * @param modelo Modelo de la aeronave.
     * @param piloto Nombre del Piloto.
     * @throws NullPointerException Si alguno de los par�metros es null.
     * @throws IllegalArgumentException Si la matr�cula no coincide con el
     * formato especificado o si es una cadena vac�a.
     */
    public ComputadorVuelo(String matricula, String modelo, String piloto) throws NullPointerException, IllegalArgumentException {
        // Comprobaci�n de que ninguno de los atributos son nulos
        if (matricula == null) {
            throw new NullPointerException("La matr�cula de la aeronave no puede ser nula");
        } else if (modelo == null) {
            throw new NullPointerException("El modelo de la aeronave no puede ser nulo");
        } else if (piloto == null) {
            throw new NullPointerException("El Piloto de la aeronave no puede ser nulo");
        }

        // Comprobaci�n adicional de la matr�cula
        if (matricula.isEmpty()) {
            throw new IllegalArgumentException("La matr�cula es una cadena vac�a.");
        } else if (!matricula.matches("EC-[A-Z0-9]{3}")) {
            throw new IllegalArgumentException(String.format("El formato de la matr�cula es incorrecto: %s", matricula));
        }

        // Si todo sale bien, se actualizan los valores 
        this.matricula = matricula;
        this.modelo = modelo;
        this.piloto = piloto;

        // se aumente el n� de aeronaves creadas
        totalAeronavesCreadas++;
    }

    // Constructor de 2 par�metros
    /**
     * Constructor de dos par�metros.
     * <p>
     * Este constructor crear� una nueva instancia que representa a una
     * aeronave, identificada por la matr�cula y el modelo, usando el valor del
     * piloto por defecto (PILOTO_DEFECTO).
     * </p>
     *
     * @param matricula Matr�cula de la aeronave.
     * @param modelo Modelo de la aeronave.
     * @see #ComputadorVuelo(String, String, String)
     */
    public ComputadorVuelo(String matricula, String modelo) {
        this(matricula, modelo, PILOTO_DEFECTO);
    }

    // Constructor sin par�metros
    /**
     * Constructor sin par�metros.
     * <p>
     * Con este constructor se crear� un objeto con los tres atributos iniciados
     * a sus valores por defecto (MATRICULA_DEFECTO, MODELO_DEFECTO y
     * PILOTO_DEFECTO)
     * </p>
     *
     * @see #ComputadorVuelo(String, String, String)
     */
    public ComputadorVuelo() {
        this(MATRICULA_DEFECTO, MODELO_DEFECTO, PILOTO_DEFECTO);
    }

    // M�todo de f�brica o PSEUDOCONSTRUCTOR
    // --------------------------------------------
    /**
     * M�todo de f�brica.
     * <p>
     * Este m�todo recibir� como par�metro la cantidad de aeronaves y crear� un
     * array de referencias a instancias de la clase ComputadorVuelo. Cada
     * objeto ComputadorVuelo representar� a una aeronave creada con los
     * par�metros por omisi�n.
     * </p>
     *
     * @param totalAeronavesCreadas Total de aeronaves creadas.
     * @return Un array de objetos ComputadorVuelo con la cantidad de elementos
     * especificada por el par�metro totalAeronavesCreadas. Cada elemento del
     * array es una nueva instancia de ComputadorVuelo creada usando el
     * constructor sin par�metros.
     * @throws IllegalArgumentException Si el n� de aeronaves creadas es menor
     * que 1 o mayor que 10.
     */
    public static ComputadorVuelo[] crearArrayComputadorVuelo(int totalAeronavesCreadas) throws IllegalArgumentException {
        // validaci�n de la cantidad de aeronaves creadas
        if (totalAeronavesCreadas < 1 || totalAeronavesCreadas > 10) {
            throw new IllegalArgumentException(String.format("N�mero de aviones incorrecto %d, debe ser mayor o igual que 1 y menor o igual que 10", totalAeronavesCreadas));
        }
        // creamos el array
        ComputadorVuelo[] arrayAeronaves = new ComputadorVuelo[totalAeronavesCreadas];
        // recorremos el array y creamos las nuevas aeronaves con los par�metros por omisi�n usando el constructor sin par�metros
        for (int i = 0; i < totalAeronavesCreadas; i++) {
            arrayAeronaves[i] = new ComputadorVuelo();
        }
        return arrayAeronaves;
    }

    // GETTERS
    // --------------------------------------------
    // para la matr�cula: 
    /**
     * Obtiene la matr�cula de la aeronave.
     *
     * @return La matr�cula. Si no est� asignada, devolver� la matr�cula por
     * defecto.
     */
    public String getMatricula() {
        return (this.matricula != null ? this.matricula : MATRICULA_DEFECTO);
    }

    // para el modelo: 
    /**
     * Obtiene el modelo de la aeronave.
     *
     * @return El modelo. Si no est� asignadop, devolver� el modelo por defecto.
     */
    public String getModelo() {
        return (this.modelo != null ? this.modelo : MODELO_DEFECTO);
    }

    // para enVuelo: 
    /**
     * Obtiene si la aeronave est� volando o no.
     *
     * @return True - si est� volando. False - si est� en tierra.
     */
    public boolean isVolando() { // por defecto est� asignado como false
        return this.enVuelo;
    }

    // para el piloto: 
    /**
     * Obtiene el nombre del Piloto.
     *
     * @return El piloto. Si no est� asignado, devolver� el piloto por defecto.
     */
    public String getPiloto() {
        return (this.piloto != null ? this.piloto : PILOTO_DEFECTO);
    }

    // para tipo de vuelo: 
    /**
     * Obtiene el tipo de vuelo.
     *
     * @return 0 - Si es de tipo escuela. 1 - Si es de tipo privado.
     */
    public int getTipoVuelo() { // por defecto los tipo int se inicializan en 0 (equivalente a VUELO_ESCUELA en nuestro caso)
        return this.tipoVuelo;
    }

    // para el tiempo total de vuelo: 
    /**
     * Obtiene el tiempo total de vuelo de la aeronave en minutos.
     *
     * @return El tiempo total de vuelo de la aeronave hasta el momento. Si se
     * acaba de crear, debe ser 0.
     */
    public int getTiempoTotalVuelo() {
        return this.tiempoTotalVuelo;
    }

    // para la velocidad: 
    /**
     * Obtiene la velocidad de la aeronave en km/h.
     *
     * @return La velocidad en km/h. Si la aeronave no est� volando, debe ser 0.
     */
    public int getVelocidad() {
        return this.velocidad;
    }

    // para rumbo: 
    /**
     * Obtiene el rumbo de la aeronave en grados.
     *
     * @return El rumbo en grados. Si la aeronave no est� volando, debe ser 0.
     */
    public int getRumbo() {
        return this.rumbo;
    }

    // para la altitud: 
    /**
     * Obtiene la altitud de la aeronave.
     *
     * @return La altitud en metros. Si la aeronave no est� volando, debe ser 0.
     */
    public int getAltitud() {
        return this.altitud;
    }

    // SETTERS 
    // --------------------------------------------
    // para velocidad
    /**
     * Modifica la velocidad de la aeronave.
     *
     * @param velocidad Velocidad de la aeronave.
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    // para el rumbo
    /**
     * Modifica el rumbo de la aeronave.
     *
     * @param rumbo Rumbo de la aeronave.
     */
    public void setRumbo(int rumbo) {
        this.rumbo = rumbo;
    }

    // para la altitud
    /**
     * Modifica la altitud de la aeronave.
     * <p>
     * La altitud debe estar comprendida entre MIN_ALTITUD Y MAX_ALTITUD. En
     * caso contrario, se establecer� el valor MIN_ALTITUD.</p>
     *
     * @param altitud Altitud de la aeronave.
     */
    public void setAltitud(int altitud) {
        if (altitud >= MIN_ALTITUD && altitud <= MAX_ALTITUD) {
            this.altitud = altitud;
        } else {
            this.altitud = MIN_ALTITUD;
        }
    }

    // M�TODOS EST�TICOS (GETTERS DE TIPO EST�TICO)
    // --------------------------------------------
    // N�mero de aeronaves creadas hasta el momento
    /**
     * Obtiene el n�mero total de aeronaves creadas.
     *
     * @return N�mero total de aeronaves creadas
     */
    public static int getNumAeronaves() {
        return totalAeronavesCreadas;
    }

    // Cantidad de aeronaves que est�n volando en un momento dado
    /**
     * Obtiene la cantidad de aeronaves que est�n volando.
     *
     * @return N�mero total de aeronaves volando.
     */
    public static int getNumAeronavesVolando() {
        return totalAeronavesVolando;
    }

    // N�mero total de horas de vuelo de la escuela (float).
    /**
     * Obtiene el n�mero total de horas de vuelo de la escuela.
     *
     * @return N�mero total de horas de vuelo de todas las aeronaves de la
     * escuela.
     */
    public static float getNumHorasVuelo() {
        return totalHorasVueloTodasAeronaves;
    }

    // M�TODOS DE ACCI�N 
    // --------------------------------------------
    // M�todo despegar() 
    /**
     * Despega la aeronave.
     *
     * @param tipoVuelo Tipo de vuelo.
     * @param velocidad Velocidad que lleva.
     * @param altitud Altitud que lleva.
     * @throws IllegalArgumentException Si la altitud no est� dentro de los
     * l�mites establecidos.
     * @throws IllegalStateException Si la aeronave ya ha despegado.
     */
    public void despegar(int tipoVuelo, int velocidad, int altitud) throws IllegalArgumentException, IllegalStateException {
        // comprobamos primero que la altitud est� dentro de los l�mites       
        if (altitud < MIN_ALTITUD || altitud > MAX_ALTITUD) {
            throw new IllegalArgumentException(String.format("La altitud de vuelo de %d metros es incorrecta", altitud));
        }
        // comprobamos si la aeronave ya est� volando 
        if (isVolando()) {
            throw new IllegalStateException(String.format("%s ya ha despegado y se encuentra fuera del aeropuerto", getMatricula()));
        }
        // si todo est� correcto, despegamos y actualizamos valores
        this.enVuelo = true;
        this.tipoVuelo = tipoVuelo;
        setVelocidad(velocidad);
        setAltitud(altitud);
        totalAeronavesVolando++;
    }

    // M�todo aterrizar()
    /**
     * Aterriza la aeronave.
     *
     * @param aeropuertoSalida C�digo del aeropuerto de procedencia.
     * @param aeropuertoLlegada C�digo del aeropuerto de llegada.
     * @param tiempoDeVuelo Tiempo de vuelo (en minutos) que lleva la aeronave.
     * @throws IllegalStateException Si la aeronave ya ha aterrizado.
     */
    public void aterrizar(String aeropuertoSalida, String aeropuertoLlegada, int tiempoDeVuelo) throws IllegalStateException {
        if (!isVolando()) {
            throw new IllegalStateException(String.format("%s ya ha aterrizado y debe despegar de nuevo antes de volver a aterrizar", getMatricula()));
        }
        tiempoTotalVuelo += tiempoDeVuelo;
        totalHorasVueloTodasAeronaves += (float) tiempoDeVuelo / 60;

        this.enVuelo = false;
        setVelocidad(0);
        this.altitud = 0;
        totalAeronavesVolando--;
    }

    // M�TODO toString() 
    // --------------------------------------------
    /**
     * Devuelve una cadena que represente el estado del Computador de Vuelo en
     * un momento dado. Esa cadena proporcionar� la siguiente informaci�n:
     * <ol>
     * <li><strong>Matr�cula</strong> de la aeronave.</li>
     * <li><strong>Modelo</strong> de la aeronave.</li>
     * <li>Valor del atributo <strong>enVuelo</strong></li>
     * <li><strong>Piloto</strong> de la aeronave.</li>
     * <li><strong>Tipo de vuelo</strong> que est� realizando la aeronave.</li>
     * <li><strong>Tiempo total de vuelo</strong> de la aeronave.</li>
     * <li><strong>Velocidad</strong> de la aeronave.</li>
     * <li><strong>Rumbo</strong> de la aeronave.</li>
     * <li><strong>Altitud</strong> de la aeronave.</li>
     * </ol>
     * <p>
     * <strong>Un ejemplo del formato de salida ser�a el siguiente:</strong></p>
     * <pre>[Matricula=EC-FA3, Modelo=Eurostar Evektor EV-97, isVolando=false, Piloto=Pepito P�rez, TipoVuelo=1, TiempoTotal=230, V=0 km/h, Rumbo=0�, Altitud=0 metros]</pre>
     *
     * @return Cadena que representa el estado del Computador de Vuelo actual.
     */
    @Override
    public String toString() {
        return String.format("[Matricula=%s, Modelo=%s, isVolando=%b, Piloto=%s, TipoVuelo=%d, TiempoTotal=%d, V=%d km/h, Rumbo=%d�, Altitud=%d metros]",
                getMatricula(), getModelo(), isVolando(), getPiloto(), getTipoVuelo(),
                getTiempoTotalVuelo(), getVelocidad(), getRumbo(), getAltitud());
    }

}
