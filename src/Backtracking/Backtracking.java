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
        if(no.getNivel()< 7767){ //nivel máximo: 7767
            if(!estadoFinal.getEstadoFinal(no.getTabuleiro())){
                Regras regras = new Regras();
                int [] tabuleiro = no.getTabuleiro();
                if(tabuleiro[0] != 0 && tabuleiro[regras.getRegraDir(0)] == 0){
                    tabuleiro[regras.getRegraDir(0)] = tabuleiro[0];
                    tabuleiro[0] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else if(tabuleiro[1] != 0 && tabuleiro[regras.getRegraDir(1)] == 0){
                    tabuleiro[regras.getRegraDir(1)] = tabuleiro[1];
                    tabuleiro[1] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else if(tabuleiro[2] != 0 && tabuleiro[regras.getRegraDir(2)] == 0){
                    tabuleiro[regras.getRegraDir(2)] = tabuleiro[2];
                    tabuleiro[2] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else if(tabuleiro[3] != 0 && tabuleiro[regras.getRegraDir(3)] == 0){
                    tabuleiro[regras.getRegraDir(3)] = tabuleiro[3];
                    tabuleiro[3] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else if(tabuleiro[4] != 0 && tabuleiro[regras.getRegraDir(4)] == 0){
                    tabuleiro[regras.getRegraDir(4)] = tabuleiro[4];
                    tabuleiro[4] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else if(tabuleiro[5] != 0 && tabuleiro[regras.getRegraDir(5)] == 0){
                    tabuleiro[regras.getRegraDir(5)] = tabuleiro[5];
                    tabuleiro[5] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else if(tabuleiro[6] != 0 && tabuleiro[regras.getRegraDir(6)] == 0){
                    tabuleiro[regras.getRegraDir(6)] = tabuleiro[6];
                    tabuleiro[6] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else if(tabuleiro[7] != 0 && tabuleiro[regras.getRegraDir(7)] == 0){
                    tabuleiro[regras.getRegraDir(7)] = tabuleiro[7];
                    tabuleiro[7] = 0;
                    No novoNo = new No(no.getNivel()+1,tabuleiro);
                    no.setProx(novoNo);
                    return buscaAux(no.getProx());
                }else{
                    return null;
                }
            }else{
                return no.getTabuleiro();
            }
        }else{

            return null;
        }
    }
}
