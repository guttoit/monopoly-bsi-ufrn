/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro.tabuleiroConcreto;

import tabuleiro.Lugar;

/**
 *
 * @author Adm
 */

/**
 *
 * @class classe Servico publico é um lugar fisico que representa .....
 *
 *
 */
public class ServicoPublico extends Lugar {
    private float preco;

    public ServicoPublico(String nome, int posicao, float preco) {
        super(nome , posicao);
        this.preco = preco;
        
    }



}
