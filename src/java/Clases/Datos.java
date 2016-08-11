/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alero_000
 */
public class Datos {
    private Connection cnn;
    
    public Datos () {
        try {
            Class.forName("com.msql.jdbc.Driver");
            String db = "jdbc:mysql://localhost/tigre";
            cnn = DriverManager.getConnection(db, "root", "123");
        } catch (Exception ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrarConexion() {
        try {
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean validarUsuario (String usuario, String clave){
        try {
            String sql = "select (1) from usuarios where "
                    + "idUsuario = '"+usuario+"' and "
                    +"clave = ' " +clave+ "'";
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 }
