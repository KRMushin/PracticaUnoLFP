/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.AnalizadorLexico;

import com.mycompany.practicaunolfp.Automatas.DatosBooleano;
import com.mycompany.practicaunolfp.Automatas.DatosCadena;
import com.mycompany.practicaunolfp.Automatas.DatosCaracter;
import com.mycompany.practicaunolfp.Automatas.DatosDecimales;
import com.mycompany.practicaunolfp.Automatas.DatosEnteros;
import com.mycompany.practicaunolfp.Automatas.Identificador;
import com.mycompany.practicaunolfp.Automatas.OperadorAritmetico;
import com.mycompany.practicaunolfp.Automatas.OperadorAsignacion;
import com.mycompany.practicaunolfp.Automatas.OperadorLogico;
import com.mycompany.practicaunolfp.Automatas.OperadorRelacionComparacion;
import com.mycompany.practicaunolfp.Automatas.PalabrasReservadas;
import com.mycompany.practicaunolfp.utileria.TipoOperador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin-mushin
 */
public class AnalizadorLexico {
    
    
   private String entrada;
   private Tokenizador tokenizador;
   
   private DatosBooleano datosBooleano;
   private DatosCadena datosCadena;
   private DatosCaracter datosCaracter;
   private DatosDecimales datosDecimales;
   private DatosEnteros datosEnteros;
   private Identificador identificador;
   private OperadorAritmetico operadorAritmetico;
   private OperadorAsignacion operadorAsignacion;
   private OperadorLogico operadorLogico;
   private OperadorRelacionComparacion operadorRelacionComparacion;
   private PalabrasReservadas palabrasReservadas;


   

    public AnalizadorLexico(String entrada) {
        this.entrada = entrada;
        this.tokenizador = new Tokenizador();
        
        /* instancias de los automatas*/
        this.datosBooleano = new DatosBooleano();
       this.datosCadena = new DatosCadena();
       this.datosCaracter = new DatosCaracter();
       this.datosDecimales = new DatosDecimales();
       this.datosEnteros = new DatosEnteros();
       this.identificador = new Identificador();
       this.operadorAritmetico = new OperadorAritmetico();
       this.operadorAsignacion = new OperadorAsignacion();
       this.operadorLogico = new OperadorLogico();
       this.operadorRelacionComparacion = new OperadorRelacionComparacion();
       this.palabrasReservadas = new PalabrasReservadas();
    }  
    
    
        /*
           metodo para separar toda la linea de caracteres en lexemas para su posterior analisis
           este metodo retorna una lista de cadenas ( lexemas )
        */
  public List<Token> obtenerLexemas(String entrada) {
      /* lista con los tokens que se deb¡volverar*/
      System.out.println(entrada);
      List<Token> tokens = new ArrayList<>();
      /* obtener los lexemas del tokenizador*/
      List<String> lexemas = tokenizador.obtenerLexemas(entrada);
      /* ciclo for que evaluara cada lexema*/
      System.out.println(lexemas.size() + "tamaño lex");
      for (int i = 0; i < lexemas.size(); i++) {
            String lexema = lexemas.get(i);
            if (esIdentificador(lexema)) {
                 String color = TipoOperador.IDENTIFICADOR.obtenerColor(lexema);
                 tokens.add(new Token(lexema,color,"Identificador"));
            }else if (esPalabraReservada(lexema)) {
                String color = TipoOperador.PALABRA_RESERVADA.obtenerColor(lexema);
                tokens.add(new Token(lexema,color,"PalabraReservada"));
            } 
            else if (esOperadorAritmetico(lexema)) {
                String color = TipoOperador.OPERADOR_ARITMETICO.obtenerColor(lexema);
                System.out.println(color);
                tokens.add(new Token(lexema,color,"Operador Aritmetico"));
              
          }else if (esOperadorLogico(lexema)) {
              String color = TipoOperador.OPERADOR_LOGICO.obtenerColor(lexema);
                tokens.add(new Token(lexema,color,"Operador Logico"));
              
          }else if (esOperadorAsignacion(lexema)) {
              String color = TipoOperador.OPERADOR_ASIGNACION.obtenerColor(lexema);
                tokens.add(new Token(lexema,color,"Operador Asignacion"));
              
          }else if (esOperadorRelacionComparacion(lexema)) {
              String color = TipoOperador.OPERADOR_RELACIONAL_COMPARACION.obtenerColor(lexema);
                tokens.add(new Token(lexema,color,"Operados relacion comparacion"));
              
          }else if (esDatoBooleano(lexema)) {
              
          }else if (esDatoCadena(lexema)) {
              
          }else if (esDatoCaracter(lexema.charAt(0))) {
              
          }else if (esDatoDecimal(lexema)) {
              
          }else if (esDatoEntero(lexema)) {
              
          }      
            reiniciarAutomatas();
      }
      
    return tokens;
   }
    /* metodos booleanos para evaluar lexemas*/
    private boolean esIdentificador(String lexema) {
        return identificador.esIdentificador(lexema);
    }

    private boolean esDatoBooleano(String lexema) {
        return datosBooleano.esBooleanoValido(lexema);
    }

    private boolean esDatoCadena(String lexema) {
        return datosCadena.esCadenaValida(lexema);
    }

    private boolean esDatoCaracter(char caracter) {
        return datosCaracter.esCaracterValido(caracter);
    }

    private boolean esDatoDecimal(String lexema) {
        return datosDecimales.esDecimalValido(lexema);
    }

    private boolean esDatoEntero(String lexema) {
        return datosEnteros.esEntero(lexema);
    }

    private boolean esOperadorAritmetico(String lexema) {
        return operadorAritmetico.esOperadorAritmetico(lexema);
    }

    private boolean esOperadorAsignacion(String lexema) {
        return operadorAsignacion.esOperadorAsignacion(lexema);
    }

    private boolean esOperadorLogico(String lexema) {
        return operadorLogico.esOperadorLogico(lexema);
    }

    private boolean esOperadorRelacionComparacion(String lexema) {
        return operadorRelacionComparacion.esOperadorRelacionalComparacion(lexema);
    }

    private boolean esPalabraReservada(String lexema) {
        return palabrasReservadas.esPalabraReservada(lexema);
    }
    private void reiniciarAutomatas(){
        operadorAritmetico.reiniciar();
    
    }
}











 /* public List<String> obtenerLexemas(String entrada) {
    List<String> lexemas = new ArrayList<>();
    StringBuilder lexemaActual = new StringBuilder();

    for (int i = 0; i < entrada.length(); i++) {
        char caracter = entrada.charAt(i);

        if (Character.isWhitespace(caracter)) {
            if (lexemaActual.length() > 0) {
                lexemas.add(lexemaActual.toString());
                lexemaActual.setLength(0);
            }
        } else if (esInicioDeMetodo(lexemaActual.toString(), caracter)) {
            // Si detectamos que estamos iniciando una expresión como Square.Color(
            lexemaActual.append(caracter);
            i++; // avanzar para entrar al contenido del método
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
        } else {
            lexemaActual.append(caracter);
        }
    }

    if (lexemaActual.length() > 0) {
        lexemas.add(lexemaActual.toString());
    }

    return lexemas;
}*/






