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
 P = {
    S0 → INICIO
    S0 → ESPACIO_EN_BLANCO S1
    S1 → LEXEMA S2
    S2 → ESPACIO_EN_BLANCO S3
    S3 → TOKEN_ESPECIAL S4
    S4 → FINAL
    S0 → LEXEMA S5
    S5 → ESPACIO_EN_BLANCO S6
    S6 → LEXEMA S7
    S7 → S4
}
 */
public class Tokenizador {

    
    /* ESTADOS DE TRANSICION */
    private enum Estado {       
            INICIO,
            LEXEMA,
            ESPACIO_EN_BLANCO,
            TOKEN_ESPECIAL,
            FINAL
    }
    /* este metodo del autoamta es llamado por la vista del programa para obtener los lexemas que separo el tokenizador*/
    public List<Lexema> obtenerLexemas(String entrada) {
        List<Lexema> lexemas = new ArrayList<>();
        StringBuilder lexemaActual = new StringBuilder();
        Estado estadoActual = Estado.INICIO;

        int fila = 1;
        int columna = 1;
        int inicioColumnaLexema = 1;

        for (int i = 0; i < entrada.length(); i++) {
            char caracter = entrada.charAt(i);

            switch (estadoActual) {
                case INICIO:
                    if (esEspacioEnBlanco(caracter)) {
                        if (caracter == '\n') {
                            fila++;
                            columna = 0;
                        }
                        estadoActual = Estado.ESPACIO_EN_BLANCO;
                    } else if (esInicioDeTokenEspecial(lexemaActual.toString(), caracter)) {
                        estadoActual = Estado.TOKEN_ESPECIAL;
                        inicioColumnaLexema = columna; 
                        lexemaActual.append(caracter);
                    } else {
                        estadoActual = Estado.LEXEMA;
                        inicioColumnaLexema = columna;
                        lexemaActual.append(caracter);
                    }
                    break;

                case LEXEMA:
                    if (esEspacioEnBlanco(caracter)) {
                        lexemas.add(new Lexema(lexemaActual.toString(), fila, inicioColumnaLexema));
                        lexemaActual.setLength(0);
                        if (caracter == '\n') {
                            fila++;
                            columna = 0;
                        }
                        estadoActual = Estado.ESPACIO_EN_BLANCO;
                    } else if (esInicioDeTokenEspecial(lexemaActual.toString(), caracter)) {
                        // agrega el lexema actual si la lectura del boleano resulta que es inicio de un square.color especial
                        lexemaActual.append(caracter); 
                        estadoActual = Estado.TOKEN_ESPECIAL;
                    } else {
                        lexemaActual.append(caracter);
                    }
                    break;

                case ESPACIO_EN_BLANCO:
                    if (caracter == '\n') {
                        fila++;
                        columna = 0;
                    }
                    if (!esEspacioEnBlanco(caracter)) {
                        estadoActual = Estado.LEXEMA;
                        // se modifica el numero de columna para que despues se le asigne al lexema
                        inicioColumnaLexema = columna; 
                        lexemaActual.append(caracter);
                    }
                    break;

                case TOKEN_ESPECIAL:
                    // continuar  construyendo el token especial sin agregar partes intermedias
                    while (i < entrada.length()) {
                        char c = entrada.charAt(i);
                        lexemaActual.append(c);
                        
                        if (c == '\n') {
                            fila++;
                            columna = 0;
                        }else{
                            columna++;
                        }
                        if (c == ')') {
                            columna++;
                            if (i < entrada.length() && entrada.charAt(i) == ';') {
                                lexemaActual.append(';');
                                columna++;
                            }
                            break;
                        }
                        i++;
                    }
                    // aca se crea el objeto de tipo lexema y se añade a la lista
                    lexemas.add(new Lexema(lexemaActual.toString(), fila, inicioColumnaLexema));
                    lexemaActual.setLength(0);
                    estadoActual = Estado.INICIO;
                    break;

                case FINAL:
                    // frena ya que esta en estado de aceptacion
                    break;
            }

            columna++;
        }

        // Añadir el último lexema si existe
        if (lexemaActual.length() > 0) {
            lexemas.add(new Lexema(lexemaActual.toString(), fila, inicioColumnaLexema));
        }

        return lexemas;
    }
    private boolean esEspacioEnBlanco(char caracter) {
    // se obtiene si: es  verdadero o si el carácter es un espacio en blanco, salto linea, espacio tabular o seccion pagina
    return caracter == ' ' || caracter == '\t' || caracter == '\n' || caracter == '\r' || caracter == '\f';
}
    
    private boolean esInicioDeTokenEspecial(String lexema, char siguienteCaracter) {
            String subcadena = "Square.Color";
            int longitudLexema = lexema.length();
            int longitudSubcadena = subcadena.length();

            //  verificcion d eprimera linea para ver que ambos coincidad con el tamaño 
            if (longitudLexema < longitudSubcadena) {
                return false;
            }

            // se compara cada dato con el de la cadena
            for (int i = 0; i < longitudSubcadena; i++) {
                if (lexema.charAt(longitudLexema - longitudSubcadena + i) != subcadena.charAt(i)) {
                    return false; 
                }
            }

            // enviar respuesta booleana
            return siguienteCaracter == '(';
}

}
