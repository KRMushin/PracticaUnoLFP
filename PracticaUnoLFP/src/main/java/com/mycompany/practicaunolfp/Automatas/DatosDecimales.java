/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class DatosDecimales {
    /*

    P = {
            
            S0 --> [ 0- 9]S1
            S1 --> [ 0- 9] S1
            S1 ----> .S2
            S2 -----> [ 0 -9] S3
            S3 ----> [0-9]S3
            S3 ---> LAMBDA
    
    
    }
    S = {S0}
    */
    public enum Produccion {
        S0, S1, S2, S3, S4, S5, S6, ERROR;
    }
    
    private Produccion estadoActual;

    public DatosDecimales() {
        // estado inicial S0
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    public boolean esDecimalValido(String lexema) {
                reiniciar();

        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (esDigito(caracter)) {
                        estadoActual = Produccion.S1;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (esDigito(caracter)) {
                        // se queda en S1 al recibir más dígitos de la parte entera
                    } else if (caracter == '.') {
                        // punto decimal después de la parte entera
                        estadoActual = Produccion.S2;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S2:
                    if (esDigito(caracter)) {
                        // primer digito hallado
                        estadoActual = Produccion.S3; 
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S3:
                    if (esDigito(caracter)) {
                        // se queda en estado 3 si existen mas digitos
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

        // estado de aceptacion S3
        return estadoActual == Produccion.S3;
    }
       

      private boolean esDigito(char caracter) {
           return caracter >= '0' && caracter <= '9';
      }
    
}
