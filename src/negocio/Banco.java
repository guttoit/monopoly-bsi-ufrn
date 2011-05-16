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
 * @class Banco é uma classe abstrata que serve como inteface para bancoConcreto. Sua responsabilidade
 * é armazenar valores dos jogadores como resceber impostos.
 */

public abstract class Banco {

    public Banco() {
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
