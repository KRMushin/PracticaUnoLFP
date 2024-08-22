/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Controladores;

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
     
        
    }
    /*
        metodo para separar toda la linea de caracteres en lexemas para su posterior analisis
        este metodo retorna una lista de cadenas ( lexemas )
    */
    private List<String> obtenerLexemas(String entrada){
    
        List<String> lexemas = new ArrayList<>();
        //aca se guardan los lexemas formados
        StringBuilder lexemaActual = new StringBuilder();
        // for que itera sobre todos lo caracteres
        for (int i = 0; i < entrada.length(); i++) {
            // obtencion del caracater i
              char caracter = entrada.charAt(i);
              //evaluar si es un caracter vacio
              if (Character.isWhitespace(caracter)) {
                  //si encuentra un espacio en blanco guarda los datos anteriores construidos en el stringbuilder
                  // y establece en 0 para que se introduzca un nuevo lexema
                  if (lexemaActual.length() > 0) {
                      lexemas.add(lexemaActual.toString());
                      lexemaActual.setLength(0);
                  }
                  else if (true) {
                      
                  }
                  
                  
            }
              
            
        }
        
        return lexemas;
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
    
} // cerrar clase
