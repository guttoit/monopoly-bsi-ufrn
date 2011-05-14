/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import player.Jogador;
import player.concretos.DadoDuplo;
import tabuleiro.Imposto;
import tabuleiro.Lugar;
import tabuleiro.LugarFisico;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Gutto
 */
public class GerenteConcreto implements GerenteJogo {

    private Jogo jogo;
    private MensagensJogo mensagens = new MensagensJogo();
    private Jogador[] jogadores;
    private String cores[] = new String[8];

    public GerenteConcreto(Jogo jogo) {
        this.jogo = jogo;
        inicializaCores();
    }

    public void inicializaCores() {
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
        Lugar l = tabuleiro.getListaLugar().get(valorDado[0] + valorDado[1] + jogador.getPeao().getPosicao());
        jogador.getPeao().setPosicao(l.getPosicao());
        System.out.println("O jogador " + jogador.getNomeJogador() + "tirou " + valorDado[0]
                + " e " + valorDado[1] + ". O peao avancou para " + l.getPosicao() + ", " + l.getNome());

        return l;
    }

    public void gerenciaJogo(Tabuleiro tab, Scanner teclado) {
        int numJogadores = 0;
        int nivelBurrice = 0;
        while (numJogadores == 0 || nivelBurrice < 4) {
            if (nivelBurrice == 0) {
                System.out.println("Digite o numero de jogadores: ");
            }
            if (teclado.hasNextInt()) {
                numJogadores = teclado.nextInt();
                if (numJogadores >= 2 && numJogadores <= 8) {
                    jogadores = new Jogador[numJogadores];
                } else {
                    nivelBurrice++;
                    System.out.println(mensagens.nivelBurrice(nivelBurrice, numJogadores));
                }
            } else {
                System.out.println("Digite um número inteiro entre 2 e 8: ");
            }
        }
        if (nivelBurrice == 4) {
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
            System.out.println("\n A cor escolhida foi " + corDigitada + "\n");
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

    public void realizaJogada(Jogador jogadorVez, Scanner teclado) {
        Lugar l;
        String comando = "";
        System.out.println("\nO jogo iniciou\n");
        System.out.println("\nA jogada de " + jogadorVez.getNomeJogador());
        System.out.println("\nComandos disponiveis: [Jogar]   [Sair]");
        System.out.println("\nEntre com o comando");
        comando = teclado.nextLine();
        if (comando.equalsIgnoreCase("sair")) {
            System.exit(0);
        } else if (comando.equalsIgnoreCase("jogar")) {
            jogadorVez.jogaDado(new DadoDuplo());

            l = andaPeao(jogadorVez.jogaDado(new DadoDuplo()), jogadorVez, jogo.getTabuleiro());
            if (l instanceof LugarFisico) {
                mensagens.geraStatus(jogadorVez, teclado);
                gerenciaCompra((LugarFisico) l, jogadorVez, teclado);
            } else if (l instanceof Imposto) {
                jogadorVez.setDinheiro((float) (jogadorVez.getDinheiro() - l.getPreco()));
            } else {
                //ImplementarCompanhia e
            }
        }
    }

    public void gerenciaCompra(LugarFisico l, Jogador jogador, Scanner teclado) {
        String comprou = "";
        if (l.getProprietario() == null) {
            //Criar essa mensagem em mensagem mensagens.mensagemCompra(jogador, l);
            comprou = teclado.nextLine();
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
