package Largura;

/**
 *
 * @author pedro
 */
public class Largura {

    private int getNivelEsq(No no){
        if(no.getEsq() != null){
            return getNivelEsq(no.getEsq());
        }else if(no.getDir() != null){
            return getNivelDir(no.getDir());
        }else{
            return no.getNivel();
        }
    }
    private int getNivelDir(No no){
        if(no.getDir() != null){
            return getNivelDir(no.getDir());
        }else if(no.getEsq() != null){
            return getNivelEsq(no.getEsq());
        }else{
            return no.getNivel();
        }
    }

    public void nivelArvore(No no){
        int nivelEsq = getNivelEsq(no);
        int nivelDir = getNivelDir(no);
        if(nivelEsq >= nivelDir){
            System.out.println("O nivel da arvore é: "+nivelEsq) ;
        }else{
            System.out.println("O nivel da arvore é: "+nivelDir);
        }
    }
    private No raiz;

    Largura(){
        this.raiz = null;
    }

    void inserir(int chave){
        if(this.raiz == null){
            this.raiz = new No(chave,0);
        }else{
            inserirAux(this.raiz, chave);
        }
    }

    void inserirAux(No no, int chave){

    }

}
