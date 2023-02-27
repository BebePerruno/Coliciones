/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

/**
 *
 * @author Rafael
 * Sabado 19 de febrero del 2022.
 * 
 * El algoritmo genetico imita la vida evolutiva.
 * Se encuentra una solucion mediante la evolucion.
 * La solucion encontrada se guarda en una base de datos, archivo de texto, en disco duro.
 * Para la reproduccion deben seleccionarse mas de 2 individuos.
 * 
 */
public class AlgoritmoEvolutivo {
    
    public static void main(String []m){
        new AlgoritmoEvolutivo();
    }
    
    /**
     * 1)
     * Inicializa la matriz de individuos.
     */
    public void crearPoblacion(){
        for(int i=0;i<mPoblacion.length;i++){
            mPoblacion[i].largo_de_la_cadena_genetica=4;
//            mPoblacion[i].mCadenaGenetica=new int[]{numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9)};
//Mas facil asi.
            for(int p=0;p<mPoblacion[i].mCadenaGenetica.length;p++){
                mPoblacion[i].mCadenaGenetica[p]=numeroAleatorio(2,4);
//                System.out.println("mPoblacion[i]="+mPoblacion[i].toString());
            }
        }
    }
    
    public void calcular_fitness_de_la_poblacion(){
        int fitness=0;
        for(int i=0;i<mPoblacion.length;i++){
            mPoblacion[i].fitness=calcular_fitness(mPoblacion[i]);
        }
    }
    
    public void calcular_fitness_de_la_poblacion(Individuo []poblacion){
        int fitness=0;
        for(int i=0;i<poblacion.length;i++){
            poblacion[i].fitness=calcular_fitness(poblacion[i]);
        }
    }
    
    /**
     * 2)
     * El fitness del individuo nos e calcula ya que podria tener un fitness alto y la solucion no ser igual al modelo.
     *  || individuo.fitness==Objetivo.fitness
     * Pero igual deberia tomarse en cuenta ya que el algoritmo lo habria evolucionado de tal manera que el resultado de la 
     * solucion aunque diferente es el mismo.

* @param individuo
     * @return 
     */
    public int calcular_fitness(Individuo individuo){
        int fitness=0;
            for(int p=0;p<individuo.mCadenaGenetica.length;p++){
                if(individuo.mCadenaGenetica[p]==Objetivo.mCadenaGenetica[p]){
                    fitness++;
                }
            }
        return fitness;
    }
    
    /**
     * 3)
     * Le da la puntuacion a cada individuo de la poblacion, luego los va evaluando, se queda con los mejores individuos
     * guardadandolos en un nuevo vector.
     * 
     * Antes de mesclarlos se guarda en un tercer vector una copia de los individuos seleccionados sin modificar.
     * 
     * Despuez mezcla el material genetico de los individuos seleccionados que estan guardados en el segundo vector 
     * para crear una nueva poblacion.
     * 
     * Finalmente le realiza una mutacion a la nueva poblacion.
     * 
     * Método de ruleta: la probabilidad de que un individuo sea seleccionado es proporcional a su fitness relativo, es decir, a su fitness dividido por la suma del fitness de todos los individuos de la población. Si el fitness de un individuo es el doble que el de otro, también lo será la probabilidad de que sea seleccionado. Este método presenta problemas si el fitness de unos pocos individuos es muy superior (varios órdenes de magnitud) al resto, ya que estos serán seleccionados de forma repetida y casi todos los individuos de la siguiente generación serán "hijos" de los mismos "padres" (poca variación).


Método rank: la probabilidad de selección de un individuo es inversamente proporcional a la posición que ocupa tras ordenar todos los individuos de mayor a menor fitness. Este método es menos agresivo que el método ruleta cuando la diferencia entre los mayores fitness es varios órdenes de magnitud superior al resto.


Selección competitiva (tournament): se seleccionan aleatoriamente dos parejas de individuos de la población (todos con la misma probabilidad). De cada pareja se selecciona el que tenga mayor fitness. Finalmente, se comparan los dos finalistas y se selecciona el de mayor fitness. Este método tiende a generar una distribución de la probabilidad de selección más equilibrada que las dos anteriores.


Selección truncada (truncated selection): se realizan selecciones aleatorias de individuos, habiendo descartado primero los n individuos con menor fitness de la población.
* 
* 
     * @param poblacion 
     */
    public void seleccion_y_reproduccion(Individuo []poblacion){
        this.calcular_fitness_de_la_poblacion(poblacion);
        
        
        //ordenando 
        Individuo individuo_elegible=null;
        Individuo []mPoblacion_ordenada_temp=poblacion;
        for(int i=0;i<mPoblacion.length;i++){
            individuo_elegible=mPoblacion[i];
            for(int p=0;p<mPoblacion_ordenada_temp.length;p++){
                //Condicion original (mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness)
                if(mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness){
                    individuo_elegible=mPoblacion_ordenada_temp[i];
                    mPoblacion_ordenada_temp[i]=mPoblacion_ordenada_temp[p];
                    mPoblacion_ordenada_temp[p]=individuo_elegible;
                }
            }
        }
        //Seleccionando
        int contador=0;
        Individuo []mIndividuosSeleccionados=new Individuo[mPoblacion_ordenada_temp.length];
        for(int i2=mPoblacion_ordenada_temp.length-1;i2>=mPoblacion_ordenada_temp.length-2;i2--){
            //No se necesitan condicionales.
            mIndividuosSeleccionados[contador]=mPoblacion_ordenada_temp[i2];
            contador++;
        }
        
        Individuo []mSeleccionadosSinMesclar=mIndividuosSeleccionados;
        
        //Mesclando los seleccionados en mIndividuosSeleccionados.
        for(int i2=mIndividuosSeleccionados.length-1;i2>=mPoblacion_ordenada_temp.length-6;i2--){
            //No se necesitan condicionales.
            mIndividuosSeleccionados[contador]=mPoblacion_ordenada_temp[i2];
            contador++;
        }
        //Usar aleatorios para mesclar geneticamente.
        //6 rondas para realizar una buena mescla. 
        //6 genes intercambiados.
//        for (int rondas=0; rondas<=6;rondas++){
//            for(int i2=0;i2<=poblacion.length;i2++){
                //No se necesitan condicionales.
//                //Cruzamiento entre los seleccionados.
//            mIndividuosSeleccionados[numeroAleatorio(mIndividuosSeleccionados.length-6, mIndividuosSeleccionados.length-1)].mCadenaGenetica[numeroAleatorio(mIndividuosSeleccionados.length-6, mIndividuosSeleccionados.length-1)]=mIndividuosSeleccionados[numeroAleatorio(1, 9)].mCadenaGenetica[numeroAleatorio(1, 9)];
            
            
//            }
//        }
    for(int i=0;i<poblacion.length;i++){
        poblacion[i].mCadenaGenetica[numeroAleatorio(1,9)]=mIndividuosSeleccionados[numeroAleatorio(mIndividuosSeleccionados.length-6, mIndividuosSeleccionados.length-1)].mCadenaGenetica[numeroAleatorio(1,9)];
//    System.out.println(poblacion[i].toString());
    }

}
    
    public void seleccion_y_reproduccion(){
        this.calcular_fitness_de_la_poblacion(mPoblacion);
        
        
        //ordenando 
        Individuo individuo_elegible=null;
        Individuo []mPoblacion_ordenada_temp=mPoblacion;
        for(int i=0;i<mPoblacion.length;i++){
            individuo_elegible=mPoblacion[i];
            for(int p=0;p<mPoblacion_ordenada_temp.length;p++){
                //Condicion original (mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness)
                if(mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness){
                    individuo_elegible=mPoblacion_ordenada_temp[i];
                    mPoblacion_ordenada_temp[i]=mPoblacion_ordenada_temp[p];
                    mPoblacion_ordenada_temp[p]=individuo_elegible;
                }
            }
        }
        //Seleccionando
        int contador=0;
        Individuo []mIndividuosSeleccionados=new Individuo[mPoblacion_ordenada_temp.length];
        for(int i2=mPoblacion_ordenada_temp.length-1;i2>=mPoblacion_ordenada_temp.length-6;i2--){
            //No se necesitan condicionales.
            mIndividuosSeleccionados[contador]=mPoblacion_ordenada_temp[i2];
            contador++;
        }
        
        Individuo []mSeleccionadosSinMesclar=mIndividuosSeleccionados;
        
        //Mesclando los seleccionados en mIndividuosSeleccionados.
        for(int i2=mIndividuosSeleccionados.length-1;i2>=mPoblacion_ordenada_temp.length-6;i2--){
            //No se necesitan condicionales.
            mIndividuosSeleccionados[contador]=mPoblacion_ordenada_temp[i2];
            contador++;
        }
        //Usar aleatorios para mesclar geneticamente.
        //6 rondas para realizar una buena mescla. 
        //6 genes intercambiados.
//        for (int rondas=0; rondas<=6;rondas++){
//            for(int i2=0;i2<=poblacion.length;i2++){
                //No se necesitan condicionales.
//                //Cruzamiento entre los seleccionados.
//            mIndividuosSeleccionados[numeroAleatorio(mIndividuosSeleccionados.length-6, mIndividuosSeleccionados.length-1)].mCadenaGenetica[numeroAleatorio(mIndividuosSeleccionados.length-6, mIndividuosSeleccionados.length-1)]=mIndividuosSeleccionados[numeroAleatorio(1, 9)].mCadenaGenetica[numeroAleatorio(1, 9)];
//            }
//        }
    for(int i=0;i<mPoblacion.length;i++){
        mPoblacion[i].mCadenaGenetica[numeroAleatorio(1,9)]=mIndividuosSeleccionados[numeroAleatorio(mIndividuosSeleccionados.length-6, mIndividuosSeleccionados.length-1)].mCadenaGenetica[numeroAleatorio(0,9)];
//    System.out.println(mPoblacion[i].toString());
    }
}
    
    /**
     * 2.9 y 4)
     * @param poblacion 
     * @return  
     */
    public Individuo elegir_mejor_individuo(Individuo []poblacion){
        Individuo []mPoblacion_ordenada_temp=poblacion;
        //Seleccionando
        Individuo individuo_elegible=null;
        for(int i=0;i<poblacion.length;i++){
            individuo_elegible=poblacion[i];
            for(int p=0;p<mPoblacion_ordenada_temp.length;p++){
                //Condicion original (mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness)
                if(mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness){
                    individuo_elegible=mPoblacion_ordenada_temp[i];
                    mPoblacion_ordenada_temp[i]=mPoblacion_ordenada_temp[p];
                    mPoblacion_ordenada_temp[p]=individuo_elegible;
                }
            }
        }
        //Mejor individuo
        return individuo_elegible;
    }
    
    public Individuo elegir_mejor_individuo(){
        Individuo []mPoblacion_ordenada_temp=mPoblacion;
        //Seleccionando
        Individuo individuo_elegible=null;
        for(int i=0;i<mPoblacion.length;i++){
            individuo_elegible=mPoblacion[i];
            for(int p=0;p<mPoblacion_ordenada_temp.length;p++){
                //Condicion original (mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness)
                if(mPoblacion_ordenada_temp[i].fitness>=mPoblacion_ordenada_temp[p].fitness)
                {
                    individuo_elegible=mPoblacion_ordenada_temp[i];
                    mPoblacion_ordenada_temp[i]=mPoblacion_ordenada_temp[p];
                    mPoblacion_ordenada_temp[p]=individuo_elegible;
                }
            }
        }
        //Mejor individuo
        return individuo_elegible;
    }
    
    public void mutacion(Individuo []poblacion){
        for(int i=0;i<poblacion.length;i++){
            for(int g=0;g<poblacion[i].mCadenaGenetica.length;g++){
                poblacion[i].mCadenaGenetica[g]=numeroAleatorio(0,9);
            }
        }
    }
    
    /**
     * Se introduces nuevos genes.
     * Se eligen individuos aleatoriamente.
     */
    public void mutacion(){
        for (Individuo mPoblacion1 : mPoblacion) {
            //            for(int g=0;g<mPoblacion[i].mCadenaGenetica.length;g++){
            int mut=numeroAleatorio(0,4);
            mPoblacion[mut].mCadenaGenetica[numeroAleatorio(0,3)]=numeroAleatorio(1,6);
////            System.out.println("Mutacion " + mut);
//try{
//System.out.println( mPoblacion[mut].mCadenaGenetica[numeroAleatorio(0,4)]);//=numeroAleatorio(0,9);
//            }
//        }catch(Exception ex){}
        }
    }
    
    
    
    /**
     * El default se usa en las interfaces, nuevo truco.
     * @param Min
     * @param Max
     * @return 
     */
    public int numeroAleatorio(int Min, int Max){
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
    
    private int poblacion=20;
    public Individuo []mPoblacion;
    
    /**
     * Objetivo a alcanzar por el algoritmo.
     */
    public Individuo Objetivo=new Individuo();
    
    public AlgoritmoEvolutivo(){
        Objetivo.largo_de_la_cadena_genetica=4;
        Objetivo.fitness=100;
        Objetivo.mCadenaGenetica=new int []{3,2,4,2};
        
        
        mPoblacion=new Individuo[poblacion];
        for(int i=0;i<mPoblacion.length;i++){
            mPoblacion[i]=new Individuo(4);
        }
        
        for(int i=0;i<=500;i++){
            this.crearPoblacion();
        this.calcular_fitness_de_la_poblacion();
        this.mutacion();
        this.calcular_fitness_de_la_poblacion();
        System.out.println();
        System.out.println("Genoma objetivo: " + Objetivo.getCadenaGenetica()+"\nMejor individuo de la ronda " + i + 
                "\n" + this.elegir_mejor_individuo().toString());
        }
        
        
    }
    
    
    public class Individuo{
        
        
        public Individuo(int nuevo_largo_de_la_cadena_genetica){
            mCadenaGenetica=new int[nuevo_largo_de_la_cadena_genetica];
            largo_de_la_cadena_genetica=nuevo_largo_de_la_cadena_genetica;
        }
        
        
        public Individuo(){
            mCadenaGenetica=new int[largo_de_la_cadena_genetica];
        }
        
        public int largo_de_la_cadena_genetica=0;
        /**
         * De cero a diez.
         * Objetivo a lograr :{3,2,4,2,4,0,4,4,5}
         */
        public int []mCadenaGenetica;
        
        public String getCadenaGenetica(){
            String genes="";
            for(int i:mCadenaGenetica){
                genes+=""+i;
            }
            return genes;
        }
        
        public boolean es_progenitor;
        public boolean es_descendiente;
        public boolean elegido_para_mutacion;
        
        /**
         * 0.2 es el valor estandar pero se puede variar de individuo en individuo en tiempo de diseño o ejecucion.
         */
        public double probabilidad_de_mutacion=0.2;
        
        public int fitness;
        
        @Override
        public String toString(){
            String cadena="";
            for(int c=0;c<mCadenaGenetica.length;c++){
                cadena+=" "+mCadenaGenetica[c];
            }
            return "largo_de_la_cadena_genetica=" + largo_de_la_cadena_genetica + "\nes_progenitor="+es_progenitor+
                    "\nes_descendiente="+es_descendiente+"\nelegido_para_mutacion="+elegido_para_mutacion + 
                    "\nprobabilidad_de_mutacion="+probabilidad_de_mutacion+"\nfitness="+fitness + "\nGenes= " + cadena + "\n\n\n";
        }
    }
}
