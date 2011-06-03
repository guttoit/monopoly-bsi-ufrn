/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.negocioConcreto;

import java.util.Scanner;
import negocio.Banco;
import negocio.GerenteCompraVenda;
import player.Jogador;
import tabuleiro.Imposto;
import tabuleiro.ImpostoRenda;
import tabuleiro.ImpostoRiqueza;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;

/**
 *
 * @author gutto
 */
public class GerenteCompraVendaConcreto implements GerenteCompraVenda {

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

    /**
     * Esse método será chamado caso o jogador caia em uma posição que represente um imposto, que pode ser
     * imposto de renda ou imposto de riqueza. Descontando o seu respectivo valor no dinheiro do jogador
     * e enviando ao banco.
     * @param l
     * @param jogadorVez
     * @param b
     */
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

    /**
     * Gerencia compra é responsável por receber o comando do jogador dizendo se ele comprou ou não
     * o lugarFísico oferecido.
     * @param l
     * @param jogador
     * @param teclado
     * @param b
     * @return boolean
     */
    public boolean gerenciaCompra(LugarFisico l, Jogador jogador, Scanner teclado, Banco b) {
        String comprou = "";
        boolean acertouComando = false;
        if (l.getProprietario() == null) {
            while (!acertouComando) {

                //Criar essa mensagem em mensagem mensagens.mensagemCompra(jogador, l);
                comprou = teclado.next();
                if (comprou.trim().equalsIgnoreCase("s") || comprou.trim().equalsIgnoreCase("Sim")) {
                    if (jogador.getDinheiro() > l.getPreco()) {
                        jogador.setDinheiro((float) (jogador.getDinheiro() - l.getPreco()));
                        b.setDinheiroEmCaixa((float) (b.getDinheiroEmCaixa() + l.getPreco()));
                        l.setProprietario(jogador);
                        jogador.getListaLugarFisico().add(l);
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
