package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Distribuidora;
import view.GestaoDistribuidoras;
import view.MenuPrincipal;

public class MenuPrincipalController implements ActionListener {
    private MenuPrincipal menuPrincipal = null;
    
    public MenuPrincipal getMenuPrincipal(){
        return this.menuPrincipal;
    }
    
    public MenuPrincipalController (MenuPrincipal view) {
        this.menuPrincipal = view;
        
        this.menuPrincipal.getjMenuItemDistribuidoras().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.menuPrincipal.getjMenuItemDistribuidoras()) {
            Distribuidora model = new Distribuidora();
            GestaoDistribuidoras viewDistribuidora = new GestaoDistribuidoras();
            
            GestaoDistribuidoraController controllerDistribuidora = new GestaoDistribuidoraController(viewDistribuidora, model);
            controllerDistribuidora.getGestaoDistribuidoras().setVisible(true);
        }
    }
}
