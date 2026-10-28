/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;

import java.time.LocalDate;
import java.time.MonthDay;
import org.jcr.enums.TipoSangre;

/**
 *
 * @author signo
 */
public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected LocalDate fechaNacimiento;
    protected TipoSangre tipoSangre;

    public Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipoSangre) {
        setNombre(nombre);
        setApellido(apellido);
        setDni(dni);
        setFechaNacimiento(fechaNacimiento);
        setTipoSangre(tipoSangre);
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    private void setTipoSangre(TipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }
    
    public String getNombreCompleto(){
        return nombre + " " + apellido;
        
    }
    
    public int getEdad(){
        // se obtiene la fecha actual.
        LocalDate fecha_actual = LocalDate.now();
        
        // se obtiene el cumpleaños de la persona con el año actual
        LocalDate cumpleanios = MonthDay.from(fechaNacimiento).atYear(fecha_actual.getYear());
        int edad = 0;
        
        if (cumpleanios.isBefore(fecha_actual) || cumpleanios.equals(fecha_actual)) {
            edad = fecha_actual.getYear() - fechaNacimiento.getYear();
        } else {
            edad = fecha_actual.getYear() - fechaNacimiento.getYear() - 1;
        }
        
        return edad;
    }
}
