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
public class RsCategorias extends AbstractModelo implements RsDatos<Categoria> {
   
   public ArrayList<Categoria> rsCategorias=new ArrayList();
   public ArrayList<Categoria> rsCategoriaOrdenadas=new ArrayList();

    public RsCategorias(String newNombre, double newValoGlobal) {
        super(newNombre, newValoGlobal);
    }
   
    @Override
   public void add(Categoria newCategoria)
   {
       newCategoria.setId(rsCategorias.size());
       
       rsCategorias.add(newCategoria);
   }
   
    @Override
   public void modificar(Categoria newCategoria)
   {
       for (int i=0; i<rsCategorias.size(); ++i)
       {
           if(rsCategorias.get(i).getId()==newCategoria.getId())
           {
               rsCategorias.remove(i);
               rsCategorias.add(newCategoria);
           }
       }
   }
   
    @Override
   public void Ordenar()
    {
        Categoria []m=new Categoria[rsCategorias.size()];
        for(int i=0; i<m.length; ++i)
        {
            m[i]=rsCategorias.get(i);
//            System.out.println("setListaOrdenada "+etiquetas.get(i));
        }
        Categoria temp=null;
        for(int i=0; i<m.length; ++i)
        {
            for(int i1=0; i1<m.length; ++i1)
            {
                if(m[i].getValor()>m[i1].getValor())
                {
                    temp=m[i];
                    m[i]=m[i1];
                    m[i1]=temp;
                }
            }
        }
        
        for(int i=0; i<m.length; ++i)
        {
            this.rsCategoriaOrdenadas.add(m[i]);
            System.out.println("Copiando en orden ="+m[i].toString());
        }
    }

    @Override
    public Categoria get(int id) {
        if(id>=rsCategorias.size())
        {
            id=rsCategorias.size()-1;
        }else if(id<0)
        {
            id=0;
        }
        try{
            return this.rsCategorias.get(id);
        }catch(Exception e){}
        return null;
    }

    @Override
    public ArrayList<Categoria> getRange(int k) {
        try
        {
            ArrayList<Categoria> rangeK=new ArrayList();
            for(int n=0; n<=k; ++n)
            {
                rangeK.add(rsCategorias.get(n));
            }
        }catch(Exception e){}
        return null;
    }

    @Override
    public int size() {
        return rsCategorias.size();
    }
}
