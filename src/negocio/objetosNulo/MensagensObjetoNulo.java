/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.objetosNulo;

import java.util.List;
import java.util.Scanner;
import negocio.Mensagens;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;

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

    /**
     *
     * @param jogador
     * @param l
     * @param valorDado
     */
    public void mostraMensAndaPeao(Jogador jogador, Lugar l, Integer[] valorDado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void visitaPrisao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void vaParaPrisao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String mensagemEstaPreso(Jogador jogador, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String mensagemEstaPresoComCarta(Jogador jogador, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public int mensagemConstruir(Jogador jogador, List<LugarFisico> lugares, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String mensagemVenda(Jogador j, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String MensagemTitulosHipoteca(Jogador j, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String MensagemVendaHabitacoes(Propriedade p, Scanner teclado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int mensagemVenda(Jogador j, Scanner teclado, List<LugarFisico> lugares) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
