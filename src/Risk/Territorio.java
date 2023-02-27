/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Risk;

import javax.swing.JPanel;

/**
 *
 * @author Rafae
 */
public class Territorio extends JPanel{
    
    public Territorio(){
        inicio();
    }
    
    private javax.swing.JLabel jLJugador;
    private javax.swing.JLabel jLTerritorioFaccion;
    private JugadorUnidad jugador;
    
    private void inicio(){
        jLJugador = new javax.swing.JLabel();
        jLTerritorioFaccion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 102));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 4, true));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLJugador.setText("Jugador");
        add(jLJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, -1));

        jLTerritorioFaccion.setText("Territorio faccion");
        add(jLTerritorioFaccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, -1));
    }
    
    public void setJugador(JugadorUnidad nuevo_jugador){
        jugador=nuevo_jugador;
        this.jLJugador.setText(jugador.getNombre() + "");
        this.jLTerritorioFaccion.setText(jugador.getFaccion() + "");
    }
    public JugadorUnidad getJugador(){
        return jugador;
    }
    
    /**
     * Devuelve true si los puntos de vida del invasor son mayores a la unidad local en el territorio.
     * @param UnidadInvasora
     * @return 
     */
    public boolean conquistarTerritorio(JugadorUnidad UnidadInvasora){
        if(jugador!=null && UnidadInvasora!=null){
            if(UnidadInvasora.getPuntosDeVida()>jugador.getPuntosDeVida()){
                jugador=UnidadInvasora;
                return true;
            }
        }
        return false;
    }
}
