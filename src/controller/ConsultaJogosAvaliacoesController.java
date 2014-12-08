package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.Jogo;
import model.JogoDAO;
import model.Utilities;
import view.ConsultaJogosAvaliacoes;

public class ConsultaJogosAvaliacoesController implements ActionListener, MouseListener, WindowListener {
    private ConsultaJogosAvaliacoes consultaJogosAvaliacoes = null;
    private Jogo jogo = null;
    private JogoDAO jogoDAO = null;
    private Avaliacao avaliacao = null;
    private AvaliacaoDAO avaliacaoDAO = null;
    private Utilities utilities = null;

    public ConsultaJogosAvaliacoes getConsultaJogosAvaliacoes() {
        return consultaJogosAvaliacoes;
    }
    
    public ConsultaJogosAvaliacoesController(ConsultaJogosAvaliacoes view, Jogo model) {
        this.consultaJogosAvaliacoes = view;
        this.jogo = model;
        this.jogoDAO = new JogoDAO();
        this.avaliacao = new Avaliacao();
        this.avaliacaoDAO = new AvaliacaoDAO();
        this.utilities = new Utilities();
        
        this.consultaJogosAvaliacoes.getjButtonEnviar().addActionListener(this);
        this.consultaJogosAvaliacoes.getjButtonLimpar().addActionListener(this);
        this.consultaJogosAvaliacoes.getjButtonSair().addActionListener(this);
        this.consultaJogosAvaliacoes.getjTableAvaliacoes().addMouseListener(this);
        this.consultaJogosAvaliacoes.addWindowListener(this);
    }
    
    //Função para listar as classificações
    public void listaAvaliacoes(int id) {
        ArrayList<Avaliacao> avaliacoes = avaliacaoDAO.listaAvaliacaos(id);
        
        DefaultTableModel model = (DefaultTableModel) this.consultaJogosAvaliacoes.getjTableAvaliacoes().getModel();
        model.setRowCount(0);
        
        for (Avaliacao av : avaliacoes) {
            model.addRow(new Object[]{av.getId(), av.getAvaliador(), utilities.ajustaData(av.getData()), av.getNota()});
        }
    }
    
    //Função para limpar a view
    public void limpaView() {
        avaliacao.setId(0);
        this.consultaJogosAvaliacoes.getjButtonEnviar().setEnabled(true);
        this.consultaJogosAvaliacoes.getjTextFieldAvaliador().setText(null);
        this.consultaJogosAvaliacoes.getjFormattedTextFieldData().setText(null);
        this.consultaJogosAvaliacoes.getjComboBoxNota().setSelectedIndex(0);
        this.consultaJogosAvaliacoes.getjTextAreaObservacao().setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Enviar
        if (e.getSource() == this.consultaJogosAvaliacoes.getjButtonEnviar()) {
            avaliacao.setAvaliador(this.consultaJogosAvaliacoes.getjTextFieldAvaliador().getText());
            avaliacao.setData(utilities.converteData(this.consultaJogosAvaliacoes.getjFormattedTextFieldData().getText()));
            avaliacao.setNota(this.consultaJogosAvaliacoes.getjComboBoxNota().getSelectedIndex()+1);
            avaliacao.setObservacao(this.consultaJogosAvaliacoes.getjTextAreaObservacao().getText());
            avaliacao.setIdJogo(jogo.getId());
            
            //Chama a função para cadastrar a avaliação
            avaliacaoDAO.cadastraAvaliacao(avaliacao);
            
            //Chama a função para retonrar a quantidade de avaliações e a soma das notas para o jogo
            double nota = avaliacaoDAO.notaAvaliacoes(jogo.getId());
            double qtde = avaliacaoDAO.numeroAvaliacoes(jogo.getId());
            
            double classificacao = nota / qtde;
            
            //Chama a função para ajustar a classificação do jogo
            jogoDAO.ajustaClassificacaoJogo(jogo.getId(), classificacao);
            
            //Ajusta a classificação na tela
            this.consultaJogosAvaliacoes.getjTextFieldNotaGeral().setText(utilities.ajustaDecimais(classificacao));
            
            //Chama a função para limpar a view
            limpaView();
            
            //Chama a função para listar as avaliações
            listaAvaliacoes(jogo.getId());
        }
        //Limpar
        else if (e.getSource() == this.consultaJogosAvaliacoes.getjButtonLimpar()) {
            limpaView();
        }
        //Sair
        else if (e.getSource() == this.consultaJogosAvaliacoes.getjButtonSair()) {
            this.consultaJogosAvaliacoes.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.consultaJogosAvaliacoes.getjButtonEnviar().setEnabled(false);
        
        avaliacao = avaliacaoDAO.posicionaAvaliacao((int) this.consultaJogosAvaliacoes.getjTableAvaliacoes().getValueAt(this.consultaJogosAvaliacoes.getjTableAvaliacoes().getSelectedRow(), 0));
        
        this.consultaJogosAvaliacoes.getjTextFieldAvaliador().setText(avaliacao.getAvaliador());
        this.consultaJogosAvaliacoes.getjFormattedTextFieldData().setText(utilities.ajustaData(avaliacao.getData()));
        this.consultaJogosAvaliacoes.getjComboBoxNota().setSelectedIndex(avaliacao.getNota()-1);
        this.consultaJogosAvaliacoes.getjTextAreaObservacao().setText(avaliacao.getObservacao());
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
        if (jogo.getId() > 0) {
            this.consultaJogosAvaliacoes.getjTextFieldIdJogo().setText("" + jogo.getId());
            this.consultaJogosAvaliacoes.getjTextFieldNomeJogo().setText(jogo.getNome());
            this.consultaJogosAvaliacoes.getjTextFieldNotaGeral().setText(utilities.ajustaDecimais(jogo.getClassificacao()));
            
            //Chama a função para listar as avaliações do jogo
            listaAvaliacoes(jogo.getId());
        }
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
