/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

/**
 *
 * @author Rafae
 */
import Experimentos.Juego.UnidadEstandar;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Zoom extends JPanel{
    private Image FOTO_ORIGINAL;
    private Image FOTO_tmp;   
    private BufferedImage Imagen_en_memoria;
    private Graphics2D g2D;
    private boolean con_foto = false;   
    private int valEscalaX=0;
    private int valEscalaY=0;
    
    private Unidad A,B;
    
    public Zoom(){
        u=new UnidadEstandar(300,150,25,50,this,"/Experimentos/AbejaDerecha.jpg");
        t=new UnidadEstandar(250,50,25,50,this,"/Experimentos/AbejaIzquierda.jpg");
//        AL al=new AL();
        this.addKeyListener(new AL());
        A=new Unidad(0,0,50,50);
        B=new Unidad(0,0,100,100);
        BufferedImage f=null;
        try {
            f = ImageIO.read(SpriteHoja.class.getResourceAsStream("/Experimentos/SpriteSheetAgual.jpg"));
            f.getRGB(0, 0, 50, 50, pixeles, 0, 50);
        } catch (IOException ex) {
            Logger.getLogger(Zoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.FOTO_ORIGINAL = f;
        this.FOTO_tmp = f;
        this.setSize(f.getWidth(),f.getHeight());
        this.setVisible(true);
        this.con_foto=true;
    }
   public  int []pixeles;
    /* al crear el objeto se crea con una imagen pasada como parametro*/
    public Zoom(BufferedImage f){             /*[u][b]esta es la duda de como se mete aqui la foto como parametro[/b][/u]?*/
        this.FOTO_ORIGINAL = f;
        this.FOTO_tmp = f;
        pixeles=new int[100*100];
        
        this.setSize(f.getWidth(),f.getHeight());
        this.setVisible(true);
        this.con_foto=true;
    }
    
    private int a,b;
    
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);//Esta era la palabra.
//       repaint();}
         BufferedImage f=null;
         BufferedImage f1=null;
        try {
            
            f = ImageIO.read(Zoom.class.getResourceAsStream("/coliciones/agregar.png"));
            f1 = ImageIO.read(Zoom.class.getResourceAsStream("/Experimentos/AbejaDerecha.jpg"));
            f.getRGB(0, 0, 30, 10, pixeles, 0, 100);
        } catch (IOException ex) {
            Logger.getLogger(Zoom.class.getName()).log(Level.SEVERE, null, ex);
        }
//        this.FOTO_ORIGINAL = f;
//        this.FOTO_tmp = f;
//        this.setSize(f.getWidth(),f.getHeight());
        this.setVisible(true);
        this.con_foto=true;
        if(b>=20){
            try {
                f1 = ImageIO.read(SpriteHoja.class.getResourceAsStream("/coliciones/Explocion.gif"));
            } catch (IOException ex) {
                Logger.getLogger(Zoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        A.x=b*4;
        A.y=50;
        B.x=a;
        B.y=50;
        g.drawImage(f1, b*4, 50,100,100, this);
        g.drawImage(f, a, b, 50,50,this);
        if(A.intersects(B)==true){
            System.out.println( "Colicion");
        }
         
        t.draw(g);
        u.draw(g);
        //Da null
//        boolean b=f1.getGraphics().getClipRect().getBounds().intersects(f.getGraphics().getClipRect().getBounds());
//        if(b=true){
//            System.out.println("Colicion");
//        }
    }
    
    private UnidadEstandar u,t;
    
    public void checkCollision(){
        if(u.intersects(t)==true){
            System.out.println("Inserseccion\nGameOver");
            
        }
    }
    
    public class AL extends KeyAdapter{
    
        @Override
        public void keyPressed(KeyEvent key){
            u.keyPressed(key);
//            enemy.keyPressed(key);
            checkCollision();//Procedimiento externo.
            repaint();
        }
    }
    
    public void mover(){
        a+=10;
        b+=10;
        this.t.setX(u.getX()+20);
        t.setY(u.getY()+20);
        repaint();
    }
    
    public class Unidad{
        public int x,y,width,height;
        public Color color;
        
        public Unidad(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight){
            this.x=nuevoX;
            y=nuevoY;
            this.width=nuevoWidth;
            this.height=nuevoHeight;
        }
        
        public boolean intersects(Unidad nueva_unidad) {
            int tw = this.width;
            int th = this.height;
            int rw = nueva_unidad.width;
            int rh = nueva_unidad.height;
            if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
                return false;
            }
            int tx = this.x;
            int ty = this.y;
            int rx = nueva_unidad.x;
            int ry = nueva_unidad.y;
            rw += rx;
            rh += ry;
            tw += tx;
            th += ty;
            //      overflow || intersect
            return ((rw < rx || rw > tx) &&
                    (rh < ry || rh > ty) &&
                    (tw < tx || tw > rx) &&
                    (th < ty || th > ry));
        }

    }
}
