/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investigacionSprites;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Baloon extends Canvas {
    @Override
    public void paint(Graphics g){
        
    }
}


class Formulario extends JFrame{
    
}

/**
 *
 * @author Rafael
 * El canvas es recomendado por la eficiencia con los graficos.
 */
public class EliminandoParpadeo extends Canvas {
    public static Image fondo=null;
    public  ArrayList<Baloon> b;
    public static final boolean SHOWBACBGROUND=true;
    private Image dibujoAUX;
    private Graphics gAUX;
    private Dimension dimAUX;
    private Dimension dimCanvas;
    
    
    static{
        fondo=new ImageIcon(Formulario.class.getResource("/Experimentos/Juego/2.jpg")).getImage();
    }
    
    public EliminandoParpadeo(ArrayList<Baloon> nuevoB, int nuevoWidth, int nuevoHeight){
        super();
        this.setBackground(Color.green);
        setSize(new Dimension(nuevoWidth,nuevoHeight));
        b=nuevoB;
        dimCanvas=getSize();
    }
    
    @Override
    public void update(Graphics g){
//        super.update(g); No usar.
        paint(g);
    }
    
    @Override
    public void paint(Graphics g){
//        super.paint(g); Se elimina no se usa 
            
        if(gAUX==null || dimAUX==null || dimCanvas.width!=dimAUX.width || dimCanvas.width!=dimAUX.width){
            dimAUX=dimCanvas;
            dibujoAUX=createImage(dimAUX.width,dimAUX.height);
            gAUX=dibujoAUX.getGraphics();
        }    
        if(SHOWBACBGROUND) gAUX.drawImage(fondo, 0, 0, this);
        for(Baloon c:b) {
            c.paint(gAUX);
        }
        g.drawImage(dibujoAUX, 0, 0, this);
    }
    
    
    
}
