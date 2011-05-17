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
 * @class A class ImpostoRiqueza é um tipo de imposto. Representa uma taxa a ser paga pelo jogador
 * ao Banco. Serve de interface para outros tipos de imposto riqueza.
 */
public class ImpostoRiqueza extends Imposto{


    public ImpostoRiqueza(int posicao, String nome, float preco){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
    }
}
