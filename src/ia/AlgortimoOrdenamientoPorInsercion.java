/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

/**
 *
 * @author Rafael Angel MF
 */
public class AlgortimoOrdenamientoPorInsercion {
    private double []mDouble={2.7, 3.4, 1.5,1.2,4.2,4,3.1,2.1,1.1};
    
    private double []OrdenadosPorInsecionManor_a_Mayor(double []matriz){
        int k=0;
        double []m=matriz;
        double temp=0;
        try{
            //El recorrio empeiza por el segundo elemento, para poder abrir un espacio 
            //entre el primero y el tercero si es que existe.
            for(int i=1; i<m.length; i++){
                temp=m[i];
                k=i-1;
                while(k>=0 && temp<m[k]){
                    m[k+1]=m[k];
                    k--;
                }
                m[k+1]=temp; //Posicion temp en su lugar.
            }
        }catch(Exception e){}
        return m;
    }
    
    private double []OrdenadosPorInsecionMayor_a_menor(double []matriz){
        int k=0;
        double []m=matriz;
        double temp=0;
        try{
            //El recorrio empeiza por el segundo elemento, para poder abrir un espacio 
            //entre el primero y el tercero si es que existe.
            for(int i=1; i<m.length; i++){
                temp=m[i];
                k=i-1;
                while(k>=0 && temp>m[k]){
                    m[k+1]=m[k];
                    k--;
                }
                m[k+1]=temp; //Posicion temp en su lugar.
            }
        }catch(Exception e){}
        return m;
    }
    
    /**
     * n-1 camparaciones.
     * 2*(n-1) intercambios.
     */
    private void casoMasFaborableDeLaOrdenacion(){
        int n=mDouble.length;
        System.out.println((n-1)+" comparaciones.");
        System.out.println((2*(n-1))+" intercambios");
    }
    
    private void pintar(double []m){
        for(int i=0; i<m.length; ++i){
            System.out.println("matriz["+i+"]=" + m[i]);
        }
    }
    
    public void OrdenadosPorInsecion(){
        
        
        System.out.println("Matriz sin ordenar.");
        this.pintar(mDouble);
        System.out.println();
        double []m=OrdenadosPorInsecionManor_a_Mayor(mDouble);
        
        System.out.println("ordenacion por insercion de menor a mayor.");
        pintar(m);
        System.out.println();
        m=this.OrdenadosPorInsecionMayor_a_menor(mDouble);
        System.out.println("ordenacion por insercion de mayor a menor.");
        pintar(m);
        System.out.println();
        casoMasFaborableDeLaOrdenacion();
    }
    
    public static void main(String []m){
        AlgortimoOrdenamientoPorInsercion insercion=new AlgortimoOrdenamientoPorInsercion();
        insercion.OrdenadosPorInsecion();
    }
}
