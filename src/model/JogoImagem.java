package model;

import javax.swing.JOptionPane;

public class JogoImagem {
    private int sequencia;
    private int idJogo;
    private String imagem;

    public JogoImagem() {
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public boolean validaCampos() {
        if (idJogo == 0) {
            JOptionPane.showMessageDialog(null, "Jogo inválido!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (imagem == null || imagem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Imagem inválida!", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
