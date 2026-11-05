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
public class Hospital {
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Departamento> departamentos;
    private List<Paciente> pacientes;

    public Hospital(String nombre, String direccion, String telefono) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        this.departamentos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    private void setNombre(String nombre) {
        this.nombre = Validaciones.textoObligatorio(nombre, "Error: Nombre del Hospital nulo.");
    }

    private void setDireccion(String direccion) {
        this.direccion = Validaciones.textoObligatorio(direccion, "Error: Direccion del Hospital nula.");
    }

    private void setTelefono(String telefono) {
        this.telefono = Validaciones.textoObligatorio(telefono, "Error: Telefeno del Hospital nulo.");
    }
    
    public void agregarDepartamento(Departamento departamento){
        if(!departamentos.contains(departamento)){
            departamentos.add(departamento);          
            departamento.setHospital(this);
        }
    
    }
    
    public void agregarPaciente(Paciente paciente){
        if(!pacientes.contains(paciente)){
            pacientes.add(paciente);
            paciente.setHospital(this);
        }
    }

    public List<Departamento> getDepartamentos() {
        return Collections.unmodifiableList(departamentos);
    }

    public List<Paciente> getPacientes() {
        return Collections.unmodifiableList(pacientes);
    }
    
    /*
    List<Departamento> getInternalDepartamentos() {
        return departamentos;
    }

    List<Paciente> getInternalPacientes() {
        return pacientes;
    }
    */
    
    public void removeDepartamento(Departamento departamento){
        if(departamentos.remove(departamento) && departamento.getHospital() == this){
            departamento.setHospital(null);
        }
        
    }
    
    public void removePaciente(Paciente paciente){
        if(pacientes.remove(paciente) && paciente.getHospital() == this){           
            paciente.setHospital(null);
        }
    }
}
