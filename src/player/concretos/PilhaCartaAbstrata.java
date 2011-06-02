/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package player.concretos;

import java.util.List;

/**
 *
 * @author Adm
 */
public abstract class PilhaCartaAbstrata {

    public PilhaCartaAbstrata(List<CartaCofresComunitarios> listaCartaCofresComunitarios, List<CartaSorteReves> listaCartaSorteReves ) {
        this.listaCartaCofresComunitarios = listaCartaCofresComunitarios;
        this.listaCartaSorteReves = listaCartaSorteReves;
    }

    public List<CartaCofresComunitarios> listaCartaCofresComunitarios ;
    public List<CartaSorteReves> listaCartaSorteReves ;



}
