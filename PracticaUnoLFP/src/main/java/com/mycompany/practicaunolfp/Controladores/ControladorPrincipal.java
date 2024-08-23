/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Controladores;

import com.mycompany.practicaunolfp.AnalizadorLexico.AnalizadorLexico;
import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import com.mycompany.practicaunolfp.Vista.VistaPrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin-mushin
 */
public class ControladorPrincipal {
    
    private VistaPrincipal vistaPrincipal;
    private AnalizadorLexico analizadorLexico;
    
    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    public void analizarEntrada(String numeroFilas , String numeroColumnas , String entradaAnalisis){
        System.out.println(entradaAnalisis);
        if (!datosValidos(numeroFilas, numeroColumnas)) {
            return;
        }
        if (entradaAnalisis.isEmpty()) {
            return;
        }
     
        this.analizadorLexico = new AnalizadorLexico(entradaAnalisis);
        List<Token> tokens = analizadorLexico.obtenerLexemas(entradaAnalisis);
        mostrarLexemas(tokens);
        
    }    
    private boolean datosValidos(String numeroFilas, String numeroColumnas){
    
            try {
                int filas = Integer.parseInt(numeroFilas);
                int columnas = Integer.parseInt(numeroColumnas);
                // Verificar si las filas y columnas son números positivos
                if (filas <= 0 || columnas <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores positivos para las columnas y filas.");
                    return false;
                }
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos para las columnas y filas.");
                return false;
            }
    }
    
    private void mostrarLexemas(List<Token> tokens){
    
        System.out.println(tokens.size());
        for (int i = 0; i < tokens.size(); i++) {
              Token token = tokens.get(i);
              System.out.println(" LEXEMA " + token.getLexema() + " color " + token.getColor());
        }
    
    
    }
    
} // cerrar clase
