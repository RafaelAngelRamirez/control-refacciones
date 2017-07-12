
package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * Maneja la fecha y la hora. Entrega diferentes verciones del mismo y 
 * tambien brinda algúnas otras utilidades.
 * @author Rafael Ángel Ramírez Estrada
 */
public class FechaYHora implements Runnable {
    
    private Thread hilo1;
    private JLabel etiquetaHora;
    private JLabel etiquetaFecha;

    public FechaYHora()  {
        this.hilo1 = new Thread(this    );
        this.hilo1.start();
       
    }

    public void setEtiquetaHora(JLabel etiquetaHora) {
        this.etiquetaHora = etiquetaHora;
    }

    public void setEtiquetaFecha(JLabel etiquetaFecha) {
        this.etiquetaFecha = etiquetaFecha;
    }
    
    
//    public void pruebas(){
//        Date date = new Date();
//        //Caso 1: obtener la hora y salida por pantalla con formato:
//        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
//        //Caso 2: obtener la fecha y salida por pantalla con formato:
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Fecha: "+dateFormat.format(date));
//        //Caso 3: obtenerhora y fecha y salida por pantalla con formato:
//        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
//        System.out.println("Hora y fecha: "+hourdateFormat.format(date));
//    
//    }
    
    public void horaMinutoSegundo(){
        Date hora = new Date();
        DateFormat horaFormateada = new SimpleDateFormat("HH:mm:ss");
        this.etiquetaHora.setText(horaFormateada.format(hora));
    }
    
    public void fechaCompleta(){
        String diaCompleto, dia, mesCompleto, anio;
        
        Date date = new Date();
        HashMap<String, String> meses = new HashMap();
        meses.put("1", "Enero");
        meses.put("2", "Febrero");
        meses.put("3", "Marzo");
        meses.put("4", "Abril");
        meses.put("5", "Mayo");
        meses.put("6", "Junio");
        meses.put("7", "Julio");
        meses.put("8", "Agosto");
        meses.put("9", "Septiembre");
        meses.put("10", "Octubre");
        meses.put("11", "Noviembre");
        meses.put("12", "Diciembre");
        
        HashMap<String, String> diasCompletos = new HashMap();
        diasCompletos.put("2","Domingo");
        diasCompletos.put("3","Lunes");
        diasCompletos.put("4","Martes");
        diasCompletos.put("5","Miercoles");
        diasCompletos.put("6","Jueves");
        diasCompletos.put("7","Viernes");
        diasCompletos.put("1","Sábado");
        
        DateFormat mesDigito = new SimpleDateFormat("M");
        mesCompleto = meses.get(mesDigito.format(date));
        
        Calendar diaCalendario = Calendar.getInstance();
        diaCompleto = diasCompletos.get(""+diaCalendario.get(Calendar.DAY_OF_WEEK));
        dia = ""+diaCalendario.get(Calendar.DAY_OF_MONTH);
        
        Calendar anioCalendario = Calendar.getInstance();
        anio = ""+diaCalendario.get(Calendar.YEAR);
        
        this.etiquetaFecha.setText(diaCompleto + ", " +dia+ " de " +
                mesCompleto + ", " + anio);
        
    }

    @Override
    public void run() {
       while (true){
            if(this.etiquetaHora != null)
                this.horaMinutoSegundo();
           // if(this.etiquetaFecha != null)
                this.fechaCompleta();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FechaYHora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
