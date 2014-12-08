package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import model.Deposito;
import model.Jogo;
import model.JogoDep;
import model.JogoDepDAO;
import view.GestaoJogosDeposito;

public class GestaoJogosDepositoController implements ActionListener, WindowListener {
    private GestaoJogosDeposito gestaoJogosDeposito = null;
    private Jogo jogo = null;
    private Deposito deposito = null;
    private JogoDep jogoDep = null;
    private JogoDepDAO jogoDepDAO = null;

    public GestaoJogosDeposito getGestaoJogosDeposito() {
        return gestaoJogosDeposito;
    }

    public GestaoJogosDepositoController(GestaoJogosDeposito view, JogoDep model, Jogo jogoModel, Deposito depositoModel) {
        this.gestaoJogosDeposito = view;
        this.jogoDep = model;
        this.jogo = jogoModel;
        this.deposito = depositoModel;
        this.jogoDepDAO = new JogoDepDAO();
        
        this.gestaoJogosDeposito.getjButtonMovimentar().addActionListener(this);
        this.gestaoJogosDeposito.getjButtonSair().addActionListener(this);
        this.gestaoJogosDeposito.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Movimentar
        if (e.getSource() == this.gestaoJogosDeposito.getjButtonMovimentar()) {
            jogoDep.setIdJogo(jogo.getId());
            jogoDep.setIdDeposito(deposito.getId());
            jogoDep.setQuantidade((int) this.gestaoJogosDeposito.getjSpinnerQtdeAtual().getValue());
            
            //Chama a função para realizar a movimentação do estoque
            jogoDepDAO.movimentaJogoDeposito(jogoDep);
        }
        //Sair
        else if (e.getSource() == this.gestaoJogosDeposito.getjButtonSair()) {
            this.gestaoJogosDeposito.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        if (this.gestaoJogosDeposito.getjTextFieldIdJogo().getText().isEmpty()) {
            this.gestaoJogosDeposito.getjTextFieldIdJogo().setText(String.valueOf(jogo.getId()));
            this.gestaoJogosDeposito.getjTextFieldNomeJogo().setText(jogo.getNome());
            this.gestaoJogosDeposito.getjTextFieldIdDeposito().setText(String.valueOf(deposito.getId()));
            this.gestaoJogosDeposito.getjTextFieldDescDeposito().setText(deposito.getDescricao());
            this.gestaoJogosDeposito.getjSpinnerQtdeAtual().setValue((int) jogoDep.getQuantidade());
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
