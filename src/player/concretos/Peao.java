/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

/**
 *
 * @author Adm
 */


/**
 *
 * @class A classe peao pertence a um jogador e fica em uma das posiçoes do tabuleiro.Além disso, detem a posição
 * onde está localizada jutamente com sua cor
 */
public class Peao {

    private String corPeao;
    private int posicao;

    /**
     *
     * @param corPeao
     */
    public Peao(String corPeao){
        this.corPeao = corPeao;
        this.posicao = 40;
    }

    /**
     *
     */
    public Peao() {
        this.posicao = 40;
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
    public String getCorPeao() {
        return corPeao;
    }

    /**
     *
     * @param corPeao
     */
    public void setCorPeao(String corPeao) {
        this.corPeao = corPeao;
    }

}
