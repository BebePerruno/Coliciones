/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package investigacionSprites;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafae
 */
public class frmDibujos extends javax.swing.JFrame {

    public class Coord{
        public int x1=0, x2=0;
        public int y1=0, y2=0;
        
        public String obtenerMayor(){
            if(x1<x2){
                return "x1";
            }
            return "x2";
        }
    }
    
    private Coord coordenadas=new Coord();
    
    public class Coord2 extends Coord{
        
        private ArrayList<String> ArrayX=new ArrayList<String>();
        private ArrayList<String> ArrayY=new ArrayList<String>();
        
        public int sizeX(){
            return ArrayX.size()-1;
        }
        
        public int sizeY(){
            return ArrayX.size()-1;
        }
        
        private String Xtxt="", Ytxt="";
//        private String []mX={};
//        private String []mY={};
        
        public int getX(int id){
            if(sizeX()>=0){
                if(id<0){
                    id=0;
                }
                if(id>sizeX()){
                    id=sizeX();
                }
                return Integer.parseInt(this.ArrayX.get(id)) ;
            }
            return 0;
        }
        
        public int getY(int id){
            if(sizeY()>=0){
                if(id<0){
                    id=0;
                }
                if(id>sizeY()){
                    id=sizeY();
                }
                return Integer.parseInt(ArrayY.get(id)) ;
            }
            return 0;
        }
        
        /**
         * Este borrado funciona cuando se hace DragDrop
         */
        public void borrarRecorrido(){
            
            //Se coloca el ultimo id al inicio.
//            if(mX.length>0){
//                Xtxt=" " + mX[mX.length-1] + " " + Xtxt;
//            }
//            if(mY.length>0){
//                Ytxt=" " + mY[mY.length-1] + " " + Ytxt;
//            }
//            mX=Xtxt.split(" ");
//            mY=Ytxt.split(" ");
//            System.out.println(mX[1]);
                String yBkUp="";
                String xBkUp="";
                
                if(ArrayX.size()-1>-1){
                    xBkUp=ArrayX.get(ArrayX.size()-1);
                }
                if(ArrayY.size()-1>-1){
                    yBkUp=ArrayY.get(ArrayY.size()-1);
                    
                }
               ArrayX=new ArrayList<String>();
               ArrayY=new ArrayList<String>();
               
               if(xBkUp.equalsIgnoreCase("")==false){
                   ArrayX.add(xBkUp);
               }
               if(yBkUp.equalsIgnoreCase("")==false){
                   ArrayY.add(yBkUp);
               }
        }
        
        public void borrarTodo(){
            ArrayX=new ArrayList<String>();
           ArrayY=new ArrayList<String>();
        }
        
        public void add(int nuevo_x, int nuevo_y){
//            convertir();
            ArrayX.add("" + nuevo_x);
            ArrayY.add("" + nuevo_y);
//            Xtxt+= " " + nuevo_x;
//            Ytxt+= " " + nuevo_y;
            
        }
        
    }
    
    private Coord2 coordenadas2=new Coord2();
    private boolean b=false;
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        //Esto para un hilo
//        if(coordenadas.obtenerMayor().equalsIgnoreCase("x2")==true){
//            for(int i=coordenadas.x1;i<=coordenadas.x2;i++){
//                g.drawLine(coordenadas.x1, coordenadas.y1, i, coordenadas.y2);
//            }
//        }else{
//            for(int i=coordenadas.x1;i>=coordenadas.x2;i--){
//                g.drawLine(coordenadas.x1, coordenadas.y1, i, coordenadas.y2);
//            }
//        }
        g.setColor(Color.GREEN);
//        g.setClip(0, 0, 35, 23);

jTextAreaX.setText("            int []mX=new int[" + (coordenadas2.sizeX()+1) + "];\n");
jTextAreaY.setText("            int []mY=new int[" + (coordenadas2.sizeY()+1) + "];\n");
    int idx=0;
    for(int idy=0;idy<=coordenadas2.sizeY();idy++){
        if(b==true){
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(frmDibujos.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.setColor(Color.MAGENTA);
            g.drawRect(coordenadas2.getX(idx), coordenadas2.getY(idy), 50, 50);
        }
        
        
        System.out.println(idx);
        g.drawLine(coordenadas2.getX(idx-1), coordenadas2.getY(idy-1), coordenadas2.getX(idx), coordenadas2.getY(idy));
        
        this.jTextAreaX.setText(jTextAreaX.getText() + "\nmX[" + idx + "]=" + coordenadas2.getX(idx) + ";");
        jTextAreaY.setText(jTextAreaY.getText() + "\nmY[" + idy + "]=" + coordenadas2.getY(idy)+";");
        
        idx++;
    }
//        g.drawLine(coordenadas.x1, coordenadas.y1, coordenadas.x2, coordenadas.y2);
//g.fillRect(WIDTH, WIDTH, WIDTH, HEIGHT);
//g.fillRect(0, 0, 400, 250);
//g.setColor(Color.MAGENTA);
//g.fillRect(0, 252, 400, 250);
    }
    
    @Override
    public void update(Graphics g){
//        super.update(g);// No usar.
//        paint(g);
    }
    
    /**
     * Creates new form frmDibujos
     */
    public frmDibujos() {
        initComponents();
//        this.jLabel1.setVisible(false);
//        this.jLabel2.setVisible(false);
//        this.jScrollPane1.setVisible(false);
//        this.jScrollPane2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaX = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaY = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTextAreaX.setColumns(20);
        jTextAreaX.setRows(5);
        jScrollPane1.setViewportView(jTextAreaX);

        jTextAreaY.setColumns(20);
        jTextAreaY.setRows(5);
        jScrollPane2.setViewportView(jTextAreaY);

        jLabel1.setText("Eje X");

        jLabel2.setText("Eje Y");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(355, 355, 355)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        coordenadas2.add(evt.getX(), evt.getY());
//        coordenadas.x2=evt.getX();
//        coordenadas.y2=evt.getY();
        this.repaint();
        
        
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
//        coordenadas.x1=evt.getX();
//        coordenadas.y1=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//       coordenadas.x2=evt.getX();
//        coordenadas.y2=evt.getY();
//        this.repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
       b=true;
        this.repaint();
    }//GEN-LAST:event_formMouseWheelMoved

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        this.jLabel1.setVisible(true);
        this.jLabel2.setVisible(true);
        this.jScrollPane1.setVisible(true);
        this.jScrollPane2.setVisible(true);
    }//GEN-LAST:event_formKeyPressed

    private boolean borrar=false;
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
            java.util.logging.Logger.getLogger(frmDibujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDibujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDibujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDibujos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDibujos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaX;
    private javax.swing.JTextArea jTextAreaY;
    // End of variables declaration//GEN-END:variables
}
