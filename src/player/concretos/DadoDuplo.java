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
public class DadoDuplo implements Dado{

    public DadoDuplo(){
        
    }

    public Integer[] gerarNumero() {
        Random random = new Random();
        Integer[] numeros = new Integer[2];
        numeros[0] = random.nextInt(6) +1;
        numeros[1] = random.nextInt(6)+1;
        return numeros;
    }

}
