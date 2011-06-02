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

    public Peao(String corPeao){
        this.corPeao = corPeao;
        this.posicao = 0;
    }

    public Peao() {
        this.posicao = 0;
    }
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getCorPeao() {
        return corPeao;
    }

    public void setCorPeao(String corPeao) {
        this.corPeao = corPeao;
    }

}
