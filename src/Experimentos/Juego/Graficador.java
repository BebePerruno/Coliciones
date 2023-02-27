/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import jdk.internal.vm.annotation.IntrinsicCandidate;

/**
 *
 * @author Rafael
 */
public class Graficador {
    
    
    /**
     * Debe llenar esos parametros.
     * @param nuevoX
     * @param nuevoY
     * @param nuevoWidth
     * @param nuevoHeight
     * @param form_para_dibujar 
     * @param nuevo_nombre_de_la_imagen 
     */
    public Graficador(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JFrame form_para_dibujar,String nuevo_nombre_de_la_imagen){
        this.x=nuevoX;
        y=nuevoY;
        this.width=nuevoWidth;
        this.height=nuevoHeight;
        this.Superficie_para_dibujar=form_para_dibujar;
        nombreDeLaImagen=nuevo_nombre_de_la_imagen;
    }
    /**
     * Para rectangulos o territorios
     * @param nuevoX
     * @param nuevoY
     * @param nuevoWidth
     * @param nuevoHeight
     * @param form_para_dibujar 
     */
    public Graficador(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JPanel form_para_dibujar){
        this.x=nuevoX;
        y=nuevoY;
        this.width=nuevoWidth;
        this.height=nuevoHeight;
        this.panel=form_para_dibujar;
    }
    
    public Graficador(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight){
        this.x=nuevoX;
        y=nuevoY;
        this.width=nuevoWidth;
        this.height=nuevoHeight;
    }
    
    /**
     * Debe llenar esos parametros.
     * @param nuevoX
     * @param nuevoY
     * @param nuevoWidth
     * @param nuevoHeight
     * @param form_para_dibujar 
     */
    public Graficador(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JPanel form_para_dibujar,String nuevo_nombre_de_la_imagen){
        this.x=nuevoX;
        y=nuevoY;
        this.width=nuevoWidth;
        this.height=nuevoHeight;
        this.panel=form_para_dibujar;
        this.nombreDeLaImagen=nuevo_nombre_de_la_imagen;
    }
    
    public int[] pixeles;
    protected JFrame Superficie_para_dibujar = null;
    protected String nombreDeLaImagen = "";
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    public Color color;
    protected JPanel panel = null;
    
    public void setPanelDeDibujo(JPanel nuevo_lienzo){
        panel=nuevo_lienzo;
    }
    
    /**
     * Direccion con nombre de la imagen, con la extencion de archivo.
     * Ejemplo: /coliciones/agregar.png
     * @param nuevo_nombre 
     */
    public void setNombreDeLaImagen(String nuevo_nombre){
        nombreDeLaImagen=nuevo_nombre;
    }
    
    public String getNombreDeLaImagen(){
        return this.nombreDeLaImagen;
    }

    public void draw(Graphics g) {
        //        super.paintComponent(g);//Esta era la palabra.
        BufferedImage f = null;
        try {
            f = ImageIO.read(Graficador.class.getResourceAsStream(getNombreDeLaImagen()));
        } catch (Exception ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Superficie_para_dibujar != null) {
            g.drawImage(f, x, y, this.width, height, Superficie_para_dibujar);
        } else {
            g.drawImage(f, x, y, this.width, this.height, this.panel);
        }
        //            f.getRGB(0, 0, 30, 20, pixeles, 1, 100);
        //        this.con_foto=true;
        //        if(x>=20){
        //            //Dibujar otra imagen.
        //        }
        //        original x*=4;
        //        setX(getX());//50*4;
        //
        //        setY(getY());
        //            g.drawImage(f, getX(), getY(),this);
        //Asi cuando todo el algoritmo de dibujado se realiza dentro del form.
        //        if(aliado.intersects(enemigo)==true){
        //            System.out.println( "Colicion");
        //        }
    }

    public void setX(int nuevoX) {
        x = nuevoX;
    }

    public int getX() {
        return x;
    }

    public void setY(int nuevoY) {
        y = nuevoY;
    }

    public int getY() {
        return y;
    }

    public void setWidth(int nuevoWidth) {
        this.width = nuevoWidth;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int nuevoheight) {
        height = nuevoheight;
    }

    public int getHeight() {
        return height;
    }

    public void setForm(JFrame nuevo_lienzo) {
        Superficie_para_dibujar = nuevo_lienzo;
    }
    
}
