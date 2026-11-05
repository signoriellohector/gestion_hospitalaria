/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcr.enums.TipoSangre;

/**
 *
 * @author signo
 */
public class Paciente extends Persona{
    private HistoriaClinica historiaClinica;
    private String telefono;
    private String direccion;
    private Hospital hospital;
    private List<Cita> citas;

    public Paciente(String nombre, String apellido, 
            String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre,
            String telefono, String direccion) {
        
        super(nombre, apellido, dni, fechaNacimiento, tipoSangre);
        setTelefono(telefono);
        setDireccion(direccion);
        this.historiaClinica = new HistoriaClinica(this);
        this.citas = new ArrayList<>();
        
        
    }
    
    //---- Setter ----

    private void setTelefono(String telefono) {
        this.telefono = Validaciones.textoObligatorio(telefono, "Error: El telefono no puede ser nulo estar vacío");
    }

    private void setDireccion(String direccion) {   
        this.direccion = Validaciones.textoObligatorio(direccion, "Error: La direccion no puede ser nula o estar vacía");
    }

    public void setHospital(Hospital hospital) {
        if(this.hospital != hospital){
            Hospital h = this.hospital;
            this.hospital = hospital;
            
            if (this.hospital != null && !this.hospital.getPacientes().contains(this)){
                this.hospital.agregarPaciente(this);
            }
            
            if (h != null){
                h.removePaciente(this);
            }
            
        }
        
        
    }
    
    public void addCita(Cita cita){
        citas.add(cita);
    }

    // ------ Getter ----
    
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }
    
    
}
