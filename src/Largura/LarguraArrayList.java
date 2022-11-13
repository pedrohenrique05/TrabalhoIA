package Largura;

import InfoGerais.EstadoFinal;
import InfoGerais.Regras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LarguraArrayList{

    public void imprimeCaminhoDaFolhaARaiz(No no){
        System.out.println(" Nivel: "+no.getNivel()+" | Tabuleiro: "+ Arrays.toString(no.getTabuleiro())+" ->");
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
        ArrayList<No> filhos = no.getNosFilhos();
        for(int i = 0; i < filhos.size() ; i++){
            if(filhos.get(i).getNoSolucao()){
                imprimeCaminhoDaRaizAFolhaAux(filhos.get(i));
            }
        }
    }


        private No noSolucao;
        private No raiz;
        private List<No> filaNosAberto = new ArrayList<>();
        private List<No> filaNosFechado = new ArrayList<>();

    public LarguraArrayList(){
        this.noSolucao = null;
        this.raiz = null;
    }

    public No getNoSolucao(){
        return this.noSolucao;
    }
    /**
     * Função que tem como objetivo apenas para mostrar que manteve o tabuleiro inicial,
     * mesmo após a conclusão da busca.
     * @return
     */
    public int[] getTabuleiroRaiz(){
        return this.filaNosFechado.get(0).getTabuleiro();
    }

    /**
     *
     * @return o nivel da arvore de busca
     */
    public int getNivel(){
        return this.filaNosFechado.get(this.filaNosFechado.size()-1).getNivel();
    }

    /**
     * Seta o No que acabou se ser criado na lista de aberto.
     * @param no
     */
    private void setListaNoAberto(No no){
        this.filaNosAberto.add(no);
    }

    /**
     * Seta o No que acabou de ser explorado na lista de fechado.
     * @param no
     */
    private void setListaNoFechado(No no){
        this.filaNosFechado.add(no);
    }

    /**
     * Retira o No que acabou de ser explorado.
     * @return
     */
    private No getPrimeiroNoAberto(){
        No aux = this.filaNosAberto.get(0);
        this.filaNosAberto.remove(0);
        return aux;
    }

    /**
     * Informa qual será o próximo No a ser explorado.
     * @return
     */
    private No getProximoNoAberto(){
        return this.filaNosAberto.get(0);
    }

    /**
     * Função a ser chamada para começar a busca em largura.
     * @param tabuleiro
     * @return
     */
    public void iniciaBusca(int [] tabuleiro){
        if(this.raiz == null){
            EstadoFinal estadoFinal = new EstadoFinal();
            Regras reg = new Regras();
            No no = new No(0,tabuleiro);
            setListaNoAberto(no);
            int[] tabuleiroAux = null;
            this.noSolucao = buscaLargura(no,0,estadoFinal,reg,tabuleiroAux);
            marcaNoSolucao(this.noSolucao);
        }else{
            System.out.println("Busca já realizada!");
        }
    }

    /**
     * Função auxiliar que realiza a busca em largura de forma recursiva.
     * @param no
     * @return
     */
    private No buscaLargura(No no, int interacao,EstadoFinal estadoFinal,Regras reg,int [] tabuleiroAux) {
        if(interacao < 300){
            if (!estadoFinal.getEstadoFinal(no.getTabuleiro())) {
                tabuleiroAux = no.getTabuleiro().clone();
                if (reg.getRegraUm(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    if (!this.filaNosFechado.contains(novoNo) || !this.filaNosAberto.contains(novoNo)) {
                        no.setNoFilho(novoNo);
                        novoNo.setNoAnterior(no);
                        setListaNoAberto(novoNo);
                    } else {
                        novoNo = null;
                    }
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if (reg.getRegraDois(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    if (!this.filaNosFechado.contains(novoNo) || !this.filaNosAberto.contains(novoNo)) {
                        no.setNoFilho(novoNo);
                        novoNo.setNoAnterior(no);
                        setListaNoAberto(novoNo);
                    } else {
                        novoNo = null;
                    }
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if (reg.getRegraTres(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    if (!this.filaNosFechado.contains(novoNo) || !this.filaNosAberto.contains(novoNo)) {
                        no.setNoFilho(novoNo);
                        novoNo.setNoAnterior(no);
                        setListaNoAberto(novoNo);
                    } else {
                        novoNo = null;
                    }
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if (reg.getRegraQuatro(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    if (!this.filaNosFechado.contains(novoNo) || !this.filaNosAberto.contains(novoNo)) {
                        no.setNoFilho(novoNo);
                        novoNo.setNoAnterior(no);
                        setListaNoAberto(novoNo);
                    } else {
                        novoNo = null;
                    }
                }
                tabuleiroAux = null;
                no.setNoExplorado();
                setListaNoFechado(getPrimeiroNoAberto());
                return buscaLargura(getProximoNoAberto(), interacao + 1, estadoFinal, reg, tabuleiroAux);
            } else {
                return no;
            }
        }else{
            return no;
        }
    }

    private void marcaNoSolucao(No noSolucao){
        noSolucao.setNoSolucao();
        if(noSolucao.getNoAnterior() != null){
            marcaNoSolucao(noSolucao.getNoAnterior());
        }
    }


}
