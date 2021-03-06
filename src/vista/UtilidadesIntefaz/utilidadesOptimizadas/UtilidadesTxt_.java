/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;
import controlador.Coordinador;
import javax.swing.JTextField;

/**
 *
 * @author Particular
 */
public class UtilidadesTxt_ extends OperacionesBasicasPorDefinir{
    
    //Coordinador coordinador;
    JTextField txt;

    public UtilidadesTxt_(Coordinador coordinador) {
        super(coordinador);
    }

    /**
     * Setea el JTexField que se le pase como parametro. 
     * @param txt Componente que se manejara. 
     */
    public void setComponente(JTextField txt) {
        this.txt = txt;
        this.txt.setText("");
    }
    
    @Override
    public void setText(String txt){
        this.txt.setText(txt);
    }


    
    public String getText(){
        String texto = this.quitarEspaciosSobrantes(this.txt.getText());
        return texto;
    };
    /**
     * Revisa que el JTextField este vacio incluyendo una revición de espacios
     * en blanco.
     * @return True si esta vacio.
     */
    public boolean isEmpty(){
        String texto = this.getText();
        if (texto.equals("")) {
            return true;
        }
        return false;
    }

    @Override
    public void setError() {
        this.setCampoTextoError(this.txt);
    }
    
    public void setError(String mensajeDeError){
        this.setMensajeDeError(mensajeDeError);
        this.setError();
        this.mostrarError();
        this.setFocus();
    }
    
    public void setErrorQuitar(){
        this.setCampoTextoRestaurar(this.txt);
    }

    public void setFocus() {
        this.txt.requestFocusInWindow();
    }

    public JTextField getThis() {
        return this.txt;
    }

    public void setEditable(boolean editable) {
        
        this.txt.setEditable(editable);
        
        
    }
    
}
