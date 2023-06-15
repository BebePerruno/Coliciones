/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Experimentos.Juego;

import investigacionSprites.HiloAleatorio;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafae
 */
public class frmRts extends javax.swing.JFrame  {
    
    public void draw(Graphics g){
//        super.paintComponent(g);//Esta era la palabra.

         BufferedImage f=null;
         
        try {
            f = ImageIO.read(UnidadEstandar.class.getResourceAsStream(aliado.getNombreDeLaImagen()));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(UnidadEstandar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
            f.getRGB(0, 0, 30, 20, aliado.pixeles, 1, 100);
            
//        this.con_foto=true;
//        if(x>=20){
//            //Dibujar otra imagen.
//        }
//        original x*=4;
        aliado.setX(aliado.getX());//50*4;
        
        aliado.setY(aliado.getY());
            g.drawImage(f, aliado.getX(), aliado.getY(),this);
        
        
        //Asi cuando todo el algoritmo de dibujado se realiza dentro del form.
//        if(aliado.intersects(enemigo)==true){
//            System.out.println( "Colicion");
//        }
    }
    private UnidadEstandar aliado, enemigo,edificio1,edificio2;
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
//        super.paintComponents(g);
//        this.draw(g);
        this.enemigo.draw(g);
        aliado.draw(g);
        if(n1==1){
            if(aliado.getCrear()==true){
                edificio1.draw(g);
                edificio1.setCreado(true);
            }
        }else{
             if(aliado.getCrear()==true){
                edificio2.draw(g);
                edificio2.setCreado(true);
            }
        }
        if(edificio1.getCreado()==true){
            edificio1.draw(g);
        }
        if(edificio2.getCreado()==true){
            edificio2.draw(g);
        }
//        enemigo.draw(g);
    }
Thread tt=null;
    /**
     * Creates new form frmRts
     */
    public frmRts() {
        initComponents();
        aliado=new UnidadEstandar(200,100,50,50,this,"/Experimentos/AbejaDerecha.jpg");
        enemigo=new UnidadEstandar(100,50,50,50,this,"/Experimentos/AbejaIzquierda.jpg");
        enemigo.setVelocidad(30);
        edificio1=new UnidadEstandar(50,50,80,80,this,"/Experimentos/Juego/1.jpg");
        edificio2=new UnidadEstandar(50,50,80,80,this,"/Experimentos/Juego/2.jpg");
        this.run();
        
    }
    
    @Override
    public void update(Graphics g){
//        super.update(g); No usar.
        paint(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int c=0;
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
//        if(evt.getKeyCode()==KeyEvent.VK_UP){
//            aliado.moverArriba();
//        }
//        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
//            aliado.moverAbajo();
//        }
//        if(evt.getKeyCode()==KeyEvent.VK_LEFT){
//            aliado.moverIzquierda();
//        }
//        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
//           aliado.moverDrecha();
//        }
    run();
    this.aliado.keyPressed(evt);
        repaint();
        if(aliado.intersects(enemigo)==true){
            c++;
            System.out.println( "Colicion " + c);
        }
        if(aliado.getCrear()==true){
            if(n1==1){
                edificio1.setX(aliado.getX()+80);
                edificio1.setY(aliado.getY()+80);
            }else{
                edificio2.setX(aliado.getX()+80);
                edificio2.setY(aliado.getY()+80);
            }
            System.out.println("creando en " + edificio1.getX());
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmRts().setVisible(true);
            }
        });
    }

    private int n1,n2;
    
    public  int numeroAleatorio(int Min, int Max){
        if(Min==0){
            Min=-1;
        }
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
    
    public void run() {
//        while (true){
            n1=numeroAleatorio(1, 4);
            n2=numeroAleatorio(1, 6);
            switch(n2){
                case 1:
                    enemigo.moverArriba();
                    break;
                case 2:
                    enemigo.moverAbajo();
                    break;
                case 3:
                    enemigo.moverDrecha();
                    break;
                case 4:
                    enemigo.moverIzquierda();
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                  
            }
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
