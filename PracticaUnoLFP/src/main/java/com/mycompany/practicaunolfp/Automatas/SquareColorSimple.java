/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class SquareColorSimple {
    /*GRAMATICA
    
    S0 ---> S s1
    S1 ----> q S2
    S2 -----> u S3
    S3 ---> a s4
    S4 ----> r S5
    S5 -----> e S6
    S6 ---> . s7
    S7 ----> C S8
    S8 -----> o S9
    S9 ---> l S10
    S10 ----> o S11
    S11 -----> r S12
    S12 _____> ( S13
    S13 ----> # S14
    S14 ----> HEX S15
    S15 ----> HEX S16
    S16 ----> HEX S17
    S17 ----> HEX S18
    S18 ----> HEX S19
    S19 ----> HEX S20
    S20 -------> ) 
    */
    private enum P{
    
        S0 , S1 , S2 ,S3 , S4 , S5 ,  S6 , S7 , S8 ,S9 , S10 , S11 ,  S12 , S13 , S14 ,S15 , S16 , S17 ,  S18 , S19 , S20 , ERROR , FINAL;
    }

    private P estadoActual;
    private StringBuilder colorConstructor;
    private String color;

    public String getColor() {
        return color;
    }
    public SquareColorSimple() {
        this.estadoActual = P.S0;
        this.colorConstructor = new StringBuilder();
    }
    public void reiniciar() {
        this.estadoActual = P.S0;
        this.colorConstructor.setLength(0); 
    }
    
    public boolean esSquareSimple(String lexema){
        reiniciar();
        for (int i = 0; i < lexema.length(); i++) {
              char caracter = lexema.charAt(i);
              switch (estadoActual) {
                case S0:
                            if (caracter == 'S') {
                                estadoActual = P.S1;
                            }else{
                                estadoActual = P.ERROR;
                            }
                    break;
              
                case S1:
                    if (caracter == 'q') {
                        estadoActual = P.S2;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S2:
                    if (caracter == 'u') {
                        estadoActual = P.S3;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S3:
                    if (caracter == 'a') {
                        estadoActual = P.S4;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S4:
                    if (caracter == 'r') {
                        estadoActual = P.S5;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S5:
                    if (caracter == 'e') {
                        estadoActual = P.S6;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S6:
                    if (caracter == '.') {
                        estadoActual = P.S7;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S7:
                    if (caracter == 'C') {
                        estadoActual = P.S8;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S8:
                    if (caracter == 'o') {
                        estadoActual = P.S9;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S9:
                    if (caracter == 'l') {
                        estadoActual = P.S10;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S10:
                    if (caracter == 'o') {
                        estadoActual = P.S11;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S11:
                    if (caracter == 'r') {
                        estadoActual = P.S12;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S12:
                    if (caracter == '(') {
                        estadoActual = P.S13;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S13:
                    if (caracter == '#') {
                        colorConstructor.append(caracter);
                        estadoActual = P.S14;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S14:
                    if ( esHexadecimalC(caracter)) {
                        colorConstructor.append(caracter);
                        estadoActual = P.S15;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S15:
                    if ( esHexadecimalC(caracter)) {
                        colorConstructor.append(caracter);
                        estadoActual = P.S16;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S16:
                    if ( esHexadecimalC(caracter)) {
                         colorConstructor.append(caracter);
                        estadoActual = P.S17;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S17:
                    if ( esHexadecimalC(caracter)) {
                        colorConstructor.append(caracter);                        
                        estadoActual = P.S18;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S18:
                    if ( esHexadecimalC(caracter)) {
                        colorConstructor.append(caracter);                        
                        estadoActual = P.S19;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S19:
                    if ( esHexadecimalC(caracter)) {
                         colorConstructor.append(caracter);
                        estadoActual = P.S20;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S20:
                    if (caracter == ')') {
                        estadoActual = P.FINAL;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                default:
                    estadoActual = P.ERROR;
                    break;
            }

            if (estadoActual == P.ERROR) {
                break;
            }
        }
        if (estadoActual == P.FINAL) {
            this.color = colorConstructor.toString();
            return true;
        }else{
            return false;
        }
    }
     private boolean esHexadecimalC(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    
}
