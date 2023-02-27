/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

/**
 *
 * @author Rafael
 */
public class Hormiga {
    
    /**
     * Debe darle el nombre a la hormiga y colocar los valores de los caminos.
     * @return 
     */
    public boolean iniciarAlgoritmo(){
        establecerVisibilidad();
        valor_inicialDeFeromonas();
        sumatoriaDeFeromonas();
        costoDeLCamino();
        establecerFeromonasPorVisibilidad();
        sumatoriaFeromonasPorVisibilidad();
        establecerProbabilidad_PXY();
        InicializarTranscitoElCamino();//No es necesario pero se deja.
        TranscitoElCaminoValidar();
        establecerFeromonasXY();
        establecerAporteDeFeromonas();
        sumatoriaDelAporteDeFeromonas();
        establecerActualizacionDeFeromonasEnELCamino();
        return true;
    }
    
    public Hormiga(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    
    private String nombre="";
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    public String getNombre(){
        return nombre;
    }
    
    public static double tasaDeEvaporacion=0.01;
    public static double valorDeAprendizageQ=0.01;
    
    /**
     * Paso 1
     * Colocar los caminos
     */
    public RsListas Caminos=new RsListas("Caminos");
    /**
     * Paso 2
     */
    private RsListas Visibilidad=new RsListas("Visibilidad");
    
    /**
     * Paso 2
     */
    public void establecerVisibilidad(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                Visibilidad.add(new Punto("Visibilidad " + Caminos.get(i).getNombre(),1/Caminos.get(i).Valor));
                System.out.println("Visibilidad " +(1/Caminos.get(i).Valor) );
            }
        }catch(Exception e){
            
        }
    }
    /**
     * Paso 3
     */
    public RsListas Feromonas=new RsListas("Feromonas");
    
    private void valor_inicialDeFeromonas(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                Feromonas.add(new Punto("Feromonas " + Caminos.get(i).getNombre(),0.1+i));
            }
        }catch(Exception e){
            
        }
    }
    
    /**
     * Paso 4
     * @return 
     */
    public double sumatoriaDeFeromonas(){
        return Feromonas.sumatoria();
    }
    /**
     * Paso 5
     * @return 
     */
    public double costoDeLCamino(){
        return Caminos.sumatoria();
    }
    
    /**
     * Paso 6
     */
    private RsListas FeromonasPorVisibilidad=new RsListas("FeromonasPorVisibilidad");
    
    private void establecerFeromonasPorVisibilidad(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                FeromonasPorVisibilidad.add(new Punto("FeromonasPorVisibilidad " + Caminos.get(i).getNombre(),Feromonas.get(i).Valor*Visibilidad.get(i).Valor));
            }
        }catch(Exception e){
            
        }
    }
    
    /**
     * Paso 7
     * @return 
     */
    public double sumatoriaFeromonasPorVisibilidad(){
        return FeromonasPorVisibilidad.sumatoria();
    }
    /**
     * Paso 8
     */
    public RsListas Probabilidad_PXY=new RsListas("Probabilidad_PXY");
    
    /**
     * Paso 8.
     * Probabilidad de elegir el mejor camino.
     * 
     */
    public void establecerProbabilidad_PXY(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                Probabilidad_PXY.add(new Punto("Probabilidad_PXY " + Caminos.get(i).getNombre(),FeromonasPorVisibilidad.get(i).Valor/sumatoriaFeromonasPorVisibilidad()));
//                System.out.println("Probabilidad_PXY " + (FeromonasPorVisibilidad.get(i).Valor/sumatoriaFeromonasPorVisibilidad()));
            }
        }catch(Exception e){
            
        }
    }
    /**
     * Paso 9
     */
    public RsListas TranscitoElCamino=new RsListas("TranscitoElCamino");
    
    private void InicializarTranscitoElCamino(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                TranscitoElCamino.add(new Punto("TranscitoElCamino " + Caminos.get(i).getNombre(),false));
            }
        }catch(Exception e){
            
        }
    }
    
    public void TranscitoElCaminoValidar(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                TranscitoElCamino.add(new Punto("TranscitoElCamino " + Caminos.get(i).getNombre(),false));
                if(TranscitoElCamino.get(i).getActivado()==true){
                    TranscitoElCamino.modificar(new Punto("TranscitoElCamino " + Caminos.get(i).getNombre(),valorDeAprendizageQ/this.costoDeLCamino(),true));
                }else{
                    TranscitoElCamino.modificar(new Punto("TranscitoElCamino " + Caminos.get(i).getNombre(),0,false));
                }
            }
        }catch(Exception e){
            
        }
    }
    
    /**
     * Paso 10
     */
    public RsListas FeromonasXY=new RsListas("FeromonasXY");
    
    private void establecerFeromonasXY(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                double evaporacion=(1-tasaDeEvaporacion);
                FeromonasXY.add(new Punto("FeromonasXY " + Caminos.get(i).getNombre(),evaporacion*this.Feromonas.get(i).Valor));
//                System.out.println("FeromonasXY " +(evaporacion*this.Feromonas.get(i).Valor));
            }
        }catch(Exception e){
            
        }
    }
    /**
     * Paso 11
     */
    public RsListas AporteDeFeromonas=new RsListas("AporteDeFeromonas");
    private void establecerAporteDeFeromonas(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                AporteDeFeromonas.add(new Punto("AporteDeFeromonas " + Caminos.get(i).getNombre(),tasaDeEvaporacion/this.costoDeLCamino()));
//                System.out.println("AporteDeFeromonas " +tasaDeEvaporacion/this.costoDeLCamino());
            }
        }catch(Exception e){
            
        }
    }
    /**
     * Paso 12
     * @return 
     */
    public double sumatoriaDelAporteDeFeromonas(){
        return AporteDeFeromonas.sumatoria();
    }
    
    /**
     * Paso 13
     */
    public RsListas ActualizacionDeFeromonasEnELCamino=new RsListas("ActualizacionDeFeromonasEnELCamino");
    
    /**
     * Reviar que anda mal.
     */
    private void establecerActualizacionDeFeromonasEnELCamino(){
        try{
            for(int i =0; i<Caminos.size(); i++){
                ActualizacionDeFeromonasEnELCamino.add(new Punto("ActualizacionDeFeromonasEnELCamino " + Caminos.get(i).getNombre(),this.FeromonasXY.get(i).Valor+this.sumatoriaDelAporteDeFeromonas()));
                Feromonas.modificar(new Punto("Feromonas " + Caminos.get(i).getNombre(),ActualizacionDeFeromonasEnELCamino.get(i).Valor));
//                System.out.println(Feromonas.toString());
            }
        }catch(Exception e){
            
        }
    }
    //Aqui termina la primera parte del algoritmo de hormigas.
    //La segunda parte es crear un class en el cual se creará un ArrayList de este class para crear el hormiguero.
    //En el cual se realizará un paso más para todas las feromonas en el camino pero de manera gloval con varias hormigas.
}
