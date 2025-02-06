
package ISS;

import java.util.Scanner;

//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
//  #################### CLASS
//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
/**
 * Se conecta con el escáner físico, cuando se escanea un código QR, este obtiene la dirección web. 
 * El método extrae información de dicho enlace, y envía solo el identificador a la GUI. 
 * El identificador es de tipo numérico. 
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
public class lectura {
    
    //	--------------------------------------------------
    //	-------------------- OBJETOS
    //	--------------------------------------------------
    /**
     * Objeto para leer la entrada del usuario por consola.
     */    
    Scanner Scanner = new Scanner(System.in);

    //	--------------------------------------------------
    //	-------------------- METODO readQRCode
    //	--------------------------------------------------     
    /**
     * El escáner lee un QR, obtiene el enlace web almacenado y envía lo obtenido para ser formateado.
     * 
     * @return Identificador númerico encontrado en el enlace.
     */
    public String readQRCode()  {
        String enlaceAnalizado;// Enlace web extraido del scaner.
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el enlace web:");
        enlaceAnalizado = scanner.nextLine();      
        
        // El escaner envía el enlace para ser formateada, y devuelve el identificador númererico.
        enlaceAnalizado = formatea(enlaceAnalizado);
        return enlaceAnalizado;
    }
    
    /**
     * Formatea el enlace web obtenido, extrae el identificador almacenado dentro del enlace,
     * y retorna solo el identificador.
     * 
     * @param enlaceAnalizado Enlace web obtenido del QR.
     * @return Identificador númerico, 
     */
    private String formatea(String enlaceAnalizado)  {
        String identificador=" "; // Identificador numerico extraido del código QR.
        if (enlaceAnalizado.length() <= 80) {// Verificar si el enlace tiene una longitud menor o igual a 80
            
            String[] keywords = {"id=", "identi="};// Procesar tanto "id=" como "identi="
            
            for (String keyword : keywords) {
                int index = enlaceAnalizado.indexOf(keyword);
                
                if (index != -1) {
                    // Analizar los caracteres uno por uno después de "id=" o "identi="
                    StringBuilder numericPart = new StringBuilder();
                    
                    for (int i = index + keyword.length(); i < enlaceAnalizado.length() && numericPart.length() < 30; i++) {
                        char c = enlaceAnalizado.charAt(i);
                        
                        if (Character.isDigit(c)) 
                        {
                            numericPart.append(c);
                        } else {
                            break; // Detener la búsqueda si no es un número
                        }
                    }
                    
                    //System.out.println(keyword + "[" + numericPart + "]");
                    String resultSS = numericPart.toString();
                    
                    return resultSS; // Salir del método una vez que se encuentra y procesa un keyword
                }
            }
            System.out.println("El enlace no contiene 'id=' o 'identi='");
            
        } else {
            
            System.out.println("La longitud del enlace es mayor a 35. La operación no se realizará.");
        } 
        
        return "0";
    }
}
