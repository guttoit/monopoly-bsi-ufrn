/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import gui.JanelaTabuleiroGUI;
import gui.LugarTabuleiroGUI;
import gui.TabuleiroGUI;
import guiAbstrato.TabuleiroGUIAbstrato;
import java.awt.Point;
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
import player.Dado;
import player.Jogador;
import player.concretos.BaralhoCofreComunitario;
import player.concretos.BaralhoSorteReves;
import player.concretos.CartaCofresComunitarios;
import player.concretos.CartaSorteReves;
import player.concretos.Peao;
import tabuleiro.*;
import tabuleiro.tabuleiroConcreto.Grupo;

/**
 *
 * @author Adm
 */
/**
 *
 * @class A classe Jogo detem os componentes necessarios para serem utilizados durante o Jogo.
 */
public class Jogo {

    private FactoryCriador factory;
    private List<Jogador> jogadores;
    private List<CartaCofresComunitarios> cartasCofresComunitarios;
    private List<CartaSorteReves> cartaSorteReveses;
    private List<Lugar> lugares;
    private GerenteJogo gerente;
    private GerenteCompraVenda gerenteCompraVendaConcreto;
    private GerenteSorteCofre gerenteSorteCofre;
    private Dado dado;
    private Peao peao;
    private Mensagens mensagens;
    private Tabuleiro tabuleiro;
    private int numJogadores;
    private Scanner teclado;
    private Banco banco;
    // Os baralhos usados
    private BaralhoCofreComunitario baralhoCofreComunitario;
    private BaralhoSorteReves baralhoSorteReves;
    //Lugares do tabuleiro
    private Lugar posicaoZero;
    private Lugar mediterraneanAvenue;
    private Lugar communityChest1;
    private Lugar balticAvenue;
    private Lugar incomeTax;
    private Lugar readingRailroad;
    private Lugar orientalAvenue;
    private Lugar chance;
    private Lugar vermontAvenue;
    private Lugar connecticutAvenue;
    private Lugar jailJustVisiting;
    private Lugar stCharlesPlace;
    private Lugar electricCompany;
    private Lugar statesAvenue;
    private Lugar virginiaAvenue;
    private Lugar pennsylvaniaRailroad;
    private Lugar stJamesPlace;
    private Lugar communityChest2;
    private Lugar tennesseeAvenue;
    private Lugar newYorkAvenue;
    private Lugar freeParking;
    private Lugar kentuckyAvenue;
    private Lugar chance2;
    private Lugar indianaAvenue;
    private Lugar illinoisAvenue;
    private Lugar beORailroad;
    private Lugar atlanticAvenue;
    private Lugar ventnorAvenue;
    private Lugar waterWorks;
    private Lugar marvinGardens;
    private Lugar pacificAvenue;
    private Lugar northCarolinaAvenue;
    private Lugar communityChest3;
    private Lugar pennsylvaniaAvenue;
    private Lugar shortLineRailroad;
    private Lugar chance3;
    private Lugar parkPlace;
    private Lugar luxuryTax;
    private Lugar boardwalk;
    private Lugar go;
    private Lugar sorteReves1;
    private Lugar sorteReves2;
    private Lugar sorteReves3;
    private Lugar cofreComunitario1;
    private Lugar cofreComunitario2;
    private Lugar cofreComunitario3;
    //Cartas cofres comunitários
    private CartaCofresComunitarios avanceParaOPontoDePartidaGo;
    private CartaCofresComunitarios erroDoBancoEmSeuFavor;
    private CartaCofresComunitarios taxaDoMedico;
    private CartaCofresComunitarios aberturaDaGrandeOpera;
    private CartaCofresComunitarios daLiquidacaoForaDeEstoque;
    private CartaCofresComunitarios saiaLivreDaPrisaoSemPagar;
    private CartaCofresComunitarios vaParaAPrisao;
    private CartaCofresComunitarios restituicaoDoImpostoDeRenda;
    private CartaCofresComunitarios aniversarioDoSeguroDeVida;
    private CartaCofresComunitarios pagueOHospital;
    private CartaCofresComunitarios pagueTaxaDaEscola;
    private CartaCofresComunitarios recebaPorSeusServicos;
    private CartaCofresComunitarios aniversarioDosFundosDeNatal;
    private CartaCofresComunitarios voceTirouOSegundoLugarNoConcursoDeBeleza;
    private CartaCofresComunitarios voceHerdou;
    private CartaCofresComunitarios voceDevePagarOsReparosDaRua;
    //Cadeia
    private Lugar jail;
    private Lugar goToJail;
    //Cartas sorte reves
    private CartaSorteReves avanceParaOPontoDePartida;
    private CartaSorteReves avancePara;
    private CartaSorteReves avanceParaStCharlesPlace;
    private CartaSorteReves avanceOPeaoParaOServicoPublicoMaisProximo;
    private CartaSorteReves avanceOPeaoParaAFerroviaMaisProxima;
    private CartaSorteReves oBancoLhePagouDividendosDe;
    private CartaSorteReves volte3Espacos;
    private CartaSorteReves vaDiretamenteParaAPrisao;
    private CartaSorteReves facaAmanutencaoDeTodasAsSuasPropriedades;
    private CartaSorteReves pagueImpostoDePobrezaDe;
    private CartaSorteReves estaCartaPodeSerMantidaAteSeuUsoOuVenda;
    private CartaSorteReves deUmaVoltaNaReading;
    private CartaSorteReves deUmaCaminhadaNoBoardWalk;
    private CartaSorteReves voceFoiEleitoPresidenteDoTabuleiro;
    private CartaSorteReves seusEmprestimosEInvestimentoFizeramAniversario;
    //Grupos
    private GrupoAbstrato grupoPreto;
    private GrupoAbstrato grupoBranco;
    private GrupoAbstrato grupoVermelho;
    private GrupoAbstrato grupoAzul;
    private GrupoAbstrato grupoAmarelo;
    private GrupoAbstrato grupoVerde;
    private GrupoAbstrato grupoRosa;
    private GrupoAbstrato grupoLaranja;
    //Lista de lugares de interface gráfica LugarTabuleiroGUI
    private Map lugaresTabuleiroGUI;
    private TabuleiroGUI tabuleiroGUI;
    private JanelaTabuleiroGUI janelaTabuleiroGUI;

    /**
     * Construtor de jogo que recebe um factoryCriador como parãmetro. Esse factory será usado para
     * criar as instânicas de todas as classes do jogo.
     * @param factory
     */
    public Jogo(FactoryCriador factory) {
        this.factory = factory;
        inicializaVariaveis();
        criaGrupos();
        criarLugares();
        
        tabuleiroGUI = factory.criaTabuleiroGUI(lugaresTabuleiroGUI, "C:/Users/Gutto/Desktop/monopoly-bsi-ufrn/tabuleiroMonopoly/FinalTabuleiro.png", gerente);
        montaTabuleiro(tabuleiro, lugares);
    }

    /**
     * Método responsável por dar início ao jogo. Ele chama o método gerenciaJogo do Gerente.
     */
    public void iniciaJogo() {
        tabuleiroGUI.addListaLugares(lugaresTabuleiroGUI);
        janelaTabuleiroGUI = new JanelaTabuleiroGUI(tabuleiroGUI);
        gerente.setTabuleiroGUI(tabuleiroGUI);
        tabuleiroGUI.setGerenteJogo(gerente);
        gerente.gerenciaJogo(tabuleiro, teclado, banco, jogadores);

        
    }

    /**
     * inicializa as variáveis através do fatory
     */
    public void inicializaVariaveis() {
        mensagens = factory.criaMensagens();
        baralhoCofreComunitario = factory.criaBaralhoCofreComunitario();
        baralhoSorteReves = factory.criaBaralhoSorteReves();
        criaCartasCofresComunitarios();
        criaCartasSorteReves();
        baralhoCofreComunitario.tracarBaralho();
        baralhoSorteReves.tracarBaralho();
        gerenteCompraVendaConcreto = factory.criaGerenteCompraVenda(factory);
        gerenteSorteCofre = factory.criaGerenteSorteCofre(baralhoSorteReves, baralhoCofreComunitario);
        gerente = factory.criaGerente(factory, mensagens, gerenteCompraVendaConcreto, gerenteSorteCofre);
        lugares = factory.criaLugares(40);
        tabuleiro = factory.criaTabuleiro(40);
        jogadores = factory.criaListaJogadores(8);
        lugaresTabuleiroGUI = new HashMap();
        
        
        teclado = new Scanner(System.in);

        banco = factory.criaBanco(32, 12);

    }

    public void criaGrupos() {
        grupoAmarelo = factory.criaGrupo("Amarelo");
        grupoAzul = factory.criaGrupo("Azul");
        grupoVerde = factory.criaGrupo("Verde");
        grupoVermelho = factory.criaGrupo("Vermelho");
        grupoBranco = factory.criaGrupo("Branco");
        grupoPreto = factory.criaGrupo("Preto");
        grupoRosa = factory.criaGrupo("Rosa");
        grupoLaranja = factory.criaGrupo("Laranja");
    }

    /**
     * Metodo para criar lugares no Tabuleiro.
     */
    public void criarLugares() {

        mediterraneanAvenue = factory.criaPropriedade(lugares, 1, "Mediterranean Avenue", (Grupo) grupoPreto, 60, 500, 10, 30, 90, 160, 250, 30, 90);
        lugaresTabuleiroGUI.put(1, factory.criaLugarTabuleiroGUI(mediterraneanAvenue, new Point(92, 0)));

        cofreComunitario1 = factory.criaCofresComunitarios(lugares, 2, "cofreComunitario1");
        lugaresTabuleiroGUI.put(2, factory.criaLugarTabuleiroGUI(cofreComunitario1, new Point(166, 0)));

        balticAvenue = factory.criaPropriedade(lugares, 3, "balticAvenue", (Grupo) grupoPreto, 60, 500, 20, 60, 80, 160, 450, 30, 50);
        lugaresTabuleiroGUI.put(3, factory.criaLugarTabuleiroGUI(balticAvenue, new Point(236, 0)));

        incomeTax = factory.criaImpostoRenda(lugares, 4, "incomeTax", 200);
        lugaresTabuleiroGUI.put(4, factory.criaLugarTabuleiroGUI(incomeTax, new Point(305, 0)));

        readingRailroad = factory.criaFerrovia(lugares, 5, "readingRailroad", 200, 100);
        lugaresTabuleiroGUI.put(5, factory.criaLugarTabuleiroGUI(readingRailroad, new Point(373, 0)));

        orientalAvenue = factory.criaPropriedade(lugares, 6, "orientalAvenue", (Grupo) grupoBranco, 100, 500, 30, 90, 270, 400, 550, 50, 50);
        lugaresTabuleiroGUI.put(6, factory.criaLugarTabuleiroGUI(orientalAvenue, new Point(440, 0)));

        sorteReves1 = factory.criaSorteReves(lugares, 7, "sorteReves1");
        lugaresTabuleiroGUI.put(7, factory.criaLugarTabuleiroGUI(sorteReves1, new Point(516, 0)));

        vermontAvenue = factory.criaPropriedade(lugares, 8, "vermontAvenue", (Grupo) grupoBranco, 100, 500, 30, 90, 270, 400, 550, 50, 50);
        lugaresTabuleiroGUI.put(8, factory.criaLugarTabuleiroGUI(vermontAvenue, new Point(580, 0)));

        connecticutAvenue = factory.criaPropriedade(lugares, 9, "connecticutAvenue", (Grupo) grupoBranco, 120, 500, 40, 100, 300, 450, 600, 60, 50);
        lugaresTabuleiroGUI.put(9, factory.criaLugarTabuleiroGUI(connecticutAvenue, new Point(654, 0)));

        jailJustVisiting = factory.criaPrisao(lugares,"jailJustVisiting", 10);
        lugaresTabuleiroGUI.put(10, factory.criaLugarTabuleiroGUI(jailJustVisiting, new Point(734, 0)));

        stCharlesPlace = factory.criaPropriedade(lugares, 11, "stCharlesPlace", (Grupo) grupoRosa, 140, 500, 50, 150, 450, 625, 750, 70, 100);
        lugaresTabuleiroGUI.put(11, factory.criaLugarTabuleiroGUI(stJamesPlace, new Point(734, 76)));

        electricCompany = factory.criaServicopublico(lugares,"electricCompany", 12, 150);
        lugaresTabuleiroGUI.put(12, factory.criaLugarTabuleiroGUI(electricCompany, new Point(734, 134)));

        statesAvenue = factory.criaPropriedade(lugares, 13, "statesAvenue", (Grupo) grupoRosa, 60, 500, 10, 30, 90, 160, 250, 30, 90);
        lugaresTabuleiroGUI.put(13, factory.criaLugarTabuleiroGUI(statesAvenue, new Point(734, 175)));

        virginiaAvenue = factory.criaPropriedade(lugares, 14, "virginiaAvenue", (Grupo) grupoRosa, 160, 500, 60, 180, 500, 700, 900, 80, 100);
        lugaresTabuleiroGUI.put(14, factory.criaLugarTabuleiroGUI(virginiaAvenue, new Point(734, 220)));

        pennsylvaniaRailroad= factory.criaFerrovia(lugares,15, "pennsylvaniaRailroad", 200, 100);
        lugaresTabuleiroGUI.put(15, factory.criaLugarTabuleiroGUI(pennsylvaniaRailroad, new Point(734, 267)));

        stJamesPlace = factory.criaPropriedade(lugares, 16, "stJamesPlace", (Grupo) grupoLaranja, 180, 500, 70, 200, 550, 750, 950, 90, 100);
        lugaresTabuleiroGUI.put(16, factory.criaLugarTabuleiroGUI(stJamesPlace, new Point(734, 310)));

        cofreComunitario2 = factory.criaCofresComunitarios(lugares, 17, "cofreComunitario2");
        lugaresTabuleiroGUI.put(17, factory.criaLugarTabuleiroGUI(cofreComunitario2, new Point(734, 374)));

        tennesseeAvenue = factory.criaPropriedade(lugares, 18, "tennesseeAvenue", (Grupo) grupoLaranja, 180, 500, 70, 200, 550, 750, 950, 90, 100);
        lugaresTabuleiroGUI.put(18, factory.criaLugarTabuleiroGUI(tennesseeAvenue, new Point(734, 410)));

        newYorkAvenue = factory.criaPropriedade(lugares, 19, "newYorkAvenue", (Grupo) grupoLaranja, 200, 500, 80, 220, 600, 800, 1000, 100, 100);
        lugaresTabuleiroGUI.put(19, factory.criaLugarTabuleiroGUI(newYorkAvenue, new Point(734, 472)));

        freeParking = factory.criaParadaLivre(lugares,"freeParking", 20, 0);
        lugaresTabuleiroGUI.put(20, factory.criaLugarTabuleiroGUI(freeParking, new Point(734, 534)));

        kentuckyAvenue = factory.criaPropriedade(lugares, 21, "kentuckyAvenue", (Grupo) grupoVermelho, 220, 500, 90, 250, 700, 875, 1050, 110, 150);
        lugaresTabuleiroGUI.put(21, factory.criaLugarTabuleiroGUI(kentuckyAvenue, new Point(654, 534)));

        sorteReves2 = factory.criaSorteReves(lugares, 22, "sorteReves2");
        lugaresTabuleiroGUI.put(22, factory.criaLugarTabuleiroGUI(sorteReves2, new Point(595, 534)));

        indianaAvenue = factory.criaPropriedade(lugares, 23, "indianaAvenue", (Grupo) grupoVermelho, 220, 500, 90, 250, 700, 875, 1050, 110, 150);
        lugaresTabuleiroGUI.put(23, factory.criaLugarTabuleiroGUI(indianaAvenue, new Point(516, 534)));

        illinoisAvenue = factory.criaPropriedade(lugares, 24, "illinoisAvenue", (Grupo) grupoVermelho, 240, 500, 100, 300, 750, 925, 1100, 120, 150);
        lugaresTabuleiroGUI.put(24, factory.criaLugarTabuleiroGUI(illinoisAvenue, new Point(440, 534)));

        beORailroad = factory.criaFerrovia(lugares, 25, "beORailroad", 200, 100);
        lugaresTabuleiroGUI.put(25, factory.criaLugarTabuleiroGUI(beORailroad, new Point(376, 534)));

        atlanticAvenue = factory.criaPropriedade(lugares, 26, "atlanticAvenue", (Grupo) grupoAmarelo, 260, 500, 110, 330, 800, 975, 1150, 130, 150);
        lugaresTabuleiroGUI.put(26, factory.criaLugarTabuleiroGUI(atlanticAvenue, new Point(305, 534)));

        ventnorAvenue = factory.criaPropriedade(lugares, 27, "ventnorAvenue", (Grupo) grupoAmarelo, 260, 500, 110, 330, 800, 975, 1150, 130, 150);
        lugaresTabuleiroGUI.put(27, factory.criaLugarTabuleiroGUI(ventnorAvenue, new Point(227, 534)));

        waterWorks = factory.criaServicopublico(lugares,"waterWorks", 28, 150);
        lugaresTabuleiroGUI.put(28, factory.criaLugarTabuleiroGUI(waterWorks, new Point(166, 534)));

        marvinGardens = factory.criaPropriedade(lugares, 29, "marvinGardens", (Grupo) grupoAmarelo, 280, 500, 120, 360, 850, 1025, 1200, 140, 150);
        lugaresTabuleiroGUI.put(29, factory.criaLugarTabuleiroGUI(marvinGardens, new Point(92, 534)));

        goToJail = factory.criaVaParaPrisao(lugares,"gotoJail", 30);
        lugaresTabuleiroGUI.put(30, factory.criaLugarTabuleiroGUI(goToJail, new Point(0, 534)));

        pacificAvenue = factory.criaPropriedade(lugares, 31, "pacificAvenue", (Grupo) grupoVerde, 300, 500, 130, 390, 900, 1100, 1275, 150, 200);
        lugaresTabuleiroGUI.put(31, factory.criaLugarTabuleiroGUI(pacificAvenue, new Point(0, 472)));

        northCarolinaAvenue = factory.criaPropriedade(lugares, 32, "northCarolinaAvenue", (Grupo) grupoVerde, 260, 500, 110, 330, 800, 975, 1150, 130, 150);
        lugaresTabuleiroGUI.put(32, factory.criaLugarTabuleiroGUI(northCarolinaAvenue, new Point(0, 410)));

        cofreComunitario3 = factory.criaCofresComunitarios(lugares, 33, "cofreComunitario3");
        lugaresTabuleiroGUI.put(33, factory.criaLugarTabuleiroGUI(cofreComunitario3, new Point(0, 374)));

        pennsylvaniaAvenue = factory.criaPropriedade(lugares, 34, "pennsylvaniaAvenue", (Grupo) grupoVerde, 320, 500, 150, 450, 1000, 1200, 1400, 160, 200);
        lugaresTabuleiroGUI.put(34, factory.criaLugarTabuleiroGUI(pennsylvaniaAvenue, new Point(0, 310)));

        shortLineRailroad = factory.criaFerrovia(lugares, 35, "shortLineRailroad", 200, 100);
        lugaresTabuleiroGUI.put(35, factory.criaLugarTabuleiroGUI(shortLineRailroad, new Point(0, 257)));

        sorteReves3 = factory.criaSorteReves(lugares, 36, "SorteReves");
        lugaresTabuleiroGUI.put(36, factory.criaLugarTabuleiroGUI(sorteReves3, new Point(0, 220)));

        parkPlace = factory.criaPropriedade(lugares, 37, "parkPlace", (Grupo) grupoAzul, 350, 500, 175, 500, 1100, 1300, 1500, 175, 200);
        lugaresTabuleiroGUI.put(37, factory.criaLugarTabuleiroGUI(parkPlace, new Point(0, 175)));

        luxuryTax = factory.criaImpostoRiqueza(lugares, 38, "luxuryTax", 75);
        lugaresTabuleiroGUI.put(38, factory.criaLugarTabuleiroGUI(luxuryTax, new Point(0, 134)));

        boardwalk = factory.criaPropriedade(lugares, 39, "boardwalk", (Grupo) grupoAzul, 400, 500, 200, 600, 1400, 1700, 2000, 200, 200);
        lugaresTabuleiroGUI.put(39, factory.criaLugarTabuleiroGUI(boardwalk, new Point(0, 76)));

        go = factory.criaLugar(lugares, 40, "Go");
        lugaresTabuleiroGUI.put(40, factory.criaLugarTabuleiroGUI(go, new Point(0, 0)));
    }

    /**
     *
     */
    public void criaCartasCofresComunitarios() {

        avanceParaOPontoDePartidaGo = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 1, "AvanceParaOPontoDePartidaGo", "Receba $200", "Isso não é um bônus, ou seja, os $200 referem-se ao valor que o jogador recebe normalmente ao passar pelo Ponto de Partida.");

        erroDoBancoEmSeuFavor = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 2, "ErroDoBancoEmSeuFavor", "Receba $200", "");

        taxaDoMedico = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 3, "TaxaDoMedico", "Pague $50", "Isso não é um bônus, ou seja, os $200 referem-se ao valor que o jogador recebe normalmente ao passar pelo Ponto de Partida.");

        aberturaDaGrandeOpera = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 4, "AberturaDaGrandeOpera", "Receba $50 de cada jogador pelas entradas", "");

        daLiquidacaoForaDeEstoque = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 5, "DaLiquidacaoForaDeEstoque", "Receba $45", "");

        saiaLivreDaPrisaoSemPagar = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 6, "SaiaLivreDaPrisaoSemPagar", "Esta carta pode ser mantida até o uso ou venda.", "Veja a user story sobre a prisão");

        vaParaAPrisao = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 7, "VaParaAPrisao", "Vá direto para a prisão – Não passe pelo ponto de partida – Não receba $200", "");

        restituicaoDoImpostoDeRenda = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 8, "RestituicaoDoImpostoDeRenda", "Receba $20", "");

        aniversarioDoSeguroDeVida = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 9, "AniversarioDoSeguroDeVida", "Receba $100", "");

        pagueOHospital = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 10, "PagueOHospital", "Pague $100", "");

        pagueTaxaDaEscola = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 11, "PagueTaxaDaEscola", "Pague $150", "");

        recebaPorSeusServicos = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 12, "RecebaPorSeusServicos", "Receba $25", "");

        aniversarioDosFundosDeNatal = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 13, "AniversarioDosFundosDeNatal", "Receba $100", "");

        voceTirouOSegundoLugarNoConcursoDeBeleza = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 14, "VoceTirouOSegundoLugarNoConcursoDeBeleza", "Receba $10", "");

        voceHerdou = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 15, "VoceHerdou", "Receba $100", "");

        voceDevePagarOsReparosDaRua = factory.criaCartasCofresComunitarios(baralhoCofreComunitario, 16, "VoceDevePagarOsReparosDaRua", "Pague $40 por cada casa, $115 por hotel", "Isso se aplica apenas às casas e hotéis que o jogador possui; ele não precisa pagar pelas casas e hotéis dos outros jogadores.");

    }

    /**
     *
     */
    public void criaCartasSorteReves() {


        avanceParaOPontoDePartida = factory.criaCartasSorteReves(baralhoSorteReves, 1, "avanceParaOPontoDePartida", "Receba $200", "");

        avancePara = factory.criaCartasSorteReves(baralhoSorteReves, 2, "avancePara", "Illinois Avenue", "O jogador não recebe $200 se passar pelo Ponto de Partida.");

        avanceParaStCharlesPlace = factory.criaCartasSorteReves(baralhoSorteReves, 3, "avanceParaStCharlesPlace", "Se passer pelo ponto de partida, receba $200", "");

        avanceOPeaoParaOServicoPublicoMaisProximo = factory.criaCartasSorteReves(baralhoSorteReves, 4, "avanceOPeaoParaOServicoPublicoMaisProximo", "Se não tiver dono você pode comprá-lo do banco.Se tiver, lance os dados e pague ao dono 10 vezes o resultado do lançamento.", " O jogador não recebe $200 se passar pelo Ponto de Partida.");

        avanceOPeaoParaAFerroviaMaisProxima = factory.criaCartasSorteReves(baralhoSorteReves, 5, "avanceOPeaoParaAFerroviaMaisProxima", "Pague ao dono duas vezes o valor que ele deveria receber normalmente.Se a ferrovia não tiver dono, você pode comprá-la do banco.", "O jogador não recebe $200 se passar pelo Ponto de Partida. ");

        oBancoLhePagouDividendosDe = factory.criaCartasSorteReves(baralhoSorteReves, 6, "oBancoLhePagouDividendosDe", "$50", "");

        volte3Espacos = factory.criaCartasSorteReves(baralhoSorteReves, 7, "volte3Espacos", "   ", "");

        vaDiretamenteParaAPrisao = factory.criaCartasSorteReves(baralhoSorteReves, 8, "vaDiretamenteParaAPrisao", "Não passe pelo ponto de partida, não receba $200.", "");

        facaAmanutencaoDeTodasAsSuasPropriedades = factory.criaCartasSorteReves(baralhoSorteReves, 9, "facaAmanutencaoDeTodasAsSuasPropriedades", "Para cada casa pague $25, para cada hotel $10.", " Somente para casas e hotéis que o jogador construiu.");

        pagueImpostoDePobrezaDe = factory.criaCartasSorteReves(baralhoSorteReves, 10, "pagueImpostoDePobrezaDe", "$15", "");

        estaCartaPodeSerMantidaAteSeuUsoOuVenda = factory.criaCartasSorteReves(baralhoSorteReves, 11, "estaCartaPodeSerMantidaAteSeuUsoOuVenda", "Get Out Of Jail Free", " Veja user stories sobre Prisão ");

        deUmaVoltaNaReading = factory.criaCartasSorteReves(baralhoSorteReves, 12, "deUmaVoltaNaReading", "Se você passer pelo Ponto de Partida receba $200", "");

        deUmaCaminhadaNoBoardWalk = factory.criaCartasSorteReves(baralhoSorteReves, 13, "deUmaCaminhadaNoBoardWalk ", "Avance o peão para Board Walk", "");

        voceFoiEleitoPresidenteDoTabuleiro = factory.criaCartasSorteReves(baralhoSorteReves, 14, "voceFoiEleitoPresidenteDoTabuleiro", "Pague $50 para cada jogador", "");

        seusEmprestimosEInvestimentoFizeramAniversario = factory.criaCartasSorteReves(baralhoSorteReves, 15, "seusEmprestimosEInvestimentoFizeramAniversario", "Receba $150", "");

    }

    /**
     * Metodo para montar o tabuleiro com seus respectivos lugares.
     * @param t
     * @param lugares
     */
    public void montaTabuleiro(Tabuleiro t, List<Lugar> lugares) {

        for (Lugar l : lugares) {
            t.addLugar(l);
        }

    }

    /**
     *
     * @return
     */
    public List<CartaSorteReves> getCartaSorteReveses() {
        return cartaSorteReveses;
    }

    /**
     *
     * @param cartaSorteReveses
     */
    public void setCartaSorteReveses(List<CartaSorteReves> cartaSorteReveses) {
        this.cartaSorteReveses = cartaSorteReveses;
    }

    /**
     *
     * @return
     */
    public List<CartaCofresComunitarios> getCartasCofresComunitarios() {
        return cartasCofresComunitarios;
    }

    /**
     *
     * @param cartasCofresComunitarios
     */
    public void setCartasCofresComunitarios(List<CartaCofresComunitarios> cartasCofresComunitarios) {
        this.cartasCofresComunitarios = cartasCofresComunitarios;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    /**
     *
     * @param jogadores
     */
    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    /**
     *
     * @return
     */
    public Dado getDado() {
        return dado;
    }

    /**
     *
     * @param dado
     */
    public void setDado(Dado dado) {
        this.dado = dado;
    }

    /**
     *
     * @return
     */
    public GerenteJogo getGerente() {
        return gerente;
    }

    /**
     *
     * @param gerente
     */
    public void setGerente(GerenteJogo gerente) {
        this.gerente = gerente;
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
    public Peao getPeao() {
        return peao;
    }

    /**
     *
     * @param peao
     */
    public void setPeao(Peao peao) {
        this.peao = peao;
    }

    /**
     *
     * @return
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    /**
     *
     * @param tabuleiro
     */
    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
