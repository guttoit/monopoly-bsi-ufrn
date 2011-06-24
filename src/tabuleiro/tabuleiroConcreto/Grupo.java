/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tabuleiro.tabuleiroConcreto;

import java.util.ArrayList;
import java.util.List;
import player.Jogador;
import tabuleiro.GrupoAbstrato;
import tabuleiro.Lugar;

/**
 *
 * @author gutto
 */
public class Grupo implements GrupoAbstrato{
    private List<LugarFisico> lugaresFisicos;
    private List<Jogador> jogadores;
    private List<LugarFisico> propriedadesNaoPodeConstruir;
    private String cor;
    public Grupo(){
        lugaresFisicos = new ArrayList<LugarFisico>();
        jogadores = new ArrayList<Jogador>();
        propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
    }

    public Grupo(String cor){
        this.cor=cor;
        lugaresFisicos = new ArrayList<LugarFisico>();
        jogadores = new ArrayList<Jogador>();
        propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
    }
    public Grupo(List<LugarFisico> lugaresFisicos, String cor) {
        this.lugaresFisicos = lugaresFisicos;
        this.cor = cor;
        jogadores = new ArrayList<Jogador>();
        propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
    }

    public void addLugarFisico(LugarFisico lf) {
        lugaresFisicos.add(lf);
    }

     public void addPropriedadeNaoPodeConstruir(Propriedade p){
        propriedadesNaoPodeConstruir.add(p);
        lugaresFisicos.remove(p);
        if(lugaresFisicos.isEmpty()){
            lugaresFisicos = propriedadesNaoPodeConstruir;
            propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
        }
     }

    //Testa se o grupo é meu ou tem mais de um proprietario
    public boolean grupoEMeu(Jogador j){
        if(grupoEstaCompleto()){
            preencheListaJogadores();
            for(Jogador jog: jogadores){
                if(!jog.equals(j)){
                    return false;
                }
            }
           
              
        }else{
            return false;
        }
        return true;
    }

    /*
     * Preenche a lista dos jogadores que possuem propriedades desse grupo
     */
    public void preencheListaJogadores(){

        for(LugarFisico lf: lugaresFisicos){
            if(lf.getProprietario()!=null){
                jogadores.add(lf.getProprietario());
            }
        }
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    

    public List<LugarFisico> getPropriedadesNaoPodeConstruir() {
        return propriedadesNaoPodeConstruir;
    }

    public void setPropriedadesNaoPodeConstruir(List<LugarFisico> propriedadesNaoPodeConstruir) {
        this.propriedadesNaoPodeConstruir = propriedadesNaoPodeConstruir;
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
