/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabajosEnCosturas;

/**
 *
 * @author Jugador
 */
public class ModificarRsException  extends Exception{
    public ModificarRsException(){
        super("El registro no se pudo modificar con exito y por eso se retornó un null");
    }
}
