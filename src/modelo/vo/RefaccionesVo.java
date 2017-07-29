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
public class RefaccionesVo {
    int id;
    String nombre;
    int idMaterial;
    int importancia;
    double stockMaximo;
    double stockMinimo;
    int unidad;
    String codigoRefaccion;
    String codigoProveedor;
    String descripcion;
    String queEs;
    String paraQueEs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getImportancia() {
        return importancia;
    }

    public void setImportancia(int importancia) {
        this.importancia = importancia;
    }

    public double getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(double stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public double getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public String getCodigoRefaccion() {
        return codigoRefaccion;
    }

    public void setCodigoRefaccion(String codigoRefaccion) {
        this.codigoRefaccion = codigoRefaccion;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getQueEs() {
        return queEs;
    }

    public void setQueEs(String queEs) {
        this.queEs = queEs;
    }

    public String getParaQueEs() {
        return paraQueEs;
    }

    public void setParaQueEs(String paraQueEs) {
        this.paraQueEs = paraQueEs;
    }
    
            
}
