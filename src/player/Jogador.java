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
    private boolean estaNaPrisao;
    private boolean temCartaSorteRevesSairPrisao;
    private boolean temCartaCofreComuSairPrisao;
    /**
     *
     */
    public Jogador(){
        listaLugarFisico = new ArrayList<LugarFisico>();
        peao = new Peao();
        estaNaPrisao = false;
        temCartaCofreComuSairPrisao = false;
        temCartaSorteRevesSairPrisao = false;
    }

    /**
     *
     * @param peao
     * @param nome
     */
    public Jogador(Peao peao, String nome) {
        this.peao = peao;
        this.nomeJogador = nome;
        listaLugarFisico = new ArrayList<LugarFisico>();
        estaNaPrisao = false;
        temCartaCofreComuSairPrisao = false;
        temCartaSorteRevesSairPrisao = false;

    }
// Assinatura do metodo abstrato jogaDado que recebe uma instancia de dado com parametro.
    /**
     *
     * @param dado
     * @return
     */
    public abstract Integer[] jogaDado(Dado dado);


     /**
     *  metodo que pega uma lista de lugares fisicos
     * @return List<LugarFisico>
     */
    public List<LugarFisico> getListaLugarFisico() {
        return listaLugarFisico;
    }

    /**
     *
     * @param listaLugarFisico
     */
    public void setListaLugarFisico(List<LugarFisico> listaLugarFisico) {
        this.listaLugarFisico = listaLugarFisico;
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
    public float getDinheiro() {
        return dinheiro;
    }

    /**
     *
     * @param dinheiro
     */
    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    /**
     *
     * @return
     */
    public String getNomeJogador() {
        return nomeJogador;
    }

    /**
     *
     * @param nomeJogador
     */
    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    /**
     *
     * @param l
     * @return
     */
    public boolean comprar(LugarFisico l) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     *
     * @return
     */
    public boolean isEstaNaPrisao() {
        return estaNaPrisao;
    }

    /**
     *
     * @param estaNaPrisao
     */
    public void setEstaNaPrisao(boolean estaNaPrisao) {
        this.estaNaPrisao = estaNaPrisao;
    }

    /**
     *
     * @return
     */
    public boolean isTemCartaCofreComuSairPrisao() {
        return temCartaCofreComuSairPrisao;
    }

    /**
     *
     * @param temCartaCofreComuSairPrisao
     */
    public void setTemCartaCofreComuSairPrisao(boolean temCartaCofreComuSairPrisao) {
        this.temCartaCofreComuSairPrisao = temCartaCofreComuSairPrisao;
    }

    /**
     *
     * @return
     */
    public boolean isTemCartaSorteRevesSairPrisao() {
        return temCartaSorteRevesSairPrisao;
    }

    /**
     *
     * @param temCartaSorteRevesSairPrisao
     */
    public void setTemCartaSorteRevesSairPrisao(boolean temCartaSorteRevesSairPrisao) {
        this.temCartaSorteRevesSairPrisao = temCartaSorteRevesSairPrisao;
    }


    
}
