/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GestorDB;

import java.util.ArrayList;

/**
 *
 * @author Jugador
 */
public interface iSQL<Plantilla> {

    /**
     * Primero se busca el where para ver que campo esta usando para buscar y que esta buscando.
     * Luego se seleccionan los datos correspondientes a lo que se busca.
     * @param comando_sql
     * @return
     */
    ArrayList<Plantilla> buscarConSQL(String comando_sql);
    
}
