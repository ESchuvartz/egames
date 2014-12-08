package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import model.FaixaEtaria;
import model.FaixaEtariaDAO;
import view.GestaoFaixasEtarias;
import view.ListaFaixasEtarias;

public class GestaoFaixaEtariaController implements ActionListener, WindowFocusListener {
    private GestaoFaixasEtarias gestaoFaixaEtaria = null;
    private FaixaEtaria faixaEtaria = null;
    private FaixaEtariaDAO faixaEtariaDAO = null;

    public GestaoFaixasEtarias getGestaoFaixaEtaria() {
        return gestaoFaixaEtaria;
    }
    
    public GestaoFaixaEtariaController (GestaoFaixasEtarias view, FaixaEtaria model) {
        this.faixaEtariaDAO = new FaixaEtariaDAO();
        this.faixaEtaria = model;
        this.gestaoFaixaEtaria = view;
        
        this.gestaoFaixaEtaria.getjButtonAdicionar().addActionListener(this);
        this.gestaoFaixaEtaria.getjButtonEditar().addActionListener(this);
        this.gestaoFaixaEtaria.getjButtonExcluir().addActionListener(this);
        this.gestaoFaixaEtaria.getjButtonPesquisar().addActionListener(this);
        this.gestaoFaixaEtaria.getjButtonSair().addActionListener(this);
        this.gestaoFaixaEtaria.addWindowFocusListener(this);
    }
    
    public void limpaView() {
        faixaEtaria.setId(0);
        
        //Limpa os objetos
        this.gestaoFaixaEtaria.getjTextFieldId().setText(null);
        this.gestaoFaixaEtaria.getjTextFieldDescricao().setText(null);
        
        //Restaura os botões
        this.gestaoFaixaEtaria.getjButtonAdicionar().setEnabled(true);
        this.gestaoFaixaEtaria.getjButtonEditar().setEnabled(false);
        this.gestaoFaixaEtaria.getjButtonExcluir().setEnabled(false);
    }
    
    public void exibeCadastro(int id) {
        faixaEtaria.setId(id);
        faixaEtaria = faixaEtariaDAO.posicionaFaixaEtaria(id);
        
        this.gestaoFaixaEtaria.getjTextFieldId().setText("" + faixaEtaria.getId());
        this.gestaoFaixaEtaria.getjTextFieldDescricao().setText(faixaEtaria.getDescricao());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Adicionar
        if (e.getSource() == this.gestaoFaixaEtaria.getjButtonAdicionar()) {
            faixaEtaria.setDescricao(this.gestaoFaixaEtaria.getjTextFieldDescricao().getText());
            
            //Chama a função para cadastrar a faixa etária
            faixaEtariaDAO.cadastraFaixaEtaria(faixaEtaria);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Editar
        else if (e.getSource() == this.gestaoFaixaEtaria.getjButtonEditar()) {
            faixaEtaria.setId(Integer.parseInt(this.gestaoFaixaEtaria.getjTextFieldId().getText()));
            faixaEtaria.setDescricao(this.gestaoFaixaEtaria.getjTextFieldDescricao().getText());
            
            //Chama a função para editar a faixa etária
            faixaEtariaDAO.editaFaixaEtaria(faixaEtaria);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Excluir
        else if (e.getSource() == this.gestaoFaixaEtaria.getjButtonExcluir()) {
            faixaEtaria.setId(Integer.parseInt(this.gestaoFaixaEtaria.getjTextFieldId().getText()));
            
            //Chama a função para excluir a faixa etária
            faixaEtariaDAO.excluiFaixaEtaria(faixaEtaria);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Pesquisar
        else if (e.getSource() == this.gestaoFaixaEtaria.getjButtonPesquisar()) {
            limpaView();
            ListaFaixasEtarias viewListaFaixaEtarias = new ListaFaixasEtarias(gestaoFaixaEtaria, true);
            ListaFaixasEtariasController controllerListaFaixaEtarias = new ListaFaixasEtariasController(viewListaFaixaEtarias, faixaEtaria);
            
            controllerListaFaixaEtarias.getListaFaixaEtarias().setVisible(true);
        }
        //Sair
        else if (e.getSource() == this.gestaoFaixaEtaria.getjButtonSair()) {
            this.gestaoFaixaEtaria.dispose();
        }
    }

    @Override
    public void windowGainedFocus(WindowEvent we) {
        if (faixaEtaria.getId() > 0 && gestaoFaixaEtaria.getjTextFieldId().getText().isEmpty()) {
            //Ajusta o status dos botões
            gestaoFaixaEtaria.getjButtonAdicionar().setEnabled(false);
            gestaoFaixaEtaria.getjButtonEditar().setEnabled(true);
            gestaoFaixaEtaria.getjButtonExcluir().setEnabled(true);
            
            //Chama a função para exibir o cadastro
            exibeCadastro(faixaEtaria.getId());
        }
    }

    @Override
    public void windowLostFocus(WindowEvent we) {
    }
}
