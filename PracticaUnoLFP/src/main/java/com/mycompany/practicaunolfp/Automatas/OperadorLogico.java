/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class OperadorLogico {
    /*
    N = { S0, S1, S2, S3, S4, S5, S6 }
    T = { A, n, d, O, r, N, o, t }
    P = {
        S0 --> S1 (si recibe 'A'),
        S1 --> S2 (si recibe 'n'),
        S2 --> S3 (si recibe 'd'),

        S0 --> S4 (si recibe 'O'),
        S4 --> S5 (si recibe 'r'),

        S0 --> S6 (si recibe 'N'),
        S6 --> S5 (si recibe 'o'),
        S5 --> S3 (si recibe 't')
    }
    S = S0
    */
    
    public enum Produccion {
        S0, S1, S2, S3, S4, S5, S6, ERROR;
    }
    
    private Produccion estadoActual;

    public OperadorLogico() {
        // estado inicial S0
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    
    public boolean esOperadorLogico(String lexema) {
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);
            
            switch (estadoActual) {
                case S0:
                    if (caracter == 'A') {
                        estadoActual = Produccion.S1;
                    } else if (caracter == 'O') {
                        estadoActual = Produccion.S4;
                    } else if (caracter == 'N') {
                        estadoActual = Produccion.S6;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                
                case S1:
                    if (caracter == 'n') {
                        estadoActual = Produccion.S2;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                    
                case S2:
                    if (caracter == 'd') {
                        estadoActual = Produccion.S3;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                    
                case S4:
                    if (caracter == 'r') {
                        estadoActual = Produccion.S5;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                    
                case S6:
                    if (caracter == 'o') {
                        estadoActual = Produccion.S5;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                    
                case S5:
                    if (caracter == 't') {
                        estadoActual = Produccion.S3;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                    
                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }
            
            if (estadoActual == Produccion.ERROR) {
                break; // salida en caso de error
            }
        }
        
        // El operador lógico es válido si terminamos en el estado S3 (para "And", "Or", "Not")
        return estadoActual == Produccion.S3;
    }
}

