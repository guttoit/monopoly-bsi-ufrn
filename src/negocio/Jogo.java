/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import player.Dado;
import player.Jogador;
import player.concretos.Peao;
import tabuleiro.Lugar;
import tabuleiro.Lugar;
import tabuleiro.Tabuleiro;

/**
 *
 * @author Adm
 */
public class Jogo {

    private FactoryCriador factory;
    private List<Jogador> jogadores;
    private GerenteJogo gerente;
    private Vendendor vendedor;
    private Dado dado;
    private Peao peao;
    private Mensagens mensagens;
  //private Status status;
    private Tabuleiro tabuleiro;
    private int numJogadores;
    private List<Lugar> lugares;
    private Scanner teclado;
    private Banco banco;

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




    
    public Jogo(FactoryCriador factory) {
        this.factory = factory;
        inicializaVariaveis();
        criarLugares();
    }

    public void iniciaJogo(){
        gerente.gerenciaJogo(tabuleiro, teclado, banco, jogadores, mensagens);
    }

    public void inicializaVariaveis(){
        gerente = factory.criaGerente(factory);
        tabuleiro = factory.criaTabuleiro(40);
        jogadores = factory.criaListaJogadores(8);
        mensagens = factory.criaMensagens();
        teclado = new Scanner(System.in);
        lugares = factory.criaLugares(40);
        banco = factory.criaBanco();
    }
    public void criarLugares(){
        
        posicaoZero = factory.criaLugar(tabuleiro, 0, " INICIO ");

        mediterraneanAvenue= factory.criaPropriedade(tabuleiro, 1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

       // communityChest1 = factory.criaImpostoRenda(tabuleiro, numJogadores, null, numJogadores);

        balticAvenue= factory.criaPropriedade(tabuleiro,3, "Baltic Avenue", "roxo", 60 , 4 , 20 , 60 , 80 ,160 , 450 , 30 , 50);

        incomeTax = factory.criaImpostoRenda(tabuleiro,4, "Income Tax", 200);

        readingRailroad = factory.criaFerrovia(tabuleiro,5, "Reading Railroad", 200, 100);

        orientalAvenue = factory.criaPropriedade(tabuleiro,6, "Oriental Avenue", "AzulClaro" , 100, 6, 30, 90, 270, 400, 550,50, 50);

        //chance = factory.criaChance(tabuleiro,7, "chance", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        vermontAvenue = factory.criaPropriedade(tabuleiro,8, "Vermont Avenue", "AzulClaro",  100 ,  6,	30  ,  90 , 270 ,  400 ,  550,	  50,  50);

        connecticutAvenue= factory.criaPropriedade(tabuleiro,9, "Connecticut Avenue", "AzulClaro",	120,	8,	40,	100,	300,	450,	600,	60,	50);

       // jailJustVisiting= factory.cria

        stCharlesPlace= factory.criaPropriedade(tabuleiro,11, "St Charles Place", "Cinza",	140,	10,	50,	150,	450,	625,	750,	70,	100);

  //serviços públicos  electricCompany= factory.criaPropriedade(tabuleiro,12, "electricCompany", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        statesAvenue= factory.criaPropriedade(tabuleiro,13, "States Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        virginiaAvenue= factory.criaPropriedade(tabuleiro,14, "Virginia Avenue", " ",160,	12,	60,	180,	500,	700,	900,	80,	100);

   // esse usa cor     pennsylvaniaRailroad= factory.criaFerrovia(tabuleiro,15, "pennsylvaniaRailroad", 200, 100);

        stJamesPlace= factory.criaPropriedade(tabuleiro,16, "St James Place", "Laranja",	180,	14,	70,	200,	550,	750,	950,	90,	100);

        //communityChest2= factory.criaChance();

        tennesseeAvenue= factory.criaPropriedade(tabuleiro,18, "Tennessee Avenue", "Laranja",	180,	14,	70,	200,	550,	750,	950,	90,	100);

        newYorkAvenue= factory.criaPropriedade(tabuleiro,19, "New York Avenue", "Laranja",	200,	16,	80,	220,	600,	800,	1000,	100,	100);

       // freeParking= factory.cria

        kentuckyAvenue= factory.criaPropriedade(tabuleiro,21, "Kentucky Avenue", "Vermelho",	220,	18,	90,	250,	700,	875,	1050,	110,	150);

       // chance2= factory.criaChance()

        indianaAvenue= factory.criaPropriedade(tabuleiro,23, "Indiana Avenue", "Vermelho",	220,	18,	90,	250,	700,	875,	1050,	110,	150);

        illinoisAvenue= factory.criaPropriedade(tabuleiro,24, "Illinois Avenue", "Vermelho",	240,	20,	100,	300,	750,	925,	1100,	120,	150);

        beORailroad= factory.criaFerrovia(tabuleiro,25, "Be O Railroad", 200, 100);

        atlanticAvenue= factory.criaPropriedade(tabuleiro,26, "Atlantic Avenue", "Amarelo",	260,	22,	110,	330,	800,	975,	1150,	130,		150);

        ventnorAvenue= factory.criaPropriedade(tabuleiro,27, "Ventnor Avenue", "Amarelo",	260,	22,	110,	330,	800,	975,	1150,	130,		150);

       //serviços públicos  waterWorks= factory.cria

        marvinGardens= factory.criaPropriedade(tabuleiro,29, "Marvin Gardens",  "Amarelo",	  280,	24,	120,	360,	850,	1025,	1200,	140,	150);

       // gotoJail= factory.criaPropriedade(tabuleiro,30, "gotoJail", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pacificAvenue= factory.criaPropriedade(tabuleiro,31, "Pacific Avenue", "Verde",	300,	26,	130,	390,	900,	1100,	1275,	150,	200);

        northCarolinaAvenue= factory.criaPropriedade(tabuleiro,32, "North Carolina Avenue", "Verde",	260,	22,	110,	330,	800,	975,	1150,	130,	150);

       // communityChest3= factory.criaPropriedade(tabuleiro,33, "communityChest3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaAvenue= factory.criaPropriedade(tabuleiro,34, "Pennsylvania Avenue", "Verde",	320,	28,	150,	450,	1000,	1200,	1400,	160,	200);

        shortLineRailroad= factory.criaFerrovia(tabuleiro,35, "ShortLine Railroad", 200, 100);

       // chance3= factory.criaPropriedade(tabuleiro,36, "chance3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        parkPlace= factory.criaPropriedade(tabuleiro,37, "Park Place", " Azul",	350,	35,	175,	500,	1100,	1300,	1500,	175,	200);

        luxuryTax= factory.criaImpostoRiqueza(tabuleiro,38, "Luxury Tax", 75);

        boardwalk= factory.criaPropriedade(tabuleiro,39, "Boardwalk", "Azul",	400,	50,	200,	600,	1400,	1700,	2000,	200,	200);

        // go= factory.criaPropriedade(tabuleiro,40, "go", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);
    }

    public void montaTabuleiro(Tabuleiro t, List<Lugar> lugares) {
        if (t.getNumCasas() != lugares.size()) {
        } else {
            for (Lugar l : lugares) {
                t.addLugar(l);
            }
        }
    }

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

    public Vendendor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendendor vendedor) {
        this.vendedor = vendedor;
    }
}
