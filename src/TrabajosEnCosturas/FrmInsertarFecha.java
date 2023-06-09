/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TrabajosEnCosturas;

/**
 *
 * @author Jugador
 */
public abstract class FrmInsertarFecha extends javax.swing.JFrame {

    /**
     * Creates new form FrmInsertarFecha
     */
    public FrmInsertarFecha() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCmbMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTxtAño = new javax.swing.JTextField();
        jBtnAceptar = new javax.swing.JButton();
        jCmbDiasDeLaSemana = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Dia");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel2.setText("Mes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jCmbMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Nobiembre", "Diciembre" }));
        jCmbMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbMesMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 120, -1));

        jLabel3.setText("Año");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jTxtAño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTxtAño.setText("2003");
        getContentPane().add(jTxtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 110, -1));

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jCmbDiasDeLaSemana.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCmbDiasDeLaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jCmbDiasDeLaSemana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCmbDiasDeLaSemanaMouseClicked(evt);
            }
        });
        getContentPane().add(jCmbDiasDeLaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Formulario para fechas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public abstract void eveFechaGenerada(String nueva_fecha);
    private String fecha="";
    
    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        dia=jCmbDiasDeLaSemana.getSelectedItem()+"";
        mes=jCmbMes.getSelectedItem()+"";
        if(jTxtAño.getText().isEmpty()==true){
            fecha=dia+"/"+mes+"/0000";
        }
        else{
               fecha=dia+"/"+mes+"/"+this.jTxtAño.getText();     
        }
        eveFechaGenerada(fecha);
        this.dispose();
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private String dia="";
    
    private void jCmbDiasDeLaSemanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbDiasDeLaSemanaMouseClicked
//        System.out.println("jCmbDiasDeLaSemana.getSelectedItem()="+jCmbDiasDeLaSemana.getSelectedItem());
//        dia=jCmbDiasDeLaSemana.getSelectedItem()+"";
    }//GEN-LAST:event_jCmbDiasDeLaSemanaMouseClicked

    private String mes="";
    
    private void jCmbMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCmbMesMouseClicked
//        System.out.println("jCmbMes.getSelectedItem()="+jCmbMes.getSelectedItem());
//        mes=jCmbMes.getSelectedItem()+"";
    }//GEN-LAST:event_jCmbMesMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JComboBox<String> jCmbDiasDeLaSemana;
    private javax.swing.JComboBox<String> jCmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTxtAño;
    // End of variables declaration//GEN-END:variables
}
