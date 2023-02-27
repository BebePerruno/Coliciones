/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Risk3;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

/**
 *
 * @author Rafael Angel MF
 * 
 */
public class FrmEscenario extends javax.swing.JFrame {
    /**
     * Permite saber en que posicion numerica esta la seleccion.
     */
    private int posicion_numerica_en_seleccion=0;
    
    private void trasladarse_al_territorio_propio(){//(int f, int c, int f_mover, int c_mover){
        deInterfazGraficaHaciaMatriz();
        int soladosTanques=-1;
        int []m=comprovarPosicionDeSeleecion();
        soladosTanques=JOptionPane.showConfirmDialog(null, "Desea enviar soldados, en caso de no agregar soldados entonces se agregaran tanques.", "Hola", JOptionPane.YES_NO_OPTION);
        if(soladosTanques==0){
        String s=JOptionPane.showInputDialog("¿Cuantos soldados deseas enviar?");
        int vCantidad=0;
        
        try{
           vCantidad=Integer.parseInt(s);
           mapa[m[0]][m[1]]= mapa[m[2]][m[3]].entrar_a_este_territorio(mapa[m[0]][m[1]], true, false, vCantidad, FACCION_USUARIO);

        }catch(Exception e){
            return;
        }
    }
    else if(soladosTanques==1){
        String s=JOptionPane.showInputDialog("¿Cuantos tanques deseas enviar?");
        int vCantidad=0;
        try{
            vCantidad=Integer.parseInt(s);
           mapa[m[0]][m[1]]= mapa[m[2]][m[3]].entrar_a_este_territorio(mapa[m[0]][m[1]], false, true, vCantidad, FACCION_USUARIO);

        }catch(Exception e){
            return;
        }
    }
    deMatrizHaciaInterfazGrafica();    
}
    
    private final String FACCION_USUARIO="Angel";
    private final String FACCION_oponente="Oponente";
    
    
    
    private String territoriosConquistados(){
        String informe="Coordenadas de territorios conquistados\n";
        for(int f=0; f<mapa.length;++f){
            for(int c=0; c<mapa.length;++c){
                if(mapa[f][c].getFaccion().equalsIgnoreCase(FACCION_USUARIO)){
                    informe+=f+":"+c + ";";
                }
            }
        }
        return informe;
    }
    
    /**
     * Genera recursos sin importar la faccion.
     */
    private void generarRecursos(){
        mapa[0][0].generarRecursos();
        mapa[0][1].generarRecursos();
        mapa[1][0].generarRecursos();
        mapa[1][1].generarRecursos();
    }
    
    private final FrmMenuTerritorio fEveMenu=new FrmMenuTerritorio();
    
    private class EventosDelMenu implements ActionListener {
        private final int PRECIO_DEL_SOLDADO=10;
        private final int PRECIO_DEL_TANQUE=20;
        private final int PRECIO_DE_LA_CASA=4;
        
        /**
         * Este metodo se creó con la intencion de reducir el codigo repetido.
         * @param f un valor numerico de cero hasta el maximo de la matriz.
         * @param c un valor numerico de cero hasta el maximo de la matriz.
         */
        public void crearCasa(int f, int c){
            if(mapa[f][c].getSeleccionado()==true && mapa[f][c].getFaccion().equalsIgnoreCase(FACCION_USUARIO)==true){
                if(mapa[f][c].getRecursosDeLaCivilizacion()>=PRECIO_DE_LA_CASA){
                    mapa[f][c].restarRecursos(PRECIO_DE_LA_CASA);
                    mapa[f][c].setCasas(mapa[f][c].getCasas()+1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Intentaré convertir 4 soldados en una casa.\nEspero que existan suficientes soldados.");
                    mapa[f][c].convertir4SoldadosEnUnaCasa();
                }
            }
        }
        
        /**
         * Este metodo se creó con la intencion de reducir el codigo repetido.
         * @param f un valor numerico de cero hasta el maximo de la matriz.
         * @param c 
         */
        private void crearTanque(int f, int c){
            if(mapa[f][c].getSeleccionado()==true && mapa[f][c].getFaccion().equalsIgnoreCase(FACCION_USUARIO)==true){
                if(mapa[f][c].getRecursosDeLaCivilizacion()>=PRECIO_DEL_TANQUE){
                    mapa[f][c].restarRecursos(PRECIO_DEL_TANQUE);
                    mapa[f][c].setTanques(mapa[f][c].getTanques()+1);
                }
                else{
                    //No esta seleccionado y no es de la faccion del usuario.
                }
            }
        }
        
        /**
         * Este metodo se creó con la intencion de reducir el codigo repetido.
         * @param f un valor numerico de cero hasta el maximo de la matriz.
         * @param c un valor numerico de cero hasta el maximo de la matriz.
         */
        private void crearSoldado(int f, int c){
            if(mapa[f][c].getSeleccionado()==true && mapa[f][c].getFaccion().equalsIgnoreCase(FACCION_USUARIO)==true){
                if(mapa[f][c].getRecursosDeLaCivilizacion()>=PRECIO_DEL_SOLDADO){
                    mapa[f][c].restarRecursos(PRECIO_DEL_SOLDADO);
                    mapa[f][c].setSoldados(mapa[f][c].getSoldados()+1);
                }
                else{
                    //No esta seleccionado y no es de la faccion del usuario.
                }
            }
        }
        
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(posicion_numerica_en_seleccion<=2){
                
                deInterfazGraficaHaciaMatriz();

                generarRecursos();
                fEveMenu.enableColinizar(posicion_numerica_en_seleccion==2);
                fEveMenu.enableCrear(posicion_numerica_en_seleccion==1);
                fEveMenu.enableTrasladarse(posicion_numerica_en_seleccion==2);
                final String BTN_ACCIONES="Acciones";

                if(evt.getActionCommand().equalsIgnoreCase(BTN_ACCIONES)){
                    fEveMenu.setVisible(true);
                }

                if(evt.getActionCommand().equalsIgnoreCase(fEveMenu.getEtiquetaTrasladarse())){
                    trasladarse_al_territorio_propio();
                    fEveMenu.dispose();
                    desactivarChks();
                }

                if(evt.getActionCommand().equalsIgnoreCase(fEveMenu.getEtiquetaColonizar())){
                    int []m=comprovarPosicionDeSeleecion();
    //       revisar este condicional         if(mapa[m[0]][m[1]].getFaccion().equalsIgnoreCase(mapa[m[2]][m[3]].getFaccion())==false){
                        usuarioInvade();
                        fEveMenu.dispose();
                        desactivarChks();
    //                }
                }
                if(evt.getActionCommand().equalsIgnoreCase(fEveMenu.getEtiquetaCrearSoldado())){
                    crearSoldado(0,0);
                    crearSoldado(1,0);
                    crearSoldado(0,1);
                    crearSoldado(1,1);
                    fEveMenu.dispose();
                    desactivarChks();
                }
                if(evt.getActionCommand().equalsIgnoreCase(fEveMenu.getEtiquetaCrearTanque())){
                    crearTanque(0,0);
                    crearTanque(1,0);
                    crearTanque(0,1);
                    crearTanque(1,1);
                    fEveMenu.dispose();
                    desactivarChks();
                }
                if(evt.getActionCommand().equalsIgnoreCase(fEveMenu.getEtiquetaCrearCasa())){
                    crearCasa(0,0);
                    crearCasa(1,0);
                    crearCasa(0,1);
                    crearCasa(1,1);
                    fEveMenu.dispose();
                    desactivarChks();
                }

                deMatrizHaciaInterfazGrafica();
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo puede seleccionar 2 mapas a la vez.");
                desactivarChks();
            }
        } // end evento
    }
    
    private void desactivarChks(){
        //Desactivar la seleccion obliga al usuario a vovler a activar las casillas.
        this.deInterfazGraficaHaciaMatriz();
        mapa[0][0].setSeleccionado(false);
        mapa[1][0].setSeleccionado(false);
        mapa[0][1].setSeleccionado(false);
        mapa[1][1].setSeleccionado(false);
        posicion_numerica_en_seleccion=0;
        this.deMatrizHaciaInterfazGrafica();
    }
    
    /**
     * 2 territorios seleccionados indica una accion de colonizacion.
     * 
     */
    private String territoriosSeleccionados="";
    
    
    
    /**
     * 
     * @return Retorna una matriz con 4 items, los primeros 2 son del primer territorio seleccionado.
     * Los segundos dos items son del segundo territorio selecccionado.
     * Este codigo no se puede simplificar más porque es igual a decir: La negacion de la negacion de A es igual a A.
     * A''==A.
     * O sea que se vuelve al problema que se quizó solucionar aquí.
     */
    private int [] comprovarPosicionDeSeleecion(){
        this.deInterfazGraficaHaciaMatriz();
        int m[]=new int[4];
        //Territorio 00
        if( mapa[0][0].getPrimeroEnSeleccionarse()==1 && mapa[0][0].getSeleccionado()==true){
            if( mapa[1][0].getPrimeroEnSeleccionarse()==2&& mapa[1][0].getSeleccionado()==true){
                m[0]=0;
                m[1]=0;
                m[2]=1;
                m[3]=0;
                System.out.println("De 00 a 10");
            }
            if( mapa[0][1].getPrimeroEnSeleccionarse()==2&& mapa[0][1].getSeleccionado()==true){
                m[0]=0;
                m[1]=0;
                m[2]=0;
                m[3]=1;
                System.out.println("De 00 a 01");
            }
            if( mapa[1][1].getPrimeroEnSeleccionarse()==2&& mapa[1][1].getSeleccionado()==true){
                m[0]=0;
                m[1]=0;
                m[2]=1;
                m[3]=1;
                System.out.println("De 00 a 11");
            }
        }
        
        //Territorio 10
        if( mapa[1][0].getPrimeroEnSeleccionarse()==1&& mapa[1][0].getSeleccionado()==true){
            if( mapa[0][0].getPrimeroEnSeleccionarse()==2&& mapa[0][0].getSeleccionado()==true){
                m[0]=1;
                m[1]=0;
                m[2]=0;
                m[3]=0;
                System.out.println("De 10 a 00");
            }
            if( mapa[0][1].getPrimeroEnSeleccionarse()==2&& mapa[0][1].getSeleccionado()==true){
                m[0]=1;
                m[1]=0;
                m[2]=0;
                m[3]=1;
                System.out.println("De 10 a 01");
            }
            if( mapa[1][1].getPrimeroEnSeleccionarse()==2&& mapa[1][1].getSeleccionado()==true){
                m[0]=1;
                m[1]=0;
                m[2]=1;
                m[3]=1;
                System.out.println("De 10 a 11");
            }
        }
        //Territorio 01
        if( mapa[0][1].getPrimeroEnSeleccionarse()==1&& mapa[0][1].getSeleccionado()==true){
            if( mapa[0][0].getPrimeroEnSeleccionarse()==2){
                m[0]=0;
                m[1]=1;
                m[2]=0;
                m[3]=0;
                System.out.println("De 01 a 00");
            }
            if( mapa[1][0].getPrimeroEnSeleccionarse()==2&& mapa[1][0].getSeleccionado()==true){
                m[0]=0;
                m[1]=1;
                m[2]=1;
                m[3]=0;
                System.out.println("De 01 a 10");
            }
            if( mapa[1][1].getPrimeroEnSeleccionarse()==2&& mapa[1][1].getSeleccionado()==true){
                m[0]=0;
                m[1]=1;
                m[2]=1;
                m[3]=1;
                System.out.println("De 01 a 11");
            }
        }
        //Territorio 11
        if( mapa[1][1].getPrimeroEnSeleccionarse()==1&& mapa[1][1].getSeleccionado()==true){
            if( mapa[0][0].getPrimeroEnSeleccionarse()==2&& mapa[0][0].getSeleccionado()==true){
                m[0]=1;
                m[1]=1;
                m[2]=0;
                m[3]=0;
                System.out.println("De 11 a 00");
            }
            if( mapa[1][0].getPrimeroEnSeleccionarse()==2&& mapa[1][0].getSeleccionado()==true){
                m[0]=1;
                m[1]=1;
                m[2]=1;
                m[3]=0;
                System.out.println("De 11 a 10");
            }
            if( mapa[0][1].getPrimeroEnSeleccionarse()==2){
                m[0]=1;
                m[1]=1;
                m[2]=0;
                m[3]=1;
                System.out.println("De 11 a 01");
            }
        }
        this.deMatrizHaciaInterfazGrafica();
//        System.out.println("Coordenaas de traslado: ("+ m[0]+";"+m[1]+")("+m[2]+";"+m[3]+")\n\n");
        return m;
    }
    
    private class EventoChk1 implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deInterfazGraficaHaciaMatriz();
            if(posicion_numerica_en_seleccion<=2){
                if(mapa[0][0].getSeleccionado()==true){
                    posicion_numerica_en_seleccion++;
                    mapa[0][0].setPrimeroEnSeleccionarse(posicion_numerica_en_seleccion);
                }else{
                    posicion_numerica_en_seleccion--;
                    mapa[0][0].setPrimeroEnSeleccionarse(0);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo puede seleccionar 2 mapas a la vez.");
                desactivarChks();
            }
            deMatrizHaciaInterfazGrafica();
        }
    }
    
    private class EventoChk2 implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deInterfazGraficaHaciaMatriz();
            if(posicion_numerica_en_seleccion<=2){
                if(mapa[1][0].getSeleccionado()==true){
                    posicion_numerica_en_seleccion++;
                    mapa[1][0].setPrimeroEnSeleccionarse(posicion_numerica_en_seleccion);
                }else{
                    posicion_numerica_en_seleccion--;
                    mapa[1][0].setPrimeroEnSeleccionarse(0);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo puede seleccionar 2 mapas a la vez.");
                desactivarChks();
            }
            deMatrizHaciaInterfazGrafica();
        }
    }
    
    private class EventoChk3 implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deInterfazGraficaHaciaMatriz();
            if(posicion_numerica_en_seleccion<=2){
                if(mapa[0][1].getSeleccionado()==true){
                    posicion_numerica_en_seleccion++;
                    mapa[0][1].setPrimeroEnSeleccionarse(posicion_numerica_en_seleccion);
                }else{
                    posicion_numerica_en_seleccion--;
                    mapa[0][1].setPrimeroEnSeleccionarse(0);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo puede seleccionar 2 mapas a la vez.");
                desactivarChks();
            }
            deMatrizHaciaInterfazGrafica();
        }
    }
    
    private class EventoChk4 implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deInterfazGraficaHaciaMatriz();
            if(posicion_numerica_en_seleccion<=2){
                if(mapa[1][1].getSeleccionado()==true){
                    posicion_numerica_en_seleccion++;
                    mapa[1][1].setPrimeroEnSeleccionarse(posicion_numerica_en_seleccion);
                }else{
                    posicion_numerica_en_seleccion--;
                    mapa[1][1].setPrimeroEnSeleccionarse(0);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Solo puede seleccionar 2 mapas a la vez.");
                desactivarChks();
            }
            deMatrizHaciaInterfazGrafica();
        }
    }
    
    /**
     * @autor Rafael Angel MF
     * Encontrando la solucion a algunos comportamientos inconvenientes del codigo.
     * No existe un evento personalizado para cuando se desactiva el chk en forma directa.
     * Por lo tanto queda a futuro investigarlo con la ayuda de Internet.
     * Por el momento se debe saber que cuando hay dos ChekBox (chk) activos y se desactiva uno
     * de ellos entonces, se debe desactivar el segundo chk.
     * Aunque se puede puentear o salvar con la sigueinte accion.
     * Colocar codigo en el controlador de eventos del Menu para desactivar todos los cks
     * despues de alguna accion.
     * Aun asi existe la posibilidad que el usuario active 3 y luego desactive uno de los 3 o los 4.
     * Entonces los valores seleccionados individualmente mediante los controladores el tipo EventoChk1,
     * no cambian.
     * 
     * Para solucionarlo intentaré colocar una instancia de cada controlador en 
     * EventoChkBox1, provado no funciona y de funcionar se necesitan más condicionales del 
     * tipo if y no deseo hacerlo así.
     * 
     * Pero esta forma si funcionó, he creado un metodo llamado desactivarChks() 
     * para desactivar todas las selecciones y poner en cero el posicion_numerica_en_seleccion; 
     * solo se le permite al posicion_numerica_en_seleccion llegar a 2.
     * Esto interactua en el class anidado EventosDelMenu el cual es un controlador de eventos.
     * Este metodo es llamado en varias partes del codigo pero el principal es en 
     * el procedimiento e evento el class EventosDelMenu llamado actionPerformed.
     */
    private class EventoChkBox implements ActionListener {
        
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deInterfazGraficaHaciaMatriz();
            fEveMenu.enableCrear(posicion_numerica_en_seleccion==1);
            fEveMenu.enableColinizar(posicion_numerica_en_seleccion==2);
            fEveMenu.enableTrasladarse(posicion_numerica_en_seleccion==2);
            deMatrizHaciaInterfazGrafica();
//            JOptionPane.showMessageDialog(null, "posicion_numerica_en_seleccion="+posicion_numerica_en_seleccion);
        }
    }
    
    /**
     * Envia datos a la interfas grafica del usuario.
     */
    private void deInterfazGraficaHaciaMatriz(){
        mapa[0][0]=jpTerritorio1.getTerritorio();
        mapa[1][0]=jpTerritorio2.getTerritorio();
        mapa[0][1]=jpTerritorio3.getTerritorio();
        mapa[1][1]=jpTerritorio4.getTerritorio();
    }
    
    private void usuarioInvade(){
        deInterfazGraficaHaciaMatriz();
        int []m=this.comprovarPosicionDeSeleecion();
        int soladosTanques=-1;
        int siColonizar=JOptionPane.showConfirmDialog(null, "¿Desea colinizar este territorio?", "Hola", JOptionPane.YES_NO_OPTION);//=0 si, =1 no
        
        if(siColonizar==0){
            soladosTanques=JOptionPane.showConfirmDialog(null, "Has elegido invadir.\nDesea enviar soldados, en caso de no agregar soldados entonces se agregaran tanques.", "Hola", JOptionPane.YES_NO_OPTION);
            if(soladosTanques==0){
                String s=JOptionPane.showInputDialog("¿Cuantos soldados deseas enviar?");
                int vCantidad=0;
                try{
                    vCantidad=Integer.parseInt(s);
                    /**
                     * En este codigo los items numericos 2 y 3 corresponden al territorio a invadir.
                     */
                    mapa[m[0]][m[1]]=mapa[m[2]][m[3]].invadir_este_territorio(mapa[m[0]][m[1]], true, false, vCantidad);
                }catch(Exception e){
                    return;
                }
            }
            else if(soladosTanques==1){
                String s=JOptionPane.showInputDialog("¿Cuantos tanques deseas enviar?");
                int vCantidad=0;
                try{
                    vCantidad=Integer.parseInt(s);
                    mapa[m[0]][m[1]]=mapa[m[2]][m[3]].invadir_este_territorio(mapa[m[0]][m[1]], false, true, vCantidad);
                }catch(Exception e){
                    return;
                }
            }
        } //end algoritmo
        JOptionPane.showMessageDialog(null, territoriosConquistados());
        this.deMatrizHaciaInterfazGrafica();
    }
    
    /**
     * Actualiza las acciones en la interfas grafica.
     */
    private void deMatrizHaciaInterfazGrafica(){
        jpTerritorio1.setTerritorio(mapa[0][0]);
        jpTerritorio2.setTerritorio(mapa[1][0]);
        jpTerritorio3.setTerritorio(mapa[0][1]);
        jpTerritorio4.setTerritorio(mapa[1][1]);
    }

    /**
     * Indica el id del territorio seleccionado por el usuario.
     */
    private int territorioSeleccionadoPorUsuario=0;
    
    public static void main(String []m){
//        int a=2;
//        int b=0; int c=1;
//        a+=-(b+(c*2));
//        System.out.println(a);
        FrmEscenario f=new FrmEscenario();
        f.setVisible(true);
//        System.exit(0);
        
    }

    private TerritorioRisk3 [][] mapa=new TerritorioRisk3[2][2];
    /**
     * Creates new form FrmEscenario
     */
    public FrmEscenario() {
        initComponents();
        this.setBounds(100, 100, 800, 500);
        for(int f=0; f<mapa.length; ++f){
            for(int c=0;c<mapa.length; c++){
                mapa[f][c]=new TerritorioRisk3();
            }
        }
        
        mapa[0][0].setCasas(20);
        mapa[0][0].setSoldados(15);
        mapa[0][0].setTanques(10);
        mapa[0][0].generarRecursos();
        mapa[0][0].setFaccion(this.FACCION_oponente);
        
        mapa[1][0].setCasas(5);
        mapa[1][0].setSoldados(4);
        mapa[1][0].setTanques(3);
        mapa[1][0].generarRecursos();
        mapa[1][0].setFaccion(this.FACCION_oponente);
        
        mapa[0][1].setCasas(12);
        mapa[0][1].setSoldados(8);
        mapa[0][1].setTanques(7);
        mapa[0][1].generarRecursos();
        mapa[0][1].setFaccion(this.FACCION_oponente);
        
        mapa[1][1].setCasas(5);
        mapa[1][1].setSoldados(1);
        mapa[1][1].setTanques(3);
        mapa[1][1].generarRecursos();
        mapa[1][1].setFaccion(FACCION_USUARIO);
        jpTerritorio1.setNumeroDelTerritorio(0);
        jpTerritorio1.setTerritorio(mapa[0][0]);
        jpTerritorio2.setNumeroDelTerritorio(1);
        jpTerritorio2.setTerritorio(mapa[1][0]);
        jpTerritorio3.setNumeroDelTerritorio(2);
        jpTerritorio3.setTerritorio(mapa[0][1]);
        jpTerritorio4.setNumeroDelTerritorio(3);
        jpTerritorio4.setTerritorio(mapa[1][1]);
        
        jpTerritorio1.addChkActionListener(new EventoChkBox());
        jpTerritorio2.addChkActionListener(new EventoChkBox());
        jpTerritorio3.addChkActionListener(new EventoChkBox());
        jpTerritorio4.addChkActionListener(new EventoChkBox());
        
        jpTerritorio1.addChkActionListener(new EventoChk1());
        jpTerritorio2.addChkActionListener(new EventoChk2());
        jpTerritorio3.addChkActionListener(new EventoChk3());
        jpTerritorio4.addChkActionListener(new EventoChk4());
        
        
        jpTerritorio1.addBtnAccionesControlador(new EventosDelMenu());
        jpTerritorio2.addBtnAccionesControlador(new EventosDelMenu());
        jpTerritorio3.addBtnAccionesControlador(new EventosDelMenu());
        jpTerritorio4.addBtnAccionesControlador(new EventosDelMenu());
        fEveMenu.addControladorActionListener(new EventosDelMenu());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTerritorio1 = new Risk3.jpTerritorio();
        jpTerritorio2 = new Risk3.jpTerritorio();
        jpTerritorio3 = new Risk3.jpTerritorio();
        jpTerritorio4 = new Risk3.jpTerritorio();
        jBtnSalir = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpTerritorio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTerritorio1MouseClicked(evt);
            }
        });
        getContentPane().add(jpTerritorio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, -1));

        jpTerritorio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTerritorio2MouseClicked(evt);
            }
        });
        getContentPane().add(jpTerritorio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 230, -1));

        jpTerritorio3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTerritorio3MouseClicked(evt);
            }
        });
        getContentPane().add(jpTerritorio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 220, -1));

        jpTerritorio4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTerritorio4MouseClicked(evt);
            }
        });
        getContentPane().add(jpTerritorio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 210, -1));

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private int t1Conteo=0;
    private void jpTerritorio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTerritorio1MouseClicked
        //0
    }//GEN-LAST:event_jpTerritorio1MouseClicked

    private int t3Conteo=0;
    private void jpTerritorio3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTerritorio3MouseClicked
        //2
    }//GEN-LAST:event_jpTerritorio3MouseClicked

    private int t2Conteo=0;
    private void jpTerritorio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTerritorio2MouseClicked
        //1
    }//GEN-LAST:event_jpTerritorio2MouseClicked

    private int t4Conteo=0;
    private void jpTerritorio4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTerritorio4MouseClicked
        //3
    }//GEN-LAST:event_jpTerritorio4MouseClicked

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBtnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalir;
    private Risk3.jpTerritorio jpTerritorio1;
    private Risk3.jpTerritorio jpTerritorio2;
    private Risk3.jpTerritorio jpTerritorio3;
    private Risk3.jpTerritorio jpTerritorio4;
    // End of variables declaration//GEN-END:variables
}
