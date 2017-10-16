/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.InfoTabla;

/**
 *
 * @author Particular
 */
public class  SeccionDeMaquinaIT extends ITGenerales{
    
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "secciondemaquina";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo nombreSeccion = new ParametrosDeCampo();
 

    public SeccionDeMaquinaIT() {
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        nombreSeccion.setNombre("nombreSeccion");
        nombreSeccion.setNombreParaMostrar("Nombre de seccion");
        nombreSeccion.setLongitudDeCaracteres(30);
        nombreSeccion.setTipoDeDatos("varchar");
        nombreSeccion.setNulo(false);
        nombreSeccion.setAutoIncrement(false);
        nombreSeccion.setPermiteRepetido(false);
        
              
        camposPDC.add(idPDC);
        camposPDC.add(nombreSeccion);
       
    
    
    }
    
    
    
}
