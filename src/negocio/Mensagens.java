/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Scanner;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Gutto
 */
/**
 *
 * @interface Mensagens contem as assinaturas dos métodos utilizados por MensagensJogo para exibir
 * as principais mensagens do sistema.
 */
public interface Mensagens {

    /**
     * Metodo para mostrar mensagesn de boas vindas ao usuario
     *
     */
    public String mensagensBoasVindas();

    /**
     * Metodo para mostrar mensagem de tetativas de execucoes erradas.
     * @param nivelBurrice
     * @param numDigitado
     */
    public String nivelBurrice(int nivelBurrice, int numDigitado);

    /**
     * Metodo para mostrar a mensagem inicial pedindo o nome do jogador
     * @param numJogador
     * @param  teclado
     *
     * @return  String
     */
    public String mensagemNome(int numJogador, Scanner teclado);

    /**
     * Metodo para mostrar as mensagem com as cores disponiveis no jogo
     * @param jogador Jogador,
     * @param cores
     * @param numJogador
     * @param teclado
     * @return String
     */
    public String mensagemCores(Jogador jogador, String[] cores, int numJogador, Scanner teclado);

    /**
     * * Metodo para mostrar em que posicao está a propriedade e pegunta se o jogador deseja comprá-la
     * @param j
     * @param l
     */
    public void geraStatus(Jogador j, LugarFisico l);

    /**
     * Metodo para mostrar a situacao atual do jogador
     * @param j
     * @param t
     */
    public void statusJogador(Jogador j, Tabuleiro t);
}
