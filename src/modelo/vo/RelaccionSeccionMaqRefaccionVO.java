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
public class RelaccionSeccionMaqRefaccionVO extends VoGenerales{
    
    private int idRefaccion;
    private int idSeccionMaquina;

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public int getIdSeccionMaquina() {
        return idSeccionMaquina;
    }

    public void setIdSeccionMaquina(int idSeccionMaquina) {
        this.idSeccionMaquina = idSeccionMaquina;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
