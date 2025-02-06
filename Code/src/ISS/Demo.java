
package ISS;

//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
//  #################### CLASS Demo
//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
/**
 * Esta clase contiene el método principal del programa, que es el punto de entrada 
 * al ejecutar la aplicación. Al ejecutarse, se muestra una interfaz gráfica al usuario.
 * 
 * <p>
 * <b>Programa:</b> Acceso UACM <br>
 * <b>Autor:</b> Guadalupe Yamileth Valadez Carmona <br>
 * <b>Autor:</b> Rodríguez Cervantes Kevin Manzur <br>
 * <b>Autor:</b> Romero Cervantes Fátima Daniela <br>
 * <b>Autor:</b> Rodríguez Sánchez Diana Fabiola <br>
 * <b>Autor:</b> Cruz Ovando Cristela Adelaida <br> 
 * <b>Versión programa:</b> 4.00 <br>
 * <b>Fecha de implementación:</b> 22 - Noviembre - 2024 <br>
 * <b>Aviso legal:</b> Este código es propiedad intelectual de los alumnos Rodríguez
 * Cervantes Kevin Manzur, Guadalupe Yamileth Valadez Carmona, Romero Cervantes Fátima Daniela,
 * Rodríguez Sánchez Diana Fabiola, Cruz Ovando Cristela Adelaida y está protegido por las leyes 
 * de propiedad intelectual en México, incluyendo la Ley Federal del Derecho de Autor. 
 * No puede ser distribuido, compartido o utilizado fuera del ámbito educativo sin permiso
 * explícito de los autores. La violación de estas leyes puede conllevar a sanciones
 * civiles y penales según lo estipulado en la legislación mexicana.
 */
public class Demo {

    //	============================================================
    //	==================== CLASE MAIN
    //	============================================================
    /**
     * Clase main del programa, muestra la interfaz gráfica, en la cual 
     * se pueden hacer diferentes operaciones. 
     *
     * @param args Argumentos.
     */
     public static void main(String[] args) {

        interfaz1 OInterfaz1 = new interfaz1();// Implementado para lanzar la interfaz gráfica. 
        OInterfaz1.run();// Método:  Muestra o activa la interfaz gráfica. 

    }

}

/*

----- END USER ----

https://test/UACM/demo_form.php?id=123456783&name2=Andrea
https://test/UACM/demo_form.php?id=123456787&name2=Isabella
https://test/UACM/demo_form.php?id=123456800&name2=Emiliano
https://test/UACM/demo_form.php?id=123456799&name2=Leonardo

----- VISITANTES ----

https://test/demo_form.php?identi=372845093012345&name2=Maria
https://test/demo_form.php?identi=5840129387&name2=Laura
https://test/demo_form.php?identi=18490324501&name2=Elena
https://test/demo_form.php?identi=2847593012487&name2=Luis

*/