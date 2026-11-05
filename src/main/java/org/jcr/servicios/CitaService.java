/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.jcr.servicios;

import java.time.LocalDateTime;
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
public interface CitaService {
    public Cita programarCita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) throws CitaException;
    
    public List<Cita> getCitasPorPaciente(Paciente paciente);
    
    public List<Cita> getCitasPorMedico(Medico medico);
    
    public List<Cita> getCitasPorSala(Sala sala);
}
