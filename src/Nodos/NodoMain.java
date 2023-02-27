/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

/**
 *
 * @author Rafae
 */
public class NodoMain {
    public static void main(String []m){
        Nodo unNodo;
        ListaDoblementeEnlazadaDeNodos nodos=new ListaDoblementeEnlazadaDeNodos();
        unNodo=new Nodo();
        unNodo.setId(1);
        unNodo.setNombre("Rafael");
        unNodo.setValor(44);
        nodos.agregarAnterior(unNodo);
        
        unNodo=new Nodo();
        unNodo.setId(2);
        unNodo.setNombre("Xinia");
        unNodo.setValor(45);
        nodos.agregarAnterior(unNodo);
        
        unNodo=new Nodo();
        unNodo.setId(3);
        unNodo.setNombre("Katy");
        unNodo.setValor(24);
        nodos.agregarAnterior(unNodo);
        
        System.out.println(nodos.toString());
        
        nodos=new ListaDoblementeEnlazadaDeNodos();
        
        unNodo=new Nodo();
        unNodo.setId(1);
        unNodo.setNombre("Rafael");
        unNodo.setValor(44);
        nodos.agregarSiguiente(unNodo);
        
        unNodo=new Nodo();
        unNodo.setId(2);
        unNodo.setNombre("Xinia");
        unNodo.setValor(45);
        nodos.agregarSiguiente(unNodo);
        
        unNodo=new Nodo();
        unNodo.setId(3);
        unNodo.setNombre("Katy");
        unNodo.setValor(24);
        nodos.agregarSiguiente(unNodo);
        System.out.println(nodos.toString());
    }
}
