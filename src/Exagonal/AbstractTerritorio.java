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
import javax.swing.JOptionPane;

/**
 *
 * @author Jugador
 */
public abstract class AbstractTerritorio extends javax.swing.JPanel {
    
    private boolean estaSeleccionado=false;
    
    /**
     * Permite indicar si algun descendiente de este class ha sido seleccionado.
     * @param seleccionado 
     */
    public void setEstaSeleccionado(boolean seleccionado){
        estaSeleccionado=seleccionado;
    }
    
    /**
     * Permite indicar si algun descendiente de este class ha sido seleccionado.
     * Se debe usar en conjunto con el numero de instancia.
     * @return 
     */
    public boolean getEstaSeleccionado(){
        return estaSeleccionado;
    }

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
    
    private static AbstractDoubleClick eventos;
    
    public static void setEventosParaTodasLasInstancias(AbstractDoubleClick nuevosEventos){
//        System.out.println("Reciviendo eventos static setEventosParaTodasLasInstancias=" + (nuevosEventos==null));
        eventos=nuevosEventos;
    }
    
    public boolean colicion(AbstractTerritorio nuevo_objeto){
        return(getBounds().intersects(nuevo_objeto.getBounds())==true);
    }
    
    public abstract void eveEventosAgregados();
    
    public void setEventos(AbstractDoubleClick nuevoMouseListener){
//        this.jLbImagen.addMouseListener(nuevoMouseListener);
        this.jLabel6.addMouseListener(nuevoMouseListener);
        this.jLabel7.addMouseListener(nuevoMouseListener);
        this.jLabel8.addMouseListener(nuevoMouseListener);
        this.jLabel10.addMouseListener(nuevoMouseListener);
        this.jLabel11.addMouseListener(nuevoMouseListener);
        this.jLabel12.addMouseListener(nuevoMouseListener);
        this.jLabel13.addMouseListener(nuevoMouseListener);
        this.jLabel14.addMouseListener(nuevoMouseListener);
        
        this.jLabel6.addMouseMotionListener(nuevoMouseListener);
        this.jLabel7.addMouseMotionListener(nuevoMouseListener);
        this.jLabel8.addMouseMotionListener(nuevoMouseListener);
        this.jLabel10.addMouseMotionListener(nuevoMouseListener);
        this.jLabel11.addMouseMotionListener(nuevoMouseListener);
        this.jLabel12.addMouseMotionListener(nuevoMouseListener);
        this.jLabel13.addMouseMotionListener(nuevoMouseListener);
        this.jLabel14.addMouseMotionListener(nuevoMouseListener);
        AbstractTerritorio.add(this);
        eveEventosAgregados();
//        System.out.println("Cantidad " + AbstractTerritorio.rsInstancias.size());
    }
    
    public static ArrayList<AbstractTerritorio> rsInstancias=new ArrayList<AbstractTerritorio>();
    
    private static void add(AbstractTerritorio nuevo){
        for(int i=0; i<rsInstancias.size(); i++){
            if(rsInstancias.get(i).getNumeroDeInstancia()==nuevo.getNumeroDeInstancia()){
//                System.out.println(rsInstancias.get(i).getNombre()+rsInstancias.get(i).getNumeroDeInstancia()+ " actualizandose con los datos de " + nuevo.getNombre());
                rsInstancias.remove(i);
                rsInstancias.add(nuevo);
                
                return;//Salta de una sola vez.
            }
        }
//        System.out.println("Agregando " +nuevo.getNombre()+nuevo.getNumeroDeInstancia());
        rsInstancias.add(nuevo);
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
//        System.out.println("Es null eventos=" + eventos);
        
        
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
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
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
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        add(jLabel7);
        jLabel7.setBounds(30, 30, 10, 90);

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        add(jLabel8);
        jLabel8.setBounds(40, 20, 10, 110);

        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        add(jLabel10);
        jLabel10.setBounds(50, 10, 10, 130);

        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        add(jLabel11);
        jLabel11.setBounds(60, 10, 10, 130);

        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        add(jLabel12);
        jLabel12.setBounds(70, 20, 10, 110);

        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        add(jLabel13);
        jLabel13.setBounds(80, 30, 10, 90);

        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        add(jLabel14);
        jLabel14.setBounds(90, 30, 10, 90);

        jLbEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLbEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbEventosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbEventosMouseExited(evt);
            }
        });
        add(jLbEventos);
        jLbEventos.setBounds(0, 0, 120, 140);

        jLbImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exagonal/dirt_02.png"))); // NOI18N
        jLbImagen.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLbImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbImagenMouseClicked(evt);
            }
        });
        add(jLbImagen);
        jLbImagen.setBounds(0, 0, 120, 140);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
//        rectanguloPuntero.setLocation(evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jLbImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbImagenMouseClicked
//        JOptionPane.showMessageDialog(null, getNumeroDeInstancia());
//        jLbImagen.setIcon(null);
    }//GEN-LAST:event_jLbImagenMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        dblClick();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        dblClick();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        dblClick();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dblClick();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        dblClick();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        dblClick();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        dblClick();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
       dblClick();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLbEventosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbEventosMouseExited
//        setEstaSeleccionado(false);
//        System.out.println("Saliendo de " +   this.getNombre() +"=" +this.getEstaSeleccionado());
    }//GEN-LAST:event_jLbEventosMouseExited

    private void jLbEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbEventosMouseClicked
//        dblClick();
    }//GEN-LAST:event_jLbEventosMouseClicked

    private int dosClicks=1;
    
    private void dblClick(){
        if(dosClicks==2){
            this.setEstaSeleccionado(true);
//            System.out.println("Entrando en " +   this.getNumeroDeInstancia() +"=" +this.getEstaSeleccionado());
        }
        dosClicks++;
        if(dosClicks>=3){dosClicks=1;}
        
    }

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
