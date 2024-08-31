/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.AnalizadorLexico;

/**
 *
 * @author kevin-mushin
 */


public class TokenEspecial extends Token{
    
    private int numeroFila;
    private int numeroColumna;

    public int getNumeroFila() {
        return numeroFila;
    }

    public int getNumeroColumna() {
        return numeroColumna;
    }
    
    public TokenEspecial(Lexema lexema, String color, String tipoToken,  String numeroFila, String numeroColumna) {
        super(lexema, color, tipoToken);
        establecerNumeros(numeroFila,numeroColumna);
    }
    /* establece la ubicacion del token en el lienzo*/
    private void establecerNumeros(String numeroFila,String numeroColumna){
        try {
            this.numeroColumna = Integer.parseInt(numeroColumna);
            this.numeroFila = Integer.parseInt(numeroFila);
              
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
}
