<?php

/**
 * Clase controlador principal. Se encarga de poder cargar los modelos y las vistas
 */
class Controlador {

    /**
     * Cargar modelo
     *
     * @param  mixed $modelo
     * @return void
     */
    public function modelo($modelo){

        // Carga modeo
        require_once '../app/modelos/'. $modelo . '.php';
        
        // Instanciar el modelo 
        return new $modelo();
    }
    
    /**
     * Cargar vista
     *
     * @param  mixed $vista Vista a mostrar
     * @param  mixed $datos Datos a mostrar
     * @return void
     */
    public function vista($vista, $datos = []){

        // Chequear si el archivo existe
        if (file_exists('../app/vistas/' . $vista . '.php')) {

            require_once '../app/vistas/' . $vista . '.php';
        }else{

            // Si el archivo de la vista no existe
            die('La vista no existe');
        }
    }
}