/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 * Propiedades comunes a todos los descendientes.
 * Esto indica que cada unidad poseerá una copia del tablero y que cada unidad 
 * actuara a modo de un cliente y el tablero definitivo a modo de servidor.
 * 
 */
public abstract class Ancestro extends Casilla{
    
        
    public Ancestro(int nueva_fila, int nueva_columna){
        super(nueva_fila, nueva_columna);
    }
    
    private boolean unidadSeleccionada;
    
    public void setUnidadSeleccionada(boolean esta_seleccionada){
        unidadSeleccionada=esta_seleccionada;
    }
    public boolean getUnidadSeleccionada(){
        return unidadSeleccionada;
    }
    
    public Ancestro(){
        
    }
    
    public Ancestro(TipoDeUnidad nuevoTipoDeUnidad)
    {
        //Como las propiedades se heredan y hasta se pueden redefinir entonces 
        //el constructor carga directamente en la propiedad en lugar de la variable.
        setTipoDeUnidad( nuevoTipoDeUnidad);
    }
    
    
    
//    /**
//     * Cantidad de estas unidades vivas en el tablero.
//     */
//    private int cantidadDeUnidades=0;
//    
//    public void setCantidadDeUnidades(int nuevaCantidadDeUnidades){
//        cantidadDeUnidades=nuevaCantidadDeUnidades;
//    }
//    public int getCantidadDeUnidades(){
//        return cantidadDeUnidades;
//    }
    
    public enum ColorElegido{
        blanco, negro;
    }
    
    private ColorElegido colorDeLaCasilla=null;
    
    public void SetColorDeLaCasilla(ColorElegido nuevoColorDeLaCasilla){
        colorDeLaCasilla=nuevoColorDeLaCasilla;
    }
    public ColorElegido getColorDeLaCasilla(){
        return colorDeLaCasilla;
    }
            
    private ColorElegido colorDeLaUnidad=null;
    
    public void SetColorDeLaUnidad(ColorElegido nuevoColorDeLaUnidad){
        colorDeLaUnidad=nuevoColorDeLaUnidad;
    }
    public ColorElegido getColorDeLaUnidad(){
        return colorDeLaUnidad;
    }
    
    
    @Override
    public String toString(){
        return "Jugador al mando " + this.getJugadorAlMando() + ", tipo de unidad " + 
                this.getTipoDeUnidad() +", color de la unidad " + 
                this.getColorDeLaUnidad() + ", color de la casilla " + this.getColorDeLaCasilla() + 
                ", unidad seleccionada " + this.getUnidadSeleccionada();
    }
}
