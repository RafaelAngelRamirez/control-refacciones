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
    byte refaccionDeConsumoUnico;

    public RefaccionVo() {
        
        relacionCampo.put(RefaccionIT.getCODIGO_PROVEEDOR().getNombre(), ()->this.getCodigoProveedor());
        relacionCampo.put(RefaccionIT.getCODIGO_INTERNO().getNombre(), ()->this.getCodigoInterno());
        relacionCampo.put(RefaccionIT.getDESCRIPCION().getNombre(), ()->this.getDescripcion());
        relacionCampo.put(RefaccionIT.getID().getNombre(), ()->this.getId());
        relacionCampo.put(RefaccionIT.getID_MATERIAL().getNombre(), ()->this.getIdMaterial());
        relacionCampo.put(RefaccionIT.getIMPORTANCIA().getNombre(), ()->this.getImportancia());
        relacionCampo.put(RefaccionIT.getNOMBRE().getNombre(), ()->this.getNombre());
        relacionCampo.put(RefaccionIT.getPARA_QUE_ES().getNombre(), ()->this.getParaQueEs());
        relacionCampo.put(RefaccionIT.getQUE_ES().getNombre(), ()->this.getQueEs());
        relacionCampo.put(RefaccionIT.getSTOCK_MAXIMO().getNombre(), ()->this.getStockMaximo());
        relacionCampo.put(RefaccionIT.getSTOCK_MINIMO().getNombre(), ()->this.getStockMinimo());
        relacionCampo.put(RefaccionIT.getREFACCION_DE_CONSUMO_UNICO().getNombre(), ()->this.getRefaccionDeConsumoUnico());
        relacionCampo.put(RefaccionIT.getUNIDAD().getNombre(), ()->this.getUnidad());
    
    }

    public boolean equals(RefaccionVo vo) {
        return vo.getId()==getId();
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

    public byte getRefaccionDeConsumoUnico() {
        return refaccionDeConsumoUnico;
    }

    public void setRefaccionDeConsumoUnico(byte refaccionDeConsumoUnico) {
        this.refaccionDeConsumoUnico = refaccionDeConsumoUnico;
    }
    
    

    @Override
    public String toString() {
        String a = "Clase: "+this.getClass().getSimpleName()+"\n";
        String b= "       | ";
        
        String c =  "\n                     Id" +b+ id+
                    "\n                 nombre" +b+ nombre+    
                    "\n             idMaterial" +b+ idMaterial+    
                    "\n            importancia" +b+ importancia+   
                    "\n            stockMaximo" +b+ stockMaximo+   
                    "\n            stockMinimo" +b+ stockMinimo+   
                    "\n                 unidad" +b+ unidad+    
                    "\n          codigoInterno" +b+ codigoInterno+ 
                    "\n        codigoProveedor" +b+ codigoProveedor+   
                    "\n            descripcion" +b+ descripcion+   
                    "\n                  queEs" +b+ queEs+ 
                    "\nrefaccionDeConsumoUnico" +b+ refaccionDeConsumoUnico+
                    "\n              paraQueEs" +b+ paraQueEs;

        String d =  "----------------------";
        
        
        return a+d+c+d;
    }
    
            
}
