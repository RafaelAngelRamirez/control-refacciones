/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.Coordinador;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelo.InfoTabla.EntradaLoteIT;
import modelo.logica.ComparacionLotes;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.ColoresYFuentes;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class PanelSalidaLoteContenedorDeFila extends JPanel {

    private static final long serialVersionUID = 1L;
    
    ComparacionLotes cl;
    JLabel etiquetaLote;
    JLabel etiquetaExistencia;
    JTextField recuadroEntrada;
    Runnable r;
    BigDecimal cantidadAgreadaPorUsuario;
    UtilidadesTxt_ _txtRecuadroEntrada;
    Coordinador coordinador;

    public JLabel getEtiquetaExistencia() {
        return etiquetaExistencia;
    }

    public void setEtiquetaExistencia(JLabel etiquetaExistencia) {
        this.etiquetaExistencia = etiquetaExistencia;
    }

    public JTextField getRecuadroEntrada() {
        return recuadroEntrada;
    }

    public void setRecuadroEntrada(JTextField recuadroEntrada) {
        this.recuadroEntrada = recuadroEntrada;
    }
    
    public PanelSalidaLoteContenedorDeFila(ComparacionLotes cl) {
        this.cl = cl;
        generarFila();
    }

    public ComparacionLotes getCl() {
        return cl;
    }

    public void setCl(ComparacionLotes cl) {
        this.cl = cl;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    private void generarFila() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        etiquetaLote = new JLabel();
        etiquetaExistencia = new JLabel();
        recuadroEntrada = new JTextField();
        Dimension dimRec = new Dimension(110, 30);
        Dimension dimEti = new Dimension(100, 30);
        recuadroEntrada.setPreferredSize(dimRec);
        recuadroEntrada.setMinimumSize(dimRec);
        recuadroEntrada.setMaximumSize(dimRec);
        etiquetaExistencia.setPreferredSize(dimEti);
        etiquetaExistencia.setMinimumSize(dimEti);
        etiquetaExistencia.setMaximumSize(dimEti);
        etiquetaLote.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaExistencia.setAlignmentX(Component.CENTER_ALIGNMENT);
        recuadroEntrada.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaLote.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaExistencia.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaExistencia.setVerticalAlignment(SwingConstants.CENTER);
        etiquetaLote.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaLote.setOpaque(true);
        etiquetaExistencia.setOpaque(true);
        etiquetaExistencia.setBackground(ColoresYFuentes.TEMA_FONDO_ETIQUETAS_OSCURO);
        etiquetaLote.setFont(ColoresYFuentes.FUENTE_ALINEADA);
        etiquetaExistencia.setFont(ColoresYFuentes.FUENTE_ALINEADA);
        recuadroEntrada.setFont(ColoresYFuentes.FUENTE_CUADRO_TEXTO_NORMAL);
        EntradaLoteIT eit = new EntradaLoteIT();
        _txtRecuadroEntrada = new UtilidadesTxt_(getCoordinador());
        _txtRecuadroEntrada.setComponente(recuadroEntrada);
        _txtRecuadroEntrada.setTamanoDeCampo(eit.getCantidadPDC().getLongitudDeCaracteres(), eit.getCantidadPDC().getLongitudDeDecimales());
        _txtRecuadroEntrada.setPermitirSoloNumeros();
        _txtRecuadroEntrada.getThis().setHorizontalAlignment(JTextField.CENTER);
        // ASIGNAMOS LOS VALORES PARA LAS ETIQUETAS.
        etiquetaLote.setText(cl.getLote().getNombreParaMostrarLote());
        String tExistencia = (cl.getLote().getCantidad() - cl.getExistenciaPreFinal()) + "";
        etiquetaExistencia.setText(tExistencia);
        cantidadAgreadaPorUsuario = new BigDecimal(cl.getExistenciaPreFinal());
        recuadroEntrada.setText(cantidadAgreadaPorUsuario.toString());
        add(etiquetaLote);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(etiquetaExistencia);
        add(Box.createRigidArea(new Dimension(10, 0)));
        add(recuadroEntrada);
        validate();
        KeyAdapter k = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //RETORNAMOS EL CAMPO AL QUE ESTAMOS DANDO LA ACCIÓN.
                JTextField t = (JTextField) e.getComponent();
                //OBTENEMOS EL TEXTO ESCRITO.
                String texto = t.getText();
                //SI HAY TEXTO HACEMOS LAS SIGUIENTES ACCIONES.
                if (!texto.isEmpty()) {
                    //CREAMOS EL NUEVO BIGDECIMAL QUE CONTEDRA LA CANTIDAD
                    // ESCRITA POR EL USUARIO.
                    cantidadAgreadaPorUsuario = new BigDecimal(texto);
                    //CREAMOS UN NUEVO BIGDECIMAL CON LA EXISTENCIA ACTUAL
                    BigDecimal big = new BigDecimal(cl.getLote().getCantidad());
                    //RESTAMOS LA CANTIDAD INGRESADA POR EL USUARIO
                    //A LA EXISTECIA ACTUAL.
                    big = big.subtract(cantidadAgreadaPorUsuario);
                    //SETEAMOS LA ETIQUETA.
                    etiquetaExistencia.setText(big.toString());
                    //COLOREAMOS SEGÚN EL CASO.
                    colorearEtiqueta();
                } else {
                    //SI EL CAMPO ESTA VACIO ENTONCES PONEMOS LA CANTIDAD
                    //AGREGADA POR EL USUARIO EN 0 Y LA ETIQUETA DE EXISTENCIA
                    //LA DEVOLVEMOS Al VALOR DE EXISTENCIA DEL LOTE.
                    cantidadAgreadaPorUsuario = new BigDecimal(0.0);
                    etiquetaExistencia.setText(cl.getLote().getCantidad() + "");
                    colorearEtiqueta();
                }
                r.run();
            }
        };
        //AÑADIMOS EL CUADRO AL LISTENER.
        recuadroEntrada.addKeyListener(k);
        FocusListener f = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField t = (JTextField) e.getComponent();
                t.setSelectionStart(0);
                t.setSelectionEnd(t.getText().length());
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField t = (JTextField) e.getComponent();
                if (t.getText().isEmpty()) {
                    t.setText("0.0");
                }
            }
            
            
        };
        recuadroEntrada.addFocusListener(f);
    }

    public void setR(Runnable r) {
        this.r = r;
    }

    public BigDecimal getCantidadAgreadaPorUsuario() {
        if (cantidadAgreadaPorUsuario == null) {
            cantidadAgreadaPorUsuario = new BigDecimal(0);
        }
        return cantidadAgreadaPorUsuario;
    }

    public void setCantidadAgreadaPorUsuario(BigDecimal cantidadAgreadaPorUsuario) {
        this.cantidadAgreadaPorUsuario = cantidadAgreadaPorUsuario;
    }

    public void colorearEtiqueta() {
        BigDecimal big = new BigDecimal(etiquetaExistencia.getText());
        if (big.signum() == -1) {
            etiquetaExistencia.setBackground(ColoresYFuentes.ERROR_TXT_RESALTAR_BG);
            etiquetaExistencia.setForeground(ColoresYFuentes.ERROR_TXT_RESALTAR_FG);
        } else {
            etiquetaExistencia.setBackground(ColoresYFuentes.TEMA_FONDO_ETIQUETAS_OSCURO);
            etiquetaExistencia.setForeground(ColoresYFuentes.TEMA_TXT_FG);
        }
    }

    public void consolidar() {
        cl.consolidar();
    }
    
    public void consolidadExistenciaModificadaPorUsuario(){
        Float f = Float.parseFloat(etiquetaExistencia.getText());
        cl.setExistenciaModificadaPorUsuario(f);
        cl.consolidarExistenciaModificadaPorUsuario();
    }
    
}
