package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Distribuidora;
import model.DistribuidoraDAO;
import model.Utilities;
import view.ListaDistribuidoras;

public class ListaDistribuidorasController implements ActionListener, MouseListener {
    private ListaDistribuidoras listaDistribuidoras = null;
    private Utilities utilities = null;
    private Distribuidora distribuidora = null;
    private DistribuidoraDAO distribuidoraDAO = null;
    
    public ListaDistribuidoras getListaDistribuidoras() {
        return this.listaDistribuidoras;
    }
    
    public ListaDistribuidorasController (ListaDistribuidoras view, Distribuidora model) {
        this.listaDistribuidoras = view;
        this.distribuidora = model;
        this.distribuidoraDAO = new DistribuidoraDAO();
        this.utilities = new Utilities();
        
        this.listaDistribuidoras.getjButtonPesquisar().addActionListener(this);
        this.listaDistribuidoras.getjButtonSair().addActionListener(this);
        this.listaDistribuidoras.getjTableDistribuidoras().addMouseListener(this);
    }
    
    //Função para listar as distribuidoras
    public void listaDistribuidoras(String nome) {
        ArrayList<Distribuidora> distribuidoras = distribuidoraDAO.listaDistribuidoras(nome);
        
        DefaultTableModel model = (DefaultTableModel) this.listaDistribuidoras.getjTableDistribuidoras().getModel();
        
        for (Distribuidora distribuidora1 : distribuidoras) {
            model.addRow(new Object[]{distribuidora1.getId(), distribuidora1.getNome(), utilities.ajustaData(distribuidora1.getFundacao())});
        }
    }
    
    //Função para limpar a view
    public void limpaView() {
        DefaultTableModel model = (DefaultTableModel) this.listaDistribuidoras.getjTableDistribuidoras().getModel();
        while (model.getRowCount() > 0) model.removeRow(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pesquisar
        if (e.getSource() == this.listaDistribuidoras.getjButtonPesquisar()) {
            limpaView();
            listaDistribuidoras(this.listaDistribuidoras.getjTextFieldNomeBusca().getText());
            
            //Limpa o JTextField após realizar a busca
            this.listaDistribuidoras.getjTextFieldNomeBusca().setText("");
        }
        //Sair
        else if (e.getSource() == this.listaDistribuidoras.getjButtonSair()) {
            this.listaDistribuidoras.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        distribuidora.setId((int) this.listaDistribuidoras.getjTableDistribuidoras().getValueAt(this.listaDistribuidoras.getjTableDistribuidoras().getSelectedRow(), 0));
        this.listaDistribuidoras.dispose();
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
