/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import negocio.Banco;
import negocio.GerenteCompraVenda;
import org.omg.CORBA.BAD_CONTEXT;
import player.Jogador;
import tabuleiro.Imposto;
import tabuleiro.ImpostoRenda;
import tabuleiro.ImpostoRiqueza;
import tabuleiro.Lugar;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.tabuleiroConcreto.Grupo;
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
                        return false;
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

    public void construir(Jogador jogador, Banco banco) {
        List<LugarFisico> listaLugarFisico = jogador.getListaLugarFisico();
        List<LugarFisico> listaQuePodeConstruir = new ArrayList<LugarFisico>();
        for (int i = 0; i < listaLugarFisico.size(); i++) {
            Grupo grupo = (Grupo) listaLugarFisico.get(i).getGrupo();
            if (grupo.grupoEMeu(jogador)) {
                for (int j = 0; j < grupo.getLugaresFisicos().size(); j++) {
                    Propriedade lugarFisico = (Propriedade) grupo.getLugaresFisicos().get(j);
                    if (jogador.getDinheiro() > lugarFisico.getPrecoCasa()) {
                        listaQuePodeConstruir.add(lugarFisico);
                    }

                }
            }
        }

    }

//Verificar se o jogador pode ou não construir uma casa ou hotel
//Caso possa construir, mostrar mensagem utilizando o método mensagemConstruir
// da classe mensagens, com as opções de casas e propriedades que o jogador tem para construir
//Pegar a opção escolhida pelo jogador
    public void venda(Jogador jogador, Propriedade propriedade, Banco banco) {
    }

    public void construir(Jogador jogador, Propriedade propriedade, Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
