/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Risk2;

/**
 *
 * @author Rafael Angel Montero Fernández.
 * Sabado 24 de setiembre del 2022.
 * Despues de largos experimentos, despues de muchos intentos, he llegado a la 
 * conclusion que para diseñar un risk.
 * La parte central del juego es el territorio.
 * Ya no es la unidad en si. De hecho la unidad en esta version experimental 
 * es tan solo un numero.
 * El territorio contara con las siguientes unidades, las cuales son variables 
 * int para indicar la cantidad de cada una.
 * Tambien cada variable tendrá asociada una constante con el valor de puntos 
 * de vida correspondiente.
 * Faccion, unidad civil, unidad soldad, unidad tanque, casa, fabrica, torre, fortaleza.
 * De esta manera para mover una unidad de un territorio a otro solo bastará 
 * con sumar o restar de algun territorio.
 * Ademas, cuando un territorio tiene unidades de alguna otra faccion, el 
 * enfrentamiento es tan solo una operacion matematica.
 * Es una resta. Mediante condicionales se indicará cual faccion es cual. 
 * (Mediante la faccion del territorio y la faccion del territorio invasor.)
 * Todo esto en una matriz del objeto Territorio 4X4, cada territorio es 
 * una casilla de la matriz.
 * Cuando el experimento se pase a una interfas grafica, se usará una sola 
 * imagen de cada unidad para representar el total de dicha unidad en el territorio.
 * 
 */
public class JuegoRisk2 {
    
}
