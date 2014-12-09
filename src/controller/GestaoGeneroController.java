package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import model.Genero;
import model.GeneroDAO;
import view.GestaoGeneros;
import view.ListaGeneros;

public class GestaoGeneroController implements ActionListener, WindowFocusListener {
    private GestaoGeneros gestaoGenero = null;
    private Genero genero = null;
    private GeneroDAO generoDAO = null;

    public GestaoGeneros getGestaoGenero() {
        return gestaoGenero;
    }
    
    public GestaoGeneroController (GestaoGeneros view, Genero model) {
        this.generoDAO = new GeneroDAO();
        this.genero = model;
        this.gestaoGenero = view;
        
        this.gestaoGenero.getjButtonAdicionar().addActionListener(this);
        this.gestaoGenero.getjButtonEditar().addActionListener(this);
        this.gestaoGenero.getjButtonExcluir().addActionListener(this);
        this.gestaoGenero.getjButtonPesquisar().addActionListener(this);
        this.gestaoGenero.getjButtonSair().addActionListener(this);
        this.gestaoGenero.addWindowFocusListener(this);
    }
    
    public void limpaView() {
        genero.setId(0);
        
        //Limpa os objetos
        this.gestaoGenero.getjTextFieldId().setText(null);
        this.gestaoGenero.getjTextFieldDescricao().setText(null);
        
        //Restaura os botões
        this.gestaoGenero.getjButtonAdicionar().setEnabled(true);
        this.gestaoGenero.getjButtonEditar().setEnabled(false);
        this.gestaoGenero.getjButtonExcluir().setEnabled(false);
    }
    
    public void exibeCadastro(int id) {
        genero.setId(id);
        genero = generoDAO.posicionaGenero(id);
        
        this.gestaoGenero.getjTextFieldId().setText("" + genero.getId());
        this.gestaoGenero.getjTextFieldDescricao().setText(genero.getDescricao());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Adicionar
        if (e.getSource() == this.gestaoGenero.getjButtonAdicionar()) {
            genero.setDescricao(this.gestaoGenero.getjTextFieldDescricao().getText());
            
            if (genero.validaCampos()) {
                //Chama a função para cadastrar o gênero
                generoDAO.cadastraGenero(genero);

                //Chama a função para limpar a view
                limpaView();
            }
        }
        //Editar
        else if (e.getSource() == this.gestaoGenero.getjButtonEditar()) {
            genero.setId(Integer.parseInt(this.gestaoGenero.getjTextFieldId().getText()));
            genero.setDescricao(this.gestaoGenero.getjTextFieldDescricao().getText());
            
            if (genero.validaCampos()) {
                //Chama a função para editar o gênero
                generoDAO.editaGenero(genero);

                //Chama a função para limpar a view
                limpaView();
            }
        }
        //Excluir
        else if (e.getSource() == this.gestaoGenero.getjButtonExcluir()) {
            genero.setId(Integer.parseInt(this.gestaoGenero.getjTextFieldId().getText()));
            
            //Chama a função para excluir o gênero
            generoDAO.excluiGenero(genero);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Pesquisar
        else if (e.getSource() == this.gestaoGenero.getjButtonPesquisar()) {
            limpaView();
            ListaGeneros viewListaGeneros = new ListaGeneros(gestaoGenero, true);
            ListaGenerosController controllerListaGeneros = new ListaGenerosController(viewListaGeneros, genero);
            
            controllerListaGeneros.getListaGeneros().setVisible(true);
        }
        //Sair
        else if (e.getSource() == this.gestaoGenero.getjButtonSair()) {
            this.gestaoGenero.dispose();
        }
    }

    @Override
    public void windowGainedFocus(WindowEvent we) {
        if (genero.getId() > 0 && gestaoGenero.getjTextFieldId().getText().isEmpty()) {
            //Ajusta o status dos botões
            gestaoGenero.getjButtonAdicionar().setEnabled(false);
            gestaoGenero.getjButtonEditar().setEnabled(true);
            gestaoGenero.getjButtonExcluir().setEnabled(true);
            
            //Chama a função para exibir o cadastro
            exibeCadastro(genero.getId());
        }
    }

    @Override
    public void windowLostFocus(WindowEvent we) {
    }
}
