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
    N = { S0, S1 }
    T = { LETRA, DIGITO, SIMBOLO } 
    P = {
        S0 --> [LETRA, DIGITO, SIMBOLO] S1  
        S1 --- LAMBDA  
    }
    S = { S0 }
    */
     public enum Produccion {
        S0, S1, ERROR;
    }

    private Produccion estadoActual;

    public DatosCaracter() {
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }

    public boolean esCaracterValido(char caracter) {
        switch (estadoActual) {
            case S0:
                if (esDigito(caracter)) {
                    estadoActual = Produccion.S1;  
                } else if (esLetra(caracter)) {
                    estadoActual = Produccion.S1; 
                } else if (esSimbolo(caracter)) {
                    estadoActual = Produccion.S1;  
                } else {
                    estadoActual = Produccion.ERROR;
                }
                break;

            default:
                estadoActual = Produccion.ERROR;
                break;
        }

        return estadoActual == Produccion.S1;
    }

    private boolean esDigito(char caracter) {
        // Verifica si el charrr es un dígito
        return caracter >= '0' && caracter <= '9';
    }

    private boolean esLetra(char caracter) {
        //verificacion de datos mayusculas o minuzculas
        return (caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z');
    }

    private boolean esSimbolo(char caracter) {
        // verifica algunos caracteres permitidos s
        char[] simbolosPermitidos = { '!', '@', '#', '$', '%', '^', '&', '|', ';', ':', '\'', '\"', ',', '.', '<', '>', '?' };
        for (char simbolo : simbolosPermitidos) {
            if (caracter == simbolo) {
                return true;
            }
        }
        return false;
    }
    
}
