package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import model.Deposito;
import model.DepositoDAO;
import model.Distribuidora;
import model.DistribuidoraDAO;
import model.FaixaEtaria;
import model.FaixaEtariaDAO;
import model.Genero;
import model.GeneroDAO;
import model.Jogo;
import model.JogoDAO;
import model.JogoDep;
import model.JogoDepDAO;
import view.GestaoJogos;
import view.GestaoJogosDeposito;
import view.GestaoJogosImagens;
import view.ListaGeneros;
import view.ListaJogos;

public class GestaoJogosController implements ActionListener, WindowListener, WindowFocusListener {
    private GestaoJogos gestaoJogos = null;
    private Jogo jogo = null;
    private JogoDAO jogoDAO = null;
    private Distribuidora distribuidora = null;
    private DistribuidoraDAO distribuidoraDAO = null;
    private Genero genero = null;
    private GeneroDAO generoDAO = null;
    private FaixaEtaria faixaEtaria = null;
    private FaixaEtariaDAO faixaEtariaDAO = null;
    private Deposito deposito = null;
    private DepositoDAO depositoDAO = null;
    private JogoDep jogoDep = null;
    private JogoDepDAO jogoDepDAO = null;

    public GestaoJogos getGestaoJogos() {
        return gestaoJogos;
    }

    public GestaoJogosController(GestaoJogos view, Jogo model) {
        this.jogoDAO = new JogoDAO();
        this.jogo = model;
        this.gestaoJogos = view;
        this.distribuidora = new Distribuidora();
        this.distribuidoraDAO = new DistribuidoraDAO();
        this.genero = new Genero();
        this.generoDAO = new GeneroDAO();
        this.faixaEtaria = new FaixaEtaria();
        this.faixaEtariaDAO = new FaixaEtariaDAO();
        this.deposito = new Deposito();
        this.depositoDAO = new DepositoDAO();
        this.jogoDepDAO = new JogoDepDAO();
        this.jogoDep = new JogoDep();
        
        this.gestaoJogos.getjButtonCadastrar().addActionListener(this);
        this.gestaoJogos.getjButtonEditar().addActionListener(this);
        this.gestaoJogos.getjButtonExcluir().addActionListener(this);
        this.gestaoJogos.getjButtonImagens().addActionListener(this);
        this.gestaoJogos.getjButtonEstoque().addActionListener(this);
        this.gestaoJogos.getjButtonPesquisar().addActionListener(this);
        this.gestaoJogos.getjButtonSair().addActionListener(this);
        this.gestaoJogos.addWindowFocusListener(this);
        this.gestaoJogos.addWindowListener(this);
    }
    
    //Função para limpar a view
    public void limpaView() {
        jogo.setId(0);
        
        //Ajusta os forms
        this.gestaoJogos.getjTextFieldId().setText(null);
        this.gestaoJogos.getjTextFieldNome().setText(null);
        this.gestaoJogos.getjFormattedTextFieldValor().setText(null);
        this.gestaoJogos.getjTextFieldClassificacao().setText(null);
        this.gestaoJogos.getjTextAreaReview().setText(null);
        
        //Ajusta os ComboForms
        listaDistribuidoras("");
        listaGeneros("");
        listaFaixasEtarias("");
        listaDepositos("");
        
        //Ajusta o stauts dos botões
        this.gestaoJogos.getjButtonCadastrar().setEnabled(true);
        this.gestaoJogos.getjButtonEditar().setEnabled(false);
        this.gestaoJogos.getjButtonExcluir().setEnabled(false);
        this.gestaoJogos.getjButtonImagens().setEnabled(false);
        this.gestaoJogos.getjButtonEstoque().setEnabled(false);
    }
    
    //Função para listar as distribuidoras
    public void listaDistribuidoras(String nome) {
        ArrayList<Distribuidora> distribuidoras = distribuidoraDAO.listaDistribuidoras(nome);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.gestaoJogos.getjComboBoxDistribuidora().getModel();
        
        model.removeAllElements();
                
        for (Distribuidora dist : distribuidoras) {
            model.addElement(dist.getNome());
        }
    }
    
    //Função para listar os gêneros
    public void listaGeneros(String nome) {
        ArrayList<Genero> generos = generoDAO.listaGeneros(nome);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.gestaoJogos.getjComboBoxGenero().getModel();
        
        model.removeAllElements();
                
        for (Genero gen : generos) {
            model.addElement(gen.getDescricao());
        }
    }
    
    //Função para listar as faixas etárias
    public void listaFaixasEtarias(String nome) {
        ArrayList<FaixaEtaria> faixasEtarias = faixaEtariaDAO.listaFaixaEtarias(nome);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.gestaoJogos.getjComboBoxFaixaEtaria().getModel();
        
        model.removeAllElements();
                
        for (FaixaEtaria fE : faixasEtarias) {
            model.addElement(fE.getDescricao());
        }
    }
    
    //Função para listar os depósitos
    public void listaDepositos(String nome) {
        ArrayList<Deposito> depositos = depositoDAO.listaDepositos(nome);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.gestaoJogos.getjComboBoxDeposito().getModel();
        
        model.removeAllElements();
                
        for (Deposito dep : depositos) {
            model.addElement(dep.getDescricao());
        }
    }
    
    //Função para exibir o cadastro de um jogo
    public void exibeCadastro(int id) {
        jogo.setId(id);
        jogo = jogoDAO.posicionaJogo(id);
        
        //Posiciona os registros relacionados
        distribuidora = distribuidoraDAO.posicionaDistribuidora(jogo.getIdDistribuidora());
        genero = generoDAO.posicionaGenero(jogo.getIdGenero());
        faixaEtaria = faixaEtariaDAO.posicionaFaixaEtaria(jogo.getIdFaixaEtaria());
        deposito = depositoDAO.posicionaDeposito(jogo.getIdDeposito());
        
        this.gestaoJogos.getjTextFieldId().setText("" + jogo.getId());
        this.gestaoJogos.getjTextFieldNome().setText(jogo.getNome());
        this.gestaoJogos.getjComboBoxDistribuidora().setSelectedItem(distribuidora.getNome());
        this.gestaoJogos.getjComboBoxGenero().setSelectedItem(genero.getDescricao());
        this.gestaoJogos.getjComboBoxFaixaEtaria().setSelectedItem(faixaEtaria.getDescricao());
        this.gestaoJogos.getjComboBoxDeposito().setSelectedItem(deposito.getDescricao());
        this.gestaoJogos.getjFormattedTextFieldValor().setText("" + String.valueOf(jogo.getValor()).replace(".", ","));
        this.gestaoJogos.getjTextFieldClassificacao().setText("" + jogo.getClassificacao());
        this.gestaoJogos.getjTextAreaReview().setText(jogo.getReview());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Cadastrar
        if (e.getSource() == this.gestaoJogos.getjButtonCadastrar()) {
            //Chama a função para carregar o cadastro da distribuidora selecionada
            distribuidora = distribuidoraDAO.posicionaDistribuidoraNome((String) this.gestaoJogos.getjComboBoxDistribuidora().getSelectedItem());
            
            //Chama a função para carregar o cadastro do gênero selecionado
            genero = generoDAO.posicionaGeneroDescricao((String) this.gestaoJogos.getjComboBoxGenero().getSelectedItem());
            
            //Chama a função para carregar o cadastro da faixa etária selecionada
            faixaEtaria = faixaEtariaDAO.posicionaFaixaEtariaDescricao((String) this.gestaoJogos.getjComboBoxFaixaEtaria().getSelectedItem());
            
            //Chama a função para carregar o cadastro do depósito selecionado
            deposito = depositoDAO.posicionaDepositoDescricao((String) this.gestaoJogos.getjComboBoxDeposito().getSelectedItem());
            
            jogo.setNome(this.gestaoJogos.getjTextFieldNome().getText());
            jogo.setIdDistribuidora(distribuidora.getId());
            jogo.setIdGenero(genero.getId());
            jogo.setIdFaixaEtaria(faixaEtaria.getId());
            jogo.setIdDeposito(deposito.getId());
            jogo.setValor(Double.parseDouble(this.gestaoJogos.getjFormattedTextFieldValor().getText().replace(",", ".")));
            jogo.setClassificacao(0);
            jogo.setReview(this.gestaoJogos.getjTextAreaReview().getText());
            
            //Chama a função para cadastrar o jogo
            jogoDAO.cadastraJogo(jogo);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Editar
        else if (e.getSource() == this.getGestaoJogos().getjButtonEditar()) {
            //Chama a função para carregar o cadastro da distribuidora selecionada
            distribuidora = distribuidoraDAO.posicionaDistribuidoraNome((String) this.gestaoJogos.getjComboBoxDistribuidora().getSelectedItem());
            
            //Chama a função para carregar o cadastro do gênero selecionado
            genero = generoDAO.posicionaGeneroDescricao((String) this.gestaoJogos.getjComboBoxGenero().getSelectedItem());
            
            //Chama a função para carregar o cadastro da faixa etária selecionada
            faixaEtaria = faixaEtariaDAO.posicionaFaixaEtariaDescricao((String) this.gestaoJogos.getjComboBoxFaixaEtaria().getSelectedItem());
            
            //Chama a função para carregar o cadastro do depósito selecionado
            deposito = depositoDAO.posicionaDepositoDescricao((String) this.gestaoJogos.getjComboBoxDeposito().getSelectedItem());
            
            jogo.setId(Integer.parseInt(this.gestaoJogos.getjTextFieldId().getText()));
            jogo.setNome(this.gestaoJogos.getjTextFieldNome().getText());
            jogo.setIdDistribuidora(distribuidora.getId());
            jogo.setIdGenero(genero.getId());
            jogo.setIdFaixaEtaria(faixaEtaria.getId());
            jogo.setIdDeposito(deposito.getId());
            jogo.setValor(Double.parseDouble(this.gestaoJogos.getjFormattedTextFieldValor().getText().replace(",", ".")));
            jogo.setClassificacao(0);
            jogo.setReview(this.gestaoJogos.getjTextAreaReview().getText());
            
            //Chama a função para cadastrar o jogo
            jogoDAO.editaJogo(jogo);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Excluir
        else if (e.getSource() == this.getGestaoJogos().getjButtonExcluir()) {
            jogo.setId(Integer.parseInt(this.gestaoJogos.getjTextFieldId().getText()));
            
            //Chama a função para excluir o jogo
            jogoDAO.excluiJogo(jogo);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Pesquisar
        else if (e.getSource() == this.getGestaoJogos().getjButtonPesquisar()) {
            limpaView();
            ListaJogos viewListaJogos = new ListaJogos(gestaoJogos, true);
            ListaJogosController controllerJogos = new ListaJogosController(viewListaJogos, jogo);
            
            controllerJogos.getListaJogos().setVisible(true);
        }
        //Imagens
        else if (e.getSource() == this.gestaoJogos.getjButtonImagens()) {
            jogo.setId(Integer.parseInt(this.gestaoJogos.getjTextFieldId().getText()));
            jogo.setNome(this.gestaoJogos.getjTextFieldNome().getText());
            
            GestaoJogosImagens viewGestaoJogosImagens = new GestaoJogosImagens();
            GestaoJogosImagensController controllerGestaoJogosImagens = new GestaoJogosImagensController(viewGestaoJogosImagens, jogo);
            controllerGestaoJogosImagens.getGestaoJogosImagens().setVisible(true);
        }
        //Estoque
        else if (e.getSource() == this.gestaoJogos.getjButtonEstoque()) {
            jogo.setId(Integer.parseInt(this.gestaoJogos.getjTextFieldId().getText()));
            jogo.setNome(this.gestaoJogos.getjTextFieldNome().getText());
            deposito = depositoDAO.posicionaDepositoDescricao((String) this.gestaoJogos.getjComboBoxDeposito().getSelectedItem());
            
            GestaoJogosDeposito viewGestaoJogosDeposito = new GestaoJogosDeposito();
            GestaoJogosDepositoController controllerGestaoJogosDeposito = new GestaoJogosDepositoController(viewGestaoJogosDeposito, jogoDep, jogo, deposito);
            controllerGestaoJogosDeposito.getGestaoJogosDeposito().setVisible(true);
        }
        //Sair
        else if (e.getSource() == this.gestaoJogos.getjButtonSair()) {
            this.gestaoJogos.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
        //Chama a função para carregar as distribuidoras cadastradas do sistema
        listaDistribuidoras("");
        
        //Chama a função para carregar os gêneros cadastrados do sistema
        listaGeneros("");
        
        //Chama a função para carregar as faixas etárias do sistema
        listaFaixasEtarias("");
        
        //Chama a função para carregar os depósitos do sistema
        listaDepositos("");
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void windowGainedFocus(WindowEvent we) {
        if (jogo.getId() > 0 && gestaoJogos.getjTextFieldId().getText().isEmpty()) {
            //Ajusta o status dos botões
            gestaoJogos.getjButtonCadastrar().setEnabled(false);
            gestaoJogos.getjButtonEditar().setEnabled(true);
            gestaoJogos.getjButtonExcluir().setEnabled(true);
            gestaoJogos.getjButtonImagens().setEnabled(true);
            gestaoJogos.getjButtonEstoque().setEnabled(true);
            
            //Chama a função para exibir o cadastro
            exibeCadastro(jogo.getId());
        }
    }

    @Override
    public void windowLostFocus(WindowEvent we) {
    }
}
