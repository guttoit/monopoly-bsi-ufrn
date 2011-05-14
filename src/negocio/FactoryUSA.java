/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import player.Dado;
import player.Jogador;
import player.concretos.DadoDuplo;
import player.concretos.JogadorConcreto;
import player.concretos.Peao;
import tabuleiro.Carta;
import tabuleiro.Chance;
import tabuleiro.Ferrovia;
import tabuleiro.ImpostoRenda;
import tabuleiro.ImpostoRiqueza;
import tabuleiro.Lugar;
import tabuleiro.Propriedade;
import tabuleiro.Tabuleiro;
import tabuleiro.TabuleiroUSA;

/**
 *
 * @author Gutto
 */
public class FactoryUSA implements FactoryCriador {

    public Jogador criaJogador() {
        return new JogadorConcreto();
    }

    public Dado criaDado() {
        return new DadoDuplo();
    }

    public Peao criaPeao(String cor) {
        return new Peao(cor);
    }

    public Lugar criaLugar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Propriedade criaPropriedade(int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa) {
        return new Propriedade(posicao, nome, cor, precoP, aluguelSCasa, c1, c2, c3, c4, hotel, hip, precoCasa);
    }

    public GerenteJogo criaGerente() {
        return null;
    }

    public Ferrovia criaFerrovia(int posicao, String nome, float preco, float hipoteca) {
        return new Ferrovia(posicao, nome, preco, hipoteca);
    }

    public ImpostoRenda criaImpostoRenda(int posicao, String nome, float preco) {
        return new ImpostoRenda(posicao, nome, preco);
    }

    public ImpostoRiqueza criaImpostoRiqueza(int posicao, String nome, float preco) {
        return new ImpostoRiqueza(posicao, nome, preco);
    }

    public Tabuleiro criaTabuleiro(int numCasas) {
        return new TabuleiroUSA(numCasas);
    }
    public Chance criaChance(){
               return null;
    }
    public Carta pegaCarta(int numeroCarta, String nomeCarta, String descricao, String observacoes){
         return new Carta(numeroCarta , nomeCarta, descricao, observacoes );
    }
}
