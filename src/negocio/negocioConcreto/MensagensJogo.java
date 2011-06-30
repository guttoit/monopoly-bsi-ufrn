/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import negocio.Mensagens;
import player.Jogador;
import player.concretos.Peao;
import player.Carta;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.Grupo;

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
     * @return
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
        System.out.println("Entre com o nome do jogador " + numJogador + " :");
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

        System.out.println(todasCores);
        System.out.println("Cor do Jogador " + (numJogador + 1) + ": ");
        while (!acertouCor) {
            cor = teclado.next().trim();
            for (String c : cores) {
                if (cor.equalsIgnoreCase(c)) {
                    acertouCor = true;
                    return cor;
                }
            }

            System.out.println(" Essa cor não existe ou não está no nosso jogo. Digite"
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

        System.out.printf("O título da propriedade " + j.getPeao().getPosicao() + " " + l.getNome() + " está disponivel por : " + l.getPreco()
                + " " + j.getNomeJogador() + ".\n Voce possui " + j.getDinheiro() + "\n Deseja Comprar ?  sim [s] ou nao [n] ");

    }

    /**
     *
     * @param j
     * @param carta
     */
    public void mensagemSorteCofre(Jogador j, Carta carta) {
        System.out.printf("Você tirou a carta " + carta.getNomeCarta() + "\n" + carta.getDescricao());

    }

    /**
     * Metodo para mostrar a situacao atual do jogador
     * @param j
     * @param t
     */
    public void statusJogador(Jogador j, Tabuleiro t) {
        int posicaoLugar = j.getPeao().getPosicao() + 1;
        if (t.getListaLugar().get(posicaoLugar) == null) {
            System.out.printf(" O status de " + j.getNomeJogador() + " - " + j.getPeao().getCorPeao()
                    + "\n é o segunte:\n" + " Situado na posicao  " + j.getPeao().getPosicao() + "-" + " Lugar inexistente"
                    + "\n " + "Possui" + "$" + j.getDinheiro() + "\n");
        } else {
            System.out.printf(" O status de " + j.getNomeJogador() + "- " + j.getPeao().getCorPeao()
                    + "\n é o segunte:\n" + " Situado na posicao  " + j.getPeao().getPosicao() + "-" + t.getListaLugar().get(posicaoLugar).getNome()
                    + "\n " + "Possui" + "$" + j.getDinheiro() + "\n");
        }
        for (Lugar lugar : j.getListaLugarFisico()) {

            if (lugar instanceof Propriedade) {
                Propriedade p = (Propriedade) lugar;
                if (p.getnCasas() >= 5) {
                    System.out.printf("Propriedade " + lugar.getNome() + " " + ((Grupo) (p.getGrupo())).getCor() + " " + p.getPreco() + " ; 1" + " Hotel");
                } else {
                    System.out.printf("Propriedade " + lugar.getNome() + " " + ((Grupo) (p.getGrupo())).getCor() + " " + p.getPreco() + " ; " + p.getnCasas() + " Casas" );
                }
            }
            if (lugar instanceof Ferrovia) {
                Ferrovia f = (Ferrovia) lugar;
                System.out.printf("Ferrovia " + lugar.getNome() + f.getPreco());
            }
        }

    }

    /**
     *
     * @param j
     * @param t
     */
    public void geraStatus(Jogador j, Tabuleiro t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param jogador
     * @param l
     * @param valorDado
     */
    public void mostraMensAndaPeao(Jogador jogador, Lugar l, Integer[] valorDado) {
        Peao p = jogador.getPeao();
        if (l == null) {

            System.out.println("O jogador  " + jogador.getNomeJogador() + "tirou  " + valorDado[0]
                    + " e " + valorDado[1] + ". O peao avancou para " + p.getPosicao() + ", " + " Nao existe ainda ");
        } else {

            System.out.println("O jogador " + jogador.getNomeJogador() + " tirou " + valorDado[0]
                    + " e " + valorDado[1] + ". O peao avancou para  " + l.getPosicao() + ", " + l.getNome());
        }
    }

    public void visitaPrisao() {
        System.out.println("Visitando Prisao");

    }

    public void vaParaPrisao() {
        System.out.println(" Você está preso.");

    }

    public String mensagemEstaPreso(Jogador jogador, Scanner teclado) {
        System.out.println("A jogada de " + jogador.getNomeJogador() + " comecou.");
        System.out.println("" + jogador.getNomeJogador() + " Você está na prisão.\n");
        System.out.println("Comandos disponiveis: [pagar] [jogar] [status] [sair]");
        System.out.println("Entre com o comando");
        return teclado.next().trim();
    }

    public String mensagemEstaPresoComCarta(Jogador jogador, Scanner teclado) {
        System.out.println("A jogada de " + jogador.getNomeJogador() + " comecou.");
        System.out.println("" + jogador.getNomeJogador() + " Você está na prisão.\n");
        System.out.println("Comandos disponiveis: [pagar] [carta] [jogar] [status] [sair]");
        System.out.println("Entre com o comando");
        return teclado.next().trim();
    }

    public int mensagemConstruir(Jogador jogador, List<LugarFisico> lugares, Scanner teclado) {
        int escolha = -1;
        System.out.println(jogador.getNomeJogador() + " possui " + jogador.getDinheiro());
        System.out.println("Escolha onde quer construir: ");
        while (escolha == -1) {
            int i;
            for (i = 0; i < lugares.size(); i++) {
                Propriedade p = (Propriedade) lugares.get(i);
                //Verifica se o jogador possui dinheiro para construir...
                if (jogador.getDinheiro() > p.getPrecoCasa()) {
                    if (p.getnCasas() >= 4) {
                        System.out.println((i + 1) + " - " + p.getNome() + " tem " + p.getnCasas() + " construídas."
                                + " Você só pode construir um hotel."
                                + " \nO hotel custa $" + p.getHotel());
                    } else {
                        System.out.println((i + 1) + " - " + p.getNome() + " tem " + p.getnCasas() + " construídas,"
                                + " a casa custa $" + p.getPrecoCasa());
                    }
                } else {
                    lugares.remove(p);
                }
            }
            //Verifica se ele possui lugares onde pode construir, se não possuir, então imediatamente é atribuído
            //0 ao valor da escolha e a função é retornada.
            if (lugares.isEmpty()) {
                System.out.println("Você não possui mais propriedades para construir ou não tem mais dinheiro... ");
                escolha = 0;
                return escolha;
            }
            System.out.println("Entre com o número da propriedade ou 0 para sair: ");
            if (teclado.hasNextInt()) {
                escolha = teclado.nextInt();
                if (escolha == 0) {
                    return 0;
                } else if ((escolha) > i) {
                    System.out.println("Comando errado. Digite um número inteiro dentre os oferecidos ");
                    escolha = -1;

                }

            } else {
                teclado.next();
                System.out.println("Comando errado. Digite um número inteiro dentre os oferecidos ");
                escolha = -1;
            }
        }
        return escolha;
    }

    /**
     *
     * @param jogadorVez
     * @param teclado
     * @param lugares
     * @return
     */
    public int mensagemVenda(Jogador jogadorVez, Scanner teclado, List<LugarFisico> lugares) {
        System.out.println(jogadorVez.getNomeJogador() + " tem $" + jogadorVez.getDinheiro());
        System.out.println("Escolha o que quer vender:");
        Map mapa = new HashMap();
        int contador = 1;
        for (LugarFisico lugarFisico : lugares) {
            if (lugarFisico instanceof Propriedade) {
                Propriedade p = (Propriedade) lugarFisico;
                if (p.getnCasas() == 5) {
                    System.out.println(contador + ". " + p.getNome() + " tem um hotel construído. Você recebe $"
                            + p.getHotel() + ".");
                } else {
                    System.out.println(contador + ". " + p.getNome() + "tem " + p.getnCasas()
                            + "construída(s). Você recebe $" + p.getPrecoCasa() + ".");
                }

                mapa.put(contador, lugarFisico);
                contador++;
            }

        }

        System.out.println("Entre com o número da propriedade(0 para sair): ");

        int escolhaVenda = -1;
        while (escolhaVenda == -1) {
            if (teclado.hasNextInt()) {
                escolhaVenda = teclado.nextInt();
                if (escolhaVenda == 0) {
                    return 0;
                } else if ((escolhaVenda) > contador) {
                    System.out.println("Comando errado. Digite um número inteiro dentre os oferecidos ");
                    escolhaVenda = -1;

                }

            } else {
                teclado.next();
                System.out.println("Comando errado. Digite um número inteiro dentre os oferecidos ");
                escolhaVenda = -1;
            }

        }
        return escolhaVenda;

    }

    /**
     *
     * @param j
     * @param teclado
     * @return
     */
    public String MensagemTitulosHipoteca(Jogador j, Scanner teclado) {
        System.out.println("Voce possui" + j.getListaLugarFisico());
        System.out.println("Digite o numero correspondente a qual deseja hipotecar");
        return teclado.next().trim();
    }

    /**
     *
     * @param p
     * @param teclado
     * @return
     */
    public String MensagemVendaHabitacoes(Propriedade p, Scanner teclado) {

        System.out.println("Voce possui" + p.getnCasas());
        System.out.println(" Digite o numero correspondente a qual deseja Vender");
        return teclado.next().trim();
    }

    /**
     *
     * @param jogador
     * @param teclado
     * @return
     */
    public String mensagemVendaCasa(Jogador jogador, Scanner teclado) {
        System.out.println("A jogada de " + jogador.getNomeJogador() + " comecou.");
        System.out.println("Comandos disponiveis: [vender][jogar][status][sair]");
        System.out.println("Entre com o comando: ");
        return teclado.next().trim();
    }
}
