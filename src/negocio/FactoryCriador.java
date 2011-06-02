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

/**
 *
 * @author Gutto
 */
/**
 *
 * @interface A interface FatoryCriador contém as assinaturas dos métodos de FactoryUSA.
 */
public interface FactoryCriador {

    public List<Jogador> criaListaJogadores(int numJogadores);

    public Jogador criaJogador();

    public Dado criaDado();

    public Peao criaPeao(String cor);

    public Lugar criaLugar(List<Lugar> lugares, int posicao, String nome);

    public List<Lugar> criaLugares(int numLugares);

    public Propriedade criaPropriedade(List<Lugar> lugares, int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa);

    public Ferrovia criaFerrovia(List<Lugar> lugares, int posicao, String nome, float preco, float hipoteca);

    public ImpostoRenda criaImpostoRenda(List<Lugar> lugares, int posicao, String nome, float preco);

    public ImpostoRiqueza criaImpostoRiqueza(List<Lugar> lugares, int posicao, String nome, float preco);

    public Tabuleiro criaTabuleiro(int numCasas);

    public GerenteJogo criaGerente(FactoryCriador f);

    public CartaCofresComunitarios criaCartasCofresComunitarios(Baralho baralho, int numeroCarta, String nomeCarta, String descricao, String observacoes);

    public CartaSorteReves criaCartasSorteReves(Baralho baralho, int numeroCarta, String nomeCarta, String descricao, String observacoes);

    public Mensagens criaMensagens();

    public Banco criaBanco();

    public BaralhoCofreComunitario criaBaralhoCofreComunitario();

    public BaralhoSorteReves criaBaralhoSorteReves();

}
