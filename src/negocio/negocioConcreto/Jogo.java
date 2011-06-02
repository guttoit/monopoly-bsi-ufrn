/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import java.util.List;
import java.util.Scanner;
import negocio.Banco;
import negocio.FactoryCriador;
import negocio.GerenteJogo;
import negocio.Mensagens;
import player.Dado;
import player.Jogador;
import player.concretos.Baralho;
import player.concretos.CartaCofresComunitarios;
import player.concretos.Peao;
import tabuleiro.*;
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
    private GerenteJogo gerente;
    private Dado dado;
    private Peao peao;
    private Mensagens mensagens;
  //private Status status;
    private Tabuleiro tabuleiro;
    private int numJogadores;
    private List<Lugar> lugares;
    private Scanner teclado;
    private Banco banco;

    private Baralho baralho;


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

    private Lugar gotoJail;

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



    /**
     * Construtor de jogo que recebe um factoryCriador como parãmetro. Esse factory será usado para
     * criar as instânicas de todas as classes do jogo.
     * @param factory
     */

    
    public Jogo(FactoryCriador factory) {
        this.factory = factory;
        inicializaVariaveis();
        criarLugares();
        montaTabuleiro(tabuleiro, lugares);
    }

    /**
     * Método responsável por dar início ao jogo. Ele chama o método gerenciaJogo do Gerente.
     */
    public void iniciaJogo(){
        gerente.gerenciaJogo(tabuleiro, teclado, banco, jogadores, mensagens);
    }

    /**
     * inicializa as variáveis através do fatory
     */
    public void inicializaVariaveis(){
        gerente = factory.criaGerente(factory);
        tabuleiro = factory.criaTabuleiro(40);
        jogadores = factory.criaListaJogadores(8);
        mensagens = factory.criaMensagens();
        teclado = new Scanner(System.in);
        lugares = factory.criaLugares(40);
        banco = factory.criaBanco();
//        baralho = factory.criaBaralho();
    }

   /*
    public void criaLugaresTeste(){
         mediterraneanAvenue= factory.criaPropriedade(lugares, 1, "Mediterranean Avenue", "roxo", 60, 200, 10, 30, 90, 160, 250, 30, 90);

       // communityChest1 = factory.criaImpostoRenda(lugares, numJogadores, null, numJogadores);

        balticAvenue= factory.criaPropriedade(lugares,3, "balticAvenue", "roxo", 60 , 200 , 20 , 60 , 80 ,160 , 450 , 30 , 50);

        incomeTax = factory.criaImpostoRenda(lugares,4, "Income Tax", 200);

        readingRailroad = factory.criaFerrovia(lugares,5, "Reading Railroad", 200, 100);

        orientalAvenue = factory.criaPropriedade(lugares,6, "orientalAvenue", "AzulClaro" , 100, 200, 30, 90, 270, 400, 550,50, 50);

        //chance = factory.criaChance(lugares,7, "chance", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        vermontAvenue = factory.criaPropriedade(lugares,8, "vermontAvenue", "AzulClaro",  100 ,  200,	30  ,  90 , 270 ,  400 ,  550,	  50,  50);

        connecticutAvenue= factory.criaPropriedade(lugares,9, "connecticutAvenue", "AzulClaro",	120,	200,	40,	100,	300,	450,	600,	60,	50);

       // jailJustVisiting= factory.cria

        stCharlesPlace= factory.criaPropriedade(lugares,11, "stCharlesPlace", "Cinza",	140,	500,	50,	150,	450,	625,	750,	70,	100);

  //serviços públicos  electricCompany= factory.criaPropriedade(lugares,12, "electricCompany", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        statesAvenue= factory.criaPropriedade(lugares,13, "statesAvenue", "roxo", 60, 500, 10, 30, 90, 160, 250, 30, 90);

        virginiaAvenue= factory.criaPropriedade(lugares,14, "virginiaAvenue", " ",160, 500,	60,	180,	500,	700,	900,	80,	100);

   // esse usa cor     pennsylvaniaRailroad= factory.criaFerrovia(lugares,15, "pennsylvaniaRailroad", 200, 100);

        stJamesPlace= factory.criaPropriedade(lugares,16, "stJamesPlace", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        //communityChest2= factory.criaChance();

        tennesseeAvenue= factory.criaPropriedade(lugares,18, "tennesseeAvenue", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        newYorkAvenue= factory.criaPropriedade(lugares,19, "newYorkAvenue", "Laranja",	200,	500,	80,	220,	600,	800,	1000,	100,	100);

       // freeParking= factory.cria

        kentuckyAvenue= factory.criaPropriedade(lugares,21, "kentuckyAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

       // chance2= factory.criaChance()

        indianaAvenue= factory.criaPropriedade(lugares,23, "indianaAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

        illinoisAvenue= factory.criaPropriedade(lugares,24, "illinoisAvenue", "Vermelho",	240,	500,	100,	300,	750,	925,	1100,	120,	150);

        beORailroad= factory.criaFerrovia(lugares,25, "Be O Railroad", 200, 100);

        atlanticAvenue= factory.criaPropriedade(lugares,26, "atlanticAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

        ventnorAvenue= factory.criaPropriedade(lugares,27, "ventnorAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

       //serviços públicos  waterWorks= factory.cria

        marvinGardens= factory.criaPropriedade(lugares,29, "marvinGardens",  "Amarelo",	  280,	500,	120,	360,	850,	1025,	1200,	140,	150);

       // gotoJail= factory.criaPropriedade(lugares,30, "gotoJail", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pacificAvenue= factory.criaPropriedade(lugares,31, "pacificAvenue", "Verde",	300,	26,	500,	390,	900,	1100,	1275,	150,	200);

        northCarolinaAvenue= factory.criaPropriedade(lugares,32, "northCarolinaAvenue", "Verde",	260,	500,	110,	330,	800,	975,	1150,	130,	150);

       // communityChest3= factory.criaPropriedade(lugares,33, "communityChest3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaAvenue= factory.criaPropriedade(lugares,34, "pennsylvaniaAvenue", "Verde",	320,	500,	150,	450,	1000,	1200,	1400,	160,	200);

        shortLineRailroad= factory.criaFerrovia(lugares,35, "ShortLine Railroad", 200, 100);

       // chance3= factory.criaPropriedade(lugares,36, "chance3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        parkPlace= factory.criaPropriedade(lugares,37, "parkPlace", " Azul",	350,	500,	175,	500,	1100,	1300,	1500,	175,	200);

        luxuryTax= factory.criaImpostoRiqueza(lugares,38, "Luxury Tax", 75);

        boardwalk= factory.criaPropriedade(lugares,39, "boardwalk", "Azul",	400,	500,	200,	600,	1400,	1700,	2000,	200,	200);

         go= factory.criaLugar(lugares,0, "inicio");
    }*/
    /**
     * Metodo para criar lugares no Tabuleiro.
     */
    public void criarLugares(){
        

        mediterraneanAvenue= factory.criaPropriedade(lugares, 1, "Mediterranean Avenue", "roxo", 60, 500, 10, 30, 90, 160, 250, 30, 90);

       // communityChest1 = factory.criaImpostoRenda(lugares, numJogadores, null, numJogadores);

        balticAvenue= factory.criaPropriedade(lugares,3, "balticAvenue", "roxo", 60 , 500 , 20 , 60 , 80 ,160 , 450 , 30 , 50);

        incomeTax = factory.criaImpostoRenda(lugares,4, "incomeTax", 200);

        readingRailroad = factory.criaFerrovia(lugares,5, "readingRailroad", 200, 100);

        orientalAvenue = factory.criaPropriedade(lugares,6, "orientalAvenue", "AzulClaro" , 100, 500, 30, 90, 270, 400, 550,50, 50);

        //chance = factory.criaChance(lugares,7, "chance", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        vermontAvenue = factory.criaPropriedade(lugares,8, "vermontAvenue", "AzulClaro",  100 ,  500,	30  ,  90 , 270 ,  400 ,  550,	  50,  50);

        connecticutAvenue= factory.criaPropriedade(lugares,9, "connecticutAvenue", "AzulClaro", 120,	500,	40,	100,	300,	450,	600,	60,	50);

       // jailJustVisiting= factory.cria

        stCharlesPlace= factory.criaPropriedade(lugares,11, "stCharlesPlace", "Cinza",	140,	500,	50,	150,	450,	625,	750,	70,	100);

  //serviços públicos  electricCompany= factory.criaPropriedade(lugares,12, "electricCompany", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        statesAvenue= factory.criaPropriedade(lugares,13, "statesAvenue", "roxo", 60, 500, 10, 30, 90, 160, 250, 30, 90);

        virginiaAvenue= factory.criaPropriedade(lugares,14, "virginiaAvenue", " ",160,	500,	60,	180,	500,	700,	900,	80,	100);

   // esse usa cor     pennsylvaniaRailroad= factory.criaFerrovia(lugares,15, "pennsylvaniaRailroad", 200, 100);

        stJamesPlace= factory.criaPropriedade(lugares,16, "stJamesPlace", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        //communityChest2= factory.criaChance();

        tennesseeAvenue= factory.criaPropriedade(lugares,18, "tennesseeAvenue", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        newYorkAvenue= factory.criaPropriedade(lugares,19, "newYorkAvenue", "Laranja",	200,	500,	80,	220,	600,	800,	1000,	100,	100);

       // freeParking= factory.cria

        kentuckyAvenue= factory.criaPropriedade(lugares,21, "kentuckyAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

       // chance2= factory.criaChance()

        indianaAvenue= factory.criaPropriedade(lugares,23, "indianaAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

        illinoisAvenue= factory.criaPropriedade(lugares,24, "illinoisAvenue", "Vermelho",	240,	500,	100,	300,	750,	925,	1100,	120,	150);

        beORailroad= factory.criaFerrovia(lugares,25, "beORailroad", 200, 100);

        atlanticAvenue= factory.criaPropriedade(lugares,26, "atlanticAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

        ventnorAvenue= factory.criaPropriedade(lugares,27, "ventnorAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

       //serviços públicos  waterWorks= factory.cria

        marvinGardens= factory.criaPropriedade(lugares,29, "marvinGardens",  "Amarelo",	  280,	500,	120,	360,	850,	1025,	1200,	140,	150);

       // gotoJail= factory.criaPropriedade(lugares,30, "gotoJail", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pacificAvenue= factory.criaPropriedade(lugares,31, "pacificAvenue", "Verde",	300,	500,	130,	390,	900,	1100,	1275,	150,	200);

        northCarolinaAvenue= factory.criaPropriedade(lugares,32, "northCarolinaAvenue", "Verde",	260,	500,	110,	330,	800,	975,	1150,	130,	150);

       // communityChest3= factory.criaPropriedade(lugares,33, "communityChest3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaAvenue= factory.criaPropriedade(lugares,34, "pennsylvaniaAvenue", "Verde",	320,	500,	150,	450,	1000,	1200,	1400,	160,	200);

        shortLineRailroad= factory.criaFerrovia(lugares,35, "shortLineRailroad", 200, 100);

       // chance3= factory.criaPropriedade(lugares,36, "chance3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        parkPlace= factory.criaPropriedade(lugares,37, "parkPlace", " Azul",	350,	500,	175,	500,	1100,	1300,	1500,	175,	200);

        luxuryTax= factory.criaImpostoRiqueza(lugares,38, "luxuryTax", 75);

        boardwalk= factory.criaPropriedade(lugares,39, "boardwalk", "Azul",	400,	500,	200,	600,	1400,	1700,	2000,	200,	200);

         go= factory.criaPropriedade(lugares,0, "go", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);
    }



    
    public void  criaCartasCofresComunitarios(){

            avanceParaOPontoDePartidaGo = factory.criaCartasCofresComunitarios(baralho, 1 , "AvanceParaOPontoDePartidaGo", "Receba $200", "Isso não é um bônus, ou seja, os $200 referem-se ao valor que o jogador recebe normalmente ao passar pelo Ponto de Partida.");

            erroDoBancoEmSeuFavor = factory.criaCartasCofresComunitarios(baralho, 2 , "ErroDoBancoEmSeuFavor", "Receba $200", "");

            taxaDoMedico = factory.criaCartasCofresComunitarios(baralho, 3 , "TaxaDoMedico", "Pague $50", "Isso não é um bônus, ou seja, os $200 referem-se ao valor que o jogador recebe normalmente ao passar pelo Ponto de Partida.");

            aberturaDaGrandeOpera = factory.criaCartasCofresComunitarios(baralho, 4 , "AberturaDaGrandeOpera", "Receba $50 de cada jogador pelas entradas", "");

            daLiquidacaoForaDeEstoque = factory.criaCartasCofresComunitarios(baralho, 5 , "DaLiquidacaoForaDeEstoque", "Receba $45", "");

            saiaLivreDaPrisaoSemPagar = factory.criaCartasCofresComunitarios(baralho, 6 , "SaiaLivreDaPrisaoSemPagar", "Esta carta pode ser mantida até o uso ou venda.", "Veja a user story sobre a prisão");

            vaParaAPrisao = factory.criaCartasCofresComunitarios(baralho, 7 , "VaParaAPrisao", "Vá direto para a prisão – Não passe pelo ponto de partida – Não receba $200", "");

            restituicaoDoImpostoDeRenda = factory.criaCartasCofresComunitarios(baralho, 8 , "RestituicaoDoImpostoDeRenda", "Receba $20", "");

            aniversarioDoSeguroDeVida = factory.criaCartasCofresComunitarios(baralho, 9 , "AniversarioDoSeguroDeVida", "Receba $100", "");

            pagueOHospital = factory.criaCartasCofresComunitarios(baralho, 10 , "PagueOHospital", "Pague $100", "");

            pagueTaxaDaEscola = factory.criaCartasCofresComunitarios(baralho, 11 , "PagueTaxaDaEscola", "Pague $150", "");

            recebaPorSeusServicos = factory.criaCartasCofresComunitarios(baralho, 12 , "RecebaPorSeusServicos", "Receba $25", "");

            aniversarioDosFundosDeNatal = factory.criaCartasCofresComunitarios(baralho, 13 , "AniversarioDosFundosDeNatal", "Receba $100", "");

            voceTirouOSegundoLugarNoConcursoDeBeleza = factory.criaCartasCofresComunitarios(baralho, 14 , "VoceTirouOSegundoLugarNoConcursoDeBeleza", "Receba $10", "");

            voceHerdou = factory.criaCartasCofresComunitarios(baralho, 15 , "VoceHerdou", "Receba $100", "");

            voceDevePagarOsReparosDaRua = factory.criaCartasCofresComunitarios(baralho, 16 , "VoceDevePagarOsReparosDaRua", "Pague $40 por cada casa, $115 por hotel", "Isso se aplica apenas às casas e hotéis que o jogador possui; ele não precisa pagar pelas casas e hotéis dos outros jogadores.");

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
     * pega uma lista de jogadores e os retorna
     * @return List<Jogador>
     */
    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public GerenteJogo getGerente() {
        return gerente;
    }

    public void setGerente(GerenteJogo gerente) {
        this.gerente = gerente;
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;
    }

    public Peao getPeao() {
        return peao;
    }

    public void setPeao(Peao peao) {
        this.peao = peao;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

}
