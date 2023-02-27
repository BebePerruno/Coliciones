/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia.MiVersion;

import java.util.ArrayList;

/**
 * Establecer la sincronicidad de los hilos para ir agregando las coordenadas a la unidad conforme llega al
 * final de cada segmento del camino.
 * @author Rafael
 */
public abstract class HormiguerroSimplificado {
    private ArrayList<RsHormigaSimplificada> hormiguero=new ArrayList<RsHormigaSimplificada> ();
    
    public void add(RsHormigaSimplificada nuevo_rsHormiga){
        hormiguero.add(nuevo_rsHormiga);
    }
    
    public abstract void ObteniendoCoordenadas(double nuevo_X1, double nuevo_X2, double nuevo_Y1, double nuevo_Y2);
    /**
     * Retorna la hormiga con el mejor recorrido.
     * @return 
     */
    public RsHormigaSimplificada mejorCamino(){
        RsHormigaSimplificada mejor_camino=hormiguero.get(0);
        try{
            for(int i=1; i<hormiguero.size(); i++){
                if(hormiguero.get(i).SumatoriaDeSegmentos()>mejor_camino.SumatoriaDeSegmentos()){
                    mejor_camino=hormiguero.get(i);
                }
            }
            for(int i=0; i<mejor_camino.size(); i++){
                this.ObteniendoCoordenadas(mejor_camino.getXY(i).X1, mejor_camino.getXY(i).X2, mejor_camino.getXY(i).Y1, mejor_camino.getXY(i).Y2);
            }
        }catch(Exception e){
            
        }
        return mejor_camino;
    }
    
}
