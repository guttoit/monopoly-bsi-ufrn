/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro;

import java.util.List;

/**
 *
 * @author Gutto
 */
public class TabuleiroUSA extends Tabuleiro{

    private Lugar propriedade = new Propriedade();


    @Override
    public List<Lugar> getListaLugar() {
        return super.getListaLugar();
    }


    public TabuleiroUSA(){
        super(40);
    }
}