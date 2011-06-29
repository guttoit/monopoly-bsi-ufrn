/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author gutto
 */
public class TabuleiroGUI extends JFrame{

    private Map listaLugares;

    public TabuleiroGUI(){}

    //Construtor que recebe os lugares
    public TabuleiroGUI(Map lugares){
        iniciaComponentes();
        listaLugares = lugares;
    }

    public void iniciaComponentes(){
        listaLugares = new HashMap();
    }

}
