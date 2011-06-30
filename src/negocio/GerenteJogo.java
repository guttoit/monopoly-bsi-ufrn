/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import gui.TabuleiroGUI;
import java.util.List;
import java.util.Scanner;
import negocio.negocioConcreto.Jogo;
import negocio.objetosNulo.GerenteCompraVendaObjetoNulo;
import negocio.objetosNulo.MensagensObjetoNulo;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.Propriedade;

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

    /**
     *
     */
    protected FactoryCriador factory;
    /**
     *
     */
    protected int numJogadores = 0;
    /**
     *
     */
    protected Mensagens mensagens = new MensagensObjetoNulo();
    /**
     *
     */
    protected GerenteCompraVenda gerenteCompraVenda = new GerenteCompraVendaObjetoNulo();
    /**
     *
     */
    protected GerenteSorteCofre gerenteSorteCofre;
    /**
     *
     */
    protected TabuleiroGUI tabuleiroGUI;
    /**
     *
     * @param factory
     */
    public GerenteJogo(FactoryCriador factory) {
        this.factory = factory;
    }

    /**
     *
     * @param factory
     * @param mensagens
     * @param gerenteCompraVenda
     * @param gerenteSorteCofre
     */
    public GerenteJogo(FactoryCriador factory, Mensagens mensagens, GerenteCompraVenda gerenteCompraVenda, GerenteSorteCofre gerenteSorteCofre) {
        this.factory = factory;
        this.gerenteSorteCofre = gerenteSorteCofre;
        this.gerenteCompraVenda = gerenteCompraVenda;
        this.mensagens = mensagens;
    }

    /**
     *Método usado para inicializar um vetor de strings que conterá as cores do jogo.
     */
    public abstract void inicializaCores();

    /**
     * Faz o peao andar e identifica onde o mesmo se localizará a partir da jogada atual
     * @param valorDado
     * @param jogador
     * @param tabuleiro
     * @return Lugar
     */
    public abstract Lugar andaPeao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro);

    /**
     * Método usado em andaPeao para verificar qual a posição antiga com a próxima, verificando se ele
     * passou pela posição inicial do jogo o que acarretará em um ganho de 200 pelo jogador.
     *
     * @param valorDado
     * @param jogador
     * @param tabuleiro
     * @return
     */
    public abstract boolean verificaPosicao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro);

    /**
     * Método utilizado pra gerenciar o jogo. É ele que "conversa" com o jogador ou dispara outros
     * métodos. Esse método usará o padrão de projeto Template method
     * @param tab
     * @param teclado
     * @param b
     * @param jogadores
     *
     */
    public void gerenciaJogo(Tabuleiro tab, Scanner teclado, Banco b, List<Jogador> jogadores) {
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
        //Passa a lista de Jogadores para o TabuleiroGUI
        tabuleiroGUI.setListaJogadores(jogadores);
        tabuleiroGUI.inicializaPeoes();
        tabuleiroGUI.inicicaJogo();
        System.out.println("\nO jogo iniciou");
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
        // Verifica se os outros jogadores perderam ou desistiram, restando apenas um, que será o vencedor.
        if (numJogadores == 1) {
            System.out.println("\nParabéns " + jogadores.get(0).getNomeJogador() + " ! Você é o mais novo"
                    + " milionario da America!");
            System.exit(0);
        }

    }

    /**
     * Esse método tem a função quase que idêntica a do método realizaJogada, porém é utilizado quando um
     * jogador encontra-se na prisão.
     * @param jogadores
     * @param tab
     * @param jogadorVez
     * @param teclado
     * @param b
     * @param numJogAtual
     * @return
     */
    public abstract Lugar realizaJogadaPrisao(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int numJogAtual);

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
    public abstract int realizaJogada(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int i);

    /**
     * Método usado para coletar e armazenar os nomes e as respectivas cores dos jogadores.
     * @param jogadores
     * @param numJogadores
     * @param teclado
     */
    public abstract void armazenaNomeECorJogadores(List<Jogador> jogadores, int numJogadores, Scanner teclado);

     // Verifica se o jogador tem propriedades para vender.
    /**
     *
     * @param j
     * @return
     */
    public abstract boolean podeVender(Jogador j);

    /**
     *
     * @param jogador
     * @param jogo
     * @param propriedade
     */
    public abstract void evitaFalencia(Jogador jogador, Jogo jogo, Propriedade propriedade );

    /**
     *
     * @return
     */
    public TabuleiroGUI getTabuleiroGUI() {
        return tabuleiroGUI;
    }

    /**
     *
     * @param tabuleiroGUI
     */
    public void setTabuleiroGUI(TabuleiroGUI tabuleiroGUI) {
        this.tabuleiroGUI = tabuleiroGUI;
    }

    
}
