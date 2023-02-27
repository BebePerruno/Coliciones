/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TrabajosEnCosturas;

/**
 *
 * @author Jugador
 */
public interface iDiaDeTrabajo {

    String getDia();

    String getEntrada();

    String getEntradaAmPm();

    String getFecha();

    String getSalida();

    String getSalidaAmPm();

    String getSubtotalDeHoras();

    void setDia(String nuevo_dia);

    void setEntrada(String nueva_entrada);

    void setEntradaAmPm(String nuevo_am_pm);

    void setFecha(String nueva_fecha);

    void setSalida(String nueva_salida);

    void setSalidaAmPm(String nuevo_am_pm);

    void setSubtotalDeHoras(String nueva_subtotal);
    
}
