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

    /**
     *
     */
    protected float dinheiroEmCaixa;
    /**
     * Construtor padrão
     */
    public Banco() {
    }

    private static Banco unicaInstancia;

    public static Banco getInstance(){
       if (unicaInstancia == null){
           synchronized (Banco.class){
           if (unicaInstancia == null) {
               unicaInstancia = new Banco() {};
            }
           }
       }
       return unicaInstancia;
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
