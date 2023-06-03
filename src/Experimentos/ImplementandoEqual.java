/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

import javax.swing.JOptionPane;

/**
 *Experimento para ver si implementando la funcion equals se puede realizar una comprobacion en 
 * otro class.
 * @author Jugador
 */
public class ImplementandoEqual {
    
    public static void main(String m[]){
        X<Uno> x=new X();
        Uno []m1=new Uno[2];
        Uno uno=new Uno(), dos=new Uno();
        uno.numero=1;
        dos.numero=3;
        //x.pasalo(uno, dos);
        //JOptionPane.showMessageDialog(null, "Es verdadero " + (uno==dos));
        uno=dos;
        //x.pasalo(uno, dos);
        
        m1[0]=uno;
        m1[1]=dos;
        x.pasalo(m1);
        //JOptionPane.showMessageDialog(null, "Es verdadero si uno=dos\n" + (uno==dos));
    }
}


class Uno{
    public int numero=0;
    
    @Override
    public boolean equals(Object obj) {
        Uno v=(Uno)obj;
        boolean b=false;
        if (this == obj ){
            JOptionPane.showMessageDialog(null, "El numero de entrada es " + v.numero + " y el numero del class es " + this.numero);
            b=true;
        }
        if (v.numero==this.numero){
            b=true;
        }
            return b;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.numero;
        return hash;
    }
}

class X<p>{
    
    public void pasalo(p parametro1, p parametro2){
        JOptionPane.showMessageDialog(null, "Es verdadero si parametro1=parametro2\n" + (parametro1.equals(parametro2)));
    }
    
    public void pasalo(Object []m){
        JOptionPane.showMessageDialog(null, "Es verdadero si parametro1=parametro2 en la matriz.\n" + (((p)m[0]).equals((p)m[1])));
    }
}