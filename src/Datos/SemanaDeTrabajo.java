/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jugador
 */
public class SemanaDeTrabajo implements TotalesSemanales {
    
    private String totalDeHoras="0";
    
    @Override
    public void setTotalDeHoras(String nuevo_total){
        //No se coloca nada porque da problemas.
        System.out.println("setTotalDeHoras= Valor total erroneo " + nuevo_total);
    }
    
    @Override
    public String getTotalDeHoras(){
        totalDeHoras=this.getDiasSemanales().getTotalDeHoras();
        return totalDeHoras+"";
    }
    
    
    public SemanaDeTrabajo(){
        
    }
    
    /**
     * Carga el class sin el rs de los dias de semana para usarse en una busqueda.
     * @param fecha_de_inicio_de_semana 
     */
    public SemanaDeTrabajo(String fecha_de_inicio_de_semana){
        this.setFechaInicial(fecha_de_inicio_de_semana);
    }
    
    public static final String EndRs=" Ends ";
    public static final String EndField=" EndFieldS ";
    
    private String fechaInicial="";
    
    public void setFechaInicial(String nueva_fecha_inicial){
        fechaInicial=nueva_fecha_inicial;
    }
    public void setFechaInicial(){
        try {
            fechaInicial=diasSemanales.get(0).getFecha();
        } catch (Exception ex) {
            Logger.getLogger(SemanaDeTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFechaInicial(){
        return fechaInicial;
    }
    
    private String fechaFinal="";
    public void setFechaFinal(String nueva_fecha_final){
        fechaFinal=nueva_fecha_final;
    }
    public void setFechaFinal(){
        try {
            fechaFinal=diasSemanales.get(diasSemanales.Size()-1).getFecha();
        } catch (Exception ex) {
            Logger.getLogger(SemanaDeTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getFechaFinal(){
        return fechaFinal;
    }
    
    
    
    private RsDiasDeTrabajo diasSemanales=null;
    private String rsDiasDeTrabajoFormateados="";
    
    private void formatear(){
        rsDiasDeTrabajoFormateados="";
        for(DiaDeTrabajo dia: diasSemanales){
            rsDiasDeTrabajoFormateados+=dia.getDiaFormateado();//dia.getDia() + RsDiasDeTrabajo.EndField + dia.getFecha() + RsDiasDeTrabajo.EndField + dia.getEntrada() +  RsDiasDeTrabajo.EndField + dia.getEntradaAmPm() +  RsDiasDeTrabajo.EndField + dia.getSalida() +  RsDiasDeTrabajo.EndField + dia.getSalidaAmPm() +  RsDiasDeTrabajo.EndField + dia.getSubtotalDeHoras() +  RsDiasDeTrabajo.EndField + RsDiasDeTrabajo.EndRs;
//            System.out.println("Formateando\n"+rsDiasDeTrabajoFormateados);
        }
    }
    
    public void setDiasSemanales(RsDiasDeTrabajo nuevos_datos_semanales){
        diasSemanales=nuevos_datos_semanales;
        formatear();
    }
    
    public RsDiasDeTrabajo getDiasSemanales(){
        return diasSemanales;
    }
    public String getRsDiasDeTrabajoFormateados(){
        formatear();
        return rsDiasDeTrabajoFormateados;
    }
    
    @Override
    public String toString(){
        return "Fecha de inicio de semana " + this.getFechaFinal() + ", fecha de final de semana " + this.getFechaFinal() + "\nDias\n"+getRsDiasDeTrabajoFormateados();
    }
    
    private String datosFormateados="";
    
    public void setRsDiasDeTrabajoFormateados(String nuevos_datos_formateados){
        datosFormateados=nuevos_datos_formateados;
//        String []m=datosFormateados.split(SemanaDeTrabajo.EndField);
//        this.setFechaInicial(m[0]);
//        this.setFechaFinal(m[1]);
        String []mDias=nuevos_datos_formateados.split(DiaDeTrabajo.EndRs);
//        System.out.println("mDias="+mDias.length +"= " +nuevos_datos_formateados);
        diasSemanales=new RsDiasDeTrabajo();
        for(int i=0; i<mDias.length; ++i){
            String []mField=mDias[i].split(DiaDeTrabajo.EndField);
            DiaDeTrabajo dia=new DiaDeTrabajo();
            dia.setDiaFormateado(mField);
//            dia.setDia(mField[0]);
//            dia.setFecha(mField[1]);
//            dia.setEntrada(mField[2]);
//            dia.setEntradaAmPm(mField[3]);
//            dia.setSalida(mField[4]);
//            dia.setSalidaAmPm(mField[5]);
//            dia.setSubtotalDeHoras(mField[6]);
            diasSemanales.add(dia);
        }
    }
}
