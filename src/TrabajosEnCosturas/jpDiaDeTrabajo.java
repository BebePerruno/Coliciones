/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TrabajosEnCosturas;

import javax.swing.JComboBox;

/**
 *
 * @author Jugador
 */
public class jpDiaDeTrabajo extends javax.swing.JPanel implements iDiaDeTrabajo {

    private String dia = "";
    private String fecha = "00/00/0000";
    private String entrada = "0";
    private String[] mEntradaHoras = {};
    private String[] mEntradaMinutos = {};
    private String salida = "0";
    private String[] mSalidaHoras = {};
    private String[] mSalidaMinutos = {};
    private String subtotalDeHoras = "0";
    private String entradaAmPm = "AM";
    private String salidaAmPm = "PM";
    
    public void limpiar(){
        jCmbDiasDeLaSemana.setSelectedIndex(0);
        this.setFecha("00/00/0000");
        this.setEntrada("");
        this.setSalida("");
        this.setSubtotalDeHoras("");
        this.jCmbEntradaAMPM.setSelectedIndex(0);
        this.jCmbSalidaAMPM.setSelectedIndex(1);
    }
    
    private boolean enableFecha=true;
    
    public void setEnableFecha(boolean habilitar_cuadro_de_texto){
        enableFecha=habilitar_cuadro_de_texto;
        jTxtFecha.setEnabled(enableFecha);
    }
    public boolean getEnableFecha(){
        return enableFecha;
    }
    
    
    private boolean esVisibleBotonGenerarSubtotalDeHoras=true;
    
    public void setEsVisibleBotonGenerarSubtotalDeHoras(boolean esVisible){
        esVisibleBotonGenerarSubtotalDeHoras=esVisible;
        jBtnGenerarSubtotalDeHoras.setEnabled(esVisible);
        jBtnGenerarSubtotalDeHoras.setVisible(esVisible);
    }
    public boolean getEsVisibleBotonGenerarSubtotalDeHoras(){
        return esVisibleBotonGenerarSubtotalDeHoras;
    }

    @Override
    public void setDia(String nuevo_dia) {
        dia = nuevo_dia;
        if(nuevo_dia.equalsIgnoreCase("Lunes")==true){
            jCmbDiasDeLaSemana.setSelectedIndex(0);
        }
        if(nuevo_dia.equalsIgnoreCase("Martes")==true){
            jCmbDiasDeLaSemana.setSelectedIndex(1);
        }
        if(nuevo_dia.equalsIgnoreCase("Miercoles")==true){
            jCmbDiasDeLaSemana.setSelectedIndex(2);
        }
        if(nuevo_dia.equalsIgnoreCase("Jueves")==true){
            jCmbDiasDeLaSemana.setSelectedIndex(3);
        }
        if(nuevo_dia.equalsIgnoreCase("Viernes")==true){
            jCmbDiasDeLaSemana.setSelectedIndex(4);
        }
        if(nuevo_dia.equalsIgnoreCase("Sabado")==true){
            jCmbDiasDeLaSemana.setSelectedIndex(5);
        }
        if(nuevo_dia.equalsIgnoreCase("Domingo")==true){
            jCmbDiasDeLaSemana.setSelectedIndex(6);
        }
//        jCmbDiasDeLaSemana.selectWithKeyChar(dia.toCharArray()[0]);//No sirve puesto que martes y miercoles empiezan con 'm'.

        switch(nuevo_dia){
            case "Lunes":
                jCmbDiasDeLaSemana.setSelectedIndex(0);
                return;
            case "Martes":
                jCmbDiasDeLaSemana.setSelectedIndex(1);
                return;
            case "Miercoles":
                jCmbDiasDeLaSemana.setSelectedIndex(2);
                return;
            case "Jueves":
                jCmbDiasDeLaSemana.setSelectedIndex(3);
                return;
            case "Viernes":
                jCmbDiasDeLaSemana.setSelectedIndex(4);
                return;
            case "Sabado":
                jCmbDiasDeLaSemana.setSelectedIndex(5);
                return;  
            case "Domingo":
                jCmbDiasDeLaSemana.setSelectedIndex(6);
                return;    
        }
//        jCmbDiasDeLaSemana.selectWithKeyChar(dia.toCharArray()[0]);
    }

    @Override
    public String getDia() {
        dia = jCmbDiasDeLaSemana.getSelectedItem()+"";
        return dia;
    }

    @Override
    public void setFecha(String nueva_fecha) {
        fecha = nueva_fecha;
        this.jTxtFecha.setText(fecha);
    }

    @Override
    public String getFecha() {
        fecha = jTxtFecha.getText();
        return fecha;
    }

    /**
     * La entrada va con el am o el pm.
     * El codigo interno se encarga de formatearlo.
     * @param nueva_entrada 
     */
    @Override
    public void setEntrada(String nueva_entrada) {
        entrada = nueva_entrada;
        this.jTxtEntrada.setText(entrada);
//        char []m=entrada.toCharArray();
//        this.setEntradaAmPm(m[m.length-2]+m[m.length-1]+"");
        
    }

    @Override
    public String getEntrada() {
        entrada = jTxtEntrada.getText();
        System.out.println("entrada=" + entrada);
        return entrada;
    }

    public int getEntradaHoras() {
        mEntradaHoras = getEntrada().split(":");
        int horasObtenidos = 0;
        if (mEntradaHoras.length >= 2) {
            try {
                formatearHora(mEntradaHoras, this.jCmbEntradaAMPM);
                horasObtenidos = Integer.parseInt(mEntradaHoras[0]);
            } catch (Exception e) {
            }
        }
        return horasObtenidos;
    }

    public int getEntradaMinutos() {
        mEntradaMinutos = getEntrada().split(":");
        int minutosObtenidos = 0;
        if (mEntradaMinutos.length >= 2) {
            try {
                minutosObtenidos = Integer.parseInt(mEntradaMinutos[1]);
            } catch (Exception e) {
            }
        }
        return minutosObtenidos;
    }

    @Override
    public void setSalida(String nueva_salida) {
        salida = nueva_salida;
        this.jTxtSalida.setText(salida);
//        char []m=salida.toCharArray();
//        this.setEntradaAmPm(m[m.length-2]+m[m.length-1]+"");
    }

    @Override
    public String getSalida() {
        salida = jTxtSalida.getText();
        return salida;
    }

    public int getSalidaHoras() {
        mSalidaHoras = getSalida().split(":");
        int horasObtenidos = 0;
        formatearHora(mSalidaHoras, this.jCmbSalidaAMPM);
        if (mSalidaHoras.length >= 2) {
            System.out.println(mSalidaHoras[0]);
            try {
                horasObtenidos = Integer.parseInt(mSalidaHoras[0]);
            } catch (Exception e) {
            }
        }
        return horasObtenidos;
    }

    public int getSalidaMinutos() {
        mSalidaMinutos = getSalida().split(":");
        int minutosObtenidos = 0;
        if (mSalidaMinutos.length >= 2) {
            try {
                minutosObtenidos = Integer.parseInt(mSalidaMinutos[1]);
            } catch (Exception e) {
            }
        }
        return minutosObtenidos;
    }

    @Override
    public void setSubtotalDeHoras(String nueva_subtotal) {
        subtotalDeHoras = nueva_subtotal;
        this.jTxtSubtotalDeHoras.setText(subtotalDeHoras);
    }

    @Override
    public String getSubtotalDeHoras() {
        subtotalDeHoras = jTxtSubtotalDeHoras.getText();
        return subtotalDeHoras;
    }

    @Override
    public void setEntradaAmPm(String nuevo_am_pm) {
        entradaAmPm = nuevo_am_pm;
        if (entradaAmPm.equalsIgnoreCase("AM") == true) {
            this.jCmbEntradaAMPM.setSelectedIndex(0);
        } else if (entradaAmPm.equalsIgnoreCase("PM") == true) {
            jCmbEntradaAMPM.setSelectedIndex(1);
        }
    }
    
   

    @Override
    public String getEntradaAmPm() {
        entradaAmPm = jCmbEntradaAMPM.getSelectedItem() + "";
        System.out.println("entradaAmPm="+entradaAmPm);
        return entradaAmPm;
    }

    /**
     * La entrada va con el am o el pm.
     * El codigo interno se encarga de formatearlo.
     * @param nuevo_am_pm 
     */
    @Override
    public void setSalidaAmPm(String nuevo_am_pm) {
        entradaAmPm = nuevo_am_pm;
        if (salidaAmPm.equalsIgnoreCase("AM") == true) {
            this.jCmbSalidaAMPM.setSelectedIndex(0);
        } else if (salidaAmPm.equalsIgnoreCase("PM") == true) {
            jCmbSalidaAMPM.setSelectedIndex(1);
        }
    }

    @Override
    public String getSalidaAmPm() {
        salidaAmPm = jCmbSalidaAMPM.getSelectedItem() + "";
        System.out.println("salidaAmPm="+salidaAmPm);
        return salidaAmPm;
    }
    
    private void formatearHora(String []m, JComboBox cmb){
        if((cmb.getSelectedItem()+"").equalsIgnoreCase("PM")==true){
                   switch(m[0]){
                       case "1":
                           m[0]="13";
                           break;
                       case "2":
                           m[0]="14";
                           break;
                       case "3":
                           m[0]="15";
                           break; 
                       case "4":
                           m[0]="16";
                           break;
                       case "5":
                           m[0]="17";
                           break;
                       case "6":
                           m[0]="18";
                           break;
                       case "7":
                           m[0]="19";
                           break;
                        case "8":
                           m[0]="20";
                           break;   
                        case "9":
                           m[0]="21";
                           break;  
                        case "10":
                           m[0]="22";
                           break; 
                        case "11":
                           m[0]="23";
                           break;   
                        case "12":
                           m[0]="0";
                           break;   
                   }
               }
    }
    
    
    public void SubtotalDeHorasGenerarlo(){
        double totalDeHorasEnUnDia=0;
        double minutosSumatoria=(this.getEntradaMinutos()+this.getSalidaMinutos());
        minutosSumatoria/=60;
        //Si es pm entonces aplicar hora militar.
//        System.out.println("getSalidaHoras()="+getSalidaHoras());
        double horasSumatoria=this.getSalidaHoras()-this.getEntradaHoras();
//        System.out.println("minutosSumatoria="+minutosSumatoria );
        totalDeHorasEnUnDia=horasSumatoria+minutosSumatoria;
        this.setSubtotalDeHoras(totalDeHorasEnUnDia+"");
    }
    /**
     * Creates new form jpDiaDeTrabajo
     */
    public jpDiaDeTrabajo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtngEntrada = new javax.swing.ButtonGroup();
        jBtngSalida = new javax.swing.ButtonGroup();
        jLbDia = new javax.swing.JLabel();
        jLbFecha = new javax.swing.JLabel();
        jTxtFecha = new javax.swing.JTextField();
        jLbEntrada = new javax.swing.JLabel();
        jTxtEntrada = new javax.swing.JTextField();
        jLbSalida = new javax.swing.JLabel();
        jTxtSalida = new javax.swing.JTextField();
        jLbSubtotalDeHoras = new javax.swing.JLabel();
        jTxtSubtotalDeHoras = new javax.swing.JTextField();
        jBtnGenerarSubtotalDeHoras = new javax.swing.JButton();
        jCmbDiasDeLaSemana = new javax.swing.JComboBox<>();
        jCmbEntradaAMPM = new javax.swing.JComboBox<>();
        jCmbSalidaAMPM = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbDia.setText("Dia");
        add(jLbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        jLbFecha.setText("Fecha");
        add(jLbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 80, -1));

        jTxtFecha.setText("00/00/0000");
        add(jTxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 460, -1));

        jLbEntrada.setText("Entrada");
        add(jLbEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        jTxtEntrada.setText("00:00");
        add(jTxtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, -1));

        jLbSalida.setText("Salida");
        add(jLbSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 150, -1));

        jTxtSalida.setText("00:00");
        add(jTxtSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 150, -1));

        jLbSubtotalDeHoras.setText("Subtotal");
        add(jLbSubtotalDeHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 140, 30));

        jTxtSubtotalDeHoras.setText("0");
        add(jTxtSubtotalDeHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, -1));

        jBtnGenerarSubtotalDeHoras.setText("Generar subtotal de horas");
        jBtnGenerarSubtotalDeHoras.setToolTipText("Generar subtotal de horas");
        jBtnGenerarSubtotalDeHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGenerarSubtotalDeHorasActionPerformed(evt);
            }
        });
        add(jBtnGenerarSubtotalDeHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 180, -1));

        jCmbDiasDeLaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        add(jCmbDiasDeLaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, -1));

        jCmbEntradaAMPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        add(jCmbEntradaAMPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        jCmbSalidaAMPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        add(jCmbSalidaAMPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGenerarSubtotalDeHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGenerarSubtotalDeHorasActionPerformed
        this.SubtotalDeHorasGenerarlo();
    }//GEN-LAST:event_jBtnGenerarSubtotalDeHorasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnGenerarSubtotalDeHoras;
    private javax.swing.ButtonGroup jBtngEntrada;
    private javax.swing.ButtonGroup jBtngSalida;
    private javax.swing.JComboBox<String> jCmbDiasDeLaSemana;
    private javax.swing.JComboBox<String> jCmbEntradaAMPM;
    private javax.swing.JComboBox<String> jCmbSalidaAMPM;
    private javax.swing.JLabel jLbDia;
    private javax.swing.JLabel jLbEntrada;
    private javax.swing.JLabel jLbFecha;
    private javax.swing.JLabel jLbSalida;
    private javax.swing.JLabel jLbSubtotalDeHoras;
    private javax.swing.JTextField jTxtEntrada;
    private javax.swing.JTextField jTxtFecha;
    private javax.swing.JTextField jTxtSalida;
    private javax.swing.JTextField jTxtSubtotalDeHoras;
    // End of variables declaration//GEN-END:variables
}
