<?php
// Cargamos librerias
require_once 'config/configurar.php';

require_once 'helpers/url_helper.php';

// Autoload php
/**
 * Utilizamos la función para cargar todas las librerias de la ruta, de manera que 
 * disminuimos las lineas. Funciona como un ciclo, de manera que requiere 
 * todos todos los archivos de la ruta, con esto disminuimos las lineas:
 * require_once 'librerias/Base.php';
 * require_once 'librerias/Controlador.php';
 * require_once 'librerias/Core.php';
 */
spl_autoload_register(function($nombreClase){
    require_once 'librerias/' . $nombreClase . '.php';
});