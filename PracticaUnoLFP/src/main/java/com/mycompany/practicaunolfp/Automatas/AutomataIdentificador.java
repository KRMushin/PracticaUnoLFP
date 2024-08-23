/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class AutomataIdentificador {
    /*
    N = { S0 , S1}
    T = { A-Z , a-z ,  _ , 0- 9 }
    P = s0 --> 
    S = S0
    */
    
    
    public enum Produccion{ 
    
        S0, S1, ERROR;
    
    }
    private Produccion estadoActual;

    public AutomataIdentificador() {
        // estado inicial s0
        this.estadoActual = Produccion.S0;
    }
    
    public boolean esIdentificador(String lexema){
        for (int i = 0; i < lexema.length(); i++) {
              char caracter = lexema.charAt(i);
                    if (Character.isLetter(caracter) && estadoActual == Produccion.S0) {
                         estadoActual = Produccion.S1;
                     }else if (estadoActual == Produccion.S1 && (Character.isLetterOrDigit(caracter) || caracter == '_')) {
                         estadoActual = Produccion.S1;
                     }else{
                         estadoActual = Produccion.ERROR;
                         break; //salida
                     }
                  
               }
            
        
        
    return estadoActual == Produccion.S1;
    }
    
    
    
}
