<?php
/*
Instrucciones para la implementación del framework
1. Cambiar el directorio de la carpeta, en el archivo '.htaccess', el cual esta ubicado /public/.htaccess
2. Establecer las configuraciones del proyecto, en el archivo /app/config/configurar.php. Establecer la conexión con 
   la base de datos, y los directorios del proyecto. Estas variables son globales.
3. En el controlador /app/controlers/Paginas.php, crear '$this->instructorModelo = $this->modelo('Instructor');' en el constructor, la variable instructorModelo es inventada,
   lo que se realiza es instanciar un nuevo modelo.
4. Para instanciar un nuevo modelo, este se tiene que crear en la ruta /app/modelos/, el cual debe empesar con mayuscula y en singular.
   Despues es necesario crearle su constructor, para evitar problemas.
5. Si el modelo se conecta con la BD, se inicializa en el constructor.



 */
