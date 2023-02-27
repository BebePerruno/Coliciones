/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sonidos;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Rafael
 */
public class FrmSonidos extends javax.swing.JFrame {

    private Clip sonidoFondo;
    
    public void reproducirSonido(URL ruta) throws Exception{
    
        //Clip sonido = AudioSystem.getClip();
        sonidoFondo=null;
        sonidoFondo= AudioSystem.getClip();
        sonidoFondo.open(AudioSystem.getAudioInputStream(ruta));
        if(!sonidoFondo.isRunning()){
            sonidoFondo.start();

        }
    }
    
    private final String SonidosDeFondo="/Audios/CA-March-On-FULL-Loop.wav";
    private final String SonidoDeBoton="/Audios/Mogngo perruno.wav";
    
    /**
     * Creates new form FrmSonidos
     */
    public FrmSonidos() {
        initComponents();
        /**
         * Sonido de fondo.
         */
        try {
            sonidoFondo= AudioSystem.getClip();
            sonidoFondo.open(AudioSystem.getAudioInputStream(getClass().getResource(SonidosDeFondo)));
            sonidoFondo.loop(0);
        } catch (Exception ex) {
            System.out.println("Error de sonido");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnSonar = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBtnSonar.setText("Sonar");
        jBtnSonar.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jBtnSonar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jBtnSonar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jBtnSonar) {
                FrmSonidos.this.jBtnSonarActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSonarActionPerformed
        try {
            reproducirSonido(getClass().getResource(SonidoDeBoton));
        } catch (Exception ex) {
            Logger.getLogger(FrmSonidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnSonarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSonidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSonidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSonidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSonidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSonidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSonar;
    // End of variables declaration//GEN-END:variables
}
