/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

import player.Jogador;

/**
 *
 * @author gutto
 */
public interface GrupoAbstrato {


    /*
     * Testa se o grupo é do jogador que está chamando a função
     */
    public boolean grupoEMeu(Jogador j);


    /*
     * Testa se o grupo esta completo
     */
    public boolean grupoEstaCompleto();

}
