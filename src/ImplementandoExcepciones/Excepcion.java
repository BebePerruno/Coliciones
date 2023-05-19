/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ImplementandoExcepciones;

/**
 * Heredar de este class permite personalizar las excepciones en las implementaciones.
 * @author Jugador
 */
public class Excepcion extends RuntimeException{
    public Excepcion(){
        super("Debes colocar codigo aqui.");
    }
}

abstract class SerVivo{
    public abstract boolean vive() ;
}

class Gato extends SerVivo{

    @Override
    public boolean vive() {
        throw new Excepcion();
    }

}