
package model;

import java.util.Date;



public class Incidencia {
    

    private String tipoPlazo;
    private String detalle;
    private Date fechaCreacion;
    private Departamento departamentoIncidencia;
    private Boolean completada;
    
    
    
    public Incidencia(){
        
    }

    public Incidencia(Departamento departamentoIncidencia, String tipoPlazo, String detalle, Date fechaCreacion, Boolean completada) {
        this.departamentoIncidencia = departamentoIncidencia;
        this.tipoPlazo = tipoPlazo;
        this.detalle = detalle;
        this.fechaCreacion = fechaCreacion;
        this.completada = completada;
    }
    //Constructor añadido por defecto, CUIDADO
//    public Incidencia(String departamento, String tipoPlazo, String detalle, String completada) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    

    public Departamento getDepartamentoIncidencia() {
        return departamentoIncidencia;
    }

    public void setDepartamentoIncidencia(Departamento departamentoIncidencia) {
        this.departamentoIncidencia = departamentoIncidencia;
    }

    public String getTipoPlazo() {
        return tipoPlazo;
    }

    public void setTipoPlazo(String tipoPlazo) {
        this.tipoPlazo = tipoPlazo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }
 
}
