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
import tabuleiro.Propriedade;
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
    
    private Propriedade mediterraneanAvenue;

    private Propriedade communityChest1;

    private Propriedade balticAvenue;

    private Propriedade incomeTax;

    private Propriedade readingRailroad;

    private Propriedade orientalAvenue;

    private Propriedade chance;

    private Propriedade vermontAvenue;

    private Propriedade connecticutAvenue;

    private Propriedade jailJustVisiting;

    private Propriedade stCharlesPlace;

    private Propriedade electricCompany;

    private Propriedade statesAvenue;

    private Propriedade virginiaAvenue;

    private Propriedade pennsylvaniaRailroad;

    private Propriedade stJamesPlace;

    private Propriedade communityChest2;

    private Propriedade tennesseeAvenue;

    private Propriedade newYorkAvenue;

    private Propriedade freeParking;

    private Propriedade kentuckyAvenue;

    private Propriedade chance2;

    private Propriedade indianaAvenue;

    private Propriedade illinoisAvenue;

    private Propriedade beORailroad;

    private Propriedade atlanticAvenue;

    private Propriedade ventnorAvenue;

    private Propriedade waterWorks;

    private Propriedade marvinGardens;

    private Propriedade gotoJail;

    private Propriedade pacificAvenue;

    private Propriedade northCarolinaAvenue;

    private Propriedade communityChest3;

    private Propriedade pennsylvaniaAvenue;

    private Propriedade shortLineRailroad;

    private Propriedade chance3;

    private Propriedade parkPlace;

    private Propriedade luxuryTax;

    private Propriedade boardwalk;

    private Propriedade go;




    


    public Jogo(FactoryCriador factory) {
        this.factory = factory;
        gerente = factory.criaGerente();
        criarLugares();
    }

    public void criarLugares(){
        mediterraneanAvenue = factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        mediterraneanAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        communityChest1= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        balticAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        incomeTax = factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        readingRailroad = factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        orientalAvenue = factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        chance = factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        vermontAvenue = factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        connecticutAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        jailJustVisiting= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        stCharlesPlace= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        electricCompany= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        statesAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        virginiaAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaRailroad= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        stJamesPlace= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        communityChest2= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        tennesseeAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        newYorkAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        freeParking= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        kentuckyAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        chance2= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        indianaAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        illinoisAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        beORailroad= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        atlanticAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        ventnorAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        waterWorks= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        marvinGardens= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        gotoJail= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pacificAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        northCarolinaAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        communityChest3= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        pennsylvaniaAvenue= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        shortLineRailroad= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        chance3= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        parkPlace= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        luxuryTax= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        boardwalk= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);

        go= factory.criaPropriedade(1, "Mediterranean Avenue", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 90);
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
