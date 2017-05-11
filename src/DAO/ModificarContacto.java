package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarContacto {
    
    
    public void proceso(){
    
        try {
            Conexion random = new Conexion();
            Connection con = random.AbrirConexion();
            Scanner tec = new Scanner(System.in);
            
            
            
            // para hacer esto, primero se hace un select se pone todo en variables, se pregunta que quiere cambiar de todo (menos id), se cambia y luego hago un update de todo sobreescribiendo
            
            
            
            //primero muestro todo para ver que usuario quieres cambiar
            String query = "select * from contacto";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                
                System.out.println("ID:  " + rs.getInt("Id") +"\tNOMBRE:  " +  rs.getString("Nombre")+ "\tID:  " + rs.getString("Apellidos")+ "\tTelefono:  " + rs.getString("Telefono") + "\tFecha Nacimiento:  "+ rs.getDate("Nacimiento"));
                System.out.println();
            }
            System.out.println("----------FIN DE CONTACTOS---------- \n");
            
            
            // ahora pido la id del usuario que quiera cambiar y hago un select de todo de SOLO ese usuario, podria haberme guardado todos los anteriores en un arraylist... y asi me ahorraria esta consulta... pero eso ya es más tiempo..
            System.out.println("Dame la ID del usuario que quieras cambiar");
            int ide = tec.nextInt();
            tec.nextLine(); // consumo linea
            
            
            
            
            String query2 = "select * from contacto where Id=?";
            PreparedStatement st2 = con.prepareStatement(query2);
            st2.setInt(1,ide);
            ResultSet rs2 = st2.executeQuery();
            rs2.next();
            
            String name = rs2.getString("Nombre");
            String surname = rs2.getString("Apellidos");
            String telefono = rs2.getString("Telefono");
            Date nacimiento = rs2.getDate("Nacimiento");
            
            int opt;
            do{
                do{
            System.out.println("Qué quieres cambiar?");
            System.out.println("1 = Nombre");
            System.out.println("2 = Apellidos");
            System.out.println("3 = Telefono");
            System.out.println("4 = FechaNacimiento");
            System.out.println("5 = SALIR");
            opt = tec.nextInt();
            tec.nextLine(); // quemo linea
            if(opt<1 || opt>5){
                System.out.println("ERROR, introduce un valor valido");
            }   
                }while(opt<1 || opt>5);
            
            
               switch (opt){
               
                   case 1:
                       System.out.println("Nombre nuevo?");
                       name = tec.nextLine();
                       break;
                       
                       
                   case 2:
                       System.out.println("Apellidos nuevo?");
                       surname = tec.nextLine();
                       
                       break;
                       
                   case 3:
                       System.out.println("Telefono nuevo?");
                       telefono = tec.nextLine();
                       
                       break;
                       
                   case 4:
                       System.out.println("Dame la fecha de nacimiento EN ESTE FORMATO año-mes-dia");
                       String fecha = tec.nextLine();
                       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                {
                    try {
                        nacimiento = df.parse(fecha);
                        //ME QUEDE AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                    } catch (ParseException ex) {
                        System.out.println("error en el parse de la fecha al modificarla");
                        Logger.getLogger(ModificarContacto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                       
                      
                       break;
                    
               
               
               
               }
                
                
            
            }while(opt!=5);
            
            //necesito pasar el Date a sqlDate sino da una expceción, intente parsearlo pero no es suficiente
            java.sql.Date sqlDate = new java.sql.Date(nacimiento.getTime());
            
            String query3 = "update contacto set Nombre=?, Apellidos=?, Telefono=?, Nacimiento=? where Id=?";
            PreparedStatement st3 = con.prepareStatement(query3);
            st3.setString(1, name);
            st3.setString(2, surname);
            st3.setString(3, telefono);
            st3.setDate(4, sqlDate);
            st3.setInt(5, ide);
            st3.executeUpdate();
            
            
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModificarContacto.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
