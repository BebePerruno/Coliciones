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
import javax.swing.JOptionPane;

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
//            System.out.println("casa1.getMax() " + casa1.getMax()+"; mina1.getMax() " + mina1.getMax());
            for(int i=0; i<Casa.rsCasas.size(); i++){
                if(casaTiempoDeConstruccion>=Casa.rsCasas.get(i).getMax()){
                    casaTiempoDeConstruccion=0;
                    Casa.rsCasas.get(i).generandoRecursos();
//                    System.out.println("casa numero " + i);
                }
                Casa.rsCasas.get(i).setProgress(casaTiempoDeConstruccion);
            }
            
            for(int i=0; i<Mina.rsMinas.size(); i++){
                if(minaTiempoDeConstruccion>=Mina.rsMinas.get(i).getMax()){
                    minaTiempoDeConstruccion=0;
                    Mina.rsMinas.get(i).generandoRecursos();
                }
                Mina.rsMinas.get(i).setProgress(minaTiempoDeConstruccion);
            }
            
            for(int i=0; i<Farm.rsFarms.size(); i++){
                if(granjaTiempoDeConstruccion>=Farm.rsFarms.get(i).getMax()){
                    granjaTiempoDeConstruccion=0;
                    Farm.rsFarms.get(i).generandoRecursos();
                }
                Farm.rsFarms.get(i).setProgress(granjaTiempoDeConstruccion);
            }
            
//            jLPoblacion.setMax(AbstractTerritorio.rsTerritorios.size());
//            jLPoblacion.setProgress(AbstractTerritorio.poblacion);
//            jLPiedra.setProgress(minaTiempoDeConstruccion);
//            jLOro.setProgress(casaTiempoDeConstruccion);
//            jLAlimentos.setProgress(granjaTiempoDeConstruccion);
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
//            System.out.println("Tiempo="+casaTiempoDeConstruccion+"_"+minaTiempoDeConstruccion+"_"+granjaTiempoDeConstruccion);
//            jLPoblacion.setTexto("Poblacion " + Casa.poblacion);
//            jLPiedra.setTexto("Pidra " + Mina.recursosGeneradosPorTodasLasMinas);
//            jLOro.setTexto("Oro " + Casa.recursosGeneradosPorTodasLasCasas);
//            jLAlimentos.setTexto("Alimentos " + Farm.recursosGeneradosPorTodasLasGranjas);
        }
    }

    public static Rectangle rectanguloPuntero=new Rectangle(60,60);
    
    
    private int id=0;
     /**
     * 
     * Entonces debe programarse en el contenedor form.
     * @return 
     */
    public boolean estaSeleccionado(AbstractTerritorio un_territorio){
        boolean seleccionado=false;
        for(int i=0; i<Territorio.rsTerritorios.size(); i++){
            seleccionado=un_territorio.getBounds().intersects(Territorio.rsTerritorios.get(i).getBounds());
            if(punteroDelMouse1.getNumeroDeInstancia()!=Territorio.rsTerritorios.get(i).getNumeroDeInstancia()){
               id=i;
                if(seleccionado==true){
                    
                    return seleccionado;
                }
            }
        }
        return false;
    }
    
    private Eventos vEventos=new Eventos();
    /**
     * Creates new form FrmMapaExagonal
     */
    public FrmMapaExagonal() {
        initComponents();
        
        Casa casa=new Casa();
//        casa.setLocation(this.jLabel1.getLocation());
        
//        AbstractTerritorio.rsTerritorios.get(id).setVisible(false);
        getContentPane().add(casa);
        casa.setBounds(840, 80, 70, 70);
        casa.setVisible(true);
        JOptionPane.showMessageDialog(null, casa);
        
        AbstractTerritorio.setEventosParaTodasLasInstancias(vEventos);
        Casa.maxDelProgressBar=12;
        Mina.maxDelProgressBar=10;
        Farm.maxDelProgressBar=8;
        territorio1.setEventos(vEventos);
        territorio2.setEventos(vEventos);
        this.territorio3.setEventos(vEventos);
        this.territorio4.setEventos(vEventos);
        this.territorio5.setEventos(vEventos);
        this.territorio6.setEventos(vEventos);
        this.territorio7.setEventos(vEventos);
        territorio8.setEventos(vEventos);
        territorio9.setEventos(vEventos);
        territorio10.setEventos(vEventos);
        territorio11.setEventos(vEventos);
        territorio12.setEventos(vEventos);
        Motor h=new Motor();
//        JOptionPane.showMessageDialog(null, Casa.rsCasas.size());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        punteroDelMouse1 = new Exagonal.PunteroDelMouse();
        jLAlimentos = new Exagonal.Etiqueta();
        jLOro = new Exagonal.Etiqueta();
        jLMadera = new Exagonal.Etiqueta();
        jLPiedra = new Exagonal.Etiqueta();
        jLPoblacion = new Exagonal.Etiqueta();
        territorio1 = new Exagonal.Territorio();
        territorio2 = new Exagonal.Territorio();
        territorio3 = new Exagonal.Territorio();
        territorio4 = new Exagonal.Territorio();
        territorio5 = new Exagonal.Territorio();
        territorio6 = new Exagonal.Territorio();
        territorio7 = new Exagonal.Territorio();
        territorio8 = new Exagonal.Territorio();
        territorio9 = new Exagonal.Territorio();
        territorio10 = new Exagonal.Territorio();
        territorio11 = new Exagonal.Territorio();
        territorio12 = new Exagonal.Territorio();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);
        getContentPane().add(punteroDelMouse1);
        punteroDelMouse1.setBounds(900, 200, 42, 38);

        getContentPane().add(jLAlimentos);
        jLAlimentos.setBounds(120, 0, 150, 47);

        jLOro.setMax(9);
        jLOro.setTexto("Oro");
        getContentPane().add(jLOro);
        jLOro.setBounds(280, 0, 150, 47);

        jLMadera.setTexto("Madera");
        getContentPane().add(jLMadera);
        jLMadera.setBounds(440, 0, 150, 47);

        jLPiedra.setTexto("Piedra");
        getContentPane().add(jLPiedra);
        jLPiedra.setBounds(600, 0, 150, 47);

        jLPoblacion.setTexto("Poblacion");
        getContentPane().add(jLPoblacion);
        jLPoblacion.setBounds(770, 0, 150, 47);
        getContentPane().add(territorio1);
        territorio1.setBounds(650, 170, 120, 140);
        getContentPane().add(territorio2);
        territorio2.setBounds(100, 170, 120, 140);
        getContentPane().add(territorio3);
        territorio3.setBounds(40, 70, 120, 140);
        getContentPane().add(territorio4);
        territorio4.setBounds(150, 70, 120, 140);
        getContentPane().add(territorio5);
        territorio5.setBounds(210, 170, 120, 140);
        getContentPane().add(territorio6);
        territorio6.setBounds(260, 70, 120, 140);
        getContentPane().add(territorio7);
        territorio7.setBounds(150, 270, 120, 140);
        getContentPane().add(territorio8);
        territorio8.setBounds(320, 170, 120, 140);
        getContentPane().add(territorio9);
        territorio9.setBounds(430, 170, 120, 140);
        getContentPane().add(territorio10);
        territorio10.setBounds(490, 70, 120, 140);
        getContentPane().add(territorio11);
        territorio11.setBounds(490, 270, 120, 140);
        getContentPane().add(territorio12);
        territorio12.setBounds(540, 170, 120, 140);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(840, 300, 70, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detectar(){
        for (int i=0; i<Territorio.rsTerritorios.size(); i++){
            if(Territorio.rsTerritorios.get(i).getEstaSeleccionado()==true){
//                 this.setTitle("Territorio seleccionado " + Territorio.rsTerritorios.get(i).getNumeroDeInstancia());
            }else{
//                System.out.println("No colicion");
            }
        }
    }
    
    private void territorio2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio2MouseMoved
        
    }//GEN-LAST:event_territorio2MouseMoved

    private void territorio3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio3MouseMoved
        
    }//GEN-LAST:event_territorio3MouseMoved

    private void territorio4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio4MouseMoved
        
    }//GEN-LAST:event_territorio4MouseMoved

    private void territorio1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio1MouseMoved
        
    }//GEN-LAST:event_territorio1MouseMoved

    private void territorio6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio6MouseMoved
      
    }//GEN-LAST:event_territorio6MouseMoved

    private void territorio5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_territorio5MouseMoved
        
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
//            System.out.println("Click");
        }

        @Override
        public void eveDobleClick(int x, int y, Point puntoXY) {
            for(int i=1; i<AbstractTerritorio.rsTerritorios.size(); i++){
                if(estaSeleccionado(punteroDelMouse1)){//(AbstractTerritorio.rsTerritorios.get(id).getEstaSeleccionado()==true){
                    
                    class FrmOpcionesDeConstruccion extends FrmMenu{

                        @Override
                        public void eveCancelar() {
                            //Operacion cancelada.
                        }

                        @Override
                        public void eveAceptar(int tipo_de_edificio) {
                            switch(tipo_de_edificio){
                                case 1 -> {
                                    //Construir casa.
                                    Casa casa=new Casa();
                                    casa.setLocation(territorio8.getLocation());
                                    casa.setBounds(territorio8.getBounds());
                                    casa.setVisible(true);
                                    AbstractTerritorio.rsTerritorios.get(id).setVisible(false);
                                    getContentPane().add(casa);
                                    
                                    JOptionPane.showMessageDialog(null,"Casa "+id);
                                }
                                case 2 -> {
                                    //Construir granja.
                                    JOptionPane.showMessageDialog(null,"Granja");
                                }
                                case 3 -> {
                                    //Construir mina.
                                    JOptionPane.showMessageDialog(null,"Mina");
                                }
                            }
                        }

                    }
                    FrmOpcionesDeConstruccion frmOpciones=new FrmOpcionesDeConstruccion();
//                    JOptionPane.showMessageDialog(null,"Que desea hacer en el territorio numero " + AbstractTerritorio.rsTerritorios.get(id).getNumeroDeInstancia());
                    return;
                }
            }
        }

        
        
        @Override
        public void mousePressed() {
//            System.out.println("Numero de instancia " + instanciaNumero + "; cantiad de instancias " + cantidadDeInstancias);
        }

        @Override
        public void mouseMoviendose(int nuevoX, int nuevoY) {
            for(int i=1; i<AbstractTerritorio.rsTerritorios.size(); i++){
                punteroDelMouse1.setLocation(nuevoX-punteroDelMouse1.getWidth(), nuevoY-(punteroDelMouse1.getHeight()));
            }
                if(estaSeleccionado(punteroDelMouse1)==true ){
//                    System.out.println("El puntero esta en " + AbstractTerritorio.rsTerritorios.get(id).getNumeroDeInstancia() );
                }
        }

        @Override
        public void mouseArrastrastrado() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void eveMouseHaSalido() {
//            System.out.println("El mouse ha salido.");
            punteroDelMouse1.setVisible(false);
        }

        @Override
        public void eveMouseHaEntrado() {
            punteroDelMouse1.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Exagonal.Etiqueta jLAlimentos;
    private Exagonal.Etiqueta jLMadera;
    private Exagonal.Etiqueta jLOro;
    private Exagonal.Etiqueta jLPiedra;
    private Exagonal.Etiqueta jLPoblacion;
    private javax.swing.JLabel jLabel1;
    private Exagonal.PunteroDelMouse punteroDelMouse1;
    private Exagonal.Territorio territorio1;
    private Exagonal.Territorio territorio10;
    private Exagonal.Territorio territorio11;
    private Exagonal.Territorio territorio12;
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
