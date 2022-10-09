package InfoGerais;

/**
 *
 * @author pedro
 */
public class EstadoFinal {
    private final int[] estFinal;

    {
        estFinal = new int[]{21, 0, 22, 0, 11, 0, 12, 0};
    }

    public boolean getEstadoFinal11(int indice){
        if(indice == 4)
            return true;
        else {
            return false;
        }
    }
    public boolean getEstadoFinal12(int indice){
        if(indice == 6)
            return true;
        else {
            return false;
        }
    }
    public boolean getEstadoFinal21(int indice){
        if(indice == 0)
            return true;
        else {
            return false;
        }
    }
    public boolean getEstadoFinal22(int indice){
        if(indice == 2)
            return true;
        else {
            return false;
        }
    }
    public boolean getEstadoFinal(int[] tabuleiro){
        return tabuleiro == this.estFinal;
    }
}
