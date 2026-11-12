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
import org.jcr.enums.EstadoCita;
import org.jcr.excepciones.CitaException;

/**
 *
 * @author signo
 */
public class CitaManager implements CitaService{
    private final int HORAS_ENTRE_CITAS = 2;
    private List<Cita> citas = new ArrayList<>();

    @Override
    public Cita programarCita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) throws CitaException {
        Cita cita = null;
        // verificacion de datos nulos
            
        validarCita(fechaHora, costo);
        noNulo(paciente,"Error: El paciente no puede ser nulo");
        noNulo(medico, "Error: El medico no puede ser nulo");
        noNulo(sala, "Error: La sala no puede ser nula");

        if (sala.getDepartamento().getEspecialidad() != medico.getEspecialidad()){
            throw new CitaException("Error: Especialidad de medico y sala incompatibles.");
        }
        
        if (esSalaDisponible(sala, fechaHora) && esMedicoDisponible(medico, fechaHora)){
            
            cita = new Cita(paciente, medico, sala, fechaHora, costo);
            
            citas.add(cita);
            paciente.addCita(cita);
            medico.addCita(cita);
            sala.addCita(cita);
            
        }
        
        return cita;
    }

    @Override
    public List<Cita> getCitasPorPaciente(Paciente paciente) {
        List<Cita> citasPaciente = new ArrayList<>();
        
        for (Cita c : citas){
            if(c.getPaciente().equals(paciente)){
                citasPaciente.add(c);
            }
        }
        
        return citasPaciente;
    }

    @Override
    public List<Cita> getCitasPorMedico(Medico medico) {
        List<Cita> citasMedico = new ArrayList<>();
        for (Cita c : citas){
            if(c.getMedico().equals(medico)){
                citasMedico.add(c);
            }
        }
        
        return citasMedico;
    }

    @Override
    public List<Cita> getCitasPorSala(Sala sala) {
        List<Cita> citasSala = new ArrayList<>();
        for (Cita c : citas){
            if(c.getSala().equals(sala)){
                citasSala.add(c);
            }
        }
        
        return citasSala;
    }

    
    private void validarCita(LocalDateTime fechaHora, double costo) throws CitaException{
        noNulo(fechaHora, "Error: La fecha no puede ser nula");
        if (fechaHora.isBefore(LocalDateTime.now())){
            throw new CitaException("Error: La fecha pasada");
        }
        
        if (costo <= 0 ){
            throw new CitaException("Error: El costo no puede ser zero o negativo");
        }
        
    }
    
    private boolean esMedicoDisponible(Medico medico, LocalDateTime fechaHora) throws CitaException{
        boolean medicoDisponible = false;
        List<Cita> citasMedico = getCitasPorMedico(medico);
        if (citasMedico == null || citasMedico.isEmpty()){
            // si no hay cita con ese medico esta disponible.
            medicoDisponible = true;
        } else {
            for (Cita c : citasMedico){
                if (c.getEstado() == EstadoCita.CANCELADA || !seSuperponen(c.getFechaHora(), fechaHora)){
                    medicoDisponible = true;
                    
                } else {
                   throw new CitaException("Error: El medico ya tiene otra cita a menos de 2 horas");
                   
                }
            }
            
        }
        
        return medicoDisponible;
    }
    
    private boolean esSalaDisponible(Sala sala, LocalDateTime fechaHora) throws CitaException{
        boolean salaDisponible = false;
        List<Cita> citasSala = getCitasPorSala(sala);
        if(citasSala == null || citasSala.isEmpty()){
            // si no hay cita creada con esa sala esta disponible.
            salaDisponible = true;
        } else {
            for (Cita c: citasSala) {
                if(c.getEstado() == EstadoCita.CANCELADA || !seSuperponen(c.getFechaHora(), fechaHora)){
                    salaDisponible = true;
                } else {
                    throw new CitaException("Error: La sala ya tiene asignada una cita a menos de 2 horas");
                }
            }
        }
        
        return salaDisponible;
    }
    
    private boolean seSuperponen(LocalDateTime existente, LocalDateTime nueva ){
        LocalDateTime desde = existente.minusHours(HORAS_ENTRE_CITAS);
        LocalDateTime hasta = existente.plusHours(HORAS_ENTRE_CITAS);
        
        return nueva.isAfter(desde) && nueva.isBefore(hasta);

    }
    
    private void noNulo(Object valor, String mensage) throws CitaException{
        if (valor == null){
            throw new CitaException(mensage);
            
        }

    }
}
