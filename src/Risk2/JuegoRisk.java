/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Risk2;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Rafael Angel Montero Fernández.
 * Sabado 24 de setiembre del 2022.
 * He llegado al final del experimento con este documento.
 * Este juego Risk no es viable.
 * Tendré que recomenzar en JuegoRisk2, aunque en realidad es como la version 5 o 10.
 * Quiero decir el intento 5 o 10.
 * 
 */
public class JuegoRisk {
    
    public JuegoRisk(){
        escenario=new EscenarioRisk();
        unidad=new UnidadRisk(NombresDeFacciones.estelares, "Oponente", 3);
        unidad.prTipoDeUnidad.setPropiedad(UnidadRisk.TipoDeUnidad.tanque);
        jugador=new Jugador(NombresDeFacciones.estelares);
        usuario=new Jugador(NombresDeFacciones.Humanos);
    }
    
    
    private EscenarioRisk escenario ;
    private Facciones facciones=new Facciones();
    private UnidadRisk unidad;
    private Jugador jugador, usuario;
    
    private void moverseSelectivo(UnidadRisk nueva_unidad, int f, int c){
        int accionesAleatorias=Jugador.numeroAleatorio(1, 8); //Es bueno que siga siendo un inicio aleatorio por si no se encuentra alguna condicion valida.
        
        int idF=0, idC=0;
            if((f-1>=0) && (accionesAleatorias==1)){
                System.out.println("Arriba");
//                if(escenario.escenario[f-1][c].getFaccionPropietaria()!=nueva_unidad.faccion){
                   idF=f-1;idC=c;  
                   escenario.escenario[idF][idC].unidades.add(new UnidadRisk(nueva_unidad.faccion, nueva_unidad.nombre, 1, nueva_unidad.prTipoDeUnidad.getPropiedad()));
                   escenario.escenario[idF][idC].unidades.detectarEnemigos();
//                }
            }

            if((f+1<escenario.escenario.length) && (accionesAleatorias==2)){
                System.out.println("Abajo");
//                if(escenario.escenario[f+1][c].getFaccionPropietaria()!=nueva_unidad.faccion){
                   idF=f+1;idC=c;  
                   escenario.escenario[idF][idC].unidades.add(new UnidadRisk(nueva_unidad.faccion, nueva_unidad.nombre, 1, nueva_unidad.prTipoDeUnidad.getPropiedad()));
                   escenario.escenario[idF][idC].unidades.detectarEnemigos();
//                }
            }

            if((c+1<escenario.escenario.length) && (accionesAleatorias==3)){
                System.out.println("Derecha");
//                if(escenario.escenario[f][c+1].getFaccionPropietaria()!=nueva_unidad.faccion){
                   idF=f;idC=c+1;  
                   escenario.escenario[idF][idC].unidades.add(new UnidadRisk(nueva_unidad.faccion, nueva_unidad.nombre, 1, nueva_unidad.prTipoDeUnidad.getPropiedad()));
                   escenario.escenario[idF][idC].unidades.detectarEnemigos();
//                }
            }

            if((c-1>=0) && (accionesAleatorias==4)){
                System.out.println("Izquierda");
//                if(escenario.escenario[f][c-1].getFaccionPropietaria()!=nueva_unidad.faccion){
                   idF=f;idC=c-1; 
                   escenario.escenario[idF][idC].unidades.add(new UnidadRisk(nueva_unidad.faccion, nueva_unidad.nombre, 1, nueva_unidad.prTipoDeUnidad.getPropiedad()));
                   escenario.escenario[idF][idC].unidades.detectarEnemigos();
//                }
            }
            
        
        //Crear edificio.
        if(accionesAleatorias==5){
            System.out.println("Edicficio creado");
            idF=f;idC=c; 
            UnidadRisk edificio=new UnidadRisk(nueva_unidad.faccion, "EdificioCreadoPor" + nueva_unidad.nombre, 1, UnidadRisk.TipoDeUnidad.edificio);
            escenario.escenario[idF][idC].unidades.add(edificio);
        }
        //Crear civil.
        if(accionesAleatorias==6){
            System.out.println("Civil creado");
            idF=f;idC=c; 
            UnidadRisk edificio=new UnidadRisk(nueva_unidad.faccion, "CivilHijoDe" + nueva_unidad.nombre, 1, UnidadRisk.TipoDeUnidad.civil);
            escenario.escenario[idF][idC].unidades.add(edificio);
        }
        //Crear soldado.
        if(accionesAleatorias==7){
            System.out.println("Soldado entrenado");
            idF=f;idC=c; 
            UnidadRisk edificio=new UnidadRisk(nueva_unidad.faccion, "SoldadoEntrenadoPor" + nueva_unidad.nombre, 1, UnidadRisk.TipoDeUnidad.soldado);
            escenario.escenario[idF][idC].unidades.add(edificio);
        }
        //Crear tanque.
        if(accionesAleatorias==8){
            System.out.println("Tanque creado");
            idF=f;idC=c; 
            UnidadRisk edificio=new UnidadRisk(nueva_unidad.faccion, "TanqueArmadoPor" + nueva_unidad.nombre, 1, UnidadRisk.TipoDeUnidad.tanque);
            escenario.escenario[idF][idC].unidades.add(edificio);
        }
        jugador.setEscenario(escenario);
        System.out.println("Escenario conquistado\n" + jugador.InformeDeTerritoriosConquistados(true));
        System.out.println("idF="+idF + "; idC=" + idC);
        System.out.println("escenario=" + escenario.toString());
        
        
    }
    
    private void moverseAleatorio(UnidadRisk nueva_unidad, int f, int c){
        int ruta_elegida=Jugador.numeroAleatorio(1, 4);
            
            if((f-1>=0) && (ruta_elegida==1)){
                //Arriba
                escenario.escenario[f-1][c].unidades.add(nueva_unidad);
               escenario.escenario[f-1][c].unidades.detectarEnemigos();
            }
            
            if((f+1<escenario.escenario.length) && (ruta_elegida==2)){
                //Abajo
                escenario.escenario[f+1][c].unidades.add(nueva_unidad);
                escenario.escenario[f+1][c].unidades.detectarEnemigos();
            }
            
            if((c+1<escenario.escenario.length) && (ruta_elegida==3)){
                //Derecha
                escenario.escenario[f][c+1].unidades.add(nueva_unidad);
                escenario.escenario[f][c+1].unidades.detectarEnemigos();
            }
            
            if((c-1>=0) && (ruta_elegida==4)){
                //izquierda
                escenario.escenario[f][c-1].unidades.add(nueva_unidad);
                escenario.escenario[f][c-1].unidades.detectarEnemigos();
            }
    }
    
    public void oponente(){
        int f=Jugador.numeroAleatorio(0, 3), c=Jugador.numeroAleatorio(0, 3);
        escenario.escenario[f][c].unidades.add(unidad);
        escenario.escenario[f][c].unidades.crearNuevaunidad(NombresDeFacciones.estelares, UnidadRisk.TipoDeUnidad.edificio);
        

        UnidadRisk u=escenario.escenario[f][c].unidades.extraerAlgunaUnidad();
        
////            this.moverseAleatorio(unidad, f, c);
////            moverseAleatorio(unidad, f, c);
////            moverseAleatorio(unidad, f, c);
            
            
        moverseSelectivo(unidad, f, c);
//        jugador.setEscenario(escenario);
//        System.out.println("Escenario conquistado\n" + jugador.InformeDeTerritoriosConquistados(true));
        moverseSelectivo(unidad, f, c);
//        jugador.setEscenario(escenario);
//        System.out.println("Escenario conquistado\n" + jugador.InformeDeTerritoriosConquistados(true));
        moverseSelectivo(unidad, f, c);
//        jugador.setEscenario(escenario);
//        System.out.println("Escenario conquistado\n" + jugador.InformeDeTerritoriosConquistados(true));
        moverseSelectivo(unidad, f, c);

//        jugador.setEscenario(escenario);
//        System.out.println("Escenario conquistado\n" + jugador.InformeDeTerritoriosConquistados(true));
        
        
        
//        facciones.addAcciones(escenario, jugador.getFaccionPropietaria());No es necesario.
        
//        System.out.println(jugadorHumano.InformeDeTerritoriosConquistados(true));
    }
    
    
    public void humano(){
//        escenario=facciones.ObtenerEscenario(NombresDeFacciones.Humanos);No porque da problemas... anula las acciones del oponente.
        int f=Jugador.numeroAleatorio(0, 3), c=Jugador.numeroAleatorio(0, 3);
        escenario.escenario[f][c].unidades.add(new UnidadRisk(NombresDeFacciones.Humanos,"Rafael",3,UnidadRisk.TipoDeUnidad.soldado));
//        usuario.setEscenario(escenario);
//        System.out.println("Escenario de inicio\n" + usuario.InformeDeTerritoriosConquistados(true));
//                
//                System.out.println("(Oponente) Es null=" + (escenario.escenario[f][c].unidades.extraerAlgunaUnidad()==null));
        UnidadRisk u=escenario.escenario[f][c].unidades.extraerAlgunaUnidad();
        f=Jugador.numeroAleatorio(0, 3); c=Jugador.numeroAleatorio(0, 3);
        escenario.escenario[f][c].unidades.add(u);
        usuario.setEscenario(escenario);
        System.out.println("Escenario conquistado\n" +usuario.InformeDeTerritoriosConquistados(true));
        
        usuario.setEscenario(escenario);
        escenario.escenario[f][c].unidades.detectarEnemigos();
        facciones.addAcciones(escenario, usuario.getFaccionPropietaria());
        
//        System.out.println(jugadorHumano.InformeDeTerritoriosConquistados(true));
    }
    
    
    public static void main(String []a){
        
        JuegoRisk j=new JuegoRisk();
        j.oponente();
//        j.humano();
    }
}



class Propiedad<r>{
    
    @Override
    public String toString(){
        return "" + propiedad;
    }
    
    private r propiedad;
    public void setPropiedad(r datos){
        propiedad=datos;
    }
    public r getPropiedad(){
        return propiedad;
    }
}

class UnidadRisk implements Serializable{
    
    public UnidadRisk(NombresDeFacciones tu_faccion, String tu_nombre, int tus_puntos_de_vida){
        this.faccion=tu_faccion;
        this.nombre=tu_nombre;
        this.puntosDeVida=tus_puntos_de_vida;
        this.prTipoDeUnidad=new Propiedad();
//        System.out.println(toString());
    }
    
    @Override
    public String toString(){
        return "Faccion " + faccion + ", nombre " + nombre + ", puntos de vida " + this.puntosDeVida + 
                ", tipo de unidad " + this.prTipoDeUnidad + ", esta seleccionada " + this.estaSeleccionada;
    }
    
    public NombresDeFacciones faccion;
    public int puntosDeVida=0;
    public boolean estaSeleccionada=false;
    
    public String nombre="";
    public Propiedad<TipoDeUnidad> prTipoDeUnidad;
    public String recursos="";
    
    public enum TipoDeUnidad{
        civil,soldado,tanque,edificio,territorio
    }
    
    public UnidadRisk(){
        prTipoDeUnidad=new Propiedad<TipoDeUnidad>();
        puntosDeVida=1;
    }
    
    public UnidadRisk(NombresDeFacciones nueva_faccion, String nuevo_nombre, int nuevosPuntosDeVida, TipoDeUnidad nuevo_tipo_de_unidad){
        prTipoDeUnidad=new Propiedad();
        this.prTipoDeUnidad.setPropiedad(nuevo_tipo_de_unidad);
        faccion=nueva_faccion;
        nombre=nuevo_nombre;
        puntosDeVida=nuevosPuntosDeVida;
    }
}

class RsUnidades{
    /**
     * Permite saber a que faccion pertenece el rs.
     * @return Retorna el nombre de la faccion propietaria.
     */
    public NombresDeFacciones FaccionPropietaria(){
//        try{
            for(UnidadRisk u: mRs){
                if(u!=null){
                    return u.faccion;
                }
            }
//        }catch(Exception e){
//            
//        }
        return NombresDeFacciones.sinFaccion;
    }
    
    private UnidadRisk []mRs=new UnidadRisk[4];
    
    /**
     * Valida una unidad entrante, si es de la misma faccion no sucede nada.
     * Si la unidad entrante es de otra faccion entonces sucede un enfrentamiento
     * entre la unidad enemiga y todas las unidades en el rs hasta que la unidad enemiga
     * sea eliminada o que las unidades en el rs sean eliminadas.
     * Si la unidad enemiga sobrevive es agregada como primer item del rs y
     * su faccion se vuelve propietaria.
     * @param nuevo Un objeto UnidadRisk.
     */
    protected boolean enfrentar(UnidadRisk nuevo){
        boolean war=false;
        try{
//            System.out.println("La faccion en el territorio es " + this.FaccionPropietaria());
            for(int i=0; i<mRs.length; ++i){
                int puntos=nuevo.puntosDeVida;
                if(mRs[i]!=null){
                    if(mRs[i].puntosDeVida>puntos){
                        System.out.println("Enemigo (" + nuevo.faccion + ") eliminado y la unidad " + mRs[i].nombre + " le quedan " + (mRs[i].puntosDeVida-nuevo.puntosDeVida) + " puntos.");
                        mRs[i].puntosDeVida-=nuevo.puntosDeVida;
                        nuevo=null;
                        war=true;
                    }
                    else if(mRs[i].puntosDeVida<puntos){
                        nuevo.puntosDeVida-=mRs[i].puntosDeVida;
                        System.out.println("Hemos perdido la unidad " + mRs[i].nombre);
                        mRs[i]=null;
                        war=true;
                    }
                    else if(mRs[i].puntosDeVida==puntos){
                        System.out.println("Hemos perdido la unidad " + mRs[i].nombre + " ademas, hemos eliminado al enemigo.");
                        war=true;
                        nuevo=null;
                        mRs[i]=null;
                    }
                }
            }
            return true;
        }catch(Exception e){}
        if(this.esBacio()==true){
            System.out.println("Hemos perdido todas las unidades.");
            if(nuevo!=null){
                if(nuevo.puntosDeVida>=1){
                    this.add(nuevo, 0);
                    System.out.println("La unidad enemiga " + nuevo.nombre + 
                            " ha sobrevivido y ahora el territrio es suyo. Faccion " + FaccionPropietaria());
                    war=true;
                }
            }
        }
        informar();
        return war;
    }
    
    public int size(){
        return mRs.length;
    }
    
    public UnidadRisk verUnidad(int id){
        try{
            UnidadRisk respuesta=mRs[id];
            return respuesta;
        }catch(Exception e){
            
        }
        return null;
    }
    
    /**
     * Es la cantidad de unidades que no sean null que estan en el territorio.
     * No debe confundirse con la funcion size(), porque size() retorna el total 
     * de espacios en la matriz de unidades.
     * @return Retorna la cantidad de unidades activas.
     */
    public int CantidadDeUnidadesActivas(){
        int cont=0;
        try{
            for(UnidadRisk respuesta : mRs){
                if(respuesta!=null){
                    if(respuesta.prTipoDeUnidad.getPropiedad()!=UnidadRisk.TipoDeUnidad.edificio){
                        cont++;
                    }
                }
                
            }
        }catch(Exception e){
            
        }
        return cont;
    }
    
    
    public UnidadRisk extraerAlgunaUnidad(){
        try{
            int cont=0;
            for(UnidadRisk respuesta : mRs){
                if(respuesta!=null){
                    if(respuesta.prTipoDeUnidad.getPropiedad()!=UnidadRisk.TipoDeUnidad.edificio){
                        mRs[cont]=null;//Casilla de la unidad extraida.
                        return respuesta;
                    }
                }
                cont++;
            }
            
//            return respuesta;
        }catch(Exception e){
            
        }
        return null;
    }
    
    public UnidadRisk extraerUnidad(int id){
        try{
            UnidadRisk respuesta=new UnidadRisk( mRs[id].faccion, mRs[id].nombre, mRs[id].puntosDeVida);
            mRs[id]=null;
            return respuesta;
        }catch(Exception e){
            
        }
        return null;
    }
    
    /**
     * Detecta si una unidad de otra faccion se agregó al rs por medio del metodo add.
     * Si la existe una que sea de otra faccion la extrae y la enfrenta con el resto de unidades
     * del rs.
     */
    public void detectarEnemigos(){
        try{
        System.out.println("Buscando enemigos. ");
        for(int i=0; i<size(); ++i){
            UnidadRisk UnidadSospechosa=null;
            if(this.verUnidad(i)!=null){
//                System.out.println(verUnidad(i));
                UnidadSospechosa=extraerUnidad(i);
            }//else{ System.out.println("Es null");}
            for(UnidadRisk x:mRs){
                if(UnidadSospechosa!=null ){
                    if(x!=null){
//                        System.out.println("Buscando...");
                        if(UnidadSospechosa.faccion!=x.faccion){
                            System.out.println("Se ha detectado una unidad enemiga, su faccion es " + UnidadSospechosa.faccion);
                            this.enfrentar(UnidadSospechosa);
                        }
                    }
                }
            }
        }
        }catch(Exception e){}
    }
    /**
     * Solo valida si es una unidad enemiga.
     * @param nuevo Un objeto UnidadRisk.
     * @return Retorna true si es un enemigo, false en caso contrario.
     */
    protected boolean esEnemigo(UnidadRisk nuevo){
        for(int i=0; i<mRs.length;++i){
            if(mRs[i]!=null){
                if(mRs[i].faccion==nuevo.faccion){
                    return true;
                }
            }
        }
        return false; //Si es de otra faccion.
    }
    
    /**
     * Comprueba si aun existen unidades vivas (Casillas que no sean null).
     * @return True existe una o muchas unidades vivas, false no existen unidades vivas.
     */
    private boolean esBacio(){
        int cont=0;
        for(int i=0; i<mRs.length; ++i){
            try{
                //Se usa un try catch porque el condicional if no valida bien si es null o no.
                String s=mRs[i].nombre ;
                cont++;
            }catch(Exception e){
//                System.out.println("cont="+cont );
            }
        }
//        System.out.println("cont<=0 == "+(cont<=0));
        return cont<=0;
    }
    
    /**
     * Permite crear una unidad directamente en el registro sin necesidad 
     * de declarar variables o instancias externas.
     * La unica desventaja es que todas las unidades creadas solo tienen un punto de vida.
     * @param su_faccion Un item del enum NombresDeFacciones.
     * @param tipo_de_unidad Un item del enum UnidadRisk.TipoDeUnidad.
     */
    public void crearNuevaunidad(NombresDeFacciones su_faccion, UnidadRisk.TipoDeUnidad tipo_de_unidad){
        crearNuevaunidad(su_faccion,  tipo_de_unidad,"Nuevo_" + tipo_de_unidad + "_de_"+su_faccion, 1);
    }
    
    /**
     * Permite crear una unidad directamente en el registro sin necesidad 
     * de declarar variables o instancias externas.
     * @param su_faccion Un item del enum NombresDeFacciones.
     * @param tipo_de_unidad Un item del enum UnidadRisk.TipoDeUnidad.
     * @param nuevo_nombre Nombre de la nueva unidad, lo elige el usuario o programador o en forma aleatoria.
     * @param puntos_de_vida Un valor aleatorio o elegido por el usuario o programador.
     */
    public void crearNuevaunidad(NombresDeFacciones su_faccion, UnidadRisk.TipoDeUnidad tipo_de_unidad, String nuevo_nombre, int puntos_de_vida){
        UnidadRisk nuevaUnidad=new UnidadRisk();
        nuevaUnidad.faccion=su_faccion;
        nuevaUnidad.prTipoDeUnidad.setPropiedad(tipo_de_unidad);
        nuevaUnidad.nombre=nuevo_nombre;
        nuevaUnidad.puntosDeVida=puntos_de_vida;
        this.add(nuevaUnidad);
    }
    
    /**
     * Agrega una nueva unidad al rs.
     * @param nuevo Un objeto UnidadRisk.
     */
    public void add(UnidadRisk nuevo)
    {
        System.out.println("add");//("(add) Es null=" + (nuevo==null));
        add(nuevo,0);//Se agregan por medio de busqueda de campos.
//        this.detectarEnemigos(); Definitivamente aqui no.
    }
    
    /**
     * Agrega una nueva unidad al rs.
     * @param nuevo Un objeto UnidadRisk.
     * @param id Un numero de alguna casilla.
     */
    public void add(UnidadRisk nuevo,int id){
        if(mRs[0]==null){
            mRs[0]=new UnidadRisk(nuevo.faccion,nuevo.nombre,nuevo.puntosDeVida, nuevo.prTipoDeUnidad.getPropiedad()) ;
            System.out.println("Primera unidad (" + mRs[0].nombre +") agregada, faccion " + mRs[0].faccion);
            return;
        }
        
        if(mRs[id]==null && (id<=mRs.length-1)){
            if(this.esEnemigo(nuevo)==false){
                mRs[id]=nuevo;
                System.out.println("Unidad agregada por medio del parametro id en " + id);
            }
        }
        else if(mRs[id]!=null && (id<=mRs.length-1)){
            for(int i=0; i<mRs.length; ++i){
                if(mRs[i]==null){
                    mRs[i]=nuevo;
                    System.out.println("Unidad agregada por medio de la busqueda de un campo bacio");
                    return;
                }
            }
        }
        System.out.println("Mensaje para la faccion " + nuevo.faccion + ". Ya no se pueden agragar más unidades, ya no hay espacio.");
    }
    
    /**
     * Informa cuantas unidades viven o no en el rs.
     */
    protected void informar(){
        System.out.println("Informando");
        for(int i=0; i<mRs.length;++i){
            if(mRs[i]!=null){
                System.out.println("id="+i + ")" + mRs[i].toString() );
            }
        }
    }
    
    
}

interface PropiedadFaccion{
    public NombresDeFacciones getFaccionPropietaria();
}

/**
 * El territorio usa el class RsUnidades, el cual le da todas las propiedades necesarias.
 * Usa un objeto UnidadRisk para crear las propiedades del tipo de terreno.
 * @author Rafael
 */
class Territorio implements PropiedadFaccion{
    
    public class Ubicasion{
        public int idFila=-1;
        public int idColumna=-1;
    }
    
    public Ubicasion ubicasion_del_territorio=new Ubicasion();
    
    public String territoriosConquistados(NombresDeFacciones su_faccion){
        if(getFaccionPropietaria()==su_faccion){
            return "Nombre del territorio " + terreno.nombre + 
                ", faccion propietaria del territorio " + getFaccionPropietaria() + "\n"; 
        }
        return "";
    }
    
    @Override
    public String toString(){
        return "Nombre del territorio " + terreno.nombre + 
                ", faccion propietaria del territorio " + getFaccionPropietaria() + ", recursos " + terreno.recursos;
    }
    
    public Territorio(){
        terreno=new UnidadRisk();
        terreno.recursos="10";//Recursos
        terreno.faccion=NombresDeFacciones.sinFaccion;
        terreno.prTipoDeUnidad.setPropiedad(UnidadRisk.TipoDeUnidad.territorio);
        terreno.nombre="Tropical";
        unidades=new RsUnidades();
    }
    
    public Territorio(String nombre_del_ambiente_del_territorio){
        terreno=new UnidadRisk();
        terreno.recursos="10";//Recursos
        terreno.faccion=NombresDeFacciones.sinFaccion;
        terreno.prTipoDeUnidad.setPropiedad(UnidadRisk.TipoDeUnidad.territorio);
        terreno.nombre=nombre_del_ambiente_del_territorio;
        unidades=new RsUnidades();
    }
    
    public Territorio(String nombre_del_ambiente_del_territorio, NombresDeFacciones nueva_faccion){
        terreno=new UnidadRisk();
        terreno.recursos="10";//Recursos
        terreno.faccion=nueva_faccion;
        terreno.prTipoDeUnidad.setPropiedad(UnidadRisk.TipoDeUnidad.territorio);
        terreno.nombre=nombre_del_ambiente_del_territorio;
        unidades=new RsUnidades();
    }
    
    public UnidadRisk terreno=null;
    public RsUnidades unidades=null;
    
    @Override
    public NombresDeFacciones getFaccionPropietaria(){
        terreno.faccion=unidades.FaccionPropietaria();
        return unidades.FaccionPropietaria();
    }
    
}

interface Movimientos{
    public Territorio irArriba();
    Territorio irAbajo();
    public Territorio irIzquierda();
    public Territorio irDerecha();
}

/**
 * Este es un solo territorio, la fila y la columna a la que se muevan las 
 * facciones siempre tendran el valor del movimiento realizado por la faccion anterior.
 * Todo va bien.
 * La solucion es crear una instancia del escenario por faccion, una copia exacta 
 * pero sin los valores del id fila y del id columna. Estos valores se conservan en la faccion.
 * Finalmente existira un solo escenario global en el que se reflegen las 
 * acciones realizadas dentro de los escenarios de cada faccion.
 * Será algo asi como un merge en git. Un escenario master.
 * 
 * @author Rafael
 */
class EscenarioRisk implements Movimientos{
    
    /**
     * Le da el id a cada territorio.
     */
    public EscenarioRisk(){
        for(int c=0; c<escenario.length; ++c){
            for(int f=0; f<escenario.length; ++f){
                escenario[f][c]=new Territorio();
                escenario[f][c].ubicasion_del_territorio.idColumna=c;
                escenario[f][c].ubicasion_del_territorio.idFila=f;
            }
        }
    }
    
    
    @Override
    public String toString(){
        String informe="Status de los territorios del escenario.\n";
        for(int c=0; c<escenario.length; ++c){
            for(int f=0; f<escenario.length; ++f){
                informe+=escenario[f][c].toString() + "\n";
            }
        }
        return informe;
    }
    
    protected Territorio [][]escenario=new Territorio[4][4];//4*4=8
    private int fila=0, columna=0;
    
    public void setIdFila(int nuevo_valor){
        fila=nuevo_valor;
    }
    
    public void setIdColumna(int nuevo_valor){
        columna=nuevo_valor;
    }
    
    /**
     * Su valor cambia con las acciones irIzquierda e irDerecha.
     * @return Retorna un numero de fila.
     */
    public int getIdFila(){
        return fila;
    }
    
    /**
     * Su valor cambia con las acciones irAbajo e irArriba.
     * @return Retorna un numero de columna.
     */
    public int getIdColumna(){
        return columna;
    }
    
    @Override
    public Territorio irArriba(){
        try{
            if(columna>=1){
                columna-=1;
                return escenario[fila][columna];
            }
            else{
                //columna <=0 
            }
        }catch(Exception e){}
        return null;
    }
    
    @Override
    public Territorio irAbajo(){
        try{
            if(columna<=escenario.length-1){
                columna+=1;
                return escenario[fila][columna];
            }
            else{
                //columna > escenario.length -1
            }
        }catch(Exception e){}
        return null;
    }
    
    @Override
    public Territorio irIzquierda(){
        try{
            if(fila>=1){
                fila-=1;
                return escenario[fila][columna];
            }
            else{
                //fila <= 0
            }
        }catch(Exception e){}
        return null;
    }
    
    @Override
    public Territorio irDerecha(){
        try{
            if(fila<=escenario.length-1){
                fila+=1;
                return escenario[fila][columna];
            }
            else{
                //fila > escenario.length -1
            }
        }catch(Exception e){}
        return null;
    }
    
}

/**
 * Este class no es necesario.
 * @author Rafael
 */
class Facciones{
    /**
     * Cada faccion recive una copia del escenario global.
     */
    public Facciones(){
        
        mFacciones[0]=escenarioGlobal;
        mFacciones[1]=escenarioGlobal;
    }
    
    /**
     * Por el momento solo 2 facciones.
     */
    public EscenarioRisk []mFacciones=new EscenarioRisk[2];//1=faccion humanos, 2=faccion estelares
    
    public EscenarioRisk escenarioGlobal=new EscenarioRisk();
    
    /**
     * 
     * @param nombre_de_la_faccion Un objeto de la enumeracion NombresDeFacciones.
     * @return Retorna una copia del escenario global para cada faccion.
     */
    public EscenarioRisk ObtenerEscenario(NombresDeFacciones nombre_de_la_faccion){
        if(nombre_de_la_faccion==NombresDeFacciones.Humanos)
        {
            mFacciones[0]=escenarioGlobal;
            return mFacciones[0];
        }
        else if(nombre_de_la_faccion==NombresDeFacciones.estelares)
        {
            mFacciones[1]=escenarioGlobal;
            return mFacciones[1];
        }
        return null;
    }
    
    /**
     * Actualiza la copia local del escenario del usuario actual.
     * Ademas, actualiza el escenario global.
     * @param tu_escenario Un objeto EscenarioRisk que representa el escenario del usuario actual.
     * @param nombre_de_la_faccion Un objeto del enumerado NombresDeFacciones.
     * @return Retorna el escenario global actualizado.
     */
    public EscenarioRisk addAcciones(EscenarioRisk tu_escenario, NombresDeFacciones nombre_de_la_faccion){
        escenarioGlobal=tu_escenario; //El escenario global se actualiza incondicionalmente.
        if(nombre_de_la_faccion==NombresDeFacciones.Humanos)
        {
            mFacciones[0]=tu_escenario;
            return escenarioGlobal;
        }
        else if(nombre_de_la_faccion==NombresDeFacciones.estelares)
        {
            mFacciones[1]=tu_escenario;
            return escenarioGlobal;
        }
        return null;
    }
    
    
}

/**
 * Enumerado para las diferentes facciones del juego Risk.
 * @author RafaeL
 */
 enum NombresDeFacciones{
    Humanos, estelares,sinFaccion
 }

/**
 * Class para los diferentes jugadores (Humano, ia).
 * @author Rafael
 */
class Jugador implements Movimientos, PropiedadFaccion{
    public Jugador(NombresDeFacciones nuevo_nombre_de_la_faccion){
        this.faccion=nuevo_nombre_de_la_faccion;
    }
    /**
     * El default se usa en las interfaces, nuevo truco.
     * @param Min
     * @param Max
     * @return 
     */
    public static int numeroAleatorio(int Min, int Max){
        if(Min==0){
            Min=-1;
            int rnd=0;
            for(int i=0;i<Max;i++){
                rnd= (int)(Math.random()*(Max-Min+1)+Min);
                if(rnd!=-1){
                    return rnd;
                }
            }
        }
        
        return (int)(Math.random()*(Max-Min+1)+Min);
    }
    
    private Territorio territorioDeInicio=null;
    public Territorio getTerritorioDeInicio(){
        return territorioDeInicio;
    }
    
    /**
     * Obligatoriamente se debe agregar la primera unidad.
     * Elige aleatoriamente el territorio de la faccion.
     * @param nueva_unidad Una unidad inicializada.
     * @param nuevo_escenario Una copia del escenario global.
     */
    public Jugador(EscenarioRisk nuevo_escenario, UnidadRisk nueva_unidad){
        escenarioDelJugador=nuevo_escenario;
        int f=numeroAleatorio(0, escenarioDelJugador.escenario.length-1);
        int c=numeroAleatorio(0, escenarioDelJugador.escenario.length-1);
        if(escenarioDelJugador.escenario[f][c]==null){
            f=numeroAleatorio(0,escenarioDelJugador.escenario.length-1);
            c=numeroAleatorio(0,escenarioDelJugador.escenario.length-1);
            escenarioDelJugador.escenario[f][c]=new Territorio();
        }
        else{
            if(f==escenarioDelJugador.escenario.length-1){
                f-=2;
            }
            if(c==escenarioDelJugador.escenario.length-1){
                c-=2;
            }
                
            f=numeroAleatorio(f+1,escenarioDelJugador.escenario.length-1);
            c=numeroAleatorio(c+1,escenarioDelJugador.escenario.length-1);
            escenarioDelJugador.escenario[f][c]=new Territorio();
        }
        escenarioDelJugador.escenario[f][c].unidades.add(nueva_unidad);
        territorioDeInicio=escenarioDelJugador.escenario[f][c];
        this.faccion=escenarioDelJugador.escenario[f][c].getFaccionPropietaria();
        
    }
    /**
     * Es una copia del escenario global.
     */
    private EscenarioRisk escenarioDelJugador=null;
    /**
     * Recive una copia del escenario global en el que se reflejan las 
     * de todos los jugadores.
     * @param un_escenario Una copia del escenario global.
     */
    public void setEscenario(EscenarioRisk un_escenario){
//        System.out.println(un_escenario.escenario[3][3].unidades.verUnidad(0));
        escenarioDelJugador=un_escenario;
    }
    /**
     * Despues de realizar acciones con una copia del escenario global se retorna 
     * para ser recivido como actualizacion del escenario global.
     * @return Retorna un objeto EscenarioRisk. Es el escenario manipulado por el jugador actual.
     */
    public EscenarioRisk getEscenario(){
        return escenarioDelJugador;
    }
    
    
    private NombresDeFacciones faccion;
    @Override
     public NombresDeFacciones getFaccionPropietaria(){
         return faccion;
     }
     
     public void setFaccionPropietaria(NombresDeFacciones nuevo_nombre_de_la_faccion){
         faccion=nuevo_nombre_de_la_faccion;
     }
     
     /**
     * 
     * @return Retorna una matriz con las casillas vecinas a las que se puede mover.
     */
    public Territorio [][]territoriosVecinos(int id_fila, int id_columna){
        Territorio [][]m=new Territorio [2][2];
        //Lo que importa es detectar si la casilla actual pertenece al jugador actual.
        if(escenarioDelJugador.escenario[id_fila][id_columna].getFaccionPropietaria()==getFaccionPropietaria()){
            escenarioDelJugador.setIdColumna(id_fila);
            escenarioDelJugador.setIdFila(id_columna);
            m[0][0]=escenarioDelJugador.irAbajo();
            escenarioDelJugador.setIdColumna(id_fila);
            escenarioDelJugador.setIdFila(id_columna);
            m[1][1]=escenarioDelJugador.irArriba();
            escenarioDelJugador.setIdColumna(id_fila);
            escenarioDelJugador.setIdFila(id_columna);
            m[2][2]=escenarioDelJugador.irDerecha();
            escenarioDelJugador.setIdColumna(id_fila);
            escenarioDelJugador.setIdFila(id_columna);
            m[3][3]=escenarioDelJugador.irIzquierda();
            return m;
        }
        return m;
    }
    
    /**
     * 
     * @return Retorna las coordenadas de los territorios conquistados.
     */
    public String territoriosConquistadosCoordenadas(){
        String informe="";
        for(int f=0; f<escenarioDelJugador.escenario.length; ++f){
            for(int c=0; c<escenarioDelJugador.escenario.length; ++c){
                //Lo que importa es detectar si la casilla actual pertenece al jugador actual.
                if(escenarioDelJugador.escenario[f][c].getFaccionPropietaria()==getFaccionPropietaria()){
//                        System.out.println("Propia " + (escenarioDelJugador.escenario[f][c].getFaccionPropietaria()==getFaccionPropietaria()));
                   informe+= f + ":" + c + ";";
                }
            }
        }
        return informe;
    }
    
    /**
     * 
     * @return Retorna una matriz con las casillas vecinas a las que se puede mover.
     */
    public String InformeDeTerritoriosConquistados(boolean es_jugador_humano){
        
        String informe="Territorios conquistados.\nLista de corrdenadas:\n";
        if(es_jugador_humano==true){
            for(int f=0; f<escenarioDelJugador.escenario.length; ++f){
                for(int c=0; c<escenarioDelJugador.escenario.length; ++c){
//                    System.out.println("Mismas facciones " + (escenarioDelJugador.escenario[f][c].getFaccionPropietaria() + " vs " + getFaccionPropietaria()));
                    //Lo que importa es detectar si la casilla actual pertenece al jugador actual.
                    if(escenarioDelJugador.escenario[f][c].getFaccionPropietaria()==getFaccionPropietaria() ){
//                       System.out.println("[" + f + "][" + c + "]");
                        informe+=escenarioDelJugador.escenario[f][c].getFaccionPropietaria() + ", fila(" + f + "), columna(" + c + ")\n";
                    }
                }
            }
        }
        else{
            for(int f=0; f<escenarioDelJugador.escenario.length; ++f){
                for(int c=0; c<escenarioDelJugador.escenario.length; ++c){
                    //Lo que importa es detectar si la casilla actual pertenece al jugador actual.
                    if(escenarioDelJugador.escenario[f][c].getFaccionPropietaria()==getFaccionPropietaria()){
//                        System.out.println("[" + f + "][" + c + "]");
                       informe+= f + ":" + c + ";";
                    }
                }
            }
        }
//        System.out.println("si " + informe +"\n\n\n");
        if(informe.equalsIgnoreCase("Territorios conquistados.\nLista de corrdenadas:\n")==true){
            System.out.println(this.getFaccionPropietaria() + ": Ya no tenemos territorios conquistados, hemos perdido el juego.");
            siFueEliminadoDelMapa=true;
        }
        siFueEliminadoDelMapa=false;
        return informe;
    }
    
    private boolean siFueEliminadoDelMapa=false;
    /**
     * 
     * @return Retorna true si ya no hay territorios ni unidades en el mapa para el jugador actual. false si todavia tiene minimo un territorio.
     */
    public boolean SiFueEliminadoDelMapa(){
        return siFueEliminadoDelMapa;
    }
    
    /**
     * El codigo del subMenu se usa varias veces en el procedimiento menu().
     * 
     * @param nuevo_id_fila Un numero para la fila de la matriz.
     * @param nuevo_id_columna Un numero para la columna de la matriz.
     */
    private void subMenu(int nuevo_id_fila, int nuevo_id_columna){
        Scanner sc=new Scanner(System.in); //Escribe la cantidad deseada de unidades.
        int opcionElegida=sc.nextInt();
        if(opcionElegida>=escenarioDelJugador.escenario[nuevo_id_fila][nuevo_id_columna].unidades.size()){
            opcionElegida=escenarioDelJugador.escenario[nuevo_id_fila][nuevo_id_columna].unidades.size()-1;
        }
        if(escenarioDelJugador.escenario[nuevo_id_fila][nuevo_id_columna]!=null && (nuevo_id_fila-1!=-1 && nuevo_id_columna!=-1)){
            for(int i=0; i<=opcionElegida; ++i){
                if(escenarioDelJugador.escenario[nuevo_id_fila-1][nuevo_id_columna].unidades.verUnidad(i)!=null){
                    //Sucede la invacion de un territorio a otro, sucede el enfrentamiento entre dos facciones.
                    escenarioDelJugador.escenario[nuevo_id_fila][nuevo_id_columna].unidades.add(escenarioDelJugador.escenario[nuevo_id_fila][nuevo_id_columna].unidades.extraerUnidad(i));
                }
            }
        }
    }
    
    /**
     * Se usa en el procedimiento dialogoConJugadorHumano(),
     * es para poder interactuar con el jugador humano.
     */
    private void menu(){
        System.out.println ("Elija una de las siguientes coordenas de algun territorio conquistado");
        System.out.println ("Escriba en este formato: numero_de_fila;numero_de_columna.");
        System.out.println (InformeDeTerritoriosConquistados(true));
        
        Scanner sc=new Scanner(System.in);
        String []mCoordenadas=sc.next().split(";");
        int f=Integer.parseInt(mCoordenadas[0]), c=Integer.parseInt(mCoordenadas[1]);
        System.out.println("Sus coordenadas son:\nFila= " + f + "; columan=" + c);
        System.out.println("Escriba el numero que correspondo de uno de los siguientes items:\n1)Ir al territorio de arriba.\n2)Ir al territorio de abajo.\n3)Ir al territorio Izquierdo.\n4)ir al territorio derecho.");
        sc=new Scanner(System.in);
        int opcionElegida=sc.nextInt();
        System.out.println("Tenemos " + (escenarioDelJugador.escenario[f][c].unidades.size()-1) + " unidades en el territorio. ¿Cuantas quieres mover?");
        switch(opcionElegida){
            case 1->{ //ir arriba
                this.subMenu(f-1, c);
            }
            case 2->{ //ir abajo
                subMenu(f+1, c);
            }
            case 3->{ //ir izquierda
                subMenu(f, c-1);
            }
            case 4->{ //ir derecha
                subMenu(f, c+1);
            }
        }
    }
    
    /**
     * Dialogo con el usuario o jugador humano.
     */
    public void dialogoConJugadorHumano(){
        menu();
    }
    

    @Override
    public Territorio irArriba() {
        //Permite extraer las coordenadas del territorio conquistado.
        String []mFC=this.territoriosConquistadosCoordenadas().split(";");//Lista de coordenadas de territorios.
        String []midFidC=mFC[this.numeroAleatorio(0, mFC.length-1)].split(":");//Extrae las coordenadas de algun territorio.
        
        int f=Integer.parseInt(midFidC[0]);
        int c=Integer.parseInt(midFidC[1]);
        int cantidad_de_unidades_a_mover=numeroAleatorio
        (1, escenarioDelJugador.escenario[f][c].unidades.size()-1);
        for(int i=0; i<=cantidad_de_unidades_a_mover;++i){
            if(escenarioDelJugador.escenario[f][c].unidades.verUnidad(i)!=null){
                escenarioDelJugador.escenario[f-1][c].unidades.add
                (escenarioDelJugador.escenario[f][c].unidades.extraerAlgunaUnidad());
            }
        }
        return escenarioDelJugador.escenario[f][c];
    }

    @Override
    public Territorio irAbajo() {
        //Permite extraer las coordenadas del territorio conquistado.
        String []mFC=this.territoriosConquistadosCoordenadas().split(";");//Lista de coordenadas de territorios.
        String []midFidC=mFC[this.numeroAleatorio(0, mFC.length-1)].split(":");//Extrae las coordenadas de algun territorio.
        
        int f=Integer.parseInt(midFidC[0]);
        int c=Integer.parseInt(midFidC[1]);
        int cantidad_de_unidades_a_mover=numeroAleatorio
        (1, escenarioDelJugador.escenario[f][c].unidades.size()-1);
        for(int i=0; i<=cantidad_de_unidades_a_mover;++i){
            if(escenarioDelJugador.escenario[f][c].unidades.verUnidad(i)!=null){
                escenarioDelJugador.escenario[f+1][c].unidades.add
                (escenarioDelJugador.escenario[f][c].unidades.extraerAlgunaUnidad());
            }
        }
        return escenarioDelJugador.escenario[f][c];
    }

    @Override
    public Territorio irIzquierda() {
        //Permite extraer las coordenadas del territorio conquistado.
        String []mFC=this.territoriosConquistadosCoordenadas().split(";");//Lista de coordenadas de territorios.
        String []midFidC=mFC[this.numeroAleatorio(0, mFC.length-1)].split(":");//Extrae las coordenadas de algun territorio.
        
        int f=Integer.parseInt(midFidC[0]);
        int c=Integer.parseInt(midFidC[1]);
        int cantidad_de_unidades_a_mover=numeroAleatorio
        (1, escenarioDelJugador.escenario[f][c].unidades.size()-1);
        for(int i=0; i<=cantidad_de_unidades_a_mover;++i){
            if(escenarioDelJugador.escenario[f][c].unidades.verUnidad(i)!=null){
                escenarioDelJugador.escenario[f][c-1].unidades.add
                (escenarioDelJugador.escenario[f][c].unidades.extraerAlgunaUnidad());
            }
        }
        return escenarioDelJugador.escenario[f][c];
    }

    @Override
    public Territorio irDerecha() {
        //Permite extraer las coordenadas del territorio conquistado.
        String []mFC=this.territoriosConquistadosCoordenadas().split(";");//Lista de coordenadas de territorios.
        String []midFidC=mFC[this.numeroAleatorio(0, mFC.length-1)].split(":");//Extrae las coordenadas de algun territorio.
        
        int f=Integer.parseInt(midFidC[0]);
        int c=Integer.parseInt(midFidC[1]);
        int cantidad_de_unidades_a_mover=numeroAleatorio
        (1, escenarioDelJugador.escenario[f][c].unidades.size()-1);
        for(int i=0; i<=cantidad_de_unidades_a_mover;++i){
            if(escenarioDelJugador.escenario[f][c].unidades.verUnidad(i)!=null){
                escenarioDelJugador.escenario[f][c+1].unidades.add
                (escenarioDelJugador.escenario[f][c].unidades.extraerAlgunaUnidad());
            }
        }
        return escenarioDelJugador.escenario[f][c];
    }
    
    
    
    
}

/**
 * Ejemplo de una clase inmutable.
 * Supuestamente mayor rendimiento del codigo.
 * Una clase final no se puede heredar.
 * En una clase final (Inmutable) las variables deben ser privadas e inicializadas mediante el constructor
 * con o sin parametros.
 * Ademas, la declaracion final se usa para indicar que es una constante y que no puede heredarse.
 * Esto en un class no final pero que si tienen metodos y funciones declarados con la palabra clave final.
 * @author Rafael
 */ 
final class ClaseInmutable{
    private final int valor;
    
    public final int getValor(){
        return valor;
    }
    
    public ClaseInmutable(int nuevo_valor){
        valor=nuevo_valor;
    }
}





