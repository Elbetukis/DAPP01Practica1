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
import javax.persistence.Table;

@Entity
@Table(name = "detalleventa")
public class VentaDetalle implements Serializable{
    
    @Id
    @Column(name="idlinea")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "detalleventa_idlinea_seq")
    @SequenceGenerator(name = "detalleventa_idlinea_seq",
            sequenceName = "detalleventa_idlinea_seq",
            initialValue = 1,
            allocationSize = 1)
    private long id;
    
    @Column
    private double cantidad;
    
    @Column
    private double precio;
    
    @Column
    private String producto;
    
    @Column
    private long idventa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public long getIdventa() {
        return idventa;
    }

    public void setIdventa(long idventa) {
        this.idventa = idventa;
    }
    
    
}