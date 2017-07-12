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
public class LoginsVo {
    int id;
    int idUsuario;
    String marcaDeSeción;
    int inicioOFin;

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

    public String getMarcaDeSeción() {
        return marcaDeSeción;
    }

    public void setMarcaDeSeción(String marcaDeSeción) {
        this.marcaDeSeción = marcaDeSeción;
    }

    public int getInicioOFin() {
        return inicioOFin;
    }

    public void setInicioOFin(int inicioOFin) {
        this.inicioOFin = inicioOFin;
    }
    
}
