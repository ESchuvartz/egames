package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JogoImagemDAO {
    private Connection connection;

    public JogoImagemDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    public void cadastrarJogoImagem (JogoImagem jogoImagem) {
        String sql = "INSERT INTO jogoimagem (idjogo, imagem) VALUES (?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, jogoImagem.getIdJogo());
            st.setString(2, jogoImagem.getImagem());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Imagem inclusa no cadastro do jogo com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao inserir imagem para o jogo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void excluiJogoImagem (JogoImagem jogoImagem) {
        String sql = "DELETE FROM jogoimagem WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, jogoImagem.getIdJogo());
            
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, ("Imagem deletada do cadastro do jogo com sucesso!"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao deletar imagem do jogo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<JogoImagem> listaJogoImagens(int id) {
        ArrayList<JogoImagem> jogoImagens = new ArrayList<>();
        
        try {
            String sql =  "SELECT * FROM jogoimagem where idjogo = ?";
                
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        JogoImagem jogoImagem = new JogoImagem();
                        jogoImagem.setSequencia(rs.getInt("seq"));
                        jogoImagem.setIdJogo(rs.getInt("idjogo"));
                        jogoImagem.setImagem(rs.getString("imagem"));
                        jogoImagens.add(jogoImagem);
                    }
                }
                
                return jogoImagens;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao listar imagens do jogo", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
