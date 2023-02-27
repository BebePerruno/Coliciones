/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Risk3;
import javax.swing.JOptionPane;
/**
 *
 * @author Rafael Angel MF
 */
public class TerritorioRisk3 {
    
    /**
     * Se usa en TerritorioRisk3();
     * @param cantidad Una cantidad a restarle a los tanques de este territorio.
     */
    private void restarTanquesLocales(int cantidad, String faccion_invasora){
        if(getTanques()==cantidad){
            this.setTanques(0);
            return;
        }

        if(getTanques()>cantidad){
            this.setTanques(this.getTanques()-cantidad);
//            JOptionPane.showMessageDialog(null, "getTanques()>cantidad == " + (this.getTanques()-cantidad) + " más o menos " + this.getTanques());
            return;
        }

        if(getTanques()<cantidad){
            this.setTanques(cantidad-this.getTanques());
            this.setFaccion(faccion_invasora);
            return;

        }
    }
    
    /**
     * Se usa en TerritorioRisk3();
     * @param cantidad Una cantidad a restarle a los soldados de este territorio.
     */
    private void restarSoldadosLocales(int cantidad, String faccion_invasora){
        if(getSoldados()==cantidad){
            this.setSoldados(0);
            return;
        }

        if(getSoldados()>cantidad){
            this.setSoldados(this.getSoldados()-cantidad);
            return;
        }

        if(getSoldados()<cantidad){
            this.setSoldados(cantidad-this.getSoldados());
            this.setFaccion(faccion_invasora);
            return;

        }
    }
    
    public TerritorioRisk3 invadir_este_territorio(TerritorioRisk3 territorio_del_que_provienen_las_uniades, boolean trasladar_soldados, boolean trasladar_tanques, int cantidad){
        if((territorio_del_que_provienen_las_uniades.getSeleccionado()==true && this.getSeleccionado()==true)==true && this.getFaccion().equalsIgnoreCase(territorio_del_que_provienen_las_uniades.getFaccion())==false){
//            JOptionPane.showMessageDialog(null, this.getFaccion() + "==" +territorio_del_que_provienen_las_uniades.getFaccion());
            if(trasladar_soldados==true){
                if(territorio_del_que_provienen_las_uniades.getSoldados()>=cantidad ){
                    territorio_del_que_provienen_las_uniades.setSoldados(territorio_del_que_provienen_las_uniades.getSoldados()-cantidad);
                    restarSoldadosLocales(cantidad, territorio_del_que_provienen_las_uniades.getFaccion());
                }
            }
            
            if(trasladar_tanques==true){
                if(territorio_del_que_provienen_las_uniades.getTanques()>=cantidad){
                    territorio_del_que_provienen_las_uniades.setTanques(territorio_del_que_provienen_las_uniades.getTanques()-cantidad);
                    restarTanquesLocales(cantidad, territorio_del_que_provienen_las_uniades.getFaccion());
                }
            }
        }
        return territorio_del_que_provienen_las_uniades;
    }
    
    /**
     * Permite saber si un territorio fue seleccionado primero que otro.
     */
    private int primeroEnSeleccionarse=0;
    
    public void setPrimeroEnSeleccionarse(int posicion_numerica){
        primeroEnSeleccionarse=posicion_numerica;
    }
    /**
     * Permite saber si un territorio fue seleccionado primero que otro.
     * @return Retorna un numero que indica su posicion en la seleccion.
     */
    public int getPrimeroEnSeleccionarse(){
        return primeroEnSeleccionarse;
    }
    
    public final String FACCION_USUARIO="Angel";
    public final String FACCION_oponente="Oponente";
    
    /**
     * Traslada una cantidad indicada de unidades.
     * @param territorio_del_que_provienen_las_uniades Un territorio de la misma faccion del que provienen las unidades. 
     * Si es de una faccion diferente no se realiza nada.
     * @param trasladar_soldados True se procede a trasladar la cantidad indicada de soldados.
     * @param trasladar_tanques True se procede a trasladar la cantidad indicada de tanques.
     * @param cantidad Cantidad de unidades a trasladar, que no supere el valor de unidades del territorio del que provienen.
     * @param faccion_de_las_unidades Debe ser la misma faccion para los 2 territorios.
     * @return Retorna el territorio que se paso por parametro.
     */
    public TerritorioRisk3 entrar_a_este_territorio(TerritorioRisk3 territorio_del_que_provienen_las_uniades, boolean trasladar_soldados, boolean trasladar_tanques, int cantidad, String faccion_de_las_unidades){
        if((territorio_del_que_provienen_las_uniades.getSeleccionado()==true && this.getSeleccionado()==true)==true && (this.getFaccion().equalsIgnoreCase(faccion_de_las_unidades)==true && territorio_del_que_provienen_las_uniades.getFaccion().equalsIgnoreCase(faccion_de_las_unidades)==true)==true){
            if(trasladar_soldados==true){
                if(territorio_del_que_provienen_las_uniades.getSoldados()>=cantidad){
//                    JOptionPane.showMessageDialog(null, "territorio_del_que_provienen_las_uniades.getSoldados() " + territorio_del_que_provienen_las_uniades.getSoldados());
                    territorio_del_que_provienen_las_uniades.setSoldados(territorio_del_que_provienen_las_uniades.getSoldados()-cantidad);
                    this.setSoldados(this.getSoldados()+cantidad);
                }
            }
            
            if(trasladar_tanques==true){
                if(territorio_del_que_provienen_las_uniades.getTanques()>=cantidad){
                    territorio_del_que_provienen_las_uniades.setTanques(territorio_del_que_provienen_las_uniades.getTanques()-cantidad);
                    this.setTanques(this.getTanques()+cantidad);
                }
            }
        }
        return territorio_del_que_provienen_las_uniades;
    }
    
    private boolean seleccionado=false;
    public boolean getSeleccionado(){
        return seleccionado;
    }
    /**
     * 
     * @param seleccionarlo Un valor booleano.
     */
    public void setSeleccionado(boolean seleccionarlo){
        seleccionado=seleccionarlo;
    }
    
    public TerritorioRisk3(){
        setFaccion("Neutro");
    }
    
    public TerritorioRisk3(String nueva_faccion){
        setFaccion(nueva_faccion);
    }
    
    private String faccion="";
    public void setFaccion(String nueva_faccion){
        faccion=nueva_faccion;
    }
    public String getFaccion(){
        return faccion;
    }
    
    public final int SOLDADO_PUNTOS_DE_VIDA=2;
    private int soldados=0;
    public void setSoldados(int nueva_cantidad_de_soldados){
        soldados=nueva_cantidad_de_soldados;
    }
    public int getSoldados(){
        return soldados;
    }
    
    public final int TANQUE_PUNTOS_DE_VIDA=3;
    private int tanques=0;
    public void setTanques(int nueva_cantidad_de_tanques){
        tanques=nueva_cantidad_de_tanques;
    }
    public int getTanques(){
        return tanques;
    }
    
    public final int CASA_PUNTOS_DE_VIDA=4;
    private int casas=0;
    /**
     * Las casas se usan para generar recursos.
     * @param nueva_cantidad_de_casas Una cantidad de casas.
     */
    public void setCasas(int nueva_cantidad_de_casas){
        casas=nueva_cantidad_de_casas;
    }
    /**
     * Las casas se usan para generar recursos.
     * @return Retorna la cantidad de casas creadas.
     */
    public int getCasas(){
        return casas;
    }
    
    private int recursos_de_la_civilizacion=0;
    
    /**
     * 
     * Cada casa genera 1 de recursos.
     */
    public void generarRecursos(){
        if(casas>=1){
            recursos_de_la_civilizacion+=(casas*2)-(this.getSoldados()+(this.getTanques()*2));
        }
        else{
            //No hay casas para generar recursos.
        }
        
        if(recursos_de_la_civilizacion>200){
            //Por aquello de los desbordamientos.
            recursos_de_la_civilizacion=200;
        }
    }
    
    /**
     * Convierte 4 soldados en una casa.
     */
    public void convertir4SoldadosEnUnaCasa(){
        if(this.getSoldados()==4 ||this.getSoldados()>=4){
            this.setCasas(this.getCasas()+1);
            this.setSoldados(this.getSoldados()-4);
        }
        else{
            JOptionPane.showMessageDialog(null,"No existen suficientes soldados en este territorio para convertirlos en una casa.\nSe necesitan 4 soldados.\nIntente moviendo soldados de otro territorio.");
        }
    }
    
    public void restarRecursos(int cantidad_a_restar){
        if(recursos_de_la_civilizacion>=1){
            if(recursos_de_la_civilizacion>cantidad_a_restar){
                recursos_de_la_civilizacion-=cantidad_a_restar;
            }
            else{
                //Ya no hay recursos.
            }
        }
    }
    /**
     * Cada casa genera 2 de recursos.
     * @return Retorna la cantidad de recursos generados por cantidad de casas.
     */
    public int getRecursosDeLaCivilizacion(){
        return recursos_de_la_civilizacion;
    }
}
