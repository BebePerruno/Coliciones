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
    
    private int contadorebasesEne=0;
    public class SoldadoEnemigo extends PersonajeEvolucionado{

        public SoldadoEnemigo(int nuevo_x, int nuevo_y, TipoDeImagen imagen_para_el_personaje) {
            super(nuevo_x, nuevo_y, imagen_para_el_personaje);
//            PersonajeEvolucionado.maxDeSaldodados=5;
            PersonajeEvolucionado.maxDeBases=1;
            PersonajeEvolucionado.maxDeBodegas=1;
            PersonajeEvolucionado.maxDeGeneradores=1;
            PersonajeEvolucionado.maxFabricas=1;
            PersonajeEvolucionado.maxDeTorres=1;
        }

        @Override
        public void eveCrearBase(int coordenada_x, int coordenada_y) {
//            contadorebasesEne++;
//            if(contadorebasesEne<=PersonajeEvolucionado.maxDeBases){
                
                add(edificiosEnemigos.getBase(coordenada_x, coordenada_y).getLabel());
//            }
            
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
            SoldadoEnemigo unSoldado=new SoldadoEnemigo(edificiosEnemigos.getPosicionDeLaBase().getX()+100, edificiosEnemigos.getPosicionDeLaBase().getY()+100, TipoDeImagen.Robot);
            ObjetosEstaticos.soldadosEnemigos.add(unSoldado);
            add(ObjetosEstaticos.soldadosEnemigos.get(ObjetosEstaticos.soldadosEnemigos.size()-1).getLabel());
        }

        @Override
        public JLabel[] getVectorDeJLabels() {
            JLabel []m=new JLabel[EdificiosEnemigos.edificios.size()];// + ObjetosEstaticos.soldadosEnemigos.size() ];//{jLbRecursos1, jLbRecursos2, jLbRecursos3};
            for(int i=0; i<EdificiosEnemigos.edificios.size(); i++){
                m[i]=EdificiosEnemigos.edificios.get(i).getLabel();
            }
            //No porque hace que todas las unidades creadas se fucionen entre si y dejan de moverse al cavo de un rato.
//            for(int i=EdificiosEnemigos.edificios.size(); i<ObjetosEstaticos.soldadosEnemigos.size(); i++){
//                    m[id]=ObjetosEstaticos.soldadosEnemigos.get(i).getLabel();
//                    id++;
//            }
            if(EdificiosEnemigos.edificios.size()>0){
//                m[EdificiosEnemigos.edificios.size()+ObjetosEstaticos.soldadosEnemigos.size()]=jLbRecursos1;
//                m[EdificiosEnemigos.edificios.size()+ObjetosEstaticos.soldadosEnemigos.size()+1]=jLbRecursos2;
//                m[EdificiosEnemigos.edificios.size()+ObjetosEstaticos.soldadosEnemigos.size()+2]=jLbRecursos3;
            }
            return m;
        }

        @Override
        public void eveValidarColision(JLabel nuevo_jLabel) {
            add(nuevo_jLabel);
//            System.out.println("Validando");
            for(int i=0; i<EdificiosEnemigos.edificios.size(); i++){
                this.VerObjeto(EdificiosEnemigos.edificios.get(i));
            }
            
        }

        private boolean moverse_con_memoria=false;
        @Override
        public boolean getMoverseConMemoria() {
            return moverse_con_memoria;
        }

        @Override
        public DecisionesDeMovimientos getDesicionGuardada() {
            return DecisionesDeMovimientos.derecha;
        }

//        private int uno=0, dos=0;
        @Override
        public void eveViedoObjetos(PersonajeEvolucionado nuevoPersonajeEvolucionado) {
//            uno++;
//            for(int i=0; i<EdificiosEnemigos.edificios.size(); i++){
//                if( uno>=300 && dos==0){
//                    /**
//                     * Realizar acciones.
//                     */
//                    moverse_con_memoria=true;
////                    this.ejecutarRutasGuardadas();
//System.out.println("Ejecutando rutas guardadas");
//                    dos=1;
////                    moverse_con_memoria=false;
//
//
//                }
//            }
               
            
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
        public static ArrayList<PersonajeEvolucionado> edificios=new ArrayList();
        
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
        jLbBordeSuperior = new javax.swing.JLabel();
        jLbRecursos1 = new javax.swing.JLabel();
        jLbBordeDerecho = new javax.swing.JLabel();
        jLbBordeInferior = new javax.swing.JLabel();
        jLbRecursos3 = new javax.swing.JLabel();
        jLbRecursos2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 51), 2, true));
        setLayout(null);

        jLbBordeIzquierdo.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeIzquierdo.setToolTipText("");
        jLbBordeIzquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeIzquierdo);
        jLbBordeIzquierdo.setBounds(-30, 0, 50, 480);

        jLbBordeSuperior.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeSuperior);
        jLbBordeSuperior.setBounds(20, -10, 1000, 30);

        jLbRecursos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recursos minerales.png"))); // NOI18N
        jLbRecursos1.setToolTipText("");
        jLbRecursos1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbRecursos1);
        jLbRecursos1.setBounds(160, 160, 30, 30);

        jLbBordeDerecho.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeDerecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeDerecho);
        jLbBordeDerecho.setBounds(970, 0, 40, 480);

        jLbBordeInferior.setBackground(new java.awt.Color(255, 51, 0));
        jLbBordeInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbBordeInferior);
        jLbBordeInferior.setBounds(0, 480, 1020, 30);

        jLbRecursos3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recursos minerales.png"))); // NOI18N
        jLbRecursos3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbRecursos3);
        jLbRecursos3.setBounds(800, 160, 30, 30);

        jLbRecursos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recursos minerales.png"))); // NOI18N
        jLbRecursos2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbRecursos2);
        jLbRecursos2.setBounds(500, 300, 30, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLbBordeDerecho;
    private javax.swing.JLabel jLbBordeInferior;
    private javax.swing.JLabel jLbBordeIzquierdo;
    private javax.swing.JLabel jLbBordeSuperior;
    private javax.swing.JLabel jLbRecursos1;
    private javax.swing.JLabel jLbRecursos2;
    private javax.swing.JLabel jLbRecursos3;
    // End of variables declaration//GEN-END:variables
}
