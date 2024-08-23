/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class DatosCaracter {
    /*
    N = { S0, S1, S2, ERROR }
    T = { LETRA, DIGITO, SIMBOLO } 
    P = {
        S0 --> ' S1
        S1 --> [ LETRA, DIGITO, SIMBOLO ] S2
        S2 --> ' S3
    }
    S = { S0 }
    */
    
    public enum Produccion {
        S0, S1, S2, S3 ,ERROR;
    }

    private Produccion estadoActual;

    public DatosCaracter() {
        this.estadoActual = Produccion.S0;
    }

    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }

    public boolean esCaracterValido(String lexema) {
        reiniciar();
        
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);
            
            switch (estadoActual) {
                case S0:
                    if (caracter == '\'') {
                        estadoActual = Produccion.S1; // Encuentra la primera comilla simple
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (esDigito(caracter) || esLetra(caracter) || esSimbolo(caracter)) {
                        estadoActual = Produccion.S2; // Encuentra un carácter válido
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S2:
                    if (caracter == '\'') {
                        estadoActual = Produccion.S3; // Encuentra la segunda comilla simple, acepta la entrada
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
        
        // El carácter es válido si terminamos en el estado S3
        return estadoActual == Produccion.S3;
    }

    private boolean esDigito(char caracter) {
        // Verifica si el carácter es un dígito
        return caracter >= '0' && caracter <= '9';
    }

    private boolean esLetra(char caracter) {
        // Verifica si el carácter es una letra mayúscula o minúscula
        return (caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z');
    }

    private boolean esSimbolo(char caracter) {
        // Verifica si el carácter es uno de los símbolos permitidos
        char[] simbolosPermitidos = { '!', '@', '#', '$', '%', '^', '&', '|', ';', ':', ',', '.', '<', '>', '?' };
        for (char simbolo : simbolosPermitidos) {
            if (caracter == simbolo) {
                return true;
            }
        }
        return false;
    }
}
