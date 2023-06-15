/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investigacionSprites;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Rafael
 */
public class LeerVariosArchivos {
    /**
     * Lunes 22 de agosto del 2022.
     * Muestra la informacion escrita en varios archivos de texto alamcenados en 
     * la misma carpeta que el ejecutable jar.
     * 
     */
    public void inforemeDeVariosArchivos()
    {
        System.out.println("\n\nMostrando historial de vehiculos alquilados.");
        //Leyendo nombres de archivos.
        String []mLista_de_documentos={};
        String ListaTXT="";
        String path=new File("A.txt").getAbsolutePath();
//        System.out.println("El Path antes del formateo\n"+path);
        path=path.replace("\\","/");
        String []mPath=path.split("/");
        
        path="";
        for(int i=0; i<mPath.length-1; ++i)
        {
            if((i>=0) && (i<mPath.length-1))
            {
                path+=mPath[i]+"/";
            }else if(i==mPath.length-1)
            {
                path+=mPath[i];
            }
        }
        File folder=new File(path);//Carpeta de busqueda.
        System.out.println("\nEl Path despues del formateo\n"+path);
        
        for(File file: folder.listFiles())
        {
            if(file.isDirectory()==false)
            {
                if(file.getName().endsWith(".txt"))
                {
                    ListaTXT+=file.getName() + ";";
                    System.out.println("Archivo de texto= " + file.getName());
                }
            }
            mLista_de_documentos=ListaTXT.split(";");
            
            //Leyendo el contenido de los archivos.
            
        }
        
        System.out.println("\n\n\nInformando\n\n");
        for(int id=0; id<mLista_de_documentos.length; ++id)
        {
            File archivo=new File(path + mLista_de_documentos[id]);
            FileReader fr=null;
            BufferedReader br=null;
            System.out.println("Informe del cliente " + mLista_de_documentos[id].replace(".txt", "")+"\n\n");
            try {
            fr=new FileReader(archivo);
            } catch (FileNotFoundException ex) {
                //
            }
                    br=new BufferedReader(fr);
                    String linea_de_texto="";

            try {
                while((linea_de_texto=br.readLine())!=null)
                {
                    System.out.println(linea_de_texto);
                }
            } catch (IOException ex) {
                //
            }
            System.out.println("Informe del cliente " + mLista_de_documentos[id].replace(".txt", "") + " finalizado.\n\n");
        } //End for
        System.out.println("\n\nFin del informe\n\n\n");
        
    } //end
}
