/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Controladores;

import com.mycompany.practicaunolfp.AnalizadorLexico.AnalizadorLexico;
import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
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
    
    private VistaPrincipal vistaPrincipal;
    private AnalizadorLexico analizadorLexico;
    
    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    public void analizarEntrada(String numeroFilas , String numeroColumnas , String entradaAnalisis){

        if (!datosValidos(numeroFilas, numeroColumnas)) {
            return;
        }
        int numeroFil = Integer.parseInt(numeroFilas);
        int numeroCol = Integer.parseInt(numeroColumnas);
                
        if (entradaAnalisis.isEmpty()) {
            return;
        }
     
        this.analizadorLexico = new AnalizadorLexico(entradaAnalisis);
        List<Token> tokens = analizadorLexico.obtenerLexemas(entradaAnalisis);
        if ((numeroFil * numeroCol) < tokens.size() ) {
            mostrarMensaje("El numero de filas y columnas ingresador no puede soportar la cantidad de tokens encontrados \n Numero Tokens: " + tokens.size());
            return;
        }
        mostrarLexemas(tokens);
        vistaPrincipal.mostrarPanelesToken(obtenerTokenPaneles(tokens,numeroFil,numeroCol), numeroFil, numeroCol);
    }
    private List<TokenPanel> obtenerTokenPaneles(List<Token> tokens, int numeroFilas, int numeroColumnas){
        List<TokenPanel> paneles = new ArrayList<>();
        int indiceToken = 0;
               for (int i = 0; i < numeroFilas; i++) {
                    for (int j = 0; j < numeroColumnas; j++) {
                        if (indiceToken < tokens.size()) {
                            Token token = tokens.get(indiceToken);
                            TokenPanel panel = new TokenPanel(i, j, token);
                            paneles.add(panel);
                            indiceToken++;
                        } else {
                            // se cierra el ciclo para no generar mas paneles adicionales
                            break;
                        }
                    }
                }
           return paneles;
    }
    
    private boolean datosValidos(String numeroFilas, String numeroColumnas){
    
            try {
                int filas = Integer.parseInt(numeroFilas);
                int columnas = Integer.parseInt(numeroColumnas);
                // Verificar si las filas y columnas son números positivos
                if (filas <= 0 || columnas <= 0) {
                    mostrarMensaje("Por favor, ingrese valores positivos para las columnas y filas.");
                    return false;
                }
                return true;
            } catch (NumberFormatException e) {
                mostrarMensaje("Por favor, ingrese datos válidos para las columnas y filas.");
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
    private void mostrarMensaje(String mensaje){
                    JOptionPane.showMessageDialog(null, mensaje);

        
    }
    
} // cerrar clase
