/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.*;
import java.awt.event.*;
import modelo.*;
import vista.*;
import dao.*;
import java.io.IOException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Gloriana
 */
public class ControladorUsuario implements ActionListener {
    public LoginForm vista;
    public UsuarioDAO dao;
    public Usuario modelo;
    
    public ControladorUsuario(LoginForm pVista, Usuario pModelo) {
        vista = pVista;
        modelo = pModelo;
        dao = new UsuarioDAO();
        
        this.vista.btIniciarLogin.addActionListener(this);
        this.vista.btCancelarLogin.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Iniciar LogIn":
                logIn();
                break;
            case "Cancelar LogIn":
                cerrarVentanaLogin();
                break;
            default:
                break;
        }
    }
    
    public void logIn() {
        //Si se llenaron los campos de usuario y contraseña
        if(vista.logInDatosCorrectos() == true) {
            System.out.println("Datos Correctos.");
            
            String nombreUsuario = vista.txtNombreUsuario.getText();
            String contraseña = vista.txtContraseña.getText();
            
            modelo = new Usuario(nombreUsuario, contraseña);
            
            boolean datosCorrectos = false;
            
            try {
                System.out.println("Intentando");
                dao.iniciarSesion(modelo);
                datosCorrectos = true;
            } catch(InvalidUserException invalidUserExceptione){
                JOptionPane.showMessageDialog(vista, "La combinación usuario-contraseña es incorrecta. Por favor intente de nuevo.");
            } catch(IOException iOException) {
                JOptionPane.showMessageDialog(vista, "Hubo un problema leyendo los datos. Por favor intente de nuevo.");
            } catch(JAXBException jAXBException) {
                JOptionPane.showMessageDialog(vista, "Hubo un problema leyendo los archivos. Por favor intente de nuevo.");
                System.err.println(jAXBException.getMessage());
                System.err.println(jAXBException.getStackTrace()[0].toString());
            }
            
            if(datosCorrectos) {
            vista.setVisible(false);
            //Se abre vista dependiendo del usuario
            JOptionPane.showMessageDialog(vista, "Bienvenido: " + modelo.getNombre());
            llamarSala();
            }
        }
        else {
            JOptionPane.showMessageDialog(vista, "Todos los datos son requeridos");
        }
    }
    
    public void llamarSala() {
        SalaForm vistaSala = new SalaForm();
        
        Sala modeloSala = new Sala();
        ControladorSala controladorSala = new ControladorSala(vistaSala, modeloSala);
        controladorSala.vista.setVisible(true);
        controladorSala.vista.setLocationRelativeTo(null);
    }
    
    public void cerrarVentanaLogin() {
        vista.cancelarInicioSesion();
    }
}
