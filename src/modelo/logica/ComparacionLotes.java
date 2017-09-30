/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.Comparator;
import javax.swing.JOptionPane;
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
    private float existenciaPreFinal;
    private float totalSalida;

    public ComparacionLotes(EntradaLoteVo lote) {
        this.lote = lote;
    }

    public EntradaLoteVo getLote() {
        return lote;
    }

    /**
     * El lote que queremos comparar. 
     * @param lote
     */
    public void setLote(EntradaLoteVo lote) {
        this.lote = lote;
    }

    /**
     * Retorna true si el lote a sido modificado despues de extraer la cantidad
     * ordenadamente del total y descontarselo a este. Se utiliza es una lista
     * que sea del mismo tipo que esta clase. 
     * 
     * @return 
     */
    public boolean isModificado() {
        return modificado;
    }
    
    /**
     * Nos ayuda a detectar si el lote ha sido modificado en la parte
     * donde evaluamos si hay lotes sobrantes sin modificaciones. El objetivo
     * es saber si es necesario mostrarle al usuario la opción para abrir
     * la lista de lotes y modificarlos indivudualmente. 
     * @param modificado
     */
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }

    /**
     * Retorna el valor que el usuario modifico en el 
     * PanelSalidaLoteCantidadADescontarDeLote para posteriormente 
     * consolidarlo en la operacion.
     * consolidarExistenciaModificadaPorUsuario(). 
     * @return
     */
    public float getExistenciaModificadaPorUsuario() {
        return existenciaModificadaPorUsuario;
    }
    /**
     * Setea el valor que el usuario modifico en el 
     * PanelSalidaLoteCantidadADescontarDeLote para posteriormente 
     * consolidarlo en la operacion.
     * consolidarExistenciaModificadaPorUsuario(). 
     * @return
     */
    public void setExistenciaModificadaPorUsuario(float existenciaModificadaPorUsuario) {
        this.existenciaModificadaPorUsuario = existenciaModificadaPorUsuario;
    }
    
    /**
     * Retorna la exitencia temporal que se hace de la resta automática ordenada
     * del lote mas viejo al mas nuevo descontando los lotes
     */
    public float getNuevaExistenciaTemporal() {
        return nuevaExistenciaTemporal;
    }
    
    /**
     * Retorna el valor de existencia previa a las modificaciones en la BD.
     * Este dato es el que se obtiene cuando se calcula automaticamente 
     * el descuento de lotes contra la cantidad total de salida. Cuando el lote
     * es superado por la cantidad de salida entonces este valor es siempre 0 pero 
     * si el lote es mayor a la cantidad de salida este valor devuelve el restante
     * de el lote. 
     * @return
     */
    public float getExistenciaPreFinal() {
        return existenciaPreFinal;
    }

   /**
     * Setea el valor de existencia previa a las modificaciones en la BD.
     * Este dato es el que se obtiene cuando se calcula automaticamente 
     * el descuento de lotes contra la cantidad total de salida. Cuando el lote
     * es superado por la cantidad de salida entonces este valor es siempre 0 pero 
     * si el lote es mayor a la cantidad de salida este valor devuelve el restante
     * de el lote. 
     * @param existenciaPreFinal
     */
    public void setExistenciaPreFinal(float existenciaPreFinal) {
        this.existenciaPreFinal = existenciaPreFinal;
    }
    
    /**
     * Se utiliza para consolidad la cantidad final que tendra el lote cuando
     * el usuario a modificado la salida por lote. 
     */
    public void consolidarExistenciaModificadaPorUsuario(){
        lote.setCantidad(existenciaModificadaPorUsuario);
    }
    
    /**
     * Convierte el estimado generado automaticamente de salida en la nueva cantidad
     * del lote. Este se utilizara para reescribir el lote en la BD y guardar las 
     * salidas.
     */
    public void consolidar() {
        lote.setCantidad(nuevaExistenciaTemporal);
    }
    
    /**
     * Retorna el total de la salida modificada. Esta se modifica desde el 
     * PanelSalidaDeLoteCantidadADescontar y es el dato que el usuario ingresa
     * en la casilla. 
     * @return
     */
    public float getTotalSalida() {
        return totalSalida;
    }

    /**
     *
     * Setea el total de la salida modificada por el usuario. Esta se modifica desde el 
     * PanelSalidaDeLoteCantidadADescontar y es el dato que el usuario ingresa
     * en la casilla. 
     * @param totalSalida El dato que ingreso el suario. 
     */
    public void setTotalSalida(float totalSalida) {
        this.totalSalida = totalSalida;
    }
    
    /**
     * Toma el total como parametro (el total de la salida de la refacción)
     * y modifca sus valores para detectar si hay algún cambio. 
     * 
     * En esta función tambien se define {@see getExistenciaPreFinal()} y 
     * {@see getNuevaExistenciaTemporal()}
     * 
     * @param totalSalida
     * @return El totalSalida menos la existencia de la refacción . Si la existencia
     * no alcanza estonces la modifica a 0 y retorna la salida de lo contrario
     * a nuevaExistenciaTemporal le asigna la resta y retorna 0;
     */
    public float restarDelTotal(float totalSalida) {
        //TOTAL SALIDA DEBE SER MAYOR QUE 0 DE LO CONTRARIO
        //LOS OTRO LOTES YA CONSUMIERON LA SALIDA.
        if (totalSalida > 0) {
            modificado = true;
            //EL TOTAL TIENE MAS QUE EL LOTE.
            if (totalSalida > lote.getCantidad()) {
                float paraResta = lote.getCantidad();
                nuevaExistenciaTemporal = 0;
                existenciaPreFinal = paraResta;
                return totalSalida - paraResta;
            } else {
                //EL TOTAL TIENE MENOS QUE EL LOTE.
                float cantidadDeLote = lote.getCantidad() - totalSalida;
                nuevaExistenciaTemporal = cantidadDeLote;
                existenciaPreFinal = lote.getCantidad()-cantidadDeLote;
                return 0;
            }
        }else{
            existenciaPreFinal = 0;
            return 0;
        }
    }

    @Override
    public String toString() {
        String a = lote.toString();
        
        a+="\n modificado por comparación: "+modificado;
        a+="\n existencia temp: "+nuevaExistenciaTemporal;
        a+="\n existencia usuar: "+existenciaModificadaPorUsuario;
        return a;
    }
    
    
    public static Comparator<ComparacionLotes> LoteComparador = new Comparator<ComparacionLotes>() {
        @Override
        public int compare(ComparacionLotes o1, ComparacionLotes o2) {
            EntradaLoteVo vo1 = o1.getLote();
            EntradaLoteVo vo2 = o2.getLote();
            
            int r = vo1.getFechaRecepcionLote().compareTo(vo2.getFechaRecepcionLote());
            
            if (r==0) {
                if(vo1.getId()>vo2.getId()) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return r;
        }
    };
    
    
    
}
