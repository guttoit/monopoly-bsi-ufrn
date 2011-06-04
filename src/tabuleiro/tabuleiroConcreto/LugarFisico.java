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

/**
 *
 * @classAbstract A classe Lugar é  representa o lugar dos tabuleiros que podem ser comprados, ou seja
 * os titulos
 *
 */

public class LugarFisico extends Lugar {
    private float hipoteca;
    private Jogador proprietario;
    private float preco;

    /**
     *
     */
    public LugarFisico(){
        
    }

    /**
     *
     * @param nome
     * @param posicao
     * @param preco
     */
    public LugarFisico(String nome, int posicao, float preco) {
        super(nome, posicao);
        this.preco = preco;

    }

    

    /**
     *
     * @return
     */
    public float getPreco() {
        return preco;
    }

    /**
     *
     * @param preco
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }






    

    /**
     *
     * @return
     */
    public Jogador getProprietario() {
        return proprietario;
    }

    /**
     *
     * @param proprietario
     */
    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }

    /**
     *
     * @return
     */
    public float getHipoteca() {
        return hipoteca;
    }

    /**
     *
     * @param hipoteca
     */
    public void setHipoteca(float hipoteca) {
        this.hipoteca = hipoteca;
    }

    

}
