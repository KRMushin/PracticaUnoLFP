/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practicaunolfp.Vista;

import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import com.mycompany.practicaunolfp.AnalizadorLexico.TokenEspecial;
import com.mycompany.practicaunolfp.Controladores.ControladorPrincipal;
import com.mycompany.practicaunolfp.utileria.LectorArchivo;
import com.mycompany.practicaunolfp.utileria.TokenPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kevin-mushin
 */
public class VistaPrincipal extends javax.swing.JFrame {
    

    LectorArchivo lectorArchivo = new LectorArchivo();
    private int numeroFil = 0;
    private int numeroCol = 0;
    List<TokenPanel> paneles = new ArrayList<>();

    public JButton getAnalizar() {
        return analizar;
    }

    public JTextField getNumeroColumnas() {
        return numeroColumnas;
    }

    public JTextField getNumeroFilas() {
        return numeroFilas;
    }
    
    public VistaPrincipal() {
        initComponents();
        configuracionFrame();
    }
    public void mostrarPanelesToken(List<Token> tokens){
        
        List<Token> tokensEspeciales = new ArrayList<>();
        List<Token> tokensSimples = new ArrayList<>();
        
        for (int i = 0; i < tokens.size() && i < paneles.size(); i++) {
            Token token = tokens.get(i);
            if (token instanceof TokenEspecial) {
                tokensEspeciales.add(token);
            }else{
                tokensSimples.add(token);
            }
        }
        if (!tokensEspeciales.isEmpty()) {
            mostrarTokensEspeciales(tokensEspeciales);
        }
        if (!tokensSimples.isEmpty()) {
            mostrarTokensSimples(tokensSimples);           
        }
        this.pack();           
    }
    private void mostrarTokensEspeciales(List<Token> tokensEspeciales) {
    int indiceEspeciales = 0;
    
    while (indiceEspeciales < tokensEspeciales.size()) {
        boolean tokenAsignado = false;
        
        for (int i = 0; i < paneles.size(); i++) {
            TokenPanel panel = paneles.get(i);
            TokenEspecial token = (TokenEspecial) tokensEspeciales.get(indiceEspeciales);
            
            if (panel.getPosicionX() == token.getNumeroFila() && panel.getPosicionY() == token.getNumeroColumna()) {
                panel.asignarToken(token);
                panel.setPanelVacio(false);
                indiceEspeciales++;
                tokenAsignado = true;
                break;
            }
        }

        if (!tokenAsignado) {
            System.out.println("Advertencia: No se encontró un panel para el token en la posición esperada.");
            indiceEspeciales++;
        }
    }
}

    private void mostrarTokensSimples(List<Token> tokensSimples) {
            int indiceToken = 0;

            while (indiceToken < tokensSimples.size()) {
                boolean tokenAsignado = false;

                for (int i = 0; i < paneles.size(); i++) {
                    TokenPanel panel = paneles.get(i);

                    if (panel.isPanelVacio()) {
                        Token token = tokensSimples.get(indiceToken);
                        panel.asignarToken(token);
                        panel.setPanelVacio(false);  // Marcamos el panel como ocupado
                        indiceToken++;
                        tokenAsignado = true;
                        break;
                    }
                }

                if (!tokenAsignado) {
                    System.out.println("Advertencia: No hay paneles vacíos disponibles para asignar más tokens.");
                    break;  // Salimos del bucle si no hay más paneles disponibles
                }
            }
}

    /*
      public void mostrarPanelesToken(List<Token> tokens){
        
        List<Token> tokensEspeciales = new ArrayList<>();
        
        for (int i = 0; i < tokens.size() && i < paneles.size(); i++) {
            Token token = tokens.get(i);
            if (token instanceof TokenEspecial) {
                
            }else {
            TokenPanel panel = paneles.get(i);
            panel.asignarToken(token);
            }
        }
        this.pack();           
    }
    */
    
    private void configuracionFrame(){
        
           this.setExtendedState(JFrame.MAXIMIZED_BOTH);
           this.panelContenedor.setLayout(new BorderLayout());
           jScrollPane1.setPreferredSize(new Dimension(550, 0)); // Ajusta solo el ancho, 0 permite que el alto se ajuste automáticamente
           this.panelContenedor.add(barraBotones, BorderLayout.NORTH);
           this.panelContenedor.add(jScrollPane1, BorderLayout.WEST);
           this.panelContenedor.add(panelGrafico, BorderLayout.CENTER);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        barraBotones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numeroFilas = new javax.swing.JTextField();
        numeroColumnas = new javax.swing.JTextField();
        analizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        panelGrafico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barraBotones.setBackground(new java.awt.Color(255, 204, 0));

        jButton1.setText("Cargar con Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reportes");

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero Filas");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Numero Columnas");

        analizar.setText("ANALIZAR");
        analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarActionPerformed(evt);
            }
        });

        jButton3.setText("Establecer Tamaño");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraBotonesLayout = new javax.swing.GroupLayout(barraBotones);
        barraBotones.setLayout(barraBotonesLayout);
        barraBotonesLayout.setHorizontalGroup(
            barraBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(analizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        barraBotonesLayout.setVerticalGroup(
            barraBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barraBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(numeroFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroColumnas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analizar)
                    .addComponent(jButton3))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        panelGrafico.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addComponent(barraBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                lectorArchivo.leerArchivo(archivoSeleccionado.getAbsolutePath(), areaTexto);        
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarActionPerformed
        try {
               ControladorPrincipal controlador = new ControladorPrincipal(this);
               controlador.analizarEntrada(numeroFil,numeroCol,areaTexto.getText().replace("\n", " "));  
        } catch (Exception e) {
            System.out.println("Error: error en el analisis de datos" + e.getMessage()  );
        }        
    }//GEN-LAST:event_analizarActionPerformed
/*  creacion y asignacion de paneles en grafico*/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            this.numeroFil = Integer.parseInt(numeroFilas.getText());
            this.numeroCol = Integer.parseInt(numeroColumnas.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, " ingrese datos validos para filas y columnas");
        }
        paneles.clear();
         panelGrafico.removeAll();
         panelGrafico.setLayout(new BoxLayout(panelGrafico, BoxLayout.Y_AXIS));

            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new GridLayout(numeroFil, numeroCol));
            
            for (int i = 0; i < numeroFil; i++) {
                   for (int j = 0; j < numeroCol; j++) {
                        TokenPanel panel = new TokenPanel(i,j);
                         paneles.add(panel);
                         gridPanel.add(panel);
                }
            }
            panelGrafico.add(gridPanel);
            this.pack();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizar;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JPanel barraBotones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numeroColumnas;
    private javax.swing.JTextField numeroFilas;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelGrafico;
    // End of variables declaration//GEN-END:variables
}
