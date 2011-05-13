/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import player.Jogador;
import tabuleiro.LugarFisico;

/**
 *
 * @author Adm
 */
public interface  Vendendor {

    public void vendeLugarFisico(Jogador jogador, LugarFisico lugarFisico);
    public void realizaLeilao(List<Jogador> litaJogador, LugarFisico lugarFisico );


}
