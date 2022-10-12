
package Inicio;

import Backtracking.Backtracking;

import java.util.Arrays;

/**
 *
 * @author pedro
 */
public class Main {

    public static void main(String[] args){

        Backtracking back = new Backtracking();
        int[] estadoInicial = {11,0,12,0,21,0,22,0};
        int[] estadoFinal = back.iniciaBusca(estadoInicial);
        System.out.print("Tabuleiro inicial: "+Arrays.toString(back.getTabuleiroRaiz())+"\n");
        System.out.print("Tabuleiro final:   "+Arrays.toString(estadoFinal)+"\n");
        System.out.println("Nivel da busca:    "+back.getNivel());

    }
}
