package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
import view.ConsultaJogos;
import view.ConsultaJogosAvaliacoes;

public class ConsultaJogosController implements ActionListener, MouseListener, WindowListener {
    private ConsultaJogos consultaJogos = null;
    private Distribuidora distribuidora = null;
    private DistribuidoraDAO distribuidoraDAO = null;
    private Genero genero = null;
    private GeneroDAO generoDAO = null;
    private FaixaEtaria faixaEtaria = null;
    private FaixaEtariaDAO faixaEtariaDAO = null;
    private Deposito deposito = null;
    private DepositoDAO depositoDAO = null;
    private Jogo jogo = null;
    private JogoDAO jogoDAO = null;
    private JogoDep jogoDep = null;
    private JogoDepDAO jogoDepDAO = null;

    public ConsultaJogos getConsultaJogos() {
        return consultaJogos;
    }

    public ConsultaJogosController(ConsultaJogos view, Jogo model) {
        this.consultaJogos = view;
        this.jogo = model;
        this.jogoDAO = new JogoDAO();
        this.distribuidora = new Distribuidora();
        this.distribuidoraDAO = new DistribuidoraDAO();
        this.genero = new Genero();
        this.generoDAO = new GeneroDAO();
        this.faixaEtaria = new FaixaEtaria();
        this.faixaEtariaDAO = new FaixaEtariaDAO();
        this.deposito = new Deposito();
        this.depositoDAO = new DepositoDAO();
        this.jogoDep = new JogoDep();
        this.jogoDepDAO = new JogoDepDAO();
        
        this.consultaJogos.getjButtonIniciarBusca().addActionListener(this);
        this.consultaJogos.getjButtonImagens().addActionListener(this);
        this.consultaJogos.getjButtonAvaliar().addActionListener(this);
        this.consultaJogos.getjButtonVerificarDisponibilidade().addActionListener(this);
        this.consultaJogos.getjButtonSair().addActionListener(this);
        this.consultaJogos.getjTableListaJogos().addMouseListener(this);
        this.consultaJogos.addWindowListener(this);
    }
    
    //Função para listar as distribuidoras
    public void listaDistribuidoras(String nome) {
        ArrayList<Distribuidora> distribuidoras = distribuidoraDAO.listaDistribuidoras(nome);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.consultaJogos.getjComboBoxDistribuidora().getModel();
        
        model.removeAllElements();
        
        model.addElement("Todas");
        
        for (Distribuidora dist : distribuidoras) {
            model.addElement(dist.getNome());
        }
    }
    
    //Função para listar os gêneros
    public void listaGeneros(String descricao) {
        ArrayList<Genero> generos = generoDAO.listaGeneros(descricao);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.consultaJogos.getjComboBoxGenero().getModel();
        
        model.removeAllElements();
        
        model.addElement("Todos");
        
        for (Genero gen : generos) {
            model.addElement(gen.getDescricao());
        }
    }
    
    //Função para listar as faixas etárias
    public void listaFaixasEtarias(String descricao) {
        ArrayList<FaixaEtaria> faixasEtarias = faixaEtariaDAO.listaFaixaEtarias(descricao);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.consultaJogos.getjComboBoxFaixaEtaria().getModel();
        
        model.removeAllElements();
        
        model.addElement("Todas");
        
        for (FaixaEtaria fE : faixasEtarias) {
            model.addElement(fE.getDescricao());
        }
    }
    
    //Função para listar os depósitos
    public void listaDepositos(String descricao) {
        ArrayList<Deposito> depositos = depositoDAO.listaDepositos(descricao);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.consultaJogos.getjComboBoxDeposito().getModel();
        
        model.removeAllElements();
        
        model.addElement("Todos");
        
        for (Deposito dep : depositos) {
            model.addElement(dep.getDescricao());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Iniciar busca
        if (e.getSource() == this.consultaJogos.getjButtonIniciarBusca()) {
            //Ajusta os botões
            this.consultaJogos.getjButtonImagens().setEnabled(false);
            this.consultaJogos.getjButtonAvaliar().setEnabled(false);
            this.consultaJogos.getjButtonVerificarDisponibilidade().setEnabled(false);
            
            if (this.consultaJogos.getjComboBoxDistribuidora().getSelectedItem().equals("Todas")) {
                distribuidora.setId(0);
            } else {
                //Chama a função para carregar o cadastro da distribuidora selecionada
                distribuidora = distribuidoraDAO.posicionaDistribuidoraNome((String) this.consultaJogos.getjComboBoxDistribuidora().getSelectedItem());
            }
            
            if (this.consultaJogos.getjComboBoxGenero().getSelectedItem().equals("Todos")) {
                genero.setId(0);
            } else {
               //Chama a função para carregar o cadastro do gênero selecionado 
               genero = generoDAO.posicionaGeneroDescricao((String) this.consultaJogos.getjComboBoxGenero().getSelectedItem());
            }
            
            if (this.consultaJogos.getjComboBoxFaixaEtaria().getSelectedItem().equals("Todas")) {
                faixaEtaria.setId(0);
            } else {
                //Chama a função para carregar o cadastro da faixa etária selecionada
                faixaEtaria = faixaEtariaDAO.posicionaFaixaEtariaDescricao((String) this.consultaJogos.getjComboBoxFaixaEtaria().getSelectedItem());
            }
            
            if (this.consultaJogos.getjComboBoxDeposito().getSelectedItem().equals("Todos")) {
                deposito.setId(0);
            } else {
                //Chama a função para carregar o cadastro do depósito selecionado
                deposito = depositoDAO.posicionaDepositoDescricao((String) this.consultaJogos.getjComboBoxDeposito().getSelectedItem());
            }
            
            double vlIni = 0;
            double vlFin = 0;
            
            if ((!this.consultaJogos.getjFormattedTextFieldVlInicial().getText().isEmpty()) && Double.parseDouble(this.consultaJogos.getjFormattedTextFieldVlInicial().getText()) > 0) {
                vlIni = (Double.parseDouble(this.consultaJogos.getjFormattedTextFieldVlInicial().getText().replace(",", ".")));
            } 
            
            if ((!this.consultaJogos.getjFormattedTextFieldVlFinal().getText().isEmpty()) && Double.parseDouble(this.consultaJogos.getjFormattedTextFieldVlFinal().getText()) > 0) {
                vlFin = (Double.parseDouble(this.consultaJogos.getjFormattedTextFieldVlFinal().getText().replace(",", ".")));
            }
            
            String nome = this.consultaJogos.getjTextFieldNome().getText();
            
            //Chama a função para carregar o array de jogos
            ArrayList<Jogo> jogos = jogoDAO.listaJogosBusca(distribuidora.getId(), genero.getId(), faixaEtaria.getId(), deposito.getId(), nome, vlIni, vlFin);
            
            DefaultTableModel model = (DefaultTableModel) this.consultaJogos.getjTableListaJogos().getModel();
            
            model.setRowCount(0);
        
            for (Jogo jogo1 : jogos) {
                distribuidora = distribuidoraDAO.posicionaDistribuidora(jogo1.getIdDistribuidora());
                genero = generoDAO.posicionaGenero(jogo1.getIdGenero());
                faixaEtaria = faixaEtariaDAO.posicionaFaixaEtaria(jogo1.getIdFaixaEtaria());
                deposito = depositoDAO.posicionaDeposito(jogo1.getIdDeposito());
                
                model.addRow(new Object[]{jogo1.getId(), jogo1.getNome(), distribuidora.getNome(), genero.getDescricao(), faixaEtaria.getDescricao(), deposito.getDescricao(), String.valueOf(jogo1.getValor()).replace(".", ",")});
            }
            
        }
        //Imagens
        else if (e.getSource() == this.consultaJogos.getjButtonImagens()) {
            
        }
        //Avaliar
        else if (e.getSource() == this.consultaJogos.getjButtonAvaliar()) {
            ConsultaJogosAvaliacoes viewConsultaJogosAvaliacoes = new ConsultaJogosAvaliacoes();
            ConsultaJogosAvaliacoesController controllerAvaliacoesJogos = new ConsultaJogosAvaliacoesController(viewConsultaJogosAvaliacoes, jogo);
            controllerAvaliacoesJogos.getConsultaJogosAvaliacoes().setVisible(true);
        }
        //Verificar disponibilidade
        else if (e.getSource() == this.consultaJogos.getjButtonVerificarDisponibilidade()) {
            jogoDep = jogoDepDAO.buscaEstoqueJogo(jogo.getId(), jogo.getIdDeposito());
            if (jogoDep.getQuantidade() > 0) {
                if (jogoDep.getQuantidade() == 1) JOptionPane.showMessageDialog(consultaJogos, ("O jogo " + jogo.getNome() + " possui " + jogoDep.getQuantidade() + " quantidade disponível!"));
                else JOptionPane.showMessageDialog(consultaJogos, ("O jogo " + jogo.getNome() + " possui " + jogoDep.getQuantidade() + " quantidades disponívels!"));
            } else {
                JOptionPane.showMessageDialog(consultaJogos, ("O jogo " + jogo.getNome() + " não possui quantidade disponível no momento!"), "Jogo indisponível", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Sair
        else if (e.getSource() == this.consultaJogos.getjButtonSair()) {
            this.consultaJogos.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        jogo = jogoDAO.posicionaJogo((int) this.consultaJogos.getjTableListaJogos().getValueAt(this.consultaJogos.getjTableListaJogos().getSelectedRow(), 0));
       
        //Ajusta os botões
        this.consultaJogos.getjButtonImagens().setEnabled(true);
        this.consultaJogos.getjButtonAvaliar().setEnabled(true);
        this.consultaJogos.getjButtonVerificarDisponibilidade().setEnabled(true);
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

    @Override
    public void windowOpened(WindowEvent we) {
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
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}
