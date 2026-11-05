/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcr.enums.EspecialidadMedica;

/**
 *
 * @author signo
 */
public class Departamento {
    private String nombre;
    private EspecialidadMedica especialidad;
    private Hospital hospital;
    private List<Medico> medicos;
    private List<Sala> salas;

    public Departamento(String nombre, EspecialidadMedica especialidad) {
        setNombre(nombre);
        setEspecialidad(especialidad);
        this.medicos = new ArrayList<>();
        this.salas = new ArrayList<>();
        
    }
    
    // ---- Setters ------
    
    private void setNombre(String nombre){
        this.nombre = Validaciones.textoObligatorio(nombre, "Error: Nombre del departamento no puede ser nulo");
    }
    
    private void setEspecialidad(EspecialidadMedica especialidad){
        Validaciones.noNulo(especialidad, "Error: Especialidad no puede ser nula");
        this.especialidad = especialidad;
    }

    public void setHospital(Hospital hospital) {
        if (this.hospital != hospital){
            if(this.hospital != null) {
                this.hospital.removeDepartamento(this);
            } 
            this.hospital = hospital;
            this.hospital.agregarDepartamento(this);
        }
    }
    
    public void agregarMedico(Medico medico){
        if(!medicos.contains(medico)){
            medicos.add(medico);
        }
        
        if(medico.getDepartamento() != this){
            medico.setDepartamento(this);
        }
    }
    
    public Sala crearSala(String numero, String tipo){
        Sala sala = new Sala(numero, tipo, this);
        return sala;
    }

    public List<Medico> getMedicos() {
        return Collections.unmodifiableList(medicos);
    }

    public List<Sala> getSalas() {
        return Collections.unmodifiableList(salas);
    }
    
    List<Medico> getInternalMedico() {
        return medicos;
    }

    public Hospital getHospital() {
        return hospital;
    }
    
    
}
