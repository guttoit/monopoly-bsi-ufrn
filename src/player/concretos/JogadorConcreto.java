/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

import player.Dado;
import player.Jogador;
import tabuleiro.tabuleiroConcreto.LugarFisico;

/**
 *
 * @author Gutto
 */

  /**
     *@class A classe jogadorConcreto é uma classe concreta que extende jogador. A mesma tem um peao e o nome especificos para este jogo.
     */
public class JogadorConcreto extends Jogador {

    

    public JogadorConcreto(){
        super();
    }
    public JogadorConcreto(Peao p, String nome){
        super(p,nome);
    }

    @Override
    public boolean comprar(LugarFisico lugarFisico) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float compraEmLeilao(LugarFisico lugarFisico, float valorAtual) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer[] jogaDado(Dado dado) {
        return dado.gerarNumero();
    }

    /*@Override
     Integer[] jogaDado(Dado dado) {
        return dado.gerarNumero();
    }*/

}
