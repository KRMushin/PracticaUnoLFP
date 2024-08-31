/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Controladores;

import com.mycompany.practicaunolfp.AnalizadorLexico.AnalizadorLexico;
import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import com.mycompany.practicaunolfp.Vista.VistaPrincipal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin-mushin
 */
public class ControladorPrincipal {
    
    private final VistaPrincipal vistaPrincipal;
    private AnalizadorLexico analizadorLexico;
    private List<Token> tokens;
    
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
        tokens = analizadorLexico.obtenerLexemas(entradaAnalisis);
        
        if ((numeroFilas * numeroColumnas) < tokens.size() ) {
           mostrarMensaje("El numero de filas y columnas ingresador no puede soportar la cantidad de tokens encontrados \n Numero Tokens: " + tokens.size());
            return;
        }
        vistaPrincipal.mostrarPanelesToken(tokens);
    }
   
    private boolean datosValidos(int numeroFilas, int numeroColumnas){
    
                if (numeroFilas<= 0 || numeroColumnas <= 0) {
                    mostrarMensaje("Por favor, ingrese valores positivos para las columnas y filas.");
                    return false;
                }
                return true;
    }
    private void mostrarMensaje(String mensaje){
         JOptionPane.showMessageDialog(null, mensaje);       
    }    
} // cerrar clase
