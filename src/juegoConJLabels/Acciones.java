/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juegoConJLabels;

/**
 *
 * @author Jugador
 */
public interface Acciones <Plantilla>{
    public void crearUnidad();
    public void crearEdificio();
    public void moverse();//(plantilla nuevo);
    public void diferentesAcciones();
    public boolean validarColision(Plantilla nuevo);
}
