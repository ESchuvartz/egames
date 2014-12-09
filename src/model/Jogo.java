package model;

import javax.swing.JOptionPane;

public class Jogo {
    private int id;
    private String nome;
    private int idDistribuidora;
    private int idGenero;
    private int idFaixaEtaria;
    private int idDeposito;
    private double valor;
    private double classificacao;
    private String review;

    public Jogo() {
    }

    public double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdDistribuidora() {
        return idDistribuidora;
    }

    public void setIdDistribuidora(int idDistribuidora) {
        this.idDistribuidora = idDistribuidora;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdFaixaEtaria() {
        return idFaixaEtaria;
    }

    public void setIdFaixaEtaria(int idFaixaEtaria) {
        this.idFaixaEtaria = idFaixaEtaria;
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }
    
    public boolean validaCampos() {
        if (nome == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome do jogo inválido!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (idDistribuidora == 0) {
            JOptionPane.showMessageDialog(null, "Distribuidora do jogo inválida!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (idGenero == 0) {
            JOptionPane.showMessageDialog(null, "Gênero do jogo inválido!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (idFaixaEtaria == 0) {
            JOptionPane.showMessageDialog(null, "Faixa etária do jogo inválida!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (idDeposito == 0) {
            JOptionPane.showMessageDialog(null, "Depósito do jogo inválido!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (valor <= 0) {
            JOptionPane.showMessageDialog(null, "Valor do jogo inválido!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
