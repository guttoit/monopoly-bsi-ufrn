/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

import player.Jogador;
import tabuleiro.LugarFisico;

/**
 *
 * @author Gutto
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

}