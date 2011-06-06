/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import negocio.negocioConcreto.MensagensJogo;
import player.Jogador;
import player.Baralho;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import player.Carta;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.SorteRevesConcreto;

/**
 *
 * @author gutto
 */
public abstract class GerenteSorteCofre {

    protected Baralho baralhoSorteReves = new Baralho() {
    };
    protected Baralho baralhoCofreComunitario = new Baralho() {
    };

    public GerenteSorteCofre() {
    }

    /**
     *
     * @param bSR
     * @param bCC
     */
    public GerenteSorteCofre(BaralhoSorteReves bSR, BaralhoCofreComunitario bCC) {
        this.baralhoCofreComunitario = bCC;
        this.baralhoSorteReves = bSR;
    }

    /**
     *
     * @param jogador
     * @param cofreComunitario
     * @param mensagens
     * @param tabuleiro
     * @param jogadores
     * @param b
     */
    public abstract void gerenciaJogadaCarta(Jogador jogador, CofreComunitarioConcreto cofreComunitario, MensagensJogo mensagens, Tabuleiro tabuleiro, List<Jogador> jogadores, Banco b);

    /**
     *
     * @param jogador
     * @param cofreComunitario
     * @param mensagens
     * @param tabuleiro
     * @param jogadores
     * @param b
     */
    public abstract void gerenciaJogadaCarta(Jogador jogador, SorteRevesConcreto sorteReves, MensagensJogo mensagens, Tabuleiro tabuleiro, List<Jogador> jogadores, Banco b);
}
