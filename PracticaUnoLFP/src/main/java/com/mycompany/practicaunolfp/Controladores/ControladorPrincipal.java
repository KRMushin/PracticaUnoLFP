/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Controladores;

import com.mycompany.practicaunolfp.AnalizadorLexico.AnalizadorLexico;
import com.mycompany.practicaunolfp.AnalizadorLexico.Lexema;
import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import com.mycompany.practicaunolfp.AnalizadorLexico.Tokenizador;
import com.mycompany.practicaunolfp.Vista.VistaPrincipal;
import com.mycompany.practicaunolfp.utileria.TokenPanel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin-mushin
 */
public class ControladorPrincipal {
    
    private final VistaPrincipal vistaPrincipal;
    private AnalizadorLexico analizadorLexico;
    
    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    public void analizarEntrada(int numeroFilas , int numeroColumnas , String entradaAnalisis){

        if (!datosValidos(numeroFilas, numeroColumnas)) {
            return;
        }
        if (entradaAnalisis.isEmpty()) {
            return;
        }
     
        this.analizadorLexico = new AnalizadorLexico(entradaAnalisis);
        List<Token> tokens = analizadorLexico.obtenerLexemas(entradaAnalisis);
        
        if ((numeroFilas * numeroColumnas) < tokens.size() ) {
           mostrarMensaje("El numero de filas y columnas ingresador no puede soportar la cantidad de tokens encontrados \n Numero Tokens: " + tokens.size());
            return;
        }
        mostrarLexemas(tokens);
        vistaPrincipal.mostrarPanelesToken(tokens);

    }
   
    private boolean datosValidos(int numeroFilas, int numeroColumnas){
    
                if (numeroFilas<= 0 || numeroColumnas <= 0) {
                    mostrarMensaje("Por favor, ingrese valores positivos para las columnas y filas.");
                    return false;
                }
                return true;
    }
    
    private void mostrarLexemas(List<Token> tokens){
    
        System.out.println(tokens.size());
        for (int i = 0; i < tokens.size(); i++) {
              Token token = tokens.get(i);
              System.out.println(" LEXEMA " + token.getLexema().getValor() + " color " + token.getColor() + " Fila" + token.getLexema().getFila() + " columna" + token.getLexema().getColumna());
        }
    
    
    }
    private void mostrarMensaje(String mensaje){
                    JOptionPane.showMessageDialog(null, mensaje);

        
    }
    private void mostLexemas(List<Lexema> lexemas){
        
        for (int i = 0; i < lexemas.size(); i++) {
              Lexema lexema = lexemas.get(i);
              
              if (lexema != null) {
                  System.out.println(lexema.getValor() + " FIl " + lexema.getFila() + " col " + lexema.getColumna());
            }
            
        }
    
    }
    
} // cerrar clase
