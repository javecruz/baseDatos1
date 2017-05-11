package Entidad;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contacto{
    
    private int id;
    private String Nombre;
    private String Apellidos;
    private String Telefono;
    private Date fNacimiento;
    
    public Contacto(){
    
    }
    
    public Contacto(String Nombre, String Apellidos, String Telefono, String fNacimiento){
    
    this.Nombre = Nombre;
    this.Apellidos = Apellidos;
    this.Telefono = Telefono;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fNacimiento = df.parse(fNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Contacto.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the fNacimiento
     */
    public Date getfNacimiento() {
        return fNacimiento;
    }

    /**
     * @param fNacimiento the fNacimiento to set
     */
    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }
    
    
}
