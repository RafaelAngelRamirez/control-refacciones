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
public class LotesVo {
    int id;
    String lote;
    double cantidad;
    int idRelacionProveedores;
    String fechaRecepcionLote;
    int idEmpleados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdRelacionProveedores() {
        return idRelacionProveedores;
    }

    public void setIdRelacionProveedores(int idRelacionProveedores) {
        this.idRelacionProveedores = idRelacionProveedores;
    }

    public String getFechaRecepcionLote() {
        return fechaRecepcionLote;
    }

    public void setFechaRecepcionLote(String fechaRecepcionLote) {
        this.fechaRecepcionLote = fechaRecepcionLote;
    }

    public int getIdEmpleados() {
        return idEmpleados;
    }

    public void setIdEmpleados(int idEmpleados) {
        this.idEmpleados = idEmpleados;
    }
    
    
    
}
