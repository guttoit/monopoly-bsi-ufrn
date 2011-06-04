/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

/**
 *
 * @author Gutto
 */

/**
 *
 * @class A class Imposto é um tipo de lugar. Representa uma taxa a ser paga pelo jogador
 * que cair na mesma.
 */

public class Imposto extends Lugar{

    private float preco;

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

    
}
