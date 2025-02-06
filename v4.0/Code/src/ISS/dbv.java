
package ISS;

import java.sql.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import javax.swing.JOptionPane;

//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
//  #################### CLASS dbv
//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
/**
 * Conexión con la base de datos, realiza consultas y agrega información a la base de datos de visitantes. 
 * Es utilizada para almacenar la información de cada visitante en el plantel Cuautepec. 
 * Toda la información almacenada es ficticia, es utilizada para pruebas de funcionamiento.
 *
 * <p>
 * <b>Programa:</b> Acceso UACM. <br>
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
public class dbv {

    //	--------------------------------------------------
    //	-------------------- OBJETOS
    //	--------------------------------------------------    
    /**
     * Genera un QR nuevo, exclusivo para los visitantes.
     */
    newQR OCodeQR = new newQR();    
    
    //	--------------------------------------------------
    //	-------------------- ATRIBUTOS
    //	--------------------------------------------------   
    /**
     * Nombre de la base de datos.
     */
    private String databaseUrl = "jdbc:mysql://localhost:3306/accesouacmvisitante";
    /**
     * Usuario con el que se conectara a la base de datos.
     */
    private String username = "root";
    /**
     * Contraseña del usuario.
     */
    private String password = "root";   
    
    /**
     * Realiza una búsqueda en la base de datos, comprueba si existe el identificador en la columna id. 
     * De existir, retorna un string, informando que sí existe; en caso contrario, retorna un 
     * string indicando que no existe. 
     * 
     * @param identificador Identificador.
     * @return Retona un String, este indica si el identificador se encintro en la base de datos de visitantes.
     */
    public String buscaVis(String identificador) {
        String queryVis = "SELECT id FROM accesouacmvisitante.visitantes WHERE id = ?";// Query para el metodo -> buscaVis
        
        // Establecemos conexión y ejecutamos la consulta
        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(queryVis)) {
                        
            preparedStatement.setString(1, identificador);// Establecemos el parámetro del identificador

            // Imprimir la consulta final con el parámetro ya incluido
            //System.out.println("SELECT id FROM accesouacmvisitante.visitantes WHERE id = '" + identificador + "'");
            
            ResultSet resultSet = preparedStatement.executeQuery();// Ejecutamos la consulta

            // Verificamos si hay resultados
            if (resultSet.next()) {
                //System.out.println("\nDBR: YesVis");
                return "YesVis"; // La fila con el identificador existe
                
            } else {
                //System.out.println("\nDBR: Error: Vis no encontrado.");
                return "ErrorVis"; // La fila con el identificador no existe
            }
            
        } catch (SQLException e) {// Manejamos la excepción.
            
            // Identificar el error específico
            if (e.getSQLState().startsWith("42")) { // SQLState "42" indica errores de sintaxis o tabla no encontrada
                System.err.println("Error: La tabla visitantes no existe.");
                
            } else if (e.getSQLState().equals("02000")) { // SQLState "02000" indica que no se encontró la fila
                System.err.println("Error: No se encontró ninguna fila con la id proporcionado.");
                
            } else {
                System.err.println("Error desconocido al consultar la base de datos: " + e.getMessage());
            }
            
            return "Error";
        } 
    }
      
   
    /**
     * Retorna el nombre completo almacenado en la base de datos, solo retorna el nombre que coincida
     * con el identificador numérico pasado como parámetro.
     * 
     * @param identificador Identificador.
     * @return Nombre completo de visitante.
     */
    public String getVisNombre(String identificador){
        
        String query = "SELECT nombre,apellidoM,apellidoP FROM accesouacmvisitante.visitantes WHERE id = ?";
        //int id = Integer.parseInt(identificador);  // Convierte el String a int
        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Asignar el valor del identificador al parámetro de la consulta
            preparedStatement.setString(1, identificador);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Retornamos el nombre completo.
                
                String nombre = resultSet.getString("nombre");
                String apellidoM = resultSet.getString("apellidoM");
                String apellidoP = resultSet.getString("apellidoP"); 
                //System.out.println("Nombre: " + nombre + ", apellidoM: " + apellidoM + ", apellidoP: " + apellidoP);
                System.out.println("\nUsuario: Visitante.");
                System.out.println("Nombre: " + nombre + " " + apellidoM + " " + apellidoP);
                nombre = nombre + " " + apellidoM + " " +apellidoP;
                return nombre;  
                
            } else {
                // Retornar null si no se encuentra el identificador
                return null;
            }

        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }     
    
    /**
     * Regista a un nuevo Visitante, y guarda su información a la DB.
     * 
     * @param nombre Nombre del visitante.
     * @param apellidoM Apellido Materno del Visitante.
     * @param apellidoP Apellido Paterno de Visitante
     * @param imagenBytes Imagen de la identificación oficial.
     * @param motivo Motivo de la visita.
     * @param duracion Duración  de la Visita.
     * @param QR Código QR.
     */
    public void setInsert(String nombre,String apellidoM,String apellidoP, byte[] imagenBytes,String motivo,int duracion) {
        String url = "jdbc:mysql://localhost:3306/accesouacmvisitante";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO visitantes (id,nombre, apellidoM, apellidoP, motivo, codeQR, identificacion,duracion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                String id = "", enlace = "";
                id = generarNumeroAleatorioConLongitud();
                //https://test/demo_form.php?identi=372845093012345&name2=Maria
                enlace = "https://test/demo_form.php?identi="+id+"&name2="+nombre;
                //time = String.valueOf(duracion);
                // Generar el código QR
                BufferedImage qrImage = OCodeQR.newQR(enlace);

                // Convertir BufferedImage a byte[]
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(qrImage, "png", baos); // Especifica el formato, por ejemplo "png"
                byte[] qrBytes = baos.toByteArray();

                // Configurar los valores en el PreparedStatement
                statement.setString(1, id);
                statement.setString(2, nombre);
                statement.setString(3, apellidoM);
                statement.setString(4, apellidoP);
                statement.setString(5, motivo);
                statement.setBytes(6, qrBytes); // Almacenar el código QR como BLOB
                statement.setBytes(7, imagenBytes); // Otra imagen proporcionada
                statement.setInt(8, duracion);

                statement.executeUpdate();
                System.out.println("\nInformación guardada con éxito.");
                JOptionPane.showMessageDialog(null, "Información guardada con éxito.");
            }
        } catch (Exception e) {
            System.out.println("\nError al guardar la información en la base de datos.");
            JOptionPane.showMessageDialog(null, "Error al guardar la información en la base de datos.");
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }        
    }

    
    /**
     * Genera un número aleatorio con una longitud aleatoria entre 5 y 15
     * 
     * @return Número aleatorio menor o igual a una longitud de 15
     */
    private static String generarNumeroAleatorioConLongitud() {
        Random random = new Random();

        // Genera una longitud aleatoria entre 5 y 15 (inclusive)
        int longitud = random.nextInt(11) + 5; // Entre 5 y 15

        StringBuilder numero = new StringBuilder();

        // Generar el primer dígito (asegurándose de que no sea 0)
        numero.append(random.nextInt(9) + 1); // Primer dígito entre 1 y 9

        // Generar los demás dígitos (pueden ser 0 a 9)
        for (int i = 1; i < longitud; i++) {
            numero.append(random.nextInt(10)); // Dígitos entre 0 y 9
        }

        // Convertir el número generado en una variable long
        long id;
        id = Long.parseLong(numero.toString());
        String Id;
        Id = String.format("%d", id);
        return Id;
    }    
    
    /**
     * Muestra la imagen de la identificación proporcionada en su registro.
     * 
     * @param id Identificador de un End User
     * @return Fotografia almacenada en la base de datos.
     */
    public BufferedImage visitanteImg(String id) {
        BufferedImage image = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesouacmvisitante", "root", "root");
            String query = "SELECT identificacion FROM accesouacmvisitante.visitantes WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] imgBytes = rs.getBytes("identificacion");
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
    
    /**
     * Retorna los registros, del mismo día en que se esté utilizando. No muestra registros de días anteriores.
     */
    public void SelectVis(){

    }    
    
}
