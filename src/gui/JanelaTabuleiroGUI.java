/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javax.swing.JFrame;

/**
 *
 * @author gutto
 */
public class JanelaTabuleiroGUI extends JFrame{

    private TabuleiroGUI tabuleiro;

    public JanelaTabuleiroGUI(TabuleiroGUI tabuleiro){
        this.tabuleiro=tabuleiro;
        setSize(800, 600);
        posicionaComponentes();
        setVisible(true);

    }

    public void posicionaComponentes(){
        getContentPane().add(tabuleiro);
    }

}
