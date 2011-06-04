/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import java.util.Scanner;
import negocio.objetosNulo.GerenteCompraVendaObjetoNulo;
import negocio.objetosNulo.MensagensObjetoNulo;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.Tabuleiro;

/**
 *
 * @author adm
 */

/**
 *
 * @interface GerenteJogo contem as assinaturas dos métodos utilizados por GerenteConcreto.
 * O GerenteConcreto é quem é responsável por administrar todo o jogo, desde andar o peão para o jogador
 * até vender os lugares.
 * 
 */
public abstract class GerenteJogo {

    protected FactoryCriador factory;
    protected  int numJogadores = 0;
    protected  Mensagens mensagens = new MensagensObjetoNulo();
    protected  GerenteCompraVenda gerenteCompraVenda = new GerenteCompraVendaObjetoNulo();
    protected  GerenteSorteCofre gerenteSorteCofre;

    public GerenteJogo(FactoryCriador factory) {
        this.factory = factory;
    }

    public GerenteJogo(FactoryCriador factory, Mensagens mensagens, GerenteCompraVenda gerenteCompraVenda, GerenteSorteCofre gerenteSorteCofre) {
        this.factory = factory;
        this.gerenteSorteCofre = gerenteSorteCofre;
        this.gerenteCompraVenda = gerenteCompraVenda;
        this.mensagens = mensagens;
    }



    public abstract void inicializaCores();
    /**
     * Faz o peao andar e identifica onde o mesmo se localizará a partir da jogada atual
     * @param valorDado
     * @param jogador
     * @param tabuleiro
     * @return Lugar
     */
      public abstract Lugar andaPeao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro);

      public abstract boolean verificaPosicao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro);
      /**
     * Método utilizado pra gerenciar o jogo. É ele que "conversa" com o jogador ou dispara outros
     * métodos.
     * @param tab
     * @param teclado
     * @param b
     * @param jogadores
     */

    public void gerenciaJogo(Tabuleiro tab, Scanner teclado, Banco b, List<Jogador> jogadores){
        int auxNumJogadores;
        int nivelBurrice = 0;
        System.out.println("Digite o numero de jogadores: ");
        // Esse laço é usado para verificar se o jogador tem condições de entender os comandos do jogo.
        // Caso o jogador erre o número de jogadores mais de 4 vezes o jogo é encerrado.
        while (numJogadores == 0 && nivelBurrice < 4) {

            if (teclado.hasNextInt()) {

                auxNumJogadores = teclado.nextInt();

                if (auxNumJogadores >= 2 && auxNumJogadores <= 8) {
                    numJogadores = auxNumJogadores;
                    jogadores = factory.criaListaJogadores(numJogadores);


                } else {
                    nivelBurrice++;
                    System.out.println(mensagens.nivelBurrice(nivelBurrice, auxNumJogadores));
                }
            } else {
                System.out.println("Digite um número inteiro entre 2 e 8: ");
                teclado.next();

            }
        }
        if (nivelBurrice == 4) {
            return;
        }

        // Chama o método para receber os nomes e as cores dos jogadores
        armazenaNomeECorJogadores(jogadores, numJogadores, teclado);

        System.out.println("\nO jogo iniciou\n");
        int jogadorAtual = 0;
        int jogadorDepoisJogada = 0;
        while (numJogadores >= 2) {
            if (jogadorAtual >= numJogadores) {
                jogadorAtual = 0;
            }
            jogadorDepoisJogada = realizaJogada(jogadores, tab, jogadores.get(jogadorAtual), teclado, b, jogadorAtual);
            // Verifica se algum jogador desistiu do jogo ou perdeu.
            // Caso sim, o próximo jogador estará na mesma posição na lista de jogadores que o jogador
            //que saiu
            if (jogadorDepoisJogada < jogadorAtual) {
                jogadorAtual = jogadorDepoisJogada;
            }
            jogadorAtual++;

        }
        if (numJogadores == 1) {
            System.out.println("\n\n\n Parabéns " + jogadores.get(0).getNomeJogador() + " ! Você é o mais novo"
                    + " milionario da America!");
            System.exit(0);
        }

    }

    /**
     * Método responsável por analisar e realizar a jogada escolhida pelo jogador. Ele é chamado
     * pelo método gerenciaJogo, logo após a fase de coleta das informações dos jogadores.
     * @param jogadores
     * @param tab
     * @param jogadorVez
     * @param teclado
     * @param b
     * @param i
     * @return
     */
    public abstract int realizaJogada(List<Jogador> jogadores,Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int i);

     public abstract void armazenaNomeECorJogadores(List<Jogador> jogadores, int numJogadores, Scanner teclado);
    

}
