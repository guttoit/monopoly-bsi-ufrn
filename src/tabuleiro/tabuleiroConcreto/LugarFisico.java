/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro.tabuleiroConcreto;

import player.Jogador;
import tabuleiro.Lugar;

/**
 *
 * @author Adm
 */
public class LugarFisico extends Lugar {
    private float hipoteca;
    private Jogador proprietario;


    public LugarFisico(){

    }








    public Jogador getProprietario() {
        return proprietario;
    }

    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }

    public float getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(float hipoteca) {
        this.hipoteca = hipoteca;
    }

    

}
