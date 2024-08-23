/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class PalabrasReservadas {
    /*
    N
    T = { A-Z, a-z}
    P = {
        
        S0 ---> [A-Z]S1
        s1 ----> [ a- z]s1
        s1 --->  lambda
    } 
    S = S0
    */
    public enum Produccion {
        S0, S1, ERROR;
    }

    private Produccion estadoActual;

    public PalabrasReservadas() {
        this.estadoActual = Produccion.S0;
    }

    public boolean esPalabraReservada(String lexema) {
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (esLetraMayuscula(caracter)) {
                        estadoActual = Produccion.S1;  // Transición al estado S1 si es una mayúscula
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (esLetraMinuscula(caracter)) {
                        // Permanece en S1 si es una minúscula
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }

            if (estadoActual == Produccion.ERROR) {
                break;  // Salida en caso de error
            }
        }

        return estadoActual == Produccion.S1;  // La palabra es válida si termina en S1
    }

    private boolean esLetraMayuscula(char caracter) {
        return caracter >= 'A' && caracter <= 'Z';
    }

    private boolean esLetraMinuscula(char caracter) {
        return caracter >= 'a' && caracter <= 'z';
    }
    
}
