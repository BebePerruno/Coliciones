/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exagonal;

import java.awt.Rectangle;

/**
 *
 * @author Jugador
 */
public class Rectangulo{
    
    private Punto vArista1Alto, vArista2Alto, vArista3Largo,  vArista4Largo;
    
    public int getX(){
        return vArista1Alto.xInicial;
    }
    
    public int getY(){
        return vArista1Alto.yInicial;
    }
    
    public Rectangulo(Punto arista1Alto, Punto arista2Alto, Punto arista3Largo, Punto arista4Largo){
        vArista1Alto=arista1Alto; vArista2Alto=arista2Alto; vArista3Largo=arista3Largo; vArista4Largo=arista4Largo;
    }
//    
//    public Rectangle getRectangulo(){
//        return new Rectangle(vArista1Alto.xInicial, vArista3Largo.yInicial,this.getAlto(), this.getLargo());
//    }
    
    public boolean Colicion(Rectangulo nuevoPunto){
        
        int x=vArista1Alto.xInicial;
        int y=vArista1Alto.yInicial;
        
        
        int tw = this.getLargo();
        int th = this.getAlto();
        int rw = nuevoPunto.getLargo();
        int rh =nuevoPunto.getAlto();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.getX();
        int ty = this.getY();
        int rx = nuevoPunto.getX();
        int ry = nuevoPunto.getY();
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
        
//        return intersects(nuevoPunto.getRectangulo());
    }
    
    public int getLargo(){
        int w=0;
        if(vArista3Largo.yInicial>vArista3Largo.yFinal){
            w=vArista3Largo.yFinal-vArista3Largo.yInicial;
        }else{
            w=vArista3Largo.yInicial-vArista3Largo.yFinal;
        }
        return w;
    }
    
    public int getAlto(){
        int w=0;
        if(vArista1Alto.xInicial>vArista1Alto.xFinal){
            w=vArista1Alto.xFinal-vArista1Alto.xInicial;
        }else{
            w=vArista1Alto.xInicial-vArista1Alto.xFinal;
        }
        return w;
    }
}
