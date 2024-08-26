/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

import com.mycompany.practicaunolfp.AnalizadorLexico.Token;

/**
 *
 * @author kevin-mushin
 */
public class GenerarImagenAutomata {
    
    private Token token;
    private TokenPanel panelToken;

    public GenerarImagenAutomata(Token token, TokenPanel panelToken) {
        this.token = token;
        this.panelToken = panelToken;
    }
    private void generarImagen(){}
    private void mostrarImagen(){}
    
    
}
/*
                import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class TokenPanel extends JPanel {

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

    public void asignarToken(Token token) {
        this.token = token;
        cambiarColor(token.getColor());
    }

    private void cambiarColor(String color) {
        try {
            Color nuevoColor = Color.decode(color);
            this.setBackground(nuevoColor);
        } catch (NumberFormatException e) {
            System.out.println("COLOR INVALIDO " + color);
        }
    }

    private void inicializarEvento() {
        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("Panel clickeado en la posición: (" + (posicionX + 1) + ", " + (posicionY + 1) + ")");
                System.out.print(token.getTrazaProduccion());
                mostrarGraficoEnMemoria(token);
            }
        });
    }

    public void mostrarGraficoEnMemoria(Token token) {
        String lexema = token.getLexema();
        StringBuilder dotFileContent = new StringBuilder();
        dotFileContent.append("digraph G {\n");
        dotFileContent.append("rankdir=LR;\n");
        dotFileContent.append("node [shape = circle];\n");

        // Generar nodos y conexiones
        for (int i = 0; i < lexema.length(); i++) {
            char caracter = lexema.charAt(i);
            String nodeName = "node" + i;

            if (i == lexema.length() - 1) {
                dotFileContent.append(nodeName + " [label=\"" + caracter + "\", shape=doublecircle];\n");
            } else {
                dotFileContent.append(nodeName + " [label=\"" + caracter + "\"];\n");
            }

            if (i > 0) {
                String prevNodeName = "node" + (i - 1);
                dotFileContent.append(prevNodeName + " -> " + nodeName + ";\n");
            }
        }

        dotFileContent.append("}");

        try {
            // Crear el proceso para Graphviz
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng");
            Process process = pb.start();

            // Escribir el contenido del dotFileContent directamente en la entrada del proceso
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(dotFileContent.toString());
            writer.flush();
            writer.close();

            // Leer la salida del proceso y convertirla en una imagen
            InputStream inputStream = process.getInputStream();
            BufferedImage image = ImageIO.read(inputStream);

            // Mostrar la imagen en un JFrame
            JFrame frame = new JFrame("Autómata para token: " + token.getTipoToken());
            frame.setSize(700, 400);

            JLabel label = new JLabel(new ImageIcon(image));
            frame.add(label);

            frame.setVisible(true);

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al generar la imagen del autómata en memoria: " + e.getMessage());
        }
    }
}


*/