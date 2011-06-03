/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro.tabuleiroConcreto;

/**
 *
 * @author Adm
 */

/**
*
 *@class A classe ferrovia é uma classe concreta. É um tipo de Lugar fisico que representa um meio de transporte que pode ser comprada
 * pelo jogador. Dependendo da quantidade de ferrovias que o jogador tiver, que é no maximo 4, vai determinar quanto
 * que o outro jogardor vai ter que lhe pagar.
     *
     */
public class Ferrovia  extends LugarFisico{

    /**
     *
     * @param posicao
     * @param nome
     * @param preco
     * @param hipoteca
     */
    public Ferrovia(int posicao, String nome, float preco, float hipoteca){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
        super.setHipoteca(hipoteca);
        super.setProprietario(null);
    }
}
