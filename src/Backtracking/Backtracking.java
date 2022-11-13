package Backtracking;

import InfoGerais.EstadoFinal;
import InfoGerais.Regras;

import java.util.Arrays;

/**
 *
 * @author pedro
 */
public class Backtracking {

    public void imprimeCaminhoDaFolhaARaiz(No no){
        System.out.println(" Nivel: "+no.getNivel()+" | Tabuleiro: "+Arrays.toString(no.getTabuleiro())+" ->");
        if (no.getNoAnterior() != null)
            imprimeCaminhoDaFolhaARaiz(no.getNoAnterior());
    }

    public void imprimeCaminhoDaRaizAFolha(No no){
        if(no.getNoAnterior() != null){
            imprimeCaminhoDaRaizAFolha(no.getNoAnterior());
        }else{
            imprimeCaminhoDaRaizAFolhaAux(no);
        }
    }

    private void imprimeCaminhoDaRaizAFolhaAux(No no){
        System.out.println(" Nivel: "+no.getNivel()+" | Tabuleiro: "+Arrays.toString(no.getTabuleiro())+" ->");
        if(no.getProx()!= null)
            imprimeCaminhoDaRaizAFolhaAux(no.getProx());
    }
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
    public int[] getTabuleiroRaiz(){
        return this.raiz.getTabuleiro();
    }

    private No raiz;
    private No solucao;

    public Backtracking(){
        this.solucao = null;
        this.raiz = null;
    }
    public No getNoSolucao(){
        return this.solucao;
    }
    public void iniciaBusca(int[] tabuleiro){
        if(this.raiz == null){
            EstadoFinal estadoFinal = new EstadoFinal();
            Regras reg = new Regras();
            this.raiz = new No(0,tabuleiro,0);
            this.solucao = buscaAux(this.raiz,estadoFinal,reg);
        }else{
            System.out.println("Busca já realizada!");
        }

    }
    private No buscaAux(No no,EstadoFinal estadoFinal,Regras reg){

        if(!estadoFinal.getEstadoFinal(no.getTabuleiro())){

            int[] tabuleiroAux = no.getTabuleiro().clone();
            if(reg.getRegraUm(tabuleiroAux) && no.getRegraImpasse() != 1){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(1);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(novoNo,estadoFinal,reg);
            }else if(reg.getRegraDois(tabuleiroAux) && no.getRegraImpasse() != 2 ){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(2);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(novoNo,estadoFinal,reg);
            }else if(reg.getRegraTres(tabuleiroAux) && no.getRegraImpasse() != 3){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(3);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(novoNo,estadoFinal,reg);
            }else if(reg.getRegraQuatro(tabuleiroAux) && no.getRegraImpasse() != 4){
                No novoNo = new No(no.getNivel()+1,tabuleiroAux,0);
                no.setRegraAtual(4);
                no.setProx(novoNo);
                novoNo.setNoAnterior(no);
                return buscaAux(novoNo,estadoFinal,reg);
            }else{
                No aux = no.getNoAnterior();
                aux.setRegraImpasse(no.getRegraAtual());
                return buscaAux(no.getNoAnterior(),estadoFinal,reg);
            }
        }else{
            return no;
        }
    }
}
