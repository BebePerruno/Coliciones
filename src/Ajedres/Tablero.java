/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 * El tablero consulta las unidades para saber cuantas casillas puede moverse
 * cada unidad.
 * En el caso de la reina, la torre y el arfil esto no aplica ya que
 * dichas unidades pueden moverse una casilla o muchas, hasta el limine maximo o minimo del tablero.
 */
public class Tablero {
    public Casilla [][]mTablero=new Casilla[8][8];
    
    public Tablero(){
        for(int f=0; f<this.mTablero.length; ++f){
            for(int c=0; c<this.mTablero.length; ++c){
                mTablero[f][c]=new Casilla(f,c);
            }
        }
    }
    
}
