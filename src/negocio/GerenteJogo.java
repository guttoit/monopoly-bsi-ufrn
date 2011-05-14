/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import java.util.Scanner;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.LugarFisico;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Adm
 */
public  interface GerenteJogo {

      public Lugar andaPeao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro);

    public void gerenciaJogo(Tabuleiro tab, Scanner teclado, Banco b, List<Jogador> jogadores, Mensagens mensagens);

    public void realizaJogada(List<Jogador> jogadores,Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, Mensagens mensagens);

    public boolean gerenciaCompra(LugarFisico l, Jogador jogador, Scanner teclado);

}
