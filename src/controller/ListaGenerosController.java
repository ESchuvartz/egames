package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Genero;
import model.GeneroDAO;
import view.ListaGeneros;

public class ListaGenerosController implements ActionListener, MouseListener {
    private ListaGeneros listaGeneros = null;
    private Genero genero = null;
    private GeneroDAO generoDAO = null;

    public ListaGeneros getListaGeneros() {
        return this.listaGeneros;
    }
    
    public ListaGenerosController(ListaGeneros view, Genero model) {
        this.listaGeneros = view;
        this.genero = model;
        this.generoDAO = new GeneroDAO();
        
        this.listaGeneros.getjButtonPesquisar().addActionListener(this);
        this.listaGeneros.getjButtonSair().addActionListener(this);
        this.listaGeneros.getjTablePesquisa().addMouseListener(this);
    }
    
    //Função para listar os gêneros
    public void listaGeneros(String descricao) {
        ArrayList<Genero> generos = generoDAO.listaGeneros(descricao);
        
        DefaultTableModel model = (DefaultTableModel) this.listaGeneros.getjTablePesquisa().getModel();
        
        for (Genero genero1 : generos) {
            model.addRow(new Object[]{genero1.getId(), genero1.getDescricao()});
        }
    }
    
    //Função para limpar a view
    public void limpaView() {
        DefaultTableModel model = (DefaultTableModel) this.listaGeneros.getjTablePesquisa().getModel();
        while (model.getRowCount() > 0) model.removeRow(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pesquisar
        if (e.getSource() == this.listaGeneros.getjButtonPesquisar()) {
            limpaView();
            listaGeneros(this.listaGeneros.getjTextFieldDescricao().getText());
            
            //Limpa o JTextField após realizar a busca
            this.listaGeneros.getjTextFieldDescricao().setText("");
        }
        //Sair
        else if (e.getSource() == this.listaGeneros.getjButtonSair()) {
            this.listaGeneros.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        genero.setId((int) this.listaGeneros.getjTablePesquisa().getValueAt(this.listaGeneros.getjTablePesquisa().getSelectedRow(), 0));
        this.listaGeneros.dispose();
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
