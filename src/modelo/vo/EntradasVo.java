/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

/**
 *
 * @author Particular
 */
public class EntradasVo {
    
    int id;
    int idLotes;
    double cantidadQueEntra;
    String fechaEntrada;
    int idEmpleados;
    int idMaquinas;
    String observacionEntrada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLotes() {
        return idLotes;
    }

    public void setIdLotes(int idLotes) {
        this.idLotes = idLotes;
    }

    public double getCantidadQueEntra() {
        return cantidadQueEntra;
    }

    public void setCantidadQueEntra(double cantidadQueEntra) {
        this.cantidadQueEntra = cantidadQueEntra;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getIdEmpleados() {
        return idEmpleados;
    }

    public void setIdEmpleados(int idEmpleados) {
        this.idEmpleados = idEmpleados;
    }

    public int getIdMaquinas() {
        return idMaquinas;
    }

    public void setIdMaquinas(int idMaquinas) {
        this.idMaquinas = idMaquinas;
    }

    public String getObservacionEntrada() {
        return observacionEntrada;
    }

    public void setObservacionEntrada(String observacionEntrada) {
        this.observacionEntrada = observacionEntrada;
    }
    
    
    
    
    
}
