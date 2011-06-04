/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import  java.util.ArrayList;
import  java.util.List;
import  java.util.Random;
import  java.util.Stack;

/**
 *
 * @author Adm
 *
 */
public abstract class Baralho {

    private List<Carta> listaCarta;
    private Stack<Carta> pilhaJogo;
    private Stack<Carta> pilhaDescarte;

    /**
     *
     */
    public Baralho() {
        pilhaDescarte = new Stack<Carta>();
        pilhaJogo = new Stack<Carta>();
        listaCarta = new ArrayList<Carta>();
    }

    
    /**
     *
     * @param listaCarta
     */
    public Baralho(List<Carta> listaCarta) {
        this.pilhaDescarte = new Stack<Carta>();
        this.pilhaJogo = new Stack<Carta>();
        this.listaCarta = listaCarta;
        tracarBaralho();
    }

    /**
     *
     * @param carta
     */
    public void addCarta(Carta carta) {

        listaCarta.add(carta);
    }

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public Carta retiraCartaPilha(){
        if (pilhaJogo.empty()){
            restauraBaralho();
        }
        Carta c = pilhaJogo.pop();
        addPilhaDescarte(c);
        return c;
    }

    public void restauraBaralho(){
        while(!pilhaDescarte.empty()){
            pilhaJogo.push(pilhaDescarte.pop());
        }
    }

    /**
     *
     * @param carta
     */
    public void addPilhaJogo(Carta carta) {

        pilhaJogo.push(carta);

    }

    /**
     *
     * @param carta
     */
    public void addPilhaDescarte(Carta carta) {

        pilhaDescarte.push(carta);

    }

    /**
     *
     * @return
     */
    public List<Carta> getListaCarta() {
        return listaCarta;
    }

    /**
     *
     * @param listaCarta
     */
    public void setListaCarta(List<Carta> listaCarta) {
        this.listaCarta = listaCarta;
    }

    /**
     *
     * @return
     */
    public Stack<Carta> getPilhaDescarte() {
        return pilhaDescarte;
    }

    /**
     *
     * @param pilhaDescarte
     */
    public void setPilhaDescarte(Stack<Carta> pilhaDescarte) {
        this.pilhaDescarte = pilhaDescarte;
    }

    /**
     *
     * @return
     */
    public Stack<Carta> getPilhaJogo() {
        return pilhaJogo;
    }

    /**
     *
     * @param pilhaJogo
     */
    public void setPilhaJogo(Stack<Carta> pilhaJogo) {
        this.pilhaJogo = pilhaJogo;
    }

}
