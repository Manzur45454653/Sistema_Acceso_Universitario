<?php

/**
 * Ciframos y deciframos la información de la DB.
 */
class Cifrado {
        
    // Clave y vector de inicialización (IV) estáticos (asegúrate de usar las longitudes correctas)

    /**
     * Clave de 32 cáracteres para el cifrado OpenSSL.
     *
     * @param  static $clave Clave
     * @return void 
     */
    private static $clave = 'claveestticasegura23567890123456'; // 32 caracteres
    /**
     * Vector de inicialización (IV), para cifrado OpenSSL.
     *
     * @param  static $iv Información a cifrar.
     * @return void 
     */
    private static $iv = 'ivestatico123456';    

    /**
     * Cifrado irreversible con  sha512
     *
     * @param  mixed $data Información a cifrar.
     * @return void Información cifrada sha1
     */
    public function cifradoSha1($data) {
        $data = hash("sha1", $data);
        return $data;
    }

    /**
     * Cifrado unico con sha512, con una longitud de 129 cáracteres.
     *
     * @param  mixed $data Información a cifrar.
     * @return void Información cifrada sha512
     */
    public function cifradoSha512($data) {
        $data =  hash("sha512", $data);
        return $data;
    }

    /**
     * Cifra la información con OpenSSL, esta es reversible.
     * 
     * @param string $data Información a cifrar
     * @return string Texto cifrado en Base64
     */
    public function cifradoOpenSSL ($data) {

        // Validar que la clave y el IV tienen las longitudes requeridas
        if (strlen(self::$clave) !== 32 || strlen(self::$iv) !== 16) {
            throw new Exception("La clave o el IV no cumplen con los requisitos de longitud.");
        }

        // Cifrar el texto
        $cifrado = openssl_encrypt($data, 'aes-256-cbc', self::$clave, 0, self::$iv);

        // Retornar el texto cifrado en Base64
        return base64_encode($cifrado);
    }

    /**
     * Desiframos la información, de cifrado OpenSSL.
     * 
     * @param string $encryptedData Texto cifrado en Base64
     * @return string Texto descifrado
     */
    public static function decifraOpenSSL($data)
    {
        // Decodificar el texto cifrado de Base64
        $data = base64_decode($data);

        // Descifrar el texto
        $data = openssl_decrypt($data, 'aes-256-cbc', self::$clave, 0, self::$iv);

        // Retornar el texto descifrado
        return $data;
    }    
}