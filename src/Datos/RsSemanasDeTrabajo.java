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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jugador
 */
public class RsSemanasDeTrabajo implements RsEstructura<SemanaDeTrabajo>, EscribirLeerInterface{
    
    public RsSemanasDeTrabajo(){
        leer();
    }

    private ArrayList <SemanaDeTrabajo> SemanasDeTrabajo=new ArrayList();

    @Override
    public void add(SemanaDeTrabajo nuevo_registro) {
        SemanasDeTrabajo.add(nuevo_registro);
    }

    @Override
    public SemanaDeTrabajo buscar(SemanaDeTrabajo registro_a_buscar) throws BuscarRsException {
        for (int i=0; i<SemanasDeTrabajo.size(); i++){
            if(registro_a_buscar.getFechaInicial().equalsIgnoreCase(SemanasDeTrabajo.get(i).getFechaInicial())==true){
                return SemanasDeTrabajo.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean existe(SemanaDeTrabajo registro_a_validar) {
        try{
            for (int i=0; i<SemanasDeTrabajo.size(); i++){
                if(registro_a_validar.getFechaInicial().equalsIgnoreCase(SemanasDeTrabajo.get(i).getFechaInicial())==true){
                    return true;
                }
            }
        }catch(Exception e){
            
        }
        return false;
    }

    @Override
    public SemanaDeTrabajo get(int id)  {
        if(id<=-1 || id>=SemanasDeTrabajo.size() ){
            return null;
        }
        return SemanasDeTrabajo.get(id);
    }

    @Override
    public SemanaDeTrabajo get(SemanaDeTrabajo registro_a_obtener) {
        for (int i=0; i<SemanasDeTrabajo.size(); i++){
            if(registro_a_obtener.getFechaInicial().equalsIgnoreCase(SemanasDeTrabajo.get(i).getFechaInicial())==true){
                return SemanasDeTrabajo.get(i);
            }
        }
        return null;
    }

    @Override
    public SemanaDeTrabajo modificar(SemanaDeTrabajo registro_a_modificar) throws ModificarRsException {
        
        for (int i=0; i<SemanasDeTrabajo.size(); i++){
            if(registro_a_modificar.getFechaInicial().equalsIgnoreCase(SemanasDeTrabajo.get(i).getFechaInicial())==true){
                SemanasDeTrabajo.get(i).setFechaInicial(registro_a_modificar.getFechaInicial());
                SemanasDeTrabajo.get(i).setFechaFinal(registro_a_modificar.getFechaFinal());
                SemanasDeTrabajo.get(i).setDiasSemanales(registro_a_modificar.getDiasSemanales());
                
                return SemanasDeTrabajo.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean borrar(SemanaDeTrabajo registro_a_borrar) {
        for (int i=0; i<SemanasDeTrabajo.size(); i++){
            if(registro_a_borrar.getFechaInicial().equalsIgnoreCase(SemanasDeTrabajo.get(i).getFechaInicial())==true){
                SemanasDeTrabajo.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public DefaultTableModel getCuadricula() throws getCuadriculaException {
        String [][]m={};
        try {
            m=getMatriz();
        } catch (getMatrizException ex) {
            System.out.println(ex.getMessage());
        }
        return new DefaultTableModel(m,getEtiquetas());
    }

    @Override
    public String[][] getMatriz() throws getMatrizException {
        String [][]m=new String[SemanasDeTrabajo.size()][SemanasDeTrabajo.size()];
        for (int f=0; f<SemanasDeTrabajo.size(); f++){
                m[f][0]=SemanasDeTrabajo.get(f).getFechaInicial();
                m[f][1]=SemanasDeTrabajo.get(f).getFechaFinal();
                m[f][2]=SemanasDeTrabajo.get(f).getRsDiasDeTrabajoFormateados();
        }
            return m;
    }

    @Override
    public String[] getEtiquetas() {
        String []m={"Fecha inicial", "Fecha final", "Datos de la semana" };
        return m;
    }

    @Override
    public DefaultComboBoxModel getDefaultComboBoxModel() throws getDefaultComboBoxModelException {
        try {
            return new DefaultComboBoxModel(this.getVector());
        } catch (getVectorException ex) {
            Logger.getLogger(RsDiasDeTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public AbstractListModel<String> getAbstractListModel() throws getAbstractListModelException {
        class ListModelo extends AbstractListModel<String>{
                String []m=new String [SemanasDeTrabajo.size()];
                
                public ListModelo(){
                    try {
                        m=getVector();
                    } catch (getVectorException ex) {
                        Logger.getLogger(RsDiasDeTrabajo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                @Override
                public int getSize() {
                    return m.length;
                }
                
                @Override
                public String getElementAt(int index) {
                    return m[index];
                }
                
            }
        return new ListModelo();
    }

    @Override
    public int Size() {
        return SemanasDeTrabajo.size();
    }

    @Override
    public String[] getVector() throws getVectorException {
        String []m=new String [SemanasDeTrabajo.size()];
        for (int i=0; i<SemanasDeTrabajo.size(); i++){
            m[i]=SemanasDeTrabajo.get(i).getFechaInicial();
        }
        return m;
    }

    private final String nombreDelArchivo="Tabla.txt";
    
    @Override
    public void escribir() {
        try
            {
                String texto="";
                FileWriter fw = new FileWriter(nombreDelArchivo);
                
                PrintWriter pw = new PrintWriter(fw);
                for(int i=0; i<SemanasDeTrabajo.size(); i++){
                    texto+=SemanasDeTrabajo.get(i).getFechaInicial() + SemanaDeTrabajo.EndField;
                    texto+=""+SemanasDeTrabajo.get(i).getFechaFinal() + SemanaDeTrabajo.EndField;
                    texto+=""+SemanasDeTrabajo.get(i).getTotalDeHoras()+ SemanaDeTrabajo.EndField;
                    texto+=""+SemanasDeTrabajo.get(i).getRsDiasDeTrabajoFormateados()+ SemanaDeTrabajo.EndField;
                    texto+=SemanaDeTrabajo.EndRs;
                    pw.println(texto);//Escribe en una nueva linea al estilo System.out.println...
//                    String m[]=texto.split(SemanaDeTrabajo.EndRs);
                    texto="";
                    
//                    String F[]=m[0].split(SemanaDeTrabajo.EndField);
                    
//                    System.out.println("m="+ m.length + "\nF="+F.length + "Datos de F= " + F[2]);
//                    System.out.println("Escribiendo " + SemanasDeTrabajo.get(i).toString());
                }
                pw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
    }

    @Override
    public void leer() {
        try {
             File archivo = new File (nombreDelArchivo);
             FileReader fr = new FileReader (archivo);
             BufferedReader br = new BufferedReader(fr);

             // Lectura del fichero
             String []mRs={};
             String []mField={};
             String lineaDeTexto="";
             String todoElTexto="";
             
             SemanasDeTrabajo=new ArrayList();//Limpiando datos
             lineaDeTexto=br.readLine();

             while(lineaDeTexto!=null){
                 todoElTexto+=lineaDeTexto;
                lineaDeTexto=br.readLine();
             }
             fr.close();
             br.close();
//             System.out.println("todoElTexto="+todoElTexto);
             SemanaDeTrabajo unaSemana;
             mRs=todoElTexto.split(SemanaDeTrabajo.EndRs);
             for(int i=0; i<mRs.length; ++i){
//                 try{
                    mField=mRs[i].split(SemanaDeTrabajo.EndField);
//                    System.out.println("mRs= "+mRs.length );
                    unaSemana=new SemanaDeTrabajo();
                    unaSemana.setFechaInicial(mField[0]);
                    unaSemana.setFechaFinal(mField[1]);
                    unaSemana.setTotalDeHoras(mField[2]);
                    unaSemana.setRsDiasDeTrabajoFormateados(mField[3] );
                    SemanasDeTrabajo.add(unaSemana);
//                    System.out.println("Leyendo " + SemanasDeTrabajo.get(SemanasDeTrabajo.size()-1).toString());
//                }catch(Exception e){
//                    System.out.println(e.getMessage());
//                }
             }
        }catch(Exception e){
           System.out.println("Error; " + e.getMessage() + "\n");
        }
    }
}
