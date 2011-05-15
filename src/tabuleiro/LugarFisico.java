/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

import player.Jogador;

/**
 *
 * @author Adm
 */

/**
 *
 * @classAbstract A classe Lugar é  representa o lugar dos tabuleiros que podem ser comprados, ou seja
 * os titulos
 *
 */

public class LugarFisico extends Lugar {
    private float hipoteca;
    private Jogador proprietario;


    public LugarFisico(){

    }

    public LugarFisico(String nome, float preco, int posicao ){

        super(nome, preco, posicao);

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
