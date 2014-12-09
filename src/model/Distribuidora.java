package model;

import java.sql.Date;
import javax.swing.JOptionPane;

public class Distribuidora {
    private int id;
    private String nome;
    private Date fundacao;
    private String imagem;

    public Distribuidora() {
    }

    public Date getFundacao() {
        return fundacao;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean validaCampos() {
        if (nome == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome da distribuidora inválido!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (fundacao == null) {
            JOptionPane.showMessageDialog(null, "Data de fundação da distribuidora inválida!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
