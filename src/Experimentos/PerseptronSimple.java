/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 * El perseptron simple es una neurona basica, a partir del perseptron simple se crean 
 * las demas neuronas hasta llegar a redes neuronales.
 * 
 * En el perceptron basico los pesos se ajustan manualmente de acuerdo a la prioridad de los componentes a agregar.
 * Tambien es un buen ejercicio para programar en binario.
 */
public class PerseptronSimple {
    
    public PerseptronSimple(){
        
    }
    
    public PerseptronSimple(int nuevo_umbral){
        umbral_de_activacion=nuevo_umbral;
    }
    
    /**
     * Las entradas de la neurona.
     */
    private ArrayList<EntradasPesos> entradas_y_pesos=new ArrayList<EntradasPesos>();
    
    /**
     * El umbral de activacion es lo mismo que bias.
     */
    private int umbral_de_activacion=0;
    
    /**
     * El umbral de activacion.
     * El umbral de activacion No es lo mismo que la salida deseada.
     * @param nuevo_umbral 
     */
    public void setUmbral(int nuevo_umbral){
        umbral_de_activacion=nuevo_umbral;
    }
    /**
     * El umbral de activacion.
     * El umbral de activacion equivale a la salida deseada.
     * @return 
     */
    public int getUmbral(){
        return umbral_de_activacion;
    }
    
    /**
     * No se necesita aqui ya que las entradas y los pesos se repiten.
     * @param nuevoEntradasPesos
     * @return 
     */
    private boolean existe(EntradasPesos nuevoEntradasPesos){
        return false;
    }
    
    public void addEntradasConPesos(EntradasPesos nuevas_entradas_conpesos){
        entradas_y_pesos.add(nuevas_entradas_conpesos);
    }
    
    public EntradasPesos getEntradasPesos(int id){
        return entradas_y_pesos.get(id);
    }
    
    /**
     * La activacion es la operacion entra las entradas y los pesos.
     *La sumatoria de  X*W (Entradas * Pesos)
     * Se le suma el umbral de activacion para que la respuesta de mayor al umbral_de_activacion.
     * @return 
     */
    private int activacion(){
        int respuesta=0;
        for(int i=0;i<this.entradas_y_pesos.size(); i++){
            respuesta+=entradas_y_pesos.get(i).EntradaPorPeso();
        }
        
        //No
//        if(umbral_de_activacion==0){
//            int porcentaje=respuesta/2;
////            umbral_de_activacion=Integer.parseInt("" + respuesta/porcentaje);
//            System.out.println("umbral_de_activacion=" + umbral_de_activacion);
//        }
        return respuesta;//+umbral_de_activacion;
    }
    
    public int salida(){
        if(activacion()<=this.umbral_de_activacion){
            //No es la respuesta deseada.
            System.out.println("Activacion obtenida " + activacion());
            return 0;
        }
        //Si es la respuesta deseada.
        System.out.println("Activacion obtenida " + activacion());
        return 1;
    }
    
    private int salidaDeseada=0;
    
    /**
     * Esta propiedad permite colocar cerca el valor deseado de la neurona.
     * Ponerle datos a esta propiedad es opcional para el perseptron simple.
     * La salida deseada para este tipo de neurona puede ser cero o uno.
     * @param nueva_salida_deseada 
     */
    public void setSalidaDeseada(int nueva_salida_deseada){
         salidaDeseada=nueva_salida_deseada;
    }
    /**
     * Esta propiedad permite colocar cerca el valor deseado de la neurona.
     * Ponerle datos a esta propiedad es opcional para el perseptron simple.
     * El umbral de activacion equivale a la salida deseada.
     * @return 
     */
    public int getSalidaDeseada(){
        return salidaDeseada;
    }
    
}

/**
 * 
 * @author Rafael
 * Las entradas y pesos de la neurona.
 */
class EntradasPesos{
    
    public EntradasPesos(int nueva_entrada, int nuevo_peso){
        entrada=nueva_entrada;
        peso=nuevo_peso;
    }
    
    public EntradasPesos(){
        
    }
    
    private int entrada=0;
    
    /**
     * Solo se permiten entradas binarias.
     * Ceros o unos.
     * @param nueva_entrada 
     */
    public void setEntrada(int nueva_entrada){
        if(nueva_entrada>1){
            nueva_entrada=1;
        }
        if(nueva_entrada<0){
            nueva_entrada=0;
        }
        entrada=nueva_entrada;
    }
    public int getEntrada(){
        return entrada;
    }
    
    private int peso=0;
    public void setPeso(int nuevo_peso){
        peso=nuevo_peso;
    }
    public int getPeso(){
        return peso;
    }
    
    public int EntradaPorPeso(){
        System.out.println(entrada * peso);
        return entrada * peso;
    }
    
    
}

class ElMain extends Frame{
    
    public ElMain(){
        //Comprobando con una arepa o una tortilla.
        /**
         * Arepa= arina , azucar , agua , royal, huevo, aceite, opcional sal sin sal y16 con sal.
         * 
         * Tortilla = maiz molido, sal, agua, aceite.
         */
        PerseptronSimple neurona=new PerseptronSimple();
        neurona.setUmbral(15);
        
        EntradasPesos ewArina=new EntradasPesos(1,4);
        EntradasPesos ewAzucar=new EntradasPesos(1,1);
        EntradasPesos ewAgua=new EntradasPesos(1,6);
        EntradasPesos ewRoyal=new EntradasPesos(1,4);
        EntradasPesos ewHuevo=new EntradasPesos(1,3);
        EntradasPesos ewAceite=new EntradasPesos(0,3);
        EntradasPesos ewSal=new EntradasPesos(0,2);
        
//        neurona.addEntradasConPesos(ewArina);
//        neurona.addEntradasConPesos(ewAzucar);
//        neurona.addEntradasConPesos(ewAgua);//Un peso de 7
//        neurona.addEntradasConPesos(ewRoyal);
//        neurona.addEntradasConPesos(ewHuevo);
//        neurona.addEntradasConPesos(ewAceite);
//        neurona.addEntradasConPesos(ewSal);//Puede ser un peso de 1
        
        neurona=new PerseptronSimple();
        neurona.setUmbral(9);
        EntradasPesos ewMasa=new EntradasPesos(1,6);
        neurona.addEntradasConPesos(ewAgua);
        neurona.addEntradasConPesos(ewSal);
        neurona.addEntradasConPesos(ewAceite);
        neurona.addEntradasConPesos(ewMasa);
        
//        System.out.println("Salida " + neurona.salida());
        
        if(neurona.salida()==1){
            txt="Es una tortilla.\n" + neurona.salida();
        }else{
            txt="No es una tortilla.\n" + neurona.salida();
        }
        
        this.setTitle("" + neurona.salida());
        this.setVisible(true);
        this.setBounds(100, 100, 300, 150);
        
    }
    
    private String txt="";
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawString(txt, 100, 75);
    }
    
    public static void main(String []m){
        ElMain el=new ElMain();
        
    }
}