/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.RefaccionIT;

/**
 *
 * @author Particular
 */
public class RefaccionVo extends VoGenerales{
    int id;
    String nombre;
    Object idMaterial;
    Object importancia;
    double stockMaximo;
    double stockMinimo;
    Object unidad;
    String codigoInterno;
    String codigoProveedor;
    String descripcion;
    String queEs;
    String paraQueEs;

    public RefaccionVo() {
        RefaccionIT it = new RefaccionIT();
        
        relacionCampo.put(it.getCodigoProveedorPDC().getNombre(), ()->this.getCodigoProveedor());
        relacionCampo.put(it.getCodigoInternoPDC().getNombre(), ()->this.getCodigoInterno());
        relacionCampo.put(it.getDescripcionPDC().getNombre(), ()->this.getDescripcion());
        relacionCampo.put(it.getIdPDC().getNombre(), ()->this.getId());
        relacionCampo.put(it.getIdMaterialPDC().getNombre(), ()->this.getIdMaterial());
        relacionCampo.put(it.getImportanciaPDC().getNombre(), ()->this.getImportancia());
        relacionCampo.put(it.getNombrePDC().getNombre(), ()->this.getNombre());
        relacionCampo.put(it.getParaQueEsPDC().getNombre(), ()->this.getParaQueEs());
        relacionCampo.put(it.getQueEsPDC().getNombre(), ()->this.getQueEs());
        relacionCampo.put(it.getStockMaximoPDC().getNombre(), ()->this.getStockMaximo());
        relacionCampo.put(it.getStockMinimoPDC().getNombre(), ()->this.getStockMinimo());
        relacionCampo.put(it.getUnidadPDC().getNombre(), ()->this.getUnidad());
    
    }

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

    public Object getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Object idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Object getImportancia() {
        return importancia;
    }

    public void setImportancia(Object importancia) {
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

    public Object getUnidad() {
        return unidad;
    }

    public void setUnidad(Object unidad) {
        this.unidad = unidad;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
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

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
}
