/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    public PainelMensagensGUI(){
        setLayout(new BorderLayout());
    }
    
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

        painelJogador = new JPanel(new GridLayout());
        painelMensagem = new JPanel(new GridLayout());
        painelDados = new JPanel(new GridLayout());
        painelComandos = new JPanel(new GridLayout());

        botaoJogar = new JButton("Jogar");
        botaoSair = new JButton("Sair");
        botaoStatus = new JButton("Status");
        botaoVender = new JButton("Vender");
        botaoConstruir = new JButton("Construir");

    }

    public JLabel getCorPeao() {
        return corPeao;
    }

    public void setCorPeao(JLabel corPeao) {
        this.corPeao = corPeao;
    }

    public JLabel getDados() {
        return dados;
    }

    public void setDados(JLabel dados) {
        this.dados = dados;
    }

    public JLabel getJogadorVez() {
        return jogadorVez;
    }

    public void setJogadorVez(JLabel jogadorVez) {
        this.jogadorVez = jogadorVez;
    }

    public JLabel getMensagens() {
        return mensagens;
    }

    public void setMensagens(JLabel mensagens) {
        this.mensagens = mensagens;
    }

    public JPanel getPainelComandos() {
        return painelComandos;
    }

    public void setPainelComandos(JPanel painelComandos) {
        this.painelComandos = painelComandos;
    }

    public JPanel getPainelDados() {
        return painelDados;
    }

    public void setPainelDados(JPanel painelDados) {
        this.painelDados = painelDados;
    }

    public JPanel getPainelJogador() {
        return painelJogador;
    }

    public void setPainelJogador(JPanel painelJogador) {
        this.painelJogador = painelJogador;
    }

    public JPanel getPainelMensagem() {
        return painelMensagem;
    }

    public void setPainelMensagem(JPanel painelMensagem) {
        this.painelMensagem = painelMensagem;
    }

    public JTextField getTextoCorPeao() {
        return textoCorPeao;
    }

    public void setTextoCorPeao(JTextField textoCorPeao) {
        this.textoCorPeao = textoCorPeao;
    }

    public JTextField getTextoDado1() {
        return textoDado1;
    }

    public void setTextoDado1(JTextField textoDado1) {
        this.textoDado1 = textoDado1;
    }

    public JTextField getTextoDado2() {
        return textoDado2;
    }

    public void setTextoDado2(JTextField textoDado2) {
        this.textoDado2 = textoDado2;
    }

    public JTextField getTextoJogadorVez() {
        return textoJogadorVez;
    }

    public void setTextoJogadorVez(JTextField textoJogadorVez) {
        this.textoJogadorVez = textoJogadorVez;
    }

    public JTextArea getTextoMensagem() {
        return textoMensagem;
    }

    public void setTextoMensagem(JTextArea textoMensagem) {
        this.textoMensagem = textoMensagem;
    }



}
