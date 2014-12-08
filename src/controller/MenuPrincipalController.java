package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Deposito;
import model.Distribuidora;
import model.FaixaEtaria;
import model.Genero;
import model.Jogo;
import view.GestaoDepositos;
import view.GestaoDistribuidoras;
import view.GestaoFaixasEtarias;
import view.GestaoGeneros;
import view.GestaoJogos;
import view.MenuPrincipal;

public class MenuPrincipalController implements ActionListener {
    private MenuPrincipal menuPrincipal = null;
    
    public MenuPrincipal getMenuPrincipal(){
        return this.menuPrincipal;
    }
    
    public MenuPrincipalController (MenuPrincipal view) {
        this.menuPrincipal = view;
        
        this.menuPrincipal.getjMenuItemDistribuidoras().addActionListener(this);
        this.menuPrincipal.getjMenuItemGeneros().addActionListener(this);
        this.menuPrincipal.getjMenuItemFaixasEtarias().addActionListener(this);
        this.menuPrincipal.getjMenuItemDepositos().addActionListener(this);
        this.menuPrincipal.getjMenuItemJogos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Cadastro de Distribuidoras
        if (e.getSource() == this.menuPrincipal.getjMenuItemDistribuidoras()) {
            Distribuidora model = new Distribuidora();
            GestaoDistribuidoras viewDistribuidora = new GestaoDistribuidoras();
            
            GestaoDistribuidoraController controllerDistribuidora = new GestaoDistribuidoraController(viewDistribuidora, model);
            controllerDistribuidora.getGestaoDistribuidoras().setVisible(true);
        }
        //Cadastro de Gêneros
        else if (e.getSource() == this.menuPrincipal.getjMenuItemGeneros()) {
            Genero model = new Genero();
            GestaoGeneros viewGeneros = new GestaoGeneros();
            
            GestaoGeneroController controllerGenero = new GestaoGeneroController(viewGeneros, model);
            controllerGenero.getGestaoGenero().setVisible(true);
        }
        //Cadastro de Faixas Etárias
        else if (e.getSource() == this.menuPrincipal.getjMenuItemFaixasEtarias()) {
            FaixaEtaria model = new FaixaEtaria();
            GestaoFaixasEtarias viewFaixasEtarias = new GestaoFaixasEtarias();
            
            GestaoFaixaEtariaController controllerFaixaEtaria = new GestaoFaixaEtariaController(viewFaixasEtarias, model);
            controllerFaixaEtaria.getGestaoFaixaEtaria().setVisible(true);
        }
        //Cadastro de Depósitos
        else if (e.getSource() == this.menuPrincipal.getjMenuItemDepositos()) {
            Deposito model = new Deposito();
            GestaoDepositos viewDepositos = new GestaoDepositos();
            
            GestaoDepositoController controllerDeposito = new GestaoDepositoController(viewDepositos, model);
            controllerDeposito.getGestaoDeposito().setVisible(true);
        }
        //Cadastro de jogos
        else if (e.getSource() == this.menuPrincipal.getjMenuItemJogos()) {
            Jogo model = new Jogo();
            GestaoJogos viewJogos = new GestaoJogos();
            
            GestaoJogosController controllerJogo = new GestaoJogosController(viewJogos, model);
            controllerJogo.getGestaoJogos().setVisible(true);
        }
    }
}
