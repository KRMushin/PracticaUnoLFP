/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class Identificador {
    /*
    N = { S0 , S1}
    T = { A-Z , a-z ,  _ , 0- 9, }
    P = s0 --> 
    S = S0
    */
    
    
    public enum Produccion{ 
    
        S0, S1, ERROR;
    
    }
    private Produccion estadoActual;

    public Identificador() {
        // estado inicial s0
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    
    public boolean esIdentificador(String lexema){
        
         reiniciar();  // Reinicia el estado para cada lexema

        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            if (estadoActual == Produccion.S0) {
                // Estado S0: Solo aceptamos letras al inicio
                if (Character.isLetter(caracter)) {
                    estadoActual = Produccion.S1;
                } else {
                    estadoActual = Produccion.ERROR;
                    break;
                }
            } else if (estadoActual == Produccion.S1) {
                // Estado S1: Aceptamos letras, dígitos o guion bajo
                if (Character.isLetterOrDigit(caracter) || caracter == '_') {
                    // Permanece en S1 si es válido
                    estadoActual = Produccion.S1;
                } else {
                    estadoActual = Produccion.ERROR;
                    break;
                }
            }
        }

        // El lexema es un identificador válido si terminó en S1
        return estadoActual == Produccion.S1 && lexema.length() > 0;
    }
    
    
    
}
