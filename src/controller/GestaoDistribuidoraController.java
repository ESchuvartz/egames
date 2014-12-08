package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import model.Distribuidora;
import model.DistribuidoraDAO;
import model.Utilities;
import view.GestaoDistribuidoras;
import view.ListaDistribuidoras;

public class GestaoDistribuidoraController implements ActionListener, WindowFocusListener {
    private GestaoDistribuidoras gestaoDistribuidoras = null;
    private Utilities utilities = null;
    private Distribuidora distribuidora = null;
    private DistribuidoraDAO distribuidoraDAO = null;
    
    public GestaoDistribuidoras getGestaoDistribuidoras() {
        return this.gestaoDistribuidoras;
    }
    
    public GestaoDistribuidoraController (GestaoDistribuidoras view, Distribuidora model) {
        this.distribuidoraDAO = new DistribuidoraDAO();
        this.utilities = new Utilities();
        this.gestaoDistribuidoras = view;
        this.distribuidora = model;
        
        this.gestaoDistribuidoras.getjButtonSair().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonEscolher().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonAdicionar().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonEditar().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonExcluir().addActionListener(this);
        this.gestaoDistribuidoras.getjButtonPesquisar().addActionListener(this);
        this.gestaoDistribuidoras.addWindowFocusListener(this);
    }
    
    //Função para limpar toda a tela
    public void limpaView() {
        //Zera a ID da distribuidora
        distribuidora.setId(0);
        
        //Limpa os objetos necessários
        this.gestaoDistribuidoras.getjTextFieldId().setText(null);
        this.gestaoDistribuidoras.getjTextFieldNome().setText(null);
        this.gestaoDistribuidoras.getjFormattedTextFieldFundacao().setText(null);
        this.gestaoDistribuidoras.getjTextFieldImagem().setText(null);
        this.gestaoDistribuidoras.getjLabelExibirImagem().setIcon(null);
        
        //Restaura os botões
        this.gestaoDistribuidoras.getjButtonAdicionar().setEnabled(true);
        this.gestaoDistribuidoras.getjButtonEditar().setEnabled(false);
        this.gestaoDistribuidoras.getjButtonExcluir().setEnabled(false);
    }
    
    //Função para exibir a imagem
    public void exibeImagem(String sPath) {
        if (!sPath.trim().isEmpty()) {ImageIcon imagem = new ImageIcon(sPath);
            //Verifica se a imagem a ser exibida possui tamanho maior que o JLabel para redimensioná-la
            if (imagem.getIconWidth() > this.gestaoDistribuidoras.getjLabelExibirImagem().getWidth()) {
                this.gestaoDistribuidoras.getjLabelExibirImagem().setIcon(new ImageIcon(imagem.getImage().getScaledInstance(this.gestaoDistribuidoras.getjLabelExibirImagem().getWidth(),this.gestaoDistribuidoras.getjLabelExibirImagem().getHeight(), Image.SCALE_DEFAULT)));
            } else {
                this.gestaoDistribuidoras.getjLabelExibirImagem().setIcon(imagem);
            }
            
            this.getGestaoDistribuidoras().getjLabelExibirImagem().setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
    
    //Função para exibir o cadastro de uma distribuidora
    public void exibeCadastro(int id) {
        distribuidora.setId(id);
        distribuidora = distribuidoraDAO.posicionaDistribuidora(id);
        
        this.gestaoDistribuidoras.getjTextFieldId().setText("" + distribuidora.getId());
        this.gestaoDistribuidoras.getjTextFieldNome().setText(distribuidora.getNome());
        this.gestaoDistribuidoras.getjTextFieldImagem().setText(distribuidora.getImagem());
        this.gestaoDistribuidoras.getjFormattedTextFieldFundacao().setText(utilities.ajustaData(distribuidora.getFundacao()));
        exibeImagem(System.getProperty("user.dir") + distribuidora.getImagem());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Adicionar
        if (e.getSource() == this.gestaoDistribuidoras.getjButtonAdicionar()) {
            distribuidora.setNome(this.gestaoDistribuidoras.getjTextFieldNome().getText());
            distribuidora.setFundacao(utilities.converteData(this.gestaoDistribuidoras.getjFormattedTextFieldFundacao().getText()));
            if (!this.gestaoDistribuidoras.getjTextFieldImagem().getText().trim().isEmpty()) {
                distribuidora.setImagem(utilities.copiaImagem(this.gestaoDistribuidoras.getjTextFieldImagem().getText(), "/src/images/Distribuidoras/"));
            }

            //Chama a função para adicionar a distribuidora
            distribuidoraDAO.cadastraDistribuidora(distribuidora);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Editar
        else if (e.getSource() == this.gestaoDistribuidoras.getjButtonEditar()) {
            distribuidora.setId(Integer.parseInt(this.gestaoDistribuidoras.getjTextFieldId().getText()));
            distribuidora.setNome(this.gestaoDistribuidoras.getjTextFieldNome().getText());
            distribuidora.setFundacao(utilities.converteData(this.gestaoDistribuidoras.getjFormattedTextFieldFundacao().getText()));

            if (!this.gestaoDistribuidoras.getjTextFieldImagem().getText().contains("src/images/Distribuidoras/")) {
                distribuidora.setImagem(utilities.copiaImagem(this.gestaoDistribuidoras.getjTextFieldImagem().getText(), "/src/images/Distribuidoras/"));
            } else {
                distribuidora.setImagem(this.gestaoDistribuidoras.getjTextFieldImagem().getText());
            }
            
            //Chama a função parar editar a distribuidora
            distribuidoraDAO.editarDistribuidora(distribuidora);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Excluir
        else if (e.getSource() == this.getGestaoDistribuidoras().getjButtonExcluir()) {
            distribuidora.setId(Integer.parseInt(this.getGestaoDistribuidoras().getjTextFieldId().getText()));
            
            //Chama a função para excluir a distribuidora
            distribuidoraDAO.excluirDistribuidora(distribuidora);
            
            //Chama a função para limpar a view
            limpaView();
        }
        //Escolher
        else if (e.getSource() == this.getGestaoDistribuidoras().getjButtonEscolher()) {
            JFileChooser fileChooser = new  JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                this.gestaoDistribuidoras.getjTextFieldImagem().setText(fileChooser.getSelectedFile().getPath());
                exibeImagem(fileChooser.getSelectedFile().getPath());
            }
        }
        //Pesquisar
        else if (e.getSource() == this.getGestaoDistribuidoras().getjButtonPesquisar()) {
            limpaView();
            ListaDistribuidoras viewListaDistribuidoras = new ListaDistribuidoras(gestaoDistribuidoras, true);
            ListaDistribuidorasController controllerListaDistribuidora = new ListaDistribuidorasController(viewListaDistribuidoras, distribuidora);
            
            controllerListaDistribuidora.getListaDistribuidoras().setVisible(true);
        }
        //Sair
        else if (e.getSource() == this.getGestaoDistribuidoras().getjButtonSair()) {
            this.gestaoDistribuidoras.dispose();
        }
    }

    @Override
    public void windowGainedFocus(WindowEvent we) {
        if (distribuidora.getId()> 0 && gestaoDistribuidoras.getjTextFieldId().getText().isEmpty()) {
            //Ajusta o status dos botões
            gestaoDistribuidoras.getjButtonEditar().setEnabled(true);
            gestaoDistribuidoras.getjButtonExcluir().setEnabled(true);
            gestaoDistribuidoras.getjButtonAdicionar().setEnabled(false);
            
            //Chama a função para exibir o cadastro
            exibeCadastro(distribuidora.getId());
        }
    }

    @Override
    public void windowLostFocus(WindowEvent we) {
    }
}
