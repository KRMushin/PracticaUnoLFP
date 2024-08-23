/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class DatosBooleano {
    /*
    N = { S0 , S1 , S2 , S3 , S4 , S6 , S7 ,S8}
    T = { T , R , U , F , A , L , S ,E }
    P = {
        S0 --> TS2
        S2 --> RS3
        S3 --> US4
        S4 ---> E
        S0 ---> FS5
        S5 ---> AS6
        S6 ---> LS7
        S7 ---> S S8
        S8 ---> S4
    }
    S = { S0} 
    */
     public enum Produccion {
        S0, S2, S3, S4, S5, S6, S7, S8, ACEPTACION, ERROR;
    }

    private Produccion estadoActual;

    public DatosBooleano() {
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    public boolean esBooleanoValido(String lexema) {
        reiniciar();
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (caracter == 'T') {
                        estadoActual = Produccion.S2;
                    } else if (caracter == 'F') {
                        estadoActual = Produccion.S5;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S2:
                    if (caracter == 'r') {
                        estadoActual = Produccion.S3;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S3:
                    if (caracter == 'u') {
                        estadoActual = Produccion.S4;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S4:
                    if (caracter == 'e') {
                        estadoActual = Produccion.ACEPTACION;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S5:
                    if (caracter == 'a') {
                        estadoActual = Produccion.S6;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S6:
                    if (caracter == 'l') {
                        estadoActual = Produccion.S7;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S7:
                    if (caracter == 's') {
                        estadoActual = Produccion.S8;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S8:
                    if (caracter == 'e') {
                        estadoActual = Produccion.ACEPTACION;
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

        // El valor booleano es válido si termina en el estado ACEPTACION
        return estadoActual == Produccion.ACEPTACION;
    }
}
