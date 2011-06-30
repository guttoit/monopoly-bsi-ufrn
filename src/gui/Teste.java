/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gutto
 */
public class Teste extends JPanel {

    ImageIcon img = new ImageIcon("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/go.png");
    private JLabel label = new JLabel(img);
    private JButton botao = new JButton("Teste");
    private JPanel painel = new JPanel();

    public Teste() {
        //this.add(label);
        setLayout(new BorderLayout());
        painel.add(botao);
        botao.setPreferredSize(new Dimension(20, 20));
        botao.setBounds(100, 50, 50, 50);
        this.add(botao, BorderLayout.NORTH);
    }

    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage b = null;
        try {
            b = ImageIO.read(new File("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/FinalTabuleiro.png"));
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(b, 0, 0, this);
        try {
            b = ImageIO.read(new File("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/peaoAzul.png"));
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(b, 5, 0, this);
        g.drawImage(b, 15, 0, this);
        g.drawImage(b, 25, 0, this);
        g.drawImage(b, 35, 0, this);
        g.drawImage(b, 45, 0, this);
        g.drawImage(b, 55, 0, this);

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            JFrame frame = new JFrame();

            public void run() {
                //frame.add(new Teste());
                Teste t = new Teste();
                ImageIcon img = new ImageIcon("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/go.png");
                JLabel j = new JLabel(img);

                t.add(j);

                frame.getContentPane().add(t);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            }
        });
    }
}
