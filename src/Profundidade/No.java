package Profundidade;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class No {

    private boolean solucao;
    private boolean explorado;
    private ArrayList<No> nosFilhos = new ArrayList();
    private No noAnterior;
    private final int nivel;
    private final int[] tabuleiro;

    public No(int nivel,int[] tabuleiro){
        this.solucao = false;
        this.explorado = false;
        this.nivel = nivel;
        this.tabuleiro = tabuleiro;
        this.noAnterior = null;
    }

    public boolean isSolucao() {
        return solucao;
    }

    public void setSolucao() {
        this.solucao = true;
    }

    public boolean isExplorado() {
        return explorado;
    }

    public void setExplorado() {
        this.explorado = true;
    }

    public void setNoFilho(No no){
        this.nosFilhos.add(no);
    }

    public ArrayList<No> getProx(){
        return this.nosFilhos;
    }

    public void setNoAnterior(No no){ this.noAnterior = no;}

    public No getNoAnterior(){ return this.noAnterior;}

    public int getNivel(){
        return this.nivel;
    }

    public int[] getTabuleiro(){
        return this.tabuleiro;
    }

}