/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

/**
 *
 * @author Adm
 */
public class Ferrovia  extends LugarFisico{

    public Ferrovia(int posicao, String nome, float preco, float hipoteca){
        super.setPosicao(posicao);
        super.setNome(nome);
        super.setPreco(preco);
        super.setHipoteca(hipoteca);
        super.setProprietario(null);
    }
}
