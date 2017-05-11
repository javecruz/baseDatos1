package DAO;

import Entidad.Contacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AñadirContacto {
    
    
    
    /*public static void main() throws SQLException{
    proceso();
    }*/
    
    
    public void proceso() {
        try {
            Conexion random = new Conexion();
            
            Connection con = random.AbrirConexion();
            Scanner tec = new Scanner(System.in);
            
            String name;
            String surname;
            String tlf;
            String fnac;
            
    
            System.out.println("Dame el nombre");
            name = tec.nextLine();
            System.out.println("Dame los apellidos");
            surname = tec.nextLine();
            System.out.println("Dame el telefono");
            tlf = tec.nextLine();
            // en sql el date es año-mes-dia
            System.out.println("Dame la fecha de nacimiento EN ESTE FORMATO año-mes-dia");
            fnac = tec.nextLine();
            
            Contacto contact = new Contacto(name,surname,tlf,fnac);
            
            
            
            
            
            String query = "insert into contacto(Nombre, Apellidos, Telefono, Nacimiento) values (?,?,?,?)";
            
            
            // la movida de las fecha.. aqui viene
            java.util.Date myDate = contact.getfNacimiento();
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            
            //ahora viene el prepared
            
            PreparedStatement st = con.prepareStatement(query);
            
            st.setString(1, contact.getNombre());
            st.setString(2, contact.getApellidos());
            st.setString(3, contact.getTelefono());
            st.setDate(4, sqlDate);
            st.executeUpdate();
            
       
            con.close();
        } catch (SQLException ex) {
            System.out.println("problema en añadir contacto proceso");
            Logger.getLogger(AñadirContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
    
    
    
}
