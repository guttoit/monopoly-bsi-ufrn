package negocio.negocioConcreto;

import java.util.ArrayList;
import java.util.List;
import negocio.Banco;
import negocio.FactoryCriador;
import negocio.GerenteCompraVenda;
import negocio.GerenteJogo;
import negocio.GerenteSorteCofre;
import negocio.Mensagens;
import player.Dado;
import player.Jogador;
import player.Baralho;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import player.concretos.DadoDuplo;
import player.concretos.JogadorConcreto;
import player.concretos.Peao;
import player.concretos.CartaCofresComunitarios;
import player.concretos.CartaSorteReves;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.tabuleiroConcreto.ImpostoRenda;
import tabuleiro.tabuleiroConcreto.ImpostoRiqueza;
import tabuleiro.Lugar;

import tabuleiro.tabuleiroConcreto.Propriedade;

import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.ParadaLivre;
import tabuleiro.tabuleiroConcreto.Prisao;
import tabuleiro.tabuleiroConcreto.ServicoPublico;
import tabuleiro.tabuleiroConcreto.SorteRevesConcreto;
import tabuleiro.tabuleiroConcreto.TabuleiroUSA;
import tabuleiro.tabuleiroConcreto.VaParaPrisao;

/**
 *@author Gutto
 * FatoryUsa é uma classe concreta que implementa FactoryCriador e
 * tem a responsabilidade de criar objetos do jogo.
 */
public class FactoryUSA implements FactoryCriador {

    /*
     * Retorna um JogadorConcreto
     */
    public Jogador criaJogador() {
        return new JogadorConcreto();
    }

    /*
     * Retorna um DadoDuplo
     */
    public Dado criaDado() {
        return new DadoDuplo();
    }
// Cria um  Peao e retorna um Peao com sua respectiviva cor
    /*
     *
     */

    public Peao criaPeao(String cor) {
        return new Peao(cor);
    }

    // Cria uma Lista de Lugares e retorna Um ArrayList de Lugares com a quantidade de lugares.
    public List<Lugar> criaLugares(int numLugares) {
        return new ArrayList<Lugar>(numLugares);
    }

    // Cria Lugar e adiciona no Tabuleiro retornando uma instancia de um lugar fisico.
    public Lugar criaLugar(List<Lugar> lugares, int posicao, String nome) {
        LugarFisico l = new LugarFisico(nome, 0, posicao);
        lugares.add(l);
        return l;
    }

    // Cria uma  Propriedade  com suas caracteristicas e adiciona no respestivo lugar no tabuleiro.
    public Propriedade criaPropriedade(List<Lugar> lugares, int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa) {
        Propriedade p = new Propriedade(posicao, nome, cor, precoP, aluguelSCasa, c1, c2, c3, c4, hotel, hip, precoCasa);
        lugares.add(p);
        return p;
    }
    // Cria uma Ferrovia, adiciona suas caracteristicas e retorna uma isntancia de Ferrovia
    public Ferrovia criaFerrovia(List<Lugar> lugares, int posicao, String nome, float preco, float hipoteca) {
        Ferrovia f = new Ferrovia(posicao, nome, preco, hipoteca);
        lugares.add(f);
        return f;
    }

    // Cria um imposto de Renda, adiciona suas caracteristicas e retorna uma instancia de Imposto de Renda
    public ImpostoRenda criaImpostoRenda(List<Lugar> lugares, int posicao, String nome, float preco) {
        ImpostoRenda ir = new ImpostoRenda(posicao, nome, preco);
        lugares.add(ir);
        return ir;
    }

    // Cria um imposto Riqueza, adiciona suas caracteristicas e retorna uma instancia de Imposto riqueza
    public ImpostoRiqueza criaImpostoRiqueza(List<Lugar> lugares, int posicao, String nome, float preco) {
        ImpostoRiqueza iRiqueza = new ImpostoRiqueza(posicao, nome, preco);
        lugares.add(iRiqueza);
        return iRiqueza;
    }

    /**
     *
     * @param lugares
     * @param posicao
     * @param nome
     * @return
     */
    public CofreComunitarioConcreto criaCofresComunitarios(List<Lugar> lugares, int posicao, String nome) {
        CofreComunitarioConcreto cofreComunitarioConcreto = new CofreComunitarioConcreto(nome, posicao);
        lugares.add(cofreComunitarioConcreto);
        return cofreComunitarioConcreto;
    }

    /**
     *
     * @param lugares
     * @param posicao
     * @param nome
     * @return
     */
    public SorteRevesConcreto criaSorteReves(List<Lugar> lugares, int posicao, String nome) {
        SorteRevesConcreto sorteRevesConcreto = new SorteRevesConcreto(nome, posicao);
        lugares.add(sorteRevesConcreto);
        return sorteRevesConcreto;
    }

    // Cria um tabuleiro com sua quantidade de espaços
    public Tabuleiro criaTabuleiro(int numCasas) {
        return new TabuleiroUSA(numCasas);
    }
    // Cria um gerente que controla o jogo
    public GerenteJogo criaGerente(FactoryCriador factory, Mensagens mensagens, GerenteCompraVenda gerenteCompraVendaConcreto, GerenteSorteCofre gerenteSorteCofre) {
        return new GerenteJogoConcreto(factory, mensagens, gerenteCompraVendaConcreto, gerenteSorteCofre);
    }

    /**
     *
     * @param bSR
     * @param bCC
     * @return
     */
    public GerenteSorteCofre criaGerenteSorteCofre(BaralhoSorteReves bSR, BaralhoCofreComunitario bCC) {
        return new GerenteSorteCofreConcreto(bSR, bCC);
    }

    /**
     *
     * @param f
     * @return
     */
    public GerenteCompraVenda criaGerenteCompraVenda(FactoryCriador f) {
        return new GerenteCompraVendaConcreto();
    }
    /**
     *
     * @param numJogadores
     * @return
     */

    // Cria uma Lista de Jogadores e adiciona os jogadores concrestos na mesma.
    public List<Jogador> criaListaJogadores(int numJogadores) {
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>(numJogadores);
        for (int i = 0; i < numJogadores; i++) {
            jogadores.add(new JogadorConcreto());
        }
        return jogadores;
    }

    // Cria  cria um Banco e retorna um Banco concreto que serve para armazenar finanças do jogo.
    public Banco criaBanco() {
        return new BancoConcreto();
    }

    // Cria  mensagens e retorna MensagensJogo que seram exibidas no decorrer do jogo.
    public Mensagens criaMensagens() {
        return new MensagensJogo();
    }

    public BaralhoCofreComunitario criaBaralhoCofreComunitario() {
        return new BaralhoCofreComunitario();
    }

    public BaralhoSorteReves criaBaralhoSorteReves() {
        return new BaralhoSorteReves();
    }
    /**
     *
     * @param baralho
     * @param numeroCarta
     * @param nomeCarta
     * @param descricao
     * @param observacao
     * @return
     */
    public CartaCofresComunitarios criaCartasCofresComunitarios(Baralho baralho, int numeroCarta, String nomeCarta, String descricao, String observacoes) {
        CartaCofresComunitarios cartaCofresComunitarios = new CartaCofresComunitarios(numeroCarta, nomeCarta, descricao, observacoes);
        baralho.addCarta(cartaCofresComunitarios);
        return cartaCofresComunitarios;
    }
    /**
     *
     * @param baralho
     * @param numeroCarta
     * @param nomeCarta
     * @param descricao
     * @param observacao
     * @return
     */
    public CartaSorteReves criaCartasSorteReves(Baralho baralho, int numeroCarta, String nomeCarta, String descricao, String observacoes) {
        CartaSorteReves cartaSorteReves = new CartaSorteReves(numeroCarta, nomeCarta, descricao, observacoes);
        baralho.addCarta(cartaSorteReves);
        return cartaSorteReves;
    }
   
    /**
     *
     * @param nome
     * @param posicao
     *
     * @return
     */
    public Lugar criaPrisao(String nome, int posicao) {
         Prisao prisao = new  Prisao(nome, posicao);
           return prisao;
    }
     /**
     *
     * @param nome
     * @param posicao
     *
     * @return
     */
    public Lugar criaVaParaPrisao(String nome, int posicao) {
        VaParaPrisao vaParaPrisao = new VaParaPrisao(nome, posicao);
            return vaParaPrisao;
    }
     /**
     *
     * @param nome
     * @param posicao
     * @param preco
     * @return
     */
    public Lugar criaServicopublico(String nome, int posicao, float preco){
         ServicoPublico servicoPublico = new ServicoPublico(nome, posicao, preco);
         return servicoPublico;
    }

    /**
     *
     * @param nome
     * @param posicao
     * @param preco
     * @return
     */

    public Lugar criaParadaLivre(String nome, int posicao, float preco) {
           ParadaLivre paradaLivre = new ParadaLivre(nome, posicao, preco);
            return paradaLivre;
    }
}
