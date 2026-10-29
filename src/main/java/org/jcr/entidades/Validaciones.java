/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

/**
 *
 * @author signo
 */
public class Validaciones {

    private Validaciones() {
    }
    
    String textoObligatorio(String valor, String mensajeError){
        if (valor == null || valor.isEmpty()){
            throw new IllegalArgumentException(mensajeError);
        }
        
        return valor;
    }
    
    void noNulo(Object valor,String mensajeError){
        if (valor == null){
            throw new IllegalArgumentException(mensajeError);
        }
    }
    
    boolean sonDigitos(String texto){
        boolean digitos = !texto.isEmpty() && texto.chars().allMatch(c -> c >= '0' && c <= '9');
        
        return digitos;
    }
}
