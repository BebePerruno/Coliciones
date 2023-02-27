/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos.JuegoG2D;


/**
 * 
 * @author Rafael
 * Fecha de creacion viernes 18 de febrero del 2022.
 * Este modelo abstracto resultó exitoso en los experimentos y pruebas con Graphics2D.
 * Forma de usar este class abstracto despues de heredarlo.
 * Lo siguiente con un ipotetico descendiente de este class abstracto.
 * 
 * Para los objetos static y el constructor:
 *     UnidadBasica2.setDimencionesDelSpriteVector(500, 500);
 *       UnidadBasica2.setColumnasDelSprite(4);
 *       UnidadBasica2.setFilasDelSprite(4);
 *       UnidadBasica2 u2prueba=new UnidadBasica2(50,50,8,70,50);
*        g2d.fillRect(0, 0, UnidadBasica2.getAnchoVentana(),UnidadBasica2.getAltoVentana());
  
  * Para los objetos publicos y el dibujado:
  * 
  * g2d.drawImage(img, 
                u2prueba.posicionX,
                u2prueba.posicionY,
                u2prueba.getPosicionXFinal(),
                u2prueba.getPosicionYFinal(),
                u2prueba.getLargoDelDibujo(),
                u2prueba.getAltoDelDibujo(),
                u2prueba.getLargoDelDibujoFinal(),
                u2prueba.getAltoDelDibujoFinal(),
                this);
  
  * Se declaró a modo de columna para facilitar el depurado y analicis.
 */
abstract class UnidadAbstracta{
        public int posicionX, posicionY;
        
        public int contador_de_cuadros=0;
        
        public UnidadAbstracta(){
        
        }
        
        public UnidadAbstracta(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros, int nueva_posicion_x_final, int nueva_posicion_y_final){
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
            return (contador_de_cuadros%columnas) *XlargoDelDibujo();
        }
        
        /**
         * X_del_dibujo=(15%filas)*125
         * @return 
         */
        public int getAltoDelDibujo(){
            return (contador_de_cuadros/filas ) *YlargoDelDibujo();
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
        
        public UnidadAbstracta(int nueva_posicionX, int nueva_posicionY, int nuevo_contador_de_cuadros,int nuevo_width, int nuevo_heigth, int cantidad_de_filas, int cantidad_de_columnas){
            posicionX=nueva_posicionX;
            posicionY=nueva_posicionY;
            contador_de_cuadros=nuevo_contador_de_cuadros;
            vWidth=nuevo_width;
            vHeight=nuevo_heigth;
                setColumnasDelSprite(cantidad_de_columnas);
                setFilasDelSprite(cantidad_de_filas);
        }
        
        /**
         * Sirven para comprobar coliciones.
         * No es necesario cargarlas porque ellas se cargan con un metodo
         */
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
        
        /**
     * Algoritmo perfecto para detectar intersecciones.
     * Basado en la clase Retangle.
     * Como el ancho y el alto son estaticos entonces no 
     * @param nueva_unidad
     * @return 
     */
    public boolean intersects(UnidadAbstracta nueva_unidad) {
        int tw = this.getPosicionXFinal();
        int th = this.getPosicionYFinal();
        int rw = nueva_unidad.getPosicionXFinal();
        int rh = nueva_unidad.getPosicionYFinal();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.posicionX;
        int ty = this.posicionY;
        int rx = nueva_unidad.posicionX;
        int ry = nueva_unidad.posicionY;
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
}
