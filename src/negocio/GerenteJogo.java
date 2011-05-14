/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.LugarFisico;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Adm
 */
public  interface GerenteJogo {

       public Lugar andaPeao(Integer[] valorDado, Jogador jogador,Tabuleiro tabuleiro);
       
       public void gerenciaCompra(LugarFisico l, Jogador jogador, Vendendor vendendor, boolean compraLeilao);

}
