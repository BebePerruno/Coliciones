/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

import javax.swing.ImageIcon;

/**
 *
 * @author Jugador
 */
public class ImagenesParaJuegos {
    public ImageIcon imagenExplosion(){
        return new ImageIcon(getClass().getResource("/coliciones/Explocion.gif"));
    }
    
    public ImageIcon imagenBase(){
        return new ImageIcon(getClass().getResource("/imagenes/1.jpg"));
    }
    
    public ImageIcon imagenFabrica(){
        return new ImageIcon(getClass().getResource("/imagenes/2.jpg"));
    }
    
    public ImageIcon imagenGenerador(){
        return new ImageIcon(getClass().getResource("/imagenes/3.jpg"));
    }
    
    public ImageIcon imagenBodega(){
        return new ImageIcon(getClass().getResource("/imagenes/4.jpg"));
    }
    
    public ImageIcon imagenTorre(){
        return new ImageIcon(getClass().getResource("/imagenes/Torre.jpg"));
    }
    
    public ImageIcon imagenRobot(){
        return new ImageIcon(getClass().getResource("/imagenes/Robot.png"));
    }
    
    public ImageIcon imagenTanque(){
        return new ImageIcon(getClass().getResource("/imagenes/TanqueRojo.png"));
    }
}
