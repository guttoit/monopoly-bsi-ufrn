/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author gutto
 */
public class JanelaTabuleiro3 extends JFrame{

    private Map posicoes;
    private GridBagConstraints constraints;

    public JanelaTabuleiro3(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(820, 630);
        //this.setResizable(true);
       
        this.setVisible(true);
        iniciaComponentes();
        posicionaComponentes();
        //this.pack();
    }

    public void iniciaComponentes(){
        setLayout(new GridBagLayout());
        posicoes = new HashMap();
        constraints = new GridBagConstraints();

        //Laço usado para criar os painéis de acordo com sua posição e tamanho
        for (int i = 1; i <= 40; i++) {
            if (i <= 11 || (i > 20 && i <= 30)) {
                if (i == 7 || i == 23) {
                    posicoes.put(i, new PosicoesTabuleiro(62, 74));
                } else {
                    posicoes.put(i, new PosicoesTabuleiro(72, 74));
                }
            } else if (i == 12 || i == 13 || i == 17) {
                posicoes.put(i, new PosicoesTabuleiro(74, 42));
            } else if (i == 14 | i == 15) {
                posicoes.put(i, new PosicoesTabuleiro(74, 50));
            } else if (i <= 20) {
                posicoes.put(i, new PosicoesTabuleiro(74, 60));
            } else if (i >= 30 && i <= 40) {
                if (i == 38 || i == 37 || i == 33) {
                    posicoes.put(i, new PosicoesTabuleiro(90, 42));
                } else if (i == 36 || i == 35) {
                    posicoes.put(i, new PosicoesTabuleiro(90, 50));
                } else {
                    posicoes.put(i, new PosicoesTabuleiro(90, 60));
                }
            }
        }
    }

    public void posicionaComponentes(){

         for (int i = 1; i <= 40; i++) {
           // JLabel label = (JLabel) posicoes.get(i);
            //label.setName("Teste");
             JLabel label = new JLabel("Teste");
             //label.setSize(70, 50);
            // label.setMinimumSize(new Dimension(70, 60));
             //constraints.fill = GridBagConstraints.BOTH;
             constraints.insets = new Insets(0, 0, 0,70);
             if(i<=10){
                constraints.gridy =0;
                constraints.gridx =i;
                if(i==10){
                    constraints.insets = new Insets(0, 0, 0,0);
                }
                
                getContentPane().add(label, constraints);
            }else if(i<=20){
                constraints.gridy =i - 10;
                constraints.gridx =10;
                constraints.insets = new Insets(0, 0, 0, 0);
                getContentPane().add(label, constraints);

            }else if(i<=29){
                constraints.gridy =11;
                constraints.gridx =10 - (i - 20);
                getContentPane().add(label, constraints);

            }else if(i<=40){
                constraints.gridy =10 - (i - 30);
                constraints.gridx =0;
                constraints.insets = new Insets(0, 0, 40,0);
                getContentPane().add(label, constraints);
            }
        }
    }

     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                    new JanelaTabuleiro3();

            }
        });
    }
}
