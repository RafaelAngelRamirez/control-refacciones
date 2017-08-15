/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import modelo.InfoTabla.RelacionRefaccionMaquinaModeloIT;

/**
 *
 * @author Particular
 */
public class RelacionRefaccionMaquinaModeloVo extends VoGenerales{
 
    int idMaquinaModelo;
    int idRefaccion;
    MaquinaModeloVo maquinaModeloVo;
    RefaccionVo refaccionVo;
            

    public RelacionRefaccionMaquinaModeloVo() {
        RelacionRefaccionMaquinaModeloIT i = new RelacionRefaccionMaquinaModeloIT();
        
        relacionCampo.put(i.getIdMaquinaModeloPDC().getNombre(),()->this.getIdMaquinaModelo());
        relacionCampo.put(i.getIdRefaccionPDC().getNombre(),()->this.getIdRefaccion());
    
    }

    public MaquinaModeloVo getMaquinaModeloVo() {
        return maquinaModeloVo;
    }

    public void setMaquinaModeloVo(MaquinaModeloVo maquinaModeloVo) {
        this.maquinaModeloVo = maquinaModeloVo;
    }

    public RefaccionVo getRefaccionVo() {
        return refaccionVo;
    }

    public void setRefaccionVo(RefaccionVo refaccionVo) {
        this.refaccionVo = refaccionVo;
    }
    

    public int getIdMaquinaModelo() {
        return idMaquinaModelo;
    }

    public void setIdMaquinaModelo(int idMaquinaModelo) {
        this.idMaquinaModelo = idMaquinaModelo;
    }

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
