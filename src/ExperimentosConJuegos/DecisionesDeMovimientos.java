/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExperimentosConJuegos;

/**
 *
 * @author Jugador
 */
public enum DecisionesDeMovimientos{
    izquierda, derecha, arriba, abajo;
    
    public DecisionesDeMovimientos desicionTomada(int desicion){
            switch(desicion){
                case 1:
                    return izquierda;
                case 2:
                    return derecha;
                case 3:
                    return arriba;
                case 4:
                    return abajo;
//                default:
//                    System.out.println("Existe una nueva definicion en desiciones la cual es " + desicion);
            }
            return izquierda;
    }
} 
