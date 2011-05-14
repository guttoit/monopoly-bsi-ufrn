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
 * @author Gutto
 */
public class VendedorConcreto implements Vendendor{

    public void vendeLugarFisico(Jogador jogador, Lugar lugarFisico) {
        LugarFisico l = (LugarFisico) lugarFisico;
        if(jogador.comprar(l)){
          l.setProprietario(jogador);
        }
        
    }

    public void realizaLeilao(List<Jogador> litaJogador, LugarFisico lugarFisico) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
