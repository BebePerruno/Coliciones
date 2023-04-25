/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exagonal;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jugador
 */
public class ImagenesExagonales {
    public  Icon getPunero(){
         Icon imagen=new ImageIcon();
         imagen=new ImageIcon(getClass().getResource("/Exagonal/dirt_02.png"));
         return imagen;
    }
    
    public  Icon getGranja(){
         Icon imagen=new ImageIcon();
         imagen=new ImageIcon(getClass().getResource("/Exagonal/medieval_windmill.png"));
         return imagen;
    }
    
    public  Icon getMina(){
         Icon imagen=new ImageIcon();
         imagen=new ImageIcon(getClass().getResource("/Exagonal/medieval_mine.png"));
         return imagen;
    }
    
    public  Icon getCasa(){
         Icon imagen=new ImageIcon();
         imagen=new ImageIcon(getClass().getResource("/Exagonal/medieval_blacksmith.png"));
         return imagen;
    }
}
