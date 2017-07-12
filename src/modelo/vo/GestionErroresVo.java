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
public class GestionErroresVo {
    
    int id;
    String hora;
    int idUsuarioActivo;
    String errorCapturado;
    String detalles;
    String ubicacionDelError;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdUsuarioActivo() {
        return idUsuarioActivo;
    }

    public void setIdUsuarioActivo(int idUsuarioActivo) {
        this.idUsuarioActivo = idUsuarioActivo;
    }

    public String getErrorCapturado() {
        return errorCapturado;
    }

    public void setErrorCapturado(String errorCapturado) {
        this.errorCapturado = errorCapturado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getUbicacionDelError() {
        return ubicacionDelError;
    }

    public void setUbicacionDelError(String ubicacionDelError) {
        this.ubicacionDelError = ubicacionDelError;
    }
    
    
    
    
    
    
}
