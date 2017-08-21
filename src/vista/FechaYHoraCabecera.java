
package vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
    * Maneja la fecha y la hora. Entrega diferentes versiones del mismo y 
    * tambien brinda algúnas otras utilidades.
    * @author Rafael Ángel Ramírez Estrada
    */
    public class FechaYHoraCabecera implements Runnable {

       private Thread hilo1;
       private JLabel etiquetaHora;
       private JLabel etiquetaFecha;

       public FechaYHoraCabecera()  {
           this.iniciar();
       }
       
       /**
        * Inicia el hilo de manera segura.  
        */
       public void iniciar(){
           this.hilo1 = new Thread(this);
           this.hilo1.start();
           
       }
       
       /**
        * La etiqueta en la que se escribiran los datos de la hora.  
         * @param etiquetaHora La etiqueta donde se mostrara la hora. 
        */
       public void setEtiquetaHora(JLabel etiquetaHora) {
           this.etiquetaHora = etiquetaHora;
       }
       
       /**
        * La etiqueta en la que se escribiran los datos de la fecha.  
         * @param etiquetaFecha La etiqueta donde se mostrara la fecha. 
        */
       public void setEtiquetaFecha(JLabel etiquetaFecha) {
           this.etiquetaFecha = etiquetaFecha;
       }
       
       /**
        * Crea el reloj y lo asigna a la etiqueta dispuesta para eso. 
        */
       public void horaMinutoSegundo(){
           Date hora = new Date();
           DateFormat horaFormateada = new SimpleDateFormat("HH:mm:ss");
           this.etiquetaHora.setText(horaFormateada.format(hora));
       }
       
       /**
        * Crea el formato y cargar la equiteta dispuesta para la fecha. 
        */
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
           diasCompletos.put("1","Domingo");
           diasCompletos.put("2","Lunes");
           diasCompletos.put("3","Martes");
           diasCompletos.put("4","Miercoles");
           diasCompletos.put("5","Jueves");
           diasCompletos.put("6","Viernes");
           diasCompletos.put("7","Sábado");

           DateFormat mesDigito = new SimpleDateFormat("M");
           mesCompleto = meses.get(mesDigito.format(date));

           Calendar diaCalendario = Calendar.getInstance();
           diaCompleto = diasCompletos.get(""+diaCalendario.get(Calendar.DAY_OF_WEEK));
           dia = ""+diaCalendario.get(Calendar.DAY_OF_MONTH);

           anio = ""+diaCalendario.get(Calendar.YEAR);

           this.etiquetaFecha.setText(diaCompleto + ", " +dia+ " de " +
                   mesCompleto + ", " + anio);

       }
       /**
        * El run del hilo que se ejectuta cada segundo. Lo inicializamos con 
        * start() dentro de iniciar().
        */
       @Override
       public void run() {
            while (true){
                this.horaMinutoSegundo();
                this.fechaCompleta();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FechaYHoraCabecera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       }
    }