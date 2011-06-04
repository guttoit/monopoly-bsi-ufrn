/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import java.util.List;
import java.util.Scanner;
import negocio.Banco;
import negocio.GerenteSorteCofre;
import negocio.Mensagens;
import player.Carta;
import player.Jogador;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import tabuleiro.Lugar;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.SorteRevesConcreto;

/**
 *
 * @author gutto
 */
public class GerenteSorteCofreConcreto extends GerenteSorteCofre {

    public GerenteSorteCofreConcreto(BaralhoSorteReves bSR, BaralhoCofreComunitario bCC) {
        super(bSR, bCC);
    }

    public GerenteSorteCofreConcreto() {
    }

    @Override
    public void gerenciaJogadaCarta(Jogador jogador, CofreComunitarioConcreto cofreComunitario, MensagensJogo mensagens, Tabuleiro tabuleiro, List<Jogador> jogadores, Banco b) {
        Carta cartaTirada = baralhoCofreComunitario.retiraCartaPilha();
        mensagens.mensagemSorteCofre(jogador, cartaTirada);
        switch (cartaTirada.getNumeroCarta()) {
            case 1:
                jogador.setDinheiro(jogador.getDinheiro() + 200);
                break;
            case 2:
                jogador.setDinheiro(jogador.getDinheiro() + 200);
                break;
            case 3:
                jogador.setDinheiro(jogador.getDinheiro() - 50);
                break;
            case 4:
                jogador.setDinheiro(jogador.getDinheiro() + 50 * jogadores.size());
                break;
            case 5:
                jogador.setDinheiro(jogador.getDinheiro() + 45);
                break;
            case 6:
                jogador.setTemCartaCofreComuSairPrisao(true);
                break;
            case 7:
                //Vai para a prisao
                jogador.getPeao().setPosicao(10);
                jogador.setEstaNaPrisao(true);
                break;
            case 8:
                jogador.setDinheiro(jogador.getDinheiro() + 20);
                break;
            case 9:
                jogador.setDinheiro(jogador.getDinheiro() + 100);
                break;
            case 10:
                jogador.setDinheiro(jogador.getDinheiro() - 100);
                break;
            case 11:
                jogador.setDinheiro(jogador.getDinheiro() - 150);
                break;
            case 12:
                jogador.setDinheiro(jogador.getDinheiro() + 25);
                break;
            case 13:
                jogador.setDinheiro(jogador.getDinheiro() + 100);
                break;
            case 14:
                jogador.setDinheiro(jogador.getDinheiro() + 10);
                break;
            case 15:
                jogador.setDinheiro(jogador.getDinheiro() + 100);
                break;
            case 16:
                // Paga imposto das ruas por cada casa ou hotel

                break;
        }
    }

    @Override
    public void gerenciaJogadaCarta(Jogador jogador, SorteRevesConcreto sorteRevesConcreto, MensagensJogo mensagens, Tabuleiro tabuleiro, List<Jogador> jogadores, Banco b) {
        Carta cartaTirada = baralhoSorteReves.retiraCartaPilha();
        mensagens.mensagemSorteCofre(jogador, cartaTirada);
        switch (cartaTirada.getNumeroCarta()) {
            case 1:
                // Vai para o ponto de partida e ganha 200 reais
                jogador.getPeao().setPosicao(40);
                jogador.setDinheiro(jogador.getDinheiro() + 200);
                break;
            case 2:
                // Vai para Ilinues avenue;
                jogador.getPeao().setPosicao(24);
                break;
            case 3:
                // Vai para o senhor charles place, caso passe pela posição inicial recebe 200
                if (jogador.getPeao().getPosicao() > 11) {
                    jogador.setDinheiro(jogador.getDinheiro() + 200);
                }
                jogador.getPeao().setPosicao(11);
                break;
            case 4:
                // Vai para o serviço público mais próximo
                //Se não tiver dono você pode comprá-lo do banco.
                //Se tiver, lance os dados e pague ao dono 10 vezes o resultado do lançamento.
                break;
            case 5:
                //Vai para a ferrovia mais próxima. Caso tenha dono paga a ele o dobro do valor.
                //Caso não haja dono, o jogador tem a opção de comprá-la.
                acaoSorteReves5(jogador, tabuleiro, jogadores, b, mensagens);
                break;
            case 6:
                jogador.setDinheiro(jogador.getDinheiro() + 50);
                break;
            case 7:
                jogador.getPeao().setPosicao(jogador.getPeao().getPosicao() - 3);
                break;
            case 8:
                // Vai para a prisão
                jogador.getPeao().setPosicao(10);
                jogador.setEstaNaPrisao(true);
                break;
            case 9:
                // Deve fazer a manutenção das suas casas e hoteis
                break;
            case 10:
                jogador.setDinheiro(jogador.getDinheiro() - 15);
                break;
            case 11:
                jogador.setTemCartaSorteRevesSairPrisao(true);
                break;
            case 12:
                if (jogador.getPeao().getPosicao() > 5) {
                    jogador.setDinheiro(jogador.getDinheiro() + 200);
                }
                jogador.getPeao().setPosicao(5);
                break;
            case 13:
                jogador.getPeao().setPosicao(39);
                break;
            case 14:
                for (Jogador j : jogadores) {
                    j.setDinheiro(j.getDinheiro() + 50);
                    jogador.setDinheiro(jogador.getDinheiro() - 50);
                }
                break;
            case 15:
                jogador.setDinheiro(jogador.getDinheiro() + 150);
                break;

        }
    }

    /*
     * Função que realiza a ação da carta 5 do baralho SorteReves. <br/0>
     *
     */
    public void acaoSorteReves5(Jogador jogador, Tabuleiro tabuleiro, List<Jogador> jogadores, Banco b, Mensagens mensagens) {
        List<Lugar> listaLugares = tabuleiro.getListaLugar();
        Scanner teclado = new Scanner(System.in);
        // Esse laço procura a ferrovia mais próxima
        int i = jogador.getPeao().getPosicao();
        while (!(listaLugares.get(i) instanceof Ferrovia)) {
            i++;
        }
        if (listaLugares.get(i) instanceof Ferrovia) {
            jogador.getPeao().setPosicao(i);
            Ferrovia ferrovia = (Ferrovia) listaLugares.get(i);
            if (ferrovia.getProprietario() != null) {
                int numFerrovias = 0;
                for (LugarFisico lugar : ferrovia.getProprietario().getListaLugarFisico()) {
                    if (lugar instanceof Ferrovia) {
                        numFerrovias++;
                    }
                }
                jogador.setDinheiro(jogador.getDinheiro() - 2 * numFerrovias * 25);
                ferrovia.getProprietario().setDinheiro(ferrovia.getProprietario().getDinheiro() + 2 * numFerrovias * 25);
            } else {
                // Oferece a opção para comprar a ferrovia
                mensagens.geraStatus(jogador, ferrovia);
                String comprou = "";
                boolean acertouComando = false;

                while (!acertouComando) {

                    //Criar essa mensagem em mensagem mensagens.mensagemCompra(jogador, l);
                    comprou = teclado.next();
                    if (comprou.trim().equalsIgnoreCase("s") || comprou.trim().equalsIgnoreCase("Sim")) {
                        if (jogador.getDinheiro() > ferrovia.getPreco()) {
                            jogador.setDinheiro((float) (jogador.getDinheiro() - ferrovia.getPreco()));
                            b.setDinheiroEmCaixa((float) (b.getDinheiroEmCaixa() + ferrovia.getPreco()));
                            ferrovia.setProprietario(jogador);
                            jogador.getListaLugarFisico().add(ferrovia);
                            acertouComando = true;

                        } else {
                            System.out.println(" \n Seu dinheiro e insuficiente... Fica pra proxima");
                        }

                    } else if (comprou.trim().equalsIgnoreCase("n") || comprou.trim().equalsIgnoreCase("Nao")) {
                        acertouComando = true;

                    } else {
                        System.out.println("\n Comando invalido. Digite S para comprar "
                                + "ou N para nao compra: ");
                    }

                }
            }

        }
    }
}
