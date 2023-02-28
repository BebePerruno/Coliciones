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
public abstract class FrmBuscarSemanas extends javax.swing.JFrame implements TotalesSemanales {

    
    @Override
    public void setTotalDeHoras(String nuevo_total){
        this.jTxtTotalDeHoras.setText(nuevo_total);
    }
    
    @Override
    public String getTotalDeHoras(){
        double valor=0;
        try{
            valor=Double.parseDouble(jTxtTotalDeHoras.getText());
        }catch(Exception e){}
        return valor+"";
    }
    
    /**
     * Creates new form FrmSemanasDeTrabajo
     */
    public FrmBuscarSemanas() {
        initComponents();
    }

    public FrmBuscarSemanas(RsSemanasDeTrabajo nuevas_semanas_para_buscar) {
        initComponents();
        try {
            this.jList1.setModel(nuevas_semanas_para_buscar.getAbstractListModel());
        } catch (getAbstractListModelException ex) {
            Logger.getLogger(FrmBuscarSemanas.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jBtnSalir = new javax.swing.JButton();
        jLbTotalDeHoras = new javax.swing.JLabel();
        jTxtTotalDeHoras = new javax.swing.JTextField();

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 290, 170));

        jLabel1.setText("Elija una fecha ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 280, -1));

        jLabel2.setText("Busqueda por fecha de inicio de semana");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, -1));

        jBtnSalir.setText("Mostrar resultados de la busqueda y salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 270, -1));

        jLbTotalDeHoras.setText("Total de horas trabajadas");
        getContentPane().add(jLbTotalDeHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        jTxtTotalDeHoras.setText("0");
        getContentPane().add(jTxtTotalDeHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public abstract void eveMostrarResultados();
    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    public abstract void eveItemSeleccionado(String datos);
    
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
//        System.out.println("Valor seleccionado "+jList1.getSelectedValue());
        eveItemSeleccionado(jList1.getSelectedValue());
        
    }//GEN-LAST:event_jList1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLbTotalDeHoras;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtTotalDeHoras;
    // End of variables declaration//GEN-END:variables
}
