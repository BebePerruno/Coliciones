/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

/**
 *Jueves 20 de agosto del 2022.
 * Ejemplo del algoritmo de busquea binaria.
 * @author Rafael Angel MF
 * Numero de celular en Costa Rica:
 * 506 83942235
 */
public class AlgoritmoBusquedaBinaria {
    
    private int numeroTemp=0;
    
    private int aleatorio(int Min, int Max) {
        if (Min == 0) {
            Min = -1;
        }
        int resultado = (int) (Math.random() * (Max - Min + 1) + Min);
        if (numeroTemp == resultado) {
//            System.out.println("En aleatorio(), mismo resultado que el anterior:" + resultado);
            aleatorio(Min, Max);
        }
        if(Min==0 && resultado==-1){
            resultado=0;
        }
        numeroTemp = resultado;
//        System.out.println("En aleatorio(), resultado " + resultado);
        return resultado;
    }
    
    private double []matrizGlobal=new double[10];
    
    public AlgoritmoBusquedaBinaria(){
        for(int i=0; i<matrizGlobal.length; ++i){
            matrizGlobal[i]=i+1;
        }
    }
    
    @Override
    public String toString(){
        double valor=aleatorio(1,9);
        return "Ejemplo de busqueda con el valor "+valor+" en Buscar2() \nid=" + this.Buscar2(matrizGlobal, valor) +
                "\nEjemplo de busqueda con el valor 5 en Buscar() \nid=" + this.Buscar(matrizGlobal, 5);
    }
    
    /**
     * En el do se podria usar esta condicion while(matriz[mitad]!=valor && (superior>0) && (inferior<matriz.length-1)  );
     * Pero resulta que causa que el algoritmo se detenga antes de tiempo. 
     * Sin embargo es preferible usar este condicional para el do while.
     * Se podria usar esta otra condicion:
     * while(matriz[mitad]!=valor || (superior>0) && (inferior<matriz.length-1)  ); pero
     * causa que el algoritmo no se detenga nunca.
     * @param matriz Una matriz con valores dobles.
     * @param valor Un numero doble
     * @return Retorna el id donde esta el valor buscado.
     */
    private int Buscar(double []matriz, double valor){
        int mitad=0;
        int inferior=0; int superior=matriz.length-1;
        
        do{
            try{
                mitad=(inferior+superior)/2;
                System.out.println("Comparando: Valor=" + valor+" > matriz[" + mitad+ "]=" + matriz[mitad]);
                if(valor>matriz[mitad]){
                    inferior+=mitad;
                }else if(valor<matriz[mitad]){
                    superior-=mitad;
                }

                if(matriz[mitad]==valor){
                    return mitad;
                }
            }catch(Exception e){
                return -1;
            }
            
        }while(matriz[mitad]!=valor && (superior>0) && (inferior<matriz.length-1)  );
        
        return -1;
    }
    
    /**
     * Algoritmo cortesia de mi parte Rafael Angel Montero Fernpandez.
     * Esta basado en el original Buscar... pero con algunas diferencias.
     * @param matriz Una matriz con numeros.
     * @param valor Un numero.
     * @return Retorna el id de la posicion del valor en la matriz.
     */
    private int Buscar2(double []matriz, double valor){
        int mitad=(matriz.length-1)/2;
        int inferior=0; int superior=matriz.length-1;
        
        do{
            if(matriz[mitad]<valor){
                if(matriz[inferior]==valor){
                    return inferior;
                }
                inferior++;
            }
            else if(matriz[mitad]>valor){
                if(matriz[superior]==valor){
                    return superior;
                }
                superior--;
            }
            else if(matriz[mitad]==valor){
                return mitad;
            }
        }while(matriz[mitad]!=valor && (superior>0) && (inferior<matriz.length-1)  );
        
        return -1;
    }
    
    public static void main(String []m){
        AlgoritmoBusquedaBinaria b=new AlgoritmoBusquedaBinaria();
        System.out.println(b.toString());
    }
    
}
