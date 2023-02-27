/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmo_KNN;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class KNN {
    private RsCategorias []rsCategoriasDeEntrenamiento=null;
    private int k=0;
    
    /**
     * 
     * @param k_resultados Nuvero de items a evaluar a ver cuantas veces se repite uno.
     * @param newRsCategorias Vector de RsCategorias que sirve para evaluar y colocar la categoria a investigar.
     */
    public KNN(int k_resultados,RsCategorias []newRsCategorias )
    {
        rsCategoriasDeEntrenamiento=newRsCategorias;
        k=k_resultados;
    }
    
    public UnClasificado Clasificar(RsCategorias newRsCategorias_a_clasificar,RsCategorias []m_entrenamiento_RsCategorias)
    {
        this.calcularTodasLasDistancias(newRsCategorias_a_clasificar, m_entrenamiento_RsCategorias);
        clasificados.Ordenar();
        return clasificados.getClasificadoGanador(k);
    }
    
      
    private RsClasificados clasificados=new RsClasificados();
    
    public String getPrimerClasificado()
    {
        try
        {
            clasificados.Ordenar();
            return clasificados.getRange(1).get(0).toString();
        }catch(Exception e)
        {
            System.err.println("Debe llamar la funcion calcularTodasLasDistancias primero.\n"+e.getMessage());
        }
        return "Sin resultados";
    }
    
    int contador=0;
    
    public ArrayList<UnClasificado> calcularTodasLasDistancias(RsCategorias newRsCategorias,RsCategorias []m_entrenamiento_RsCategorias)
    {
//        RsClasificados clasificadosLocales=new RsClasificados();
        try{
            for(int i=0; i<m_entrenamiento_RsCategorias.length; ++i)
            {
                clasificados.add(new UnClasificado(m_entrenamiento_RsCategorias[i].getNombre(),distancia(newRsCategorias,m_entrenamiento_RsCategorias[i])));
            }
        }catch(Exception e)
        {
            
        }
        clasificados.Ordenar();
        return clasificados.getRange(k);
    }
    
    public double distancia(RsCategorias newRsCategorias,RsCategorias entrenamiento_RsCategorias )
    {
        double valor_global_local=0;
        try{
//            rsCategoriasDeEntrenamiento=entrenamiento_RsCategorias; No aplica
            if(newRsCategorias.size()==entrenamiento_RsCategorias.size())
            {
                for(int i=0; i<newRsCategorias.size(); ++i)
                {
                    if(newRsCategorias.get(i).getValor()<entrenamiento_RsCategorias.get(i).getValor())
                    {
                        valor_global_local+=Math.pow(entrenamiento_RsCategorias.get(i).getValor()-newRsCategorias.get(i).getValor(),2);
                    }else
                    {
                        valor_global_local+=Math.pow(newRsCategorias.get(i).getValor()-entrenamiento_RsCategorias.get(i).getValor(),2);
                    }
                }
                valor_global_local=Math.sqrt(valor_global_local);
            }
        }catch(Exception ex)
        {
            System.err.println("Los registros tienen tamaños diferentes.\nHay datos null.\n\n"+ex.getMessage());
        }
        return valor_global_local;
    }
}
