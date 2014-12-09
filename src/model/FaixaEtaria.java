package model;

import javax.swing.JOptionPane;

public class FaixaEtaria {
    private int id;
    private String descricao;

    public FaixaEtaria() {
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
            JOptionPane.showMessageDialog(null, "Descrição da faixa etária inválida!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
