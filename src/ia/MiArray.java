/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia;

/**
 *
 * @author Jugador
 */
public class MiArray{
        private String []matriz={""};
        
        public MiArray(){
        }
        
        public int size(){
            return matriz.length;
        }
        
        public void add(String datos){
            String []m=matriz;
            if(matriz[0].equals("")==true){
                matriz[0]=datos;
            }else{
                matriz=new String[1+m.length];
                for(int i=0; i<m.length; i++){
                    matriz[i]=m[i];
                }
                matriz[matriz.length-1]=datos;
            }
        }
        
        public String get(int id){
            try {
                if(idValido(id)==false){
                    return "";
                }
                return matriz[id];
            } catch (Exception ex) {
//                Logger.getLogger(MiArray.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "";
        }
        
        private boolean idValido(int id) throws Exception{
            if(id>matriz.length-1){
                throw new Exception("El id es mayor al maximo en class MiArray.");
            }
            
            if(id<0){
                throw new Exception("El id es es al maximo en class MiArray.");
            }
            return true;
        }
        
        public void remover(int id){
            try {
                if(idValido(id)==false){
                    return;
                }
                matriz[id]=null;
                String []m=new String[matriz.length-2];
                for(int i=0; i<matriz.length; i++){
                    if(matriz[id].equals("")==true){
                        //No hacer nada
                    }else{
                        m[i]=matriz[i];
                    }
                }
                matriz=m;
            } catch (Exception ex) {
//                Logger.getLogger(MiArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void modificar(int id, String datos){
            try {
                if(idValido(id)==false){
                    return;
                }
                matriz[id]=datos;
            } catch (Exception ex) {
//                Logger.getLogger(MiArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
