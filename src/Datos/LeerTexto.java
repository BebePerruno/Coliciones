/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.io.*;
/**
 *
 * @author Jugador
 */
public class LeerTexto {
    public static void main(String [] arg) {
        EscribirTexto es=new EscribirTexto();
//        es.Escribir();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String todoElTexto="";
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            // Si el archivo esta en una hubicación diferente podemos
            // utilizar algo como C:\\carpeta\\archivo.txt
            archivo = new File ("Datos.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            
            String linea;
            while((linea=br.readLine())!=null){
//                System.out.println(linea);
                todoElTexto+=linea +"\n";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        
        String []m=todoElTexto.split("EndRs\n");
//            System.out.println("Todo el texto " + todoElTexto);
        System.out.println("Tamaño de la matriz m = " + m.length);
        String []mRegistro={};
        for(int i=0; i<m.length; ++i){
            mRegistro=m[i].split("EndField\n");
            System.out.println("Tamaño de la matriz mRegistro = " + mRegistro.length);
            System.out.println("Leyendo registro numero " + i);
            for(int b=0; b<mRegistro.length-1; b++){ //Asi para evitar tirar un campo en blanco.
                System.out.println(b+") "+ mRegistro[b]);
            }
        }
    }
}
