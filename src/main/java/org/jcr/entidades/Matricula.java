/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

/**
 *
 * @author signo
 */
public class Matricula {
    private String numero;

    public Matricula(String numero) {
        setMatricula(numero);
    }
    
    private void setMatricula( String numero){
        if (validarMatricula(numero)){
            this.numero = numero;
        } 
    }

    public String getNumero() {
        return numero;
    }
    
    private boolean validarMatricula(String numero){
        return true;
    }
}
