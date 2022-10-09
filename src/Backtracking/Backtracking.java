package Backtracking;

import InfoGerais.EstadoFinal;
import InfoGerais.Regras;

/**
 *
 * @author pedro
 */
public class Backtracking {

    private int getNivel(No no){
        if(no.getProx() != null){
            return getNivel(no.getProx());
        }else{
            return no.getNivel();
        }
    }

    private No raiz;

    public Backtracking(){
        this.raiz = null;
    }

    public int[] iniciaBusca(int[] tabuleiro){
        this.raiz = new No(0,tabuleiro);
        return buscaAux(this.raiz);
    }
    private int[] buscaAux(No no){
        EstadoFinal estadoFinal = new EstadoFinal();
        if(!estadoFinal.getEstadoFinal(no.getTabuleiro())){
            Regras reg = new Regras();
            int[] tabuleiroAux = no.getTabuleiro();
            if(reg.getRegraUm(tabuleiroAux)){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux);
                no.setProx(novoNo);
                return buscaAux(no.getProx());
            }else if(reg.getRegraDois(tabuleiroAux)){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux);
                no.setProx(novoNo);
                return buscaAux(no.getProx());
            }else if(reg.getRegraTres(tabuleiroAux)){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux);
                no.setProx(novoNo);
                return buscaAux(no.getProx());
            }else if(reg.getRegraQuatro(tabuleiroAux)){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux);
                no.setProx(novoNo);
                return buscaAux(no.getProx());
            }
        }else{
            return no.getTabuleiro();
        }
        return no.getTabuleiro();
    }
}
