/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author gutto
 */
public class PainelImagem extends JPanel{


     private File arquivoImagem;
    private Image imagemFundo;

    public PainelImagem(String caminho){
        criaImagem(caminho);
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



     public Image getImagemFundo() {
        return imagemFundo;
    }

    public void setImagemFundo(Image imagemFundo) {
        this.imagemFundo = imagemFundo;
        this.paintComponent(this.getGraphics());
    }
}
