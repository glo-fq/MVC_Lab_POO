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
public class ControladorSala implements ActionListener {
    public SalaForm vista;
    public SalaDAO dao;
    public Sala modelo;
    
    public ControladorSala(SalaForm pVista, Sala pModelo) {
        vista = pVista;
        modelo = pModelo;
        dao = new SalaDAO();
        
        this.vista.btAceptar.addActionListener(this);
        this.vista.btCancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Aceptar":
                registrarSala();
                break;
            case "Cancelar":
                cerrarVentanaSala();
                break;
            default:
                break;
        }
    }
    
    public void registrarSala() {
        if(vista.salaDatosCorrectos()) {
            String capacidad = vista.txCapacidad.getText();
            String identificacion = vista.txIdentificacion.getText();
            String ubicacion = vista.txUbicacion.getText();
            
            int numCapacidad = Integer.parseInt(capacidad);
            
            modelo = new Sala(identificacion, ubicacion, numCapacidad);
            
            try {
                dao.registrarSala(modelo);
                JOptionPane.showMessageDialog(vista, "Cuenta registrada exitosamente.");
            } catch(SalaAlreadyExistsException e) {
                JOptionPane.showMessageDialog(vista, "Esta sala ya existe.");
            } catch(IOException e) {
                JOptionPane.showMessageDialog(vista, "Se dio un error leyendo las entradas. Por favor intente de nuevo.");
            } catch(JAXBException e) {
                JOptionPane.showMessageDialog(vista, "Se dio un error leyendo los archivos. Por favor intente de nuevo.");
                System.err.println(e.getMessage());
                System.err.println(e.getStackTrace()[0].toString());
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Todos los datos son requeridos");
            
        }
        
    }
    
    public void cerrarVentanaSala() {
        vista.cancelarAgregarSala();
    }
    
}
