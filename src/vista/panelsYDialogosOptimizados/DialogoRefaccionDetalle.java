/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.panelsYDialogosOptimizados;

import controlador.Coordinador;
import java.util.HashMap;
import java.util.List;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.InfoTabla.ImportanciaIT;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.MaterialIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.InfoTabla.RefaccionIT;
import org.jdesktop.swingx.JXImageView;
<<<<<<< HEAD
import utilidades.UtilidadesJXViewImage_;
import utilidades.UtilidadesListas_;
import utilidades.UtilidadesTxtArea_;
import vista.utilidades.UtilidadesTxt_;
=======
import vista.utilidadesOptimizadas.UtilidadesJXViewImage_;
import vista.utilidadesOptimizadas.UtilidadesListas_;
import vista.utilidadesOptimizadas.UtilidadesTxtArea_;
import vista.utilidadesOptimizadas.UtilidadesTxt_;
>>>>>>> parent of d0a5173... REacomodamos muchisisisisisisisisismas cosas.
import javax.swing.JDialog;
import javax.swing.JLabel;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import modelo.vo.RelacionRefaccionProveedorVo;


/**
 *
 * @author Particular
 */
public class DialogoRefaccionDetalle extends JDialog {
    private Coordinador coordinador;
    private int idRefaccion;
    private List<ImagenRefaccionVo> listaImagenesRefaccion;
    
    private UtilidadesJXViewImage_ _ImagenesRefacciones;
    
    private UtilidadesTxt_ _TxtUnidad;

    private UtilidadesListas_ _ListaProveedor;
    private UtilidadesListas_ _ListaMaquinaModelo;
    
    private UtilidadesTxt_ _TxtNombreDeLaRefaccion;
    private UtilidadesTxt_ _TxtCodigo;
    private UtilidadesTxt_ _TxtStockMin;
    private UtilidadesTxt_ _TxtStockMax;
    private UtilidadesTxt_ _TxtCodigoDelProveedor;
    private UtilidadesTxt_ _TxtDeQueEstaEcho;
    
    private UtilidadesTxtArea_ _TxtDescripcion;
    private UtilidadesTxtArea_ _TxtQueEs;
    private UtilidadesTxtArea_ _TxtParaQueEs;
    
    UtilidadesTxt_ _TxtImportancia;

    /** Creates new form DialogoDetalleRefaccion */
    public DialogoRefaccionDetalle() {
        initComponents();
    }
    
    public void configurar(String id){
        /*
        =======================================================================
            INICIO CONFIGURACIONES DIALOGO
        ///////////////////////////////////////////////////////////////////////

        Los dialogos nos los estoy configurando de manera complicada. Solo lo
        básico para que funcionen en modal.
        
        */ 
//        setModal(true);
        setResizable(false);
        setTitle("Detalle de refacción");
        setLocationRelativeTo(this.getCoordinador().getMarcoParaVentanaPrincipal());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
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
        
        _ImagenesRefacciones = new UtilidadesJXViewImage_(coordinador);
    
        _TxtUnidad = new UtilidadesTxt_(coordinador);

        _ListaProveedor = new UtilidadesListas_(coordinador);
        _ListaMaquinaModelo = new UtilidadesListas_(coordinador);

        _TxtNombreDeLaRefaccion = new UtilidadesTxt_(coordinador);
        _TxtCodigo = new UtilidadesTxt_(coordinador);
        _TxtStockMin = new UtilidadesTxt_(coordinador);
        _TxtStockMax = new UtilidadesTxt_(coordinador);
        _TxtCodigoDelProveedor = new UtilidadesTxt_(coordinador);

        _TxtDescripcion = new UtilidadesTxtArea_(coordinador);
        _TxtQueEs = new UtilidadesTxtArea_(coordinador);
        _TxtParaQueEs = new UtilidadesTxtArea_(coordinador);

        _TxtImportancia = new UtilidadesTxt_(coordinador);
        
        _TxtDeQueEstaEcho = new UtilidadesTxt_(coordinador);
        
        
        //SETEAMOS LOS COMPONENTES DENTRO DE LA UTILIDAD.
        
        _ImagenesRefacciones.setComponente(getImagenesRefacciones());
        _ImagenesRefacciones.setjLabelContador(getEtiquetaNombreImagen());
    
        _TxtUnidad.setComponente(getTxtUnidad());

        _ListaProveedor.setComponente(getListaProveedores());
        _ListaMaquinaModelo.setComponente(getListaMaquinas());

        _TxtNombreDeLaRefaccion.setComponente(getTxtNombreDeLaRefaccion());
        _TxtCodigo.setComponente(getTxtCodigoInterno());
        _TxtStockMin.setComponente(getTxtStockMin());
        _TxtStockMax.setComponente(getTxtStockMax());
        _TxtCodigoDelProveedor.setComponente(getTxtCodigoProveedor());
        _TxtDeQueEstaEcho.setComponente(getTxtDeQueEstaEcho());

        _TxtDescripcion.setComponente(getTxtDescripcion());
        _TxtQueEs.setComponente(getTxtQueEs());
        _TxtParaQueEs.setComponente(getTxtParaQueEs());

        _TxtImportancia.setComponente(getTxtImportancia());
       
        //ASIGNAMOS EL TAMAÑO DE CAMPO
        
        //CAMPOS QUE REQUIEREN TEXTO EN MAYUSCULAS.
        
        //CAMPOS NUMÉRICOS
        
        //QUITAMOS LOS ESPACIOS SOBRANTES DESPUES DE DEJAR EL CAMPO.
        
        //TRAVEL POLICY
        
        //ACCIONES ESPECELIALES.
        
        //ACCIONES DE BOTONES
        
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN SETEO DE UTILIDADES
        ========================================================================
        */
        
        /*
        =======================================================================
            INICIO CARGA DE ELEMENTOS 
        ///////////////////////////////////////////////////////////////////////
        */
        idRefaccion = Integer.parseInt(id);
        cargarElementos();
        /* 
        ////////////////////////////////////////////////////////////////////////
            FIN CARGA DE ELEMENTOS 
        ========================================================================
        */
    }
    
    public void cargarElementos(){
        
        RefaccionVo rvo = this.getCoordinador().refaccionConsultar(idRefaccion);
        
        _TxtNombreDeLaRefaccion.setText(rvo.getNombre());
        _TxtCodigo.setText(rvo.getCodigoInterno());
        _TxtCodigoDelProveedor.setText(rvo.getCodigoProveedor());
        _TxtImportancia.setText((String)rvo.getImportancia());
        _TxtDeQueEstaEcho.setText((String)rvo.getIdMaterial());
        _TxtStockMin.setText(rvo.getStockMinimo()+"");
        _TxtStockMax.setText(rvo.getStockMaximo()+"");
        _TxtUnidad.setText((String)rvo.getUnidad());
        _TxtDescripcion.setText(rvo.getDescripcion());
        _TxtQueEs.setText(rvo.getQueEs());
        _TxtParaQueEs.setText(rvo.getParaQueEs());
        
        List<RelacionRefaccionProveedorVo> lpvo = this.getCoordinador().proveedoresConsultarMarcas(idRefaccion);
        HashMap<String, Object> pvoMapa = new HashMap<>();
        for (RelacionRefaccionProveedorVo vo : lpvo) {
            pvoMapa.put(vo.getProveedorVo().getEmpresa(), vo.getIdProveedor());
        }
        _ListaProveedor.cargarLista(pvoMapa);
        
        
        List<RelacionRefaccionMaquinaModeloVo> lmmvo = this.getCoordinador().maquinaModeloConsultar(idRefaccion);
        HashMap<String, Object> mmvoMapa = new HashMap<>();
        for (RelacionRefaccionMaquinaModeloVo vo : lmmvo) {
            mmvoMapa.put(vo.getMaquinaModeloVo().getModelo()
                    + " "+vo.getMaquinaModeloVo().getAnio(), 
                    vo.getIdMaquinaModelo());
        }
        _ListaMaquinaModelo.cargarLista(mmvoMapa);
        
        cargarImagenes();
        
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
    
    
       
    
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_tache.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        etiquetaProveedores.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaProveedores.setText("Proveedores");

        listaProveedores.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaProveedores.setFocusable(false);
        listaProveedores.setMinimumSize(new java.awt.Dimension(237, 9));
        listaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listaProveedores);

        etiquetaImportancia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaImportancia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaImportancia.setText("Importantancia");
        etiquetaImportancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        etiquetaMaquinas.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaMaquinas.setText("Maquinas");

        listaMaquinas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        listaMaquinas.setFocusable(false);
        listaMaquinas.setMinimumSize(new java.awt.Dimension(237, 9));
        listaMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMaquinasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listaMaquinas);

        txtStockMax.setEditable(false);
        txtStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMax.setText("012345.123");

        txtNombreDeLaRefaccion.setEditable(false);
        txtNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        txtNombreDeLaRefaccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreDeLaRefaccion.setPreferredSize(new java.awt.Dimension(40, 337));

        etiquetaDescripcion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaDescripcion.setText("Descripcion");

        jLabel1.setBackground(new java.awt.Color(98, 15, 89));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_titulo_detalle de refaccion.png"))); // NOI18N
        jLabel1.setOpaque(true);

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(1);
        txtDescripcion.setFocusCycleRoot(true);
        txtDescripcion.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(txtDescripcion);

        etiquetaCodigoInterno.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoInterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaCodigoInterno.setText("Código interno");
        etiquetaCodigoInterno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        etiquetaCodigoDelProveedor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaCodigoDelProveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaCodigoDelProveedor.setText("Código proveedor");
        etiquetaCodigoDelProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        etiquetaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaQueEs.setText("¿Que es?");

        etiquetaNombreDeLaRefaccion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaNombreDeLaRefaccion.setText("Nombre de la refacción");

        txtQueEs.setEditable(false);
        txtQueEs.setColumns(20);
        txtQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtQueEs.setLineWrap(true);
        txtQueEs.setRows(1);
        txtQueEs.setFocusCycleRoot(true);
        txtQueEs.setFocusTraversalPolicyProvider(true);
        jScrollPane2.setViewportView(txtQueEs);

        etiquetaParaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaParaQueEs.setText("¿Para que es?");

        etiquetaStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMin.setText("Stock Min");

        txtParaQueEs.setEditable(false);
        txtParaQueEs.setColumns(20);
        txtParaQueEs.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtParaQueEs.setLineWrap(true);
        txtParaQueEs.setRows(1);
        txtParaQueEs.setFocusCycleRoot(true);
        txtParaQueEs.setFocusTraversalPolicyProvider(true);
        jScrollPane7.setViewportView(txtParaQueEs);

        txtStockMin.setEditable(false);
        txtStockMin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtStockMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMin.setText("012345.123");
        txtStockMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockMinActionPerformed(evt);
            }
        });

        etiquetaStockMax.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaStockMax.setText("Stock Max");

        imagenesRefacciones.setOpaque(false);
        imagenesRefacciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenesRefaccionesMouseClicked(evt);
            }
        });

        btnSiguienteImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_siguiente.png"))); // NOI18N
        btnSiguienteImagen.setFocusable(false);
        btnSiguienteImagen.setOpaque(false);
        btnSiguienteImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteImagenActionPerformed(evt);
            }
        });

        btnRegresarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_anterios.png"))); // NOI18N
        btnRegresarImagen.setFocusable(false);
        btnRegresarImagen.setOpaque(false);
        btnRegresarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarImagenActionPerformed(evt);
            }
        });

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
                .addComponent(etiquetaNombreImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        txtExistencia.setEditable(false);
        txtExistencia.setFont(new java.awt.Font("Calibri", 0, 40)); // NOI18N
        txtExistencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtExistencia.setText("123456.321");

        etiquetaExistencia.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaExistencia.setText("Existencia");

        etiquetaDeQueEstaEcho.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        etiquetaDeQueEstaEcho.setText("¿De que esta echo?");

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
        txtUnidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUnidad.setText("012345.123");

        etiquetaParaQueEs1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        etiquetaParaQueEs1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/iconos_mas.png"))); // NOI18N
        etiquetaParaQueEs1.setText("Doble click en la imagen para ver en detalle de imagenes.");

        btnModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/imagenes/iconos_mas.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(etiquetaMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaExistencia)
                                .addGap(163, 163, 163)
                                .addComponent(etiquetaStockMin))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiquetaStockMax)))))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenesRefacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaParaQueEs1)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaCodigoDelProveedor)
                            .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaDeQueEstaEcho)
                            .addComponent(txtDeQueEstaEcho, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(etiquetaParaQueEs))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(etiquetaCodigoInterno)
                                        .addGap(178, 178, 178)
                                        .addComponent(etiquetaImportancia))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(etiquetaQueEs))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(etiquetaDescripcion)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombreDeLaRefaccion)
                    .addComponent(etiquetaDescripcion)
                    .addComponent(btnModificar))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtNombreDeLaRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaCodigoInterno)
                            .addComponent(etiquetaImportancia))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImportancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaQueEs)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(etiquetaParaQueEs))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCodigoDelProveedor)
                                .addGap(6, 6, 6)
                                .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaDeQueEstaEcho)
                                .addGap(6, 6, 6)
                                .addComponent(txtDeQueEstaEcho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaExistencia)
                            .addComponent(etiquetaStockMin))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(etiquetaStockMax)
                                    .addComponent(etiquetaParaQueEs1)))))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaProveedores)
                            .addComponent(etiquetaMaquinas))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addComponent(imagenesRefacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }    
    
    private void salir(){
        this.setVisible(false);
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
        this.getCoordinador().refaccionAbrirPanelModificar(idRefaccion);
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogoRefaccionDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoRefaccionDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoRefaccionDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoRefaccionDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoRefaccionDetalle dialog = new DialogoRefaccionDetalle();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresarImagen;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguienteImagen;
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
