
package negocio.negocioConcreto;

import java.util.List;
import java.util.Scanner;
import negocio.Banco;
import negocio.FactoryCriador;
import negocio.GerenteCompraVenda;
import negocio.GerenteJogo;
import negocio.GerenteSorteCofre;
import negocio.Mensagens;
import player.Jogador;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import player.concretos.DadoDuplo;
import player.concretos.Peao;
import tabuleiro.Imposto;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.Prisao;
import tabuleiro.tabuleiroConcreto.SorteRevesConcreto;
import tabuleiro.tabuleiroConcreto.VaParaPrisao;
/**
 *
 * @author Gutto
 */
/**
 *
 * @class A class GerenteJogoConcreto implementa o GerenteJogo. Ela tem a responsabilidade de gerenciar
 * um modo específico de Jogo.
 */
public class GerenteJogoConcreto extends GerenteJogo {

    private String cores[] = new String[8];

    /**
     *
     * @param factory
     */
    public GerenteJogoConcreto(FactoryCriador factory) {
        super(factory);
    }


    /**
     *
     * @param f
     * @param mens
     * @param gerente
     * @param gerenteSorteCofre
     */
    public GerenteJogoConcreto(FactoryCriador f, Mensagens mens, GerenteCompraVenda gerente, GerenteSorteCofre gerenteSorteCofre){
        super(f, mens, gerente, gerenteSorteCofre);
        inicializaCores();
        
    }

    /**
     * Método usado para inicar um vetor String contendo as cores disponíveis para os jogadores.
     */
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

    /*
     * Desloca o peão no tabuleiro de acordo com o resultado do dado.
     * Caso o peão passe pela posição inicial o jogador receberá um bônus de R$ 200
     */
    public Lugar andaPeao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro) {
        Peao p = jogador.getPeao();
        // Variável usada para facilitar os calculos
        int aux = (p.getPosicao() + valorDado[0] + valorDado[1]);

        // Verifica se o peão passou pela posição de origem ou não. Caso tenha passado, a sua posição
        // é transforma nos parâmetros que o jogo aceita.
        if (verificaPosicao(valorDado, jogador, tabuleiro)) {
            if(aux == 40){
                p.setPosicao(40 - 1);
            }
            p.setPosicao(0 + aux - 40);
        } else {
            p.setPosicao(aux);
        }
        // Pega o lugar no qual o peão se encontra após ter andado
        Lugar l = tabuleiro.getListaLugar().get(p.getPosicao()+1);


        // Chama o método mostraMensAndaPeao da classe MensagensJogo para mostrar ao usuário o seu lugar no jogo.
        mensagens.mostraMensAndaPeao(jogador, l, valorDado);

        return l;
    }

    /**
     * Verifica onde um jogador está localizado no tabuleiro
     * para receber gratificação por dar uma volta no tabuleiro
     * @param valorDado
     * @param jogador
     * @param tabuleiro
     * @return
     */
    public boolean verificaPosicao(Integer[] valorDado, Jogador jogador, Tabuleiro tabuleiro) {
        int posicaoAtual = jogador.getPeao().getPosicao();
        if (posicaoAtual == 40) {
            return true;
        } else if (posicaoAtual < 40 && (posicaoAtual + valorDado[0] + valorDado[1]) > 40) {
            jogador.setDinheiro(jogador.getDinheiro() + 200);
            return true;
        }
        return false;
    }
    /**
     * Método que irá pegar os nomes e as respectivas cores dos jogadores
     * @param jogadores
     * @param numJogadores
     * @param teclado
     */
    public void armazenaNomeECorJogadores(List<Jogador> jogadores, int numJogadores, Scanner teclado){
        String auxCor[] = cores;
        String corDigitada = "";
        String nome = "";
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("\nEntre com o nome do jogador " + (i + 1) + " :");
            nome = teclado.next();
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

    }

    public int realizaJogada(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int numJogAtual) {
        Lugar l;
        String comando = "";
        boolean acertouComando = false;

        System.out.println("\nA jogada de " + jogadorVez.getNomeJogador() + " comecou.");
        System.out.println("\nComandos disponiveis: [Jogar]   [Sair]   [status]");
        System.out.println("\nEntre com o comando");
        comando = teclado.next().trim();
        while (!acertouComando) {
            if (comando.equalsIgnoreCase("sair")) {
                acertouComando = true;
                jogadores.remove(jogadorVez);
                numJogadores--;
                numJogAtual --;
                //Verifica se só existe um jogador
                if (jogadores.size() <= 1) {
                    System.out.println("\n\n\n Parabéns " + jogadores.get(0).getNomeJogador() + " ! Seu adversário desistiu e"
                            + " você é o mais novo" + " milionario da America!");
                    System.exit(0);
                }
                return numJogAtual;
            } else if (comando.equalsIgnoreCase("jogar")) {
                acertouComando = true;
                l = andaPeao(jogadorVez.jogaDado(new DadoDuplo()), jogadorVez, tab);
                if (l == null) {
                    System.out.println("\nNao faz nada.");
                } else if (l.getPosicao() == 40) {
                    //Não faz nada
                } else if (l instanceof LugarFisico) {
                    LugarFisico lf = (LugarFisico) l;
                    if (lf.getProprietario() == null) {
                        mensagens.geraStatus(jogadorVez, lf);
                        gerenteCompraVenda.gerenciaCompra(lf, jogadorVez, teclado, b);
                    } else {
                        gerenteCompraVenda.descontaAluguel(lf, jogadorVez);
                    }

                } else if (l instanceof Imposto) {
                    gerenteCompraVenda.descontaImposto(l, jogadorVez, b);
                } else if(l instanceof SorteRevesConcreto){
                    SorteRevesConcreto sorteReves= (SorteRevesConcreto) l;
                    gerenteSorteCofre.gerenciaJogadaCarta(jogadorVez, sorteReves, (MensagensJogo) mensagens, tab, jogadores, b);
                }else if(l instanceof CofreComunitarioConcreto){
                    CofreComunitarioConcreto cofreComunitario= (CofreComunitarioConcreto) l;
                    gerenteSorteCofre.gerenciaJogadaCarta(jogadorVez, cofreComunitario, (MensagensJogo) mensagens, tab, jogadores, b);
                } else if (l instanceof VaParaPrisao){
                          jogadorVez.getPeao().setPosicao(10);
                          jogadorVez.setEstaNaPrisao(true);
                } else if (l instanceof Prisao){
                          mensagens.visitaPrisao();
                }

            } else if (comando.equalsIgnoreCase("status")) {
                mensagens.statusJogador(jogadorVez, tab);
                acertouComando = true;
            } else {
                System.out.println("Comando errado. Os comandos disponíveis sao: [jogar] [sair] [status] "
                        + "\n Digite um desses comandos... ");
                comando = teclado.next().trim();
            }
        }
        if (jogadorVez.getDinheiro() <= 0) {
            System.out.println("\n" + jogadorVez.getNomeJogador() + " Você perdeu. Seu saldo é: " + jogadorVez.getDinheiro());
            numJogAtual--;
            numJogadores--;
            jogadores.remove(jogadorVez);
        }
        return numJogAtual;

    }

    /**
     *
     * @return
     */
    public String[] getCores() {
        return cores;
    }

    /**
     *
     * @param cores
     */
    public void setCores(String[] cores) {
        this.cores = cores;
    }

    /**
     *
     * @return
     */
    public FactoryCriador getFactory() {
        return factory;
    }

    /**
     *
     * @param factory
     */
    public void setFactory(FactoryCriador factory) {
        this.factory = factory;
    }

    /**
     *
     * @return
     */
    public Mensagens getMensagens() {
        return mensagens;
    }

    /**
     *
     * @param mensagens
     */
    public void setMensagens(Mensagens mensagens) {
        this.mensagens = mensagens;
    }

    /**
     *
     * @return
     */
    public int getNumJogadores() {
        return numJogadores;
    }

    /**
     *
     * @param numJogadores
     */
    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }


    /**
     *
     * @return
     */
    public GerenteCompraVenda getGerenteCompraVenda() {
        return gerenteCompraVenda;
    }
    /**
     *
     * @param gerenteCompraVenda
     */
    public void setGerenteCompraVenda(GerenteCompraVenda gerenteCompraVenda) {
        this.gerenteCompraVenda = gerenteCompraVenda;
    }

    /**
     *
     * @return
     */
    public GerenteSorteCofre getGerenteSorteCofre() {
        return gerenteSorteCofre;
    }

    /**
     *
     * @param gerenteSorteCofre
     */
    public void setGerenteSorteCofre(GerenteSorteCofre gerenteSorteCofre) {
        this.gerenteSorteCofre = gerenteSorteCofre;
    }

}
