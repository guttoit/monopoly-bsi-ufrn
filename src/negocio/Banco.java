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

    public Banco() {
    }
    /**
     * Construtor do banco que recebe uma lista de lugares do tabuleiro como parâmetro.
     * @param lugares
     */
    public Banco(List<Lugar> lugares) {
        this.lugares = lugares;
    }
    private List<Lugar> lugares;
    
    
    private float dinheiroEmCaixa;

    public float getDinheiroEmCaixa() {
        return dinheiroEmCaixa;
    }

    public void setDinheiroEmCaixa(float dinheiroEmCaixa) {
        this.dinheiroEmCaixa = dinheiroEmCaixa;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    


}
