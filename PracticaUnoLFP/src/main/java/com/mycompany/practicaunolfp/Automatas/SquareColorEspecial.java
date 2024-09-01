/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class SquareColorEspecial {
    /*GRAMATICA         ---> PATRON  DE TOKEN A GENERAR ---- Square.Color(#FFFFFF, 8 , 1)
    
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
    S20 -------> , S21
    S21 -----> " "S22
    S22 ------> [0 - 9]S23
    S23 -----> [ 0 - 9]S24
    S23 ------>[ ,] S25
    S25 ------> " "S26
    S26 ------> [0 - 9]S27
    S27 -----> [ 0 - 9]S24
    S27 -----> [ , ]S
    
    */

    private enum P {
        S0, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20, S21, S22, S23, S24, S25, S26, S27, S28, S29, S30, S31, ERROR, FINAL;
    }

    private P estadoActual;
    private StringBuilder colorConstructor;
    private StringBuilder construirFilas;
    private StringBuilder construirColumnas;
    private String color;
    private String numeroFilas;
    private String numeroColumnas;

    public String getColor() {
        return color;
    }

    public String getNumeroFilas() {
        return numeroFilas;
    }

    public String getNumeroColumnas() {
        return numeroColumnas;
    }
    
    

    public SquareColorEspecial() {
        this.estadoActual = P.S0;
        this.colorConstructor = new StringBuilder();
        this.construirFilas = new StringBuilder();
        this.construirColumnas = new StringBuilder();
    }

    public void reiniciar() {
        this.estadoActual = P.S0;
        this.colorConstructor.setLength(0);
        this.construirFilas.setLength(0);
        this.construirColumnas.setLength(0);
    }

    public boolean esSquareEspecial(String lexema) {
        reiniciar();
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);
            switch (estadoActual) {
                case S0:
                    if (caracter == 'S') {
                        estadoActual = P.S1;
                    } else {
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
                case S15:
                case S16:
                case S17:
                case S18:
                case S19:
                    if (esHexadecimalC(caracter)) {
                        colorConstructor.append(caracter);
                        estadoActual = P.values()[estadoActual.ordinal() + 1];
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S20:
                    if (caracter == ',') {
                        estadoActual = P.S21;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S21:
                    if (caracter == ' ') {
                        estadoActual = P.S22;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S22:
                    if (esNumeroValido(caracter)) {
                        estadoActual = P.S23;
                        construirFilas.append(caracter);
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S23:
                    if (esNumeroValido(caracter)) {
                        construirFilas.append(caracter);
                    } else if (caracter == ',') {
                        estadoActual = P.S25;
                    } else if (caracter == ' ') {
                        // permite espacios, pero no cambia el estado
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S25:
                    if (caracter == ' ') {
                        estadoActual = P.S26;
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S26:
                    if (esNumeroValido(caracter)) {
                        estadoActual = P.S27;
                        construirColumnas.append(caracter);
                    } else {
                        estadoActual = P.ERROR;
                    }
                    break;
                case S27:
                    if (esNumeroValido(caracter)) {
                        construirColumnas.append(caracter);
                    } else if (caracter == ')') {
                        estadoActual = P.FINAL;
                    } else if (caracter == ' ') {
                        // esta vaina permanece en el estado actual para verificar si e mantiene otro numero
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
            this.numeroFilas = construirFilas.toString();
            this.numeroColumnas = construirColumnas.toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean esHexadecimalC(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private boolean esNumeroValido(char c) {
        return c >= '1' && c <= '9';
    }
}
