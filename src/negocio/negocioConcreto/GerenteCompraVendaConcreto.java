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
import negocio.Mensagens;
import player.Jogador;
import tabuleiro.Imposto;
import tabuleiro.ImpostoRenda;
import tabuleiro.ImpostoRiqueza;
import tabuleiro.Lugar;
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

            jogadorVez.setDinheiro((float) (jogadorVez.getDinheiro() - p.getPrecoAluguelAtual()));
            proprietario.setDinheiro(proprietario.getDinheiro() + p.getPrecoAluguelAtual());
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

    /*
     * Verificar se o jogador pode ou não construir uma casa ou hotel.
     * Caso possa construir, mostra mensagem utilizando o método mensagemConstruir
     * da classe mensagens, com as opções de casas e propriedades que o jogador tem para construir
     */
    public void construir(Jogador jogador, List<LugarFisico> lugares, Scanner teclado, Banco banco, Mensagens mens) {
        //Lista que irá armazenar os lugares possíveis para construir
        List<LugarFisico> lugaresPossiveis = new ArrayList<LugarFisico>();
        //Irá armazenar os grupos que já foram testados para que não teste duas vezes
        List<Grupo> listaGruposTestados = new ArrayList<Grupo>();
        for (LugarFisico lf : lugares) {
            if (lf != null && !listaGruposTestados.contains((Grupo) lf.getGrupo())) {
                if (lf instanceof Propriedade) {
                    Grupo g = (Grupo) lf.getGrupo();
                    if (g.grupoEMeu(jogador)) {
                        //Adiciona o grupo testao a uma lista de grupos para que não necessite mais testar propriedades
                        //desse grupo
                        listaGruposTestados.add(g);
                        //Laço que pega as propriedades possíveis de serem construídas e adiciona a lista de lugaresPossiveis
                        for (LugarFisico l : g.getLugaresFisicos()) {
                            Propriedade p = (Propriedade) l;
                            // Testa se a propriedade já tem hotel construído. Quando tem hotel o numero de casas é 5
                            if (p.getnCasas() < 5) {
                                //Testa se o jogador tem dinheiro suficiente
                                if (jogador.getDinheiro() > p.getPrecoCasa()) {
                                    lugaresPossiveis.add(l);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!lugaresPossiveis.isEmpty()) {
            controlaJogadaConstruir(jogador, lugaresPossiveis, mens, teclado, banco);
        }

    }

    /**
     *
     * @param jogador
     * @param lugaresPossiveis
     * @param mens
     * @param teclado
     * @param b
     */
    public void controlaJogadaConstruir(Jogador jogador, List<LugarFisico> lugaresPossiveis, Mensagens mens, Scanner teclado, Banco b) {
        int escolha = -1;
        //Laço que controlará a jogada construir. O mesmo será executado até que o jogador escolha a opção 0 (para sair)
        // ou que não exista mais lugares que ele possa construir ou ainda que não exista mais casas disponíveis no banco
        while (escolha != 0 && !lugaresPossiveis.isEmpty() && (b.getNumCasasDisponiveis() > 0) || b.getNumHoteisDisponiveis()>0) {
            escolha = mens.mensagemConstruir(jogador, lugaresPossiveis, teclado);
            if (escolha != 0) {
                Propriedade p = (Propriedade) lugaresPossiveis.get(escolha - 1);
                if(((Grupo)(p.getGrupo())).getPropriedadesNaoPodeConstruir().contains(p)){
                    System.out.println("Não pode construir nessa propriedade. Construa nas outras propriedades desse grupo"
                            + " até que fiquem niveladas. ");
                }else if(p.getnCasas()>=5){
                    System.out.println("Não pode construir nessa propriedade."
                            + " Você já tem um hotel.");
                }else{
                p.setnCasas(p.getnCasas() + 1);
                jogador.setDinheiro(jogador.getDinheiro() - p.getPrecoCasa());
                //lugaresPossiveis.remove(p);
                //O código abaixc verifica se as propriedades do grupo em questão ficaram niveladas, ou seja, estão com o mesmo
                //número de casas construídas, sendo assim, todas voltam a lista de lugaresPossiveis.
                Grupo grupo = (Grupo) p.getGrupo();
                p.getGrupo().addPropriedadeNaoPodeConstruir(p);
                if(b.getNumCasasDisponiveis() <=0){
                    System.out.println("O banco não possui mais casas para venda...");
                }
                if (grupo.getPropriedadesNaoPodeConstruir().isEmpty()) {
                    //A operação abaixo previne que seja adicionado propriedades duplicadamente, em casos como
                    // o de errar a operação na primeira tentativa de construir, aí, como não foram construídas
                    // casas em nenhuma propriedade a lista de naoPodeConstruir vai estar vazia
                    lugaresPossiveis.removeAll(grupo.getLugaresFisicos());
                    lugaresPossiveis.addAll(grupo.getLugaresFisicos());
                }

                b.setNumCasasDisponiveis(b.getNumCasasDisponiveis() - 1);
                }
            }
        }
    }
/*
    public void controlaVenda(Jogador jogador){

    }
*/
    public void venda(Jogador jogador, Propriedade propriedade, Banco banco) {

        List<LugarFisico> novaLista = new ArrayList<LugarFisico>();
        novaLista.addAll(((Grupo)(propriedade.getGrupo())).getLugaresFisicos());
        novaLista.addAll(((Grupo)(propriedade.getGrupo())).getPropriedadesNaoPodeConstruir());

        for(LugarFisico lf:novaLista){
            if(propriedade.getnCasas() < ((Propriedade)lf).getnCasas() && propriedade.getnCasas()!=0){
                System.out.println("Você não pode vender casas nessa propriedade. \n"
                        + "Ela possui um número de casas menor que de outras propriedades do seu grupo.\n"
                        + "Escolha outra propriedade...");
            return;
            }
        }

        if (propriedade.getnCasas() <= 0) {
            System.out.println("Você não possui mas casas nessa propriedade. Escolha outra propriedade...");
            return;
        }
        if (propriedade.getnCasas() == 5) {
            propriedade.setnCasas(0);
            jogador.setDinheiro(jogador.getDinheiro() + propriedade.getHotel() / 2);
            banco.setNumHoteisDisponiveis(banco.getNumHoteisDisponiveis() + 1);


        } else {
            propriedade.setnCasas(propriedade.getnCasas() - 1);
            jogador.setDinheiro(jogador.getDinheiro() + propriedade.getPrecoCasa() / 2);
            banco.setNumCasasDisponiveis(banco.getNumCasasDisponiveis() + 1);
        }

    }
}
