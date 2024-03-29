/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;
import tabuleiro.Lugar;

/**
 *
 * @author Adm
 */

/**
 *
 * Banco é uma classe abstrata que serve como inteface para qualquer bancoConcreto. Sua responsabilidade
 * é receber o pagamento das propriedades oferecidas aos jogadores bem como receber o pagamento de
 * impostos.
 */

public abstract class Banco {

    /**
     *
     */
    protected  List<Lugar> lugares;

    private int numCasasPossiveis;
    private int numCasasDisponiveis;
    private int numHoteisPossiveis;
    private int numHoteisDisponiveis;
    /**
     *
     */
    protected float dinheiroEmCaixa;
    /**
     * Construtor padrão
     */
    public Banco() {
        this.numCasasPossiveis = 40;
        this.numHoteisPossiveis = 20;
        this.numCasasDisponiveis = this.numCasasPossiveis;
        this.numHoteisDisponiveis = this.numHoteisPossiveis;
    }

    /**
     *
     * @param numCasasPossiveis
     * @param numHoteisPossiveis
     */
    public Banco(int numCasasPossiveis, int numHoteisPossiveis) {
        this.numCasasPossiveis = numCasasPossiveis;
        this.numHoteisPossiveis = numHoteisPossiveis;
        this.numCasasDisponiveis = this.numCasasPossiveis;
        this.numHoteisDisponiveis = this.numHoteisPossiveis;
    }



    /**
     *
     * @return
     */
    public int getNumCasasDisponiveis() {
        return numCasasDisponiveis;
    }

    /**
     *
     * @param numCasasDisponiveis
     */
    public void setNumCasasDisponiveis(int numCasasDisponiveis) {
        this.numCasasDisponiveis = numCasasDisponiveis;
    }

    /**
     *
     * @return
     */
    public int getNumCasasPossiveis() {
        return numCasasPossiveis;
    }

    /**
     *
     * @param numCasasPossiveis
     */
    public void setNumCasasPossiveis(int numCasasPossiveis) {
        this.numCasasPossiveis = numCasasPossiveis;
    }

    /**
     *
     * @return
     */
    public int getNumHoteisDisponiveis() {
        return numHoteisDisponiveis;
    }

    /**
     *
     * @param numHoteisDisponiveis
     */
    public void setNumHoteisDisponiveis(int numHoteisDisponiveis) {
        this.numHoteisDisponiveis = numHoteisDisponiveis;
    }

    /**
     *
     * @return
     */
    public int getNumHoteisPossiveis() {
        return numHoteisPossiveis;
    }

    /**
     *
     * @param numHoteisPossiveis
     */
    public void setNumHoteisPossiveis(int numHoteisPossiveis) {
        this.numHoteisPossiveis = numHoteisPossiveis;
    }

  
    

    /**
     *
     * @return float
     */
    public float getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }
    /**
     *
     * @param dinheiroEmCaixa float
     */
    public void setDinheiroEmCaixa(float dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }
    /**
     *
     * @return ArrayList<Lugares>
     */
    public List<Lugar> getLugares() {
        return lugares;
    }
    /**
     *
     * @param lugares List<Lugar>
     */
    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    

}
