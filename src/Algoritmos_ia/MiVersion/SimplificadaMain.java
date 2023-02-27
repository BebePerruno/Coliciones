/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos_ia.MiVersion;

/**
 *
 * @author Rafael
 */
public class SimplificadaMain {
    
    public static void main(String []m){
        RsHormigaSimplificada h=new RsHormigaSimplificada();
        h.add(5, 1, 1,5);
        h.add(4, 1, 1,7);
        h.add(2, 8, 4,15);
        h.add(15, 7, 11,5);
        
        class Colmena extends HormiguerroSimplificado{

            @Override
            public void ObteniendoCoordenadas(double nuevo_X1, double nuevo_X2, double nuevo_Y1, double nuevo_Y2) {
                System.out.println("x1= " + nuevo_X1 + "; x2= " + nuevo_X2 + "; Y1= " + nuevo_Y1 + "; Y2= " + nuevo_Y2);
            }
            
        }
        
        HormiguerroSimplificado hor=new Colmena();
        hor.add(h);
        RsHormigaSimplificada h2=new RsHormigaSimplificada();
        h2.add(4, 3, 1,8);
        h2.add(1, 2, 2,7);
        h2.add(9, 1, 12,5);
        h2.add(3, 1, 6,5);
        hor.add(h2);
        hor.mejorCamino();
//        for(int i=0; i<hor.mejorCamino().size(); i++){
//            System.out.println(i + ")" + hor.mejorCamino().getXY(i).toString() + "\n");
//        }
        
     //Las coordenadas solo se volverian a agregar al gestor de coordenadas de la unidad.   
    }
    
}
