/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

import controlador.Coordinador;
import java.awt.Component;
import javax.swing.JTextArea;
import vista.UtilidadesIntefaz.OperacionesBasicasPorDefinir;

/**
 *
 * @author Particular
 */
public class UtilidadesTxtArea_ extends OperacionesBasicasPorDefinir{

    private JTextArea txt;

    public UtilidadesTxtArea_(Coordinador coordinador) {
        super(coordinador);
    }

    
    public boolean isEmpty(){
        return this.txt.getText().equals("");
    }
    
    public void setComponente(JTextArea txt) {
        this.txt = txt;
        this.txt.setText("");
    }

    @Override
    public String getText() {
        String texto = this.txt.getText();
        return this.quitarEspaciosSobrantes(texto);
    }

    @Override
    public void setText(String txt) {
        this.txt.setText(txt);
    }

    @Override
    public void setError() {
        this.setCampoTextoAreaError(this.txt);
       
    }
    public void setError(String mensajeDeError) {
        this.setMensajeDeError(mensajeDeError);
        this.setError();
        this.mostrarError();
        this.setFocus();
    }
    
    public void setErrorQuitar() {
        this.setCampoTextoAreaRestaurar(this.txt);
       
    }

    @Override
    public void setFocus() {
        this.txt.requestFocusInWindow();
    }

    @Override
    public Component getThis() {
        return this.txt;
    }

    @Override
    public void setEditable(boolean editable) {
        this.txt.setEditable(editable);
    }

    
    
         
    
}
