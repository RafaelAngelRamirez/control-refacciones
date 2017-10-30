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
    boolean ejecutado;
    int tiempo;
    
    boolean  repetir;

    public Precarga() {
        this.tiempo = -1;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
       
    void mostrarPrecarga(int tiempo) {
        mostrarPrecarga();
        this.tiempo = tiempo;
    }
     
    public synchronized void mostrarPrecarga(){
        repetir = true;
        if (ejecutado) {
            esteHilo.start();
            ejecutado = false;
        }else{
            esteHilo = new PrecargaHilo();
            ejecutado = true;
            mostrarPrecarga();
        }
    }
    
    

    public synchronized void terminarPrecarga(){
        mensaje="";
        repetir = false;
    }
    
    String mensaje;
    public synchronized void terminarPrecarga(String mensaje){
        terminarPrecarga();
        this.mensaje = mensaje;
    }

   
   
        
    private class PrecargaHilo extends Thread{
        boolean salir = false;
        @Override
        public void run() {
            try {
                
                esteHilo.sleep(500);
                if (repetir) {
                    JDialog precarga = mostrarCarga();
                    Thread h = new Thread(()->precarga.setVisible(true));
                    h.start();
    //                precarga.setAlwaysOnTop(true);
                    while (!salir) {
                            esteHilo.sleep(50);
                            if (!repetir) {
                                salir = true;
                            }
                    }
    //                precarga.setModal(true);
                    if (tiempo!=-1) {
                        esteHilo.sleep(tiempo);
                    }else{
                        esteHilo.sleep(100);

                    }
                    float i = 1;
                    while (i>=0.1f) {                    
                        precarga.setOpacity(i);
                        i-=0.01f;
                        esteHilo.sleep(1);

                    }
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
