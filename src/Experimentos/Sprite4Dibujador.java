/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rafael Angel Montero Fernández.
 * Días martes 15 de febrero del 2022.
 * Para obtener los cuadros de las iamgenes en el vector o matris de imagenes.
 * Se mira el ancho y alto de toda la imagen.
 * Luego se divide por la cantidad de cuadros.
 * 1200/NumeroDeColumnas;
 * 700/NumeroDeFilas
 * Codigo para trabajar con sprites.
 * Aqui fue donde desarrolé el algoritmo de cargado de imagenes que puego implemente más en el package Juego.
 * La investigacion con Sprites evolucionó a una investigacion corta de graphics2D, lo cual me permite ahora mover,
 * imagenes de sprites en diferentes partes del lienzo.
 * Ademas colocarlas inmoviles.
 */
public class Sprite4Dibujador extends JFrame implements Runnable{
    
    public static void main(String []argumentos){
        new Sprite4Dibujador().setVisible(true);
    }
    
    public final String IMAGEN="/Experimentos/super-cute-cartoon-honey-bees-set-vector.jpg";
    private Image img;
    private int anchoVentana =500;
    private int altoVentana=400;
    
    
    
    private Thread hilo;
    
    private int incremento=0;
    
    
    public Sprite4Dibujador(){
        
        tanque=new Tanque(this.anchoVentana,this.altoVentana);
        
        setSize(anchoVentana,altoVentana);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Toolkit herramienta=Toolkit.getDefaultToolkit();
        img=herramienta.getImage(Sprite4Dibujador.class.getResource(IMAGEN));
        buffered_image=new BufferedImage(anchoVentana,altoVentana,BufferedImage.TYPE_INT_BGR);
        TransparentTransformation transparente=new TransparentTransformation(buffered_image);
        buffered_image=transparente.makeColorTransparent(Color.white);
        
        hilo=new Thread(this);
        hilo.start();
//        new SpriteHoja(IMAGEN,50,50);
    }
    
    /**
     * Cantidad de cuadros por filas.
     */
    private int filas=4;//=125
    /**
     * Cantidad de cuadros por columnas.
     */
    private int columnas=4;
    /**
     * Ayuda a repintar y dibijar bien las imagenes.
     */
    private BufferedImage buffered_image;
    /**
        * Esto:
        * int X=(0%filas)*125;
        *int Y=(13/columnas)*125;
        * 
        * Permite seleccionar una imagen expecifica del sprite.
        * 
        * Esto:
        * filas=2; columnas=2;
        * int X=(incremento%filas)*125;
        * int Y=(incremento/columnas)*125;
        * 
        * Permite seleccionar un cuadrante del sprite, muy importante cuando existen sprites
        * con cuadrantes de sprites de diferentes personages o imagenes.
        * 
        * El incremento siempre debe llegar al resultado de filas * columnas.
        * 
        * Asi se le agrega movimiento a la imagen dibujada.
        * private int incrementoX=50;
        * 
        * g2d.drawImage(img, incrementoX,40,incrementoX+125,40+125,X,Y,X+125,Y+125, this);
        * 
        * El metodo "abeja" es la primera evolucion del codigo original, el cual habia sido escrito en el metodo paint.
        * La segunda evolucion es la clase Tanque.
        * La tercera evolucion es una modificasion del metodo abeja.
        * La cuarta evolucion es el class UnidadBasica.
        * 
         */
    public void abeja(Graphics g){
        Graphics2D g2d=null;
//        this.tanques(g,g2d);
        //g2d=(Graphics2D)g; Forma sin BufferedImage.
        
        g.drawImage(buffered_image, 0, 0, this);
        g2d=buffered_image.createGraphics();
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 0, anchoVentana,altoVentana);
        
        int xCuadro=(incremento%filas)*125;
        int yCuadro=(incremento/columnas)*125;
        AffineTransform at = new AffineTransform();
        /**
         * Formula correcta para trabajar con sprites en movimeinto.
         */
        g2d.drawImage(img, 
                X_movimiento,
                50,
                X_movimiento+100,
                50+100,
                xCuadro,
                yCuadro,
                xCuadro+125,
                yCuadro+125,
                this);
        /**
         * Recorte X, y del dibujo.
         */
        xCuadro=(15%filas)*125;
        yCuadro=(15/columnas)*125;
        System.out.println("Cuadro "+ xCuadro);
      /**
       * Misma instancia de Graphics2D pero con coordenadas diferentes.
       * Ya estoy listo para crear juegos usando Graphics2D.
       */ 
        g2d.drawImage(img, 
                200,
                200,
                200+70,
                200+70,
                xCuadro,
                yCuadro,
                xCuadro+125,
                yCuadro+125, this);
        
        g2d.drawImage(img, 
                X_movimiento,
                270,
                X_movimiento+70,
                270+50,
                (7%filas)*125,
                (7/columnas)*125,
                (7%filas)*125+125,
                (7/columnas)*125+125, this);
        
////        at=g2d.getTransform();
////        at.setToTranslation(X_movimiento, 0);
//        g2d.drawImage(buffered_image, at, this);
//        L.setBounds(0, 0, 100, 125);
//        L.setVisible(true);
//        this.add(L);
        repaint();
    }
    
    
    
    /**
     * Aqui se realiza la prueba del class UnidadBasica.
     * Prueba fallida.
     * @param g 
     */
    public void unidadBasicaPrueba(Graphics g){
        Graphics2D g2d=null;
        
        UnidadBasica.AltoDeLaVentana=400;
        UnidadBasica.AnchoDeLaVentana=500;
        UnidadBasica.cantidad_de_cuadros_por_columna=4;
        UnidadBasica.cantidad_de_cuadros_por_fila=1;
        
        UnidadBasica unidad=new UnidadBasica(150,40,5,50,50);
        UnidadBasica unidadPanal=new UnidadBasica(220,50,15,150,150);
        
        g.drawImage(buffered_image, 0, 0, this);
        g2d=buffered_image.createGraphics();
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, 0, anchoVentana,altoVentana);
        
//        int X_del_dibujo=(incremento%filas)*125;
//        int Y_del_dibujo=(incremento/columnas)*125;
        AffineTransform at = new AffineTransform();
        /**
         * Formula correcta para trabajar con sprites en movimeinto.
         */
        g2d.drawImage(img, 
                unidad.getXMovimiento(),
                unidad.getYMovimiento(),
                unidad.getX_tamaño_de_la_imagen(),
                unidad.getY_tamaño_de_la_imagen(),
                unidad.getX_tamaño_de_la_imagen(),
                unidad.getY_tamaño_de_la_imagen(),unidad.Xtamaño_del_lienzo_del_recorte(),unidad.Ytamaño_del_lienzo_del_recorte(), this);
        System.out.println("unidad.Xtamaño_del_lienzo_del_recorte()"+unidad.Xtamaño_del_lienzo_del_recorte());
        g2d.drawImage(img, 
                unidadPanal.getXMovimiento(),
                unidadPanal.getYMovimiento(),
                unidadPanal.getX_tamaño_de_la_imagen(),
                unidadPanal.getY_tamaño_de_la_imagen(),
                unidadPanal.Xtamaño_del_lienzo_del_recorte(),
                unidadPanal.Ytamaño_del_lienzo_del_recorte(),
                unidadPanal.getX_tamaño_de_la_imagen()+125,
                unidadPanal.getY_tamaño_de_la_imagen()+125, this);
        at=g2d.getTransform();
        
        at.setToTranslation(X_movimiento, 0);
        repaint();
        System.out.println("Unidad basica test");
    }
            
    private int X_movimiento=0;
    
    /**
     * Esta prueba fue exitosa.
     * Todo el dia creando un modelo perfecto para usarse en Graphics2D.
     * Al fin lo logré.
     * Quizas en el dia se debió al calor que hizo hoy, a una marea alcalina que me dio, y a un cliente de programacion consultandome todo el dia.
     * Implementaré Juego2D en un nuevo package.
     * Todas las demas pruebas fueron exitosas.
     * El modelo esta listo para una implementacion mayor en un nuevo package.
     * @param g 
     */
    public void unidadBasica2Test(Graphics g){
        Graphics2D g2d=null;
        
        UnidadBasica2.setDimencionesDelSpriteVector(500, 500);
        UnidadBasica2.setColumnasDelSprite(4);
        UnidadBasica2.setFilasDelSprite(4);
        
        UnidadBasica2 u2prueba=new UnidadBasica2(50,50,8,70,50);
        
        UnidadBasica2 uFlor=new UnidadBasica2(200,150,11,150,150);
        
        g.drawImage(buffered_image, 0, 0, this);
        g2d=buffered_image.createGraphics();
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, UnidadBasica2.getAnchoVentana(),UnidadBasica2.getAltoVentana());
        
//        AffineTransform at = new AffineTransform();
        
//Test
        g2d.drawImage(img, 
                u2prueba.posicionX,
                u2prueba.posicionY,
                u2prueba.getPosicionXFinal(),
                u2prueba.getPosicionYFinal(),
                u2prueba.getLargoDelDibujo(),
                u2prueba.getAltoDelDibujo(),
                u2prueba.getLargoDelDibujoFinal(),
                u2prueba.getAltoDelDibujoFinal(),
                this);
        
        //Flor
        g2d.drawImage(img, 
                uFlor.posicionX,
                uFlor.posicionY,
                uFlor.getPosicionXFinal(),
                uFlor.getPosicionYFinal(),
                uFlor.getLargoDelDibujo(),
                uFlor.getAltoDelDibujo(),
                uFlor.getLargoDelDibujoFinal(),
                uFlor.getAltoDelDibujoFinal(),
                this);
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
////        super.paintComponents(g); //No se debe usar con este algoritmo.
        this.abeja(g);
//            this.unidadBasica2Test(g);
//unidadBasicaPrueba(g);
        
    }
    
    
    private int incrementoX=50;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sprite4Dibujador.class.getName()).log(Level.SEVERE, null, ex);
            }
//            incremento++;
            X_movimiento+=10;
            switch(X_movimiento){
                case 20:
                    incremento=14;
                    break;
                    case 50:
                    incremento=2;
                    break;
                    case 80:
                    incremento=13;
                    break;
                    case 120:
                    incremento=15;
                    break;
            }
            this.setTitle(""+X_movimiento);
//            if(incremento>16){
//                //Tamaño maximo de cuadros 16.
//                //El incremento debe llegar hasta el maximo de filas por columnas de la matris de imagenes.
//                incremento=1;
//            }
            incrementoX+=50;
            
            tanque.incrementoX+=40;
            tanque.incremento++;
            if(tanque.incremento>15){
                //Tamaño maximo de cuadros 16.
                //El incremento debe llegar hasta el maximo de filas por columnas de la matris de imagenes.
                tanque.incremento=0;
            }
            if(incrementoX>anchoVentana-120){
                incrementoX=50;
                tanque.incrementoX=50;
            }
            
        }
    }
    
    /**
     * Se conserva el algoritmo de esta unidad como referencia historica de la evolucion de la investigacion.
     */
    public class Tanque{
        public String IMAGEN="/Experimentos/istockphoto-621351488-1024x1024.jpg";
        public final int columnas=3;
        public final int filas=5;
        public Image img;
        
        
        public final int alto_del_sprite=1024;
        public final int ancho_del_sprite=1024;
        
        public int alto_del_cuadro=alto_del_sprite/filas;
        public int ancho_del_cuadro=ancho_del_sprite/columnas;
        public int incremento=0;
        public int incrementoX=50;
        /**
     * Ayuda a repintar y dibijar bien las imagenes.
     */
      public BufferedImage buffered_image;
    
        public Tanque(int NuevoAnchoVentana,int NuevoAltoVentana){
            Toolkit herramienta=Toolkit.getDefaultToolkit();
            img=herramienta.getImage(Sprite4Dibujador.class.getResource(this.IMAGEN));
            buffered_image=new BufferedImage(NuevoAnchoVentana,NuevoAltoVentana,BufferedImage.TYPE_INT_BGR);
        }
        
    }
    
   
    
    /**
        * Esto:
        * int X=(0%filas)*125;
        *int Y=(13/columnas)*125;
        * 
        * Permite seleccionar una imagen expecifica del sprite.
        * 
        * Esto:
        * filas=2; columnas=2;
        * int X=(incremento%filas)*125;
        * int Y=(incremento/columnas)*125;
        * 
        * Permite seleccionar un cuadrante del sprite, muy importante cuando existen sprites
        * con cuadrantes de sprites de diferentes personages o imagenes.
        * 
        * El incremento siempre debe llegar al resultado de filas * columnas.
        * 
        * Asi se le agrega movimiento a la imagen dibujada.
        * private int incrementoX=50;
        * 
        * g2d.drawImage(img, incrementoX,40,incrementoX+125,50+125,X,Y,X+125,Y+125, this);
        * 
        * 
         */
    private Tanque tanque;
    
}

/**
 * 
 * 
 * @author Rafael
 * Viernes 18 de febrero del 2022.
 * Unidad basica para usarse en la graficasion con la biblioteca Graphics2D.
 * Al final me enrede con este class pero se deja como referencia historica de la investigacion.
 */
class UnidadBasica{
    public int Xtamaño_del_lienzo_del_recorte(){
        return getX_tamaño_de_la_imagen()+UnidadBasica.obtenerRecorteXDelSprite();
    }
    /**
     * Tamaño formateado.
     * El tamaño que tendrá el recuadro donde se dibujará la imagen.
     * Se usan los ejes x,y porque en ocaciones son rectangulares.
     * @return El tamaño del recuadro formateado.
     */
    public int Ytamaño_del_lienzo_del_recorte(){
        return getY_tamaño_de_la_imagen()+UnidadBasica.obtenerRecorteYDelSprite();
    }
    
    public UnidadBasica(){
        
    }
    /**
     * Constructor para gestionar el sprite y la imagen a dibujar en el form.
     * Igual las variables a cargar son staticas por lo que se puede presindir de este cosntructor.
     * No obstante se ha creado para darle más orden al insertado de datos y para facilitar la modificasion.
     * Son estaticas porque son las mismas medidas para todas las imagenes dibujadas excepto las coordenadas x,y 
     * donde se colocaran.
     * @param nuevoAltoDeLaVentana La altura del form.
     * @param nuevoAnchoDeLaVentana El ancho del form.
     * @param nueva_cantidad_de_cuadros_por_fila Cantidad de dibujos contenidos en el sprite por fila.
     * @param nueva_cantidad_de_cuadros_por_columna Cantidad de dibujos contenidos en el sprite por columna.
     * @param nuevo_ancho_del_sprite Ancho del sprite a dibujar, esto determina su tamaño en el form.
     * @param nuevo_alto_del_sprite Alto del sprite a dibujar, esto determina su tamaño en el form.
     */
    public UnidadBasica(int nuevoAltoDeLaVentana, int nuevoAnchoDeLaVentana, int nueva_cantidad_de_cuadros_por_fila,
         int nueva_cantidad_de_cuadros_por_columna, int nuevo_ancho_del_sprite, int nuevo_alto_del_sprite,
         int nuevo_xMovimiento, int nuevo_yMovimiento, int nuevo_contador_de_cuadros, 
            int nuevo_x_tamaño_del_lienzo_del_recorte, int nuevo_y_tamaño_del_lienzo_del_recorte){
        
        
        UnidadBasica.AltoDeLaVentana=nuevoAltoDeLaVentana;
        UnidadBasica.AnchoDeLaVentana=nuevoAnchoDeLaVentana;
        UnidadBasica.cantidad_de_cuadros_por_fila=nueva_cantidad_de_cuadros_por_fila;
        UnidadBasica.cantidad_de_cuadros_por_columna=nueva_cantidad_de_cuadros_por_columna;
        UnidadBasica.ancho_del_sprite=nuevo_ancho_del_sprite;
        UnidadBasica.alto_del_sprite=nuevo_alto_del_sprite;
        //Privadas
        this.xMovimiento=nuevo_xMovimiento;
        this.yMovimiento=nuevo_yMovimiento;
        contador_de_cuadros=nuevo_contador_de_cuadros;
//        xtamaño_del_lienzo_del_recorte=nuevo_x_tamaño_del_lienzo_del_recorte;
//        ytamaño_del_lienzo_del_recorte=nuevo_y_tamaño_del_lienzo_del_recorte;
    }
    
    /**
     * Este constructor permite elegir y posicionar una imagen en el form.
     * Se da por entendido que las variables static ya estan inicializadas.
     * @param nuevo_xMovimiento
     * @param nuevo_yMovimiento
     * @param nuevo_contador_de_cuadros 
     */
    public UnidadBasica(int nuevo_xMovimiento, int nuevo_yMovimiento, int nuevo_contador_de_cuadros, 
            int nuevo_x_tamaño_del_lienzo_del_recorte, int nuevo_y_tamaño_del_lienzo_del_recorte){
        this.xMovimiento=nuevo_xMovimiento;
        this.yMovimiento=nuevo_yMovimiento;
        contador_de_cuadros=nuevo_contador_de_cuadros;
//        xtamaño_del_lienzo_del_recorte=nuevo_x_tamaño_del_lienzo_del_recorte;
//        ytamaño_del_lienzo_del_recorte=nuevo_y_tamaño_del_lienzo_del_recorte;
    }
        
        /**
         * Detecta coliciones entre 2 imagenes.
         * @param nueva_unidad
         * @return 
         */
        public boolean intersects(UnidadBasica nueva_unidad) {
        int tw = this.xTamañoDeLaImagen;
        int th = this.yTamañoDeLaImagen;
        int rw = nueva_unidad.xTamañoDeLaImagen;
        int rh = nueva_unidad.yTamañoDeLaImagen;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.xMovimiento;
        int ty = this.yMovimiento;
        int rx = nueva_unidad.xMovimiento;
        int ry = nueva_unidad.yMovimiento;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }
        
        /**
         * Incrementa o disminulle el numero del cuadro a mostrar.
         */
        private int contador_de_cuadros;
        
        /**
         * Permite moverse cuadro a cuadro a travez del sprite.
         * @param nuevo_numero_de_cuadro 
         */
        public void setContadorDeCuadros(int nuevo_numero_de_cuadro){
            contador_de_cuadros=nuevo_numero_de_cuadro;
        }
        /**
         * Permite moverse cuadro a cuadro a travez del sprite.aegs
         * @return 
         */
        public int getContadorDeCuadros(){
            return contador_de_cuadros;
        }
        
        /**
         * Es lo mismo que cantidad de columnas o cantidad de filas.
         * Un sprite como minimo tiene 2 filas y 2 columnas. O sea 4 cuadros.
         */
        public static  int cantidad_de_cuadros_por_fila,cantidad_de_cuadros_por_columna;
        /**
         * Por ejemplo una imagen 500x600, entonces se pasa 500 por parametro en widthDelSprite.
         * Y la cantidad de cuadros de una fila (Del eje x).
         * @param tamaño_del_sprite
         * @param cantidad_de_cuadros_por_fila
         * @return 
         */
        public static int obtenerRecorteXDelSprite(){
            return UnidadBasica.ancho_del_sprite/cantidad_de_cuadros_por_fila;
        }
        
        /**
         * Por ejemplo una imagen 500x600, entonces se pasa 600 por parametro en heightDelSprite.
         * Y la cantidad de cuadros de una columna (Del eje y).
         * @param heightDelSprite
         * @param cantidad_de_cuadros_por_columna
         * @return 
         */
        public static int obtenerRecorteYDelSprite(){
            return UnidadBasica.alto_del_sprite/cantidad_de_cuadros_por_columna;
        }
        
        /**
         * Alto y ancho del vector sprite.
         */
        public static int alto_del_sprite,  ancho_del_sprite;
        
        /**
         * Tamaño y ancho de las imagenes, se relaciona con uan formula matematica
         * xTamañoDeLaImagen=(12%filas)*125;
         *yTamañoDeLaImagen=(12/columnas)*125;
         */
        private  int xTamañoDeLaImagen,yTamañoDeLaImagen;
        
        public int getX_tamaño_de_la_imagen(){
            xTamañoDeLaImagen=(12%UnidadBasica.cantidad_de_cuadros_por_fila)*UnidadBasica.obtenerRecorteXDelSprite();
            return xTamañoDeLaImagen;
        }
        
         public int getY_tamaño_de_la_imagen(){
            yTamañoDeLaImagen=(12/UnidadBasica.cantidad_de_cuadros_por_columna)*UnidadBasica.obtenerRecorteYDelSprite();
            return yTamañoDeLaImagen;
        }
        
        /**
         * Movimiento de las diferentes imagenes de la unica instancia de Graphics2D.
         */
        private int xMovimiento,yMovimiento;
        
        /**
         * Para mover la imagen en el eje X.
         * @param nuevas_coordenadas_x 
         */
        public void setXMovimiento(int nuevas_coordenadas_x){
            xMovimiento=nuevas_coordenadas_x;
        }
        /**
         * Para mover la imagen en el eje X
         * @return 
         */
        public int getXMovimiento(){
            return xMovimiento;
        }
        
        /**
         * Para mover la imagen en el eje Y
         * @param nuevas_coordenadas_y 
         */
        public void setYMovimiento(int nuevas_coordenadas_y){
            yMovimiento=nuevas_coordenadas_y;
        }
        /**
         * Para mover la imagen en el eje Y
         * @return 
         */
        public int getYMovimiento(){
            return yMovimiento;
        }
        
        /**
         * Ancho y alto del form, sirve tambien para dibujar un rectangulo como lienzo.
         */
        public static int AltoDeLaVentana,AnchoDeLaVentana;
        
    }


/**
 * 
 * @author Rafael
 * Fecha de creacion viernes 18 de febrero del 2022.
 * Este modelo abstracto resultó exitoso en los experimentos y pruebas con Graphics2D.
 * 
 */
abstract class UnidadAbstract{
        public int posicionX, posicionY;
        
        public int contador_de_cuadros=0;
        
        public UnidadAbstract(){
        
        }
        
        public UnidadAbstract(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros, int nueva_posicion_x_final, int nueva_posicion_y_final){
            posicionX=nueva_posicionX;
            posicionY=nueva_posicionY;
            contador_de_cuadros=nuevo_contador_de_cuadros;
            this.setPosicion_X_final(nueva_posicion_x_final);
            this.setPosicion_Y_final(nueva_posicion_y_final);
        }
        
        /**
         * X_del_dibujo+125
         * @return 
         */
        public int getLargoDelDibujoFinal(){
            return getLargoDelDibujo()+XlargoDelDibujo();
        }
        
        /**
         * Y_del_dibujo+125
         * @return 
         */
        public int getAltoDelDibujoFinal(){
            return getAltoDelDibujo()+YlargoDelDibujo();
        }
        
        /**
         * X_del_dibujo=(15%filas)*125
         * @return 
         */
        public int getLargoDelDibujo(){
            System.out.println("Cuadro"+(contador_de_cuadros%filas) *XlargoDelDibujo());
            return (contador_de_cuadros%filas) *XlargoDelDibujo();
        }
        
        /**
         * X_del_dibujo=(15%filas)*125
         * @return 
         */
        public int getAltoDelDibujo(){
            return (contador_de_cuadros/columnas) *YlargoDelDibujo();
        }
        
        /**
         * filas / vWidth;
         * @return 
         */
        public static int XlargoDelDibujo(){
            
            return vWidth/filas;
        }
        
        private static int YlargoDelDibujo(){
            return vHeight/columnas;
        }
        
        /**
         * Es para gurdar la formula X_movimiento+100
         */
        private int posicion_x_final,posicion_y_final;
        
        /**
         * Es para gurdar la formula X_movimiento+100
         * @param nueva_posicion_final 
         */
        public void setPosicion_X_final(int nueva_posicion_final){
            posicion_x_final=posicionX+nueva_posicion_final;
        }
        
        /**
         * Es para gurdar la formula Y_movimiento+100
         * @param nueva_posicion_final 
         */
        public void setPosicion_Y_final(int nueva_posicion_final){
            posicion_y_final=posicionY+nueva_posicion_final;
        }
        
        /**
         * X_movimiento+100
         * @return 
         */
        public int getPosicionXFinal(){
            return posicion_x_final;
        }
        /**
         * X_movimiento+100
         * @return 
         */
        public int getPosicionYFinal(){
            return posicion_y_final;
        }
        
        public UnidadAbstract(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros,int nuevo_width, int nuevo_heigth, int cantidad_de_filas, int cantidad_de_columnas){
            posicionX=nueva_posicionX;
            posicionY=nueva_posicionY;
            contador_de_cuadros=nuevo_contador_de_cuadros;
            vWidth=nuevo_width;
            vHeight=nuevo_heigth;
            filas=cantidad_de_filas;
            columnas=cantidad_de_columnas;
        }
        
        private static int vWidth, vHeight;
        
        /**
         * Para dibujar el rectangulo de lienzo o fondo.
         * @return 
         */
        public static int getAnchoVentana(){
            return vWidth;
        }
        
        /**
         * Para dibujar el rectangulo de lienzo o fondo.
         * @return 
         */
        public static int getAltoVentana(){
            return vHeight;
        }
        
        public static void setDimencionesDelSpriteVector(int nuevo_width, int nuevo_heigth){
            vWidth=nuevo_width;
            vHeight=nuevo_heigth;
        }
        
        private static int filas;
        public static void setFilasDelSprite(int cantidad_de_filas){
            filas=cantidad_de_filas;
        }
        
        private static int columnas;
        public static void setColumnasDelSprite(int cantidad_de_columnas){
            columnas=cantidad_de_columnas;
        }
    }

class UnidadBasica2 extends UnidadAbstract{
    
    public String nombre_de_la_unidad="";
    
    public UnidadBasica2(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros, int nueva_posicion_x_final, int nueva_posicion_y_final){
        super( nueva_posicionX,  nueva_posicionY,  nuevo_contador_de_cuadros,nueva_posicion_x_final,nueva_posicion_y_final);
    }
    
    public UnidadBasica2(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros,int nuevo_width, int nuevo_heigth, int cantidad_de_filas, int cantidad_de_columnas){
        super( nueva_posicionX,  nueva_posicionY,  nuevo_contador_de_cuadros, nuevo_width,  nuevo_heigth,  cantidad_de_filas, 
                cantidad_de_columnas);
    }
}