package Profundidade;

/**
 *
 * @author pedro
 */
public class No {

    private No proxNo;
    private No noAnterior;
    private final int nivel;
    private final int[] tabuleiro;

    public No(int nivel,int[] tabuleiro){
        this.proxNo = null;
        this.nivel = nivel;
        this.tabuleiro = tabuleiro;
        this.noAnterior = null;
    }

    public void setProx(No no){
        this.proxNo = no;
    }

    public No getProx(){
        return this.proxNo;
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