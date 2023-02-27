/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 */
public class Casilla extends TiposDeUnidadesJugadorSeleccionado {
    
    public Casilla(){
        
    }
    /**
     * Permite contar la cantidad de clicks o selecciones en un tablero.
     */
    public static int contadorDeSelecciones=0;
    /**
     * Cuenta 2 clicks el uno indica que esta seleccionado como origen y el 2 como destino, el 3 devuelve a 1.
     */
    public static void contarClicks(){
        contadorDeSelecciones++;
        if(contadorDeSelecciones>=3){
            contadorDeSelecciones=1;
        }
    }
    /**
     * Permite guardar localmente por instancia la cantidad indicada en la
     * variable static contadorDeSelecciones.
     */
    private int contadorLocalDeSelecciones=0;
    
    /**
     * Permite actualizar los datos de la variable static en la variable local.
     * Es llamado en setSeleccionada.
     */
    private void actualisacionLocalDelContador(){
        contadorLocalDeSelecciones=contadorDeSelecciones;
    }
    
    /**
     * Indica que alguna ficha debe moverse a esta casilla.
     * @return 
     */
    public boolean esDestino(){
        if(contadorLocalDeSelecciones==1){
            return true;
        }
        return false;
    }
    
    /**
     * Indica que alguna ficha en esta casilla esta lista para ser movida a alguna
     * casilla destino.
     * @return 
     */
    public boolean esOrigen(){
        if(contadorLocalDeSelecciones==1){
            return true;
        }
        return false;
    }
    
    public Casilla(int nueva_fila, int nueva_columna){
        fila=nueva_fila;
        columna=nueva_columna;
    }
    

    /**
     * La casilla es la que se debe seleccionar no la unidad
     * ya que existen casillas sin unidades a las cuales alguna
     * unidad debe moverse.
     */
    private boolean seleccionada;
    
    public void setSeleccionada(boolean esta_seleccionada){
        seleccionada=esta_seleccionada;
        if(seleccionada==true){
            actualisacionLocalDelContador();
        }
    }
    public boolean geteleccionada(){
        return seleccionada;
    }
    
    private int fila=-1;
    public void setFila(int nueva_fila){
        fila=nueva_fila;
    }
    public int getFila(){
        return fila;
    }
    
    private int columna=-1;
    
    public void setColumna(int nueva_columna){
        columna=nueva_columna;
    }
    public int getColumna(){
        return columna;
    }
    
    @Override
    public String toString(){
        return "(fila " + this.getFila()+ ", columna " + this.getColumna()
                +"), tipo de unidad en la casilla " + this.getTipoDeUnidad()
                + ", jugador al mando "+this.getJugadorAlMando() +
                ", es origen " + this.esOrigen() + ", es destino " + this.esDestino();
    }
}
