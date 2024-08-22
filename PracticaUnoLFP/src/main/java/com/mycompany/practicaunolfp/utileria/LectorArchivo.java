/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author kevin-mushin
 */
public class LectorArchivo {
    
    public void leerArchivo(String PATH_ENTRADA,JTextArea areaTexto){
    
        StringBuilder instrucciones = new StringBuilder();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(PATH_ENTRADA))) {
            String lecturaInstruccion;
            while((lecturaInstruccion = reader.readLine()) != null) {
                                //guardando cada instruccion en el string builder
                instrucciones.append(lecturaInstruccion).append("\n");            
                areaTexto.append(lecturaInstruccion + "\n");
            }
            
        } catch (IOException e) {
            System.out.println("Error al buscar archivo de entrada " + e.getMessage());
        }
        // convirtiendo las isntruccioenes a un string
    }
    
   
    
    
}
