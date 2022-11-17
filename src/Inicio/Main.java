
package Inicio;

import Backtracking.Backtracking;
import Largura.Largura;
import Largura.LarguraArrayList;
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
        /**
        System.out.println("Execução da busca backtracking");
        Backtracking back = new Backtracking();
        back.iniciaBusca(estadoInicial);
        System.out.print("Tabuleiro inicial: "+Arrays.toString(back.getTabuleiroRaiz())+"\n");
        System.out.print("\nCaminho da Raiz a folha\n");
        back.imprimeCaminhoDaRaizAFolha(back.getNoSolucao());
        System.out.print("\nCaminho da folha a raiz\n");
        back.imprimeCaminhoDaFolhaARaiz(back.getNoSolucao());
        */

        /**
         * execução da busca em largura
         */

        System.out.println("Execução da busca em largura");
        Largura largura = new Largura();
        largura.iniciaBusca(estadoInicial);
        //LarguraArrayList larguraArrayList = new LarguraArrayList();
        //larguraArrayList.iniciaBusca(estadoInicial);
        System.out.print("Tabuleiro inicial: "+Arrays.toString(largura.getTabuleiroRaiz())+"\n");
        System.out.println("\nCaminho da Raiz a folha\n");
        largura.imprimeCaminhoDaFolhaARaiz(largura.getNoSolucao());
        System.out.println("\nCaminho da folha a raiz\n");
        largura.imprimeCaminhoDaRaizAFolha(largura.getNoSolucao());
        //System.out.print("Tabuleiro final:   "+Arrays.toString(estadoFinal)+"\n");
        System.out.println("Nivel da busca:    "+largura.getNivel());

        /**
         * execução da busca em profundidade
         */
        /**
        System.out.println("Execução da busca em profundidade");
        Profundidade profundidade = new Profundidade();
        estadoFinal = profundidade.iniciaBusca(estadoInicial);
        System.out.println("Nivel da busca:    "+profundidade.getNivel());
        System.out.print("Tabuleiro inicial: "+Arrays.toString(profundidade.getTabuleiroRaiz())+"\n");
        System.out.print("Tabuleiro final:   "+Arrays.toString(estadoFinal)+"\n");
        */
    }
}
