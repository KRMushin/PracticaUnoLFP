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
    N = {S0 , S1 , S2 }
    T = { 0-9 , . }
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
                    if (Character.isDigit(caracter)) {
                        estadoActual = Produccion.S1;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S1:
                    if (Character.isDigit(caracter)) {
                        // Se queda en S1 al recibir más dígitos de la parte entera
                    } else if (caracter == '.') {
                        // Punto decimal después de la parte entera
                        estadoActual = Produccion.S2;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S2:
                    if (Character.isDigit(caracter)) {
                         // Primer dígito de la parte fraccionaria
                        estadoActual = Produccion.S3; 
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S3:
                    if (Character.isDigit(caracter)) {
                        // Se queda en S3 al recibir más dígitos de la parte fraccion
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }

            if (estadoActual == Produccion.ERROR) {
                // Salida en caso de error
                break;  
            }
        }

        // estado de aceptacion S3
        return estadoActual == Produccion.S3;
    }
    
}
