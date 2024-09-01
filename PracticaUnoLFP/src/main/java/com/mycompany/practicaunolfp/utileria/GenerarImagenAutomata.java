/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaunolfp.utileria;

import com.mycompany.practicaunolfp.AnalizadorLexico.Token;
import com.mycompany.practicaunolfp.Vista.VistaAutomata;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author kevin-mushin
 */
public class GenerarImagenAutomata {
    
    private Token token;
    private TokenPanel panelToken;
    private VistaAutomata frameAutomata;
    private BufferedImage imagenAutomata;

    public BufferedImage getImagenAutomata() {
        return imagenAutomata;
    }

    public Token getToken() {
        return token;
    }

    public GenerarImagenAutomata(Token token, TokenPanel panelToken) {
        this.token = token;
        this.panelToken = panelToken;
        this.frameAutomata = new VistaAutomata(this);
        generarImagen(token.getLexema().getValor());
        mostrarCaracteristicas(frameAutomata,token,panelToken);
    }

    private void generarImagen(String lex){
        
        StringBuilder graphConstructor = new StringBuilder();
        String lexema = lex.replace("\"", "'");
        System.out.println(lexema);
        graphConstructor.append("digraph G {\n");
        graphConstructor.append("rankdir=LR;\n");
        graphConstructor.append("node [shape = circle];\n");
        /* porc cada lexema asigna un circle en */
          for (int i = 0; i < lexema.length(); i++) {
               char caracter = lexema.charAt(i);
               String nodo = "node" + i;
               
                    if (i == lexema.length() - 1) {
                        graphConstructor.append(nodo + " [label=\"" + caracter + "\", shape=doublecircle];\n");
                    } else {
                        graphConstructor.append(nodo + " [label=\"" + caracter + "\"];\n");
                    }

                    if (i > 0) {
                        String nodoPrevio = "node" + (i - 1);
                        graphConstructor.append(nodoPrevio + " -> " + nodo + ";\n");
                    }
          }
        graphConstructor.append("}");
        
        crearConexionGraphViz(graphConstructor.toString());
    }
    private void crearConexionGraphViz(String graphConstructor){
    
        try {
            // proceso de graph viz
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng");
            Process process = pb.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(graphConstructor);
            writer.flush();
            writer.close();

            // salida del proceso y convertirla en una imagen
            InputStream inputStream = process.getInputStream();
           imagenAutomata = ImageIO.read(inputStream);
            
            
            frameAutomata.getAutomata().setIcon(new ImageIcon(imagenAutomata));
            frameAutomata.setVisible(true);
            process.waitFor();
            
        } catch (IOException | InterruptedException e) {
        }
    }

    private void mostrarCaracteristicas(VistaAutomata frameAutomata, Token token , TokenPanel tokenPanel) {
        try {
            String filaTexto = Integer.toString(token.getLexema().getFila());
            String ColTexto = Integer.toString(token.getLexema().getColumna());
            String filaCuadro = Integer.toString(tokenPanel.getPosicionX() + 1);
            String colCuadro = Integer.toString(tokenPanel.getPosicionY() + 1);
            
            frameAutomata.getTipoToken().setText(token.getTipoToken());
            
            frameAutomata.getFilaTexto().setText(filaTexto);
            frameAutomata.getColumnaTexto().setText(ColTexto);
            
            frameAutomata.getFilaCuadro().setText(filaCuadro);
            frameAutomata.getColumnaCuadro().setText(colCuadro);
            
        } catch (Exception e) {
            System.out.println(" ERROR: " +e.getMessage());
        }  
    }
    
}
