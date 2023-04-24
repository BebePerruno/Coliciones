/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coliciones;

/**
 *Para un pentagono exagono y asi como poligonos, es mejor dibujar varios rectangulos dentro de 
 * ellos y luego comprobar si uno de los rectangulos coliciona contra un objeto externo.
 * @author Jugador
 */
public class ColicionesDeFiguras {
    
    /**
     * Permite detectar la colicion de dos circulos.
     * @param cX1
     * @param cY1
     * @param cX2
     * @param cY2
     * @param radio1
     * @param radio2
     * @return 
     */
    public boolean detectarColicionDeCirculos(int cX1, int cY1, int cX2, int cY2, int radio1, int radio2){
        
        double distanciaDeLosCirculos=Math.sqrt((cX1-cX2)*(cX1-cX2)+(cY1-cY2)*(cY1-cY2));
        if(distanciaDeLosCirculos<(radio1+radio2)){
            return true;
        }
        return false;
    }
    
    /**
     * Detecta la colicion entre un circulo y un cuadrado.
     * @param cx
     * @param cy
     * @param radio
     * @param rectanguloX
     * @param rectanguloY
     * @param rectangulugoAncho
     * @param rectanguloAltura
     * @return 
     */
    public boolean detectarColicionEntreCirculo_y_cuadrado(int cx, int cy, int radio, int rectanguloX, int rectanguloY, int rectangulugoAncho , int rectanguloAltura){
        int px=cx;
        if(px<rectanguloX){
            px=rectanguloX;
        }
        if(px>(rectanguloX+rectangulugoAncho)){
            px=(rectanguloX+rectangulugoAncho);
        }
        int py=cy;
        if(py<rectanguloY){
            py=rectanguloY;
        }
        if(py>(rectanguloY+rectanguloAltura)){
            py=(rectanguloY+rectanguloAltura);
        }
        double distancia=Math.sqrt((cx-px)*(cx-px)+(cy-py)*(cy-py));
        if(distancia<radio){
            return true;
        }
        return false;
    }
    
}
