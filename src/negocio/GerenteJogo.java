/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import java.util.Scanner;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Adm
 */

/**
 *
 * @interface GerenteJogo contem as assinaturas dos métodos utilizados por GerenteConcreto para
 * realizar os princiapais passos do jogo.
 */
public  interface GerenteJogo {

    /**
     * Faz o peao andar e identifica onde o mesmo se localizará a partir da jogada atual
     * @param valorDado
     * @param jogador
     * @param tabuleiro
     * @return Lugar
     */
      public Lugar andaPeao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro);

      /**
     * Método utilizado pra gerenciar o jogo. É ele que "conversa" com o jogador ou dispara outros
     * métodos.
     * @param tab
     * @param teclado
     * @param b
     * @param jogadores
     * @param mensagens
     */
    public void gerenciaJogo(Tabuleiro tab, Scanner teclado, Banco b, List<Jogador> jogadores, Mensagens mensagens);

    /**
     * Método responsável por analisar e realizar a jogada escolhida pelo jogador. Ele é chamado
     * pelo método gerenciaJogo, logo após a fase de coleta das informações dos jogadores.
     * @param jogadores
     * @param tab
     * @param jogadorVez
     * @param teclado
     * @param b
     * @param mensagens
     */
    public void realizaJogada(List<Jogador> jogadores,Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, Mensagens mensagens);

    /**
     * Gerencia compra é responsável por receber o comando do jogador dizendo se ele comprou ou não
     * o lugarFísico oferecido.
     * @param l
     * @param jogador
     * @param teclado
     * @return boolean
     */
    public boolean gerenciaCompra(LugarFisico l, Jogador jogador, Scanner teclado, Banco b);

}
