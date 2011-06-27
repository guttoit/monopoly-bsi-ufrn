/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;

import player.Dado;
import player.Jogador;
import player.Baralho;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import player.concretos.CartaCofresComunitarios;
import player.concretos.Peao;
import player.concretos.CartaSorteReves;
import tabuleiro.GrupoAbstrato;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.tabuleiroConcreto.ImpostoRenda;
import tabuleiro.tabuleiroConcreto.ImpostoRiqueza;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.Propriedade;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.Grupo;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.SorteRevesConcreto;

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
    public Propriedade criaPropriedade(List<Lugar> lugares, int posicao, String nome, Grupo grupo, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa);

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
     *<p> cria imposto de renda no qual o jogador poderá ser taxado </p>
     * @param lugares
     * @param posicao
     * @param nome
     * @param preco
     * @return ImpostoRenda
     */
    public ImpostoRenda criaImpostoRenda(List<Lugar> lugares, int posicao, String nome, float preco);

    /**
     *<p> cria imposto de renda no qual o jogador poderá ser taxado </p>
     * @param lugares
     * @param posicao
     * @param nome
     * @param preco
     * @return ImpostoRiqueza
     */
    public ImpostoRiqueza criaImpostoRiqueza(List<Lugar> lugares, int posicao, String nome, float preco);

    /**
     *<p> cria Tabuleiro a ser percorrido pelo jogador </p>
     * @param numCasas
     * @return Tabuleiro
     */
    public Tabuleiro criaTabuleiro(int numCasas);

    public GrupoAbstrato criaGrupo(List<LugarFisico> lugares, String cor);

    public GrupoAbstrato criaGrupo(String cor);

    /**
     *<p> Cria gerente que é responsável por controlar o jogo  </p>
     * @param f
     * @param mens 
     * @param gCV
     * @param gSC
     * @return GerenteJogo
     */
    public GerenteJogo criaGerente(FactoryCriador f, Mensagens mens, GerenteCompraVenda gCV, GerenteSorteCofre gSC);

    /**
     *<p> Cria gerenteSorteCofre que é responsável gerenciar as cartas do cofre comunitario e sorte reves <p>
     * @param bSR
     * @param bCC
     * @return
     */
    public GerenteSorteCofre criaGerenteSorteCofre(BaralhoSorteReves bSR, BaralhoCofreComunitario bCC);

    /**
     * <p> Cria CofreComunitarioConcreto que é responsável por gerenciar o lugar aCofresComunitarios <p>
     * @param lugares
     * @param posicao
     * @param nome
     * @return
     */
    public CofreComunitarioConcreto criaCofresComunitarios(List<Lugar> lugares, int posicao, String nome);

    /**
     *<p> Cria  GerenteCompraVenda que é responsável por gerenciar a compra e venda de propriedade <p>
     * @param f
     * @return
     */
    public GerenteCompraVenda criaGerenteCompraVenda(FactoryCriador f);

    /**
     * <p> Cria  CartaCofresComunitarios que é responsável por gerenciar as cartar referente ao cofre comunitario <p>
     * @param baralho
     * @param numeroCarta
     * @param nomeCarta
     * @param descricao
     * @param observacoes
     * @return CartaCofresComunitarios
     */
    public CartaCofresComunitarios criaCartasCofresComunitarios(Baralho baralho, int numeroCarta, String nomeCarta, String descricao, String observacoes);

    /**
     *  <p> Cria  SorteRevesConcretoque é um lugar no tabuleiro <p>
     * @param lugares
     * @param posicao
     * @param nome
     * @return
     */
    public SorteRevesConcreto criaSorteReves(List<Lugar> lugares, int posicao, String nome);

    /**
     * <p> Cria CartasSorteReves que é responsável por gerenciar as cartar referente ao Sorte reves<p>
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

    public Banco criaBanco(int numCasas, int numHoteis);

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

    /**
     *
     * @param nome
     * @param posicao
     * @return
     */
    public Lugar criaPrisao(String nome, int posicao);

    /**
     *
     * @param nome
     * @param posicao
     * @return
     */
    public Lugar criaVaParaPrisao(String nome, int posicao);

    /**
     *
     * @param nome
     * @param posicao
     * @param preco
     * @return
     */
    public Lugar criaServicopublico(String nome, int posicao, float preco);

    /**
     *
     * @param nome
     * @param posicao
     * @param preco
     * @return
     */
    public Lugar criaParadaLivre(String nome, int posicao, float preco);
}
