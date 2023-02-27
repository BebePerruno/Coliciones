/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 * El peon, el rey, la torre, la reina se pueden mover por filas y columnas.
 * Nota, la reina tambien puede moverse en diagonales y en algunos manuales 
 * indica que tambien puede realizar el movimiento del caballo pero mejor lo investigo.
 * El rey tambien puede moverse en todas las direcciones pero solo una casilla a la vez.
 * 
 */
public interface MoversePorFilasColumnas {
    
    /**
     * Permite que el tablero consulte el class descendiente para saber cuantas
     * casillas puede moverse.
     * @return 
     */
    public int getCantidadDepasosPorFila();
    /**
     * Permite que el tablero consulte el class descendiente para saber cuantas
     * casillas puede moverse.
     * @return 
     */
    public int getCantidadDePasosPorColumna();
   public void movimiento(int id_fila, int id_columna);
    public void irAbajo(int id_fila, int id_columna);
    public void irArriba(int id_fila, int id_columna);
    public void irAdelante(int id_fila, int id_columna);
    public void irAtras(int id_fila, int id_columna);
    public void irDiagonalAbajo(int id_fila, int id_columna);
    public void irDiagonalArriba(int id_fila, int id_columna);
    public void irDiagonalAtras(int id_fila, int id_columna);
    public void irDiagonalAdelante(int id_fila, int id_columna);
}
