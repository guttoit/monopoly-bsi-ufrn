/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import java.util.Scanner;
import negocio.Mensagens;
import player.Jogador;
import player.concretos.Peao;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Gutto
 */


/**
 *
 * @class A classe MensagensJogo implementa Mensagens e é resposável pos mostrar as pricipais mensagens
 * do sistema.
 */
public class MensagensJogo implements Mensagens {

    public String mensagensBoasVindas() {
        return null;
    }



 /**
 * Metodo para mostrar mensagem de tetativas de execucoes erradas.
 * @param nivelBurrice
  * @param numDigitado
 */
    public String nivelBurrice(int nivelBurrice, int numDigitado) {
        String mensBurrice = "";
        switch (nivelBurrice) {
            case 1:
                mensBurrice = ("Você digitou " + numDigitado
                        + "/n O jogo deve ter no mínimo 2 jogadores e no máximo 8. Entre com um número"
                        + "entre 2 e 8: ");
                break;

            case 2:
                mensBurrice = ("Você errou novamente, digitou " + numDigitado
                        + "/n Leia com atencão: O jogo deve ter no mínimo 2 jogadores e no máximo 8. "
                        + "Entre com um número entre 2 e 8: ");
                break;

            case 3:
                mensBurrice = ("Idiota, deixe de ser BURRO. Vou dizer só essa vez:"
                        + "/nO jogo deve ter no mínimo 2 jogadores e no máximo 8. "
                        + "Portanto, Então, Consoante, entre com um número entre 2 e 8!!!!: ");
                break;

            case 4:
                mensBurrice = ("Sai desse véi, na moral, desistooo.... Adeus");
                break;
        }
        return mensBurrice;
    }
//


    /**
 * Metodo para mostrar a mensagem inicial pedindo o nome do jogador
 * @param numJogador
 * @param  teclado
 *
 * @return  String
 */
    public String mensagemNome(int numJogador, Scanner teclado) {
        System.out.println("\nEntre com o nome do jogador " + numJogador + " :");
        String nome = teclado.next().trim();

        return nome;
    }
//

 /**
 * Metodo para mostrar as mensagem com as cores disponiveis no jogo
 * @param jogador Jogador, 
  * @param cores
  * @param numJogador
  * @param teclado
  * @return String
 */
    public String mensagemCores(Jogador jogador, String[] cores, int numJogador, Scanner teclado) {

        boolean acertouCor = false;
        String todasCores = "";

        for (int i = 0; i < cores.length; i++) {
            todasCores += cores[i] + ", ";
        }

        String cor = "";

        System.out.println("\n" + todasCores);
        System.out.println("\nCor do Jogador " + numJogador + ": ");
        while (!acertouCor) {
            cor = teclado.next().trim();
            for (String c : cores) {
                if (cor.equalsIgnoreCase(c)) {
                    acertouCor = true;
                    return cor;
                }
            }

            System.out.println("\n Essa cor não existe ou não está no nosso jogo. Digite"
                    + "uma cor da lista de cores : \n" + todasCores);
        }

        return cor;
    }




 /**
  * * Metodo para mostrar em que posicao está a propriedade e pegunta se o jogador deseja comprá-la
  * @param j
  * @param l
  */

    public void geraStatus(Jogador j, LugarFisico l) {

        System.out.printf("\nO título da propriedade " + j.getPeao().getPosicao() + " Está disponivel por : " + l.getPreco()
                + " " + j.getNomeJogador() + ".\n Voce possui " + j.getDinheiro() + "\n Deseja Comprar ?  sim [s] ou nao [n] ");

    }

    /**
     * Metodo para mostrar a situacao atual do jogador
     * @param j
     * @param t
     */
    public void statusJogador(Jogador j, Tabuleiro t) {
        
        if (t.getListaLugar().get(j.getPeao().getPosicao()) == null) {
            System.out.printf(" \nO status de " + j.getNomeJogador() + " - " + j.getPeao().getCorPeao()
                    + "\n é o segunte:\n" + " Situado na posicao  " + j.getPeao().getPosicao() + "-" + " Lugar nao implementado"
                    + "\n " + "Possui" + "$" + j.getDinheiro()+ "\n");
        } else {
            System.out.printf(" \nO status de " + j.getNomeJogador() + "- " + j.getPeao().getCorPeao()
                    + "\n é o segunte:\n" + " Situado na posicao  " + j.getPeao().getPosicao() + "-" + t.getListaLugar().get(j.getPeao().getPosicao()).getNome()
                    + "\n " + "Possui" + "$" + j.getDinheiro() + "\n");
        }
        for (Lugar lugar : j.getListaLugarFisico()) {

            if (lugar instanceof Propriedade) {
                Propriedade p = (Propriedade)lugar;
                System.out.printf("\n Propriedade " + lugar.getNome()+ " " + p.getCor() + " " + lugar.getPreco());
            }
            if (lugar instanceof Ferrovia) {
                Ferrovia f = (Ferrovia)lugar;
                System.out.printf("\n Ferrovia " + lugar.getNome() + lugar.getPreco());
            }
        }

    }

    public void geraStatus(Jogador j, Tabuleiro t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
