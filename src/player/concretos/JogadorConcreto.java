/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

import java.util.ArrayList;
import java.util.List;
import player.Dado;
import player.Jogador;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;

/**
 *
 * @author Gutto
 */

  /**
     *@class A classe jogadorConcreto é uma classe concreta que extende jogador. A mesma tem um peao e o nome especificos para este jogo.
     */
public class JogadorConcreto extends Jogador {

    

    /**
     *
     */
    public JogadorConcreto(){
        super();
    }
    /**
     *
     * @param p
     * @param nome
     */
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
    
    /**
     *
     * @return
     */
    public List<LugarFisico> lugaresPossoConstruir(){
        List<LugarFisico> lugaresPossiveis = new ArrayList<LugarFisico>();
        for(LugarFisico lf:super.getListaLugarFisico()){
            Propriedade p;
            if(lf instanceof Propriedade){
                p = (Propriedade) lf;
                if(p.getGrupo().grupoEMeu(this) && getDinheiro()> p.getPrecoCasa()){
                    lugaresPossiveis.add(p);
                }
            }
        }
        return lugaresPossiveis;
    }

   

    /*@Override
     Integer[] jogaDado(Dado dado) {
        return dado.gerarNumero();
    }*/

}
