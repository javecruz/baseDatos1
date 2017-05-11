package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    Connection con;
    
    
    
    
    public Connection AbrirConexion(){
        
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.20.189:3306/agenda";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion BBDD ABRIENDO");
                    
                    
                    } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR EN LA CONEXION CON BBDD");
        }
        
        return con;
    }
    
    
    public void CerrarConexion() {
    
        if(con!=null){
        
            try {
                con.close();
                System.out.println("Conexion BBDD CERRADA");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    
    
    
    }
    
    
    
    
}
