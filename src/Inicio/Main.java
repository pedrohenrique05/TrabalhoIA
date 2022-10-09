
package Inicio;

import Backtracking.Backtracking;

/**
 *
 * @author pedro
 */
public class Main {

    public static void main(String[] args){

        Backtracking back = new Backtracking();
        int[] estadoInicial = {11,0,12,0,21,0,22,0};
        int[] estadoFinal = back.iniciaBusca(estadoInicial);
        if(estadoFinal == null){
            System.out.print("Estado não encontrado");
        }else{
            for (int j : estadoFinal) {
                System.out.print(j + " ");
            }
        }

    }
}
