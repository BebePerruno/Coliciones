/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ajedres;

/**
 *
 * @author Rafael Angel MF
 */
public class Peon extends Ancestro implements MoversePorFilasColumnas {
    

    private Tablero tablero=null;
    
    public void setTablero(Tablero nuevoTablero){
        tablero=nuevoTablero;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
   

    @Override
    public int getCantidadDepasosPorFila() {
        return 1;
    }

    @Override
    public int getCantidadDePasosPorColumna() {
        return 1;
    }

    @Override
    public void irAbajo(int id_fila, int id_columna) {
        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void irArriba(int id_fila, int id_columna) {
        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void irAdelante(int id_fila, int id_columna) {
        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void irAtras(int id_fila, int id_columna) {
        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void irDiagonalAbajo(int id_fila, int id_columna) {
//        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void irDiagonalArriba(int id_fila, int id_columna) {
//        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void irDiagonalAtras(int id_fila, int id_columna) {
//        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void irDiagonalAdelante(int id_fila, int id_columna) {
//        this.movimiento(id_fila, id_columna);
    }

    @Override
    public void movimiento(int id_fila, int id_columna) {
        if(tablero!=null){
            int pasos=0;
            for(int i=this.getFila(); i<=id_fila; i++){
                pasos++;
            }
            for(int i=this.getColumna(); i<=id_columna; i++){
                pasos++;
            }
            if(pasos==1){
                if(tablero.mTablero.length-1<=id_fila && tablero.mTablero.length-1<=id_columna && tablero.mTablero[id_fila][id_columna].esDestino()){
                    tablero.mTablero[id_fila][id_columna]=this;
                    tablero.mTablero[this.getFila()][this.getColumna()].setTipoDeUnidad(tipoDeUnidad.ninguna);
                    this.setColumna(id_columna);
                    this.setFila(id_fila);
                }
            }
        }
    }

    
   
}
