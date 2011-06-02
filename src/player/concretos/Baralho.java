/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player.concretos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import tabuleiro.Carta;

/**
 *
 * @author Adm
 *
 */
public abstract class Baralho {

    private List<Carta> listaCarta;
    private Stack<Carta> pilhaJogo;
    private Stack<Carta> pilhaDescarte;

    public Baralho(List<Carta> listaCarta) {
        pilhaDescarte = new Stack<Carta>();
        pilhaJogo = new Stack<Carta>();
        this.listaCarta = listaCarta;
        tracarBaralho();
    }

    public List<Carta> getListaCarta() {
        return listaCarta;
    }

    public void setListaCarta(List<Carta> listaCarta) {
        this.listaCarta = listaCarta;
    }

    public void addCarta(Carta carta) {

        listaCarta.add(carta);
    }

    public void tracarBaralho(){
        Carta carta;
        Random random = new Random();
        int numCartaEscolhida;

        for (int i = 0; i < listaCarta.size(); i++) {
            numCartaEscolhida = random.nextInt(listaCarta.size());
            carta = listaCarta.get(numCartaEscolhida);
            addPilhaJogo(carta);
            listaCarta.remove(numCartaEscolhida);
        }


    }

    public Carta retiraCartaPilha(){
        Carta c = pilhaJogo.pop();
        addPilhaDescarte(c);
        return c;
    }

    public void addPilhaJogo(Carta carta) {

        pilhaJogo.push(carta);

    }

    public void addPilhaDescarte(Carta carta) {

        pilhaDescarte.push(carta);

    }

    private void iniciaListaCartaSorteReves(int numCartasSorteReves) {
        for (int i = 0; i < listaCarta.size(); i++) {

            listaCarta.add(null);

        }
    }
}
