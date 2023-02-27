/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmo_KNN;

/**
 *
 * @author Rafael
 * Miercoles 20 de Julio del 2022.
 * Conesto concluye el algoritmo KNN.
 * Si clasifica los items que se le pasen pero lo dejaré hasta aqui ya que es muy pesado como para agregarlo a un juego o complementar otro algoritmo.
 */
public class KNN_Main {
    
    public static void main(String []args)
    {
        KNN knn=null;
        
        
        RsCategorias []m_entrenamiento_RsCategorias=new RsCategorias[4];
        
        m_entrenamiento_RsCategorias[0]=new RsCategorias("La Riviera",0);
        
        m_entrenamiento_RsCategorias[0].add(new Categoria("Marañonal",1));
        m_entrenamiento_RsCategorias[0].add(new Categoria("Espiritu Santo",0.5));
        
        
        m_entrenamiento_RsCategorias[1]=new RsCategorias("Marañonal",0);
        
        m_entrenamiento_RsCategorias[1].add(new Categoria("La Riviera",9));
        m_entrenamiento_RsCategorias[1].add(new Categoria("Las 3 Marias",7));
        
        m_entrenamiento_RsCategorias[2]=new RsCategorias("Espiritu Santo",0);
        
        m_entrenamiento_RsCategorias[2].add(new Categoria("La Riviera",11));
        m_entrenamiento_RsCategorias[2].add(new Categoria("Mojon",13));
        
        m_entrenamiento_RsCategorias[3]=new RsCategorias("Mojon",0);
        
        m_entrenamiento_RsCategorias[3].add(new Categoria("Espiritu Santo",11));
        m_entrenamiento_RsCategorias[3].add(new Categoria("Mojoncito",14));
        
        knn=new KNN(3,m_entrenamiento_RsCategorias);
        System.out.println("\n\nItem ganador:\n"+ knn.Clasificar(m_entrenamiento_RsCategorias[1], m_entrenamiento_RsCategorias).toString() + "\n\n");
//        System.out.println( knn.getPrimerClasificado().toString());
        

        RsCategorias []m_entrenamiento_RsCategorias2=new RsCategorias[2];

        m_entrenamiento_RsCategorias2[0]=new RsCategorias("Mojoncito",0);
        
        m_entrenamiento_RsCategorias2[0].add(new Categoria("Mojon",1));
        
        m_entrenamiento_RsCategorias2[1]=new RsCategorias("Las 3 Marias",0);
        
        m_entrenamiento_RsCategorias2[1].add(new Categoria("Marañonal",2));
        
        knn=new KNN(1,m_entrenamiento_RsCategorias2);
        System.out.println("\n\nItem ganador:\n"+ knn.Clasificar(m_entrenamiento_RsCategorias2[0], m_entrenamiento_RsCategorias2).toString());
        
    }
    
}
