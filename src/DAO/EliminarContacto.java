package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EliminarContacto {
    
    
    
    public void proceso(){
    
        try {
            Conexion random = new Conexion();
            Connection con = random.AbrirConexion();
            Scanner tec = new Scanner(System.in);
            
            int ide;
            
            
            System.out.println("Dame la id que quieras eliminar");
            ide = tec.nextInt();
            tec.nextLine(); // consumo linea
            
            String query = "delete from contacto where Id=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,ide);
            st.executeUpdate();
            System.out.println("Contacto Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(EliminarContacto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Algun problema en eliminar contacto proceso");
        }
            
    
    
    }
    
    
    
    
    
    
    
    
    
}
