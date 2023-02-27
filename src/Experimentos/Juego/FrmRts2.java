/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Experimentos.Juego;

/**
 *
 * @author Rafae
 */
public class FrmRts2 extends javax.swing.JFrame {

    /**
     * Creates new form FrmRts2
     */
    public FrmRts2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaDeJuego1 = new Experimentos.Juego.AreaDeJuego();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMnuBase = new javax.swing.JMenuItem();
        jMnuGenerador = new javax.swing.JMenuItem();
        jMnuGranjaPequeña = new javax.swing.JMenuItem();
        jMnuGranjaGrande = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        areaDeJuego1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 153), 5, true));
        getContentPane().add(areaDeJuego1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 480));

        jMenu1.setText("Crear");

        jMnuBase.setText("Base");
        jMnuBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuBaseActionPerformed(evt);
            }
        });
        jMenu1.add(jMnuBase);

        jMnuGenerador.setText("Generador");
        jMnuGenerador.setToolTipText("1");
        jMnuGenerador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuGeneradorActionPerformed(evt);
            }
        });
        jMenu1.add(jMnuGenerador);

        jMnuGranjaPequeña.setText("Granje pequeña");
        jMnuGranjaPequeña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuGranjaPequeñaActionPerformed(evt);
            }
        });
        jMenu1.add(jMnuGranjaPequeña);

        jMnuGranjaGrande.setText("Granja grande");
        jMnuGranjaGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuGranjaGrandeActionPerformed(evt);
            }
        });
        jMenu1.add(jMnuGranjaGrande);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        this.areaDeJuego1.keyPressed(evt);
    }//GEN-LAST:event_formKeyPressed

    private void jMnuBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuBaseActionPerformed
        areaDeJuego1.setNumeroDeEdificio(2);
    }//GEN-LAST:event_jMnuBaseActionPerformed

    private void jMnuGeneradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuGeneradorActionPerformed
        areaDeJuego1.setNumeroDeEdificio(1);
    }//GEN-LAST:event_jMnuGeneradorActionPerformed

    private void jMnuGranjaGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuGranjaGrandeActionPerformed
        areaDeJuego1.setNumeroDeEdificio(3);
    }//GEN-LAST:event_jMnuGranjaGrandeActionPerformed

    private void jMnuGranjaPequeñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuGranjaPequeñaActionPerformed
        areaDeJuego1.setNumeroDeEdificio(4);
    }//GEN-LAST:event_jMnuGranjaPequeñaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRts2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRts2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRts2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRts2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRts2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Experimentos.Juego.AreaDeJuego areaDeJuego1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMnuBase;
    private javax.swing.JMenuItem jMnuGenerador;
    private javax.swing.JMenuItem jMnuGranjaGrande;
    private javax.swing.JMenuItem jMnuGranjaPequeña;
    // End of variables declaration//GEN-END:variables
}
