/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoConJLabels;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *Memorias de todos los caminos es el mapa que la unidad va dibujandose a si misma mientras explora el ambiente.
 * Esto es el equivalente a cuando un usuario hace click en una coordenada xy entonces, se guarda la ruta y se procede a recorrerla.
 * No es una pila.
 * Agrega rutas continuas, pero no quiere decir que sean rutas individuales.
 * Porque si se quiere recorrer la ruta o camino 3 insertado en algun punto existente entonces, no se podra.
 * De hecho empesaria a recorrerlo todo.
 * No obstante existen varias soluciones.
 * 1) Seria guardar en memoria el id de las rutas completas.
 * 
 * 2)Crear en otro class un ArrayList de este class.
 * 
 * Pero ambas implican guardar en otro class ciertos objetos.
 * @author Jugador
 */
public class MemoriaRuta implements Serializable{
    private ArrayList<MemoriaDelCamino> rsMemoriaDelCamino=new ArrayList();
    
    
    
    public void agregarAlFinal(MemoriaDelCamino nueva_memoria_del_camino){
        System.out.println("Se ha agregado: "+ nueva_memoria_del_camino.toString());
        rsMemoriaDelCamino.add(nueva_memoria_del_camino);
        System.out.println("Tamaño del registro " + this.size() );
//        this.VerResultados();
    }
    
    /**
     * Se debe insertar item por item.
     * @param id_del_punto
     * @param nueva_memoria_de_todos_los_caminos
     * @return 
     */
    public void agregarEnCualquierPunto(int id_del_punto, MemoriaRuta nueva_memoria_de_todos_los_caminos){
        int a_partir_del_punto_de_insercion=id_del_punto;
        for(int i=0; i<nueva_memoria_de_todos_los_caminos.size(); i++){
            agregarEnCualquierPunto(a_partir_del_punto_de_insercion, nueva_memoria_de_todos_los_caminos.getMemoria(i));
            a_partir_del_punto_de_insercion++;
        }
    }
    
    /**
     * Contiene el algoritmo para insertar en cualquier lado.
     * @param id_del_punto Un indice de algun item registrado.
     * @param nueva_memoria_del_camino Un objeto del class inicializado.
     * @return Si retorna true entonces la operacion se realizó con exito.
     */
    public boolean agregarEnCualquierPunto(int id_del_punto, MemoriaDelCamino nueva_memoria_del_camino){
        ArrayList<MemoriaDelCamino> rsMemoriaDelCaminoLocal=null;
        if(rsMemoriaDelCamino.size()-1==1){
            rsMemoriaDelCamino.add(nueva_memoria_del_camino);
            return true;        
        }else if(id_del_punto==0){
            rsMemoriaDelCaminoLocal=rsMemoriaDelCamino;
            rsMemoriaDelCamino=new ArrayList();
            rsMemoriaDelCamino.add(nueva_memoria_del_camino);
            for(MemoriaDelCamino unaMemoria:rsMemoriaDelCaminoLocal ){
                rsMemoriaDelCamino.add(unaMemoria);
            }
            return true;
        }else if(id_del_punto>=rsMemoriaDelCamino.size()-1){
            rsMemoriaDelCamino.add(nueva_memoria_del_camino);
            return true;
        }else if(id_del_punto>=1 && id_del_punto<rsMemoriaDelCamino.size()-2){
            rsMemoriaDelCaminoLocal=new ArrayList();
            MemoriaDelCamino unaMemoria;
//            int numeroDeParada=-1;
            for(int i=0; i<id_del_punto; i++){
                rsMemoriaDelCaminoLocal.add(rsMemoriaDelCamino.get(i));
            }
            rsMemoriaDelCaminoLocal.add(nueva_memoria_del_camino);
            //Empisa a contar desde el final de rsMemoriaDelCaminoLocal y termina al final de rsMemoriaDelCamino;
            for(int i=rsMemoriaDelCaminoLocal.size()-1; i<rsMemoriaDelCamino.size(); i++){
                rsMemoriaDelCaminoLocal.add(rsMemoriaDelCamino.get(i));
            }
            return true;
        }
        return false;
    }
    
    public void eliminarUnaMemoria(int id_de_la_memoria){
        rsMemoriaDelCamino.remove(id_de_la_memoria);
    }
    
    public void eliminarUnaMemoria(MemoriaDelCamino una_memoria_a_eliminar){
        rsMemoriaDelCamino.remove(una_memoria_a_eliminar);
    }
    
    public int size(){
        return rsMemoriaDelCamino.size();
    }
    
    public MemoriaDelCamino getMemoria(int id_de_la_memoria){
        if(id_de_la_memoria>=0 && id_de_la_memoria<rsMemoriaDelCamino.size()){
            return rsMemoriaDelCamino.get(id_de_la_memoria);
        }
        return null;
    }
    
    private int parar=0;
    public void VerResultados(){
        if(parar<10){
        FrmTabla f=new FrmTabla();
        try{
        f.setTabla(getCuadricula());}catch(Exception e){}
        f.setVisible(true);
        
        }
        parar++;
        
    }
    
    public DefaultTableModel getCuadricula()  {
        String [][]m={};
        try {
            m=getMatriz();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new DefaultTableModel(m,getEtiquetas());
    }
    
    public String[][] getMatriz()  {
        String [][]m=new String[rsMemoriaDelCamino.size()][rsMemoriaDelCamino.size()];
        for (int f=0; f<rsMemoriaDelCamino.size(); f++){
                m[f][0]=rsMemoriaDelCamino.get(f).XY_final.getX()+"";
                m[f][1]=rsMemoriaDelCamino.get(f).XY_final.getY()+"";
                m[f][2]=rsMemoriaDelCamino.get(f).getDecision()+"";
        }
            return m;
    }
    
    public String[] getEtiquetas() {
        String []m={"X", "Y", "Desicion" };
        return m;
    }
    
    
    
}
