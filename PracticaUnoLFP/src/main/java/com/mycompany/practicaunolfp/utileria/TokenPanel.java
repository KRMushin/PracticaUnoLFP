/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author kevin-mushin
 */
public class TokenPanel extends JPanel{
    
    private int posicionX;
    private int posicionY;
    private Token token;
    private String color;
    private boolean panelVacio;
    
    private String trazasProduccion;

    
    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public Token getToken() {
        return token;
    }

    public boolean isPanelVacio() {
        return panelVacio;
    }
    
    public void setPanelVacio(boolean panelVacio) {
        this.panelVacio = panelVacio;
    }   

    public TokenPanel(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.panelVacio = true;
        inicializarEvento();
        
    }
    public void asignarToken(Token token){
        this.token = token;
        cambiarColor(token.getColor());
    
    }
    private void cambiarColor(String color){
        try {
              Color nuevoColor = Color.decode(color);
              this.setBackground(nuevoColor);
        } catch (NumberFormatException e) {
            System.out.println("COLOR INVALIDO " + color);
        }
    }
    private void inicializarEvento(){
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                GenerarImagenAutomata generar = new GenerarImagenAutomata(token, TokenPanel.this);
            }         
        });
        
    
    }
}


/*
      public void generarDotFile(Token token) {
    dotFileContent.setLength(0);
    dotFileContent.append("digraph G {\n");
    dotFileContent.append("rankdir=LR;\n");  // Direccionar el gráfico de izquierda a derecha
    dotFileContent.append("node [shape = circle];\n");

    String lexema = token.getLexema();
    
        System.out.println("                DEPURACION "  + lexema);
        System.out.println("dep " + token.getColor());
        System.out.println("");
// Generar nodos y conexiones
    for (int i = 0; i < lexema.length(); i++) {
        char caracter = lexema.charAt(i);
        String nodeName = "node" + i;
        System.out.println(caracter);
        if (i == lexema.length() - 1) {
            // El último nodo con doble círculo
            dotFileContent.append(nodeName + " [label=\"" + caracter + "\", shape=doublecircle];\n");
        } else {
            // Nodos intermedios
            dotFileContent.append(nodeName + " [label=\"" + caracter + "\"];\n");
        }
        
        // Conectar los nodos
        if (i > 0) {
            String prevNodeName = "node" + (i - 1);
            dotFileContent.append(prevNodeName + " -> " + nodeName + ";\n");
        }
    }
    
    dotFileContent.append("}");

    try {
        FileWriter fileWriter = new FileWriter("automata_" + token.getTipoToken() + token.getTipoToken() + ".dot");
        fileWriter.write(dotFileContent.toString());
        System.out.println(dotFileContent.toString());
        fileWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public void mostrarAutomata(String tipoToken) {
    JFrame frame = new JFrame("Autómata para token: " + tipoToken);
    frame.setSize(700, 400);

    JLabel label = new JLabel(new ImageIcon("automata_" + tipoToken + ".png"));
    frame.add(label);

    frame.setVisible(true);
}
    
    public void generarImagenAutomata(String tipoToken) {
    try {
        ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", "automata_" + tipoToken + ".dot", "-o", "automata_" + tipoToken + ".png");
        pb.start().waitFor();
    } catch (IOException | InterruptedException e) {
        System.out.println("error en generacionImagenautomata");
    }
}


*/