package Largura;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import InfoGerais.EstadoFinal;
import InfoGerais.Regras;

/**
 *
 * @author pedro
 */
public class Largura {

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
    private EstadoFinal estadoFinal;
    private Regras reg = new Regras();
    private No noSolucao;
    private No raiz;
    private Queue<No> filaNosAberto = new LinkedList<>();
    private Queue<No> filaNosFechado = new LinkedList<>();

    public Largura(){
        this.estadoFinal = new EstadoFinal();
        this.reg = new Regras();
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
        return this.filaNosFechado.peek().getTabuleiro();
    }

    /**
     *
     * @return o nivel da arvore de busca
     */
    public int getNivel(){
        No noAux = null;
        while(this.filaNosFechado.size() != 0){
            noAux = filaNosFechado.poll();
        }
        return noAux.getNivel();
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
        return this.filaNosAberto.poll();
    }

    /**
     * Informa qual será o próximo No a ser explorado.
     * @return
     */
    private No getProximoNoAberto(){
        return this.filaNosAberto.peek();
    }

    /**
     * Função a ser chamada para começar a busca em largura.
     * @param tabuleiro
     * @return
     */
    public void iniciaBusca(int [] tabuleiro){
        if(this.raiz == null){
            No no = new No(0,tabuleiro);
            setListaNoAberto(no);
            this.noSolucao =  buscaLargura(no,0,null);
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
    private No buscaLargura(No no, int interacao,int[] tabuleiroAux) {

        if(interacao < 2505){
            if(!this.estadoFinal.getEstadoFinal(no.getTabuleiro())){
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraUm(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraDois(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraTres(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(this.reg.getRegraQuatro(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setNoFilho(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                tabuleiroAux = null;
                //no.setNoExplorado();
                setListaNoFechado(getPrimeiroNoAberto());
                return buscaLargura(getProximoNoAberto(),interacao+1,null);
            }else{
                setListaNoFechado(no);
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
