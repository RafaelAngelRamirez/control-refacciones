/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.RelacionRefaccionProveedorIT;

/**
 *
 * @author Particular
 */
public class RelacionRefaccionProveedorVo extends VoGenerales{
    
    int idRefaccion;
    int idProveedor;
    RefaccionVo refaccionVo;
    ProveedorVo proveedorVo;

    public RelacionRefaccionProveedorVo() {
        RelacionRefaccionProveedorIT i = new RelacionRefaccionProveedorIT();
        
        relacionCampo.put(i.getIdProveedorPDC().getNombre(), ()->this.getIdProveedor());
        relacionCampo.put(i.getIdRefaccionPDC().getNombre(), ()->this.getIdProveedor());
    
    }

    public RefaccionVo getRefaccionVo() {
        return refaccionVo;
    }

    public void setRefaccionVo(RefaccionVo refaccionVo) {
        this.refaccionVo = refaccionVo;
    }

    public ProveedorVo getProveedorVo() {
        return proveedorVo;
    }

    public void setProveedorVo(ProveedorVo proveedorVo) {
        this.proveedorVo = proveedorVo;
    }
    
    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
}
