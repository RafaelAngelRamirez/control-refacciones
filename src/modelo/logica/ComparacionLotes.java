/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.vo.EntradaLoteVo;

/**
 *
 * @author Particular
 */
public class ComparacionLotes {
    
    EntradaLoteVo lote;
    //GUARDAMOS TEMPORALMENTE LA EXISTENCIA POR SI SE NECESITA
    //MODIFICAR DE NUEVO LA REFACCIÓN.
    private float nuevaExistenciaTemporal;
    private boolean modificado = false;
    private float existenciaModificadaPorUsuario;

    public ComparacionLotes(EntradaLoteVo lote) {
        this.lote = lote;
    }

    public EntradaLoteVo getLote() {
        return lote;
    }

    public void setLote(EntradaLoteVo lote) {
        this.lote = lote;
    }

    public boolean isModificado() {
        return modificado;
    }

    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }

    public float getExistenciaModificadaPorUsuario() {
        return existenciaModificadaPorUsuario;
    }

    public void setExistenciaModificadaPorUsuario(float existenciaModificadaPorUsuario) {
        this.existenciaModificadaPorUsuario = existenciaModificadaPorUsuario;
    }

    public float getNuevaExistenciaTemporal() {
        return nuevaExistenciaTemporal;
    }

    public void consolidar() {
        lote.setCantidad(nuevaExistenciaTemporal);
    }

    public float restarDelTotal(float totalSalida) {
        //TOTAL SALIDA DEBE SER MAYOR QUE 0 DE LO CONTRARIO
        //LOS OTRO LOTES YA CONSUMIERON LA SALIDA.
        if (totalSalida > 0) {
            modificado = true;
            //EL TOTAL TIENE MAS QUE EL LOTE.
            if (totalSalida > lote.getCantidad()) {
                float paraResta = lote.getCantidad();
                nuevaExistenciaTemporal = 0;
                return totalSalida - paraResta;
            } else {
                //EL TOTAL TIENE MENOS QUE EL LOTE.
                float cantidadDeLote = lote.getCantidad() - totalSalida;
                nuevaExistenciaTemporal = cantidadDeLote;
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String a = lote.toString();
        
        a+="\n modificado por comparación: "+modificado;
        a+="\n existencia temp: "+nuevaExistenciaTemporal;
        a+="\n existencia usuar: "+existenciaModificadaPorUsuario;
        return a;
    }
    
    
    
}
