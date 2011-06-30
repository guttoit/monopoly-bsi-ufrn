/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabuleiro.tabuleiroConcreto;

/**
 *
 * @author Adm
 */



/**
 *
 * @class classe Propriedade é um lugar fisico que representa imóvel.
 *
 *
 */
public class Propriedade extends LugarFisico {

    private float aluguelSemCasa;
    private float aluguelAtual;
    private int nCasas;
    private float aluguelHotel;
    private float aluguelCasa1;
    private float aluguelCasa2;
    private float aluguelCasa3;
    private float aluguelCasa4;
    private float precoCasa;
    private String cor;
    private float preco;
    
    /**
     *
     */
    public Propriedade() {
    }




    /**
     *
     * @param posicao
     * @param nome
     * @param cor
     * @param precoP
     * @param aluguelSCasa
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @param aluguelHotel
     * @param hip
     * @param precoCasa
     */
    public Propriedade(int posicao,String nome, Grupo grupo, float precoP, float aluguelSCasa,float c1, float c2, float c3, float c4, float hotel,  float hip, float precoCasa){
        super.setPreco(precoP);
        super.setNome(nome);
        this.cor = cor;
        super.setHipoteca(hip);
        super.setPosicao(posicao);
        super.setProprietario(null);
        this.aluguelHotel = hotel;
        aluguelCasa1 = c1;
        aluguelCasa2 = c2;
        aluguelCasa3 = c3;
        aluguelCasa4 = c4;
        int nivel;
        this.precoCasa = precoCasa;
        aluguelSemCasa = aluguelSCasa;
        aluguelAtual = aluguelSCasa;
        super.setGrupo(grupo);
        grupo.addLugarFisico(this);
    }

    public float getPrecoAluguelAtual(){
        switch(nCasas){
            case 0:
                return aluguelSemCasa;
            case 1:
                return aluguelCasa1;
              
            case 2:
                return aluguelCasa2;
                
            case 3:
                return aluguelCasa3;
                
            case 4:
                return aluguelCasa4;
                
            case 5:
                return aluguelHotel;

            default:
                return (float) 0;
        }

    }

    /**
     *
     * @return
     */
    public float getAluguelSemCasa() {
        return aluguelSemCasa;
    }

    /**
     *
     * @param aluguelSemCasa
     */
    public void setAluguelSemCasa(float aluguelSemCasa) {
        this.aluguelSemCasa = aluguelSemCasa;
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
    public float getAluguelCasa1() {
        return aluguelCasa1;
    }

    /**
     *
     * @param aluguelCasa1
     */
    public void setAluguelCasa1(float aluguelCasa1) {
        this.aluguelCasa1 = aluguelCasa1;
    }

    /**
     *
     * @return
     */
    public float getAluguelCasa2() {
        return aluguelCasa2;
    }

    /**
     *
     * @param aluguelCasa2
     */
    public void setAluguelCasa2(float aluguelCasa2) {
        this.aluguelCasa2 = aluguelCasa2;
    }

    /**
     *
     * @return
     */
    public float getAluguelCasa3() {
        return aluguelCasa3;
    }

    /**
     *
     * @param aluguelCasa3
     */
    public void setAluguelCasa3(float aluguelCasa3) {
        this.aluguelCasa3 = aluguelCasa3;
    }

    /**
     * 
     * @return
     */
    public float getAluguelCasa4() {
        return aluguelCasa4;
    }

    /**
     *
     * @param aluguelCasa4
     */
    public void setAluguelCasa4(float aluguelCasa4) {
        this.aluguelCasa4 = aluguelCasa4;
    }

    /**
     *
     * @return
     */
    public float getHotel() {
        return aluguelHotel;
    }

    /**
     *
     * @param aluguelHotel
     */
    public void setHotel(float hotel) {
        this.aluguelHotel = hotel;
    }

    /**
     *
     * @return
     */
    public float getPrecoCasa() {
        return precoCasa;
    }

    /**
     *
     * @param precoCasa
     */
    public void setPrecoCasa(float precoCasa) {
        this.precoCasa = precoCasa;
    }

   

    /**
     *
     * @return
     */
    public int getnCasas() {
        return nCasas;
    }

    /**
     *
     * @param nCasas
     */
    public void setnCasas(int nCasas) {
        this.nCasas = nCasas;
    }

    /**
     *
     * @return
     */
    public float getAluguelAtual() {
        return aluguelAtual;
    }

    /**
     *
     * @param aluguelAtual
     */
    public void setAluguelAtual(float aluguelAtual) {
        this.aluguelAtual = aluguelAtual;
    }

    
       

    
}
