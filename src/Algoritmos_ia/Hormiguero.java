/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

import java.util.ArrayList;

/**
 *Recordar crear un class camino con todos los arrays de la hormiga pero sin los algoritmos.
 * Quizas se pueda hacer que hormiga descienda de camino.
 * Este class es opcional ya que se puede realizar el algoritmo de manera alternativa con solo el class Hormiga.
 * 
 * Bueno despues de este experimento en Java mejor me construyo mi propia variante de este algoritmo.
 * @author Rafael
 */
public class Hormiguero {
    
    
    public static void main(String []a){
        Hormiguero hs=new Hormiguero();
        Hormiga h1=new Hormiga("h1");
        Hormiga h2=new Hormiga("h2");
        Hormiga h3=new Hormiga("h3");
        Hormiga h4=new Hormiga("h4");
        
        h1.Caminos.add(new Punto("c1",4));
        h1.Caminos.add(new Punto("c2",5));
        h1.Caminos.add(new Punto("c3", 3));
        h1.Caminos.add(new Punto("c4", 2));
//        h1.Caminos.add(new Punto("c5",1));
//        h1.Caminos.add(new Punto("c6",1.5));
        
        h2.Caminos=h1.Caminos;
        h3.Caminos=h1.Caminos;
        h4.Caminos=h1.Caminos;
        
        h1.iniciarAlgoritmo();
        h2.iniciarAlgoritmo();
        h3.iniciarAlgoritmo();
        h4.iniciarAlgoritmo();
        
        hs.add(h1);
        hs.add(h2);
        hs.add(h3);
        hs.add(h4);
        
        System.out.println(hs.MejorCamino().toString());
    }
    
    
    public ArrayList<Hormiga> hormigas=new ArrayList<Hormiga>();
    
    public void add(Hormiga nueva_Hormiga_de_valor){
        if(this.SiExiste(nueva_Hormiga_de_valor)==false){
            hormigas.add(nueva_Hormiga_de_valor);
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
    private boolean SiExiste(Hormiga nueva_Hormiga_de_valor){
        try{
            for(int i=0; i<hormigas.size(); i++){
                if(hormigas.get(i).getNombre().equalsIgnoreCase(nueva_Hormiga_de_valor.getNombre())==true){
                    si_existe_id=i;
                    return true;
                }
            }
        }catch(Exception e){
            
        }
        return false;
    }
    
    /**
     * Nuevo valor de t(e), mejor dicho del campo feromonas.
     * Se puede actualizar el ArrayList de cada hormiga con este despues de actualizarlo globalmente.
     */
    public RsListas Feromonas=new RsListas("Feromonas");
    
    /**
     * Retorna un ArrayList con las feromonas actualizadas en forma global por todo el hormiguero.
     * Nuevo valor de t(e), mejor dicho del campo feromonas.
     * Permite obtener el ArrayList actualizado para pasarselo a cada hormiga y tambien para colocarlo en el camino.
     * @return 
     */
    private RsListas getActualizacionGlobalDeFeromonasEnElCamino(){
        int idf=0;
        int id=0;
        try{
            Punto punto=null;
            /**
             * Recorido de 2 en 2 desde cero.
             */
            for (int i=0; i<hormigas.size(); i++){
                id=i;
                int z=hormigas.get(i).ActualizacionDeFeromonasEnELCamino.size();
                for(int f=0;f<z; f++){
                    idf=f;
//                    Hormiga hr=hormigas.get(i);
                    /**
                     * Esto evita que el ArrayList cresca sin control alguno
                     */
//                    if(Feromonas.size()==hormigas.get(i).Caminos.size()){
////                        punto=new Punto(hormigas.get(i).Caminos.getNombre(), Feromonas.get(f).Valor + hormigas.get(i).ActualizacionDeFeromonasEnELCamino.get(f).Valor);
////                        Feromonas.modificar(punto);
////                          System.out.println(hormigas.get(id).Caminos.get(idf).toString());
//                    }else{
//                        hormigas.get(i).ActualizacionDeFeromonasEnELCamino.get(id);
                        punto=new Punto("xxx" + i, i);//(hormigas.get(i).Caminos.getNombre(), hormigas.get(i).ActualizacionDeFeromonasEnELCamino.get(f).Valor);
//                        Feromonas.add(punto);
hormigas.get(i).iniciarAlgoritmo();
                        Feromonas.add(punto);
//                        System.out.println(hormigas.get(i).ActualizacionDeFeromonasEnELCamino.get(id).toString());
//                    }
                    
//                    Feromonas.get(id).setNombre("c"+f);
//                    Feromonas.get(id).Valor=punto.Valor;
                }
//                System.out.println(i+ "=" + punto.toString());
            }
        }catch(Exception ex){
            System.out.println("El recorrido se detuvo en la hormiga numero " + id+ ", con el id de actualizacion de feromonas " + idf);
            if(Feromonas.size()<hormigas.get(idf).Caminos.size()){
                Feromonas.add(new Punto("Hormiga extra",0));
            }
        }
        
        return new RsListas("No habilitado");
    }
    
    private RsListas sumatoriaDeProbabilidades=null;
    /**
     * Actualiza el ArrayList de feromonas.
     * 
     */
    public RsListas SumatoriaPXY(){
        sumatoriaDeProbabilidades=new RsListas("SumatoriaPX");
        for(int f=0;f<hormigas.get(0).Probabilidad_PXY.size(); f++){
            hormigas.get(0).establecerProbabilidad_PXY();
            sumatoriaDeProbabilidades.add(hormigas.get(0).Probabilidad_PXY.get(f));
        }
        
            for (int i=1; i<hormigas.size(); i++){
                hormigas.get(i).iniciarAlgoritmo();
                for(int f=0;f<hormigas.get(i).Probabilidad_PXY.size(); f++){
                    sumatoriaDeProbabilidades.modificar(new Punto(sumatoriaDeProbabilidades.get(i).getNombre(),
                    sumatoriaDeProbabilidades.get(i).Valor+hormigas.get(i).Probabilidad_PXY.get(i).Valor));
                }
            }
            return sumatoriaDeProbabilidades;
    }
    
    /**
     * El mejor camino en el hormiguero es el que tiene más feromonas.
     * 
     * @return 
     */
    private RsListas Ordenado(){
        
        RsListas mPoblacion_ordenada_temp=SumatoriaPXY();
        Punto []mPuntos=new Punto[hormigas.get(0).Caminos.size()];
        Punto individuo_elegible=null;
        //Cargando el vector
        for(int i=0;i<mPuntos.length;i++){
            mPuntos[i]=hormigas.get(0).Caminos.get(i);
            System.out.println(i+" mPuntos[i]="+mPuntos[i].Valor);
        }
        
        //Ordenando
        for(int i=0;i<mPuntos.length;i++){
            individuo_elegible=mPuntos[i];
            for(int p=0;p<mPuntos.length;p++){
                if(mPuntos[i].Valor<mPuntos[p].Valor){
                    individuo_elegible=mPuntos[i];
                    mPuntos[i]=mPuntos[p];
                    mPuntos[p]=individuo_elegible;
                }
            }
                
        }
        mPoblacion_ordenada_temp=new RsListas("Feromonas");
        for(int i=0;i<mPuntos.length;i++){
            mPoblacion_ordenada_temp.add(mPuntos[i]);
            System.out.println("ProvabilidadPXY [" + i + "] = "+mPuntos[i].Valor);
        }
        //Mejor individuo
        return mPoblacion_ordenada_temp;
    }
    
    /**
     * Retorna el camino con mayor puntage de feromonas.
     * @return 
     */
    public Punto MejorCamino(){
//        actualizarFeromonas();
        return Ordenado().get(0);
    }
    
    
    
}
