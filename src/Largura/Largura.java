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

    Largura(){
        this.raiz = null;
    }

    Queue<No> filaNos = new LinkedList<>();



}
