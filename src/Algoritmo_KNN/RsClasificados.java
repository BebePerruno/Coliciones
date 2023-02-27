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
public class RsClasificados implements RsDatos<UnClasificado>{
    
    
    public ArrayList<UnClasificado> rsClasificados=new ArrayList();
    public ArrayList<UnClasificado> rsClasificadosOrdenados=new ArrayList();
    
    @Override
    public void Ordenar() {
        UnClasificado []m=new UnClasificado[rsClasificados.size()];
        for(int i=0; i<m.length; ++i)
        {
            m[i]=rsClasificados.get(i);
//            System.out.println("setListaOrdenada "+etiquetas.get(i));
        }
        UnClasificado temp=null;
        for(int i=0; i<m.length; ++i)
        {
            for(int i1=0; i1<m.length; ++i1)
            {
                if(m[i].getValorGlobal()<m[i1].getValorGlobal())
                {
                    temp=m[i];
                    m[i]=m[i1];
                    m[i1]=temp;
                }
            }
        }
        
        for(int i=0; i<m.length; ++i)
        {
            this.rsClasificadosOrdenados.add(m[i]);
//            System.out.println("Copiando en orden ="+m[i].toString());
        }
    }

    @Override
    public void add(UnClasificado newCategoria) {
        rsClasificados.add(newCategoria);
    }

    @Override
    public void modificar(UnClasificado newCategoria) {
        for (int i=0; i<rsClasificados.size(); ++i)
       {
           if(rsClasificados.get(i).getId()==newCategoria.getId())
           {
               rsClasificados.remove(i);
               rsClasificados.add(newCategoria);
           }
       }
    }

    @Override
    public UnClasificado get(int id) {
        if(id>=rsClasificados.size())
        {
            id=rsClasificados.size()-1;
        }else if(id<0)
        {
            id=0;
        }
        try{
            return this.rsClasificados.get(id);
        }catch(Exception e){}
        return null;
    }

    @Override
    public ArrayList<UnClasificado> getRange(int k) {
        try
        {
            this.Ordenar();
            ArrayList<UnClasificado> rangeK=new ArrayList();
            for(int n=0; n<=k; ++n)
            {
                rangeK.add(rsClasificadosOrdenados.get(n));
            }
        }catch(Exception e){}
        return null;
    }
    
    public UnClasificado getClasificadoGanador(int k)
    {
        try
        {
            this.Ordenar();
            ArrayList<UnClasificado> rangeK=new ArrayList();
            for(int n=0; n<=k; ++n)
            {
                rangeK.add(rsClasificadosOrdenados.get(n));
            }
            
            //Contando las clases seleccionadas a ver cuantas veces se repiten.
            for(int n=0; n<=k; ++n)
            {
                for(int i=0; i<=k; ++i)
                {
                    if(rangeK.get(k).getNombre().equalsIgnoreCase(rangeK.get(i).getNombre())==true)
                    {
                        rangeK.get(k).setVecesQueAparese(rangeK.get(k).getVecesQueAparese()+1);
                    }
                }
            }
            
            //Ordenando de mayor a menor.
            return Ordenar_de_Mayor_a_menor(rangeK).get(0);
        }catch(Exception e){
            System.err.println("No hay datos en el registro.\n\n" + e.getMessage());
        }
        return null;
    }
    
    private ArrayList<UnClasificado> Ordenar_de_Mayor_a_menor(ArrayList<UnClasificado> un_rs) {
        UnClasificado []m=new UnClasificado[un_rs.size()];
        for(int i=0; i<m.length; ++i)
        {
            m[i]=un_rs.get(i);
//            System.out.println("setListaOrdenada "+etiquetas.get(i));
        }
        UnClasificado temp=null;
        for(int i=0; i<m.length; ++i)
        {
            for(int i1=0; i1<m.length; ++i1)
            {
                if(m[i].getVecesQueAparese()>m[i1].getVecesQueAparese())
                {
                    temp=m[i];
                    m[i]=m[i1];
                    m[i1]=temp;
                }
            }
        }
        
        ArrayList<UnClasificado> rs=new ArrayList();
        for(int i=0; i<m.length; ++i)
        {
            rs.add(m[i]);
            System.out.println("Copiando en orden ="+m[i].toString());
        }
        
        return rs;
    }

    @Override
    public int size() {
        return rsClasificados.size();
    }
}
