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
public interface Mensagens {

    public String mensagensBoasVindas();


    public String nivelBurrice(int nivelBurrice, int numDigitado);

    public String mensagemNome(int numJogador, Scanner teclado);

    public String mensagemCores(Jogador jogador, String[] cores, int numJogador, Scanner teclado);


    public void geraStatus(Jogador j, Scanner teclado);

}
