/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exagonal;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jugador
 */
public class Lienzo extends Canvas {
    private ArrayList<Punto> p=null;
    public Lienzo(){
        super();
    }
    private Rectangulo r;
    public void Dibujar(ArrayList<Punto> nuevoRsPuntos){
        p=nuevoRsPuntos;
        try{
        r=new Rectangulo(nuevoRsPuntos.get(0), nuevoRsPuntos.get(1), nuevoRsPuntos.get(2), nuevoRsPuntos.get(3));}catch(Exception e){}
        repaint();
    }
    
    
    
    @Override
    public void paint(Graphics g){
        try{
            for(Punto i:p){
                g.drawLine(i.xInicial, i.yInicial, i.xFinal, i.yFinal);
               
            }
             g.drawRect(r.getX(), r.getY(), r.getLargo(), r.getAlto());
        }catch(Exception e){}
    }
    
}
