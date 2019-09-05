/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_lab_glorianafernandez;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import modelo.Sala;
import modelo.Usuario;

/**
 *
 * @author Gloriana
 */
@XmlRootElement(name="elementos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Salas {
    private ArrayList<Sala> salasXML = new ArrayList<>();
   
    public Salas() {
        
    }
    
    @XmlElementWrapper(name="salas")
    @XmlElement(name="sala")
    public ArrayList<Sala> getSalas() {
        return salasXML;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salasXML = salas;
    }
    
    public void agregarSala(Sala sala) {
        salasXML.add(sala);
        //Escribir sala en el XML
        //O si se hace desde el DAO no es necesario
    }

    
    
    
}

