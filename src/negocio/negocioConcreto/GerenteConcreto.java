
package negocio.negocioConcreto;

import java.util.List;
import java.util.Scanner;
import negocio.Banco;
import negocio.FactoryCriador;
import negocio.GerenteCompraVenda;
import negocio.GerenteJogo;
import negocio.Mensagens;
import negocio.objetosNulo.GerenteCompraVendaObjetoNulo;
import negocio.objetosNulo.MensagensObjetoNulo;
import player.Jogador;
import player.concretos.Baralho;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import player.concretos.DadoDuplo;
import player.concretos.Peao;
import tabuleiro.Imposto;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.SorteRevesConcreto;

/**
 *
 * @author Gutto
 */
/**
 *
 * @class A class GerenteConcreto implementa o GerenteJogo. Ela tem a responsabilidade de gerenciar
 * um modo específico de Jogo.
 */
public class GerenteConcreto implements GerenteJogo {

    private FactoryCriador factory;
    private String cores[] = new String[8];
    private int numJogadores = 0;
    private Mensagens mensagens = new MensagensObjetoNulo();
    private GerenteCompraVenda gerenteCompraVenda = new GerenteCompraVendaObjetoNulo();
    private Baralho baralhoSorteReves;
    private Baralho baralhoCofreComunitario;




    /**
     *
     * @param f FactoryCriador
     */
    public GerenteConcreto(FactoryCriador f) {
        factory = f;
        inicializaCores();
    }

    /**
     *
     * @param f
     * @param mens
     */
    public GerenteConcreto(FactoryCriador f, Mensagens mens){
        factory = f;
        inicializaCores();
        this.mensagens = mens;
    }
    /**
     *
     * @param f
     * @param mens
     * @param gerente
     */
    public GerenteConcreto(FactoryCriador f, Mensagens mens, GerenteCompraVenda gerente){
        factory = f;
        inicializaCores();
        this.mensagens = mens;
        this.gerenteCompraVenda = gerente;
    }

     public GerenteConcreto(FactoryCriador f, Mensagens mens, GerenteCompraVenda gerente, Baralho baralhoSorteReves, Baralho baralhoCofreComunitario){
        factory = f;
        inicializaCores();
        this.mensagens = mens;
        this.gerenteCompraVenda = gerente;
        this.baralhoCofreComunitario = baralhoCofreComunitario;
        this.baralhoSorteReves = baralhoSorteReves;

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
            p.setPosicao(0 + aux - 40);
        } else {
            p.setPosicao(aux);
        }
        // Pega o lugar no qual o peão se encontra após ter andado
        Lugar l = tabuleiro.getListaLugar().get(p.getPosicao());

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
     * Método utilizado pra gerenciar o jogo. É ele que "conversa" com o jogador ou dispara outros
     * métodos.
     * @param tab
     * @param teclado
     * @param banco
     * @param jogadores
     */
    public void gerenciaJogo(Tabuleiro tab, Scanner teclado, Banco banco, List<Jogador> jogadores) {
        int auxNumJogadores;
        int nivelBurrice = 0;
        System.out.println("Digite o numero de jogadores: ");
        // Esse laço é usado para verificar se o jogador tem condições de entender os comandos do jogo.
        // Caso o jogador erre o número de jogadores mais de 4 vezes o jogo é encerrado.
        while (numJogadores == 0 && nivelBurrice < 4) {

            if (teclado.hasNextInt()) {

                auxNumJogadores = teclado.nextInt();

                if (auxNumJogadores >= 2 && auxNumJogadores <= 8) {
                    numJogadores = auxNumJogadores;
                    jogadores = factory.criaListaJogadores(numJogadores);


                } else {
                    nivelBurrice++;
                    System.out.println(mensagens.nivelBurrice(nivelBurrice, auxNumJogadores));
                }
            } else {
                System.out.println("Digite um número inteiro entre 2 e 8: ");
                teclado.next();

            }
        }
        if (nivelBurrice == 4) {
            return;
        }


        // Chama o método para receber os nomes e as cores dos jogadores
        armazenaNomeECorJogadores(jogadores, numJogadores, teclado);

        System.out.println("\nO jogo iniciou\n");

        int jogadorAtual = 0;
        int jogadorDepoisJogada = 0;
        while (numJogadores >= 2) {
            if (jogadorAtual >= numJogadores) {
                jogadorAtual = 0;
            }
            jogadorDepoisJogada = realizaJogada(jogadores, tab, jogadores.get(jogadorAtual), teclado, banco, jogadorAtual);
            // Verifica se algum jogador desistiu do jogo ou perdeu.
            // Caso sim, o próximo jogador estará na mesma posição na lista de jogadores que o jogador
            //que saiu
            if (jogadorDepoisJogada < jogadorAtual) {
                jogadorAtual = jogadorDepoisJogada;
            }
            jogadorAtual++;

        }
        if (numJogadores == 1) {
            System.out.println("\n\n\n Parabéns " + jogadores.get(0).getNomeJogador() + " ! Você é o mais novo"
                    + " milionario da America!");
            System.exit(0);
        }
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

    public int realizaJogada(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int numJogAtual, BaralhoCofreComunitario baralhoCofreComunitario, BaralhoSorteReves baralhoSorteReves) {
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
                    
                } else if (l instanceof SorteRevesConcreto ) {
                          baralhoSorteReves.retiraCartaPilha();
                } else if (l instanceof CofreComunitarioConcreto){
                          baralhoCofreComunitario.retiraCartaPilha();
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

    public int realizaJogada(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
