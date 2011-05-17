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


/**
 *
 * @class Main é a classe princial que inicializa o Jogo criando instancias de fatory e jogo e chamanado
 * o metodo para iniciar o jogo. A partir desse ponto, o jogo pode ser utilidados pelos usuários.
 */
public class Main {


    public static void main(String[] args) {
        FactoryCriador factory = new FactoryUSA();
        Jogo jogo = new Jogo(factory);
        jogo.iniciaJogo();
    }
}



