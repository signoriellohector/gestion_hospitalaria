/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcr.enums.EspecialidadMedica;
import org.jcr.enums.TipoSangre;

/**
 *
 * @author signo
 */
public class Medico extends Persona{
    private Matricula matricula;
    private EspecialidadMedica especialidad;
    private Departamento departamento;
    private List<Cita> citas;

    public Medico(String nombre, String apellido, String dni, 
            LocalDate fechaNacimiento, TipoSangre tipoSangre,
            String numeroMatricula, EspecialidadMedica especialidad) {
        
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        setMatricula(numeroMatricula);
        setEspacialidad(especialidad);
        this.citas = new ArrayList<>();
    }
    
    // ----- Setters -----
    private void setMatricula(String numeroMatricula){
       this.matricula = new Matricula(numeroMatricula);
    }
    
    private void setEspacialidad(EspecialidadMedica especialidad){
        Validaciones.noNulo(especialidad, "Error: La especialidad no puede ser nula");
        this.especialidad = especialidad;
    }

    public void setDepartamento(Departamento departamento) {
        Validaciones.noNulo(departamento, "Error: Departamento no puede ser nulo.");
        
        if (especialidad.equals(departamento.getEspecialidad())){
            this.departamento = departamento;
        } else {
            throw new IllegalArgumentException("Error: Especialidad incompatible con el departamento.");
        }
    }
    
    public void addCita(Cita cita){
        this.citas.add(cita);
    }

    
    // ----- Getters ----
    public Matricula getMatricula() {
        return matricula;
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }
    
    
    
}
