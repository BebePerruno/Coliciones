/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 * Bueno despues del intento numero 4 creo que crearé el intento numero 5.
 * Conclusiones, el algoritmo si funciona pero debe agregarse un diccionario con una sola etiqueta por unidad.
 */
public class VecinoMásCercano4 {
    public static void main(String []m)
    {
        new KNN();
    }
}

/**
 * 
 * @author Rafael
 * Se hace abstracto para poder pasar valores a los metodos a implementar.
 */
 class KNN{
     
     public KNN()
     {
         k=4;
         //Cada clase debe ser un vector de RsEtiquetas.
         //Datos conocidos
         RsEtiquetas etiquetas=new RsEtiquetas("A");
         etiquetas.add(new Etiqueta(1.3,1));
         etiquetas.add(new Etiqueta(1.4,2));
         gropoDeEtiquetas=new RsGrupoDeEtiquetas();
         gropoDeEtiquetas.add(etiquetas);
//         
//         RsEtiquetas  etiquetas1=new RsEtiquetas("B");
//         etiquetas.add(new Etiqueta(2.3,1));
//         etiquetas.add(new Etiqueta(3.4,2));
//         gropoDeEtiquetas.add(etiquetas1);
//         
//         RsEtiquetas  etiquetas2=new RsEtiquetas("C");
//         etiquetas.add(new Etiqueta(5.3,1));
//         etiquetas.add(new Etiqueta(5.4,2));
//         gropoDeEtiquetas.add(etiquetas2);
         
         RsEtiquetas parametros_de_entranamiento=new RsEtiquetas("parametros_de_entranamiento");
         parametros_de_entranamiento.add(new Etiqueta(4.99,1));
         parametros_de_entranamiento.add(new Etiqueta(5.12,2));
         
         
         RsEtiquetas parametros_a_buscar=new RsEtiquetas("parametros_a_buscar");
         parametros_a_buscar.add(new Etiqueta(1,7));
         parametros_a_buscar.add(new Etiqueta(2,2));
//         parametros_de_entranamiento.OrdenarDatosOriginales();
         this.clasificarParametros(parametros_a_buscar);
//         for(int i=0; i<getClasificados().size(); i++)
//         {
//             System.out.println(getClasificados().get(i).toString());
//         }
     }
    
    /**
     * K del algoritmo.
     * Tambien determina el patron de ordenamiento, o sea cuantos items se mostraran despues de ordenar la lista.
     */
    private int k=0;
    
    /**
     * Etiquetas del algoritmo knn, con su respectivo valor double.
     */
//    private ArrayList<Etiqueta> etiquetas=new ArrayList();
    private RsGrupoDeEtiquetas gropoDeEtiquetas;
    
    public KNN(int newK, RsGrupoDeEtiquetas newRsGrupoDeEtiquetas)
    {
        gropoDeEtiquetas=newRsGrupoDeEtiquetas;
        k=newK;
    }
    
    /**
     * Se carga con datos cuando se llama a la funcion Distancia().
     * @param newDistancia Datos que se reciven cuando se ejecuta el evento.
     */
    public double getDistancia()
    {
        return distanciaLocal;
    }
    
    private double distanciaLocal=0;
    /**
     * 
     * @param mParametros_a_clasificar Un vector con formato double.
     *  Son datos que se quieren clasificar.
     * @param mParametros_de_entrenamiento Un vector con formato double.
     *  Son datos de entrenamiento.
     * @param newDistancia se deja como parametro para respetar el diseño original pero no se usa.
     * @return Retorna verdadero si todas las condiciones se cumplen.
     */
    private boolean distancia(RsEtiquetas newParametros_a_clasificar, 
            RsGrupoDeEtiquetas newGrupoDeEtiquetasDeEntrenamiento) throws Exception//, double newDistancia )
    {
        double suma=0;
        distanciaLocal=0;
        boolean sonIguales=false;
        for(int i=0; i<newGrupoDeEtiquetasDeEntrenamiento.size();++i)
        {
            if(newParametros_a_clasificar.size()!=newGrupoDeEtiquetasDeEntrenamiento.get(i).size())
            {
                System.out.println("Los tamaños son diferentes.");
                sonIguales= false;
            }

            int numeroDeParametros=newParametros_a_clasificar.size();
            
            for(int id=0; id<numeroDeParametros; id++)
            {
                if(newParametros_a_clasificar.get(i)!=null)
                {
                    try {
                        //                System.out.println(newParametros_a_clasificar.get(i).ValorDelNivel);
                        suma+=Math.pow(newParametros_a_clasificar.get(i).ValorDelNivel-newGrupoDeEtiquetasDeEntrenamiento.get(i).get(id).ValorDelNivel, 2);
                    } catch (Exception ex) {
                        Logger.getLogger(KNN.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        } //End for newGrupoDeEtiquetasDeEntrenamiento
        distanciaLocal=Math.sqrt(suma);
        
        return true;
    }
    
    private RsGrupoDeEtiquetas grupoDeDistanciasOrdenadas=null; 
    
//    /**
//     * Se carga con datos cuando se llama a la funcion booleana calcularTodasLasDistancias_y_Ordenarlas().
//     * @return 
//     */
//    public RsEtiquetas getDistanciasOrdenadas()
//    {
//        return grupoDeDistanciasOrdenadas.getListaOrdenada();;
//    }
    
    
    private boolean calcularTodasLasDistancias_y_Ordenarlas(RsEtiquetas newParametros_a_clasificar) throws Exception// Es el array para llenar, RsGrupoDeEtiquetas newRGrupoDeEtiqurtas)
    {
        grupoDeDistanciasOrdenadas=new RsGrupoDeEtiquetas(); 
        for(int i=0; i<this.gropoDeEtiquetas.size(); ++i)
        {
            RsEtiquetas unRsEtiquetas=gropoDeEtiquetas.get(i);
//            for(int id=0; id<unRsEtiquetas.size(); ++id)
//            {
                if(distancia(newParametros_a_clasificar, gropoDeEtiquetas )==true)
                {
                    grupoDeDistanciasOrdenadas.add(new RsEtiquetas(unRsEtiquetas.Nombre,unRsEtiquetas.getTodoElArray(),1,distanciaLocal));
                    System.out.println("calcularTodasLasDistancias_y_Ordenarlas= " + (distanciaLocal));//+unaEtiqueta.ValorDelNivel));
                }
                else
                {
                    return false;
                }
//            } //End for unRsEtiquetas
        }
        System.out.println("Distancia global = " + distanciaLocal);
//        grupoDeDistanciasOrdenadas.getListaOrdenada();
        return true;
    }
    
    /**
     * Se carga cuando se llama a la funcion clasificarParametros(...).
     * @return Un ArrayList con las etiquetas clasificadas.
     */
    public ArrayList<RsEtiquetas> getClasificados()
    {
        return diccionario_de_etiquetas.getRange(k);
    }
    
    private RsGrupoDeEtiquetas diccionario_de_etiquetas;
    
    public boolean clasificarParametros(RsEtiquetas lista_a_clasificar)//, String etueta_de_salida_solo_de_relleno)
    {
        diccionario_de_etiquetas=new RsGrupoDeEtiquetas();
         try {
             if(calcularTodasLasDistancias_y_Ordenarlas(lista_a_clasificar)==true)
             {
                 grupoDeDistanciasOrdenadas.getListaOrdenada();
//            System.out.println("Size="+grupoDeDistanciasOrdenadas.getListaOrdenada().size());
for(int i=0;i<grupoDeDistanciasOrdenadas.ordenadas.size();i++)
{
    RsEtiquetas rsEtiquetas=grupoDeDistanciasOrdenadas.ordenadas.get(i);
    try
    {
//                  Etiqueta et=diccionario_de_etiquetas.get(i);
        if(diccionario_de_etiquetas.get(i).Nombre.equalsIgnoreCase(rsEtiquetas.Nombre)==false)
        {
            diccionario_de_etiquetas.add(rsEtiquetas);
        }
        diccionario_de_etiquetas.modificar(new RsEtiquetas(diccionario_de_etiquetas.get(i).Nombre, diccionario_de_etiquetas.get(i).getTodoElArray(),diccionario_de_etiquetas.get(i).veces+1,diccionario_de_etiquetas.get(i).distanciaGlobal));
//                  System.out.println(i+")Clasificando " + diccionario_de_etiquetas.get(i));

    }catch(Exception e)
    {
        try {
            diccionario_de_etiquetas.add(new RsEtiquetas(diccionario_de_etiquetas.get(i).Nombre, diccionario_de_etiquetas.get(i).getTodoElArray(),diccionario_de_etiquetas.get(i).veces+1,diccionario_de_etiquetas.get(i).distanciaGlobal));
        } catch (Exception  ex) {
//            Logger.getLogger(KNN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

diccionario_de_etiquetas.getRange(k);
return true;
             }} catch (Exception ex) {
             Logger.getLogger(KNN.class.getName()).log(Level.SEVERE, null, ex);
         }
        return false;
    }
    
}

/**
 * Diccionarios
 * @author Rafael
 */
class RsGrupoDeEtiquetas
{
    
    public RsGrupoDeEtiquetas()
    {
        System.err.println("Se debe simplificar este algoritmo.");
        
    }
    
    public ArrayList<RsEtiquetas> getRange(int k)
    {
        
        System.out.println("ordenadas.size() "+ordenadas.size());
        if(k>=ordenadas.size()){
            k=ordenadas.size()-1;
        }
        getListaOrdenada();
        ArrayList<RsEtiquetas> rsLocal=new ArrayList();
        for(int i=0; i<=k;i++)
        {
            try{
                rsLocal.add(ordenadas.get(i));
                System.out.println(ordenadas.get(i).Nombre);
            }catch(Exception e){}
            
        }
        return rsLocal;
    }
    
    public ArrayList<RsEtiquetas> getListaOrdenada()
    {
        RsEtiquetas []m=new RsEtiquetas[grupo.size()];
        for(int i=0; i<m.length; ++i)
        {
            m[i]=grupo.get(i);
//            System.out.println("setListaOrdenada "+etiquetas.get(i));
        }
        RsEtiquetas temp=null;
        for(int i=0; i<m.length; ++i)
        {
            for(int i1=0; i1<m.length; ++i1)
            {
                if(m[i].distanciaGlobal>m[i1].distanciaGlobal)
                {
                    temp=m[i];
                    m[i]=m[i1];
                    m[i1]=temp;
                }
            }
        }
        for(int i=0; i<m.length; ++i)
        {
            ordenadas.add(m[i]);
//            System.out.println("setListaOrdenada copiando ="+m[i].toString());
        }
        return ordenadas;
    }
    
    public ArrayList<RsEtiquetas>ordenadas=new ArrayList();
    
    public int size()
    {
        return grupo.size();
    }
    
    private ArrayList<RsEtiquetas> grupo=new ArrayList();
    public void add(RsEtiquetas unGrupo)
    {
        grupo.add(unGrupo);
    }
    
//    public class ErrObjetoNull extends Exception
//    {
//        public ErrObjetoNull()
//        {
//            super("El objeto es null y el arrayList no tiene items.");
//        }
//    }
    
    public RsEtiquetas get(int id) throws Exception
    {
        try{
            return grupo.get(id);
        }catch(Exception e)
        {
//            new Exception();
        }
        return null;
    }
    
    public RsEtiquetas get(String nombre)
    {
        for(int i=0; i<grupo.size(); i++)
        {
            if(grupo.get(i).Nombre.equalsIgnoreCase(nombre)==true)
            {
                return grupo.get(i);
            }
        }
        return null;
    }
    
    public RsEtiquetas get(RsEtiquetas newRsEtiquetas)
    {
        for(int i=0; i<grupo.size(); i++)
        {
            if(grupo.get(i).Nombre.equalsIgnoreCase(newRsEtiquetas.Nombre)==true)
            {
                return grupo.get(i);
            }
        }
        return null;
    }
    
    public void modificar(RsEtiquetas newRsEtiquetas)
    {
        for(int i=0; i<grupo.size(); i++)
        {
            if(grupo.get(i).Nombre.equalsIgnoreCase(newRsEtiquetas.Nombre)==true)
            {
                grupo.remove(i);
                grupo.add(newRsEtiquetas);
            }
        }
    }
}

class RsEtiquetas
{
    
    public int veces=0;
    
    public String Nombre="";
    
    private ArrayList<Etiqueta> etiquetas;//=new ArrayList<Etiqueta>();
    
    public ArrayList<Etiqueta> getTodoElArray()
    {
        return etiquetas;
    }
    
    public RsEtiquetas(String newNombre)
    {
        Nombre=newNombre;
         etiquetas=new ArrayList<Etiqueta>();
    }
    
    public double distanciaGlobal=0;
    public RsEtiquetas(String newNombre, ArrayList<Etiqueta> nuevas_etiquetas, int newVeces, double newDistanciaGlobal)
    {
        distanciaGlobal=newDistanciaGlobal;
        Nombre=newNombre;
        etiquetas=nuevas_etiquetas;
        veces=newVeces;
    }
    
    public int size()
    {
        return etiquetas.size();
    }
    
    public RsEtiquetas(ArrayList<Etiqueta> nuevas_etiquetas)
    {
        etiquetas=nuevas_etiquetas;
    }
    
    public void add(Etiqueta nueva_etiqueta)
    {
        etiquetas.add(nueva_etiqueta);
    }
    
    public Etiqueta get(int id)
    {
        try{
            return etiquetas.get(id);
        }catch(Exception e)
        {
            
        }
        return null;
    }
    

    
    public void setListaOrdenada()
    {
        Etiqueta []m=new Etiqueta[etiquetas.size()];
        for(int i=0; i<m.length; ++i)
        {
            m[i]=etiquetas.get(i);
//            System.out.println("setListaOrdenada "+etiquetas.get(i));
        }
        Etiqueta temp=null;
        for(int i=0; i<m.length; ++i)
        {
            for(int i1=0; i1<m.length; ++i1)
            {
                if(m[i].ValorDelNivel>m[i1].ValorDelNivel)
                {
                    temp=m[i];
                    m[i]=m[i1];
                    m[i1]=temp;
                }
            }
        }
        
        for(int i=0; i<m.length; ++i)
        {
            ordenadas.add(m[i]);
            System.out.println("setListaOrdenada copiando ="+m[i].toString());
        }
    }
    
    private ArrayList<Etiqueta> ordenadas=new ArrayList<Etiqueta>();
    
    /**
     * Primero debe llamar a setListaOrdenada().
     * @return Retorna un ArrayList ordenado.
     */
    public ArrayList<Etiqueta> getListaOrdenada()
    {
        return ordenadas;
    }
    
    /**
     * Coloca los datos ordenados en el ArrayList principal.
     */
    public void OrdenarDatosOriginales()
    {
        this.setListaOrdenada();
        this.etiquetas= ordenadas;
    }
    
    public void modificar(Etiqueta newEtiqueta)
    {
        if(this.get(newEtiqueta.id)!=null)
        {
            this.etiquetas.remove(newEtiqueta);
            etiquetas.add(newEtiqueta);
        }
    }
    
}

class Etiqueta{
    
    public int id=-1;
    
    public String toString()
    {
        return  ", valor " + ValorDelNivel + ", veces " + vecesQueAparese + ", id " + id;
    }
    
//    public String NombreDelNivel="";
    public double ValorDelNivel=0.0;
    public int vecesQueAparese=0;
    
    public Etiqueta( double newValorDelNivel, int new_Id)//, int newVeces)
    {
        id=new_Id;
        ValorDelNivel=newValorDelNivel;
//        this.ValorDelNivel=newVeces;
    }
    
}