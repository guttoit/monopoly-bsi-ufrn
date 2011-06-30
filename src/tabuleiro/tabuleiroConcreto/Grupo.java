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
    /**
     *
     */
    public Grupo(){
        lugaresFisicos = new ArrayList<LugarFisico>();
        jogadores = new ArrayList<Jogador>();
        propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
    }

    /**
     *
     * @param cor
     */
    public Grupo(String cor){
        this.cor=cor;
        lugaresFisicos = new ArrayList<LugarFisico>();
        jogadores = new ArrayList<Jogador>();
        propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
    }
    /**
     *
     * @param lugaresFisicos
     * @param cor
     */
    public Grupo(List<LugarFisico> lugaresFisicos, String cor) {
        this.lugaresFisicos = lugaresFisicos;
        this.cor = cor;
        jogadores = new ArrayList<Jogador>();
        propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
    }

    /**
     *
     * @param lf
     */
    public void addLugarFisico(LugarFisico lf) {
        lugaresFisicos.add(lf);
    }

    /**
     *
     * @param p
     */
    public void addPropriedadeNaoPodeConstruir(Propriedade p){
        propriedadesNaoPodeConstruir.add(p);
        lugaresFisicos.remove(p);
        if(lugaresFisicos.isEmpty()){
            lugaresFisicos = propriedadesNaoPodeConstruir;
            propriedadesNaoPodeConstruir = new ArrayList<LugarFisico>();
        }
     }

    //Testa se o grupo é meu ou tem mais de um proprietario
     /**
      *
      * @param j
      * @return
      */
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
    /**
     *
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
    /**
     *
     * @return
     */
    public boolean grupoEstaCompleto(){
        for(LugarFisico f: lugaresFisicos){
            if(f.getProprietario() == null){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return
     */
    public String getCor() {
        return cor;
    }

    /**
     *
     * @param cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    

    /**
     *
     * @return
     */
    public List<LugarFisico> getPropriedadesNaoPodeConstruir() {
        return propriedadesNaoPodeConstruir;
    }

    /**
     *
     * @param propriedadesNaoPodeConstruir
     */
    public void setPropriedadesNaoPodeConstruir(List<LugarFisico> propriedadesNaoPodeConstruir) {
        this.propriedadesNaoPodeConstruir = propriedadesNaoPodeConstruir;
    }

    

    /**
     *
     * @return
     */
    public List<Jogador> getJogadores() {
        return jogadores;
    }

    /**
     *
     * @param jogadores
     */
    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    /**
     *
     * @return
     */
    public List<LugarFisico> getLugaresFisicos() {
        return lugaresFisicos;
    }

    /**
     *
     * @param lugaresFisicos
     */
    public void setLugaresFisicos(List<LugarFisico> lugaresFisicos) {
        this.lugaresFisicos = lugaresFisicos;
    }




}
