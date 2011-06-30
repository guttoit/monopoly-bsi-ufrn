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

    public LugarTabuleiroGUI(Lugar lugarTabuleiro, Point posicao) {
        this.lugarTabuleiro = lugarTabuleiro;
        this.posicao = posicao;
    }



    public Lugar getLugarTabuleiro() {
        return lugarTabuleiro;
    }

    public void setLugarTabuleiro(Lugar lugarTabuleiro) {
        this.lugarTabuleiro = lugarTabuleiro;
    }

    public Point getPosicao() {
        return posicao;
    }




}
