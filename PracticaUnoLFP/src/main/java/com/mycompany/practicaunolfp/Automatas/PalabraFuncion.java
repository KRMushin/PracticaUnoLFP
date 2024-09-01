/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

import com.mycompany.practicaunolfp.AnalizadorLexico.Lexema;
import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import com.mycompany.practicaunolfp.utileria.TipoOperador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin-mushin
 */
public class PalabraFuncion {

    
    /*
        
        q0 = [A-Z]q1
        q0 = [a-z]q2
        
    
    */
    public enum Produccion {
        S0, S1, S3,ERROR;
    }

    private Produccion estadoActual;
    private StringBuilder constructorPalabra;
    private StringBuilder constructorSimbolos;
    private SignoSimbolo automataSignos;
    private PalabrasReservadas automataPalabrasReservada;
    private Identificador automataIdentificador;

    public PalabraFuncion() {
        this.estadoActual = Produccion.S0;
        this.constructorPalabra = new StringBuilder();
        this.constructorSimbolos = new StringBuilder();
        this.automataSignos = new SignoSimbolo();
        this.automataPalabrasReservada = new PalabrasReservadas();
        this.automataIdentificador = new Identificador();
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
        this.constructorPalabra.setLength(0);
        this.constructorSimbolos.setLength(0);
    }
    public List<Token> procesarPalabra(Lexema lexema){
        List<Token> tokens = new ArrayList<>();
        
        
        if (!esPalabraFuncion(lexema.getValor()) || constructorPalabra.toString().isEmpty() || constructorSimbolos.toString().isEmpty()) {
            return null;
        }
        
        if (automataPalabrasReservada.esPalabraReservada(constructorPalabra.toString())) {
            
            String color = TipoOperador.PALABRA_RESERVADA.obtenerColor(lexema.getValor());
            tokens.add(new Token(new Lexema(constructorPalabra.toString(),lexema.getFila(),lexema.getColumna()),color,"PALABRA_RESERVADA"));
        } else if (automataIdentificador.esIdentificador(constructorPalabra.toString())) {
            
            String color = TipoOperador.IDENTIFICADOR.obtenerColor(lexema.getValor());
            tokens.add(new Token(new Lexema(constructorPalabra.toString(),lexema.getFila(),lexema.getColumna()),color,"IDENTIFICADOR"));
        }
        
        String simbolos = constructorSimbolos.toString();
        for (int i = 0; i < simbolos.length(); i++) {
            
              char caracter = simbolos.charAt(i);
              if (automataSignos.esSignoSimbolo(String.valueOf(caracter))) {
                  String color = TipoOperador.SIGNO_SIMBOLO.obtenerColor(String.valueOf(caracter));
                  tokens.add(new Token(new Lexema(String.valueOf(caracter),lexema.getFila(),lexema.getFila()),color,"SIGNO_SIMBOLO"));
            }
        }
        
        return tokens;
        
    }
    public boolean esPalabraFuncion(String lexema) {
        reiniciar();
        
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);

            switch (estadoActual) {
                case S0:
                    if (esLetraMayuscula(caracter) || esLetraMinuscula(caracter)) {
                        estadoActual = Produccion.S1;
                        constructorPalabra.append(caracter);
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                case S1:
                    if (esLetraMinuscula(caracter) || esLetraMayuscula(caracter)) {
                        estadoActual = Produccion.S1;
                        constructorPalabra.append(caracter);
                    } else if (automataSignos.esSignoSimbolo(String.valueOf(caracter))) {
                        estadoActual = Produccion.S3;
                        constructorSimbolos.append(caracter);
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                case S3:
                    if (automataSignos.esSignoSimbolo(String.valueOf(caracter))) {
                        estadoActual = Produccion.S3;
                        constructorSimbolos.append(caracter);
                    } else {
                        estadoActual = Produccion.ERROR;
                    }
                    break;
                default:
                    return false;
            }
            if (estadoActual == Produccion.ERROR) {
                break;
            }
        }
        return estadoActual == Produccion.S3;
    }
    
    private boolean esLetraMayuscula(char caracter) {
        return caracter >= 'A' && caracter <= 'Z';
    }

    private boolean esLetraMinuscula(char caracter) {
        return caracter >= 'a' && caracter <= 'z';
    }
    
}
