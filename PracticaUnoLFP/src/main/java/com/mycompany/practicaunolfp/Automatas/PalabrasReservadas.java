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
    T = { A-Z, a-z , .}
    P = {
        
        S0 ---> [A-Z]S1
        s1 ----> [ a- z]s1
        s1 --->  lambda
        S1 ----> [.] S2
        S2 ---> [ A -Z ,] S3
        S3 ---> [ a-z]s3
        S3 ----> [A-Z]S3
        s3 ----> lambda
    } 
    S = S0
    */
    public enum Produccion {
        S0, S1, S2, S3 , ERROR;
    }

    private Produccion estadoActual;

    public PalabrasReservadas() {
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }

   public boolean esPalabraReservada(String lexema) {
        reiniciar();
        
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                            if (esLetraMayuscula(caracter)) {
                                estadoActual = Produccion.S1;
                             }else{
                                estadoActual = Produccion.ERROR;
                            }
                    break;
                case S1:
                            if (esLetraMinuscula(caracter)) {
                                estadoActual = Produccion.S1;
                            }
                            else if (caracter == '.') {
                                estadoActual = Produccion.S2;
                            }else {
                                estadoActual = Produccion.ERROR;
                            }
                    break;
                case S2:
                            if (esLetraMayuscula(caracter)) {
                                estadoActual = Produccion.S3;
                            }else{
                                estadoActual = Produccion.ERROR;
                            }
                    break;
                case S3:
                        if (esLetraMayuscula(caracter)) {
                              estadoActual = Produccion.S3;
                         }else if (esLetraMinuscula(caracter)) {
                               estadoActual = Produccion.S3;
                         }else{
                             estadoActual = Produccion.ERROR;
                         }
                    break;
                default:
                    estadoActual = Produccion.ERROR;
            }
           
            if (estadoActual == Produccion.ERROR) {
                break; 
            }
        }

        return estadoActual == Produccion.S1 || estadoActual == Produccion.S3;  // La palabra es válida solo si termina en S1
    }

    private boolean esLetraMayuscula(char caracter) {
        return caracter >= 'A' && caracter <= 'Z';
    }

    private boolean esLetraMinuscula(char caracter) {
        return caracter >= 'a' && caracter <= 'z';
    }
    
}
