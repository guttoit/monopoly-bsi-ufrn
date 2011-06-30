package negocio.negocioConcreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import negocio.Banco;
import negocio.FactoryCriador;
import negocio.GerenteCompraVenda;
import negocio.GerenteJogo;
import negocio.GerenteSorteCofre;
import negocio.Mensagens;
import player.Jogador;
import player.concretos.DadoDuplo;
import player.concretos.Peao;
import tabuleiro.Imposto;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.CofreComunitarioConcreto;
import tabuleiro.tabuleiroConcreto.Prisao;
import tabuleiro.tabuleiroConcreto.Propriedade;
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
    public GerenteJogoConcreto(FactoryCriador f, Mensagens mens, GerenteCompraVenda gerente, GerenteSorteCofre gerenteSorteCofre) {
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

        if (jogador.isEstaNaPrisao()) {
            // Verifica se os valores dados são diferentes, caso seja, ele incrementa uma tentativa de sair
            // da prisão. Se atingir três tentativas ou jogador paga 50 e sai da prisão...
            if (valorDado[0] != valorDado[1]) {
                jogador.setTentativasSairPrisao(jogador.getTentativasSairPrisao() + 1);
                jogador.setJogaNovamente(false);
                if (jogador.getTentativasSairPrisao() == 3) {
                    System.out.println("\n Você tentou sair 3 vezes da prisao e não conseguiu... Será"
                            + " descontado 50 reais da sua conta.");
                    jogador.setDinheiro(jogador.getDinheiro() - 50);
                    jogador.setEstaNaPrisao(false);
                } else {
                    for (Lugar l : tabuleiro.getListaLugar()) {
                        if (l instanceof Prisao) {
                            return l;
                        }
                    }
                }
            } else {
                jogador.setTentativasSairPrisao(0);
                jogador.setEstaNaPrisao(false);
                System.out.println("\n Você tirou números iguais e conseguiu sair da prisão...");
            }
        } else // Verifica se os valores dos dados são iguais, caso seja ele poderá jogar novamente, porém
        // se for a terceira vez seguida que ele tira números iguais, então ele irá para a prisão
        if (valorDado[0] == valorDado[1]) {
            jogador.setNumVezesDadosIguais(jogador.getNumVezesDadosIguais() + 1);
            if (jogador.getNumVezesDadosIguais() >= 3) {
                jogador.setNumVezesDadosIguais(0);
                System.out.println("\n Você tirou números iguais três vezes siguidas e vai para prisão...");
                jogador.getPeao().setPosicao(10);
                jogador.setEstaNaPrisao(true);
                jogador.setJogaNovamente(false);
                for (Lugar l : tabuleiro.getListaLugar()) {
                    if (l instanceof Prisao) {
                        return l;
                    }
                }
            } else {
                jogador.setJogaNovamente(true);
            }
        } else {
            jogador.setJogaNovamente(false);
            jogador.setNumVezesDadosIguais(0);
        }

        // Verifica se o peão passou pela posição de origem ou não. Caso tenha passado, a sua posição
        // é transforma nos parâmetros que o jogo aceita.
        if (verificaPosicao(valorDado, jogador, tabuleiro)) {
            if (aux == 40) {
                p.setPosicao(40 - 1);
            }
            p.setPosicao(0 + aux - 40);
        } else {
            p.setPosicao(aux);
        }
        // Pega o lugar no qual o peão se encontra após ter andado
        Lugar l = tabuleiro.getListaLugar().get(p.getPosicao() + 1);


        // Chama o método mostraMensAndaPeao da classe MensagensJogo para mostrar ao usuário o seu lugar no jogo.
        mensagens.mostraMensAndaPeao(jogador, l, valorDado);
        tabuleiroGUI.repaint();
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
    public void armazenaNomeECorJogadores(List<Jogador> jogadores, int numJogadores, Scanner teclado) {
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
            jogadores.get(i).getPeao().setCaminhoImagemPeao(pegaCaminhoPeao(corDigitada));
            jogadores.get(i).setDinheiro(1500);
            for (int j = 0; j < auxCor.length; j++) {
                if (corDigitada.equalsIgnoreCase(auxCor[j])) {
                    auxCor[j] = "";
                }
            }
            System.out.println("\n A cor escolhida foi " + corDigitada + "\n");
        }

    }

    public String pegaCaminhoPeao(String cor){
        String corPeao;
        if(cor.equalsIgnoreCase("branco")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Branco.png";
            return corPeao;
        }else if(cor.equalsIgnoreCase("azul")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Azul.png";
            return corPeao;
        }else if(cor.equalsIgnoreCase("verde")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Verde.png";
            return corPeao;
        }else if(cor.equalsIgnoreCase("amarelo")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Amarelo.png";
            return corPeao;
        }else if(cor.equalsIgnoreCase("vermelho")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Vermelho.png";
            return corPeao;
        }else if(cor.equalsIgnoreCase("preto")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Preto.png";
            return corPeao;
        }else if(cor.equalsIgnoreCase("rosa")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Rosa.png";
            return corPeao;
        }else if(cor.equalsIgnoreCase("laranja")){
            corPeao = "C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/Laranja.png";
            return corPeao;
        }
        return new String("C:/Users/gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/peaoAzul.png");
    }

    //Variável usada apenas nos métodos realizaJogada e realizaJogadaPrisao
    String comando = "";



    public Lugar realizaJogadaPrisao(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int numJogAtual) {
        Lugar l = null;
        String comando = "";
        // Verifica se o jogador possui uma carta para sair da prisão. Caso possua então
        // é mostrado a ele a opção de usar carta.
        if (jogadorVez.isTemCartaCofreComuSairPrisao() || jogadorVez.isTemCartaSorteRevesSairPrisao()) {
            comando = mensagens.mensagemEstaPresoComCarta(jogadorVez, teclado);
        } else {
            comando = mensagens.mensagemEstaPreso(jogadorVez, teclado);
        }

        if (comando.equalsIgnoreCase("pagar")) {
            jogadorVez.setDinheiro(jogadorVez.getDinheiro() - 50);
            jogadorVez.setEstaNaPrisao(false);

            l = andaPeao(jogadorVez.jogaDado(new DadoDuplo()), jogadorVez, tab);

        } else if (comando.equalsIgnoreCase("carta")) {
            if (jogadorVez.isTemCartaCofreComuSairPrisao()) {
                jogadorVez.setTemCartaCofreComuSairPrisao(false);

            } else if (jogadorVez.isTemCartaSorteRevesSairPrisao()) {
                jogadorVez.setTemCartaSorteRevesSairPrisao(false);

            }
            jogadorVez.setEstaNaPrisao(false);

            l = andaPeao(jogadorVez.jogaDado(new DadoDuplo()), jogadorVez, tab);

        }
        return l;
    }

    public int realizaJogada(List<Jogador> jogadores, Tabuleiro tab, Jogador jogadorVez, Scanner teclado, Banco b, int numJogAtual) {
        Lugar l = null;
        boolean acertouComando = false;
        //Pega os lugares em que o jogador pode construir casas ou hoteis
        List<LugarFisico> lugaresParaConstruir = jogadorVez.lugaresPossoConstruir();
        while (!acertouComando || jogadorVez.isJogaNovamente()) {
            //Verifica se o jogador está com saldo negativo e pode se recuperar
            if (jogadorVez.getDinheiro() <= 0 && jogadorVez.getListaLugarFisico().size() > 0) {
                System.out.println(jogadorVez.getNomeJogador() + " você está com saldo negativo, mas pode vender\n"
                        + "vender e/ou hipotecar títulos.");
                System.out.println("Os comandos disponiveis são: [Vender] [Hipotecar] [Sair] [status]");
                comando = teclado.next();
            } else if (jogadorVez.isEstaNaPrisao()) {
                l = realizaJogadaPrisao(jogadores, tab, jogadorVez, teclado, b, numJogAtual);

            } else {
                System.out.println("\nA jogada de " + jogadorVez.getNomeJogador() + " comecou.");
                if (podeVender(jogadorVez) || (!lugaresParaConstruir.isEmpty() && (b.getNumCasasDisponiveis() > 0))) {
                    if (!(podeVender(jogadorVez))) {
                        System.out.println("\nComandos disponiveis: [Construir] [Jogar]   [Sair]   [status]");
                    } else if (!(!lugaresParaConstruir.isEmpty() && (b.getNumCasasDisponiveis() > 0))) {
                        System.out.println("\nComandos disponiveis: [Vender] [Jogar] [Sair]   [status]");
                    } else {
                        System.out.println("\nComandos disponiveis: [Construir] [Vender] [Jogar] [Sair]   [status]");
                    }

                    //Testa se existe algum lugar disponível para construir e chama a função do gerenteCompraVenda
                } else {
                    System.out.println("\nComandos disponiveis: [Jogar] [Sair]   [status]");
                }

                System.out.println("\nEntre com o comando");
                comando = teclado.next().trim();
            }
            if (comando.equalsIgnoreCase("sair")) {
                acertouComando = true;
                jogadores.remove(jogadorVez);
                numJogadores--;
                numJogAtual--;
                //Verifica se só existe um jogador
                if (jogadores.size() <= 1) {
                    System.out.println("\n\n\n Parabéns " + jogadores.get(0).getNomeJogador() + " ! Seu adversário desistiu e"
                            + " você é o mais novo" + " milionario da America!");
                    System.exit(0);
                }
                return numJogAtual;
            } else if (comando.equalsIgnoreCase("status")) {
                mensagens.statusJogador(jogadorVez, tab);
            } else if (comando.equalsIgnoreCase("jogar")) {
                acertouComando = true;
                l = andaPeao(jogadorVez.jogaDado(new DadoDuplo()), jogadorVez, tab);
            } else if (comando.equalsIgnoreCase("construir")) {
                gerenteCompraVenda.construir(jogadorVez, lugaresParaConstruir, teclado, b, mensagens);
            } else if (comando.equalsIgnoreCase("vender")) {
                List<LugarFisico> lugares = new ArrayList<LugarFisico>();
                lugares.addAll(jogadorVez.getListaLugarFisico());
                
                while (podeVender(jogadorVez)) {
                    System.out.println(jogadorVez.getNomeJogador() + " tem $" + jogadorVez.getDinheiro());
                    System.out.println("\nEscolha o que quer vender:");

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

                    int escolhaVenda = -1;
                    while (escolhaVenda != 0) {
                        if (teclado.hasNextInt()) {
                            escolhaVenda = teclado.nextInt();
                            if ((escolhaVenda) > contador) {
                                System.out.println("Comando errado. Digite um número inteiro dentre os oferecidos ");
                                escolhaVenda = -1;

                            } else if (escolhaVenda > 0) {
                                Propriedade p = (Propriedade) mapa.get(escolhaVenda);
                                gerenteCompraVenda.venda(jogadorVez, p, b);
                                escolhaVenda = 0;
                            }

                        } else {
                            teclado.next();
                            System.out.println("Comando errado. Digite um número inteiro dentre os oferecidos ");
                            escolhaVenda = -1;
                        }

                    }

                }
            }else if(comando.equalsIgnoreCase("hipotecar")){
                System.out.println(" Esta funcionalidade ainda não foi implementada. Tente a opção vender.");
            }
            // Gambiarra para evitar que ele entre nas condições abaixo sem ter jogado o dado
            if (comando.equalsIgnoreCase("jogar") || comando.equalsIgnoreCase("pagar") || comando.equalsIgnoreCase("carta")) {
                if (l == null) {
                    if (jogadorVez.getNumVezesDadosIguais() >= 3) {
                        System.out.println("\nNao faz nada.");

                    }

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

                } else if (l instanceof SorteRevesConcreto) {
                    SorteRevesConcreto sorteReves = (SorteRevesConcreto) l;
                    gerenteSorteCofre.gerenciaJogadaCarta(jogadorVez, sorteReves, (MensagensJogo) mensagens, tab, jogadores, b);

                } else if (l instanceof CofreComunitarioConcreto) {
                    CofreComunitarioConcreto cofreComunitario = (CofreComunitarioConcreto) l;
                    gerenteSorteCofre.gerenciaJogadaCarta(jogadorVez, cofreComunitario, (MensagensJogo) mensagens, tab, jogadores, b);

                } else if (l instanceof VaParaPrisao) {
                    mensagens.vaParaPrisao();
                    jogadorVez.getPeao().setPosicao(10);
                    jogadorVez.setEstaNaPrisao(true);

                } else if (l instanceof Prisao) {
                    if (jogadorVez.isEstaNaPrisao()) {
                        System.out.println("\n Você tentou sair da prisão mas não conseguiu. Fica para a"
                                + "próxima");

                    } else if (jogadorVez.getNumVezesDadosIguais() >= 3) {
                    } else {
                        mensagens.visitaPrisao();
                    }

                }
            } else if (!comando.equalsIgnoreCase("construir") || !comando.equalsIgnoreCase("vender")) {
                // System.out.println("\nComando errado. Tente novamente.");
            }
            //Verifica se o jogador está com saldo negativo mas pode recuperar
            if (jogadorVez.getDinheiro() <= 0 && jogadorVez.getListaLugarFisico().size() > 0) {
                acertouComando = false;
                //evitaFalencia(jogadorVez, null, null);

            } else if (jogadorVez.getDinheiro() <= 0 && jogadorVez.getListaLugarFisico().size() <= 0) {
                System.out.println("\n" + jogadorVez.getNomeJogador() + " Você perdeu. Seu saldo é: " + jogadorVez.getDinheiro());
                numJogAtual--;
                numJogadores--;
                jogadores.remove(jogadorVez);
            }

        }

        return numJogAtual;



    }

    /*public void evitaFalencia(List<Jogador> jogadores, Tabuleiro tab, Jogador jogador, Scanner teclado, Banco b, int numJogAtual) {


        if ((jogador.getListaLugarFisico().size() > 0)) {
            realizaJogada(jogadores, tab, jogador, teclado, b, numJogAtual);

        }
    }*/

     @Override
    public void evitaFalencia(Jogador jogador, Jogo jogo, Propriedade propriedade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean podeVender(Jogador j) {

        for (LugarFisico l : j.getListaLugarFisico()) {
            if (l instanceof Propriedade) {
                if (((Propriedade) l).getnCasas() > 0) {
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * 
     * @return
     */
    String[] getCores() {
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
