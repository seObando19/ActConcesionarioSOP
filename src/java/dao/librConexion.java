/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class librConexion {
    //metodo estatico para establecer la conexion
    //Metodo para la aplicacion web
    public static Connection conectarDB(){
        //try catch -> identificar los errores
        try {
            //Datos conexion 
            String dbDriver = "com.mysql.jdbc.Driver";            
            String dbUrl = "jdbc:mysql://localhost:3306/";
            
            //Datos db
            String dbName = "concesionarioFlota";
            String dbUser = "root";
            String dbPassword = "";
            
            //Configurar la conexion
            Class.forName(dbDriver);
            Connection conex = DriverManager.getConnection(dbUrl + dbName,dbUser,dbPassword);
            
            return conex;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }       
    }
    
    //Metodo para probar la conexion   
    /*Connection con = null;
    public librConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario","root","");
            
            boolean ok = con.isValid(5000);
            System.out.println(ok ? "Conexion bien" : "Conexion fallo");
            
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());            
        } catch (ClassNotFoundException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
    
    public Connection getConnection()
    {
        return con;
    }*/
}
