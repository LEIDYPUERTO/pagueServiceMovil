package logica;
// Generated 18/04/2015 08:11:28 PM by Hibernate Tools 4.3.1



public class Cliente  implements java.io.Serializable {


     private int cedula;
     private String nombre;
     private String genero;
     private String contrasena;

    /**
     * Constructor de la clase Cliente.java 
     */
    public Cliente() {
    	
    }

    public Cliente(int cedula, String nombre, String genero, String contrasena) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.genero = genero;
       this.contrasena = contrasena;
    }
   
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}

