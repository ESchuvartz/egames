package main;

import controller.MenuPrincipalController;
import view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal viewMenuPrincipal = new MenuPrincipal();
        MenuPrincipalController controllerMenuPrincipal = new MenuPrincipalController(viewMenuPrincipal);
        
        //Ativa o menu principal
        controllerMenuPrincipal.getMenuPrincipal().setVisible(true);
    }
}
