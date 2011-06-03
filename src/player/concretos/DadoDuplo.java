/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

import java.util.Random;
import player.Dado;

/**
 *
 * @author Gutto
 */

      /**
     *@class A classe dadoDuplo é uma classe concreta que implementa um dado. A mesma tem a essecialidade de gerar dois numeros aleatórios
     * a ser ultilizado pelo jogador durante sua jogada.
     */
public class DadoDuplo implements Dado{

    /**
     *
     */
    public DadoDuplo(){
        
    }

     /**
     * Método que irá gerar dois numeros aleatórios entre 1 e 6 cada um.
     *
     * @return numeros
     */

    public Integer[] gerarNumero() {
        Random random = new Random();
        Integer[] numeros = new Integer[2];
        numeros[0] = random.nextInt(6) +1;
        numeros[1] = random.nextInt(6)+1;
        return numeros;
    }

}
