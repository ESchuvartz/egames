package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Deposito;
import model.DepositoDAO;
import view.ListaDepositos;

public class ListaDepositosController implements ActionListener, MouseListener {
    private ListaDepositos listaDepositos = null;
    private Deposito deposito = null;
    private DepositoDAO depositoDAO = null;

    public ListaDepositos getListaDepositos() {
        return this.listaDepositos;
    }
    
    public ListaDepositosController(ListaDepositos view, Deposito model) {
        this.listaDepositos = view;
        this.deposito = model;
        this.depositoDAO = new DepositoDAO();
        
        this.listaDepositos.getjButtonPesquisar().addActionListener(this);
        this.listaDepositos.getjButtonSair().addActionListener(this);
        this.listaDepositos.getjTablePesquisa().addMouseListener(this);
    }
    
    //Função para listar os gêneros
    public void listaDepositos(String descricao) {
        ArrayList<Deposito> depositos = depositoDAO.listaDepositos(descricao);
        
        DefaultTableModel model = (DefaultTableModel) this.listaDepositos.getjTablePesquisa().getModel();
        
        for (Deposito deposito1 : depositos) {
            model.addRow(new Object[]{deposito1.getId(), deposito1.getDescricao()});
        }
    }
    
    //Função para limpar a view
    public void limpaView() {
        DefaultTableModel model = (DefaultTableModel) this.listaDepositos.getjTablePesquisa().getModel();
        while (model.getRowCount() > 0) model.removeRow(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pesquisar
        if (e.getSource() == this.listaDepositos.getjButtonPesquisar()) {
            limpaView();
            listaDepositos(this.listaDepositos.getjTextFieldDescricao().getText());
            
            //Limpa o JTextField após realizar a busca
            this.listaDepositos.getjTextFieldDescricao().setText("");
        }
        //Sair
        else if (e.getSource() == this.listaDepositos.getjButtonSair()) {
            this.listaDepositos.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        deposito.setId((int) this.listaDepositos.getjTablePesquisa().getValueAt(this.listaDepositos.getjTablePesquisa().getSelectedRow(), 0));
        this.listaDepositos.dispose();
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
