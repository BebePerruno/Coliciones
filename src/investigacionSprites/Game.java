/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
^ elevado
 */
package investigacionSprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Rafae
 * Detencion de coliciones entre 2 objetos.
 */
public class Game {
    
    public static void main(String []Args){
        MyFrame myFrame=new MyFrame();
    }
}

class MyFrame extends JFrame{
    private Image image;
    private Graphics graphics;
    
    private Box player;
    private Box enemy;
    private boolean gameOver;
    
    
    public MyFrame(){
        player=new Box(100,300,50,50,Color.BLUE);
        enemy=new Box(300,300,50,50,Color.red);
        this.gameOver=false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);
        this.addKeyListener(new AL());
    }
    
    @Override
    public void paint(Graphics g){
        image=createImage(this.getWidth(),this.getHeight());
        this.graphics=image.getGraphics();
        g.drawImage(image, 0, 0, this);
        player.draw(g);
        enemy.draw(g);
        if(this.gameOver==true){
            g.setColor(Color.red);
        }
        
    }
    
    public void checkCollision(){
        if(player.intersects(enemy)==true){
            System.out.println("Inserseccion\nGameOver");
            this.gameOver=true;
        }
    }
    
    public class AL extends KeyAdapter{
    
        @Override
        public void keyPressed(KeyEvent key){
            player.keyPressed(key);
//            enemy.keyPressed(key);
            checkCollision();//Procedimiento externo.
            repaint();
        }
    }
    
}

/**
 * Condicional para las coliciones.
 * 
 * public boolean intersects(Rectangle r) {
        int tw = this.width;
        int th = this.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = r.x;
        int ry = r.y;
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
 * @author Rafae
 */
class Box extends Rectangle{
    
    
    
    private Color color;
    
    Box(int nuevoX, int nuevoY, int nuevoWidth, int nuevoHeight, Color nuevo_color){
        this.x=nuevoX;
        y=nuevoY;
        this.width=nuevoWidth;
        this.height=nuevoHeight;
        this.color=nuevo_color;
    }
    
    public void keyPressed(KeyEvent key){
        if(key.getKeyCode()==KeyEvent.VK_UP){
            y-=10;
        }
        if(key.getKeyCode()==KeyEvent.VK_DOWN){
            y+=10;
        }
        if(key.getKeyCode()==KeyEvent.VK_LEFT){
            x-=10;
        }
        if(key.getKeyCode()==KeyEvent.VK_RIGHT){
            x+=10;
        }
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}
