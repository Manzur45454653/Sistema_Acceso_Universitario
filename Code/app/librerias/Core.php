<?php

/**
 * Mapear la url ingresada en el navegador:
 * 1. controlador
 * 2. metodo
 * 3. parametro
 * Ejemplo: /articulo/actualizar/4
 */
class Core {

    // Mientras no se ponga nada en la url, se carga la vista por defecto
    /**
     * Controlador por defecto
     *
     * @var string
     */
    protected $controladorActual = 'paginas';
    /**
     * Metodo por defecto
     *
     * @var string
     */
    protected $metodoActual = 'index';    
    /**
     * Array vacio por defecto
     *
     * @var array
     */
    protected $parametros = [];
   
    /**
     * Establecemos el controlador y el metodo por defecto, en caso de que no se establesca 
     * nada por la url. Si se estabece algo por la url, se redirecciona al modelo
     * y la vita.
     *
     * @return void
     */
    public function __construct(){

        $url = $this->getUrl(); // url descompuesta en un array

        // echo "<pre>"; print_r($this->getUrl()); echo "</pre>";

        // Buscar en controladores si el controlador existe, si no carcamos el controlador por defecto.
        if (isset($url[0])) {
            
            if (file_exists('../app/controlers/'.ucwords($url[0].'.php'))) {
                // Si existe se setea como controlador por defecto
                $this->controladorActual = ucwords($url[0]);
    
                // unset indice
                unset($url[0]);
            }
        }

        // Requerir el controlador, si no hay uno en la url, se usa el que esta por defecto
        require_once '../app/controlers/'. ucwords($this->controladorActual) . '.php';
        $this->controladorActual = new $this->controladorActual;

        // Chequear o verificar la segunda parte de la url que sería el método
        if (isset($url[1])) {
            
            if (method_exists($this->controladorActual, $url[1])) {
                // Chequeamos el método
                $this->metodoActual = $url[1];
                
                // unset indice
                unset($url[1]);
            }
        }

        // echo $this->metodoActual; // Para probar
        
        // Obtener los posibles parametros
        $this->parametros = $url ? array_values($url) : [];

        // Llamar a calback con parametros array
        call_user_func_array([$this->controladorActual, $this->metodoActual], $this->parametros);
    }
    
    /**
     * Comprobamos si hay algo en la url del sitio, si esta la ruta del sitio, no retorna nada.
     * En caso de existir algo en la ruta de la url, esta se descompone en un array, utilizando 
     * el caracter '/' para separarla en el array.
     *
     * @return void url descompuesta en un array.
     */
    public function getUrl(){
        // echo $_GET['url'];
        if(isset($_GET['url'])){// Comprobamos si existe algo en la url
            $url = rtrim($_GET['url'], '/');
            $url = filter_var($url, FILTER_SANITIZE_URL);
            $url = explode('/',$url);
            return $url;
        }
    }
}