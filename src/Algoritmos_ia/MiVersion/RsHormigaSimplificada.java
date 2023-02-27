/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia.MiVersion;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class RsHormigaSimplificada {
    private ArrayList<Camino> Lista=new ArrayList<Camino>();
    
    public class XY{
        public XY(double nuevo_X1, double nuevo_X2, double nuevo_Y1, double nuevo_Y2){
             X1=nuevo_X1;
             X2=nuevo_X2;
             
             Y1=nuevo_Y1;
             Y2=nuevo_Y2;
        }
        public double X1=0;
        public double X2=0;
        public double Y1=0;
        public double Y2=0;
        
        @Override
        public String toString(){
            return "X1=" + X1 + "; X2=" + X2 + "; Y1=" + Y1 + "; Y2= " + Y2;
        }
    }
    
    private ArrayList<XY> rsXY=new ArrayList<XY> ();
    
    public XY getXY(int id){
        try{
            return rsXY.get(id);
        }catch(Exception ex){}
        return new XY(0,0,0,0);
    }
    
    public XY getMejorXY(){
        return rsXY.get(idXY);
    }
 
    
    /**
     * 
     * @param nuevo_X1 Punto inicial X
     * @param nuevo_X2 Punto final X.
     * @param nuevo_Y1 Punto inicial Y
     * @param nuevo_Y2 Punto final Y
     */
    public void add(double nuevo_X1, double nuevo_X2, double nuevo_Y1, double nuevo_Y2){
        double xTotal=0;
        rsXY.add(new XY( nuevo_X1,  nuevo_X2,  nuevo_Y1,  nuevo_Y2));
        if(nuevo_X2>nuevo_X1){
            xTotal=nuevo_X2-nuevo_X1;
        }else{
            xTotal=nuevo_X1-nuevo_X2;
        }
        
        double yTotal=0;
        if(nuevo_Y2>nuevo_Y1){
            yTotal=nuevo_Y2-nuevo_Y1;
        }else{
            yTotal=nuevo_Y1-nuevo_Y2;
        }
//        System.out.println("xTotal " + xTotal);
//        System.out.println("yTotal " + yTotal);
        double distancia_del_camino=xTotal+yTotal;
//        Camino camino=new Camino(distancia_del_camino,1);
        Lista.add(new Camino(distancia_del_camino,1));
//        add(camino);//No funciona porque no se agrega el nombre del camino.
    }
    
    /**
     * Permite agregar en forma simplificada la distancia, las operaciones externas como sumar 2 puntos para 
     * determinar el largo de uns egmento de la ruto se realizan fuera y el resultado se pasa por parametro.
     * @param nuevo_camino 
     */
    public void add(Camino nuevo_camino){

        if(Lista.size()>0){
            try{
                for(int i=0; i<Lista.size(); i++){
                    if(Lista.get(i).getNombre().equalsIgnoreCase(nuevo_camino.getNombre())==true){
                        Lista.get(i).setCantidadDePasadasPorAqui(Lista.get(i).getCantidadDePasadasPorAqui()+1);
                        break;
                    }else{
                        Lista.add(nuevo_camino);
                        break;
                    }
                }
            }catch(Exception ex){
                Lista.add(nuevo_camino);
            }
        }else{
            Lista.add(nuevo_camino);
        }
    }
    
    private int si_existe_id=-1;
    /**
     * No se utilizará puesto que puede lerdear la agregacion de datos.
     * Ademas los valores numericos se pueden repetir.
     * Pero mejor si.
     * @param nuevo_punto_de_valor
     * @return 
     */
    private boolean SiExiste(Camino nuevo_punto_de_valor){
        try{
            for(int i=0; i<Lista.size(); i++){
                if(Lista.get(i).getNombre().equalsIgnoreCase(nuevo_punto_de_valor.getNombre())==true){
                    si_existe_id=i;
                    return true;
                }
            }
        }catch(Exception e){
            
        }
        return false;
    }
    
    private int idXY=0;
    public Camino mejorCamino(){
        Camino mejor_camino=Lista.get(0);
//        System.out.println("size " +Lista.size() );
        try{
            for(int i=1; i<Lista.size(); i++){
//                System.out.println("Lista.get(i).getVisibilidad() " +Lista.get(i).getVisibilidad() );
                if(Lista.get(i).getVisibilidad()>mejor_camino.getVisibilidad()){
                    mejor_camino=Lista.get(i);
                    idXY=i;
                }
            }
        }catch(Exception e){
            
        }
//        System.out.println("mejor_camino " + mejor_camino.getDistancia() + "; " );
        return mejor_camino;
    }
    
    /**
     * Suma todos los segmentos del recorrido total de la hormiga rs.
     * @return 
     */
    public double SumatoriaDeSegmentos(){
        double sumatoria=0;
        try{
            for(int i=0; i<Lista.size(); i++){
                sumatoria+=Lista.get(i).getDistancia();
            }
        }catch(Exception e){
            
        }
        return sumatoria;
    }
    
    public int size(){
        return Lista.size();
    }
    
    @Override
    public String toString(){
        String informe="Informe de la hormiga\n";
        try{
            for(int i=0; i<Lista.size(); i++){
                informe=Lista.get(i).toString() + "\n\n";
            }
        }catch(Exception e){}
        return informe;
    }
    
    public void modificar(Camino nuevo_punto_de_valor){
        if(this.SiExiste(nuevo_punto_de_valor)==true){
            Lista.remove(si_existe_id);
            Lista.add(nuevo_punto_de_valor);
        }
    }
    
    public void borrar(Camino nuevo_punto_de_valor){
        if(this.SiExiste(nuevo_punto_de_valor)==true){
            Lista.remove(si_existe_id);
        }
    }
    
    public Camino buscar(Camino nuevo_punto_de_valor){
        try{
            for(int i=0; i<Lista.size(); i++){
                if(Lista.get(i).getNombre().equalsIgnoreCase(nuevo_punto_de_valor.getNombre())==true){
                    si_existe_id=i;
                    return Lista.get(i);
                }
            }
        }catch(Exception e){
            
        }
        return new Camino(0,0);
    }
    
    public Camino get(int id){
        try{
            return Lista.get(id);
        }catch(Exception e){}
        return new Camino(0,0);
    }
    
}
