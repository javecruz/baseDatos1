package Agenda;

import DAO.AñadirContacto;
import DAO.ConsultarContacto;
import DAO.EliminarContacto;
import DAO.ModificarContacto;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejecucion {

    public static void main(String[] args) {

        opciones();

    }

    public static void opciones() {
        
        int opt;
        Scanner tec = new Scanner(System.in);
        do {
        do {
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("\t1 = Añadir contacto");
            System.out.println("\t2 = Eliminar contacto por ID");
            System.out.println("\t3 = Consultar contacto por ID");
            System.out.println("\t4 = Modificar algo");
            System.out.println("\t5 = Salir");
            opt = tec.nextInt();
            // consumo linea
            tec.nextLine();

            if (opt < 1 || opt > 5) {
                System.out.println("ERROR, vuelva introducir");
            }

        } while (opt < 1 || opt > 5);

        
        
        switch (opt){
        
        
        
            case 1:
                AñadirContacto aña = new AñadirContacto();
                aña.proceso();
                break;
                
            case 2:   
                EliminarContacto eli = new EliminarContacto();
                eli.proceso();
                break;
                
            case 3:
                ConsultarContacto consu = new ConsultarContacto();
                consu.proceso();
                break;
                
            case 4:
                ModificarContacto modi = new ModificarContacto();
                modi.proceso();
                
                break;
                
 
        
        }
        
        
        
        } while(opt!=5);
        
        
        
        
    }

}
