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
    N = { S0 , S1}
    T = { 0 - 9 }
    P = {
        S0 --> S1
        S1 --> 0 - 9 S1
        S1 --- LAMBDA
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
    
    public boolean esEntero(String lexema){
        for (int i = 0; i < lexema.length(); i++) {
              char caracter = lexema.charAt(i);
              
              switch (estadoActual) {
                case S0:
                            if (caracter == '0' || caracter == '1' || caracter == '2' || caracter == '3' || caracter == '4' || caracter == '5' || caracter == '6' || caracter == '7' || caracter == '8' || caracter == '9') {
                                estadoActual = Produccion.S1;
                               }else{
                                estadoActual = Produccion.ERROR;
                               }
                    break;
                case S1:
                                if (!Character.isDigit(caracter)) {
                                    estadoActual = Produccion.ERROR;
                                   }
                                //permanece en estado s1
                    break;
                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }
                if (estadoActual == Produccion.ERROR) {
                break;  // Salida en caso de error
                }
                
        }    
               return estadoActual == Produccion.S1;  
    }
    
}
