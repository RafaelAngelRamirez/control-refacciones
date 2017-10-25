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
public class RelacionRefaccionProveedorIT extends ITGenerales{
    
public static final String NOMBRE_TABLA = "relacionrefaccionproveedor";    
private static final ParametrosDeCampo idProveedorPDC = new ParametrosDeCampo();
private static final ParametrosDeCampo idRefaccionPDC = new ParametrosDeCampo();

    public RelacionRefaccionProveedorIT() {
        

        idRefaccionPDC.setNombre("idRefaccion");
        idRefaccionPDC.setLongitudDeCaracteres(11);
        idRefaccionPDC.setTipoDeDatos("int");
        idRefaccionPDC.setNulo(false);
        idRefaccionPDC.setAutoIncrement(false);
        idRefaccionPDC.setPermiteRepetido(true);
        
        idProveedorPDC.setNombre("idProveedor");
        idProveedorPDC.setLongitudDeCaracteres(11);
        idProveedorPDC.setTipoDeDatos("int");
        idProveedorPDC.setNulo(false);
        idProveedorPDC.setAutoIncrement(false);
        idProveedorPDC.setPermiteRepetido(true);
        idProveedorPDC.setNombreParaMostrar("Proveedor");
        
        
        camposPDC.add(idProveedorPDC);
        camposPDC.add(idRefaccionPDC);
    
    }   

    public ParametrosDeCampo getIdProveedorPDC() {
        return idProveedorPDC;
    }

    

    public ParametrosDeCampo getIdRefaccionPDC() {
        return idRefaccionPDC;
    }

    
    
    
    
    
}
