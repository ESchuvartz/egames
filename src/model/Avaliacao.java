package model;

import java.sql.Date;
import javax.swing.JOptionPane;

public class Avaliacao {
    private int id;
    private int idJogo;
    private Date data;
    private int nota;
    private String avaliador;
    private String observacao;

    public Avaliacao() {
    }

    public String getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(String avaliador) {
        this.avaliador = avaliador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public boolean validaCampos() {
        if (avaliador == null || avaliador.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o nome do avaliador", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (data == null) {
            JOptionPane.showMessageDialog(null, "Informe uma data válida", "Erro ao validar campos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}
