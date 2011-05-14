/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;
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
  //private Status status;
    private Tabuleiro tabuleiro;
    private int numJogadores;
    private List<Lugar> lugares = new ArrayList<Lugar>(40);

    
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
        gerente = factory.criaGerente();
        criarLugares();
    }

    public void criarLugares(){
        

        mediterraneanAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

       // communityChest1 = factory.criaImpostoRenda(numJogadores, null, numJogadores);

        balticAvenue= factory.criaPropriedade(3, "balticAvenue", "roxo", 60 , 4 , 20 , 60 , 80 ,160 , 450 , 30 , 50);

        incomeTax = factory.criaImpostoRenda(4, "incomeTax", 200);

        readingRailroad = factory.criaFerrovia(5, "readingRailroad", 200, 100);

        orientalAvenue = factory.criaPropriedade(6, "orientalAvenue", "AzulClaro" , 100, 6, 30, 90, 270, 400, 550,50, 50);

        //chance = factory.criaChance(7, "chance", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        vermontAvenue = factory.criaPropriedade(8, "vermontAvenue", "AzulClaro",  100 ,  6,	30  ,  90 , 270 ,  400 ,  550,	  50,  50);

        connecticutAvenue= factory.criaPropriedade(9, "connecticutAvenue", "AzulClaro",	120,	8,	40,	100,	300,	450,	600,	60,	50);

       // jailJustVisiting= factory.cria

        stCharlesPlace= factory.criaPropriedade(11, "stCharlesPlace", "Cinza",	140,	10,	50,	150,	450,	625,	750,	70,	100);

       // electricCompany= factory.criaPropriedade(12, "electricCompany", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        statesAvenue= factory.criaPropriedade(13, "statesAvenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        virginiaAvenue= factory.criaPropriedade(14, "virginiaAvenue", " ",160,	12,	60,	180,	500,	700,	900,	80,	100);

   // esse usa cor     pennsylvaniaRailroad= factory.criaFerrovia(15, "pennsylvaniaRailroad", 200, 100);

        stJamesPlace= factory.criaPropriedade(16, "stJamesPlace", "Laranja",	180,	14,	70,	200,	550,	750,	950,	90,	100);

        //communityChest2= factory.criaChance();

        tennesseeAvenue= factory.criaPropriedade(18, "tennesseeAvenue", "Laranja",	180,	14,	70,	200,	550,	750,	950,	90,	100);

        newYorkAvenue= factory.criaPropriedade(19, "newYorkAvenue", "Laranja",	200,	16,	80,	220,	600,	800,	1000,	100,	100);

       // freeParking= factory.cria

        kentuckyAvenue= factory.criaPropriedade(21, "kentuckyAvenue", "Vermelho",	220,	18,	90,	250,	700,	875,	1050,	110,	150);

       // chance2= factory.criaChance()

        indianaAvenue= factory.criaPropriedade(23, "indianaAvenue", "Vermelho",	220,	18,	90,	250,	700,	875,	1050,	110,	150);

        illinoisAvenue= factory.criaPropriedade(24, "illinoisAvenue", "Vermelho",	240,	20,	100,	300,	750,	925,	1100,	120,	150);

        beORailroad= factory.criaFerrovia(25, "beORailroad", 200, 100);

        atlanticAvenue= factory.criaPropriedade(26, "atlanticAvenue", "Amarelo",	260,	22,	110,	330,	800,	975,	1150,	130,		150);

        ventnorAvenue= factory.criaPropriedade(27, "ventnorAvenue", "Amarelo",	260,	22,	110,	330,	800,	975,	1150,	130,		150);

       // waterWorks= factory.cria

        marvinGardens= factory.criaPropriedade(29, "marvinGardens",  "Amarelo",	  280,	24,	120,	360,	850,	1025,	1200,	140,	150);

       // gotoJail= factory.criaPropriedade(30, "gotoJail", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pacificAvenue= factory.criaPropriedade(31, "pacificAvenue", "Verde",	300,	26,	130,	390,	900,	1100,	1275,	150,	200);

        northCarolinaAvenue= factory.criaPropriedade(32, "northCarolinaAvenue", "Verde",	260,	22,	110,	330,	800,	975,	1150,	130,	150);

       // communityChest3= factory.criaPropriedade(33, "communityChest3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaAvenue= factory.criaPropriedade(34, "pennsylvaniaAvenue", "Verde",	320,	28,	150,	450,	1000,	1200,	1400,	160,	200);

        shortLineRailroad= factory.criaFerrovia(35, "shortLineRailroad", 200, 100);

       // chance3= factory.criaPropriedade(36, "chance3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        parkPlace= factory.criaPropriedade(37, "parkPlace", " Azul",	350,	35,	175,	500,	1100,	1300,	1500,	175,	200);

        luxuryTax= factory.criaImpostoRiqueza(38, "luxuryTax", 75);

        boardwalk= factory.criaPropriedade(39, "boardwalk", "Azul",	400,	50,	200,	600,	1400,	1700,	2000,	200,	200);

        // go= factory.criaPropriedade(40, "go", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);
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
