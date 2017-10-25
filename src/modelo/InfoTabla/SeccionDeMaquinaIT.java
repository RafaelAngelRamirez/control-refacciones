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
public class SeccionDeMaquinaIT extends ITGenerales{
    
     /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "secciondemaquina";
    
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo nombreSeccionPDC = new ParametrosDeCampo();
 

    public SeccionDeMaquinaIT() {
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        nombreSeccionPDC.setNombre("nombreSeccion");
        nombreSeccionPDC.setNombreParaMostrar("Nombre de seccion");
        nombreSeccionPDC.setLongitudDeCaracteres(30);
        nombreSeccionPDC.setTipoDeDatos("varchar");
        nombreSeccionPDC.setNulo(false);
        nombreSeccionPDC.setAutoIncrement(false);
        nombreSeccionPDC.setPermiteRepetido(false);
        
              
        camposPDC.add(idPDC);
        camposPDC.add(nombreSeccionPDC);
       
    
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getNombreSeccionPDC() {
        return nombreSeccionPDC;
    }

    public void setNombreSeccionPDC(ParametrosDeCampo nombreSeccionPDC) {
        this.nombreSeccionPDC = nombreSeccionPDC;
    }
    
    
    
    
    
}
