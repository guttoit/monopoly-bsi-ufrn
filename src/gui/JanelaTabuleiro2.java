/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.CellRendererPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;
import player.concretos.Peao;

/**
 *
 * @author gutto
 */
public class JanelaTabuleiro2 extends JFrame {

    private Map posicoes;
    private JPanel painelTopo;
    private JPanel painelEsquerda;
    private JPanel painelBaixo;
    private JPanel painelDireita;
    private JLayeredPane painelPrincipal;

    public JanelaTabuleiro2() {
        //inicializaComponentes();
        //posicionaComponentes();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JComponent contentePanel =new ContentPanelMonopoly("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png");
        contentePanel.setOpaque(true);
        setContentPane(contentePanel);
        //setSize(820, 630);
        //setResizable(false);
        
        this.pack();
        this.setVisible(true);

    }

    public void inicializaComponentes() {
        //this.setContentPane(new ContentPanelMonopoly("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png"));
        
        posicoes = new HashMap();
        painelPrincipal = new JLayeredPane();
        this.setLayeredPane(painelPrincipal);
        painelTopo = new JPanel(new GridLayout(1, 10));
        painelTopo.setSize(820, 74);
        painelEsquerda = new JPanel(new GridLayout(11, 1));
        painelEsquerda.setSize(92, 620);
        painelBaixo = new JPanel(new GridLayout(1, 9));
        painelBaixo.setSize(820, 60);
        painelDireita = new JPanel(new GridLayout(1, 10));
        painelDireita.setSize(74, 620);
        //Laço usado para criar os painéis de acordo com sua posição e tamanho
        for (int i = 1; i <= 40; i++) {
            if (i <= 11 || (i > 20 && i <= 30)) {
                if (i == 7 || i == 23) {
                    posicoes.put(i, new PainelPosicoes(62, 74));
                } else {
                    posicoes.put(i, new PainelPosicoes(72, 74));
                }
            } else if (i == 12 || i == 13 || i == 17) {
                posicoes.put(i, new PainelPosicoes(74, 42));
            } else if (i == 14 | i == 15) {
                posicoes.put(i, new PainelPosicoes(74, 50));
            } else if (i <= 20) {
                posicoes.put(i, new PainelPosicoes(74, 60));
            } else if (i >= 30 && i <= 40) {
                if (i == 38 || i == 37 || i == 33) {
                    posicoes.put(i, new PainelPosicoes(90, 42));
                } else if (i == 36 || i == 35) {
                    posicoes.put(i, new PainelPosicoes(90, 50));
                } else {
                    posicoes.put(i, new PainelPosicoes(90, 60));
                }
            }
        }
    }

    public void posicionaComponentes() {
        //painelPrincipal.add(painelEsquerda, 3);
       // painelPrincipal.add(painelTopo, 4);
        //painelPrincipal.add(painelDireita, 5);
        //painelPrincipal.add(painelBaixo, 6);
        painelPrincipal.add(new ContentPanelMonopoly("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png"));
        for (int i = 1; i <= 40; i++) {
            if (i >= 1 && i <= 10) {
                painelTopo.add((JPanel) posicoes.get(i));
            } else if (i > 10 && i <= 20) {
                painelDireita.add((JPanel) posicoes.get(i));
            } else if (i > 20 && i < 30) {
                painelBaixo.add((JPanel) posicoes.get(i));
            } else if (i >= 30 && i <= 40) {
                painelEsquerda.add((JPanel) posicoes.get(i));
            }
        }
        /*
        painelEsquerda.add(new JButton("Botão teste"));
        painelDireita.add(new JButton("Botão teste"));
        painelTopo.add(new JButton("Botão teste"));
        painelBaixo.add(new JButton("Botão teste"));*/
        painelPrincipal.setVisible(true);
        //getContentPane().add(painelPrincipal);
        getLayeredPane().add(painelEsquerda, 1);
        getLayeredPane().add(painelTopo, 2);
        getLayeredPane().add(new ContentPanelMonopoly("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png"), -1);
        ((JPanel)(posicoes.get(1))).add(new JButton("Teste"));
        ((JPanel)(posicoes.get(40))).add(new JButton("Teste2"));
        //((JPanel)(posicoes.get(2))).add(new JButton("Teste"));
        //((JPanel)(posicoes.get(3))).add(new JButton("Teste"));
       // ((JPanel)(posicoes.get(9))).add(new JButton("Teste"));
        
    }

    public void movimentaPeao(Peao peao) {
    }

     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                    new JanelaTabuleiro2();

            }
        });
    }
}
