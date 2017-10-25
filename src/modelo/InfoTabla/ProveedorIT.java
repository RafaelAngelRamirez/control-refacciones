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
public class ProveedorIT extends ITGenerales{
    /**
     * El nombre de la tabla en la base de datos. 
     */
    public static final String NOMBRE_TABLA = "proveedor";
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE_CONTACTO = new ParametrosDeCampo();
    private static final ParametrosDeCampo TELEFONO = new ParametrosDeCampo();
    private static final ParametrosDeCampo EMAIL = new ParametrosDeCampo();
    private static final ParametrosDeCampo EMPRESA_PROVEEDOR = new ParametrosDeCampo();
    private static final ParametrosDeCampo PAGINA_WEB = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_PAIS = new ParametrosDeCampo();
    
    public ProveedorIT() {
    
        ID.setNombre("id");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);

        NOMBRE_CONTACTO.setNombre("nombreContacto");
        NOMBRE_CONTACTO.setNombreParaMostrar("Nombre contacto");
        NOMBRE_CONTACTO.setLongitudDeCaracteres(100);
        NOMBRE_CONTACTO.setTipoDeDatos("varchar");
        NOMBRE_CONTACTO.setNulo(true);
        NOMBRE_CONTACTO.setAutoIncrement(false);

        TELEFONO.setNombre("telefono");
        TELEFONO.setNombreParaMostrar("Telefono");
        TELEFONO.setLongitudDeCaracteres(15);
        TELEFONO.setTipoDeDatos("varchar");
        TELEFONO.setNulo(true);
        TELEFONO.setAutoIncrement(false);

        EMAIL.setNombre("email");
        EMAIL.setNombreParaMostrar("Email");
        EMAIL.setLongitudDeCaracteres(50);
        EMAIL.setTipoDeDatos("varchar");
        EMAIL.setNulo(true);
        EMAIL.setAutoIncrement(false);

        EMPRESA_PROVEEDOR.setNombre("empresa");
        EMPRESA_PROVEEDOR.setNombreParaMostrar("Proveedores");
        EMPRESA_PROVEEDOR.setLongitudDeCaracteres(50);
        EMPRESA_PROVEEDOR.setTipoDeDatos("varchar");
        EMPRESA_PROVEEDOR.setNulo(false);
        EMPRESA_PROVEEDOR.setAutoIncrement(false);
        EMPRESA_PROVEEDOR.setPermiteRepetido(false);

        PAGINA_WEB.setNombre("paginaWeb");
        PAGINA_WEB.setNombreParaMostrar("Pagina web");
        PAGINA_WEB.setLongitudDeCaracteres(100);
        PAGINA_WEB.setTipoDeDatos("varchar");
        PAGINA_WEB.setNulo(true);
        PAGINA_WEB.setAutoIncrement(false);

        ID_PAIS.setNombre("idPais");
        ID_PAIS.setLongitudDeCaracteres(11);
        ID_PAIS.setTipoDeDatos("int");
        ID_PAIS.setNulo(true);
        ID_PAIS.setAutoIncrement(false);
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(NOMBRE_CONTACTO);
        CAMPOS_PDC.add(TELEFONO);
        CAMPOS_PDC.add(EMAIL);
        CAMPOS_PDC.add(EMPRESA_PROVEEDOR);
        CAMPOS_PDC.add(PAGINA_WEB);
        CAMPOS_PDC.add(ID_PAIS);
    
    }

    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getNOMBRE_CONTACTO() {
        return NOMBRE_CONTACTO;
    }

    

    public static ParametrosDeCampo getTELEFONO() {
        return TELEFONO;
    }

    

    public static ParametrosDeCampo getEMAIL() {
        return EMAIL;
    }

    

    public static ParametrosDeCampo getEmpresaProveedorPDC() {
        return EMPRESA_PROVEEDOR;
    }

    

    public static ParametrosDeCampo getPAGINA_WEB() {
        return PAGINA_WEB;
    }

    

    public static ParametrosDeCampo getID_PAIS() {
        return ID_PAIS;
    }

    
    
    
    
    
    
}
