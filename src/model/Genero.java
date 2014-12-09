package model;

import javax.swing.JOptionPane;

public class Genero {
    private int id;
    private String descricao;

    public Genero() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean validaCampos() {
        if (descricao == null || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Descrição do gênero inválida!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
