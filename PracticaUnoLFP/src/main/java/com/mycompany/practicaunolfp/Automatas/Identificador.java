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
    private StringBuilder guardarPaso;
    private String trazaProduccion;
    /* area setter y getter*/

    public String getTrazaProduccion() {
        return trazaProduccion;
    }    
    public Identificador() {
        // estado inicial s0
        this.estadoActual = Produccion.S0;
        this.guardarPaso = new StringBuilder();
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
        this.guardarPaso.setLength(0);
    }
    
    public boolean esIdentificador(String lexema){
        
         reiniciar();  // Reinicia el estado para cada lexema

        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            if (estadoActual == Produccion.S0) {
                // Estado S0: Solo aceptamos letras al inicio
                if (Character.isLetter(caracter)) {
                    //s0 ---->  [ A -Z , a- z] S1
                    estadoActual = Produccion.S1;
                    guardarPaso.append("S0 -> S1 [label=\"" + caracter + "\"];\n");             
                } else {
                    estadoActual = Produccion.ERROR;
                    break;
                }
            } else if (estadoActual == Produccion.S1) {
                // Estado S1: Aceptamos letras, dígitos o guion bajo
                if (Character.isLetterOrDigit(caracter) || caracter == '_') {
                    // Permanece en S1 si es válido
                    estadoActual = Produccion.S1;
                    guardarPaso.append("S1 -> S1 [label=\"" + caracter + "\"];\n");
                } else {
                    estadoActual = Produccion.ERROR;
                    break;
                }
            }
            if (estadoActual == Produccion.S1) {
                
            }
        }
        if (estadoActual == Produccion.S1) {
            this.trazaProduccion = guardarPaso.toString();
        }
        

        // El lexema es un identificador válido si terminó en S1
        return estadoActual == Produccion.S1 && lexema.length() > 0;
    }
    
    
    
}
