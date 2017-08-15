package vista;

import controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import modelo.ExcepcionPersonalizada;

/**
 * Esta clase crea un JFrame como base para las aplicaciones e incluye dentro de 
 * su construccion varios panles que ayudan a redimencionar, establecer una barra
 * 
 * 
 * @author Rafael Ángel Ramírez Estrada
 */


public class MarcoParaVentanaPrincipal extends JFrame{
    
    
    private Coordinador coordinador;
    //LA ACCION DE ACTUALIZACION QUE SE EJECUTARA SIEMPRE ANTES DE ABRIR UN PANEL
    // SIRVE PARA LOS MENUS E ITEMS QUE SE MODIFIQUEN FUERA DEL PANEL Y
    // QUE ES NECESARIO RECARGAR PERO QUE EN EL MOMENTO NO SE PUEDE Y POR
    // TANTO HAY QUE HACERLO CUANDO EL PANEL ESTE VISIBLE. 
    // ESTA VARIABLE SOLO GUARDA LA OPERACION QUE SE TIENE QUE DEFINIR. 
    // PARA DEFINIRLA HAY QUE USAR EL CONTROLADOR. 
    private Runnable operacionActualizacion;
   
    
    //ESTE EL JSCROLL PANE QUE PERMITE QUE AL REDIMECIONAR EL JFRAME ESTE TENGA
    // LAS BARRAS DE SCROLL. A ESTE ES EL QUE HAY QUE AGREGARLE LOS JPANEL QUE
    // DISEÑEMOS PERO CON SU RESPECTIVA OPERACION.
    private ScrollPane contenedorParaPaneles;
    //EL JPANEL ACTUAL. NOS AYUDARA A CAMBIAR DE PANELES. TIENEN SUS SET Y GETS
    private MenuConstructor jPanelActual;
    //El ménu para agregar las acciones. 
    private Menu menu;
    // LA BARRA DE TITULO DE LA VENTANA CON EL FONDO DE COLOR (DEPENDE DE CUAL)
    private BarraTitulo barraTitulo;
    
    
    //ACCION DE BOTON DE INICIO.
    // ESTE BOTON DEFINE LA ACCIÓN DE LA IMAGEN DE INICIO QUE SE
    // QUIERE REALIZAR AL HACER UN CLICK.
    private Runnable accionMenuInicio;
    
    
    
    
//        /*------------------------------------------------------------
//            NOMBRAMOS LOS PANELES Y DIALOGOS CON VARIABLES ESTATICAS
//            PARA IDENTIFICARLOS Y LLAMARLOS POR FUERA. ESTE MISMO NOMBRE
//            SE MUESTRA EN LOS MENUS.
//        ------------------------------------------------------------*/
    /**
     * Nombre del panel principal donde se consultar las refacciones al 
     * iniciar el sistema.
     */
    public static String PANEL_CONSULTAR_REFACCIONES = "Consultar refacciones";
    /**
     * Nombre del panel registro de refacciones.
     */
    public static String PANEL_REGISTRAR_NUEVA_REFACCION = "Registrar nueva refacción";
    /**
     * Nombre del panel para modificar refacciones. 
     */
    public static String PANEL_MODIFICAR_REFACCION = "Modificar refacción";
    /**
     * Dialogo Imagen detalle.
     */
    public static String DIALOGO_IMAGEN_DETALLE = "Detalle de imagen";
    /**
     * Nombre del dialogo Maquina modelo agregar
     */
    public static String DIALOGO_MAQUINA_MODELO_AGREGAR = "Registrar maquina-modelo";
    /**
     * Nombre del dialogo Maquina modelo modificar
     */
    public static String DIALOGO_MAQUINA_MODELO_MODIFICAR = "Modificar maquina-modelo";
    /**
     * Nombre del dialogo proveedor registrar.
     */
    public static String DIALOGO_PROVEEDOR_REGISTRAR = "Registrar proveedor";
    /**
     * Nombre del dialogo proveedor modificar.
     */
    public static String DIALOGO_PROVEEDOR_MODIFICAR = "Modificar proveedor";
    /**
     * Nombre del dialogo refaccion detalle.
     */
    public static String DIALOGO_REFACCION_DETALLE = "Detalle refacción";
    
    
   
    /**
     * Incializa todos los parametros que requerimos para la crear la ventana que
     * contendra todos los elementos gráficos. Es la base de todo. 
     */
    public void init(){
        
        //EL TAMAÑO POR DEFECTO DE APERTURA DE LA VENTANA.
        // POR EL MOMENTO LO DEJAREMOS EN EL TAMAÑO DE LA RESOLUCIÓN 1440x900
        // QUE ES LA RESOLUCIÓN OBJETIVO PARA IMPLANTAR EN EL ALMACEN.
        
        //HAY QUE MODIFICAR LA RESOLUCÓN DESPUES PARA QUE SEA MAXIMIZADO.
        // DESCOMENTANDO LA SIGUIENTE LINEA.
        //Dimension medidasVentana = new Dimension(this.resolucion());
        
        // ESTA LINEA ES LA QUE HAY QUE QUITAR.
        Dimension medidasVentana = new Dimension(1440,900);
        //-----------------------------------------------------------
        
        //TAMAÑO MÍNIMO QUE TENDRA LA VENTANA AL REDIMENCIONARSE
        Dimension medidasVentanaMinimo = new Dimension(800, 600);
        //TAMAÑO MÁXIMO QUE TENDRA LA VENTANA AL REDIMENCIONARSE
        // (AL TAMAÑO DE LA PANTALLA)
        Dimension medidasVentanaMaximo = new Dimension(this.resolucion());
        
        
        //SETEAMOS EL TAMAÑO POR DEFECTO CON EL QUE INICIALIZARA. 
        this.setPreferredSize(medidasVentana);
        
        //ESTA CLASE ES LA QUE NOS PERMITE REDIMENCIONAR EL JFRAME.
        ComponentResizer cr = new ComponentResizer();
        //LAS MEDIDAS DEL COMPONENTE MÁXIMAS Y MÍNIMAS.
        cr.setMinimumSize(medidasVentanaMinimo);
        cr.setMaximumSize(medidasVentanaMaximo);
        cr.registerComponent(this);
        //LA CANTIDAD DE ESPACIO QUE TENEMOS QUE ARRASTRAR EL MOUSE PARA QUE 
        // EMPIEZE A REDIMENCIONAR. SE PUEDE VER TAMBIEN COMO EL BRINCO QUE DARA.
        // ENTRE MÁS ALTO SEA EL VALOR MÁS NOTORIO SERA EL SALTO. MIN = 1
        cr.setSnapSize(new Dimension(2, 2));
        
        /*------------------------------------------------------------
        INICIALIZAMOS TODOS LOS TIPOS DE CONTENEDORES QUE OCUPAMOS.
        ------------------------------------------------------------*/
        
        /* 
        ESTE PANEL ES EL CONTENEDOR DE TODOS. EN EL ESTA EL BORDE GRIS QUE
        PUSIMOS PARA ARRACTRAR LA VENTANA. 
        */
        PanelSuperContenedor panelSuperContenedor = new PanelSuperContenedor();
        /*
        CONTIENE LA BARRA DE TITULO Y EL MENU-FECHA-HORA-BOTONES DE CIERRE.
        */
        PanelEncabezado panelEncabezado = new PanelEncabezado(this);
        /*
         ESTE ES EL QUE HACE LA MAGIA DE CARGAR LOS DIFERENTES PANELES DENTRO
         DE TOODA LA ESTRUCTURA. DA LA POSIBILIDAD DE QUE EL PANEL QUE SE CARGUE
         SEA MAYOR QUE LA VENTANA Y QUE AL REDIMENCIONARSE O SER MÁS GRANDE EL 
         PANEL QUE LA SECCION DE VISUALIZCIÓN SE CREEN PANELES. LO HACEMOS GLOBAL
         PARA PODER CAMBIAR LOS PANELES DESDE UNA FUNCIÓN.
        */
        this.contenedorParaPaneles = new ScrollPane();
        /*
        LA BARRA DE MENUS. ESTA INCLUYE PROCEDIMIENTOS PARA CREAR MENUS E ITEM
        DE MANERA MÁS FÁCIL INVOCANDO LA OPERACION setMenu y setItem RESPECTIVAMENTE.
        */
        this.menu = new Menu();
        /*
        CREA LA BARRA DE TITULO DE LA VENTANA EN LA PARTE SUPERIOR Y LE ASIGNA
        SU NOMBRE. SI SE QUEIRE CAMBIAR SE PUEDE SETEAR CON LOS DEBIDOS PROCEDIMIENTOS.
        
        EL TITULO QUE SE LE ASIGNA AQUI ES QUE PREVALECERA DURANTE TODA LA APLICACIÓN.
        LOS PANELES QUE AGREGUEMOS SE AGRAGARAN AL LADO DE ESTE TITULO.
         */
        this.barraTitulo = new BarraTitulo("GESTION DE REFACCIONES");
        
        /*
        CREAMOS UN ICONO PARA LA BARRA.
        */
        URL imageURL;
        imageURL = this.getClass().getResource("imagenes/iconos_icono_principal.png");
        JLabel iconoEtiquetaPrincipal = new JLabel(new ImageIcon(imageURL));
        /**
         ASIGNAMOS LA ACCIÓN DE EJECUCIÓN DEL ICONO DE LA BARRA. 
         */
        this.accionMenuInicio = ()->this.getCoordinador().refaccionAbrirPanelConsultaRefacciones();
        iconoEtiquetaPrincipal.addMouseListener(new MouseAdapter() {
            
            Runnable r;
            public MouseAdapter parametros(Runnable r){
                this.r = r;
                return this;
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                this.r.run();
                System.out.println("[+] Ejecutando accion de menú inicio.");
            }
        }.parametros(this.accionMenuInicio));
        
        /**
         CREAMOS EL PANEL QUE CONTIENE EL RELOJ, LA FECH Y LOS BOTONES DE INTERACCIÓN
         DE LA VENTANA.
         */
        RelojYBotonesDeCierre rybdc = new RelojYBotonesDeCierre();
        
        /*
        ORDENAMOS LOS PANELES AGREGANDOLOS A SU RESPECTIVO PADRE. TENER CUIDADDO
        DE RESPETAR EL ÓRDEN QUE TIENEN PUESTO QUE AFECTA A LA ESTRUCUTRA. 
        */
        
        this.menu.add(iconoEtiquetaPrincipal);
        panelEncabezado.add(this.barraTitulo, BorderLayout.PAGE_START);
        panelEncabezado.add(this.menu, BorderLayout.SOUTH);
        panelSuperContenedor.add(panelEncabezado, BorderLayout.PAGE_START);
        panelSuperContenedor.add(this.contenedorParaPaneles);
        this.add(panelSuperContenedor);
        
//        /*------------------------------------------------------------
//            CREAMOS LOS MENUS DE LA BARRA DE MENUS
//            ===================
//            EJEMPLO DE CREACION
//            ===================
//            
//            COMENTAR ESTAS LINEAS CUANDO SE IMPLEMENTE EL SISTEMA.
//        ------------------------------------------------------------*/
//
//        MenuConstructor mArchivo = new MenuConstructor();
//        mArchivo.setMenu();
//        mArchivo.setNombre("Cambiar Modulos");
//        mArchivo.setImagen("imagenes/iconos_siguiente.png");
//        
//        MenuConstructor mArchivo1 = new MenuConstructor();
//        mArchivo1.setMenu();
//        mArchivo1.setNombre("otro menu");
//        mArchivo1.setImagen("imagenes/iconos_siguiente.png");
//        mArchivo1.setPadre(mArchivo);
//        
//        MenuConstructor p1 = new MenuConstructor();
//        p1.setItem();
//        p1.setNombre("Agregar Empresa");
//        p1.setPanel(this.coordinador.getFormulario());
//        p1.setImagen("imagenes/iconos_mas.png");
//        p1.setPadre(mArchivo);
//        
//        MenuConstructor p2 = new MenuConstructor();
//        p2.setItem();
//        p2.setNombre("Ventana Roja");
//        p2.setPanel(this.coordinador.getPanelPrimeraVentana());
//        p2.setImagen("imagenes/iconos_palomita.png");
//        p2.setPadre(mArchivo);
//        
//      
//        MenuConstructor p3 = new MenuConstructor();
//        p3.setItem();
//        p3.setNombre("Accion directa");
//        p3.setImagen("imagenes/iconos_icono_principal.png");
//        p3.setAccionDelItem(()->this.accion("accion directa"));
//        p3.setPadre(mArchivo1);
//        
//        //AÑADIMOS TODOS LOS MENUS.
//        this.addItemOMenu(mArchivo);
//        this.addItemOMenu(mArchivo1);
//        this.addItemOMenu(p1);
//        this.addItemOMenu(p2);
//        this.addItemOMenu(p3);



//        /*------------------------------------------------------------
//            NOMBRAMOS LOS PANELES CON VARIABLES ESTATICAS
//            PARA IDENTIFICARLOS Y LLAMARLOS POR FUERA. SOLO PANELES.
//        ------------------------------------------------------------*/
        
        //LA OPERACION GENERAL DE ACTUALIZACION
        operacionActualizacion = ()->this.getCoordinador().ejecutarOperacionesParaActualizar();
        
        /**
         * /////////////////////////////////////////////////
         *      CREAMOS LOS MENUS
         * /////////////////////////////////////////////////
         */
        MenuConstructor menuAgregarRegistrar = new MenuConstructor();
        menuAgregarRegistrar.setMenu();
        menuAgregarRegistrar.setNombre("Agregar/Registrar");
        this.addItemOMenu(menuAgregarRegistrar);
        
        MenuConstructor menuModificar = new MenuConstructor();
        menuModificar.setMenu();
        menuModificar.setNombre("Modificar");
        this.addItemOMenu(menuModificar);
        
        MenuConstructor menuConsultar = new MenuConstructor();
        menuConsultar.setMenu();
        menuConsultar.setNombre("Consultar");
        this.addItemOMenu(menuConsultar);
        
        /**
         * /////////////////////////////////////////////////
         *      MENU CONSULTAR
         * /////////////////////////////////////////////////
         */
        MenuConstructor panelConsultaRefacciones = new MenuConstructor();
        panelConsultaRefacciones.setItem();
        panelConsultaRefacciones.setNombre(PANEL_CONSULTAR_REFACCIONES);
        panelConsultaRefacciones.setPanel(this.getCoordinador().getPanelConsultaRefacciones());
        panelConsultaRefacciones.setPadre(menuConsultar);
        panelConsultaRefacciones.setAccionDeInicializacion(
                ()->this.getCoordinador().getPanelConsultaRefacciones().configurar());
        this.addItemOMenu(panelConsultaRefacciones);
        
        
        Coordinador.OperacionesPorActualizar consultaRefaccionesOPA 
                = getCoordinador().new OperacionesPorActualizar();
        consultaRefaccionesOPA.setPanel(panelConsultaRefacciones);
        consultaRefaccionesOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().refaccionActualizarPanelConsultaRefacciones());
        this.getCoordinador().addListaOperacionesPorActualizar(consultaRefaccionesOPA);
        
        //-------------------------------
        MenuConstructor dialogoRefaccionDetalle = new MenuConstructor();
        dialogoRefaccionDetalle.setItem();
        dialogoRefaccionDetalle.setNombre(DIALOGO_REFACCION_DETALLE);
        dialogoRefaccionDetalle.setPadre(menuConsultar);
        dialogoRefaccionDetalle.setAccionDelItem(
                ()->this.getCoordinador().refaccionAbrirDetalleRefaccion());
        dialogoRefaccionDetalle.setDialog(this.getCoordinador().getDialogoMaquinaModeloModificar());
        this.addItemOMenu(dialogoRefaccionDetalle);
        
        Coordinador.OperacionesPorActualizar dialogoRefaccionDetalleOPA 
                = getCoordinador().new OperacionesPorActualizar();
        dialogoRefaccionDetalleOPA.setPanel(dialogoRefaccionDetalle);
        dialogoRefaccionDetalleOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().refaccionMostrarDetalleActualizarImagenes());
        this.getCoordinador().addListaOperacionesPorActualizar(dialogoRefaccionDetalleOPA);
        
        /**
         * /////////////////////////////////////////////////
         *      MENU AGREGAR-REGISTRAR
         * /////////////////////////////////////////////////
         */
        
        MenuConstructor registroRefacciones = new MenuConstructor();
        registroRefacciones.setItem();
        registroRefacciones.setNombre(PANEL_REGISTRAR_NUEVA_REFACCION);
        registroRefacciones.setPanel(this.getCoordinador().getPanelRefaccionAgregar());
        registroRefacciones.setPadre(menuAgregarRegistrar);
        registroRefacciones.setAccionDeInicializacion(
                ()->this.getCoordinador().getPanelRefaccionAgregar().configurar());
        this.addItemOMenu(registroRefacciones);
        
        Coordinador.OperacionesPorActualizar registroRefaccionesOPA 
                = getCoordinador().new OperacionesPorActualizar();
        registroRefaccionesOPA.setPanel(registroRefacciones);
        registroRefaccionesOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().refaccionActualizarPanelAgregarRefaccion());
        this.getCoordinador().addListaOperacionesPorActualizar(registroRefaccionesOPA);
        
        //-------------------------------
        MenuConstructor dialogoProveedorRegistrar = new MenuConstructor();
        dialogoProveedorRegistrar.setItem();
        dialogoProveedorRegistrar.setNombre(DIALOGO_PROVEEDOR_REGISTRAR);
        dialogoProveedorRegistrar.setPadre(menuAgregarRegistrar);
        dialogoProveedorRegistrar.setAccionDelItem(
                ()->this.getCoordinador().proveedorAbrirDialogoGuardarNuevo());
        dialogoProveedorRegistrar.setDialog(this.getCoordinador().getDialogoProveedorRegistrar());
        this.addItemOMenu(dialogoProveedorRegistrar);
        
        Coordinador.OperacionesPorActualizar dialogoProveedorRegistrarOPA 
                = getCoordinador().new OperacionesPorActualizar();
        dialogoProveedorRegistrarOPA.setPanel(dialogoProveedorRegistrar);
        dialogoProveedorRegistrarOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().refaccionActualizarPanelAgregarRefaccion());
        this.getCoordinador().addListaOperacionesPorActualizar(dialogoProveedorRegistrarOPA);
        
         //-------------------------------
        MenuConstructor dialogoMaquinaModeloAgregar = new MenuConstructor();
        dialogoMaquinaModeloAgregar.setItem();
        dialogoMaquinaModeloAgregar.setNombre(DIALOGO_MAQUINA_MODELO_AGREGAR);
        dialogoMaquinaModeloAgregar.setPadre(menuAgregarRegistrar);
        dialogoMaquinaModeloAgregar.setAccionDelItem(
                ()->this.getCoordinador().maquinaModeloAbrirDialogoAgregar());
        dialogoMaquinaModeloAgregar.setDialog(this.getCoordinador().getDialogoMaquinaModeloAgregar());
        this.addItemOMenu(dialogoMaquinaModeloAgregar);
        
        Coordinador.OperacionesPorActualizar dialogoMaquinaModeloAgregarOPA 
                = getCoordinador().new OperacionesPorActualizar();
        dialogoMaquinaModeloAgregarOPA.setPanel(dialogoMaquinaModeloAgregar);
        dialogoMaquinaModeloAgregarOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().maquinaModeloActualizarDialogoAgregar());
        this.getCoordinador().addListaOperacionesPorActualizar(dialogoMaquinaModeloAgregarOPA);
        
        /**
         * /////////////////////////////////////////////////
         *      MENU MODIFICAR
         * /////////////////////////////////////////////////
         */
        
        MenuConstructor modificarRefaccion = new MenuConstructor();
        modificarRefaccion.setItem();
        modificarRefaccion.setNombre(PANEL_MODIFICAR_REFACCION);
        modificarRefaccion.setPanel(this.getCoordinador().getPanelRefaccionModificar());
        modificarRefaccion.setPadre(menuModificar);
        modificarRefaccion.setSiempreAccionInicializada(true);
        modificarRefaccion.setAccionDeInicializacion(
                ()->this.getCoordinador().refaccionAbrirPanelModificar());
        this.addItemOMenu(modificarRefaccion);

        Coordinador.OperacionesPorActualizar modificarRefaccionOPA 
                = getCoordinador().new OperacionesPorActualizar();
        modificarRefaccionOPA.setPanel(modificarRefaccion);
        modificarRefaccionOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().refaccionActualizarPanelAgregarRefaccion());
        this.getCoordinador().addListaOperacionesPorActualizar(modificarRefaccionOPA);
        
        //-------------------------------
        MenuConstructor dialogoProveedorModificar = new MenuConstructor();
        dialogoProveedorModificar.setItem();
        dialogoProveedorModificar.setNombre(DIALOGO_PROVEEDOR_MODIFICAR);
        dialogoProveedorModificar.setPadre(menuModificar);
        dialogoProveedorModificar.setAccionDelItem(
                ()->this.getCoordinador().proveedoresAbrirDialogoModificar());
        dialogoProveedorModificar.setDialog(this.getCoordinador().getDialogoProveedorModificar());
        this.addItemOMenu(dialogoProveedorModificar);
        
        Coordinador.OperacionesPorActualizar dialogoProveedorModificarOPA 
                = getCoordinador().new OperacionesPorActualizar();
        dialogoProveedorModificarOPA.setPanel(dialogoProveedorModificar);
        dialogoProveedorModificarOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().proveedorDialogoModificarActualizarListaProveedores());
        dialogoProveedorModificarOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().proveedorDialogoModificarActualizarPais());
        dialogoProveedorModificarOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().proveedorDialogoModificarActualizarImagenes());
        this.getCoordinador().addListaOperacionesPorActualizar(dialogoProveedorModificarOPA);
        
        //-------------------------------
        MenuConstructor dialogoModificarMaquinaModelo = new MenuConstructor();
        dialogoModificarMaquinaModelo.setItem();
        dialogoModificarMaquinaModelo.setNombre(DIALOGO_MAQUINA_MODELO_MODIFICAR);
        dialogoModificarMaquinaModelo.setPadre(menuModificar);
        dialogoModificarMaquinaModelo.setAccionDelItem(
                ()->this.getCoordinador().maquinaModeloAbrirDialogoModificar());
        dialogoModificarMaquinaModelo.setDialog(this.getCoordinador().getDialogoMaquinaModeloModificar());
        this.addItemOMenu(dialogoModificarMaquinaModelo);
        
        Coordinador.OperacionesPorActualizar modificarMaquinaModeloOPA 
                = getCoordinador().new OperacionesPorActualizar();
        modificarMaquinaModeloOPA.setPanel(dialogoModificarMaquinaModelo);
        modificarMaquinaModeloOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().maquinaModeloActualizarDialogoModificar());
        this.getCoordinador().addListaOperacionesPorActualizar(modificarMaquinaModeloOPA);
        
        //-------------------------------
        MenuConstructor dialogoImagenDetalle = new MenuConstructor();
        dialogoImagenDetalle.setItem();
        dialogoImagenDetalle.setNombre(DIALOGO_IMAGEN_DETALLE);
        dialogoImagenDetalle.setPadre(menuConsultar);
        dialogoImagenDetalle.setAccionDelItem(
                ()->this.getCoordinador().refaccionAbrirDetalleRefaccion());
        dialogoImagenDetalle.setDialog(this.getCoordinador().getDialogoImagenDetalle());
        this.addItemOMenu(dialogoImagenDetalle);
        
        Coordinador.OperacionesPorActualizar dialogoImagenDetalleOPA 
                = getCoordinador().new OperacionesPorActualizar();
        dialogoImagenDetalleOPA.setPanel(dialogoImagenDetalle);
        dialogoImagenDetalleOPA.addOperacionParaActualizar(
                ()->this.getCoordinador().refaccionMostrarDetalleActualizarImagenes());
        this.getCoordinador().addListaOperacionesPorActualizar(dialogoImagenDetalleOPA);
       
        
        
        //AÑADIMOS LOS DIALOGOS.
       
       
        
       
        
       
        
        //GENERAMOS EL MENU.
        this.generarMenus();
        
        //ASIGNAMOS EL PANEL QUE ABRIRA POR DEFECTO
        this.setJPanelActual(panelConsultaRefacciones);
        
        /*
        ------------------------------------------------------------
            CREAMOS LOS MENUS DE LA BARRA DE MENUS
            ===============================
            FIN DE LOS EJEMPLOS DE CREACION
            ===============================
        ------------------------------------------------------------
        */
        
        /**
         ASIGNAMOS LA VENTANA PRINCIPAL AL PANEL DE BOTONES, RELOJ Y FECHA PARA 
         * QUE LOS BOTONES INTERECTUEN CON ELLA. SI NO LO HACEMOS NOS MANDARA
         * ERROR DE NULL POINTER EXCEPTION. 
         */
        rybdc.setVentanaPrincipal(this);
        //ASIGMAMOS LOS BOTONES. IMPORTANTE POR QUE SI NO NO FUNCIONAN. 
        rybdc.asignarAcciones();
        //AÑADIMOS EL PANEL AL MENU.
        this.menu.add(rybdc);

        /*------------------------------------------------------------
            CONFIGURACIONES BÁSICAS PARA EL JFRAME. 
        ------------------------------------------------------------*/
        this.dispose();
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
       
        /*
        NECESITAMOS EMPACAR PARA QUE TODOS LOS CAMBIOS EN LOS PANELES FUNCIONEN.
        */
        this.pack();
        this.setLocationRelativeTo(null);
        //ESTA LINEA HACE QUE SE TERMINE COMPLETAMENTE LA EJECUCIÓN CUANDO
        // SE CIERRA LA VENTANA DESDE LA BARRA. 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    /**
     * SOLO PARA EL EJEMPLO DE LOS MENUS. NO BORRAR
     */
    private void accion(String texto){
        JOptionPane.showMessageDialog(null, texto);
    
    }
    
    /**
     * Setea el panel que se le pase como parametro en la ventana principal.
     * Es necesario llamar a las variables estáticas de MarcoParaVentana para 
     * definirlo. Si se crea un panel nuevo hay que crear tambian su variable
     * estática. Hay que tener cuidado con los nombres puesto que tambien busca
     * dentro de los items. 
     * @param panel El nombre del panel que tiene que ser dato por una variable
     * estática para mantener el órden.
     */
    public void setJPanelActual(String panel){
        for (MenuConstructor p : menuConstructorLista) {
            if (p.getNombre().equals(panel)) {
                this.setJPanelActual(p);
                break;
            }
        }
    }
    
    /**
     * El coordinador del sistema.  
     * @return El jefe de jefes, señores!
     */
    public Coordinador getCoordinador() {
        return coordinador;
    }
    
    /**
     *Setea al coordinador del sistema.  
     * @param coordinador El jefe de jefes, señores!
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    /**
     * Retorna la resolucion actual de la pantalla. 
     * @return  La resolución de la pantalla. 
     */
    public Dimension resolucion(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Retorna el panel que se esta mostrando actualmente. 
     * @return El panel que se esta manejando en un tipo MenuConstructor. 
     * @see MenuConstructor
     */
    public MenuConstructor getjPanelActual() {
        if (this.jPanelActual==null) {
            try {
                throw new ExcepcionPersonalizada("No seteaste el panel actual.", this, "getjPanelActual");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return jPanelActual;
    }

    /**
     * Setea el panel que se quiere mostrar en la ventana principal. Dentro de
     * esta opración se define el viewPortView del JScrollPane que se construyo
     * dentro del JFrame y el titulo que se desplegara en la ventana.
     * @param nuevoJPanel - El panel que queremos pasarle a la ventana.
     */
    //public void setJPanelActual(JPanel nuevoJPanel) {
    public void setJPanelActual(MenuConstructor nuevoJPanel) {
        //SI EXISTE UN PANEL ACTUAL LO REMOVEMOS DEL contenedorParaPaneles.
        if(this.jPanelActual != null){
            this.contenedorParaPaneles.remove(this.jPanelActual.getThisPanel());
        }
        //COLOCAMOS EL PANEL NUEVO.
        this.contenedorParaPaneles.setViewportView(nuevoJPanel.getThisPanel());
        //CAMBIAMOS EL TITULO DE LA VENTANA EN LA BARRA.
        this.barraTitulo.setTitulo(nuevoJPanel.getNombre());
        //SETEAMOS EL PANEL NUEVO PARA DESPUES ELIMINARLO.
        this.jPanelActual = nuevoJPanel;
        if (!this.jPanelActual.isAccionInicializacionEjecutada()) {
            this.jPanelActual.getAccionInicializacion().run();
            this.jPanelActual.setAccionInicializacionEjecutada(true);
        }
        
    }
            
    /**
     * Crea la barra de titulo con color que se muestra a en la parte superior
     * de la ventana.
     */
    class BarraTitulo extends JPanel{
        
        private String titulo;
        private String tituloPrincipal;
        JLabel etiqueta;
       
        public BarraTitulo(String titulo) {
            //CREAMOS LA ETIQUETA PARA EL TITULO.
            etiqueta = new JLabel(this.getTitulo());
            //COLOR DE LA LETRA.
            etiqueta.setForeground(Color.WHITE);
            //AL CONSTRUIR SETEAMOS EL TITULO.
            tituloPrincipal = titulo;
            setTitulo("");
            //AÑADIMOS LA ETIQUETA AL PANEL.
            setLayout(new GridLayout());
            
            add(etiqueta);
            
            setPreferredSize(new Dimension(this.getWidth(), 16));
            //LE DAMOS EL COLORCITO AZUL
            setBackground(new Color(0,158,227));
        }
        /*
        * El título que llevara la ventana. 
        */
        public String getTitulo() {
            return "  "+titulo;
        }

        public void setTitulo(String titulo) {
            this.etiqueta.setText("    "+this.tituloPrincipal+" / "+titulo);
            this.titulo = titulo;
        }
    }
    
    class Menu extends JMenuBar{
        List<ElementoItemOMenu> elementoItemOMenuLista = new ArrayList<ElementoItemOMenu>();

        /**
         * Creamos los items que necesitemos y los guardamos para despues 
         * asignarlos con generarMenu(). 
         * 
         * @param padre El menu padre del elemento.
         * @param nombre El nombre de la etiqueta.
         * @param accion La accion que va a ejecutar. 
         * @param imagen Icono que se mostrara al lado del item o menu.
         * @see this.setMenu()
         */
        public void setItem(String padre, String nombre, Runnable accion, String imagen){
        
            try {
                if (accion == null) {
                    throw new ExcepcionPersonalizada("No definiste la accion.", this, "setItem");
                }else if(nombre == null){
                    throw new ExcepcionPersonalizada("No definiste un nombre para el item.", this, "setItem");
                }
                
                this.agregarMenuEItem(padre, nombre, accion, imagen);
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Creamos los menus que necesitemos y los guardamos para despues 
         * asignarlos con generarMenu().
         * 
         * @param padre El menu padre del elemento. Si es raíz se deja en null
         * @param nombre El nombre de la etiqueta.
         * @param imagen Icono que se mostrara al lado del item o menu.
         * @sett this.setItem()
         */
        
        public void setMenu(String padre, String nombre, String imagen){
            //NO SE PUEDE CREAR UN MENU SIN SU NOMBRE. ES LO QUE LO IDENTIFICA
            try {
                if(nombre == null){
                    throw new ExcepcionPersonalizada("No definiste un nombre para el menu.", this, "setMenu");
                }
               
                this.agregarMenuEItem(padre, nombre, null, imagen);
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Creamos los menus y los items que necesitemos y los guardamos dentro 
         * de la lista elementoItemIMenuLista para despues asignarlos con generarMenu().
         * 
         * @param padre El menu padre del elemento. Poner null si es raiz.
         * @param nombre El nombre de la etiqueta.
         * @param accion La accion que va a ejecutar. 
         * @param imagen Icono que se mostrara al lado del item o menu.
         * 
         */
        private void agregarMenuEItem(String padre, String nombre, Runnable accion, String imagen){
            //CONTENEDOR DE TODOS LOS ELEMENTOS DEL MENU
            ElementoItemOMenu elemento = new ElementoItemOMenu();
            
            //CREAMOS LA URL PARA GUARDAR LA IMAGEN. SI SE PONE EN NULL ENTONCES
            // CREAMOS UNA NUEVA URL VACIA PARA QUE NO HAYA ERRORES.
            URL imageURL;
            if (imagen !=null) {
                imageURL = this.getClass().getResource(imagen);
            }else{
                imageURL = this.getClass().getResource("");
            }
            //OBJETO PARA CARGAR EN EL MENU O ITEM LA IMAGEN.
            ImageIcon image = new ImageIcon(imageURL);
            
            //SI NO HAY ACCIONES DEFINIDAS QUIERE DECIR QUE ES UN MENU.
            if (accion == null) {
                //CREAMOS UN OBJETO TIPO JMenu.
                JMenu menu = new JMenu(nombre);
                //ASIGNAMOS LA IMAGEN AL MENU.
                menu.setIcon(image);
                //SETEAMOS EL MENU DENTRO DEL ELEMENTO CONTENEDOR GENERALIZANTE.
                elemento.setMenu(menu);
            }else{
                //DADO QUE SI SE DEFINIO UNA ACCIÓN SUPONEMOS QUE ES UN ITEM Y 
                // UN OBJETO JMenuItem.
                JMenuItem item = new JMenuItem(nombre);
                //ASIGAMOS LA IMAGEN QUE LO ACOMPAÑARA.
                item.setIcon( image);
                //AÑADIMOS LA ACCION QUE QUEREMOS QUE EJECUTE EL ITEM.
                // SOLO EN mousePressed.
                item.addMouseListener( new MouseAdapter() {
                    //LA ACCION
                    Runnable accion;
                    Runnable aPerpetua;
                    //EL PROCEDIMIENTO PARA PASAR A LA FUNCION ANOMINA EL PARAMETRO
                    // DESEADO.
                    public MouseListener parametros(Runnable accion, Runnable a){
                        this.accion = accion;
                        this.aPerpetua = a;
                        return this;
                    }
                    
                    @Override
                    public void mousePressed(MouseEvent e) {
                        //AL PRESIONAR EL ELEMENTO SE EJECUTA LA ACCIÓN.
                        this.accion.run();
                    }
                    
                    @Override
                    public void mouseReleased(MouseEvent e){
                        aPerpetua.run();
                    
                    }

                }.parametros(accion, operacionActualizacion));
                //AÑADIMOS EL ITEM AL ELEMENTO GENRALIZANTE. 
                elemento.setItem(item);
            }
            //EL NOMBRE DEL ELEMENTO QUE SE MOSTRARA.
            elemento.setNombre(nombre);
            //EL NOMBRE DEL PADRE PARA SABER A QUE MENU PERTENECE.
            elemento.setPadre(padre);
            
            //AÑADIMOS EL ELEMENTO QUE GUARDA EL ITEM O MENU A LA LISTA PARA 
            // DESPUES GENERARLOS CON generarMenu();
            this.elementoItemOMenuLista.add(elemento);
        }
        
        /**
         * Genera el menu despues de que se cargaron los elementos que contendra
         * con agregarMenu()
         */
        public void generarMenu(){
            //SI LA LISTA ESTA VACIA MOSTRAMOS ERROR.
            if (elementoItemOMenuLista.isEmpty()) {
                try {
                    throw new ExcepcionPersonalizada(
                            "No has definido ningún elemento"
                          + " para el menu.", this, "generarMenu");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //CREO QUE ESTA PARTE ES SEMI RECURSIVA. LLAMAMOS A LA FUNCION menusContinuos
            // CADA VES QUE TENEMOS UN ELEMENTO RAÍZ Y ESTA LLAMA A menusContinuos
            // QUE REVISA PARA CADA ELEMENTO DE LA LISTA SI EXISTE UN HIJO Y 
            // LO ASIGNA. 
            for (ElementoItemOMenu elementoItemOMenu : elementoItemOMenuLista) {
                //SI EL ELEMENTO QUE ESTAMOS REVISANDO NO TIENE PADRE QUIERE 
                // DECIR QUE VA EN LA RAÍZ. SI ES UN MENU SE CREA MENU, SI ES 
                // UN ITEM SE CREA UN ITEM! xp
                if (elementoItemOMenu.getPadre() == null) {
                    //SI NO ES MENU QUIERE DECIR QUE ES ITEM
                    if (elementoItemOMenu.menu != null) {
                        this.add(elementoItemOMenu.getMenu());
                    }else{
                        this.add(elementoItemOMenu.getItem());
                    }
                }
                //LLAMAMOS A LA FUNCION menusContinuos PARA COMPROBAR TODOS
                // LOS HIJOS QUE TIENE EL elementoItemMenu QUE EXTRAJIMOS DE
                // LA LISTA.
                this.menusContinuos(elementoItemOMenu);
            }
        }
    
        private void menusContinuos(ElementoItemOMenu elementoAComparar){
            // REVISA TODOS LOS ELEMENTOS QUE AÑADIMOS PARA CREAR LOS SUB MENUS.
            for (ElementoItemOMenu subEIM : elementoItemOMenuLista) {
                /*
                SI EL NOMBRE DEL ELEMENTO QUE LE PASAMOS A ESTA FUNCION 
                ES IGUAL A ALGUNO DE LOS ELEMENTOS QUE TENEMOS EN LA LISTA DE
                ITEMS O MENUS SIGNIFICA QUE subEIM ES HIJO de elementoAComparar.
                */
                if (elementoAComparar.getNombre().equals(subEIM.getPadre())) {
                    //SI subEIM TIENE ITEM CREADO SE TOMA SU ITEM Y SE AGREGA
                    // COMO HIJO DEL elementoAComparar.
                    if (subEIM.getItem() != null) {
                        elementoAComparar.getMenu().add(subEIM.getItem());
                    }
                    // SI EL ELEMENTO ES UN MENU ENTONCES SE AGREGA COMO MENU
                    //HIJO DE elementoAcomparar.
                    if (subEIM.getMenu() != null) {
                        elementoAComparar.getMenu().add(subEIM.getMenu());
                    }
                }
            }
        }
        
        /**
         * Crea un objeto item o menu para despues utilizarlo. 
         * No hay mucho que explicar.
         */
        private class ElementoItemOMenu{
            
            private JMenuItem item;
            private JMenu menu;
            private String padre;
            private String nombre;

            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public JMenuItem getItem() {
                return item;
            }

            public void setItem(JMenuItem item) {
                this.item = item;
            }

            public JMenu getMenu() {
                return menu;
            }

            public void setMenu(JMenu menu) {
                this.menu = menu;
            }

            public String getPadre() {
                return padre;
            }

            public void setPadre(String padre) {
                this.padre = padre;
            }
        
        }
        
    }
    
    /***
     * Creamos los botones y las opciones para la fecha y configuraciones
     * del menu de la ventana incluyendo las acciones que tomaran los botones
     * de minimizar. 
     */
    class RelojYBotonesDeCierre extends JPanel{

        private JButton cerrarBtn;
        private JButton minimizarBtn;
        private JButton maximizarBtn;
        private JButton encimaBtn;

        private JFrame ventanaPrincipal;

        public RelojYBotonesDeCierre() {


            //EL PANEL QUE CONTENDRA EL RELOJ.
            JPanel reloj = new JPanel();

            //EL PANEL QUE CONTENDRA LOS BOTONES DE CIERRE Y APERTURA.
            JPanel botones = new JPanel();

            //LLAMAMOS A LA CLASE FECHA Y HORA Y LAS AGREGAMOS A SUS PANELES.
            FechaYHora fechaHora = new FechaYHora();
            JLabel hora = new JLabel();
            JLabel fecha = new JLabel();
            JLabel relleno= new JLabel("-");

            fechaHora.setEtiquetaHora(hora);
            fechaHora.setEtiquetaFecha(fecha);
            
            Font fuenteFechaYHora = new Font("Arial", 0, 21);
            hora.setFont(fuenteFechaYHora);
            fecha.setFont(fuenteFechaYHora);

            reloj.add(fecha);
            reloj.add(relleno);
            reloj.add(hora);

            //CREAMOS LOS BOTONES QUE LLEVARAN PARA CIEERE
            this.cerrarBtn = new JButton("X");
            this.minimizarBtn = new JButton("_");
            this.maximizarBtn = new JButton("█");
            this.encimaBtn = new JButton("ENCIMA");
            
            //NO FOCUSABLES
            this.cerrarBtn.setFocusable(false);
            this.minimizarBtn.setFocusable(false);
            this.maximizarBtn.setFocusable(false);
            this.encimaBtn.setFocusable(false);
            
            
            //FUENTE
            Font fuenteBotones = new Font("Arial", 0, 7);
            this.cerrarBtn.setFont(fuenteBotones);
            this.minimizarBtn.setFont(fuenteBotones);
            this.maximizarBtn.setFont(fuenteBotones);
            this.encimaBtn.setFont(fuenteBotones);
            
            //AGREGAMOS AL JPANEL BOTONES LOS BOTONES.
            botones.add(encimaBtn);
            botones.add(minimizarBtn);
            botones.add(maximizarBtn);
            botones.add(cerrarBtn);
            
            //LOS LAYOUT PARA DAR ORDEN
            this.setLayout(new FlowLayout(FlowLayout.TRAILING));
            reloj.setLayout(new FlowLayout(FlowLayout.LEFT));
            botones.setLayout(new FlowLayout(FlowLayout.RIGHT));
            
            //MEDIDAS DE LOS PANELES. 
            reloj.setPreferredSize(new Dimension(380, 35));
            botones.setPreferredSize(new Dimension(215, 35));

            //AGREGAMOS LOS PANELES AL PANEL QUE LOS VA A CONTENER.
            this.add(reloj);
            this.add(botones);

        }
        
        public JFrame getVentanaPrincipal() {
            return ventanaPrincipal;
        }

        
        /**
         * Seteamos la ventana principal para fines de acomdoo. 
         */
        public void setVentanaPrincipal(JFrame ventanaPrincipal) {
            this.ventanaPrincipal = ventanaPrincipal;
        }
        
        /**
         * La acción que se ejecutara al minimizar.  
         */
        private void minimizar(){
            try {
                if(this.ventanaPrincipal ==null){
                        throw new ExcepcionPersonalizada("No has seteado la ventana principal", this, "minimizar");
                }
      
                this.ventanaPrincipal.setExtendedState(ICONIFIED);
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        /*
        PARA MAXIMIZAR Y MINIMIZAR ES NECEARIO GUARDAR EL TAMAÑO DE LA VENTANA
        ANTES DE EJECUTAR LA ACCIÓN. EN ESTE CASO SOLO A LA HORA DE MAXIMIZAR. 
        
        LA VARIABLE tamanoantesDeMaximizar SE ENCARGA DE ALMACENAR EL TAMAÑO
        QUE TENIA LA VENTANA ANTES DE MAXIMIZARSE PARA LUEGO RECUPERARLO AL MAXI-
        MIZARSE.
        
        estaMaximzado ES PARA SABER EL ESTADO DE LA VENTANA Y EN CASO DE QUE
        SE DESMAXIMIZE RETORNE AL TAMAÑO QUE ORIGINALMENTE TENIA.
        
        TAMBIEN ES NESARIO QUE posicion SE GUARDE PARA QUE NO SE MUEVA LA VENTANA
        A LA EZQUINA SUPERIOR IZQUIERDA CADA VEZ. 
        
        */
        Dimension tamanoAntesDeMaximizar;
        Point posicion;
        boolean estaMaximizado = false;
        private void maximizar(){
            try {
                //NECESARIA LA VENTANA PRINCIPAL SETEADA PARA QUE FUNCIONE.
                if(this.ventanaPrincipal ==null){
                        throw new ExcepcionPersonalizada("No has seteado la ventana principal", this, "maximizar");
                }
                //EN CASO DE QUE ESTE MAXIMIZADO EJECUTEMOS LO SIGUIEINTE. 
                if (this.estaMaximizado) {
                    this.ventanaPrincipal.setSize(tamanoAntesDeMaximizar);
                    this.ventanaPrincipal.setLocation(posicion);
                    this.estaMaximizado = false;
                }else{
                    //SI NO ESTA MAXIMIZADO GUARDAMOS LOS DATOS NECESARIOS.
                    this.tamanoAntesDeMaximizar = new Dimension(this.ventanaPrincipal.getSize());
                    this.posicion = new Point(this.ventanaPrincipal.getLocationOnScreen());
                    this.ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    this.estaMaximizado = true;
                }
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /*
        EL BOTON DE ENCIMA PERMITE A LA VENTANA PERMANECER SOBRE TODAS LAS DEMAS.
        PARA QUE EL USUARIO DISTINGA QUE ESTA ACTIVO SE COLOREA MIENTRAS
        ESTE FUNCIONANDO.
        */
        Color colorEncimaBtn;
        private void encima(){
            try {
                //NO FUNCIONA SI LA VENTANA PRINCIPAL NO ESTA SETEADA. 
                if(this.ventanaPrincipal ==null){
                        throw new ExcepcionPersonalizada("No has seteado la ventana principal", this, "encima");
                }
                //SI LA VENTANA YA ESTA alwaysOnTop QUITAMOS TODO. 
                if (this.ventanaPrincipal.isAlwaysOnTop()) {
                    this.encimaBtn.setForeground(this.colorEncimaBtn);
                    this.ventanaPrincipal.setAlwaysOnTop(false);
                }else{
                    //SI NO ESTA ENTONCES GUARDAMOS LOS DATOS NECESARIOS. 
                    this.colorEncimaBtn = this.encimaBtn.getForeground();
                    Color activado = new Color(200,200,0);
                    this.encimaBtn.setForeground(activado);
                    this.ventanaPrincipal.setAlwaysOnTop(true);
                }
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        /*
        ESTA NO TIENE MUCHO CHISTE, PERO SI SE QUIERE DEFINIR ALGÚNA ACCIÓN
        ANTES DE CERRAR CERÁ AQUI.
        */
        private void cerrar(){
            JOptionPane.showMessageDialog(this.getVentanaPrincipal(), "sin definir");
                System.exit(0);
        }

        /**
         * Asigna las acciones para los botones de interacción de la ventana
         * que previamente fueron seteados. Sin este las acciones sobre los botones
         * no existen.
         * 
         */
        public void asignarAcciones(){
            this.asignarAccionABoton(this.minimizarBtn, ()->this.minimizar());
            this.asignarAccionABoton(this.maximizarBtn, ()->this.maximizar());
            this.asignarAccionABoton(this.encimaBtn, ()->this.encima());
            this.asignarAccionABoton(this.cerrarBtn, ()->this.cerrar());
        }
        
        /**
         * Esta función asigna las operaciones correpondientes a cada boton 
         * de control de la ventana.
         */
        private void asignarAccionABoton(Component componente, Runnable accion){
            componente.addMouseListener(new MouseListener() {
                
                Runnable accion;
                MouseListener parametros(Runnable accion){
                    this.accion = accion;
                    return this;
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                  
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    this.accion.run();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            }.parametros(accion));
        }
    }

    /**
    * Maneja la fecha y la hora. Entrega diferentes versiones del mismo y 
    * tambien brinda algúnas otras utilidades.
    * @author Rafael Ángel Ramírez Estrada
    */
    public class FechaYHora implements Runnable {

       private Thread hilo1;
       private JLabel etiquetaHora;
       private JLabel etiquetaFecha;

       public FechaYHora()  {
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
           Date hora = new Date();
           DateFormat horaFormateada = new SimpleDateFormat("HH:mm:ss");
           this.etiquetaHora.setText(horaFormateada.format(hora));
       }
       
       /**
        * Crea el formato y cargar la equiteta dispuesta para la fecha. 
        */
       public void fechaCompleta(){
           String diaCompleto, dia, mesCompleto, anio;

           Date date = new Date();
           HashMap<String, String> meses = new HashMap();
           meses.put("1", "Enero");
           meses.put("2", "Febrero");
           meses.put("3", "Marzo");
           meses.put("4", "Abril");
           meses.put("5", "Mayo");
           meses.put("6", "Junio");
           meses.put("7", "Julio");
           meses.put("8", "Agosto");
           meses.put("9", "Septiembre");
           meses.put("10", "Octubre");
           meses.put("11", "Noviembre");
           meses.put("12", "Diciembre");

           HashMap<String, String> diasCompletos = new HashMap();
           diasCompletos.put("1","Domingo");
           diasCompletos.put("2","Lunes");
           diasCompletos.put("3","Martes");
           diasCompletos.put("4","Miercoles");
           diasCompletos.put("5","Jueves");
           diasCompletos.put("6","Viernes");
           diasCompletos.put("7","Sábado");

           DateFormat mesDigito = new SimpleDateFormat("M");
           mesCompleto = meses.get(mesDigito.format(date));

           Calendar diaCalendario = Calendar.getInstance();
           diaCompleto = diasCompletos.get(""+diaCalendario.get(Calendar.DAY_OF_WEEK));
           dia = ""+diaCalendario.get(Calendar.DAY_OF_MONTH);

           anio = ""+diaCalendario.get(Calendar.YEAR);

           this.etiquetaFecha.setText(diaCompleto + ", " +dia+ " de " +
                   mesCompleto + ", " + anio);

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
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FechaYHora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       }
    }
        
    //NO SE POR QUE CREE ESTO AQUI PERO DEFINE LO QUE PERMITE DARLE LAS BARRAS
    // A LA VENTNA PRINCIPAL. SI SE REQUIERE UNA MODIFICACIÓN MEJOR SERÍA QUE 
    // SE HIZIERA AQUI.
    class ScrollPane extends JScrollPane{

        public ScrollPane() {
            //PERMITE QUE SE MUESTREN LAS BARRAS DE SCROLL.
            setAutoscrolls(true);
        }
    }
    
    /**
     * Esta subclase crea un panel que contendra a todos los demas paneles.
   
     */
    class PanelContenedor extends JPanel {
    
    }

    /**
     * Es el contenedor que del panel de fecha, hora, menus y botones. Aqui estan
     * definidas las funciones para arrastrar la ventana. 
     */
    class PanelEncabezado extends JPanel {
        
        //LAS CORRDENADAS PARA EL ARRASTRE
        int pX, pY;

        public PanelEncabezado(JFrame ventanaPrincipal) {
            /*
            PERMITE EL ACOMODO HACIA NORTE, SUR, ESTE Y OESTE PARA QUE APAREZCAN
            ORDENADOS LAS DOS SUB BARRAS. LA DE TITULO Y LA QUE CONTIENE MENUS, 
            BOTONES Y FECHA Y HORA. 
            */
            BorderLayout gl = new BorderLayout();
            setLayout(gl);

            //AÑADE LA ESCUCHA PARA ARRASTRAR LA VENTANA 
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    //GUARDA LA POSICION ACTUAL AL PRESIONAR EL MOUSE.
                    pX = me.getX();
                    pY = me.getY();

                }
               
                
                /*
                PARECE QUE LA SIGUIENTE PARTE NO SE OCUPA PERO SI ME DA PROBLEMAS
                ENTONCES VENDRE A DESCOMENTARLA. 
                
                ---------------------------------------------------------------
                    NO BORRAR
                ---------------------------------------------------------------
                */
                
//                //SUMA O RESTA LA EL MOVIMIENTO DEL MOUSE A LA POSICIÓN ACTUAL 
//                //DE LA VENTANA.
//                public void mouseDragged(MouseEvent me) {
//                    ventanaPrincipal.setLocation(
//                            ventanaPrincipal.getLocation().x + me.getX() - pX,
//                            ventanaPrincipal.getLocation().y + me.getY() - pY);
//                }
                /*
                ---------------------------------------------------------------
                    NO BORRAR HASTA AQUI
                ---------------------------------------------------------------
                */
                
            });
                //SUMA O RESTA LA EL MOVIMIENTO DEL MOUSE A LA POSICIÓN ACTUAL 
                //DE LA VENTANA.
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent me) {

                    ventanaPrincipal.setLocation(
                            ventanaPrincipal.getLocation().x + me.getX() - pX,
                            ventanaPrincipal.getLocation().y + me.getY() - pY);
                }
            });
        }
    }

    /**
     * Es el panel principal que acomoda a todos los demas de manera que 
     * tengamos la posiblidad de arrastrar por los cuatro bordes.
     * 
     * El borde y color que tienen la ventana aqui se definen.
     */
    class PanelSuperContenedor extends JPanel {

        public PanelSuperContenedor() {
            setLayout(new BorderLayout());
            setBorder(new LineBorder(new Color(70,70,70), 5, false));
        }
    }
    
    /*
    LISTA QUE CONTROLA LOS PANELES PARA ACCEDER A LA CLASE menuConstructor.
    */
    
    List<MenuConstructor> menuConstructorLista = new ArrayList<>();

    public List<MenuConstructor> getMenuConstructorLista() {
        return menuConstructorLista;
    }

    public void setMenuConstructorLista(List<MenuConstructor> menuConstructorLista) {
        this.menuConstructorLista = menuConstructorLista;
    }
    
        
    
    /**
     * Agrega el menuConstructor lista que se debe definir dentro del Jpanel
     * para que se agregue al menu. Una vez que se allan agregado los menús
     * es necesario ejecutar generarMenus() para que se creen los menus. 
     * @param itemOMenu El elemento MenuConstructor que se va a agregar. 
     * @see MenuConstructor
     */
    public void addItemOMenu (MenuConstructor itemOMenu){
        this.menuConstructorLista.add(itemOMenu);
    }
    
    
    
    /**
     * Genera los menus para que se muestren en el JFrame.  
     */
    public void generarMenus(){
        
        if (menuConstructorLista.isEmpty()) {
            try {
                throw new ExcepcionPersonalizada(
                        "La lista de elementos del menu esta vacia!"
                      + "\n Parece que olvidaste agregar los elementos.", this, "generarMenus");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //ITINERAMOS SOBRE CADA ELEMENTO QUE AGREGAMOS A LA LISTA menuConstructorLista
        for (MenuConstructor menuConstructor : menuConstructorLista) {
            
            //CREAMOS LOS MENUS
            if (menuConstructor.isMenu()) {
                this.menu.setMenu(menuConstructor.getPadre(),
                        menuConstructor.getNombre(), 
                        menuConstructor.getImagen());
            }
            //CREAMOS LOS ITEMS
            if (menuConstructor.isItem()) {
                
                /*
                SI NO SE DEFINIO UN ACCION POR DEFECTO SUPONEMOS QUE LA ACCION
                QUE SE RESALIZARA SERA EL CAMBIO DE PANEL.
                */
                if (menuConstructor.getAccionDelItem()== null) {
                    this.menu.setItem(menuConstructor.getPadre(), 
                            menuConstructor.getNombre(), 
                            /*
                            SETEAMOS EL PANEL COMO PRINCIPAL. ESTA OPERACIÓN TRAE
                            CONSIGO LA OPCION DEL CAMBIO INTERNAMENTE. 
                            */
                            ()->this.setJPanelActual(menuConstructor), 
                            /*
                            LA FUNCION DENTRO DE LA INSTANCIA DE MENU SABE QUE 
                            HACER CUANDO LA IMAGEN QUE LE PASAMOS ESTA EN NULL.
                            */
                            menuConstructor.getImagen());
                            
                } else {
                    this.menu.setItem(
                            menuConstructor.getPadre(), 
                            menuConstructor.getNombre(), 
                            /*
                            EN ESTE CASO LA ACCIÓN ESTA DEFINIDA Y POR TANTO 
                            LA ASIGAMOS AL ITEM PARA QUE LA EJECUTE DIRECTAMENTE.
                            
                            AQUI YA NO OCUPAMOS EL LAMBDA POR QUE LO HACEMOS 
                            DESDE LA CLASE MenuConstructor.
                            */
                            menuConstructor.getAccionDelItem(), 
                            /*
                            LA FUNCION DENTRO DE LA INSTANCIA DE MENU SABE QUE 
                            HACER CUANDO LA IMAGEN QUE LE PASAMOS ESTA EN NULL.
                            */
                            menuConstructor.getImagen());
                }
            }
        }
        
        /*
        ESTA LINEA ES DE VITAL IMPORTANCIA PARA QUE SE CONSTRUYAN LOS MENUS DENTRO
        DE LA BARRA, SI NO SE PONE NO SE CARGARAN.
         */
        this.menu.generarMenu();
    }
    
    
    
    public class MenuConstructor{
        
        private boolean menu;
        private boolean item;
        private JPanel thisPanel;
        private JDialog thisDialog;
        
        
        private String nombre;
        private String padre;
        private String imagen;
        
        private Runnable accionDelItem;
        private Runnable accionInicializacion;
        private boolean accionInicializacionEjecutada = false;
        private boolean siempreAccionInicializada = false;


        /**
        * SE ENCARGA DE ALMACENAR EL PANEL JUNTO CON LA INFORMACION DEL MENU CONSTRUCTOR
        * PARA ACCEDER ATRAVEZ DE EL EN LA LISTA.
        */
        public MenuConstructor() {
        }

        public JDialog getThisDialog() {
            if (thisDialog == null) {
                try {
                    throw new ExcepcionPersonalizada("No has definido un dialgo.", this, "getThisDialog");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if( thisPanel!=null){
                try {
                    throw new ExcepcionPersonalizada(" No puedes tener un dialgo y un panel en el mismo objeto.", this, "getThisDialog");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return thisDialog;
        }

        public void setDialog(JDialog thisDialog) {
            
            this.thisDialog = thisDialog;
        }
        
        
        
        
        /**
         * Devuelve la acción que ejecutara el item al ser presionado. Si no se
         * define ningúna acción entonces se ejecutara por defecto el cambio
         * de panel en caso de que este definido uno.
         * 
         * @return Retorna la acción que ejecutara un item al ser ejecutado .
         */
        public Runnable getAccionDelItem() {
            return accionDelItem;
        }
        
        /**
         * Define la acción que se quiere setear sobre el item. Si no se define 
         * una acción por defecto se ejecutara el cambio de paneles. 
         * @param accionDelItem La acción que se quiere ejecutar. 
         */
        public void setAccionDelItem(Runnable accionDelItem) {
            if (this.isMenu()) {
                try {
                    throw new ExcepcionPersonalizada(
                            "Parece que"+" \" "+this.getNombre()+" \" esta definido como un menu."
                            +"\n Un menu no debe llevar acciones.", this, "setAccionDelItem");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.accionDelItem = accionDelItem;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        /**
         * Retorna true si el elemento es un Menu. 
         * @return True si es menu. 
         */
        public boolean isMenu() {
            return menu;
        }
        
        /**
         * Define que el MenuConstructor tiene almacenado un Menú.
         */
        public void setMenu() {
            try {
                if (this.item==true) {
                    throw new ExcepcionPersonalizada(
                        "El menuConstructor ya esta definido como un item.",
                        this, "setMenu");
                }
                
                this.menu = true;
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /**
         *Retorna true si es un item.
         * @return  True si es item.
         */
        public boolean isItem() {
            return item;
        }
        
        /*
        * Define que el MeuConstructor tiene almacenado un Item. 
        */
        public void setItem() {
            try {
                if (this.menu==true) {
                    throw new ExcepcionPersonalizada(
                        "El menuConstructor ya esta definido como un menu.",
                        this, "setItem");
                }
                
                this.item = true;
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
        
        /**
         * Retorna el panel al que señala el item. 
         * @return El panel que se tiene almacenado.  
         */
        public JPanel getThisPanel() {
            try {
                if (this.menu==true) {
                    throw new ExcepcionPersonalizada(
                        "Este menyConstructor ya esta definido como un menu y no "
                                + " puedes definir un panel dentro de el.",
                        this, "setThisPanel");
                }else if( this.accionDelItem == null && this.thisPanel==null){
                    throw new ExcepcionPersonalizada( 
                        "No definiste una acción para este Menú costructor y por"
                         + "defecto este tomando la acción de cambiar de Jpanel "
                                + "pero tampoco esta definido un JPanel", this, "getThisPanel"
                    );
                }
                return thisPanel;
            
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        /**
         * Setea el panel al que se quiere llamar por medio de un item.
         * @param thisPanel El panel que se quiere almacenar. 
         */
        public void setPanel(JPanel thisPanel) {
            try {
                if (this.menu==true) {
                    throw new ExcepcionPersonalizada(
                        "Este menuConstructor ya esta definido como un menu y no "
                                + " puedes definir un panel dentro de el.",
                        this, "setThisPanel");
                }
                
                this.thisPanel = thisPanel;
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
      
        /*
         * Retorna el padre de el menu o el item. 
         */
        public String getPadre() {
            return padre;
        }

        /**
         * 
         * Define el padre del el menu o el item. El necesario pasar el 
         * menúCosntructor del JPanel que se quiere señalar como padre del elemento
         * actual.
         * 
         * @param padre El MenuConstructor del padre. 
         */
        public void setPadre(MenuConstructor padre) {
            if (padre.isItem()) {
                try {
                    throw new ExcepcionPersonalizada(
                        "\""+padre.getNombre() + "\" esta declarado como un item y no puede"
                        + " ser padre de ningún elemento. Definelo como menú.", this, "setPadre");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.padre = padre.getNombre();
        }
        
        /**
         * La ruta de la imagen que se quiere agregar como icono al menu. 
         * @return  La ruta para llegar a la imágen.
         */
        public String getImagen() {
            return imagen;
        }
        
        /**
         * Agrega el string para insertar una imagene en el elemento. 
         * @param imagen La ruta de la imagen que se quiere agregar como icono al menu. 
         */
        public void setImagen(String imagen) {
            this.imagen = imagen;
        }
        
        /**
         * Define la acción que se ejecutara para inicializar el panel que es 
         * llamado a la ventana principal. Estas configuraciones solo se pueden
         * correr hasta despues de que la clase Coordinador haya cargado y 
         * seteado todos los paneles, de manera que no se puede hacer en el 
         * constructor del panel. Hay que hacerlo desde aquí y solo una vez. Para
         * eso esta la (@see setAccionInicializacionEjecutada)
         * @param accionInicialización La acción que se quiere ejecutar al inicializar
         * el panel. 
         */
        public void setAccionDeInicializacion(Runnable accionInicialización){
            this.accionInicializacion = accionInicialización;
        }
        
        /**
         * La acción para inicializar el panel. 
         * @return La acción que se ejecutara al inicializar el panel.
         */
        public Runnable getAccionInicializacion() {
            if (accionInicializacion==null) {
                try {
                    throw new ExcepcionPersonalizada(
                            "No definiste el inicializador para el panel : "+ getNombre() ,
                            this,
                            "getAccionInicializacion");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return accionInicializacion;
        }
        
        /**
         * Comprueba que si se ejecuto una sola vez la acción de inicialización
         * del panel. Si no se define siempreAccionInicializadaComo true entonces
         * solo se ejecutara la inicizalización una vez.
         * @return  True si se inicializo el panel y isSiempreAccionInicializada() es
         * false.
         */
        public boolean isAccionInicializacionEjecutada() {
            if (isSiempreAccionInicializada()) {
                return false;
            }
            return accionInicializacionEjecutada;
        }
        
        /**
         * Define si se ha inicializado el panel. 
         * @param accionInicializacionEjecutada True cuando se ejecuto. 
         */
        public void setAccionInicializacionEjecutada(boolean accionInicializacionEjecutada) {
            this.accionInicializacionEjecutada = accionInicializacionEjecutada;
        }

        public boolean isSiempreAccionInicializada() {
            return siempreAccionInicializada;
        }
        
        /**
         * Provoca que la acción de inicialización siempre se ejecute al llamar
         * el panel. Para esto dentro de isAccionInicializacionEjecutada comprobamos
         * que este parametro este en true. Si es así entonces retorna siempre 
         * false de manera que ejecute las acciones de inicialización.
         * @param siempreAccionInicializada True para que sieempre se ejecute la
         * acción de inicialización o false para que solo ejecute una vez. 
         * @see #getAccionInicializacion() 
         */
        public void setSiempreAccionInicializada(boolean siempreAccionInicializada) {
            this.siempreAccionInicializada = siempreAccionInicializada;
        }
        
    }
    
}
