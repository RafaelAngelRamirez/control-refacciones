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
        
        relacionCampo.put(i.getID_PROVEEDOR().getNombre(), ()->this.getIdProveedor());
        relacionCampo.put(i.getID_REFACCION().getNombre(), ()->this.getIdProveedor());
    
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

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
