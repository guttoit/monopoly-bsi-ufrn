/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import player.Jogador;
import tabuleiro.Lugar;

/**
 *
 * @author Adm
 */
public  interface GerenteJogo {

       public Lugar andaPeao(int valorDado, Jogador jogador);
       
       public void gerenciaCompra(Jogador jogador, Vendendor vendendor, boolean compraLeilao);

}
