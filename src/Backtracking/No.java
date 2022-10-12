package Backtracking;

/**
 *
 * @author pedro
 */
public class No {

    private No proxNo;
    private No noAnterior;
    private int regraImpasse;
    private int regraAtual;
    private final int nivel;
    private final int[] tabuleiro;

    public No(int nivel,int[] tabuleiro, int regraAtual){
        this.proxNo = null;
        this.nivel = nivel;
        this.tabuleiro = tabuleiro;
        this.noAnterior = null;
        this.regraAtual = regraAtual;
        this.regraImpasse = 0;
    }

    public int getRegraAtual() { return this.regraAtual; }

    public void setRegraAtual(int regraAtual) { this.regraAtual = regraAtual; }

    public int getRegraImpasse() { return this.regraImpasse; }

    public void setRegraImpasse(int regraImpasse) { this.regraImpasse = regraImpasse; }

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