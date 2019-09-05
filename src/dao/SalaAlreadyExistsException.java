/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Gloriana
 */
public class SalaAlreadyExistsException extends Exception{
    public SalaAlreadyExistsException(String mensaje) {
        super(mensaje);
    }
    
}
