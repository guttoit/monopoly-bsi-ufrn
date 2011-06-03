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
    private String nome;
    private int posicao;
    /**
     *
     */
    public Lugar(){

    }

    /**
     *
     * @param nome
     * 
     * @param posicao
     */
    public Lugar(String nome,int posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }


    

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

    

    

}
