/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.InfoTabla;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Particular
 */
public class ImagenRefaccionIT extends ITGenerales{
    
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "imagenRefaccion";
    
    private ParametrosDeCampo idRefaccionPDC = new ParametrosDeCampo();
    private ParametrosDeCampo nombreParaMostarPDC = new ParametrosDeCampo();
    private ParametrosDeCampo nombreServidorPDC = new ParametrosDeCampo();

    public ImagenRefaccionIT() {
        
        
        idRefaccionPDC.setNombre("idRefaccion");
        idRefaccionPDC.setLongitudDeCaracteres(11);
        idRefaccionPDC.setTipoDeDatos("int");
        idRefaccionPDC.setNulo(false);
        idRefaccionPDC.setAutoIncrement(false);
        idRefaccionPDC.setPermiteRepetido(true);

        nombreParaMostarPDC.setNombre("nombreParaMostrar");
        nombreParaMostarPDC.setNombreParaMostrar("Nombre imagen");
        nombreParaMostarPDC.setLongitudDeCaracteres(200);
        nombreParaMostarPDC.setTipoDeDatos("varchar");
        nombreParaMostarPDC.setNulo(false);
        nombreParaMostarPDC.setAutoIncrement(false);
        nombreParaMostarPDC.setPermiteRepetido(true);
        
        nombreServidorPDC.setNombre("nombreServidor");
        nombreServidorPDC.setNombreParaMostrar("Nombre servidor");
        nombreServidorPDC.setLongitudDeCaracteres(200);
        nombreServidorPDC.setTipoDeDatos("varchar");
        nombreServidorPDC.setNulo(false);
        nombreServidorPDC.setAutoIncrement(false);
        nombreServidorPDC.setPermiteRepetido(true);
        
        camposPDC.add(idRefaccionPDC);
        camposPDC.add(nombreParaMostarPDC);
        camposPDC.add(nombreServidorPDC);
    
    }   

    public ParametrosDeCampo getNombreServidorPDC() {
        return nombreServidorPDC;
    }

    public void setNombreServidorPDC(ParametrosDeCampo nombreServidorPDC) {
        this.nombreServidorPDC = nombreServidorPDC;
    }

    public ParametrosDeCampo getIdRefaccionPDC() {
        return idRefaccionPDC;
    }

    public void setIdRefaccionPDC(ParametrosDeCampo idRefaccionPDC) {
        this.idRefaccionPDC = idRefaccionPDC;
    }

    public ParametrosDeCampo getNombreParaMostarPDC() {
        return nombreParaMostarPDC;
    }

    public void setNombreParaMostarPDC(ParametrosDeCampo nombreParaMostarPDC) {
        this.nombreParaMostarPDC = nombreParaMostarPDC;
    }
    
//    public String subirImagen(File file){
//        JOptionPane.showMessageDialog(null, "pendiente subir imagenes.");
//        return "";
//                
//    }
//    
    
    
}
