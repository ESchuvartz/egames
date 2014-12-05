package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import model.Distribuidora;
import model.DistribuidoraDAO;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import view.GestaoDistribuidoras;

public class GestaoDistribuidoraController implements ActionListener {
    private GestaoDistribuidoras gestaoDistribuidoras = null;
    private Distribuidora distribuidora = null;
    private DistribuidoraDAO distribuidoraDAO = null;
    
    public GestaoDistribuidoras getGestaoDistribuidoras() {
        return this.gestaoDistribuidoras;
    }
    
    public GestaoDistribuidoraController (GestaoDistribuidoras view, Distribuidora model) {
        this.distribuidoraDAO = new DistribuidoraDAO();
        this.gestaoDistribuidoras = view;
        this.distribuidora = model;
        
        this.gestaoDistribuidoras.getjButtonSair().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonEscolher().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonAdicionar().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonEditar().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Adicionar
        if (e.getSource() == this.gestaoDistribuidoras.getjButtonAdicionar()) {
            distribuidora.setNome(this.gestaoDistribuidoras.getjTextFieldNome().getText());
            distribuidora.setFundacao(distribuidora.converteData(this.gestaoDistribuidoras.getjFormattedTextFieldFundacao().getText()));
            distribuidora.setImagem(this.gestaoDistribuidoras.getjTextFieldImagem().getText());
            
            //Chama a função para adicionar a distribuidora
            distribuidoraDAO.cadastraDistribuidora(distribuidora);
        }
        //Editar
        else if (e.getSource() == this.gestaoDistribuidoras.getjButtonEditar()) {
            
        }
        //Excluir
        else if (e.getSource() == this.getGestaoDistribuidoras().getjButtonExcluir()) {
            
        }
        //Escolher
        else if (e.getSource() == this.getGestaoDistribuidoras().getjButtonEscolher()) {
            
        }
        //Sair
        else if (e.getSource() == this.getGestaoDistribuidoras().getjButtonSair()) {
            this.gestaoDistribuidoras.dispose();
        }
    }
}
