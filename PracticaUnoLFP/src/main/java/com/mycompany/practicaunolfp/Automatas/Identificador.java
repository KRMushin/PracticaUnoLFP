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
    /* area setter y getter*/

   
    public Identificador() {
        // estado inicial s0
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    
    public boolean esIdentificador(String lexema){
        
         reiniciar(); 

        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            if (estadoActual == Produccion.S0) {
                // estado S0: Solo aceptamos letras al inicio
                if (esLetra(caracter)) {
                    //s0 ---->  [ A -Z , a- z] S1
                    estadoActual = Produccion.S1;
                } else {
                    estadoActual = Produccion.ERROR;
                    break;
                }
            } else if (estadoActual == Produccion.S1) {
                // estado S1: Aceptamos letras, dígitos o guion bajo
                if (esLetraODigito(caracter) || caracter == '_') {
                    // permanece en S1 si es válido
                    estadoActual = Produccion.S1;
                } else {
                    estadoActual = Produccion.ERROR;
                    break;
                }
            }
            if (estadoActual == Produccion.S1) {
                
            }
        }
        // estado de aceptacion S1
        return estadoActual == Produccion.S1 && lexema.length() > 0;
    }
       
       private boolean esLetra(char caracter) {
            return (caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z');
        }

        private boolean esLetraODigito(char caracter) {
            return esLetra(caracter) || esDigito(caracter);
        }

        private boolean esDigito(char caracter) {
            return caracter >= '0' && caracter <= '9';
        }
    
    
    
}
