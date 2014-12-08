package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.FaixaEtaria;
import model.FaixaEtariaDAO;
import view.ListaFaixasEtarias;

public class ListaFaixasEtariasController implements ActionListener, MouseListener {
    private ListaFaixasEtarias listaFaixasEtarias = null;
    private FaixaEtaria faixaEtaria = null;
    private FaixaEtariaDAO faixaEtariaDAO = null;

    public ListaFaixasEtarias getListaFaixaEtarias() {
        return this.listaFaixasEtarias;
    }
    
    public ListaFaixasEtariasController(ListaFaixasEtarias view, FaixaEtaria model) {
        this.listaFaixasEtarias = view;
        this.faixaEtaria = model;
        this.faixaEtariaDAO = new FaixaEtariaDAO();
        
        this.listaFaixasEtarias.getjButtonPesquisar().addActionListener(this);
        this.listaFaixasEtarias.getjButtonSair().addActionListener(this);
        this.listaFaixasEtarias.getjTablePesquisa().addMouseListener(this);
    }
    
    //Função para listar as faixas etárias
    public void listaFaixasEtarias(String descricao) {
        ArrayList<FaixaEtaria> faixaEtarias = faixaEtariaDAO.listaFaixaEtarias(descricao);
        
        DefaultTableModel model = (DefaultTableModel) this.listaFaixasEtarias.getjTablePesquisa().getModel();
        
        for (FaixaEtaria faixaEtaria1 : faixaEtarias) {
            model.addRow(new Object[]{faixaEtaria1.getId(), faixaEtaria1.getDescricao()});
        }
    }
    
    //Função para limpar a view
    public void limpaView() {
        DefaultTableModel model = (DefaultTableModel) this.listaFaixasEtarias.getjTablePesquisa().getModel();
        while (model.getRowCount() > 0) model.removeRow(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pesquisar
        if (e.getSource() == this.listaFaixasEtarias.getjButtonPesquisar()) {
            limpaView();
            listaFaixasEtarias(this.listaFaixasEtarias.getjTextFieldDescricao().getText());
            
            //Limpa o JTextField após realizar a busca
            this.listaFaixasEtarias.getjTextFieldDescricao().setText("");
        }
        //Sair
        else if (e.getSource() == this.listaFaixasEtarias.getjButtonSair()) {
            this.listaFaixasEtarias.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        faixaEtaria.setId((int) this.listaFaixasEtarias.getjTablePesquisa().getValueAt(this.listaFaixasEtarias.getjTablePesquisa().getSelectedRow(), 0));
        this.listaFaixasEtarias.dispose();
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
