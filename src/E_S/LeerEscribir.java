/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package E_S;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *Todo adaptar el codigo a NetBeans
 * @author Jugador
 */
public class LeerEscribir {
    
    public static void main(String []m){
        LeerEscribir es=new LeerEscribir();
        es.escribir();
        JOptionPane.showMessageDialog(null, es.leer());
    }
    
    private final String SALTO="__";
    
    public String leer(){
        File archivo=null;
        FileReader frLeer=null;
        BufferedReader brLeer=null;
        try{
            archivo=new File("archivo.txt");
            frLeer=new FileReader(archivo);
            brLeer=new BufferedReader(frLeer);
            String todosLosDatos="";
            String linea;
            while((linea=brLeer.readLine())!=null){
                todosLosDatos+=linea;
            }
            String respuesta=todosLosDatos.replace(SALTO,"\n");
            frLeer.close();
            return respuesta;
        }catch(Exception e){
            try {
                frLeer.close();
            } catch (IOException ex) {
                //Logger.getLogger(LeerEscribir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return "";
    }

    public void escribir() {
        String texto="1\n2\n3\n4\n5";
        String []m=texto.split("\n");
        FileWriter fwArchivo=null;
        PrintWriter pwEscribir=null;
        try{
            fwArchivo=new FileWriter("archivo.txt");
            pwEscribir=new PrintWriter(fwArchivo);
            for(int i=0; i<m.length; i++){
                pwEscribir.println(m[i]+ SALTO); //
                
            }
            fwArchivo.close();
        }catch(Exception e){
            try {
                fwArchivo.close();
            } catch (IOException ex) {
                //Logger.getLogger(LeerEscribir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
