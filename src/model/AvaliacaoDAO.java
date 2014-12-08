package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AvaliacaoDAO {
    private Connection connection;

    public AvaliacaoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastraAvaliacao(Avaliacao avaliacao) {
        try {
            String sql = "INSERT INTO avaliacao (idjogo, data, nota, avaliador, observacao) values (?,?,?,?,?)";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setInt(1, avaliacao.getIdJogo());
                st.setDate(2, avaliacao.getData());
                st.setInt(3, avaliacao.getNota());
                st.setString(4, avaliacao.getAvaliador());
                st.setString(5, avaliacao.getObservacao());
                
                st.execute();
                st.close();
                
                JOptionPane.showMessageDialog(null, (avaliacao.getAvaliador() + ", sua avaliação foi registrada com sucesso!\nA E-Games agradece a sua colaboração!"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao registrar avaliação", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public double numeroAvaliacoes(int idJogo) {
        try {
            String sql = "SELECT COUNT(*) from avaliacao WHERE idjogo=?";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setInt(1, idJogo);
                
                try(ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao contar quantidade de avaliações", JOptionPane.ERROR_MESSAGE);
        }  
        
        return 0;
    } 
    
    public double notaAvaliacoes (int idJogo) {
        try {
            String sql = "SELECT SUM(nota) from avaliacao WHERE idjogo=?";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setInt(1, idJogo);
                
                try(ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao somar notas das avaliações", JOptionPane.ERROR_MESSAGE);
        }  
        
        return 0;
    }
    
    public ArrayList<Avaliacao> listaAvaliacaos(int idJogo) {
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM avaliacao WHERE idjogo=?";
            
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setInt(1, idJogo);
                
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Avaliacao avaliacao = new Avaliacao();
                        avaliacao.setId(rs.getInt("id"));
                        avaliacao.setIdJogo(rs.getInt("idjogo"));
                        avaliacao.setData(rs.getDate("data"));
                        avaliacao.setNota(rs.getInt("nota"));
                        avaliacao.setAvaliador(rs.getString("avaliador"));
                        avaliacao.setObservacao(rs.getString("observacao"));
                        avaliacoes.add(avaliacao);
                    }
                }
                
                return avaliacoes;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao listar avaliações", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Avaliacao posicionaAvaliacao (int id) {
        String sql = "SELECT * FROM avaliacao WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao.setId(rs.getInt("id"));
                    avaliacao.setIdJogo(rs.getInt("idjogo"));
                    avaliacao.setData(rs.getDate("data"));
                    avaliacao.setNota(rs.getInt("nota"));
                    avaliacao.setAvaliador(rs.getString("avaliador"));
                    avaliacao.setObservacao(rs.getString("observacao"));
                    return avaliacao;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar avaliação", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
}
