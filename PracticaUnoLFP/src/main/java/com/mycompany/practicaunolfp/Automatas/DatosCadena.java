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
    /*GRAMATICA
N = { S0 , S1, S2 }
T = {A-Z, a-z , 0-9, " }
P = {
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
                                estadoActual = Produccion.S1; // Encuentra la primera comilla doble
                            } else {
                                estadoActual = Produccion.ERROR;
                            }
                            break;

                        case S1:
                            if (esLetra(caracter) || esDigito(caracter)) {
                                estadoActual = Produccion.S1; // Permanece en S1 si es letra o número
                            } else if (caracter == '"') {
                                estadoActual = Produccion.S2; // Encuentra la segunda comilla doble
                            } else {
                                estadoActual = Produccion.ERROR;
                            }
                            break;

                        default:
                            estadoActual = Produccion.ERROR;
                            break;
                    }

                    if (estadoActual == Produccion.ERROR) {
                        break; // Salida en caso de error
                    }
                }

                // La cadena es válida si terminamos en el estado S2
                return estadoActual == Produccion.S2;
            }

            private boolean esLetra(char caracter) {
                return (caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z');
            }

            private boolean esDigito(char caracter) {
                return caracter >= '0' && caracter <= '9';
            }

}
