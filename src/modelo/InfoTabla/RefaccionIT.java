/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.InfoTabla;

import java.util.List;

/**
 *
 * @author Rafael Ramírez
 */
public class RefaccionIT extends ITGenerales{
    
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "refaccion";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo nombrePDC = new ParametrosDeCampo();
    private ParametrosDeCampo idMaterialPDC = new ParametrosDeCampo();
    private ParametrosDeCampo importanciaPDC = new ParametrosDeCampo();
    private ParametrosDeCampo stockMinimoPDC = new ParametrosDeCampo();
    private ParametrosDeCampo stockMaximoPDC = new ParametrosDeCampo();
    private ParametrosDeCampo unidadPDC = new ParametrosDeCampo();
    private ParametrosDeCampo codigoInternoPDC = new ParametrosDeCampo();
    private ParametrosDeCampo codigoProveedorPDC = new ParametrosDeCampo();
    private ParametrosDeCampo descripcionPDC = new ParametrosDeCampo();
    private ParametrosDeCampo queEsPDC = new ParametrosDeCampo();
    private ParametrosDeCampo paraQueEsPDC = new ParametrosDeCampo();

    public RefaccionIT() {
    
           
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);

        nombrePDC.setNombre("nombre");
        nombrePDC.setLongitudDeCaracteres(50);
        nombrePDC.setTipoDeDatos("int");
        nombrePDC.setNulo(false);
        nombrePDC.setAutoIncrement(false);
        nombrePDC.setPermiteRepetido(true);
        nombrePDC.setNombreParaMostrar("Nombre de la Refacción");

        idMaterialPDC.setNombre("idMaterial");
        idMaterialPDC.setLongitudDeCaracteres(11);
        idMaterialPDC.setTipoDeDatos("int");
        idMaterialPDC.setNulo(false);
        idMaterialPDC.setAutoIncrement(false);
        idMaterialPDC.setPermiteRepetido(true);
        idMaterialPDC.setNombreParaMostrar("Material");

        importanciaPDC.setNombre("importancia");
        importanciaPDC.setLongitudDeCaracteres(11);
        importanciaPDC.setTipoDeDatos("int");
        importanciaPDC.setNulo(false);
        importanciaPDC.setAutoIncrement(false);
        importanciaPDC.setPermiteRepetido(true);
        importanciaPDC.setNombreParaMostrar("Importancia");

        stockMinimoPDC.setNombre("stockMinimo");
        stockMinimoPDC.setTipoDeDatos("float");
        stockMinimoPDC.setLongitudDeCaracteres(10);
        stockMinimoPDC.setLongitudDeDecimales(3);
        stockMinimoPDC.setNulo(false);
        stockMinimoPDC.setAutoIncrement(false);
        stockMinimoPDC.setPermiteRepetido(true);
        stockMinimoPDC.setNombreParaMostrar("Stock Mín");

        stockMaximoPDC.setNombre("stockMaximo");
        stockMaximoPDC.setTipoDeDatos("float");
        stockMaximoPDC.setLongitudDeCaracteres(10);
        stockMaximoPDC.setLongitudDeDecimales(3);
        stockMaximoPDC.setNulo(false);
        stockMaximoPDC.setAutoIncrement(false);
        stockMaximoPDC.setPermiteRepetido(true);
        stockMaximoPDC.setNombreParaMostrar("Stock Máx");

        unidadPDC.setNombre("unidad");
        unidadPDC.setLongitudDeCaracteres(11);
        unidadPDC.setTipoDeDatos("int");
        unidadPDC.setNulo(false);
        unidadPDC.setAutoIncrement(false);
        unidadPDC.setPermiteRepetido(true);
        unidadPDC.setNombreParaMostrar("Unidad");

        codigoInternoPDC.setNombre("codigoInterno");
        codigoInternoPDC.setLongitudDeCaracteres(20);
        codigoInternoPDC.setTipoDeDatos("varchar");
        codigoInternoPDC.setNulo(false);
        codigoInternoPDC.setAutoIncrement(false);
        codigoInternoPDC.setPermiteRepetido(false);
        codigoInternoPDC.setNombreParaMostrar("Código Interno");

        codigoProveedorPDC.setNombre("codigoProveedor");
        codigoProveedorPDC.setLongitudDeCaracteres(20);
        codigoProveedorPDC.setTipoDeDatos("varchar");
        codigoProveedorPDC.setNulo(true);
        codigoProveedorPDC.setAutoIncrement(false);
        codigoProveedorPDC.setPermiteRepetido(true);
        codigoProveedorPDC.setNombreParaMostrar("Código del Proveedor");

        descripcionPDC.setNombre("descripcion");
        descripcionPDC.setLongitudDeCaracteres(500);
        descripcionPDC.setTipoDeDatos("varchar");
        descripcionPDC.setNulo(false);
        descripcionPDC.setAutoIncrement(false);
        descripcionPDC.setPermiteRepetido(true);
        descripcionPDC.setNombreParaMostrar("Descripción");

        queEsPDC.setNombre("queEs");
        queEsPDC.setLongitudDeCaracteres(250);
        queEsPDC.setTipoDeDatos("varchar");
        queEsPDC.setNulo(true);
        queEsPDC.setAutoIncrement(false);
        queEsPDC.setPermiteRepetido(true);
        queEsPDC.setNombreParaMostrar("¿Que es?");

        paraQueEsPDC.setNombre("paraQueEs");
        paraQueEsPDC.setLongitudDeCaracteres(250);
        paraQueEsPDC.setTipoDeDatos("varchar");
        paraQueEsPDC.setNulo(true);
        paraQueEsPDC.setAutoIncrement(false);
        paraQueEsPDC.setPermiteRepetido(true);
        paraQueEsPDC.setNombreParaMostrar("¿Para que es?");
        
        camposPDC.add(idPDC);
        camposPDC.add(nombrePDC);
        camposPDC.add(idMaterialPDC);
        camposPDC.add(importanciaPDC);
        camposPDC.add(stockMinimoPDC);
        camposPDC.add(stockMaximoPDC);
        camposPDC.add(unidadPDC);
        camposPDC.add(codigoInternoPDC);
        camposPDC.add(codigoProveedorPDC);
        camposPDC.add(descripcionPDC);
        camposPDC.add(queEsPDC);
        camposPDC.add(paraQueEsPDC);

    }

   
    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getNombrePDC() {
        return nombrePDC;
    }

    public void setNombrePDC(ParametrosDeCampo nombrePDC) {
        this.nombrePDC = nombrePDC;
    }

    public ParametrosDeCampo getIdMaterialPDC() {
        return idMaterialPDC;
    }

    public void setIdMaterialPDC(ParametrosDeCampo idMaterialPDC) {
        this.idMaterialPDC = idMaterialPDC;
    }

    public ParametrosDeCampo getImportanciaPDC() {
        return importanciaPDC;
    }

    public void setImportanciaPDC(ParametrosDeCampo importanciaPDC) {
        this.importanciaPDC = importanciaPDC;
    }

    public ParametrosDeCampo getStockMinimoPDC() {
        return stockMinimoPDC;
    }

    public void setStockMinimoPDC(ParametrosDeCampo stockMinimoPDC) {
        this.stockMinimoPDC = stockMinimoPDC;
    }

    public ParametrosDeCampo getStockMaximoPDC() {
        return stockMaximoPDC;
    }

    public void setStockMaximoPDC(ParametrosDeCampo stockMaximoPDC) {
        this.stockMaximoPDC = stockMaximoPDC;
    }

    public ParametrosDeCampo getUnidadPDC() {
        return unidadPDC;
    }

    public void setUnidadPDC(ParametrosDeCampo unidadPDC) {
        this.unidadPDC = unidadPDC;
    }

    public ParametrosDeCampo getCodigoInternoPDC() {
        return codigoInternoPDC;
    }

    public void setCodigoInternoPDC(ParametrosDeCampo codigoInternoPDC) {
        this.codigoInternoPDC = codigoInternoPDC;
    }

    public ParametrosDeCampo getCodigoProveedorPDC() {
        return codigoProveedorPDC;
    }

    public void setCodigoProveedorPDC(ParametrosDeCampo codigoProveedorPDC) {
        this.codigoProveedorPDC = codigoProveedorPDC;
    }

    public ParametrosDeCampo getDescripcionPDC() {
        return descripcionPDC;
    }

    public void setDescripcionPDC(ParametrosDeCampo descripcionPDC) {
        this.descripcionPDC = descripcionPDC;
    }

    public ParametrosDeCampo getQueEsPDC() {
        return queEsPDC;
    }

    public void setQueEsPDC(ParametrosDeCampo queEsPDC) {
        this.queEsPDC = queEsPDC;
    }

    public ParametrosDeCampo getParaQueEsPDC() {
        return paraQueEsPDC;
    }

    public void setParaQueEsPDC(ParametrosDeCampo paraQueEsPDC) {
        this.paraQueEsPDC = paraQueEsPDC;
    }
    
    
    
}
