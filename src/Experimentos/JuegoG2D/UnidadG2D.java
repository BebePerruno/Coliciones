/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.JuegoG2D;

/**
 *
 * @author Rafael
 */
public class UnidadG2D  extends UnidadAbstracta{
    public String nombre="";
    public int puntos_de_vida;
    public int felicidad=100;
    
    public UnidadG2D(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros, int nueva_posicion_x_final, int nueva_posicion_y_final){
        super( nueva_posicionX,  nueva_posicionY,  nuevo_contador_de_cuadros,nueva_posicion_x_final,nueva_posicion_y_final);
    }
    
    public UnidadG2D(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros,int nuevo_width, int nuevo_heigth, int cantidad_de_filas, int cantidad_de_columnas){
        super( nueva_posicionX,  nueva_posicionY,  nuevo_contador_de_cuadros, nuevo_width,  nuevo_heigth,  cantidad_de_filas, 
                cantidad_de_columnas);
    }
}
