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


    /**
     *
     * @param caminhoImagem
     */
    public abstract void pegaImagem(String caminhoImagem);

    /**
     *
     * @param lugares
     */
    public abstract void iniciaComponentes(Map lugares);

    /**
     *
     * @param peao
     */
    public abstract void addPeao(Peao peao);

    /**
     *
     * @param listaLugares
     */
    public abstract void addListaLugares(Map listaLugares) ;
}
