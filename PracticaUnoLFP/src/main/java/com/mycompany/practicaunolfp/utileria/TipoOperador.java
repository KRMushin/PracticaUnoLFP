/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

/**
 *
 * @author kevin-mushin
 */
public enum TipoOperador {

    OPERADOR_ARITMETICO {
        @Override
        public String obtenerColor(String lexema) {
            switch (lexema) {
               case "+":
                return "#FF33FF";
            case "-":
                return "#C19A6B";
            case "^":
                return "#FCD0B4";
            case "/":
                return "#B4D941";
            case "Mod":
            return "#D9AB41";   
            case "*":
                return "#D80073";
            default:
                 return "FFFFFF";         
            }
        }
    },
    OPERADOR_LOGICO {
        @Override
        public String obtenerColor(String lexema) {
            switch (lexema) {
                case "And":
                return "#414ED9";
                case "Or":
                return "#41D95D";
                 case "Not":
                return "#A741D9";
                default:
                    return "#000000"; // Negro por defecto
            }
        }
    },
    OPERADOR_RELACIONAL_COMPARACION {
        @Override
        public String obtenerColor(String lexema) {
            switch (lexema) {
                    case "==":
                    return "#6A00FF";
                case "<>":
                    return "#3F2212";
                case ">":
                    return "#D9D441";
                case "<":
                return "#D94A41";

                 case ">=":
                    return "#E3C800";
                case "<=":
                return "#F0A30A";
                default:
                    return "#000000"; // Negro por defecto
            }
        }
    },
    OPERADOR_ASIGNACION {
        @Override
        public String obtenerColor(String lexema) {
            switch (lexema) {
                case "=":
                    return "#41D9D4"; 
                default:
                    return "#FFFFFF"; 
            }
        }
    },
    IDENTIFICADOR{
        @Override
        public String obtenerColor(String lexema) {
            return "#FFD300";
        }
    
    },
    PALABRA_RESERVADA{
        @Override
        public String obtenerColor(String lexema) {
            return "#60A917";
        }
    
    };
    

    // Método abstracto a implementar en cada tipo de operador
    public abstract String obtenerColor(String lexema);
}
