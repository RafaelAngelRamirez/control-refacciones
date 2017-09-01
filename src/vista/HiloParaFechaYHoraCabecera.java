
package vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
    * Maneja la fecha y la hora. Entrega diferentes versiones del mismo y 
    * tambien brinda algúnas otras utilidades.
    * @author Rafael Ángel Ramírez Estrada
    */
    public class HiloParaFechaYHoraCabecera implements Runnable {

       private Thread hilo1;
       private JLabel etiquetaHora;
       private JLabel etiquetaFecha;

       public HiloParaFechaYHoraCabecera()  {
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
           this.etiquetaHora.setText(FechaYHora.Actual.getHora_Hhmmss());
       }
       
       /**
        * Crea el formato y cargar la equiteta dispuesta para la fecha. 
        */
       public void fechaCompleta(){
           this.etiquetaFecha.setText(FechaYHora.Actual.getFecha_Dia_dd_mes_anio().toUpperCase());
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
                System.out.println(FechaYHora.Actual.getHora_Hhmmss());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Error iniciando el  reloj!!!");
                    Logger.getLogger(HiloParaFechaYHoraCabecera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       }
    }