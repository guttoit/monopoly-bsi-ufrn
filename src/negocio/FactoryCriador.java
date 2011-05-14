/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import player.Dado;
import player.Jogador;
import player.concretos.Peao;
import tabuleiro.Carta;
import tabuleiro.Chance;
import tabuleiro.Ferrovia;
import tabuleiro.ImpostoRenda;
import tabuleiro.ImpostoRiqueza;
import tabuleiro.Lugar;
import tabuleiro.Propriedade;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Gutto
 */
public interface FactoryCriador {

    public List<Jogador> criaListaJogadores(int numJogadores);

    public Jogador criaJogador();

    public Dado criaDado();

    public Peao criaPeao(String cor);

    public Lugar criaLugar();

    public List<Lugar> criaLugares(int numLugares);

    public Propriedade criaPropriedade(Tabuleiro tab,int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa);

    public Ferrovia criaFerrovia(Tabuleiro tab,int posicao, String nome, float preco, float hipoteca);

    public ImpostoRenda criaImpostoRenda(Tabuleiro tab,int posicao, String nome, float preco);

    public ImpostoRiqueza criaImpostoRiqueza(Tabuleiro tab,int posicao, String nome, float preco);

    public Tabuleiro criaTabuleiro(int numCasas);

    public GerenteJogo criaGerente(FactoryCriador f);

    public Chance criaChance();

    public Carta pagaCarta();

    public Mensagens criaMensagens();

    public Banco criaBanco();
}
