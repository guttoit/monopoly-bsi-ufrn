/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

/**
 *
 * @author Adm
 */
public class CartaCofresComunitarios extends PilhaCartaAbstrata {
   
    
    public int numeroCarta;
    public String nomeCarta;
    public String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public int getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(int numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public String observacoes;
}
