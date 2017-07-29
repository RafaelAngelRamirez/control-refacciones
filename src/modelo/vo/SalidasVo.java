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
public class SalidasVo {
    int id;
    int idLotes;
    double cantidadQueSale;
    String fechaSalida;
    int idEmpleados;
    int idMaquinas;
    String observacionSalidas;

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

    public double getCantidadQueSale() {
        return cantidadQueSale;
    }

    public void setCantidadQueSale(double cantidadQueSale) {
        this.cantidadQueSale = cantidadQueSale;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public String getObservacionSalidas() {
        return observacionSalidas;
    }

    public void setObservacionSalidas(String observacionSalidas) {
        this.observacionSalidas = observacionSalidas;
    }
    
}
