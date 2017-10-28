/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panels;

import controlador.CoordinadorPaneles;
import controlador.HiloConPrecarga;
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
import modelo.InfoTabla.*;
import modelo.logica.Validacion;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.ImportanciaVo;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaterialVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
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
            INICIO SETEO NOMBRES DE ETIQUETA<
        ///////////////////////////////////////////////////////////////////////
        */
        etiquetaCodigoDelProveedor.setText(RefaccionIT.getCODIGO_PROVEEDOR().getNombreParaMostrar());
        etiquetaCodigoInterno.setText(RefaccionIT.getCODIGO_INTERNO().getNombreParaMostrar());
        etiquetaDeQueEstaEcho.setText(MaterialIT.getMATERIAL().getNombreParaMostrar());
        etiquetaDescripcion.setText(RefaccionIT.getDESCRIPCION().getNombreParaMostrar());
        etiquetaImportancia.setText(ImportanciaIT.getIMPORTANCIA().getNombreParaMostrar());
        etiquetaMaquinas.setText(MaquinaModeloIT.getMODELO().getNombreParaMostrar());
        etiquetaNombreDeLaRefaccion.setText(RefaccionIT.getNOMBRE().getNombreParaMostrar());
        etiquetaParaQueEs.setText(RefaccionIT.getPARA_QUE_ES().getNombreParaMostrar());
        etiquetaQueEs.setText(RefaccionIT.getQUE_ES().getNombreParaMostrar());
        etiquetaStockMax.setText(RefaccionIT.getSTOCK_MAXIMO().getNombreParaMostrar());
        etiquetaStockMin.setText(RefaccionIT.getSTOCK_MINIMO().getNombreParaMostrar());
        etiquetaUnidad.setText(UnidadIT.getUNIDAD().getNombreParaMostrar());
        
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
        
        _ImagenesRefacciones.setComponente(imagenView);
        _ImagenesRefacciones.setjLabelContador(getEtiquetaContadorImagenes());
        
        _ComboUnidad.setComponente(getComboUnidad());
        _ComboMaterial.setComponente(getComboMaterial());

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
        _ComboUnidad.setTamanoDeCampo(UnidadIT.getUNIDAD().getLongitudDeCaracteres());
        _ComboMaterial.setTamanoDeCampo(MaterialIT.getMATERIAL().getLongitudDeCaracteres());

        _TxtNombreDeLaRefaccion.setTamanoDeCampo(RefaccionIT.getNOMBRE().getLongitudDeCaracteres());
        _TxtCodigo.setTamanoDeCampo(RefaccionIT.getCODIGO_INTERNO().getLongitudDeCaracteres());
        _TxtCodigoDelProveedor.setTamanoDeCampo(RefaccionIT.getCODIGO_PROVEEDOR().getLongitudDeCaracteres());
        
        _TxtStockMin.setTamanoDeCampo(RefaccionIT.getSTOCK_MINIMO().getLongitudDeCaracteres(),
                                      RefaccionIT.getSTOCK_MINIMO().getLongitudDeDecimales());
        _TxtStockMax.setTamanoDeCampo(RefaccionIT.getSTOCK_MAXIMO().getLongitudDeCaracteres(),
                                      RefaccionIT.getSTOCK_MAXIMO().getLongitudDeDecimales());

        _TxtDescripcion.setTamanoDeCampo(RefaccionIT.getDESCRIPCION().getLongitudDeCaracteres());
        _TxtQueEs.setTamanoDeCampo(RefaccionIT.getQUE_ES().getLongitudDeCaracteres());
        _TxtParaQueEs.setTamanoDeCampo(RefaccionIT.getPARA_QUE_ES().getLongitudDeCaracteres());
        
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
        
        _ListaMaquinaModelo.setValueChange(()->_ListaMaquinaModelo.cambioEntreListas(false));
        _ListasMaquinasSeleccionadas.setValueChange(()->_ListaMaquinaModelo.cambioEntreListas(true));
        
        etiquetaRefaccionesPendientesPorModificar.setVisible(false);
        
        
        //ACCIONES DE BOTONES
        UtilidadesBotones_.setEnterYEspacio(btnCancelar);
        UtilidadesBotones_.setEnterYEspacio(btnGuardar);
        
        //OPERACIONES DE ACTUALIZACION
        
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
    
    int idModificandoseActualmente = -1;
    public void configurar(int id, int idRestantesCantidad){
        
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS 
        ///////////////////////////////////////////////////////////////////////
        */
        idModificandoseActualmente = id;
        cargarRefaccionAModificar(idModificandoseActualmente, idRestantesCantidad);
        etiquetaRefaccionesPendientesPorModificar.setVisible(true);
        btnGuardar.setText("Modificar");
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */
    
    }
    
    public void cargarRefaccionAModificar(int id, int idRestantesCantidad){
        
        etiquetaRefaccionesPendientesPorModificar.setText("Refacciones por modificar: "+idRestantesCantidad);
        
        RefaccionVo rvo = this.getCoordinador().refaccionConsultar(id);
        List<RelacionRefaccionMaquinaModeloVo> lmmvo = this.getCoordinador().maquinaModeloConsultar(id);
        
        
        _TxtNombreDeLaRefaccion.setText(rvo.getNombre());
        _TxtCodigo.setText(rvo.getCodigoInterno());
        _TxtCodigoDelProveedor.setText(rvo.getCodigoProveedor());
        _TxtStockMin.setText(rvo.getStockMinimo()+"");
        _TxtStockMax.setText(rvo.getStockMaximo()+"");
        _TxtDescripcion.setText(rvo.getDescripcion());
        _TxtQueEs.setText(rvo.getQueEs());
        _TxtParaQueEs.setText(rvo.getParaQueEs());
        
        if (rvo.getRefaccionDeConsumoUnico()==(byte)1) {
            checkEsDeConsumoUnico.setSelected(true);
        } else {
            checkEsDeConsumoUnico.setSelected(false);
        }
            
        
        
//        //CARGAMOS LOS COMBOS PARA SELECCIONAR EL ELEMENTO QUE ESTA GUADRADO EN 
//        // LA BASE. 
//        cargarListasYCombos();
        
        _RadioImportancia.setSelectRadio((String)rvo.getImportancia());
        _ComboMaterial.setSelectedItem((String)rvo.getIdMaterial());
        
        _ComboUnidad.setSelectedItem((String)rvo.getUnidad());
        
        //CARGAMOS LOS DATOS YA GUARDADOS EN SUS LISTAS Y LOS ELIMINANOD DE LA 
        // OTRA. 
        
              
        HashMap<String, Object> mmvoMapa = new HashMap<>();
        for (RelacionRefaccionMaquinaModeloVo vo : lmmvo) {
            _ListaMaquinaModelo.removeElement(
                    vo.getMaquinaModeloVo().getModelo()
                    + " "+vo.getMaquinaModeloVo().getAnio());
            
            mmvoMapa.put(vo.getMaquinaModeloVo().getModelo()
                    + " "+vo.getMaquinaModeloVo().getAnio(), 
                    vo.getIdMaquinaModelo());
        }
        
        _ListasMaquinasSeleccionadas.cargarLista(mmvoMapa);
        cargarImagenes(id);
    }
    
     private List<ImagenRefaccionVo> listaImagenesRefaccion;
    /**
     * Carga las imagenes que esten relacionadas con id que se le pase.   
     * @param id El id que corresponde a la refacción.
     */
    public void cargarImagenes(int id){
        listaImagenesRefaccion = this.getCoordinador().imagenRefaccionConsultar(id);
        _ImagenesRefacciones.limpiarComponenteURL();
        for (ImagenRefaccionVo vo : listaImagenesRefaccion) {
            UtilidadesJXViewImage_.TransporteImagenesURL t = new UtilidadesJXViewImage_.TransporteImagenesURL();
            t.setIdImagen(vo.getIdRefaccion());
            t.setNombreImagen(vo.getNombreParaMostrar());
            t.setNombreImagenServidor(vo.getNombreServidor());
            t.setUrl(vo.getUrlImagen());
            _ImagenesRefacciones.addIMagenes(t);
        }
        _ImagenesRefacciones.cargarPrimeraImagen();
        
    }
    
    private boolean unaSolaRefaccion;
    /**
     * True para definir que es una sola refacción y que no se ejecuta de nuevo
     * la operación que carga las refacciónes pendientes. 
     * @param unaSolaRefaccion
     */
    public void setUnaSolaRefaccion(boolean unaSolaRefaccion) {
        this.unaSolaRefaccion = unaSolaRefaccion;
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
        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        etiquetaRefaccionesPendientesPorModificar = new javax.swing.JLabel();

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
        btnAgregarNuevaMaquina.setText("Registrar nueva máquina");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txtBusqueda.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBusqueda.setMaximumSize(new java.awt.Dimension(395, 2147483647));
        txtBusqueda.setMinimumSize(new java.awt.Dimension(395, 35));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_buscar.png"))); // NOI18N

        etiquetaRefaccionesPendientesPorModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaRefaccionesPendientesPorModificar.setText("Refacciones pendientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(etiquetaNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(etiquetaMaquinas)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                                        .addComponent(jLabel1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jScrollPane3))
                                                .addGap(6, 6, 6))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addComponent(etiquetaCompatibles, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnAgregarNuevaMaquina))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jScrollPane4)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(etiquetaImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(etiquetaRefaccionesPendientesPorModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioAkta)
                                                .addGap(9, 9, 9)
                                                .addComponent(radioMedia)
                                                .addGap(2, 2, 2)
                                                .addComponent(radioBaja)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addGap(6, 6, 6)
                                .addComponent(btnGuardar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(filler7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiquetaNombreDeLaRefaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(filler5, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(filler6, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiquetaNombreDeLaRefaccion)
                                            .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(etiquetaMaquinas))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(etiquetaCompatibles)
                                                    .addComponent(btnAgregarNuevaMaquina))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radioAkta)
                                            .addComponent(radioMedia)
                                            .addComponent(radioBaja)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(etiquetaImportancia)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(etiquetaRefaccionesPendientesPorModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(checkEsDeConsumoUnico))
                                    .addComponent(btnGuardar))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listaMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMaquinasMouseClicked
    }//GEN-LAST:event_listaMaquinasMouseClicked

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        
        HiloConPrecarga hcp = new HiloConPrecarga( 
                ()->_ImagenesRefacciones.cargarImagenes(),
                getCoordinador().getPanelCarga());
        hcp.start();
        
        
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
        limpiar();
        this.getCoordinador().refaccionAbrirPanelModificar(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    
    
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        HiloConPrecarga hcp = new HiloConPrecarga(this::guardar, getCoordinador().getPanelCarga());
        hcp.start();
    }
    
    
    private void guardar() {     
        RefaccionVo rVo = new RefaccionVo();
        
        //LAS LISTAS QUE CONTENDRAN LOS DATOS PARA LAS MULTIPLES RELACIONES QUE TENEMOS.
        List<ImagenRefaccionVo> listaiVo = new ArrayList<>();
        List<RelacionRefaccionMaquinaModeloVo> listarrmmVo = new ArrayList<>();
//        List<RelacionRefaccionProveedorVo> listarrpVo = new ArrayList<>();
              
        
        //VO DE REFACCION.
        if (idModificandoseActualmente!=-1) {
            rVo.setId(idModificandoseActualmente);
        }
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
        List<Object> mmSeleccinadas = _ListasMaquinasSeleccionadas.getItems_ObjectsRelacionados();
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
        
        
        //VALIDACIONES
        //REFACCION
        List<Validacion> valRefaccion;
        if (idModificandoseActualmente==-1) {
           valRefaccion = this.getCoordinador().refaccionValidarCampos(rVo);
        }else{
           valRefaccion = this.getCoordinador().refaccionValidarCampos(rVo, true);
        }
        
        //RELACION MAQUINAMODELO
        List<Validacion> valRelacionRMM = 
                this.getCoordinador().refaccionValidarCamposMaquinaModelo(listarrmmVo);
        
                
        //SI ESTA VARIABLE QUEDA EN TRUE QUIERE DECIR QUE TODAS LAS VALIDACIONES
        //PASARON.
        boolean todoValido = true;
        
        //VALIDAMOS REFACCION
        RefaccionIT t = new RefaccionIT();
        for (Validacion v : valRefaccion) {
            System.out.println(v.toString());
            
            //NOMBRE DE LA REFACCION.
            if (v.getNombreDeCampo().equals(RefaccionIT.getNOMBRE().getNombre())) {
                if (!v.isValido()) {
                    _TxtNombreDeLaRefaccion.setError(v.getMensajeDeError());
                } else {
                    _TxtNombreDeLaRefaccion.setErrorQuitar();
                }
            }
            
            //CODIGO INTERNO DE LA REFACCION
            if (v.getNombreDeCampo().equals(RefaccionIT.getCODIGO_INTERNO().getNombre())) {
                if (!v.isValido()) {
                    _TxtCodigo.setError(v.getMensajeDeError());
                } else {
                    _TxtCodigo.setErrorQuitar();
                }
            }
            
            //UNIDAD
            if (v.getNombreDeCampo().equals(RefaccionIT.getUNIDAD().getNombre())) {
                if (!v.isValido()) {
                    _ComboUnidad.setError(v.getMensajeDeError());
                } else {
                    _ComboUnidad.setErrorQuitar();
                }
            }
            
            //STOCK MINIMO
            if (v.getNombreDeCampo().equals(RefaccionIT.getSTOCK_MINIMO().getNombre())) {
                if (!v.isValido()) {
                    _TxtStockMin.setError(v.getMensajeDeError());
                } else {
                    _TxtStockMin.setErrorQuitar();
                }
            }
            
            //STOCK MAXIMO
            if (v.getNombreDeCampo().equals(RefaccionIT.getSTOCK_MAXIMO().getNombre())) {
                if (!v.isValido()) {
                    _TxtStockMax.setError(v.getMensajeDeError());
                } else {
                    _TxtStockMax.setErrorQuitar();
                }
            }
           
            //CODIGO EXTERNO DE LA REFACCIÓN.
            if (v.getNombreDeCampo().equals(RefaccionIT.getCODIGO_PROVEEDOR().getNombre())) {
                if (!v.isValido()) {
                    _TxtCodigoDelProveedor.setError(v.getMensajeDeError());
                } else {
                    _TxtCodigoDelProveedor.setErrorQuitar();
                }
            }
            
            //MATERIAL - DE QUE ESTA ECHO.
            if (!v.getNombreDeCampo().equals(RefaccionIT.getID_MATERIAL().getNombre())) {
            } else {
                if (!v.isValido()) {
                    _ComboMaterial.setError(v.getMensajeDeError());
                } else {
                    _ComboMaterial.setErrorQuitar();
                }
            }
            
            //DESCRIPCION
            if (!v.getNombreDeCampo().equals(RefaccionIT.getDESCRIPCION().getNombre())) {
            } else {
                if (!v.isValido()) {
                    _TxtDescripcion.setError(v.getMensajeDeError());
                } else {
                    _TxtDescripcion.setErrorQuitar();
                }
            }
            
            //IMPORTANCIA
            if (v.getNombreDeCampo().equals(RefaccionIT.getIMPORTANCIA().getNombre())) {
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
        
        //VALIDAMOS MAQUINAMODELO
        for (Validacion v : valRelacionRMM) {
            if (!v.isValido()) {
                _ListasMaquinasSeleccionadas.setError(v.getMensajeDeError());
                todoValido = false;
            }else{
                _ListasMaquinasSeleccionadas.setErrorQuitar();
            }
        }
        
        String mensajes = "";
        if (todoValido) {
            
            //GUARDAMOS LA REFACCIÓN.
            boolean guardadoModificadoCorrecto = 
                    idModificandoseActualmente==-1 
                    ? getCoordinador().refaccionGuardar(rVo):
                    getCoordinador().refaccionModificar(rVo);
            
            if(guardadoModificadoCorrecto){
                //OBTENEMOS EL ID GENERADO.
                if (idModificandoseActualmente==-1) {
                    
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

                        if (this.getCoordinador().relacionRefaccionMaquinaModeloGuardarLista(listarrmmVo)) {
                            String errorImg = this.getCoordinador().imagenRefaccionGuardarLista(listaiVo);
                            if (errorImg!=null) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "No se cargaron las siguientes imagenes: \n\n" + errorImg,
                                        "Error cargando imagenes", JOptionPane.ERROR_MESSAGE);
                            }

                            limpiarTodo();
                            mensajes = "Se guardo la refaccción correctamente.";
                            getCoordinador().actualizarTodoLoVisible();
                        }else{
                            mensajes = "Algo paso y no se "
                                    + "pudo guardar la refacción.";
                        }
                    }
                } else {
                    int idRefaccion = this.idModificandoseActualmente;
                    //ASOCIAMOS LOS DATOS QUE SE VAN A RELACIONAR CON LA REFACCIÓN RECIEN
                    //ALMACENADA. 
                    for (ImagenRefaccionVo iVo : listaiVo) {
                        iVo.setIdRefaccion(idRefaccion);
                    }

                    for (RelacionRefaccionMaquinaModeloVo rr : listarrmmVo) {
                        rr.setIdRefaccion(idRefaccion);
                    }

                    if(getCoordinador().relacionRefaccionMaquinaModeloModificarLista(listarrmmVo)){
                        limpiar();
                        getCoordinador().actualizarTodoLoVisible();
                        mensajes = "Se actualizo la refaccción correctamente.";
                        //SI SE PUSO EN TRUE ENTONCES YA NO REVISAMOS SI HAY MÁS REFACCIONES
                        // POR MODIFICAR Y ABRIRMOS LA CONSULTA DE REFACCIONES. 
                        if (unaSolaRefaccion) {
                            unaSolaRefaccion = false;
                            getCoordinador().refaccionAbrirPanelConsultaRefacciones();
                        }else{
                        //SIRVE PARA ITERAR SOBRE LA LISTA QUE CONTIENE LAS RERFACCIONES 
                        // SELECCIONADAS PARA MODIFICAR.
                            this.getCoordinador().refaccionAbrirPanelModificar();
                        }
                    
                    }else{
                        mensajes = "Al parecer no se pudieron guardar algúnos cambios."
                                + "\n Puedes revisarlos para ver que sucedio";
                    }
                }
            }else{
                mensajes = "Algo paso y no se pudo completar la acción.";
            }
        }
    }
    
    public void limpiarTodo(){
        //SE LIMPIA CUANDO SE GUARDA. 
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
        
        idModificandoseActualmente = -1;
        
        opAct.actualizarPanel();
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    @Override
    public void limpiar() {
        //AQUI LIMPIAMOS LO QUE SE MODIFICA
        _ImagenesRefacciones.setErrorQuitar();
        _ComboUnidad.setErrorQuitar();
        _ComboMaterial.setErrorQuitar();



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
        

    }
    
    private void radioBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBajaActionPerformed

    private void btnAgregarNuevaMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevaMaquinaActionPerformed
        this.getCoordinador().maquinaModeloAbrirDialogoAgregar();
    }//GEN-LAST:event_btnAgregarNuevaMaquinaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnAgregarNuevaMaquina;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarImagen;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresarImagen;
    private javax.swing.JButton btnSiguienteImagen;
    private javax.swing.JCheckBox checkEsDeConsumoUnico;
    private javax.swing.JComboBox<String> comboMaterial;
    private javax.swing.JComboBox<String> comboUnidad;
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
    private javax.swing.JLabel etiquetaQueEs;
    private javax.swing.JLabel etiquetaRefaccionesPendientesPorModificar;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> listaMaquinas;
    private javax.swing.JList<String> listaMaquinasSeleccionadas;
    private javax.swing.JRadioButton radioAkta;
    private javax.swing.JRadioButton radioBaja;
    private javax.swing.ButtonGroup radioBotones;
    private javax.swing.JRadioButton radioMedia;
    private javax.swing.JTextField txtBusqueda;
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
        etiquetaRefaccionesPendientesPorModificar.setVisible(false);
        btnGuardar.setText("Guardar");
        limpiarTodo();
    }

}
