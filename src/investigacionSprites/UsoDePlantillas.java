/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package investigacionSprites;

import javax.swing.JOptionPane;

/**
 *Ejemplo basico del uso de plantillas.
 * @author Jugador
 */
public class UsoDePlantillas {
    
    private interface Plantilla<UnModelo>{
        
        public void RealizarOperacion(UnModelo un_objeto, UnModelo otro_objeto);
    }
    
    private class Modelo{
        private int numero=0;
        
        public void setNumero(int nuevoNumero){
            numero=nuevoNumero;
        }
        public int getNumero(){
           return numero;
        }
    }
    
    private class Operador implements Plantilla<Modelo>{

        @Override
        public void RealizarOperacion(Modelo un_objeto, Modelo otro_objeto) {
            JOptionPane.showMessageDialog(null, un_objeto.getNumero()+otro_objeto.getNumero());
        }
    }
}
