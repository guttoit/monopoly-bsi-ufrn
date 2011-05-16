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


 /*
     *@class A classe ImpostoRiqueza é uma classe concreta. É um tipo de imposto que representa uma taxa de $75 a ser paga pelo jogardo
   * que cair neste lugar.
     *
     */
public class ImpostoRiqueza extends Imposto{


    public ImpostoRiqueza(int posicao, String nome, float preco){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
    }
}