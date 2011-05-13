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
import tabuleiro.Lugar;
import tabuleiro.Propriedade;
import tabuleiro.Tabuleiro;
import tabuleiro.TabuleiroUSA;

/**
 *
 * @author Gutto
 */
public class FactoryUSA implements FactoryCriador{

    public Jogador criaJogador() {
        return new JogadorConcreto();
    }

    public Dado criaDado() {
        return new DadoDuplo();
    }

    public Peao criaPeao(String cor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Lugar criaLugar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Propriedade criaPropriedade(int posicao,String nome, String cor, float aluguelSCasa,float c1, float c2, float c3, float c4, float hotel,  float hip, float precoCasa){
        return new Propriedade(posicao, nome, cor, aluguelSCasa, c1, c2, c3,c4, hotel, hip, precoCasa);
    }

    public GerenteJogo criaGerente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Tabuleiro criaTabuleiro() {

        return new TabuleiroUSA();
    }

    




}
