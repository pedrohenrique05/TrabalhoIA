package InfoGerais;

/**
 *
 * @author pedro
 */
public class EstadoFinal {
    private final int[] estFinal;

    {
        estFinal = new int[]{2, 0, 2, 0, 1, 0, 1, 0};
    }

    public boolean getEstadoFinal(int[] tabuleiro){
        return tabuleiro == this.estFinal;
    }
}
