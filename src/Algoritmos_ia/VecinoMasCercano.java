/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia;

/**
 *
 * @author Rafael
 * Recordar que la seleccion del punto de partida puede ser aleatorio.
 * Y puede ser cualquier id de la matriz.
 * El algoritmo KNN solo puede seleccionar uno entre cada columna.
 */
public class VecinoMasCercano {
    
    public static void main(String []args){
        VecinoMasCercano knn=new VecinoMasCercano();
//        
        VecinoMasCercano.Clasificador c=knn.getCercanias()[2][2];
        System.out.println(c.vecinoAbajo.Fila + "\n" +c.vecinoArriba.Fila + "\n"+c.vecinoDr.Fila+"\n"+c.vecinoIz.Fila);
//        double h=Math.sqrt(( + ((51000 - 12)/(150000-38000))^2 );

    }
    
    public Clasificador [][]getCercanias(){
        load();
//        getPuntoDePartida(); //Debe implementarse.
        identificarVecinosCercanos();
        for (int c=0; c<matrizClasificador.length; c++){
            for (int f=0; f<matrizClasificador[0].length; f++){
                System.err.println("Implementar con el metodo de la burbuja, linea 29");
//                System.out.println(matrizClasificador[f][c].toString());
            }
        }
        return matrizClasificador;
    }
    
    private int tamaño=5;
    
    private Clasificador []mClasificasiones=new Clasificador[tamaño*tamaño];
    
    private Clasificador [][]matrizClasificador=new Clasificador[tamaño][tamaño];
    
    private void identificarVecinosCercanos(){
        //Vecinos arriba
        this.getMatrizOrdenadaPorFilas();
        for (int c=0; c<matrizClasificador.length; c++){
            for (int f=0; f<matrizClasificador[0].length; f++){
                try{
                    if(matrizClasificador[f-1][c]!=null){
                        matrizClasificador[f][c].vecinoArriba.Fila=f;
                        matrizClasificador[f][c].vecinoArriba.Columna=c;
                    }
                }catch(Exception e){
                    
                }
            }
        }
        //Vecino abajo
        for (int c=0; c<matrizClasificador.length; c++){
            for (int f=0; f<matrizClasificador[0].length; f++){
                try{
                    if(matrizClasificador[f+1][c]!=null){
                        matrizClasificador[f][c].vecinoAbajo.Fila=f;
                        matrizClasificador[f][c].vecinoAbajo.Columna=c;
                    }
                }catch(Exception e){
                    
                }
            }
        }
        
        this.getMatrizOrdenadaPorColumnas();
        //Vecino iz
        for (int f=0; f<matrizClasificador.length; f++){
            for (int c=0; f<matrizClasificador[0].length; c++){
                try{
                    if(matrizClasificador[f][c-1]!=null){
                        matrizClasificador[f][c].vecinoIz.Fila=f;
                        matrizClasificador[f][c].vecinoIz.Columna=c;
                    }
                }catch(Exception e){
                    
                }
            }
        }
        
        //Vecino dr
        for (int f=0; f<matrizClasificador.length; f++){
            for (int c=0; f<matrizClasificador[0].length; c++){
                try{
                    if(matrizClasificador[f][c+1]!=null){
                        matrizClasificador[f][c].vecinoDr.Fila=f;
                        matrizClasificador[f][c].vecinoDr.Columna=c;
                    }
                }catch(Exception e){
                    
                }
            }
        }
    }
    
    /**
     * Usa el algoritmo de burbuja para ordenar la matriz.
     * @return 
     */
    private Clasificador [][]getMatrizOrdenadaPorFilas(){
        Clasificador temp=null;
        for (int c=0; c<matrizVecinos.length; c++){
            for (int f=0; f<matrizClasificador[0].length; f++){
                for (int f1=0; f1<matrizClasificador[0].length; f1++){
                    if(matrizClasificador[f][c].getDistancia()<matrizClasificador[f1][c].getDistancia()){
                        temp=matrizClasificador[f][c];
                        matrizClasificador[f][c]=matrizClasificador[f1][c];
                        matrizClasificador[f1][c]=temp;
//                        System.out.println("mClasificasiones[id]= "+ matrizClasificador[f1][c] );
                    }
                }
            }
        }
        return matrizClasificador;
    }
    
    private Clasificador [][]getMatrizOrdenadaPorColumnas(){
        Clasificador temp=null;
        for (int f=0; f<matrizVecinos.length; f++){
            for (int c=0; c<matrizVecinos[0].length; c++){
                for (int c1=0; c1<matrizVecinos[0].length; c1++){
                    if(matrizClasificador[f][c].getDistancia()<matrizClasificador[f][c1].getDistancia()){
                        temp=matrizClasificador[f][c];
                        matrizClasificador[f][c]=matrizClasificador[f][c1];
                        matrizClasificador[f][c1]=temp;
//                        System.out.println("mClasificasiones[id]= "+ matrizClasificador[f][c1] );
                    }
                }
            }
        }
        return matrizClasificador;
    }
    
    private int getPuntoDePartida(){
        int punto_de_partida=aleatorio(0,tamaño);
        return punto_de_partida;
    }
    
    
    /**
     * Tercer metodo en ser llamado.
     */
    private Clasificador []getRutasOrdenadas(){
        Clasificador temp=null;
        System.out.println("Ordenando vecinos por cercania.");
        for(int i=0; i<mClasificasiones.length; i++){
            for(int id=0; id<mClasificasiones.length; id++){
                if(mClasificasiones[i].getDistancia()<mClasificasiones[id].getDistancia()){
                    temp=mClasificasiones[i];
                    mClasificasiones[i]=mClasificasiones[id];
                    mClasificasiones[id]=temp;
//            System.out.println("mClasificasiones[id]= "+ mClasificasiones[id] );
                }
            }
        }
        return mClasificasiones;
    }
    
    /**
     * Segundo en ser llamado para clasificar las distancias.
     */
    private void clasificar(){
        int contador_del_vector=0;
        for(int f=0; f<matrizVecinos.length; ++f){
            for(int c=0; c<matrizVecinos.length; ++c){
                mClasificasiones[contador_del_vector].setIdFila(f);
                mClasificasiones[contador_del_vector].setIdColumna(c);
                mClasificasiones[contador_del_vector].setDistancia(matrizVecinos[f][c]);
                contador_del_vector++;
            }
        }
    }
    
    
    
    private int [][]matrizVecinos=new int[tamaño][tamaño];
    
    /**
     * Primero en ser llamado para cargar los datos.
     */
    private void load(){
        int cont=0;
        for (int f=0; f<matrizVecinos.length; f++){
            for (int c=0; c<matrizVecinos[0].length; c++){
                matrizVecinos[f][c]=aleatorio(1, 100);
                matrizClasificador[f][c]=new Clasificador();
                
                matrizClasificador[f][c]=new Clasificador();
                matrizClasificador[f][c].setIdColumna(c);
                matrizClasificador[f][c].setIdFila(numeroTemp);
                matrizClasificador[f][c].setDistancia(matrizVecinos[f][c]);
                
                
                mClasificasiones[cont]=new Clasificador();
                mClasificasiones[cont].setIdColumna(c);
                mClasificasiones[cont].setIdFila(numeroTemp);
                mClasificasiones[cont].setDistancia(matrizVecinos[f][c]);
                cont++;
            }
        }
    }
    
    /**
     * Permite guardar la distancia y el id en la matriz.
     * La forma más practica es una combinacion entre nodos y matrices.
     */
    public class Clasificador{
        
        public class Indices{
            public int Fila=0;
            public int Columna=0;
        }
        
        @Override
        public String toString(){
            try{
                return "id columna " + this.idColumna + ", id fila " + this.idFila + ", distancia " + this.distancia;
//                     + ", id vecino " + this.vecinoArriba.toString() + 
//                    ", vecino abajo " + this.vecinoAbajo.toString() + ", vecino iz "+
//                    this.vecinoIz.toString() + ", vecino dr "+ this.vecinoDr.toString();
            }catch (Exception e){
                
            }
            return "id columna " + this.idColumna + ", id fila " + this.idFila + ", distancia " + this.distancia;
        }
        
        public Indices vecinoDr=null;
        public Indices vecinoIz=null;
        public Indices vecinoAbajo=null;
        public Indices vecinoArriba=null;
        
        private int idFila=0;
        public void setIdFila(int nuevoIdFila){
            idFila=nuevoIdFila;
        }
        public int getIdFila(){
            return idFila;
        }
        
        private int idColumna=0;
        public void setIdColumna(int nuevoIdColumna){
            idColumna=nuevoIdColumna;
        }
        public int getIdColumna(){
            return idColumna;
        }
        
        private int distancia=0;
        
        public void setDistancia(int nueva_distancia){
            distancia=nueva_distancia;
        }
        public int getDistancia(){
            return distancia;
        }
        
        private double distanciaDbl=0;
        
        public void setDistanciaDbl(double nueva_distancia){
            distanciaDbl=nueva_distancia;
        }
        public double getDistanciaDbl(){
            return distanciaDbl;
        }
    }
    
    private int numeroTemp=0;
    
    private int aleatorio(int Min, int Max) {
        if (Min == 0) {
            Min = -1;
        }
        int resultado = (int) (Math.random() * (Max - Min + 1) + Min);
        if (numeroTemp == resultado) {
            System.out.println("Mismo resultado que el anterior:" + resultado);
            aleatorio(Min, Max);
        }
        if(Min==0 && resultado==-1){
            resultado=0;
        }
        numeroTemp = resultado;
        return resultado;
    }
    
}
