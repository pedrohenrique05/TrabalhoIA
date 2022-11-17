package Largura;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class No {

    @Override
    public boolean equals(Object obj){
        No outro = (No) obj;
        return this.tabuleiro.equals(((No) obj).getTabuleiro());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tabuleiro == null) ? 0 : tabuleiro.hashCode());
        return result;
    }
    private boolean solucao;
//    private boolean explorado;
    private ArrayList<No> nosFilhos;
    private No noAnterior;
    private final int nivel;
    private final int[] tabuleiro;

    public No(int nivel,int[] tabuleiro){
        this.nivel = nivel;
        this.tabuleiro = tabuleiro;
        this.noAnterior = null;
//        this.explorado = false;
        this.solucao = false;
        this.nosFilhos = new ArrayList();
    }

    public void setNoFilho(No no){
        this.nosFilhos.add(no);
    }

    /**
    public No getNoFilho(){
        for(int i = 0; i < this.nosFilhos.size(); i++){
            if(!this.nosFilhos.get(i).getNoExplorado()){
                return this.nosFilhos.get(i);
            }
        }
        return null;
    }*/

    public ArrayList<No> getNosFilhos(){
        return this.nosFilhos;
    }
/**    public void setNoExplorado(){
        this.explorado = true;
    }
    public boolean getNoExplorado(){
        return this.explorado;
    }*/
    public void setNoSolucao(){ this.solucao = true;}
    public boolean getNoSolucao(){return this.solucao;}
    public void setNoAnterior(No no){ this.noAnterior = no;}

    public No getNoAnterior(){ return this.noAnterior;}

    public int getNivel(){
        return this.nivel;
    }

    public int[] getTabuleiro(){
        return this.tabuleiro;
    }

}