/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Gloriana
 */
@XmlRootElement(name="sala")
public class Sala {
    private String identificador;
    private String ubicacion;
    private int capacidad;
    
    public Sala() {}
    
    public Sala(String pIdentificador, String pUbicacion, int pCapacidad) {
        identificador = pIdentificador;
        ubicacion = pUbicacion;
        capacidad = pCapacidad;
    }

    @XmlElement(name="identificador")
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @XmlElement(name="ubicacion")
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @XmlElement(name="capacidad")
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
    
}
