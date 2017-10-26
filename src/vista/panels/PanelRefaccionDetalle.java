/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.panels;

import controlador.CoordinadorPaneles;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.InfoTabla.ImagenRefaccionIT;
import modelo.InfoTabla.ImportanciaIT;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.MaterialIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.ProveedorVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import org.jdesktop.swingx.JXImageView;
import vista.UtilidadesIntefaz.ConfiguracionDePanel;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesJXViewImage_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesListas_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxtArea_;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.UtilidadesTxt_;


/**
 *
 * @author Particular
 */
public class PanelRefaccionDetalle extends JPanelBase {

    private static final long serialVersionUID = 1L;
    private int idRefaccion;

    private List<ImagenRefaccionVo> listaImagenesRefaccion;
    
    private UtilidadesJXViewImage_ _ImagenesRefacciones;
    
    private UtilidadesTxt_ _TxtUnidad;

    private UtilidadesListas_ _ListaProveedor;
    private UtilidadesListas_ _ListaMaquinaModelo;
    
    private UtilidadesTxt_ _txtNombreDeLaRefaccion;
    private UtilidadesTxt_ _txtCodigo;
    private UtilidadesTxt_ _txtExistencia;
    private UtilidadesTxt_ _txtStockMin;
    private UtilidadesTxt_ _txtStockMax;
    private UtilidadesTxt_ _txtCodigoDelProveedor;
    private UtilidadesTxt_ _txtDeQueEstaEcho;
    
    private UtilidadesTxtArea_ _TxtDescripcion;
    private UtilidadesTxtArea_ _TxtQueEs;
    private UtilidadesTxtArea_ _TxtParaQueEs;
    
    UtilidadesTxt_ _txtImportancia;

    /** Creates new form DialogoDetalleRefaccion */
    public PanelRefaccionDetalle() {
        initComponents();
        configuracionesDialogo = new ConfiguracionDePanel();
        configuracionesDialogo.setModal(false);
        configuracionesDialogo.setResizable(false);
        configuracionesDialogo.setTitle(CoordinadorPaneles.PANEL_REFACCION_DETALLE);
        configuracionesDialogo.setLocationRelativeTo(null);
        configuracionesDialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
    }
    
    

    @Override
    public void initConfig() {
        /*
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        
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
        
        etiquetaCodigoDelProveedor.setText(rit.getCODIGO_PROVEEDOR().getNombreParaMostrar());
        etiquetaCodigoInterno.setText(rit.getCODIGO_INTERNO().getNombreParaMostrar());
        etiquetaDeQueEstaEcho.setText(mit.getMATERIAL().getNombreParaMostrar());
        etiquetaDescripcion.setText(rit.getDESCRIPCION().getNombreParaMostrar());
        etiquetaImportancia.setText(iit.getIMPORTANCIA().getNombreParaMostrar());
        etiquetaMaquinas.setText(mmit.getMODELO().getNombreParaMostrar());
        etiquetaNombreDeLaRefaccion.setText(rit.getNOMBRE().getNombreParaMostrar());
        etiquetaParaQueEs.setText(rit.getPARA_QUE_ES().getNombreParaMostrar());
        etiquetaProveedores.setText(pit.getEMPRESA_PROVEEDOR().getNombreParaMostrar());
        etiquetaQueEs.setText(rit.getQUE_ES().getNombreParaMostrar());
        etiquetaStockMax.setText(rit.getSTOCK_MAXIMO().getNombreParaMostrar());
        etiquetaStockMin.setText(rit.getSTOCK_MINIMO().getNombreParaMostrar());
               
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
    
        _TxtUnidad = new UtilidadesTxt_(getCoordinador());

        _ListaProveedor = new UtilidadesListas_(getCoordinador());
        _ListaMaquinaModelo = new UtilidadesListas_(getCoordinador());

        _txtNombreDeLaRefaccion = new UtilidadesTxt_(getCoordinador());
        _txtCodigo = new UtilidadesTxt_(getCoordinador());
        _txtExistencia = new UtilidadesTxt_(getCoordinador());
        _txtStockMin = new UtilidadesTxt_(getCoordinador());
        _txtStockMax = new UtilidadesTxt_(getCoordinador());
        
        _txtCodigoDelProveedor = new UtilidadesTxt_(getCoordinador());

        _TxtDescripcion = new UtilidadesTxtArea_(getCoordinador());
        _TxtQueEs = new UtilidadesTxtArea_(getCoordinador());
        _TxtParaQueEs = new UtilidadesTxtArea_(getCoordinador());

        _txtImportancia = new UtilidadesTxt_(getCoordinador());
        
        _txtDeQueEstaEcho = new UtilidadesTxt_(getCoordinador());
        
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _ImagenesRefacciones.setComponente(getImagenesRefacciones());
        _ImagenesRefacciones.setjLabelContador(getEtiquetaNombreImagen());
    
        _TxtUnidad.setComponente(getTxtUnidad());

        _ListaProveedor.setComponente(getListaProveedores());
        _ListaMaquinaModelo.setComponente(getListaMaquinas());

        _txtNombreDeLaRefaccion.setComponente(getTxtNombreDeLaRefaccion());
        _txtCodigo.setComponente(getTxtCodigoInterno());
        _txtStockMin.setComponente(getTxtStockMin());
        _txtStockMax.setComponente(getTxtStockMax());
        _txtExistencia.setComponente(txtExistencia);
        _txtCodigoDelProveedor.setComponente(getTxtCodigoProveedor());
        _txtDeQueEstaEcho.setComponente(getTxtDeQueEstaEcho());

        _TxtDescripcion.setComponente(getTxtDescripcion());
        _TxtQueEs.setComponente(getTxtQueEs());
        _TxtParaQueEs.setComponente(getTxtParaQueEs());

        _txtImportancia.setComponente(getTxtImportancia());
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        
        //CAMPOS NUMÉRICOS
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        
        //TRAVEL POLICY
        
        //ACCIONES ESPECELIALES.
        noActualizarOperaciones();
        
        
        //ACCIONES DE BOTONES
        
        //OPERACIONES DE ACTUALIZACIÓN.
        opAct.add(RefaccionIT.NOMBRE_TABLA, this::cargarElementos);
        opAct.add(RefaccionIT.NOMBRE_TABLA, this::cargarProveedores);
        opAct.add(RefaccionIT.NOMBRE_TABLA, this::cargarMaquinaModelo);
        opAct.add(ImagenRefaccionIT.NOMBRE_TABLA, this::cargarImagenes);
        
        
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
         
    }
    
    @Override
    public void configurar(){
    }
    


    
    
    public void configurar(String id){
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS 
        ///////////////////////////////////////////////////////////////////////
        */
        limpiar();
        idRefaccion = Integer.parseInt(id);
        opAct.actualizarPanel();
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */
    }
    
    
    
    @Override
    public void limpiar(){
        _ImagenesRefacciones.limpiarComponenteURL();
        _ListaMaquinaModelo.limpiar();
        _ListaProveedor.limpiar();
        _TxtDescripcion.setText();
        _TxtParaQueEs.setText();
        _TxtQueEs.setText();
        _TxtUnidad.setText();
        _txtCodigo.setText();
        _txtCodigoDelProveedor.setText();
        _txtDeQueEstaEcho.setText();
        _txtExistencia.setText();
        _txtImportancia.setText();
        _txtNombreDeLaRefaccion.setText();
        _txtStockMax.setText();
        _txtStockMin.setText();
    }


    
    public void cargarElementos(){
        
        RefaccionVo rvo = this.getCoordinador().refaccionConsultar(idRefaccion);
        float existencia = this.getCoordinador().entradaLoteExistencia(idRefaccion);
        
        _txtNombreDeLaRefaccion.setText(rvo.getNombre());
        _txtCodigo.setText(rvo.getCodigoInterno());
        _txtCodigoDelProveedor.setText(rvo.getCodigoProveedor());
        _txtImportancia.setText((String)rvo.getImportancia());
        _txtDeQueEstaEcho.setText((String)rvo.getIdMaterial());
        
        _txtExistencia.setText(existencia+"");
        _txtStockMin.setText(rvo.getStockMinimo()+"");
        _txtStockMax.setText(rvo.getStockMaximo()+"");
        
        boolean todoBien = true;
        if (rvo.getStockMaximo()<existencia) {
            _txtExistencia.setError();
            _txtStockMax.setError();
            todoBien = false;
        }else{
            _txtStockMax.setErrorQuitar();
        }
        
        if (rvo.getStockMinimo()>existencia) {
            _txtExistencia.setError();
            _txtStockMin.setError();
            todoBien = false;
        }else{
            _txtStockMin.setErrorQuitar();
        }
        
        if (todoBien) {
            _txtExistencia.setErrorQuitar();
        }
        
        
        
        _TxtUnidad.setText((String)rvo.getUnidad());
        _TxtDescripcion.setText(rvo.getDescripcion());
        _TxtQueEs.setText(rvo.getQueEs());
        _TxtParaQueEs.setText(rvo.getParaQueEs());
        
        checkEsDeConsumoUnico.setSelected((rvo.getRefaccionDeConsumoUnico()==(byte)1));
        
//        cargarImagenes();
        
    }
    
    public void cargarProveedores(){
        _ListaProveedor.limpiar();
        if (idRefaccion!=-1) {
            RefaccionVo rvo = new RefaccionVo();
            rvo.setId(idRefaccion);
            List<ProveedorVo> lpvo = this.getCoordinador().proveedoresConsultarMarcas(rvo);
            HashMap<String, Object> pvoMapa = new HashMap<>();
            for (ProveedorVo vo : lpvo) {
                pvoMapa.put(vo.getEmpresa(), vo);
            }
            System.out.println(pvoMapa.toString());
            _ListaProveedor.cargarLista(pvoMapa);
            JOptionPane.showMessageDialog(null, pvoMapa.toString());
        }
    
    }
    
    public void cargarMaquinaModelo(){
        _ListaMaquinaModelo.limpiar();
        if (idRefaccion!=-1) {
            List<RelacionRefaccionMaquinaModeloVo> lmmvo = this.getCoordinador().maquinaModeloConsultar(idRefaccion);
                HashMap<String, Object> mmvoMapa = new HashMap<>();
                for (RelacionRefaccionMaquinaModeloVo vo : lmmvo) {
                    mmvoMapa.put(vo.getMaquinaModeloVo().getModelo()
                            + " "+vo.getMaquinaModeloVo().getAnio(), 
                            vo.getIdMaquinaModelo());
                }
                _ListaMaquinaModelo.cargarLista(mmvoMapa);
        }
    }
    
    /**
     * Carga las imagenes que esten relacionadas con id que se le pase.   
     */
    public void cargarImagenes(){
        int id = idRefaccion;
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
    
    
    public List<ImagenRefaccionVo> getListaImagenesRefaccion() {
        return listaImagenesRefaccion;
    }

    public void setListaImagenesRefaccion(List<ImagenRefaccionVo> listaImagenesRefaccion) {
        this.listaImagenesRefaccion = listaImagenesRefaccion;
    }

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public JXImageView getImagenesRefacciones() {
        return imagenesRefacciones;
    }

    public void setImagenesRefacciones(JXImageView imagenesRefacciones) {
        this.imagenesRefacciones = imagenesRefacciones;
    }

    public JList<String> getListaMaquinas() {
        return listaMaquinas;
    }

    public void setListaMaquinas(JList<String> listaMaquinas) {
        this.listaMaquinas = listaMaquinas;
    }

    public JList<String> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(JList<String> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public JTextField getTxtCodigoInterno() {
        return txtCodigoInterno;
    }

    public void setTxtCodigoInterno(JTextField txtCodigoInterno) {
        this.txtCodigoInterno = txtCodigoInterno;
    }

    public JTextField getTxtCodigoProveedor() {
        return txtCodigoProveedor;
    }

    public void setTxtCodigoProveedor(JTextField txtCodigoProveedor) {
        this.txtCodigoProveedor = txtCodigoProveedor;
    }

    public JTextField getTxtDeQueEstaEcho() {
        return txtDeQueEstaEcho;
    }

    public void setTxtDeQueEstaEcho(JTextField txtDeQueEstaEcho) {
        this.txtDeQueEstaEcho = txtDeQueEstaEcho;
    }

    public JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextArea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JTextField getTxtExistencia() {
        return txtExistencia;
    }

    public void setTxtExistencia(JTextField txtExistencia) {
        this.txtExistencia = txtExistencia;
    }

    public JTextField getTxtImportancia() {
        return txtImportancia;
    }

    public void setTxtImportancia(JTextField txtImportancia) {
        this.txtImportancia = txtImportancia;
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

    public JTextField getTxtUnidad() {
        return txtUnidad;
    }

    public void setTxtUnidad(JTextField txtUnidad) {
        this.txtUnidad = txtUnidad;
    }

    public JLabel getEtiquetaNombreImagen() {
        return etiquetaNombreImagen;
    }

    public void setEtiquetaNombreImagen(JLabel etiquetaNombreImagen) {
        this.etiquetaNombreImagen = etiquetaNombreImagen;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        etiquetaProveedores = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaProveedores = new javax.swing.JList<>();
        etiquetaImportancia = new javax.swing.JLabel();
        etiquetaMaquinas = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaMaquinas = new javax.swing.JList<>();
        txtStockMax = new javax.swing.JTextField();
        txtNombreDeLaRefaccion = new javax.swing.JTextField();
        etiquetaDescripcion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        etiquetaCodigoInterno = new javax.swing.JLabel();
        etiquetaCodigoDelProveedor = new javax.swing.JLabel();
        etiquetaQueEs = new javax.swing.JLabel();
        etiquetaNombreDeLaRefaccion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQueEs = new javax.swing.JTextArea();
        etiquetaParaQueEs = new javax.swing.JLabel();
        etiquetaStockMin = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtParaQueEs = new javax.swing.JTextArea();
        txtStockMin = new javax.swing.JTextField();
        etiquetaStockMax = new javax.swing.JLabel();
        imagenesRefacciones = new org.jdesktop.swingx.JXImageView();
        btnSiguienteImagen = new javax.swing.JButton();
        btnRegresarImagen = new javax.swing.JButton();
        etiquetaNombreImagen = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        etiquetaExistencia = new javax.swing.JLabel();
        etiquetaDeQueEstaEcho = new javax.swing.JLabel();
        txtDeQueEstaEcho = new javax.swing.JTextField();
        txtCodigoInterno = new javax.swing.JTextField();
        txtCodigoProveedor = new javax.swing.JTextField();
        txtImportancia = new javax.swing.JTextField();
        txtUnidad = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        etiquetaParaQueEs1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        etiquetaPedidoEnEspera = new javax.swing.JLabel();
        checkEsDeConsumoUnico = new javax.swing.JCheckBox();

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_tache.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        etiquetaProveedores.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaProveedores.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaProveedores.setText("Proveedores");
        etiquetaProveedores.setOpaque(true);

        listaProveedores.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaProveedores.setFocusable(false);
        listaProveedores.setMinimumSize(new java.awt.Dimension(237, 9));
        listaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listaProveedores);

        etiquetaImportancia.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaImportancia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaImportancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaImportancia.setText("Importantancia");
        etiquetaImportancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaImportancia.setOpaque(true);

        etiquetaMaquinas.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaMaquinas.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaMaquinas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaMaquinas.setText("Maquinas");
        etiquetaMaquinas.setOpaque(true);

        listaMaquinas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaMaquinas.setFocusable(false);
        listaMaquinas.setMinimumSize(new java.awt.Dimension(237, 9));
        listaMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMaquinasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listaMaquinas);

        txtStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMax.setText("012345.123");
        txtStockMax.setFocusable(false);

        txtNombreDeLaRefaccion.setEditable(false);
        txtNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        txtNombreDeLaRefaccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreDeLaRefaccion.setPreferredSize(new java.awt.Dimension(40, 337));

        etiquetaDescripcion.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaDescripcion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaDescripcion.setText("Descripcion");
        etiquetaDescripcion.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(98, 15, 89));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_titulo_detalle de refaccion.png"))); // NOI18N

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(1);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setFocusCycleRoot(true);
        txtDescripcion.setFocusTraversalPolicyProvider(true);
        txtDescripcion.setFocusable(false);
        jScrollPane1.setViewportView(txtDescripcion);

        etiquetaCodigoInterno.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaCodigoInterno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoInterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoInterno.setText("Código interno");
        etiquetaCodigoInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoInterno.setOpaque(true);

        etiquetaCodigoDelProveedor.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaCodigoDelProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoDelProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoDelProveedor.setText("Código proveedor");
        etiquetaCodigoDelProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        etiquetaCodigoDelProveedor.setOpaque(true);

        etiquetaQueEs.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaQueEs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaQueEs.setText("¿Que es?");
        etiquetaQueEs.setOpaque(true);

        etiquetaNombreDeLaRefaccion.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNombreDeLaRefaccion.setText("Nombre de la refacción");
        etiquetaNombreDeLaRefaccion.setOpaque(true);

        txtQueEs.setEditable(false);
        txtQueEs.setColumns(20);
        txtQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtQueEs.setLineWrap(true);
        txtQueEs.setRows(1);
        txtQueEs.setWrapStyleWord(true);
        txtQueEs.setFocusCycleRoot(true);
        txtQueEs.setFocusTraversalPolicyProvider(true);
        txtQueEs.setFocusable(false);
        jScrollPane2.setViewportView(txtQueEs);

        etiquetaParaQueEs.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaParaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaParaQueEs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaParaQueEs.setText("¿Para que es?");
        etiquetaParaQueEs.setOpaque(true);

        etiquetaStockMin.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaStockMin.setText("Stock Min");
        etiquetaStockMin.setOpaque(true);

        txtParaQueEs.setEditable(false);
        txtParaQueEs.setColumns(20);
        txtParaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtParaQueEs.setLineWrap(true);
        txtParaQueEs.setRows(1);
        txtParaQueEs.setWrapStyleWord(true);
        txtParaQueEs.setFocusCycleRoot(true);
        txtParaQueEs.setFocusTraversalPolicyProvider(true);
        txtParaQueEs.setFocusable(false);
        jScrollPane7.setViewportView(txtParaQueEs);

        txtStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMin.setText("012345.123");
        txtStockMin.setFocusable(false);
        txtStockMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockMinActionPerformed(evt);
            }
        });

        etiquetaStockMax.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaStockMax.setText("Stock Max");
        etiquetaStockMax.setOpaque(true);

        imagenesRefacciones.setOpaque(false);
        imagenesRefacciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenesRefaccionesMouseClicked(evt);
            }
        });

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

        etiquetaNombreImagen.setBackground(new java.awt.Color(33, 33, 33));
        etiquetaNombreImagen.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaNombreImagen.setText("Stock Max");
        etiquetaNombreImagen.setOpaque(true);

        javax.swing.GroupLayout imagenesRefaccionesLayout = new javax.swing.GroupLayout(imagenesRefacciones);
        imagenesRefacciones.setLayout(imagenesRefaccionesLayout);
        imagenesRefaccionesLayout.setHorizontalGroup(
            imagenesRefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenesRefaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguienteImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaNombreImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );
        imagenesRefaccionesLayout.setVerticalGroup(
            imagenesRefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenesRefaccionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(imagenesRefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiguienteImagen)
                    .addComponent(btnRegresarImagen)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagenesRefaccionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiquetaNombreImagen)
                .addContainerGap())
        );

        txtExistencia.setFont(new java.awt.Font("Calibri", 0, 40)); // NOI18N
        txtExistencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExistencia.setText("123456.321");
        txtExistencia.setFocusable(false);

        etiquetaExistencia.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaExistencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaExistencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaExistencia.setText("Existencia");
        etiquetaExistencia.setOpaque(true);

        etiquetaDeQueEstaEcho.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaDeQueEstaEcho.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaDeQueEstaEcho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaDeQueEstaEcho.setText("¿De que esta echo?");
        etiquetaDeQueEstaEcho.setOpaque(true);

        txtDeQueEstaEcho.setEditable(false);
        txtDeQueEstaEcho.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDeQueEstaEcho.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCodigoInterno.setEditable(false);
        txtCodigoInterno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCodigoInterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCodigoProveedor.setEditable(false);
        txtCodigoProveedor.setBackground(new java.awt.Color(102, 102, 102));
        txtCodigoProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtCodigoProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtImportancia.setEditable(false);
        txtImportancia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtImportancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtUnidad.setEditable(false);
        txtUnidad.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUnidad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUnidad.setText("UNIDAD");
        txtUnidad.setFocusable(false);

        etiquetaParaQueEs1.setBackground(new java.awt.Color(51, 51, 51));
        etiquetaParaQueEs1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaParaQueEs1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_mas.png"))); // NOI18N
        etiquetaParaQueEs1.setText("Doble click en la imagen para ver en detalle de imagenes.");
        etiquetaParaQueEs1.setOpaque(true);

        btnModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_mas.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        etiquetaPedidoEnEspera.setBackground(new java.awt.Color(255, 255, 0));
        etiquetaPedidoEnEspera.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        etiquetaPedidoEnEspera.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaPedidoEnEspera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaPedidoEnEspera.setText("Pedido en espera");
        etiquetaPedidoEnEspera.setToolTipText("");
        etiquetaPedidoEnEspera.setOpaque(true);

        checkEsDeConsumoUnico.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        checkEsDeConsumoUnico.setText("Consumo único");
        checkEsDeConsumoUnico.setEnabled(false);
        checkEsDeConsumoUnico.setFocusPainted(false);
        checkEsDeConsumoUnico.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(650, 650, 650)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imagenesRefacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(etiquetaExistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtExistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(etiquetaProveedores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUnidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etiquetaStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStockMax, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                            .addComponent(etiquetaStockMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(etiquetaMaquinas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(etiquetaCodigoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCodigoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiquetaCodigoDelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(etiquetaNombreDeLaRefaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtImportancia)
                                        .addComponent(etiquetaImportancia, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDeQueEstaEcho, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addComponent(etiquetaDeQueEstaEcho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etiquetaPedidoEnEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkEsDeConsumoUnico, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(3, 3, 3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(etiquetaParaQueEs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiquetaQueEs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                    .addComponent(etiquetaDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiquetaParaQueEs1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {etiquetaStockMax, etiquetaStockMin, txtStockMax, txtStockMin});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCodigoDelProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(etiquetaDeQueEstaEcho, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                    .addComponent(etiquetaPedidoEnEspera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDeQueEstaEcho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkEsDeConsumoUnico)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaQueEs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaParaQueEs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaExistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaStockMin, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(etiquetaStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaParaQueEs1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiquetaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenesRefacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnSalir))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {etiquetaCodigoDelProveedor, etiquetaCodigoInterno, etiquetaDeQueEstaEcho, etiquetaDescripcion, etiquetaExistencia, etiquetaImportancia, etiquetaMaquinas, etiquetaParaQueEs, etiquetaProveedores, etiquetaQueEs, etiquetaStockMax, etiquetaStockMin});

    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }    
    
    private void salir(){
        this.dispose();
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void listaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProveedoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaProveedoresMouseClicked

    private void listaMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMaquinasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaMaquinasMouseClicked

    private void txtStockMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockMinActionPerformed

    private void btnSiguienteImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteImagenActionPerformed
        _ImagenesRefacciones.imagenSiguiente();
    }//GEN-LAST:event_btnSiguienteImagenActionPerformed

    private void btnRegresarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarImagenActionPerformed
        _ImagenesRefacciones.imagenAnterior();
    }//GEN-LAST:event_btnRegresarImagenActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        salir();
    }//GEN-LAST:event_formWindowClosing

    private void imagenesRefaccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenesRefaccionesMouseClicked
        if (evt.getClickCount()==2) {
            this.getCoordinador().refaccionAbrirDetalleImagen();
        }
    }//GEN-LAST:event_imagenesRefaccionesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.dispose();
        
        this.getCoordinador().refaccionAbrirPanelModificar(idRefaccion, true);
    }//GEN-LAST:event_btnModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresarImagen;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguienteImagen;
    private javax.swing.JCheckBox checkEsDeConsumoUnico;
    private javax.swing.JLabel etiquetaCodigoDelProveedor;
    private javax.swing.JLabel etiquetaCodigoInterno;
    private javax.swing.JLabel etiquetaDeQueEstaEcho;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaExistencia;
    private javax.swing.JLabel etiquetaImportancia;
    private javax.swing.JLabel etiquetaMaquinas;
    private javax.swing.JLabel etiquetaNombreDeLaRefaccion;
    private javax.swing.JLabel etiquetaNombreImagen;
    private javax.swing.JLabel etiquetaParaQueEs;
    private javax.swing.JLabel etiquetaParaQueEs1;
    private javax.swing.JLabel etiquetaPedidoEnEspera;
    private javax.swing.JLabel etiquetaProveedores;
    private javax.swing.JLabel etiquetaQueEs;
    private javax.swing.JLabel etiquetaStockMax;
    private javax.swing.JLabel etiquetaStockMin;
    private javax.swing.Box.Filler filler1;
    private org.jdesktop.swingx.JXImageView imagenesRefacciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<String> listaMaquinas;
    private javax.swing.JList<String> listaProveedores;
    private javax.swing.JTextField txtCodigoInterno;
    private javax.swing.JTextField txtCodigoProveedor;
    private javax.swing.JTextField txtDeQueEstaEcho;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtImportancia;
    private javax.swing.JTextField txtNombreDeLaRefaccion;
    private javax.swing.JTextArea txtParaQueEs;
    private javax.swing.JTextArea txtQueEs;
    private javax.swing.JTextField txtStockMax;
    private javax.swing.JTextField txtStockMin;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables

}
