/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

import java.time.LocalDateTime;
import org.jcr.enums.EstadoCita;

/**
 *
 * @author signo
 */
public class Cita {
    private Paciente paciente;
    private Medico medico;
    private Sala sala;
    private LocalDateTime fechaHora;
    private double costo;
    private EstadoCita estado;
    private String observaciones;

    public Cita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) {
        setPaciente(paciente);
        setMedico(medico);
        setSala(sala);
        setFechaHora(fechaHora);
        setCosto(costo);
        this.estado = EstadoCita.PROGRAMADA;
        this.observaciones = "";
    }

    // ------ Setters ----- 
    private void setPaciente(Paciente paciente) {
        Validaciones.noNulo(paciente, "Error: Paciente no puede ser nulo.");
        this.paciente = paciente;
    }

    private void setMedico(Medico medico) {
        Validaciones.noNulo(medico, "Error: Medico no puede ser nulo.");
        this.medico = medico;
    }

    private void setSala(Sala sala) {
        Validaciones.noNulo(sala, "Error: Sala no puede ser nula.");
        this.sala = sala;
    }

    private void setFechaHora(LocalDateTime fechaHora) {
        Validaciones.noNulo(fechaHora, "Error: Fecha no puede ser nula.");
        this.fechaHora = fechaHora;
    }

    private void setCosto(double costo) {
        if (costo > 0) {
            this.costo = costo;
        
        }
    }

    public void setEstado(EstadoCita estado) {
        Validaciones.noNulo(estado, "Error: Estado no puede ser nulo.");
        this.estado = estado;
    }

    public void setObservaciones(String observaciones) {
        if (observaciones != null) {
            this.observaciones = observaciones;
        } else {
            this.observaciones = "";
        }
        
    }

    // ----- Getters -----
    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public double getCosto() {
        return costo;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    
}
