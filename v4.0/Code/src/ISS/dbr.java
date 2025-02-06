
package ISS;

import java.sql.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;

//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
//  #################### CLASS dbv
//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
/**
 * Conexión con la base de datos, realiza consulta a la base de datos de los End User.
 * Almacena la información de los End User.
 * La base de datos simula la información almacenada por parte de la UACM; toda la información 
 * almacenada es ficticia, es utilizada para pruebas de funcionamiento.
 *
 * <p>
 * <b>Programa:</b> Acceso UACM <br>
 * <b>Autor:</b> Guadalupe Yamileth Valadez Carmona <br>
 * <b>Autor:</b> Rodríguez Cervantes Kevin Manzur <br>
 * <b>Autor:</b> Romero Cervantes Fátima Daniela <br>
 * <b>Autor:</b> Rodríguez Sánchez Diana Fabiola <br>
 * <b>Autor:</b> Cruz Ovando Cristela Adelaida <br> 
 * <b>Versión:</b> 4.00 <br>
 * <b>Fecha de implementación:</b> 22 - Noviembre - 2024 <br>
 * <b>Aviso legal:</b> Este código es propiedad intelectual de los alumnos Rodríguez
 * Cervantes Kevin Manzur, Guadalupe Yamileth Valadez Carmona, Romero Cervantes Fátima Daniela,
 * Rodríguez Sánchez Diana Fabiola, Cruz Ovando Cristela Adelaida y está protegido por las leyes 
 * de propiedad intelectual en México, incluyendo la Ley Federal del Derecho de Autor. 
 * No puede ser distribuido, compartido o utilizado fuera del ámbito educativo sin permiso
 * explícito de los autores. La violación de estas leyes puede conllevar a sanciones
 * civiles y penales según lo estipulado en la legislación mexicana.
 */
public class dbr {

    //	--------------------------------------------------
    //	-------------------- ATRIBUTOS
    //	--------------------------------------------------  
    /**
     * Nombre de la base de datos.
     */    
    private String databaseUrl = "jdbc:mysql://localhost:3306/accesouacmenduser";
    /**
     * Usuario con el que se conectara a la base de datos.
     */
    private String username = "root";
    /**
     * Contraseña del usuario.
     */
    private String password = "root";
       
    /**
     * Realiza una búsqueda en la base de datos, comprueba si existe el identificador en la columna matricula. 
     * De existir, retorna un string, informando que sí existe; en caso contrario, retorna un 
     * string indicando que no existe. 
     * 
     * @param identificador Identificador.
     * @return Retona un String, este indica si el identificador se encintro en la base de datos de End User.
     */
    public String buscaEnd(String identificador)  {
        // Establecemos conexión y ejecutamos la consulta
        
        String query = "SELECT matricula FROM accesouacmenduser.usuarios WHERE matricula = ?";// Query
        
        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, identificador);// Establecemos el parámetro del identificador

            // Imprimir la consulta final con el parámetro ya incluido
            //System.out.println("\nQuery End User: SELECT matricula FROM accesouacmenduser.usuarios WHERE matricula = '" + identificador + "'");
            
            ResultSet resultSet = preparedStatement.executeQuery();// Ejecutamos la consulta
            //System.out.println("Consultando End User:");

            // Verificamos si hay resultados
            if (resultSet.next()) {
                //System.out.println("DBR: YesEnd\n\n");
                return "YesEnd"; // La fila con el identificador existe
                
            } else {
                //System.out.println("DBR: Error: End User no encontrado\n\n");
                return "ErrorEnd"; // La fila con el identificador no existe
            }
        } catch (SQLException e) {
            // Identificar el error específico
            if (e.getSQLState().startsWith("42")) { // SQLState "42" indica errores de sintaxis o tabla no encontrada
                System.err.println("Error: La tabla accesouacmenduser.usuarios no existe.");
            } else if (e.getSQLState().equals("02000")) { // SQLState "02000" indica que no se encontró la fila
                System.err.println("Error: No se encontró ninguna fila con la matricula proporcionado.");
            } else {
                System.err.println("Error desconocido al consultar la base de datos: " + e.getMessage());
            }
            return "Error";
        }          
    }
    
    /**
     * Retornamos el nombre completo del End User almacenado en la DB.
     * 
     * @param identificador Identificador.
     * @return Nombre completo del End USer.
     */
    public String getEndUserNombre(String identificador){
       
        String query = "SELECT nombre,apellidoM,apellidoP,asignacion,fotografia FROM accesouacmenduser.usuarios WHERE matricula = ?";// Consulta SQL para obtener el nombre

        int id = Integer.parseInt(identificador);// Convertimos el identificador de String a int
        
        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Asignar el valor del identificador al parámetro de la consulta
            preparedStatement.setInt(1, id);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Retornamos el nombre completo.
                
                String nombre = resultSet.getString("nombre");
                String apellidoM = resultSet.getString("apellidoM");
                String apellidoP = resultSet.getString("apellidoP"); 
                //System.out.println("Nombre: " + nombre + ", apellidoM: " + apellidoM + ", apellidoP: " + apellidoP);
                System.out.println("\nUsuario: End User.");
                System.out.println("Nombre: " + nombre + " " + apellidoM + " " + apellidoP);
                nombre = nombre + " " + apellidoM + " " + apellidoP;
                return nombre;  
            } else {
                // Retornar null si no se encuentra el identificador
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }                     
    }    
    
    /**
     * Retornamos la ocupación del End User.
     * 
     * @param identificador Identificador.
     * @return Retornamos la ocupación del End User.
     */
    public String getEndUserOcupacion(String identificador){
       
        String query = "SELECT asignacion FROM accesouacmenduser.usuarios WHERE matricula = ?";// Consulta SQL para obtener el nombre

        int id = Integer.parseInt(identificador);// Convertimos el identificador de String a int
        
        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Asignar el valor del identificador al parámetro de la consulta
            preparedStatement.setInt(1, id);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Retornamos el nombre completo.
                
                String asignacion = resultSet.getString("asignacion");
                //System.out.println("Ocupación: " + asignacion);
                return asignacion;  
            } else {
                // Retornar null si no se encuentra el identificador
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }                     
    }    
    
    /**
     * Obtiene la fotografía almacenada en la DB, y la retorna para ser mostrada en la interfaz.
     * 
     * @param identificador Identificador para un End User
     * @return Fotografia almacenada en la base de datos.
     */
    public BufferedImage EndUserImg(String identificador) {
        BufferedImage image = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesouacmvisitante", "root", "root");
            String query = "SELECT fotografia FROM accesouacmenduser.usuarios WHERE matricula = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, identificador);
            rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] imgBytes = rs.getBytes("fotografia");
                if (imgBytes != null) {
                    image = ImageIO.read(new ByteArrayInputStream(imgBytes));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return image;
    }
    
}
