/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Point;
import tabuleiro.Lugar;

/**
 *
 * @author gutto
 */
public class LugarTabuleiroGUI {

    private Lugar lugarTabuleiro;
    private final Point posicao;

    /**
     *
     * @param lugarTabuleiro
     * @param posicao
     */
    public LugarTabuleiroGUI(Lugar lugarTabuleiro, Point posicao) {
        this.lugarTabuleiro = lugarTabuleiro;
        this.posicao = posicao;
    }



    /**
     *
     * @return
     */
    public Lugar getLugarTabuleiro() {
        return lugarTabuleiro;
    }

    /**
     *
     * @param lugarTabuleiro
     */
    public void setLugarTabuleiro(Lugar lugarTabuleiro) {
        this.lugarTabuleiro = lugarTabuleiro;
    }

    /**
     *
     * @return
     */
    public Point getPosicao() {
        return posicao;
    }



}
