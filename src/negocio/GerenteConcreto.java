/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import player.Jogador;
import tabuleiro.Imposto;
import tabuleiro.Lugar;
import tabuleiro.LugarFisico;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Gutto
 */
public class GerenteConcreto implements GerenteJogo {

    private MensagensJogo mensagens = new MensagensJogo();
    private Jogador[] jogadores;
    private String cores[] = new String[8];

    public GerenteConcreto(){
        inicializaCores();
    }

    public void inicializaCores(){
        cores[0] = "Preto";
        cores[1] = "Branco";
        cores[2] = "Vermelho";
        cores[3] = "Verde";
        cores[4] = "Azul";
        cores[5] = "Amarelo";
        cores[6] = "Laranja";
        cores[7] = "Rosa";
    }

    public Lugar andaPeao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro) {
        return tabuleiro.getListaLugar().get(valorDado[0] + valorDado[1] + jogador.getPeao().getPosicao());
    }

    public void gerenciaJogo(Tabuleiro tab, Scanner teclado) {
        int numJogadores = 0;
        int nivelBurrice = 0;
        while (numJogadores == 0) {
            if (nivelBurrice == 0) {
                System.out.printf("Digite o numero de jogadores: ");
            }
            if (teclado.hasNextInt()) {
                if (numJogadores >= 2 && numJogadores <= 8) {
                    numJogadores = teclado.nextInt();
                    jogadores = new Jogador[numJogadores];
                } else {
                    nivelBurrice++;
                    switch (nivelBurrice) {
                        case 1:
                            System.out.printf("Você digitou " + numJogadores
                                    + "/n O jogo deve ter no mínimo 2 jogadores e no máximo 8. Entre com um número"
                                    + "entre 2 e 8: ");
                            break;

                        case 2:
                            System.out.printf("Você errou novamente, digitou " + numJogadores
                                    + "/n Leia com atencão: O jogo deve ter no mínimo 2 jogadores e no máximo 8. "
                                    + "Entre com um número entre 2 e 8: ");
                            break;

                        case 3:
                            System.out.printf("Idiota, deixe de ser BURRO. Vou dizer só essa vez:"
                                    + "/nO jogo deve ter no mínimo 2 jogadores e no máximo 8. "
                                    + "Portanto, Então, Consoante, entre com um número entre 2 e 8!!!!: ");
                            break;

                        case 4:
                            System.out.printf("Sai desse véi, na moral, desistooo.... Adeus");
                            numJogadores = 10;
                            break;
                    }
                }
            } else {
                System.out.printf("Digite um número inteiro entre 2 e 8: ");
            }
        }
        if (numJogadores == 10) {
            return;
        }


        String auxCor[] = cores;
        String corDigitada = "";
        for (int i = 0; i <= jogadores.length; i++) {
            corDigitada = mensagens.mensagemCores(jogadores[i], cores, i);
            jogadores[i].getPeao().setCorPeao(corDigitada);
            for (int j = 0; j < auxCor.length; j++) {
                if (corDigitada.equalsIgnoreCase(auxCor[j])) {
                    auxCor[j] = "";
                }
            }
            System.out.printf("\n A cor escolhida foi " + corDigitada + "\n");
        }

        /*Lugar l = tab.getListaLugar().get(j.getPeao().getPosicao());
        if (l instanceof LugarFisico) {
        Status.geraStatus(j);
        gerenciaCompra((LugarFisico) l, j);
        } else if (l instanceof Imposto) {
        j.setDinheiro((float) (j.getDinheiro() - l.getPreco()));
        } else {
        //ImplementarCompanhia e
        }*/
    }

    public void gerenciaCompra(LugarFisico l, Jogador jogador) {

        if (l.getProprietario() == null) {
            if (jogador.comprar(l)) {
                jogador.setDinheiro((float) (jogador.getDinheiro() - l.getPreco()));
                l.setProprietario(jogador);



            } else {
                // Implementar Leilão
            }
        } else {
        }
    }

    public void gerenciaCompra(LugarFisico l, Jogador jogador, Vendendor vendendor, boolean compraLeilao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*public void pagarPreco(Lugar l, ) {
    }*/
}
