/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import modelo.Sala;
import mvc_lab_glorianafernandez.Cuentas;
import mvc_lab_glorianafernandez.Salas;

/**
 *
 * @author Gloriana
 */
public class SalaDAO {
    public SalaDAO() {}
    
    public void registrarSala(Sala sala) throws SalaAlreadyExistsException, IOException, JAXBException{
        JAXBContext context = JAXBContext.newInstance(Salas.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Salas salas = (Salas) unmarshaller.unmarshal(new File("salas.xml"));
        
        ArrayList<Sala> salasLeidas = salas.getSalas();
        
        boolean salaExiste = false;
        
        //Busco entre las salas existentes
        for (Sala salaL : salasLeidas) {
            if(sala.getIdentificador().equals(salaL.getIdentificador())) {
                salaExiste = true;
                break;
            }
        }
        
        if(salaExiste) {
            throw new SalaAlreadyExistsException("Esta sala ya existe.");
        } else {
            
            //salasLeidas.add(sala);
            salas.agregarSala(sala);
            
            
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(salas, new FileWriter("salas.xml"));
        }
        
        
        
    }
    
}
