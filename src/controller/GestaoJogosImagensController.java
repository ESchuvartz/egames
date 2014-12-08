package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import model.Jogo;
import model.JogoImagem;
import model.JogoImagemDAO;
import model.Utilities;
import view.GestaoJogosImagens;

public class GestaoJogosImagensController implements ActionListener, WindowListener, MouseListener {
    private GestaoJogosImagens gestaoJogosImagens = null;
    private Jogo jogo = null;
    private JogoImagemDAO jogoImagemDAO = null;
    private JogoImagem jogoImagem = null;
    private Utilities utilities = null;

    public GestaoJogosImagens getGestaoJogosImagens() {
        return gestaoJogosImagens;
    }

    public GestaoJogosImagensController(GestaoJogosImagens view, Jogo model) {
        this.gestaoJogosImagens = view;
        this.jogo = model;
        this.jogoImagem = new JogoImagem();
        this.jogoImagemDAO = new JogoImagemDAO();
        this.utilities = new Utilities();
        
        this.gestaoJogosImagens.getjButtonSelecionar().addActionListener(this);
        this.gestaoJogosImagens.getjButtonSair().addActionListener(this);
        this.gestaoJogosImagens.getjButtonIncluir().addActionListener(this);
        this.gestaoJogosImagens.getjButtonExcluir().addActionListener(this);
        this.gestaoJogosImagens.addWindowListener(this);
        this.gestaoJogosImagens.getjTableImagens().addMouseListener(this);
    }
    
    //Função para limpar a view
    public void limpaView() {
        this.gestaoJogosImagens.getjTextFieldImagem().setText("");
    }
    
    //Função para exibir a imagem
    public void exibeImagem(String sPath) {
        if (!sPath.trim().isEmpty()) {
            ImageIcon imagem = new ImageIcon(sPath);
            //Verifica se a imagem a ser exibida possui tamanho maior que o JLabel para redimensioná-la
            if (imagem.getIconWidth() > this.gestaoJogosImagens.getjLabelExibirImagem().getWidth()) {
                this.gestaoJogosImagens.getjLabelExibirImagem().setIcon(new ImageIcon(imagem.getImage().getScaledInstance(this.gestaoJogosImagens.getjLabelExibirImagem().getWidth(),this.gestaoJogosImagens.getjLabelExibirImagem().getHeight(), Image.SCALE_DEFAULT)));
            } else {
                this.gestaoJogosImagens.getjLabelExibirImagem().setIcon(imagem);
            }
        } else {
            this.gestaoJogosImagens.getjLabelExibirImagem().setIcon(null);
        }
        
        this.gestaoJogosImagens.getjLabelExibirImagem().setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    //Função para listar as imagens do jogo
    public void listaJogoImagens(int id) {
        int i = 1;
        ArrayList<JogoImagem> jogoImagens = jogoImagemDAO.listaJogoImagens(id);
        
        DefaultTableModel model = (DefaultTableModel) this.gestaoJogosImagens.getjTableImagens().getModel();
        
        model.setRowCount(0);
        
        //Ajusta o tamanho da coluna id
        this.gestaoJogosImagens.getjTableImagens().getColumnModel().getColumn(0).setPreferredWidth(2);
        this.gestaoJogosImagens.getjTableImagens().getColumnModel().getColumn(1).setPreferredWidth(5);
        
        for (JogoImagem jImg : jogoImagens) {
            model.addRow(new Object[]{i++, jImg.getSequencia(), jImg.getImagem()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Selecionar
        if (e.getSource() == this.gestaoJogosImagens.getjButtonSelecionar()) {
            JFileChooser fileChooser = new  JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                this.gestaoJogosImagens.getjTextFieldImagem().setText(fileChooser.getSelectedFile().getPath());
                exibeImagem(fileChooser.getSelectedFile().getPath());
            }    
        }
        //Incluir
        else if (e.getSource() == this.gestaoJogosImagens.getjButtonIncluir()) {
            jogoImagem.setIdJogo(Integer.parseInt(this.gestaoJogosImagens.getjTextFieldId().getText()));
            //Chama a função para criar a pasta
            utilities.criaPasta("/src/images/Jogos/" + jogoImagem.getIdJogo());

            //Chama a função para copiar a imagem para a pasta criada
            jogoImagem.setImagem(utilities.copiaImagem(this.gestaoJogosImagens.getjTextFieldImagem().getText(), "/src/images/Jogos/" + jogoImagem.getIdJogo() + "/"));

            //Chama a função para cadastrar a imagem do jogo
            jogoImagemDAO.cadastraJogoImagem(jogoImagem);
            
            //Chama a função para limpar a view
            limpaView();
            
            //Chama a função para atualizar a table de imagens
            listaJogoImagens(jogoImagem.getIdJogo());
        }
        //Excluir
        else if (e.getSource() == this.gestaoJogosImagens.getjButtonExcluir()) {
            //Chama o método para excluir a imagem
            jogoImagemDAO.excluiJogoImagemSeq(jogoImagem);
            
            //Chama o método para listar as imagens novamente
            listaJogoImagens(jogoImagem.getIdJogo());
            
            exibeImagem("");
        }
        //Sair
        else if (e.getSource() == this.gestaoJogosImagens.getjButtonSair()) {
            this.gestaoJogosImagens.dispose();
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
        if (jogo.getId() > 0) {
            this.gestaoJogosImagens.getjTextFieldId().setText(String.valueOf(jogo.getId()));
            this.gestaoJogosImagens.getjTextFieldNome().setText(jogo.getNome());
            listaJogoImagens(jogo.getId());
        }
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        jogoImagem.setSequencia((int) this.gestaoJogosImagens.getjTableImagens().getValueAt(this.gestaoJogosImagens.getjTableImagens().getSelectedRow(), 1));
        jogoImagem.setIdJogo(Integer.parseInt(this.gestaoJogosImagens.getjTextFieldId().getText()));
        jogoImagem.setImagem((String) this.gestaoJogosImagens.getjTableImagens().getValueAt(this.gestaoJogosImagens.getjTableImagens().getSelectedRow(), 2));
        exibeImagem(System.getProperty("user.dir") + jogoImagem.getImagem());
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
