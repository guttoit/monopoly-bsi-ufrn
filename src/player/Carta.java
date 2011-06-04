/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.util.List;
import negocio.Banco;
import negocio.Mensagens;
import player.Jogador;

/**
 *
 * @author Adm
 */
public abstract class Carta {

    private int numeroCarta;
    private String nomeCarta;
    private String descricao;
    private String observacoes;

    public Carta() {
    }
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
