/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.Scanner;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;

/**
 * @interface GerenteCompraVenda contem as assinaturas dos métodos utilizados por GerenteCompraVendaConcreto.
 * O GerenteCompraVendaConcreto é quem é responsável por administrar a parte de compra e venda de propriedades
 * e o desconto de impostos.
 * @author gutto
 */
public interface GerenteCompraVenda {


    /**
     * Gerencia compra é responsável por receber o comando do jogador dizendo se ele comprou ou não
     * o lugarFísico oferecido. Descontando, caso necessite, o seu dinheiro.
     * @param l
     * @param jogador
     * @param teclado
     * @param b
     * @return boolean
     */
    public boolean gerenciaCompra(LugarFisico l, Jogador jogador, Scanner teclado, Banco b);

    /**
     * Método chamado caso o jogador caia em uma lugarFisico que já tenha dono, como uma propriedade
     * ou uma ferrovia. Ele irá anilsar e descontar o preço do aluguel daquele lugar.
     * @param lf
     * @param jogadorVez
     */
    public void descontaAluguel(LugarFisico lf, Jogador jogadorVez) ;

    /**
     * Esse método será chamado caso o jogador caia em uma posição que represente um imposto, que pode ser
     * imposto de renda ou imposto de riqueza. Descontando o seu respectivo valor no dinheiro do jogador
     * e enviando ao banco.
     * @param l
     * @param jogadorVez
     * @param b
     */
    public void descontaImposto(Lugar l, Jogador jogadorVez, Banco b);

    public void construir(Jogador jogador, Propriedade propriedade, Banco banco);

    public void venda(Jogador jogador, Propriedade propriedade, Banco banco);
}
