<?php

/**
 * Sanitiza la información para guardarla en la DB, evitando inyecciones.
 */
class Sanitiza {
    
    /**
     * Sanitiza la información.
     *
     * @param  mixed $data Información a satinizar.
     * @return void Información satinizada.
     */
    private function sanitize_input($data) {
        $data = trim($data); // Eliminar espacios en blanco al inicio y al final
        $data = stripslashes($data); // Eliminar barras invertidas
        $data = htmlspecialchars($data); // Convertir caracteres especiales en entidades HTML
        return $data;
    }
}