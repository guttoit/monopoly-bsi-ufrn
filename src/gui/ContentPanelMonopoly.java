/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import player.concretos.Peao;

/**
 *
 * @author gutto
 */
public class ContentPanelMonopoly extends JPanel {

    private File arquivoImagem;
    private Image imagemFundo;
    //private JLayeredPane painelPrincipal;
    private Map posicoes;
    private JPanel painelTopo;
    private JPanel painelEsquerda;
    private JPanel painelBaixo;
    private JPanel painelDireita;

    public ContentPanelMonopoly(String caminhoImagem) {
        criaImagem(caminhoImagem);
        //setLayout(new BorderLayout());
        inicializaComponentes();
        posicionaComponentes();
        setSize(820, 630);

        
        
    }


    public void criaImagem (String caminhoArquivo) {
        try {
            arquivoImagem = new File(caminhoArquivo);
            imagemFundo = ImageIO.read(arquivoImagem);
        } catch (IOException io) {
            System.out.println("Caminho do arquivo é inválido\n" + io.getStackTrace().toString());

        }catch(Exception e){
             System.out.println("Erro não conhecido ao ler arquivo\n" + e.getStackTrace().toString());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemFundo, 0, 0, this);

    }

     public void inicializaComponentes() {
        //this.setContentPane(new ContentPanelMonopoly("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png"));

        posicoes = new HashMap();
        //painelPrincipal = new JLayeredPane();
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
        //painelPrincipal.add(new ContentPanelMonopoly("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png"));
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
        //painelPrincipal.setVisible(true);
        //getContentPane().add(painelPrincipal);
        PainelImagem painelImagem = new PainelImagem("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png");
        add(painelEsquerda, new Integer(2),0);
        add(painelDireita, new Integer(1), 0);
        add(painelTopo, new Integer(3),0);
        add(painelImagem, new Integer(0),0);

        //add(new ContentPanelMonopoly("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/src/gui/FinalTabuleiro.png"), new Integer(0),0);
        ((JPanel)(posicoes.get(1))).add(new JButton("Teste"));
        ((JPanel)(posicoes.get(40))).add(new JButton("Teste2"));
        //((JPanel)(posicoes.get(2))).add(new JButton("Teste"));
        //((JPanel)(posicoes.get(3))).add(new JButton("Teste"));
       // ((JPanel)(posicoes.get(9))).add(new JButton("Teste"));

    }

    public void movimentaPeao(Peao peao) {
    }

    public Image getImagemFundo() {
        return imagemFundo;
    }

    public void setImagemFundo(Image imagemFundo) {
        this.imagemFundo = imagemFundo;
        this.paintComponent(this.getGraphics());
    }
}
