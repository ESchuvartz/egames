package model;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            }
        } catch (SQLException ex) {
            Logger.getLogger(DistribuidoraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
