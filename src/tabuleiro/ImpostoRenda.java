/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

/**
 *
 * @author Adm
 */

/**
 *
 * @class A class ImpostoRenda é um tipo de imposto. Representa uma taxa de 200 a ser paga pelo jogador 
 * ao Banco. 
 */


public class ImpostoRenda extends Imposto {


    public ImpostoRenda(int posicao, String nome, float preco){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
    }
}
