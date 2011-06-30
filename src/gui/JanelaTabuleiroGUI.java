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
    //private PainelMensagensGUI painelMensagensGUI;
    
    /**
     *
     * @param tabuleiro
     */
    public JanelaTabuleiroGUI(TabuleiroGUI tabuleiro){
        
        this.tabuleiro=tabuleiro;
        //this.painelMensagensGUI = new PainelMensagensGUI();
        setSize(1024, 640);
        setResizable(false);
        posicionaComponentes();
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }

    /**
     *
     */
    public void posicionaComponentes(){

       
        getContentPane().add(tabuleiro);
      
        //getContentPane().add(painelMensagensGUI);
    }



}
