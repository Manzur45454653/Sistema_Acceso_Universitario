<?php

// Configuramos la conexción con la base de datos, con variables de tipo globales.
define('DB_HOST', 'localhost');
define('DB_USUARIO', '_SU_USUARIO');// Usuario dela DB
define('DB_PASSWORD', '_SU_PASSWORD');// Password de la DB
define('DB_NOMBRE', '_SU_BASE_DATOS');// Nombre de la DB

// Ruta de la aplicación. Ejemplo: CURSO_MVC/app
define('RUTA_APP',dirname(dirname(__FILE__)));

// Ruta url Ejemplo: http://localhost/CURSO_MVC/
define('RUTA_URL','_AQUI_RUTA_');

// Ruta de las imagenes almacenadas en el servidor. Utiliza una ruta absoluta del sistema en lugar de una URL.
define('RUTA_SERVER','_AQUI_RUTA_');// Ruta del directorio, de manera del disco: C:/xampp/htdocs/uploads/
define('RUTA_FILE','_AQUI_RUTA_');// Ruta tipo url,para mostrar archivos guardados en el servidor: http://localhost/uploads/
// Nombre del sitio web
define('NOMBRE_SITIO','_NOMBRE_SITIO');

// Palabras clave para motores de búsqueda
define('PALABRAS_CLAVE','_PALABRAS_CLAVE_DEL_SITIO');

// Descripción del sitio
define('DESCRIPCION_SITIO','_DESCRIPCION_DE_TU_SITIO');

// Autor del sitio
define('AUTOR_SITIO','_AUTOR_DEL_SITIO');