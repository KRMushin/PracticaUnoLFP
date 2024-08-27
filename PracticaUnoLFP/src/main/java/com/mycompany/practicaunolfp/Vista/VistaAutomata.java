/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practicaunolfp.Vista;

import com.mycompany.practicaunolfp.utileria.GenerarImagenAutomata;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author kevin-mushin
 */
public class VistaAutomata extends javax.swing.JFrame {
    private GenerarImagenAutomata guardarImagen;

    public VistaAutomata(GenerarImagenAutomata guardarImagen) {
        initComponents();
        this.guardarImagen = guardarImagen;
    }

    /*  AREA SETTERS Y GETTER */

    public JScrollPane getScrollImagen() {
        return scrollImagen;
    }

    public void setScrollImagen(JScrollPane scrollImagen) {
        this.scrollImagen = scrollImagen;
    }

    public JLabel getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(JLabel tipoToken) {
        this.tipoToken = tipoToken;
    }

    public JLabel getAutomata() {
        return Automata;
    }

    public void setAutomata(JLabel Automata) {
        this.Automata = Automata;
    }

    public JLabel getColumnaCuadro() {
        return columnaCuadro;
    }

    public void setColumnaCuadro(JLabel columnaCuadro) {
        this.columnaCuadro = columnaCuadro;
    }

    public JLabel getColumnaTexto() {
        return columnaTexto;
    }

    public void setColumnaTexto(JLabel columnaTexto) {
        this.columnaTexto = columnaTexto;
    }

    public JLabel getFilaCuadro() {
        return filaCuadro;
    }

    public void setFilaCuadro(JLabel filaCuadro) {
        this.filaCuadro = filaCuadro;
    }

    public JLabel getFilaTexto() {
        return filaTexto;
    }

    public void setFilaTexto(JLabel filaTexto) {
        this.filaTexto = filaTexto;
    }

    public JButton getbGuadar() {
        return bGuadar;
    }
    
    
    
    public void guardarImagen(BufferedImage imagenAutomata, String tipoToken){
        String tipoImagen = null;
        if (combobox.getSelectedIndex() != 0) {
            tipoImagen = combobox.getSelectedItem().toString();
        }
        
        if (tipoImagen == null || campoRuta == null || imagenAutomata == null) {
            JOptionPane.showMessageDialog(null, " INGRESE LOS DATOS NECESARIOS PARA LA GENERACION DE IMAGEN");
            return;
        }
        
        crearArchivo(campoRuta.getText(),tipoImagen, imagenAutomata,tipoToken);
    
    }
    
    private void crearArchivo(String PATH_SALIDA, String tipoImagen, BufferedImage imagenAutomata, String tipoToken) {
    if (imagenAutomata != null && !PATH_SALIDA.isEmpty() && !tipoImagen.isEmpty()) {
        File output = new File(PATH_SALIDA);

        // Verificaaa que el archivo tiene la extensión correcta
        if (!output.getName().toLowerCase().endsWith("." + tipoImagen.toLowerCase())) {
            output = new File(PATH_SALIDA + "." + tipoToken.toLowerCase());
        }

        try {
            ImageIO.write(imagenAutomata, tipoImagen, output);
            JOptionPane.showMessageDialog(null, "Imagen generada con éxito en " + output.getAbsolutePath());
            System.out.println("IMAGEN GENERADA CON ÉXITO :)");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar la imagen: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("INTRODUZCA LOS CAMPOS SOLICITADOS");
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bGuadar = new javax.swing.JButton();
        combobox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        campoRuta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tipoToken = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        filaTexto = new javax.swing.JLabel();
        columnaTexto = new javax.swing.JLabel();
        filaCuadro = new javax.swing.JLabel();
        columnaCuadro = new javax.swing.JLabel();
        scrollImagen = new javax.swing.JScrollPane();
        Automata = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(0, 102, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        bGuadar.setText("Guardar Imagen");
        bGuadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuadarActionPerformed(evt);
            }
        });

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sin filtro", "png", "jpg" }));

        jButton2.setText("Especificar Ruta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(bGuadar)
                .addGap(44, 44, 44)
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(campoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuadar)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(campoRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Fila:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Columna:");

        tipoToken.setFont(new java.awt.Font("DejaVu Serif Condensed", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Cuadro Fila:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Cuadro Columna:");

        filaTexto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        filaTexto.setText("Vacio");

        columnaTexto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        columnaTexto.setText("Vacio");

        filaCuadro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        filaCuadro.setText("Vacio");

        columnaCuadro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        columnaCuadro.setText("Vacio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(filaTexto)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(columnaTexto)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(filaCuadro)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(columnaCuadro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(tipoToken, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipoToken, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(filaTexto)
                    .addComponent(columnaTexto)
                    .addComponent(filaCuadro)
                    .addComponent(columnaCuadro))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        scrollImagen.setViewportView(Automata);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollImagen))
                .addContainerGap())
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
JFileChooser fileChooser = new JFileChooser();
        // crear el file chooser de modo que solo pueda escoger carpetas
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            campoRuta.setText(archivoSeleccionado.getAbsolutePath());
        }
        }//GEN-LAST:event_jButton2ActionPerformed

    private void bGuadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuadarActionPerformed
                                      
        try {
            BufferedImage imagen = guardarImagen.getImagenAutomata();
            String tipoToken =  guardarImagen.getToken().getTipoToken();
            if (imagen == null || tipoToken.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay imagen generada para guardar.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                guardarImagen(imagen,tipoToken);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la imagen: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bGuadarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Automata;
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton bGuadar;
    private javax.swing.JTextField campoRuta;
    private javax.swing.JLabel columnaCuadro;
    private javax.swing.JLabel columnaTexto;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JLabel filaCuadro;
    private javax.swing.JLabel filaTexto;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollImagen;
    private javax.swing.JLabel tipoToken;
    // End of variables declaration//GEN-END:variables
}
