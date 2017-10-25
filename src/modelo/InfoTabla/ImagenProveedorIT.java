
package modelo.InfoTabla;

/**
 *
 * @author Particular
 */
public class ImagenProveedorIT extends ITGenerales{
    /*
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "imagenproveedor";
    
    private static final ParametrosDeCampo idProveedorPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo nombreParaMostarPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo nombreServidorPDC = new ParametrosDeCampo();

    public ImagenProveedorIT() {
        
        
        idProveedorPDC.setNombre("idProveedor");
        idProveedorPDC.setLongitudDeCaracteres(11);
        idProveedorPDC.setTipoDeDatos("int");
        idProveedorPDC.setNulo(false);
        idProveedorPDC.setAutoIncrement(false);
        idProveedorPDC.setPermiteRepetido(true);

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
        
        camposPDC.add(idProveedorPDC);
        camposPDC.add(nombreParaMostarPDC);
        camposPDC.add(nombreServidorPDC);
    
    }   

    public ParametrosDeCampo getIdProveedorPDC() {
        return idProveedorPDC;
    }

    public void setIdProveedorPDC(ParametrosDeCampo idProveedorPDC) {
        this.idProveedorPDC = idProveedorPDC;
    }

    public ParametrosDeCampo getNombreParaMostarPDC() {
        return nombreParaMostarPDC;
    }

    public void setNombreParaMostarPDC(ParametrosDeCampo nombreParaMostarPDC) {
        this.nombreParaMostarPDC = nombreParaMostarPDC;
    }

    public ParametrosDeCampo getNombreServidorPDC() {
        return nombreServidorPDC;
    }

    public void setNombreServidorPDC(ParametrosDeCampo nombreServidorPDC) {
        this.nombreServidorPDC = nombreServidorPDC;
    }
    
    
    
}
