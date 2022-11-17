package InfoGerais;

import java.util.Arrays;

/**
 *
 * @author pedro
 */
public class EstadoFinal {
    private final int[] estFinal = {21, 0, 22, 0, 11, 0, 12, 0};
    /**
    public boolean getEstadoFinal11(int indice){
        return indice == 4;
    }
    public boolean getEstadoFinal12(int indice){
        return indice == 6;
    }
    public boolean getEstadoFinal21(int indice){
        return indice == 0;
    }
    public boolean getEstadoFinal22(int indice){
        return indice == 2;
    }
    */
    public boolean getEstadoFinal(int[] tabuleiro){
        return Arrays.equals(tabuleiro, this.estFinal);
    }
}
