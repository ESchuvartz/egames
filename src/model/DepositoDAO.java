package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DepositoDAO {
    private Connection connection;

    public DepositoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastraDeposito (Deposito deposito) {
        String sql = "INSERT INTO deposito (descricao) VALUES (?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, deposito.getDescricao());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Depósito " + deposito.getDescricao()+ " cadastrado com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao efetuar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editaDeposito (Deposito deposito) {
        String sql = "UPDATE deposito SET descricao=? WHERE id=?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, deposito.getDescricao());
            st.setInt(2, deposito.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Depósito " + deposito.getDescricao()+ " editado com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluiDeposito (Deposito deposito) {
        String sql = "DELETE from deposito WHERE id = ?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, deposito.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Cadastro do depósito excluído com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao excluir cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Deposito> listaDepositos(String descricao) {
        ArrayList<Deposito> depositos = new ArrayList<>();
        
        try {
            String sql = "";
            
            if (!descricao.trim().isEmpty()) sql = "SELECT * FROM deposito USE INDEX (INDEX_1) WHERE descricao like ?";
            else sql =  "SELECT * FROM deposito USE INDEX (INDEX_2) WHERE descricao like ?";
                
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, "%" + descricao + "%");
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Deposito deposito = new Deposito();
                        deposito.setId(Integer.parseInt(rs.getString("id")));
                        deposito.setDescricao(rs.getString("descricao"));
                        depositos.add(deposito);
                    }
                }
                
                return depositos;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao listar depósitos", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Deposito posicionaDeposito (int id) {
        String sql = "SELECT * FROM deposito WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Deposito deposito = new Deposito();
                    deposito.setId(Integer.parseInt(rs.getString("id")));
                    deposito.setDescricao(rs.getString("descricao"));
                    return deposito;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar depósito", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
        public Deposito posicionaDepositoDescricao (String descricao) {
        String sql = "SELECT * FROM deposito USE INDEX (INDEX_1) WHERE descricao like ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, descricao + "%");
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Deposito deposito = new Deposito();
                    deposito.setId(Integer.parseInt(rs.getString("id")));
                    deposito.setDescricao(rs.getString("descricao"));
                    return deposito;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar depósito por nome", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
}

