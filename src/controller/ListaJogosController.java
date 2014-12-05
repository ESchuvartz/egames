package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Jogo;
import model.JogoDAO;
import view.ListaJogos;

public class ListaJogosController implements ActionListener, MouseListener {
    private ListaJogos listaJogos = null;
    private Jogo jogo = null;
    private JogoDAO jogoDAO = null;

    public ListaJogos getListaJogos() {
        return this.listaJogos;
    }
    
    public ListaJogosController(ListaJogos view, Jogo model) {
        this.listaJogos = view;
        this.jogo = model;
        this.jogoDAO = new JogoDAO();
        
        this.listaJogos.getjButtonPesquisar().addActionListener(this);
        this.listaJogos.getjButtonSair().addActionListener(this);
        this.listaJogos.getjTablePesquisa().addMouseListener(this);
    }
    
    //Função para listar os jogos
    public void listaJogos(String nome) {
        ArrayList<Jogo> jogos = jogoDAO.listaJogos(nome);
        
        DefaultTableModel model = (DefaultTableModel) this.listaJogos.getjTablePesquisa().getModel();
        
        this.listaJogos.getjTablePesquisa().getColumnModel().getColumn(1).setPreferredWidth(500);
        
        for (Jogo jogo1 : jogos) {
            model.addRow(new Object[]{jogo1.getId(), jogo1.getNome(), String.valueOf(jogo1.getValor()).replace(".", ",")});
        }
    }
    
    //Função para limpar a view
    public void limpaView() {
        DefaultTableModel model = (DefaultTableModel) this.listaJogos.getjTablePesquisa().getModel();
        while (model.getRowCount() > 0) model.removeRow(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pesquisar
        if (e.getSource() == this.listaJogos.getjButtonPesquisar()) {
            limpaView();
            listaJogos(this.listaJogos.getjTextFieldNome().getText());
            
            //Limpa o JTextField após realizar a busca
            this.listaJogos.getjTextFieldNome().setText("");
        }
        //Sair
        else if (e.getSource() == this.listaJogos.getjButtonSair()) {
            this.listaJogos.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        jogo.setId((int) this.listaJogos.getjTablePesquisa().getValueAt(this.listaJogos.getjTablePesquisa().getSelectedRow(), 0));
        this.listaJogos.dispose();
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