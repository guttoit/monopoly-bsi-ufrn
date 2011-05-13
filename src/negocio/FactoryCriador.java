/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import player.Dado;
import player.Jogador;
import player.concretos.Peao;
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

    public Jogador criaJogador();

    public Dado criaDado();

    public Peao criaPeao(String cor);

    public Lugar criaLugar();

    public Propriedade criaPropriedade(int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa);

    public Ferrovia criaFerrovia(int posicao, String nome, float preco, float hipoteca);

    public ImpostoRenda ciraImpostoRenda(int posicao, String nome, float preco);

    public ImpostoRiqueza ciraImpostoRiqueza(int posicao, String nome, float preco);

    public Tabuleiro criaTabuleiro(int numCasas);

    public GerenteJogo criaGerente();
}
