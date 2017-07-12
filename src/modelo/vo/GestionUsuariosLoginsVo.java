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
public class GestionUsuariosLoginsVo {
    
    int id;
    int idUsuario;
    String inicioDeSecion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getInicioDeSecion() {
        return inicioDeSecion;
    }

    public void setInicioDeSecion(String inicioDeSecion) {
        this.inicioDeSecion = inicioDeSecion;
    }

    public String getFinDeSecion() {
        return finDeSecion;
    }

    public void setFinDeSecion(String finDeSecion) {
        this.finDeSecion = finDeSecion;
    }
    String finDeSecion;
    
    
    
}
