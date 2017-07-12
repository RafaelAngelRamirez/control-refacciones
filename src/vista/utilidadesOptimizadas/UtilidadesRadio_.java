/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidadesOptimizadas;

import modelo.ExcepcionPersonalizada;
import controlador.Coordinador;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import vista.utilidadesOptimizadas.OperacionesBasicasPorDefinir_;

/**
 *
 * @author Particular
 */
public class UtilidadesRadio_ extends OperacionesBasicasPorDefinir_ {

    ButtonGroup grupo;
    List <JRadioButton> radios = new ArrayList<JRadioButton>();
    
    
    /**
     * Esta clase ingresa automaticamente los radio butons que se le pasen a 
     * setComponente en un grupo para acceder a ellos. 
     */
    public UtilidadesRadio_(Coordinador coordinador) {
        super(coordinador);
        this.exepcionALaReglaMayusculasYNumeros = true;
        this.grupo = new ButtonGroup();
    }

    /**
     * Va agrupando los radioButtons que se le pasen de manera automática. 
     * 
     * @param radio
     */
    public void setComponente(JRadioButton radio) {
        this.radios.add(radio);
        this.grupo.add(radio);
        this.coordinador.getSystemOut().println("[!]Radio button seteado: " + radio.getText());
    }
    
    /**
     * Retorna true si algúnos de los radioButtons esta seleccionado.  
     * @return 
     */
    public boolean isSelected(){
        for (JRadioButton radio : radios) {
            if (radio.isSelected()) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Retorna el texto del radiobutton seleccionado.  
     * @return 
     */
    @Override
    public String getText() {
        for (JRadioButton radio : radios) {
            if(radio.isSelected())
                return radio.getText();
        }
        return "";
    }

    /**
     * Señala un error sobre el radioButton.
     * 
     */
    public void setError() {
        radios.forEach((radio) -> {
            this.setRadioError(radio);
        });
    }
    
    /**
     * Señala un errod sobre el radioButton y muestra un mensaje.  
     */
    public void setError(String mensaje) {
        this.setMensajeDeError(mensaje);
        this.setError();
        this.mostrarError();
    }
    
    /**
     * Quita las configuraciones de error sobre el radioButton. 
     */
    public void setErrorQuitar(){
        radios.forEach((radio) -> {
            this.setRadioRestaurar(radio);
        });
    }

    /**
     *Retorna el primer radio. 
     */
    @Override
    public Component getThis() {
        return this.radios.get(0);
    }
    
    /**
     * Retorna la lista de radios. 
     */
    public List<Component> getThisRadios(){
        List<Component> componentes = new ArrayList<>();
        for (int i = 0; i < this.radios.size(); i++) {
            JRadioButton radio = this.radios.get(i);
            componentes.add(radio);
            
        }
        return componentes;
    }
    
    /**
     * Quita la selección del grupo. 
     */
    public void clearSelection(){
        if (this.grupo != null) {
            this.grupo.clearSelection();
        }
    }
    
    /**
     * Selecciona el radio que contenga el nombre coincidiente con el valor
     * que se le pase como parametro.
     * @param valorDeRadio
     */
    public void setSelectRadio(String valorDeRadio){
        for (JRadioButton radio : radios) {
            if (radio.getText().equals(valorDeRadio)) {
                radio.setSelected(true);
            }
        }
    }
    
    
    @Override
    public void setNextFocusableComponent(Component componente){
        for (int i = 0; i < this.radios.size(); i++) {
            JRadioButton radio = this.radios.get(i);
            if (i==this.radios.size()) {
                super.setNextFocusableComponent(componente);
                break;
            }
            super.setNextFocusableComponent(radio);
            
            
        }
    }

    @Override
    public void setText(String txt) {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setText");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setFocus() {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setFocus");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setEditable(boolean editable) {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setEditable");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    
}
