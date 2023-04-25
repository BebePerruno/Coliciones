/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Exagonal;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jugador
 */
public abstract class AbstractTerritorio extends javax.swing.JPanel {

    public static int poblacion=0;
    public static final ImagenesExagonales imagenes=new ImagenesExagonales();
    
    public static int cantidadDeInstancias=0;
    private  int numeroDeInstancia=0;
    
    public void setNumeroDeInstancia(int nuevo_numero_de_instancia){
        numeroDeInstancia=nuevo_numero_de_instancia;
    }
    public int getNumeroDeInstancia(){
        return numeroDeInstancia;
    }
    
    private String nombre="Exagono";
    
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    public String getNombre(){
        return nombre;
    }
        
    
    private Icon imagen=new ImageIcon();
    public void setImagen(Icon nuevaImagen){
        imagen=nuevaImagen;
        this.jLbImagen.setIcon(imagen);//(new javax.swing.ImageIcon(getClass().getResource("/E_S/medieval_archery.png"))); 
    }
    
    {
//    class EveInterno extends AbstractDoubleClick{
//        @Override
//        public void eveClick(int x, int y, Point puntoXY) {
//            
//        }
//
//        @Override
//        public void eveDobleClick(int x, int y, Point puntoXY) {
//            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        }
//
//        @Override
//        public void mousePressed() {
//            System.out.println("Numero de instancia " + instanciaNumero + "; cantiad de instancias " + cantidadDeInstancias);
//        }
//
//        @Override
//        public void mouseMoviendose() {
//            if(estaSeleccionado()==true){
//                System.out.println("El puntero esta en " + instanciaNumero );
//            }
//        }
//
//        @Override
//        public void mouseArrastrastrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        }
//        
//    }
    }
    private static AbstractDoubleClick eventos;
    
    public static void setEventosParaTodasLasInstancias(AbstractDoubleClick nuevosEventos){
        System.out.println("Reciviendo eventos static setEventosParaTodasLasInstancias=" + (nuevosEventos==null));
        eventos=nuevosEventos;
    }
    
    public void setEventos(AbstractDoubleClick nuevoMouseListener){
        System.out.println("Reciviendo eventos en setEventos " + (nuevoMouseListener==null));
        this.jLbImagen.addMouseListener(nuevoMouseListener);
        this.jLabel6.addMouseListener(nuevoMouseListener);
        this.jLabel7.addMouseListener(nuevoMouseListener);
        this.jLabel8.addMouseListener(nuevoMouseListener);
        this.jLabel10.addMouseListener(nuevoMouseListener);
        this.jLabel11.addMouseListener(nuevoMouseListener);
        this.jLabel12.addMouseListener(nuevoMouseListener);
        this.jLabel13.addMouseListener(nuevoMouseListener);
        this.jLabel14.addMouseListener(nuevoMouseListener);
        this.jLbEventos.addMouseListener(nuevoMouseListener);
//        this.addMouseListener(nuevoMouseListener);
        
        this.jLbImagen.addMouseMotionListener(nuevoMouseListener);
        this.jLabel6.addMouseMotionListener(nuevoMouseListener);
        this.jLabel7.addMouseMotionListener(nuevoMouseListener);
        this.jLabel8.addMouseMotionListener(nuevoMouseListener);
        this.jLabel10.addMouseMotionListener(nuevoMouseListener);
        this.jLabel11.addMouseMotionListener(nuevoMouseListener);
        this.jLabel12.addMouseMotionListener(nuevoMouseListener);
        this.jLabel13.addMouseMotionListener(nuevoMouseListener);
        this.jLabel14.addMouseMotionListener(nuevoMouseListener);
        jLbEventos.addMouseMotionListener(nuevoMouseListener);
//        this.addMouseMotionListener(nuevoMouseListener);
    }
    
    public static ArrayList<AbstractTerritorio> rsTerritorios=new ArrayList<AbstractTerritorio>();
    
    private static void add(AbstractTerritorio nuevo){
        for(int i=0; i<rsTerritorios.size(); i++){
            if(rsTerritorios.get(i).getNumeroDeInstancia()==nuevo.getNumeroDeInstancia()){
                System.out.println(rsTerritorios.get(i).getNombre()+" modificado por " + nuevo.getNombre());
                rsTerritorios.remove(i);
                rsTerritorios.add(nuevo);
                
                return;//Salta de una sola vez.
            }
        }
        rsTerritorios.add(nuevo);
    }
    
    /**
     * Creates new form Territorio
     */
    public AbstractTerritorio() {
        initComponents();
        
        
        cantidadDeInstancias++;
        numeroDeInstancia=cantidadDeInstancias;
        this.setEventos(eventos);
        add(this);
        System.out.println("Es null eventos=" + eventos);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLbEventos = new javax.swing.JLabel();
        jLbImagen = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(null);

        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel6MouseMoved(evt);
            }
        });
        add(jLabel6);
        jLabel6.setBounds(20, 30, 10, 90);

        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });
        add(jLabel7);
        jLabel7.setBounds(30, 30, 10, 90);

        jLabel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel8MouseMoved(evt);
            }
        });
        add(jLabel8);
        jLabel8.setBounds(40, 20, 10, 110);

        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel10MouseMoved(evt);
            }
        });
        add(jLabel10);
        jLabel10.setBounds(50, 10, 10, 130);

        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel11MouseMoved(evt);
            }
        });
        add(jLabel11);
        jLabel11.setBounds(60, 10, 10, 130);

        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel12MouseMoved(evt);
            }
        });
        add(jLabel12);
        jLabel12.setBounds(70, 20, 10, 110);

        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel13MouseMoved(evt);
            }
        });
        add(jLabel13);
        jLabel13.setBounds(80, 30, 10, 90);

        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel14MouseMoved(evt);
            }
        });
        add(jLabel14);
        jLabel14.setBounds(90, 30, 10, 90);

        jLbEventos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLbEventosMouseMoved(evt);
            }
        });
        add(jLbEventos);
        jLbEventos.setBounds(0, 0, 120, 140);

        jLbImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exagonal/dirt_02.png"))); // NOI18N
        jLbImagen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLbImagen.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLbImagenMouseMoved(evt);
            }
        });
        add(jLbImagen);
        jLbImagen.setBounds(0, 0, 120, 140);
    }// </editor-fold>//GEN-END:initComponents

    private void jLbImagenMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbImagenMouseMoved
//       rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLbImagenMouseMoved

    private void jLabel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel6MouseMoved

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jLabel8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel8MouseMoved

    private void jLabel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel10MouseMoved

    private void jLabel11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel11MouseMoved

    private void jLabel12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel12MouseMoved

    private void jLabel13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel13MouseMoved

    private void jLabel14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel14MouseMoved

    private void jLbEventosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbEventosMouseMoved
//       rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLbEventosMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLbEventos;
    private javax.swing.JLabel jLbImagen;
    // End of variables declaration//GEN-END:variables
}
