/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

import com.mycompany.practicaunolfp.Vista.VistaGuardarLienzo;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kevin-mushin
 */
public class GenerarImagenLienzo {
    
    public void guardarLienzo(JPanel panelLienzo, String nombreArchivo, String PATH_SALIDA, String tipoImagen,VistaGuardarLienzo vista){
        BufferedImage image = new BufferedImage(panelLienzo.getWidth(), panelLienzo.getHeight(), BufferedImage.TYPE_INT_RGB);
    
        Graphics2D g2d = image.createGraphics();
        panelLienzo.paint(g2d);
        g2d.dispose();
        
        try {
            ImageIO.write(image, tipoImagen, new File(PATH_SALIDA, nombreArchivo));
            JOptionPane.showMessageDialog(panelLienzo, "ARCHIVO GENERADO CORRECTAMENTE EN" + PATH_SALIDA);
            
        } catch (IOException e) {
            System.out.println(e.getCause());
        }
        vista.dispose();
    }
   
}
