/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.objetosNulo;

import java.util.List;
import java.util.Scanner;
import negocio.Banco;
import negocio.GerenteCompraVenda;
import negocio.Mensagens;
import player.Jogador;
import tabuleiro.Lugar;
import tabuleiro.tabuleiroConcreto.LugarFisico;
import tabuleiro.tabuleiroConcreto.Propriedade;

/**
 *
 * @author gutto
 */
public class GerenteCompraVendaObjetoNulo implements GerenteCompraVenda{

    public boolean gerenciaCompra(LugarFisico l, Jogador jogador, Scanner teclado, Banco b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void descontaAluguel(LugarFisico lf, Jogador jogadorVez) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void descontaImposto(Lugar l, Jogador jogadorVez, Banco b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
    public void venda(Jogador jogador, Propriedade propriedade, Banco banco) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void construir(Jogador jogador, List<LugarFisico> lugares, Scanner teclado, Banco banco, Mensagens mens) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
