/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class EscribirTexto {
    public void escribir(){
        FileWriter archivo = null;
        PrintWriter pw = null;
        String datos="Tema: Registro 1EndField\n fecha:Hoy\n EndField\n Datos:Esto es un registro\nQue bueno.EndField\n EndRs\nTema: Registro 2\n EndField\n fecha:Ayer\n EndField\n ;Datos:Esto fue un registro\nDel ayer.  EndRs";
        try{
            /*
            Añade el texto al final del archivo.
            archivo = new FileWriter("archivo.txt",true); 
            */
            archivo = new FileWriter("Datos.txt");//Borra el contenido del texto y agrega los nuevos datos.
            
            pw = new PrintWriter(archivo);
//            for (int i = 0; i < 10; i++) {
                pw.println(datos);
//            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            //Cerrando el archivo.
            if (null != archivo) {
                try {
                    archivo.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
//                    Logger.getLogger(EscribirTexto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
