/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import player.Dado;
import player.Jogador;
import player.concretos.Peao;
import tabuleiro.Lugar;
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

    public Tabuleiro criaTabuleiro();

    public GerenteJogo criaGerente();


    

    
}
