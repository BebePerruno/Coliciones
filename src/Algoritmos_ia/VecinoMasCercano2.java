/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class VecinoMasCercano2 //implements ITspAlgoritmo 
{
    
    public static void main(String []m){
        new VecinoMasCercano2();
    }
    
    public VecinoMasCercano2()
    {
        ListaDeCiudades lista=new ListaDeCiudades();
        lista.add(new Ciudad(1,800,"Arina"));
        lista.add(new Ciudad(2,1000,"Arroz"));
        lista.add(new Ciudad(3,400,"Numar"));
        lista.add(new Ciudad(4,500,"Jabon"));
        lista.add(new Ciudad(5,1500,"Leche"));
        lista.add(new Ciudad(6,900,"Avena"));
        lista.add(new Ciudad(7,700,"Pasta"));
//        lista.add(new Ciudad(8,66,"USA"));
//        lista.add(new Ciudad(9,72,"Russia"));
//        lista.add(new Ciudad(10,80,"Panama"));
//        lista.add(new Ciudad(13,28,"Taiwan"));
//        lista.add(new Ciudad(14,63,"Castilla"));
//        lista.add(new Ciudad(15,86,"Estrecho de hornos"));
//        lista.add(new Ciudad(16,13,"Groenlandia"));
//        lista.add(new Ciudad(17,23,"Bielo Rusia"));
//        lista.add(new Ciudad(18,99,"Ecuador"));
        
        
        Problema problema=new Problema();
        problema.setCiudades(lista.getCiudades());
         
        Ciudad ciudad_inicial_a_visitar=new Ciudad(-1,2000,"Varato");//new Ciudad(-1,44,"Isla del tesoro");
        
        System.out.println("Ciudad inicial a visitar, aunque no este en la lista:\n" + 
                ciudad_inicial_a_visitar.toString());
        
        //problema solo se usa para calcular las distancias.
        System.out.println("Ciudad más cercana\n" + ciudadMasCercana
        (ciudad_inicial_a_visitar, problema, lista.ciudades).toString() );
        
//        System.out.println("Calculando ruta recorrida\n" + calculaRuta(14, problema).toString() );
        
        System.out.println("Calculando mejor ruta\n" + calculaMejorRuta(problema).toString() );
        
        
    }

//    @Override

    /**
     *Usa la funcion calculaRutaRecorrida.
     * @param problema Una serie de ciudades a recorrer.
     * @return Retorna la mejor ruta.
     */
    public Ruta calculaMejorRuta(final Problema problema) {
        Ruta mejorRuta = null;
        // Para cada ciudad inicial posible, calcula una ruta comenzando por
        // ella y se queda con la que menor coste dé.
        for (int i = 0; i < problema.getNumeroDeCiudades(); i++) {
            Ruta rutaActual = calculaRutaRecorrida(i, problema);
            if (mejorRuta == null || mejorRuta.getCoste() > rutaActual.getCoste())
            {
                mejorRuta = rutaActual;
            }
        }
        return mejorRuta;
    }
    
    /**
     * Calcula una ruta usando el algoritmo del "Vecino más cercano" comenznado
     * por la ciudad dada.
     * Llama a la funcion ciudadMasCercana.
     * 
     * @param ciudadInicial Índice de la ciudad por la que se comenzará
     * @param problema Conjunto de ciudades que definen el problema.
     * @return Ruta generada por el algoritmo.
     */
    private static Ruta calculaRutaRecorrida(final int id_de_la_ciudad_por_la_cual_comenzar, final Problema problema) {
        // Crea la instancia de ruta y añade la ruta inicial.
        Ruta ruta = new Ruta(problema.getNumeroDeCiudades());
        
        // Crea una lista de ciudades sin añadir a la ruta para que puedan
        // ser comparadas y obtener la más cercana.
        ArrayList<Ciudad> ciudadesLibres = problema.getCiudades();
           
        // Comenzamos por la ciudad inicial dada.
        Ciudad actual = problema.getCiudad(id_de_la_ciudad_por_la_cual_comenzar);
        
        // Para cada ciudad, se añade y se busca su más cercana
        for (int i = 0; i < problema.getNumeroDeCiudades(); i++) {
            ruta.setCiudad(actual, i);      // La inserta
            ciudadesLibres.remove(actual);  // La elimina de las libres
           
            // Busca cual es la ciudad más cercana a esta que no se haya añadido
            // todavía a la ruta actual.
            actual = ciudadMasCercana(actual, problema, ciudadesLibres);
        }
        
        return ruta;
    }
    
    /**
     * Busca la ciudad más cercana a la dada en una lista.
     * 
     * @param inicio_ciudad_a_comparar Ciudad que se usará para comparar.
     * @param lista_de_ciudades Lista de ciudad para comparar.
     * @return Ciudad más cercana.
     */
    private static Ciudad ciudadMasCercana(final Ciudad inicio_ciudad_a_comparar, 
        final Problema problema, final ArrayList<Ciudad> lista_de_ciudades) {
        double coste = 0;
        Ciudad masCercana = null;
        
        for (Ciudad ciudad : lista_de_ciudades) {
            double costeActual = problema.getDistancia(inicio_ciudad_a_comparar, ciudad);
            if (masCercana == null || costeActual < coste) {
                coste = costeActual;
                masCercana = ciudad;
            } 
        }
        return masCercana;
    }
}

abstract class Rs
{
    public void setCiudades(ArrayList<Ciudad> newCiudades){
        this.ciudades=newCiudades;
    }
    
    public ArrayList<Ciudad> getCiudades(){
        return ciudades;
    }
    
    
    public ArrayList<Ciudad> ciudades=new ArrayList();
    public abstract void add(Ciudad nueva_ciudad);
    public abstract Ciudad get(int id);
    
    public DefaultTableModel getDefaultTableModel(){
        final String []Etiquetas={"id","Nombre","Distancia"};
//        Usuario []diez=getLos10Mejores();
        String [][]Datos=new String[ciudades.size()][3];
        try{
            int tamaño=0;
            for(int i=0; i<ciudades.size(); i++){
                tamaño++;
//                System.out.println("Colocando en tabla= " + diez[i].toString());
                Datos[i][0]=ciudades.get(i).id+"";
                Datos[i][1]=ciudades.get(i).nombre+"";
                Datos[i][2]=ciudades.get(i).distancia+"";
//                System.out.println("Colocados en tabla= " + Datos[i][2]);
            }
            return new DefaultTableModel(Datos,Etiquetas);
        }catch(Exception e){
//            System.out.println("Error: " + e.getMessage());
            return new DefaultTableModel(Datos,Etiquetas);
        }
    }
}


class ListaDeCiudades extends Rs{
//    public ArrayList<Ciudad> ciudades=new ArrayList();
    
    @Override
    public void add(Ciudad nueva_ciudad){
        ciudades.add(nueva_ciudad);
    }
    
    @Override
    public Ciudad get(int id){
        return ciudades.get(id);
    }
}


class Ciudad{
    public Ciudad()
    {
        
    }
    
    public Ciudad(int newId, double newDistancia, String newNombre)
    {
        id=newId;
        distancia=newDistancia;
        nombre=newNombre;
    }
    
    public int id=0;
    public double distancia=0;
    public String nombre="";
    
    public String toString(){
        return "id=" + id+", distancia=" + distancia + ", nombre " + nombre;
    }
}

/**
 * 
 * @author Rafael
 * 
 * Son algunas ciudades del total a existente, son las que se deben recorrer.
 */
class Problema extends Rs
{
    
    public Problema()
    {
        
    }
    
    public int getNumeroDeCiudades(){
        return ciudades.size();
    }
    
    public Ciudad getCiudad(int ciudad_inicial_id){
        return ciudades.get(ciudad_inicial_id);
    }
    
    public double getDistancia(Ciudad ciudad_de_inicio, Ciudad ciudad_actual){
        double respuesta=0;
        if(ciudad_actual.distancia>ciudad_de_inicio.distancia){
            respuesta= ciudad_actual.distancia-ciudad_de_inicio.distancia;
        }else if(ciudad_actual.distancia<ciudad_de_inicio.distancia){
            respuesta= ciudad_de_inicio.distancia-ciudad_actual.distancia;
        }
        return respuesta;
    }
//    public ArrayList<Ciudad> ciudades=new ArrayList();
    
    @Override
    public void add(Ciudad nueva_ciudad){
        ciudades.add(nueva_ciudad);
    }
    
    @Override
    public Ciudad get(int id){
        return ciudades.get(id);
    }
}

class Ruta extends Rs
{
    @Override
    public String toString()
    {
        String respuesta="Ruta:\n";
        try{
            for(int i=0; i<mciudades.length; ++i){
                respuesta+=mciudades[i].toString() + "\n";
            }
        }catch(Exception e){
//            for(int i=0; i<ciudades.size(); ++i){
//                respuesta+=ciudades.get(i).toString() + "\n";
//            }
        }
        respuesta+="Costo de la ruta " + this.getCoste() + "\nY estas fueron todas las rutas.";
        return respuesta;
    }
    /**
     * Se realiza una ponderacion.
     * La suma de las distancias dividido entre la cantidad de distancias.
     * @return 
     */
    public double getCoste(){
        double costo=0;
        try{
            for(int i=0; i<this.mciudades.length; ++i){
                costo+=mciudades[i].distancia;
            }
//            return costo;//(costo/mciudades.length);
        }catch(Exception e){
//            for(int i=0; i<ciudades.size(); ++i){
//                costo+=ciudades.get(i).distancia;
//            }
//            
//            return costo;///ciudades.size();
        }
        return costo;///mciudades.length;
    }
    
    public void setCiudad(Ciudad ciudad_actual, int id){
        mciudades[id]=ciudad_actual;
    }
    
    public Ruta(int cantidad_de_ciudades){
        mciudades=new Ciudad[cantidad_de_ciudades];
    }
    public Ciudad []mciudades={};
    
    @Override
    public void add(Ciudad nueva_ciudad){
        Ciudad []ciudadesTemp=mciudades;
        mciudades=new Ciudad[ciudadesTemp.length+1];
        for(int i=0; i<ciudadesTemp.length; ++i){
            mciudades[i]=ciudadesTemp[i];
        }
        mciudades[mciudades.length-1]=nueva_ciudad;
    }
    
    @Override
    public Ciudad get(int id){
        return mciudades[id];
    }
    
    /**
     * Aqui si se implementa o se redefine porque se esta usando una matriz.
     * @return 
     */
    @Override
    public DefaultTableModel getDefaultTableModel(){
        final String []Etiquetas={"id","Nombre","Distancia"};
//        Usuario []diez=getLos10Mejores();
        String [][]Datos=new String[mciudades.length][3];
        try{
            int tamaño=0;
            for(int i=0; i<mciudades.length; i++){
                tamaño++;
//                System.out.println("Colocando en tabla= " + diez[i].toString());
                Datos[i][0]=mciudades[i].id+"";
                Datos[i][1]=mciudades[i].nombre+"";
                Datos[i][2]=mciudades[i].distancia+"";
//                System.out.println("Colocados en tabla= " + Datos[i][2]);
            }
            return new DefaultTableModel(Datos,Etiquetas);
        }catch(Exception e){
//            System.out.println("Error: " + e.getMessage());
            return new DefaultTableModel(Datos,Etiquetas);
        }
    }
    
}