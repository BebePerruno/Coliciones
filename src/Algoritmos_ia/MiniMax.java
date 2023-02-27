/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

/**
 *El algoritmo minimax realiza una exploración primero en profundidad completa del arbol de juegos.
 * @author Rafael
 */
public interface MiniMax {
    /**
     * Retorna alguna accion.
     * @param estado Estado actual del juego, no necesariamente debe ser un booleano.
     * Puede ser un objeto de algun class personalizado.
     */
    public JugadorMiniMax decisionMiniMax(JugadorMiniMax estado);
    
    /**
     * 
     * @param estado Algun objeto que represente el estado del juego.
     * @return Devuelve un valor utilidad.
     */
    public int maxValor(JugadorMiniMax estado);
    
    public boolean testAccionTerminal(JugadorMiniMax estado);
    
    public int max(int nuevo_valor_del_nodo_actual, int nuevo_valor_minimo_del_sucesor);
    
    public int minValor(JugadorMiniMax nuevo_sucesor);
    
}

class JugadorMiniMax{
    public int valor=0;
    
    public NombreMaxMin nombre;
}

enum NombreMaxMin{
    Min,Max
}