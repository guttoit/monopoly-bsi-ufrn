/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Scanner;
import player.Jogador;
import player.concretos.Peao;
import tabuleiro.Ferrovia;
import tabuleiro.Lugar;
import tabuleiro.LugarFisico;
import tabuleiro.Propriedade;
import tabuleiro.Tabuleiro;

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

    public String nivelBurrice(int nivelBurrice, int numDigitado){
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

    public void geraStatus(Jogador j, Scanner teclado , LugarFisico l){

        System.out.printf("A título da propriedade" + j.getPeao().getPosicao()+ "Está disponivel por " + l.getPreco()
                + j.getNomeJogador() + "Voce possui" + j.getDinheiro() );

    }

    public void statusJogador(Lugar l , Peao p, Jogador j, Tabuleiro  t){
       // O status de ana – azul é o seguinte:
       //Situado na posição 39 – Boardwalk
        //Possui $304
        //Títulos:
        //[Baltic Avenue] – propriedade roxa, aluguel 4
        //[B & O Railroad] – ferrovia, corrida 25
         //[Pennsylvania Avenue] – propriedade verde, aluguel 28
           System.out.printf(" \nO status de " + j.getNomeJogador()+ "- " + p.getCorPeao()
                   + "\n é o segunte:\n" +" Situado na posicao" + l.getPosicao() + "-"+ t.getListaLugar().get(p.getPosicao())+
                   "\n " + "Possui" + "$" + j.getDinheiro());
                for(Lugar lugar : j.getListaLugarFisico() ){

                    if (lugar instanceof Propriedade){
                       System.out.printf(l.getNome() + "Propriedade "+ j.getPeao().getCorPeao()+ l.getPreco() ) ;
                    }
                    if (lugar instanceof Ferrovia)
                         System.out.printf(l.getNome() + "Ferrovia "+ j.getPeao().getCorPeao()+ l.getPreco() ) ;
                    }



    }
}
