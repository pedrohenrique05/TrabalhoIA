package Profundidade;
import java.util.Stack;

import InfoGerais.EstadoFinal;
import InfoGerais.Regras;

/**
 *
 * @author pedro
 */
public class Profundidade {
    private EstadoFinal estadoFinal;
    private Regras reg;
    private No raiz;
    private Stack<No> pilhaNosAberto = new Stack<>();
    private Stack<No> pilhaNosFechado = new Stack<>();

    public Profundidade(){
        this.reg = new Regras();
        this.estadoFinal = new EstadoFinal();
        this.raiz = null;
    }

    /**
     * Função que tem como objetivo apenas para mostrar que manteve o tabuleiro inicial,
     * mesmo após a conclusão da busca.
     * @return
     */
    public int[] getTabuleiroRaiz(){
        No noAux = null;
        while(this.pilhaNosFechado.size() != 0){
            noAux = pilhaNosFechado.pop();
        }
        return noAux.getTabuleiro();
    }

    /**
     *
     * @return o nivel da arvore de busca
     */
    public int getNivel(){
        return this.pilhaNosFechado.peek().getNivel();
    }

    /**
     * Seta o No que acabou se ser criado na pilha de aberto.
     * @param no
     */
    private void setPilhaNoAberto(No no){
        this.pilhaNosAberto.push(no);
    }

    /**
     * Seta o No que acabou de ser explorado na pilha de fechado.
     * @param no
     */
    private void setPilhaNoFechado(No no){
        this.pilhaNosFechado.push(no);
    }

    /**
     * Retira o No que acabou de ser explorado.
     * @return
     */
    private No getPrimeiroNoAberto(){
        return this.pilhaNosAberto.pop();
    }

    /**
     * Informa qual será o próximo No a ser explorado.
     * @return
     */
    private No getProximoNoAberto(){
        return this.pilhaNosAberto.peek();
    }

    /**
     * Função a ser chamada para começar a busca em profundidade.
     * @param tabuleiro
     * @return
     */
    public int[] iniciaBusca(int [] tabuleiro){
        if(this.raiz == null){
            No no = new No(0,tabuleiro);
            setPilhaNoAberto(no);
            return buscaProfundidade(no,null,0);
        }else{
            System.out.println("Busca já realizada!");
            return null;
        }
    }

    /**
     * Função auxiliar que realiza a busca em profundidade de forma recursiva.
     * @param no
     * @return
     */
    private int[] buscaProfundidade(No no, int [] tabuleiroAux,int interacao) {
        if(interacao < 2505){
            if(!this.estadoFinal.getEstadoFinal(no.getTabuleiro())){
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraUm(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setPilhaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraDois(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setPilhaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraTres(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setPilhaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraQuatro(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setPilhaNoAberto(novoNo);
                }
                tabuleiroAux = null;
                no.setExplorado();
                setPilhaNoFechado(getPrimeiroNoAberto());
                return buscaProfundidade(getProximoNoAberto(), null,interacao+1);
            }else{
                setPilhaNoFechado(getPrimeiroNoAberto());
                return no.getTabuleiro();
            }
        }else{
            return no.getTabuleiro();
        }

    }
}
