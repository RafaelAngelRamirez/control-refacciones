package vista.utilidadesOptimizadas;

import controlador.Coordinador;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.vo.Suceso;
import org.jdesktop.swingx.JXImageView;

/**
 * Los errores que aqui se muestran son los generados sobre la GUI. Comúnmente
 * son mensajes de aviso, cambios de color etc.
 * @author Particular
 */
public class SenalarErroresSobreGUI_ {
    
    private String ubicacion;
    private String mensajeDeError;
    private String titulo;

    private JFrame padre;
    
    private Colores_ colores = new Colores_();

    private boolean error = false;
    Coordinador coordinador;

    public SenalarErroresSobreGUI_(Coordinador controlador) {
        this.coordinador = controlador;
    }
    
    
   

    /**
     * Gestiona los errores para mostrarse en pantalla. 
     * Es necesario utilizar las funciones:
     * setTitulo();
     * 
     * setUbicacion();
     * 
     * setMensajeDeError();
     * 
     * setDepuracion(); - En caso de que sea necesario.
     * 
     * setPadre();
     */
    public void mostrarError (){
        JOptionPane.showMessageDialog(this.padre, this.mensajeDeError, this.titulo, 0);
        System.out.println("[!]Error de catpura detectado:"+ this.ubicacion);
        System.out.println("            "+this.mensajeDeError);
        this.error = true;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

  
    /**
     * Titulo del error.
     * @param titulo El titulo del error. 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
     /**
     * Ubicacion en el código. Solo se mostrara si se pone setDepuracion(true);
     * @param ubicacion Donde se genera.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * El mensaje de error que se mostrara.
     * @param error Mensaje de error.
     */
    public void setMensajeDeError(String error) {
        this.mensajeDeError = error;
    }

    public void setPadre(JFrame padre) {
        this.padre = padre;
    }
    
    /**
     * Modifica el campo de password para darle un color acorde al error.
     *
     * @param campoPassword El componente tipo JPasswordField.
     */
    protected void setCampoPassword(JPasswordField campoPassword) {
       //MODIFICAMOS UN CAMPO PASSWORD PARA DARLE EL ERROR.
       campoPassword.setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
       campoPassword.setForeground(this.colores.ERROR_TXT_RESALTAR_FG);
       
    }
    
    /**
     * Modifica el campo de password para restablecerlo al tema original.
     *
     * @param campoPassword El componente tipo JPasswordField.
     */
    protected void setCampoPasswordRestaurar(JPasswordField campoPassword) {
       //MODIFICAMOS UN CAMPO PASSWORD QUITARLE EL ERROR
       campoPassword.setBackground(this.colores.TEMA_TXT_BG);
       campoPassword.setForeground(this.colores.TEMA_TXT_FG);
       
    }
     /**
     * Modifica el campo de texto para darle un color acorde al error.
     *
     * @param campoTexto El componente tipo JTextField.
     */
    protected void setCampoTextoError(JTextField campoTexto){
        campoTexto.setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
        campoTexto.setForeground(this.colores.ERROR_TXT_RESALTAR_FG);
    }
     /**
     * Modifica el campo de texto para restaurar el color despues del error..
     *
     * @param campoTexto El componente tipo JTextField.
     */
    protected void setCampoTextoRestaurar(JTextField campoTexto){
        campoTexto.setBackground(this.colores.TEMA_TXT_BG);
        campoTexto.setForeground(this.colores.TEMA_TXT_FG);
    }
    
    /**
     * Modiica el combobox para darle un color acorde al error.
     * @param campoComboBox El componente tipo JComboBox.
     */
    protected void setCampoComboBoxError(JComboBox campoComboBox){
        campoComboBox.getEditor().getEditorComponent().setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
        campoComboBox.getEditor().getEditorComponent().setForeground(this.colores.ERROR_TXT_RESALTAR_FG);

    }
    
    /**
     * Modiica el combobox para darle un color acorde al error.
     * @param campoComboBox El componente tipo JComboBox.
     */
    protected void setCampoComboBoxRestaurar(JComboBox campoComboBox){
        campoComboBox.getEditor().getEditorComponent().setBackground(this.colores.TEMA_TXT_BG);
        campoComboBox.getEditor().getEditorComponent().setForeground(this.colores.TEMA_TXT_FG);
    }
    
    
    /**
     * Modifica el campo de area de texto para darle un color acorde al error.
     *
     * @param campoTextoArea El componente tipo JTextArea.
     */
    protected void setCampoTextoAreaError(JTextArea campoTextoArea){
        campoTextoArea.setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
        campoTextoArea.setForeground(this.colores.ERROR_TXT_RESALTAR_FG);
    }
     /**
     * Modifica el campo de area de texto texto para quitar el color del error.
     *
     * @param campoTextoArea El componente tipo JTextArea.
     */
    protected void setCampoTextoAreaRestaurar(JTextArea campoTextoArea){
        campoTextoArea.setBackground(this.colores.TEMA_TXT_BG);
        campoTextoArea.setForeground(this.colores.TEMA_TXT_FG);
    }
    
    /**
     * Modifica el campo de area de texto para darle un color acorde al error.
     *
     * @param radio El componente tipo JRadioButton.
     */
    protected void setRadioError(JRadioButton radio){
        radio.setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
        radio.setForeground(this.colores.ERROR_TXT_RESALTAR_FG);
    }
     /**
     * Modifica el campo de area de texto texto para quitar el color del error.
     *
     * @param radio El componente tipo JRadioButton.
     */
    protected void setRadioRestaurar(JRadioButton radio){
        radio.setBackground(this.colores.TEMA_FONDO_BG);
        radio.setForeground(this.colores.TEMA_TXT_FG);
    }
    
    /**
     * Modifica el espacio que muestra la imagen acorde al error;
     * @param imagen El componente tipo JXImageView.
     */
    protected void setImagenViewError(JXImageView imagen){
        imagen.setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
        imagen.setForeground(this.colores.ERROR_TXT_RESALTAR_FG);
    
    }
    
    /**
     * Modifica el espacio que muestra la imagen acorde al error;
     * @param imagen El componente tipo JXImageView.
     */
    protected void setImagenViewErrorRestaurar(JXImageView imagen){
        imagen.setBackground(this.colores.TEMA_TXT_BG);
        imagen.setForeground(this.colores.TEMA_TXT_FG);
    }
    
    /**
     * Modifica la lista para señalarla como error.;
     * @param lista El componente tipo JList.
     */
    protected void setListaError(JList lista){
        lista.setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
        lista.setForeground(this.colores.ERROR_TXT_RESALTAR_FG);
    
    }
    
    /**
     * Modifica la lista a al color de tema normal.;
     * @param lista El componente tipo JList.
     */
    protected void setListaErrorRestaurar(JList lista){
        lista.setBackground(this.colores.TEMA_FONDO_BG);
        lista.setForeground(this.colores.TEMA_TXT_FG);
        
    }
    
    
     /**
     * Modifica la etiqueta para señalarla como error.;
     * @param etiqueta El componente tipo JLabel.
     */
    protected void setEtiquetaError(JLabel etiqueta){
        etiqueta.setBackground(this.colores.ERROR_TXT_RESALTAR_BG);
        etiqueta.setForeground(this.colores.ERROR_TXT_RESALTAR_FG);
    
    }
    
    /**
     * Modifica la etiqueta al color de tema normal.;
     * @param etiqueta El componente tipo JLabel.
     */
    protected void setEtiquetaErrorRestaurar(JLabel etiqueta){
        etiqueta.setBackground(this.colores.TEMA_FONDO_BG);
        etiqueta.setForeground(this.colores.TEMA_TXT_FG);
    }

}