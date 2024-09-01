/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class DatosEnteros {
    /*
    /*
    N = { S0, S1, S2 }
    T = { 0 - 9, - }
    P = {
        S0 --> S1 (si es dígito)
        S0 --> S2 (si es '-')
        S2 --> S1 (si es dígito)
        S1 --> 0 - 9 S1
        S1 --> LAMBDA
    }
    S = S0
   
    
    */
    public enum Produccion {
        S0, S1, S2, ERROR, ACEPTACION;
    }

    private Produccion estadoActual;

    public DatosEnteros() {
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    
   public boolean esEntero(String lexema) {
        reiniciar();
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (caracter == '-') {
                        // hacia el estado S2 si es un signo negativo
                        estadoActual = Produccion.S2; 
                    } else if (esDigito(caracter)) {
                         // haciaa el estado S1 si es un dígito
                        estadoActual = Produccion.S1;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S2:
                    if (esDigito(caracter)) {
                         //despes de un '-', debe venir un dígito
                        estadoActual = Produccion.S1;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (!esDigito(caracter)) {
                        estadoActual = Produccion.ERROR; 
                    }
                    break;

                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }

            if (estadoActual == Produccion.ERROR) {
                break; // salida por error
            }
        }

        // estado de aceptacion S1
        return estadoActual == Produccion.S1;
    }
   
       private boolean esDigito(char caracter) {
            return caracter >= '0' && caracter <= '9';
        }
    
}
