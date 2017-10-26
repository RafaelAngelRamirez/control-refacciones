/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.InfoTabla;

import modelo.ParametrosDeCampo;
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
    
    private static final ParametrosDeCampo ID_REFACCION = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE_PARA_MOSTRAR = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE_SERVIDOR = new ParametrosDeCampo();

    public ImagenRefaccionIT() {
        
        
        ID_REFACCION.setNombre("idRefaccion");
        ID_REFACCION.setLongitudDeCaracteres(11);
        ID_REFACCION.setTipoDeDatos("int");
        ID_REFACCION.setNulo(false);
        ID_REFACCION.setAutoIncrement(false);
        ID_REFACCION.setPermiteRepetido(true);

        NOMBRE_PARA_MOSTRAR.setNombre("nombreParaMostrar");
        NOMBRE_PARA_MOSTRAR.setNombreParaMostrar("Nombre imagen");
        NOMBRE_PARA_MOSTRAR.setLongitudDeCaracteres(200);
        NOMBRE_PARA_MOSTRAR.setTipoDeDatos("varchar");
        NOMBRE_PARA_MOSTRAR.setNulo(false);
        NOMBRE_PARA_MOSTRAR.setAutoIncrement(false);
        NOMBRE_PARA_MOSTRAR.setPermiteRepetido(true);
        
        NOMBRE_SERVIDOR.setNombre("nombreServidor");
        NOMBRE_SERVIDOR.setNombreParaMostrar("Nombre servidor");
        NOMBRE_SERVIDOR.setLongitudDeCaracteres(200);
        NOMBRE_SERVIDOR.setTipoDeDatos("varchar");
        NOMBRE_SERVIDOR.setNulo(false);
        NOMBRE_SERVIDOR.setAutoIncrement(false);
        NOMBRE_SERVIDOR.setPermiteRepetido(true);
        
        CAMPOS_PDC.add(ID_REFACCION);
        CAMPOS_PDC.add(NOMBRE_PARA_MOSTRAR);
        CAMPOS_PDC.add(NOMBRE_SERVIDOR);
    
    }   

    public static ParametrosDeCampo getNOMBRE_SERVIDOR() {
        return NOMBRE_SERVIDOR;
    }

    

    public static ParametrosDeCampo getID_REFACCION() {
        return ID_REFACCION;
    }

    

    public static ParametrosDeCampo getNOMBRE_PARA_MOSTRAR() {
        return NOMBRE_PARA_MOSTRAR;
    }

    
    
//    public String subirImagen(File file){
//        JOptionPane.showMessageDialog(null, "pendiente subir imagenes.");
//        return "";
//                
//    }
//    
    
    
}
