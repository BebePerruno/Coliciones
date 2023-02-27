/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * Ahora, cada vez que queramos hacer transparente un determinado color de una imagen habrá que hacer lo que se muestra en el siguiente código.
 * TransparentTransformation transparent = new TransparentTransformation(destinationImage);
BufferedImage destinationImage = transparent.makeColorTransparent(new Color(0, 0, 0));
* 
* Si se quiere guardar la imagen en formato PNG (admite transparencia), será algo tan sencillo como usar la clase ImageIO de Java.
* private void savePNGImage(BufferedImage im) throws IOException {
    ImageIO.write(im, "PNG", new File("imagen.png"));
}
}
 */
public class TransparentTransformation {
    private BufferedImage img;
    public TransparentTransformation(BufferedImage img) {
        this.img = img;
    }
    public BufferedImage makeColorTransparent(final Color color) {
        BufferedImage imgDestination;
        ImageFilter filter = new RGBImageFilter() {
            // the color we are looking for... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFF000000;
            @Override
            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };
        ImageProducer ip = new FilteredImageSource(img.getSource(), filter);
        Image img = Toolkit.getDefaultToolkit().createImage(ip);
        imgDestination = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2dImg = imgDestination.createGraphics();
        g2dImg.drawImage(img, 0, 0, null);
        g2dImg.dispose();
        return imgDestination;
    }
    
    /**
     * Para guardar las imagenes en formato PNG, el cual admite transparencia.
     * Si se quiere guardar la imagen en formato PNG (admite transparencia), será algo tan sencillo como usar la clase ImageIO de Java.
     * @param im
     * @throws IOException 
     */
    public void savePNGImage(BufferedImage im) throws IOException {
        ImageIO.write(im, "PNG", new File("imagen.png"));
    }
}
