/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package guiAbstrato;

import java.util.Map;
import javax.swing.JPanel;
import player.concretos.Peao;

/**
 *
 * @author gutto
 */
public abstract class TabuleiroGUIAbstrato extends JPanel{


    public abstract void pegaImagem(String caminhoImagem);

    public abstract void iniciaComponentes(Map lugares);

    public abstract void addPeao(Peao peao);

    public abstract void addListaLugares(Map listaLugares) ;
}
