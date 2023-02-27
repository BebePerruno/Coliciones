/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jugador
 * @param <Plantilla>
 */
public interface RsEstructura <Plantilla>{
    public void add(Plantilla nuevo_registro);
    public Plantilla buscar(Plantilla registro_a_buscar)throws BuscarRsException;
    public boolean existe(Plantilla registro_a_validar);
    public Plantilla get(int id);// throws GetRsException;
    public Plantilla get(Plantilla registro_a_obtener) ;
    public Plantilla modificar(Plantilla registro_a_modificar) throws ModificarRsException;
    public boolean borrar(Plantilla registro_a_borrar);
    public DefaultTableModel getCuadricula()throws getCuadriculaException;
    public String [][]getMatriz()throws getMatrizException;
    public String []getEtiquetas();
    public DefaultComboBoxModel getDefaultComboBoxModel() throws getDefaultComboBoxModelException;
    public AbstractListModel<String> getAbstractListModel()throws getAbstractListModelException;
    public int Size();
    public String []getVector()throws getVectorException;
}

class getVectorException extends Exception{
    public getVectorException(){
        super("No existen datos para poder llenar el vector.");
    }
}

class getAbstractListModelException extends Exception{
    public getAbstractListModelException(){
        super("No existen datos para poder llenar el jListBox.");
    }
}

class getDefaultComboBoxModelException extends Exception{
    public getDefaultComboBoxModelException(){
        super("No existen datos para poder llenar el JComboBox.");
    }
}

class getMatrizException extends Exception{
    public getMatrizException(){
        super("No existen datos para poder llenar la matriz.");
    }
}

class getCuadriculaException extends Exception{
    public getCuadriculaException(){
        super("No existen datos para poder llenar la cuadricula.");
    }
}

class BuscarRsException extends Exception{
    public BuscarRsException(){
        super("El registro no existe y por eso se retornó un null");
    }
}

//class GetRsException extends BuscarRsException{
//    
//}

class ModificarRsException extends Exception{
    public ModificarRsException(){
        super("El registro no se pudo modificar con exito y por eso se retornó un null");
    }
}