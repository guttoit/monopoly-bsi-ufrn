/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.objetosNulo;

import java.util.Scanner;
import negocio.Mensagens;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.LugarFisico;

/**
 *
 * @author gutto
 */
public class MensagensObjetoNulo implements Mensagens{

    public String mensagensBoasVindas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String nivelBurrice(int nivelBurrice, int numDigitado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String mensagemNome(int numJogador, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String mensagemCores(Jogador jogador, String[] cores, int numJogador, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void geraStatus(Jogador j, LugarFisico l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void statusJogador(Jogador j, Tabuleiro t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mostraMensAndaPeao(Jogador jogador, Lugar l, Integer[] valorDado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
