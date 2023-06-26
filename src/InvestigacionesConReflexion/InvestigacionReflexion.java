/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InvestigacionesConReflexion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Element;

/**
 * Es parte de una investigacion para crear asistentes y para crear Annotations.
 * Ademas permite profundizas en el lenguaje Java con uso de reflexion.
 * Si uno de los metodos es llamado con invoke entonces los datos cargados en el metodo y en el class en si se reflejan para
 * la instancia que se inicializa en este caso, el codigo de reflexion se ejecuta en el constructor.
 * Con lo cual hace efecto para la instancia en si.
 * En una investigacion más profunda.
 * El codigo podria ir en un metodo static y tambien podria ir en una metodo de otro class.
 * @author Jugador
 * 
 */
@Angel(nombre="Yo")
public class InvestigacionReflexion {
private int varaible1;
    
    /**
     * Se ve como un metodo y no como una propiedad.
     * @param nuevo 
     */
    public void set(int nuevo){
        System.out.println("Invocado set "+nuevo);
        varaible1=nuevo;
    }
    /**
     * Se ve como un metodo y no como una propiedad.
     * @return 
     */
    public int get(){
        System.out.println("Invocado get "+varaible1);
        return varaible1;
    }
    
    
    /**
     * Se toma como un campo o field.
     * Es una variable publica y el compilador si lo ve como una autentica propiedad.
     * 
     */
    @campo
    public double numeroDoble=1.1;
    
    public InvestigacionReflexion(){
        System.out.println("Metodos="+getClass().getMethods().length);
        for(int i=0; i<getClass().getMethods().length; i++){
            System.out.println("Metodo nombre = " +getClass().getMethods()[i].getName());
            
        }
        
        System.out.println("Fields="+getClass().getFields().length);
        for(int i=0; i<getClass().getFields().length; i++){
            System.out.println("Field nombre = "+getClass().getFields()[i].getName());
        }
        invocar();
       comprobarAnotaciones();
    }
    
    private void invocar(){
        System.out.println("\nInvocando\n");
         try {
            getClass().getMethods()[1].invoke(this, 22);
            getClass().getMethods()[0].invoke(this);
            System.out.println("Tipo de datos del metodo es " + getClass().getMethods()[0].getReturnType());
            System.out.println("Tipo de datos del field es " + getClass().getFields()[0].getType());
            System.out.println("Valor del field " + getClass().getFields()[0].getName() +" es " + getClass().getFields()[0].get(this));
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InvestigacionReflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(InvestigacionReflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(InvestigacionReflexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * La forma en como se invoca para un campo o field es la misma para un class o para un metodo.
     * Solo tiene algunas variaciones.
     */
    private void comprobarAnotaciones(){
        if(this.getClass().getFields()[0].isAnnotationPresent(campo.class)==true){
            System.out.println("Si existe una anotacion, su valor " + campo.class.getMethods()[0].getDefaultValue());
            this.numeroDoble=Double.parseDouble(campo.class.getMethods()[0].getDefaultValue().toString());
        }else{
             System.out.println("No existe una anotacion.");
        }
    }
}

@Documented //Hace que salga en JavaDoc.
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface campo{ 
    int valor() default 45;
}

@Documented //Hace que salga en JavaDoc.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Angel{
    String nombre()default "Angel";
    
}