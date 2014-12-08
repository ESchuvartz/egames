package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JogoDepDAO {
    private Connection connection;

    public JogoDepDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastraJogoDeposito (JogoDep jogoDep) {
        String sql = "INSERT INTO jogodep (idjogo, iddep, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, jogoDep.getIdJogo());
            st.setInt(2, jogoDep.getIdDeposito());
            st.setInt(3, 0);
            
            st.execute();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao criar depósito para o jogo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluiDepositoJogo (JogoDep jogoDep) {
        String sql = "DELETE FROM jogodep WHERE idjogo = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, jogoDep.getIdJogo());
            st.execute();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao excluir depósito do jogo", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    public void movimentaJogoDeposito (JogoDep jogoDep) {
        String sql = "UPDATE jogodep SET quantidade=? WHERE idjogo=? and iddep=?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, jogoDep.getQuantidade());
            st.setInt(2, jogoDep.getIdJogo());
            st.setInt(3, jogoDep.getIdDeposito());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Movimentação realizada com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao realizar movimentação", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public JogoDep buscaEstoqueJogo (int idJogo, int idDeposito) {
        String sql = "SELECT * FROM jogodep WHERE idjogo=? and iddep=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idJogo);
            st.setInt(2, idDeposito);
            
            try(ResultSet rs = st.executeQuery()) {
                JogoDep jogoDep = new JogoDep();
                
                if (rs.next()) {
                    jogoDep.setId(rs.getInt("id"));
                    jogoDep.setIdJogo(rs.getInt("idjogo"));
                    jogoDep.setIdDeposito(rs.getInt("iddep"));
                    jogoDep.setQuantidade(rs.getInt("quantidade"));
                    
                } else {
                    jogoDep.setId(0);
                }
                
                return jogoDep;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao buscar depósito do jogo", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
}
