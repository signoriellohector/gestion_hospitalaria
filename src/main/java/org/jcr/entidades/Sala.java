/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author signo
 */
public class Sala {
    private String numero;
    private String tipo;
    private Departamento departamento;
    private List<Cita> citas;

    Sala(String numero, String tipo, Departamento departamento) {
        setNumero(numero);
        setTipo(tipo);
        setDepartamento(departamento);
        this.citas = new ArrayList<>();
    }

    // ------ Setters
    private void setNumero(String numero) {       
        this.numero = Validaciones.textoObligatorio(numero, "Error: Numero de sala no puede ser nulo");
    }

    private void setTipo(String tipo) {       
        this.tipo = Validaciones.textoObligatorio(tipo, "Error: Tipo de sala no puede ser nulo");
    }

    private void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public void addCita(Cita cita){
        this.citas.add(cita);
    }
    
    // ------ Getters

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }
    
    
}
