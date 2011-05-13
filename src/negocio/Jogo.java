/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;
import player.Dado;
import player.Jogador;
import player.concretos.Peao;
import tabuleiro.Lugar;
import tabuleiro.Propriedade;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Adm
 */
public class Jogo {

    private List<Jogador> jogadores;
    private GerenteJogo gerente;
    private Vendendor vendedor;
    private Dado dado;
    private Peao peao;
    //private Status status;
    private Tabuleiro tabuleiro;
    private int numJogadores;
    private List<Lugar> lugares = new ArrayList<Lugar>(40);

    //private Propriedade p1 = new Propriedade(1, "", null, numJogadores, numJogadores, numJogadores, numJogadores, numJogadores, numJogadores, numJogadores, numJogadores);
    private Propriedade mediterraneanAvenue = new Propriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

    


    public Jogo() {
    }

    public void montaTabuleiro(Tabuleiro t, List<Lugar> lugares) {
        if (t.getNumCasas() != lugares.size()) {
        } else {
            for (Lugar l : lugares) {
                t.addLugar(l);
            }
        }
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public GerenteJogo getGerente() {
        return gerente;
    }

    public void setGerente(GerenteJogo gerente) {
        this.gerente = gerente;
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }

    public Peao getPeao() {
        return peao;
    }

    public void setPeao(Peao peao) {
        this.peao = peao;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Vendendor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendendor vendedor) {
        this.vendedor = vendedor;
    }
}
