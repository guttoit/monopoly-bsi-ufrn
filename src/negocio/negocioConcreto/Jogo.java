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
import negocio.Vendendor;
import player.Dado;
import player.Jogador;
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
        criaLugaresTeste();
    }

    public void iniciaJogo(){
        gerente.gerenciaJogo(tabuleiro, teclado, banco, jogadores, mensagens);
    }
// inicializa as variáveis através do fatory
    public void inicializaVariaveis(){
        gerente = factory.criaGerente(factory);
        tabuleiro = factory.criaTabuleiro(40);
        jogadores = factory.criaListaJogadores(8);
        mensagens = factory.criaMensagens();
        teclado = new Scanner(System.in);
        lugares = factory.criaLugares(40);
        banco = factory.criaBanco();
    }
// cria os lugares com seus atributos
    public void criaLugaresTeste(){
         mediterraneanAvenue= factory.criaPropriedade(tabuleiro, 1, "Mediterranean Avenue", "roxo", 60, 200, 10, 30, 90, 160, 250, 30, 90);

       // communityChest1 = factory.criaImpostoRenda(tabuleiro, numJogadores, null, numJogadores);

        balticAvenue= factory.criaPropriedade(tabuleiro,3, "balticAvenue", "roxo", 60 , 200 , 20 , 60 , 80 ,160 , 450 , 30 , 50);

        incomeTax = factory.criaImpostoRenda(tabuleiro,4, "Income Tax", 200);

        readingRailroad = factory.criaFerrovia(tabuleiro,5, "Reading Railroad", 200, 100);

        orientalAvenue = factory.criaPropriedade(tabuleiro,6, "orientalAvenue", "AzulClaro" , 100, 200, 30, 90, 270, 400, 550,50, 50);

        //chance = factory.criaChance(tabuleiro,7, "chance", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        vermontAvenue = factory.criaPropriedade(tabuleiro,8, "vermontAvenue", "AzulClaro",  100 ,  200,	30  ,  90 , 270 ,  400 ,  550,	  50,  50);

        connecticutAvenue= factory.criaPropriedade(tabuleiro,9, "connecticutAvenue", "AzulClaro",	120,	200,	40,	100,	300,	450,	600,	60,	50);

       // jailJustVisiting= factory.cria

        stCharlesPlace= factory.criaPropriedade(tabuleiro,11, "stCharlesPlace", "Cinza",	140,	500,	50,	150,	450,	625,	750,	70,	100);

  //serviços públicos  electricCompany= factory.criaPropriedade(tabuleiro,12, "electricCompany", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        statesAvenue= factory.criaPropriedade(tabuleiro,13, "statesAvenue", "roxo", 60, 500, 10, 30, 90, 160, 250, 30, 90);

        virginiaAvenue= factory.criaPropriedade(tabuleiro,14, "virginiaAvenue", " ",160, 500,	60,	180,	500,	700,	900,	80,	100);

   // esse usa cor     pennsylvaniaRailroad= factory.criaFerrovia(tabuleiro,15, "pennsylvaniaRailroad", 200, 100);

        stJamesPlace= factory.criaPropriedade(tabuleiro,16, "stJamesPlace", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        //communityChest2= factory.criaChance();

        tennesseeAvenue= factory.criaPropriedade(tabuleiro,18, "tennesseeAvenue", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        newYorkAvenue= factory.criaPropriedade(tabuleiro,19, "newYorkAvenue", "Laranja",	200,	500,	80,	220,	600,	800,	1000,	100,	100);

       // freeParking= factory.cria

        kentuckyAvenue= factory.criaPropriedade(tabuleiro,21, "kentuckyAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

       // chance2= factory.criaChance()

        indianaAvenue= factory.criaPropriedade(tabuleiro,23, "indianaAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

        illinoisAvenue= factory.criaPropriedade(tabuleiro,24, "illinoisAvenue", "Vermelho",	240,	500,	100,	300,	750,	925,	1100,	120,	150);

        beORailroad= factory.criaFerrovia(tabuleiro,25, "Be O Railroad", 200, 100);

        atlanticAvenue= factory.criaPropriedade(tabuleiro,26, "atlanticAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

        ventnorAvenue= factory.criaPropriedade(tabuleiro,27, "ventnorAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

       //serviços públicos  waterWorks= factory.cria

        marvinGardens= factory.criaPropriedade(tabuleiro,29, "marvinGardens",  "Amarelo",	  280,	500,	120,	360,	850,	1025,	1200,	140,	150);

       // gotoJail= factory.criaPropriedade(tabuleiro,30, "gotoJail", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pacificAvenue= factory.criaPropriedade(tabuleiro,31, "pacificAvenue", "Verde",	300,	26,	500,	390,	900,	1100,	1275,	150,	200);

        northCarolinaAvenue= factory.criaPropriedade(tabuleiro,32, "northCarolinaAvenue", "Verde",	260,	500,	110,	330,	800,	975,	1150,	130,	150);

       // communityChest3= factory.criaPropriedade(tabuleiro,33, "communityChest3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaAvenue= factory.criaPropriedade(tabuleiro,34, "pennsylvaniaAvenue", "Verde",	320,	500,	150,	450,	1000,	1200,	1400,	160,	200);

        shortLineRailroad= factory.criaFerrovia(tabuleiro,35, "ShortLine Railroad", 200, 100);

       // chance3= factory.criaPropriedade(tabuleiro,36, "chance3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        parkPlace= factory.criaPropriedade(tabuleiro,37, "parkPlace", " Azul",	350,	500,	175,	500,	1100,	1300,	1500,	175,	200);

        luxuryTax= factory.criaImpostoRiqueza(tabuleiro,38, "Luxury Tax", 75);

        boardwalk= factory.criaPropriedade(tabuleiro,39, "boardwalk", "Azul",	400,	500,	200,	600,	1400,	1700,	2000,	200,	200);

         go= factory.criaLugar(tabuleiro,0, "inicio");
    }
    public void criarLugares(){
        

        mediterraneanAvenue= factory.criaPropriedade(tabuleiro, 1, "Mediterranean Avenue", "roxo", 60, 500, 10, 30, 90, 160, 250, 30, 90);

       // communityChest1 = factory.criaImpostoRenda(tabuleiro, numJogadores, null, numJogadores);

        balticAvenue= factory.criaPropriedade(tabuleiro,3, "balticAvenue", "roxo", 60 , 500 , 20 , 60 , 80 ,160 , 450 , 30 , 50);

        incomeTax = factory.criaImpostoRenda(tabuleiro,4, "incomeTax", 200);

        readingRailroad = factory.criaFerrovia(tabuleiro,5, "readingRailroad", 200, 100);

        orientalAvenue = factory.criaPropriedade(tabuleiro,6, "orientalAvenue", "AzulClaro" , 100, 500, 30, 90, 270, 400, 550,50, 50);

        //chance = factory.criaChance(tabuleiro,7, "chance", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        vermontAvenue = factory.criaPropriedade(tabuleiro,8, "vermontAvenue", "AzulClaro",  100 ,  500,	30  ,  90 , 270 ,  400 ,  550,	  50,  50);

        connecticutAvenue= factory.criaPropriedade(tabuleiro,9, "connecticutAvenue", "AzulClaro", 120,	500,	40,	100,	300,	450,	600,	60,	50);

       // jailJustVisiting= factory.cria

        stCharlesPlace= factory.criaPropriedade(tabuleiro,11, "stCharlesPlace", "Cinza",	140,	500,	50,	150,	450,	625,	750,	70,	100);

  //serviços públicos  electricCompany= factory.criaPropriedade(tabuleiro,12, "electricCompany", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        statesAvenue= factory.criaPropriedade(tabuleiro,13, "statesAvenue", "roxo", 60, 500, 10, 30, 90, 160, 250, 30, 90);

        virginiaAvenue= factory.criaPropriedade(tabuleiro,14, "virginiaAvenue", " ",160,	500,	60,	180,	500,	700,	900,	80,	100);

   // esse usa cor     pennsylvaniaRailroad= factory.criaFerrovia(tabuleiro,15, "pennsylvaniaRailroad", 200, 100);

        stJamesPlace= factory.criaPropriedade(tabuleiro,16, "stJamesPlace", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        //communityChest2= factory.criaChance();

        tennesseeAvenue= factory.criaPropriedade(tabuleiro,18, "tennesseeAvenue", "Laranja",	180,	500,	70,	200,	550,	750,	950,	90,	100);

        newYorkAvenue= factory.criaPropriedade(tabuleiro,19, "newYorkAvenue", "Laranja",	200,	500,	80,	220,	600,	800,	1000,	100,	100);

       // freeParking= factory.cria

        kentuckyAvenue= factory.criaPropriedade(tabuleiro,21, "kentuckyAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

       // chance2= factory.criaChance()

        indianaAvenue= factory.criaPropriedade(tabuleiro,23, "indianaAvenue", "Vermelho",	220,	500,	90,	250,	700,	875,	1050,	110,	150);

        illinoisAvenue= factory.criaPropriedade(tabuleiro,24, "illinoisAvenue", "Vermelho",	240,	500,	100,	300,	750,	925,	1100,	120,	150);

        beORailroad= factory.criaFerrovia(tabuleiro,25, "beORailroad", 200, 100);

        atlanticAvenue= factory.criaPropriedade(tabuleiro,26, "atlanticAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

        ventnorAvenue= factory.criaPropriedade(tabuleiro,27, "ventnorAvenue", "Amarelo",	260,	500,	110,	330,	800,	975,	1150,	130,		150);

       //serviços públicos  waterWorks= factory.cria

        marvinGardens= factory.criaPropriedade(tabuleiro,29, "marvinGardens",  "Amarelo",	  280,	500,	120,	360,	850,	1025,	1200,	140,	150);

       // gotoJail= factory.criaPropriedade(tabuleiro,30, "gotoJail", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pacificAvenue= factory.criaPropriedade(tabuleiro,31, "pacificAvenue", "Verde",	300,	500,	130,	390,	900,	1100,	1275,	150,	200);

        northCarolinaAvenue= factory.criaPropriedade(tabuleiro,32, "northCarolinaAvenue", "Verde",	260,	500,	110,	330,	800,	975,	1150,	130,	150);

       // communityChest3= factory.criaPropriedade(tabuleiro,33, "communityChest3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaAvenue= factory.criaPropriedade(tabuleiro,34, "pennsylvaniaAvenue", "Verde",	320,	500,	150,	450,	1000,	1200,	1400,	160,	200);

        shortLineRailroad= factory.criaFerrovia(tabuleiro,35, "shortLineRailroad", 200, 100);

       // chance3= factory.criaPropriedade(tabuleiro,36, "chance3", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        parkPlace= factory.criaPropriedade(tabuleiro,37, "parkPlace", " Azul",	350,	500,	175,	500,	1100,	1300,	1500,	175,	200);

        luxuryTax= factory.criaImpostoRiqueza(tabuleiro,38, "luxuryTax", 75);

        boardwalk= factory.criaPropriedade(tabuleiro,39, "boardwalk", "Azul",	400,	500,	200,	600,	1400,	1700,	2000,	200,	200);

         go= factory.criaPropriedade(tabuleiro,0, "go", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);
    }
// monta o tabuleiro com seus respectivos lugares.
    public void montaTabuleiro(Tabuleiro t, List<Lugar> lugares) {
        if (t.getNumCasas() != lugares.size()) {
        } else {
            for (Lugar l : lugares) {
                t.addLugar(l);
            }
        }
    }
//pega uma lista de jogadores e os retorna
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
