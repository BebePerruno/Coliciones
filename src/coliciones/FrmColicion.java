/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coliciones;

import java.awt.Point;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafae
 */
public class FrmColicion extends javax.swing.JFrame {

    
    
    private Hilo hilo=new Hilo();
    
    /**
     * Para las coordenadas de las unidades.
     */
    public class Coordenadas{
        public int X;
        public int Y;
        
        public int X1, X2;
        public int Y1, Y2;
        private int mayor_contador;
        
        public int getMayorContador(){
            if(X>Y){
                mayor_contador=X; 
            }else{
                mayor_contador=Y; 
            }
            return mayor_contador;
        }
        
        public void msj(String nombre){
            System.out.println(nombre + "; " + toString());
            
        }
        
        @Override
        public String toString(){
            return  "Coordenada X=" + X+ "; coordenada Y=" + Y;
        }
    }
    private Coordenadas coordenadas_jugador=new Coordenadas();
    private Coordenadas coordenadas_Enemigo=new Coordenadas();
    
    public String getNumeroINT(String numeros_con_formato_de_Texto){
        
//        String []m=numeros_con_formato_de_Texto.split(".");
        System.out.println("Valor original " + numeros_con_formato_de_Texto);
        String txt="";
        int contador=0;
        int v=numeros_con_formato_de_Texto.indexOf(".")-1;
        for (int i=v;i>=0;i--){
            
            txt+=numeros_con_formato_de_Texto.charAt(contador);
            contador++;
//            System.out.println("Modificando " + txt);
        }
        System.out.println("Valor modificado " + txt);
        if(contador==0){
            return numeros_con_formato_de_Texto;
        }
        return txt;
    }
    private void RandomX(){
        
//        double x = x1*(1.0 - f) + x2*f;
        //Jugador
        //Se le puede poner elegancia por medio de 2 matrices numericas dentro del class coordenadas.
        coordenadas_jugador.X1=360;
        coordenadas_jugador.X2=10;
        coordenadas_jugador.Y1=260;
        coordenadas_jugador.Y2=20;
        coordenadas_jugador.X=Integer.parseInt(getNumeroINT(""+coordenadas_jugador.X1*(Math.random())+coordenadas_jugador.X2*1));
        coordenadas_jugador.Y=(Integer.parseInt(getNumeroINT(""+coordenadas_jugador.Y1*(Math.random())+coordenadas_jugador.Y2*1)));
        
        //Enemigo
        
        coordenadas_Enemigo.X1=10;
        coordenadas_Enemigo.X2=360;
        coordenadas_Enemigo.Y1=20;
        coordenadas_Enemigo.Y2=260;
        coordenadas_Enemigo.X=(Integer.parseInt(getNumeroINT(""+coordenadas_jugador.X1*(Math.random())+coordenadas_jugador.X2*1)));
        coordenadas_Enemigo.Y=(Integer.parseInt(getNumeroINT(""+coordenadas_jugador.Y1*(Math.random())+coordenadas_jugador.Y2*1)));
    }
    
    public class Hilo extends Thread{
        public boolean SiColiciono=false;
        @Override
        public void run(){
//            RandomX();
            //Para ejecutar la posicion random.
            while((jLEnemigo.getBounds().intersects(jLJugador.getBounds())!=true) /*|| (SiColiciono!=true)*/ ){
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FrmColicion.class.getName()).log(Level.SEVERE, null, ex);
                }
                RandomX();
//                //Para mover las unidades. No funciona bien.
//                for(int i=coordenadas_Enemigo.X1;i<coordenadas_Enemigo.X;i++){
//                    if(coordenadas_Enemigo.X<=150 && coordenadas_Enemigo.Y<=50 ){
//                        coordenadas_Enemigo.X+=5;
//                        coordenadas_Enemigo.Y+=5;
//                        coordenadas_Enemigo.msj("Enemigo");
//                    }else if(coordenadas_Enemigo.X>=150 && coordenadas_Enemigo.X<=350 && coordenadas_Enemigo.Y>=50 && coordenadas_Enemigo.Y<=250){
//                        coordenadas_Enemigo.X-=5;
//                        coordenadas_Enemigo.Y-=5;
//                        coordenadas_Enemigo.msj("Enemigo");
//                    }
//                    
//                    try {
//                        sleep(500);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(FrmColicion.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    Point p=new Point(coordenadas_Enemigo.X,coordenadas_Enemigo.Y);
                    jLEnemigo.setLocation(coordenadas_Enemigo.X,coordenadas_Enemigo.Y);
                    jLJugador.setLocation(coordenadas_jugador.X,coordenadas_jugador.Y);
                    jLExplocion.setLocation(coordenadas_jugador.X,coordenadas_jugador.Y);
                    DetectarColicion();
//                }//end for
                    
            
            }
        }
    }
    /**
     * Autor Rafael Angel Montero Fernández.
     * Celular: 839442235
     * 
     * Detecta cuando dos unidades colicionan.
     * Investigacion personal de coliciones.
     * Porque es un error pensar que con operaciones matematicas con las medidas 
     * cartecianas de pantallas de ordenador se puede obtener la colicion cuando 
     * en realidad, suceden pero coliciones de resultados o datos.
     * (Cuando en 2 pociones aparte pero con medidas x, y n numeros al obtenerse 
     * la diferencia entre ellos el resultado es el mismo que si estuvieran superpuestas o en punto de colicion.)
     * 
     * Finalmente la investigacion dio resultados positivos por medio de una forma
     * alternativa de detectar coliciones y mucho más efectiva.
     * Que de seguro no tendra coliciones de datos o resultados.
     * (jLEnemigo.getBounds().intersects(this.jLJugador.getBounds())
     * 
     * Espero que al programador Java le sirva para futuros proyectos.
     * 
     * Atentamente alguine como yo que me estoy preparando para vovler un dia a 
     * la UCR a pedir varios examenes por suficiencia(O sea si gano el examen gano el 
     * curso entero es algo asi como muerte subita en un partido de futbol) en todas las matematicas 
     * para la carrera de Informatica Empresarial.
     * Un dia volvere por la revancha.
     * @return  
     */
    public boolean DetectarColicion() {
        //Este algoritmo de coliciones tiene sesgos.
//        if (jLEnemigo.getX() < jLJugador.getX() + 10
//                && (jLEnemigo.getX() + 10) > jLJugador.getX()
//                && (jLJugador.getY() + 10) > jLEnemigo.getY()) {

        //Este otro diseñado por mi tambien tiene sesgos.
        //Cuando se acerca la unidad a alguno de los extremos del escenario entonces la operacion matematica queda dentro del rango de colicion.
        //Esto aunque la otra unidad este alejada.
//        System.out.println("X " + (jLJugador.getX()-jLEnemigo.getX()));
//        if((jLJugador.getX()-jLEnemigo.getX())<=30 &&(jLJugador.getX()-jLEnemigo.getX())>=-30 && (jLJugador.getY()-jLEnemigo.getY())<=30 ||(jLJugador.getY()-jLEnemigo.getY())>=-30){
//          
//            int x=jLJugador.getX()-jLEnemigo.getX(),y=jLJugador.getY()-jLEnemigo.getY();
//            int jX=jLJugador.getX()-x;
//            int jY=jLJugador.getY()-y;
            //Tambien presenta un sesgo...
//            if(jX==jLEnemigo.getX() || jX==jLJugador.getX() && jY==jLEnemigo.getY() || jY==jLJugador.getY()){
//                hilo.SiColiciono = true;
//                System.out.println("Colicion " + jX + "; " + jY + "\nCoordenadas del jugador " + coordenadas_jugador.toString() + "\nCoordenadas del enemigo " + coordenadas_Enemigo.toString());
//                return true;
//            }
            
        //Este es el que no tiene sesgos pero tiene el inconveniente que las dos 
        //unidades tienen que estar superpuestas una sobre la otra, para que ocurra la colicion.
//        if(jLJugador.getX()==jLEnemigo.getX() && jLJugador.getY()==jLEnemigo.getY()){ 

//        //Este no tiene problemas pero podria surgir el problema o sesgo de si se acerca a uno de los extremos
//        //del escenario. Presenta sesgos.
//        if((jLJugador.getX()-40)>=(jLEnemigo.getX()-40) && (jLJugador.getY()-40)>=(jLEnemigo.getY()-40) || (jLJugador.getX()+40)<=(jLEnemigo.getX()+40) && (jLJugador.getY()+40)<=(jLEnemigo.getY()+40)){  
            
/**
 * Investigar
 * Lo mejor es investigar como detectar una imagen superpuesta en otra. Esto es por medio de Graph y de print().
 * O sea con uso de graficos es la unica manera.
 */
        
        //El codigo correcto es este.
        if(this.jLEnemigo.getBounds().intersects(this.jLJugador.getBounds())){
            hilo.SiColiciono = true;
//            this.jLJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coliciones/Explocion.gif")));
//            jLEnemigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coliciones/Explocion.gif")));
//            System.out.println("Colicion \nCoordenadas del jugador " + coordenadas_jugador.toString() + "\nCoordenadas del enemigo " + coordenadas_Enemigo.toString());
            System.out.println("Colicion de objetos");
            jLEnemigo.setVisible(false);
            jLJugador.setVisible(false);
            jLExplocion.setVisible(true);
            this.hilo.stop();
            
            return true;
        }
        //
        return false;
    }//fin del metodo detectarColicion
    
    /**
     * Creates new form FrmColicion
     */
    public FrmColicion() {
        initComponents();
        jLExplocion.setVisible(false);
        RandomX();
//        this.unidad1.X=unidad2.getX();
//        unidad1.Y=unidad2.getY();
//        unidad1.WGrosor=unidad2.getWidth();
//        unidad1.Haltura=unidad2.getHeight();
//        unidad1.repaint();
//        unidad2.repaint();
//        this.repaint();
        hilo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLJugador = new javax.swing.JLabel();
        jLEnemigo = new javax.swing.JLabel();
        jLExplocion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coliciones/agregar.png"))); // NOI18N
        jLJugador.setText("Jugador");
        getContentPane().add(jLJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        jLEnemigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coliciones/modificar.png"))); // NOI18N
        jLEnemigo.setText("Enemigo");
        getContentPane().add(jLEnemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLExplocion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coliciones/Explocion.gif"))); // NOI18N
        getContentPane().add(jLExplocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 100, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmColicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmColicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmColicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmColicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmColicion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLEnemigo;
    private javax.swing.JLabel jLExplocion;
    private javax.swing.JLabel jLJugador;
    // End of variables declaration//GEN-END:variables
}
