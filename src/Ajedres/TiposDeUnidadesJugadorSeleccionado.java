/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 */
public class TiposDeUnidadesJugadorSeleccionado  {
    /**
     * Permite establecer restricciones con respecto al tipo de unidad.
     */
    public enum TipoDeUnidad{
        peon, caballo, arfil, torre, rey, reina, ninguna;
    }
    
    protected TipoDeUnidad tipoDeUnidad=null;
    
    public void setTipoDeUnidad(TipoDeUnidad nuevoTipoDeUnidad)
    {
        tipoDeUnidad=nuevoTipoDeUnidad;
    }
    public TipoDeUnidad getTipoDeUnidad(){
        return tipoDeUnidad;
    }
    
    public enum JugadorAlMando{
        jugador1, jugador2;
    }
    
    private JugadorAlMando jugador;
    
    public void serJugador(JugadorAlMando nuevoJugadorAlMando){
        jugador=nuevoJugadorAlMando;
    }
    
    public JugadorAlMando getJugadorAlMando(){
        return jugador;
    }
}
