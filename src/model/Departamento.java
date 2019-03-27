
package model;


public class Departamento {
    
    private String nombreDepartamento;
    private int capacidadMAX;
    private String gerente;
    
    public Departamento(){
        
    }
    
    public Departamento(String nombreDepartamento, int capacidadMAX, String gerente){
        this.nombreDepartamento = nombreDepartamento;
        this.capacidadMAX = capacidadMAX;
        this.gerente = gerente;    
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getCapacidadMAX() {
        return capacidadMAX;
    }

    public void setCapacidadMAX(int capacidadMAX) {
        this.capacidadMAX = capacidadMAX;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
    
    
}
