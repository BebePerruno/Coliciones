/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ExperimentosConJuegos;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jugador
 */
public class jPJuego extends javax.swing.JPanel {

    private ArrayList<Personaje> soldadosAliados=new ArrayList();
    private ArrayList<Personaje> soldadosEnemigos=new ArrayList();
    private EdificiosAliados edificiosAliados=new EdificiosAliados();
    private EdificiosEnemigos edificiosEnemigos=new EdificiosEnemigos();
    
    public interface iEdificios{
        /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        public Personaje getBase(int x, int y);
        /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        public Personaje getFabrica(int x, int y);
         /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        public Personaje getGenerador(int x, int y);
        
         /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        public Personaje getBodega(int x, int y);
        
        /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        public Personaje getTorre(int x, int y);
    }
    
    public class EdificiosAliados implements iEdificios{
        
        @Override
        public Personaje getBase(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Base);
            edificion.setFaccion(Faccion.Aliados);
            return edificion;
        }
        
        @Override
        public Personaje getFabrica(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Fabrica);
            edificion.setFaccion(Faccion.Aliados);
            return edificion;
        }
        
        @Override
        public Personaje getGenerador(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Generador);
            edificion.setFaccion(Faccion.Aliados);
            return edificion;
        }
        
        @Override
        public Personaje getBodega(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Bodega);
            edificion.setFaccion(Faccion.Aliados);
            return edificion;
        }
        
        /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        @Override
        public Personaje getTorre(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Torre);
            edificion.setFaccion(Faccion.Aliados);
            return edificion;
        }
    }
    
    public class EdificiosEnemigos implements iEdificios{
        
        @Override
        public Personaje getBase(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Base);
            edificion.setFaccion(Faccion.Enemigos);
            return edificion;
        }
        
        @Override
        public Personaje getFabrica(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Fabrica);
            edificion.setFaccion(Faccion.Enemigos);
            return edificion;
        }
        
        @Override
        public Personaje getGenerador(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Generador);
            edificion.setFaccion(Faccion.Enemigos);
            return edificion;
        }
        
        @Override
        public Personaje getBodega(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Bodega);
            edificion.setFaccion(Faccion.Enemigos);
            return edificion;
        }
        
        /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        @Override
        public Personaje getTorre(int x, int y){
            Personaje edificion=new Personaje(x,y,TipoDeImagen.Torre);
            edificion.setFaccion(Faccion.Enemigos);
            return edificion;
        }
    }
    
    
    class Hilo extends Thread{
        
        public Hilo(){
        }
        
        public int numeroAleatorio(int Min, int Max){
            return (int)(Math.random()*(Max-Min+1)+Min);
        }
        
        private boolean parar=false;
        
        @Override
        public void run(){
            while(parar!=true){
                
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(jPJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    private void anularLabel(JLabel unLabel){
        unLabel.setVisible(false);
        unLabel=null;
    }
    
    /**
     * Coloca un label en el form.
     * @param unLabel Un objeto Jlabel.
     * @param x Una coordenada x del form.
     * @param y Una coordenada y del form.
     */
    private void colocarLabel(JLabel unLabel, int x, int y, ImageIcon icono){
        unLabel.setIcon(icono);
        unLabel.setVisible(true);
        unLabel.setBounds(x, y, 100, 100);
//        absoluto=new AbsoluteConstraints(x, y, 1, -1);
        this.add(unLabel);
    }
    
    /**
     * Creates new form jPJuego
     */
    public jPJuego() {
        initComponents();
        this.add(edificiosAliados.getBase(0, 50).getLabel());
        this.setBounds(new Rectangle(1000,450));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbCualquierEdificiao2 = new javax.swing.JLabel();
        jLbCualquierEdificiao3 = new javax.swing.JLabel();
        jLbCualquierEdificiao4 = new javax.swing.JLabel();
        jLbCualquierEdificiao5 = new javax.swing.JLabel();
        jLbCualquierEdificiao6 = new javax.swing.JLabel();
        jLbCualquierEdificiao7 = new javax.swing.JLabel();
        jLbCualquierEdificiao8 = new javax.swing.JLabel();
        jLbCualquierEdificiao9 = new javax.swing.JLabel();
        jLbCualquierEdificiao10 = new javax.swing.JLabel();
        jLbCualquierEdificiao11 = new javax.swing.JLabel();
        jLbCualquierEdificiao12 = new javax.swing.JLabel();
        jLbCualquierEdificiao13 = new javax.swing.JLabel();
        jLbCualquierEdificiao14 = new javax.swing.JLabel();
        jLbCualquierEdificiao15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 51), 2, true));
        setLayout(null);

        jLbCualquierEdificiao2.setText("Cualquier edificio");
        jLbCualquierEdificiao2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao2);
        jLbCualquierEdificiao2.setBounds(50, 330, 50, 60);

        jLbCualquierEdificiao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/TanqueRojo.png"))); // NOI18N
        jLbCualquierEdificiao3.setText("Cualquier edificio");
        jLbCualquierEdificiao3.setToolTipText("");
        jLbCualquierEdificiao3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao3);
        jLbCualquierEdificiao3.setBounds(70, 60, 60, 60);

        jLbCualquierEdificiao4.setText("Cualquier edificio");
        jLbCualquierEdificiao4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao4);
        jLbCualquierEdificiao4.setBounds(80, 200, 50, 50);

        jLbCualquierEdificiao5.setText("Cualquier edificio");
        jLbCualquierEdificiao5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao5);
        jLbCualquierEdificiao5.setBounds(300, 310, 50, 50);

        jLbCualquierEdificiao6.setText("Cualquier edificio");
        jLbCualquierEdificiao6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao6);
        jLbCualquierEdificiao6.setBounds(240, 50, 50, 50);

        jLbCualquierEdificiao7.setText("Cualquier edificio");
        jLbCualquierEdificiao7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao7);
        jLbCualquierEdificiao7.setBounds(260, 180, 50, 50);

        jLbCualquierEdificiao8.setText("Cualquier edificio");
        jLbCualquierEdificiao8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao8);
        jLbCualquierEdificiao8.setBounds(520, 300, 60, 50);

        jLbCualquierEdificiao9.setText("Cualquier edificio");
        jLbCualquierEdificiao9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao9);
        jLbCualquierEdificiao9.setBounds(380, 70, 50, 50);

        jLbCualquierEdificiao10.setText("Cualquier edificio");
        jLbCualquierEdificiao10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao10);
        jLbCualquierEdificiao10.setBounds(480, 160, 50, 50);

        jLbCualquierEdificiao11.setText("Cualquier edificio");
        jLbCualquierEdificiao11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao11);
        jLbCualquierEdificiao11.setBounds(860, 180, 50, 40);

        jLbCualquierEdificiao12.setText("Cualquier edificio");
        jLbCualquierEdificiao12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao12);
        jLbCualquierEdificiao12.setBounds(810, 60, 50, 50);

        jLbCualquierEdificiao13.setText("Cualquier edificio");
        jLbCualquierEdificiao13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao13);
        jLbCualquierEdificiao13.setBounds(660, 70, 50, 50);

        jLbCualquierEdificiao14.setText("Cualquier edificio");
        jLbCualquierEdificiao14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao14);
        jLbCualquierEdificiao14.setBounds(800, 320, 50, 40);

        jLbCualquierEdificiao15.setText("Cualquier edificio");
        jLbCualquierEdificiao15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao15);
        jLbCualquierEdificiao15.setBounds(690, 210, 50, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLbCualquierEdificiao10;
    private javax.swing.JLabel jLbCualquierEdificiao11;
    private javax.swing.JLabel jLbCualquierEdificiao12;
    private javax.swing.JLabel jLbCualquierEdificiao13;
    private javax.swing.JLabel jLbCualquierEdificiao14;
    private javax.swing.JLabel jLbCualquierEdificiao15;
    private javax.swing.JLabel jLbCualquierEdificiao2;
    private javax.swing.JLabel jLbCualquierEdificiao3;
    private javax.swing.JLabel jLbCualquierEdificiao4;
    private javax.swing.JLabel jLbCualquierEdificiao5;
    private javax.swing.JLabel jLbCualquierEdificiao6;
    private javax.swing.JLabel jLbCualquierEdificiao7;
    private javax.swing.JLabel jLbCualquierEdificiao8;
    private javax.swing.JLabel jLbCualquierEdificiao9;
    // End of variables declaration//GEN-END:variables
}
