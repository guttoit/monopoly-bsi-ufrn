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
import tabuleiro.tabuleiroConcreto.Propriedade;

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
     * @return
     */
    public String mensagensBoasVindas();

    /**
     * Metodo para mostrar mensagem de tentativas de execucoes erradas.
     * @param nivelBurrice
     * @param numDigitado
     * @return
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

    /**
     *
     * @param jogador
     * @param l
     * @param valorDado
     */
    public void mostraMensAndaPeao(Jogador jogador, Lugar l, Integer[] valorDado);

    /**
     *
     */
    public void visitaPrisao();

    /**
     *
     */
    public void vaParaPrisao();

    /**
     *
     * @param jogador
     * @param teclado
     * @return
     */
    public String mensagemEstaPreso(Jogador jogador, Scanner teclado);

    /**
     *
     * @param jogador
     * @param teclado
     * @return
     */
    public String mensagemEstaPresoComCarta(Jogador jogador, Scanner teclado);

    /**
     *
     * @param jogador
     * @param lugares
     * @param teclado
     * @return
     */
    public int mensagemConstruir(Jogador jogador, List<LugarFisico> lugares, Scanner teclado);


    /**
     *
     * @param j
     * @param teclado
     * @param lugares
     * @return
     */
    public int mensagemVenda(Jogador j, Scanner teclado, List<LugarFisico> lugares);

    /**
     *
     * @param j
     * @param teclado
     * @return
     */
    public String MensagemTitulosHipoteca(Jogador j, Scanner teclado);

    /**
     *
     * @param p
     * @param teclado
     * @return
     */
    public String MensagemVendaHabitacoes(Propriedade p,Scanner teclado);




}
