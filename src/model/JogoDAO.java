package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JogoDAO {
    private Connection connection;
    
    public JogoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastraJogo (Jogo jogo) {
        String sql = "INSERT INTO Jogo (nome, iddistribuidora, idgenero, idfaixaetaria, iddeposito, valor, classificacao, review) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, jogo.getNome());
            st.setInt(2, jogo.getIdDistribuidora());
            st.setInt(3, jogo.getIdGenero());
            st.setInt(4, jogo.getIdFaixaEtaria());
            st.setInt(5, jogo.getIdDeposito());
            st.setDouble(6, jogo.getValor());
            st.setDouble(7, jogo.getClassificacao());
            st.setString(8, jogo.getReview());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Jogo " + jogo.getNome() + " cadastrado com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao efetuar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editaJogo (Jogo jogo) {
        String sql = "UPDATE Jogo SET nome=?, iddistribuidora=?, idgenero=?, idfaixaetaria=?, iddeposito=?, valor=?, classificacao=?, review=? WHERE id=?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, jogo.getNome());
            st.setInt(2, jogo.getIdDistribuidora());
            st.setInt(3, jogo.getIdGenero());
            st.setInt(4, jogo.getIdFaixaEtaria());
            st.setInt(5, jogo.getIdDeposito());
            st.setDouble(6, jogo.getValor());
            st.setDouble(7, jogo.getClassificacao());
            st.setString(8, jogo.getReview());
            st.setInt(9, jogo.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Jogo " + jogo.getNome() + " editado com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluiJogo (Jogo jogo) {
        String sql = "DELETE from Jogo WHERE id = ?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, jogo.getId());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Cadastro do jogo excluído com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao editar cadastro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Jogo> listaJogos(String nome) {
        ArrayList<Jogo> jogos = new ArrayList<>();
        
        try {
            String sql = "";
            
            if (!nome.trim().isEmpty()) sql = "SELECT * FROM Jogo USE INDEX (INDEX_1) WHERE nome like ?";
            else sql =  "SELECT * FROM Jogo USE INDEX (INDEX_2) WHERE nome like ?";
                
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, "%" + nome + "%");
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Jogo jogo = new Jogo();
                        jogo.setId(Integer.parseInt(rs.getString("id")));
                        jogo.setNome(rs.getString("nome"));
                        jogo.setIdDistribuidora(Integer.parseInt(rs.getString("iddistribuidora")));
                        jogo.setIdGenero(Integer.parseInt(rs.getString("idgenero")));
                        jogo.setIdFaixaEtaria(Integer.parseInt(rs.getString("idfaixaetaria")));
                        jogo.setIdDeposito(Integer.parseInt(rs.getString("iddeposito")));
                        jogo.setValor(Double.parseDouble(rs.getString("valor")));
                        jogo.setClassificacao(Double.parseDouble(rs.getString("classificacao")));
                        jogo.setReview(rs.getString("review"));
                        jogos.add(jogo);
                    }
                }
                
                return jogos;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao listar jogos", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public Jogo posicionaJogo (int id) {
        String sql = "SELECT * FROM Jogo USE INDEX (INDEX_2) WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Jogo jogo = new Jogo();
                    jogo.setId(Integer.parseInt(rs.getString("id")));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setIdDistribuidora(Integer.parseInt(rs.getString("iddistribuidora")));
                    jogo.setIdGenero(Integer.parseInt(rs.getString("idgenero")));
                    jogo.setIdFaixaEtaria(Integer.parseInt(rs.getString("idfaixaetaria")));
                    jogo.setIdDeposito(Integer.parseInt(rs.getString("iddeposito")));
                    jogo.setValor(Double.parseDouble(rs.getString("valor")));
                    jogo.setClassificacao(Double.parseDouble(rs.getString("classificacao")));
                    jogo.setReview(rs.getString("review"));
                    return jogo;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar jogo", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
    public Jogo posicionaJogoNome (String nome) {
        String sql = "SELECT * FROM Jogo USE INDEX (INDEX_1) WHERE nome like ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome + "%");
            
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Jogo jogo = new Jogo();
                    jogo.setId(Integer.parseInt(rs.getString("id")));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setIdDistribuidora(Integer.parseInt(rs.getString("iddistribuidora")));
                    jogo.setIdGenero(Integer.parseInt(rs.getString("idgenero")));
                    jogo.setIdFaixaEtaria(Integer.parseInt(rs.getString("idfaixaetaria")));
                    jogo.setIdDeposito(Integer.parseInt(rs.getString("iddeposito")));
                    jogo.setValor(Double.parseDouble(rs.getString("valor")));
                    jogo.setClassificacao(Double.parseDouble(rs.getString("classificacao")));
                    jogo.setReview(rs.getString("review"));
                    return jogo;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao posicionar jogo por nome", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
}
