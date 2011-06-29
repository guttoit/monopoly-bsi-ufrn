/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import player.concretos.Peao;

/**
 *
 * @author gutto
 */
public class JanelaTabuleiro4 extends JFrame {

    private Map posicoes;
    private GridBagConstraints constraints;
    private PainelPosicoes painelTopo;
    private PainelPosicoes painelDireita;
    private PainelPosicoes painelBaixo;
    private PainelPosicoes painelEsquerda;
    private JPanel painelCentro;

    public JanelaTabuleiro4() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        iniciaComponentes();
        criaPosicoes();
        posicionaComponentes();
        this.setResizable(true);
        setSize(820, 630);
        this.setVisible(true);
        andaPeao(new Peao("Azul"));
        repaint();
        //this.pack();
    }

    public void iniciaComponentes() {
        setLayout(new BorderLayout());
        posicoes = new HashMap();
        constraints = new GridBagConstraints();
        painelBaixo = new PainelPosicoes(1, 9);
        painelEsquerda = new PainelPosicoes(9, 1);
        painelTopo = new PainelPosicoes(1, 10);
        painelDireita = new PainelPosicoes(9, 1);
        painelCentro = new JPanel(new GridLayout());

        //Laço usado para criar os painéis de acordo com sua posição e tamanho
        for (int i = 1; i <= 40; i++) {
            if (i <= 11 || (i > 20 && i <= 30)) {
                if (i == 7 || i == 23) {
                    JLabel lab = new JLabel();
                    lab.setPreferredSize(new Dimension(68, 74));
                    posicoes.put(i, lab);
                } else {
                    JLabel lab = new JLabel();
                    lab.setPreferredSize(new Dimension(72, 74));
                    posicoes.put(i, lab);
                }
            } else if (i == 12 || i == 13 || i == 17) {
                JLabel lab = new JLabel();
                lab.setPreferredSize(new Dimension(74, 42));
                posicoes.put(i, lab);

            } else if (i == 14 | i == 15) {
                JLabel lab = new JLabel();
                lab.setPreferredSize(new Dimension(74, 50));
                posicoes.put(i, lab);

            } else if (i <= 20) {
                JLabel lab = new JLabel();
                lab.setPreferredSize(new Dimension(74, 60));
                posicoes.put(i, lab);

            } else if (i >= 30 && i <= 40) {
                if (i == 38 || i == 37 || i == 33) {
                    JLabel lab = new JLabel();
                    lab.setPreferredSize(new Dimension(90, 42));
                    posicoes.put(i, lab);

                } else if (i == 36 || i == 35) {
                    JLabel lab = new JLabel();
                    lab.setPreferredSize(new Dimension(90, 50));
                    posicoes.put(i, lab);

                } else {
                    JLabel lab = new JLabel();
                    lab.setPreferredSize(new Dimension(90, 60));
                    posicoes.put(i, lab);

                }
            }
        }
    }

    public void posicionaComponentes() {

        painelTopo.add((JLabel) posicoes.get(40));
       
        for (int i = 1; i < 40; i++) {
            
            if (i <= 10) {
                JLabel label = (JLabel) posicoes.get(i);
                painelTopo.add(label);
            } else if (i < 20) {
                JLabel label = (JLabel) posicoes.get(i);
                painelDireita.add(label);

            } else if (i <= 30) {
                //Operação para inverter a ordem das posições
                int j = 50-i ;
                JLabel label = (JLabel) posicoes.get(j);
                painelBaixo.add(label);


            } else if (i <40) {
                int j = 70-i ;
                JLabel label = (JLabel) posicoes.get(j);
                painelEsquerda.add(label);
            }
        }
        ImageIcon imagem = new ImageIcon("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/centro.png");
        painelCentro.add(new JLabel(imagem));
        getContentPane().add(painelEsquerda, BorderLayout.WEST);
        getContentPane().add(painelTopo, BorderLayout.NORTH);
        getContentPane().add(painelDireita, BorderLayout.EAST);
        getContentPane().add(painelBaixo, BorderLayout.SOUTH);
        getContentPane().add(painelCentro, BorderLayout.CENTER);
    }

    public void criaPosicoes() {

        JLabel label = new JLabel();
        ImageIcon imagem;
        for (int i = 1; i < 40; i++) {
            imagem = new ImageIcon("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/posicao" + i + ".png");
            ((JLabel) posicoes.get(i)).setIcon(imagem);
            //posicoes.put(i, label);
        }
        imagem = new ImageIcon("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/go.png");
        ((JLabel) posicoes.get(40)).setIcon(imagem);
        //posicoes.put(40, label40);
    }

    public void andaPeao(Peao peao){
        //peao = new Peao("Azul");
        peao.setPosicao(8);
        JLabel j = (JLabel) posicoes.get(peao.getPosicao());
        Graphics g =j.getGraphics();
        g.drawLine(j.getX(), j.getY(), 10, 10);
        
        j.add(new Button("Peao azul"));
    }

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new JanelaTabuleiro4();

            }
        });
    }
}
