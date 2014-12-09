package model;

import javax.swing.JOptionPane;

public class JogoDep {
    private int id;
    private int idJogo;
    private int idDeposito;
    private int quantidade;

    public JogoDep() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }
    
    public boolean validaCampos() {
        if (idJogo == 0) {
            JOptionPane.showMessageDialog(null, "Jogo inválido!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (idDeposito == 0) {
            JOptionPane.showMessageDialog(null, "Depósito inválido", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (quantidade < 0) {
            JOptionPane.showMessageDialog(null, "A quantidade deve ser maior ou igual a zero!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
