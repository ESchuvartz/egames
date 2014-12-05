package model;

public class Jogo {
    private int id;
    private String nome;
    private Distribuidora distribuidora;
    private Genero genero;
    private FaixaEtaria faixaEtaria;
    private Deposito deposito;
    private double valor;
    private double classificacao;
    private String review;
    private String imagem;

    public Jogo() {
    }

    public double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public String getDescricao() {
        return nome;
    }

    public void setDescricao(String nome) {
        this.nome = nome;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
