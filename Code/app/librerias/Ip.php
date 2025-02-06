<?php

/**
 * Optenemos la ip del usuario.
 */
class Ip {
        
    /**
     * Optenemos la dirección ip del dispositivo del usuario, controlamos si utiliza proxy o otro metodo para 
     * ocultarla.
     *
     * @return void IP real del usuario.
     */
    private function obtener_ip_usuario() {

        // Verifica si el usuario está detrás de un proxy
        if (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {
            // Si existe un valor en X-Forwarded-For, lo usamos (esto es más común en proxies)

           $ip = $_SERVER['HTTP_X_FORWARDED_FOR'];
        } else {
            // Si no existe un valor, usamos la dirección IP remota
            $ip = $_SERVER['REMOTE_ADDR'];
        }
        return $ip;
    }
        
    /**
     * Optenemos la IP real del usuario.
     *
     * @return void IP real del usuario.
     */
    public function getIp(){
        return $this->obtener_ip_usuario();
    }
}