/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Experimentos.Juego;

import investigacionSprites.HiloAleatorio;
import investigacionSprites.frmDibujos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafael
 */
public class AreaDeJuego extends javax.swing.JPanel{
    

    private Coordenadas coordAliado=new Coordenadas();
    
    private UnidadEstandar aliado,edificioCristales,edificioBase, edificioIvernadero,edificioMiniInvernadero, torre;
    
    private UnidadEstandar enemigo, casaEnemiga, recolectorEnemigo, edificioEnemigo, torreEnemiga, baseEnemiga;
    
    private UnidadEstandar territorio1, territorio2;
    
    private UnidadEstandar recursos1, recursos2, recursos3, recursos4;
    
   private UnidadEstandar vistaAliado;
    
   /**
    * Se utiliza externamente cuando se usa un menú para colocar el numero de edificio.
    * @param nuevo_numero 
    */
    public void setNumeroDeEdificio(int nuevo_numero){
        System.out.println(nuevo_numero);
        aliado.setNumeroDeEdficio(nuevo_numero);
        aliado.setCrear(true);
        repaint();
    }
    
    private void dibujarUnidadesEnemigo(Graphics g){
        if(enemigo.getCrear()==true){
            switch(enemigo.getNumeroDeEdficio()){
                case 5:
                        baseEnemiga.draw(g);
                        baseEnemiga.setCreado(true);
                    break;
                case 6:
                        recolectorEnemigo.draw(g);
                        recolectorEnemigo.setCreado(true);
                    break;
                case 7:
                    torreEnemiga.draw(g);
                    torreEnemiga.setCreado(true);
                    break;
                case 8:
                    edificioEnemigo.draw(g);
                      edificioEnemigo.setCreado(true);
                    break;
               case 9:
                    this.casaEnemiga.draw(g);
                      casaEnemiga.setCreado(true);
                    break;
            }
            enemigo.setCrear(false);
        }
        
        //Repintando los edificios creados
        if(casaEnemiga.getCreado()==true){
            casaEnemiga.draw(g);
        }
        if(edificioEnemigo.getCreado()==true){
            edificioEnemigo.draw(g);
        }
        if(torreEnemiga.getCreado()==true){
            torreEnemiga.draw(g);
        }
        if(this.recolectorEnemigo.getCreado()==true){
            recolectorEnemigo.draw(g);
        }
         if(this.baseEnemiga.getCreado()==true){
            baseEnemiga.draw(g);
        }
    }
    
    private void dibujarUnidadesAliadas(Graphics g){
        if(aliado.getCrear()==true){
            switch(aliado.getNumeroDeEdficio()){
                case 1:
                        edificioCristales.draw(g);
                        edificioCristales.setCreado(true);
                    break;
                case 2:
                        edificioBase.draw(g);
                        edificioBase.setCreado(true);
                    break;
                case 3:
                    edificioIvernadero.draw(g);
                    edificioIvernadero.setCreado(true);
                    break;
                case 4:
                    edificioMiniInvernadero.draw(g);
                      edificioMiniInvernadero.setCreado(true);
                    break;
               case 5:
                    this.torre.draw(g);
                      torre.setCreado(true);
                    break;
            }
            aliado.setCrear(false);
        }
        
        //Repintando los edificios creados
        if(edificioCristales.getCreado()==true){
            edificioCristales.draw(g);
        }
        if(edificioBase.getCreado()==true){
            edificioBase.draw(g);
        }
        if(edificioIvernadero.getCreado()==true){
            edificioIvernadero.draw(g);
        }
        if(this.edificioMiniInvernadero.getCreado()==true){
            edificioMiniInvernadero.draw(g);
        }
         if(this.torre.getCreado()==true){
            torre.draw(g);
        }
    }
//    boolean visto=false;
    @Override
    public void paint(Graphics g){
        super.paint(g);
//        super.paintComponents(g); no se usa
//        this.draw(g);
//    System.out.println(aliado.getNumeroDeEdficio());
        dibujarRecursos(g);
        this.enemigo.draw(g);
        dibujarUnidadesEnemigo(g);
        
        aliado.draw(g);
        dibujarUnidadesAliadas(g);
        g.setColor(Color.MAGENTA);
         g.drawRect(territorio1.getX(), territorio1.getY(), territorio1.getWidth(), territorio1.getHeight());//Territorio 1
         g.setColor(Color.YELLOW);
         g.drawRect(territorio2.getX(), territorio2.getY(), territorio2.getWidth(), territorio2.getHeight());//Territorio 2
         vistaAliado=new UnidadEstandar(aliado.getX()-aliado.getWidth()+15,aliado.getY()-15,aliado.getWidth()+30,aliado.getHeight()+30);
//             for(int i=180;i>0;i--){
//                 g.drawLine(vistaAliado.getX()+i, vistaAliado.getY(),vistaAliado.getX()+ i,vistaAliado.getHeight());
//             }
        
        if(vistaAliado.intersects(territorio1)){
//            System.out.println("Estoy viendo el territorio 1.");
            g.setColor(Color.cyan);
            g.drawRect(vistaAliado.getX(), vistaAliado.getY(),vistaAliado.getWidth(),vistaAliado.getHeight());
            if(aliado.intersects(territorio1)==true){
//                 System.out.println("Estoy en el territorio 1");
             }
        }
        
        if(vistaAliado.intersects(territorio2)){
//            System.out.println("Estoy viendo el territorio 2.");
            g.setColor(Color.cyan);
            g.drawRect(vistaAliado.getX(), vistaAliado.getY(),vistaAliado.getWidth(),vistaAliado.getHeight());
            if(aliado.intersects(territorio2)==true){
//                 System.out.println("Estoy en el territorio 2");
             }
        }
        
        if((aliado.intersects(territorio2)==true)&&(aliado.intersects(territorio2)==true) ){
//                 System.out.println("Estoy en ambos territorios");
             }
         
        
        
    }
    
    private void dibujarRecursos(Graphics g){
        if(recursos1.getPuntosDeVida()>0){
            recursos1.draw(g);
        }
        if(recursos2.getPuntosDeVida()>0){
            recursos2.draw(g);
        }
        if(recursos3.getPuntosDeVida()>0){
            recursos3.draw(g);
        }
        if(recursos4.getPuntosDeVida()>0){
            recursos4.draw(g);
        }
    }
    
    public  int numeroAleatorio(int Min, int Max){
        if(Min==0){
            Min=-1;
        }
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
    
    private HiloEnemigo h;//=new HiloEnemigo();
    /**
     * Creates new form frmRts
     */
    public AreaDeJuego() {
        
        
        initComponents();
        
        h=new HiloEnemigo();
        
        UnidadEstandar.LimiteDerecho=981;
        UnidadEstandar.LimiteInferior=431;
        this.setBounds(0, 0, 850, 550);
        aliado=new UnidadEstandar(10,10,30,30,this,"/Experimentos/AbejaDerecha.jpg");
        edificioCristales=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/1.jpg");
        edificioBase=new UnidadEstandar(10,10,60,60,this,"/Experimentos/Juego/2.jpg");
        edificioIvernadero=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/3.jpg");
        edificioMiniInvernadero=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/4.jpg");
        torre=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/Torre aliada.jpg");
        
        territorio1=new UnidadEstandar(0,0,522,478);
        territorio2=new UnidadEstandar(525,0,500,478);
        
        enemigo=new UnidadEstandar(100,50,30,30,this,"/Experimentos/AbejaIzquierda.jpg");
        enemigo.setVelocidad(20);
        casaEnemiga=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/Edificio enemigo 1.png");
        recolectorEnemigo=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/Edificio enemigo 3.png");
        edificioEnemigo=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/Edificio enemigo 5.png");
        torreEnemiga=new UnidadEstandar(10,10,55,55,this,"/Experimentos/Juego/Edificio enemigo 4.png");
        baseEnemiga=new UnidadEstandar(10,10,60,60,this,"/Experimentos/Juego/Edificio enemigo 2.png");
        
        recursos1=new UnidadEstandar(890,50,60,60,this,"/Experimentos/Juego/Masorcas recursos.jpg");
        recursos2=new UnidadEstandar(265,360,60,60,this,"/Experimentos/Juego/Masorcas recursos.jpg");
        recursos3=new UnidadEstandar(600,226,60,60,this,"/Experimentos/Juego/Masorcas recursos.jpg");
        recursos4=new UnidadEstandar(130,134,60,60,this,"/Experimentos/Juego/Masorcas recursos.jpg");
        recursos1.setPuntosDeVida(10);
        recursos2.setPuntosDeVida(10);
        recursos3.setPuntosDeVida(10);
        recursos4.setPuntosDeVida(10);
        
        vistaAliado=new UnidadEstandar(territorio1.getX()+50, territorio1.getY()+70, territorio1.getX()+100, territorio1.getY()+20);
                
        this.setDoubleBuffered(true);
        AccionesEnemigas();
        h.start();
//        hiloAliado.start();
        
    }
    
    @Override
    public void update(Graphics g){
//        super.update(g); No usar.
        paint(g);
    }
                      

    private int c=0;
    private void formKeyPressedOriginal(java.awt.event.KeyEvent evt) {    
//        AccionesEnemigas();
        this.aliado.keyPressed(evt);
        repaint();
        if(aliado.intersects(enemigo)==true){
            c++;
            System.out.println( "Colicion " + c);
        }
        if(aliado.getCrear()==true){
            
            switch(aliado.getNumeroDeEdficio()){
                case 1:
                    edificioCristales.setX(aliado.getX()+50);
                    edificioCristales.setY(aliado.getY()+50);
                    break;
                case 2:
                    edificioBase.setX(aliado.getX()+50);
                    edificioBase.setY(aliado.getY()+50);
                    break;
                case 3:
                    edificioIvernadero.setX(aliado.getX()+50);
                    edificioIvernadero.setY(aliado.getX()+50);
                    break;
                case 4:
                    this.edificioMiniInvernadero.setX(aliado.getX()+50);
                    edificioMiniInvernadero.setY(aliado.getX()+50);
                break;
            case 5:
                    this.torre.setX(aliado.getX()+50);
                    torre.setY(aliado.getX()+50);
                break;
            }
            System.out.println("creando en " + edificioCristales.getX());
        }
    }                               

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
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmRts().setVisible(true);
            }
        });
    }
    
    /**
     * Crear un arraylist para las coordenadas.
     */
      class HiloAliado extends Thread{
          public int vX, vY;
           private void dormir(){
//                       System.out.println("Durmiendo");
               try {
                   sleep(10);
               } catch (InterruptedException ex) {
                   Logger.getLogger(AreaDeJuego.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
           //Implementar
           private void recorriendo(){
               System.out.println("recorriendo");
               try{
                   int contador_y=0;
                   int contador_x=0;
                   System.out.println(coordAliado.getDatosBorrados());
                   if(coordAliado.x_es_mayor_que_y()==true){
                       for(int i=0;i<coordAliado.sizeX(); i++){

                          dormir();

                           aliado.setX(coordAliado.getX(i));
                           if(contador_y<coordAliado.sizeY()){
                               aliado.setY(coordAliado.getY(contador_y));
                               contador_y++;
                           }
                           if(coordAliado.getDatosBorrados()==true){
                               contador_y=0;
                               coordAliado.setDatosBorrados(false);
                           }
                           repaint();
                       }
                   }else if(coordAliado.x_es_mayor_que_y()==false){
                       for(int i=0;i<coordAliado.sizeY(); i++){

                           dormir();

                           aliado.setY(coordAliado.getY(i));
//                           System.out.println("Recorriendo x=" + coordAliado.getX(i) + "; y=" + coordAliado.getY(contador_y));
                           if(contador_x<coordAliado.sizeX()){
                               aliado.setX(coordAliado.getX(contador_x));
                               contador_x++;
                           }
                           if(coordAliado.getDatosBorrados()==true){
                               contador_x=0;
                               coordAliado.setDatosBorrados(false);
                           }
                           repaint();
                       }
                   }
               }catch(Exception ex){
                   
               }
           }
                   
                   
          @Override
           public void run(){
//               while(true){
               recorriendo();
               
               stop();
               
           }
//           }//end while
       }
    
    /**
     * Un hilo no funciona para el juego.
     * Explorar hasta crear rutas por las cuales pasar, y si una ruta no es segura volver a explorar.
     */
    class HiloEnemigo extends Thread{
       Coordenadas coordEnemigo=new Coordenadas();

       private void crearEdificios(){
           //Crear unidades invisibles fijas para la creacion de edificios.
           if(baseEnemiga.getCreado()==false){
                if(recursos3.intersects(enemigo)==true){
//                   enemigo.setX(enemigo.getX()-10);
                   enemigo.setNumeroDeEdficio(5);
                }
            }else if(baseEnemiga.getCreado()==true){
                if(casaEnemiga.getCreado()==false){
                    if(recursos3.intersects(enemigo)==true ){
//                       enemigo.setY(enemigo.getX()+10);
                       enemigo.setNumeroDeEdficio(9);
                    }
                }else{
                    if(edificioEnemigo.getCreado()==false){
                        if(recursos3.intersects(enemigo)==true){
//                           enemigo.setX(enemigo.getX()+10);
                           enemigo.setNumeroDeEdficio(8);
                        }
                    }else{
                        if(torreEnemiga.getCreado()==false){
                            if(recursos3.intersects(enemigo)==true ){
//                               enemigo.setX(enemigo.getX()+10);
                               enemigo.setNumeroDeEdficio(7);
                            }
                        }else{
                            if(recolectorEnemigo.getCreado()==false){
                                if(recursos3.intersects(enemigo)==true ){
    //                               enemigo.setX(enemigo.getX()+10);
                                   enemigo.setNumeroDeEdficio(6);
                                }
                            }
                        }
                    }
                }
            }
           
           switch(enemigo.getNumeroDeEdficio()){
                case 1:
                        enemigo.moverArriba();
                    
                    break;
                case 2:
                        enemigo.moverAbajo();
                    break;
                case 3:
                        enemigo.moverDrecha();
                    break;
                case 4:
                        enemigo.moverIzquierda();
                    break;
                case 5: //Base
                    if(baseEnemiga.getCreado()==false){
                        baseEnemiga.setX(enemigo.getX()+40+recursos3.getWidth());
                        baseEnemiga.setY(enemigo.getY()-10);
                        enemigo.setCrear(true);
                    }
                    break;
                case 6://Recolector
                    if(recolectorEnemigo.getCreado()==false){
                        recolectorEnemigo.setX(enemigo.getX()+70+baseEnemiga.getWidth());
                        recolectorEnemigo.setY(enemigo.getY()+120);
                        enemigo.setCrear(true);
                    }
                    break;
                case 7://Torre
                    if(torreEnemiga.getCreado()==false){
                        torreEnemiga.setX(enemigo.getX()+10+baseEnemiga.getWidth());
                        torreEnemiga.setY(enemigo.getY()+50+baseEnemiga.getHeight());
                        enemigo.setCrear(true);
                    }
                    break;
                case 8://Edificio 2
                    if(edificioEnemigo.getCreado()==false){
                        edificioEnemigo.setX(enemigo.getX()-20-recursos3.getWidth());
                        edificioEnemigo.setY(enemigo.getY()-10-recursos3.getHeight());
                        enemigo.setCrear(true);
                    }
                    break;
                case 9://Casa
                    if(casaEnemiga.getCreado()==false){
                       casaEnemiga.setX(enemigo.getX()+25+recursos3.getWidth());
                        casaEnemiga.setY(enemigo.getY()-15-recursos3.getHeight());
                        enemigo.setCrear(true);
                    }
                    break;
                case 10:
                    
                    break;
            }
       }

       private void dormir(){
//                       System.out.println("Durmiendo");
           try {
               sleep(10);
           } catch (InterruptedException ex) {
               Logger.getLogger(AreaDeJuego.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

       private int vY, vX;

       private void generar(){
           vY=enemigo.numeroAleatorio(1, 430);
           vX=enemigo.numeroAleatorio(1, 981);
       }

       private void recorriendo(){
           generar();
           if(coordEnemigo.sizeX()>0){
                coordEnemigo.borrarTodo();
                coordEnemigo.setDatosBorrados(true);
            }
           coordEnemigo.add(enemigo.getX(), enemigo.getY(), vX, vY);
           try{
               int contador_y=0;
               int contador_x=0;
//                   System.out.println(coordAliado.getDatosBorrados());
               if(coordEnemigo.x_es_mayor_que_y()==true){
                   for(int i=0;i<coordEnemigo.sizeX(); i++){

                      dormir();

                       enemigo.setX(coordEnemigo.getX(i));
                       if(contador_y<coordEnemigo.sizeY()){
                           enemigo.setY(coordEnemigo.getY(contador_y));
                           contador_y++;
                       }
                       if(coordEnemigo.getDatosBorrados()==true){
                           contador_y=0;
                           coordEnemigo.setDatosBorrados(false);
                       }
                       crearEdificios();
                       repaint();

                   }
               }else if(coordEnemigo.x_es_mayor_que_y()==false){
                   for(int i=0;i<coordEnemigo.sizeY(); i++){

                       dormir();

                       enemigo.setY(coordEnemigo.getY(i));
//                           System.out.println("Recorriendo x=" + coordAliado.getX(i) + "; y=" + coordAliado.getY(contador_y));
                       if(contador_x<coordEnemigo.sizeX()){
                           enemigo.setX(coordEnemigo.getX(contador_x));
                           contador_x++;
                       }
                       if(coordEnemigo.getDatosBorrados()==true){
                           contador_x=0;
                           coordEnemigo.setDatosBorrados(false);
                       }
                       crearEdificios();
                       repaint();
                   }
               }
           }catch(Exception ex){

           }
       }

       @Override
       public void run(){
           while(true){
               recorriendo();

           }
       }
                   
   }
    
    private int contadorEnemigo=0;
    private int inversa=0;
    private boolean unica_llamada=false;
    /**
     * Se pueden crear clases anidadas de hilos.
     * Tambien se puede hacer que busque ciertos puntos claves en el mapa para moverse.
     * Recordar colocar una propiedad para la satisfaccion de la unidad.
     */
    public void AccionesEnemigas() {
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Crea un edificio de acuerdo al numero de tecla precionado.
     */
    private void crearCoordenadasAliado(){
        if(aliado.getCrear()==true){
            switch(aliado.getNumeroDeEdficio()){
                case 1:
                    if(edificioCristales.getCreado()==false){
                        edificioCristales.setX(aliado.getX()+10);
                        edificioCristales.setY(aliado.getY()+10);
                    }
                    break;
                case 2:
                    if(edificioBase.getCreado()==false){
                        edificioBase.setX(aliado.getX()+10);
                        edificioBase.setY(aliado.getY()+10);
                    }
                    break;
                case 3:
                    if(edificioIvernadero.getCreado()==false){
                        this.edificioIvernadero.setX(aliado.getX()+10);
                        edificioIvernadero.setY(aliado.getY()+10);
                    }
                    break;
                case 4:
                    if(edificioMiniInvernadero.getCreado()==false){
                        this.edificioMiniInvernadero.setX(aliado.getX()+10);
                        edificioMiniInvernadero.setY(aliado.getY()+10);
                    }
                    break;
                case 5:
                    if(torre.getCreado()==false){
                        this.torre.setX(aliado.getX()+10);
                        torre.setY(aliado.getY()+10);
                    }
                    break;
            }
            System.out.println("creando en " + aliado.getX());
//            repaint();
        }
    }
    
    public void keyPressed(KeyEvent evt){
//        h.stop();
//        h=null;
//        
//        h=new Hilo();
//        AccionesEnemigas();
        this.aliado.keyPressed(evt);
        
//        visto=false;
        if(aliado.intersects(enemigo)==true){
            c++;
            System.out.println( "Colicion " + c);
        }
        crearCoordenadasAliado();
        repaint();
    }
    
       
    HiloAliado hiloAliado=new HiloAliado();
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
//        AccionesEnemigas();
        if(coordAliado.sizeX()>0){
            coordAliado.borrarTodo();
            coordAliado.setDatosBorrados(true);
        }
        System.out.println("X= " + evt.getX());
        System.out.println("Y= " + evt.getY());
        //Implementar
        coordAliado.add(aliado.getX(), aliado.getY(), evt.getX(), evt.getY());
            //        aliado.setX(evt.getX());
//        aliado.setY(evt.getY());
        hiloAliado=null;
        hiloAliado=new HiloAliado();
//        hiloAliado.vX=evt.getX();
//        hiloAliado.vY=evt.getY();
        try{
            hiloAliado.start();
        }catch(Exception e){}
        
        
        if(aliado.intersects(enemigo)==true){
            c++;
            System.out.println( "Colicion numero " + c);
        }
        crearCoordenadasAliado();
        repaint();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


//Cosas sin uso
//    public void draw(Graphics g){
////        super.paintComponent(g);//Esta era la palabra.
//
//         BufferedImage f=null;
//         
//        try {
//            f = ImageIO.read(UnidadEstandar.class.getResourceAsStream(aliado.getNombreDeLaImagen()));
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(UnidadEstandar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        
//            f.getRGB(0, 0, 30, 20, aliado.pixeles, 1, 100);
//            
////        this.con_foto=true;
////        if(x>=20){
////            //Dibujar otra imagen.
////        }
////        original x*=4;
//        aliado.setX(aliado.getX());//50*4;
//        
//        aliado.setY(aliado.getY());
//            g.drawImage(f, aliado.getX(), aliado.getY(),this);
//        
//        
//        //Asi cuando todo el algoritmo de dibujado se realiza dentro del form.
////        if(aliado.intersects(enemigo)==true){
////            System.out.println( "Colicion");
////        }
//    }