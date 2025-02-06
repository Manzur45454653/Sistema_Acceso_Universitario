package ISS;

//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.*;
import java.awt.image.BufferedImage;


//  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
/**
 * Permite la generación de un código QR único para un visitante. Los códigos QR almacena un 
 * enlace web, el cual tiene como método GET, un identificador, este se ha proporcionado 
 * como parámetro. Se debe crear el QR como una imagen, la cual será almacenada en la base de datos.
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
public class newQR {

    /**
     * Genera un QR, el cual almacena un enlace web.
     * 
     * @param identificador Identificador del visitante, esté aparece en la DB.
     * @return Imagen QR.
     */
    public BufferedImage newQR(String identificador) {

        int size = 1000; // Dimensiones del QR
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        try {
            // Generar matriz de bits para el código QR
            BitMatrix bitMatrix = qrCodeWriter.encode(identificador, BarcodeFormat.QR_CODE, size, size);

            // Crear la imagen en memoria
            int matrixWidth = bitMatrix.getWidth();
            BufferedImage qrImage = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);

            // Configurar gráficos para dibujar el código QR
            Graphics2D graphics = qrImage.createGraphics();
            graphics.setColor(Color.WHITE); // Fondo blanco
            graphics.fillRect(0, 0, matrixWidth, matrixWidth);
            graphics.setColor(Color.BLACK); // Código QR negro

            // Dibujar cada píxel del QR
            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            graphics.dispose(); // Liberar recursos gráficos
            return qrImage; // Retornar la imagen generada

        } catch (WriterException e) {
            e.printStackTrace();
            return null; // En caso de error, retornar null
        }        
    }

}
