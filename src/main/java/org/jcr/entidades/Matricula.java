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
        } else {
            throw new IllegalArgumentException("Error: Numero de matricula no es valido");
        }
    }

    public String getNumero() {
        return numero;
    }
    
    private boolean validarMatricula(String numero){
        String prefijo = "MP-";
        boolean valido = false;
        Validaciones.textoObligatorio(numero, "Error: Numero de matricula no puede ser nulo o estar vacío.");
        if (numero.startsWith(prefijo)){
            String digitos = numero.substring(prefijo.length());
            if (digitos.length() >= 4 && digitos.length() <= 6){
                valido = Validaciones.sonDigitos(digitos);
            }
        }
        return valido;
    }
}
