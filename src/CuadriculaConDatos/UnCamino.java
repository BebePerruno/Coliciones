/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuadriculaConDatos;

import java.util.ArrayList;

/**
 *
 * @author Jugador
 */
public class UnCamino {
    public ArrayList<SegmentoDelCamino> camino=new ArrayList();
    
    private double getSumatoriaDeFeromonasPorVisibilidad(){
        double sumatoria=0;
        try{
            for(int i =0; i<camino.size(); i++){
                sumatoria+=camino.get(i).getFeromonasEnElCamino()*camino.get(i).getVisibilidad();
            }
        }catch(Exception e){
            
        }
        return sumatoria;
    }
    
    private double getSumatoriaDeAporteDeFeromonas(){
        double sumatoria=0;
        try{
            for(int i =0; i<camino.size(); i++){
                sumatoria+=camino.get(i).getAporteDeFeromonas();
            }
        }catch(Exception e){
            
        }
        return sumatoria;
    }
    
    private double actualizacionDeFeromonasEnElCamino=0;
    
    public double getActualizacionDeFeromonasEnElCamino(){
        actualizacionDeFeromonasEnElCamino=getSumatoriaDeAporteDeFeromonas();
        return actualizacionDeFeromonasEnElCamino;
    }
    
    
}
