/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

/**
 *No ordena bien.
 * @author Rafael Angel MF
 */
public class AlgoritmoQuickSort {
    private double []mDouble={5.4,2.7, 3.4, 1.5,1.2,4.2,4,3.1,2.1,1.1};
    
    public class Pila{
        public int inferior=0;
        public int superior=0;
    }
    
    private Pila []mPila={};
    
    private double []quickSort(double []matriz ){
        int valor_inferior=0; int valor_superior=matriz.length-1;
        double []m=matriz;
        mPila=new Pila[matriz.length];
        for(int i=0; i<mPila.length; ++i){
            mPila[i]=new Pila();
        }
        
        int  idPila=1;
        double mitad=0;
        double temp=0;
        int iz=0, dr=0;
        mPila[idPila].inferior=valor_inferior;
        mPila[idPila].superior=valor_superior;
        
        try{
           for(int idsu=0; idsu<m.length; idsu++){
               System.out.println("do 1");
               valor_inferior=mPila[idPila].inferior;
               valor_superior=mPila[idPila].superior;
               idPila--;
               for(int id=0; id<m.length; id++){
                   System.out.println("do 2");
                 iz=valor_inferior; dr=valor_superior;  
                 mitad=m[(iz+dr)/2];
                 for(int i=0; i<m.length; i++){
                     System.out.println("do 3");
                     if(m[iz]<mitad && iz<valor_superior){
                         iz++;
                     }
                     if(m[dr]>mitad && dr>valor_inferior){
                         dr--;
                     }
                 }
                 if(iz<valor_superior){
                     idPila++;
                     mPila[idPila].inferior=iz;
                     mPila[idPila].superior=valor_superior;
                 }
                 valor_superior=dr;
               } //end for
           } //end for
        }catch(Exception e){}
        return m;
    }
    
    public void pintar(double []m){
        for (int i=0; i<m.length; ++i){
            System.out.println("Matriz["+i+"]="+m[i]);
        }
    }
    
    public void ordenar(){
        this.pintar(this.quickSort(mDouble));
    }
    
    public static void main(String []m){
        AlgoritmoQuickSort quickSort=new AlgoritmoQuickSort();
        quickSort.ordenar();
    }
}
