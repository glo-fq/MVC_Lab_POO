/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import modelo.*;
import mvc_lab_glorianafernandez.Cuenta;
import mvc_lab_glorianafernandez.Cuentas;
/**
 *
 * @author Gloriana
 */
public class UsuarioDAO {
    
    public UsuarioDAO() {}
    
    public void iniciarSesion(Usuario usuario) throws InvalidUserException, IOException, JAXBException {
        System.out.println("Inside Iniciar Sesion");
        JAXBContext context = JAXBContext.newInstance(Cuentas.class);
        System.out.println("Context creado.");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        System.out.println("Unmarshaller creado.");
        Cuentas cuentas = (Cuentas) unmarshaller.unmarshal(new File("cuentas.xml"));
        System.out.println("Cuentas creadas.");
        ArrayList<Cuenta> cuentasLeidas = cuentas.getCuentas();
        
        boolean cuentaExiste = false;
        Cuenta cuentaEncontrada = null;
       
        String nombreUsuario = usuario.getNombre();
        String claveUsuario = usuario.getContraseña();
        
        
        for (Cuenta cuentaL : cuentasLeidas) {
            if(nombreUsuario.equals(cuentaL.getNombre())) {
                cuentaEncontrada = cuentaL;
                cuentaExiste = true;
                break;
            }
        }
        
        if(!cuentaExiste) {
            throw new InvalidUserException("Usuario invalido.");
        }
        
        if(cuentaExiste) {
            if(!cuentaEncontrada.getClave().equals(usuario.getContraseña())) {
                throw new InvalidUserException("Usuario invalido.");
            }
        }
        
        
    }
    
}
