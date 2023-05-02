/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Exagonal;

import java.awt.Point;

/**
 *
 * @author Jugador
 */
public abstract class FrmMenu extends javax.swing.JFrame {
    
    
    private class EventosMina extends AbstractDoubleClick{

        @Override
        public void eveClick(int x, int y, Point puntoXY) {
            rbtnMina.setSelected(true);
        }

        @Override
        public void eveDobleClick(int x, int y, Point puntoXY) {
            eveAceptar(getNumeroDeCasa());
            dispose();
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
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void eveMouseHaEntrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    private class EventosGranja extends AbstractDoubleClick{

        @Override
        public void eveClick(int x, int y, Point puntoXY) {
            rbtnGranja.setSelected(true);
        }

        @Override
        public void eveDobleClick(int x, int y, Point puntoXY) {
            eveAceptar(getNumeroDeCasa());
            dispose();
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
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void eveMouseHaEntrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    
    private class EventosCasa extends AbstractDoubleClick{

        @Override
        public void eveClick(int x, int y, Point puntoXY) {
            rbtnCasa.setSelected(true);
        }

        @Override
        public void eveDobleClick(int x, int y, Point puntoXY) {
            eveAceptar(getNumeroDeCasa());
            dispose();
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
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void eveMouseHaEntrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        this.casa1.setEventos(new FrmMenu.EventosCasa());
        this.mina1.setEventos(new FrmMenu.EventosMina());
        this.farm1.setEventos(new FrmMenu.EventosGranja());
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        casa1 = new Exagonal.Casa();
        farm1 = new Exagonal.Farm();
        mina1 = new Exagonal.Mina();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        rbtnCasa = new javax.swing.JRadioButton();
        rbtnGranja = new javax.swing.JRadioButton();
        rbtnMina = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opciones de construccion");
        setPreferredSize(new java.awt.Dimension(520, 350));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Elija el edificio que desea construir.");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 13, 350, 25);
        getContentPane().add(casa1);
        casa1.setBounds(0, 70, 121, 143);
        getContentPane().add(farm1);
        farm1.setBounds(190, 70, 119, 143);
        getContentPane().add(mina1);
        mina1.setBounds(390, 70, 121, 143);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(250, 270, 80, 25);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(150, 270, 80, 25);

        buttonGroup1.add(rbtnCasa);
        rbtnCasa.setText("Casa");
        getContentPane().add(rbtnCasa);
        rbtnCasa.setBounds(20, 220, 100, 25);

        buttonGroup1.add(rbtnGranja);
        rbtnGranja.setText("Granja");
        getContentPane().add(rbtnGranja);
        rbtnGranja.setBounds(220, 210, 100, 25);

        buttonGroup1.add(rbtnMina);
        rbtnMina.setText("Mina");
        getContentPane().add(rbtnMina);
        rbtnMina.setBounds(390, 210, 101, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 1) Construir casa.
     * 2) Construir granja.
     * 3) Construir mina.
     * @param tipo_de_edificio Un numero del 1 al 3 que indica que tipo de edificio se construirá.
     */
    public abstract void eveAceptar(int tipo_de_edificio);
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        eveAceptar(getNumeroDeCasa());
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private int getNumeroDeCasa(){
        if(rbtnCasa.isSelected()==true){ return 1;}
        if(rbtnGranja.isSelected()==true){ return 2;}
        if(rbtnMina.isSelected()==true){ return 3;}
        return 0;
    }
    
    public abstract void eveCancelar();
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       eveCancelar();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private Exagonal.Casa casa1;
    private Exagonal.Farm farm1;
    private javax.swing.JLabel jLabel1;
    private Exagonal.Mina mina1;
    private javax.swing.JRadioButton rbtnCasa;
    private javax.swing.JRadioButton rbtnGranja;
    private javax.swing.JRadioButton rbtnMina;
    // End of variables declaration//GEN-END:variables
}
