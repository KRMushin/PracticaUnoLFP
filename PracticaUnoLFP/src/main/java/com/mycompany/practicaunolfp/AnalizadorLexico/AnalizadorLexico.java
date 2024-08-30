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
import com.mycompany.practicaunolfp.Automatas.SignoSimbolo;
import com.mycompany.practicaunolfp.Automatas.SquareColorEspecial;
import com.mycompany.practicaunolfp.Automatas.SquareColorSimple;
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
   private SignoSimbolo signoSimbolo;
   private SquareColorSimple squareSimple;
   private SquareColorEspecial squareEspecial;


   

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
       this.signoSimbolo = new SignoSimbolo();
       this.squareSimple = new SquareColorSimple();
       this.squareEspecial = new SquareColorEspecial();
    }  
    
    
        /*
           metodo para separar toda la linea de caracteres en lexemas para su posterior analisis
           este metodo retorna una lista de cadenas ( lexemas )
        */
    
    
  public List<Token> obtenerLexemas(String entrada) {
      System.out.println(entrada);
      List<Token> tokens = new ArrayList<>();
      List<Lexema> lexemas = tokenizador.obtenerLexemas(entrada);
      System.out.println(lexemas.size() + "tamaño lex");
      
      for (int i = 0; i < lexemas.size(); i++) {
            Lexema lexema = lexemas.get(i);
            String lexemaValor = lexema.getValor();
            
           if (esOperadorLogico(lexemaValor)) {
              String color = TipoOperador.OPERADOR_LOGICO.obtenerColor(lexemaValor);
                tokens.add(new Token(lexema,color,"Operador Logico"));
                
           } else if (esDatoBooleano(lexemaValor)) {
              String color = TipoOperador.DATO_BOOLEANO.obtenerColor(lexemaValor);
              tokens.add(new Token(lexema,color,"Dato Booleano" ));
              
           }else if (esSquareSimple(lexemaValor)) {
              String color = squareSimple.getColor();
              tokens.add(new Token(lexema,color," Square Simple"));
              
          } else if (esSquareEspecial(lexemaValor)) {
                String color = squareEspecial.getColor();
                String numeroFilas = squareEspecial.getNumeroFilas();
                String numeroColumnas = squareEspecial.getNumeroColumnas();
                tokens.add(new TokenEspecial(lexema,color, "square Especial",numeroFilas,numeroColumnas));
          }
           else if (esPalabraReservada(lexemaValor)) {
                
                String color = TipoOperador.PALABRA_RESERVADA.obtenerColor(lexemaValor);
                tokens.add(new Token(lexema,color,"PalabraReservada"));
                
            }else if (esDatoEntero(lexemaValor)) {
              String color = TipoOperador.DATO_ENTERO.obtenerColor(lexemaValor);
              tokens.add(new Token(lexema,color," Token Entero"));
          }  
           else if (esOperadorAritmetico(lexemaValor)) {

                String color = TipoOperador.OPERADOR_ARITMETICO.obtenerColor(lexemaValor);
                tokens.add(new Token(lexema,color,"Operador Aritmetico"));
              
          } 
           else if (esIdentificador(lexemaValor)) {
               
                String color = TipoOperador.IDENTIFICADOR.obtenerColor(lexemaValor);
                 tokens.add(new Token(lexema,color,"Identificador" ));
                 
            } else if (esSignoSimbolo(lexemaValor)) {
              String color = TipoOperador.SIGNO_SIMBOLO.obtenerColor(lexemaValor);
                 tokens.add(new Token(lexema,color," Signo Simbolo"));
           }else if (esOperadorAsignacion(lexemaValor)) {
              
              String color = TipoOperador.OPERADOR_ASIGNACION.obtenerColor(lexemaValor);
                tokens.add(new Token(lexema,color,"Operador Asignacion"));
              
          }else if (esOperadorRelacionComparacion(lexemaValor)) {
              
              String color = TipoOperador.OPERADOR_RELACIONAL_COMPARACION.obtenerColor(lexemaValor);
                tokens.add(new Token(lexema,color,"Operados relacion comparacion"));
                
          }else if (esDatoCadena(lexemaValor)) {
              String color = TipoOperador.DATO_CADENA.obtenerColor(lexemaValor);
              tokens.add(new Token(lexema,color," Dato Cadena"));
          }else if (esDatoDecimal(lexemaValor)) {
              String color = TipoOperador.DATO_DECIMAL.obtenerColor(lexemaValor);
              tokens.add(new Token(lexema,color," Token Decimal "));
              
          }
          else if (esDatoCaracter(lexemaValor)) {
              String color = TipoOperador.DATO_CARACTER.obtenerColor(lexemaValor);
              tokens.add(new Token(lexema,color," Dato Caracter"));
          }
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

    private boolean esDatoCaracter(String caracter) {
        return datosCaracter.esCaracterValido(caracter);
    }

    private boolean esDatoDecimal(String lexema) {
        return datosDecimales.esDecimalValido(lexema);
    }

    private boolean esDatoEntero(String lexema) {
        return datosEnteros.esEntero(lexema);
    }
    private boolean esSignoSimbolo(String lexema){
        return signoSimbolo.esSignoSimbolo(lexema);
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
    private boolean esSquareSimple(String lexema){
        return squareSimple.esSquareSimple(lexema);
    }
    private boolean esSquareEspecial(String lexema){
        return squareEspecial.esSquareEspecial(lexema);
    }
    
}