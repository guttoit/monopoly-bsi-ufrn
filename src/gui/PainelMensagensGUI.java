/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author gutto
 */
public class PainelMensagensGUI extends JPanel{
    private JLabel jogadorVez, corPeao, mensagens, dados;
    private JTextField textoJogadorVez, textoCorPeao, textoDado1, textoDado2;
    private JTextArea textoMensagem;
    private JPanel painelJogador, painelMensagem, painelDados, painelComandos;
    private JButton botaoJogar,botaoSair,botaoStatus,botaoVender,botaoConstruir;
    /**
     *
     */
    public PainelMensagensGUI(){
        setLayout(new GridBagLayout());
        iniciaComponentes();
        posicionaComponentes();
        setPreferredSize(new Dimension(300, 600));
    }
    
    /**
     *
     */
    public void iniciaComponentes(){
        jogadorVez = new JLabel("Jogador vez");
        corPeao = new JLabel("Cor peão");
        mensagens = new JLabel("Mensagens");
        dados = new JLabel("Dados");
        
        textoJogadorVez = new JTextField(50);
        textoCorPeao = new JTextField(20);
        textoDado1 = new JTextField(10);
        textoDado2 = new JTextField(10);
 
        textoMensagem = new JTextArea();
        

        botaoJogar = new JButton("Jogar");
        botaoSair = new JButton("Sair");
        botaoStatus = new JButton("Status");
        botaoVender = new JButton("Vender");
        botaoConstruir = new JButton("Construir");

        painelJogador = new JPanel(new GridLayout(2, 2));
        painelMensagem = new JPanel(new GridLayout(1,1));
        painelDados = new JPanel(new GridLayout(2,2));
        painelComandos = new JPanel(new GridLayout(2,2));

    }

    public void posicionaComponentes(){
        painelJogador.setBorder(BorderFactory.createTitledBorder("Jogador Vez"));
        painelJogador.add(jogadorVez);
        painelJogador.add(textoJogadorVez);
        painelJogador.add(corPeao);
        painelJogador.add(textoCorPeao);

       // painelMensagem.setBorder(BorderFactory.createTitledBorder("Mensagens"));
        //painelMensagem.add(mensagens);
        painelMensagem.add(textoMensagem);

        painelDados.add(dados);
        painelDados.add(new JLabel(":"));
        painelDados.add(textoDado1);
        painelDados.add(textoDado2);

        painelComandos.add(botaoJogar);
        painelComandos.add(botaoStatus);
        painelComandos.add(botaoConstruir);
        painelComandos.add(botaoVender);
        painelComandos.add(botaoSair);
        GridBagConstraints constrains = new GridBagConstraints();
        constrains.gridx = 0;
        constrains.gridy = 0;
        constrains.gridwidth = 10;
        constrains.insets = new Insets(0, 0,80, 0);
        this.add(painelJogador,constrains);
        constrains.gridx = 0;
        constrains.gridy = 4;
        constrains.gridwidth = 10;
        this.add(painelMensagem,constrains);
        constrains.gridx = 0;
        constrains.gridy = 6;
        constrains.gridwidth = 10;
        constrains.gridheight = 2;
        this.add(painelDados,constrains);
        constrains.gridx = 0;
        constrains.gridy = 8;
        this.add(painelComandos,constrains);
    }

    /**
     *
     * @return
     */
    public JLabel getCorPeao() {
        return corPeao;
    }

    /**
     *
     * @param corPeao
     */
    public void setCorPeao(JLabel corPeao) {
        this.corPeao = corPeao;
    }

    /**
     *
     * @return
     */
    public JLabel getDados() {
        return dados;
    }

    /**
     *
     * @param dados
     */
    public void setDados(JLabel dados) {
        this.dados = dados;
    }

    /**
     *
     * @return
     */
    public JLabel getJogadorVez() {
        return jogadorVez;
    }

    /**
     *
     * @param jogadorVez
     */
    public void setJogadorVez(JLabel jogadorVez) {
        this.jogadorVez = jogadorVez;
    }

    /**
     *
     * @return
     */
    public JLabel getMensagens() {
        return mensagens;
    }

    /**
     *
     * @param mensagens
     */
    public void setMensagens(JLabel mensagens) {
        this.mensagens = mensagens;
    }

    /**
     *
     * @return
     */
    public JPanel getPainelComandos() {
        return painelComandos;
    }

    /**
     *
     * @param painelComandos
     */
    public void setPainelComandos(JPanel painelComandos) {
        this.painelComandos = painelComandos;
    }

    /**
     *
     * @return
     */
    public JPanel getPainelDados() {
        return painelDados;
    }

    /**
     *
     * @param painelDados
     */
    public void setPainelDados(JPanel painelDados) {
        this.painelDados = painelDados;
    }

    /**
     *
     * @return
     */
    public JPanel getPainelJogador() {
        return painelJogador;
    }

    /**
     *
     * @param painelJogador
     */
    public void setPainelJogador(JPanel painelJogador) {
        this.painelJogador = painelJogador;
    }

    /**
     *
     * @return
     */
    public JPanel getPainelMensagem() {
        return painelMensagem;
    }

    /**
     *
     * @param painelMensagem
     */
    public void setPainelMensagem(JPanel painelMensagem) {
        this.painelMensagem = painelMensagem;
    }

    /**
     *
     * @return
     */
    public JTextField getTextoCorPeao() {
        return textoCorPeao;
    }

    /**
     *
     * @param textoCorPeao
     */
    public void setTextoCorPeao(JTextField textoCorPeao) {
        this.textoCorPeao = textoCorPeao;
    }

    /**
     *
     * @return
     */
    public JTextField getTextoDado1() {
        return textoDado1;
    }

    /**
     *
     * @param textoDado1
     */
    public void setTextoDado1(JTextField textoDado1) {
        this.textoDado1 = textoDado1;
    }

    /**
     *
     * @return
     */
    public JTextField getTextoDado2() {
        return textoDado2;
    }

    /**
     *
     * @param textoDado2
     */
    public void setTextoDado2(JTextField textoDado2) {
        this.textoDado2 = textoDado2;
    }

    /**
     *
     * @return
     */
    public JTextField getTextoJogadorVez() {
        return textoJogadorVez;
    }

    /**
     *
     * @param textoJogadorVez
     */
    public void setTextoJogadorVez(JTextField textoJogadorVez) {
        this.textoJogadorVez = textoJogadorVez;
    }

    /**
     *
     * @return
     */
    public JTextArea getTextoMensagem() {
        return textoMensagem;
    }

    /**
     *
     * @param textoMensagem
     */
    public void setTextoMensagem(JTextArea textoMensagem) {
        this.textoMensagem = textoMensagem;
    }



}
