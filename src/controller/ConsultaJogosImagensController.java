package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import model.Jogo;
import model.JogoDAO;
import model.JogoImagem;
import model.JogoImagemDAO;
import view.ConsultaJogosImagens;

public class ConsultaJogosImagensController implements ActionListener, WindowListener {
    private ConsultaJogosImagens consultaJogosImagens = null;
    private Jogo jogo = null;
    private JogoDAO jogoDAO = null;
    private JogoImagem jogoImagem = null;
    private JogoImagemDAO jogoImagemDAO = null;
    private ArrayList<JogoImagem> jogoimagens = null;
    private int iAtual = 0;
    private int iUltima = 0;

    public ConsultaJogosImagens getConsultaJogosImagens() {
        return consultaJogosImagens;
    }
    
    public ConsultaJogosImagensController(ConsultaJogosImagens view, Jogo model, JogoImagem modelJogoImagem) {
        this.consultaJogosImagens = view;
        this.jogo = model;
        this.jogoImagem = modelJogoImagem;
        this.jogoDAO = new JogoDAO();
        this.jogoImagemDAO = new JogoImagemDAO();
        
        this.consultaJogosImagens.getjButtonAnterior().addActionListener(this);
        this.consultaJogosImagens.getjButtonProxima().addActionListener(this);
        this.consultaJogosImagens.getjButtonSair().addActionListener(this);
        this.consultaJogosImagens.addWindowListener(this);
    } 
    
        //Função para exibir a imagem
    public void exibeImagem(String sPath) {
        if (!sPath.trim().isEmpty()) {
            ImageIcon imagem = new ImageIcon(sPath);
            //Verifica se a imagem a ser exibida possui tamanho maior que o JLabel para redimensioná-la
            if (imagem.getIconWidth() > this.consultaJogosImagens.getjLabelExibirImagem().getWidth()) {
                this.consultaJogosImagens.getjLabelExibirImagem().setIcon(new ImageIcon(imagem.getImage().getScaledInstance(this.consultaJogosImagens.getjLabelExibirImagem().getWidth(),this.consultaJogosImagens.getjLabelExibirImagem().getHeight(), Image.SCALE_DEFAULT)));
            } else {
                this.consultaJogosImagens.getjLabelExibirImagem().setIcon(imagem);
            }
        } else {
            this.consultaJogosImagens.getjLabelExibirImagem().setIcon(null);
        }
        
        this.consultaJogosImagens.getjLabelExibirImagem().setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Anterior
        if (e.getSource() == this.consultaJogosImagens.getjButtonAnterior()) {
            iAtual = iAtual - 1;
            
            if (iAtual == 0) this.consultaJogosImagens.getjButtonAnterior().setEnabled(false);
            this.consultaJogosImagens.getjButtonProxima().setEnabled(true);
            
            exibeImagem(System.getProperty("user.dir") + jogoimagens.get(iAtual).getImagem());
        }
        //Próxima
        else if (e.getSource() == this.consultaJogosImagens.getjButtonProxima()) {
            iAtual = iAtual + 1;
            
            if (iAtual + 1 == iUltima) this.consultaJogosImagens.getjButtonProxima().setEnabled(false);
            this.consultaJogosImagens.getjButtonAnterior().setEnabled(true);
            
            exibeImagem(System.getProperty("user.dir") + jogoimagens.get(iAtual).getImagem());
        }
        //Sair
        else if (e.getSource() == this.consultaJogosImagens.getjButtonSair()) {
            this.consultaJogosImagens.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        if (jogo.getId() > 0) {
            this.consultaJogosImagens.getjTextFieldJogoId().setText("" + jogo.getId());
            this.consultaJogosImagens.getjTextFieldJogoNome().setText(jogo.getNome());
            
            jogoimagens = jogoImagemDAO.listaJogoImagens(jogo.getId());
            iAtual = 0;
            exibeImagem(System.getProperty("user.dir") + jogoimagens.get(0).getImagem());
            
            iUltima = jogoimagens.size();
            
            if (iAtual + 1 == iUltima) this.consultaJogosImagens.getjButtonProxima().setEnabled(false);
            this.consultaJogosImagens.getjButtonAnterior().setEnabled(false);
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
