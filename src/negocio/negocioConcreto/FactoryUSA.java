/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.negocioConcreto;

import java.util.ArrayList;
import java.util.List;
import negocio.Banco;
import negocio.FactoryCriador;
import negocio.GerenteJogo;
import negocio.Mensagens;
import player.Dado;
import player.Jogador;
import player.concretos.DadoDuplo;
import player.concretos.JogadorConcreto;
import player.concretos.Peao;
import tabuleiro.Carta;
import tabuleiro.Chance;
import tabuleiro.tabuleiroConcreto.Ferrovia;
import tabuleiro.tabuleiroConcreto.ImpostoRenda;
import tabuleiro.tabuleiroConcreto.ImpostoRiqueza;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.Propriedade;
import tabuleiro.Tabuleiro;
import tabuleiro.tabuleiroConcreto.TabuleiroUSA;

/**
 *
 * @author Gutto
 */
public class FactoryUSA implements FactoryCriador {

    public Jogador criaJogador() {
        return new JogadorConcreto();
    }

    public Dado criaDado() {
        return new DadoDuplo();
    }

    public Peao criaPeao(String cor) {
        return new Peao(cor);
    }

    public Lugar criaLugar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Propriedade criaPropriedade(Tabuleiro tab,int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa) {
        Propriedade p = new Propriedade(posicao, nome, cor, precoP, aluguelSCasa, c1, c2, c3, c4, hotel, hip, precoCasa);
        tab.addLugar(p);
        return p;
    }

    public GerenteJogo criaGerente(FactoryCriador f) {
        return new GerenteConcreto(f);
    }

    public Ferrovia criaFerrovia(Tabuleiro tab,int posicao, String nome, float preco, float hipoteca) {
        Ferrovia f = new Ferrovia(posicao, nome, preco, hipoteca);
        return f;
    }

    public ImpostoRenda criaImpostoRenda(Tabuleiro tab,int posicao, String nome, float preco) {
        ImpostoRenda ir = new ImpostoRenda(posicao, nome, preco);
        return ir;
    }

    public ImpostoRiqueza criaImpostoRiqueza(Tabuleiro tab,int posicao, String nome, float preco) {
        ImpostoRiqueza iRiqueza = new ImpostoRiqueza(posicao, nome, preco);
        return iRiqueza;
    }

    public Tabuleiro criaTabuleiro(int numCasas) {
        return new TabuleiroUSA(numCasas);
    }
    public Chance criaChance(){
               return null;
    }
    public Carta pegaCarta(int numeroCarta, String nomeCarta, String descricao, String observacoes){
         return new Carta(numeroCarta , nomeCarta, descricao, observacoes );
    }

    public Carta pagaCarta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Jogador> criaListaJogadores(int numJogadores) {
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>(numJogadores);
        for(int i = 0; i<numJogadores;i++){
            jogadores.add(new JogadorConcreto());
        }
        return jogadores;
    }

    public Mensagens criaMensagens() {
        return new MensagensJogo();
    }

    public List<Lugar> criaLugares(int numLugares) {
        return new ArrayList<Lugar>(numLugares);
    }

    public Banco criaBanco() {
        return new BancoConcreto();
    }


}
