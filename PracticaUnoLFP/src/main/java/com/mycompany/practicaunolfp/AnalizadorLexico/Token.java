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
    
    private String lexema;
    private String color;
    private String tipoToken;
    private String trazaProduccion;

    public String getLexema() {
        return lexema;
    }

    public String getColor() {
        return color;
    }

    public String getTipoToken() {
        return tipoToken;
    }

    public String getTrazaProduccion() {
        return trazaProduccion;
    }

    
    
    public Token(String lexema, String color, String tipoToken, String trazaProduccion) {
        this.lexema = lexema;
        this.color = color;
        this.tipoToken = tipoToken;
        this.trazaProduccion = trazaProduccion;
    }
    
    
    
}
