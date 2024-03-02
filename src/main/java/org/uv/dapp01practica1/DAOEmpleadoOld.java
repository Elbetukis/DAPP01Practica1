/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alber
 */
public class DAOEmpleadoOld {

    public boolean guardar(PojoEmpleado empleado) {
        Connection con = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/dappDB";
            String usr = "postgres";
            String pwd = "postgres";
            con = DriverManager.getConnection(url, usr, pwd);
            
            String sql = "INSERT INTO empleado(nombre, direccion, telefono)"+
                    "values(?,?,?)";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, empleado.getNombre());
            pstm.setString(2, empleado.getDireccion());
            pstm.setString(3, empleado.getTelefono());
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleadoOld.class.getName()).log(Level.SEVERE, "error");
        }
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOEmpleadoOld.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    public boolean eliminar() {
        return true;
    }

    public boolean modificar() {
        return true;
    }

    public PojoEmpleado buscarById(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/dappDB";
            String usr = "postgres";
            String pwd = "postgres";
            con = DriverManager.getConnection(url, usr, pwd);
            String sql = "SELECT * FROM empleado WHERE id = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet reg = pstm.executeQuery();
            if (reg.next()) {
                PojoEmpleado empleado = new PojoEmpleado();
                empleado.setId(reg.getInt(1));
                empleado.setNombre(reg.getString(2));
                empleado.setDireccion(reg.getString(3));
                empleado.setTelefono(reg.getString(4));
                return empleado;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleadoOld.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOEmpleadoOld.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pstm!=null) {
            try {
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOEmpleadoOld.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public String buscarAll() {
        return "";
    }
}
