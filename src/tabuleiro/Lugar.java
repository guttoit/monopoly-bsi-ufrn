/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

/**
 *
 * @author Adm
 */
public abstract class Lugar {

    public Lugar(){

    }

    public Lugar(String nome, double preco, int posicao) {
        this.nome = nome;
        this.preco = preco;
        this.posicao = posicao;
    }


    private String nome;
    private double preco;
    private int posicao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
