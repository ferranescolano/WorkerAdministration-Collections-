
package model;

import java.util.Date;

public class Empleado {

 
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private Date fechaContratacion;
    private String ciudadResidencia;
    private Departamento departamento;
    
    
    public Empleado(){
        
    }
    
    
    
       public Empleado(String usuario, String password, String nombre, String apellidos, Date fechaContratacion, String ciudadResidencia, Departamento departamento) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContratacion = fechaContratacion;
        this.ciudadResidencia = ciudadResidencia;
        this.departamento = departamento;
    }
        //Constructor añadido por defecto, CUIDADO
//    public Empleado(String usuario, String password, String nombre, String apellido, String fechaContratacion, String ciudadResidencia, String departamento) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
    
}
