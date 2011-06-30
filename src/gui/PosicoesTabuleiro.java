/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author gutto
 */
public class PosicoesTabuleiro extends JLabel{

    private ImageIcon imagemLugar;

    public PosicoesTabuleiro(String caminhoImagem, int w, int h){
        //imagemLugar = new ImageIcon(caminhoImagem);
       // setIcon(imagemLugar);
        //setSize(w, h);
        setName("Teste");
        //setVisible(true);
    }
    public PosicoesTabuleiro( int w, int h){
        //setIcon(imagemLugar);
        //setSize(w, h);
        setName("Teste");
        //etVisible(true);
    }
    public PosicoesTabuleiro(){
        setName("TesteS");
    }

    public ImageIcon getImagemFundo() {
        return imagemLugar;
    }

    @Override
    public void paintComponents(Graphics g){
        super.paint(g);
        //g.drawImage((Image)imagemLugar, TOP, TOP, labelFor);

    }
    public void setImagemFundo(ImageIcon imagemLugar) {
        this.imagemLugar = imagemLugar;
        setIcon(imagemLugar);
    }
}
