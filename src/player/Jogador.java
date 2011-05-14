/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.util.ArrayList;
import player.concretos.Peao;
import java.util.List;
import tabuleiro.LugarFisico;

/**
 *
 * @author Adm
 */
public abstract class Jogador {

    private String nomeJogador;
    private float dinheiro;
    private Peao peao;
    private List<LugarFisico> listaLugarFisico;

    public Jogador(){
        listaLugarFisico = new ArrayList<LugarFisico>();
    }

    public Jogador(Peao peao, String nome) {
        this.peao = peao;
        this.nomeJogador = nome;
        listaLugarFisico = new ArrayList<LugarFisico>();

    }

    public abstract Integer[] jogaDado(Dado dado);

        

    public abstract boolean comprar(LugarFisico lugarFisico);

    public abstract float compraEmLeilao(LugarFisico lugarFisico, float valorAtual);

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
