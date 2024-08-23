/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.AnalizadorLexico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin-mushin
 */
public class Tokenizador { 
       
       /*
           metodo para separar toda la linea de caracteres en lexemas para su posterior analisis
           este metodo retorna una lista de cadenas ( lexemas )
        */
        public List<String> obtenerLexemas(String entrada) {
                List<String> lexemas = new ArrayList<>();
                StringBuilder lexemaActual = new StringBuilder();

                        for (int i = 0; i < entrada.length(); i++) {
                            char caracter = entrada.charAt(i);

                            if (Character.isWhitespace(caracter)) {
                                if (lexemaActual.length() > 0) {
                                    lexemas.add(lexemaActual.toString());
                                    lexemaActual.setLength(0);
                                }
                            }else if (esInicioDeTokenEspecial(lexemaActual.toString(), caracter)) {
                                        // Si detectamos que estamos iniciando una expresión como Square.Color(
                                        lexemaActual.append(caracter);
                                        // se avanza para entrar al contenido del método
                                        i++; 
                                        while (i < entrada.length()) {
                                            char c = entrada.charAt(i);
                                            lexemaActual.append(c);
                                            if (c == ')') {
                                                // si llegamos al final del método, lo agregamos a la lista
                                                i++; // avanzar para incluir el posible ';'
                                                if (i < entrada.length() && entrada.charAt(i) == ';') {
                                                    lexemaActual.append(';');
                                                }
                                                break;
                                            }
                                            i++;
                                        }
                                        lexemas.add(lexemaActual.toString());
                                        lexemaActual.setLength(0);
                                    } 

                            else {
                                lexemaActual.append(caracter);
                            }
                        }

                if (lexemaActual.length() > 0) {
                    lexemas.add(lexemaActual.toString());
                }
                return lexemas;
        }
        private boolean esInicioDeTokenEspecial(String lexema, char siguienteCaracter) {
            // Detecta el patrón de inicio de métodos como Square.Color(
            return lexema.endsWith(".Color") && siguienteCaracter == '(';
         }
    
    
}
