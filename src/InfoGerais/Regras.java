
package InfoGerais;

/**
 * 11 - cavalo preto um
 * 12 - cavalo preto dois
 * 21 - cavalo branco um
 * 22 - cavalo branco dois
 * Regras de transições:
 * R1 - Cavalo 11 não está no estado final e tem movimentação válida.
 * R2 - Cavalo 12 não está no estado final e tem movimentação válida.
 * R3 - Cavalo 21 não está no estado final e tem movimentação válida.
 * R4 - Cavalo 22 não está no estado final e tem movimentação válida.
 * Observação: Cada movimentação de qualquer cavalo é de 3(três) casas.
 * @author pedro
 */
public class Regras {

    public Regras(){
    }
    public int getRegraDir(int indice){
        return ((indice+3)%8+8)%8;
    }

    public int getRegraEsq(int indice){
        return ((indice-3)%8+8)%8;
    }

    public boolean getRegraUm(int [] tabuleiro){

        for(int i = 0; i < tabuleiro.length; i++){
            if(i != 4 && tabuleiro[i] == 11 && tabuleiro[getRegraDir(i)] == 0){
                tabuleiro[getRegraDir(i)] = tabuleiro[i];
                tabuleiro[i] = 0;
                return true;
            }
        }
        return false;
    }

    public boolean getRegraDois(int [] tabuleiro){
        for(int i = 0; i < tabuleiro.length; i++){
            if( i != 6 && tabuleiro[i] == 12 &&
                    tabuleiro[getRegraDir(i)] == 0){
                tabuleiro[getRegraDir(i)] = tabuleiro[i];
                tabuleiro[i] = 0;
                return true;
            }
        }
        return false;
    }

    public boolean getRegraTres(int [] tabuleiro){
        for(int i = 0; i < tabuleiro.length; i++){
            if((i != 0) && tabuleiro[i] == 21 && tabuleiro[getRegraDir(i)] == 0){
                tabuleiro[getRegraDir(i)] = tabuleiro[i];
                tabuleiro[i] = 0;
                return true;
            }
        }
        return false;
    }

    public boolean getRegraQuatro(int [] tabuleiro){
        for(int i = 0; i < tabuleiro.length; i++){
            if( i != 2 && tabuleiro[i] == 22 && tabuleiro[getRegraDir(i)] == 0){
                tabuleiro[getRegraDir(i)] = tabuleiro[i];
                tabuleiro[i] = 0;
                return true;
            }
        }
        return false;
    }

}
