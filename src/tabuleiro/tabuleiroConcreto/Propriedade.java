/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabuleiro.tabuleiroConcreto;

/**
 *
 * @author Adm
 */
public class Propriedade extends LugarFisico {

    private float aluguelSemCasa;
    private float aluguelAtual;
    private int nCasas;
    private float hotel;
    private float aluguelCasa1;
    private float aluguelCasa2;
    private float aluguelCasa3;
    private float aluguelCasa4;
    private float precoCasa;
    private String cor;

    public Propriedade() {
    }

    public Propriedade(int posicao,String nome, String cor, float precoP, float aluguelSCasa,float c1, float c2, float c3, float c4, float hotel,  float hip, float precoCasa){
        super.setPreco(precoP);
        super.setNome(nome);
        this.cor = cor;
        super.setHipoteca(hip);
        super.setPosicao(posicao);
        super.setProprietario(null);
        this.hotel = hotel;
        aluguelCasa1 = c1;
        aluguelCasa2 = c2;
        aluguelCasa3 = c3;
        aluguelCasa4 = c4;
        int nivel;
        this.precoCasa = precoCasa;
        aluguelSemCasa = aluguelSCasa;
        aluguelAtual = aluguelSCasa;
    }

    public float getAluguelSemCasa() {
        return aluguelSemCasa;
    }

    public void setAluguelSemCasa(float aluguelSemCasa) {
        this.aluguelSemCasa = aluguelSemCasa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getAluguelCasa1() {
        return aluguelCasa1;
    }

    public void setAluguelCasa1(float aluguelCasa1) {
        this.aluguelCasa1 = aluguelCasa1;
    }

    public float getAluguelCasa2() {
        return aluguelCasa2;
    }

    public void setAluguelCasa2(float aluguelCasa2) {
        this.aluguelCasa2 = aluguelCasa2;
    }

    public float getAluguelCasa3() {
        return aluguelCasa3;
    }

    public void setAluguelCasa3(float aluguelCasa3) {
        this.aluguelCasa3 = aluguelCasa3;
    }

    public float getAluguelCasa4() {
        return aluguelCasa4;
    }

    public void setAluguelCasa4(float aluguelCasa4) {
        this.aluguelCasa4 = aluguelCasa4;
    }

    public float getHotel() {
        return hotel;
    }

    public void setHotel(float hotel) {
        this.hotel = hotel;
    }

    public float getPrecoCasa() {
        return precoCasa;
    }

    public void setPrecoCasa(float precoCasa) {
        this.precoCasa = precoCasa;
    }

   

    public int getnCasas() {
        return nCasas;
    }

    public void setnCasas(int nCasas) {
        this.nCasas = nCasas;
    }

    public float getAluguelAtual() {
        return aluguelAtual;
    }

    public void setAluguelAtual(float aluguelAtual) {
        this.aluguelAtual = aluguelAtual;
    }

    
       

    
}
