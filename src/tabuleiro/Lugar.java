/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

/**
 *
 * @author Adm
 */

/**
 *
 * @class A classe Lugar é uma interface que representa qualquer lugar do tabuleiro.
 *
 */
public abstract class Lugar {

    /**
     *
     */
    public Lugar(){

    }

    /**
     *
     * @param nome
     * @param preco
     * @param posicao
     */
    public Lugar(String nome, double preco, int posicao) {
        this.nome = nome;
        this.preco = preco;
        this.posicao = posicao;
    }


    private String nome;
    private double preco;
    private int posicao;

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     *
     * @param posicao
     */
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    /**
     *
     * @return
     */
    public double getPreco() {
        return preco;
    }

    /**
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

}
