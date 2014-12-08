package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Deposito;
import model.Jogo;
import model.JogoDep;
import model.JogoDepDAO;
import view.GestaoJogosDeposito;

public class GestaoJogosDepositoController implements ActionListener {
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
}
