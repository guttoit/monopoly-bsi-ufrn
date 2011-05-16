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
public class ImpostoRenda extends Imposto {


    public ImpostoRenda(int posicao, String nome, float preco){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
    }
}