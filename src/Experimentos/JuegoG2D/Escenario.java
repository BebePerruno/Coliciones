/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.JuegoG2D;

import investigacionSprites.Sprite4Dibujador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 * Despues de investigar algunos inconvenientes con los calculos del modelo esta es la formula a usar.
 * (400-30)X(725+75) en las dimenciones de la imagen que contiene el sprite.
 * El restado y el sumado varia de acuerdo al sprite.
 * Bueno la investigacion sprites se deja hasta aqui.
 * Lo correcto si es crear un modelo pero solo para el movimiento x,y del recuadro.
 * Ademas de acuerdo al sprite hay que realizar una serie de ajustes matematicos.
 */
public class Escenario extends JPanel {
    
    public final String IMAGEN="/Experimentos/JuegoG2D/Robots.jpg";
    private Image img;
    /**
     * Ayuda a repintar y dibijar bien las imagenes.
     */
    private BufferedImage buffered_image;
    
    private UnidadG2D aliado, enemigo;
    private UnidadG2D roca, piedra,muro;
    
    public Escenario(){
        cargar();
    }
    
    public void cargar(){
        //        this.setDoubleBuffered(true);Solo en caso de parpadeo.

//Inicializacion global.
        UnidadG2D.setColumnasDelSprite(4);
        UnidadG2D.setFilasDelSprite(4);
        UnidadG2D.setDimencionesDelSpriteVector((400-30), (725+75));//(400-30)X(725+75)
        Toolkit herramienta=Toolkit.getDefaultToolkit();
        img=herramienta.getImage(Sprite4Dibujador.class.getResource(IMAGEN));
        buffered_image=new BufferedImage(UnidadG2D.getAnchoVentana(),UnidadG2D.getAltoVentana(),BufferedImage.TYPE_INT_BGR);
        
    }
    
    @Override
    public void paint(Graphics g){
////        super.paintComponents(g); //No se debe usar con este algoritmo.
//try{
        Graphics2D g2d=null;
        
        

       aliado=new UnidadG2D(50,50,4,100,100);
       enemigo=new UnidadG2D(300,50,8,70,50);
       
        g.drawImage(buffered_image, 0, 0, this);
        g2d=buffered_image.createGraphics();
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, UnidadG2D.getAnchoVentana(),UnidadG2D.getAltoVentana());
//        
////Test
        g2d.drawImage(img, 
                aliado.posicionX,
                aliado.posicionY,
                aliado.getPosicionXFinal(),
                aliado.getPosicionYFinal(),
                aliado.getLargoDelDibujo(),
                aliado.getAltoDelDibujo(),
                aliado.getLargoDelDibujoFinal(),
                aliado.getAltoDelDibujoFinal(),
                this);
        repaint();
//                }catch(Exception ex){}
    }
}
