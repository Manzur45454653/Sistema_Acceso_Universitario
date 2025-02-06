<?php

class Paginas extends Controlador{
        
    /**
     * Constructor
     *
     * @return void
     */
    public function __construct(){
        
    }
    
    /**
     * Index de la clase
     *
     * @return void
     */
    public function index(){
        $datos = [
            'titulo' => 'Bienvenida a MVC Render2web',
        ];
        $this->vista('paginas/inicio', $datos);
    }
}