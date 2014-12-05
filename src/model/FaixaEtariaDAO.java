package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FaixaEtariaDAO {
    private Connection connection;

    public FaixaEtariaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastraFaixaEtaria (FaixaEtaria faixaEtaria) {
        String sql = "INSERT INTO FaixaEtaria (descricao) VALUES (?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, faixaEtaria.getDescricao());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Faixa Etária " + faixaEtaria.getDescricao()+ " cadastrada com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao efetuar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editaFaixaEtaria (FaixaEtaria faixaEtaria) {
        String sql = "UPDATE FaixaEtaria SET descricao=? WHERE id=?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, faixaEtaria.getDescricao());
            st.setInt(2, faixaEtaria.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Faixa Etária " + faixaEtaria.getDescricao()+ " editada com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluiFaixaEtaria (FaixaEtaria faixaEtaria) {
        String sql = "DELETE from FaixaEtaria WHERE id = ?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, faixaEtaria.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Cadastro da faixa etária excluído com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<FaixaEtaria> listaFaixaEtarias(String descricao) {
        ArrayList<FaixaEtaria> faixaEtarias = new ArrayList<>();
        
        try {
            String sql = "";
            
            if (!descricao.trim().isEmpty()) sql = "SELECT * FROM faixaEtaria USE INDEX (INDEX_1) WHERE descricao like ?";
            else sql =  "SELECT * FROM faixaEtaria USE INDEX (INDEX_2) WHERE descricao like ?";
                
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, "%" + descricao + "%");
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        FaixaEtaria faixaEtaria = new FaixaEtaria();
                        faixaEtaria.setId(Integer.parseInt(rs.getString("id")));
                        faixaEtaria.setDescricao(rs.getString("descricao"));
                        faixaEtarias.add(faixaEtaria);
                    }
                }
                
                return faixaEtarias;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao listar faixas etárias", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public FaixaEtaria posicionaFaixaEtaria (int id) {
        String sql = "SELECT * FROM FaixaEtaria WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FaixaEtaria faixaEtaria = new FaixaEtaria();
                    faixaEtaria.setId(Integer.parseInt(rs.getString("id")));
                    faixaEtaria.setDescricao(rs.getString("descricao"));
                    return faixaEtaria;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar faixa etária", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
}
