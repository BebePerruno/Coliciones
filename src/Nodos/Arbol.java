/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

import javax.swing.JOptionPane;

/**
 * Fecha de inicio del diseño miercoles 24 de agosto del 2022.
 * Fecha de finalizacion jueves 25 de agosto del 2022.
 * @author Rafael Angel Montero Fernpandez.
 * celular: +506 83942235
 * correo: rafaelangelmfx@gmail.com
 * 
 * Este tema de los nodos lo investigué como refuerzo de mis conocimientos.
 * 
 */
public class Arbol {
    private NodoBinario raiz=null;
    
    
    private NodoBinario buscarNodo(NodoBinario nueva_raiz, NodoBinario nodo_para_buscar){
       
        if(nueva_raiz!=null){
            buscarNodo(nueva_raiz.iz,nodo_para_buscar);
            buscarNodo(nueva_raiz.dr,nodo_para_buscar);
            if(nueva_raiz.numero==nodo_para_buscar.numero){
//                System.out.println("nodoEncontrado=" + nodoEncontrado.numero);
                return new NodoBinario(nueva_raiz.numero);
            }
        }
        return null;
    }
    
    public NodoBinario buscarNodo(NodoBinario nodo_para_buscar){
        NodoBinario raizLocal=raiz;
        return buscarNodo(raizLocal,nodo_para_buscar);
    }
    
    /**
     * Esta funcion es necesaria para validar los datos.
     * Se comprueva si ya existe un nodo.
     * @param nuevo_nodo Un nodo cargado, listo para ser agregado al arbol, pero antes se comprueva que no exista otro con el mismo valor.
     * @return Retorna true si existe otro igual y false si no existe otro nodo con ese valor.
     */
    private boolean esRepetido(NodoBinario nuevo_nodo){
        String []m={};
        recorrerInforme="";
        lista=new ListaDoblementeEnlazada();
        this.recorrerConListaEnlazada(raiz);
        m=recorrerInforme.split("_");
        for(String s:m){
            int x=Integer.parseInt(s);
            if(x==nuevo_nodo.numero){
//                System.out.println("Numero repetido " + x);
                return true;
            }
        }
        return false;
    }
    
    private String recorrerInforme="_";
    
    private ListaDoblementeEnlazada lista=null;
    
    private void recorrerConListaEnlazada(NodoBinario nueva_raiz){
        if(nueva_raiz==null){
            return;
        }
        else if(nueva_raiz!=null){
            lista.add(nueva_raiz);
            recorrerInforme+=nueva_raiz.numero+"_";
            recorrerConListaEnlazada(nueva_raiz.iz);
            recorrerConListaEnlazada(nueva_raiz.dr);
        }
    }
    
    public void recorrerConListaEnlazada(){
        
       lista=new ListaDoblementeEnlazada();
       recorrerConListaEnlazada(raiz);
        
        String report="";
        for(int i=1; i<=lista.Size();++i){
            report+="Valor del nodo "+lista.get(i).numero + "\n";
        }
        System.out.println(report);
    }
    
    /**
     * Contiene el algoritmo correcto para insertar un nodo.
     * @param nueva_raiz Solo se le pasa el nodo raiz del arbol.
     * @param nuevo_nodo Un nodo incializado con datos.
     */
    private void insertarUnNodo(NodoBinario nueva_raiz, NodoBinario nuevo_nodo){
        if(raiz==null){
            raiz=new NodoBinario(nuevo_nodo.numero);
        }
        else{
            
            if(nueva_raiz.iz!=null){
                insertarUnNodo( nueva_raiz.iz, nuevo_nodo);
            }else{
                if(nuevo_nodo.numero<nueva_raiz.numero){
                    if(esRepetido(nuevo_nodo)==false){
                    nueva_raiz.iz=new NodoBinario(nuevo_nodo.numero);
                    }
                }
            }
            if(nueva_raiz.dr!=null){
                insertarUnNodo( nueva_raiz.dr, nuevo_nodo);
            }else{
                if(nuevo_nodo.numero>nueva_raiz.numero){
                    if(esRepetido(nuevo_nodo)==false){
                    nueva_raiz.dr=new NodoBinario(nuevo_nodo.numero);
                    }
                }
            }
        }
    }
    
    public void insertar( NodoBinario nuevo_nodo){
        
        insertarUnNodo(raiz,nuevo_nodo);
//        raiz=insertar(raiz,nuevo_nodo);
    }
    
    private NodoBinario eliminarDosNodos(NodoBinario nueva_raiz, NodoBinario raiz_temporal){
        if(nueva_raiz.dr!=null){
            nueva_raiz=eliminarDosNodos(nueva_raiz.dr, raiz_temporal);
        }
        else if(nueva_raiz.dr==null){
            /**
             * Carga la variable raiz_temporal con los datos del nodo actual.
             */
            raiz_temporal.numero=nueva_raiz.numero;
            nueva_raiz=nueva_raiz.iz; //Avanza al siguiente nodo izquierdo.
        }
        return nueva_raiz;
    }
    
    private NodoBinario eliminarUnNodo(NodoBinario nueva_raiz, NodoBinario nuevo_nodo){
        if(nueva_raiz!=null){
            if(nuevo_nodo.numero<nueva_raiz.numero){
                nueva_raiz.iz=eliminarUnNodo(nueva_raiz.iz,nuevo_nodo);
            }
            else if(nuevo_nodo.numero>nueva_raiz.numero){
                nueva_raiz.dr=eliminarUnNodo(nueva_raiz.dr,nuevo_nodo);
            }
            else if(nuevo_nodo.numero==nueva_raiz.numero){
                NodoBinario nodoRaizTemporal=nueva_raiz;
                if(nueva_raiz.iz==null){
                    nueva_raiz=nueva_raiz.dr;
                }
                else if(nueva_raiz.dr==null){
                    nueva_raiz=nueva_raiz.iz;
                }
                else{
                    //Situacion en la que puede eliminar un solo nodo y se desea reordenar la rama derecha y la izquierda al mismo tiempo.
                    //Solo para el nodo izquierdo.
                    nueva_raiz=eliminarDosNodos(nueva_raiz.iz, nodoRaizTemporal);
                }
            }
        }
        return nueva_raiz;
    }
    
    
    public void eliminarUnNodo(NodoBinario nodo_a_eliminar){
        raiz=eliminarUnNodo(raiz, nodo_a_eliminar);
    }
    
    
    private boolean estaOrdenado(NodoBinario nueva_raiz, int valor){
        boolean respuesta=false;
        if(nueva_raiz!=null){
            respuesta=true;
            return respuesta;
        }
        else if(nueva_raiz==null){
            respuesta=estaOrdenado(nueva_raiz.iz,valor);
//            if(es_el_primer_nodo==true){
//                es_el_primer_nodo=false;
//            }
            
            if(nueva_raiz.numero<valor){
                respuesta=false;
            }
            
            if(respuesta==true){
                valor=nueva_raiz.numero;
                respuesta=estaOrdenado(nueva_raiz.dr,valor);
            }
        }
        return respuesta;
    }
    
    public boolean estaOrdenado(){
        int valor=0;
        return estaOrdenado(raiz, valor);
    }
    
    /**
     * Se usa en getTodos_los_datos.
     */
    private String todos_los_datos="";
    
    private String getTodos_los_datos(NodoBinario nueva_raiz, int contador, boolean obtener_datos_de_izquierda_a_derecha){
        if(nueva_raiz!=null)
        {
           this.todos_los_datos+= "Valor del nodo \n" + nueva_raiz.numero + "\nEstos datos fueron encontrados en el nivel " + contador + "\n";
           if(obtener_datos_de_izquierda_a_derecha==true)
           {
               //Las llamadas recursivas empiezan por la izquierda.
                this.getTodos_los_datos(nueva_raiz.iz, contador+1,obtener_datos_de_izquierda_a_derecha);
                this.getTodos_los_datos(nueva_raiz.dr, contador+1,obtener_datos_de_izquierda_a_derecha);
           }
           else if(obtener_datos_de_izquierda_a_derecha==false)
           {
               //Las llamadas recursivas empiezan por la derecha.
               this.getTodos_los_datos(nueva_raiz.dr, contador+1,obtener_datos_de_izquierda_a_derecha);
               this.getTodos_los_datos(nueva_raiz.iz, contador+1,obtener_datos_de_izquierda_a_derecha);
           }
        }
        return todos_los_datos;
    }
    
    public enum IzquierdaDerecha{
        comenzar_por_la_izquierda, comenzar_por_la_derecha
    }
    
    public String informe(IzquierdaDerecha por_cual_orden_quiere_comenzar ){
        todos_los_datos="";
        int contador =0;
        boolean obtener_datos_de_izquierda_a_derecha=false;
        if(por_cual_orden_quiere_comenzar==IzquierdaDerecha.comenzar_por_la_izquierda){
            obtener_datos_de_izquierda_a_derecha=true;
        }
        else if(por_cual_orden_quiere_comenzar==IzquierdaDerecha.comenzar_por_la_derecha){
            obtener_datos_de_izquierda_a_derecha=false;
        }
        return getTodos_los_datos(raiz, contador, obtener_datos_de_izquierda_a_derecha);
    }
    
    private String preOrdenDatos="";
    private String preOrden(NodoBinario nueva_raiz){
        if(nueva_raiz==null){
            return "";
        }
        else if(nueva_raiz!=null){
            preOrdenDatos+="Valor del nodo " + nueva_raiz.numero+"\n";
            preOrden(nueva_raiz.iz);
            preOrden(nueva_raiz.dr);
        }
        return preOrdenDatos;
    }
    
    public String preOrden(){
        preOrdenDatos="Informe en PreOrden\n";
        return this.preOrden(raiz);
    }
    
    private String postOrdenDatos="";
    private String postOrden(NodoBinario nueva_raiz){
        if(nueva_raiz==null){
            return "";
        }
        else if(nueva_raiz!=null){
            postOrden(nueva_raiz.iz);
            postOrden(nueva_raiz.dr);
            postOrdenDatos+="Valor del nodo " + nueva_raiz.numero + "\n";
        }
        return postOrdenDatos;
    }
    
    public String postOrden(){
        postOrdenDatos="Informe en PostOrden\n";
        return this.postOrden(raiz);
    }
    
    private String inordenDatos="";
    private String inorden(NodoBinario nueva_raiz){
        if(nueva_raiz==null){
            return "";
        }
        else if(nueva_raiz!=null){
            inorden(nueva_raiz.iz);
            inordenDatos+="Valor del nodo " + nueva_raiz.numero + "\n";
            inorden(nueva_raiz.dr);
        }
        return inordenDatos;
    }
    
    public String inorden(){
        inordenDatos="Informe en orden central\n";
        
        return this.inorden(raiz);
    }
    
    public String ordenCentral(){
        inordenDatos="";
        return this.postOrden(raiz);
    }
    
    private int alturaDelArbol(NodoBinario nueva_raiz){
        int altura_dr=(nueva_raiz==null?0:1+alturaDelArbol(nueva_raiz.dr));
        int altura_iz=(nueva_raiz==null?0:1+alturaDelArbol(nueva_raiz.iz));
        return Math.max(altura_dr, altura_iz);
    }
    
    public int alturaDelArbol(){
        return alturaDelArbol(raiz);
    }
    
    private String anchuraInforme_del_recorrido="";
    private Cola cola=null;
    private void anchuraInforme(NodoBinario nueva_raiz){
        if(nueva_raiz==null){
            return;
        }
        else if(nueva_raiz!=null){
            
//            if(nueva_raiz.iz!=null){
            anchuraInforme(nueva_raiz.iz);
//            }
//            if(nueva_raiz.dr!=null){
            anchuraInforme(nueva_raiz.dr);
//            }
            cola.insertar_al_final(new NodoBinario(nueva_raiz.numero));
//            System.out.println("Anchura " + nueva_raiz.numero);
        }
    }
    
    public String anchuraInforme(){
        anchuraInforme_del_recorrido="Informe en anchura\n";
        cola=new Cola();
        cola.insertar_al_final(raiz);
        anchuraInforme(raiz);
        while(cola.esVacia()!=true){
            cola.eliminar_primer_nodo();
            anchuraInforme_del_recorrido+=cola.extraerPrimerNodo().numero + "\n";
            cola.eliminar_primer_nodo();
        }
        
        return anchuraInforme_del_recorrido;
    }
    
}

class NodoBinario{
    public boolean esPrimerNodo;
//    private Cola cola=new Cola();
    public NodoBinario iz=null;
    public NodoBinario dr=null;
    
    public int numero;
    
    public NodoBinario(int nuevo_numero){
        numero=nuevo_numero;
    }
    
    
}
 
class Cola{
    public NodoBinario primerNodo=null;
    public NodoBinario ultimoNodo=null;
    public String nombre="";
    
    public Cola(){
        this("Lista vacia");//Forma de llamar otro constructor con parametros desde uno diferente como uno sin parametros.
    }
    
    public Cola(String nuevo_nombre_de_la_cola){
        nombre=nuevo_nombre_de_la_cola;
    }
    
    public boolean esVacia(){
        return this.primerNodo==null;
    }
    
    public void insertar_al_inicio(NodoBinario nuevoNodoBinario){
        if(this.esVacia()==true){
            primerNodo=nuevoNodoBinario;//new NodoBinario(nuevoNodoBinario.numero);
            ultimoNodo=nuevoNodoBinario;//new NodoBinario(nuevoNodoBinario.numero);
        }
        else{
            NodoBinario recorrido=primerNodo;
            primerNodo=new NodoBinario(nuevoNodoBinario.numero);
            primerNodo.dr=recorrido;
            //Colocando el ultimo.
            recorrido=primerNodo;
            while(recorrido!=null){
                if(recorrido.dr!=null){
                    recorrido=recorrido.dr;
                }else{
                   ultimoNodo =new NodoBinario(recorrido.numero);
                } 
            }
        }
    }
    
    public void insertar_al_final(NodoBinario nuevoNodoBinario){
        if(this.esVacia()==true){
            primerNodo=nuevoNodoBinario;//new NodoBinario(nuevoNodoBinario.numero);
            ultimoNodo=nuevoNodoBinario;//new NodoBinario(nuevoNodoBinario.numero);
        }
        else{
            NodoBinario recorrido=primerNodo;
            while(recorrido!=null){
                if(recorrido.dr!=null){
                    recorrido=recorrido.dr;
                }else{
                   recorrido.dr=new NodoBinario(nuevoNodoBinario.numero);
                   break;
                } 
            }
//            this.primerNodo=recorrido;
            ultimoNodo=new NodoBinario(nuevoNodoBinario.numero);
        }
//        else{
//            ultimoNodo=new NodoBinario(nuevoNodoBinario.numero);
//        }
    }
    
    public NodoBinario extraerPrimerNodo(){
        if(this.esVacia()==true){
//            JOptionPane.showConfirmDialog(null, "La accion de extraer no es necesaria porque la cola esta vacia.");
        }
        else{
            NodoBinario respuesta=new NodoBinario(primerNodo.numero);
            if(primerNodo.dr==null){
                this.ultimoNodo=primerNodo.dr;
                
            }
//            else{
                primerNodo=primerNodo.dr;
//            }
            
            return respuesta;
        }
        return primerNodo;
    }
    
    public void eliminar_primer_nodo(){
        if(this.esVacia()==true){
//            JOptionPane.showConfirmDialog(null, "La accion de eliminar no es necesaria porque la cola esta vacia.");
        }
        else{
            NodoBinario temp=primerNodo.dr;
            primerNodo=temp;
        }
    }
    
    public void eliminar_ultimo_nodo(){
        if(this.esVacia()==true){
            JOptionPane.showConfirmDialog(null, "La accion de eliminar no es necesaria porque la cola esta vacia.");
        }
        else{
            NodoBinario recorrido=primerNodo;
            while(recorrido!=ultimoNodo){
                if(recorrido.dr!=null){
                    if(recorrido.dr==ultimoNodo){
                        ultimoNodo=recorrido; //Nuevo ultimo nodo.
                        recorrido.dr=null;//Se elimina el ultimo de la cola.
                        break;
                    }
                }
            }
        }
    } 
}

class MainArbol{
    public static void main(String []m){
        Arbol a=new Arbol();
//        NodoBinario nodo=new NodoBinario(1);
        a.insertar(new NodoBinario(1));
        a.insertar(new NodoBinario(2));
        a.insertar(new NodoBinario(3));
        a.insertar(new NodoBinario(5));
        a.insertar(new NodoBinario(8));
        a.insertar(new NodoBinario(7));
        a.insertar(new NodoBinario(4));
//       ListaDoblementeEnlazada ld=new ListaDoblementeEnlazada();
//       ld.add(new NodoBinario(1));
//        ld.add(new NodoBinario(2));
//        ld.add(new NodoBinario(3));
//        ld.add(new NodoBinario(5));
//        ld.add(new NodoBinario(8));
//        ld.add(new NodoBinario(7));
//        ld.add(new NodoBinario(4));
//        System.out.println(ld.toString());
        System.out.println(a.anchuraInforme());
    }
}

class ListaDoblementeEnlazada {
        
    private int size=0;
    
    public int Size(){
        return size;
    }
    
   private NodoBinario lista=null;

   public boolean eliminar(NodoBinario nodo_para_buscar){
       NodoBinario listaLocal=lista;
       if(size==1){
          if(listaLocal.numero==nodo_para_buscar.numero){
              listaLocal=null;
              size=0;
              return true;
          }  
       }
        while(listaLocal!=null){
          if(listaLocal.numero==nodo_para_buscar.numero){
              listaLocal=listaLocal.iz;
              size--;
              return true;
          }  
            listaLocal=listaLocal.dr;
        }
        return false;
   }

   public boolean existe(NodoBinario nodo_para_buscar){
       NodoBinario listaLocal=lista;
        while(listaLocal.dr!=null){
          if(listaLocal.numero==nodo_para_buscar.numero){
              return true;
          }  
            listaLocal=listaLocal.dr;
        }
        return false;
   }
   
   /**
    * Hace un conteo hasta que encuentra el que es de acuerdo al id.
    * @param id
    * @return 
    */
   public NodoBinario get(int id){
       NodoBinario listaLocal=lista;
       int cont=1;
        while(listaLocal!=null){
          if(cont==id){
              return new NodoBinario(listaLocal.numero);
          }  
            listaLocal=listaLocal.dr;
            cont++;
        }
        return null;
   }

   public NodoBinario get(NodoBinario nodo_para_buscar){
       NodoBinario listaLocal=lista;
        while(listaLocal!=null){
          if(listaLocal.numero==nodo_para_buscar.numero){
              return new NodoBinario(listaLocal.numero);
          }  
            listaLocal=listaLocal.dr;
        }
        return null;
   }

   public void clear(){
       lista=null;
   }

    public void add(NodoBinario nuevoNodoBinario){
        if(lista==null){
           lista=new NodoBinario(nuevoNodoBinario.numero);
           size=1;
           return ;
       }
        NodoBinario listaLocal=lista;
        boolean parar=false;
        while(parar!=true){
            if(listaLocal!=null){
                if(listaLocal.dr!=null){
                    listaLocal=listaLocal.dr;
                }else{
                    listaLocal.iz=listaLocal;
                    listaLocal.dr=new NodoBinario(nuevoNodoBinario.numero);
                    size++;
                    parar=true;
                }
            }
            else{
                parar=true;
            }
        }
    }

   @Override
    public String toString(){
        String informe="";
        NodoBinario listaLocal=lista;
        while(listaLocal!=null){
//                if(listaLocal.dr!=null){
                informe+="Nodo= " + listaLocal.numero + "\n";
//                }
            listaLocal=listaLocal.dr;
        }
        return informe;
    }

}

/**
 * En una pila el primero en entrar es el ultimo en salir y 
 * el ultimo en entrar es el primero en salir.
 * Finalmente Pila es lo mismo que stack.
 * @author Rafae
 */
class Pila{
    
    /**
     * Es el nodo pila.
     */
    private NodoBinario pila=null;
    
    /**
     * Contador de pila para determinar la catidad o tamaño de la pila.
     */
    private int size=0;
    
    /**
     * 
     * @return Retorna el tamaño de la pila.
     */
    public boolean esVacio(){
        return size==0;
    }
    
    /**
     * Agrega un nodo al final de la pila.
     * @param nuevo_nodo Nuevo nodo inicializado.
     * @return Retorna el ultimo nodo que se agregó.
     */
    public NodoBinario add(NodoBinario nuevo_nodo){
        NodoBinario ultimoEnLlegar=null;
        NodoBinario pilaLocal=pila;
        while(pilaLocal!=null){
            if(pilaLocal.dr!=null){
                pilaLocal=pilaLocal.dr;
            }else{
                pilaLocal.dr=nuevo_nodo;
                size++;
                ultimoEnLlegar=pilaLocal.dr;
            }
        }
       return ultimoEnLlegar; 
    } 
    
    /**
     * En una pila el ultimo en llegar es el primero en salir.
     * @param nueva_pila Se le pasa el nodo pila.
     * @return Retorna el ultimo item agregado.
     */
    private NodoBinario verItem(NodoBinario nueva_pila){
        NodoBinario ultimoEnLlegar=null;
        if(nueva_pila.dr!=null){
            verItem(nueva_pila.dr);
        }else{
            ultimoEnLlegar= nueva_pila;
        }
       return ultimoEnLlegar; 
    }
    
    /**
     * En una pila el ultimo en llegar es el primero en salir.
     * @return Retorna el ultimo item agregado.
     */
    public NodoBinario verItem(){
        return verItem(pila);
    }
    
    /**
     * En una pila el ultimo en llegar es el primero en salir.
     * @param nueva_pila Se le pasa el nodo pila.
     * @return Retorna el ultimo item agregado.
     */
    private NodoBinario extraerItem(NodoBinario nueva_pila){
        NodoBinario ultimoEnLlegar=null;
        if(nueva_pila.dr!=null){
            verItem(nueva_pila.dr);
        }else{
            ultimoEnLlegar= nueva_pila;
            size--;
            nueva_pila=null;
        }
       return ultimoEnLlegar; 
    }
    
    /**
     * En una pila el ultimo en llegar es el primero en salir.
     * @return Retorna el ultimo item agregado.
     */
    public NodoBinario extraerItem(){
        return extraerItem(pila);
    }
    
    /**
     * Busca en la pila de nodos y si encuentra el item buscado entonces retorna la distancia a la 
     * que esta del ultimo nodo.
     * @param nuevo_nodo_a_buscar Un nodo inicializado con datos existentes en la pila.
     * @return Retorna la distancia que hay del nodo buscado al ultimo nodo.
     */
    public int buscar(NodoBinario nuevo_nodo_a_buscar){
        if(size==0){
            return 0;
        }
        NodoBinario pilaLocal=pila;
        int cont=0;
        
        while(pilaLocal!=null){
            if(pilaLocal.numero==nuevo_nodo_a_buscar.numero){
                return size-cont;
            }
            
            if(pilaLocal.dr!=null){
                cont++;
                pilaLocal=pilaLocal.dr;
            }else{
                return 0;
            }
        }
        return 0;
    }
    
    
}