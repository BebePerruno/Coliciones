/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmo_KNN;

/**
 *
 * @author Rafael
 */
public class UnClasificado extends AbstractModelo{
    
    private int veces_que_aparese=0;

    public UnClasificado(String newNombre, double newValoGlobal) {
        super(newNombre, newValoGlobal);
    }
    
    public void setVecesQueAparese(int new_veces_que_aparese)
    {
        veces_que_aparese=new_veces_que_aparese;
    }
    public int getVecesQueAparese()
    {
        return veces_que_aparese;
    }
   
   
    
   private int id=0;
   
   public void setId(int newId)
   {
       id=newId;
   }
   public int getId()
   {
       return id;
   }
   
   @Override
   public String toString()
   {
       return "id=" + id + "; nombre= " + nombre + "; valor global=" +  valoGlobal + "; veces que aparese " + this.getVecesQueAparese();
   }
}
