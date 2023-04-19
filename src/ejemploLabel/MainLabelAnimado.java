/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploLabel;

import ExperimentosConJuegos.TipoDeImagen;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jugador
 */
public class MainLabelAnimado{
    public static void main(String []m){
        FrmMain f=new FrmMain();
//        f.setVisible(true);
    }
}

enum Foto_a_elegir{
        Base, Fabrica, Robot, Explosion, SinImagen
}


/**
 * Contiene de propiedades de solo lectura que retornan una imagen determinada.
 * Las imagenes deben ir en la misma carpeta del class o cambiar la direccion en: ImageIcon(getClass().getResource("/1.jpg"));
 * @author Rafael Angel Montero Fernpandez.
 */
class Fotos{
    
    private final String direccion="/imagenes";
    public ImageIcon imagenExplosion(){
        return new ImageIcon(getClass().getResource("/coliciones/Explocion.gif"));
    }
    
    public ImageIcon imagenBase(){
        return new ImageIcon(getClass().getResource(direccion+"/1.jpg"));
    }
    
    public ImageIcon imagenFabrica(){
        return new ImageIcon(getClass().getResource(direccion+"/2.jpg"));
    }
    
    public ImageIcon imagenRobot(){
        return new ImageIcon(getClass().getResource(direccion+"/Robot.png"));
    }
}

/**
 * Se le agrega al JLabel al capacidad de detectar la cercania de objetos (otros JLabels o controles que tengan alguna propueda getBounds.)
 * Puede dibujarse a si mismo una imagen de acuerdo a los parametros que le indiquen.
 * Contiene 2 constructores.
 * @author Rafael Angel montero Fernpandez.
 */
class LabelAnimado extends JLabel{
    
    /**
     * Se le indica la altura y el ancho.
     * @param x Coordenada del control parent.
     * @param y Coordenada y del control parent.
     * @param ancho Ancho del control JLabel a dibujar.
     * @param altura Altura del control JLabel a dibujar.
     * @param imagen_elegida Una imagen ya conocida que esta indicada en el enum Foto_a_elegir.
     */
    public LabelAnimado(int x, int y, int ancho, int altura, Foto_a_elegir imagen_elegida){
        this.setBounds(x, y, ancho, altura);
        this.setVisible(true);
        DibujarImagen(imagen_elegida);
    }
    
    /**
     * Se dibuja con los valores alto, ancho de las variables estaticas.
     * @param x Coordenada del control parent.
     * @param y Coordenada y del control parent.
     * @param imagen_elegida Una imagen ya conocida que esta indicada en el enum Foto_a_elegir.
     */
    public LabelAnimado(int x, int y, Foto_a_elegir imagen_elegida){
        this.setBounds(x, y, ancho, altura);
        this.setVisible(true);
        DibujarImagen(imagen_elegida);
    }
    
    /**
     * Ancho global de todos los objetos JLabels.
     */
    public static final int ancho=100;
    
    /**
     * Alto global de todos los objetos JLabels.
     */
    public static final int altura=100;
    
    /**
     * Detecta el borde derecho del ambiente.
     * @param width_del_ambiente Es el width del control parent.
     * @return
     */
    public boolean detectarBordeDerecho(int width_del_ambiente) {
        if (width_del_ambiente <= getX() + getWidth()) {
            //            System.out.println("Estoy en el borde derecho ." + (getX()+getWidth()));
            return true;
        }
        return false;
    }

    /**
     * Detecta el borde izquierdo del ambiente.
     * @param height_del_ambiente Es el heigth del control parent.
     * @return
     */
    public boolean detectarBordeInferior(int height_del_ambiente) {
        if (height_del_ambiente <= getY() + this.getHeight()) {
            //            System.out.println("Estoy en el borde inferior ." + (getY()+getHeight()));
            return true;
        }
        return false;
    }

    /**
     * Permite detectar el borde izquierdo del control parent.
     * @return Retorna true en caso de darse la condicion de estar colicionando con el borde izquierdo del control parent.
     */
    public boolean detectarBordeIzquierdo() {
        if (this.getX() <= 0) {
            return true;
        }
        return false;
    }

    public boolean detectarBordeSuperior() {
        if (this.getY() <= 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Objeto el class Fotos, contiene la direccion y la carga de la imagen a dibujar en el JLabel.
     */ 
    private final Fotos imagenes=new Fotos();
    
    /**
     * Permite dibujarle una imagen a JLabel de acuerdo al item indicado en el parametro.
     * @param imagen_elegida Debes pasarle un item del enum Foto_a_elegir.
     */
    public void DibujarImagen(Foto_a_elegir imagen_elegida){
        try{ //El try catch solo es necesario por si las iamgenes no existen.
        switch(imagen_elegida){
            case Base:
                setIcon(imagenes.imagenBase());
                this.setToolTipText(Foto_a_elegir.Base+"");
                break;
            case Fabrica:
                 setIcon( imagenes.imagenFabrica());
                 setToolTipText(Foto_a_elegir.Fabrica+"");
                 break;
             case Robot:
                setIcon( imagenes.imagenRobot());
                setToolTipText(Foto_a_elegir.Robot+"");
                break;
             case SinImagen:
                 this.setText(Foto_a_elegir.SinImagen+"");
                 setToolTipText(Foto_a_elegir.SinImagen+"");
                 break;
             case Explosion:
                 setIcon( imagenes.imagenExplosion());
                 setToolTipText(Foto_a_elegir.Explosion+"");
                 break;
        }
        }catch(Exception e){
            System.out.println(e);//("Es posible que la imagen a cargar no exista o que tenga otro nombre. \nDebe estar en la misma carpete de este class.\nFinalmente el JLabel si se cargará pero sin imagen.");
            this.setText(Foto_a_elegir.SinImagen+"");
            setToolTipText(Foto_a_elegir.SinImagen+"");
        }
    }
    
    /**
     * Permit edetectar la colicion, el codigo ya viene por defecto en los controles del compilador pero para facilitar la programacion se redefine uno personalizado.
     * 
     * @param unidad_contra_la_cual_colisiona Un control JLabel.
     * @return Retorna true si ha colicionado con algun otro contro (Objeto).
     */
    public boolean colision(JLabel unidad_contra_la_cual_colisiona){
        if(unidad_contra_la_cual_colisiona==null){
            return false;
        }
        JLabel ojos=new JLabel();
         ojos.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        return ojos.getBounds().intersects(unidad_contra_la_cual_colisiona.getBounds());
    }
    
    /**
     * Permit edetectar la colicion, el codigo ya viene por defecto en los controles del compilador pero para facilitar la programacion se redefine uno personalizado.
     * Ademas permite detectar un vector o matriz de controles para verificar si se esta colicionando o no.
     * @param mUnidades_contra_las_cuales_colisiona un vector de controles JLabel.
     * @return Retorna true en caso de colicion.
     */
    public boolean colision(JLabel []mUnidades_contra_las_cuales_colisiona){
         try{
             JLabel ojos=new JLabel();
             ojos.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
             for(int i=0; i<mUnidades_contra_las_cuales_colisiona.length; i++){
                 if(ojos.getBounds().intersects(mUnidades_contra_las_cuales_colisiona[i].getBounds())==true){
                     return true;
                 }
             }
         }catch(Exception e){
             
         }
         return false;
     }
    
    /**
      * Permite detectar objetos cercanos.
      * Es lo mismo que la colision simplemente se crea un label invisible que funciona como rango de vision.
      * Importante esta funcion no es colision es un sensor para indicarle a la unidad que se acerca a un objeto.
      * @param mObjetos_cercanos Un matriz de controles JLabels.
      * @return Retorna true si detecta un objeto.
      */
     public boolean VerObjetos(JLabel []mObjetos_cercanos){
         try{
             final int rangoDeVision=50;
             JLabel ojos=new JLabel();
             ojos.setBounds(this.getX(), this.getY(), this.getWidth()+rangoDeVision, this.getHeight()+rangoDeVision);
             for(int i=0; i<mObjetos_cercanos.length; i++){
                 if(ojos.getBounds().intersects(mObjetos_cercanos[i].getBounds())==true){
                     return true;
                 }
             }
         }catch(Exception e){
             
         }
         return false;
     }
     
     public boolean verObjeto(JLabel unidad_contra_la_cual_colisiona){
        if(unidad_contra_la_cual_colisiona==null){
            return false;
        }
        final int rangoDeVision=50;
         JLabel ojos=new JLabel();
         ojos.setBounds(this.getX()-20, this.getY()-20, this.getWidth()+rangoDeVision, this.getHeight()+rangoDeVision);

        return ojos.getBounds().intersects(unidad_contra_la_cual_colisiona.getBounds());
    }
}

interface AccionesDeMovimiento {

    int getVelocidad();

    void moverAbajo();

    void moverArriba();

    void moverDerecha();

    void moverIzquierda();
    
    /**
     * Recordar las matematicas lineales.
     * La diagonal superior va de la esquina superior izquierda a la esquina inferior derecha.
     */
    void moverDiagonalSuperior();
    
    /**
     * Hace el recorrido a la inversa.
     * Va de la esquina inferior derecha hacia la esquina superior izquierda.
     */
    void moverDiagonalSuperiorReversa();
    
    /**
     * Recordar las matematicas lineales.
     * La diagonal menor va de la esquina inferior izquierda a la esquina superior derecha.
     */
    void moverDiagonalInferior();
    
    /**
     * Hace el recorrido a la inversa.
     * Va de la esquina superior derecha hacia la esquina inferior izquierda.
     */
    void moverDiagonalInferiorReversa();

    /**
     * Permite definir el nivel de velocidad de traslado desde la coordenada x inicial a la coordenada x final.
     * @param nuevaVelocidad Un valor int, puede ser 1 o 5.
     */
    void setVelocidad(int nuevaVelocidad);
    
}

/**
 * interfas que contiene las propieades de solo lectura para las coordenadas x, y.
 * @author Rafael Angel Montero Fernández.
 */
interface iCoordenadas {

    /**
     * Permite saber donde esta el control.
     * @return un numero de la coordenada x del JLabel.
     */
    int getXDelLabel();

    /**
     * Permite saber hacia donde se dirige.
     * @return Un numero de la coordenada X del movimiento (Hacia donde se dirige el control).
     */
    int getXDelMovimiento();

    /**
     * Permite saber donde esta el control.
     * @return Un numero de la coordenada Y del JLabel.
     */
    int getYDelLabel();

    /**
     * Permite saber hacia donde se dirige.
     * @return  Un numero de la coordenada Y del movimiento (Hacia donde se dirige el control).
     */
    int getYDelMovimeinto();
    
}

class MemoriaDelCamino {
    
    public MemoriaDelCamino(){
        
    }
    
    public MemoriaDelCamino(int nuevo_x, int nuevo_y){
        x=nuevo_x;
        y=nuevo_y;
    }
    
    public MemoriaDelCamino(int nuevo_x, int nuevo_y, int nueva_decision){
        x=nuevo_x;
        y=nuevo_y;
        decision=nueva_decision;
    }
    
    private int x=0;
    
    public void setX(int nuevo_x){
        x=nuevo_x;
    } 
    public int getX(){
        return x;
    }
    
    private int y=0;
    
    public void setY(int nuevo_y){
        y=nuevo_y;
    } 
    public int getY(){
        return y;
    }
    
    private int decision=1;
    
   /**
    * Permite guardar la decision de movimeinto.
    * Y asi no es necesario guardar una gigantesca cantidad de coordenadas xy.
    * Una buena solucion para el antiguo class gestor de coordenadas.
    * @param nueva_decision Un numero entre 1 y 4, los cuales son movimientos basicos.
    */ 
    public void setDecision(int nueva_decision){
        decision=nueva_decision;
    }
    
    /**
     * 
     * @return Retorna el numero entre 1 y 4 que corresponde a una decision de movimiento.
     */ 
    public int getDecision(){
        return decision;
    }
    
    
    @Override
    public String toString(){
        return "Desicion de hacia donde se dirige " + this.getDecision() + ", coordenada x " + x + ", coordenaa y= " + y ;
    }
}

class UnidadLabel extends LabelAnimado implements AccionesDeMovimiento, iCoordenadas{
    
    /**
     * Esta variable sirve para implementar otras funcionalidades en el class.
     * 
     */
    private MemoriaDelCamino memoria;
    
    /**
     * 
     * @return Retorna un objeto del class MemoriaDelCamino.
     */
    public MemoriaDelCamino getMemoriaDelCamino(){
        return memoria;
    }
    
    /**
     * 
     * @param x Coordenada del control parent.
     * @param y Coordenada y del control parent.
     * @param ancho Ancho del control JLabel a dibujar.
     * @param altura Altura del control JLabel a dibujar.
     * @param imagen_elegida Una imagen ya conocida que esta indicada en el enum Foto_a_elegir.
     */
    public UnidadLabel(int x, int y, int ancho, int altura, Foto_a_elegir imagen_elegida){
        super(x, y, ancho, altura, imagen_elegida);
        xDelMovimiento=x;
        yDelMovimiento=y;    
        this.setBounds(x, y, ancho, altura);
        memoria=new MemoriaDelCamino(x,y);
        DibujarImagen(imagen_elegida);
    }
    
    /**
     * 
     * @param x Coordenada del control parent.
     * @param y Coordenada y del control parent.
     * @param imagen_elegida Una imagen ya conocida que esta indicada en el enum Foto_a_elegir.
     */
    public UnidadLabel(int x, int y, Foto_a_elegir imagen_elegida){
        super(x, y, imagen_elegida);
        xDelMovimiento=x;
        yDelMovimiento=y;
        this.setBounds(x, y, ancho, altura);
        memoria=new MemoriaDelCamino(x,y);
        DibujarImagen(imagen_elegida);
    }
    
    private int velocidad=25;
    @Override
    public int getVelocidad() {
        return velocidad;
    }
    
    @Override
    public void setVelocidad(int nuevaVelocidad) {
        velocidad=nuevaVelocidad;
    }
    
    /**
     * Se usa en los movimientos.
     * Si bien el JLabel ya trae esas variables, es preferible usar unas locales para tareas extra sin afectar la posicion del control.
     */
    private int xDelMovimiento=0;
    /**
     * Se usa en los movimientos.
     * Si bien el JLabel ya trae esas variables, es preferible usar unas locales para tareas extra sin afectar la posicion del control.
     */
    private int yDelMovimiento=0;
    
    /**
     * Aunque el antepasado (AccionesDeMovimiento) ya tiene como detectar los bordes, sin embargo es necesario indicarle en 2 de sus funciones cual es el borde.
     * Y para otras tareas es necesario consultar.
     */
    public static int LimiteInferior=200;
    /**
     * Aunque el antepasado (AccionesDeMovimiento) ya tiene como detectar los bordes, sin embargo es necesario indicarle en 2 de sus funciones cual es el borde.
     * Y para otras tareas es necesario consultar.
     */
    public static int LimiteSuperior=0;
    /**
     * Aunque el antepasado (AccionesDeMovimiento) ya tiene como detectar los bordes, sin embargo es necesario indicarle en 2 de sus funciones cual es el borde.
     * Y para otras tareas es necesario consultar.
     */
    public static int LimiteIzquierdo=0;
    /**
     * Aunque el antepasado (AccionesDeMovimiento) ya tiene como detectar los bordes, sin embargo es necesario indicarle en 2 de sus funciones cual es el borde.
     * Y para otras tareas es necesario consultar.
     */
    public static int LimiteDerecho=200;
    
    @Override
    public void moverAbajo() {
        yDelMovimiento += velocidad;
        if (yDelMovimiento >= LimiteInferior) {
            yDelMovimiento = LimiteInferior;
        }
        memoria.setY(yDelMovimiento);
        setBounds(xDelMovimiento, yDelMovimiento, getWidth(), getHeight());
    }

    @Override
    public void moverArriba() {
        yDelMovimiento -= velocidad;
        if (yDelMovimiento <= LimiteSuperior) {
            yDelMovimiento = LimiteSuperior;
        }
        memoria.setY(yDelMovimiento);
        setBounds(xDelMovimiento, yDelMovimiento, getWidth(), getHeight());
    }

    @Override
    public void moverDerecha() {
        xDelMovimiento += velocidad;
        if (xDelMovimiento >= LimiteDerecho) {
            xDelMovimiento = LimiteDerecho;
        }
        memoria.setX(xDelMovimiento);
        setBounds(xDelMovimiento, yDelMovimiento, getWidth(), getHeight());
    }

    @Override
    public void moverIzquierda() {
        xDelMovimiento -= velocidad;
            if (xDelMovimiento <= LimiteIzquierdo) {
                xDelMovimiento = LimiteIzquierdo;
            }
            memoria.setX(xDelMovimiento);
            setBounds(xDelMovimiento, yDelMovimiento, getWidth(), getHeight());
    }

    @Override
    public void moverDiagonalSuperior() {
        moverDerecha();
        moverAbajo();
    }

    @Override
    public void moverDiagonalInferior() {
        moverDerecha();
        moverArriba();
    }

    @Override
    public void moverDiagonalSuperiorReversa() {
        moverIzquierda();
        moverArriba();
    }

    @Override
    public void moverDiagonalInferiorReversa() {
        moverIzquierda();
        moverAbajo();
    }
    
    /**
     * Permite saber donde esta el control.
     * @return un numero de la coordenada x del JLabel.
     */
    @Override
    public int getXDelLabel(){
        return this.getX();
    }
    
    /**
     * Permite saber donde esta el control.
     * @return Un numero de la coordenada Y del JLabel.
     */
    @Override
    public int getYDelLabel(){
        return this.getY();
    }
    
    /**
     * Permite saber hacia donde se dirige.
     * @return Un numero de la coordenada X del movimiento (Hacia donde se dirige el control).
     */
    @Override
    public int getXDelMovimiento(){
        return xDelMovimiento;
    }
    
    /**
     * Permite saber hacia donde se dirige.
     * @return  Un numero de la coordenada Y del movimiento (Hacia donde se dirige el control).
     */
    @Override
    public int getYDelMovimeinto(){
        return yDelMovimiento;
    }
}



/**
 * Es donde se dibuja el ambiente o demostracion.
 * La razon por la que se usa esta interface AccionesDeMovimiento es porque existe el pontencial de crear unidades y objetos con movimientos aleatorios.
 * @author Rafael Angel Montero Fernández.
 */
class LienzoDeDibujo extends JPanel implements AccionesDeMovimiento{
    private LabelAnimado jLCuadrante;
    private LabelAnimado base;
    private LabelAnimado fabrica;
    private UnidadLabel robot;
    JLabel jLbMeta;
    
    public LienzoDeDibujo(){
        setBounds(0, 0, 600, 500);
        this.setDoubleBuffered(true);
        UnidadLabel.LimiteDerecho=650;
        UnidadLabel.LimiteInferior=500;
        jLCuadrante=new LabelAnimado(100, 70, 50, 50, Foto_a_elegir.Explosion);
        base=new LabelAnimado(200, 130, 60, 60, Foto_a_elegir.Base);
        fabrica=new LabelAnimado(350, 200, 60, 60, Foto_a_elegir.Fabrica);
        robot=new UnidadLabel(0, 0, 60, 60, Foto_a_elegir.Robot);
        robot.setVelocidad(50);
        jLbMeta = new JLabel("Meta explosiva");
        jLbMeta.setBounds(300, 240, 100, 60);
        
        add(jLCuadrante);
        add(base);
        add(fabrica);
        add(robot);
        add(jLbMeta);
    }
    
    public void verificarColiciones(){
        //Elcondicional deshabilitado es solo por si se quiere crear un algoritmo para evitar que ingrese ahi  o alguna otra cosa.
//        if(robot.colision(jLCuadrante)==true ){
//            JOptionPane.showMessageDialog(robot, "Colicionaste con el cuadrante.");
//        }

        if(robot.colision(jLCuadrante)==true ){
            System.out.println("Colicionaste con el cuadrante.");
        }
        
        if(robot.colision(base)==true ){
            System.out.println("Colicionaste con la base.");
        }
        
        if(robot.colision(fabrica)==true ){
            System.out.println("Colicionaste con la fabrica.");
        }
        
        if(robot.colision(jLbMeta)==true ){
            MemoriaDelCamino memoria=robot.getMemoriaDelCamino();
            robot=null;
            robot=new UnidadLabel(memoria.getX(), memoria.getY(), 60, 60, Foto_a_elegir.Explosion);
            System.out.println( "He llegado a una meta explosiva.");
        }
        
        
    }
    

    @Override
    public int getVelocidad() {
        return robot.getVelocidad();
    }

    @Override
    public void moverAbajo() {
        robot.moverAbajo();
        verificarColiciones();
    }

    @Override
    public void moverArriba() {
        robot.moverArriba();
        verificarColiciones();
    }

    @Override
    public void moverDerecha() {
        robot.moverDerecha();
        verificarColiciones();
    }

    @Override
    public void moverIzquierda() {
        robot.moverIzquierda();
        verificarColiciones();
    }

    @Override
    public void moverDiagonalSuperior() {
        robot.moverDiagonalSuperior();
        verificarColiciones();
    }

    @Override
    public void moverDiagonalSuperiorReversa() {
        robot.moverDiagonalSuperiorReversa();
        verificarColiciones();
    }

    @Override
    public void moverDiagonalInferior() {
        robot.moverDiagonalInferior();
        verificarColiciones();
    }

    @Override
    public void moverDiagonalInferiorReversa() {
        robot.moverDiagonalInferiorReversa();
        verificarColiciones();
    }

    @Override
    public void setVelocidad(int nuevaVelocidad) {
        robot.setVelocidad(nuevaVelocidad);
        verificarColiciones();
    }
}

class FrmMain extends JFrame{
    private JButton btnDiagonalSuperior;
    private JButton btnDigonalInferior;
    private JButton btnInversaDiagonalSuperior;
    private JButton btnInversaDiagonalinferior;
    private JLabel jLControlesDeMovimientos;
    private JButton btnAbajo;
    private JButton btnArriba;
    private JButton btnDerecha;
    private JButton btnIzquierda;
    
//    private LienzoDeDibujo ambiente;
    
    private LabelAnimado jLCuadrante;
    private LabelAnimado base;
    private LabelAnimado fabrica;
    private UnidadLabel robot;
    JLabel jLbMeta;
    
    public FrmMain(){
        setBounds(100,100,800, 500);
        this.setPreferredSize(new Dimension(800, 500));
        getContentPane().setLayout(null);
        setVisible(true);
        btnDerecha = new javax.swing.JButton();
        btnAbajo = new JButton();
        btnArriba = new JButton();
        btnIzquierda = new JButton();
        btnDiagonalSuperior = new JButton();
        btnDigonalInferior = new JButton();
        btnInversaDiagonalinferior = new JButton();
        btnInversaDiagonalSuperior = new JButton();
        jLControlesDeMovimientos = new JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setResizable(false);
        
        btnDerecha.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDerecha.setText("dr");
//        getContentPane().add(btnDerecha);
        btnDerecha.setBounds(700, 100, 90, 40);

        btnAbajo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAbajo.setText("Abajo");
//        getContentPane().add(btnAbajo);
        btnAbajo.setBounds(700, 160, 90, 40);

        btnArriba.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnArriba.setText("Arriba");
//        getContentPane().add(btnArriba);
        btnArriba.setBounds(600, 160, 90, 40);

        btnIzquierda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnIzquierda.setText("iz");
//        getContentPane().add(btnIzquierda);
        btnIzquierda.setBounds(600, 100, 90, 33);

        btnDiagonalSuperior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDiagonalSuperior.setText("Diagonal superior");
//        getContentPane().add(btnDiagonalSuperior);
        btnDiagonalSuperior.setBounds(630, 220, 130, 30);

        btnDigonalInferior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDigonalInferior.setText("diagonal inferior");
//        getContentPane().add(btnDigonalInferior);
        btnDigonalInferior.setBounds(630, 260, 130, 30);

        btnInversaDiagonalinferior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInversaDiagonalinferior.setText("inversa diagonal inferior");
//        getContentPane().add(btnInversaDiagonalinferior);
        btnInversaDiagonalinferior.setBounds(600, 350, 190, 30);

        btnInversaDiagonalSuperior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInversaDiagonalSuperior.setText("inversa Diagonal superior");
//        getContentPane().add(btnInversaDiagonalSuperior);
        btnInversaDiagonalSuperior.setBounds(600, 300, 190, 30);

        jLControlesDeMovimientos.setText("Controles de movimientos");
//        getContentPane().add(jLControlesDeMovimientos);
        jLControlesDeMovimientos.setBounds(600, 40, 180, 40);
        
        UnidadLabel.LimiteDerecho=650;
        UnidadLabel.LimiteInferior=500;
        jLCuadrante=new LabelAnimado(100, 100, 50, 50, Foto_a_elegir.Explosion);
        base=new LabelAnimado(200, 0, 60, 60, Foto_a_elegir.Base);
        fabrica=new LabelAnimado(100, 300, 60, 60, Foto_a_elegir.Fabrica);
        robot=new UnidadLabel(0, 0, 60, 60, Foto_a_elegir.Robot);
        robot.setVelocidad(50);
        jLbMeta = new JLabel("Meta explosiva");
        jLbMeta.setBounds(500, 500, 100, 60);
        
        getContentPane().add(jLCuadrante);
        getContentPane().add(base);
        getContentPane().add(fabrica);
        getContentPane().add(robot);
        getContentPane().add(jLbMeta);
        
//         ambiente=new LienzoDeDibujo();
//        add(ambiente);
        
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverDerecha();
                verificarColiciones();
            }
        });
        
        this.btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverIzquierda();
                verificarColiciones();
            }
        });
        
        this.btnArriba.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverArriba();
                verificarColiciones();
            }
        });
        
        this.btnAbajo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverAbajo();
                verificarColiciones();
            }
        });
        
        this.btnDiagonalSuperior.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverDiagonalSuperior();
                verificarColiciones();
            }
        });
        
        this.btnDigonalInferior.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverDiagonalInferior();
                verificarColiciones();
            }
        });
        
        this.btnInversaDiagonalSuperior.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverDiagonalSuperiorReversa();
                verificarColiciones();
            }
        });
        
        this.btnInversaDiagonalinferior.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robot.moverDiagonalInferiorReversa();
                verificarColiciones();
            }
        });
        
    }
    
    public void verificarColiciones(){
        //Elcondicional deshabilitado es solo por si se quiere crear un algoritmo para evitar que ingrese ahi  o alguna otra cosa.
//        if(robot.colision(jLCuadrante)==true ){
//            JOptionPane.showMessageDialog(robot, "Colicionaste con el cuadrante.");
//        }

        if(robot.colision(jLCuadrante)==true ){
            System.out.println("Colicionaste con el cuadrante.");
        }
        
        if(robot.colision(base)==true ){
            System.out.println("Colicionaste con la base.");
        }
        
        if(robot.colision(fabrica)==true ){
            System.out.println("Colicionaste con la fabrica.");
        }
        
        if(robot.colision(jLbMeta)==true ){
            MemoriaDelCamino memoria=robot.getMemoriaDelCamino();
            robot=null;
            robot=new UnidadLabel(memoria.getX(), memoria.getY(), 60, 60, Foto_a_elegir.Explosion);
            System.out.println( "He llegado a una meta explosiva.");
        }
    }
    
    
    
}
