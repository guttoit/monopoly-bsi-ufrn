/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package monopoly;

import negocio.FactoryCriador;
import negocio.negocioConcreto.FactoryUSA;
import negocio.negocioConcreto.Jogo;



/**
 *
 * @author Adm
 */
public class Main {


    public static void main(String[] args) {
        FactoryCriador factory = new FactoryUSA();
        Jogo jogo = new Jogo(factory);
        jogo.iniciaJogo();
    }
}



