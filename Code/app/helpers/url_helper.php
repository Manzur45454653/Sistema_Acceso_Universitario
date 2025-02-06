<?php

// Para redirecionar la página
function redireccionar($pagina) {
    header('location: ' . RUTA_URL . $pagina);
}