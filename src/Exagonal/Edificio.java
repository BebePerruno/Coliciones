/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Exagonal;

import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jugador
 */
public abstract class Edificio extends AbstractTerritorio {
    private int vMax=0;
    
    public void setMax(int nuevo_maximo){
        vMax=nuevo_maximo;
        jProgressBar1.setMaximum(vMax);
    }
    
    public int getMax(){
        return jProgressBar1.getMaximum();
    }
    
    private int valor=0;

    public void setProgress(int nuevo_progreso){
        valor=nuevo_progreso;//jProgressBar1.getValue()+1;
        jProgressBar1.setValue(valor);
    }
    
    
    private int recursosGenerados=0;
    
    public abstract void generandoRecursos();
    
    public void setRecursosEnGenerados(int nuevos_recursos){
        recursosGenerados=nuevos_recursos;
    }
    
    public int getRecursosEnGenerados(){
        return recursosGenerados;
    }
    
    private int cantidadDeRecursosHaGenerar=1;
    
    public void setCantidadDeRecursosHaGenerar(int nueva_cantidad_para_producir){
        cantidadDeRecursosHaGenerar=nueva_cantidad_para_producir;
    }
    public int getCantidadDeRecursosHaGenerar(){
        return cantidadDeRecursosHaGenerar;
    }
    
    private class Evento extends AbstractDoubleClick{

        @Override
        public void eveClick(int x, int y, Point puntoXY) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void eveDobleClick(int x, int y, Point puntoXY) {
//            JOptionPane.showMessageDialog(null, "Recursos generados en " + getNombre() + "=" + getRecursosEnGenerados());
//            recursosGenerados++;
        }

        @Override
        public void mouseMoviendose(int nuevoX, int nuevoY) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseArrastrastrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void eveMouseHaSalido() {
            
        }

        @Override
        public void eveMouseHaEntrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    /**
     * Creates new form NewJPanel
     */
    public Edificio() {
        initComponents();
        this.setEventos(new Evento());
        jProgressBar1.setMinimum(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();

        setPreferredSize(new java.awt.Dimension(138, 120));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);

        jProgressBar1.setBackground(new java.awt.Color(0, 255, 51));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jProgressBar1);
        jProgressBar1.setBounds(0, 0, 50, 16);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
