/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class SignoSimbolo {
    /* GRAMATICA
    N = { S0 , S1}
    T = { ( , ) , {  , } , [ , ] , "," , . }
    P = {
        so ----> [ { ( , ) , {  , } , [ , ] , "," , . ]s1
        s1 ----> [ { ( , ) , {  , } , [ , ] , "," , . ]S1
        S1 -----> LAMBDA
    }
    S = { S0}
    */
    public enum Produccion{
        S0 , S1 , ERROR;
    }
    private Produccion estadoActual;
    
    private void reiniciar(){
        this.estadoActual = Produccion.S0;
    }

    public SignoSimbolo() {
        this.estadoActual = Produccion.S0;
    }
    
    public boolean esSignoSimbolo(String lexema){
        reiniciar();
        for (int i = 0; i < lexema.length(); i++) {
              char caracter = lexema.charAt(i);
              switch (estadoActual) {
                case S0:
                                if (esSimboloValido(caracter)) {
                                    estadoActual = Produccion.S1;
                                }else {
                                    estadoActual = Produccion.ERROR;
                                }
                    break;
                case S1:
                                if (esSimboloValido(caracter)) {
                                    estadoActual = Produccion.S1; // estado de aceptacion
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
        return estadoActual == Produccion.S1;
    
    }
    private boolean esSimboloValido(char caracter) {
        return caracter == '(' || caracter == ')' ||
               caracter == '{' || caracter == '}' ||
               caracter == '[' || caracter == ']' ||
               caracter == ',' || caracter == '.';
    }
    private void saludar(){
    }

    
}
