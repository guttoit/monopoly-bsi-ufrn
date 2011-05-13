/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabuleiro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adm
 */
public abstract class Tabuleiro {

    private int numCasas;
    private List<Lugar> listaLugar;

    public Tabuleiro() {
    }

    public Tabuleiro(int numCasas) {
        this.numCasas = numCasas;
    }

    public void addLugar(Lugar l){
        listaLugar.add(l.getPosicao(), l);
    }

    public List<Lugar> getListaLugar() {
        return listaLugar;
    }

    public void setListaLugar(List<Lugar> listaLugar) {
        this.listaLugar = listaLugar;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }
}
