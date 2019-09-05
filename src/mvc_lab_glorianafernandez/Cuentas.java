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
import modelo.Usuario;

/**
 *
 * @author Gloriana
 */
@XmlRootElement(name="datos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cuentas {
    private ArrayList<Cuenta> cuentasXML = new ArrayList<>();
   
    public Cuentas() {
        
    }
    
    @XmlElementWrapper(name="usuarios")
    @XmlElement(name="usuario")
    public ArrayList<Cuenta> getCuentas() {
        return cuentasXML;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentasXML = cuentas;
    }
    


 
    
    
    
}
