/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrabajosEnCosturas;

import javax.swing.JPanel;

/**
 *
 * @author Jugador
 */
public class DiaDeTrabajo implements iDiaDeTrabajo {
    
    public static final String EndField=" EndField ";
    public static final String EndRs=" EndRs ";
    
    private String dia = "";
    private String fecha = "";
    private String entrada = "0";
    private String salida = "0";
    private String subtotalDeHoras = "0";
    private String entradaAmPm = "AM";
    private String salidaAmPm = "PM";
    
    public void setDiaFormateado(String []mFields){
        setDia(mFields[0]);
        setFecha(mFields[1]);
        setEntrada(mFields[2]);
        setEntradaAmPm(mFields[3]);
        setSalida(mFields[4]);
        setSalidaAmPm(mFields[5]);
        setSubtotalDeHoras(mFields[6]);
    }
    
    /**
     * Formatea un dia de trabajo para que se pueda escribir en la semana y luego en el disco.
     * @return 
     */
    public String getDiaFormateado(){
        return getDia() + EndField + getFecha() + EndField + getEntrada() +  EndField + getEntradaAmPm() +  EndField + getSalida() +  EndField + getSalidaAmPm() +  EndField + getSubtotalDeHoras() +  EndField + EndRs;       
    }

    public DiaDeTrabajo() {
    }
    
    /**
     * Permite cargar el class solo con la fecha ´para poderse usar en busquedas.
     * @param nueva_fecha Debe poner una fecha de algun dia.
     */
    public DiaDeTrabajo(String nueva_fecha) {
        this.setFecha(nueva_fecha);
    }

    @Override
    public void setDia(String nuevo_dia) {
        dia = nuevo_dia;
    }

    @Override
    public String getDia() {
        return dia;
    }

    @Override
    public void setFecha(String nueva_fecha) {
        fecha = nueva_fecha;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public void setEntrada(String nueva_entrada) {
        entrada = nueva_entrada;
    }

    @Override
    public String getEntrada() {
        System.out.println("entrada=" + entrada);
        return entrada;
    }

    

    @Override
    public void setSalida(String nueva_salida) {
        salida = nueva_salida;
    }

    @Override
    public String getSalida() {
        return salida;
    }

    @Override
    public void setSubtotalDeHoras(String nueva_subtotal) {
        subtotalDeHoras = nueva_subtotal;
    }

    @Override
    public String getSubtotalDeHoras() {
        return subtotalDeHoras;
    }

    @Override
    public void setEntradaAmPm(String nuevo_am_pm) {
        entradaAmPm = nuevo_am_pm;
    }

    @Override
    public String getEntradaAmPm() {
        return entradaAmPm;
    }

    @Override
    public void setSalidaAmPm(String nuevo_am_pm) {
        salidaAmPm = nuevo_am_pm;
    }

    @Override
    public String getSalidaAmPm() {
        return salidaAmPm;
    }
    
    @Override
    public String toString(){
        return "Dia " + this.getDia() + ", fecha " + this.getFecha() + ", hora de entrada " + this.getEntrada() + this.getEntradaAmPm() + ", hora de salida " + this.getSalida() + this.getSalidaAmPm() + ", total de horas trabajadas en este dia " + this.getSubtotalDeHoras();
    }
}
