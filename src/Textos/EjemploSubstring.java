/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Textos;

/**
 *
 * @author Jugador
 */
public class EjemploSubstring {
    
    private String preguntas_respuestas="";
    
    public void setPreguntasRespuestas(String nuevo_texto){
        preguntas_respuestas=nuevo_texto;
    }
    public String getPeguntasRespuestas(){
        return this.preguntas_respuestas;
    }
    
    
    public static void main(String []m){
        EjemploSubstring c=new EjemploSubstring();
        c.setPreguntasRespuestas("1)¿Alejandro es mi amogo? 1)si2)no3)no se\n2)¿Cuantos años tengo de ser programador?1)1 año2)10 años3)18 años\n3)¿Cual es el mejor lenguaje de programacion?1)Python2)C#3)c++");
        System.out.println("Tamaño del texto " + c.getPeguntasRespuestas().length());
        System.out.println("inicio " + c.getPeguntasRespuestas().compareTo("1)¿"));
        System.out.println("fin " + c.getPeguntasRespuestas().compareTo("0?"));
        System.out.println(c.getPeguntasRespuestas().substring(0, c.getPeguntasRespuestas().indexOf("0?")));
    }
}
