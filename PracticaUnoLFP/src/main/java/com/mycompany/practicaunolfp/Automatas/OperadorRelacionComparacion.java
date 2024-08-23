/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class OperadorRelacionComparacion {
    /*
    N = { S0, S1, S2, S3 }
    T = { =, <, >, ! }
    P = {
        S0 --> S1 (si recibe '='),
        S0 --> S2 (si recibe '>'),
        S0 --> S3 (si recibe '<'),
        S1 --> S1 (si recibe '='), // ==
        S3 --> S1 (si recibe '='), // <=
        S2 --> S1 (si recibe '='), // >=
        S3 --> S1 (si recibe '>'), // <>

    }
    S = S0
    */
    
    public enum Produccion {
        S0, S1, S2, S3, S4, ERROR;
    }
    
    private Produccion estadoActual;

    public OperadorRelacionComparacion() {
        // Estado inicial S0
        this.estadoActual = Produccion.S0;
    }
    
   public boolean esOperadorRelacionalComparacion(String lexema) {
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);
            
            switch (estadoActual) {
                case S0:
                    if (caracter == '=') {
                        estadoActual = Produccion.S1;  // Igual o posible ==
                    } else if (caracter == '>') {
                        estadoActual = Produccion.S2;  // Mayor que o posible >=
                    } else if (caracter == '<') {
                        estadoActual = Produccion.S3;  // Menor que o posible <= o <>
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                
                case S1:
                    if (caracter == '=') {
                        estadoActual = Produccion.S4;  // Igual (==)
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                    
                case S2:
                    if (caracter == '=') {
                        estadoActual = Produccion.S4;  // Mayor o igual (>=)
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                    
                case S3:
                    if (caracter == '=' || caracter == '>') {
                        estadoActual = Produccion.S4;  // Menor o igual (<=) o diferente (<>)
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }
            
            if (estadoActual == Produccion.ERROR) {
                break; // Salida en caso de error
            }
        }
        
        // El operador relacional es válido si terminamos en el estado S4
        return estadoActual == Produccion.S4;
    }
}
