/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.Automatas;

/**
 *
 * @author kevin-mushin
 */
public class AutomataOperador{

    public enum Estado {
        INICIO, OPERADOR_SIMPLE, OPERADOR_DOBLE, ERROR
    }   
    private Estado estado;

    public AutomataOperador() {
        this.estado = Estado.INICIO;
    }

    public boolean esOperador(String lexema) {
        estado = Estado.INICIO;

        for (char c : lexema.toCharArray()) {
            switch (estado) {
                case INICIO:
                    if (c == '+' || c == '-' || c == '*' || c == '/' || c == '!' || c == '=') {
                        estado = Estado.OPERADOR_SIMPLE;
                    } else if (c == '&' || c == '|') {
                        estado = Estado.OPERADOR_DOBLE;
                    } else {
                        estado = Estado.ERROR;
                    }
                    break;

                case OPERADOR_SIMPLE:
                    // Si es un operador simple, el autómata debería terminar aquí.
                    // Pero para operadores dobles como "==" o "!=" lo dejamos pasar.
                    if (c == '=' && (lexema.equals("==") || lexema.equals("!="))) {
                        estado = Estado.OPERADOR_SIMPLE; // Acepta operadores dobles de comparación
                    } else {
                        estado = Estado.ERROR;
                    }
                    break;

                case OPERADOR_DOBLE:
                    // Verificamos si se completa un operador doble como "&&" o "||"
                    if (c == '&' || c == '|') {
                        estado = Estado.OPERADOR_SIMPLE; // Acepta operadores dobles lógicos
                    } else {
                        estado = Estado.ERROR;
                    }
                    break;

                case ERROR:
                    return false; // Si en algún punto se llega al estado de error, no es un operador válido
            }
        }

        return estado == Estado.OPERADOR_SIMPLE; // Un operador válido termina en OPERADOR_SIMPLE
    }
}

