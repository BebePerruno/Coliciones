/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Algoritmo_KNN;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 * @param <Rafael> Un objeto que se pasa para formatear la estructura de la interface.
 */
public interface RsDatos<Rafael> extends Serializable {

    void Ordenar();

    void add(Rafael newCategoria);

    void modificar(Rafael newCategoria);
    
    Rafael get(int id);
    
    ArrayList<Rafael> getRange(int k);
    
    int size();
    
}
