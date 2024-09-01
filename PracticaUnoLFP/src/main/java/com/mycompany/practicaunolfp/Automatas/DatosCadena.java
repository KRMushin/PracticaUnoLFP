/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class DatosCadena {
    /*
Q = {
             S0 ----> " S1
             S1 ----> [letras, números] S1
             S1 ----> " S2
       }
S = { S0 }
*/
    public enum Produccion {
        S0, S1, S2 , ERROR;
    }

    private Produccion estadoActual;

    public DatosCadena() {
        this.estadoActual = Produccion.S0;
    }
    public void reiniciar() {
        this.estadoActual = Produccion.S0;
    }

    public boolean esCadenaValida(String lexema) {
                reiniciar();

                for (int i = 0; i < lexema.length(); i++) {
                    char caracter = lexema.charAt(i);

                    switch (estadoActual) {
                        case S0:
                            if (caracter == '"') {
                                // si encuentra una comilla se va al estado S1 ya que puede ser una cadena
                                estadoActual = Produccion.S1;
                            } else {
                                estadoActual = Produccion.ERROR;
                            }
                            break;

                        case S1:
                            if (esLetra(caracter) || esDigito(caracter)) {
                                // permanece en S1 si es letra o número
                                estadoActual = Produccion.S1; 
                            } else if (caracter == '"') {
                                estadoActual = Produccion.S2; 
                            } else {
                                estadoActual = Produccion.ERROR;
                            }
                            break;

                        default:
                            estadoActual = Produccion.ERROR;
                            break;
                    }

                    if (estadoActual == Produccion.ERROR) {
                        //salida si el estado de actual no es aceptador
                        break;
                    }
                }

                // estadi de aceptacion S2
                return estadoActual == Produccion.S2;
            }

            private boolean esLetra(char caracter) {
                return (caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z');
            }

            private boolean esDigito(char caracter) {
                return caracter >= '0' && caracter <= '9';
            }

}
