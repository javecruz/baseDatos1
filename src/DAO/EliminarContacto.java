package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            
            
            
            String query = "select * from contacto";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                
                System.out.println("ID:  " + rs.getInt("Id") +"\tNOMBRE:  " +  rs.getString("Nombre")+ "\tID:  " + rs.getString("Apellidos")+ "\tTelefono:  " + rs.getString("Telefono") + "\tFecha Nacimiento:  "+ rs.getDate("Nacimiento"));
                System.out.println();
            }
            System.out.println("----------FIN DE CONTACTOS---------- \n");
            
   
            
            int ide;
            
            
            System.out.println("Dame la id que quieras eliminar");
            ide = tec.nextInt();
            tec.nextLine(); // consumo linea
            
            String query2 = "delete from contacto where Id=?";
            PreparedStatement st2 = con.prepareStatement(query2);
            st.setInt(1,ide);
            st.executeUpdate();
            System.out.println("Contacto Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(EliminarContacto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Algun problema en eliminar contacto proceso");
        }
            
    
    
    }
    
    
    
    
    
    
    
    
    
}
