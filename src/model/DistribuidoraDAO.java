package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DistribuidoraDAO {
    private Connection connection;

    public DistribuidoraDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastraDistribuidora (Distribuidora distribuidora) {
        try {
            String sql = "INSERT INTO distribuidora (nome, fundacao, imagem) VALUES (?, ?, ?)";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setString(1, distribuidora.getNome());
                st.setDate(2, distribuidora.getFundacao());
                st.setString(3, distribuidora.getImagem());
                
                st.execute();
                st.close();
                
                JOptionPane.showMessageDialog(null, ("Distribuidora " + distribuidora.getNome() + " cadastrada com sucesso!"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao efetuar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarDistribuidora (Distribuidora distribuidora) {
        try {
            String sql = "UPDATE distribuidora SET nome=?, fundacao=?, imagem=? WHERE id=?";
            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setString(1, distribuidora.getNome());
                st.setDate(2, distribuidora.getFundacao());
                st.setString(3, distribuidora.getImagem());
                st.setInt(4, distribuidora.getId());
                
                st.execute();
                st.close();
                
                JOptionPane.showMessageDialog(null, ("Distribuidora " + distribuidora.getNome() + " editada com sucesso!"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluirDistribuidora (Distribuidora distribuidora) {
        try {
            String sql = "DELETE FROM distribuidora WHERE id=?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, distribuidora.getId());
                
                stmt.execute();
                JOptionPane.showMessageDialog(null, "Cadastro da distribuidora excluído com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao excluir cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Distribuidora> listaDistribuidoras(String nome) {
        ArrayList<Distribuidora> distribuidoras = new ArrayList<>();
        
        try {
            String sql = "";
            if (!nome.trim().isEmpty()) sql = "SELECT * FROM distribuidora USE INDEX (INDEX_1) WHERE nome like ?";
            else sql = "SELECT * FROM distribuidora USE INDEX (INDEX_2) WHERE nome like ?";
            
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, "%" + nome + "%");
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Distribuidora distribuidora = new Distribuidora();
                        distribuidora.setId(Integer.parseInt(rs.getString("id")));
                        distribuidora.setNome(rs.getString("nome"));
                        distribuidora.setFundacao(rs.getDate("fundacao"));
                        distribuidoras.add(distribuidora);
                    }
                }
                
                return distribuidoras;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao listar distribuidoras", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Distribuidora posicionaDistribuidora (int id) {
        String sql = "SELECT * FROM distribuidora WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Distribuidora distribuidora = new Distribuidora();
                    distribuidora.setId(Integer.parseInt(rs.getString("id")));
                    distribuidora.setNome(rs.getString("nome"));
                    distribuidora.setFundacao(Date.valueOf(rs.getString("fundacao")));
                    distribuidora.setImagem(rs.getString("imagem"));
                    return distribuidora;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar distribuidora", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
    public Distribuidora posicionaDistribuidoraNome (String nome) {
        String sql = "SELECT * FROM distribuidora USE INDEX (INDEX_1) WHERE nome like ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome + "%");
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Distribuidora distribuidora = new Distribuidora();
                    distribuidora.setId(Integer.parseInt(rs.getString("id")));
                    distribuidora.setNome(rs.getString("nome"));
                    distribuidora.setFundacao(Date.valueOf(rs.getString("fundacao")));
                    distribuidora.setImagem(rs.getString("imagem"));
                    return distribuidora;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar distribuidora por nome", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
}
