/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CuadriculaConDatos;

/**
 *
 * @author Jugador
 */
public class SegmentoDelCamino {
    
    private int idCamino=0;
    public void setidCamino(int nuevo){
        idCamino=nuevo;
    }
    public int getidCamino(){
        return idCamino;
    }
    
    private double visibilidad=0.0;
    
    public double getVisibilidad(){
        visibilidad=1/getDistancia();
        return visibilidad;
    }
    
    private double distancia=0.0;
    public void setDistancia(double nuevo){
        distancia=nuevo;
    }
    public double getDistancia(){
        return distancia;
    }
    
    public double getCostoDelCamino(){
        return distancia;
    }
    
    private double aporteDeFeromonas=0;
    public double getAporteDeFeromonas(){
        aporteDeFeromonas=getCostoDelCamino()/evaporacion;
        return aporteDeFeromonas;
    }
    
    private double feromonasEnElCamino=0.4;
    
    
    private final double evaporacion=0.1;
    
    public void setFeromonasEnElCamino(double nuevo){
        feromonasEnElCamino=nuevo;
    }
    
    public double getFeromonasEnElCamino(){
        
        feromonasEnElCamino-=evaporacion;
        if(feromonasEnElCamino<0){
            feromonasEnElCamino=0;
        }
        return feromonasEnElCamino;
    }
    
    private double probabilidadDeElegir=0.0;
    
    
    /**
     * Una propiedad de lectura se crea para restringir el retorno de datos y para manipular como
     * se retornan los datos.
     * @return 
     */
    public double getProbabilidadDeElegir(){
        probabilidadDeElegir=getFeromonasEnElCamino()*getVisibilidad();
        return probabilidadDeElegir;
    }
    
    private double valoreAprendizage=1;
    
    public void setValorDeAprendizage(double nuevo){
        valoreAprendizage=nuevo;
    }
    public double getValorDeAprendizage(){
        return valoreAprendizage;
    }
    
    public double getQ_LK(){
        return this.getCostoDelCamino()/getValorDeAprendizage();
    }
}
