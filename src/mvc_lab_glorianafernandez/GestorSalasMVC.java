package mvc_lab_glorianafernandez;


import controlador.ControladorUsuario;
import modelo.Usuario;
import vista.LoginForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gloriana
 */
public class GestorSalasMVC {
    public static void main(String[] args)  {
        
        
        LoginForm vista = new LoginForm();
        Usuario modelo = new Usuario();
        
        ControladorUsuario controladorUsuario = new ControladorUsuario(vista, modelo);
        
        controladorUsuario.vista.setVisible(true);
        controladorUsuario.vista.setLocationRelativeTo(null);
    }
}
