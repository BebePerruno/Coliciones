/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

/**
 *
 * @author Rafael Angel Montero Fernández.
 * Correo rafaelangelmfx@gmail.com
 * Celular de Costa Rica +506 83942235
 * 
 * Basado en http://codigolibre.weebly.com/blog/listas-simples-en-java
 */
public class ListaDoblementeEnlazadaDeNodos {
    
    private  Nodo ListaDeNodos=null;
    
    
    public void eliminarListaDeNodos(){
        // Elimina el valor y la referencia a los demas nodos.
        ListaDeNodos = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamaño = 0;
    }
    
    /**
     * Consulta si el valor de referencia existe en la lista.
     * @param referencia 
     */
    public void removerPorReferencia(Nodo referencia){
        
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (ListaDeNodos.getNombre().equalsIgnoreCase(referencia.getNombre())==true ) {
                // El primer nodo apunta al siguiente.
                ListaDeNodos = ListaDeNodos.siguiente;
            } else{
                // Crea ua copia de la lista.
                Nodo aux = ListaDeNodos;
                // Recorre la lista hasta llegar al nodo anterior 
                // al de referencia.
                while(aux.getNombre().equalsIgnoreCase(referencia.getNombre())!=true){
                    aux = aux.siguiente;
                }
                // Guarda el nodo siguiente del nodo a eliminar.
                Nodo siguiente = aux.siguiente.siguiente;
                // Enlaza el nodo anterior al de eliminar con el 
                // sguiente despues de el.
                aux.siguiente=siguiente;  
            }
            // Disminuye el contador de tamaño de la lista.
            tamaño--;
        }
    }
    
    public void editarPorReferencia(Nodo referencia, Nodo nuevo_nodo){
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)==true) {
            // Crea ua copia de la lista.
            Nodo aux = ListaDeNodos;
            // Recorre la lista hasta llegar al nodo de referencia.
            while(aux.getNombre().equalsIgnoreCase(referencia.getNombre())==false){
                aux = aux.siguiente;
            }
            // Actualizamos el valor del nodo
            aux.setNombre(referencia.getNombre());
            aux.setValor(referencia.getValor());
            aux.setId(referencia.getId());
        }
    }
    
    /**
     * throw new Exception("Posicion inexistente en la lista."); Se usa para lanzar errores personalizados.
     * @param nuevo_nodo
     * @return 
     */
    public Nodo getValor(Nodo nuevo_nodo){
        try{
             // Crea una copia de la lista.
            Nodo aux = ListaDeNodos;
            // Recorre la lista hasta la posición ingresada.
            if(buscar(nuevo_nodo)==true){
                for (int i = 0; i < posicion; i++) {
                    aux = aux.siguiente;
                }
                return aux;
            }
        }catch(Exception e){
            
        }
           return new Nodo();
    }
    
    /**
     * busca por nombre.
     * @param nombre recive un String como parametro.
     * @return Retorna el Nodo consultado con datos completos.
     */
    public Nodo getValor(String nombre){
        try{
            Nodo aux = ListaDeNodos;
            Nodo nodo_consulta=new Nodo();
            nodo_consulta.setNombre(nombre);
            if(buscar(nodo_consulta)==true){
                for (int i = 0; i < posicion; i++) {
                    aux = aux.siguiente;
                }
                return aux;
            }
        }catch(Exception e){
            
        }
           return new Nodo();
    }
    
    public boolean estaBacio(){
        return ListaDeNodos==null;
    }
    
    private int tamaño=0;
    public int getTamaño(){
        return tamaño;
    }
    
    public void agregarSiguiente(Nodo nuevo_nodo){
        Nodo nodoTemporal=null;
        
        if(estaBacio()==true){
            ListaDeNodos=nuevo_nodo;
        }else{
            nodoTemporal=ListaDeNodos;
            tamaño=0;
            while(nodoTemporal.siguiente!=null){
                nodoTemporal=nodoTemporal.siguiente;
                tamaño++;
            }
//            nuevo_nodo.setId(tamaño);
            nodoTemporal.siguiente=nuevo_nodo;
        }
        
    }
    
    public void agregarAnterior(Nodo nuevo_nodo){
        if (this.estaBacio()==true) {
            ListaDeNodos = nuevo_nodo;
        } else{
            nuevo_nodo.siguiente=ListaDeNodos;
            ListaDeNodos = nuevo_nodo;
            //Por alguna extraña razon queda de siguiente.
//            System.out.println("agregarAnterior sigueinte= " + ListaDeNodos.siguiente.getNombre());
        }
        tamaño++;
    }
    /**
     * !estaBacio() si es false lo convierte en true y si es true lo convierte en false.
     * @param referencia
     * @param nuevo_nodo 
     */
    public void insertarPorReferencia(Nodo nodo_de_referencia, Nodo nuevo_nodo){
        if (estaBacio()==false) {
            if (buscar(nodo_de_referencia)==true) {
                Nodo aux = ListaDeNodos;
                while (aux.getNombre().equalsIgnoreCase(nodo_de_referencia.getNombre())==false) {
                    System.out.println("Buscando en insertarPorReferencia");
                    aux = aux.siguiente;
                }
                Nodo continuacion = aux.siguiente;
                aux.siguiente=nuevo_nodo;
                nuevo_nodo.siguiente=continuacion;
                tamaño++;
            }
        }
    }
    
    private int posicion=0;
    
    public boolean buscar(Nodo referencia){
        posicion=0;
        Nodo aux = ListaDeNodos;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia.getNombre().equalsIgnoreCase(aux.getNombre()) ==true){
                encontrado = true;
                return encontrado;//Detiene el recorrido aqui antes que incremente al contador "posicion"
            }
            else{
                aux = aux.siguiente;
            }
            posicion++;
        }
        return encontrado;
    }
    
    @Override
    public String toString(){
        Nodo aux = ListaDeNodos;
        String informe="Datos de los nodos\n\n\n";
        try{
            boolean encontrado = false;
            while(aux != null && encontrado != true){
                informe+=aux.toString() +"\n";
                aux = aux.siguiente;
            }
        }catch(Exception e){
            
        }
        return informe;
    }
    
}
