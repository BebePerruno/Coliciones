/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.Juego;

import java.util.ArrayList;

/**
 *
 * @author Rafael Angel Montero Fernpandez
 */
public class Coordenadas {
     private ArrayList<String> ArrayX=new ArrayList<String>();
    private ArrayList<String> ArrayY=new ArrayList<String>();
        
    public int sizeX(){
        return ArrayX.size()-1;
    }

    public int sizeY(){
        return ArrayY.size()-1;
    }
    
    public boolean x_es_mayor_que_y(){
        if(sizeX()>=sizeY()){
            return true;
        }
        return false;
    }

    private String Xtxt="", Ytxt="";

    public int getX(int id){
        if(sizeX()>=0){
//            if(id<0){
//                id=0;
//            }
//            if(id>sizeX()){
//                id=sizeX();
//            }
            return Integer.parseInt(this.ArrayX.get(id)) ;
        }
        return 0;
    }

    public int getY(int id){
        if(sizeY()>=0){
//            if(id<0){
//                id=0;
//            }
//            if(id>sizeY()){
//                id=sizeY();
//            }
            return Integer.parseInt(ArrayY.get(id)) ;
        }
        return 0;
    }

    /**
     * Este borrado funciona cuando se hace DragDrop
     */
    public void borrarRecorrido(){
            String yBkUp="";
            String xBkUp="";

            if(ArrayX.size()-1>-1){
                xBkUp=ArrayX.get(ArrayX.size()-1);
            }
            if(ArrayY.size()-1>-1){
                yBkUp=ArrayY.get(ArrayY.size()-1);

            }
           ArrayX=new ArrayList<String>();
           ArrayY=new ArrayList<String>();

           if(xBkUp.equalsIgnoreCase("")==false){
               ArrayX.add(xBkUp);
           }
           if(yBkUp.equalsIgnoreCase("")==false){
               ArrayY.add(yBkUp);
           }
    }

    /**
     * Borra todos los recorridos.
     */
    public void borrarTodo(){
        ArrayX=new ArrayList<String>();
       ArrayY=new ArrayList<String>();
    }

    public void add(int nuevo_x, int nuevo_y){
        ArrayX.add("" + nuevo_x);
        ArrayY.add("" + nuevo_y);

    }
    
    public void add(int nueva_coordenada_X_de_la_unidad, int nueva_coordenada_Y_de_la_unidad, 
        int nueva_posicion_x, int nueva_posicion_y){
        //En un futuro se simplificara esto si se puede.
//        int XMax=nueva_posicion_x;
//        int YMax=nueva_posicion_y;
        
        if(nueva_coordenada_X_de_la_unidad<=nueva_posicion_x){
            for(int i=nueva_coordenada_X_de_la_unidad; i<=nueva_posicion_x; i++){
                ArrayX.add("" + i);
            }
        }else if(nueva_coordenada_X_de_la_unidad>nueva_posicion_x){
            for(int i=nueva_coordenada_X_de_la_unidad; i>=nueva_posicion_x; i--){
                ArrayX.add("" + i);
            }
        }
        
        if(nueva_coordenada_Y_de_la_unidad<=nueva_posicion_y){
            for(int i=nueva_coordenada_Y_de_la_unidad; i<=nueva_posicion_y; i++){
                ArrayY.add("" + i);
            }
        }else if(nueva_coordenada_Y_de_la_unidad>nueva_posicion_y){
            for(int i=nueva_coordenada_Y_de_la_unidad; i>=nueva_posicion_y; i--){
                ArrayY.add("" + i);
            }
        }
    }
    
    private boolean datos_borrados=false;
    
    public void setDatosBorrados(boolean se_borraron){
        datos_borrados=se_borraron;
    }
    public boolean getDatosBorrados(){
        return datos_borrados;
    }
}