/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro.tabuleiroConcreto;

import tabuleiro.Imposto;

/**
 *
 * @author Adm
 */

  /**
   *@class A classe ImpostoRenda é uma classe concreta. É um tipo de imposto que representa uma taxa de $200 a ser paga pelo jogardo
   * que cair neste lugar.
   *
   */


public class ImpostoRenda extends Imposto {


    /**
     *
     * @param posicao
     * @param nome
     * @param preco
     */
    public ImpostoRenda(int posicao, String nome, float preco){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
    }
}