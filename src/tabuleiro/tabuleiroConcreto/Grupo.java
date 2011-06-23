/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro.tabuleiroConcreto;

import java.util.ArrayList;
import java.util.List;
import player.Jogador;
import tabuleiro.GrupoAbstrato;

/**
 *
 * @author gutto
 */
public class Grupo implements GrupoAbstrato{
    private List<LugarFisico> lugaresFisicos;
    private List<Jogador> jogadores;


    public Grupo(){
        lugaresFisicos = new ArrayList<LugarFisico>();
        jogadores = new ArrayList<Jogador>();
    }

    //Testa se o grupo é meu ou tem mais de um proprietario
    public boolean grupoEMeu(Jogador j){
        if(grupoEstaCompleto()){
            if(jogadores.size() == 1){
                if(jogadores.contains(j)){
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Testa se o grupo esta completo
     */
    public boolean grupoEstaCompleto(){
        for(LugarFisico f: lugaresFisicos){
            if(f.getProprietario() == null){
                return false;
            }
        }
        return true;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public List<LugarFisico> getLugaresFisicos() {
        return lugaresFisicos;
    }

    public void setLugaresFisicos(List<LugarFisico> lugaresFisicos) {
        this.lugaresFisicos = lugaresFisicos;
    }


}
