/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import tabuleiro.tabuleiroConcreto.ImpostoRiqueza;
import tabuleiro.tabuleiroConcreto.ImpostoRenda;
import java.util.List;
import java.util.Scanner;
import negocio.Banco;
import negocio.FactoryCriador;
import negocio.GerenteJogo;
import negocio.Mensagens;
import player.Jogador;
import player.concretos.DadoDuplo;
import player.concretos.Peao;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.Imposto;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Gutto
 */
public class GerenteConcreto implements GerenteJogo {

    private FactoryCriador factory;
    private String cores[] = new String[8];
    private int numJogadores = 0;

    public GerenteConcreto(FactoryCriador f) {
        factory = f;
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
        Peao p = jogador.getPeao();
        int auxPosicao = p.getPosicao() + valorDado[0] + valorDado[1];

        verificaPosicao(valorDado, jogador, tabuleiro);

        if (auxPosicao > 40) {
            p.setPosicao(0 + auxPosicao - 40);
        }
        Lugar l = tabuleiro.getListaLugar().get(valorDado[0] + valorDado[1] + jogador.getPeao().getPosicao());

        if (l == null) {
            p.setPosicao(p.getPosicao() + valorDado[0] + valorDado[1]);
            jogador.getPeao().setPosicao(p.getPosicao());
            System.out.println("O jogador " + jogador.getNomeJogador() + "tirou " + valorDado[0]
                    + " e " + valorDado[1] + ". O peao avancou para " + p.getPosicao() + ", " + "Nao existe ainda");
        } else {
            jogador.getPeao().setPosicao(l.getPosicao());
            System.out.println("O jogador " + jogador.getNomeJogador() + "tirou " + valorDado[0]
                    + " e " + valorDado[1] + ". O peao avancou para " + l.getPosicao() + ", " + l.getNome());
        }


        return l;
    }

    public void verificaPosicao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro) {
        int posicaoAtual = jogador.getPeao().getPosicao();
        if (posicaoAtual < 40 && (posicaoAtual + valorDado[0] + valorDado[1]) > 40) {
            jogador.setDinheiro(jogador.getDinheiro() + 200);
        }
    }

    public void gerenciaJogo(Tabuleiro tab, Scanner teclado, Banco b, List<Jogador> jogadores, Mensagens mensagens) {
        int auxNumJogadores;
        int nivelBurrice = 0;
        System.out.println("Digite o numero de jogadores: ");
        while (numJogadores == 0 && nivelBurrice < 4) {

            if (teclado.hasNextInt()) {

                auxNumJogadores = teclado.nextInt();

                if (auxNumJogadores >= 2 && auxNumJogadores <= 8) {
                    numJogadores = auxNumJogadores;

                } else {
                    nivelBurrice++;
                    System.out.println(mensagens.nivelBurrice(nivelBurrice, auxNumJogadores));
                }
            } else {
                System.out.println("Digite um número inteiro entre 2 e 8: ");
                teclado.nextLine();
            }
        }
        if (nivelBurrice == 4) {
            return;
        }

        String auxCor[] = cores;
        String corDigitada = "";
        String nome;
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("\nEntre com o nome do jogador " + i + " :");
            nome = teclado.nextLine().trim();
            //nome = mensagens.mensagemNome(i, teclado);
            jogadores.get(i).setNomeJogador(nome);
            System.out.println("\n O nome escolhido foi " + nome);
            corDigitada = mensagens.mensagemCores(jogadores.get(i), auxCor, i, teclado);
            jogadores.get(i).getPeao().setCorPeao(corDigitada);
            jogadores.get(i).setDinheiro(1500);
            for (int j = 0; j < auxCor.length; j++) {
                if (corDigitada.equalsIgnoreCase(auxCor[j])) {
                    auxCor[j] = "";
                }
            }
            System.out.println("\n A cor escolhida foi " + corDigitada + "\n");
        }

        System.out.println("\nO jogo iniciou\n");
        int i = 0;
        while (numJogadores >= 2) {
            if (i >= numJogadores) {
                i = 0;
            }
            realizaJogada(jogadores, tab, jogadores.get(i), teclado, b, mensagens);
            i++;
        }
        if (numJogadores == 1) {
            System.out.println("\n\n\nParabéns " + jogadores.get(0) + " ! Você é o mais novo"
                    + " milionario da America!");
            System.exit(0);
        }
    }

    public void realizaJogada(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, Mensagens mensagens) {
        Lugar l;
        String comando = "";
        boolean acertouComando = false;

        System.out.println("\nA jogada de " + jogadorVez.getNomeJogador() + " comecou.");
        System.out.println("\nComandos disponiveis: [Jogar]   [Sair]   [status]");
        System.out.println("\nEntre com o comando");
        comando = teclado.nextLine().trim();
        while (!acertouComando) {
            if (comando.equalsIgnoreCase("sair")) {
                acertouComando = true;
                jogadores.remove(jogadorVez);
                if (jogadores.size() <= 1) {
                    System.exit(0);
                }

            } else if (comando.equalsIgnoreCase("jogar")) {
                // jogadorVez.jogaDado(new DadoDuplo());
                acertouComando = true;
                l = andaPeao(jogadorVez.jogaDado(new DadoDuplo()), jogadorVez, tab);
                if (l == null) {
                    System.out.println("\nNao faz nada.");
                } else if (l instanceof LugarFisico) {
                    LugarFisico lf = (LugarFisico) l;
                    if (lf.getProprietario() == null) {
                        mensagens.geraStatus(jogadorVez, lf);
                        gerenciaCompra(lf, jogadorVez, teclado);
                    } else {
                        descontaAluguel(lf, jogadorVez);
                    }

                } else if (l instanceof Imposto) {
                    descontaImposto(l, jogadorVez, b);
                    if (jogadorVez.getDinheiro() <= 0) {
                        System.out.println("Você perdeu. Seu saldo e: " + jogadorVez.getDinheiro());
                        numJogadores--;
                        jogadores.remove(jogadorVez);
                    }
                } else {
                    //ImplementarCompanhia e
                }
            } else if (comando.equalsIgnoreCase("status")) {
                mensagens.statusJogador(jogadorVez, tab);
                acertouComando = true;
            } else {
                System.out.println("Comando errado. Os comandos disponíveis sao: [jogar] [sair] [status] "
                        + "\n Digite um desses comandos... ");
                comando = teclado.nextLine().trim();
            }
        }
        if (jogadorVez.getDinheiro() <= 0) {
            System.out.println("Você perdeu. Seu saldo e: " + jogadorVez.getDinheiro());
            numJogadores--;
            jogadores.remove(jogadorVez);
        }

    }

    public void descontaAluguel(LugarFisico lf, Jogador jogadorVez) {

        Jogador proprietario = lf.getProprietario();
        if (lf instanceof Propriedade) {
            Propriedade p = (Propriedade) lf;
            jogadorVez.setDinheiro((float) (jogadorVez.getDinheiro() - p.getAluguelAtual()));
            proprietario.setDinheiro(proprietario.getDinheiro() + p.getAluguelAtual());
        } else if (lf instanceof Ferrovia) {
            int numFerrovias = 0;
            for (LugarFisico lugar : proprietario.getListaLugarFisico()) {
                if (lugar instanceof Ferrovia) {
                    numFerrovias++;
                }
            }
            jogadorVez.setDinheiro(jogadorVez.getDinheiro() - numFerrovias * 25);
            proprietario.setDinheiro(proprietario.getDinheiro() + numFerrovias * 25);
        }

    }

    public void descontaImposto(Lugar l, Jogador jogadorVez, Banco b) {
        Imposto imposto = (Imposto) l;
        if (imposto instanceof ImpostoRenda) {

            jogadorVez.setDinheiro((float) (jogadorVez.getDinheiro() - 200));
            b.setDinheiroEmCaixa(b.getDinheiroEmCaixa() + 200);

        } else if (imposto instanceof ImpostoRiqueza) {
            jogadorVez.setDinheiro((float) (jogadorVez.getDinheiro() - 75));
            b.setDinheiroEmCaixa(b.getDinheiroEmCaixa() + 75);
        }
    }

    public boolean gerenciaCompra(LugarFisico l, Jogador jogador, Scanner teclado) {
        String comprou = "";
        boolean acertouComando = false;
        if (l.getProprietario() == null) {
            while (!acertouComando) {

                //Criar essa mensagem em mensagem mensagens.mensagemCompra(jogador, l);
                comprou = teclado.nextLine();
                if (comprou.trim().equalsIgnoreCase("s") || comprou.trim().equalsIgnoreCase("Sim")) {
                    if (jogador.getDinheiro() > l.getPreco()) {
                        jogador.setDinheiro((float) (jogador.getDinheiro() - l.getPreco()));
                        l.setProprietario(jogador);
                        acertouComando = true;
                        return true;
                    } else {
                        System.out.println(" \n Seu dinheiro e insuficiente... Fica pra proxima");
                    }

                } else if (comprou.trim().equalsIgnoreCase("n") || comprou.trim().equalsIgnoreCase("Nao")) {
                    acertouComando = true;
                    return false;
                } else {
                    System.out.println("\n Comando invalido. Digite S para comprar "
                            + "ou N para nao compra: ");
                }
            }
        }
        return false;

    }
}
