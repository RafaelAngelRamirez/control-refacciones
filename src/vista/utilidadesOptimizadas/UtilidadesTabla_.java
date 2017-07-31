
package vista.utilidadesOptimizadas;

import modelo.ExcepcionPersonalizada;
import controlador.Coordinador;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import modelo.vo.Suceso;

/**
 * Utilidades para el facil manejo de las tablas.
 * @author Particular
 */
public class UtilidadesTabla_ extends OperacionesBasicasPorDefinir_{
    
    private JTable tabla;
    private String[] columnasDeLaTabla;
    private int[]tamanoMinimoDeColumna;
    private int[]tamanoMaximoDeColumna;
    private int[]tamanoPreferidoDeColumna;
    private String columnaId;
    private UtilidadesModeloDeTabla_ tableModel;
           
    HashMap<Integer, Integer> idDeFilaSeleccionada = new HashMap<>();

    public UtilidadesTabla_(Coordinador coordinador) {
        super(coordinador);
    }

    /**
     * Define los tamñaos de las las columnas. Se declaran en el mismo órden
     * que el título de las columnas y las sentencias sql.
     * @param tamanoMinimoDeColumna El mínimo tamaño de todas las columnas de la tabla.
     */
    public void setTamanoMinimoDeColumna(int[] tamanoMinimoDeColumna) {
        this.tamanoMinimoDeColumna = tamanoMinimoDeColumna;
    }
    
    /**
     * El tamaño máximo que tomara la columna.  
     * @param tamanoDeColumna El máximo tamaño de todas las columnas de la tabla.
     * 
     */
    public void setTamanoMaximoDeColumna(int []tamanoDeColumna){
        this.tamanoMaximoDeColumna = tamanoDeColumna;
    }
    /**
     * El tamaño preferido de la columna.  
     * @param tamanoDeColumna El tamaño con el que se mostrara la columna preferentemente.
     * Depende de varios factores para que se muestre exactamente este, pero en 
     * la mayoria de los casos responde bien a la asignación que se le haga.
     */
    public void setTamanoPreferidoDeColumna(int []tamanoDeColumna){
        this.tamanoPreferidoDeColumna = tamanoDeColumna;
    }
   
    
    /**
     * La tabla que se va a modificar.
     * @param tabla La tabla con la que se quiere trabajar.
     */
    public void setComponente(JTable tabla) {
        this.tabla = tabla;
    }

    
    /**
     *El nombre de las columnas de la BD de datos para cargar la tabla. Tienen
     * que estar órdenadas de la misma manera que los títulos y las consultas
     * en la sentencia sql y solicita un arreglo.
     * @param columnasDeLaTabla Las columnas de la tabla. 
     */
    public void setColumnasDeLaTabla(String[] columnasDeLaTabla) {
        this.columnasDeLaTabla = columnasDeLaTabla;
    }

    public void setColumnaId(String columnaId) {
        this.columnaId = columnaId;
    }

    public String getColumnaId() {
        return columnaId;
    }

//    public String[] getTitulosDeLaTabla() {
//        return titulosDeLaTabla;
//    }

    public String[] getColumnasDeLaTabla() {
        return columnasDeLaTabla;
    }

    public int[] getTamanoMinimoDeColumna() {
        if (tamanoMinimoDeColumna == null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No has definido el tamaño mínmo de las columnas.",
                        this,
                        "getTamanoMinimoDeColumna");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesTabla_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tamanoMinimoDeColumna;
    }

    public int[] getTamanoMaximoDeColumna() {
        if (tamanoMaximoDeColumna == null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No has definido el tamaño máximo de las columnas.",
                        this,
                        "getTamanoMaximoDeColumna");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesTabla_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tamanoMaximoDeColumna;
    }

    public int[] getTamanoPreferidoDeColumna() {
        if (tamanoPreferidoDeColumna == null) {
            try {
                throw new ExcepcionPersonalizada(
                        "No has definido el tamaño preferido de las columnas.",
                        this,
                        "tamanoPreferidoDeColumna");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesTabla_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tamanoPreferidoDeColumna;
    }

    public HashMap<Integer, Integer> getIdDeFilaSeleccionada() {
        return idDeFilaSeleccionada;
    }
    
    
    
    
    /**
     *Define el modelo de tabla UtilidadesMoideloDeTabla que utilizaremos para
     * trabajar con esta tabla. 
     * @param tableModel El modelo predefinido con algúnas opciones extras.
     * @see UtilidadesModeloDeTabla_
     */
    public void setTableModel( UtilidadesModeloDeTabla_ tableModel) {
        this.tableModel = tableModel;
        this.tabla.setModel(tableModel);
        
        Suceso s = new Suceso();
        s.setClase(this);
        s.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
        s.setTextoAMostrar("[!]Tabla cargada con éxito");
        //TOMAMOS LAS COLUMNAS DEL MODELO Y DEFINIMOS SU TAMAÑO.
        TableColumnModel columnModel = this.tabla.getColumnModel();

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(
                    this.getTamanoPreferidoDeColumna()[i]);
            columnModel.getColumn(i).setMinWidth(
                    this.getTamanoMinimoDeColumna()[i]);
            columnModel.getColumn(i).setMaxWidth(
                    this.getTamanoMaximoDeColumna()[i]);
        }
    }
    
    /**
     * Retorna el modelo de esta tabla. 
     * @return El modelo de tabla personalizado.
     */
    public UtilidadesModeloDeTabla_ getTableModel() {
        if (tableModel ==null) {
            try {
                throw new ExcepcionPersonalizada("No has definido el modelo de tabla.", "getTableModel");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesTabla_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tableModel;
        
    }
        
    /**
     * Recupera el dato que definamos en la intersección de fila y columna.
     * @param fila Número de fila. 
     * @param columna Número de columna. 
     * @return El dato que se encuentra en la intersección.
     */
    public String getDatoDeTabla(int fila, int columna){
        UtilidadesModeloDeTabla_ tm = (UtilidadesModeloDeTabla_) this.tabla.getModel();
        if (tm.getRowCount()!=0) {
            String dato=String.valueOf(tm.getValueAt(fila,columna));
            return dato;
        }
        return null;
    }
    /**
     * Recupera el dato que este seleccionado con el mouse.
     * @return El dato seleccionado. 
     */
    public String getDatoTabla(){
        
        return getDatoDeTabla(tabla.getSelectedRow(),
                tabla.getSelectedColumn());
    }
    
    /**
     * Recupera el dato de la columna donde se le de doble click de la columna
     * que se especique como parametro.
     * @param columna La columna de la que se obtendra el dato.
     * @return El dato que coincida o -1 si la tabla no esta seleccionada
     */
    public Object getDatoDeTabla(int columna){
        if (tabla.getSelectedRow()==-1) {
            return -1;
        }
        return getDatoDeTabla(tabla.getSelectedRow(),columna);
    }
    
    /**
     * Recupera el dato de la columna del número de file que se inserte.
     * @param fila La fila de la que se quiere recuperar el dato. 
     * @return El dato que coincida. 
     */
    public String getDatoDeTabla_fila(int fila){
        return getDatoDeTabla(fila,
                tabla.getSelectedColumn());
    }
    
    /**
     * Devuelve todos los datos que esten seleccionados de la columna que se le 
     * especifique. 
     * @param columna La columna objetivo. 
     * @return Todos los datos de la columna. 
     */
    public List<Object> getDatoDeTabla_Seleccionados(int columna){
        List<Object> datos = new ArrayList<>();
        int[] rows = tabla.getSelectedRows();
        for (int row : rows) {
            Object a = this.getDatoDeTabla(row, columna);
            datos.add(a);
        }
        return datos;
    }
    

    @Override
    public Component getThis() {
        return this.tabla;
    }

    @Override
    public String getText() {
        return this.getDatoTabla();
    }

    @Override
    public void setText(String txt) {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setText");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setError() {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setError");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setFocus() {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setFocus");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setEditable(boolean editable) {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setEditable");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
