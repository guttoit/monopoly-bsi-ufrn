/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import player.Dado;
import player.Jogador;
import player.concretos.Baralho;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import player.concretos.CartaCofresComunitarios;
import player.concretos.Peao;
import player.concretos.CartaSorteReves;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.tabuleiroConcreto.ImpostoRenda;
import tabuleiro.tabuleiroConcreto.ImpostoRiqueza;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.Propriedade;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.Prisao;
import tabuleiro.tabuleiroConcreto.SorteRevesConcreto;
import tabuleiro.tabuleiroConcreto.VaParaPrisao;

/**
 *
 * @author Gutto
 */
/**
 * 
 * @interface A interface FatoryCriador contém as assinaturas dos métodos de FactoryUSA.
 * Ela representa um abstractFactory que contem os métodos responsáveis por criar as instâncias
 * de todas as classes de domínio presente no jogo. <br/>
 * Você pode extendê-la e criar o seu próprio factoryCriador.
 *
 */
public interface FactoryCriador {

    /**
     * <p> Cria uma estrutura do tipo List<JOgador>  </p>
     * @param numJogadores int
     * @return List<Jogador>
     */
    public List<Jogador> criaListaJogadores(int numJogadores);

    /**
     * <p> Método responsável por criar um Jogador do jogo. </p>
     * @return Jogador
     */
    public Jogador criaJogador();

    /**
     *  <p> Método responsável por criar um Dado para o jogo. </p>
     * @return Dado
     */
    public Dado criaDado();

    /**
     *  <p> Método responsável por criar um peão com sua respectiva cor. </p>
     * @param cor String
     * @return Peao
     */
    public Peao criaPeao(String cor);

    /**
     *  <p> Método responsável por criar um Lugar do jogo. </p>
     * @param lugares
     * @param posicao
     * @param nome
     * @return Lugar
     */
    public Lugar criaLugar(List<Lugar> lugares, int posicao, String nome);

    /**
     * <p> Cria uma lista de lugares </p>
     * @param numLugares
     * @return List<Lugar>
     */
    public List<Lugar> criaLugares(int numLugares);

    /**
     * <p> Criar uma propriedade</p>
     * @param lugares
     * @param posicao
     * @param nome
     * @param cor
     * @param precoP
     * @param aluguelSCasa
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @param hotel
     * @param hip
     * @param precoCasa
     * @return Propriedade
     */
    public Propriedade criaPropriedade(List<Lugar> lugares, int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa);

    /**
     * <p> Cria uma Ferrovia</p>
     * @param lugares
     * @param posicao
     * @param nome
     * @param preco
     * @param hipoteca
     * @return Ferrovia
     */
    public Ferrovia criaFerrovia(List<Lugar> lugares, int posicao, String nome, float preco, float hipoteca);

    /**
     *
     * @param lugares
     * @param posicao
     * @param nome
     * @param preco
     * @return ImpostoRenda
     */
    public ImpostoRenda criaImpostoRenda(List<Lugar> lugares, int posicao, String nome, float preco);

    /**
     *
     * @param lugares
     * @param posicao
     * @param nome
     * @param preco
     * @return ImpostoRiqueza
     */
    public ImpostoRiqueza criaImpostoRiqueza(List<Lugar> lugares, int posicao, String nome, float preco);

    /**
     *
     * @param numCasas
     * @return Tabuleiro
     */
    public Tabuleiro criaTabuleiro(int numCasas);

    /**
     *
     * @param f
     * @param mens 
     * @param gCV
     * @return GerenteJogo
     */
    public GerenteJogo criaGerente(FactoryCriador f, Mensagens mens, GerenteCompraVenda gCV);


    public CofreComunitarioConcreto criaCofresComunitarios( int posicao, String nome);

    /**
     *
     * @param f
     * @return
     */
    public GerenteCompraVenda criaGerenteCompraVenda(FactoryCriador f);

    /**
     *
     * @param baralho
     * @param numeroCarta
     * @param nomeCarta
     * @param descricao
     * @param observacoes
     * @return CartaCofresComunitarios
     */
    public CartaCofresComunitarios criaCartasCofresComunitarios(Baralho baralho, int numeroCarta, String nomeCarta, String descricao, String observacoes);

    public SorteRevesConcreto criaSorteReves( int posicao , String nome);

    /**
     *
     * @param baralho
     * @param numeroCarta
     * @param nomeCarta
     * @param descricao
     * @param observacoes
     * @return CartaSorteReves
     */
    public CartaSorteReves criaCartasSorteReves(Baralho baralho, int numeroCarta, String nomeCarta, String descricao, String observacoes);

    /**
     *
     * @return Mensagens
     */
    public Mensagens criaMensagens();

    /**
     *
     * @return Banco
     */
    public Banco criaBanco();

    /**
     *
     * @return BaralhoCofreComunitario
     */
    public BaralhoCofreComunitario criaBaralhoCofreComunitario();

    /**
     *
     * @return BaralhoSorteReves
     */
    public BaralhoSorteReves criaBaralhoSorteReves();

    

    public Lugar criaPrisao (String nome, int posicao);

    public Lugar criaVaParaPrisao(String nome, int posicao);




}
