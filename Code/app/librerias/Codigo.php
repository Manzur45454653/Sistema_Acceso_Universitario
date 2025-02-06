<?php

/**
 * Generamos códigos aleatorios de tipo númericos o utilizando combinaciones.
 */
class Codigo {
        
    /**
     * Genera un código númerico de una longitud definida.
     *
     * @param  mixed $inicio de la longitud
     * @param  mixed $limite de la longitud
     * @return void Código númerico de ongitud definida.
     */
    public static function codeRandom($inicio, $limite)
    {
        // Optenemos el tamaño el cual sera el codigo id del usuario
        $length = rand($inicio, $limite);

        $number = "";
        
        for ($i = 0; $i < $length; $i++) {
            // Optenemos el número aleatorio para optener el id
            $new_rand = rand(0, 9);
            $number = $number . $new_rand;
        }

        return $number;
    }
}