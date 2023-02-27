/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jugador
 */
public class RsDiasDeTrabajo implements RsEstructura<DiaDeTrabajo>, Iterable<DiaDeTrabajo>{
    private ArrayList <DiaDeTrabajo> DiasDeTrabajo=new ArrayList();
    
    /**
     * Se obtiene el total de horas trabajadas en la semana.
     * @return Retorna la sumatoria de horas.
     */
    public String getTotalDeHoras(){
        double horas=0;
        for(DiaDeTrabajo dia: DiasDeTrabajo){
            horas+=Double.parseDouble( dia.getSubtotalDeHoras() );
//            System.out.println("Sumatoria "+horas);
        }
        
        return horas+"";
    }
    
    @Override
    public void add(DiaDeTrabajo nuevo_registro) {
        DiasDeTrabajo.add(nuevo_registro);
        System.out.println("Tamaño del registro al guardar "+DiasDeTrabajo.size());
    }
    @Override
    public DiaDeTrabajo buscar(DiaDeTrabajo registro_a_buscar) throws BuscarRsException {
        for (int i=0; i<DiasDeTrabajo.size(); i++){
            if(DiasDeTrabajo.get(i).getFecha().equalsIgnoreCase(registro_a_buscar.getFecha())==true){
                System.out.println("Dia a buscar "+ registro_a_buscar.getFecha()  + ", dia encontrado " + DiasDeTrabajo.get(i));
                return DiasDeTrabajo.get(i);
            }
        }
        return null;
    }

    @Override
    public DiaDeTrabajo modificar(DiaDeTrabajo registro_a_modificar) throws ModificarRsException {
        for (int i=0; i<DiasDeTrabajo.size(); i++){
            if(registro_a_modificar.getFecha().equalsIgnoreCase(DiasDeTrabajo.get(i).getFecha())==true){
                DiasDeTrabajo.get(i).setDia(registro_a_modificar.getDia());
                DiasDeTrabajo.get(i).setFecha(registro_a_modificar.getFecha());
                DiasDeTrabajo.get(i).setEntrada(registro_a_modificar.getEntrada());
                DiasDeTrabajo.get(i).setEntradaAmPm(registro_a_modificar.getEntradaAmPm());
                DiasDeTrabajo.get(i).setSalida(registro_a_modificar.getSalida());
                DiasDeTrabajo.get(i).setSalidaAmPm(registro_a_modificar.getSalidaAmPm());
                DiasDeTrabajo.get(i).setSubtotalDeHoras(registro_a_modificar.getSubtotalDeHoras());
                
                return DiasDeTrabajo.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean existe(DiaDeTrabajo registro_a_validar) {
        for (int i=0; i<DiasDeTrabajo.size(); i++){
            if(registro_a_validar.getFecha().equalsIgnoreCase(DiasDeTrabajo.get(i).getFecha())==true){
                return true;
            }
        }
        return false;
    }

    @Override
    public DiaDeTrabajo get(int id)  {
        if(id<0 || id>DiasDeTrabajo.size()-1 ){
            return null;
        }
        return DiasDeTrabajo.get(id);
    }

    @Override
    public DiaDeTrabajo get(DiaDeTrabajo registro_a_obtener) {
        for (int i=0; i<DiasDeTrabajo.size(); i++){
            if(registro_a_obtener.getFecha().equalsIgnoreCase(DiasDeTrabajo.get(i).getFecha())==true){
                return DiasDeTrabajo.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean borrar(DiaDeTrabajo registro_a_borrar){
        for (int i=0; i<DiasDeTrabajo.size(); i++){
            if(registro_a_borrar.getFecha().equalsIgnoreCase(DiasDeTrabajo.get(i).getFecha())==true){
                DiasDeTrabajo.remove(i);
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
        String [][]m=new String[DiasDeTrabajo.size()][5];
        System.out.println("Tamaño del registro "+DiasDeTrabajo.size());
        for (int f=0; f<DiasDeTrabajo.size(); f++){
                m[f][0]=DiasDeTrabajo.get(f).getDia();
                m[f][1]=DiasDeTrabajo.get(f).getFecha();
                m[f][2]=DiasDeTrabajo.get(f).getEntrada()+DiasDeTrabajo.get(f).getEntradaAmPm();
                m[f][3]=DiasDeTrabajo.get(f).getSalida()+DiasDeTrabajo.get(f).getSalidaAmPm();
                m[f][4]=DiasDeTrabajo.get(f).getSubtotalDeHoras();
        }
            return m;
    }

    @Override
    public String[] getEtiquetas() {
       String []m={"Día", "Fecha", "Entrada", "Salida", "Subtotal de horas"};
       return m;
    }
    
    @Override
    public String toString(){
        String informe="Informe de los datos.\n";
        for (int i=0; i<DiasDeTrabajo.size(); i++){
            informe+=DiasDeTrabajo.get(i).toString()+"\n";
        }
        informe+="Final del informe.";
        return informe;
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
                String []m=new String [DiasDeTrabajo.size()];
            
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
        return DiasDeTrabajo.size();
    }

    @Override
    public Iterator<DiaDeTrabajo> iterator() {
        return new MiItr();
    }

    @Override
    public void forEach(Consumer<? super DiaDeTrabajo> action) {
        Iterable.super.forEach(action); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String[] getVector() throws getVectorException {
        String []m=new String [DiasDeTrabajo.size()];
        for (int i=0; i<DiasDeTrabajo.size(); i++){
            m[i]=DiasDeTrabajo.get(i).getFecha();
        }
        return m;
    }
    
    class MiItr implements Iterator<DiaDeTrabajo> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = DiasDeTrabajo.size();

        // prevent creating a synthetic constructor
        MiItr() {}

        @Override
        public boolean hasNext() {
            return cursor != DiasDeTrabajo.size();
        }

        @SuppressWarnings("unchecked")
        @Override
        public DiaDeTrabajo next() {
            checkForComodification();
            int i = cursor;
            if (i >= DiasDeTrabajo.size())
                throw new NoSuchElementException();
            Object[] elementData = DiasDeTrabajo.toArray();
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (DiaDeTrabajo) elementData[lastRet = i];
        }

        public int modCount=0;
        
        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                DiasDeTrabajo.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }


        private DiaDeTrabajo elementAt(Object[] es, int index) {
            return (DiaDeTrabajo) es[index];
        }
        
        @Override
        public void forEachRemaining(Consumer<? super DiaDeTrabajo> action) {
            Objects.requireNonNull(action);
            final int size = DiasDeTrabajo.size();
            int i = cursor;
            if (i < size) {
                final Object[] es = DiasDeTrabajo.toArray();
                if (i >= es.length)
                    throw new ConcurrentModificationException();
                for (; i < size && modCount == expectedModCount; i++)
                    action.accept(elementAt(es, i));
                // update once at end to reduce heap write traffic
                cursor = i;
                lastRet = i - 1;
                checkForComodification();
            }
        }

        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
        }
    }
}


 