/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

/**
 * Ejemplo del algoritmo de burbuja para ordenar.
 * Formula para calcular el numero de comparaciones: n elevado a 2 menos n dividido entre 2.
 * @author Rafael Angel MF
 */
public class Burbuja {
    private double []mDouble={2.7, 3.4, 1.5,1.2,4.2,4,3.1,2.1,1.1};
    
    /**
     * Formula standar para obtener el numero de comparaciones.
     * Existen otras formulas, para el mejor de los casos y para el peor de los casos.
     * @return Retorna la cantidad de veces que realiza comparaciones.
     */
    public double cantidadDeComparaciones(){
        int n=mDouble.length;
        return (Math.pow(n, 2)-n)/2;
    }
    
    
    public double []getMatrizDouble(){
        return mDouble;
    }
    
    public double []mOrdenarDeMenor_a_mayor(double []dame_una_matriz_de_numeros_dobles){
        double aux=0;
        double []m=dame_una_matriz_de_numeros_dobles;
        for(int idSuperior=0; idSuperior<dame_una_matriz_de_numeros_dobles.length; idSuperior++){
            for(int idInterno=0; idInterno<dame_una_matriz_de_numeros_dobles.length; idInterno++){
                if(m[idSuperior]<m[idInterno]){
                    aux=m[idInterno];
                    m[idInterno]=m[idSuperior];
                    m[idSuperior]=aux;
                }
            }
        }
        return m;
    }
    
    public double []mOrdenarDeMayor_a_menor(double []dame_una_matriz_de_numeros_dobles){
        double aux=0;
        double []m=dame_una_matriz_de_numeros_dobles;
        for(int idSuperior=0; idSuperior<dame_una_matriz_de_numeros_dobles.length; idSuperior++){
            for(int idInterno=0; idInterno<dame_una_matriz_de_numeros_dobles.length; idInterno++){
                if(m[idSuperior]>m[idInterno]){
                    aux=m[idInterno];
                    m[idInterno]=m[idSuperior];
                    m[idSuperior]=aux;
                }
            }
        }
        return m;
    }
    
    public void pintar(double []m, String msj){
        String datos="Matriz\n";
        datos=msj + "\n"+datos;
        for(int i=0; i<m.length; ++i){
            datos+="matriz["+i+"]="+m[i]+"\n";
        }
        datos+="Final de la matriz\n\n";
        System.out.println(datos);
    }
    
    public static void main(String []m){
        double []mOrdenada={};
        Burbuja b=new Burbuja();
        b.pintar(b.getMatrizDouble(),"Datos en desorden.");
        mOrdenada=b.getMatrizDouble();
        mOrdenada=b.mOrdenarDeMayor_a_menor(mOrdenada);
        b.pintar(mOrdenada,"Datos ordenados de mayor a menor.");
        mOrdenada=b.mOrdenarDeMenor_a_mayor(mOrdenada);
        b.pintar(mOrdenada,"Datos ordenados de menor a mayor.");
        
        System.out.println("Cantidad de comparaciones en el ordenamiento " + b.cantidadDeComparaciones());
    }
            
}
