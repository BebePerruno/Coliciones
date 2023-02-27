/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Propiedades;

/**
 *
 * @author Rafae
 */
public abstract class FrmPropiedadesRapidas extends javax.swing.JFrame {

    /**
     * Creates new form FrmPropiedadesRapidas
     */
    public FrmPropiedadesRapidas() {
        initComponents();
//        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtNumero = new javax.swing.JTextField();
        jBtnAceptar = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 22, -1, -1));
        getContentPane().add(jTxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 14, 280, -1));

        jLabel2.setText("Numero");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 70, -1, -1));

        jTxtNumero.setText("0");
        getContentPane().add(jTxtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 70, 98, -1));

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(formListener);
        getContentPane().add(jBtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 126, -1, -1));

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jBtnAceptar) {
                FrmPropiedadesRapidas.this.jBtnAceptarActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    public abstract void Evento_Aceptar(Modelo respuesta);
    
    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        Modelo unModelo=new Modelo();
        unModelo.Nombre.set(jTxtNombre.getText());
        unModelo.Numero.set(Integer.parseInt(this.jTxtNumero.getText()));
        Evento_Aceptar(unModelo);
        this.dispose();
    }//GEN-LAST:event_jBtnAceptarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtNumero;
    // End of variables declaration//GEN-END:variables
}
