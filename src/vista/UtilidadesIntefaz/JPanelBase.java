/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz;

import controlador.Coordinador;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Particular
 */
public abstract class JPanelBase extends JPanel{
    
    protected ConfiguracionDePanel configuracionesDialogo;
    
    Coordinador coordinador;
    int arrastre = 0;

    public JPanelBase() {
        
//        this.addMouseListener(new MouseAdapter() {
//            JPanelBase panel;
//            public MouseAdapter parametros (JPanelBase panel){
//                this.panel = panel;
//                return this;
//            }
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount()==3) {
//                    //SI DEVUELVE TRUE QUIERE DECIR QUE EL PANEL ESTABA MONTADO
//                    //SOBRE UN DIALOGO, ENTONCES DESPUES DE CERRAR SE EJECUTA
//                    // LA OPERACIÓN QUE DEFINIMOS DENTORDE configuracionesDialogo
//                    // operacionDeAcople().
//                    if (panel.dispose()) {
//                        panel.getConfiguracionesDialogo().getOperacionDeAcople().run();
//                    }else{
//                        try {
//                            //OJO CON ESTA PARTE QUE DESDE QUE MODIFICASTE CALLABLE
//                            // NO LA HAS PROBADO. 
//                            panel.getConfiguracionesDialogo().getOperacionDesacople().call();
//                        } catch (Exception ex) {
//                            Logger.getLogger(JPanelBase.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//        }.parametros(this));
//        
//        this.addMouseMotionListener( new MouseMotionListener() {
//            
//            
//            int contador = 0;
//            JPanelBase panel;
//            public MouseMotionListener parametros(JPanelBase panel){
//                this.panel = panel;
//                return this;
//            }
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                panel.arrastre++;
//                System.out.println(panel.arrastre + "alksdjfñlakjsdf");
//                if (panel.arrastre>30&&panel.configuracionesDialogo.getDialogoTemporal()==null) {
//                    Point p = new Point(e.getXOnScreen(), e.getYOnScreen());
//                    panel.configuracionesDialogo.setUltimaPosicionDeDialogo(p);
//                    JDialogBase a;
//                    try {
//                        a = panel.configuracionesDialogo.getOperacionDesacople().call();
//                        panel.configuracionesDialogo.setDialogoTemporal((JDialogBase)a);
//                        System.out.println("desacopleeeeeeeeeeeeeee");
//                    } catch (Exception ex) {
//                        Logger.getLogger(JPanelBase.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }else{
//                    Point p = new Point(e.getXOnScreen()-100, e.getYOnScreen()-50);
//                    if (panel.configuracionesDialogo.getDialogoTemporal()!=null) {
//                        panel.configuracionesDialogo.getDialogoTemporal().setLocation(p);
//                    }
//                
//                }
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                System.out.println("estaarrastrandoseeeeeeeee");
//                panel.arrastre = 0;
//            }
//        }.parametros(this));
//        
//        this.addMouseMotionListener();
        
    }
    
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    
    /**
     * La configuración inicial del panel.
     */
    public abstract void configurar();

    public ConfiguracionDePanel getConfiguracionesDialogo() {
        return configuracionesDialogo;
    }
    
    
    public boolean dispose(){
        return this.getCoordinador().getCoordinadorPaneles().cerrarDialogoAbierto(this);
    }
    

        
}
