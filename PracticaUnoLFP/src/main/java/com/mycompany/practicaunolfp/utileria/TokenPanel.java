/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import java.awt.Color;
import javax.swing.BorderFactory;
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

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public Token getToken() {
        return token;
    }
    
    

    public TokenPanel(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
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
    
    
    
}
