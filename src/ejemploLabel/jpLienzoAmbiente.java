/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ejemploLabel;

import javax.swing.JLabel;

/**
 *
 * @author Jugador
 */
public class jpLienzoAmbiente extends javax.swing.JPanel implements AccionesDeMovimiento {
    
    @Override
    public int getVelocidad() {
        return robot.getVelocidad();
    }

    @Override
    public void moverAbajo() {
        if(estaEnLaMeta()==false ){
            robot.moverAbajo();
            verificarColiciones();
        }
    }

    @Override
    public void moverArriba() {
        if(estaEnLaMeta()==false ){
            robot.moverArriba();
            verificarColiciones();
        }
    }

    @Override
    public void moverDerecha() {
        if(estaEnLaMeta()==false ){
            robot.moverDerecha();
            verificarColiciones();
        }
    }

    @Override
    public void moverIzquierda() {
        if(estaEnLaMeta()==false){
            robot.moverIzquierda();
            verificarColiciones();
        }
    }

    @Override
    public void moverDiagonalSuperior() {
        if(estaEnLaMeta()==false ){
            robot.moverDiagonalSuperior();
            verificarColiciones();
        }
    }

    @Override
    public void moverDiagonalSuperiorReversa() {
        if(estaEnLaMeta()==false ){
            robot.moverDiagonalSuperiorReversa();
            verificarColiciones();
        }
    }

    @Override
    public void moverDiagonalInferior() {
        if(estaEnLaMeta()==false ){
            robot.moverDiagonalInferior();
            verificarColiciones();
            
        }
    }

    @Override
    public void moverDiagonalInferiorReversa() {
        if(estaEnLaMeta()==false ){
            robot.moverDiagonalInferiorReversa();
            verificarColiciones();
        }
    }

    @Override
    public void setVelocidad(int nuevaVelocidad) {
        robot.setVelocidad(nuevaVelocidad);
    }
    
    private boolean estaEnLaMeta(){
        if(robot.colision(jLbMeta)==true ){
            MemoriaDelCamino memoria=robot.getMemoriaDelCamino();
            robot.setVisible(false);
//            jLbMeta.setVisible(false);
            robot=null;
            robot=new UnidadLabel(memoria.getX(), memoria.getY(), 100, 100, Foto_a_elegir.Explosion);
//            robot.setVisible(true);
            add(robot);
            robot.DibujarImagen(Foto_a_elegir.Explosion);
            System.out.println( "He llegado a una meta explosiva.\n"+memoria);
            return true;
        }
        return false;
    }
    
    private boolean viendo(){
        final String recomendasion="Debes cambiar de direccion";
        if(robot.verObjeto(jLCuadrante)==true ){
            System.out.println("Estoy viendo el cuadrante. " + recomendasion);
            return true;
        }
        
        if(robot.verObjeto(base)==true ){
            System.out.println("Estoy viendo la base. " + recomendasion);
            return true;
        }
        
        if(robot.verObjeto(fabrica)==true ){
            System.out.println("Estoy viendo la fabrica. " + recomendasion);
            return true;
        }
        if(robot.verObjeto(jLbMeta)==true ){
            System.out.println("Estoy viendo la meta, continua hacia la meta.");
            return true;
        }
        return false;
    }
    
    
    public boolean verificarColiciones(){
        viendo();
        boolean estado=false;
        
        if(robot.colision(jLCuadrante)==true ){
            System.out.println("Colicionaste con el cuadrante.");
            estado=true;
        }
        
        if(robot.colision(base)==true ){
            System.out.println("Colicionaste con la base.");
            estado=true;
        }
        
        if(robot.colision(fabrica)==true ){
            System.out.println("Colicionaste con la fabrica.");
            estado=true;
        }
        
        return estado;
    }
    
    private LabelAnimado jLCuadrante;
    private LabelAnimado base;
    private LabelAnimado fabrica;
    private UnidadLabel robot;
    /**
     * Creates new form jpLienzoAmbiente
     */
    public jpLienzoAmbiente() {
        initComponents();
        setBounds(0, 0, 600, 500);
//        this.setDoubleBuffered(true);
        UnidadLabel.LimiteDerecho=500;
        UnidadLabel.LimiteInferior=400;
        jLCuadrante=new LabelAnimado(0, 300, 100, 100, Foto_a_elegir.Explosion);
        base=new LabelAnimado(200, 0, 100, 100, Foto_a_elegir.Base);
        fabrica=new LabelAnimado(350, 400, 100, 100, Foto_a_elegir.Fabrica);
        robot=new UnidadLabel(0, 0, 60, 60, Foto_a_elegir.Robot);
        robot.setVelocidad(50);
        
        add(jLCuadrante);
        add(base);
        add(fabrica);
        add(robot);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbMeta = new javax.swing.JLabel();

        setLayout(null);

        jLbMeta.setBackground(new java.awt.Color(51, 255, 51));
        jLbMeta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLbMeta.setText("Meta");
        jLbMeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 3));
        add(jLbMeta);
        jLbMeta.setBounds(510, 210, 60, 60);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLbMeta;
    // End of variables declaration//GEN-END:variables
}
