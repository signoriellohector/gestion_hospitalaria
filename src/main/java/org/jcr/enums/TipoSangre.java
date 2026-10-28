/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.jcr.enums;

/**
 *
 * @author signo
 */
public enum TipoSangre {
    A_POSITIVO ("A+"),
    A_NEGATIVO ("A-"),
    B_POSITIVO ("B+"),
    B_NEGATIVO ("B-"),
    AB_POSITIVO ("AB+"),
    AB_NEGATIVO ("AB-"),
    O_POSITIVO ("O+"),
    O_NEGATIVO ("O-");
    private final String descripcion;

    private TipoSangre(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
        
    
}
