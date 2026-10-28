/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.jcr.enums;

/**
 *
 * @author signo
 */
public enum EstadoCita {
    PROGRAMADA ("Programada"), EN_CURSO ("En Curso"), COMPLETADA ("Completada"),
    CANCELADA ("Cancelada"), NO_ASISTIO ("No Asistió");
    private final String descripcion;

    private EstadoCita(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
