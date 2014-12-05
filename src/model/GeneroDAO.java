package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GeneroDAO {
    private Connection connection;

    public GeneroDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastraGenero (Genero genero) {
        String sql = "INSERT INTO genero (descricao) VALUES (?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, genero.getDescricao());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Gênero " + genero.getDescricao()+ " cadastrado com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao efetuar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editaGenero (Genero genero) {
        String sql = "UPDATE genero SET descricao=? WHERE id=?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, genero.getDescricao());
            st.setInt(2, genero.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Gênero " + genero.getDescricao()+ " editado com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluiGenero (Genero genero) {
        String sql = "DELETE from genero WHERE id = ?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, genero.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Cadastro do gênero excluído com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao excluir cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Genero> listaGeneros(String descricao) {
        ArrayList<Genero> generos = new ArrayList<>();
        
        try {
            String sql = "";
            
            if (!descricao.trim().isEmpty()) sql = "SELECT * FROM genero USE INDEX (INDEX_1) WHERE descricao like ?";
            else sql =  "SELECT * FROM genero USE INDEX (INDEX_2) WHERE descricao like ?";
                
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, "%" + descricao + "%");
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Genero genero = new Genero();
                        genero.setId(Integer.parseInt(rs.getString("id")));
                        genero.setDescricao(rs.getString("descricao"));
                        generos.add(genero);
                    }
                }
                
                return generos;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao listar gêneros", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Genero posicionaGenero (int id) {
        String sql = "SELECT * FROM genero WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Genero genero = new Genero();
                    genero.setId(Integer.parseInt(rs.getString("id")));
                    genero.setDescricao(rs.getString("descricao"));
                    return genero;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar gênero", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
}
