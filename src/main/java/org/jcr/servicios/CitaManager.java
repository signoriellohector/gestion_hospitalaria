/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.jcr.entidades.Cita;
import org.jcr.entidades.Medico;
import org.jcr.entidades.Paciente;
import org.jcr.entidades.Sala;
import org.jcr.excepciones.CitaException;

/**
 *
 * @author signo
 */
public class CitaManager implements CitaService{
    private final int HORAS_ENTRE_CITAS = 2;
    private List<Cita> citas;

    @Override
    public Cita programarCita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) throws CitaException {
        Cita cita = null;
        validarCita(fechaHora, costo);
        // verificacion de paciente nulo
        noNulo(paciente,"Error: El paciente no puede ser nulo");
        
        if (esSalaDisponible(sala, fechaHora) && esMedicoDisponible(medico, fechaHora)){
            
            if (sala.getDepartamento().getEspecialidad() != medico.getEspecialidad()){
                throw new CitaException("Error: Especialidad de medico y sala incompatibles.");
            }
            cita = new Cita(paciente, medico, sala, fechaHora, costo);
            
            
            paciente.addCita(cita);
            medico.addCita(cita);
            sala.addCita(cita);
            
        }
        
        return cita;
    }

    @Override
    public List<Cita> getCitasPorPaciente(Paciente paciente) {
        List<Cita> citas = new ArrayList<>();
        if (paciente != null){
            citas = paciente.getCitas();
        }
        
        return citas;
    }

    @Override
    public List<Cita> getCitasPorMedico(Medico medico) {
        List<Cita> citas = new ArrayList<>();
        if (medico != null){
            citas = medico.getCitas();
        }
        
        return citas;
    }

    @Override
    public List<Cita> getCitasPorSala(Sala sala) {
        List<Cita> citas = new ArrayList<>();
        if (sala != null){
            citas = sala.getCitas();
        }
        
        return citas;
    }

    
    private void validarCita(LocalDateTime fechaHora, double costo) throws CitaException{
        if (fechaHora == null || fechaHora.isBefore(LocalDateTime.now())){
            throw new CitaException("Error: La fecha nula o pasada");
        }
        
        if (costo <= 0 ){
            throw new CitaException("Erro: El costo no puede ser negativo");
        }
        
    }
    
    private boolean esMedicoDisponible(Medico medico, LocalDateTime fechaHora) throws CitaException{
        boolean medicoDisponible = false;
        if (noNulo(medico, "Error: medico no puede ser nulo")){
            
        }
        
        
        return true;
    }
    
    private boolean esSalaDisponible(Sala sala, LocalDateTime fechaHora) throws CitaException{
        if (noNulo(sala, "Error: La sala no puede ser nula")){
            
        }
        
        return true;
    }
    
    private boolean seSuperponen(Cita existente, Cita nueva ){
        return true;
    }
    
    private boolean noNulo(Object o, String mensage) throws CitaException{
        if (o == null){
            throw new CitaException(mensage);
            
        }
        
        return true;
    }
}
