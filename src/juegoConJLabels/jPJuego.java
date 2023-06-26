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
public class jPJuego extends javax.swing.JPanel {

    public int numeroAleatorio(int Min, int Max){
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
    
    private ArrayList<Personaje> soldadosAliados=new ArrayList();
    public static ArrayList<Personaje> soldadosEnemigos=new ArrayList();
    private EdificiosAliados edificiosAliados=new EdificiosAliados();
    private EdificiosEnemigos edificiosEnemigos=new EdificiosEnemigos();
    
    public class AccionesEnemigas implements Acciones<Personaje>{
        
        public AccionesEnemigas(){
            crearUnidad();
        }
        
        public boolean puedoCrearNuevoSoldado(Personaje edificio_a_validar){
            for(Personaje unSoldado: soldadosEnemigos){
                if(unSoldado.getLabel().colision(edificio_a_validar.getLabel())==true){
                    return false; //No se puede colocar el edificio.
                }
            }
            return true;//Si se puede colocar el edificio.
        }
        
        @Override
        public void crearUnidad() {
            if(soldadosEnemigos.size()<=10){
                Personaje unSoldado=new Personaje(edificiosEnemigos.getPosicionDeLaBase().getX()+100, edificiosEnemigos.getPosicionDeLaBase().getY()+100, TipoDeImagen.Robot);
                if(puedoCrearNuevoSoldado(unSoldado)==true){
                    soldadosEnemigos.add(unSoldado);
                    add(soldadosEnemigos.get(soldadosEnemigos.size()-1).getLabel());
                }
            }
        }

        private static int maxDeBases=0;
        private static int maxFabricas=0;
        private static int maxDeGeneradores=0;
        private static int maxDeBodegas=0;
        private static int maxDeTorres=0;
        @Override
        public void crearEdificio() {
            int id=numeroAleatorio(1,soldadosEnemigos.size());
            if(id>=soldadosEnemigos.size() || id<=-1){id=0;}
            Personaje unSoldado=soldadosEnemigos.get(id);
            int a=numeroAleatorio(1,5);
            switch(a){
                case 1:
                    if(maxDeBases<=1){
                        add(edificiosEnemigos.getBase(unSoldado.getX(), unSoldado.getY()).getLabel());
                        maxDeBases++;
                    }
                    
                    break;
                case 2:
                    if(this.maxFabricas<=2){
                        add(edificiosEnemigos.getFabrica(unSoldado.getX(), unSoldado.getY()).getLabel());
                        maxFabricas++;
                    }
                    break;
                case 3:
                    if(this.maxDeGeneradores<=4){
                        add(edificiosEnemigos.getGenerador(unSoldado.getX(), unSoldado.getY()).getLabel());
                        maxDeGeneradores++;
                    }
                    break;
                case 4:
                    if(this.maxDeBodegas<=4){
                        add(edificiosEnemigos.getBodega(unSoldado.getX(), unSoldado.getY()).getLabel());
                        maxDeBodegas++;
                    }
                    break;
                case 5:
                    if(this.maxDeTorres<=4){
                        add(edificiosEnemigos.getTorre(unSoldado.getX(), unSoldado.getY()).getLabel());
                        maxDeTorres++;
                    }
                    break;
                default:
                    System.out.print("No se puede crear el edificion con el id="+a);
                    break;
            }
        }
        
        /**
         * Es un generador de numeros aleatorios.
         * @param todos_los_numeros_menos_este Un numero que no se desea que se retorne (Que no se desea que se repita).
         * @return Retorna cualquier numero menos el que se pasó por parametro.
         */
        private int desiciones(int todos_los_numeros_menos_este ){
            int desicionAleatoria=numeroAleatorio(1,4);
            if(desicionAleatoria==todos_los_numeros_menos_este){
                desicionAleatoria=(desiciones(todos_los_numeros_menos_este));
            }else{
                return desicionAleatoria;
            }
            return todos_los_numeros_menos_este;
        }
        
        /**
         * Generador de nuemros aleatorios.
         * Usa el enum DecisionesDeMovimientos para generar decisiones aleatorias.
         * @param todos_los_numeros_menos_este Un enum que no se desea que se retorne.
         * @return Retorna cualquier enum menos el que se pasó por parametro.
         */
        private DecisionesDeMovimientos desiciones(DecisionesDeMovimientos todos_los_numeros_menos_este ){
            int desicionAleatoria=0;
            switch(todos_los_numeros_menos_este){
                case izquierda:
                    desicionAleatoria=desiciones(1);
                    break;
                case derecha:
                    desicionAleatoria=desiciones(2);
                    break;
                case arriba:
                    desicionAleatoria=desiciones(3);
                    break;
                case abajo:
                    desicionAleatoria=desiciones(4);
                    break;
                default:
                    System.out.println("Existe una nueva definicion en desiciones la cual es " + todos_los_numeros_menos_este);
            }
            
            return todos_los_numeros_menos_este.desicionTomada(desicionAleatoria);
        }
        
        /**
         * Evalua la decision actual, verifica si no se ha llegado a alguno de los bordes.
         * Si no ha llegado a algun borde no hace nada, no cambia la ruta.
         * Pero si esta en un borde o se ha pasado si cambia la ruta.
         * @param nuevo Un objeto del class Personaje.
         */
        private void decisionSeleccionada(Personaje nuevo){
            /////Descidiendo.
            if(valorDeDesicion==DecisionesDeMovimientos.izquierda){
                
                if(nuevo.getX()>Personaje.LimiteIzquierdo){
                    desicion=DecisionesDeMovimientos.izquierda;
                    nuevo.memoriaDelCamino.setDecision(desicion);
                }else if(nuevo.getX()==Personaje.LimiteIzquierdo  && valorDeDesicion==DecisionesDeMovimientos.izquierda){
//                    nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                    valorDeDesicion=desiciones(DecisionesDeMovimientos.izquierda); //Cualquier ruta menos el izquierdo.
                }
            }
            
            if(valorDeDesicion==DecisionesDeMovimientos.derecha){
                if(nuevo.getX()<Personaje.LimiteDerecho){
                    desicion=DecisionesDeMovimientos.derecha;
                    nuevo.memoriaDelCamino.setDecision(desicion);
                }else if(nuevo.getX()==Personaje.LimiteDerecho && valorDeDesicion==DecisionesDeMovimientos.derecha){
//                    nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                    valorDeDesicion=desiciones(DecisionesDeMovimientos.derecha);
                }
            }
            
            if(valorDeDesicion==DecisionesDeMovimientos.arriba){
//                postcolision=0;
                if(nuevo.getY()>Personaje.LimiteSuperior){
                    desicion=DecisionesDeMovimientos.arriba;
                    nuevo.memoriaDelCamino.setDecision(desicion);
                }else if(nuevo.getY()==Personaje.LimiteSuperior  && valorDeDesicion==DecisionesDeMovimientos.arriba){
//                    nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                    valorDeDesicion=desiciones(DecisionesDeMovimientos.arriba);
                }
            }
            
            if(valorDeDesicion==DecisionesDeMovimientos.abajo){
//                postcolision=0;
                if(nuevo.getY()<Personaje.LimiteInferior){
                    desicion=DecisionesDeMovimientos.abajo;
                    nuevo.memoriaDelCamino.setDecision(desicion);
                }else if(nuevo.getY()==Personaje.LimiteInferior  && valorDeDesicion==DecisionesDeMovimientos.abajo){
//                    nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                    valorDeDesicion=desiciones(DecisionesDeMovimientos.abajo);
                }
            }
        }

        /**
         * No se usa pero lo conservo por si acaso.
         */
//        private int postcolision=0;
        private DecisionesDeMovimientos desicion=DecisionesDeMovimientos.derecha, valorDeDesicion=DecisionesDeMovimientos.derecha;
        
        @Override
        public void moverse() {
            int id=numeroAleatorio(1,soldadosEnemigos.size());
            if(id==soldadosEnemigos.size()){id=0;}
            Personaje nuevo=soldadosEnemigos.get(id);
            decisionSeleccionada(nuevo);
//            System.out.println(desicion +"=En los bordes decidiendo a " + valorDeDesicion);
            //////Ejecutando las decisiones.
            switch(desicion){
                case izquierda:
                    if(validarColision(nuevo)==false){
                        nuevo.moverIzquierda();
                    }else if(validarColision(nuevo)==true){
                        /**Sucede una colicion en el movimiento hacia la izquierda.
                        Se procede a realizar dos retrocesos hacia la derecha.
                        Se indica que el movimiento tomado fue el derecho sin indicar el retroceso hacia la izquierda. 
                        **/
                        
//                        nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                        valorDeDesicion=desiciones(DecisionesDeMovimientos.izquierda);  //Aqui se podria implementar una descision aleatoria, pero ya se trabajo.
                        decisionSeleccionada(nuevo);//Se cambia la decision para no guardar la que cuaso la colicion.
                        nuevo.memoriaDelCamino.setDecision(desicion); //Se guarda la nueva decision, diferente a la actual.
                        nuevo.moverDrecha();nuevo.moverDrecha(); //Permite alejarse de la colicion.
                    }
                    break;
                case derecha:
                    if(validarColision(nuevo)==false){
                        nuevo.moverDrecha();
                    }else if(validarColision(nuevo)==true){
                        
////                        nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                        nuevo.moverIzquierda();nuevo.moverIzquierda();
                        valorDeDesicion=desiciones(DecisionesDeMovimientos.derecha);
                        decisionSeleccionada(nuevo);
                        nuevo.memoriaDelCamino.setDecision(desicion);
                    }
                    break;
                case arriba:
                    if(validarColision(nuevo)==false){
                        nuevo.moverArriba();
                    }else if(validarColision(nuevo)==true){
////                        nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                        nuevo.moverAbajo();nuevo.moverAbajo(); 
                        valorDeDesicion=desiciones(DecisionesDeMovimientos.arriba); 
                        decisionSeleccionada(nuevo);
                        nuevo.memoriaDelCamino.setDecision(desicion);
                    }
                    break;
                case abajo:
                    if(validarColision(nuevo)==false){
                        nuevo.moverAbajo();
                    }else if(validarColision(nuevo)==true){
////                        nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                        nuevo.moverArriba();nuevo.moverArriba();
                        valorDeDesicion=desiciones(DecisionesDeMovimientos.abajo); 
                        decisionSeleccionada(nuevo);
                        nuevo.memoriaDelCamino.setDecision(desicion);
                    }
                    break;
            }
//            nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
//            System.out.println(desicion +"=Contra objetos decidiendo a " + valorDeDesicion);
        }

        /**
         * Toma 3 diferentes desciiones de acciones.
         * Pero se debe limitar donde colocar un edificio y cuantos edificios colocar.
         * Casi es mejor colocar marcas donde deben ir los edificios.
         * Lo mismo con la cantidad de unidades.
         */
        @Override
        public void diferentesAcciones() {
            int a=numeroAleatorio(1,20);
            
            switch(a){
                case 1:
                    try{
                        System.out.println("Creando un edificio. " + a);
                        this.crearEdificio();
                    }catch(Exception e){}
                    break;
                case 2:
                    System.out.println("Creando una unidad. " + a);
                    this.crearUnidad();
                    break;
//                case 3:
//                    System.out.println("Moviendose " + a);
//                    this.moverse();
//                    break;
            }
            this.moverse();
        }

        @Override
        public boolean validarColision(Personaje nuevo) {
//            Edificios
            if( nuevo.getLabel().colision(jLbCualquierEdificiao7)==true ||nuevo.getLabel().colision(jLbCualquierEdificiao14)==true ||nuevo.getLabel().colision(jLbCualquierEdificiao12)==true ||nuevo.getLabel().colision(jLbCualquierEdificiao3)==true ||  nuevo.getLabel().colision(jLbCualquierEdificiao6)==true  ||  nuevo.getLabel().colision(jLbCualquierEdificiao8)==true ||  nuevo.getLabel().colision(jLbCualquierEdificiao4)==true ||  nuevo.getLabel().colision(jLbCualquierEdificiao5)==true ||  nuevo.getLabel().colision(jLbCualquierEdificiao13)==true ||nuevo.getLabel().colision(jLbCualquierEdificiao11)==true||nuevo.getLabel().colision(jLbCualquierEdificiao9)==true){
                System.out.println("Colision con objeto en: " + nuevo.memoriaDelCamino.toString());
                if(nuevo.memoriaDelCamino.XY_final.x_es_mayor_a_cero()==true){
                    nuevo.memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getX()-nuevo.getVelocidad());
                }else{
//                    nuevo.memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getX()+2);
                }
                if(nuevo.memoriaDelCamino.XY_final.y_es_mayor_a_cero()==true){
                    nuevo.memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getY()-nuevo.getVelocidad());
                }else{
//                    nuevo.memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getY()+2);
                }
//                nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
                return true;
            }
            
            for(int i=0; i<soldadosAliados.size(); i++){
                if(nuevo.getLabel().colision(soldadosAliados.get(i).getLabel())==true){
                    System.out.println("Colision con borde.");
                    nuevo.quitarLabel();
                    nuevo.ponerLabel(nuevo.getX_UltimaPosicion(), nuevo.getY_UltimaPosicion(), TipoDeImagen.Explosion);
//                    add(nuevo.getLabel());
                    for(int a=0; a<soldadosAliados.size(); a++){
                        soldadosAliados.get(a).quitarLabel();
                        soldadosAliados.get(a).ponerLabel(soldadosAliados.get(a).getX_UltimaPosicion(), soldadosAliados.get(a).getY_UltimaPosicion(), TipoDeImagen.Tanque);
                        add(soldadosAliados.get(a).getLabel());
                    }
                    for(int a=0; a<soldadosEnemigos.size(); a++){
                        soldadosEnemigos.get(a).quitarLabel();
                        soldadosEnemigos.get(a).ponerLabel(soldadosEnemigos.get(a).getX_UltimaPosicion(), soldadosEnemigos.get(a).getY_UltimaPosicion(), TipoDeImagen.Tanque);
                        add(soldadosEnemigos.get(a).getLabel());
                    }
                    return true;
                }
            }
            return false;
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
    public class EdificiosEnemigos implements iEdificios<Personaje>{
        
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
        
        private Personaje unaBase=null;
        
        @Override
        public Personaje getBase(int x, int y){
            unaBase=new Personaje(x,y,TipoDeImagen.Base);
            unaBase.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(unaBase)==false){
                unaBase=null;
                return null;
            }
            edificios.add(unaBase);
            return unaBase;
        }
        
        private Personaje fabrica;
        
        @Override
        public Personaje getFabrica(int x, int y){
            fabrica=new Personaje(x,y,TipoDeImagen.Fabrica);
            fabrica.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(fabrica)==false){
                fabrica=null;
                return null;
            }
            edificios.add(fabrica);
            return fabrica;
        }
        
        private Personaje generador;
        @Override
        public Personaje getGenerador(int x, int y){
            generador=new Personaje(x,y,TipoDeImagen.Generador);
            generador.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(generador)==false){
                generador=null;
                return null;
            }
            edificios.add(generador);
            return generador;
        }
        
        private Personaje bodega;
        @Override
        public Personaje getBodega(int x, int y){
            bodega=new Personaje(x,y,TipoDeImagen.Bodega);
            bodega.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(bodega)==false){
                bodega=null;
                return null;
            }
            edificios.add(bodega);
            return bodega;
        }
        
        private Personaje torre;
        
        @Override
        public Personaje getTorre(int x, int y){
            torre=new Personaje(x,y,TipoDeImagen.Torre);
            torre.setFaccion(Faccion.Enemigos);
            if(puedoPonerlNuevoEdificio(torre)==false){
                torre=null;
                return null;
            }
            edificios.add(torre);
            return torre;
        }

        @Override
        public Personaje getBase() {
            return unaBase;
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
    
//    /**
//     * No sirve para gestionar las acciones del personaje.
//     * Pero podria servir para gestionar las acciones de unidades diferentes.
//     */
//    private class H_ConsumidorProductor extends HiloProductorConsumidor{
//
//        public H_ConsumidorProductor(){
//            super();
//            this.setRecipienteLleno(true);
//        }
//        
//        private AccionesEnemigas accionesEnemigas=new AccionesEnemigas();
//        
//        private boolean parar=false;
//        
//        Personaje personaje=null;
//        
//        private int contador=100;
//        
//        @Override
//        public void produciendo() {
//            System.out.println("Produciendo");
//            if(contador>0){
//                accionesEnemigas.moverse();
//                contador--;
//            }else{
//                try{
//                    int id=numeroAleatorio(-1,soldadosEnemigos.size());
//                    if(id==soldadosEnemigos.size() || id<0){id=0;}
//                    personaje=null;
//                    personaje=soldadosEnemigos.get(id);
//
//                   
//                    if(personaje!=null){
////                         soldadosEnemigos.get(id).memoriaRuta.VerResultados();
////                        personaje.quitarLabel();
////                        personaje.ponerLabel(personaje.getX_UltimaPosicion(), personaje.getY_UltimaPosicion(), TipoDeImagen.Robot);
////                        for(int i=0; i<personaje.memoriaRuta.size(); i++){
////                            if(personaje.memoriaRuta.getMemoria(contador)!=null){
////                                try{
////                                personaje.getLabel().setBounds(personaje.memoriaRuta.getMemoria(contador).XY_final.getX(),personaje.memoriaRuta.getMemoria(contador).XY_final.getY(), personaje.getLabel().getWidth(), personaje.getLabel().getHeight());
////                                System.out.println("Recorriendo: "+personaje.memoriaRuta.getMemoria(contador).XY_final);
////                                }catch(Exception e){}
////                            }
////                        }
//                    }
//                    this.setRecipienteLleno(true);
//                    this.setRecipiente();//Esta lleno.
//                }catch(Exception e){
//                   this.setRecipienteLleno(true);
//                   setRecipiente();
//                   System.out.println("Error produciendo");
//                }
//            }
//        }
//
//        @Override
//        public void gastado(boolean llenar_recipiente) {
//            System.out.println("Consumiendo un recipiente lleno");
//            int id=numeroAleatorio(1,100);
//            System.out.println("Unidad seleccionada numero " + id);
////            if(id==soldadosEnemigos.size() || id<0){id=0;}
////            personaje=null;
////            personaje=soldadosEnemigos.get(id);
//            if(id!=45){
////                personaje.quitarLabel();
////                personaje.ponerLabel(personaje.getX_UltimaPosicion(), personaje.getY_UltimaPosicion(), TipoDeImagen.Robot);
////                for(int i=0; i<personaje.memoriaRuta.size(); i++){
////                    if(personaje.memoriaRuta.getMemoria(contador)!=null){
////                        personaje.getLabel().setBounds(personaje.memoriaRuta.getMemoria(contador).XY_final.getX(),personaje.memoriaRuta.getMemoria(contador).XY_final.getY(), personaje.getLabel().getWidth(), personaje.getLabel().getHeight());
////                        System.out.println("Recorriendo: "+personaje.memoriaRuta.getMemoria(contador).XY_final);
////                    }
////                }
//                System.out.println("Recipiente bacio");
//                contador=100;
//                setRecipienteLleno(false);
//            }
//        }
//
//        @Override
//        public void evento() {
////            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        }
//        
//    }
    
    
    class Hilo1 extends Thread{
        private AccionesEnemigas accionesEnemigas=new AccionesEnemigas();
        
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
                        accionesEnemigas.diferentesAcciones();
//                        accionesEnemigas.moverse();//.diferentesAcciones();
                    }else{
                        contador=0;
                        int id=numeroAleatorio(1,soldadosEnemigos.size());
                        if(id==soldadosEnemigos.size()){id=0;}
//                        Personaje nuevo=soldadosEnemigos.get(id);
                        
//                        agregar(nuevo);
                        contador=100;
                        //Aqui va el algoritmo.
                        //Recargando caminos guardados y ejecutandolos.
                    }
                    contador--;
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
    
    private void agregar(JLabel nuevo){
        this.add(nuevo);
    }
    /**
     * Creates new form jPJuego
     */
    public jPJuego() {
        initComponents();
        Personaje.LimiteDerecho=1000;
        Personaje.LimiteInferior=370;
        this.add(edificiosAliados.getBase(0, numeroAleatorio(1,350)).getLabel());
        this.add(edificiosEnemigos.getBase(870, numeroAleatorio(1,350)).getLabel());
        
        this.setBounds(new Rectangle(1000,450));
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

        jLbCualquierEdificiao3 = new javax.swing.JLabel();
        jLbCualquierEdificiao5 = new javax.swing.JLabel();
        jLbCualquierEdificiao4 = new javax.swing.JLabel();
        jLbCualquierEdificiao6 = new javax.swing.JLabel();
        jLbCualquierEdificiao7 = new javax.swing.JLabel();
        jLbCualquierEdificiao8 = new javax.swing.JLabel();
        jLbCualquierEdificiao9 = new javax.swing.JLabel();
        jLbCualquierEdificiao11 = new javax.swing.JLabel();
        jLbCualquierEdificiao12 = new javax.swing.JLabel();
        jLbCualquierEdificiao13 = new javax.swing.JLabel();
        jLbCualquierEdificiao14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 51), 2, true));
        setLayout(null);

        jLbCualquierEdificiao3.setText("Cualquier edificio");
        jLbCualquierEdificiao3.setToolTipText("");
        jLbCualquierEdificiao3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao3);
        jLbCualquierEdificiao3.setBounds(20, 230, 40, 40);

        jLbCualquierEdificiao5.setText("Cualquier edificio");
        jLbCualquierEdificiao5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao5);
        jLbCualquierEdificiao5.setBounds(300, 360, 40, 40);

        jLbCualquierEdificiao4.setText("Cualquier edificio");
        jLbCualquierEdificiao4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao4);
        jLbCualquierEdificiao4.setBounds(470, 260, 40, 30);

        jLbCualquierEdificiao6.setText("Cualquier edificio");
        jLbCualquierEdificiao6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao6);
        jLbCualquierEdificiao6.setBounds(120, 70, 40, 40);

        jLbCualquierEdificiao7.setText("Cualquier edificio");
        jLbCualquierEdificiao7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao7);
        jLbCualquierEdificiao7.setBounds(260, 200, 40, 40);

        jLbCualquierEdificiao8.setText("Cualquier edificio");
        jLbCualquierEdificiao8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao8);
        jLbCualquierEdificiao8.setBounds(660, 280, 40, 40);

        jLbCualquierEdificiao9.setText("Cualquier edificio");
        jLbCualquierEdificiao9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao9);
        jLbCualquierEdificiao9.setBounds(420, 90, 40, 40);

        jLbCualquierEdificiao11.setText("Cualquier edificio");
        jLbCualquierEdificiao11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao11);
        jLbCualquierEdificiao11.setBounds(950, 200, 40, 30);

        jLbCualquierEdificiao12.setText("Cualquier edificio");
        jLbCualquierEdificiao12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao12);
        jLbCualquierEdificiao12.setBounds(780, 130, 40, 30);

        jLbCualquierEdificiao13.setText("Cualquier edificio");
        jLbCualquierEdificiao13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao13);
        jLbCualquierEdificiao13.setBounds(620, 60, 40, 40);

        jLbCualquierEdificiao14.setText("Cualquier edificio");
        jLbCualquierEdificiao14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(jLbCualquierEdificiao14);
        jLbCualquierEdificiao14.setBounds(840, 380, 40, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLbCualquierEdificiao11;
    private javax.swing.JLabel jLbCualquierEdificiao12;
    private javax.swing.JLabel jLbCualquierEdificiao13;
    private javax.swing.JLabel jLbCualquierEdificiao14;
    private javax.swing.JLabel jLbCualquierEdificiao3;
    private javax.swing.JLabel jLbCualquierEdificiao4;
    private javax.swing.JLabel jLbCualquierEdificiao5;
    private javax.swing.JLabel jLbCualquierEdificiao6;
    private javax.swing.JLabel jLbCualquierEdificiao7;
    private javax.swing.JLabel jLbCualquierEdificiao8;
    private javax.swing.JLabel jLbCualquierEdificiao9;
    // End of variables declaration//GEN-END:variables
}
