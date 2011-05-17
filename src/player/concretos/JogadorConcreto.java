/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

import player.Dado;
import player.Jogador;

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

     /**
     * Método que recebe um dado como parametro e chama gerarnumero().
     *@param dado Dado
     * @return Integer[] int com os numeros gerados
     *
     */

    @Override
    public Integer[] jogaDado(Dado dado) {
        return dado.gerarNumero();
    }

   

    /*@Override
     Integer[] jogaDado(Dado dado) {
        return dado.gerarNumero();
    }*/

}
