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


/**
 *
 * @class A classe Taluleiro é uma classe abstrata que serve de interface pra qualquer tipo de tabuleiro
 *
 *
 */
public abstract class Tabuleiro {

    private int numCasas;
    private List<Lugar> listaLugar;


    public Tabuleiro(int numCasas) {
        this.numCasas = numCasas;
        listaLugar = new ArrayList<Lugar>();
        iniciaListaLugar(numCasas);
    }
     /**
      * Metodo que inicializa uma lista de lugares com null
     * @param num int
     */

    public void iniciaListaLugar(int num){
        for(int i=0; i<num; i++){

            listaLugar.add(null);

        }

    }
     /**
     * Método que  pega uma lista de lugares
     *@param l
     *
     *
     */

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
