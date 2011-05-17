/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.negocioConcreto;

import java.util.List;
import negocio.Vendendor;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;

/**
 *
 * @author Gutto
 */

/**
 *
 * @class VendedorConcreto implementa vendedor. É responsável por realizar a venda de imóveis
 */
public class VendedorConcreto implements Vendendor{

    /**
    *  Metodo para vender um lugar físico e passar a posse da propriedade para o jogador.
    *
    *@paran jogador 
    *@param lugar
    */
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
