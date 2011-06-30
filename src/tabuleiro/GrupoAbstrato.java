/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

import player.Jogador;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;

/**
 *
 * @author gutto
 */
public interface GrupoAbstrato {



    /*
     * Adiciona os lugares do grupo
     */
    /**
     *
     * @param lf
     */
    public void addLugarFisico(LugarFisico lf);

    /*
     * Será chamado sempre que o jogador construir uma casa em uma propriedade. A mesma
     * será adicionada em uma lista de propriedades que não poderão serem usadas para construir
     * até que todas as propriedades já tiverem sido usadas. Ela é responsável também por verificar
     * se todas as propriedades já foram utilizadas e, então, devolver para a lista de propriedades
     * aptas.
     */
    /**
     *
     * @param p
     */
    public void addPropriedadeNaoPodeConstruir(Propriedade p);

    /*
     * Testa se o grupo é do jogador que está chamando a função
     */
    /**
     *
     * @param j
     * @return
     */
    public boolean grupoEMeu(Jogador j);


    /*
     * Testa se o grupo esta completo
     */
    /**
     *
     * @return
     */
    public boolean grupoEstaCompleto();

}
