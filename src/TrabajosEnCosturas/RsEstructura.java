/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TrabajosEnCosturas;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jugador
 * @param <Plantilla> Cualquier class que sirva como contenedor de datos.
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