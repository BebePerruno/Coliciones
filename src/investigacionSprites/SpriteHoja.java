/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investigacionSprites;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafae
 */
public class SpriteHoja {
    public  int []pixeles;
    
    /**
     * Se le pone final a los parametros para indicar que los datos no van a cambiar durante toda la ejecucion del programa.
     * @param ruta
     * @param nuevo_ancho
     * @param nuevo_alto 
     */
    public SpriteHoja(final String ruta, final int nuevo_ancho, final int nuevo_alto){
        try {
            ancho=nuevo_ancho;
            alto=nuevo_alto;
            pixeles=new int [ancho*alto];
            //Modo 1
            BufferedImage bufered_image=ImageIO.read(SpriteHoja.class.getResource(ruta));
            //Modo 2
            BufferedImage bufered_image2=ImageIO.read(SpriteHoja.class.getResourceAsStream(ruta));
//            bufered_image.getRGB(0, 0, alto, ancho, pixeles, 0, ancho);
            //Direcciones
            BufferedImage direccionesImg;
            Image i=bufered_image2.getSubimage(1, 1, 100,100);
            JLabel L=new JLabel("Hola");
            L.setIcon((Icon) i);
            JOptionPane.showMessageDialog(null, L);
        } catch (IOException ex) {
            Logger.getLogger(SpriteHoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int ancho, alto;
    
    public int getAncho(){
        return ancho;
    }
    
    public int getAlto(){
        return alto;
    }
    
    /**
     * Se realiza asi para no crear una instancia en otra clase o muchas instancias.
     */
    public static SpriteHoja hoja_sprite=new SpriteHoja("/Experimentos/SpriteSheetAgual.jpg",626,368);
            
}
