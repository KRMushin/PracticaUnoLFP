/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class OperadorAsignacion {
    /* GRAMATICA
    N = { s0 , s1}
    T = {=, += , -= , *= , /=}
    P = {
        S0 --> = 
        S0 --> S1
        S1 --> [+ , - , * , / ]S1
        S1 --> =
    }
    S = S0
    */
    public enum Produccion {
        S0, S1, S2, ERROR, ACEPTACION;
    }

    private Produccion estadoActual;

    public OperadorAsignacion() {
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    public boolean esOperadorAsignacion(String lexema) {
                reiniciar();

        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (caracter == '=') {
                        estadoActual = Produccion.ACEPTACION;  
                    } else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
                        estadoActual = Produccion.S1;  
                      // posible inicio de asignación compuesta
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (caracter == '=') {
                        estadoActual = Produccion.ACEPTACION;  
                    // completa la asignación compuesta
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
                // salida en caso de error
            }
        }

        return estadoActual == Produccion.ACEPTACION;
    }
}
