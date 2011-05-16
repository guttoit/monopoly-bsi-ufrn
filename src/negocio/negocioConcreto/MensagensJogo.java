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
public class MensagensJogo implements Mensagens {

    public String mensagensBoasVindas() {
        return null;
    }

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

    public String mensagemNome(int numJogador, Scanner teclado) {
        System.out.println("\nEntre com o nome do jogador " + numJogador + " :");
        String nome = teclado.nextLine().trim();

        return nome;
    }

    public String mensagemCores(Jogador jogador, String[] cores, int numJogador, Scanner teclado) {

        boolean acertouCor = false;
        String todasCores = "";

        for (int i = 0; i < cores.length; i++) {
            todasCores += cores[i] + ", ";
        }

        String cor = "";

        System.out.println(todasCores);
        System.out.println("Cor do Jogador " + numJogador + ": ");
        while (!acertouCor) {
            cor = teclado.nextLine().trim();
            for (String c : cores) {
                if (cor.equalsIgnoreCase(c)) {
                    acertouCor = true;
                    return cor;
                }
            }

            System.out.println("\n Essa cor não existe ou não está no nosso jogo. Digite"
                    + "uma cor da lista de cores : " + todasCores);
        }

        return cor;
    }

    public void geraStatus(Jogador j, LugarFisico l) {

        System.out.printf("A título da propriedade " + j.getPeao().getPosicao() + " Está disponivel por : " + l.getPreco()
                + j.getNomeJogador() + " Voce possui " + j.getDinheiro() + "\n Deseja Comprar ?  sim [s] ou nao [n] ");

    }

    public void statusJogador(Jogador j, Tabuleiro t  ) {
        // O status de ana – azul é o seguinte:
        //Situado na posição 39 – Boardwalk
        //Possui $304
        //Títulos:
        //[Baltic Avenue] – propriedade roxa, aluguel 4
        //[B & O Railroad] – ferrovia, corrida 25
        //[Pennsylvania Avenue] – propriedade verde, aluguel 28
        System.out.printf(" \nO status de " + j.getNomeJogador() + "- " + j.getPeao().getCorPeao()
                + "\n é o segunte:\n" + " Situado na posicao  " + j.getPeao().getPosicao() + "-" + t.getListaLugar().get(j.getPeao().getPosicao()).getNome()
                + "\n " + "Possui" + "$" + j.getDinheiro());
        for (Lugar lugar : j.getListaLugarFisico()) {

            if (lugar instanceof Propriedade) {
                System.out.printf(lugar.getNome() + "Propriedade " + j.getPeao().getCorPeao() + lugar.getPreco());
            }
            if (lugar instanceof Ferrovia) {
                System.out.printf(lugar.getNome() + "Ferrovia " + j.getPeao().getCorPeao() + lugar.getPreco());
            }
        }

    }

    public void geraStatus(Jogador j, Tabuleiro t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
