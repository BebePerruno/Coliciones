/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Jugador
 */
public class EscribirLeer {
    private ArrayList<Uno> Lista=new ArrayList();
    private void leer(){
        try {
             File archivo = new File ("Tabla.csv");
             FileReader fr = new FileReader (archivo);
             BufferedReader br = new BufferedReader(fr);

             // Lectura del fichero
             String CSV="";
             String []matrixUnUsuario={};
             Uno jugador;
             Lista=new ArrayList();//Limpiando datos
             CSV=br.readLine();

             while(CSV!=null){
                matrixUnUsuario=CSV.split(";");
                try{
                    jugador=new Uno();
                    jugador.setNombre(matrixUnUsuario[0]);
                    jugador.setPuntos(Integer.parseInt(matrixUnUsuario[1]) );
//                   this.registrarJugador(jugador);
                    Lista.add(jugador);
                    System.out.println("Leyendo " + Lista.get(Lista.size()-1).getNombre());
                }catch(Exception e){
                }
                CSV=br.readLine();
             }
             fr.close();
             br.close();
        }catch(Exception e){
           System.out.println("Error; " + e.getMessage() + "\n");
        }
    }


private void escribir() {
            try
            {
                String datosCSV="";
                FileWriter CSV = new FileWriter("Tabla.csv");
                
                PrintWriter pw = new PrintWriter(CSV);
                for(int i=0; i<Lista.size(); i++){
                    datosCSV+=Lista.get(i).getNombre() + ";";
                    datosCSV+=""+Lista.get(i).getPuntos();
                    pw.println(datosCSV);//Escribe en una nueva linea al estilo System.out.println...
                    datosCSV="";
                    System.out.println("Escribiendo " + Lista.get(i).getNombre());
                }
                pw.close();
                CSV.close();
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
}

class Uno{
    private String nombre="";
   public String getNombre(){
       return nombre;
   } 
   public void setNombre(String nuevo_nombre){
       nombre=nuevo_nombre;
   }
   
   private int puntos=0;
   public int getPuntos(){
       return puntos;
   }
   public void setPuntos(int nuevos_puntos){
       puntos=nuevos_puntos;
   }
}