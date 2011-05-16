/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.util.ArrayList;
import player.concretos.Peao;
import java.util.List;
import tabuleiro.tabuleiroConcreto.LugarFisico;

/**
 *
 * @author Adm
 */

 /**
     *@class A classe dJogador é uma classe abstrata que serve de interface para um jocgador concreto. Na mesma contem as assinaturas dos metodos abstratos:
  * jogaDado(), comprar() e Compra em Leilao.
     */
public abstract class Jogador {

    private String nomeJogador;
    private float dinheiro;
    private Peao peao;
    private List<LugarFisico> listaLugarFisico;

    public Jogador(){
        listaLugarFisico = new ArrayList<LugarFisico>();
        peao = new Peao();
    }

    public Jogador(Peao peao, String nome) {
        this.peao = peao;
        this.nomeJogador = nome;
        listaLugarFisico = new ArrayList<LugarFisico>();

    }
// Assinatura do metodo abstrato jogaDado que recebe uma instancia de dado com parametro.
    public abstract Integer[] jogaDado(Dado dado);

        
// Assinatura do metodo abstrato compra que serve para verificar se um jogador quer comprar um lugar fisico
    public abstract boolean comprar(LugarFisico lugarFisico);
// Assinatura do metodo compra que serve para jogador  comprar num leilao
    public abstract float compraEmLeilao(LugarFisico lugarFisico, float valorAtual);
//  metodo que pega uma lista de lugares fisicos
    public List<LugarFisico> getListaLugarFisico() {
        return listaLugarFisico;
    }

    public void setListaLugarFisico(List<LugarFisico> listaLugarFisico) {
        this.listaLugarFisico = listaLugarFisico;
    }

    public Peao getPeao() {
        return peao;
    }

    public void setPeao(Peao peao) {
        this.peao = peao;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    
}
