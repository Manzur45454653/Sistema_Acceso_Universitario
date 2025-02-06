package ISS;

import java.awt.image.BufferedImage;

//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
//  #################### CLASS
//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
/**
 * Realiza las comprobaciones con las bases de datos para los End User y los visitantes. 
 * La clase puede devolver información específica por consulta; a su vez, puede enviar 
 * información a las clases de base de datos.
 * 
 * <p>
 * <b>Programa:</b> Acceso UACM <br>
 * <b>Autor:</b> Guadalupe Yamileth Valadez Carmona <br>
 * <b>Autor:</b> Rodríguez Cervantes Kevin Manzur <br>
 * <b>Autor:</b> Romero Cervantes Fátima Daniela <br>
 * <b>Autor:</b> Rodríguez Sánchez Diana Fabiola <br>
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
public class comprobar {

    //	--------------------------------------------------
    //	-------------------- OBJETOS
    //	--------------------------------------------------
    /**
     * Conexión con el servidor de la UACM, almacena información de los End User.
     */
    dbr OSeridorUACM = new dbr();
    /**
     * Conexión con el servidor de Visitas, exclusivamente para los Visitantes.
     */
    dbv OServidorVis = new dbv();
    
    //	--------------------------------------------------
    //	-------------------- ATRIBUTOS
    //	--------------------------------------------------    
    /**
     * Retorna un string, si la matricula se encuentra o no en alguna de las DB.
     */
    private String info;
    /**
     * Almacena el nuevio QR para el visitnate.
     */
    private String QR="";

    /**
     * Realiza una consulta en las diferentes bases, determina si el identificador aparece 
     * en una determinada base de datos. Esta comprobación, se la enviamos a la interfaz 1.
     * 
     * @param identificador Identificador.
     * @return String unico, para el End User o un Visitante, determina si existe o no.
     */
    public String buscaMat(String identificador) {
        String consultaEnd="",consultaVis="";

        //System.out.println("Identificador comprobar: " + identificador);Imprimimos el identificador recibido.
        
        consultaEnd = OSeridorUACM.buscaEnd(identificador);
        
        if(consultaEnd == "YesEnd" ) // El identificador existe en la DB de End USer.
        {
            //System.out.println("\nCOMPROBAR: End User encontrado.");
            return "YesEnd";
            
        }
        else if(consultaEnd == "ErrorEnd" ) // El identificador no existe en la DB de End USer, lo comprobamos en DB de  visitantes.
        {
            //System.out.println("\nCOMPROBAR: End User no encontrado. Comprobando en visitantes.");
            consultaVis = OServidorVis.buscaVis(identificador);// Buscamos el identificador en la DB de visitantes.
            
            //System.out.println("\nRetorno visitante: "+ consultaVis);
            
            if(consultaVis == "YesVis" ) // Es un visitante, retornamos que es un visitante.
            {
                //System.out.println("\nCOMPROBAR: Visitante encontrado.");
                return "YesVis";

            }
            else if(consultaVis == "ErrorVis" ) // Como no es End user ni visitante, retornamos error.
            {
                //System.out.println("\nQR no registrado en el sistema.");
                return "Error";
            }// Fin consultaVis
        }
        return "Error";
    }

    /**
     * Obtenemos el nombre completo de la DB, se la enviamos a la GUI para ser mostrada.
     * 
     * @param identificador Identificador del visitante.
     * @return Nombre completo del vsitante.
     */
    public String getNombreVisitante(String identificador){
        identificador = OServidorVis.getVisNombre(identificador);
        return identificador;  
    }

    /**
     * Obtenemos el nombre completo del End USer, se la enviamos a la GUI para ser mostrada.
     * 
     * @param identificador Identificador del End User.
     * @return Nombre completo del End User.
     */
    public String getNombreEndUser(String identificador){
        identificador = OSeridorUACM.getEndUserNombre(identificador);
        return identificador;  
    }
    

    /**
     * Obtenemos la ocupación o el cargo que tiene un End User,  y la enviamos a la GUI para ser mostrada.
     * 
     * @param identificador Identificador del End User.
     * @return Ocupación del End User.
     */
    public String getOcupacionEndUser(String identificador){
        identificador = OSeridorUACM.getEndUserOcupacion(identificador);
        return identificador;  
    }    
    
    /**
     * Obtenemos la imagen almacenada en la base de datos para un End User,  y la enviamos a la GUI para ser mostrada.
     * 
     * @param identificador Identificador.
     * @return Fotografia almacenada.
     */
    public BufferedImage getImgEndUser(String identificador) {
        return OSeridorUACM.EndUserImg(identificador);
    }    
    
    
    /**
     * Obtenemos la imagen almacenada en la base de datos para un Visitante,  y la enviamos a la GUI para ser mostrada.
     * 
     * @param id Identificador.
     * @return Identi almacenada.
     */
    public BufferedImage getVisitanteImg(String id) {
        return OServidorVis.visitanteImg(id);
    }      

    /**
     * Envía la información a la DBV para ser registrada.
     * 
     * @param nombre Nombre del viistante.
     * @param apellidoM Apellido materno del visitante
     * @param apellidoP Apellido paterno de visitante
     * @param imagenBytes Identificación oficial de visitante.
     * @param motivo Motivo del visitante.
     * @param duracion Duración de la visita.
     */
    public void registra (String nombre,String apellidoM,String apellidoP, byte[] imagenBytes,String motivo,int duracion){

        System.out.println("Nombre: " + nombre);
        System.out.println("Motivo: " + motivo);
        System.out.println("Duración: " + duracion);
        
        OServidorVis.setInsert(nombre, apellidoM, apellidoP, imagenBytes, motivo, duracion);
    }

}
