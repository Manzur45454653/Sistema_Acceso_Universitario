package ISS;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
//  #################### CLASS
//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
/**
 * Interfaz grafica principal del sistema.
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
public class interfaz1 extends javax.swing.JFrame {

    //	--------------------------------------------------
    //	-------------------- OBJETOS
    //	--------------------------------------------------
    /**
     * Enviar y recibir información de la base de datos.
     */
    comprobar OComprobar = new comprobar();
    /**
     * Conexión con el escáner QR, envía el identificador obtenido del QR.
     */
    lectura OLectura = new lectura();

    
    //	--------------------------------------------------
    //	-------------------- ATRIBUTOS
    //	--------------------------------------------------
    /**
     * Almacena el mensaje de error detectado.
     */
    private String mensaje = "";
    /**
     * Duración por defecto para el nuevo código QR del visitante.
     */
    private int duracion = 1;
    /**
     * Para seleccionar una imagen de los archivos.
     */
    private File selectedImage;
    
    //	============================================================
    //	==================== CONSTRUCTOR
    //	============================================================
    /**
     * Constructor de la interfaz.
     */
    public interfaz1() {
        initComponents();
    }

    /**
     * Este metodo se llama desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este codigo. El contenido de este metodo es
     * siempre regenerado por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        // --------------------------------------------------
        // -------------------- Formulario para registrar a un visitante.
        // --------------------------------------------------  
        jLabelImagen = new javax.swing.JLabel();
        btnIdentificacion = new javax.swing.JButton();
        inputMotivo = new javax.swing.JScrollPane();
        jTextinputMotivo = new javax.swing.JTextArea();
        LabelUserMotivo = new javax.swing.JLabel();
        
        LabelUserApellidoP = new javax.swing.JLabel();
        inputApellidoP = new javax.swing.JScrollPane();
        jTextInputApellidoP = new javax.swing.JTextArea();
        
        inputApellidoM = new javax.swing.JScrollPane();
        jTextInputApellidoM = new javax.swing.JTextArea();
        LabelUserApellidoM = new javax.swing.JLabel();
       
        LabelUserName = new javax.swing.JLabel();
        inputIName = new javax.swing.JScrollPane();
        jTextInputName = new javax.swing.JTextArea();

        // --------------------------------------------------
        // -------------------- Botones dentro de la interfaz.
        // --------------------------------------------------         
        btnGuardar = new javax.swing.JButton();
        btnEndUser = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        
        btnRegresar = new javax.swing.JButton();
        
        
        // --------------------------------------------------
        // -------------------- Muestra la información de un end user, en caso de que exista coincidencia en la base de datos.
        // --------------------------------------------------
        meessege = new javax.swing.JLabel();
        userCarr = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        imgUser = new javax.swing.JLabel();
        nameSist = new javax.swing.JLabel();
        nameUACM = new javax.swing.JLabel();
        
        fondoRojo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso UACM");
        setMaximumSize(new java.awt.Dimension(1300, 700));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setPreferredSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        jLabelImagen.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 420, 30));        
        
        // -------------------- Selecciona la identificación oficial del usuario.
        btnIdentificacion.setBackground(new java.awt.Color(153, 255, 153));
        btnIdentificacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIdentificacion.setText("Selecionar Identificadión");
        btnIdentificacion.setBorder(null);
        btnIdentificacion.setToolTipText("");
        btnIdentificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIdentificacion.setMaximumSize(new java.awt.Dimension(120, 25));
        btnIdentificacion.setMinimumSize(new java.awt.Dimension(120, 25));
        btnIdentificacion.setPreferredSize(new java.awt.Dimension(120, 25));
        getContentPane().add(btnIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 210, -1));
        btnIdentificacion.addActionListener(new seleccionarImagenActionPerformed());// Guarda la infromación en la base de datos.
        btnIdentificacion.setVisible(false);// Ocultamos el elemento.
        

        // -------------------- TextArea para el motivo de la visita     
        inputApellidoM.setBorder(null);
        inputApellidoM.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputApellidoM.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);        
        inputMotivo.setMaximumSize(new java.awt.Dimension(170, 150));
        inputMotivo.setMinimumSize(new java.awt.Dimension(170, 150));
        inputMotivo.setPreferredSize(new java.awt.Dimension(170, 150));
        jTextinputMotivo.setColumns(20);
        jTextinputMotivo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextinputMotivo.setLineWrap(true);
        jTextinputMotivo.setRows(5);
        inputMotivo.setViewportView(jTextinputMotivo);
        getContentPane().add(inputMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 420, -1));
        inputMotivo.setVisible(false);// Ocultamos el elemento.

        // -------------------- Label para el motivo de la visita.
        LabelUserMotivo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelUserMotivo.setForeground(new java.awt.Color(255, 255, 255));
        LabelUserMotivo.setText("Motivo de visita");
        getContentPane().add(LabelUserMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, -1, -1));
        LabelUserMotivo.setVisible(false);// Ocultamos el elemento.

        // -------------------- Apellido Paterno del visitante
        LabelUserApellidoP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelUserApellidoP.setForeground(new java.awt.Color(255, 255, 255));
        LabelUserApellidoP.setText("Apellido Paterno");
        getContentPane().add(LabelUserApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, -1, -1));
        LabelUserApellidoP.setVisible(false);

        inputApellidoP.setBorder(null);
        inputApellidoP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputApellidoP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        inputApellidoP.setMaximumSize(new java.awt.Dimension(170, 80));
        inputApellidoP.setMinimumSize(new java.awt.Dimension(170, 80));
        inputApellidoP.setPreferredSize(new java.awt.Dimension(170, 80));
        inputApellidoP.setRowHeaderView(null);
        inputApellidoP.setViewport(null);
        inputApellidoP.setEnabled(false);// Desactivamos el objeto.

        jTextInputApellidoP.setColumns(20);
        jTextInputApellidoP.setRows(5);
        jTextInputApellidoP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N        
        inputApellidoP.setViewportView(jTextInputApellidoP);
        getContentPane().add(inputApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 420, 40));
        inputApellidoP.setVisible(false);// Ocultamos el elemento.

        // -------------------- Apellido Materno del visitante
        inputApellidoM.setMaximumSize(new java.awt.Dimension(170, 80));
        inputApellidoM.setMinimumSize(new java.awt.Dimension(170, 80));
        inputApellidoM.setPreferredSize(new java.awt.Dimension(170, 80));
        inputApellidoM.setVerifyInputWhenFocusTarget(false);
        inputApellidoM.setViewport(null);
        inputApellidoM.setEnabled(false);// Desactivamos el objeto.

        jTextInputApellidoM.setColumns(20);
        jTextInputApellidoM.setRows(5);
        jTextInputApellidoM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N                
        inputApellidoM.setViewportView(jTextInputApellidoM);
        getContentPane().add(inputApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 420, 40));
        inputApellidoM.setVisible(false);// Ocultamos el elemento.

        LabelUserApellidoM.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelUserApellidoM.setForeground(new java.awt.Color(255, 255, 255));
        LabelUserApellidoM.setText("Apellido Materno");
        getContentPane().add(LabelUserApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, -1, -1));
        LabelUserApellidoM.setVisible(false);

        // -------------------- Nombre del visitante        
        LabelUserName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelUserName.setForeground(new java.awt.Color(255, 255, 255));
        LabelUserName.setText("Nombre");
        getContentPane().add(LabelUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, -1, -1));
        LabelUserName.setVisible(false);// Ocultamos el elemento.

        inputIName.setBorder(null);
        inputIName.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        inputIName.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        inputIName.setMaximumSize(new java.awt.Dimension(170, 80));        
        inputIName.setMaximumSize(new java.awt.Dimension(0, 0));
        inputIName.setMinimumSize(new java.awt.Dimension(0,0));
        inputIName.setPreferredSize(new java.awt.Dimension(0, 0));
        inputIName.setVerifyInputWhenFocusTarget(false);
        inputIName.setWheelScrollingEnabled(false);
        inputIName.setEnabled(false);// Desactivamos el objeto.

        jTextInputName.setColumns(0);
        jTextInputName.setRows(0);
        jTextInputName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N                
        inputIName.setViewportView(jTextInputName);
        getContentPane().add(inputIName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 420, 40));
        inputIName.setVisible(false);// Ocultamos el elemento.

        // -------------------- Boton para guardar la información del visitante.        
        btnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.setMaximumSize(new java.awt.Dimension(120, 25));
        btnGuardar.setMinimumSize(new java.awt.Dimension(120, 25));
        btnGuardar.setPreferredSize(new java.awt.Dimension(120, 25));
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));        
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 110, -1));
        btnGuardar.addActionListener(new GuardarInfoVisitante());// Guarda la infromación en la base de datos.
        btnGuardar.setVisible(false); // Ocultamos e button.

        // -------------------- Regresar a la página principal del sistema.
        btnRegresar.setBackground(new java.awt.Color(204, 204, 255));
        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setMaximumSize(new java.awt.Dimension(90, 30));
        btnRegresar.setMinimumSize(new java.awt.Dimension(90, 30));
        btnRegresar.setPreferredSize(new java.awt.Dimension(90, 30));
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 90, -1));  
        btnRegresar.addActionListener(new regresaVentana());// Guarda la infromación en la base de datos.
        btnRegresar.setVisible(false);//Ocultamos el button al inicio.
        
        // -------------------- Activa el escaneo de QR por consola.        
        btnEndUser.setBackground(new java.awt.Color(204, 204, 255));
        btnEndUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEndUser.setText("Escanear");
        btnEndUser.setBorder(null);
        btnEndUser.setMaximumSize(new java.awt.Dimension(90, 25));
        btnEndUser.setMinimumSize(new java.awt.Dimension(90, 25));
        btnEndUser.setPreferredSize(new java.awt.Dimension(90, 25));
        btnEndUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));        
        getContentPane().add(btnEndUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 210, -1));
        btnEndUser.addActionListener(new VentanaEndUser());// Manda a la interfaz grafica para un End User
        //btnEndUser.setEnabled(false);// Se mantiene activo, sera el que inicie el ciclo para el escaner.

        // -------------------- Ir a la sección para registara a un nuevo usuario.        
        btnRegistrar.setBackground(new java.awt.Color(204, 204, 255));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistrar.setText("Visitante");
        btnRegistrar.setBorder(null);
        btnRegistrar.setMaximumSize(new java.awt.Dimension(90, 25));
        btnRegistrar.setMinimumSize(new java.awt.Dimension(90, 25));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(90, 25));
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));          
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, -1, -1));
        btnRegistrar.addActionListener(new VentanaRegistrar());// Manda a la interfaz grafica para un End User

        // -------------------- Muestra el mensaje, si se le permite al usuario el acceso al sistema.        
        meessege.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        meessege.setForeground(new java.awt.Color(255, 255, 255));
        meessege.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meessege.setMaximumSize(new java.awt.Dimension(300, 45));
        meessege.setMinimumSize(new java.awt.Dimension(300, 45));
        meessege.setPreferredSize(new java.awt.Dimension(300, 45));
        meessege.setText("");// Mensaje a mostar
        getContentPane().add(meessege, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, -1, -1));
        meessege.setEnabled(false);// Desactivamos el objeto.

        // -------------------- Carrera o area de trabajo de un End User.        
        userCarr.setBackground(new java.awt.Color(255, 0, 51));
        userCarr.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userCarr.setForeground(new java.awt.Color(255, 255, 255));
        userCarr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userCarr.setText("");
        userCarr.setMaximumSize(new java.awt.Dimension(300, 25));
        userCarr.setMinimumSize(new java.awt.Dimension(300, 25));
        userCarr.setPreferredSize(new java.awt.Dimension(300, 25));
        getContentPane().add(userCarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 500, -1));

        // -------------------- Nombre de un end user.        
        userName.setBackground(new java.awt.Color(255, 102, 0));
        userName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //userName.setText("Ramirez Ortega Artiga Sandobal");
        userName.setText("");
        userName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userName.setMaximumSize(new java.awt.Dimension(300, 25));
        userName.setMinimumSize(new java.awt.Dimension(300, 25));
        userName.setPreferredSize(new java.awt.Dimension(300, 25));
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 480, -1));

        // -------------------- IMG de identificacion de un end user.        
        //imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icono.png"))); // NOI18N
        imgUser.setMaximumSize(new java.awt.Dimension(250, 250));
        imgUser.setMinimumSize(new java.awt.Dimension(250, 250));
        imgUser.setName(""); // NOI18N
        imgUser.setPreferredSize(new java.awt.Dimension(250, 250));
        getContentPane().add(imgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, -1));
        imgUser.setVisible(false);// Identificación del usuario.

        // -------------------- Titulo principal del sistema.         
        nameSist.setFont(new java.awt.Font("Tomorrow", 1, 40)); // NOI18N
        nameSist.setForeground(new java.awt.Color(204, 204, 204));
        nameSist.setText("Acceso UACM");
        getContentPane().add(nameSist, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, -1));

        // -------------------- Nombre de la universidad.        
        nameUACM.setBackground(new java.awt.Color(204, 0, 0));
        nameUACM.setFont(new java.awt.Font("Arial", 1, 60)); // NOI18N
        nameUACM.setForeground(new java.awt.Color(255, 255, 255));
        nameUACM.setText("UACM");
        nameUACM.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        nameUACM.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        nameUACM.setFocusTraversalPolicyProvider(true);
        nameUACM.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(nameUACM, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 100));

        // -------------------- Fondo de pantalla de la interfaz grafica.        
        fondoRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondo1.jpg"))); // NOI18N
        fondoRojo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        fondoRojo.setMaximumSize(new java.awt.Dimension(3000, 3000));
        fondoRojo.setMinimumSize(new java.awt.Dimension(3000, 3000));
        fondoRojo.setPreferredSize(new java.awt.Dimension(3000, 3000));
        getContentPane().add(fondoRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 740));

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    /**
    * Corremos la interfaz, hace visible la interfaz.
    */
    public void run() {
        new interfaz1().setVisible(true);
    }    

    //  --------------------------------------------------
    //  -------------------- ACCION DE ESCUCHA DEL BUTTON btnIdentificacion
    //  --------------------------------------------------
    /**
     * El método se llama cuando se presiona el botón de seleccionar imagen
     */
    class seleccionarImagenActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent e) {        
            
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes (.jpg, .png, .jpeg)", "jpg", "png", "jpeg");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedImage = fileChooser.getSelectedFile();
                // Actualiza la etiqueta o campo de texto para mostrar el nombre del archivo seleccionado
                jLabelImagen.setText(selectedImage.getName());
            }
        }   
    }
    
    //  --------------------------------------------------
    //  -------------------- ACCION DE ESCUCHA DEL BUTTON btnRegresar
    //  --------------------------------------------------
    /**
     * Oculta el formulario para registrar a un visitante y sus botones asignados. 
     * Muestra los botones, contenedores de texto para mostrar la información de un QR escaneado.
     */
    class regresaVentana implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            // Ocultamos el formulario para registar a un nuevo visitante.
            LabelUserName.setVisible(false);// Etiqueta para el nombre del visitante.
            inputIName.setVisible(false);// Entrada para el nombre del visitante.            
            LabelUserApellidoM.setVisible(false);// Etiqueta para el apellido materno del visitante.
            inputApellidoM.setVisible(false);// Entrada para el apellido materno del visitante.            
            LabelUserApellidoP.setVisible(false);// Etiqueta para el apellido paterno del visitante.
            inputApellidoP.setVisible(false);// Entrada para el apellido paterno del visitante.            
            LabelUserMotivo.setVisible(false);// Etiqueta para el motivo de visita del visitante.
            inputMotivo.setVisible(false);// Entrada para el motivo de visita del visitante.
            
            btnIdentificacion.setVisible(false);// Button para seleccionar la fotografia.
            
            btnGuardar.setVisible(false);// Botón para guardar la información del formulario.  
            
            btnRegresar.setVisible(false);// Ocultamos el butón de regresar.
            
            // Hacemos visibles los campos y botones para un End USer.
            userName.setVisible(true);// Nombre de un visitante o end user.
            userCarr.setVisible(true);// Carrera o puesto de un End User.
            imgUser.setVisible(true);// Contenedor de la imagen.
            btnEndUser.setVisible(true);// Botón para escanear.
            btnRegistrar.setVisible(true);// Botón para mostrar el formulario de un visitante.
        }
    }// Fin regresaVentana   
    
    //  --------------------------------------------------
    //  -------------------- ACCION DE ESCUCHA DEL BUTTON GuardarInfoVisitante
    //  --------------------------------------------------
    /**
     * Extrae la información ingresada de los contenedores de texto del formulario. 
     * Muestra por consola un mensaje, en el cual indica que faltan campos para llenar. Lee la imagen (identificación del visitante) como un array de byes, en caso de error, mostramos por consola el error. 
     * Realizamos una comprobación, para evitar guardar información con campos vacíos. Si todos los campos de texto están llenos y la imagen ya fue seleccionada, se la enviamos a la clase comprobar, para que guarde la información en la DB de visitantes.
     * Después de 3 segundos, limpia los campos de texto y el contenido de la imagen lo hace nulo.
     */
    class GuardarInfoVisitante implements ActionListener {
        public void actionPerformed(ActionEvent e) {

                    
        String nombre,name,apellidoP,apellidoM,motivo;
        
        name = jTextInputName.getText();// Extrae la información dentro del formulario.
        apellidoM = jTextInputApellidoM.getText();// Extrae la información dentro del formulario.
        apellidoP = jTextInputApellidoP.getText();// Extrae la información dentro del formulario.
        motivo = jTextinputMotivo.getText();//  Extrae la información dentro del formulario.
        
        System.out.println("Nombre: " + name + " " + apellidoM + " " + apellidoP);
        System.out.println("Motivo: " + motivo);
        
        String imagenPath = (selectedImage != null) ? selectedImage.getAbsolutePath() : null;

        if (name.isEmpty() || apellidoM.isEmpty() || apellidoP.isEmpty() || motivo.isEmpty() ||imagenPath == null) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos y seleccione una imagen.");
            return;
        }        
                
        // Leer la imagen como un array de bytes
        byte[] imagenBytes = null;
        try {
            imagenBytes = Files.readAllBytes(selectedImage.toPath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer la imagen.");
            ex.printStackTrace();
            return;
        }        
        
        if( (!name.isEmpty()) && (!motivo.isEmpty()) )
        {
            OComprobar.registra(name, apellidoM, apellidoP,imagenBytes,motivo, 1);// La cadena no está vacía
        }
        
        // Crear un Timer para borrar el contenido después de 3 segundos
        Timer timer;
        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Limpiamos los campos del formulario.
                jTextInputName.setText(""); // Limpiar el campo de texto.
                jTextInputApellidoM.setText(""); // Limpiar el campo de texto.
                jTextInputApellidoP.setText(""); // Limpiar el campo de texto.
                jTextinputMotivo.setText(""); // Limpiar el campo de texto.
                jLabelImagen.setText(""); // Limpiar el nombre de la imagen.
            }
        });
        timer.setRepeats(false); // Hacer que el temporizador se ejecute una vez
        timer.start(); // Iniciar el temporizador            
                       
            
        }// Fin del metodo ActionEvent
    }// Fin de la clase GuardarInfoVisitante

    //  --------------------------------------------------
    //  -------------------- ACCION DE ESCUCHA DEL BUTTON VentanaEndUser
    //  --------------------------------------------------
    /**
     * Hace visibles los contenedores de texto y los botones para ingresar y guardar la información 
     * de un visitante. Ocultamos los contenedores, donde mostramos la información de un usuario. 
     * Recibimos el identificador contenido del escáner, el identificador ya viene formateado. 
     * Enviamos el identificador a la clase comprobar, la cual va a determinar si pertenece a un 
     * end user, visitante o no existe el identificador. En caso de que el identificador exista, 
     * mostrará la información del usuario en pantalla. En esta, también determinamos si el 
     * usuario puede o no acceder al plantel.
     */
    class VentanaEndUser implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            // Ocultamos el formulario  para registrar un visitante.
            LabelUserName.setVisible(false);// Label del nombre del Visitante.
            inputIName.setVisible(false);// Input del nombre del Visitante.
            LabelUserApellidoM.setVisible(false);// Label del Apellido Materno del Visitante.
            inputApellidoM.setVisible(false);// Input del Apellido Materno del Visitante.
            LabelUserApellidoP.setVisible(false);// Label del Apellido Paterno del Visitante
            inputApellidoP.setVisible(false);// Input del Apellido Paterno del Vistante
            LabelUserMotivo.setVisible(false);// Label del Motivo del Visitante
            inputMotivo.setVisible(false);// Input del Motivo de Visitante
            btnIdentificacion.setVisible(false);// Button para Guaradar la fotografia
            btnGuardar.setVisible(false);//Boton para guardar la información del formulario.
            imgUser.setVisible(true);// Mostramos la fotografia del usuario.
            userCarr.setVisible(true);// Carrera o puesto de un End User.
            
            String identificador;// Identificador numerico extraido del código QR.
            String nombre="";// Nombre completo del usuario.
            String ocupacion = ""; // Ocuapación de un End User.
            System.out.println("\n\nCLICK EN ESCANEAR\n\n");          
            
            // Recibe la información de leer, y la envía a consulta. Determina si existe el QR en la DB.
            identificador = OLectura.readQRCode();// El scaner retorna el identificador numerico.
            //System.out.println("Identificador recibido del QR: [" + identificador + "]");// Imprime el identificador retornado.
                
            mensaje = OComprobar.buscaMat(identificador);// Buscamos en la base de datos el identificador.
            
            //System.out.println("\nRetorno de buscaMat: "+ mensaje);   
                
            if(mensaje == "YesEnd")// Si el identificador esta en End User, obtenemos su información.
            {
                nombre = OComprobar.getNombreEndUser(identificador);// Nombre completo
                ocupacion = OComprobar.getOcupacionEndUser(identificador);// Ocupación
                BufferedImage image = OComprobar.getImgEndUser(identificador);// Fotografia
                
                if (image != null) 
                {
                    // Redimensionar la imagen para que quepa en el JLabel
                    Image scaledImage = image.getScaledInstance(
                        imgUser.getWidth(),
                        imgUser.getHeight(),
                        Image.SCALE_SMOOTH
                    );
                    //ImageIcon icon = new ImageIcon(image);
                    //imgUser.setIcon(icon);
                    imgUser.setIcon(new ImageIcon(scaledImage));
                } 
                else 
                {
                    //JOptionPane.showMessageDialog(null, "No se encontró la imagen para la matrícula proporcionada.");
                }                
                
                meessege.setText("AUTORIZADO"); // Mostramos que esta autorisado para acceder.
                userName.setText(nombre); // Mostramos el nombre completo del End User.
                userCarr.setText(ocupacion);// Mostramos la ocupación del usuario.
                    
            } 
            else if (mensaje=="YesVis") // Indica que es un visitante, por lo tanto mostramos la info del visitante.
            {
                userCarr.setVisible(false);// Ocultamos la el texto de ocupación.
                
                //System.out.println("\nQR de un visitante");
                nombre = OComprobar.getNombreVisitante(identificador);// Nombre completo del visitante.
                    
                //System.out.println("\nUsuario del visitante: " + nombre);//Imprimimos el nombre completo retornado de Visitante.
                    
                BufferedImage image = OComprobar.getVisitanteImg(identificador);// Fotografia
                
                if (image != null) 
                {
                    // Redimensionar la imagen para que quepa en el JLabel
                    Image scaledImage = image.getScaledInstance(
                        imgUser.getWidth(),
                        imgUser.getHeight(),
                        Image.SCALE_SMOOTH
                    );
                    //ImageIcon icon = new ImageIcon(image);
                    //imgUser.setIcon(icon);
                    imgUser.setIcon(new ImageIcon(scaledImage));
                } 
                else 
                {
                    //JOptionPane.showMessageDialog(null, "No se encontró la imagen para la matrícula proporcionada.");
                }              
                //imgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icono.png"))); // NOI18N
                userName.setText(nombre);// Mostramos el nombre en la interfaz.
                userCarr.setText("Visitante");// Mostramos la ocupación del usuario.
                meessege.setText("AUTORIZADO"); // Mostramos que esta autorisado para acceder.
            } 
            else if (mensaje=="Error") // Indica que no es End User ni Visitante, por lo cual no esta registrado.
            {
                meessege.setText("QR inexistente.");
            }
            
        // Crear un Timer de javax.swing para borrar el contenido después de 3 segundos
        javax.swing.Timer timer = new javax.swing.Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                meessege.setText(""); // Borrar el texto del mensaje.
                userName.setText(""); // Borrar el texto del nombre.
                userCarr.setText(""); // Borrar el texto de la ocupación.
                imgUser.setIcon(null); // Borra la imagen.
            }
        });
        timer.setRepeats(false); // Hacer que el temporizador se ejecute una vez
        timer.start(); // Iniciar el temporizador           
           
        }// Fin del metodo ActionEvent
    }// Fin de la clase GuardarInfoVisitante  
    
    //  --------------------------------------------------
    //  -------------------- ACCION DE ESCUCHA DEL BUTTON VentanaRegistrar
    //  --------------------------------------------------
    /**
     * Ocultamos los contenedores y botones para mostrar información de un usuario. 
     * Mostramos botones para registrar y guardar la información de un visitante. 
     * Además, mostramos los contenedores para la información del visitante, y 
     * limpiamos su contenido. Mostramos el botón para seleccionar un archivo de tipo imagen. 
     */
    class VentanaRegistrar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        System.out.println("\n\nCLICK EN REGISTRAR\n\n");
        
        // Ocultamos los campos y botones para un End USer. 
        btnRegresar.setVisible(true);// Botón para regresar a la ventana principal.
        btnEndUser.setVisible(false);// Ocultamos el button para escanear.
        userName.setVisible(false);// Nombre de un visitante o end user.
        userCarr.setVisible(false);// Carrera o puesto de un End User.
        imgUser.setVisible(false);// Contenedor de la imagen.
        
        
        // Ocultamos los campos y botones para el formulario
        btnGuardar.setVisible(true);// Botón para guardar la información del formulario.  
        btnRegistrar.setVisible(true);// Botón para mostrar el formulario de un visitante.
        
        // Mostramos el formulario para registar a un nuevo visitante.
        LabelUserName.setVisible(true);// Etiqueta para el nombre del visitante.
        inputIName.setVisible(true);// Entrada para el nombre del visitante.            
        LabelUserApellidoM.setVisible(true);// Etiqueta para el apellido materno del visitante.
        inputApellidoM.setVisible(true);// Entrada para el apellido materno del visitante.            
        LabelUserApellidoP.setVisible(true);// Etiqueta para el apellido paterno del visitante.
        inputApellidoP.setVisible(true);// Entrada para el apellido paterno del visitante.            
        LabelUserMotivo.setVisible(true);// Etiqueta para el motivo de visita del visitante.
        inputMotivo.setVisible(true);// Entrada para el motivo de visita del visitante.        

        
        btnIdentificacion.setVisible(true);// Button para Guaradar la información.
        
        // Limpiamos los campos del formulario.
        jTextInputName.setText(""); // Limpiar el campo de texto.
        jTextInputApellidoM.setText(""); // Limpiar el campo de texto.
        jTextInputApellidoP.setText(""); // Limpiar el campo de texto.
        jTextinputMotivo.setText(""); // Limpiar el campo de texto.
        jLabelImagen.setText(""); // Limpiar el nombre de la imagen.
              
        
        
        }// Fin del metodo ActionEvent
    }// Fin de la clase GuardarInfoVisitante           
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel LabelUserApellidoM;
    private javax.swing.JLabel LabelUserApellidoP;
    private javax.swing.JLabel LabelUserMotivo;
    private javax.swing.JLabel LabelUserName;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIdentificacion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel fondoRojo;
    private javax.swing.JLabel imgUser;
    private javax.swing.JScrollPane inputApellidoM;
    private javax.swing.JScrollPane inputApellidoP;
    private javax.swing.JScrollPane inputIName;
    private javax.swing.JScrollPane inputMotivo;
    private javax.swing.JButton btnEndUser;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JTextArea jTextInputApellidoM;
    private javax.swing.JTextArea jTextInputApellidoP;
    private javax.swing.JTextArea jTextInputName;
    private javax.swing.JTextArea jTextinputMotivo;
    private javax.swing.JLabel meessege;
    private javax.swing.JLabel nameSist;
    private javax.swing.JLabel nameUACM;
    private javax.swing.JLabel userCarr;
    private javax.swing.JLabel userName;
    // End of variables declaration                   
}
