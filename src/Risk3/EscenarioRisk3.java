/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Risk3;

import javax.swing.JOptionPane;

/**
 * Aqui se realizan todas las mecanicas del juego.
 * 
 * @author Rafael Angel MF
 */
public class EscenarioRisk3 {
    private TerritorioRisk3 [][] mapa=new TerritorioRisk3[2][2];
    
    public EscenarioRisk3(){
        for(int f=0; f<mapa.length; ++f){
            for(int c=0;c<mapa.length; c++){
                mapa[f][c]=new TerritorioRisk3();
            }
        }
    }
    private void usuarioInvade(int f_defensor, int c_defensor){
//        mapa[0][0]=jpTerritorio1.getTerritorio();
//        mapa[1][0]=jpTerritorio2.getTerritorio();
//        mapa[0][1]=jpTerritorio3.getTerritorio();
//        mapa[1][1]=jpTerritorio4.getTerritorio();
        int v=JOptionPane.showConfirmDialog(null, "¿Desea colinizar este territorio?", "Hola", JOptionPane.YES_NO_OPTION);//=0 si, =1 no
        JOptionPane.showMessageDialog(null, "Eligio " + v);
        if(v==0){
            for(int f=0; f<mapa.length;++f){
                for(int c=0; c<mapa.length;++c){
                    if(true){//(f!=f_defensor && c!=c_defensor){
                        if(mapa[f][c].getSeleccionado()==true){
            //                mapa[1][0]=jpTerritorio2.getTerritorio(); no
                            int soladosTanques=JOptionPane.showConfirmDialog(null, "Desea enviar soldados, en caso de no agregar soldados entonces se agregaran tanques.", "Hola", JOptionPane.YES_NO_OPTION);
                            if(soladosTanques==0){
                                String s=JOptionPane.showInputDialog("Existen " + mapa[f][c].getSoldados() +  " soldados en tu territorio.\n¿Cuantos deseas enviar?");
                                int vCantidad=0;
                                try{
                                    vCantidad=Integer.parseInt(s);
                                }catch(Exception e){
                                    return;
                                }
                                if(mapa[f_defensor][c_defensor].getSoldados()<vCantidad){
                                    mapa[f_defensor][c_defensor].setSoldados(vCantidad-mapa[f_defensor][c_defensor].getSoldados());
                                    if(mapa[f_defensor][c_defensor].getTanques()>0){
                                        if(mapa[f_defensor][c_defensor].getTanques()>mapa[f_defensor][c_defensor].getSoldados()){
                                            int valor=mapa[f_defensor][0].getTanques()-mapa[f_defensor][c_defensor].getSoldados();
                                            mapa[f_defensor][c_defensor].setTanques(valor);
                                            mapa[f_defensor][c_defensor].setSoldados(0);
//                                            actualizarAcciones();
                                            return;
                                        }  
                                    }
                                }
                                else if(mapa[f_defensor][c_defensor].getSoldados()>vCantidad){
                                    int valor=mapa[f_defensor][c_defensor].getSoldados()-vCantidad;
                                    mapa[f_defensor][c_defensor].setSoldados(valor);
//                                    actualizarAcciones();
                                    return;
                                }

                            }
                            else if(soladosTanques==1){
                                String s=JOptionPane.showInputDialog("Existen " + mapa[f][c].getTanques()+  " tanques en tu territorio.\n¿Cuantos deseas enviar?");
                                int vCantidad=0;
                                try{
                                    vCantidad=Integer.parseInt(s);
                                }catch(Exception e){
                                    return;
                                }
                                if(mapa[f_defensor][c_defensor].getTanques()<vCantidad){
                                    mapa[f_defensor][c_defensor].setSoldados(vCantidad-mapa[f_defensor][c_defensor].getTanques());
                                    if(mapa[f_defensor][c_defensor].getSoldados()>0){
                                        if(mapa[f_defensor][c_defensor].getSoldados()>mapa[f_defensor][c_defensor].getTanques()){
                                            int valor=mapa[f_defensor][c_defensor].getSoldados()-mapa[f_defensor][c_defensor].getTanques();
                                            mapa[f_defensor][c_defensor].setSoldados(valor);
                                            mapa[f_defensor][c_defensor].setTanques(0);
//                                            actualizarAcciones();
                                            return;
                                        }  
                                    }
                                }
                                else if(mapa[f_defensor][c_defensor].getTanques()>vCantidad){
                                    int valor=mapa[f_defensor][c_defensor].getTanques()-vCantidad;
                                    mapa[f_defensor][c_defensor].setTanques(valor);
//                                    actualizarAcciones();
                                    return;
                                }
                            }
                        }
                    }  
                } //end omision del id defensor
            }
        } //end algoritmo
    }
    
    
}
