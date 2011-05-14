/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.LugarFisico;

/**
 *
 * @author Adm
 */
public interface  Vendendor {

    public void vendeLugarFisico(Jogador jogador, Lugar lugarFisico);
    public void realizaLeilao(List<Jogador> litaJogador, LugarFisico lugarFisico );


}
