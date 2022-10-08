package Backtracking;

/**
 *
 * @author pedro
 */
public class No {

    private No prox;

    private final int nivel;
    private final int[] tabuleiro;

    public No(int nivel,int[] tabuleiro){
        this.prox = null;
        this.nivel = nivel;
        this.tabuleiro = tabuleiro;
    }

    public void setProx(No no){
        this.prox = no;
    }

    public No getProx(){
        return this.prox;
    }

    public int getNivel(){
        return this.nivel;
    }

    public int[] getTabuleiro(){
        return this.tabuleiro;
    }

}