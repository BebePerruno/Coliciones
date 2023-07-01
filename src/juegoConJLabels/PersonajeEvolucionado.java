/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoConJLabels;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *Se vuelve a abstraer para permitir una serie de eventos.
 * @author Jugador
 */
public abstract class PersonajeEvolucionado extends Personaje implements Acciones<PersonajeEvolucionado>, iVer<PersonajeEvolucionado> {
    
    public abstract void eveViedoObjetos(PersonajeEvolucionado nuevoPersonajeEvolucionado);
    
    @Override
     public boolean VerObjetos(PersonajeEvolucionado []mObjetos_cercanos){
         try{
             final int rangoDeVision=100;
             JLabel ojos=new JLabel();
             ojos.setBounds(this.getX()-(rangoDeVision/2), this.getY()-(rangoDeVision/2), this.getLabel().getWidth()+rangoDeVision, this.getLabel().getHeight()+rangoDeVision);
             for(int i=0; i<mObjetos_cercanos.length; i++){
                 if(ojos.getBounds().intersects(mObjetos_cercanos[i].getLabel().getBounds())==true){
//                     System.out.println("Viendo el objeto " + mObjetos_cercanos[i].getToolTipText());
                     eveViedoObjetos(mObjetos_cercanos[i]);
                     return true;
                 }
             }
         }catch(Exception e){
             
         }
         return false;
     }
     
     @Override
    public boolean VerObjeto(PersonajeEvolucionado objeto_cercano) {
        JLabel ojos=new JLabel();
        final int rangoDeVision=100;
        ojos.setBounds(this.getX()-(rangoDeVision/2), this.getY()-(rangoDeVision/2), this.getLabel().getWidth()+rangoDeVision, this.getLabel().getHeight()+rangoDeVision);
             
//        System.out.println(ojos.getBounds().intersects(objeto_cercano.getLabel().getBounds()));
         if(ojos.getBounds().intersects(objeto_cercano.getLabel().getBounds())==true){
            eveViedoObjetos(objeto_cercano);
             return true;
         }
        return false;
    }
    
    private int numeroAnterior=0;
    /**
     * Numero aleatorio.
     * Una formula historica e inolvidable.
     * @param Min Un numero minimo para comenzar.
     * @param Max Un numero maximo para terminar.
     * @return Retorna un numero entre un minimo y un maximo.
     */
    private int numeroAleatorio(int Min, int Max){
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
    /**
     * Este constructor no agrega la instancia al ArrayList estatico. Al crearse una instancia del descendiente entonces, se debe agregar manualmente.
     * 
     * @param nuevo_x Nueva posicion "x" donde aparecera la unidad.
     * @param nuevo_y Nueva posicion "y" donde aparecera la unidad.
     * @param imagen_para_el_personaje Un item del enum TipoDeImagen
     */
    public PersonajeEvolucionado(int nuevo_x, int nuevo_y, TipoDeImagen imagen_para_el_personaje) {
        super(nuevo_x, nuevo_y, imagen_para_el_personaje);
        this.setNombre( imagen_para_el_personaje.toString()+nuevo_x+ nuevo_y );
        System.out.println("New "+this.getNombre());
    }
    
    /**
     * Crea un edificio en la posicion donde este el soldado.
     * @param coordenada_x Coordenada "x" donde irá el edificio.
     * @param coordenada_y Coordenada "y" donde irá el edificio.
     */
    public abstract void eveCrearBase(int coordenada_x, int coordenada_y);

    /**
     * Crea un edificio en la posicion donde este el soldado.
     * @param coordenada_x Coordenada "x" donde irá el edificio.
     * @param coordenada_y Coordenada "y" donde irá el edificio.
     */
    public abstract void eveCrearFabrica(int coordenada_x, int coordenada_y);

    /**
     * Crea un edificio en la posicion donde este el soldado.
     * @param coordenada_x Coordenada "x" donde irá el edificio.
     * @param coordenada_y Coordenada "y" donde irá el edificio.
     */
    public abstract void eveCrearGenerador(int coordenada_x, int coordenada_y);

    /**
     * Crea un edificio en la posicion donde este el soldado.
     * @param coordenada_x Coordenada "x" donde irá el edificio.
     * @param coordenada_y Coordenada "y" donde irá el edificio.
     */
    public abstract void eveCrearBodega(int coordenada_x, int coordenada_y);

    /**
     * Crea un edificio en la posicion donde este el soldado.
     * @param coordenada_x Coordenada "x" donde irá el edificio.
     * @param coordenada_y Coordenada "y" donde irá el edificio.
     */
    public abstract void eveCrearTorre(int coordenada_x, int coordenada_y);
    
        
//        public AccionesEnemigas(){
//            crearUnidad();
//        }
        
        public boolean puedoCrearNuevoSoldado(PersonajeEvolucionado personaje_a_validar){
            for(PersonajeEvolucionado unSoldado: ObjetosEstaticos.soldadosEnemigos){
                if(unSoldado.getLabel().colision(personaje_a_validar.getLabel())==true){
                    return false; //No se puede colocar el edificio.
                }
            }
            return true;//Si se puede colocar el edificio.
        }
        
        public abstract void eveCrearUnidad();
        
        @Override
        public void crearUnidad() {
            if(ObjetosEstaticos.soldadosEnemigos.size()<=maxDeSaldodados){
                eveCrearUnidad();
            }
        }

        public static int maxDeBases=0;
        private static int contadorDeBases=0;
        
        public static int maxFabricas=0;
        private static int contadorDeFabricas=0;
        
        public static int maxDeGeneradores=0;
        private static int contadorDeGeneradores=0;
        
        public static int maxDeBodegas=0;
        private static int contadorDeBodegas=0;
        
        public static int maxDeTorres=0;
        private static int contadorDeTorres=0;
        
        public static int maxDeSaldodados=0;
        
        @Override
        public void crearEdificio() {
            int id=numeroAleatorio(1,ObjetosEstaticos.soldadosEnemigos.size());
            if(id>=ObjetosEstaticos.soldadosEnemigos.size() || id<=-1){id=0;}
            Personaje unSoldado=ObjetosEstaticos.soldadosEnemigos.get(id);
            int a=numeroAleatorio(1,5);
            switch(a){
                case 1:
                    if(maxDeBases>0 && contadorDeBases<=maxDeBases+1){contadorDeBases++;}
                    if(contadorDeBases<=maxDeBases && maxDeBases>0){
                        eveCrearBase(unSoldado.getX(), unSoldado.getY());
                        System.out.println("Cantidad de bases " + contadorDeBases);
                    }
                    
                    break;
                case 2:
                    if(maxFabricas>0 && contadorDeFabricas<=maxFabricas+1){contadorDeFabricas++;}
                    if(contadorDeFabricas<=maxFabricas && maxFabricas>0 ){
                        eveCrearFabrica(unSoldado.getX(), unSoldado.getY());
                        System.out.println("Cantidad de fabricas " + contadorDeFabricas);
                    }
                    break;
                case 3:
                    if(maxDeGeneradores>0 && contadorDeGeneradores<=maxDeGeneradores+1){contadorDeGeneradores++;}
                    if(contadorDeGeneradores<=maxDeGeneradores && maxDeGeneradores>0){
                        eveCrearGenerador(unSoldado.getX(), unSoldado.getY());
                        System.out.println("Cantidad de generadores " + contadorDeGeneradores);
                    }
                    break;
                case 4:
                    if(maxDeBodegas>0 && contadorDeBodegas<=maxDeBodegas+1){contadorDeBodegas++;}
                    if(contadorDeBodegas<=maxDeBodegas && maxDeBodegas>0){
                        eveCrearBodega(unSoldado.getX(), unSoldado.getY());
                        System.out.println("Cantidad de bodegas " + contadorDeBodegas);
                        
                    }
                    break;
                case 5:
                    if(maxDeTorres>0 && contadorDeTorres<=maxDeTorres+1){contadorDeTorres++;}
                    if(contadorDeTorres<=maxDeTorres && maxDeTorres>0){
                        eveCrearTorre(unSoldado.getX(), unSoldado.getY());
                        System.out.println("Cantidad de torres " + contadorDeTorres);
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
        
        private boolean moverseConMemoria=false;
        /**
         * Permite decidir si la unidad se mueve en forma aleatoria o con una memoria ya guardada.
         * @return Retorna verdadero si las decisiones de movimiento estan guardadas.
         */
        public boolean getMoverseConMemoria(){
            return moverseConMemoria;
        }
        
        public void setMoverseConMemoria(boolean si_moverse_con_memoria){
            moverseConMemoria=si_moverse_con_memoria;
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
//                    nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino); No se puede agregar porque haria un fitback con los datos.
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
        * Permite ir retornando los items guardados de las decisiones por medio de un contador de llamadas.
         * @return Retorna una decision de direccion guardada.
         */
        public abstract DecisionesDeMovimientos getDesicionGuardada();
        public  ArrayList<DecisionesDeMovimientos> rsDecisiones=new ArrayList();
        
        /**
         * Permite gistionar la decision tomada, ya sea una decision guardada o una decision aleatoria.
         * @param nuevo Un objeto del class PersonajeEvolucionado.
         * @param nueva_decision Un objeto del class DecisionesDeMovimientos
         */
        private void gestionarDesicion(PersonajeEvolucionado nuevo, DecisionesDeMovimientos nueva_decision){
            //////Ejecutando las decisiones.
            switch(nueva_decision){
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
                        nuevo.memoriaDelCamino.setDecision(nueva_decision); //Se guarda la nueva decision, diferente a la actual.
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
                        nuevo.memoriaDelCamino.setDecision(nueva_decision);
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
                        nuevo.memoriaDelCamino.setDecision(nueva_decision);
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
        }

        /**
         * No se usa pero lo conservo por si acaso.
         */
//        private int postcolision=0;
        private DecisionesDeMovimientos desicion=DecisionesDeMovimientos.derecha, valorDeDesicion=DecisionesDeMovimientos.derecha;
        private int contador_de_memoria=0;
        private boolean cambiar=false;
        
        @Override
        public void moverse() {
            
            int id=numeroAleatorio(1,ObjetosEstaticos.soldadosEnemigos.size()); //El movimeinto se transfiere a cualquier soldado en la llamada actual.
            if(id==ObjetosEstaticos.soldadosEnemigos.size()){id=0;}
            PersonajeEvolucionado nuevo=ObjetosEstaticos.soldadosEnemigos.get(id);
            /**
             * Se obtiene un valor booleano que indica que puede moverse aleatoriamente.
             */
            if(getMoverseConMemoria()==false){
                decisionSeleccionada(nuevo);
                gestionarDesicion(nuevo,this.desicion);
    //            System.out.println(desicion +"=En los bordes decidiendo a " + valorDeDesicion);

    //            nuevo.memoriaRuta.agregarAlFinal(nuevo.memoriaDelCamino);
    //            System.out.println(desicion +"=Contra objetos decidiendo a " + valorDeDesicion);
            }
            /**
             * Se realizan movimientos guardados.
             */
            if(getMoverseConMemoria()==true){
                if(cambiar==false){
                    if(contador_de_memoria>=this.memoriaRuta.size()-1){
                        this.ejecutarRutaGuardada(contador_de_memoria);
                    }else{
                        cambiar=true;
                    }
                    contador_de_memoria--;
                }
                if(cambiar==true){
                    contador_de_memoria++;
                    if(contador_de_memoria<this.memoriaRuta.size()){
                        this.setMoverseConMemoria(false);
                    }else{
                        cambiar=false;
                    }
                }
            }
        }

        /**
         * Toma 3 diferentes desciiones de acciones.
         * Pero se debe limitar donde colocar un edificio y cuantos edificios colocar.
         * Casi es mejor colocar marcas donde deben ir los edificios.
         * Lo mismo con la cantidad de unidades.
         */
        @Override
        public void diferentesAcciones() {
            int a=numeroAleatorio(1,2);
            
            switch(a){
                case 1:
                    try{
//                        System.out.println("Creando un edificio. " + a);
                        this.crearEdificio();
                    }catch(Exception e){}
                    break;
                case 2:
//                    System.out.println("Creando una unidad. " + a);
                    this.crearUnidad();
                    break;
            }
        }
        
        /**
         * Puedes crear un vector de controles JLabels para que este class pueda usarlo en "validarColision".
         * 
         * @return Retorna un vector de controles JLabels.
         */
        public abstract JLabel []getVectorDeJLabels();
        
        /**
         * Permite cargar un JLabel en el control.
         * Primer elimina el label anterior y recoloca uno nuevo.
         * @param nuevo_jLabel Se obtiene un control JLabel cargado con una imagen.
         */
        public abstract void eveValidarColision(JLabel nuevo_jLabel);

        /**
         * Se usa en la toma de decisiones hacia donde moverse.
         * @param nuevo Un objeto del class PersonajeEvolucionado.
         * @return Retorna true si existe una colision.
         */
        @Override
        public boolean validarColision(PersonajeEvolucionado nuevo) {
            JLabel []mLabels=getVectorDeJLabels();
            for (JLabel Lb: mLabels){
                eveValidarColision(Lb);
    //            Edificios
                if( nuevo.getLabel().colision(Lb)==true){
//                    System.out.println("Colision con objeto en: " + nuevo.memoriaDelCamino.toString());
                    if(nuevo.memoriaDelCamino.XY_final.x_es_mayor_a_cero()==true){
                        memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getX()-nuevo.getVelocidad());
                    }else{
                        memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getX()+5);
                    }
                    if(nuevo.memoriaDelCamino.XY_final.y_es_mayor_a_cero()==true){
                        memoriaDelCamino.XY_final.setY(nuevo.memoriaDelCamino.XY_final.getY()+nuevo.getVelocidad());
                    }else{
                        memoriaDelCamino.XY_final.setY(nuevo.memoriaDelCamino.XY_final.getY()-5);
                    }
                    
                    return true;
                }else{
                    if(nuevo.memoriaDelCamino.XY_final.x_es_mayor_a_cero()==true){
                        memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getX());
                    }else{
                        memoriaDelCamino.XY_final.setX(nuevo.memoriaDelCamino.XY_final.getX());
                    }
                    if(nuevo.memoriaDelCamino.XY_final.y_es_mayor_a_cero()==true){
                        memoriaDelCamino.XY_final.setY(nuevo.memoriaDelCamino.XY_final.getY());
                    }else{
                        memoriaDelCamino.XY_final.setY(nuevo.memoriaDelCamino.XY_final.getY());
                    }
                    this.rsDecisiones.add(desicion);
//                    this.memoriaRuta.agregarAlFinal(memoriaDelCamino);
                }                
            }

            
            for(int i=0; i<ObjetosEstaticos.soldadosAliados.size(); i++){
                if(nuevo.getLabel().colision(ObjetosEstaticos.soldadosAliados.get(i).getLabel())==true){
//                    System.out.println("Colision con borde.");
                    nuevo.quitarLabel();
                    nuevo.ponerLabel(nuevo.getX_UltimaPosicion(), nuevo.getY_UltimaPosicion(), TipoDeImagen.Explosion);
//                    add(nuevo.getLabel());
                    for(int a=0; a<ObjetosEstaticos.soldadosAliados.size(); a++){
                        ObjetosEstaticos.soldadosAliados.get(a).quitarLabel();
                        ObjetosEstaticos.soldadosAliados.get(a).ponerLabel(ObjetosEstaticos.soldadosAliados.get(a).getX_UltimaPosicion(), ObjetosEstaticos.soldadosAliados.get(a).getY_UltimaPosicion(), TipoDeImagen.Tanque);
                        
                        eveValidarColision(ObjetosEstaticos.soldadosAliados.get(a).getLabel());
                    }
                    for(int a=0; a<ObjetosEstaticos.soldadosEnemigos.size(); a++){
                        ObjetosEstaticos.soldadosEnemigos.get(a).quitarLabel();
                        ObjetosEstaticos.soldadosEnemigos.get(a).ponerLabel(ObjetosEstaticos.soldadosEnemigos.get(a).getX_UltimaPosicion(), ObjetosEstaticos.soldadosEnemigos.get(a).getY_UltimaPosicion(), TipoDeImagen.Tanque);
                        
                        eveValidarColision(ObjetosEstaticos.soldadosAliados.get(a).getLabel());
                    }
                    return true;
                }
            }
            return false;
        }
}
