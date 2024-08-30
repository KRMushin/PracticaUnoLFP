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
                        estadoActual = Produccion.S2; // Va al estado S2 si es un signo negativo
                    } else if (Character.isDigit(caracter)) {
                        estadoActual = Produccion.S1; // Va al estado S1 si es un dígito
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S2:
                    if (Character.isDigit(caracter)) {
                        estadoActual = Produccion.S1; // Después de un '-', debe venir un dígito
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (!Character.isDigit(caracter)) {
                        estadoActual = Produccion.ERROR; // Permanece en S1 mientras haya dígitos
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

        // Acepta solo si termina en S1, lo que significa que todos los caracteres fueron correctos
        return estadoActual == Produccion.S1;
    }
    
}
