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
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo nombreContactoPDC = new ParametrosDeCampo();
    private ParametrosDeCampo telefonoPDC = new ParametrosDeCampo();
    private ParametrosDeCampo emailPDC = new ParametrosDeCampo();
    private ParametrosDeCampo empresaProveedorePDC = new ParametrosDeCampo();
    private ParametrosDeCampo paginaWebPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idPaisPDC = new ParametrosDeCampo();
    
    public ProveedorIT() {
    
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        nombreContactoPDC.setNombre("nombreContacto");
        nombreContactoPDC.setNombreParaMostrar("Nombre contacto");
        nombreContactoPDC.setLongitudDeCaracteres(100);
        nombreContactoPDC.setTipoDeDatos("varchar");
        nombreContactoPDC.setNulo(true);
        nombreContactoPDC.setAutoIncrement(false);

        telefonoPDC.setNombre("telefono");
        telefonoPDC.setNombreParaMostrar("Telefono");
        telefonoPDC.setLongitudDeCaracteres(15);
        telefonoPDC.setTipoDeDatos("varchar");
        telefonoPDC.setNulo(true);
        telefonoPDC.setAutoIncrement(false);

        emailPDC.setNombre("email");
        emailPDC.setNombreParaMostrar("Email");
        emailPDC.setLongitudDeCaracteres(50);
        emailPDC.setTipoDeDatos("varchar");
        emailPDC.setNulo(true);
        emailPDC.setAutoIncrement(false);

        empresaProveedorePDC.setNombre("empresa");
        empresaProveedorePDC.setNombreParaMostrar("Proveedores");
        empresaProveedorePDC.setLongitudDeCaracteres(50);
        empresaProveedorePDC.setTipoDeDatos("varchar");
        empresaProveedorePDC.setNulo(false);
        empresaProveedorePDC.setAutoIncrement(false);
        empresaProveedorePDC.setPermiteRepetido(false);

        paginaWebPDC.setNombre("paginaWeb");
        paginaWebPDC.setNombreParaMostrar("Pagina web");
        paginaWebPDC.setLongitudDeCaracteres(100);
        paginaWebPDC.setTipoDeDatos("varchar");
        paginaWebPDC.setNulo(true);
        paginaWebPDC.setAutoIncrement(false);

        idPaisPDC.setNombre("idPais");
        idPaisPDC.setLongitudDeCaracteres(11);
        idPaisPDC.setTipoDeDatos("int");
        idPaisPDC.setNulo(true);
        idPaisPDC.setAutoIncrement(false);
        
        camposPDC.add(idPDC);
        camposPDC.add(nombreContactoPDC);
        camposPDC.add(telefonoPDC);
        camposPDC.add(emailPDC);
        camposPDC.add(empresaProveedorePDC);
        camposPDC.add(paginaWebPDC);
        camposPDC.add(idPaisPDC);
    
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getNombreContactoPDC() {
        return nombreContactoPDC;
    }

    public void setNombreContactoPDC(ParametrosDeCampo nombreContactoPDC) {
        this.nombreContactoPDC = nombreContactoPDC;
    }

    public ParametrosDeCampo getTelefonoPDC() {
        return telefonoPDC;
    }

    public void setTelefonoPDC(ParametrosDeCampo telefonoPDC) {
        this.telefonoPDC = telefonoPDC;
    }

    public ParametrosDeCampo getEmailPDC() {
        return emailPDC;
    }

    public void setEmailPDC(ParametrosDeCampo emailPDC) {
        this.emailPDC = emailPDC;
    }

    public ParametrosDeCampo getEmpresaProveedorPDC() {
        return empresaProveedorePDC;
    }

    public void setEmpresaProveedorePDC(ParametrosDeCampo empresaProveedorePDC) {
        this.empresaProveedorePDC = empresaProveedorePDC;
    }

    public ParametrosDeCampo getPaginaWebPDC() {
        return paginaWebPDC;
    }

    public void setPaginaWebPDC(ParametrosDeCampo paginaWebPDC) {
        this.paginaWebPDC = paginaWebPDC;
    }

    public ParametrosDeCampo getIdPaisPDC() {
        return idPaisPDC;
    }

    public void setIdPaisPDC(ParametrosDeCampo idPaisPDC) {
        this.idPaisPDC = idPaisPDC;
    }
    
    
    
    
    
}
