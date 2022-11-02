
package Inicio;

import Backtracking.Backtracking;
import Largura.Largura;
import Profundidade.Profundidade;

import java.util.Arrays;

/**
 *
 * @author pedro
 */
public class Main {

    public static void main(String[] args){
        int[] estadoInicial = {11,0,12,0,21,0,22,0};
        int[] estadoFinal;

        /**
         * execução da busca backtracking
         */

        Backtracking back = new Backtracking();
        estadoFinal =  back.iniciaBusca(estadoInicial);
        System.out.print("Tabuleiro inicial: "+Arrays.toString(back.getTabuleiroRaiz())+"\n");
        System.out.print("Tabuleiro final:   "+Arrays.toString(estadoFinal)+"\n");
        System.out.println("Nivel da busca:    "+back.getNivel());


        /**
         * execução da busca em largura
         */
        /**
        Largura largura = new Largura();
        estadoFinal = largura.iniciaBusca(estadoInicial);
        System.out.print("Tabuleiro inicial: "+Arrays.toString(largura.getTabuleiroRaiz())+"\n");
        System.out.print("Tabuleiro final:   "+Arrays.toString(estadoFinal)+"\n");
        System.out.println("Nivel da busca:    "+largura.getNivel());
        */

        /**
         * execução da busca em profundidade
         */


        Profundidade profundidade = new Profundidade();
        estadoFinal = profundidade.iniciaBusca(estadoInicial);
        System.out.println("Nivel da busca:    "+profundidade.getNivel());
        System.out.print("Tabuleiro inicial: "+Arrays.toString(profundidade.getTabuleiroRaiz())+"\n");
        System.out.print("Tabuleiro final:   "+Arrays.toString(estadoFinal)+"\n");
    }
}
