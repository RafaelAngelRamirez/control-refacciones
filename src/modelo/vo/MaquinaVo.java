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
public class MaquinaVo {
    int id;
    int idMaquinasModelo;
    String descripcion;
    int idMarca;
    String numeroDeMaquina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMaquinasModelo() {
        return idMaquinasModelo;
    }

    public void setIdMaquinasModelo(int idMaquinasModelo) {
        this.idMaquinasModelo = idMaquinasModelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNumeroDeMaquina() {
        return numeroDeMaquina;
    }

    public void setNumeroDeMaquina(String numeroDeMaquina) {
        this.numeroDeMaquina = numeroDeMaquina;
    }
    
}
