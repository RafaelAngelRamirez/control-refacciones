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
    
    private static final ParametrosDeCampo ID = new ParametrosDeCampo();
    private static final ParametrosDeCampo NOMBRE = new ParametrosDeCampo();
    private static final ParametrosDeCampo ID_MATERIAL = new ParametrosDeCampo();
    private static final ParametrosDeCampo IMPORTANCIA = new ParametrosDeCampo();
    private static final ParametrosDeCampo STOCK_MINIMO = new ParametrosDeCampo();
    private static final ParametrosDeCampo STOCK_MAXIMO = new ParametrosDeCampo();
    private static final ParametrosDeCampo UNIDAD = new ParametrosDeCampo();
    private static final ParametrosDeCampo CODIGO_INTERNO = new ParametrosDeCampo();
    private static final ParametrosDeCampo CODIGO_PROVEEDOR = new ParametrosDeCampo();
    private static final ParametrosDeCampo DESCRIPCION = new ParametrosDeCampo();
    private static final ParametrosDeCampo QUE_ES = new ParametrosDeCampo();
    private static final ParametrosDeCampo PARA_QUE_ES = new ParametrosDeCampo();
    private static final ParametrosDeCampo REFACCION_DE_CONSUMO_UNICO = new ParametrosDeCampo();

    public RefaccionIT() {
    
           
        ID.setNombre("id");
        ID.setLongitudDeCaracteres(11);
        ID.setTipoDeDatos("int");
        ID.setNulo(false);
        ID.setAutoIncrement(true);
        ID.setPermiteRepetido(false);

        NOMBRE.setNombre("nombre");
        NOMBRE.setLongitudDeCaracteres(50);
        NOMBRE.setTipoDeDatos("int");
        NOMBRE.setNulo(false);
        NOMBRE.setAutoIncrement(false);
        NOMBRE.setPermiteRepetido(true);
        NOMBRE.setNombreParaMostrar("Nombre de la Refacción");

        ID_MATERIAL.setNombre("idMaterial");
        ID_MATERIAL.setLongitudDeCaracteres(11);
        ID_MATERIAL.setTipoDeDatos("int");
        ID_MATERIAL.setNulo(false);
        ID_MATERIAL.setAutoIncrement(false);
        ID_MATERIAL.setPermiteRepetido(true);
        ID_MATERIAL.setNombreParaMostrar("Material");

        IMPORTANCIA.setNombre("importancia");
        IMPORTANCIA.setLongitudDeCaracteres(11);
        IMPORTANCIA.setTipoDeDatos("int");
        IMPORTANCIA.setNulo(false);
        IMPORTANCIA.setAutoIncrement(false);
        IMPORTANCIA.setPermiteRepetido(true);
        IMPORTANCIA.setNombreParaMostrar("Importancia");

        STOCK_MINIMO.setNombre("stockMinimo");
        STOCK_MINIMO.setTipoDeDatos("float");
        STOCK_MINIMO.setLongitudDeCaracteres(10);
        STOCK_MINIMO.setLongitudDeDecimales(3);
        STOCK_MINIMO.setNulo(false);
        STOCK_MINIMO.setAutoIncrement(false);
        STOCK_MINIMO.setPermiteRepetido(true);
        STOCK_MINIMO.setNombreParaMostrar("Stock Mín");

        STOCK_MAXIMO.setNombre("stockMaximo");
        STOCK_MAXIMO.setTipoDeDatos("float");
        STOCK_MAXIMO.setLongitudDeCaracteres(10);
        STOCK_MAXIMO.setLongitudDeDecimales(3);
        STOCK_MAXIMO.setNulo(false);
        STOCK_MAXIMO.setAutoIncrement(false);
        STOCK_MAXIMO.setPermiteRepetido(true);
        STOCK_MAXIMO.setNombreParaMostrar("Stock Máx");

        UNIDAD.setNombre("unidad");
        UNIDAD.setLongitudDeCaracteres(11);
        UNIDAD.setTipoDeDatos("int");
        UNIDAD.setNulo(false);
        UNIDAD.setAutoIncrement(false);
        UNIDAD.setPermiteRepetido(true);
        UNIDAD.setNombreParaMostrar("Unidad");

        CODIGO_INTERNO.setNombre("codigoInterno");
        CODIGO_INTERNO.setLongitudDeCaracteres(20);
        CODIGO_INTERNO.setTipoDeDatos("varchar");
        CODIGO_INTERNO.setNulo(false);
        CODIGO_INTERNO.setAutoIncrement(false);
        CODIGO_INTERNO.setPermiteRepetido(false);
        CODIGO_INTERNO.setNombreParaMostrar("Código Interno");

        CODIGO_PROVEEDOR.setNombre("codigoProveedor");
        CODIGO_PROVEEDOR.setLongitudDeCaracteres(20);
        CODIGO_PROVEEDOR.setTipoDeDatos("varchar");
        CODIGO_PROVEEDOR.setNulo(true);
        CODIGO_PROVEEDOR.setAutoIncrement(false);
        CODIGO_PROVEEDOR.setPermiteRepetido(true);
        CODIGO_PROVEEDOR.setNombreParaMostrar("Código del Proveedor");

        DESCRIPCION.setNombre("descripcion");
        DESCRIPCION.setLongitudDeCaracteres(500);
        DESCRIPCION.setTipoDeDatos("varchar");
        DESCRIPCION.setNulo(false);
        DESCRIPCION.setAutoIncrement(false);
        DESCRIPCION.setPermiteRepetido(true);
        DESCRIPCION.setNombreParaMostrar("Descripción");

        QUE_ES.setNombre("queEs");
        QUE_ES.setLongitudDeCaracteres(250);
        QUE_ES.setTipoDeDatos("varchar");
        QUE_ES.setNulo(true);
        QUE_ES.setAutoIncrement(false);
        QUE_ES.setPermiteRepetido(true);
        QUE_ES.setNombreParaMostrar("¿Que es?");

        PARA_QUE_ES.setNombre("paraQueEs");
        PARA_QUE_ES.setLongitudDeCaracteres(250);
        PARA_QUE_ES.setTipoDeDatos("varchar");
        PARA_QUE_ES.setNulo(true);
        PARA_QUE_ES.setAutoIncrement(false);
        PARA_QUE_ES.setPermiteRepetido(true);
        PARA_QUE_ES.setNombreParaMostrar("¿Para que es?");
        
        REFACCION_DE_CONSUMO_UNICO.setNombre("refaccionDeConsumoUnico");
        REFACCION_DE_CONSUMO_UNICO.setLongitudDeCaracteres(1);
        REFACCION_DE_CONSUMO_UNICO.setTipoDeDatos("byte");
        REFACCION_DE_CONSUMO_UNICO.setNulo(false);
        REFACCION_DE_CONSUMO_UNICO.setAutoIncrement(false);
        REFACCION_DE_CONSUMO_UNICO.setPermiteRepetido(true);
        REFACCION_DE_CONSUMO_UNICO.setNombreParaMostrar("¿Es refacción de consumo único?");
        
        CAMPOS_PDC.add(ID);
        CAMPOS_PDC.add(NOMBRE);
        CAMPOS_PDC.add(ID_MATERIAL);
        CAMPOS_PDC.add(IMPORTANCIA);
        CAMPOS_PDC.add(STOCK_MINIMO);
        CAMPOS_PDC.add(STOCK_MAXIMO);
        CAMPOS_PDC.add(UNIDAD);
        CAMPOS_PDC.add(CODIGO_INTERNO);
        CAMPOS_PDC.add(CODIGO_PROVEEDOR);
        CAMPOS_PDC.add(DESCRIPCION);
        CAMPOS_PDC.add(QUE_ES);
        CAMPOS_PDC.add(PARA_QUE_ES);
        CAMPOS_PDC.add(REFACCION_DE_CONSUMO_UNICO);
        
        

    }

   
    public static ParametrosDeCampo getID() {
        return ID;
    }

    

    public static ParametrosDeCampo getNOMBRE() {
        return NOMBRE;
    }

    

    public static ParametrosDeCampo getID_MATERIAL() {
        return ID_MATERIAL;
    }

    

    public static ParametrosDeCampo getIMPORTANCIA() {
        return IMPORTANCIA;
    }

    

    public static ParametrosDeCampo getSTOCK_MINIMO() {
        return STOCK_MINIMO;
    }

    

    public static ParametrosDeCampo getSTOCK_MAXIMO() {
        return STOCK_MAXIMO;
    }

    

    public static ParametrosDeCampo getUNIDAD() {
        return UNIDAD;
    }

    

    public static ParametrosDeCampo getCODIGO_INTERNO() {
        return CODIGO_INTERNO;
    }

    

    public static ParametrosDeCampo getCODIGO_PROVEEDOR() {
        return CODIGO_PROVEEDOR;
    }

    

    public static ParametrosDeCampo getDESCRIPCION() {
        return DESCRIPCION;
    }

    

    public static ParametrosDeCampo getQUE_ES() {
        return QUE_ES;
    }

    

    public static ParametrosDeCampo getPARA_QUE_ES() {
        return PARA_QUE_ES;
    }

    

    public static ParametrosDeCampo getREFACCION_DE_CONSUMO_UNICO() {
        return REFACCION_DE_CONSUMO_UNICO;
    }

    
    
}
