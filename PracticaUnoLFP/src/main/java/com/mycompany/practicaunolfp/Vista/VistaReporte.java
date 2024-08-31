/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practicaunolfp.Vista;

import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import com.mycompany.practicaunolfp.utileria.TokenPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin-mushin
 */
public class VistaReporte extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    public VistaReporte() {
        initComponents();
        this.colores.setLayout(new GridLayout(0,2));
        this.modelo = (DefaultTableModel) jTable1.getModel();
    }
    public void mostrarReporte(List<TokenPanel> paneles){
        modelo.setRowCount(0);
        this.setVisible(true);
        if (paneles.isEmpty()) {
            return;
        }
        int number =0;
        for (int i = 0; i < paneles.size(); i++) {
             TokenPanel panelToken = paneles.get(i);
             if (!panelToken.isPanelVacio()) {
                 if (panelToken.getToken() != null) {
                     mostrarReportePanel(panelToken);         
                     number++;
                     colores.add(obtenerPanelColor(panelToken.getToken().getColor()));
                     colores.add(new JLabel(panelToken.getToken().getColor()));
                 }
            }
        }
    }
    private void mostrarReportePanel(TokenPanel panelToken){
        String tipoToken;
        String lexema;
        int filaTexto;
        int columnaTexto;
        int filaCuadro;
        int columnaCuadro;
       Token token = panelToken.getToken();
       String color = token.getColor();

        tipoToken = token.getTipoToken();
        lexema = token.getLexema().getValor();
        filaTexto = token.getLexema().getFila();
        columnaTexto = token.getLexema().getColumna();
        filaCuadro = panelToken.getPosicionX() + 1;
        columnaCuadro = panelToken.getPosicionY() + 1;
            
           insertRoow(tipoToken,lexema,filaTexto,columnaTexto,filaCuadro,columnaCuadro,panelToken,color);

    }
    private void insertRoow(String tipoToken, String lexema, int filaTexto, int columnaTexto, int filaCuadro, int columnaCuadro, TokenPanel panelToken, String color) {

        modelo.addRow(new Object []{
        
           tipoToken,
           lexema, 
           filaTexto,
           columnaTexto, 
           filaCuadro, 
           columnaCuadro,
           color
        });
    }
    
    private JPanel obtenerPanelColor(String col){
        JPanel jpanel = new JPanel();
        try {
               Color color = Color.decode(col);
               jpanel.setBackground(color);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: al obtener el color del panel" + e.getMessage());
        }
        
    return jpanel; 
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        colores = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Fila", "Columna", "Fila Cuadro", "Columna Cuadro", "Color"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout coloresLayout = new javax.swing.GroupLayout(colores);
        colores.setLayout(coloresLayout);
        coloresLayout.setHorizontalGroup(
            coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        coloresLayout.setVerticalGroup(
            coloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(colores);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("TOKENS ENCONTRADOS");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ORDEN POR COLOR");

        jButton1.setText("GUARDAR LIENZO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(288, 288, 288)
                .addComponent(jLabel2)
                .addGap(203, 203, 203))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel colores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
 
}
