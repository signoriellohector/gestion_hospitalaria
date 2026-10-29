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
    
    static String textoObligatorio(String valor, String mensajeError){
        if (valor == null || valor.isEmpty()){
            throw new IllegalArgumentException(mensajeError);
        }
        
        return valor;
    }
    
    static void noNulo(Object valor,String mensajeError){
        if (valor == null){
            throw new IllegalArgumentException(mensajeError);
        }
    }
    
    static boolean sonDigitos(String texto){
        boolean digitos = !texto.isEmpty() && texto.chars().allMatch(c -> c >= '0' && c <= '9');
        
        return digitos;
    }
}
