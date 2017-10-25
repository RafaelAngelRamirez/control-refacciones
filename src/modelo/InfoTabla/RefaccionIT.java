/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.InfoTabla;

/**
 *
 * @author Rafael Ramírez
 */
public class RefaccionIT extends ITGenerales{
    
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public final String NOMBRE_TABLA = "refaccion";
    
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo nombrePDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idMaterialPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo importanciaPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo stockMinimoPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo stockMaximoPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo unidadPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo codigoInternoPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo codigoProveedorPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo descripcionPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo queEsPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo paraQueEsPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo refaccionDeConsumoUnicoPDC = new ParametrosDeCampo();

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
        
        refaccionDeConsumoUnicoPDC.setNombre("refaccionDeConsumoUnico");
        refaccionDeConsumoUnicoPDC.setLongitudDeCaracteres(1);
        refaccionDeConsumoUnicoPDC.setTipoDeDatos("byte");
        refaccionDeConsumoUnicoPDC.setNulo(false);
        refaccionDeConsumoUnicoPDC.setAutoIncrement(false);
        refaccionDeConsumoUnicoPDC.setPermiteRepetido(true);
        refaccionDeConsumoUnicoPDC.setNombreParaMostrar("¿Es refacción de consumo único?");
        
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
        camposPDC.add(refaccionDeConsumoUnicoPDC);
        
        

    }

   
    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    

    public ParametrosDeCampo getNombrePDC() {
        return nombrePDC;
    }

    

    public ParametrosDeCampo getIdMaterialPDC() {
        return idMaterialPDC;
    }

    

    public ParametrosDeCampo getImportanciaPDC() {
        return importanciaPDC;
    }

    

    public ParametrosDeCampo getStockMinimoPDC() {
        return stockMinimoPDC;
    }

    

    public ParametrosDeCampo getStockMaximoPDC() {
        return stockMaximoPDC;
    }

    

    public ParametrosDeCampo getUnidadPDC() {
        return unidadPDC;
    }

    

    public ParametrosDeCampo getCodigoInternoPDC() {
        return codigoInternoPDC;
    }

    

    public ParametrosDeCampo getCodigoProveedorPDC() {
        return codigoProveedorPDC;
    }

    

    public ParametrosDeCampo getDescripcionPDC() {
        return descripcionPDC;
    }

    

    public ParametrosDeCampo getQueEsPDC() {
        return queEsPDC;
    }

    

    public ParametrosDeCampo getParaQueEsPDC() {
        return paraQueEsPDC;
    }

    

    public ParametrosDeCampo getRefaccionDeConsumoUnicoPDC() {
        return refaccionDeConsumoUnicoPDC;
    }

    
    
}
