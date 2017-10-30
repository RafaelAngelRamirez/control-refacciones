package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * Esta clase permite mostrar un mensaje de esteHilo para operaciones largar. 
 * Por el momento bloquea todas las acciones hasta que la carga termine. 
 * @author Particular
 */
public class Precarga {

    JPanel panel;
    Thread esteHilo;
    boolean creado;
    int tiempo;
    
    boolean  repetir;

    public Precarga() {
        this.tiempo = -1;
    }

    /**
     * El panel que se mostrara durante la precarga. 
     * @return 
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * El panel que se mostrara durante la precarga. 
     * @param panel
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    /**
     * Inicializa la precarga y modifica el tiempo de espera sleep() que se
     * ejecutara despues de que el ciclo de la precarga haya sido definido
     * como terminado. 
     * @param tiempo El tiempo que se quedara dormida la precarga antes de ser
     * detenido en milisegundos. 
     */   
    public void mostrarPrecarga(int tiempo) {
        mostrarPrecarga();
        this.tiempo = tiempo;
    }
     
    /**
     * Muestra la precarga con el tiempo de espera por defecto (100 milisegundos) despues del que el 
     * ciclo de la precarga haya sido defindo como terminado.
     */
    public synchronized void mostrarPrecarga(){
        //DEFINIMOS ESTA VARIABLE ASÍ PARA QUE EL CICLO DE ESPERA
        // COMIENZE.
        repetir = true;
        
        if (creado) {
            //SI EL HILO YA SE EJECUTO-CREO ENTONCES LO CORREMOS. 
            esteHilo.start();
            //CAMBIAMOS A FALSE LA VARIABLE POR QUE CUANDO TERMINE EL HILO
            // HAY QUE VOLVER A CREAR OTRO. 
            creado = false;
        }else{
            //SI NO HA SIDO CREADO ENTONCES LO CREAMOS. 
            esteHilo = new PrecargaHilo();
            //CAMBIAMOS ESTA VARIABLE Y VOLVEMOS A LLAMAR ESTA MISMA FUNCIÓN.
            creado = true;
            mostrarPrecarga();
        }
    }
    
    /**
     * Termina la ejecución del hilo de precarga. 
     */
    public synchronized void terminarPrecarga(){
        //TERMINA SIN UN MENSAJE. 
        mensaje="";
        //repetir ES LA VARIABLE QUE MANTIENE EL BUCLE ANDANDO. SE PONE EN
        // FALSE PARA QUE EL HILO SE DETENGA DE MANERA NATURAL. 
        repetir = false;
    }
    
    String mensaje;

    /**
     * Termina la precaga ejecutando un mensaje al final. 
     * @param mensaje
     */
    public synchronized void terminarPrecarga(String mensaje){
        terminarPrecarga();
        this.mensaje = mensaje;
    }

   
   
    /**
     * Esta clase ejecuta la precarga. 
     */
    private class PrecargaHilo extends Thread{
        boolean salir = false;
        @Override
        public void run() {
            try {
                //ESPERAMOS 500 MILISEGUNDOS. CUALQUIER OPERACIÓN MÁS CORTA
                // QUE ESTO NO MOSTRARA LA PRECARGA. 
                esteHilo.sleep(500);
                if (repetir) {
                    //COMO LA CARGA TARDO MÁS DE 500 MILISEGUNDOS ENTONCES
                    // MOSTRAMOS LA PRECARGA EN OTRO HILO. 
                    JDialog precarga = mostrarCarga();
                    Thread h = new Thread(()->precarga.setVisible(true));
                    h.start();
                    
                    //COMPROBAMOS QUE SALIR ESTE EN false. 
                    while (!salir) {
                            //ESPERAMS 50 MILISEGUNDOS PARA COMPROBAR SI NO
                            // SE HA DEFINIDO repetir=false;
                            esteHilo.sleep(50);
                            if (!repetir) {
                                // SI SE DEFINIO ENTONCES CAMBIAMOS LA VARIABLE
                                // salir=true POR QUE LA EJECUCIÓN DEL HILO DE
                                // LA OPERACIÓN YA TERMINO. 
                                salir = true;
                            }
                    }
                    //SI NO DEFINIMOS EL TIEMPO ENTONCES ESPERAMOS 100 MILISEGUNDOS
                    // ANTES DE EMPEZAR A CAMBIAR LA OPACIDAD DEL PANEL.
                    if (tiempo!=-1) {
                        esteHilo.sleep(tiempo);
                    }else{
                        esteHilo.sleep(100);

                    }
                    //LA OPACIDAD.
                    float i = 1;
                    while (i>=0.1f) {                    
                        precarga.setOpacity(i);
                        i-=0.01f;
                        esteHilo.sleep(1);

                    }
                    //CERRAMOS EL PANEL Y EL HILO MUERE. 
                    precarga.dispose();


                    if (!mensaje.equals("")) {
                        JOptionPane.showMessageDialog(null, mensaje);

                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Precarga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    boolean encima;

    public boolean isEncima() {
        return encima;
    }

    public void setEncima(boolean encima) {
        this.encima = encima;
    }
    
    
    
    public synchronized JDialog mostrarCarga(){
        
        JDialog d;
        d = new JDialog();
        d.add(panel);
        d.setUndecorated(true);
        d.pack();
        d.setSize(panel.getSize());
        d.setAlwaysOnTop(encima);

        d.setLocationRelativeTo(null);
        
        return d;
    }
    
}
