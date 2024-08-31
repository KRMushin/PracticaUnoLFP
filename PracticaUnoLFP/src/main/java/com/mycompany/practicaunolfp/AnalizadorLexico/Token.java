/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.AnalizadorLexico;

/**
 *
 * @author kevin-mushin
 */
public class Token {
    
    private Lexema lexema;
    private String color;
    private String tipoToken;

    public Lexema getLexema() {
        return lexema;
    }

    public String getColor() {
        return color;
    }

    public String getTipoToken() {
        return tipoToken;
    }
        // METODO CONSTRUCTOR
    public Token(Lexema lexema, String color, String tipoToken) {
        this.lexema = lexema;
        this.color = color;
        this.tipoToken = tipoToken;
    }
    
    
    
}
