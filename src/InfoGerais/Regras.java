
package InfoGerais;

/**
 *
 * @author pedro
 */
public class Regras {

    public int getRegraDir(int indice){
        return ((indice+3)%8+8)%8;
    }

    public int getRegraEsq(int indice){
        return ((indice-3)%8+8)%8;
    }
}
