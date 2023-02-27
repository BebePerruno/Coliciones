/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 * El arfil, la reina y el rey pueden moverse en diagonales.
 */
public interface Diagonales {
    /**
     * Permite que el tablero consulte el class descendiente para saber cuantas
     * casillas puede moverse.
     * @return 
     */
    public int getCantidadDePasosPorLaDiagonal();
}
