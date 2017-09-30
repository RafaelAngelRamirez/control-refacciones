/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz.utilidadesOptimizadas;

 
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
 
/**
 * Definimos un modelo de tabla propio para que las celdas no sean editables
 * entre otras cosas.
 * 
 */
public class UtilidadesModeloDeTabla_ extends DefaultTableModel {
    String[] titulosDeLaTabla;
    
    
    /**
     * Define la posibilidad de editar la columna. En este caso solo esta definida
     * como false por que no queremos que se edite la tabla. 
     * @return NA
     */
       
    @Override
    public final boolean isCellEditable(int row, int column) {
        return false;
    }
    
    /**
     * Añade los datos al modelo y relaciona la fila con el id que tiene en la 
     * tabla. Para acceder a este id es necesario invocar el HashMap y pasarle
     * el número de fila. 
     * 
     * El hasmap se crea por fila, de manera que el entero define la posición 
     * en que se mostrara el dato. 
     * 
     * Es necesario primero escribir los títulos para que no se sobreescriban
     * los datos.
     * 
     * @param mapaDatos Mapa de datos super complicado que no entiendo a la 
     * hora de comentar. XP!!! Hay que comentar esto.
     */
    public void addDatos(HashMap<Integer,String> mapaDatos){
        Object[] fila = new Object[mapaDatos.size()];
        for (Map.Entry<Integer, String> dato : mapaDatos.entrySet()) {
            Integer columna = dato.getKey();
            String valor = dato.getValue();
            fila[columna-1] = valor;
                
        }
        this.insertRow(this.getRowCount(), fila);
        
    }
    
    /**
     *Define los encabezados que llevara la tabla. 
     * @param titulosDeLaTabla Los títulos que llevara la tabla.
     */
    public void setTitulosDeLaTabla(String[] titulosDeLaTabla) {
        this.setColumnIdentifiers(titulosDeLaTabla);
        this.titulosDeLaTabla = titulosDeLaTabla;
    }
}