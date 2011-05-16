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
public class ImpostoRiqueza extends Imposto{


    public ImpostoRiqueza(int posicao, String nome, float preco){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
    }
}