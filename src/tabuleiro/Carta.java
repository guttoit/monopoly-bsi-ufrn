/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabuleiro;

/**
 *
 * @author Adm
 */
public abstract class Carta {

    /**
     *
     */
    public int numeroCarta;
    /**
     *
     */
    public String nomeCarta;
    /**
     *
     */
    public String descricao;
    /**
     *
     */
    public String observacoes;

    /**
     *
     * @param numeroCarta
     * @param nomeCarta
     * @param descricao
     * @param observacoes
     */
    public Carta(int numeroCarta, String nomeCarta, String descricao, String observacoes) {
        this.numeroCarta = numeroCarta;
        this.nomeCarta = nomeCarta;
        this.descricao = descricao;
        this.observacoes = observacoes;
    }

    /**
     *
     */
    public Carta() {
    }

    

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public String getNomeCarta() {
        return nomeCarta;
    }

    /**
     *
     * @param nomeCarta
     */
    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    /**
     *
     * @return
     */
    public int getNumeroCarta() {
        return numeroCarta;
    }

    /**
     *
     * @param numeroCarta
     */
    public void setNumeroCarta(int numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    /**
     *
     * @return
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     *
     * @param observacoes
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
