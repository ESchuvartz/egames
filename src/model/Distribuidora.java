package model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Date converteData(String sData) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
        java.util.Date date;
        try {
            date = sdf1.parse(sData);
            java.sql.Date sqlStartDate = new Date(date.getTime()); 
            return sqlStartDate;
        } catch (ParseException ex) {
            Logger.getLogger(Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
