/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.CoordinadorPaneles;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.InfoTabla.*;
import modelo.logica.Validacion;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.ImportanciaVo;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaterialVo;
import modelo.vo.ProveedorVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import modelo.vo.RelacionRefaccionProveedorVo;
import modelo.vo.UnidadVo;
import org.jdesktop.swingx.JXImageView;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesBotones_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesComboBox_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesJXViewImage_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesListas_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesRadio_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxtArea_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;

/**
 *
 * @author Particular
 */
public class PanelRefaccionAgregar extends JPanelBase {

    private static final long serialVersionUID = 1L;
    
    UtilidadesJXViewImage_ _ImagenesRefacciones;
    UtilidadesComboBox_ _ComboUnidad;
    UtilidadesComboBox_ _ComboMaterial;

    UtilidadesListas_ _ListaProveedor;
    UtilidadesListas_ _ListaProveedorSeleccionado;
    UtilidadesListas_ _ListaMaquinaModelo;
    UtilidadesListas_ _ListasMaquinasSeleccionadas;
    
    UtilidadesTxt_ _TxtNombreDeLaRefaccion;
    UtilidadesTxt_ _TxtCodigo;
    UtilidadesTxt_ _TxtStockMin;
    UtilidadesTxt_ _TxtStockMax;
    UtilidadesTxt_ _TxtCodigoDelProveedor;
    
    UtilidadesTxtArea_ _TxtDescripcion;
    UtilidadesTxtArea_ _TxtQueEs;
    UtilidadesTxtArea_ _TxtParaQueEs;
    
    UtilidadesRadio_ _RadioImportancia;
    /**
     * Creates new form FormularioAgregarRefaccion
     */
    public PanelRefaccionAgregar() {
        initComponents();
        
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(true);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_REFACCION_AGREGAR);
        configuracionesDialogo.setLocationRelativeTo(null);
        configuracionesDialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    @Override
    public void initConfig() {
        /*
        =======================================================================
            INICIO SETEO NOMBRES DE ETIQUETA
        ///////////////////////////////////////////////////////////////////////
        */
        
        RefaccionIT rit = new RefaccionIT();
        ProveedorIT pit = new ProveedorIT();
        MaquinaModeloIT mmit = new MaquinaModeloIT();
        MaterialIT mit = new MaterialIT();
        ImportanciaIT iit= new ImportanciaIT();
        UnidadIT uit = new UnidadIT();
        
        etiquetaCodigoDelProveedor.setText(rit.getCodigoProveedorPDC().getNombreParaMostrar());
        etiquetaCodigoInterno.setText(rit.getCodigoInternoPDC().getNombreParaMostrar());
        etiquetaDeQueEstaEcho.setText(mit.getMaterialPDC().getNombreParaMostrar());
        etiquetaDescripcion.setText(rit.getDescripcionPDC().getNombreParaMostrar());
        etiquetaImportancia.setText(iit.getImportanciaPDC().getNombreParaMostrar());
        etiquetaMaquinas.setText(mmit.getModeloPDC().getNombreParaMostrar());
        etiquetaNombreDeLaRefaccion.setText(rit.getNombrePDC().getNombreParaMostrar());
        etiquetaParaQueEs.setText(rit.getParaQueEsPDC().getNombreParaMostrar());
        etiquetaProveedores.setText(pit.getEmpresaProveedorPDC().getNombreParaMostrar());
        etiquetaQueEs.setText(rit.getQueEsPDC().getNombreParaMostrar());
        etiquetaStockMax.setText(rit.getStockMaximoPDC().getNombreParaMostrar());
        etiquetaStockMin.setText(rit.getStockMinimoPDC().getNombreParaMostrar());
        etiquetaUnidad.setText(uit.getUnidadPDC().getNombreParaMostrar());
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO NOMBRES DE ETIQUETA
        ========================================================================
        */
        
        /*
        =======================================================================
            INICIO SETEO UTILIDADES
        ///////////////////////////////////////////////////////////////////////
        */
        //INICIAMOS LAS UTILIDADES.
        _ImagenesRefacciones = new UtilidadesJXViewImage_(getCoordinador());
        _ComboUnidad = new UtilidadesComboBox_(getCoordinador());
        _ComboMaterial = new UtilidadesComboBox_(getCoordinador()) ;


        _ListaProveedor = new UtilidadesListas_(getCoordinador());
        _ListaProveedorSeleccionado = new UtilidadesListas_(getCoordinador());

        _ListaMaquinaModelo = new UtilidadesListas_(getCoordinador());
        _ListasMaquinasSeleccionadas = new UtilidadesListas_(getCoordinador());

        _TxtNombreDeLaRefaccion = new UtilidadesTxt_(getCoordinador());
        _TxtCodigo = new UtilidadesTxt_(getCoordinador());
        _TxtCodigoDelProveedor = new UtilidadesTxt_(getCoordinador());
        _TxtStockMin = new UtilidadesTxt_(getCoordinador());
        _TxtStockMax = new UtilidadesTxt_(getCoordinador());

        _TxtDescripcion = new UtilidadesTxtArea_(getCoordinador());
        _TxtQueEs = new UtilidadesTxtArea_(getCoordinador());
        _TxtParaQueEs = new UtilidadesTxtArea_(getCoordinador());
        
        _RadioImportancia = new UtilidadesRadio_(getCoordinador());
        
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _ImagenesRefacciones.setComponente(getImagenView());
        _ImagenesRefacciones.setjLabelContador(getEtiquetaContadorImagenes());
        _ComboUnidad.setComponente(getComboUnidad());
        _ComboMaterial.setComponente(getComboMaterial());

        _ListaProveedor.setComponente(getListaProveedores());
        _ListaProveedorSeleccionado.setComponente(getListaProveedoresSeleccionados());
        _ListaProveedor.setComponenteListaAAgregar(_ListaProveedorSeleccionado);

        _ListaMaquinaModelo.setComponente(getListaMaquinas());
        _ListasMaquinasSeleccionadas.setComponente(getListaMaquinasSeleccionadas());
        _ListaMaquinaModelo.setComponenteListaAAgregar(_ListasMaquinasSeleccionadas);

        _TxtNombreDeLaRefaccion.setComponente(getTxtNombreDeLaRefaccion());
        _TxtCodigo.setComponente(getTxtCodigo());
        _TxtCodigoDelProveedor.setComponente(getTxtCodigoDelProveedor());
        _TxtStockMin.setComponente(getTxtStockMin());
        _TxtStockMax.setComponente(getTxtStockMax());

        _TxtDescripcion.setComponente(getTxtDescripcion());
        _TxtQueEs.setComponente(getTxtQueEs());
        _TxtParaQueEs.setComponente(getTxtParaQueEs());
        
        _RadioImportancia.setComponente(getRadioAlta());
        _RadioImportancia.setComponente(getRadioBaja());
        _RadioImportancia.setComponente(getRadioMedia());
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        _ComboUnidad.setTamanoDeCampo(uit.getUnidadPDC().getLongitudDeCaracteres());
        _ComboMaterial.setTamanoDeCampo(mit.getMaterialPDC().getLongitudDeCaracteres());

        _TxtNombreDeLaRefaccion.setTamanoDeCampo(rit.getNombrePDC().getLongitudDeCaracteres());
        _TxtCodigo.setTamanoDeCampo(rit.getCodigoInternoPDC().getLongitudDeCaracteres());
        _TxtCodigoDelProveedor.setTamanoDeCampo(rit.getCodigoProveedorPDC().getLongitudDeCaracteres());
        
        _TxtStockMin.setTamanoDeCampo(rit.getStockMinimoPDC().getLongitudDeCaracteres(),
                                      rit.getStockMinimoPDC().getLongitudDeDecimales());
        _TxtStockMax.setTamanoDeCampo(rit.getStockMaximoPDC().getLongitudDeCaracteres(),
                                      rit.getStockMaximoPDC().getLongitudDeDecimales());

        _TxtDescripcion.setTamanoDeCampo(rit.getDescripcionPDC().getLongitudDeCaracteres());
        _TxtQueEs.setTamanoDeCampo(rit.getQueEsPDC().getLongitudDeCaracteres());
        _TxtParaQueEs.setTamanoDeCampo(rit.getParaQueEsPDC().getLongitudDeCaracteres());
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        
        _ComboUnidad.setPermitirSoloMayusculas();
        _ComboMaterial.setPermitirSoloMayusculas();

        _TxtNombreDeLaRefaccion.setPermitirSoloMayusculas();
        _TxtCodigo.setPermitirSoloMayusculas();
        _TxtCodigoDelProveedor.setPermitirSoloMayusculas();

        _TxtDescripcion.setPermitirSoloMayusculas();
        _TxtQueEs.setPermitirSoloMayusculas();
        _TxtParaQueEs.setPermitirSoloMayusculas();
        
        //CAMPOS NUMÉRICOS
        _TxtStockMin.setPermitirSoloNumeros();
        _TxtStockMax.setPermitirSoloNumeros();
        
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        _ComboUnidad.setEspaciosEnBlanco();
        _ComboMaterial.setEspaciosEnBlanco();

        _TxtNombreDeLaRefaccion.setEspaciosEnBlanco();
        _TxtCodigo.setEspaciosEnBlanco();
        _TxtCodigoDelProveedor.setEspaciosEnBlanco();
        _TxtStockMin.setEspaciosEnBlanco();
        _TxtStockMax.setEspaciosEnBlanco();

        _TxtDescripcion.setEspaciosEnBlanco();
        _TxtQueEs.setEspaciosEnBlanco();
        _TxtParaQueEs.setEspaciosEnBlanco();
        
        //TRAVEL POLICY
        
        _TxtNombreDeLaRefaccion.setNextFocusableComponent(_TxtCodigo.getThis());
        _TxtCodigo.setNextFocusableComponent(_ComboUnidad.getThis());
        _ComboUnidad.setNextFocusableComponent(_TxtStockMin.getThis());
        _TxtStockMin.setNextFocusableComponent(_TxtStockMax.getThis());
        _TxtStockMax.setNextFocusableComponent(_TxtCodigoDelProveedor.getThis());
        _TxtCodigoDelProveedor.setNextFocusableComponent(_ComboMaterial.getThis());
        _ComboMaterial.setNextFocusableComponent(_TxtDescripcion.getThis());
        _TxtDescripcion.setNextFocusableComponent(_TxtQueEs.getThis());
        _TxtQueEs.setNextFocusableComponent(_TxtParaQueEs.getThis());
        _TxtParaQueEs.setNextFocusableComponent(_RadioImportancia.getThis());
        _RadioImportancia.setNextFocusableComponent(getBtnAgregarImagen());
        getBtnAgregarImagen().setNextFocusableComponent(getBtnEliminarImagen());
        getBtnEliminarImagen().setNextFocusableComponent(getBtnGuardar());
        getBtnGuardar().setNextFocusableComponent(getBtnCancelar());
        getBtnCancelar().setNextFocusableComponent(_TxtNombreDeLaRefaccion.getThis());

        //ACCIONES ESPECELIALES.
        _ComboUnidad.setFocusAction(()->guardarUnidad(), false);
        _ComboMaterial.setFocusAction(()->guardarMaterial(), false);
        
        _ListaProveedor.setValueChange(()->_ListaProveedor.cambioEntreListas(false));
        _ListaProveedorSeleccionado.setValueChange(()->_ListaProveedor.cambioEntreListas(true));

        _ListaMaquinaModelo.setValueChange(()->_ListaMaquinaModelo.cambioEntreListas(false));
        _ListasMaquinasSeleccionadas.setValueChange(()->_ListaMaquinaModelo.cambioEntreListas(true));
        
        
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        //OPERACIONES DE ACTUALIZACION
        
        opAct.add(ProveedorIT.NOMBRE_TABLA, this::cargarListaProveedor);
        opAct.add(MaquinaModeloIT.NOMBRE_TABLA, this::cargarListaMaquinaModelo);
        opAct.add(UnidadIT.NOMBRE_TABLA, this::cargarComboUnidad);
        opAct.add(MaterialIT.NOMBRE_TABLA, this::cargarComboMaterial);
        opAct.add(ImportanciaIT.NOMBRE_TABLA, this::cargarCheck);
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
    }


    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextArea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }
    
    public void cargarCheck(){
        
        List<ImportanciaVo> listImportanciaVo = getCoordinador().importanciaConsultar();
        listImportanciaVo.sort(Comparator.comparing(ImportanciaVo::getImportancia));
        
        int cont = 0;
        for (JRadioButton r : _RadioImportancia.getRadios()) {
            r.setText(listImportanciaVo.get(cont).getImportancia());
            cont++;
        }
    }
    
    public void cargarListaProveedor(){
        List<ProveedorVo> lista = this.getCoordinador().proveedoresConsultarMarcas();
        HashMap<String, Object> datos= new HashMap<>();
        _ListaProveedor.limpiar();
        for (ProveedorVo vo : lista) {
            datos.put(vo.getEmpresa(), vo.getId());
        }
        _ListaProveedor.cargarLista(datos);
    
    }
    public void cargarListaMaquinaModelo(){
        List<MaquinaModeloVo> lista = this.getCoordinador().maquinaModeloConsultar();
        HashMap<String, Object> datos = new HashMap<>();
        _ListaMaquinaModelo.limpiar();
        for (MaquinaModeloVo vo : lista) {
            String modeloAnio = vo.getModelo() + " " +vo.getAnio();
            datos.put(modeloAnio, vo.getId());
        }
        
        
        _ListaMaquinaModelo.cargarLista(datos);
    }
    public void cargarComboUnidad(){
        List<UnidadVo> l = this.getCoordinador().unidadConsultar();
        HashMap<String, Object> map = new HashMap<>();
        
        for (UnidadVo vo : l) {
            map.put(vo.getUnidad(), vo.getId());
        }
        _ComboUnidad.cargarCombo(map);
    }
    public void cargarComboMaterial(){
        List<MaterialVo> l = this.getCoordinador().materialConsultar();
        HashMap<String, Object> map = new HashMap<>();
        for (MaterialVo vo : l) {
            map.put(vo.getMaterial(), vo.getId());
            System.out.println("este es el id que nos dice que no esta: "+vo.getId());
        }
        _ComboMaterial.cargarCombo(map);
    }
    
    public void guardarUnidad(){
        String unidad = _ComboUnidad.getText();
        if (!unidad.isEmpty()) {
            if (this.getCoordinador().unidadExiste(unidad)) {
                _ComboUnidad.setSelectedItem(unidad);

            }else{
                int op = JOptionPane.showConfirmDialog(
                        this, 
                        "¿Estas segúro que quieres agregar '"+unidad+"' "
                           + "como nueva unidad?", "¿Agregar nueva unidad?",
                        JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION) {
                    UnidadVo vo = new UnidadVo();
                    vo.setUnidad(unidad);
                    this.getCoordinador().unidadGuardar(vo);
                    this.cargarComboUnidad();
                    _ComboUnidad.setSelectedItem(unidad);
                }
            }
        }
    }
    
    
    
    public void guardarMaterial(){
        String material = _ComboMaterial.getText();
        if (!material.isEmpty()) {
            if (this.getCoordinador().materialExiste(material)) {
                _ComboMaterial.setSelectedItem(material);

            }else{
                int op = JOptionPane.showConfirmDialog(
                        this, 
                        "¿Estas segúro que quieres agregar '"+material+"' "
                           + "como nuevo material?", "¿Agregar nueva material?",
                        JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION) {
                    MaterialVo vo = new MaterialVo();
                    vo.setMaterial(material);
                    this.getCoordinador().materialGuardar(vo);
                    this.cargarComboMaterial();
                    _ComboMaterial.setSelectedItem(material);
                }
            }
        }
        
    }

    public JButton getBtnAgregarImagen() {
        return btnAgregarImagen;
    }

    public void setBtnAgregarImagen(JButton btnAgregarImagen) {
        this.btnAgregarImagen = btnAgregarImagen;
    }


    public JButton getBtnAgregarNuevProveedor() {
        return btnAgregarNuevProveedor;
    }

    public void setBtnAgregarNuevProveedor(JButton btnAgregarNuevProveedor) {
        this.btnAgregarNuevProveedor = btnAgregarNuevProveedor;
    }

    public JButton getBtnAgregarNuevaMaquina() {
        return btnAgregarNuevaMaquina;
    }

    public void setBtnAgregarNuevaMaquina(JButton btnAgregarNuevaMaquina) {
        this.btnAgregarNuevaMaquina = btnAgregarNuevaMaquina;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnEliminarImagen() {
        return btnEliminarImagen;
    }

    public void setBtnEliminarImagen(JButton btnEliminarImagen) {
        this.btnEliminarImagen = btnEliminarImagen;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnRegresarImagen() {
        return btnRegresarImagen;
    }

    public void setBtnRegresarImagen(JButton btnRegresarImagen) {
        this.btnRegresarImagen = btnRegresarImagen;
    }

    public JButton getBtnSiguienteImagen() {
        return btnSiguienteImagen;
    }

    public void setBtnSiguienteImagen(JButton btnSiguienteImagen) {
        this.btnSiguienteImagen = btnSiguienteImagen;
    }

    public JComboBox<String> getComboMaterial() {
        return comboMaterial;
    }

    public void setComboMaterial(JComboBox<String> comboMaterial) {
        this.comboMaterial = comboMaterial;
    }

    public JComboBox<String> getComboUnidad() {
        return comboUnidad;
    }

    public void setComboUnidad(JComboBox<String> comboUnidad) {
        this.comboUnidad = comboUnidad;
    }

    public JLabel getEtiquetaAsignados() {
        return etiquetaAsignados;
    }

    public void setEtiquetaAsignados(JLabel etiquetaAsignados) {
        this.etiquetaAsignados = etiquetaAsignados;
    }

    public JLabel getEtiquetaCodigoDelProveedor() {
        return etiquetaCodigoDelProveedor;
    }

    public void setEtiquetaCodigoDelProveedor(JLabel etiquetaCodigoDelProveedor) {
        this.etiquetaCodigoDelProveedor = etiquetaCodigoDelProveedor;
    }

    public JLabel getEtiquetaCodigoInterno() {
        return etiquetaCodigoInterno;
    }

    public void setEtiquetaCodigoInterno(JLabel etiquetaCodigoInterno) {
        this.etiquetaCodigoInterno = etiquetaCodigoInterno;
    }

    public JLabel getEtiquetaCompatibles() {
        return etiquetaCompatibles;
    }

    public void setEtiquetaCompatibles(JLabel etiquetaCompatibles) {
        this.etiquetaCompatibles = etiquetaCompatibles;
    }

    public JLabel getEtiquetaContadorImagenes() {
        return etiquetaContadorImagenes;
    }

    public void setEtiquetaContadorImagenes(JLabel etiquetaContadorImagenes) {
        this.etiquetaContadorImagenes = etiquetaContadorImagenes;
    }

    public JLabel getEtiquetaDeQueEstaEcho() {
        return etiquetaDeQueEstaEcho;
    }

    public void setEtiquetaDeQueEstaEcho(JLabel etiquetaDeQueEstaEcho) {
        this.etiquetaDeQueEstaEcho = etiquetaDeQueEstaEcho;
    }

    public JLabel getEtiquetaDescripcion() {
        return etiquetaDescripcion;
    }

    public void setEtiquetaDescripcion(JLabel etiquetaDescripcion) {
        this.etiquetaDescripcion = etiquetaDescripcion;
    }

    public JXImageView getImagenView() {
        return imagenView;
    }

    public void setImagenView(JXImageView imagenView) {
        this.imagenView = imagenView;
    }

    public JList<String> getListaMaquinas() {
        return listaMaquinas;
    }

    public void setListaMaquinas(JList<String> listaMaquinas) {
        this.listaMaquinas = listaMaquinas;
    }

    public JList<String> getListaMaquinasSeleccionadas() {
        return listaMaquinasSeleccionadas;
    }

    public void setListaMaquinasSeleccionadas(JList<String> listaMaquinasSeleccionadas) {
        this.listaMaquinasSeleccionadas = listaMaquinasSeleccionadas;
    }

    public JList<String> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(JList<String> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public JList<String> getListaProveedoresSeleccionados() {
        return listaProveedoresSeleccionados;
    }

    public void setListaProveedoresSeleccionados(JList<String> listaProveedoresSeleccionados) {
        this.listaProveedoresSeleccionados = listaProveedoresSeleccionados;
    }

    public JRadioButton getRadioAlta() {
        return radioAkta;
    }

    public void setRadioAkta(JRadioButton radioAkta) {
        this.radioAkta = radioAkta;
    }

    public JRadioButton getRadioBaja() {
        return radioBaja;
    }

    public void setRadioBaja(JRadioButton radioBaja) {
        this.radioBaja = radioBaja;
    }

    public ButtonGroup getRadioBotones() {
        return radioBotones;
    }

    public void setRadioBotones(ButtonGroup radioBotones) {
        this.radioBotones = radioBotones;
    }

    public JRadioButton getRadioMedia() {
        return radioMedia;
    }

    public void setRadioMedia(JRadioButton radioMedia) {
        this.radioMedia = radioMedia;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtCodigoDelProveedor() {
        return txtCodigoDelProveedor;
    }

    public void setTxtCodigoDelProveedor(JTextField txtCodigoDelProveedor) {
        this.txtCodigoDelProveedor = txtCodigoDelProveedor;
    }

    public JTextField getTxtNombreDeLaRefaccion() {
        return txtNombreDeLaRefaccion;
    }

    public void setTxtNombreDeLaRefaccion(JTextField txtNombreDeLaRefaccion) {
        this.txtNombreDeLaRefaccion = txtNombreDeLaRefaccion;
    }

    public JTextArea getTxtParaQueEs() {
        return txtParaQueEs;
    }

    public void setTxtParaQueEs(JTextArea txtParaQueEs) {
        this.txtParaQueEs = txtParaQueEs;
    }

    public JTextArea getTxtQueEs() {
        return txtQueEs;
    }

    public void setTxtQueEs(JTextArea txtQueEs) {
        this.txtQueEs = txtQueEs;
    }

    public JTextField getTxtStockMax() {
        return txtStockMax;
    }

    public void setTxtStockMax(JTextField txtStockMax) {
        this.txtStockMax = txtStockMax;
    }

    public JTextField getTxtStockMin() {
        return txtStockMin;
    }

    public void setTxtStockMin(JTextField txtStockMin) {
        this.txtStockMin = txtStockMin;
    }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioBotones = new javax.swing.ButtonGroup();
        etiquetaNombreDeLaRefaccion = new javax.swing.JLabel();
        txtNombreDeLaRefaccion = new javax.swing.JTextField();
        etiquetaStockMin = new javax.swing.JLabel();
        txtStockMax = new javax.swing.JTextField();
        etiquetaStockMax = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        etiquetaDescripcion = new javax.swing.JLabel();
        etiquetaUnidad = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        etiquetaCodigoInterno = new javax.swing.JLabel();
        etiquetaDeQueEstaEcho = new javax.swing.JLabel();
        comboMaterial = new javax.swing.JComboBox<>();
        etiquetaImportancia = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaMaquinas = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaMaquinasSeleccionadas = new javax.swing.JList<>();
        etiquetaMaquinas = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarNuevaMaquina = new javax.swing.JButton();
        imagenView = new org.jdesktop.swingx.JXImageView();
        etiquetaContadorImagenes = new javax.swing.JLabel();
        btnSiguienteImagen = new javax.swing.JButton();
        btnRegresarImagen = new javax.swing.JButton();
        btnAgregarImagen = new javax.swing.JButton();
        btnEliminarImagen = new javax.swing.JButton();
        txtStockMin = new javax.swing.JTextField();
        comboUnidad = new javax.swing.JComboBox<>();
        etiquetaCompatibles = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaProveedores = new javax.swing.JList<>();
        etiquetaProveedores = new javax.swing.JLabel();
        btnAgregarNuevProveedor = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaProveedoresSeleccionados = new javax.swing.JList<>();
        etiquetaAsignados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQueEs = new javax.swing.JTextArea();
        etiquetaQueEs = new javax.swing.JLabel();
        etiquetaParaQueEs = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtParaQueEs = new javax.swing.JTextArea();
        etiquetaCodigoDelProveedor = new javax.swing.JLabel();
        txtCodigoDelProveedor = new javax.swing.JTextField();
        radioAkta = new javax.swing.JRadioButton();
        radioMedia = new javax.swing.JRadioButton();
        radioBaja = new javax.swing.JRadioButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(2, 0), new java.awt.Dimension(2, 0), new java.awt.Dimension(2, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 2), new java.awt.Dimension(0, 2), new java.awt.Dimension(32767, 2));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 8), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 8));
        checkEsDeConsumoUnico = new javax.swing.JCheckBox();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        etiquetaNombreDeLaRefaccion1 = new javax.swing.JLabel();

        etiquetaNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion.setText("Nombre de la refaccion.");

        txtNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNombreDeLaRefaccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreDeLaRefaccion.setPreferredSize(new java.awt.Dimension(40, 337));

        etiquetaStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMin.setText("Stock Min");

        txtStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMax.setNextFocusableComponent(comboUnidad);

        etiquetaStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMax.setText("Stock Max");

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(1);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setFocusCycleRoot(true);
        txtDescripcion.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(txtDescripcion);

        etiquetaDescripcion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaDescripcion.setText("Descripcion");

        etiquetaUnidad.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaUnidad.setText("Unidad");

        txtCodigo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setAutoscrolls(false);
        txtCodigo.setMaximumSize(new java.awt.Dimension(140, 30));
        txtCodigo.setMinimumSize(new java.awt.Dimension(140, 30));

        etiquetaCodigoInterno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoInterno.setText("Código interno");

        etiquetaDeQueEstaEcho.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaDeQueEstaEcho.setText("¿De que esta echo?");

        comboMaterial.setEditable(true);
        comboMaterial.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        etiquetaImportancia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaImportancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaImportancia.setText("Importancia");
        etiquetaImportancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listaMaquinas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaMaquinas.setFocusable(false);
        listaMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMaquinasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaMaquinas);

        listaMaquinasSeleccionadas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaMaquinasSeleccionadas.setFocusable(false);
        jScrollPane4.setViewportView(listaMaquinasSeleccionadas);

        etiquetaMaquinas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaMaquinas.setText("Nuevo modelo de máquina.");

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_palomita.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarNuevaMaquina.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAgregarNuevaMaquina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_mas.png"))); // NOI18N
        btnAgregarNuevaMaquina.setText("Nueva máquina");
        btnAgregarNuevaMaquina.setFocusable(false);
        btnAgregarNuevaMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevaMaquinaActionPerformed(evt);
            }
        });

        imagenView.setOpaque(false);

        etiquetaContadorImagenes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        etiquetaContadorImagenes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaContadorImagenes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        etiquetaContadorImagenes.setOpaque(true);

        btnSiguienteImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_siguiente.png"))); // NOI18N
        btnSiguienteImagen.setFocusable(false);
        btnSiguienteImagen.setOpaque(false);
        btnSiguienteImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteImagenActionPerformed(evt);
            }
        });

        btnRegresarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_anterios.png"))); // NOI18N
        btnRegresarImagen.setFocusable(false);
        btnRegresarImagen.setOpaque(false);
        btnRegresarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarImagenActionPerformed(evt);
            }
        });

        btnAgregarImagen.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAgregarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_mas.png"))); // NOI18N
        btnAgregarImagen.setText("Agregar");
        btnAgregarImagen.setOpaque(false);
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });

        btnEliminarImagen.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnEliminarImagen.setText("Eliminar");
        btnEliminarImagen.setOpaque(false);
        btnEliminarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenViewLayout = new javax.swing.GroupLayout(imagenView);
        imagenView.setLayout(imagenViewLayout);
        imagenViewLayout.setHorizontalGroup(
            imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaContadorImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, imagenViewLayout.createSequentialGroup()
                        .addComponent(btnRegresarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguienteImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarImagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarImagen)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        imagenViewLayout.setVerticalGroup(
            imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiguienteImagen)
                    .addComponent(btnRegresarImagen)
                    .addGroup(imagenViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarImagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaContadorImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        txtStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMin.setNextFocusableComponent(comboUnidad);

        comboUnidad.setEditable(true);
        comboUnidad.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboUnidad.setNextFocusableComponent(txtDescripcion);
        comboUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUnidadActionPerformed(evt);
            }
        });

        etiquetaCompatibles.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaCompatibles.setText("Compatibles.");

        listaProveedores.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaProveedores.setFocusable(false);
        listaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listaProveedores);

        etiquetaProveedores.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaProveedores.setText("Proveedores.");

        btnAgregarNuevProveedor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAgregarNuevProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_mas.png"))); // NOI18N
        btnAgregarNuevProveedor.setText("Nuevo proveedor");
        btnAgregarNuevProveedor.setFocusable(false);
        btnAgregarNuevProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevProveedorActionPerformed(evt);
            }
        });

        listaProveedoresSeleccionados.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaProveedoresSeleccionados.setFocusable(false);
        jScrollPane6.setViewportView(listaProveedoresSeleccionados);

        etiquetaAsignados.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaAsignados.setText("Asignados.");

        txtQueEs.setColumns(20);
        txtQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtQueEs.setLineWrap(true);
        txtQueEs.setRows(1);
        txtQueEs.setWrapStyleWord(true);
        txtQueEs.setFocusCycleRoot(true);
        txtQueEs.setFocusTraversalPolicyProvider(true);
        jScrollPane2.setViewportView(txtQueEs);

        etiquetaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaQueEs.setText("¿Que es?");

        etiquetaParaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaParaQueEs.setText("¿Para que es?");

        txtParaQueEs.setColumns(20);
        txtParaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtParaQueEs.setLineWrap(true);
        txtParaQueEs.setRows(1);
        txtParaQueEs.setWrapStyleWord(true);
        txtParaQueEs.setFocusCycleRoot(true);
        txtParaQueEs.setFocusTraversalPolicyProvider(true);
        jScrollPane7.setViewportView(txtParaQueEs);

        etiquetaCodigoDelProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoDelProveedor.setText("Código del proveedor");

        txtCodigoDelProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCodigoDelProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoDelProveedor.setAutoscrolls(false);
        txtCodigoDelProveedor.setMaximumSize(new java.awt.Dimension(184, 30));
        txtCodigoDelProveedor.setMinimumSize(new java.awt.Dimension(184, 30));
        txtCodigoDelProveedor.setPreferredSize(new java.awt.Dimension(184, 31));

        radioBotones.add(radioAkta);
        radioAkta.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        radioAkta.setText("Alta");
        radioAkta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        radioBotones.add(radioMedia);
        radioMedia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        radioMedia.setText("Media");
        radioMedia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        radioBotones.add(radioBaja);
        radioBaja.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        radioBaja.setText("Baja");
        radioBaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        radioBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBajaActionPerformed(evt);
            }
        });

        checkEsDeConsumoUnico.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        checkEsDeConsumoUnico.setText("Es de consumo único.");

        etiquetaNombreDeLaRefaccion1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_agregar refaccion.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(btnAgregarNuevaMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etiquetaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etiquetaMaquinas))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(etiquetaAsignados, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(100, 100, 100)
                                                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(etiquetaNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(etiquetaImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAgregarNuevProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(radioAkta)
                                .addGap(9, 9, 9)
                                .addComponent(radioMedia)
                                .addGap(2, 2, 2)
                                .addComponent(radioBaja))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaCompatibles, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCodigoInterno)
                                .addGap(94, 94, 94)
                                .addComponent(etiquetaUnidad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaStockMin)
                                .addGap(130, 130, 130)
                                .addComponent(etiquetaStockMax))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCodigoDelProveedor)
                                .addGap(45, 45, 45)
                                .addComponent(etiquetaDeQueEstaEcho))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoDelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiquetaDescripcion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaQueEs)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaParaQueEs)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkEsDeConsumoUnico, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnCancelar)
                                .addGap(6, 6, 6)
                                .addComponent(btnGuardar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane3, jScrollPane4, jScrollPane5, jScrollPane6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaCodigoInterno)
                            .addComponent(etiquetaUnidad))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaStockMin)
                            .addComponent(etiquetaStockMax))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(etiquetaCodigoDelProveedor))
                            .addComponent(etiquetaDeQueEstaEcho))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtCodigoDelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(etiquetaDescripcion)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaQueEs)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaParaQueEs)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(checkEsDeConsumoUnico))
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(487, 487, 487)
                        .addComponent(etiquetaImportancia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombreDeLaRefaccion)
                                .addGap(5, 5, 5)
                                .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaProveedores)
                            .addComponent(etiquetaAsignados))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaMaquinas)
                            .addComponent(etiquetaCompatibles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(btnAgregarNuevaMaquina)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarNuevProveedor)
                            .addComponent(radioAkta)
                            .addComponent(radioMedia)
                            .addComponent(radioBaja)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listaMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMaquinasMouseClicked
    }//GEN-LAST:event_listaMaquinasMouseClicked

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed

        _ImagenesRefacciones.setFiltros(new FileNameExtensionFilter("Imagenes", "jpg", "gif", "png", "tiff", "jpeg"));
        _ImagenesRefacciones.cargarImagenes();

    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void btnSiguienteImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteImagenActionPerformed
        _ImagenesRefacciones.siguienteAnterior(true);
    }//GEN-LAST:event_btnSiguienteImagenActionPerformed

    private void btnRegresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarImagenActionPerformed
        _ImagenesRefacciones.siguienteAnterior(false);
    }//GEN-LAST:event_btnRegresarImagenActionPerformed

    private void btnEliminarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarImagenActionPerformed
        _ImagenesRefacciones.eliminarImagenSeleccionada();
    }//GEN-LAST:event_btnEliminarImagenActionPerformed

    private void comboUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUnidadActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarTodo();
        _ImagenesRefacciones.setErrorQuitar();
        _ComboUnidad.setErrorQuitar();
        _ComboMaterial.setErrorQuitar();


        _ListaProveedor.setErrorQuitar();
        _ListaProveedorSeleccionado.setErrorQuitar();

        _ListaMaquinaModelo.setErrorQuitar();
        _ListasMaquinasSeleccionadas.setErrorQuitar();

        _TxtNombreDeLaRefaccion.setErrorQuitar();
        _TxtCodigo.setErrorQuitar();
        _TxtCodigoDelProveedor.setErrorQuitar();
        _TxtStockMin.setErrorQuitar();
        _TxtStockMax.setErrorQuitar();

        _TxtDescripcion.setErrorQuitar();
        _TxtQueEs.setErrorQuitar();
        _TxtParaQueEs.setErrorQuitar();
        
        _RadioImportancia.setErrorQuitar();
        
        this.getCoordinador().refaccionAbrirPanelConsultaRefacciones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarNuevaMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevaMaquinaActionPerformed
        this.getCoordinador().maquinaModeloAbrirDialogoAgregar();
    }//GEN-LAST:event_btnAgregarNuevaMaquinaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        RefaccionVo rVo = new RefaccionVo();
        
        //LAS LISTAS QUE CONTENDRAN LOS DATOS PARA LAS MULTIPLES RELACIONES QUE TENEMOS.
        List<ImagenRefaccionVo> listaiVo = new ArrayList<>();
        List<RelacionRefaccionMaquinaModeloVo> listarrmmVo = new ArrayList<>();
        List<RelacionRefaccionProveedorVo> listarrpVo = new ArrayList<>();
              
        
        //VO DE REFACCION.
        rVo.setCodigoProveedor(_TxtCodigoDelProveedor.getText());
        rVo.setCodigoInterno(_TxtCodigo.getText());
        rVo.setDescripcion(_TxtDescripcion.getText());
        rVo.setIdMaterial(_ComboMaterial.getSelectedItem_idRetorno());

        switch(_RadioImportancia.getText()){
             case "ALTA":
                 rVo.setImportancia(1);
                 break;
             case "MEDIA":
                 rVo.setImportancia(2);
                 break;
            case "BAJA":
                 rVo.setImportancia(3);
                 break;
            default:
                rVo.setImportancia(-1);
        }
        rVo.setNombre(_TxtNombreDeLaRefaccion.getText());
        rVo.setParaQueEs(_TxtParaQueEs.getText());
        rVo.setQueEs(_TxtQueEs.getText());
        
        float stockMax, stockMin;
        if (_TxtStockMax.isEmpty()) {
            stockMax = -1;
        }else{
            stockMax = Float.parseFloat(_TxtStockMax.getText());
        }
        
        if (_TxtStockMin.isEmpty()) {
            stockMin = -1;
        }else{
            stockMin = Float.parseFloat(_TxtStockMin.getText());
        }
        rVo.setStockMaximo(stockMax);
        rVo.setStockMinimo(stockMin);
        rVo.setUnidad(_ComboUnidad.getSelectedItem_idRetorno());
        
        if(checkEsDeConsumoUnico.isSelected()) {
            rVo.setRefaccionDeConsumoUnico((byte) 1);
        } else {
            rVo.setRefaccionDeConsumoUnico((byte) 0);
        }
        
        
        //CARGAMOS LAS MAQUINAS-MODELO QUE VAN A RELACIONARSE CON ESTA REFACCION
        List<Object> mmSeleccinadas = _ListasMaquinasSeleccionadas.getItems_soloId();
        for (Object s : mmSeleccinadas) {
            RelacionRefaccionMaquinaModeloVo rrmmVo = new RelacionRefaccionMaquinaModeloVo();
            rrmmVo.setIdMaquinaModelo((int)s);
            listarrmmVo.add(rrmmVo);
        }
        
        //CARGAMOS LAS IMAGENES QUE VAN RELACIONARSE CON ESTA REFACCIÓN.
        List<File>file = _ImagenesRefacciones.getImagenesPorCargar();
        for (File f : file) {
            ImagenRefaccionVo vo = new ImagenRefaccionVo();
            vo.setFicheroImagen(f);
            vo.setNombreParaMostrar(f.getName());
            listaiVo.add(vo);
        }
        
        //CARGAMOS LOS PROVEEDORES QUE VAN A RELACIONARSE CON ESTA REFACCIÓN.
        List<Object> pSeleccionado = _ListaProveedorSeleccionado.getItems_soloId();
        for (Object i : pSeleccionado) {
            RelacionRefaccionProveedorVo v = new RelacionRefaccionProveedorVo();
            v.setIdProveedor((int)i);
            listarrpVo.add(v);
        }
        
        
        //VALIDACIONES
        //REFACCION
        List<Validacion> valRefaccion = 
                this.getCoordinador().refaccionValidarCampos(rVo);
        //RELACION MAQUINAMODELO
        List<Validacion> valRelacionRMM = 
                this.getCoordinador().refaccionValidarCamposMaquinaModelo(listarrmmVo);
        //RELACION PROVEEDOR
        List<Validacion> valRelacionRP = 
                this.getCoordinador().refaccionValidarCamposProveedor(listarrpVo);
                
        //SI ESTA VARIABLE QUEDA EN TRUE QUIERE DECIR QUE TODAS LAS VALIDACIONES
        //PASARON.
        boolean todoValido = true;
        
        //VALIDAMOS REFACCION
        RefaccionIT t = new RefaccionIT();
        for (Validacion v : valRefaccion) {
            System.out.println(v.toString());
            
            //NOMBRE DE LA REFACCION.
            if (v.getNombreDeCampo().equals(t.getNombrePDC().getNombre())) {
                if (!v.isValido()) {
                    _TxtNombreDeLaRefaccion.setError(v.getMensajeDeError());
                } else {
                    _TxtNombreDeLaRefaccion.setErrorQuitar();
                }
            }
            
            //CODIGO INTERNO DE LA REFACCION
            if (v.getNombreDeCampo().equals(t.getCodigoInternoPDC().getNombre())) {
                if (!v.isValido()) {
                    _TxtCodigo.setError(v.getMensajeDeError());
                } else {
                    _TxtCodigo.setErrorQuitar();
                }
            }
            
            //UNIDAD
            if (v.getNombreDeCampo().equals(t.getUnidadPDC().getNombre())) {
                if (!v.isValido()) {
                    _ComboUnidad.setError(v.getMensajeDeError());
                } else {
                    _ComboUnidad.setErrorQuitar();
                }
            }
            
            //STOCK MINIMO
            if (v.getNombreDeCampo().equals(t.getStockMinimoPDC().getNombre())) {
                if (!v.isValido()) {
                    _TxtStockMin.setError(v.getMensajeDeError());
                } else {
                    _TxtStockMin.setErrorQuitar();
                }
            }
            
            //STOCK MAXIMO
            if (v.getNombreDeCampo().equals(t.getStockMaximoPDC().getNombre())) {
                if (!v.isValido()) {
                    _TxtStockMax.setError(v.getMensajeDeError());
                } else {
                    _TxtStockMax.setErrorQuitar();
                }
            }
           
            //CODIGO EXTERNO DE LA REFACCIÓN.
            if (v.getNombreDeCampo().equals(t.getCodigoProveedorPDC().getNombre())) {
                if (!v.isValido()) {
                    _TxtCodigoDelProveedor.setError(v.getMensajeDeError());
                } else {
                    _TxtCodigoDelProveedor.setErrorQuitar();
                }
            }
            
            //MATERIAL - DE QUE ESTA ECHO.
            if (v.getNombreDeCampo().equals(t.getIdMaterialPDC().getNombre())) {
                if (!v.isValido()) {
                    _ComboMaterial.setError(v.getMensajeDeError());
                } else {
                    _ComboMaterial.setErrorQuitar();
                }
            }
            
            //DESCRIPCION
            if (v.getNombreDeCampo().equals(t.getDescripcionPDC().getNombre())) {
                if (!v.isValido()) {
                    _TxtDescripcion.setError(v.getMensajeDeError());
                } else {
                    _TxtDescripcion.setErrorQuitar();
                }
            }
            
            //IMPORTANCIA
            if (v.getNombreDeCampo().equals(t.getImportanciaPDC().getNombre())) {
                if (!v.isValido()) {
                    _RadioImportancia.setError(v.getMensajeDeError());
                } else {
                    _RadioImportancia.setErrorQuitar();
                }
            }
            
            if (!v.isValido()) {
                todoValido = false;
            }
        }
        
        //VALIDAMOS PROVEEDOR.
        for (Validacion v : valRelacionRP) {
            if (!v.isValido()) {
                _ListaProveedorSeleccionado.setError(v.getMensajeDeError());
                todoValido = false;
            }else{
                _ListaProveedorSeleccionado.setErrorQuitar();
            
            }
        }
        //VALIDAMOS MAQUINAMODELO
        for (Validacion v : valRelacionRMM) {
            if (!v.isValido()) {
                _ListasMaquinasSeleccionadas.setError(v.getMensajeDeError());
                todoValido = false;
            }else{
                _ListasMaquinasSeleccionadas.setErrorQuitar();
            }
        }
        
        if (todoValido) {
            //GUARDAMOS LA REFACCIÓN.
            this.getCoordinador().refaccionGuardar(rVo);
            //OBTENEMOS EL ID GENERADO.
            int idRefaccion = this.getCoordinador().refaccionConsultarUltimoId();
            if (idRefaccion==-1) {
                JOptionPane.showMessageDialog(this, "Hubo un error y se pudieron guardar algúnos datos.\n\n"
                        + "Puedes revisar si los datos de la refacción se almacenarón\n"
                        + "y asociar de nuevo la información modificandola directamente."
                        + "", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                //ASOCIAMOS LOS DATOS QUE SE VAN A RELACIONAR CON LA REFACCIÓN RECIEN
                //ALMACENADA. 
                for (ImagenRefaccionVo iVo : listaiVo) {
                    iVo.setIdRefaccion(idRefaccion);
                }
                for (RelacionRefaccionMaquinaModeloVo rr : listarrmmVo) {
                    rr.setIdRefaccion(idRefaccion);
                }

                for (RelacionRefaccionProveedorVo aa : listarrpVo) {
                    aa.setIdRefaccion(idRefaccion);
                }

                if (this.getCoordinador().relacionRefaccionMaquinaModeloGuardarLista(listarrmmVo) 
                        && this.getCoordinador().relacionRefaccionProveedorGuardarLista(listarrpVo)) {
                    String errorImg = this.getCoordinador().imagenRefaccionGuardarLista(listaiVo);
                    if (errorImg!=null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "No se cargaron las siguientes imagenes: \n\n" + errorImg,
                                "Error cargando imagenes", JOptionPane.ERROR_MESSAGE);
                    }

                    limpiarTodo();
                    JOptionPane.showMessageDialog(
                            getCoordinador().getMarcoParaVentanaPrincipal(),
                            "Se guardo la refaccción correctamente.");
                    getCoordinador().actualizarTodoLoVisible();
                }else{
                    JOptionPane.showMessageDialog(this, "Algo paso y no se "
                            + "pudo guardar la refacción.");
                }
            }
        }
    }
    
    public void limpiarTodo(){
        _ImagenesRefacciones.limpiar();
        _TxtNombreDeLaRefaccion.setText("");
        _TxtCodigo.setText("");
        _TxtCodigoDelProveedor.setText("");
        _TxtStockMin.setText("");
        _TxtStockMax.setText("");

        _TxtDescripcion.setText("");
        _TxtQueEs.setText("");
        _TxtParaQueEs.setText("");
        
        _RadioImportancia.clearSelection();
        
        opAct.actualizarPanel();
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void listaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProveedoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaProveedoresMouseClicked

    private void btnAgregarNuevProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevProveedorActionPerformed
        //this.controladorGestionDeRefacciones.iniciarGuardarProveedorNuevo();
        this.getCoordinador().proveedorAbrirDialogoGuardarNuevo();
    }//GEN-LAST:event_btnAgregarNuevProveedorActionPerformed

    private void radioBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBajaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnAgregarNuevProveedor;
    private javax.swing.JButton btnAgregarNuevaMaquina;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarImagen;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresarImagen;
    private javax.swing.JButton btnSiguienteImagen;
    private javax.swing.JCheckBox checkEsDeConsumoUnico;
    private javax.swing.JComboBox<String> comboMaterial;
    private javax.swing.JComboBox<String> comboUnidad;
    private javax.swing.JLabel etiquetaAsignados;
    private javax.swing.JLabel etiquetaCodigoDelProveedor;
    private javax.swing.JLabel etiquetaCodigoInterno;
    private javax.swing.JLabel etiquetaCompatibles;
    private javax.swing.JLabel etiquetaContadorImagenes;
    private javax.swing.JLabel etiquetaDeQueEstaEcho;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaImportancia;
    private javax.swing.JLabel etiquetaMaquinas;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion1;
    private javax.swing.JLabel etiquetaParaQueEs;
    private javax.swing.JLabel etiquetaProveedores;
    private javax.swing.JLabel etiquetaQueEs;
    private javax.swing.JLabel etiquetaStockMax;
    private javax.swing.JLabel etiquetaStockMin;
    private javax.swing.JLabel etiquetaUnidad;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private org.jdesktop.swingx.JXImageView imagenView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> listaMaquinas;
    private javax.swing.JList<String> listaMaquinasSeleccionadas;
    private javax.swing.JList<String> listaProveedores;
    private javax.swing.JList<String> listaProveedoresSeleccionados;
    private javax.swing.JRadioButton radioAkta;
    private javax.swing.JRadioButton radioBaja;
    private javax.swing.ButtonGroup radioBotones;
    private javax.swing.JRadioButton radioMedia;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoDelProveedor;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombreDeLaRefaccion;
    private javax.swing.JTextArea txtParaQueEs;
    private javax.swing.JTextArea txtQueEs;
    private javax.swing.JTextField txtStockMax;
    private javax.swing.JTextField txtStockMin;
    // End of variables declaration//GEN-END:variables

    @Override
    public void configurar() {
        System.out.println("CONFIGURAR: "+getClass().getSimpleName() + " no tiene nada que configurar.");
    }

}
