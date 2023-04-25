/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Exagonal;

import static Exagonal.AbstractTerritorio.cantidadDeInstancias;
import ExperimentosConJuegos.HiloProductorConsumidor;
import java.awt.Point;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jugador
 */
public class FrmMapaExagonal extends javax.swing.JFrame {
    
    private class Motor extends HiloProductorConsumidor{
        private int tiempoDeConstruccion=0;
        private int casaTiempoDeConstruccion=0;
        private int minaTiempoDeConstruccion=0;
        private int granjaTiempoDeConstruccion=0;
        
        @Override
        public void produciendo() {
            System.out.println("casa1.getMax() " + casa1.getMax()+"; mina1.getMax() " + mina1.getMax());
            if(casaTiempoDeConstruccion>=casa1.getMax()){
                casaTiempoDeConstruccion=0;
                casa1.generandoRecursos();
            }
            
            if(minaTiempoDeConstruccion>=mina1.getMax()){
                minaTiempoDeConstruccion=0;
                mina1.generandoRecursos();
            }
            
            if(granjaTiempoDeConstruccion>=farm1.getMax()){
                granjaTiempoDeConstruccion=0;
                farm1.generandoRecursos();
                farm2.generandoRecursos();
            }
            
            casa1.setProgress(casaTiempoDeConstruccion);
            mina1.setProgress(minaTiempoDeConstruccion);
            farm1.setProgress(granjaTiempoDeConstruccion);
            farm2.setProgress(granjaTiempoDeConstruccion);
            jLPoblacion.setMax(AbstractTerritorio.rsTerritorios.size());
            jLPoblacion.setProgress(AbstractTerritorio.poblacion);
            jLPiedra.setProgress(minaTiempoDeConstruccion);
            jLOro.setProgress(casaTiempoDeConstruccion);
            jLAlimentos.setProgress(granjaTiempoDeConstruccion);
            granjaTiempoDeConstruccion++;
            minaTiempoDeConstruccion++;
            casaTiempoDeConstruccion++;
            
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
//                Logger.getLogger(FrmMapaExagonal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void gastado(boolean llenar_recipiente) {
            
//            int consumido=granja1.getRecursosEnGenerados()-Casa.ConsumoDeComida();
//            granja1.setRecursosEnGenerados(consumido);
//            System.out.println("Consumiendo " + consumido + "=" + granja1.getRecursosEnGenerados());
//            System.out.println( "=" + granja1.getRecursosEnGenerados());
//            mina1.setRecursosEnGenerados(granja1.getRecursosEnGenerados()-casa1.getCantidadDeRecursosHaGenerar());
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
//                Logger.getLogger(FrmMapaExagonal.class.getName()).log(Level.SEVERE, null, ex);
            }
            llenar_recipiente=true;
        }

        
        @Override
        public void evento() {
            System.out.println("Tiempo="+casaTiempoDeConstruccion+"_"+minaTiempoDeConstruccion+"_"+granjaTiempoDeConstruccion);
            jLPoblacion.setTexto("Poblacion " + Casa.poblacion);
            jLPiedra.setTexto("Pidra " + Mina.recursosGeneradosPorTodasLasMinas);
            jLOro.setTexto("Oro " + Casa.recursosGeneradosPorTodasLasCasas);
            jLAlimentos.setTexto("Alimentos " + farm1.recursosGeneradosPorTodasLasGranjas);
        }

        
    }

    public static Rectangle rectanguloPuntero=new Rectangle(60,60);
    
     /**
     * 
     * Entonces debe programarse en el contenedor form.
     * @return 
     */
    public boolean estaSeleccionado(AbstractTerritorio un_territorio){
        return un_territorio.getBounds().intersects(territorio7.getBounds());
    }
    
    private Eventos vEventos=new Eventos();
    /**
     * Creates new form FrmMapaExagonal
     */
    public FrmMapaExagonal() {
        initComponents();
        AbstractTerritorio.setEventosParaTodasLasInstancias(vEventos);
        this.territorio1.setEventos(vEventos);
        territorio2.setEventos(vEventos);
        territorio3.setEventos(vEventos);
        territorio4.setEventos(vEventos);
        territorio5.setEventos(vEventos);
        territorio6.setEventos(vEventos);
        territorio7.setImagen(new ImagenesExagonales().getPunero());
        
//        jProgressBar1.setMaximum(20);
//        jProgressBar1.setMinimum(0);
        
//        territorio7.setEventos(vEventos);
Motor h=new Motor();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        mina1 = new Exagonal.Mina();
        territorio1 = new Exagonal.Territorio();
        territorio2 = new Exagonal.Territorio();
        territorio3 = new Exagonal.Territorio();
        territorio4 = new Exagonal.Territorio();
        territorio5 = new Exagonal.Territorio();
        territorio6 = new Exagonal.Territorio();
        territorio7 = new Exagonal.Territorio();
        territorio8 = new Exagonal.Territorio();
        territorio9 = new Exagonal.Territorio();
        farm1 = new Exagonal.Farm();
        farm2 = new Exagonal.Farm();
        jLAlimentos = new Exagonal.Etiqueta();
        jLOro = new Exagonal.Etiqueta();
        jLMadera = new Exagonal.Etiqueta();
        jLPiedra = new Exagonal.Etiqueta();
        jLPoblacion = new Exagonal.Etiqueta();
        casa1 = new Exagonal.Casa();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(690, 60, 77, 25);

        mina1.setCantidadDeRecursosHaGenerar(5);
        mina1.setMax(7);
        getContentPane().add(mina1);
        mina1.setBounds(450, 180, 120, 140);
        getContentPane().add(territorio1);
        territorio1.setBounds(270, 280, 130, 140);
        getContentPane().add(territorio2);
        territorio2.setBounds(50, 80, 130, 140);
        getContentPane().add(territorio3);
        territorio3.setBounds(160, 80, 130, 140);
        getContentPane().add(territorio4);
        territorio4.setBounds(170, 280, 130, 140);
        getContentPane().add(territorio5);
        territorio5.setBounds(220, 180, 130, 140);

        territorio6.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Exagonal/dirt_06.png"))); // NOI18N
        getContentPane().add(territorio6);
        territorio6.setBounds(270, 80, 130, 140);
        getContentPane().add(territorio7);
        territorio7.setBounds(330, 180, 130, 140);
        getContentPane().add(territorio8);
        territorio8.setBounds(110, 180, 130, 140);
        getContentPane().add(territorio9);
        territorio9.setBounds(0, 180, 130, 140);

        farm1.setCantidadDeRecursosHaGenerar(4);
        farm1.setMax(5);
        getContentPane().add(farm1);
        farm1.setBounds(510, 280, 120, 140);

        farm2.setCantidadDeRecursosHaGenerar(4);
        farm2.setMax(5);
        getContentPane().add(farm2);
        farm2.setBounds(570, 180, 120, 140);

        jLAlimentos.setMax(farm1.getMax());
        getContentPane().add(jLAlimentos);
        jLAlimentos.setBounds(120, 0, 150, 47);

        jLOro.setMax(9);
        jLOro.setTexto("Oro");
        getContentPane().add(jLOro);
        jLOro.setBounds(280, 0, 150, 47);

        jLMadera.setTexto("Madera");
        getContentPane().add(jLMadera);
        jLMadera.setBounds(440, 0, 150, 47);

        jLPiedra.setMax(mina1.getMax());
        jLPiedra.setTexto("Piedra");
        getContentPane().add(jLPiedra);
        jLPiedra.setBounds(600, 0, 150, 47);

        jLPoblacion.setTexto("Poblacion");
        getContentPane().add(jLPoblacion);
        jLPoblacion.setBounds(770, 0, 150, 47);

        casa1.setCantidadDeRecursosHaGenerar(2);
        casa1.setMax(9);
        getContentPane().add(casa1);
        casa1.setBounds(820, 250, 120, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detectar(){
//        for (int i=0; i<Territorio.rsTerritorios.size(); i++){
//            if(Territorio.rsTerritorios.get(i).estaSeleccionado()==true){
//                 this.setTitle("Territorio seleccionado " + Territorio.rsTerritorios.get(i).instanciaNumero);
//            }else{
//                System.out.println("No colicion");
//            }
//        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//       jProgressBar1.setValue(jProgressBar1.getValue()+1);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void territorio2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio2MouseMoved
        territorio7.setLocation(territorio7.getX(), territorio7.getY());
    }//GEN-LAST:event_territorio2MouseMoved

    private void territorio3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio3MouseMoved
        territorio7.setLocation(territorio3.getX(), territorio3.getY());
    }//GEN-LAST:event_territorio3MouseMoved

    private void territorio4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio4MouseMoved
        territorio7.setLocation(territorio4.getX(), territorio4.getY());
    }//GEN-LAST:event_territorio4MouseMoved

    private void territorio1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio1MouseMoved
        territorio7.setLocation(territorio1.getX(), territorio1.getY());
    }//GEN-LAST:event_territorio1MouseMoved

    private void territorio6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio6MouseMoved
       territorio7.setLocation(territorio6.getX(), territorio6.getY());
    }//GEN-LAST:event_territorio6MouseMoved

    private void territorio5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio5MouseMoved
        territorio7.setLocation(territorio5.getX(), territorio5.getY());
    }//GEN-LAST:event_territorio5MouseMoved

    private void territorio8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio8MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_territorio8MouseMoved

    private void territorio9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio9MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_territorio9MouseMoved

    private void territorio10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio10MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_territorio10MouseMoved

    private void territorio11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio11MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_territorio11MouseMoved

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
            java.util.logging.Logger.getLogger(FrmMapaExagonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMapaExagonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMapaExagonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMapaExagonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmMapaExagonal().setVisible(true);
            }
        });
    }
    
    class Eventos extends AbstractDoubleClick{
        @Override
        public void eveClick(int x, int y, Point puntoXY) {
            System.out.println("Click");
        }

        @Override
        public void eveDobleClick(int x, int y, Point puntoXY) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed() {
//            System.out.println("Numero de instancia " + instanciaNumero + "; cantiad de instancias " + cantidadDeInstancias);
        }

        @Override
        public void mouseMoviendose(int nuevoX, int nuevoY) {
            
            for(int i=1; i<AbstractTerritorio.rsTerritorios.size(); i++){
//                if(territorio7.getNumeroDeInstancia()!=Territorio.rsTerritorios.get(i).getNumeroDeInstancia()){
                    territorio7.setLocation(nuevoX-territorio7.getWidth(), nuevoY-(territorio7.getHeight()));
//                }
                if(estaSeleccionado(AbstractTerritorio.rsTerritorios.get(i))==true ){
                    System.out.println("El puntero esta en " + AbstractTerritorio.rsTerritorios.get(i).getNumeroDeInstancia() );
//                    break;
                }
            }
        }

        @Override
        public void mouseArrastrastrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Exagonal.Casa casa1;
    private Exagonal.Farm farm1;
    private Exagonal.Farm farm2;
    private javax.swing.JButton jButton1;
    private Exagonal.Etiqueta jLAlimentos;
    private Exagonal.Etiqueta jLMadera;
    private Exagonal.Etiqueta jLOro;
    private Exagonal.Etiqueta jLPiedra;
    private Exagonal.Etiqueta jLPoblacion;
    private Exagonal.Mina mina1;
    private Exagonal.Territorio territorio1;
    private Exagonal.Territorio territorio2;
    private Exagonal.Territorio territorio3;
    private Exagonal.Territorio territorio4;
    private Exagonal.Territorio territorio5;
    private Exagonal.Territorio territorio6;
    private Exagonal.Territorio territorio7;
    private Exagonal.Territorio territorio8;
    private Exagonal.Territorio territorio9;
    // End of variables declaration//GEN-END:variables
}
