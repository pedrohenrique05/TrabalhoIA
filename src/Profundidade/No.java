/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Profundidade;

/**
 *
 * @author pedro
 */
public class No {

    private No esq;
    private No dir;
    public int chave;
    private int nivel;

    public No(int chave, int nivel){
        this.chave = chave;
        this.esq = null;
        this.dir = null;
        this.nivel = nivel;
    }

    public int getChave(){
        return this.chave;
    }

    public void setEsq(No no){
        this.esq = no;
    }

    public void setDir(No no){
        this.dir = no;
    }

    public No getEsq(){
        return this.esq;
    }

    public No getDir(){
        return this.dir;
    }

    public int getNivel(){
        return this.nivel;
    }

}