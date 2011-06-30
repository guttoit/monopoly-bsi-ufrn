/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro.tabuleiroConcreto;

import player.Jogador;
import player.concretos.JogadorConcreto;
import tabuleiro.GrupoAbstrato;
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
    private GrupoAbstrato grupo;

    /**
     *
     */
    public LugarFisico(){
        proprietario = new JogadorConcreto();
        grupo = new Grupo();
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
        proprietario = new JogadorConcreto();
        grupo = new Grupo();


    }
    /**
     *
     * @param nome
     * @param posicao
     * @param preco
     * @param g
     */
    public LugarFisico(String nome, int posicao, float preco, Grupo g) {
        super(nome, posicao);
        this.preco = preco;
        proprietario = new JogadorConcreto();
        grupo = g;


    }


    /**
     *
     * @return
     */
    public GrupoAbstrato getGrupo() {
        return grupo;
    }

    /**
     *
     * @param grupo
     */
    public void setGrupo(GrupoAbstrato grupo) {
        this.grupo = grupo;
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
