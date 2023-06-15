/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MisEventos;

import javax.swing.JOptionPane;

/**
 *
 * @author Jugador
 */
public class ElMain {
    public static void main(String args[]){
        
        class Ev implements iEventos{

            @Override
            public void click() {
                JOptionPane.showMessageDialog(null, "Hola esto es un evento.");
            }
        }
        new FrmEventos(new Ev());
    }
            
}
