/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juegoConJLabels;

import javax.swing.JLabel;

/**
 *
 * @author Jugador
 */
public interface iVer <plantilla>{

    /**
     * Permite detectar objetos cercanos.
     * Es lo mismo que la colision simplemente se crea un label invisible que funciona como rango de vision.
     * Importante esta funcion no es colision es un sensor para indicarle a la unidad que se acerca a un objeto.
     * @param mObjetos_cercanos Un matriz de controles JLabels.
     * @return Retorna true si detecta un objeto.
     */
    boolean VerObjetos(plantilla[] mObjetos_cercanos);
    
    boolean VerObjeto(plantilla objeto_cercano);
    
}
