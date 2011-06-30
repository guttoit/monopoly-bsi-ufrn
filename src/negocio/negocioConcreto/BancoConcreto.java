/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.negocioConcreto;

import negocio.Banco;

/**
 *
 * @author Gutto
 */

/**
 *
 * BancoConcreto é uma classe concreta que extende banco.
 */
public class BancoConcreto extends Banco{

    /**
     *
     */
    public BancoConcreto(){
        super();
    }

    /**
     *
     * @param numCasasPossiveis
     * @param numHoteisPossiveis
     */
    public BancoConcreto(int numCasasPossiveis, int numHoteisPossiveis) {
        super.setNumCasasPossiveis(numCasasPossiveis);
        super.setNumHoteisPossiveis(numHoteisPossiveis);
        super.setNumCasasDisponiveis(numCasasPossiveis);
        super.setNumHoteisDisponiveis(numHoteisPossiveis);
    }
}
