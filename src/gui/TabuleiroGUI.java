/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import negocio.GerenteJogo;
import player.Jogador;
import player.concretos.JogadorConcreto;
import player.concretos.Peao;

/**
 *
 * @author gutto
 */
public class TabuleiroGUI extends JLabel {
 
    private Map listaLugares;
    private File arquivoImagem;
    private BufferedImage imagemFundo;
    private List<Peao> listaPeoes;
    private JLabel panelGrafico;
    private GerenteJogo gerenteJogo;
    private List<Jogador> listaJogadores = new ArrayList<Jogador>();
    private PainelMensagensGUI painelMensagens = new PainelMensagensGUI();

    /**
     *
     * @param caminhoImagem
     * @param gerente
     */
    public TabuleiroGUI(String caminhoImagem, GerenteJogo gerente ) {
        setLayout(null);
        pegaImagem(caminhoImagem);
        this.gerenteJogo = gerente;
        iniciaComponentes(new HashMap());
        panelGrafico = new JLabel();
        
    }

    //Construtor que recebe os lugares
    /**
     *
     * @param lugares
     * @param caminhoImagem
     * @param gerente
     */
    public TabuleiroGUI(Map lugares, String caminhoImagem, GerenteJogo gerente) {
        setLayout(null);
        pegaImagem(caminhoImagem);
        this.gerenteJogo = gerente;
        iniciaComponentes(lugares);
        panelGrafico = new JLabel();
        
    }

    /**
     *
     * @return
     */
    public GerenteJogo getGerenteJogo() {
        return gerenteJogo;
    }

    /**
     *
     * @param gerenteJogo
     */
    public void setGerenteJogo(GerenteJogo gerenteJogo) {
        this.gerenteJogo = gerenteJogo;
    }

    
    /**
     *
     * @param caminhoImagem
     */
    public void pegaImagem(String caminhoImagem) {
        arquivoImagem = new File(caminhoImagem);
        try {
            imagemFundo = ImageIO.read(arquivoImagem);
        } catch (IOException ex) {
            System.out.println("Caminho incorreto");
            Logger.getLogger(TabuleiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param lugares
     */
    public void iniciaComponentes(Map lugares) {
        if (lugares == null) {
            listaLugares = new HashMap();
        }

        add(painelMensagens);
        painelMensagens.setBounds(820, 10, 200, 600);
        listaPeoes = new ArrayList<Peao>();
        
    }

    /**
     * 
     */
    public void inicicaJogo(){
        repaint();
    }

    /**
     *
     * @param peao
     */
    public void andaPeao(Peao peao) {
        LugarTabuleiroGUI lugar = (LugarTabuleiroGUI) listaLugares.get(peao.getPosicao());
    }

    /**
     *
     */
    public void inicializaPeoes() {
        if(listaJogadores != null){
            for (Jogador j: listaJogadores){
                listaPeoes.add(j.getPeao());
            }
        }
        
    }

    /**
     *
     * @return
     */
    public BufferedImage getImagemFundo() {
        return imagemFundo;
    }

    /**
     *
     * @param imagemFundo
     */
    public void setImagemFundo(BufferedImage imagemFundo) {
        this.imagemFundo = imagemFundo;
    }

    /**
     *
     * @return
     */
    public Map getListaLugares() {
        return listaLugares;
    }

    /**
     *
     * @param listaLugares
     */
    public void addListaLugares(Map listaLugares) {
        this.listaLugares = listaLugares;
    }

    /**
     *
     * @return
     */
    public List<Peao> getListaPeoes() {
        return listaPeoes;
    }

    /**
     *
     * @param listaPeoes
     */
    public void setListaPeoes(List<Peao> listaPeoes) {
        this.listaPeoes = listaPeoes;
    }

    /**
     *
     * @return
     */
    public List<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    /**
     *
     * @param listaJogadores
     */
    public void setListaJogadores(List<Jogador> listaJogadores) {
        this.listaJogadores = listaJogadores;
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(imagemFundo, 0, 0, this);
        try {
            int contador = 0;
            //Fator que irá multiplicar a posição Y de onde será pintada a imagem. Ela irá ser incrementada
            //sempre que forem pintados dois peoes.
            int fatorY = 0;
            //Fator que irá multiplicar a posição X de onde será pintada a imagem. Ela voltará a seu valor
            //inicial sempre que forem pintados dois peoes.
            int fatorX = 1;
            //Laço usado para pecorrer a lista de peoes e pintalos em seus rescpectivos lugares
            for (Peao p : listaPeoes) {

                BufferedImage bImagem = ImageIO.read(new File(p.getCaminhoImagemPeao()));
                //Verifica se foram pintados pelo menos três peoes e reajusta os fatores
                if (contador != 0 && contador % 3 == 0) {
                    fatorY++;
                    fatorX = 1;
                }
                //Pega o lugar do tabuleiro de acordo com a posição do peao
                LugarTabuleiroGUI lugarTab = (LugarTabuleiroGUI) listaLugares.get(p.getPosicao());
                g.drawImage(bImagem, lugarTab.getPosicao().x + fatorX * 15, lugarTab.getPosicao().y + (fatorY * 20), this);
                fatorX++;
                contador++;
            }
        } catch (IOException ex) {
            Logger.getLogger(TabuleiroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            JFrame frame = new JFrame();
            TabuleiroGUI tab = new TabuleiroGUI("C:/Users/gutto/Documents/NetBeansProjects/monopoly-bsi-ufrn/tabuleiroMonopoly/FinalTabuleiro.png");
            LugarTabuleiroGUI l1 = new LugarTabuleiroGUI(new Lugar("Teste", 20) {
            }, new Point(50, 10));
            LugarTabuleiroGUI l2 = new LugarTabuleiroGUI(new Lugar("Teste", 22) {
            }, new Point(100, 10));
            LugarTabuleiroGUI l3 = new LugarTabuleiroGUI(new Lugar("Teste", 24) {
            }, new Point(200, 10));
            LugarTabuleiroGUI l4 = new LugarTabuleiroGUI(new Lugar("Teste", 26) {
            }, new Point(300, 10));
            Map lista = new HashMap();

            public void run() {
                Peao p = new Peao();
                p.setPosicao(20);
                tab.addPeao(p);
                p.setPosicao(22);
                tab.addPeao(p);
                p.setPosicao(24);
                tab.addPeao(p);
                p.setPosicao(26);
                tab.addPeao(p);
                lista.put(l1.getLugarTabuleiro().getPosicao(), l1);
                lista.put(l2.getLugarTabuleiro().getPosicao(), l2);
                lista.put(l3.getLugarTabuleiro().getPosicao(), l3);
                lista.put(l4.getLugarTabuleiro().getPosicao(), l4);
                tab.addListaLugares(lista);
                frame.getContentPane().add(tab);
                tab.addPeao(p);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            }
        });
    }*/
}
