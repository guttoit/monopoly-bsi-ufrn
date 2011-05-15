/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

/**
 *
 * @author Gutto
 */

/**
 *
 * @class A class ImpostoRiqueza é um tipo de imposto. Representa uma taxa de $75 a ser paga pelo jogador
 * ao Banco.
 */
public class ImpostoRiqueza extends Imposto{


    public ImpostoRiqueza(int posicao, String nome, float preco){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
    }
}
