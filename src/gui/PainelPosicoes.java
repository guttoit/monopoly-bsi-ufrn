/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author gutto
 */
public class PainelPosicoes extends JPanel {


    private List listaPeoes;

    public PainelPosicoes(){
        inicializaComponentes();

    }

    public PainelPosicoes(int x, int y){
        inicializaComponentes();
        
        setLayout(new GridLayout(x, y));
    }


    public void inicializaComponentes(){
        
        listaPeoes = new ArrayList();

    }

    public void addPeao(Component peao){
        listaPeoes.add(peao);
        this.add(peao);
    }

    public void mudaPosicao(int x, int y){
        setLocation(x, y);
    }

}
