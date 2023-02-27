/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Experimentos;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;//Para el parametro.
import java.awt.event.ItemListener;//Para el evento.
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class Arbol_binario
{
    public static void main(String args[])
    {
       Form_arbol frm=new Form_arbol();
       frm.show();
    }//main  
}//Arbol_binario
 
 
//El Nodo_unidad es para una venta de unidades, ya sean frutas, prendas, autos...
class Nodo_unidad
{
    //La variable "nombre" es la que decidirá el lado donde se guardarán los datos en uno de los ejemplos.
    private String nombre="",  descripcion="";
    //Pensaba usar la variable clave_para_el_nodo como almacend e precios, pero estudiando el codigo muy a fondo me he dado cuenta que los arboles binarios solo funcionan con claves unicas. Asi que usaré un generador de numeros aleatorios para agregar la nueva clave.
    int clave_para_el_nodo=0;
 
    public Nodo_unidad()
    {
        setNombre("");
        setDescripcion("");
        setPrecio(0);
    }//Constructor sin parametros.
 
    public Nodo_unidad(String nuevo_nombre)
    {
        setNombre(nuevo_nombre);//No colocar el argumento en su lugar me ha costado largas horas de programacion y depuracion. Bueno asi es como se adquiere la maestria en esto.
        setDescripcion("");
        setPrecio(0);
    }//Constructor con parametros, solo la propiedad nombre para las busquedas.
 
    public Nodo_unidad(String nuevo_nombre, String nueva_dascripcion, int nueva_clave_para_el_nodo)
    {
        setNombre(nuevo_nombre);
        setDescripcion(nueva_dascripcion);
        setPrecio(nueva_clave_para_el_nodo);
    }//Constructor con parametros, solo las propiedades de datos.
 
        public Nodo_unidad(String nuevo_nombre, String nueva_dascripcion, int nueva_clave_para_el_nodo, Nodo_unidad nuevo_nodo_izquierdo, Nodo_unidad nuevo_nodo_derecho)
    {
        setNombre(nuevo_nombre);
        setDescripcion(nueva_dascripcion);
        setPrecio(nueva_clave_para_el_nodo);
        setNodo_izquierdo(nuevo_nodo_izquierdo);
        setNodo_derecho(nuevo_nodo_derecho);
    }//Constructor con parametros, todas las propiedades.
 
    public void setNombre(String nuevo_nombre)
    {
        nombre=nuevo_nombre;
    }//setNombre
    public String getNombre()
    {
        return nombre;
    }//getNombre
 
    public void setDescripcion(String nueva_dascripcion)
    {
        descripcion=nueva_dascripcion;
    }//setDescripcion
    public String getDescripcion()
    {
        return descripcion;
    }//getDescripcion
 
    public void setPrecio(int nueva_clave_para_el_nodo)
    {
        clave_para_el_nodo=nueva_clave_para_el_nodo;
    }//setPrecio
    public int getPrecio()
    {
        return clave_para_el_nodo;
    }//getPrecio
 
    //Propiedades para los nodos.
    private Nodo_unidad nodo_izquierdo=null;
    public void setNodo_izquierdo(Nodo_unidad nuevo_nodo_izquierdo)
    {
        this.nodo_izquierdo=nuevo_nodo_izquierdo;
    }//setNodo_izquierdo
    public Nodo_unidad getNodo_izquierdo()
    {
        return this.nodo_izquierdo;
    }//getNodo_izquierdo
 
     private Nodo_unidad nodo_derecho=null;
    public void setNodo_derecho(Nodo_unidad nuevo_nodo_derecho)
    {
        this.nodo_derecho=nuevo_nodo_derecho;
    }//setNodo_derecho
    public Nodo_unidad getNodo_derecho()
    {
        return this.nodo_derecho;
    }//getNodo_derecho  
 
}//class Nodo_unidad
 
class Arbol_de_prendas
{
    //Nodos necesarios para el arbol.
    private Nodo_unidad raiz=null/*=new Nodo_unidad("Raiz", "Nodo raiz, no tiene valor", 1, null, null)*/, nodo_recorrido=null;
 
    public Arbol_de_prendas()
    {
        //Constructor bacio.
    }//Constructor
    String insertado="";
    public Nodo_unidad insertar_nodo_en_cualquier_lado(Nodo_unidad nueva_raiz, Nodo_unidad nuevo_nodo)
    {
        Nodo_unidad Nuevo_arbol=nueva_raiz;
        if(nueva_raiz!=null)
        {
            //Sin embargo agregando <= se permiten claves repetidas, con lo cual, el campo claves puede servir para almacenar precios.
            //Nota: El original solo tiene < o este > para comprobar datos.
            if(nueva_raiz.getNombre().length()<=nuevo_nodo.getNombre().length())//if(nueva_raiz.getPrecio()<=nuevo_nodo.getPrecio())
            {
                insertado=("derecho " + nueva_raiz.getNombre());
                //System .out.println(insertado);
                nueva_raiz.setNodo_derecho(insertar_nodo_en_cualquier_lado(nueva_raiz.getNodo_derecho(), nuevo_nodo));
            }//if
            else
            {
                //Igual los datos tienen que ser diferentes para que la busqueda de textos sea efectiva.
                if(nueva_raiz.getNombre().length()>=nuevo_nodo.getNombre().length())//if(nueva_raiz.getPrecio()>=nuevo_nodo.getPrecio())
                {
                    insertado=("Izquierdo " + nueva_raiz.getNombre());
                    //System .out.println(insertado);
                    nueva_raiz.setNodo_izquierdo(insertar_nodo_en_cualquier_lado(nueva_raiz.getNodo_izquierdo(), nuevo_nodo));
                }//if
                /*else
                {
                    //Esta aprte del condicional solo funciona si en los dos condicionales anteriores se pone <  >. En lugar de <= >=.
                    //Para este proyecto de investigacion personal no es necesario, ya que lo que yo quiero es agregar cualquier texto y que se carguen los nodos basandome en el texto.
                    //System.out.println("La clave ya Existe");
                }//else*/
            }//else
        }//if
        else
        {
            Nuevo_arbol=new Nodo_unidad(nuevo_nodo.getNombre(),nuevo_nodo.getDescripcion(),nuevo_nodo.getPrecio(),null,null);
            insertado="En la raiz " + Nuevo_arbol.getNombre();
        }//else
         //System .out.println(insertado);
        return Nuevo_arbol;
    }//insertar_nodo_en_cualquier_lado
 
    public void agregar(Nodo_unidad nuevo_nodo)
    {
        //La unica manera de que nos e me transformara en null fue haciendo "new Nodo_unidad...", ya que en la funcion "insertar_nodo_en_cualquier_lado" se convertia en null.
        this.nodo_item=null;
        if(this.buscar(nuevo_nodo)==null)
        {
        raiz=this.insertar_nodo_en_cualquier_lado(raiz,new Nodo_unidad( nuevo_nodo.getNombre(), nuevo_nodo.getDescripcion(), nuevo_nodo.getPrecio(), null, null ));
        }//if
        else
        {
            JOptionPane.showMessageDialog(null, "No puedo agregar el nodo con el nombre " + nuevo_nodo + " porque ya esta registrado." );
        }//else
    }//agregar
 
    //Se pasa un nodo como parametro para una posible herencia en la cual se implemente la busqueda por otro valor.
    //Aqui se buscará por el clave_para_el_nodo de la prenda. Tomando en cuenta que cada prenda o unidad tiene un clave_para_el_nodo diferente.
 
    public Nodo_unidad buscar(Nodo_unidad nodo_a_buscar)
    {
        this.nodo_recorrido=this.raiz;
        return this.buscar(nodo_a_buscar, nodo_recorrido);
    }//buscar
 
    //Se debe usar una variable privada o como usted quiera para captar la respuesta.
    private Nodo_unidad nodo_item=null;//Variable para almacenar el nodo encontrado en la busqueda.
    public Nodo_unidad buscar(Nodo_unidad nodo_a_buscar, Nodo_unidad nueva_raiz)
    {
        //Este algoritmo si será capaz de recorrerlo todo.
        if(nueva_raiz!=null)
        {
            this.buscar(nodo_a_buscar,nueva_raiz.getNodo_izquierdo());
            //System.out.println("Nombre buscado=" + nodo_a_buscar.getNombre());
            if(nodo_a_buscar.getNombre().equalsIgnoreCase(nueva_raiz.getNombre())==true)
            {
                //System.out.println("Encontrado " + nueva_raiz.getNombre());
                //JOptionPane.showMessageDialog(null, nueva_raiz.getNombre());
                nodo_item= nueva_raiz;//Se carga la respuesta en la varibale si se encuentra. Y no se modifica tal respuesta con las llamadas recursivas.
                return nodo_item;//Un return pero no funciona debido a las llamadas recursivas...
            }//if
            this.buscar(nodo_a_buscar,nueva_raiz.getNodo_derecho());
        }//if
        /*else
        {
        //No se usa pero por si acaso quiere implementar algo nuevo.
           // System.out.println("La raiz es null");
        }//else*/
        return nodo_item;//Se retorna la respuesta guardada en una variable private a nivel de class; ya sea que se haya encontrado o no.
    }//buscar
 
 
    //De todas las depuraciones que he realizado en esta investigacion, la de eliminar ha sido la más facil de todas.
    public Nodo_unidad eliminar_nodo(Nodo_unidad nueva_raiz ,Nodo_unidad nodo_a_buscar_para_ser_eliminado)
    {
        if(nueva_raiz!=null)
        {
            if(nodo_a_buscar_para_ser_eliminado.getNombre().length()< this.nodo_recorrido.getNombre().length())
            {
                nueva_raiz.setNodo_izquierdo(eliminar_nodo(nueva_raiz.getNodo_izquierdo(), nodo_a_buscar_para_ser_eliminado));
            }//if
            else if(nodo_a_buscar_para_ser_eliminado.getNombre().length()>this.nodo_recorrido.getNombre().length())
            {
                nueva_raiz.setNodo_derecho(eliminar_nodo(nueva_raiz.getNodo_derecho(), nodo_a_buscar_para_ser_eliminado));
            }//else if
            else
            {
                //No existe o hay dos elementos con el mismo valor.
                //Tambien para reordenar el arbol.
                Nodo_unidad nodo_local_temporal=nueva_raiz;
                if(nueva_raiz.getNodo_izquierdo()==null)
                {
                    nueva_raiz=nueva_raiz.getNodo_derecho();
                }//if
                else if(nueva_raiz.getNodo_derecho()==null)
                {
                    nueva_raiz=nueva_raiz.getNodo_izquierdo();
                }//else if
                else
                {
                    //En caso que solo elimine o reordene el izquierdo, entonces haré lo mismo con el derecho.
                    nueva_raiz.setNodo_izquierdo(this.eliminar_2_nodos(nueva_raiz.getNodo_izquierdo(), nodo_local_temporal));
                }//else
            }//else
        }//if
        raiz=nodo_recorrido;
       return raiz;
    }//eliminar_nodo
 
    //Permite reordenar el arbol cuando se elimina un nodo.
    public Nodo_unidad eliminar_2_nodos(Nodo_unidad nueva_raiz, Nodo_unidad nodo_raiz_temporal)
    {
        if(nueva_raiz.getNodo_derecho()!=null)
        {
            nueva_raiz.setNodo_derecho(this.eliminar_2_nodos(nueva_raiz.getNodo_derecho(), nodo_raiz_temporal));
        }//if
        else
        {
            nodo_raiz_temporal.setNombre(nueva_raiz.getNombre());
            nodo_raiz_temporal.setDescripcion(nueva_raiz.getDescripcion());
            nodo_raiz_temporal.setPrecio(nueva_raiz.getPrecio());
            nueva_raiz=nueva_raiz.getNodo_izquierdo();
        }//else
        return nueva_raiz;
    }//eliminar_2_nodos
 
    public String eliminar_nodo(Nodo_unidad nodo_a_eliminar)
    {
        this.nodo_recorrido=raiz;
        raiz=eliminar_nodo(nodo_recorrido, nodo_a_eliminar);
        return "Accion de eliminar ejecutada.";
    }//eliminar_nodo
 
    public boolean dos_nodos_son_iguales(Nodo_unidad nodo_1, Nodo_unidad nodo_2)
    {
        boolean respuesta=false;
        if((nodo_1==null)&& (nodo_2==null))
        {
            respuesta=true;
        }//if
        else if((nodo_1==null)||(nodo_2==null))
        {
            respuesta=false;
        }//else if
        else if(nodo_1.getPrecio()==nodo_2.getPrecio())
        {
            respuesta=this.dos_nodos_son_iguales(nodo_1.getNodo_izquierdo(), nodo_2.getNodo_izquierdo()) && this.dos_nodos_son_iguales(nodo_1.getNodo_derecho(), nodo_2.getNodo_derecho());
        }//else if
        return respuesta;
    }//dos_nodos_son_iguales
 
    private int anterior=0;
    private boolean es_el_primer_nodo=true;
    public boolean el_arbol_de_nodos_esta_ordenado(Nodo_unidad nueva_raiz)
    {
        boolean respuesta=false;
        if(nueva_raiz!=null)
        {
            respuesta=true;
        }//if
        else
        {
            respuesta=this.el_arbol_de_nodos_esta_ordenado(nueva_raiz.getNodo_izquierdo());
            if(es_el_primer_nodo==true)
            {
               this.es_el_primer_nodo=false;
            }//if
            else if(nueva_raiz.getPrecio()<anterior)
            {
                respuesta=false;
            }//else if
            if(respuesta==true)
            {
                this.anterior=nueva_raiz.getPrecio();
                respuesta=this.el_arbol_de_nodos_esta_ordenado(nueva_raiz.getNodo_derecho());
            }//if
        }//else
        return respuesta;
    }//el_arbol_de_nodos_esta_ordenado
 
    public boolean el_arbol_de_nodos_esta_ordenado()
    {
        //Se verifica si el orden es ascendente.
        this.todos_los_datos="";
        this.nodo_recorrido=this.raiz;
        return el_arbol_de_nodos_esta_ordenado(this.raiz);
    }//el_arbol_de_nodos_esta_ordenado
 
    private String todos_los_datos="";
 
    public String getTodos_los_datos(boolean obtener_datos_de_izquierda_a_derecha)
    {
        int contador=0;
        this.todos_los_datos="";
        return this.getTodos_los_datos(raiz, contador, obtener_datos_de_izquierda_a_derecha);
    }//getTodos_los_datos
 
    private String getTodos_los_datos(Nodo_unidad nueva_raiz, int contador, boolean obtener_datos_de_izquierda_a_derecha)
    {
        if(nueva_raiz!=null)
        {
           this.todos_los_datos="Nombre: " + nueva_raiz.getNombre() + "\nDescripcion\n" + nueva_raiz.getDescripcion() + "\nPrecio=" + nueva_raiz.getPrecio() + "\nEstos datos fueron encontrados en el nivel " + contador + "\n";
           if(obtener_datos_de_izquierda_a_derecha==true)
           {
               //Las llamadas recursivas empiezan por la izquierda.
                this.getTodos_los_datos(nueva_raiz.getNodo_izquierdo(), contador+1,obtener_datos_de_izquierda_a_derecha);
                this.getTodos_los_datos(nueva_raiz.getNodo_derecho(), contador+1,obtener_datos_de_izquierda_a_derecha);
           }//if
           else if(obtener_datos_de_izquierda_a_derecha==false)
           {
               //Las llamadas recursivas empiezan por la derecha.
               this.getTodos_los_datos(nueva_raiz.getNodo_derecho(), contador+1,obtener_datos_de_izquierda_a_derecha);
               this.getTodos_los_datos(nueva_raiz.getNodo_izquierdo(), contador+1,obtener_datos_de_izquierda_a_derecha);
           }//else if
        }//if
        return todos_los_datos;
    }//getTodos_los_datos
 
 
    public String getTodos_los_nodos(boolean en_pre_orden)
    {
        this.todos_los_datos="";
        this.nodo_recorrido=this.raiz;
        return this.getTodos_los_nodos(nodo_recorrido, en_pre_orden);
    }//getTodos_los_nodos
 
    public String getTodos_los_nodos_en_orden_central()
    {
        this.todos_los_datos="";
        this.nodo_recorrido=raiz;
        return this.getTodos_los_nodos_en_orden_central(nodo_recorrido);
    }//getTodos_los_nodos_en_orden_central
 
    //Lo siguiente permitirá cargar un JComboBox con datos.
    private String mNombres[], compilacion_de_nombres="";//Vector para guardar los nombres.
    public final String PREORDEN="Preorden", ORDEN_CENTRAL="Orden central", POSTORDEN="Post orden";//Constantes para el parametro de la funcion items_para_el_ComboBox.
    public String []getItems_para_el_ComboBox(String tipo_de_orden)
    {
        this.compilacion_de_nombres="";//Limpiando la variable.
        //En el siguiente bloque de condicionales se llaman a las propiedades pero no se cargan sus respuestas, solo se hace para cargar los nombres en la variable.
        if(tipo_de_orden.equalsIgnoreCase(this.PREORDEN))
        {
            this.getTodos_los_nodos(true);
        }//if
        else if(tipo_de_orden.equalsIgnoreCase(this.ORDEN_CENTRAL))
        {
            this.getTodos_los_nodos_en_orden_central();
        }//else if
        else if(tipo_de_orden.equalsIgnoreCase(this.POSTORDEN))
        {
            this.getTodos_los_nodos(false);
        }//else if
        //Se realiza un split al estilo VB6 con lo cual se carga el vector con todos los datos.
        this.mNombres=null;
        this.mNombres=this.compilacion_de_nombres.split("\n");
        System.out.println("Tamaño de la matriz " + mNombres.length);
        //System.out.println("this.mNombres=" + this.mNombres[0]);
        //Conclusiones, esta tecnica nos ha ahorrado muchas lineas de codigo repetidas. Creanlo, hubieramos tenido que reescribir de nuevo casi todo el codigo del class, teniendo asi un duplicado del codigo solo para devolver los datos para el JComboBox.
        return mNombres;
    }//getItems_para_el_ComboBox
 
    private String getTodos_los_nodos_en_orden_central(Nodo_unidad nueva_raiz)
    {
        if(nueva_raiz!=null)
        {
            this.getTodos_los_nodos_en_orden_central(nueva_raiz.getNodo_izquierdo());
            //(nueva_raiz.getNodo_izquierdo())El orden central colecta los datos entre las dos llamadas recursivas.
            this.compilacion_de_nombres+=nueva_raiz.getNombre() + "\n";//Se cargan los nombres con saltos de linea. Y asi me evito establecer el tamaño del vector cada vez que quiero agregarle datos.
            this.todos_los_datos="Nombre: " + nueva_raiz.getNombre() + "\nDescripcion\n" + nueva_raiz.getDescripcion() + "\nPrecio=" + nueva_raiz.getPrecio() + "\n";
            System.out.println("this.compilacion_de_nombres=" + this.compilacion_de_nombres);
            System.out.println("nueva_raiz.getNombre()=" + nueva_raiz.getNombre());
            this.getTodos_los_nodos_en_orden_central(nueva_raiz.getNodo_derecho());
        }//if
        else
        {
            System.out.println("La raiz es null");
        }//else
        return this.todos_los_datos;
    }//getTodos_los_nodos_en_orden_central
 
    //Funcion privada para realizar un post orden completo y correcto.
    private String invertir_matriz(String mDatos[])
    {
        String inversa="";
        for(int i=mDatos.length-1; i>=0; i--)
        {
            inversa+=mDatos[i] + "\n";
        }//for
        return inversa;
    }//invertir_matriz
 
    private String getTodos_los_nodos(Nodo_unidad nueva_raiz, boolean en_pre_orden)
    {
        if(nueva_raiz!=null)
        {
            if(en_pre_orden==true)
            {
                //Datos en preorden.
              this.compilacion_de_nombres+=nueva_raiz.getNombre() + "\n";//Se cargan los nombres con saltos de linea. Y asi me evito establecer el tamaño del vector cada vez que quiero agregarle datos.
              this.todos_los_datos="Nombre: " + nueva_raiz.getNombre() + "\nDescripcion\n" + nueva_raiz.getDescripcion() + "\nPrecio=" + nueva_raiz.getPrecio() + "\n";
              this.getTodos_los_nodos(nueva_raiz.getNodo_izquierdo(), en_pre_orden);
              this.getTodos_los_nodos(nueva_raiz.getNodo_derecho(), en_pre_orden);
            }//if
            else if(en_pre_orden==false)
            {
                String mLocal_postorden[];
                //Compilando datos.
                this.todos_los_datos+="Nombre: " + nueva_raiz.getNombre() + "\nDescripcion\n" + nueva_raiz.getDescripcion() + "\nPrecio=" + nueva_raiz.getPrecio() + "end_postorden";
                this.compilacion_de_nombres+=nueva_raiz.getNombre() + "\n";//Se cargan los nombres con saltos de linea. Y asi me evito establecer el tamaño del vector cada vez que quiero agregarle datos.
                //Datos en postorden.
              this.getTodos_los_nodos(nueva_raiz.getNodo_izquierdo(), en_pre_orden);
              this.getTodos_los_nodos(nueva_raiz.getNodo_derecho(), en_pre_orden);
              //Como ya se ve, aqui hay un problema. El post orden solo carga un dato, despues de todas las llamadas recursivas. Tan solo se cargará la informacion de la ultima llamada recursiva.
              //Se puede arreglar cargando una variable con toda la informacion, luego pasandola a un vector y despues volviendola a pasar a la variable pero en el orden inverso y despues de nuevo al vector y asi quedaria a como visualizo yo el post orden.
              //De esta manera se realiza un post orden correcto.
             System.out.println(compilacion_de_nombres);
              mLocal_postorden=this.todos_los_datos.split("end_postorden");
              todos_los_datos=this.invertir_matriz(mLocal_postorden);
              mLocal_postorden=compilacion_de_nombres.split("\n");
              compilacion_de_nombres=this.invertir_matriz(mLocal_postorden);
            }//if                
        }//if
        return this.todos_los_datos;
    }//getTodos_los_nodos_en_pre_orden
 
    private int getCantidad_de_nodos_hojas(Nodo_unidad nueva_raiz)
    {
        int respuesta=0;
        if(nueva_raiz!=null)
        {
            if((nueva_raiz.getNodo_izquierdo()==null) && (nueva_raiz.getNodo_derecho()==null))
            {
               respuesta=1;
            }//if
            else
            {
                respuesta=this.getCantidad_de_nodos_hojas(nueva_raiz.getNodo_izquierdo()) + this.getCantidad_de_nodos_hojas(nueva_raiz.getNodo_derecho());
            }//else
        }//if
        return respuesta;
    }//cantidad_de_nodos_hojas
 
    public int getCantidad_de_nodos_hojas()
    {
        this.nodo_recorrido=this.raiz;
        return this.getCantidad_de_nodos_hojas(nodo_recorrido);
    }//getCantidad_de_nodos_hojas
 
    //Implementacion de la interfaz TAD.
    private class TAD_arbol implements TAD
    {
        //Este class permitira que se realicen sumas de los precios.
        private Nodo_unidad raiz_tad=null;
 
        public TAD_arbol()
        {
            //Constructor bacio.
        }//Constructor sin argumentos.
 
        public TAD_arbol(Nodo_unidad nueva_raiz)
        {
            this.setRaiz(nueva_raiz);
        }//Constructor sin argumentos.
 
        @Override
        public void crear_nodo()
        {
            this.raiz_tad=new Nodo_unidad();
        }//crear_nodo
 
        @Override
        public int getValor()
        {
            int respuesta=0;
            if(this.raiz_tad!=null)
            {
                respuesta=this.raiz_tad.getPrecio();
            }//if
            return respuesta;
        }//getValor
        @Override
        public void setValor(int nuevo_valor)
        {
            //setValor no se usará directamente pero igual lo dejaré.
            //Sin embargo como el nodo tiene 3 campos entonces la clave debe ser un objeto nodo que actualice los 3 campos.
            if(this.raiz_tad!=null)
            {
                //Por ahora solo se actualizará el valor pero en futuras implementaciones se actualizaran todos los datos.
                this.raiz_tad.setPrecio(nuevo_valor);
            }//if
        }//setValor
 
        private Nodo_unidad recorrido_tad=null;
 
        @Override
        public Nodo_unidad getNodo_izquierdo()
        {
            if(this.raiz_tad!=null)
            {
                this.recorrido_tad=this.raiz_tad.getNodo_izquierdo();
            }//if
            return this.recorrido_tad;
        }//getNodo_izquierdo
        @Override
        public void setNodo_izquierdo(Nodo_unidad nueva_raiz_asignada)
        {
            if(this.raiz_tad!=null)
            {
               raiz_tad.setNodo_izquierdo(nueva_raiz_asignada);
            }//if
            else
            {
                //El arbol esta bacio.
            }//else
        }//setNodo_izquierdo
 
        @Override
        public Nodo_unidad getNodo_derecho()
        {
            if(this.raiz_tad!=null)
            {
                this.recorrido_tad=this.raiz_tad.getNodo_derecho();
            }//if
            return this.recorrido_tad;
        }//getNodo_derecho
        @Override
        public void setNodo_derecho(Nodo_unidad nueva_raiz_asignada)
        {
            if(this.raiz_tad!=null)
            {
               raiz_tad.setNodo_izquierdo(nueva_raiz_asignada);
            }//if
            else
            {
                //El arbol esta bacio.
            }//else
        }//setNodo_derecho
 
        @Override
        public void setRaiz(Nodo_unidad nueva_raiz)
        {
            this.raiz_tad=nueva_raiz;
        }//setReferencia
 
        @Override
        public Nodo_unidad getRaiz()
        {
            return this.raiz_tad;
        }//getRaiz
 
        @Override
        public void anular_arbol()
        {
            this.raiz_tad=null;
        }//anular_arbol
 
        @Override
        public boolean el_arbol_es_nulo()
        {
            return this.raiz_tad==null;
        }//el_arbol_es_nulo
 
        @Override
        public boolean es_igual(Nodo_unidad otra_raíz)
        {
            return this.raiz_tad==otra_raíz;
        }//es_igual
    }//clase interna TAD_arbol
    //Una vez finalizada la implementacion, procedo a crear una funcion que sume los valores.
 
    private int sumar_precios(TAD_arbol nuevo_tad_arbol)
    {
        int respuesta=0;
        TAD_arbol tad_izquierdo=new TAD_arbol(), tad_derecho=new TAD_arbol();
        if(!nuevo_tad_arbol.el_arbol_es_nulo())
        {
            tad_izquierdo.setRaiz(nuevo_tad_arbol.getNodo_izquierdo());
            tad_derecho.setRaiz(nuevo_tad_arbol.getNodo_derecho());
            respuesta=nuevo_tad_arbol.getValor() + this.sumar_precios(tad_izquierdo)+this.sumar_precios(tad_derecho);
        }//if
        return respuesta;
    }//sumar_precios
    public int sumar_precios()
    {
        TAD_arbol tad=new TAD_arbol(this.raiz);//Se pasa la raiz del arbol en el argumento del cosntructor.
        return this.sumar_precios(tad);//Y de esta manera se lográ la suma.
    }//sumar_precios
 
    //Lo siguiente es un extra por si se quiere crear un bosque de arboles; para ser más expecifico, una enredadera como las matas de chayote, ayote...
    //Para lo cual se tendrá que crear un nuevo arbol de nodos.
    //Esto permitiría tener varios formularios con datos y si una informacion buscada no se encunetra en un arbol, entonces buscarlo en otro o en todos.
    private String nombre_del_arbol="";
    public void setNombre_del_arbol(String nuevo_nombre)
    {
        this.nombre_del_arbol=nuevo_nombre;
    }//setNombre_del_arbol
    public String getNombre_del_arbol()
    {
        return this.nombre_del_arbol;
    }//getNombre_del_arbol
}//class Arbol_de_prendas
 
//Creando una interfaz para un TAD. El cual se usará dentro de los arboles.
interface TAD
{
    //No se declaran variables en una interface porque terminan siendo objetos final (Constantes).
    //Sin embargo si es util si lo que se desea es declarar constantes.
   public void crear_nodo();//Crea un nodo en el arbol que lo llame.
   public int getValor();//Devuelve algun valor, ya sea una clave, precio o numero.
   public Nodo_unidad getRaiz();//Devuelve la raiz del arbol.
   public Nodo_unidad getNodo_izquierdo();//Devuelve el nodo izquierdo.
   public Nodo_unidad getNodo_derecho();//Devuelve el nodo derecho.
   public void setValor(int nuevo_valor);//Pone algun valor numerico.
   public void setRaiz(Nodo_unidad nueva_raiz);//Hace que el arbol o raiz apunte a nueva raiz.
   public void setNodo_izquierdo(Nodo_unidad nueva_raiz_asignada);//Hace que el nodo izquierdo apunte al arbol asignado. nueva_raiz_asignada
   public void setNodo_derecho(Nodo_unidad nueva_raiz_asignada);//Hace que el nodo derecho apunte al arbol asignado. nueva_raiz_asignada
   public void anular_arbol();//Hace que el arbol(raíz) tome el valor nulo y me imagino que el resto del arbol desaparese.
   public boolean el_arbol_es_nulo();//Verifica si el arbol esta en null.
   public boolean es_igual(Nodo_unidad otra_raíz);//Verifica si la raíz local es igual a otra raíz. O arbol.
   //y esta fue toda la interfaz del TAD con siertas modificasiones para hacerlo a mi modo.
   //La interface será implementada dentro de cada class arbol.
}//interface TAD
 
//Ahora crearé un form para probar mi arbolito de datos, si resulta bien procederé a crear varios forms con diferentes temas.
//Si resulta entonces, crearé un class Bosque para acumular toda la informacion en un arbol que contenga todos los arboles.
//Luego procederé a crear un form para buscar informacion.
//Entonces, veré si lo que si funciona en mi imaginacion tambien, funciona en el software.
@SuppressWarnings("serial")
class Form_arbol extends JFrame implements ActionListener, ItemListener
{
    private Arbol_de_prendas arbol_tienda=new Arbol_de_prendas();
    private Nodo_unidad un_nodo=new Nodo_unidad();//mejor lo inicializo para evitar errores con los nulos.
    private JLabel jlNombre=new JLabel("Nombre"), jlDescripcion=new JLabel("Descripcion"), jlPrecio=new JLabel("Precio");//No es necesaria esta etiqueta: jlBusqueda=new JLabel("Busqueda"). Puesto que lo que se quieré es mostrar el JComboBox por medio del menu desplegable y al mismo tiempo desapareser el campo jtNombre y una ves que se haya hecho click en un item entonces, desapareser el JComboBox y reapareser el JTextField. 
    private JComboBox <String>jcbBusqueda=new JComboBox<>();//La plantilla <String> hace que todos los datos que le entren al JComboBox solo sean del tipo String.
    private JTextField jtNombre=new JTextField(), jtPrecio=new JTextField();
    private JTextArea jtaDescripcion=new JTextArea();
    private JScrollPane jspDescripcion=null;//new JScrollPane();
    private JMenuBar jBarra=new JMenuBar();
    private JMenu jmArchivo=new JMenu("Archivo"), jmAcciones=new JMenu("Acciones"), jmVer=new JMenu("Ver");
    private JMenuItem jmiSalir=new JMenuItem("Salir"), jmiAgregar=new JMenuItem("Agregar"), jmiPostorden=new JMenuItem("Post orden"), jmiOrden_central=new JMenuItem("Orden central"), jmiPreorden=new JMenuItem("Pre orden");
    private JMenuItem jmiLimpiar_campos=new JMenuItem("Limpiar campos"), jmiEliminar=new JMenuItem("Eliminar"), jmiCantidad_de_nodos_hojas=new JMenuItem("Cantidad de nodos hojas"), jmiSumar_valores=new JMenuItem("Sumar valores");
    private JCheckBoxMenuItem jmiBuscar=new JCheckBoxMenuItem("Buscar");
    private Container contenedor= null;
    private Font fuente;
 
    private void iniciando()
    {
        this.setSize(270,400);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(this);
        //Estableciendo los tamaños.
        jlNombre.setBounds(5, 5, 100, 25);
        jtNombre.setBounds(50, 5, 200, 25);
        jlPrecio.setBounds(5, 90, 200, 25);
        jtPrecio.setBounds(50, 90, 200, 25);
        jlDescripcion.setBounds(5, 115, 100, 25);
        jtaDescripcion.setBounds(5, 140, 250, 200);
        //Se establese el JComboBox de busqueda a falso y se coloca en la misma posicion que el JTextField.
        jcbBusqueda.setVisible(false);
        jcbBusqueda.setBounds(50, 5, 200, 25);
        //Agregando controles al form.
        //No se usará un control personalizado JPanel porque, no se esta trabajando con varios forms.
        contenedor=getContentPane();//Se inicializa el contenedor con el contenedor del form. No es necesario pero lo hago para mostrar una forma alternativa de agregar los controles. La forma practica es de forma directa getContentPane().add(control).
        contenedor.add(jlNombre);
        contenedor.add(jtNombre);
        contenedor.add(jlDescripcion);
        jspDescripcion=new JScrollPane(jtaDescripcion);//Agregando el control JTextArea al control JScrollPane.
        jspDescripcion.setBounds(5, 140, 250, 200);
        contenedor.add(jspDescripcion);
        contenedor.add(jcbBusqueda);
        contenedor.add(this.jlPrecio);
        contenedor.add(this.jtPrecio);
        //Agregando cada menu a la barra de menu.
        jBarra.add(jmArchivo);
        jBarra.add(jmVer);
        jBarra.add(jmAcciones);
        //Agregando cada submenu a cada menu.
        jmArchivo.add(this.jmiAgregar);
        jmArchivo.addSeparator();
        jmArchivo.add(jmiSalir);
        jmVer.add(this.jmiPreorden);
        jmVer.add(this.jmiOrden_central);
        jmVer.add(this.jmiPostorden);
        jmVer.addSeparator();
        jmVer.add(this.jmiCantidad_de_nodos_hojas);
        jmAcciones.add(this.jmiLimpiar_campos);
        jmAcciones.add(this.jmiBuscar);
        jmAcciones.add(this.jmiSumar_valores);
        jmAcciones.addSeparator();
        jmAcciones.add(this.jmiEliminar);
        //Agregando la barra de menu al form.
        this.setJMenuBar(jBarra);
        //Agregando el controlador de eventos a cada control.
        this.jmiAgregar.addActionListener(this);
        this.jmiBuscar.addActionListener(this);
        this.jmiLimpiar_campos.addActionListener(this);
        this.jmiPreorden.addActionListener(this);
        this.jmiOrden_central.addActionListener(this);
        this.jmiPostorden.addActionListener(this);
        this.jmiCantidad_de_nodos_hojas.addActionListener(this);
        this.jmiEliminar.addActionListener(this);
        this.jmiSalir.addActionListener(this);
        this.jcbBusqueda.addItemListener(this);
        this.jmiSumar_valores.addActionListener(this);
        //Estableciendo la fuente(El tamaño del texto).
        fuente=new Font("Tahoma", Font.BOLD, 12);
        this.jtNombre.setFont(this.fuente);
        this.jtaDescripcion.setFont(this.fuente);
        this.jtPrecio.setFont(this.fuente);
        this.jcbBusqueda.setFont(this.fuente);
    }//iniciando
 
    public Form_arbol()
    {
        super("Arbol");
        this.iniciando();
            //Datos de prueba.
           this.un_nodo=new Nodo_unidad("Algoritmos", "Soy fanatico de los algoritmos representados en lenguaje de programacion.",90, null, null);
           this.arbol_tienda.agregar(un_nodo);
           this.un_nodo=new Nodo_unidad("Arboles", "Los arboles son como el internet biologico del planeta.",800, null, null);
           this.arbol_tienda.agregar(un_nodo);
           this.un_nodo=new Nodo_unidad("Perruno Bebe", "Mi perro es raza Labrador.\nTiene unos 8 años.\nEs color negro.\nEs muy lindo, muy educado, chineado.\nHace que mis tristesas desaparescan.",8, null, null);
           this.arbol_tienda.agregar(un_nodo);
           this.un_nodo=new Nodo_unidad("Rafael", "Mi nombre completo es Rafael Angel Montero Fernández.\nTengo 40 años.\nDurante 15 años usé Visual Basic 6.0 y a la vez aprendí mucho de programacion.\nAhora uso java.",40, null, null);
           this.arbol_tienda.agregar(un_nodo);
           this.un_nodo=new Nodo_unidad("Tema favorito", "Inteligencia artificial.",100, null, null);
           this.arbol_tienda.agregar(un_nodo);
    }//Constructor
 
    public void click_cantidad_de_nodos_hoja(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase(this.jmiCantidad_de_nodos_hojas.getText()))
       {
          JOptionPane.showMessageDialog(null, this.arbol_tienda.getCantidad_de_nodos_hojas() , "Cantidad de nodos hojas", 1);
       }//if
    }//click_cantidad_de_nodos_hoja
 
    public void click_sumar_valores(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase(this.jmiSumar_valores.getText()))
       {
          JOptionPane.showMessageDialog(null,"Suma de todos los valores " +  this.arbol_tienda.sumar_precios());
       }//if
    }//click_sumar_valores
 
    public void click_preorden(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase(this.jmiPreorden.getText()))
       {
          llenar_jcombobox(this.arbol_tienda.getItems_para_el_ComboBox(arbol_tienda.PREORDEN));
       }//if
    }//click_preorden
 
    public void click_postorden(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase(this.jmiPostorden.getText()))
       {
           llenar_jcombobox(this.arbol_tienda.getItems_para_el_ComboBox(arbol_tienda.POSTORDEN));
       }//if
    }//click_postorden
 
    public void click_buscar(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase(this.jmiBuscar.getText()))
       {
           if(jmiBuscar.isSelected()==true)
           {
                this.jtNombre.setVisible(false);
                this.jcbBusqueda.setVisible(true);
                jmiBuscar.setSelected(true);
                //Va aquí para cargar el JComboBox, y solo si el menu es true.
                //Ya que si elimina un nodo, debe volver a actualizar la lista. No se como decirlo porque no observé vastante el fenomeno antes de corregirlo, fue corregido rapidamente.
                //Me sucedia una recursividad infinita, asi que tenia dos opciones. 1)Hacer visible el JComboBox y luego ejecutar una de las cargas. 2)Hacer visible el JComboBox y cargarlo al mismo tiempo, pero solo si el menu es true.
                //Finalmente, analizando, las siguientes 3 lineas de codigo se ejecutaban, ya fuera true o false, causando el bucle infinito. Pero tambien, que cuando se carga el JComboBox, inmediatamente sin que uno lo haga, se selecciona en forma oculta el primer item. Enotnces se ejecutaba la busqueda, causando la recursividad infinita.
                //Ya todo fue depurado, puede confiar en este codigo, y tiene toda la livertad para mejorarlo.
                //Esto "ActionEvent.ACTION_PERFORMED" le dice al evento que es del tipo actionPerformed. Asi es como se crea un evento personalizado.
                ActionEvent evento_local=new ActionEvent(this.jmiOrden_central,ActionEvent.ACTION_PERFORMED,this.jmiOrden_central.getText());
                evento_local.setSource(this.jmiOrden_central);
                click_orden_central(evento_local);
            }//if
           else
           {
               this.jcbBusqueda.setVisible(false);
               this.jtNombre.setVisible(true);
               jmiBuscar.setSelected(false);
           }//else if
        }//if 
    }//click_buscar    
 
    public void click_orden_central(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase("Orden central"))
       {
           llenar_jcombobox(this.arbol_tienda.getItems_para_el_ComboBox(arbol_tienda.ORDEN_CENTRAL));
       }//if
    }//click_orden_central
 
    private void limpiar_campos()
    {
        this.jtNombre.setText("");
        this.jtaDescripcion.setText("");
        this.jtPrecio.setText("0");
    }//limpiar_campos
 
    public void click_limpiar_campos(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase("Limpiar campos"))
       {
           this.limpiar_campos();
       }//if
    }//click_limpiar_campos
 
    public void click_Eliminar(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase("Eliminar"))
       {
           this.un_nodo=new Nodo_unidad(this.jcbBusqueda.getSelectedItem().toString());
           this.arbol_tienda.eliminar_nodo(un_nodo);
       }//if
    }//click_Eliminar
 
    public void click_agregar(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase("Agregar"))
       {
           this.un_nodo=new Nodo_unidad(this.jtNombre.getText(), this.jtaDescripcion.getText(),Integer.parseInt( this.jtPrecio.getText()), null, null);
           //System.out.println(un_nodo.getNombre());
           this.arbol_tienda.agregar(un_nodo);
           this.limpiar_campos();
       }//if
    }//Salir
 
    public void click_salir(ActionEvent evt)
    {
       if(evt.getActionCommand().equalsIgnoreCase("Salir"))
       {
           System.exit(0);
       }//if
    }//Salir
 
    @Override
    public void actionPerformed(ActionEvent evt)
    {
       this.click_cantidad_de_nodos_hoja(evt);
       this.click_limpiar_campos(evt);
       this.click_agregar(evt);
       this.click_buscar(evt);
       this.click_preorden(evt);
       this.click_orden_central(evt);
       this.click_postorden(evt);
       this.click_Eliminar(evt);
       this.click_salir(evt);
       this.click_sumar_valores(evt);
    }//actionPerformed
 
    @Override
    public void itemStateChanged(ItemEvent evt)
    {
        click_item(evt);
    }//itemStateChanged
 
    public void click_item(ItemEvent evt)
    {
        //Codigo de busqueda.
        try
        {
            //System.out.println("Item " + this.jcbBusqueda.getSelectedItem().toString());
            this.un_nodo=new Nodo_unidad(this.jcbBusqueda.getSelectedItem().toString());
            //System.out.println("Se buscará " + un_nodo.getNombre());
            //Condicional, porque puede que los datos no existan o no sean encontrados.
            if(un_nodo!=null)
            {
                un_nodo=this.arbol_tienda.buscar(un_nodo);
                System.out.println("Se ha encontrado " + un_nodo.getNombre());
                this.jtNombre.setText("" + un_nodo.getNombre());
                this.jtaDescripcion.setText("" + un_nodo.getDescripcion());
                this.jtPrecio.setText("" + un_nodo.getPrecio());//Forma más efectiva y practica de convertir un numero en texto.
            }//if
 
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }//catch
    }//click_item
 
    //La nomenclatura m corresponde tanto a vector como a matriz. Porque para mi son lo mismo.
    private void llenar_jcombobox(String mNuevo_vector[])
    {
        this.jcbBusqueda.removeAllItems();//Esperando que remueva todos los items. A pura intuicion.
        //Aqui mi error fue "(int i=0; i<=mNuevo_vector.length; i++)" para ser más expecifico: mNuevo_vector.length.
        //Se debe poner asi: mNuevo_vector.length-1.
        //No vallan a confiar en: i<mNuevo_vector.length. No siempre funciona, es engañoso y con frecuencia se pasa.
        for(int i=0; i<=mNuevo_vector.length-1; i++)
        {
            //System.out.println("Llenando JComboBox " + mNuevo_vector[i]);
            this.jcbBusqueda.addItem(mNuevo_vector[i]);
        }//for
    }//llenar_jcombobox
 
    //Esta propiedad permitirá crear un bosque.
    public Arbol_de_prendas getArbol()
    {
        return this.arbol_tienda;
    }//getArbol
}//class Form_arbol 
//Para crear el class Bosque, es el mismo codigo que el class Arbol_de_prendas.
//Bueno casi el mismo, porque le voy a quitar un monton de funcio
