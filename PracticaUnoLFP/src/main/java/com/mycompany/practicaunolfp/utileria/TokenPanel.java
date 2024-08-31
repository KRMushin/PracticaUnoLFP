/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kevin-mushin
 */
public class TokenPanel extends JPanel{
    
    private int posicionX;
    private int posicionY;
    private Token token;
    private String color;
    private boolean panelVacio;
    
    private String trazasProduccion;

    public String getColor() {
        return color;
    }
    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public Token getToken() {
        return token;
    }

    public boolean isPanelVacio() {
        return panelVacio;
    }
    
    public void setPanelVacio(boolean panelVacio) {
        this.panelVacio = panelVacio;
    }   

    public TokenPanel(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.panelVacio = true;
        inicializarEvento();
        
    }
    public void asignarToken(Token token){
        this.token = token;
        cambiarColor(token.getColor());
    
    }
    private void cambiarColor(String color){
        try {
              Color nuevoColor = Color.decode(color);
              this.setBackground(nuevoColor);
        } catch (NumberFormatException e) {
            System.out.println("COLOR INVALIDO " + color);
        }
    }
    private void inicializarEvento(){
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                
                if (token != null) {
                    GenerarImagenAutomata generar = new GenerarImagenAutomata(token, TokenPanel.this);
                }else{
                    JOptionPane.showMessageDialog(null, "TOKEN VACIO :)");
                }
            }         
        });
        
    
    }
}
