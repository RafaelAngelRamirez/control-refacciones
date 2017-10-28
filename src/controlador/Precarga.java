package controlador;

import java.awt.FlowLayout;
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
    
    boolean  repetir;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
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
                JDialog precarga = mostrarCarga();
                
                while (!salir) {
                        precarga.requestFocus();
                        esteHilo.sleep(100);
                        if (!repetir) {
                            salir = true;
                        }
                }
                
                esteHilo.sleep(1000);
                precarga.dispose();

                if (!mensaje.equals("")) {
                    JOptionPane.showMessageDialog(null, mensaje);

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Precarga.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public synchronized JDialog mostrarCarga(){
        JDialog dialogoPrecarga;
        dialogoPrecarga = new JDialog();
        dialogoPrecarga.setLayout(new FlowLayout());
        dialogoPrecarga.dispose();
        dialogoPrecarga.setUndecorated(true);

        dialogoPrecarga.add(panel);
        dialogoPrecarga.setSize(panel.getSize());
        dialogoPrecarga.pack();

        dialogoPrecarga.setVisible(true);
        dialogoPrecarga.setLocationRelativeTo(null);
        return dialogoPrecarga;
    }
    
}
