/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliciones;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
//import javax.scene.shape.Rectangle;
/**
 *
 * @author Rafae
 */
public class Unidad extends JPanel{
    public int X, Y, WGrosor, Haltura;
//    private Graphics gContext;
    private BufferedImage img;
    public Rectangle r;//=new Rectangle(0,0,20,20);
    @Override
    public void paint(Graphics g){
//        try {
//            img = ImageIO.read(new File("assets/java.jpg")); // Aquí la ruta del fichero
//            
//        } catch (IOException e) {
//            System.out.println("Problemas leyendo la imagen n");
//            System.out.println("Motivo: " + e.getLocalizedMessage());
//        }
        
        g.setColor(Color.GREEN);
            g.fillRect(0, 0, 100, 100);
        r=g.getClipBounds();
        g.setColor(Color.MAGENTA);
        g.fillRect(50, 110, 10, 10);
        
//        + g.getClipBounds().intersects(X, Y, WGrosor, Haltura)
        
//        g.clipRect(X, Y, 20, 5)  ;
        System.out.println("Interseccion "+ g.getClipBounds().equals(r));
        WGrosor=100;
//        g.drawImage(img, 0, 0, this);
//        g.drawRect(0, 0, 100, 100);
        
        //En caso de querer recortar una parte de la imagen.
//        g.drawImage(img, 0, 0, 160, 160, 320, 160, 480, 320, this);
    }
    
}
