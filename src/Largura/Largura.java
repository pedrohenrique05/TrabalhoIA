package Largura;
import java.util.LinkedList;
import java.util.Queue;
import InfoGerais.EstadoFinal;
import InfoGerais.Regras;

/**
 *
 * @author pedro
 */
public class Largura {
    private No raiz;
    private Queue<No> filaNosAberto = new LinkedList<>();
    private Queue<No> filaNosFechado = new LinkedList<>();

    public Largura(){
        this.raiz = null;
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
     * Auxilia a função principal a retorna o nível da arvore de busca de forma recursiva.
     * @param no
     * @return
     */
    private int getNivelAux(No no){
        if(no.getProx() != null){
            return getNivelAux(no.getProx());
        }else{
            return no.getNivel();
        }
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
    public int[] iniciaBusca(int [] tabuleiro){
        if(this.raiz == null){
            No no = new No(0,tabuleiro);
            setListaNoAberto(no);
            return buscaLargura(no,0);
        }else{
            System.out.println("Busca já realizada!");
            return null;
        }
    }

    /**
     * Função auxiliar que realiza a busca em largura de forma recursiva.
     * @param no
     * @return
     */
    private int[] buscaLargura(No no, int interacao) {
        EstadoFinal estadoFinal = new EstadoFinal();
      //  if(interacao < 5799){
            if(!estadoFinal.getEstadoFinal(no.getTabuleiro())){
                int[] tabuleiroAux = no.getTabuleiro().clone();
                Regras reg = new Regras();
                if(reg.getRegraUm(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setProx(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(reg.getRegraDois(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setProx(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(reg.getRegraTres(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setProx(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                tabuleiroAux = no.getTabuleiro().clone();
                if(reg.getRegraQuatro(tabuleiroAux)) {
                    No novoNo = new No(no.getNivel() + 1, tabuleiroAux);
                    no.setProx(novoNo);
                    novoNo.setNoAnterior(no);
                    setListaNoAberto(novoNo);
                }
                setListaNoFechado(getPrimeiroNoAberto());
                return buscaLargura(getProximoNoAberto(),interacao+1);
            }else{
                return no.getTabuleiro();
            }
        //}else{
        //    return no.getTabuleiro();
        //}

    }
}
