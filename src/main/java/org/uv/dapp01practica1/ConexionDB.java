/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alber
 */
public class ConexionDB {
    private static ConexionDB cx = null;
    
    static ConexionDB getInstance(){
        if(cx == null)
            cx = new ConexionDB();
        return cx;
    }
    
    private Connection con = null;
    private ConexionDB() {
        try {
            String url = "jdbc:postgresql://localhost:5432/dappDB";
            String usr = "postgres";
            String pwd = "postgres";
            con = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean execute(String sql){
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean execute(TransactionDB tra){
        return tra.execute(con);
    }
    
}
