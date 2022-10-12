package Backtracking;

import InfoGerais.EstadoFinal;
import InfoGerais.Regras;

/**
 *
 * @author pedro
 */
public class Backtracking {

    public int getNivel(){
        return getNivelAux(this.raiz);
    }

    private int getNivelAux(No no){
        if(no.getProx() != null){
            return getNivelAux(no.getProx());
        }else{
            return no.getNivel();
        }
    }

    private No raiz;

    public Backtracking(){
        this.raiz = null;
    }

    public int[] iniciaBusca(int[] tabuleiro){
        this.raiz = new No(0,tabuleiro,0);
        return buscaAux(this.raiz);
    }
    private int[] buscaAux(No no){
        EstadoFinal estadoFinal = new EstadoFinal();
        if(!estadoFinal.getEstadoFinal(no.getTabuleiro())){
            Regras reg = new Regras();
            int[] tabuleiroAux = no.getTabuleiro();
            if(reg.getRegraUm(tabuleiroAux) && no.getRegraImpasse() != 1){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(1);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(novoNo);
            }else if(reg.getRegraDois(tabuleiroAux) && no.getRegraImpasse() != 2 ){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(2);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(no.getProx());
            }else if(reg.getRegraTres(tabuleiroAux) && no.getRegraImpasse() != 3){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(3);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(no.getProx());
            }else if(reg.getRegraQuatro(tabuleiroAux) && no.getRegraImpasse() != 4){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(4);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(no.getProx());
            }else{
                No aux = no.getNoAnterior();
                aux.setRegraImpasse(no.getRegraAtual());
                return buscaAux(no.getNoAnterior());
            }
        }else{
            return no.getTabuleiro();
        }
    }
}
