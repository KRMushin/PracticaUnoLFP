/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class DatosCadena {
    /*GRAMATICA
    N = { S0 , S1}
    T = {A-Z, a-z , 0-9 }
    P = {
            S0 ---->[ 0-9, A-Z,a-z] S1
            S1 ---->[ 0-9, A-Z,a-z]s1
            s1 ---> lambda
    
    }
    S = { S0 }
    */
    public enum Produccion {
        S0, S1, ERROR;
    }

    private Produccion estadoActual;

    public DatosCadena() {
        this.estadoActual = Produccion.S0;
    }

    public boolean esCadenaValida(String lexema) {
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (Character.isLetterOrDigit(caracter)) {
                        estadoActual = Produccion.S1;  
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (Character.isLetterOrDigit(caracter)) {
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }

            if (estadoActual == Produccion.ERROR) {
                break;  
            }
        }
        return estadoActual == Produccion.S1;
    }
    
}
