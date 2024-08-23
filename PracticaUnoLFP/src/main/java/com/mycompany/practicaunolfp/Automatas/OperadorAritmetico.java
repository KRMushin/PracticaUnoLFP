/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class OperadorAritmetico {
    /* gramatica NTPS
    N = { s0, s2, s1,s3  }
    T = { + , - , ^, / , Mod, *  }
    P = { 
            so -- > s1
            s1 --> [ + , - , ^, / *] 
    
            so --- > M s2
            s2 ---> O s3
            s3 ---> Ds4
            s4 ---> lambda
    }
    S = {  s0   }
    */
    public enum Produccion{
        S1 , S2 , S3 , S0 ,S4, ERROR;
    }
    
    private Produccion estadoActual;
    public OperadorAritmetico() {
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }
    
     public boolean esOperadorAritmetico(String lexema) {
        reiniciar();

        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '^' || caracter == '/') {
                        estadoActual = Produccion.S1;  // Acepta operadores simples
                    } else if (caracter == 'M') {
                        estadoActual = Produccion.S2;  // Comienza a procesar "Mod"
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S2:
                    if (caracter == 'o') {
                        estadoActual = Produccion.S3;
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                case S3:
                    if (caracter == 'd') {
                        estadoActual = Produccion.S4;  // Finaliza el procesamiento de "Mod"
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;

                default:
                    estadoActual = Produccion.ERROR;
                    break;
            }

            if (estadoActual == Produccion.S1 || estadoActual == Produccion.S4) {
                break;
            }
            if (estadoActual == Produccion.ERROR) {
                break;
            }
        }

        return estadoActual == Produccion.S1 || estadoActual == Produccion.S4;
    }
    
    
}

