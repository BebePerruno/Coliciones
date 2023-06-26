/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package juegoConJLabels;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Crear un class que pueda guarar las coordenadas XY, ademas el numero de decision de la direccion tomada por la unidad controlada por la computadora.
 * De esta manera la unidad logrará crear una ruta completa o mejor dicho una ruta circular que es lo más probable.
 * Si se llega a tal punto entonces, crear un algoritmo para agregar nuevos caminos iniciando los pasos anteriores pero sin perder los datos de las rutas ya conocidas.
 * @author Jugador
 */
public class jPJuegoEvolucionado extends javax.swing.JPanel {

    private EdificiosAliados edificiosAliados=new EdificiosAliados();
    private EdificiosEnemigos edificiosEnemigos=new EdificiosEnemigos();
    
    private SoldadoEnemigo soldadoEnemigo=null;
    
    private void soldadoEnemigoInicial(){
        if(ObjetosEstaticos.soldadosEnemigos.size()<=10){
                soldadoEnemigo=new SoldadoEnemigo(edificiosEnemigos.getPosicionDeLaBase().getX()+100, edificiosEnemigos.getPosicionDeLaBase().getY()+100, TipoDeImagen.Robot);
                ObjetosEstaticos.soldadosEnemigos.add(soldadoEnemigo);
                add(ObjetosEstaticos.soldadosEnemigos.get(ObjetosEstaticos.soldadosEnemigos.size()-1).getLabel());
            }
    }
    
    
    public class SoldadoEnemigo extends PersonajeEvolucionado{

        public SoldadoEnemigo(int nuevo_x, int nuevo_y, TipoDeImagen imagen_para_el_personaje) {
            super(nuevo_x, nuevo_y, imagen_para_el_personaje);
        }

        @Override
        public void eveCrearBase(int coordenada_x, int coordenada_y) {
            add(edificiosEnemigos.getBase(coordenada_x, coordenada_y).getLabel());
        }

        @Override
        public void eveCrearFabrica(int coordenada_x, int coordenada_y) {
            add(edificiosEnemigos.getFabrica(coordenada_x, coordenada_y).getLabel());
        }

        @Override
        public void eveCrearGenerador(int coordenada_x, int coordenada_y) {
            add(edificiosEnemigos.getGenerador(coordenada_x, coordenada_y).getLabel());
        }

        @Override
        public void eveCrearBodega(int coordenada_x, int coordenada_y) {
            add(edificiosEnemigos.getBodega(coordenada_x, coordenada_y).getLabel());
        }

        @Override
        public void eveCrearTorre(int coordenada_x, int coordenada_y) {
            add(edificiosEnemigos.getTorre(coordenada_x, coordenada_y).getLabel());
        }

        @Override
        public void eveCrearUnidad() {
            if(ObjetosEstaticos.soldadosEnemigos.size()<=4){
                SoldadoEnemigo unSoldado=new SoldadoEnemigo(edificiosEnemigos.getPosicionDeLaBase().getX()+100, edificiosEnemigos.getPosicionDeLaBase().getY()+100, TipoDeImagen.Robot);
                ObjetosEstaticos.soldadosEnemigos.add(unSoldado);
                add(ObjetosEstaticos.soldadosEnemigos.get(ObjetosEstaticos.soldadosEnemigos.size()-1).getLabel());
            }
        }

        @Override
        public JLabel[] getVectorDeJLabels() {
//            jLbCualquierEdificiao9.setBounds(-100, -100, 50, 50);
            JLabel []m={};//{jLbBordeIzquierdo, jLbBordeSuperior, jLbBordeInferior, jLbBordeDerecho};//{jLbCualquierEdificiao9, jLbBordeIzquierdo, jLbCualquierEdificiao13, jLbCualquierEdificiao5, jLbCualquierEdificiao4, jLbCualquierEdificiao8, jLbBordeSuperior, jLbBordeInferior, jLbCualquierEdificiao12, jLbBordeDerecho, jLbCualquierEdificiao7};
            return m;
        }

        @Override
        public void eveValidarColision(JLabel nuevo_jLabel) {
            add(nuevo_jLabel);
        }
        
    }
    
  
    public interface iEdificios<Plantilla>{
        
        public Plantilla getBase();
        
        public Plantilla getBase(int x, int y);
        
        public Plantilla getFabrica();
        
        public Plantilla getFabrica(int x, int y);
        
        public Plantilla getGenerador();
         
        public Plantilla getGenerador(int x, int y);
        
        public Plantilla getBodega();
        
        public Plantilla getBodega(int x, int y);
        
        
        public Plantilla getTorre();
        public Plantilla getTorre(int x, int y);
    }
    
    public class EdificiosAliados implements iEdificios<Personaje>{
        
        private Personaje base;
        
        @Override
        public Personaje getBase(int x, int y){
            base=new Personaje(x,y,TipoDeImagen.Base);
            base.setFaccion(Faccion.Aliados);
            return base;
        }
        private Personaje fabrica;
        @Override
        public Personaje getFabrica(int x, int y){
            fabrica=new Personaje(x,y,TipoDeImagen.Fabrica);
            fabrica.setFaccion(Faccion.Aliados);
            return fabrica;
        }
        
        private Personaje generador;
        @Override
        public Personaje getGenerador(int x, int y){
            generador=new Personaje(x,y,TipoDeImagen.Generador);
            generador.setFaccion(Faccion.Aliados);
            return generador;
        }
        private Personaje bodega;
        
        @Override
        public Personaje getBodega(int x, int y){
            bodega=new Personaje(x,y,TipoDeImagen.Bodega);
            bodega.setFaccion(Faccion.Aliados);
            return bodega;
        }
        
        
        private Personaje torre;
        /**
         * El id =0 del vector es la imagen y el i=1 del vector es la etiqueta.
         * @param x coordenada x
         * @param y coordenada y
         * @return retorna un vector de 2 JLabels inicializados.
         */
        @Override
        public Personaje getTorre(int x, int y){
            torre=new Personaje(x,y,TipoDeImagen.Torre);
            torre.setFaccion(Faccion.Aliados);
            return torre;
        }

        @Override
        public Personaje getBase() {
            return base;
        }

        @Override
        public Personaje getFabrica() {
            return fabrica;
        }

        @Override
        public Personaje getGenerador() {
            return generador;
        }

        @Override
        public Personaje getBodega() {
            return bodega;
        }

        @Override
        public Personaje getTorre() {
            return torre;
        }
    }
    
    /**
     * Permite crear edificios.
     * De tarea hacer que los edificios queden distantes unos de otros.
     */
    public class EdificiosEnemigos implements iEdificios<SoldadoEnemigo>{
        
        /**
         * Guarda todos los edificios creados.
         * Esto es para validar si un nuevo edificio se superpone o coliciona con otro ya existente.
         */
        public static ArrayList<Personaje> edificios=new ArrayList();
        
        /**
         * Permite detectar si es valido colocar un nuevo edificio en la posicion en el mapa.
         * @param edificio_a_validar Un objeto del class Personaje.
         * @return Retorna verdadero
         */
        public boolean puedoPonerlNuevoEdificio(Personaje edificio_a_validar){
            for(Personaje unEdificio: edificios){
                if(unEdificio.getLabel().colision(edificio_a_validar.getLabel())==true){
                    return false; //No se puede colocar el edificio.
                }
            }
            return true;//Si se puede colocar el edificio.
        }
        
        public PosicionesXY getPosicionDeLaBase(){
            PosicionesXY xy=new PosicionesXY();
            if(unaBase!=null){
                xy.setX(unaBase.getX());
                xy.setY(unaBase.getY());
            }
            return xy;
        }
        
        private SoldadoEnemigo unaBase=null;
        
        @Override
        public SoldadoEnemigo getBase(int x, int y){
            unaBase=new SoldadoEnemigo(x,y,TipoDeImagen.Base);
            unaBase.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(unaBase)==false){
                unaBase=null;
                return null;
            }
            edificios.add(unaBase);
            return unaBase;
        }
        
        private SoldadoEnemigo fabrica;
        
        @Override
        public SoldadoEnemigo getFabrica(int x, int y){
            fabrica=new SoldadoEnemigo(x,y,TipoDeImagen.Fabrica);
            fabrica.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(fabrica)==false){
                fabrica=null;
                return null;
            }
            edificios.add(fabrica);
            return fabrica;
        }
        
        private SoldadoEnemigo generador;
        
        @Override
        public SoldadoEnemigo getGenerador(int x, int y){
            generador=new SoldadoEnemigo(x,y,TipoDeImagen.Generador);
            generador.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(generador)==false){
                generador=null;
                return null;
            }
            edificios.add(generador);
            return generador;
        }
        
        private SoldadoEnemigo bodega;
        
        @Override
        public SoldadoEnemigo getBodega(int x, int y){
            bodega=new SoldadoEnemigo(x,y,TipoDeImagen.Bodega);
            bodega.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(bodega)==false){
                bodega=null;
                return null;
            }
            edificios.add(bodega);
            return bodega;
        }
        
        private SoldadoEnemigo torre;
        
        @Override
        public SoldadoEnemigo getTorre(int x, int y){
            torre=new SoldadoEnemigo(x,y,TipoDeImagen.Torre);
            torre.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(torre)==false){
                torre=null;
                return null;
            }
            edificios.add(torre);
            return torre;
        }

        @Override
        public SoldadoEnemigo getBase() {
            return unaBase;
        }

        @Override
        public SoldadoEnemigo getFabrica() {
            return fabrica;
        }

        @Override
        public SoldadoEnemigo getGenerador() {
            return generador;
        }

        @Override
        public SoldadoEnemigo getBodega() {
            return bodega;
        }

        @Override
        public SoldadoEnemigo getTorre() {
            return torre;
        }
    }
    
    class Hilo1 extends Thread{
        
        public Hilo1(){
        }
        
        
        private int contador=100;
        private boolean parar=false;
        
        @Override
        public void run(){
            while(parar!=true){
                
                try {
                    sleep(10);
                    if(contador>0){
//                        for(PersonajeEvolucionado p:ObjetosEstaticos.soldadosEnemigos){
//                            p.moverse();
//                        }
                        soldadoEnemigo.moverse();
                    }else{
                        contador=0;
                        int id=GeneradorAleatorio.numeroAleatorio(1,ObjetosEstaticos.soldadosEnemigos.size());
                        if(id==ObjetosEstaticos.soldadosEnemigos.size()){id=0;}
                        contador=100;
                        //Aqui va el algoritmo.
                        soldadoEnemigo.diferentesAcciones();
//                        for(int i=0; i<ObjetosEstaticos.soldadosEnemigos.size(); i++){
//                            ObjetosEstaticos.soldadosEnemigos.get(i).diferentesAcciones();
//                        }
                    }
                    contador--;
                } catch (InterruptedException ex) {
                    Logger.getLogger(jPJuegoEvolucionado.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void agregar(JLabel nuevo){
        this.add(nuevo);
    }
    /**
     * Creates new form jPJuego
     */
    public jPJuegoEvolucionado() {
        initComponents();
        Personaje.LimiteDerecho=920;
        Personaje.LimiteInferior=420;
        Personaje.LimiteIzquierdo=20;
        Personaje.LimiteSuperior=20;
        soldadoEnemigoInicial();
        this.setBounds(new Rectangle(1000,500));
        Hilo1 h=new Hilo1();
        h.start();
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbBordeIzquierdo = new javax.swing.JLabel();
        jLbCualquierEdificiao5 = new javax.swing.JLabel();
        jLbCualquierEdificiao4 = new javax.swing.JLabel();
        jLbBordeSuperior = new javax.swing.JLabel();
        jLbCualquierEdificiao7 = new javax.swing.JLabel();
        jLbCualquierEdificiao8 = new javax.swing.JLabel();
        jLbBordeDerecho = new javax.swing.JLabel();
        jLbCualquierEdificiao9 = new javax.swing.JLabel();
        jLbBordeInferior = new javax.swing.JLabel();
        jLbCualquierEdificiao12 = new javax.swing.JLabel();
        jLbCualquierEdificiao13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 51), 2, true));
        setLayout(null);

        jLbBordeIzquierdo.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeIzquierdo.setToolTipText("");
        jLbBordeIzquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeIzquierdo);
        jLbBordeIzquierdo.setBounds(-30, 0, 50, 480);

        jLbCualquierEdificiao5.setText("Cualquier edificio");
        jLbCualquierEdificiao5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao5);
        jLbCualquierEdificiao5.setBounds(150, 330, 40, 40);

        jLbCualquierEdificiao4.setText("Cualquier edificio");
        jLbCualquierEdificiao4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao4);
        jLbCualquierEdificiao4.setBounds(480, 340, 40, 30);

        jLbBordeSuperior.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeSuperior);
        jLbBordeSuperior.setBounds(20, -10, 1000, 30);

        jLbCualquierEdificiao7.setText("Cualquier edificio");
        jLbCualquierEdificiao7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao7);
        jLbCualquierEdificiao7.setBounds(170, 90, 40, 40);

        jLbCualquierEdificiao8.setText("Cualquier edificio");
        jLbCualquierEdificiao8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao8);
        jLbCualquierEdificiao8.setBounds(750, 310, 40, 30);

        jLbBordeDerecho.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeDerecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeDerecho);
        jLbBordeDerecho.setBounds(970, 0, 40, 480);

        jLbCualquierEdificiao9.setText("Cualquier edificio");
        jLbCualquierEdificiao9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao9);
        jLbCualquierEdificiao9.setBounds(340, 160, 40, 40);

        jLbBordeInferior.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeInferior);
        jLbBordeInferior.setBounds(0, 480, 1020, 30);

        jLbCualquierEdificiao12.setText("Cualquier edificio");
        jLbCualquierEdificiao12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao12);
        jLbCualquierEdificiao12.setBounds(800, 160, 40, 30);

        jLbCualquierEdificiao13.setText("Cualquier edificio");
        jLbCualquierEdificiao13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao13);
        jLbCualquierEdificiao13.setBounds(610, 90, 40, 40);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLbBordeDerecho;
    private javax.swing.JLabel jLbBordeInferior;
    private javax.swing.JLabel jLbBordeIzquierdo;
    private javax.swing.JLabel jLbBordeSuperior;
    private javax.swing.JLabel jLbCualquierEdificiao12;
    private javax.swing.JLabel jLbCualquierEdificiao13;
    private javax.swing.JLabel jLbCualquierEdificiao4;
    private javax.swing.JLabel jLbCualquierEdificiao5;
    private javax.swing.JLabel jLbCualquierEdificiao7;
    private javax.swing.JLabel jLbCualquierEdificiao8;
    private javax.swing.JLabel jLbCualquierEdificiao9;
    // End of variables declaration//GEN-END:variables
}
