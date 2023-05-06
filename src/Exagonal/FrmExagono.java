/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Exagonal;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jugador
 */
public class FrmExagono extends javax.swing.JFrame {

    private FrmLienzo f=new FrmLienzo();
    /**
     * Creates new form NewJFrame
     */
    public FrmExagono() {
        initComponents();
        
        class Eve extends AbstractDoubleClick{
             private Punto p;
            

            @Override
            public void mousePressed() {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void eveClick(int x, int y, Point puntoXY) {
                txtInicial.setText("1) X inicial " + x + ", y inicial "  + y );
                p=new Punto();
                p.xInicial=x;
                p.yInicial=y;
            }

            @Override
            public void eveDobleClick(int x, int y, Point puntoXY) {
                txtFinal.setText("2) X final" + x + ", y final "  + y );
                p.xFinal=x;
                p.yFinal=y;
                rsPuntos.add(p);
                try{
                    Rectangulo cuadro1=new Rectangulo(rsPuntos.get(0),rsPuntos.get(1),rsPuntos.get(2),rsPuntos.get(3));
                    Rectangulo cuadro2=new Rectangulo(rsPuntos.get(4),rsPuntos.get(5),rsPuntos.get(6),rsPuntos.get(7));
                JOptionPane.showMessageDialog(null, cuadro1.Colicion(cuadro2));}catch(Exception e){}
                jLstCoorenadasDelExagono.setModel(new Lista());
                f.dibujar(rsPuntos);
                f.setVisible(true);
                p=null;
            }

            @Override
            public void mouseMoviendose(int nuevoX, int nuevoY) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseArrastrastrado() {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void eveMouseHaSalido() {
                //
            }

            @Override
            public void eveMouseHaEntrado() {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }
        
        
        jLstCoorenadasDelExagono.setModel(new Lista());
        
//        jLbEventos.addMouseListener(new Eve());
        this.setBounds(100, 100, 800, 550);
    }
    
    class Lista extends AbstractListModel<String>{

            @Override
            public int getSize() {
                return rsPuntos.size();
            }

            @Override
            public String getElementAt(int index) {
                return rsPuntos.get(index).toString();
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

        txtInicial = new javax.swing.JTextField();
        txtFinal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstCoorenadasDelExagono = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 550));
        getContentPane().setLayout(null);

        txtInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInicial.setText("0");
        getContentPane().add(txtInicial);
        txtInicial.setBounds(440, 230, 320, 30);

        txtFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFinal.setText("0");
        getContentPane().add(txtFinal);
        txtFinal.setBounds(440, 280, 320, 30);

        jLstCoorenadasDelExagono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLstCoorenadasDelExagono.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jLstCoorenadasDelExagono);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 320, 520, 146);

        jLabel3.setText("Lista de coordenadas del exagono");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 300, 200, 16);

        jLabel4.setText("Coordenadas finales");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(440, 260, 220, 20);

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalir);
        jBtnSalir.setBounds(680, 20, 77, 25);

        jLabel5.setText("Coordenadas iniciales");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(440, 210, 220, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents
private int mouseClick=1;
    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
           System.exit(0);
    }//GEN-LAST:event_jBtnSalirActionPerformed

    
    
    private ArrayList<Punto> rsPuntos=new ArrayList<Punto>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jLstCoorenadasDelExagono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFinal;
    private javax.swing.JTextField txtInicial;
    // End of variables declaration//GEN-END:variables
}
