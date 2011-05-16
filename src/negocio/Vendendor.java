/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;

/**
 *
 * @author Adm
 */

/**
 *
 * @interface vendedor contem as assinaturas dos métodos utilizados por vendedorConcreto para vender
 * lugar fisico e realizar leilao.
 */
public interface  Vendendor {

    public void vendeLugarFisico(Jogador jogador, Lugar lugarFisico);
    public void realizaLeilao(List<Jogador> litaJogador, LugarFisico lugarFisico );


}
