/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author alber
 */
@Entity(name  = "empleadoUV")
public class PojoEmpleado implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleadosUV_id_seq")
    @SequenceGenerator(name = "empleadosUV_id_seq", sequenceName = "empleadosUV_id_seq", initialValue = 1, allocationSize = 1)
    long id;
    
    @Column
    String nombre;
    
    @Column
    String direccion;
    
    @Column
    String telefono;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
