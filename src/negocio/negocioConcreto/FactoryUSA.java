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
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.TabuleiroUSA;

/**
 *
 * @author Gutto
 */

/**
 *
 * @class FatoryUsa é uma classe concreta que implementa FactoryCriador e
 * tem a responsabilidade de criar objetos do jogo.
 */
public class FactoryUSA implements FactoryCriador {
// Cria um Jogador e retorna um JogadorConcreto
    public Jogador criaJogador() {
        return new JogadorConcreto();
    }
// Cria um  Dado e retorna um DadoDuplo
    public Dado criaDado() {
        return new DadoDuplo();
    }
// Cria um  Peao e retorna um Peao com sua respectiviva cor
    public Peao criaPeao(String cor) {
        return new Peao(cor);
    }
// Cria um  Lugar e retorna uma exceção.
    public Lugar criaLugar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
// Cria uma  Propriedade  com suas caracteristicas e adiciona no respestivo lugar no tabuleiro.
    public Propriedade criaPropriedade(List<Lugar> lugares, int posicao, String nome, String cor, float precoP, float aluguelSCasa, float c1, float c2, float c3, float c4, float hotel, float hip, float precoCasa) {
        Propriedade p = new Propriedade(posicao, nome, cor, precoP, aluguelSCasa, c1, c2, c3, c4, hotel, hip, precoCasa);
        lugares.add(p);
        return p;
    }
// Cria um gerente, sendo ele responsável pela criacao dos objetos dos jogo, invocando uma instancia de FatoryCriador
    public GerenteJogo criaGerente(FactoryCriador f) {
        return new GerenteConcreto(f);
    }
// Cria uma Ferrovia, adiciona suas caracteristicas e retorna uma isntancia de Ferrovia
    public Ferrovia criaFerrovia(List<Lugar> lugares, int posicao, String nome, float preco, float hipoteca) {
        Ferrovia f = new Ferrovia(posicao, nome, preco, hipoteca);
        lugares.add(f);
        return f;
    }
// Cria um imposto de Renda, adiciona suas caracteristicas e retorna uma instancia de Imposto de Renda
    public ImpostoRenda criaImpostoRenda(List<Lugar> lugares, int posicao, String nome, float preco) {
        ImpostoRenda ir = new ImpostoRenda(posicao, nome, preco);
        lugares.add(ir);
        return ir;
    }
// Cria um imposto Riqueza, adiciona suas caracteristicas e retorna uma instancia de Imposto riqueza
    public ImpostoRiqueza criaImpostoRiqueza(List<Lugar> lugares, int posicao, String nome, float preco) {
        ImpostoRiqueza iRiqueza = new ImpostoRiqueza(posicao, nome, preco);
        lugares.add(iRiqueza);
        return iRiqueza;
    }
// Cria um tabuleiro com sua quantidade de espaços
    public Tabuleiro criaTabuleiro(int numCasas) {
        return new TabuleiroUSA(numCasas);
    }
// Cria uma chace // Falta implementar
    public Chance criaChance() {
        return null;
    }
// Cria uma Carta // Falta implementar
    public Carta pegaCarta(int numeroCarta, String nomeCarta, String descricao, String observacoes) {
        return new Carta(numeroCarta, nomeCarta, descricao, observacoes);
    }
// Cria uma carta // Falta implementar
    public Carta pagaCarta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
// Cria uma Lista de Jogadores e adiciona os jogadores concrestos na mesma.
    public List<Jogador> criaListaJogadores(int numJogadores) {
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>(numJogadores);
        for (int i = 0; i < numJogadores; i++) {
            jogadores.add(new JogadorConcreto());
        }
        return jogadores;
    }
// Cria  mensagens e retorna MensagensJogo que seram exibidas no decorrer do jogo.
    public Mensagens criaMensagens() {
        return new MensagensJogo();
    }
// Cria uma Lista de Lugares e retorna Um ArrayList de Lugares com a quantidade de lugares.
    public List<Lugar> criaLugares(int numLugares) {
        return new ArrayList<Lugar>(numLugares);
    }
// Cria  cria um Banco e retorna um Banco concreto que serve para armazenar finanças do jogo.
    public Banco criaBanco() {
        return new BancoConcreto();
    }
// Cria Lugar e adiciona no Tabuleiro retornando uma instancia de um lugar fisico.
    public Lugar criaLugar(List<Lugar> lugares, int posicao, String nome) {
        LugarFisico l = new LugarFisico(nome, 0, posicao);
        lugares.add(l);
        return l;
    }
}
