/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.Juego;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public abstract class Orientador extends Graficador {
    
    public Orientador(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight){
        super(nuevoX,nuevoY,nuevoWidth,nuevoHeight);
    }
    
    /**
     * Son estaticas porque todas las unidades deben usar estos limites.
     */
    public static int LimiteSuperior = 0;
    public static int LimiteInferior;
    public static int LimiteIzquierdo = 0;
    public static int LimiteDerecho = 0;
    protected int velocidad = 10;

    public Orientador(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JFrame form_para_dibujar, String nuevo_nombre_de_la_imagen) {
        super(nuevoX, nuevoY, nuevoWidth, nuevoHeight, form_para_dibujar, nuevo_nombre_de_la_imagen);
    }

    public Orientador(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, JPanel form_para_dibujar, String nuevo_nombre_de_la_imagen) {
        super(nuevoX, nuevoY, nuevoWidth, nuevoHeight, form_para_dibujar, nuevo_nombre_de_la_imagen);
    }

    
    private int numeroTemp=0;
    
    public int numeroAleatorio(int Min, int Max) {
        if (Min == 0) {
            Min = -1;
        }
        int resultado = (int) (Math.random() * (Max - Min + 1) + Min);
        if (numeroTemp == resultado) {
            System.out.println("Mismo resultado que el anterior:" + resultado);
            numeroAleatorio(Min, Max);
        }
        numeroTemp = resultado;
        return resultado;
    }

    public void setVelocidad(int nuevaVelocidad) {
        velocidad = nuevaVelocidad;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public void moverArriba() {
        y -= velocidad;
        if (y <= LimiteSuperior) {
            y = LimiteSuperior;
        }
        moverme();
    }

    public void moverAbajo() {
        y += 10;
        if (y >= LimiteInferior) {
            y = LimiteInferior;
        }
        moverme();
    }

    public void moverDrecha() {
        x += velocidad;
        if (x >= LimiteDerecho) {
            x = LimiteDerecho;
        }
        moverme();
    }

    public void moverIzquierda() {
        x -= velocidad;
        if (x <= LimiteIzquierdo) {
            x = LimiteIzquierdo;
        }
        moverme();
    }
    
    /**
     * Solo para unidades que no usa el jugador.
     * 
     */
    public abstract void moverme();

    /**
     * Algoritmo perfecto para detectar intersecciones.
     * Basado en la clase Retangle.
     * @param nueva_unidad
     * @return
     */
    public boolean intersects(Orientador nueva_unidad) {
        int tw = this.width;
        int th = this.height;
        int rw = nueva_unidad.width;
        int rh = nueva_unidad.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = nueva_unidad.x;
        int ry = nueva_unidad.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        /**
         * Todas las condiciones tienen que ser true para que suceda una colicion.
         */
        return (rw < rx || rw > tx) && (rh < ry || rh > ty) && (tw < tx || tw > rx) && (th < ty || th > ry);
    }

    /**
     * Detecta el borde derecho del ambiente.
     * @param width_del_ambiente
     * @return
     */
    public boolean detectarBordeDerecho(int width_del_ambiente) {
        if (width_del_ambiente <= getX() + getWidth()) {
            //            System.out.println("Estoy en el borde derecho ." + (getX()+getWidth()));
            return true;
        }
        return false;
    }

    /**
     * Detecta el borde izquierdo del ambiente.
     * @param height_del_ambiente
     * @return
     */
    public boolean detectarBordeInferior(int height_del_ambiente) {
        if (height_del_ambiente <= getY() + this.getHeight()) {
            //            System.out.println("Estoy en el borde inferior ." + (getY()+getHeight()));
            return true;
        }
        return false;
    }

    public boolean detectarBordeIzquierdo() {
        if (this.getX() <= 0) {
            return true;
        }
        return false;
    }

    public boolean detectarBordeSuperior() {
        if (this.getY() <= 0) {
            return true;
        }
        return false;
    }
    
}
