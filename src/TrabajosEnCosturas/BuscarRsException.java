/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabajosEnCosturas;

/**
 *
 * @author Jugador
 */
public class BuscarRsException extends Exception{
    public BuscarRsException(){
        super("El registro no existe y por eso se retornó un null");
    }
}
