<?php
ob_start(); // Inicia un almacenamiento en búfer.
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="id=edge">
    <title><?php echo NOMBRE_SITIO;?></title>
    <meta name="keywords" content="<?php echo PALABRAS_CLAVE; ?>">
    <meta name="description" content="<?php echo DESCRIPCION_SITIO; ?>">
    <meta name="author" content="<?php echo AUTOR_SITIO; ?>">
    <link rel="stylesheet" href="<?php echo RUTA_URL; ?>/css/style.css">
    <link rel="shortcut icon" href="<?php echo RUTA_URL; ?>public/favicon/favicon.ico" type="image/x-icon">
</head>
<body>
