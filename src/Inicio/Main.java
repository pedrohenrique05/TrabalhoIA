
package Inicio;

import Backtracking.Backtracking;

/**
 *
 * @author pedro
 */
public class Main {

    public static void main(String[] args){

        Backtracking back = new Backtracking();
        int[] estadoInicial = {1,0,1,0,2,0,2,0};
        int[] estadoFinal = back.iniciaBusca(estadoInicial);
        System.out.print(estadoFinal.length);
    }
}
