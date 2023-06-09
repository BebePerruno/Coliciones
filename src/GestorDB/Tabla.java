/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestorDB;

import TrabajosEnCosturas.BuscarRsException;
import TrabajosEnCosturas.ModificarRsException;
import TrabajosEnCosturas.RsEstructura;
import TrabajosEnCosturas.getAbstractListModelException;
import TrabajosEnCosturas.getCuadriculaException;
import TrabajosEnCosturas.getDefaultComboBoxModelException;
import TrabajosEnCosturas.getMatrizException;
import TrabajosEnCosturas.getVectorException;
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
public class Tabla implements RsEstructura<Campo>, iNombre, iSQL<Campo>{
    
    /**
     * Primero se busca el where para ver que campo esta usando para buscar y que esta buscando.
     * Luego se seleccionan los datos correspondientes a lo que se busca.
     * @param comando_sql
     * @return 
     */
    @Override
    public ArrayList<Campo> buscarConSQL(String comando_sql){
        ArrayList<Campo> resultados=new ArrayList();
        String []mComandoSql={};
        mComandoSql=comando_sql.split(" ");
        if(mComandoSql.length>=1){
            if(mComandoSql[0].equalsIgnoreCase("select")==true){
                for(int i=0; i<mComandoSql.length;i++){
                    if(mComandoSql[i].equalsIgnoreCase("from")==false){
                        Campo campoLocal=new Campo();
                        campoLocal.setNombre(mComandoSql[i]);
                        try {
                            campoLocal=this.buscar(campoLocal);
                        } catch (BuscarRsException ex) {
                            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
//                        if(campoLocal.getDatosDelCampo()!=null){
//                           resultados.add(campoLocal);
//                        }
                        
                    }else{
                        break;
                    }
                }
            }
        }
        
        
        return resultados;
    }
    
    private ArrayList<Campo> campos=new ArrayList();
    
    private String nombre="";
    
    @Override
    public void setNombre(String nuevo_nombre){
        nombre=nuevo_nombre;
    }
    @Override
    public String getNombre(){
        return nombre;
    }

    @Override
    public void add(Campo nuevo_registro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Campo buscar(Campo registro_a_buscar) throws BuscarRsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(Campo registro_a_validar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Campo get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Campo get(Campo registro_a_obtener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Campo modificar(Campo registro_a_modificar) throws ModificarRsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(Campo registro_a_borrar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel getCuadricula() throws getCuadriculaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] getMatriz() throws getMatrizException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getEtiquetas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultComboBoxModel getDefaultComboBoxModel() throws getDefaultComboBoxModelException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractListModel<String> getAbstractListModel() throws getAbstractListModelException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int Size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getVector() throws getVectorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

