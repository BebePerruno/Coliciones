/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exagonal;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Permite generar los eventos Click y DobleClick.
 * Solo para controles que usen MouseEvent y ActionListener
 * @author Jugador
 */
public abstract class AbstractDoubleClick extends MouseAdapter implements ActionListener, MouseMotionListener{
   public abstract void eveClick(int x, int y, Point puntoXY);
   public abstract void eveDobleClick(int x, int y, Point puntoXY);
    private int mouseClick=1;
    
    public abstract void mouseMoviendose();
    public abstract void mouseArrastrastrado();
   @Override
    public void mouseDragged(MouseEvent e){
        System.out.println("Moviendose");
        mouseArrastrastrado();
    }
    
   @Override
    public void mouseMoved(MouseEvent e){
        mouseMoviendose();
    }
    
   @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        eveClick(evt.getX(),evt.getY(), evt.getPoint());
//        if(mouseClick==1){
////            eveClick(evt.getX(),evt.getY(), evt.getPoint());
//        }
        if(mouseClick==2){
            eveDobleClick(evt.getX(),evt.getY(), evt.getPoint());
        }
        mouseClick++;
        if(mouseClick>=3){
            mouseClick=1;
        }
    }
    
    public abstract void mousePressed();
   @Override
    public void mousePressed(java.awt.event.MouseEvent evt) {
        mousePressed();
    }
    
   @Override
    public void actionPerformed(java.awt.event.ActionEvent evt){
        if(mouseClick==1){
            eveClick(0,0, new Point());
        }
        if(mouseClick==2){
            eveDobleClick(0,0,new Point());
        }
        mouseClick++;
        if(mouseClick>=3){
            mouseClick=1;
        }
    }
    
}