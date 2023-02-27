/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

/**
 *
 * @author Rafae
 */
public class Sprite {
    private int x,y;
    public int []pixeles;
    private int lado, columna, fila;
    private SpriteHoja hoja;
    
    public Sprite(final int nuevo_lado, final int nueva_columna, final int nueva_fila, final SpriteHoja nuevo_SpriteHoja){
        hoja=nuevo_SpriteHoja;
        lado=nuevo_lado;
        pixeles=new int[lado*lado];
        x=lado*nueva_columna;
        y=nueva_fila*lado;
        //Extrayendo el sprite de la hoja de sprites.
        for(int idY=0;idY<lado;idY++){
            for(int idX=0;idX<lado;idX++){
                //En java no se respetan las leyes de prioridad de las multiplicaciones y las diviciones.
                //En esta operacion el orden es de izquierda a derecha sin importar la multiplicasion.
                pixeles[idX+idY*lado]=hoja.pixeles[(idX+x)+(idY+y)*hoja.getAncho()];
            }
        }
    }
    
    /**
     * Se realiza asi para no crear una instancia en otra clase o muchas instancias.
     */
    public static Sprite ambiente=new Sprite(40,0,0,SpriteHoja.hoja_sprite);
}
