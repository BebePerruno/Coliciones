/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TrabajosEnCosturas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jugador
 */
public abstract class FrmBuscarDias extends javax.swing.JFrame {

    private DiaDeTrabajo unDia=null;
    /**
     * Creates new form FrmBuscarDias
     */
    public FrmBuscarDias(RsDiasDeTrabajo todos_los_dias_de_trabajo) {
        initComponents();
        try {
            this.jList1.setModel(todos_los_dias_de_trabajo.getAbstractListModel());
        } catch (getAbstractListModelException ex) {
            System.out.println("En FrmBuscarDias\n"+ex.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jBtnSalir = new javax.swing.JButton();
        jTxtBuscar = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 106, 505, 200));

        jLabel1.setText("Elija un item para buscarlo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, 274, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Busqueda de registros por medio \nde la fecha del dia de trabajo.");
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 500, 60));

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 60, -1));

        jTxtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(jTxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 360, -1));

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    public abstract void eveItemSeleccionado(DiaDeTrabajo un_dia_de_trabajo_seleccionado);
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        this.jTxtBuscar.setText(jList1.getSelectedValue() + "");
        
    }//GEN-LAST:event_jList1MouseClicked

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        DiaDeTrabajo dia=new DiaDeTrabajo(this.jTxtBuscar.getText());
        this.eveItemSeleccionado(dia);
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTxtBuscar;
    // End of variables declaration//GEN-END:variables
}
