/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Exagonal;

import static Exagonal.AbstractTerritorio.cantidadDeInstancias;
import juegoConJLabels.HiloProductorConsumidor;
import java.awt.Point;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
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
                if(casaTiempoDeConstruccion>Casa.rsCasas.get(i).getMax()){
                    casaTiempoDeConstruccion=0;
                    if(Casa.rsCasas.get(i).isVisible()==true){
                        Casa.rsCasas.get(i).generandoRecursos();
                    }
                }
                Casa.rsCasas.get(i).setProgress(casaTiempoDeConstruccion);
            }
            
            for(int i=0; i<Mina.rsMinas.size(); i++){
                if(minaTiempoDeConstruccion>Mina.rsMinas.get(i).getMax()){
                    minaTiempoDeConstruccion=0;
                    if(Mina.rsMinas.get(i).isVisible()==true){
                        Mina.rsMinas.get(i).generandoRecursos();
                    }
                    
                }
                Mina.rsMinas.get(i).setProgress(minaTiempoDeConstruccion);
            }
            
            for(int i=0; i<Farm.rsFarms.size(); i++){
                if(granjaTiempoDeConstruccion>Farm.rsFarms.get(i).getMax()){
                    granjaTiempoDeConstruccion=0;
                    if(Farm.rsFarms.get(i).isVisible()==true){
                        Farm.rsFarms.get(i).generandoRecursos();
                    }
                }
                Farm.rsFarms.get(i).setProgress(granjaTiempoDeConstruccion);
            }
            
            jLPoblacion.setMax(Territorio.rsTerritorios.size());
            jLPoblacion.setProgress(Casa.poblacion);
            
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
//            System.out.println( "Gastando");
            this.setRecipienteLleno(false);
//            mina1.setRecursosEnGenerados(granja1.getRecursosEnGenerados()-casa1.getCantidadDeRecursosHaGenerar());
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
//                Logger.getLogger(FrmMapaExagonal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        

        @Override
        public void eventoProductor() {
            ////            System.out.println("Tiempo="+casaTiempoDeConstruccion+"_"+minaTiempoDeConstruccion+"_"+granjaTiempoDeConstruccion);
            jLPoblacion.setTexto("Poblacion " + Casa.poblacion+"/" +( (Territorio.rsTerritorios.size()-1)*Casa.habitantesPorCasa));
            jLPiedra.setTexto("Pidra " + Mina.recursosGeneradosPorTodasLasMinas);
            jLOro.setTexto("Oro " + Casa.recursosGeneradosPorTodasLasCasas);
            jLAlimentos.setTexto("Alimentos " + Farm.recursosGeneradosPorTodasLasGranjas);
            this.setRecipienteLleno(true);
        }

        @Override
        public void eventoConsumidor() {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    public boolean desactivarSeleccion(){
        boolean seleccionado=false;
        for(int i=0; i<Territorio.rsTerritorios.size(); i++){
            Territorio.rsTerritorios.get(i).setEstaSeleccionado(false);
        }
        return false;
    }
    
    private Eventos vEventos=new Eventos();
    /**
     * Creates new form FrmMapaExagonal
     */
    public FrmMapaExagonal() {
        initComponents();
        this.punteroDelMouse1.setVisible(false);
        JOptionPane.showMessageDialog(null, "Crear un editor de mapas.");
        this.jLPoblacion.setTexto("Poblacion 0/" +( (Territorio.rsTerritorios.size()-1)*Casa.habitantesPorCasa));
        Casa.maxDelProgressBar=8;
        Mina.maxDelProgressBar=7;
        Mina.recursosGeneradosPorTodasLasMinas=300;
        Farm.maxDelProgressBar=5;
        this.jLOro.setMax(Casa.maxDelProgressBar);
        this.jLPiedra.setMax(Mina.maxDelProgressBar);
        this.jLAlimentos.setMax(Farm.maxDelProgressBar);
        AbstractTerritorio.setEventosParaTodasLasInstancias(vEventos);
        Casa.recursosGeneradosPorTodasLasCasas=300; //Permite crear la primer casa.
        
        Farm.recursosGeneradosPorTodasLasGranjas=300;
        /**
         * Sirve más o menos.
         */
        for(int i=0; i<Territorio.rsTerritorios.size(); i++){
            Territorio.rsTerritorios.get(id).setEventos(vEventos);
        }
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

        jLAlimentos = new Exagonal.Etiqueta();
        jLOro = new Exagonal.Etiqueta();
        jLMadera = new Exagonal.Etiqueta();
        jLPiedra = new Exagonal.Etiqueta();
        jLPoblacion = new Exagonal.Etiqueta();
        jPanel1 = new javax.swing.JPanel();
        punteroDelMouse1 = new Exagonal.PunteroDelMouse();
        territorio1 = new Exagonal.Territorio();
        territorio2 = new Exagonal.Territorio();
        territorio4 = new Exagonal.Territorio();
        territorio7 = new Exagonal.Territorio();
        territorio5 = new Exagonal.Territorio();
        territorio6 = new Exagonal.Territorio();
        territorio8 = new Exagonal.Territorio();
        territorio10 = new Exagonal.Territorio();
        territorio9 = new Exagonal.Territorio();
        territorio12 = new Exagonal.Territorio();
        territorio3 = new Exagonal.Territorio();
        territorio11 = new Exagonal.Territorio();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        getContentPane().setLayout(null);

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

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(null);
        jPanel1.add(punteroDelMouse1);
        punteroDelMouse1.setBounds(640, 220, 42, 38);
        jPanel1.add(territorio1);
        territorio1.setBounds(0, 0, 120, 140);
        jPanel1.add(territorio2);
        territorio2.setBounds(120, 0, 120, 140);
        jPanel1.add(territorio4);
        territorio4.setBounds(60, 100, 120, 140);
        jPanel1.add(territorio7);
        territorio7.setBounds(0, 200, 120, 140);
        jPanel1.add(territorio5);
        territorio5.setBounds(120, 200, 120, 140);
        jPanel1.add(territorio6);
        territorio6.setBounds(180, 100, 120, 140);
        jPanel1.add(territorio8);
        territorio8.setBounds(240, 200, 120, 140);
        jPanel1.add(territorio10);
        territorio10.setBounds(300, 100, 120, 140);
        jPanel1.add(territorio9);
        territorio9.setBounds(420, 100, 120, 140);
        jPanel1.add(territorio12);
        territorio12.setBounds(480, 0, 120, 140);
        jPanel1.add(territorio3);
        territorio3.setBounds(600, 0, 120, 140);
        jPanel1.add(territorio11);
        territorio11.setBounds(480, 200, 120, 140);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 730, 360);

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
        private class FrmOpcionesDeConstruccion extends FrmMenu{

            @Override
            public void eveCancelar() {
                //Operacion cancelada.
            }
            
            @Override
            public void eveAceptar(int tipo_de_edificio) {
//                JOptionPane.showMessageDialog(null, Mina.precioEnOro + "vs"+Casa.precioEnOro + "vs"+Farm.precioEnOro);
                switch(getNumeroDeEdificio()){
                    case 1 -> {
                        //Construir casa.
                        
                        if(Casa.recursosGeneradosPorTodasLasCasas>=Casa.precioEnOro && Mina.recursosGeneradosPorTodasLasMinas>= Casa.precioEnPiedra && Farm.recursosGeneradosPorTodasLasGranjas>= Casa.precioEnAlimentos){
                            Casa.recursosGeneradosPorTodasLasCasas-=Casa.precioEnOro;
                            Mina.recursosGeneradosPorTodasLasMinas-= Casa.precioEnPiedra;
                            Farm.recursosGeneradosPorTodasLasGranjas-=Casa.precioEnPiedra;
                            
                            Casa casa=new Casa();
                            jPanel1.add(casa);

                            casa.setBounds(Territorio.rsTerritorios.get(id).getBounds());
                            casa.setVisible(true);

                            Territorio.rsTerritorios.get(id).setVisible(false);
                        }else{ 
                            JOptionPane.showMessageDialog(null, "No existen suficientes recursos para crear una casa.");
                        }
                    }
                    case 2 -> {
                        //Construir granja.
                        if(Casa.recursosGeneradosPorTodasLasCasas>=Farm.precioEnOro && Mina.recursosGeneradosPorTodasLasMinas>= Farm.precioEnPiedra && Farm.recursosGeneradosPorTodasLasGranjas>= Farm.precioEnAlimentos){
                            Casa.recursosGeneradosPorTodasLasCasas=Casa.recursosGeneradosPorTodasLasCasas-Farm.precioEnOro;
                            Mina.recursosGeneradosPorTodasLasMinas= Mina.recursosGeneradosPorTodasLasMinas-Farm.precioEnPiedra;
                            Farm.recursosGeneradosPorTodasLasGranjas=Farm.recursosGeneradosPorTodasLasGranjas-Farm.precioEnPiedra;
                            
                            Farm farm=new Farm();
                            jPanel1.add(farm);

                            farm.setBounds(Territorio.rsTerritorios.get(id).getBounds());
                            farm.setVisible(true);

                            Territorio.rsTerritorios.get(id).setVisible(false);
                        }
                        else{ 
                            JOptionPane.showMessageDialog(null, "No existen suficientes recursos para crear una granja.");
                        }
                        
                    }
                    case 3 -> {
                        //Construir mina.
                        
                        if(Casa.recursosGeneradosPorTodasLasCasas>=Mina.precioEnOro && Mina.recursosGeneradosPorTodasLasMinas>= Mina.precioEnPiedra && Farm.recursosGeneradosPorTodasLasGranjas>= Mina.precioEnAlimentos){
                            Casa.recursosGeneradosPorTodasLasCasas-=Mina.precioEnOro;
                            Mina.recursosGeneradosPorTodasLasMinas-= Mina.precioEnPiedra;
                            Farm.recursosGeneradosPorTodasLasGranjas-=Mina.precioEnPiedra;
                            
                            Mina mina=new Mina();
                            jPanel1.add(mina);

                            mina.setBounds(Territorio.rsTerritorios.get(id).getBounds());
                            mina.setVisible(true);

                            Territorio.rsTerritorios.get(id).setVisible(false);
                        }
                        else{ 
                            JOptionPane.showMessageDialog(null, "No existen suficientes recursos para crear una mina.");
                        }
                        
                    }
                }
                desactivarSeleccion();
            }

        }
        
        @Override
        public void eveClick(int x, int y, Point puntoXY) {
//            if(estaSeleccionado(punteroDelMouse1)==true ){
////                System.out.println("El puntero esta en " + AbstractTerritorio.rsTerritorios.get(id).getNumeroDeInstancia() );
//            }
        }
        
        private class FrmComprar extends FrmComprarTerritorio{

            public FrmComprar(int id) {
                super((Territorio)Territorio.rsTerritorios.get(id)); //Castin
                setVisible(true);
            }

            @Override
            public void eveAceptar(Territorio territorio_comprado) {
                for(int i=0; i<Territorio.rsTerritorios.size(); i++){
//System.out.println(i+" Es comprado "+territorio_comprado.getComprado());
                    if(Territorio.rsTerritorios.get(i).getEstaSeleccionado()==true){
                        Territorio.rsTerritorios.get(i).setComprado(territorio_comprado.getComprado());
                        Casa.recursosGeneradosPorTodasLasCasas-=Territorio.precioEnOro;
                        Mina.recursosGeneradosPorTodasLasMinas-=Territorio.precioEnPiedra;
                        Farm.recursosGeneradosPorTodasLasGranjas-=Territorio.precioEnAlimentos;
                        JOptionPane.showMessageDialog(null, "Territorio " + Territorio.rsTerritorios.get(i).getNumeroDeInstancia() + " comprado.\nYa puedes contruir en este territorio. " );
                        int siNo=-1;
                       siNo= JOptionPane.showConfirmDialog(null, "Desea comprar en este nuevo territorio.", "Opciones de construccion", JOptionPane.YES_NO_OPTION);
                        if(siNo==JOptionPane.YES_OPTION){
                            FrmOpcionesDeConstruccion frmOpciones=new FrmOpcionesDeConstruccion();
                        }
                        return;
                    }
                }
//                desactivarSeleccion();
            }

            @Override
            public void eveCancelar() {
                //
            }
            
        }

        @Override
        public void eveDobleClick(int x, int y, Point puntoXY) {
            estaSeleccionado(punteroDelMouse1); 
//                System.out.println(id+" Es comprado "+Territorio.rsTerritorios.get(id).getNombre() + Territorio.rsTerritorios.get(id).getNumeroDeInstancia() + "="+Territorio.rsTerritorios.get(id).getComprado());
                if(Territorio.rsTerritorios.get(id).getEstaSeleccionado()==true){
                    if(Territorio.rsTerritorios.get(id).getComprado()==true){
//                        if(Territorio.rsTerritorios.get(i).isVisible()==true){
//                            JOptionPane.showMessageDialog(null, "Si es visible");
//                        }
                            FrmOpcionesDeConstruccion frmOpciones=new FrmOpcionesDeConstruccion();

        //                    JOptionPane.showMessageDialog(null,"Que desea hacer en el territorio numero " + AbstractTerritorio.rsTerritorios.get(id).getNumeroDeInstancia());
                            return;
                    }else{
                        FrmComprar frmComprar=new FrmComprar(id);
                        frmComprar.setTerritorio(territorio1);
                    }
                }
        }

        
        
        @Override
        public void mousePressed() {
//            System.out.println("Numero de instancia " + instanciaNumero + "; cantiad de instancias " + cantidadDeInstancias);
        }

        @Override
        public void mouseMoviendose(int nuevoX, int nuevoY) {
            for(int i=1; i<Territorio.rsTerritorios.size(); i++){
                punteroDelMouse1.setLocation(nuevoX-punteroDelMouse1.getWidth(), nuevoY-(punteroDelMouse1.getHeight()*2));
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
    private javax.swing.JPanel jPanel1;
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
