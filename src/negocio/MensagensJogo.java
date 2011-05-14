/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Scanner;
import player.Jogador;

/**
 *
 * @author Gutto
 */
public class MensagensJogo {

    private boolean acertouCor = false;
    private String todasCores = "";
    private Scanner teclado = new Scanner(System.in);

    public String mensagensBoasVindas() {
        return null;
    }

    public String mensagemCores(Jogador jogador, String[] cores, int numJogador) {


        /*System.out.printf("Agora entre com as cores dos jogadores. Você pode escolher as seguintes "
        + "cores /n [ ");
         */

        for (int i = 0; i < cores.length; i++) {
            todasCores += cores[i] + ", ";
        }

        String cor = "";

        System.out.printf(todasCores);
        System.out.printf("Cor do Jogador " + numJogador + ": ");
        while (!acertouCor) {
            cor = teclado.nextLine();
            if (todasCores.contentEquals(", " + cor + ",")) {
                acertouCor = true;
            } else {
                System.out.printf("\n Essa cor não existe ou não está no nosso jogo. Digite"
                        + "uma cor da lista de cores : ");
            }
        }

        return cor;
    }
}
