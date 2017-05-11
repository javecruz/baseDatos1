package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultarContacto {
    
    Conexion random = new Conexion();
    
    
    
     public void proceso(){
     
         try {
             
             Connection con = random.AbrirConexion();
             Scanner tec = new Scanner(System.in);
             
             
             System.out.println("Mira te voy a dar todos los nombres y la ID de la BBDD y me dices de quien quieres la información, ME DICES LA ID del nombre\n");
             
             String query = "select Nombre, Id from contacto";
             
             PreparedStatement st = con.prepareStatement(query);
             ResultSet rs = st.executeQuery();
             
             while (rs.next()){
                 System.out.println("NOMBRE:\t" +  rs.getString("Nombre")+ "\tID: " + rs.getInt("Id"));
             
             }
             System.out.println("----------FIN DE CONTACTOS---------- \n");
             
             
             
             
             
             
             // ahora pido de quien quiere la INFORMACION, le pide la id, podria pedirle nombre.. o las 2 cosas eso ya depende del enunciado
             //podria validar la id que introduce con las ids mostradas pero me llevaria tiempo, lo haria metiendo todas las ids que muestran en un array y validandolo con la información introducida por teclado...
             System.out.println("Ahora dame la ID del contacto que quieres buscar toda su información, NO LA VOY A VALIDAR, pon una que exista");
             int info;
             info = tec.nextInt();
             tec.nextLine(); // consumo linea, es por le nextInt sin esto al leer un string.. bueno... se hace y punto preguntame si hay dudas
             
             String query2 = "select * from contacto where Id=?";
             
             PreparedStatement st2 = con.prepareStatement(query2);
             st2.setInt(1,info);
             
             ResultSet rs2 = st2.executeQuery();
             
            
             
             System.out.println("---Aqui está toda su información---");
             
             rs2.next();
             System.out.println("ID:\t" + rs2.getInt("Id"));
             System.out.println("Nombre:\t" + rs2.getString("Nombre"));
             System.out.println("Apellidos:\t" + rs2.getString("Apellidos"));
             System.out.println("Telefono:\t" + rs2.getString("Telefono"));
             System.out.println("Fecha de Nacimiento:\t" + rs2.getDate("Nacimiento"));
             
         
             
             
             
             con.close();
             
             
         } catch (SQLException ex) {
             System.out.println("algun error en proceso de consultar");
             Logger.getLogger(ConsultarContacto.class.getName()).log(Level.SEVERE, null, ex);
         }
            
           
            
            
     
     
     
     
     
     
     
     
     }
    
    
    
    
    
    
    
    
    
}
