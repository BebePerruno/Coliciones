/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 * 
 * La version 2 de este algoritmo esta más simplificado y unificado.
 */
public class AlgoritmoEvolutivo2 {
     
    public static void main(String []m){
        new AlgoritmoEvolutivo2();
    }
    
    /**
     * 1)
     * Inicializa la matriz de individuos.
     */
    public void crearPoblacion(){
        for(int i=0;i<mPoblacion.length;i++){
            mPoblacion[i].largo_de_la_cadena_genetica=10;
//            mPoblacion[i].mCadenaGenetica=new int[]{numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9),numeroAleatorio(0,9)};
//Mas facil asi.
            for(int p=0;p<mPoblacion[i].mCadenaGenetica.length;p++){
                mPoblacion[i].mCadenaGenetica[p]=numeroAleatorio(0,9);
//                System.out.println("mPoblacion[i]="+mPoblacion[i].toString());
            }
        }
    }
    
    private void calcular_fitness(){
        int fitness=0;
        for(int i=0;i<mPoblacion.length;i++){
            mPoblacion[i].fitness=calcular_fitness(mPoblacion[i]);
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
    private int calcular_fitness(Individuo individuo){
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
* Calcula el fitness, ordena la poblacion temporal, selecciona a los mejores, reproduce 50% X 50%.
* 
     * @param poblacion 
     */
    public void seleccion_y_reproduccion(){
//        this.calcular_fitness();
//        
//        //ordenando
//        mPoblacion_ordenada_temp=OrdenarPoblacion();
//        
//        //Seleccionando
//        int contador=0;
//        seleccionarIndividuos();
//        
//        mSeleccionadosSinMesclar=mIndividuosSeleccionados;
//        
//        //Mesclando los seleccionados en mIndividuosSeleccionados.
////        cruzamientoUnGenAleatorio();
//        cruzamiento50Y50();
 throw new UnsupportedOperationException("Debes usar alguno de los siguientes "
         + "cruzamiento50Y50(), cruzamientoEntrePobladores, cruzamientoUnGenAleatorio, cruzamientoEntrePobladores_y_mejores");
}
    
    public void cruzamientoUnGenAleatorio(){
        this.calcular_fitness();
        
        //ordenando
        mPoblacion_ordenada_temp=OrdenarPoblacion();
        
        //Seleccionando
        seleccionarIndividuos();
        
        mSeleccionadosSinMesclar=mIndividuosSeleccionados;
        for(int i=0;i<mPoblacion.length;i++){
            mPoblacion[i].mCadenaGenetica[numeroAleatorio(1,9)]=mIndividuosSeleccionados[numeroAleatorio(0, 6)].mCadenaGenetica[numeroAleatorio(0,9)];
    //    System.out.println(mPoblacion[i].toString());
        }
    }
    
    /**
     * Clase para guardar ambas mitades del adn.
     */
    private class Mitades{
        /**
         * Tamaño de la mitad 1 y de la mitad 2.
         * @param nueva_cantidad_de_genes1
         * @param nueva_cantidad_de_genes2 
         */
        public Mitades(int nueva_cantidad_de_genes1, int nueva_cantidad_de_genes2){
            cantidad_de_genes_de_la_mitad1=nueva_cantidad_de_genes1;
            cantidad_de_genes_de_la_mitad2=nueva_cantidad_de_genes2;
            mPrimerMitad=new int [cantidad_de_genes_de_la_mitad1];
            mSegundaMitad=new int[cantidad_de_genes_de_la_mitad2];
        }
        public int cantidad_de_genes_de_la_mitad1;
        public int cantidad_de_genes_de_la_mitad2;
         public int []mPrimerMitad=new int [cantidad_de_genes_de_la_mitad1];
         public int []mSegundaMitad=new int[cantidad_de_genes_de_la_mitad2];
    }
    
    /**
     * Pone la mitad de la cadena genetica de algun individuo y luego la otra mitad de otro individuo.
     */
    public void cruzamiento50Y50(){
        
        this.OrdenarPoblacion();
        this.seleccionarIndividuos();
        
       Mitades []mitades=new Mitades[mIndividuosSeleccionados.length];
       
       for(int i=0;i<mitades.length;i++){
           mitades[i]=new Mitades(5,5);
       }
       
       //Extrallendo las mitades.
       for(int n=0;n<mIndividuosSeleccionados.length;n++){
           int idIndividuo1=numeroAleatorio(0,this.cantidadDePoblacion);
            int idIndividuo2=numeroAleatorio(0,this.cantidadDePoblacion);
            
            //Obteniendo primera mitad.
            for(int g=0;g<=4; g++){
                mitades[n].mPrimerMitad[g]=mIndividuosSeleccionados[numeroAleatorio(0,6)].mCadenaGenetica[g];
            }

            int contador=0;
            //Segunda mitad.
            for(int g=9;g>=5; g--){
                mitades[n].mSegundaMitad[contador]=mIndividuosSeleccionados[numeroAleatorio(0,6)].mCadenaGenetica[g];
                if(contador<=4){
                    contador++;
                }else{
                    contador=4;
                }
            }
            
            //Cruzando la poblacion.
            //Se decide el orden al llamarse o sino sera cruza de gen a gen.
            int id1=0, id2=0, decision=0;
            decision=numeroAleatorio(1,2);
            for(int g=0; g<mPoblacion[n].mCadenaGenetica.length;g++){
                if(decision==1){
                if(id1<=4){
                    mPoblacion[n].mCadenaGenetica[g]=mitades[n].mPrimerMitad[id1];
                    id1++;
                }else{
                    if(id2<=4){
                        mPoblacion[n].mCadenaGenetica[g]=mitades[n].mSegundaMitad[id2];
                         id2++;
                    }
                }
                }else if(decision==2){
                    if(id2<=4){
                        mPoblacion[n].mCadenaGenetica[g]=mitades[n].mSegundaMitad[id2];
                        id2++;
                    }else{
                        if(id1<=4){
                            mPoblacion[n].mCadenaGenetica[g]=mitades[n].mPrimerMitad[id1];
                             id1++;
                        }
                    }
                }
           }
       }
    }
    
    /**
     * Se eligen 6 campos aleatorios dontro del vector de poblacion para colocar los
     * 6 mejores de la poblacion anterior.
     * Para optimizar esto, se deben crear 2 cruzamientos más.
     * 1) Cruzamiento poblador con uno de los 6 mejores.
     * 2)Cruzamiento aleatorio entre todos los individuos de la poblacion.
     */
   public void ColocarMejoresDeLaGeneracionAnterior(){
       for(int g=0; g<6;g++){
           mPoblacion[numeroAleatorio(0,mPoblacion.length)]=mSeleccionadosSinMesclar[g];
       }
   }
   
   public void cruzamientoEntrePobladores(){
       this.calcular_fitness();
        
        //ordenando
        mPoblacion_ordenada_temp=OrdenarPoblacion();
        
        seleccionarIndividuos();
        
        mSeleccionadosSinMesclar=mIndividuosSeleccionados;
        
       Mitades []mitades=new Mitades[mPoblacion.length];
       int contador=0;
       for(int p=0;p<mPoblacion.length;p++){
           mitades[p]=new Mitades(5,5);
           for(int i=0;i<=4;i++){
               mitades[p].mPrimerMitad[i]=mPoblacion[p].mCadenaGenetica[i];
           }
           for(int i=9;i>=5;i--){
               mitades[p].mSegundaMitad[contador]=mPoblacion[p].mCadenaGenetica[i];
               if(contador<4){
                   contador++;
               }else{
                   contador=4;
               }
           }
           
           //Cruzando la poblacion.
            //Se decide el orden al llamarse o sino sera cruza de gen a gen.
            int id1=0, id2=0, decision=0;
            decision=numeroAleatorio(1,2);
            for(int g=0; g<mPoblacion[p].mCadenaGenetica.length;g++){
                if(decision==1){
                if(id1<=4){
                    mPoblacion[p].mCadenaGenetica[g]=mitades[p].mPrimerMitad[id1];
                    id1++;
                }else{
                    if(id2<=4){
                        mPoblacion[p].mCadenaGenetica[g]=mitades[p].mSegundaMitad[id2];
                         id2++;
                    }
                }
                }else if(decision==2){
                    if(id2<=4){
                        mPoblacion[p].mCadenaGenetica[g]=mitades[p].mSegundaMitad[id2];
                        id2++;
                    }else{
                        if(id1<=4){
                            mPoblacion[p].mCadenaGenetica[g]=mitades[p].mPrimerMitad[id1];
                             id1++;
                        }
                    }
                }
           }
       }
   }
    
    public void cruzamientoEntrePobladores_y_mejores(){
        this.calcular_fitness();
        
        //ordenando
        mPoblacion_ordenada_temp=OrdenarPoblacion();
        
        //Seleccionando
        seleccionarIndividuos();
        
        mSeleccionadosSinMesclar=mIndividuosSeleccionados;
        
//        Modificarlo
       Mitades []mitades=new Mitades[mPoblacion.length];
       int contador=0;
       for(int p=0;p<mPoblacion.length;p++){
           mitades[p]=new Mitades(5,5);
           for(int i=0;i<=4;i++){
               mitades[p].mPrimerMitad[i]=mPoblacion[p].mCadenaGenetica[i];
           }
           for(int i=9;i>=5;i--){
               mitades[p].mSegundaMitad[contador]=mPoblacion[p].mCadenaGenetica[i];
               if(contador<4){
                   contador++;
               }else{
                   contador=4;
               }
           }
           
           //Cruzando la poblacion.
            //Se decide el orden al llamarse o sino sera cruza de gen a gen.
            int id1=0, id2=0, decision=0;
            decision=numeroAleatorio(1,2);
            for(int g=0; g<mPoblacion[p].mCadenaGenetica.length;g++){
                if(decision==1){
                if(id1<=4){
                    mPoblacion[p].mCadenaGenetica[g]=mitades[p].mPrimerMitad[id1];
                    id1++;
                }else{
                    if(id2<=4){
                        mPoblacion[p].mCadenaGenetica[g]=mitades[p].mSegundaMitad[id2];
                         id2++;
                    }
                }
                }else if(decision==2){
                    if(id2<=4){
                        mPoblacion[p].mCadenaGenetica[g]=mitades[p].mSegundaMitad[id2];
                        id2++;
                    }else{
                        if(id1<=4){
                            mPoblacion[p].mCadenaGenetica[g]=mitades[p].mPrimerMitad[id1];
                             id1++;
                        }
                    }
                }
           }
       }
   }
    
    
    public void CruzamientoPunet(){
               
   }
    /**
     * Individuos seleccionados de la poblacion.
     */
    private Individuo []mIndividuosSeleccionados;
    private Individuo []mPoblacion_ordenada_temp;
    private Individuo []mSeleccionadosSinMesclar;
    
    private void seleccionarIndividuos(){
        ;
        //Seleccionando
        int contador=0;
         mIndividuosSeleccionados=new Individuo[OrdenarPoblacion().length];
        for(int i2=0;i2<=6;i2++){
            //No se necesitan condicionales.
            mIndividuosSeleccionados[i2]=mPoblacion_ordenada_temp[i2];
//            contador++;
        }
    }
    
private Individuo []OrdenarPoblacion(){
     //ordenando 
        Individuo individuo_elegible=null;
        mPoblacion_ordenada_temp=mPoblacion;
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
        return mPoblacion_ordenada_temp;
}
    
    /**
     * 2.9 y 4)
     * @param poblacion 
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
    
    /**
     * Se elige mejor individuo por orden ascendente.
     * Algoritmo de burbuja.
     * @return 
     */
    public Individuo elegir_mejor_individuo(){
        Individuo []mPoblacion_ordenada_temp=mPoblacion;
        //Seleccionando
        Individuo individuo_elegible=null;
        for(int i=0;i<mPoblacion.length;i++){
            individuo_elegible=mPoblacion[i];
            for(int p=0;p<mPoblacion_ordenada_temp.length;p++){
                if(mPoblacion_ordenada_temp[i].fitness>mPoblacion_ordenada_temp[p].fitness){
                    individuo_elegible=mPoblacion_ordenada_temp[i];
                    mPoblacion_ordenada_temp[i]=mPoblacion_ordenada_temp[p];
                    mPoblacion_ordenada_temp[p]=individuo_elegible;
                }
            }
        }
        //Mejor individuo
        return mPoblacion_ordenada_temp[0];
    }
    
    /**
     * Se introduces nuevos genes.
     * Se eligen individuos aleatoriamente.
     */
    public void mutacion(){
        for (Individuo mPoblacion1 : mPoblacion) {
            int mut=numeroAleatorio(0,4);
            mPoblacion[mut].mCadenaGenetica[numeroAleatorio(0,Individuo.largo_de_la_cadena_genetica-1)]=numeroAleatorio(0,9);
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
    
    public static int cantidadDePoblacion=100;
    public Individuo []mPoblacion;
    
    /**
     * Objetivo a alcanzar por el algoritmo.
     */
    public  Individuo Objetivo=new Individuo(10,new int[]{3,2,4,2,4,4,4,5,1,7});
    
    public AlgoritmoEvolutivo2(){
//        
//        Objetivo.largo_de_la_cadena_genetica=10;
//        Objetivo.fitness=100;
//        Objetivo.mCadenaGenetica=new int []{3,2,4,2,4,4,4,5,1,7};
        Individuo.largo_de_la_cadena_genetica=10;
        mPoblacion=new Individuo[cantidadDePoblacion];
        System.out.println("Tamaño de la poblacion "+mPoblacion.length);
        for(int i=0;i<mPoblacion.length;i++){
            mPoblacion[i]=new Individuo(Individuo.largo_de_la_cadena_genetica);
        }
        this.crearPoblacion();
        for(int i=0;i<=500;i++){
            
        this.calcular_fitness();
//        this.seleccion_y_reproduccion(); //Era el que se encargaba de la seleccion y reproduccion se conserva por hechos historicos.
//this.cruzamientoUnGenAleatorio();//Tiene un 60% de exito con mutacion entre un 20% y un 40% de exito.
        this.cruzamiento50Y50();//Solo un 40% con mutacion un 60% de exito.
//this.cruzamientoEntrePobladores();//10% con mutacion un 20% de exito.
        this.mutacion();
        this.calcular_fitness();
//        elegir_mejor_individuo();
        System.out.println("Mejor individuo de la ronda " + i + 
                "\n" + this.elegir_mejor_individuo().toString());
        }
        
        
    }
    
    
    public class Individuo{
        
        
        public Individuo(int nuevo_largo_de_la_cadena_genetica){
            mCadenaGenetica=new int[nuevo_largo_de_la_cadena_genetica];
            largo_de_la_cadena_genetica=nuevo_largo_de_la_cadena_genetica;
        }
        
        /**
         * Solo para el individuo static, individuo perfecto.
         * @param nuevo_largo_de_la_cadena_genetica
         * @param mCadenaGeneticaDeseada 
         */
        public Individuo(int nuevo_largo_de_la_cadena_genetica,int []mCadenaGeneticaDeseada){
            mCadenaGenetica=new int[nuevo_largo_de_la_cadena_genetica];
            largo_de_la_cadena_genetica=nuevo_largo_de_la_cadena_genetica;
            this.mCadenaGenetica=mCadenaGeneticaDeseada;
        }
        
        
        public Individuo(){
            mCadenaGenetica=new int[largo_de_la_cadena_genetica];
        }
        
        public static int largo_de_la_cadena_genetica=0;
        /**
         * De cero a diez.
         * Objetivo a lograr :{3,2,4,2,4,0,4,4,5}
         */
        public int []mCadenaGenetica;
        
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
