/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author signo
 */
public class HistoriaClinica {
    private String numeroHistoria;
    private Paciente paciente;
    private LocalDateTime fechaCreacion;
    private List<String> diagnosticos;
    private List<String> tratamientos;
    private List<String> alergias;

    HistoriaClinica(Paciente paciente) {
        setPaciente(paciente);
        setFechaCreacion();
        generarNumeroHistoria();
        this.diagnosticos = new ArrayList<>();
        this.tratamientos = new ArrayList<>();
        this.alergias = new ArrayList<>();
    }

    private void setPaciente(Paciente paciente) {
        Validaciones.noNulo(paciente, "Error: paciente nulo");
        this.paciente = paciente;
    }

    private void setFechaCreacion() {
        this.fechaCreacion = LocalDateTime.now();
    }
    
    private void generarNumeroHistoria() {
        this.numeroHistoria = "HC-" + paciente.getDni() + "-" + fechaCreacion.getYear();
    }

    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<String> getDiagnosticos() {
        return Collections.unmodifiableList(diagnosticos);
    }

    public List<String> getTratamientos() {
        return Collections.unmodifiableList(tratamientos);
    }

    public List<String> getAlergias() {
        return Collections.unmodifiableList(alergias);
    }

    public void agregarDiagnostico(String diagnostico){
        if (diagnostico != null && !diagnostico.isBlank()) {
            diagnosticos.add(diagnostico);
        }
    }
    
    public void agregarTratamiento(String tratamiento){
        if (tratamiento != null && !tratamiento.isBlank()){
            tratamientos.add(tratamiento);
        }
    }
    
    public void agregarAlergia(String alergia){
        if (alergia != null && !alergia.isBlank()){
            alergias.add(alergia);
        }
    }
    
    
    
}
