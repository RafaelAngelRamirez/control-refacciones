
package controlador.ActualizacionDeComponentesGráficos;

import controlador.Coordinador;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


/**
 * 
 * 
 * //EN PROCESO.
 * Esta clase permite controlar la actualización de los componentes que se visualizan
 * en una interfa. Si la interfaz esta visible ejecuta las acciones que se soliciten, si
 * no lo estan espera hasta que este visibles. Cada vez que un objeto se hace 
 * visible es necesario llamar a esta clase para actualizarla. 
 * 
 * @author Rafael Ángel Ramírez Estrada
 */
public class ControlDeActualizacionDeComponentesGraficos {
    
    Coordinador coordinador;
    //AYUDA A MANTENER EL CONTROL DE LA TABLAS. 
    private HashMap<String, ControlDeTabla>controlDeTablas = new HashMap<>();
    //AYUDA A MANTENER EL CONTROL DE LOS DIALOGOS. 
    private HashMap<String, ContenedorDeOperacionesDeActualizacion>ControlDePanelesDialogos = new HashMap<>();
    

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
           
    /**
     * Crea la relación que hay entre la tabla, el dialogo y las operaciones 
     * de actaulización que se quieren ejecutar. 
     * @param nombreDeLaTabla El nombre de la tabla. 
     * @param nombreDelDialogo El nombre del dialogo. 
     * @param nombreDeLaOperacion El nombre que identifique a la operación que
     * se quiere ejecutar. 
     * @param operacionParaAgregar La operación que se quiere agregar. 
     */
    public void addOperacionDeActualizacion(
            String nombreDeLaTabla, 
            String nombreDelDialogo, 
            String nombreDeLaOperacion, 
            Callable operacionParaAgregar){
        
        //SI LA TABLA NO SE HA REGISTRADO ENTONCES LA AGREGAMOS A LA LISTA.
        if (!controlDeTablas.containsKey(nombreDeLaTabla)) {
            this.controlDeTablas.put(nombreDeLaTabla, new ControlDeTabla());
        }
        
        //SI EL DIALOGO NO SE HA AGREGADO AL MAPA DE DIALOGOS ENTONCES LO AGREGAMOS.
        if (!ControlDePanelesDialogos.containsKey(nombreDelDialogo)) {
            this.ControlDePanelesDialogos.put(nombreDelDialogo, new ContenedorDeOperacionesDeActualizacion());
        }
        
        
        
        
   
    }
    
    public void actualizarComponente(String dialogoPanel, String NombreDeLaOperacion){
    
    
    
    };    
    
    @Override
    public String toString(){
        String m1  = "=============================================================================\n";
               m1 += "ELEMENTOS CONTENIDOS EN EL 'CONTROL DE ACTUALIZACIÓN DE COMPONENTES GRÁFICOS'\n";
               m1 += "=============================================================================\n";
        m1+= "\n\tTABLAS:";
        String mN ="";
        
        for (Map.Entry<String, ControlDeTabla> entry : controlDeTablas.entrySet()) {
            String key = entry.getKey();
            ControlDeTabla value = entry.getValue();
            
            mN += "\n\t"+"| "+key+"'";
            
        }
        m1+=mN;
       
        m1+= "\n\tDIALOGOS:";
        String mN2 ="";
        
        for (Map.Entry<String, ControlDeTabla> entry : controlDeTablas.entrySet()) {
            String key = entry.getKey();
            ControlDeTabla value = entry.getValue();
            mN2 += "\n\t"+"| "+key+"'";
            
        }
        m1+=mN2;
        
        return m1;
        
    }
    
        

    
    
    



}


