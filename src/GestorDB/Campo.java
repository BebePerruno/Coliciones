/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorDB;

/**
 *
 * @author Jugador
 */
public class Campo<Plantilla> {
    private String nombreDelCampo="";
    
    public void setNombreDelCampo(String nuevo_nombre){
        nombreDelCampo=nuevo_nombre;
    }
    public String getNombreDelCampo(){
        return nombreDelCampo;
    }
    
    /**
     * Debe convertirse en un arraylist
     */
    private Plantilla datosDelCampo;
    
    public void setDatosDelCampo(Plantilla nuevos_datos){
        datosDelCampo=nuevos_datos;
    }
    public Plantilla getDatosDelCampo(){
        return datosDelCampo;
    }
    
}
