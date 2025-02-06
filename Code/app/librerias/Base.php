<?php
// Clase para conectarse a la base de datos, ejecutar consultas PDO
class Base {
      
    /**
     * Host del servidor
     *
     * @var global
     */
    private $host;
       
    /**
     * Nombre de usuario de la DB
     *
     * @var global
     */
    private $usuario;
       
    /**
     * Contraseña de la DB
     *
     * @var global
     */
    private $password;
     
    /**
     * Nombre de la DB
     *
     * @var global
     */
    private $nombre_base;
     
    /**
     * database hander
     *
     * @var mixed
     */
    private $dbh;
      
    /**
     * stmt
     *
     * @var mixed
     */
    private $stmt; 
    
    /**
     * Error de la conexción
     *
     * @var mixed
     */
    private $error;
    
    /**
     * Establecemos la conexción con la BD
     *
     * @return void
     */
    public function __construct() {
        $this->host = getenv('DB_HOST');
        $this->usuario = getenv('DB_USUARIO');
        $this->password = getenv('DB_PASSWORD');
        $this->nombre_base = getenv('DB_NOMBRE');

        // Configurar conexión
        $dsn = 'mysql:host=' . $this->host . ';dbname=' . $this->nombre_base;
        $opciones = array(
            PDO::ATTR_PERSISTENT => true,
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
        );

        // Crear una instancioa PDO
        try {

            $this->dbh = new PDO($dsn, $this->usuario, $this->password, $opciones);
            $this->dbh->exec('set names utf8');// Para trabajar con caracteres de latinoamerica.

        } catch (PDOException $e) {
            // Manejo de un error, evitamos mostrarlo en producción.
            $this->error = $e->getMessage();
            error_log($this->error); // Registra el error en el log del servidor
            die('Ocurrió un problema con la base de datos.');
        }
    }
  
    /**
     * Preparamos la consulta
     *
     * @param  mixed $sql
     * @return void
     */
    public function query($sql) {
        $this->stmt = $this->dbh->prepare($sql);
    }

    /**
     * Vinculamos la consulta con bind
     *
     * @param  mixed $parametro
     * @param  mixed $valor
     * @param  mixed $tipo
     * @return void
     */
    public function bind($parametro, $valor, $tipo = null) {
        // Comprueba si la variable dada es null.
        if (is_null($tipo)) {
            $tipo = match (true) {
                is_int($valor) => PDO::PARAM_INT,
                is_bool($valor) => PDO::PARAM_BOOL,
                is_null($valor) => PDO::PARAM_NULL,
                default => PDO::PARAM_STR,
            };
        }
        $this->stmt->bindValue($parametro, $valor, $tipo);
    }

    /**
     * Ejecuta la consulta    
     *
     * @return void
     */
    public function execute() {
        return $this->stmt->execute();
    }
    
    /**
     * Obtiene todos los registros de la consulta actual.
     *
     * @return array|false Devuelve un array de objetos con los resultados o `false` si falla.
     */
    public function registros() {
        $this->execute();
        return $this->stmt->fetchAll(PDO::FETCH_OBJ);
    }

    
    /**
     * Optener un solo registro    
     *
     * @return void
     */
    public function registro() {
        $this->execute();
        return $this->stmt->fetch(PDO::FETCH_OBJ);
    }
    
    /**
     * Optener cantidad de filas con el metodo rowCount    
     *
     * @return void
     */
    public function rowCount() {
        return $this->stmt->rowCount();
    }

    /**
     * Cierra la conexión con la base de datos.
     */
    public function close() {
        $this->dbh = null;
    }

}