package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import model.Deposito;
import model.DepositoDAO;
import view.GestaoDepositos;
import view.ListaDepositos;

public class GestaoDepositoController implements ActionListener, WindowFocusListener {
    private GestaoDepositos gestaoDeposito = null;
    private Deposito deposito = null;
    private DepositoDAO depositoDAO = null;

    public GestaoDepositos getGestaoDeposito() {
        return gestaoDeposito;
    }
    
    public GestaoDepositoController (GestaoDepositos view, Deposito model) {
        this.depositoDAO = new DepositoDAO();
        this.deposito = model;
        this.gestaoDeposito = view;
        
        this.gestaoDeposito.getjButtonAdicionar().addActionListener(this);
        this.gestaoDeposito.getjButtonEditar().addActionListener(this);
        this.gestaoDeposito.getjButtonExcluir().addActionListener(this);
        this.gestaoDeposito.getjButtonPesquisar().addActionListener(this);
        this.gestaoDeposito.getjButtonSair().addActionListener(this);
        this.gestaoDeposito.addWindowFocusListener(this);
    }
    
    public void limpaView() {
        deposito.setId(0);
        
        //Limpa os objetos
        this.gestaoDeposito.getjTextFieldId().setText(null);
        this.gestaoDeposito.getjTextFieldDescricao().setText(null);
        
        //Restaura os botões
        this.gestaoDeposito.getjButtonAdicionar().setEnabled(true);
        this.gestaoDeposito.getjButtonEditar().setEnabled(false);
        this.gestaoDeposito.getjButtonExcluir().setEnabled(false);
    }
    
    public void exibeCadastro(int id) {
        deposito.setId(id);
        deposito = depositoDAO.posicionaDeposito(id);
        
        this.gestaoDeposito.getjTextFieldId().setText("" + deposito.getId());
        this.gestaoDeposito.getjTextFieldDescricao().setText(deposito.getDescricao());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Adicionar
        if (e.getSource() == this.gestaoDeposito.getjButtonAdicionar()) {
            deposito.setDescricao(this.gestaoDeposito.getjTextFieldDescricao().getText());
            
            
            if (deposito.validaCampos()) {
                //Chama a função para cadastrar o depósito
                depositoDAO.cadastraDeposito(deposito);

                //Chama a função para limpar a view
                limpaView();
            }
        }
        //Editar
        else if (e.getSource() == this.gestaoDeposito.getjButtonEditar()) {
            deposito.setId(Integer.parseInt(this.gestaoDeposito.getjTextFieldId().getText()));
            deposito.setDescricao(this.gestaoDeposito.getjTextFieldDescricao().getText());
            
            if (deposito.validaCampos()) {
                //Chama a função para editar o depósito
                depositoDAO.editaDeposito(deposito);

                //Chama a função para limpar a view
                limpaView();
            }
        }
        //Excluir
        else if (e.getSource() == this.gestaoDeposito.getjButtonExcluir()) {
            deposito.setId(Integer.parseInt(this.gestaoDeposito.getjTextFieldId().getText()));
            
            //Chama a função para excluir o depósito
            depositoDAO.excluiDeposito(deposito);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Pesquisar
        else if (e.getSource() == this.gestaoDeposito.getjButtonPesquisar()) {
            limpaView();
            ListaDepositos viewListaDepositos = new ListaDepositos(gestaoDeposito, true);
            ListaDepositosController controllerListaDepositos = new ListaDepositosController(viewListaDepositos, deposito);
            
            controllerListaDepositos.getListaDepositos().setVisible(true);
        }
        //Sair
        else if (e.getSource() == this.gestaoDeposito.getjButtonSair()) {
            this.gestaoDeposito.dispose();
        }
    }

    @Override
    public void windowGainedFocus(WindowEvent we) {
        if (deposito.getId() > 0 && gestaoDeposito.getjTextFieldId().getText().isEmpty()) {
            //Ajusta o status dos botões
            gestaoDeposito.getjButtonAdicionar().setEnabled(false);
            gestaoDeposito.getjButtonEditar().setEnabled(true);
            gestaoDeposito.getjButtonExcluir().setEnabled(true);
            
            //Chama a função para exibir o cadastro
            exibeCadastro(deposito.getId());
        }
    }

    @Override
    public void windowLostFocus(WindowEvent we) {
    }
}
